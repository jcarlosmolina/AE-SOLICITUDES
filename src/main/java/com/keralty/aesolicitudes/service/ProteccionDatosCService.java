package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.global.ProductosConstants;
import com.keralty.aesolicitudes.global.ProteccionDatosCConstants;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.ProteccionDatosC;
import com.keralty.aesolicitudes.repository.ProteccionDatosCJpaRepository;
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
public class ProteccionDatosCService extends AbstractService {

    ProteccionDatosCJpaRepository repository;

    ProteccionDatosCService proteccionDatosCSrv;

    ProductosService productosSrv;

    PersonaCService personaCSrv;

    @Inject
    public ProteccionDatosCService(
            ProteccionDatosCService proteccionDatosCSrv,
            ProductosService productosSrv,
            PersonaCService personaCSrv,
            ProteccionDatosCJpaRepository repository) {
        this.proteccionDatosCSrv = proteccionDatosCSrv;
        this.productosSrv = productosSrv;
        this.personaCSrv = personaCSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, ProteccionDatosCConstants.CLASS_NAME);
    }

    private List<ProteccionDatosC> solveProteccionDatosCTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, ProteccionDatosCConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveProteccionDatosCTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, ProteccionDatosCConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class ProteccionDatosC
     *
     * @return Population of class ProteccionDatosC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ProteccionDatosC> get() {
        List<ProteccionDatosC> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    /*
     * Returns the population of class ProteccionDatosC that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class ProteccionDatosC matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ProteccionDatosC> get(QueryRequest queryRequest) {
        return solveProteccionDatosCTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveProteccionDatosCTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveProteccionDatosCTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveProteccionDatosCTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of ProteccionDatosC by ID
     *
     * @param personaCID Identification field personaCID
     *
     * @param productosProducto Identification field productosProducto
     *
     * @param proteccionDatosCCodigo Identification field proteccionDatosCCodigo
     *
     * @return Instance of ProteccionDatosC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ProteccionDatosC getById(Long personaCID, Long productosProducto, Long proteccionDatosCCodigo) {
        return getByOID(new ProteccionDatosCOid(personaCID, productosProducto, proteccionDatosCCodigo));
    }
    
    /*
     * Returns an instance of ProteccionDatosC by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ProteccionDatosC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ProteccionDatosC getByOID(ProteccionDatosCOid oid) {
        Optional<ProteccionDatosC> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of ProteccionDatosC by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ProteccionDatosC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public ProteccionDatosC getByOIDWithHV(ProteccionDatosCOid oid) {
        Optional<ProteccionDatosC> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<ProteccionDatosC> getInstanceByOid(ProteccionDatosCOid oid) {
        return oid != null && oid.getPersonaCID() != null
               ? repository.findById(oid)
               : Optional.empty();
    }

    /*
     * Returns an instance of ProteccionDatosC by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of ProteccionDatosC
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public ProteccionDatosC getByJsonOid(String jsonOid) {
        ProteccionDatosCOid oid = new ProteccionDatosCOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of ProteccionDatosC related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ProteccionDatosC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ProteccionDatosC> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveProteccionDatosCTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of ProteccionDatosC related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ProteccionDatosC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ProteccionDatosC> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of ProteccionDatosC
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of ProteccionDatosC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getProteccionDatosCDynamic(ProteccionDatosCOid oid, String displaySetItems) {
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
    public String getSuppInfo(ProteccionDatosCOid oid, String dsName) {
        ProteccionDatosC instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(ProteccionDatosC instance, String dsName) {
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods



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
            com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = proteccionDatosCSrv.crearTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.CrearRequest request) throws ModelException {
        request.setProteccionDatosCcrearpagrProductoCInstance(productosSrv.getByOIDWithHV(request.getProteccionDatosCcrearpagrProductoC()));
        request.setProteccionDatosCcrearpagrPersonaCInstance(personaCSrv.getByOIDWithHV(request.getProteccionDatosCcrearpagrPersonaC()));
        return proteccionDatosCSrv.crearImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Productos proteccionDatosCcrearpagrProductoC = request.getProteccionDatosCcrearpagrProductoCInstance();
        PersonaC proteccionDatosCcrearpagrPersonaC = request.getProteccionDatosCcrearpagrPersonaCInstance();
        String proteccionDatosCcrearpatrCodRol = request.getProteccionDatosCcrearpatrCodRol();
        Boolean proteccionDatosCcrearpatrInformacionSaludSMS = request.getProteccionDatosCcrearpatrInformacionSaludSMS();
        Boolean proteccionDatosCcrearpatrInformacionSaludEmail = request.getProteccionDatosCcrearpatrInformacionSaludEmail();
        Boolean proteccionDatosCcrearpatrIinformacionSaludCorreo = request.getProteccionDatosCcrearpatrIinformacionSaludCorreo();
        Boolean proteccionDatosCcrearpatrInformacionPublicidadSMS = request.getProteccionDatosCcrearpatrInformacionPublicidadSMS();
        Boolean proteccionDatosCcrearpatrInformacionPublicidadEmai = request.getProteccionDatosCcrearpatrInformacionPublicidadEmai();
        Boolean proteccionDatosCcrearpatrInformacionPublicidadCorr = request.getProteccionDatosCcrearpatrInformacionPublicidadCorr();
        Boolean proteccionDatosCcrearpatrInformacionTerceros = request.getProteccionDatosCcrearpatrInformacionTerceros();
        String proteccionDatosCcrearpatrRol = request.getProteccionDatosCcrearpatrRol();
        Long proteccionDatosCcrearpatrCodigo = request.getProteccionDatosCcrearpatrCodigo();

        request.checkArguments();
        ProteccionDatosC instance = new ProteccionDatosC();
        instance.add2ProductoC(proteccionDatosCcrearpagrProductoC);

        instance.add2PersonaC(proteccionDatosCcrearpagrPersonaC);

        instance.setProteccionDatosCCodRol(proteccionDatosCcrearpatrCodRol);
        instance.setProteccionDatosCInformacionSaludSMS(proteccionDatosCcrearpatrInformacionSaludSMS);
        instance.setProteccionDatosCInformacionSaludEmail(proteccionDatosCcrearpatrInformacionSaludEmail);
        instance.setProteccionDatosCIinformacionSaludCorreo(proteccionDatosCcrearpatrIinformacionSaludCorreo);
        instance.setProteccionDatosCInformacionPublicidadSMS(proteccionDatosCcrearpatrInformacionPublicidadSMS);
        instance.setProteccionDatosCInformacionPublicidadEmail(proteccionDatosCcrearpatrInformacionPublicidadEmai);
        instance.setProteccionDatosCInformacionPublicidadCorreo(proteccionDatosCcrearpatrInformacionPublicidadCorr);
        instance.setProteccionDatosCInformacionTerceros(proteccionDatosCcrearpatrInformacionTerceros);
        instance.setProteccionDatosCRol(proteccionDatosCcrearpatrRol);
        instance.setProteccionDatosCCodigo(proteccionDatosCcrearpatrCodigo);

        instance.setOid(instance.getOid());

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
            com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = proteccionDatosCSrv.eliminarTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.EliminarRequest request) throws ModelException {
        request.setProteccionDatosCeliminarpthisProteccionDatosCInstance(proteccionDatosCSrv.getByOIDWithHV(request.getProteccionDatosCeliminarpthisProteccionDatosC()));
        return proteccionDatosCSrv.eliminarImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ProteccionDatosC proteccionDatosCeliminarpthisProteccionDatosC = request.getProteccionDatosCeliminarpthisProteccionDatosCInstance();

        request.checkArguments();
        ProteccionDatosC instance = proteccionDatosCeliminarpthisProteccionDatosC;


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
            com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.ModificarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = proteccionDatosCSrv.modificarTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.ModificarRequest request) throws ModelException {
        request.setProteccionDatosCmodificarpthisProteccionDatosCInstance(proteccionDatosCSrv.getByOIDWithHV(request.getProteccionDatosCmodificarpthisProteccionDatosC()));
        return proteccionDatosCSrv.modificarImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.ModificarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ProteccionDatosC proteccionDatosCmodificarpthisProteccionDatosC = request.getProteccionDatosCmodificarpthisProteccionDatosCInstance();
        String proteccionDatosCmodificarpCodRol = request.getProteccionDatosCmodificarpCodRol();
        Boolean proteccionDatosCmodificarpInformacionSaludSMS = request.getProteccionDatosCmodificarpInformacionSaludSMS();
        Boolean proteccionDatosCmodificarpInformacionSaludEmail = request.getProteccionDatosCmodificarpInformacionSaludEmail();
        Boolean proteccionDatosCmodificarpIinformacionSaludCorreo = request.getProteccionDatosCmodificarpIinformacionSaludCorreo();
        Boolean proteccionDatosCmodificarpInformacionPublicidadSMS = request.getProteccionDatosCmodificarpInformacionPublicidadSMS();
        Boolean proteccionDatosCmodificarpInformacionPublicidadEmail = request.getProteccionDatosCmodificarpInformacionPublicidadEmail();
        Boolean proteccionDatosCmodificarpInformacionPublicidadCorreo = request.getProteccionDatosCmodificarpInformacionPublicidadCorreo();
        Boolean proteccionDatosCmodificarpInformacionTerceros = request.getProteccionDatosCmodificarpInformacionTerceros();
        String proteccionDatosCmodificarpRol = request.getProteccionDatosCmodificarpRol();

        request.checkArguments();
        ProteccionDatosC instance = proteccionDatosCmodificarpthisProteccionDatosC;
        instance.setProteccionDatosCCodRol(proteccionDatosCmodificarpCodRol);
        instance.setProteccionDatosCInformacionSaludSMS(proteccionDatosCmodificarpInformacionSaludSMS);
        instance.setProteccionDatosCInformacionSaludEmail(proteccionDatosCmodificarpInformacionSaludEmail);
        instance.setProteccionDatosCIinformacionSaludCorreo(proteccionDatosCmodificarpIinformacionSaludCorreo);
        instance.setProteccionDatosCInformacionPublicidadSMS(proteccionDatosCmodificarpInformacionPublicidadSMS);
        instance.setProteccionDatosCInformacionPublicidadEmail(proteccionDatosCmodificarpInformacionPublicidadEmail);
        instance.setProteccionDatosCInformacionPublicidadCorreo(proteccionDatosCmodificarpInformacionPublicidadCorreo);
        instance.setProteccionDatosCInformacionTerceros(proteccionDatosCmodificarpInformacionTerceros);
        instance.setProteccionDatosCRol(proteccionDatosCmodificarpRol);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: TMODIFICAR

    /*
     * Entry point for service TMODIFICAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tMODIFICAR(
            com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.TMODIFICARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = proteccionDatosCSrv.tMODIFICARTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TMODIFICAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tMODIFICARTxn(
            com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.TMODIFICARRequest request) throws ModelException {
        request.setProteccionDatosCTMODIFICARpthisProteccionDatosCInstance(proteccionDatosCSrv.getByOIDWithHV(request.getProteccionDatosCTMODIFICARpthisProteccionDatosC()));
        request.setProteccionDatosCTMODIFICARptpevcProductoCInstance(productosSrv.getByOIDWithHV(request.getProteccionDatosCTMODIFICARptpevcProductoC()));
        return proteccionDatosCSrv.tMODIFICARImplementation(request);
    }

    /*
     * Implements service TMODIFICAR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tMODIFICARImplementation(
            com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.TMODIFICARRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        String proteccionDatosCTMODIFICARptpCodRol = request.getProteccionDatosCTMODIFICARptpCodRol();
        Boolean proteccionDatosCTMODIFICARptpInformacionSaludSMS = request.getProteccionDatosCTMODIFICARptpInformacionSaludSMS();
        Boolean proteccionDatosCTMODIFICARptpInformacionSaludEmail = request.getProteccionDatosCTMODIFICARptpInformacionSaludEmail();
        Boolean proteccionDatosCTMODIFICARptpIinformacionSaludCorreo = request.getProteccionDatosCTMODIFICARptpIinformacionSaludCorreo();
        Boolean proteccionDatosCTMODIFICARptpInformacionPublicidadSMS = request.getProteccionDatosCTMODIFICARptpInformacionPublicidadSMS();
        Boolean proteccionDatosCTMODIFICARptpInformacionPublicidadEmai = request.getProteccionDatosCTMODIFICARptpInformacionPublicidadEmai();
        Boolean proteccionDatosCTMODIFICARptpInformacionPublicidadCorr = request.getProteccionDatosCTMODIFICARptpInformacionPublicidadCorr();
        Boolean proteccionDatosCTMODIFICARptpInformacionTerceros = request.getProteccionDatosCTMODIFICARptpInformacionTerceros();
        String proteccionDatosCTMODIFICARptpRol = request.getProteccionDatosCTMODIFICARptpRol();
        ProteccionDatosC proteccionDatosCTMODIFICARpthisProteccionDatosC = request.getProteccionDatosCTMODIFICARpthisProteccionDatosCInstance();

        request.checkArguments();
        ProteccionDatosC instance = proteccionDatosCTMODIFICARpthisProteccionDatosC;

        com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.ModificarRequest step1Request = new com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.ModificarRequest();
        step1Request.setProteccionDatosCmodificarpthisProteccionDatosCInstance(proteccionDatosCTMODIFICARpthisProteccionDatosC);
        step1Request.setProteccionDatosCmodificarpCodRol(proteccionDatosCTMODIFICARptpCodRol);
        step1Request.setProteccionDatosCmodificarpInformacionSaludSMS(proteccionDatosCTMODIFICARptpInformacionSaludSMS);
        step1Request.setProteccionDatosCmodificarpInformacionSaludEmail(proteccionDatosCTMODIFICARptpInformacionSaludEmail);
        step1Request.setProteccionDatosCmodificarpIinformacionSaludCorreo(proteccionDatosCTMODIFICARptpIinformacionSaludCorreo);
        step1Request.setProteccionDatosCmodificarpInformacionPublicidadSMS(proteccionDatosCTMODIFICARptpInformacionPublicidadSMS);
        step1Request.setProteccionDatosCmodificarpInformacionPublicidadEmail(proteccionDatosCTMODIFICARptpInformacionPublicidadEmai);
        step1Request.setProteccionDatosCmodificarpInformacionPublicidadCorreo(proteccionDatosCTMODIFICARptpInformacionPublicidadCorr);
        step1Request.setProteccionDatosCmodificarpInformacionTerceros(proteccionDatosCTMODIFICARptpInformacionTerceros);
        step1Request.setProteccionDatosCmodificarpRol(proteccionDatosCTMODIFICARptpRol);
        proteccionDatosCSrv.modificarImplementation(step1Request);

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TCREARFROMWS

    /*
     * Entry point for service TCREARFROMWS
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCREARFROMWS(
            com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.TCREARFROMWSRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = proteccionDatosCSrv.tCREARFROMWSTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREARFROMWS
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCREARFROMWSTxn(
            com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.TCREARFROMWSRequest request) throws ModelException {
        request.setProteccionDatosCTCREARFROMWSpPersonaCInstance(personaCSrv.getByOIDWithHV(request.getProteccionDatosCTCREARFROMWSpPersonaC()));
        request.setProteccionDatosCTCREARFROMWSpProteccionDatosCInstance(proteccionDatosCSrv.getByOIDWithHV(request.getProteccionDatosCTCREARFROMWSpProteccionDatosC()));
        return proteccionDatosCSrv.tCREARFROMWSImplementation(request);
    }

    /*
     * Implements service TCREARFROMWS
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCREARFROMWSImplementation(
            com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.TCREARFROMWSRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ProteccionDatosC proteccionDatosCTCREARFROMWSpProteccionDatosC = request.getProteccionDatosCTCREARFROMWSpProteccionDatosCInstance();
        PersonaC proteccionDatosCTCREARFROMWSpPersonaC = request.getProteccionDatosCTCREARFROMWSpPersonaCInstance();

        request.checkArguments();
        ProteccionDatosC instance;

        com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.CrearRequest step1Request = new com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.CrearRequest();
        step1Request.setProteccionDatosCcrearpagrProductoCInstance(proteccionDatosCTCREARFROMWSpProteccionDatosC.getProductoC());
        step1Request.setProteccionDatosCcrearpagrPersonaCInstance(proteccionDatosCTCREARFROMWSpPersonaC);
        step1Request.setProteccionDatosCcrearpatrCodRol(proteccionDatosCTCREARFROMWSpProteccionDatosC.getProteccionDatosCCodRol());
        step1Request.setProteccionDatosCcrearpatrInformacionSaludSMS(proteccionDatosCTCREARFROMWSpProteccionDatosC.getProteccionDatosCInformacionSaludSMS());
        step1Request.setProteccionDatosCcrearpatrInformacionSaludEmail(proteccionDatosCTCREARFROMWSpProteccionDatosC.getProteccionDatosCInformacionSaludEmail());
        step1Request.setProteccionDatosCcrearpatrIinformacionSaludCorreo(proteccionDatosCTCREARFROMWSpProteccionDatosC.getProteccionDatosCIinformacionSaludCorreo());
        step1Request.setProteccionDatosCcrearpatrInformacionPublicidadSMS(proteccionDatosCTCREARFROMWSpProteccionDatosC.getProteccionDatosCInformacionPublicidadSMS());
        step1Request.setProteccionDatosCcrearpatrInformacionPublicidadEmai(proteccionDatosCTCREARFROMWSpProteccionDatosC.getProteccionDatosCInformacionPublicidadEmail());
        step1Request.setProteccionDatosCcrearpatrInformacionPublicidadCorr(proteccionDatosCTCREARFROMWSpProteccionDatosC.getProteccionDatosCInformacionPublicidadCorreo());
        step1Request.setProteccionDatosCcrearpatrInformacionTerceros(proteccionDatosCTCREARFROMWSpProteccionDatosC.getProteccionDatosCInformacionTerceros());
        step1Request.setProteccionDatosCcrearpatrRol(proteccionDatosCTCREARFROMWSpProteccionDatosC.getProteccionDatosCRol());
        step1Request.setProteccionDatosCcrearpatrCodigo(proteccionDatosCTCREARFROMWSpProteccionDatosC.getProteccionDatosCCodigo());
        instance = (ProteccionDatosC) proteccionDatosCSrv.crearImplementation(step1Request).getInstance();

        response.setInstance(getByOID(instance.getOid()));

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
        select.getOrderByPart().addItem(Constants.normalizePath(ProteccionDatosCConstants.CLASS_NAME, ProteccionDatosCConstants.ROLE_NAME_PERSONAC + "." + PersonaCConstants.ATTR_FIELD_PERSONACID, false), true);
        select.getOrderByPart().addItem(Constants.normalizePath(ProteccionDatosCConstants.CLASS_NAME, ProteccionDatosCConstants.ROLE_NAME_PRODUCTOC + "." + ProductosConstants.ATTR_FIELD_PRODUCTOSPRODUCTO, false), true);
        select.getOrderByPart().addItem(Constants.normalizePath(ProteccionDatosCConstants.CLASS_NAME, ProteccionDatosCConstants.ATTR_FIELD_PROTECCIONDATOSCCODIGO, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildProteccionDatosCRelatedInstance(relatedInstanceJsonOid);
        }
        if (ProteccionDatosCConstants.ROLE_NAME_PERSONAC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildProteccionDatosCRelatedInstance4PersonaC(relatedInstanceJsonOid, remainingPath);
        }
        if (ProteccionDatosCConstants.ROLE_NAME_PRODUCTOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildProteccionDatosCRelatedInstance4Productos(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildProteccionDatosCRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new ProteccionDatosC(mapper.readValue(relatedInstanceJsonOid, ProteccionDatosCOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildProteccionDatosCRelatedInstance4PersonaC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new PersonaC(mapper.readValue(relatedInstanceJsonOid, PersonaCOid.class)): PersonaC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildProteccionDatosCRelatedInstance4Productos(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Productos(mapper.readValue(relatedInstanceJsonOid, ProductosOid.class)): Productos.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ProteccionDatosCOid oid = new ProteccionDatosCOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ProteccionDatosCConstants.ROLE_NAME_PERSONAC + "." + PersonaCConstants.ATTR_FIELD_PERSONACID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getPersonaCID(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(ProteccionDatosCConstants.ROLE_NAME_PRODUCTOC + "." + ProductosConstants.ATTR_FIELD_PRODUCTOSPRODUCTO, Constants.Type.INT.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(oid.getProductosProducto(), Constants.Type.INT.getTypeName()));
            sql.addComparison(comparison2);
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("=");
            comparison3.setFirstOperand(new SQLWhereOperandPathAttribute(ProteccionDatosCConstants.ATTR_FIELD_PROTECCIONDATOSCCODIGO, Constants.Type.INT.getTypeName()));
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(oid.getProteccionDatosCCodigo(), Constants.Type.INT.getTypeName()));
            sql.addComparison(comparison3);
        } catch (Exception e) {
            LoggerFactory.getLogger(ProteccionDatosCService.class).error(e.getMessage());
        }
    }

}
