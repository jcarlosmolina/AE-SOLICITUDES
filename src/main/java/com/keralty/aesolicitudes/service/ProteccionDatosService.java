package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.MinCardinalityException;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.ProteccionDatosConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudNovedadOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;
import com.keralty.aesolicitudes.repository.ProteccionDatosJpaRepository;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLWhereComparison;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;
import com.keralty.aesolicitudes.viewmodel.FilterVariableRequest;
import com.keralty.aesolicitudes.viewmodel.InstanceResponseViewModel;
import com.keralty.aesolicitudes.viewmodel.PopulationResponseViewModel;
import com.keralty.aesolicitudes.viewmodel.PreloadResponseViewModel;
import com.keralty.aesolicitudes.viewmodel.QueryRequest;
import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class ProteccionDatosService extends AbstractService {

    ProteccionDatosJpaRepository repository;

    ProteccionDatosService proteccionDatosSrv;

    ProductosService productosSrv;

    SolicitudService solicitudSrv;

    SolicitudNovedadService solicitudNovedadSrv;

    UserFunctions userFunctionsSrv;

    @Inject
    public ProteccionDatosService(
            ProteccionDatosService proteccionDatosSrv,
            ProductosService productosSrv,
            SolicitudService solicitudSrv,
            SolicitudNovedadService solicitudNovedadSrv,
            UserFunctions userFunctionsSrv,
            ProteccionDatosJpaRepository repository) {
        this.proteccionDatosSrv = proteccionDatosSrv;
        this.productosSrv = productosSrv;
        this.solicitudSrv = solicitudSrv;
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.userFunctionsSrv = userFunctionsSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, ProteccionDatosConstants.CLASS_NAME);
    }

    private List<ProteccionDatos> solveProteccionDatosTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, ProteccionDatosConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveProteccionDatosTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, ProteccionDatosConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class ProteccionDatos
     *
     * @return Population of class ProteccionDatos
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ProteccionDatos> get() {
        List<ProteccionDatos> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class ProteccionDatos that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class ProteccionDatos matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ProteccionDatos> get(QueryRequest queryRequest) {
        return solveProteccionDatosTypedQuery(queryRequest);
    }
    
    /*
     * Returns the list of instances that matches certain search criteria
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return List of instances that matches certain search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public QueryResponse getDynamic(QueryRequest queryRequest) {
        if (queryRequest.getDisplaySetName() == null || queryRequest.getDisplaySetName().isEmpty()) {
            return new PopulationResponseViewModel(solveProteccionDatosTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveProteccionDatosTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel();
        }
    }

    /*
     * Returns the population of a class with a certain structure
     *
     * @param relatedInstanceJsonOid Json Oid of the related instance
     *
     * @param relatedInstancePath Path to the related instance
     *
     * @param displaySetItems DisplaySet items for each returned instance
     *
     * @return List of instances
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public PopulationResponseViewModel getByRelatedDynamic(String relatedInstanceJsonOid, String relatedInstancePath, String displaySetItems) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstanceJsonOid))));
        return new PopulationResponseViewModel(solveProteccionDatosTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of ProteccionDatos by ID
     *
     * @param proteccionDatosIdentificador Identification field proteccionDatosIdentificador
     *
     * @return Instance of ProteccionDatos
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ProteccionDatos getById(Long proteccionDatosIdentificador) {
        return getByOID(new ProteccionDatosOid(proteccionDatosIdentificador));
    }
    
    /*
     * Returns an instance of ProteccionDatos by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ProteccionDatos
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ProteccionDatos getByOID(ProteccionDatosOid oid) {
        Optional<ProteccionDatos> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of ProteccionDatos by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ProteccionDatos
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public ProteccionDatos getByOIDWithHV(ProteccionDatosOid oid) {
        Optional<ProteccionDatos> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<ProteccionDatos> getInstanceByOid(ProteccionDatosOid oid) {
        return oid != null && oid.getProteccionDatosIdentificador() != null
               ? repository.findById(oid.getProteccionDatosIdentificador())
               : Optional.empty();
    }

    /*
     * Returns an instance of ProteccionDatos by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of ProteccionDatos
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public ProteccionDatos getByJsonOid(String jsonOid) {
        ProteccionDatosOid oid = new ProteccionDatosOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of ProteccionDatos related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ProteccionDatos
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ProteccionDatos> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveProteccionDatosTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of ProteccionDatos related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ProteccionDatos
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ProteccionDatos> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of ProteccionDatos
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of ProteccionDatos
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getProteccionDatosDynamic(ProteccionDatosOid oid, String displaySetItems) {
        return new InstanceResponseViewModel(getByOIDWithHV(oid), displaySetItems);
    }

    /*
     * Returns the supplementary info for a given instance
     *
     * @param oid Instance OID
     *
     * @param dsName DisplaySet name
     *
     * @return Supplementary info for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String getSuppInfo(ProteccionDatosOid oid, String dsName) {
        ProteccionDatos instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(ProteccionDatos instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods


    /*
     * Solves the query needed for PIUProteccionDatosNull
     *
     * @param queryRequest Query request
     * @return List of viewmodels for ProteccionDatos using displayset DSProteccionDatosNull that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aesolicitudes.viewmodel.protecciondatos.ds.DSProteccionDatosNull> piuPIUProteccionDatosNull(QueryRequest queryRequest) {
        return solveProteccionDatosTypedQuery(queryRequest).stream()
                .map(com.keralty.aesolicitudes.viewmodel.protecciondatos.ds.DSProteccionDatosNull::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUProteccionDatosNull
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUProteccionDatosNull
     */
    public int getCount4PIUProteccionDatosNull(QueryRequest queryRequest) {
        return solveProteccionDatosTypedQuery(queryRequest).size();
    }

    // Service: crear

    /*
     * Entry point for service crear
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse crear(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = proteccionDatosSrv.crearTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service crear
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse crearTxn(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.CrearRequest request) {
        request.setProteccionDatoscrearpagrProductoTInstance(productosSrv.getByOIDWithHV(request.getProteccionDatoscrearpagrProductoT()));
        request.setProteccionDatoscrearpagrSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getProteccionDatoscrearpagrSolicitud()));
        return proteccionDatosSrv.crearImplementation(request);
    }

    /*
     * Implements service crear
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse crearImplementation(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        Productos proteccionDatoscrearpagrProductoT = request.getProteccionDatoscrearpagrProductoTInstance();
        Solicitud proteccionDatoscrearpagrSolicitud = request.getProteccionDatoscrearpagrSolicitudInstance();
        String proteccionDatoscrearpatrRol = request.getProteccionDatoscrearpatrRol();
        Boolean proteccionDatoscrearpatrSaludSMS = request.getProteccionDatoscrearpatrSaludSMS();
        Boolean proteccionDatoscrearpatrSaludEmail = request.getProteccionDatoscrearpatrSaludEmail();
        Boolean proteccionDatoscrearpatrSaludCorreo = request.getProteccionDatoscrearpatrSaludCorreo();
        Boolean proteccionDatoscrearpatrPublicidadSMS = request.getProteccionDatoscrearpatrPublicidadSMS();
        Boolean proteccionDatoscrearpatrPublicidadEmail = request.getProteccionDatoscrearpatrPublicidadEmail();
        Boolean proteccionDatoscrearpatrPublicidadCorreo = request.getProteccionDatoscrearpatrPublicidadCorreo();
        Boolean proteccionDatoscrearpatrInfoTerceros = request.getProteccionDatoscrearpatrInfoTerceros();
        ProteccionDatos instance = new ProteccionDatos();
        if (proteccionDatoscrearpagrProductoT != null && !proteccionDatoscrearpagrProductoT.isNull()) {
            instance.add2ProductoT(proteccionDatoscrearpagrProductoT);
        }

        if (proteccionDatoscrearpagrSolicitud != null && !proteccionDatoscrearpagrSolicitud.isNull()) {
            proteccionDatoscrearpagrSolicitud.add2ProteccionDatos(instance);
            instance.add2Solicitud(proteccionDatoscrearpagrSolicitud);
        }

        instance.setProteccionDatosIdentificador(Long.valueOf(0));
        instance.setProteccionDatosRol(proteccionDatoscrearpatrRol);
        instance.setProteccionDatosSaludSMS(proteccionDatoscrearpatrSaludSMS);
        instance.setProteccionDatosSaludEmail(proteccionDatoscrearpatrSaludEmail);
        instance.setProteccionDatosSaludCorreo(proteccionDatoscrearpatrSaludCorreo);
        instance.setProteccionDatosPublicidadSMS(proteccionDatoscrearpatrPublicidadSMS);
        instance.setProteccionDatosPublicidadEmail(proteccionDatoscrearpatrPublicidadEmail);
        instance.setProteccionDatosPublicidadCorreo(proteccionDatoscrearpatrPublicidadCorreo);
        instance.setProteccionDatosInfoTerceros(proteccionDatoscrearpatrInfoTerceros);

        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: eliminar

    /*
     * Entry point for service eliminar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse eliminar(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = proteccionDatosSrv.eliminarTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service eliminar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse eliminarTxn(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.EliminarRequest request) throws ModelException {
        request.setProteccionDatoseliminarpthisProteccionDatosInstance(proteccionDatosSrv.getByOIDWithHV(request.getProteccionDatoseliminarpthisProteccionDatos()));
        return proteccionDatosSrv.eliminarImplementation(request);
    }

    /*
     * Implements service eliminar
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse eliminarImplementation(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ProteccionDatos proteccionDatoseliminarpthisProteccionDatos = request.getProteccionDatoseliminarpthisProteccionDatosInstance();

        request.checkArguments();
        ProteccionDatos instance = proteccionDatoseliminarpthisProteccionDatos;
        if(proteccionDatoseliminarpthisProteccionDatos.getSolicitudNovedad() != null && !proteccionDatoseliminarpthisProteccionDatos.getSolicitudNovedad().isNull()) {
            throw new MinCardinalityException(ProteccionDatosConstants.CLASS_ALIAS, ProteccionDatosConstants.ROLE_ALIAS_SOLICITUDNOVEDAD);
        }


        repository.delete(instance);
        
        response.setInstance(instance);

        return response;
    }

    // Service: modificar

    /*
     * Entry point for service modificar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse modificar(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.ModificarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = proteccionDatosSrv.modificarTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service modificar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse modificarTxn(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.ModificarRequest request) throws ModelException {
        request.setProteccionDatosmodificarpthisProteccionDatosInstance(proteccionDatosSrv.getByOIDWithHV(request.getProteccionDatosmodificarpthisProteccionDatos()));
        return proteccionDatosSrv.modificarImplementation(request);
    }

    /*
     * Implements service modificar
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse modificarImplementation(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.ModificarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ProteccionDatos proteccionDatosmodificarpthisProteccionDatos = request.getProteccionDatosmodificarpthisProteccionDatosInstance();
        String proteccionDatosmodificarpRol = request.getProteccionDatosmodificarpRol();
        Boolean proteccionDatosmodificarpSaludSMS = request.getProteccionDatosmodificarpSaludSMS();
        Boolean proteccionDatosmodificarpSaludEmail = request.getProteccionDatosmodificarpSaludEmail();
        Boolean proteccionDatosmodificarpSaludCorreo = request.getProteccionDatosmodificarpSaludCorreo();
        Boolean proteccionDatosmodificarpPublicidadSMS = request.getProteccionDatosmodificarpPublicidadSMS();
        Boolean proteccionDatosmodificarpPublicidadEmail = request.getProteccionDatosmodificarpPublicidadEmail();
        Boolean proteccionDatosmodificarpPublicidadCorreo = request.getProteccionDatosmodificarpPublicidadCorreo();
        Boolean proteccionDatosmodificarpInfoTerceros = request.getProteccionDatosmodificarpInfoTerceros();

        request.checkArguments();
        ProteccionDatos instance = proteccionDatosmodificarpthisProteccionDatos;
        instance.setProteccionDatosRol(proteccionDatosmodificarpRol);
        instance.setProteccionDatosSaludSMS(proteccionDatosmodificarpSaludSMS);
        instance.setProteccionDatosSaludEmail(proteccionDatosmodificarpSaludEmail);
        instance.setProteccionDatosSaludCorreo(proteccionDatosmodificarpSaludCorreo);
        instance.setProteccionDatosPublicidadSMS(proteccionDatosmodificarpPublicidadSMS);
        instance.setProteccionDatosPublicidadEmail(proteccionDatosmodificarpPublicidadEmail);
        instance.setProteccionDatosPublicidadCorreo(proteccionDatosmodificarpPublicidadCorreo);
        instance.setProteccionDatosInfoTerceros(proteccionDatosmodificarpInfoTerceros);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsProductoProteccionDatos

    /*
     * Entry point for service InsProductoProteccionDatos
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insProductoProteccionDatos(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.InsProductoProteccionDatosRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = proteccionDatosSrv.insProductoProteccionDatosTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsProductoProteccionDatos
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insProductoProteccionDatosTxn(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.InsProductoProteccionDatosRequest request) throws ModelException {
        request.setProteccionDatosInsProductoProteccionDatospthisProteccionDatosInstance(proteccionDatosSrv.getByOIDWithHV(request.getProteccionDatosInsProductoProteccionDatospthisProteccionDatos()));
        request.setProteccionDatosInsProductoProteccionDatospevcProductosInstance(productosSrv.getByOIDWithHV(request.getProteccionDatosInsProductoProteccionDatospevcProductos()));
        return proteccionDatosSrv.insProductoProteccionDatosImplementation(request, true);
    }

    /*
     * Implements service InsProductoProteccionDatos
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insProductoProteccionDatosImplementation(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.InsProductoProteccionDatosRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ProteccionDatos proteccionDatosInsProductoProteccionDatospthisProteccionDatos = request.getProteccionDatosInsProductoProteccionDatospthisProteccionDatosInstance();
        Productos proteccionDatosInsProductoProteccionDatospevcProductos = request.getProteccionDatosInsProductoProteccionDatospevcProductosInstance();

        request.checkArguments();
        ProteccionDatos instance = proteccionDatosInsProductoProteccionDatospthisProteccionDatos;

        instance.add2ProductoT(proteccionDatosInsProductoProteccionDatospevcProductos);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.productos.siu.InsProductoProteccionDatosRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.productos.siu.InsProductoProteccionDatosRequest();
            relatedRequest.setProductosInsProductoProteccionDatospthisProductoInstance(proteccionDatosInsProductoProteccionDatospevcProductos);
            relatedRequest.setProductosInsProductoProteccionDatospevcProteccionDatosInstance(proteccionDatosInsProductoProteccionDatospthisProteccionDatos);
            productosSrv.insProductoProteccionDatosImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelProductoProteccionDatos

    /*
     * Entry point for service DelProductoProteccionDatos
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delProductoProteccionDatos(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.DelProductoProteccionDatosRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = proteccionDatosSrv.delProductoProteccionDatosTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelProductoProteccionDatos
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delProductoProteccionDatosTxn(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.DelProductoProteccionDatosRequest request) throws ModelException {
        request.setProteccionDatosDelProductoProteccionDatospthisProteccionDatosInstance(proteccionDatosSrv.getByOIDWithHV(request.getProteccionDatosDelProductoProteccionDatospthisProteccionDatos()));
        request.setProteccionDatosDelProductoProteccionDatospevcProductosInstance(productosSrv.getByOIDWithHV(request.getProteccionDatosDelProductoProteccionDatospevcProductos()));
        return proteccionDatosSrv.delProductoProteccionDatosImplementation(request, true);
    }

    /*
     * Implements service DelProductoProteccionDatos
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delProductoProteccionDatosImplementation(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.DelProductoProteccionDatosRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ProteccionDatos proteccionDatosDelProductoProteccionDatospthisProteccionDatos = request.getProteccionDatosDelProductoProteccionDatospthisProteccionDatosInstance();
        Productos proteccionDatosDelProductoProteccionDatospevcProductos = request.getProteccionDatosDelProductoProteccionDatospevcProductosInstance();

        request.checkArguments();
        ProteccionDatos instance = proteccionDatosDelProductoProteccionDatospthisProteccionDatos;

        instance.add2ProductoT(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.productos.siu.DelProductoProteccionDatosRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.productos.siu.DelProductoProteccionDatosRequest();
            relatedRequest.setProductosDelProductoProteccionDatospthisProductoInstance(proteccionDatosDelProductoProteccionDatospevcProductos);
            relatedRequest.setProductosDelProductoProteccionDatospevcProteccionDatosInstance(proteccionDatosDelProductoProteccionDatospthisProteccionDatos);
            productosSrv.delProductoProteccionDatosImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsSolicitudProteccionDatos

    /*
     * Entry point for service InsSolicitudProteccionDatos
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insSolicitudProteccionDatos(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.InsSolicitudProteccionDatosRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = proteccionDatosSrv.insSolicitudProteccionDatosTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsSolicitudProteccionDatos
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insSolicitudProteccionDatosTxn(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.InsSolicitudProteccionDatosRequest request) throws ModelException {
        request.setProteccionDatosInsSolicitudProteccionDatospthisProteccionDatosInstance(proteccionDatosSrv.getByOIDWithHV(request.getProteccionDatosInsSolicitudProteccionDatospthisProteccionDatos()));
        request.setProteccionDatosInsSolicitudProteccionDatospevcSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getProteccionDatosInsSolicitudProteccionDatospevcSolicitud()));
        return proteccionDatosSrv.insSolicitudProteccionDatosImplementation(request, true);
    }

    /*
     * Implements service InsSolicitudProteccionDatos
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insSolicitudProteccionDatosImplementation(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.InsSolicitudProteccionDatosRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ProteccionDatos proteccionDatosInsSolicitudProteccionDatospthisProteccionDatos = request.getProteccionDatosInsSolicitudProteccionDatospthisProteccionDatosInstance();
        Solicitud proteccionDatosInsSolicitudProteccionDatospevcSolicitud = request.getProteccionDatosInsSolicitudProteccionDatospevcSolicitudInstance();

        request.checkArguments();
        ProteccionDatos instance = proteccionDatosInsSolicitudProteccionDatospthisProteccionDatos;

        instance.add2Solicitud(proteccionDatosInsSolicitudProteccionDatospevcSolicitud);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.solicitud.siu.InsSolicitudProteccionDatosRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.solicitud.siu.InsSolicitudProteccionDatosRequest();
            relatedRequest.setSolicitudInsSolicitudProteccionDatospthisSolicitudInstance(proteccionDatosInsSolicitudProteccionDatospevcSolicitud);
            relatedRequest.setSolicitudInsSolicitudProteccionDatospevcProteccionDatosInstance(proteccionDatosInsSolicitudProteccionDatospthisProteccionDatos);
            solicitudSrv.insSolicitudProteccionDatosImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelSolicitudProteccionDatos

    /*
     * Entry point for service DelSolicitudProteccionDatos
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delSolicitudProteccionDatos(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.DelSolicitudProteccionDatosRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = proteccionDatosSrv.delSolicitudProteccionDatosTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelSolicitudProteccionDatos
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delSolicitudProteccionDatosTxn(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.DelSolicitudProteccionDatosRequest request) throws ModelException {
        request.setProteccionDatosDelSolicitudProteccionDatospthisProteccionDatosInstance(proteccionDatosSrv.getByOIDWithHV(request.getProteccionDatosDelSolicitudProteccionDatospthisProteccionDatos()));
        request.setProteccionDatosDelSolicitudProteccionDatospevcSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getProteccionDatosDelSolicitudProteccionDatospevcSolicitud()));
        return proteccionDatosSrv.delSolicitudProteccionDatosImplementation(request, true);
    }

    /*
     * Implements service DelSolicitudProteccionDatos
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delSolicitudProteccionDatosImplementation(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.DelSolicitudProteccionDatosRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ProteccionDatos proteccionDatosDelSolicitudProteccionDatospthisProteccionDatos = request.getProteccionDatosDelSolicitudProteccionDatospthisProteccionDatosInstance();
        Solicitud proteccionDatosDelSolicitudProteccionDatospevcSolicitud = request.getProteccionDatosDelSolicitudProteccionDatospevcSolicitudInstance();

        request.checkArguments();
        ProteccionDatos instance = proteccionDatosDelSolicitudProteccionDatospthisProteccionDatos;

        instance.add2Solicitud(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.solicitud.siu.DelSolicitudProteccionDatosRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.solicitud.siu.DelSolicitudProteccionDatosRequest();
            relatedRequest.setSolicitudDelSolicitudProteccionDatospthisSolicitudInstance(proteccionDatosDelSolicitudProteccionDatospevcSolicitud);
            relatedRequest.setSolicitudDelSolicitudProteccionDatospevcProteccionDatosInstance(proteccionDatosDelSolicitudProteccionDatospthisProteccionDatos);
            solicitudSrv.delSolicitudProteccionDatosImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: TCREARPROTECCIONDATOSNA

    /*
     * Entry point for service TCREARPROTECCIONDATOSNA
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSNAResponse tCREARPROTECCIONDATOSNA(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSNARequest request) {
        com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSNAResponse response = new com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSNAResponse();
        try {
            response = proteccionDatosSrv.tCREARPROTECCIONDATOSNATxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREARPROTECCIONDATOSNA
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSNAResponse tCREARPROTECCIONDATOSNATxn(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSNARequest request) {
        return proteccionDatosSrv.tCREARPROTECCIONDATOSNAImplementation(request);
    }

    /*
     * Implements service TCREARPROTECCIONDATOSNA
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSNAResponse tCREARPROTECCIONDATOSNAImplementation(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSNARequest request) {
        com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSNAResponse response = new com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSNAResponse();
        ProteccionDatos instance;

        if (request == null) {
        	throw new IllegalArgumentException("request cannot be null in TCREARPROTECCIONDATOSNAImplementation");
        }

        com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.CrearRequest step1Request = new com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.CrearRequest();
        step1Request.setProteccionDatoscrearpagrProductoTInstance(null);
        step1Request.setProteccionDatoscrearpagrSolicitudInstance(null);
        step1Request.setProteccionDatoscrearpatrRol("01");
        step1Request.setProteccionDatoscrearpatrSaludSMS(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrSaludEmail(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrSaludCorreo(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrPublicidadSMS(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrPublicidadEmail(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrPublicidadCorreo(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrInfoTerceros(Boolean.TRUE);
        instance = (ProteccionDatos) proteccionDatosSrv.crearImplementation(step1Request).getInstance();

        response.setInstance(getByOID(instance.getOid()));

        // Value expressions for outgoing argument 'proteccionDatosTCREARPROTECCIONDATOSNApsThisPD'
        // DEFAULT  : THIS
        response.setProteccionDatosTCREARPROTECCIONDATOSNApsThisPDInstance(instance);


        return response;
    }

    // Service: TCREARPROTECCIONDATOSINC

    /*
     * Entry point for service TCREARPROTECCIONDATOSINC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSINCResponse tCREARPROTECCIONDATOSINC(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSINCRequest request) {
        com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSINCResponse response = new com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSINCResponse();
        try {
            response = proteccionDatosSrv.tCREARPROTECCIONDATOSINCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREARPROTECCIONDATOSINC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSINCResponse tCREARPROTECCIONDATOSINCTxn(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSINCRequest request) {
        return proteccionDatosSrv.tCREARPROTECCIONDATOSINCImplementation(request);
    }

    /*
     * Implements service TCREARPROTECCIONDATOSINC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSINCResponse tCREARPROTECCIONDATOSINCImplementation(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSINCRequest request) {
        com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSINCResponse response = new com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSINCResponse();
        ProteccionDatos instance;

        if (request == null) {
        	throw new IllegalArgumentException("request cannot be null in TCREARPROTECCIONDATOSINCImplementation");
        }

        com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.CrearRequest step1Request = new com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.CrearRequest();
        step1Request.setProteccionDatoscrearpagrProductoTInstance(null);
        step1Request.setProteccionDatoscrearpagrSolicitudInstance(null);
        step1Request.setProteccionDatoscrearpatrRol("01");
        step1Request.setProteccionDatoscrearpatrSaludSMS(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrSaludEmail(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrSaludCorreo(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrPublicidadSMS(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrPublicidadEmail(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrPublicidadCorreo(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrInfoTerceros(Boolean.TRUE);
        instance = (ProteccionDatos) proteccionDatosSrv.crearImplementation(step1Request).getInstance();

        response.setInstance(getByOID(instance.getOid()));

        // Value expressions for outgoing argument 'proteccionDatosTCREARPROTECCIONDATOSINCpsThisPD'
        // DEFAULT  : THIS
        response.setProteccionDatosTCREARPROTECCIONDATOSINCpsThisPDInstance(instance);


        return response;
    }

    // Service: TCREARSOLNOVEDAD

    /*
     * Entry point for service TCREARSOLNOVEDAD
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADResponse tCREARSOLNOVEDAD(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADRequest request) {
        com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADResponse response = new com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADResponse();
        try {
            response = proteccionDatosSrv.tCREARSOLNOVEDADTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREARSOLNOVEDAD
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADResponse tCREARSOLNOVEDADTxn(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADRequest request) {
        return proteccionDatosSrv.tCREARSOLNOVEDADImplementation(request);
    }

    /*
     * Implements service TCREARSOLNOVEDAD
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADResponse tCREARSOLNOVEDADImplementation(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADRequest request) {
        com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADResponse response = new com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADResponse();
        ProteccionDatos instance;

        com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.CrearRequest step1Request = new com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.CrearRequest();
        step1Request.setProteccionDatoscrearpagrProductoTInstance(null);
        step1Request.setProteccionDatoscrearpagrSolicitudInstance(null);
        step1Request.setProteccionDatoscrearpatrRol("01");
        step1Request.setProteccionDatoscrearpatrSaludSMS(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrSaludEmail(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrSaludCorreo(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrPublicidadSMS(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrPublicidadEmail(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrPublicidadCorreo(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrInfoTerceros(Boolean.TRUE);
        instance = (ProteccionDatos) proteccionDatosSrv.crearImplementation(step1Request).getInstance();

        response.setInstance(getByOID(instance.getOid()));

        // Value expressions for outgoing argument 'proteccionDatosTCREARSOLNOVEDADpsThisPD'
        // DEFAULT  : THIS
        response.setProteccionDatosTCREARSOLNOVEDADpsThisPDInstance(instance);


        return response;
    }

    // Service: TCREARSOLNOVEDADEXCEPCION

    /*
     * Entry point for service TCREARSOLNOVEDADEXCEPCION
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADEXCEPCIONResponse tCREARSOLNOVEDADEXCEPCION(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADEXCEPCIONRequest request) {
        com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADEXCEPCIONResponse response = new com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADEXCEPCIONResponse();
        try {
            response = proteccionDatosSrv.tCREARSOLNOVEDADEXCEPCIONTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREARSOLNOVEDADEXCEPCION
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADEXCEPCIONResponse tCREARSOLNOVEDADEXCEPCIONTxn(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADEXCEPCIONRequest request) {
        return proteccionDatosSrv.tCREARSOLNOVEDADEXCEPCIONImplementation(request);
    }

    /*
     * Implements service TCREARSOLNOVEDADEXCEPCION
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADEXCEPCIONResponse tCREARSOLNOVEDADEXCEPCIONImplementation(
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADEXCEPCIONRequest request) {
        com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADEXCEPCIONResponse response = new com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADEXCEPCIONResponse();
        ProteccionDatos instance;

        com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.CrearRequest step1Request = new com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.CrearRequest();
        step1Request.setProteccionDatoscrearpagrProductoTInstance(null);
        step1Request.setProteccionDatoscrearpagrSolicitudInstance(null);
        step1Request.setProteccionDatoscrearpatrRol("01");
        step1Request.setProteccionDatoscrearpatrSaludSMS(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrSaludEmail(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrSaludCorreo(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrPublicidadSMS(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrPublicidadEmail(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrPublicidadCorreo(Boolean.TRUE);
        step1Request.setProteccionDatoscrearpatrInfoTerceros(Boolean.TRUE);
        instance = (ProteccionDatos) proteccionDatosSrv.crearImplementation(step1Request).getInstance();

        response.setInstance(getByOID(instance.getOid()));

        // Value expressions for outgoing argument 'proteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPD'
        // DEFAULT  : THIS
        response.setProteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPDInstance(instance);


        return response;
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(ProteccionDatosConstants.CLASS_NAME, ProteccionDatosConstants.ATTR_FIELD_PROTECCIONDATOSIDENTIFICADOR, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildProteccionDatosRelatedInstance(relatedInstanceJsonOid);
        }
        if (ProteccionDatosConstants.ROLE_NAME_SOLICITUDNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildProteccionDatosRelatedInstance4SolicitudNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (ProteccionDatosConstants.ROLE_NAME_PRODUCTOT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildProteccionDatosRelatedInstance4Productos(relatedInstanceJsonOid, remainingPath);
        }
        if (ProteccionDatosConstants.ROLE_NAME_SOLICITUD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildProteccionDatosRelatedInstance4Solicitud(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildProteccionDatosRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new ProteccionDatos(mapper.readValue(relatedInstanceJsonOid, ProteccionDatosOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildProteccionDatosRelatedInstance4SolicitudNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class)): SolicitudNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildProteccionDatosRelatedInstance4Productos(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Productos(mapper.readValue(relatedInstanceJsonOid, ProductosOid.class)): Productos.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildProteccionDatosRelatedInstance4Solicitud(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Solicitud(mapper.readValue(relatedInstanceJsonOid, SolicitudOid.class)): Solicitud.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ProteccionDatosOid oid = new ProteccionDatosOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ProteccionDatosConstants.ATTR_FIELD_PROTECCIONDATOSIDENTIFICADOR, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getProteccionDatosIdentificador(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(ProteccionDatosService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
