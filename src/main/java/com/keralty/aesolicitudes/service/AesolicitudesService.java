package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.MinCardinalityException;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.exception.PreconditionException;
import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.AesolicitudesConstants;
import com.keralty.aesolicitudes.global.AsesorConstants;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.FuncionarioConstants;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.global.STDFunctions;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.Asesor;
import com.keralty.aesolicitudes.persistence.EstadoContrato;
import com.keralty.aesolicitudes.persistence.Funcionario;
import com.keralty.aesolicitudes.persistence.GrupoAsociado;
import com.keralty.aesolicitudes.persistence.oid.AesolicitudesOid;
import com.keralty.aesolicitudes.persistence.oid.AsesorOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoContratoOid;
import com.keralty.aesolicitudes.persistence.oid.GrupoAsociadoOid;
import com.keralty.aesolicitudes.persistence.oid.PlanesOid;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.oid.ProrrateoOid;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.oid.TipoFacturaOid;
import com.keralty.aesolicitudes.persistence.Planes;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.Prorrateo;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoFactura;
import com.keralty.aesolicitudes.repository.AesolicitudesJpaRepository;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLWhereComparison;
import com.keralty.aesolicitudes.sqlutils.SQLWhereConjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereDisjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathInstance;
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
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class AesolicitudesService extends AbstractService {

    AesolicitudesJpaRepository repository;

    AesolicitudesService aesolicitudesSrv;

    EstadoContratoService estadoContratoSrv;

    ProductosService productosSrv;

    PlanesService planesSrv;

    ProteccionDatosService proteccionDatosSrv;

    GrupoAsociadoService grupoAsociadoSrv;

    ProrrateoService prorrateoSrv;

    TipoFacturaService tipoFacturaSrv;

    SolicitudService solicitudSrv;

    UserFunctions userFunctionsSrv;

    @Inject
    public AesolicitudesService(
            AesolicitudesService aesolicitudesSrv,
            EstadoContratoService estadoContratoSrv,
            ProductosService productosSrv,
            PlanesService planesSrv,
            ProteccionDatosService proteccionDatosSrv,
            GrupoAsociadoService grupoAsociadoSrv,
            ProrrateoService prorrateoSrv,
            TipoFacturaService tipoFacturaSrv,
            SolicitudService solicitudSrv,
            UserFunctions userFunctionsSrv,
            AesolicitudesJpaRepository repository) {
        this.aesolicitudesSrv = aesolicitudesSrv;
        this.estadoContratoSrv = estadoContratoSrv;
        this.productosSrv = productosSrv;
        this.planesSrv = planesSrv;
        this.proteccionDatosSrv = proteccionDatosSrv;
        this.grupoAsociadoSrv = grupoAsociadoSrv;
        this.prorrateoSrv = prorrateoSrv;
        this.tipoFacturaSrv = tipoFacturaSrv;
        this.solicitudSrv = solicitudSrv;
        this.userFunctionsSrv = userFunctionsSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, AesolicitudesConstants.CLASS_NAME);
    }

    private List<Aesolicitudes> solveAesolicitudesTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, AesolicitudesConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveAesolicitudesTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, AesolicitudesConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class Aesolicitudes
     *
     * @return Population of class Aesolicitudes
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Aesolicitudes> get() {
        List<Aesolicitudes> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class Aesolicitudes that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class Aesolicitudes matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Aesolicitudes> get(QueryRequest queryRequest) {
        return solveAesolicitudesTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveAesolicitudesTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveAesolicitudesTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveAesolicitudesTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of Aesolicitudes by ID
     *
     * @param aesolicitudesidsolicitud Identification field aesolicitudesidsolicitud
     *
     * @return Instance of Aesolicitudes
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Aesolicitudes getById(Long aesolicitudesidsolicitud) {
        return getByOID(new AesolicitudesOid(aesolicitudesidsolicitud));
    }
    
    /*
     * Returns an instance of Aesolicitudes by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Aesolicitudes
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Aesolicitudes getByOID(AesolicitudesOid oid) {
        Optional<Aesolicitudes> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Aesolicitudes by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Aesolicitudes
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Aesolicitudes getByOIDWithHV(AesolicitudesOid oid) {
        Optional<Aesolicitudes> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Aesolicitudes> getInstanceByOid(AesolicitudesOid oid) {
        return oid != null && oid.getAesolicitudesidsolicitud() != null
               ? repository.findById(oid.getAesolicitudesidsolicitud())
               : Optional.empty();
    }

    /*
     * Returns an instance of Aesolicitudes by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Aesolicitudes
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Aesolicitudes getByJsonOid(String jsonOid) {
        AesolicitudesOid oid = new AesolicitudesOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of Aesolicitudes related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Aesolicitudes
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Aesolicitudes> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveAesolicitudesTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of Aesolicitudes related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Aesolicitudes
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Aesolicitudes> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of Aesolicitudes
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of Aesolicitudes
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getAesolicitudesDynamic(AesolicitudesOid oid, String displaySetItems) {
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
    public String getSuppInfo(AesolicitudesOid oid, String dsName) {
        Aesolicitudes instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(Aesolicitudes instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods


    /*
     * Solves the query needed for PIUAesolicitudesObs
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Aesolicitudes using displayset DSAesolicitudes that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aesolicitudes.viewmodel.aesolicitudes.ds.DSAesolicitudes> piuPIUAesolicitudesObs(QueryRequest queryRequest) {
        return solveAesolicitudesTypedQuery(queryRequest).stream()
                .map(com.keralty.aesolicitudes.viewmodel.aesolicitudes.ds.DSAesolicitudes::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUAesolicitudesObs
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUAesolicitudesObs
     */
    public int getCount4PIUAesolicitudesObs(QueryRequest queryRequest) {
        return solveAesolicitudesTypedQuery(queryRequest).size();
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
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = aesolicitudesSrv.crearTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.CrearRequest request) throws ModelException {
        request.setAesolicitudescrearpagrESTADOSOLICITUDInstance(estadoContratoSrv.getByOIDWithHV(request.getAesolicitudescrearpagrESTADOSOLICITUD()));
        request.setAesolicitudescrearpagrProductoTInstance(productosSrv.getByOIDWithHV(request.getAesolicitudescrearpagrProductoT()));
        request.setAesolicitudescrearpagrPlanTInstance(planesSrv.getByOIDWithHV(request.getAesolicitudescrearpagrPlanT()));
        return aesolicitudesSrv.crearImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        EstadoContrato aesolicitudescrearpagrESTADOSOLICITUD = request.getAesolicitudescrearpagrESTADOSOLICITUDInstance();
        Productos aesolicitudescrearpagrProductoT = request.getAesolicitudescrearpagrProductoTInstance();
        Planes aesolicitudescrearpagrPlanT = request.getAesolicitudescrearpagrPlanTInstance();
        String aesolicitudescrearpatrLogin = request.getAesolicitudescrearpatrLogin();
        String aesolicitudescrearpatrTiposolicitud = request.getAesolicitudescrearpatrTiposolicitud();
        String aesolicitudescrearpatrNumerosolicitud = request.getAesolicitudescrearpatrNumerosolicitud();

        request.checkArguments();
        Aesolicitudes instance = new Aesolicitudes();
        if (aesolicitudescrearpagrESTADOSOLICITUD != null && !aesolicitudescrearpagrESTADOSOLICITUD.isNull()) {
            instance.add2ESTADOSOLICITUD(aesolicitudescrearpagrESTADOSOLICITUD);
        }

        instance.add2ProductoT(aesolicitudescrearpagrProductoT);

        if (aesolicitudescrearpagrPlanT != null && !aesolicitudescrearpagrPlanT.isNull()) {
            instance.add2PlanT(aesolicitudescrearpagrPlanT);
        }

        instance.setAesolicitudesidsolicitud(Long.valueOf(0));
        instance.setAesolicitudesFechaasignacion(STDFunctions.systemDateFun());
        instance.setAesolicitudesFesolici(STDFunctions.systemDateFun());
        instance.setAesolicitudesLogin(aesolicitudescrearpatrLogin);
        instance.setAesolicitudesTiposolicitud(aesolicitudescrearpatrTiposolicitud);
        instance.setAesolicitudesNumerosolicitud(aesolicitudescrearpatrNumerosolicitud);

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
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = aesolicitudesSrv.eliminarTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.EliminarRequest request) throws ModelException {
        request.setAesolicitudeseliminarpthisAESOLICITUDESInstance(aesolicitudesSrv.getByOIDWithHV(request.getAesolicitudeseliminarpthisAESOLICITUDES()));
        return aesolicitudesSrv.eliminarImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Aesolicitudes aesolicitudeseliminarpthisAESOLICITUDES = request.getAesolicitudeseliminarpthisAESOLICITUDESInstance();

        request.checkArguments();
        Aesolicitudes instance = aesolicitudeseliminarpthisAESOLICITUDES;
        if(aesolicitudeseliminarpthisAESOLICITUDES.getSolicitud() != null && !aesolicitudeseliminarpthisAESOLICITUDES.getSolicitud().isNull()) {
            throw new MinCardinalityException(AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ROLE_ALIAS_SOLICITUD);
        }


        repository.delete(instance);
        
        response.setInstance(instance);

        return response;
    }

    // Service: InsESTADOSOLICITUD

    /*
     * Entry point for service InsESTADOSOLICITUD
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insESTADOSOLICITUD(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.InsESTADOSOLICITUDRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = aesolicitudesSrv.insESTADOSOLICITUDTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsESTADOSOLICITUD
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insESTADOSOLICITUDTxn(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.InsESTADOSOLICITUDRequest request) throws ModelException {
        request.setAesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDESInstance(aesolicitudesSrv.getByOIDWithHV(request.getAesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDES()));
        request.setAesolicitudesInsESTADOSOLICITUDpevcEstadoContratoInstance(estadoContratoSrv.getByOIDWithHV(request.getAesolicitudesInsESTADOSOLICITUDpevcEstadoContrato()));
        return aesolicitudesSrv.insESTADOSOLICITUDImplementation(request, true);
    }

    /*
     * Implements service InsESTADOSOLICITUD
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insESTADOSOLICITUDImplementation(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.InsESTADOSOLICITUDRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Aesolicitudes aesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDES = request.getAesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDESInstance();
        EstadoContrato aesolicitudesInsESTADOSOLICITUDpevcEstadoContrato = request.getAesolicitudesInsESTADOSOLICITUDpevcEstadoContratoInstance();

        request.checkArguments();
        Aesolicitudes instance = aesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDES;

        instance.add2ESTADOSOLICITUD(aesolicitudesInsESTADOSOLICITUDpevcEstadoContrato);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.estadocontrato.siu.InsESTADOSOLICITUDRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.estadocontrato.siu.InsESTADOSOLICITUDRequest();
            relatedRequest.setEstadoContratoInsESTADOSOLICITUDpthisEstadoContratoInstance(aesolicitudesInsESTADOSOLICITUDpevcEstadoContrato);
            relatedRequest.setEstadoContratoInsESTADOSOLICITUDpevcAesolicitudesInstance(aesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDES);
            estadoContratoSrv.insESTADOSOLICITUDImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelESTADOSOLICITUD

    /*
     * Entry point for service DelESTADOSOLICITUD
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delESTADOSOLICITUD(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.DelESTADOSOLICITUDRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = aesolicitudesSrv.delESTADOSOLICITUDTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelESTADOSOLICITUD
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delESTADOSOLICITUDTxn(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.DelESTADOSOLICITUDRequest request) throws ModelException {
        request.setAesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDESInstance(aesolicitudesSrv.getByOIDWithHV(request.getAesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDES()));
        request.setAesolicitudesDelESTADOSOLICITUDpevcEstadoContratoInstance(estadoContratoSrv.getByOIDWithHV(request.getAesolicitudesDelESTADOSOLICITUDpevcEstadoContrato()));
        return aesolicitudesSrv.delESTADOSOLICITUDImplementation(request, true);
    }

    /*
     * Implements service DelESTADOSOLICITUD
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delESTADOSOLICITUDImplementation(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.DelESTADOSOLICITUDRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Aesolicitudes aesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDES = request.getAesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDESInstance();
        EstadoContrato aesolicitudesDelESTADOSOLICITUDpevcEstadoContrato = request.getAesolicitudesDelESTADOSOLICITUDpevcEstadoContratoInstance();

        request.checkArguments();
        Aesolicitudes instance = aesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDES;

        instance.add2ESTADOSOLICITUD(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.estadocontrato.siu.DelESTADOSOLICITUDRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.estadocontrato.siu.DelESTADOSOLICITUDRequest();
            relatedRequest.setEstadoContratoDelESTADOSOLICITUDpthisEstadoContratoInstance(aesolicitudesDelESTADOSOLICITUDpevcEstadoContrato);
            relatedRequest.setEstadoContratoDelESTADOSOLICITUDpevcAesolicitudesInstance(aesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDES);
            estadoContratoSrv.delESTADOSOLICITUDImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

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
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.ModificarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = aesolicitudesSrv.modificarTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.ModificarRequest request) throws ModelException {
        request.setAesolicitudesmodificarpthisAESOLICITUDESInstance(aesolicitudesSrv.getByOIDWithHV(request.getAesolicitudesmodificarpthisAESOLICITUDES()));
        return aesolicitudesSrv.modificarImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.ModificarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Aesolicitudes aesolicitudesmodificarpthisAESOLICITUDES = request.getAesolicitudesmodificarpthisAESOLICITUDESInstance();
        String aesolicitudesmodificarpNUMEROSOLICITUD = request.getAesolicitudesmodificarpNUMEROSOLICITUD();
        String aesolicitudesmodificarpSWESTADO = request.getAesolicitudesmodificarpSWESTADO();
        Date aesolicitudesmodificarpFECHAESTADO = request.getAesolicitudesmodificarpFECHAESTADO();
        String aesolicitudesmodificarpCDMOTANU = request.getAesolicitudesmodificarpCDMOTANU();
        String aesolicitudesmodificarpCDMOTDEV = request.getAesolicitudesmodificarpCDMOTDEV();
        Date aesolicitudesmodificarpFESOLICI = request.getAesolicitudesmodificarpFESOLICI();
        String aesolicitudesmodificarpLOGIN = request.getAesolicitudesmodificarpLOGIN();
        String aesolicitudesmodificarpOBSERVACION = request.getAesolicitudesmodificarpOBSERVACION();
        String aesolicitudesmodificarpTIPOSOLICITUD = request.getAesolicitudesmodificarpTIPOSOLICITUD();

        request.checkArguments();
        Aesolicitudes instance = aesolicitudesmodificarpthisAESOLICITUDES;
        instance.setAesolicitudesNumerosolicitud(aesolicitudesmodificarpNUMEROSOLICITUD);
        instance.setAesolicitudesSwestado(aesolicitudesmodificarpSWESTADO);
        instance.setAesolicitudesFechaasignacion(aesolicitudesmodificarpFECHAESTADO);
        instance.setAesolicitudesCdmotanu(aesolicitudesmodificarpCDMOTANU);
        instance.setAesolicitudesCdmotdev(aesolicitudesmodificarpCDMOTDEV);
        instance.setAesolicitudesFesolici(aesolicitudesmodificarpFESOLICI);
        instance.setAesolicitudesLogin(aesolicitudesmodificarpLOGIN);
        instance.setAesolicitudesObservacion(aesolicitudesmodificarpOBSERVACION);
        instance.setAesolicitudesTiposolicitud(aesolicitudesmodificarpTIPOSOLICITUD);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: modificarNumSolicitud

    /*
     * Entry point for service modificarNumSolicitud
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse modificarNumSolicitud(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.ModificarNumSolicitudRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = aesolicitudesSrv.modificarNumSolicitudTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service modificarNumSolicitud
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse modificarNumSolicitudTxn(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.ModificarNumSolicitudRequest request) throws ModelException {
        request.setAesolicitudesmodificarNumSolicitudpthisAESOLICITUDESInstance(aesolicitudesSrv.getByOIDWithHV(request.getAesolicitudesmodificarNumSolicitudpthisAESOLICITUDES()));
        return aesolicitudesSrv.modificarNumSolicitudImplementation(request);
    }

    /*
     * Implements service modificarNumSolicitud
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse modificarNumSolicitudImplementation(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.ModificarNumSolicitudRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Aesolicitudes aesolicitudesmodificarNumSolicitudpthisAESOLICITUDES = request.getAesolicitudesmodificarNumSolicitudpthisAESOLICITUDESInstance();
        String aesolicitudesmodificarNumSolicitudpNUMEROSOLICITUD = request.getAesolicitudesmodificarNumSolicitudpNUMEROSOLICITUD();

        request.checkArguments();
        Aesolicitudes instance = aesolicitudesmodificarNumSolicitudpthisAESOLICITUDES;
        instance.setAesolicitudesNumerosolicitud(aesolicitudesmodificarNumSolicitudpNUMEROSOLICITUD);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: cambiarEstado

    /*
     * Entry point for service cambiarEstado
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse cambiarEstado(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.CambiarEstadoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = aesolicitudesSrv.cambiarEstadoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service cambiarEstado
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse cambiarEstadoTxn(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.CambiarEstadoRequest request) throws ModelException {
        request.setAesolicitudescambiarEstadopthisAESOLICITUDESInstance(aesolicitudesSrv.getByOIDWithHV(request.getAesolicitudescambiarEstadopthisAESOLICITUDES()));
        return aesolicitudesSrv.cambiarEstadoImplementation(request);
    }

    /*
     * Implements service cambiarEstado
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse cambiarEstadoImplementation(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.CambiarEstadoRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Aesolicitudes aesolicitudescambiarEstadopthisAESOLICITUDES = request.getAesolicitudescambiarEstadopthisAESOLICITUDESInstance();
        String aesolicitudescambiarEstadopSWESTADO = request.getAesolicitudescambiarEstadopSWESTADO();

        request.checkArguments();
        Aesolicitudes instance = aesolicitudescambiarEstadopthisAESOLICITUDES;
        instance.setAesolicitudesSwestado(aesolicitudescambiarEstadopSWESTADO);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: modificarFechaElab

    /*
     * Entry point for service modificarFechaElab
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse modificarFechaElab(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.ModificarFechaElabRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = aesolicitudesSrv.modificarFechaElabTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service modificarFechaElab
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse modificarFechaElabTxn(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.ModificarFechaElabRequest request) throws ModelException {
        request.setAesolicitudesmodificarFechaElabpthisAESOLICITUDESInstance(aesolicitudesSrv.getByOIDWithHV(request.getAesolicitudesmodificarFechaElabpthisAESOLICITUDES()));
        return aesolicitudesSrv.modificarFechaElabImplementation(request);
    }

    /*
     * Implements service modificarFechaElab
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse modificarFechaElabImplementation(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.ModificarFechaElabRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Aesolicitudes aesolicitudesmodificarFechaElabpthisAESOLICITUDES = request.getAesolicitudesmodificarFechaElabpthisAESOLICITUDESInstance();
        Date aesolicitudesmodificarFechaElabpeFecha = request.getAesolicitudesmodificarFechaElabpeFecha();

        request.checkArguments();
        Aesolicitudes instance = aesolicitudesmodificarFechaElabpthisAESOLICITUDES;
        instance.setAesolicitudesFesolici(aesolicitudesmodificarFechaElabpeFecha);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: TNUEVAAFILIACION

    /*
     * Entry point for service TNUEVAAFILIACION
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TNUEVAAFILIACIONResponse tNUEVAAFILIACION(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TNUEVAAFILIACIONRequest request) {
        com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TNUEVAAFILIACIONResponse response = new com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TNUEVAAFILIACIONResponse();
        try {
            response = aesolicitudesSrv.tNUEVAAFILIACIONTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TNUEVAAFILIACION
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TNUEVAAFILIACIONResponse tNUEVAAFILIACIONTxn(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TNUEVAAFILIACIONRequest request) throws ModelException, SystemException {
        request.setAesolicitudesTNUEVAAFILIACIONptpagrProductoInstance(productosSrv.getByOIDWithHV(new ProductosOid().fromJsonString(request.getAesolicitudesTNUEVAAFILIACIONptpagrProducto())));
        request.setAesolicitudesTNUEVAAFILIACIONptpagrPlanInstance(planesSrv.getByOIDWithHV(new PlanesOid().fromJsonString(request.getAesolicitudesTNUEVAAFILIACIONptpagrPlan())));
        request.setAesolicitudesTNUEVAAFILIACIONptProteccionDatosInstance(proteccionDatosSrv.getByOIDWithHV(request.getAesolicitudesTNUEVAAFILIACIONptProteccionDatos()));
        request.setAesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociadoInstance(grupoAsociadoSrv.getByOIDWithHV(request.getAesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociado()));
        request.setAesolicitudesTNUEVAAFILIACIONpDirectorInstance(asesorSrv.getByOIDWithHV(request.getAesolicitudesTNUEVAAFILIACIONpDirector()));
        request.setAesolicitudesTNUEVAAFILIACIONptProrrateoInstance(prorrateoSrv.getByOIDWithHV(new ProrrateoOid().fromJsonString(request.getAesolicitudesTNUEVAAFILIACIONptProrrateo())));
        request.setAesolicitudesTNUEVAAFILIACIONptTipoFacturaInstance(tipoFacturaSrv.getByOIDWithHV(new TipoFacturaOid().fromJsonString(request.getAesolicitudesTNUEVAAFILIACIONptTipoFactura())));
        return aesolicitudesSrv.tNUEVAAFILIACIONImplementation(request);
    }

    /*
     * Implements service TNUEVAAFILIACION
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TNUEVAAFILIACIONResponse tNUEVAAFILIACIONImplementation(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TNUEVAAFILIACIONRequest request) throws ModelException, SystemException {
        com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TNUEVAAFILIACIONResponse response = new com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TNUEVAAFILIACIONResponse();
        Productos aesolicitudesTNUEVAAFILIACIONptpagrProducto = request.getAesolicitudesTNUEVAAFILIACIONptpagrProductoInstance();
        Planes aesolicitudesTNUEVAAFILIACIONptpagrPlan = request.getAesolicitudesTNUEVAAFILIACIONptpagrPlanInstance();
        Prorrateo aesolicitudesTNUEVAAFILIACIONptProrrateo = request.getAesolicitudesTNUEVAAFILIACIONptProrrateoInstance();
        ProteccionDatos aesolicitudesTNUEVAAFILIACIONptProteccionDatos = request.getAesolicitudesTNUEVAAFILIACIONptProteccionDatosInstance();
        GrupoAsociado aesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociado = request.getAesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociadoInstance();
        Date aesolicitudesTNUEVAAFILIACIONptpatrFInicioContrato = request.getAesolicitudesTNUEVAAFILIACIONptpatrFInicioContrato();
        Boolean aesolicitudesTNUEVAAFILIACIONptpatrEsTraslado = request.getAesolicitudesTNUEVAAFILIACIONptpatrEsTraslado();
        Asesor aesolicitudesTNUEVAAFILIACIONpDirector = request.getAesolicitudesTNUEVAAFILIACIONpDirectorInstance();
        TipoFactura aesolicitudesTNUEVAAFILIACIONptTipoFactura = request.getAesolicitudesTNUEVAAFILIACIONptTipoFacturaInstance();
        Boolean aesolicitudesTNUEVAAFILIACIONptMarcaCarnet = request.getAesolicitudesTNUEVAAFILIACIONptMarcaCarnet();

        request.checkArguments();

        tNUEVAAFILIACIONPreconditions(request);
        Aesolicitudes instance;

        com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.CrearRequest step1Request = new com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.CrearRequest();
        step1Request.setAesolicitudescrearpagrESTADOSOLICITUDInstance(null);
        step1Request.setAesolicitudescrearpagrProductoTInstance(aesolicitudesTNUEVAAFILIACIONptpagrProducto);
        step1Request.setAesolicitudescrearpagrPlanTInstance(aesolicitudesTNUEVAAFILIACIONptpagrPlan);
        step1Request.setAesolicitudescrearpatrLogin(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).getFuncionarioUsuario());
        step1Request.setAesolicitudescrearpatrTiposolicitud("E");
        step1Request.setAesolicitudescrearpatrNumerosolicitud("");
        instance = (Aesolicitudes) aesolicitudesSrv.crearImplementation(step1Request).getInstance();

        /* Action 2: IF (ptProrrateo <> NULL) */
        boolean ifCondition2 = (aesolicitudesTNUEVAAFILIACIONptProrrateo != null && !aesolicitudesTNUEVAAFILIACIONptProrrateo.isNull());
        if (ifCondition2) {
            com.keralty.aesolicitudes.viewmodel.solicitud.siu.TNUEVAAFILIACIONRequest step20Request = new com.keralty.aesolicitudes.viewmodel.solicitud.siu.TNUEVAAFILIACIONRequest();
            step20Request.setSolicitudTNUEVAAFILIACIONptpagrAESOLICITUDESInstance(instance);
            step20Request.setSolicitudTNUEVAAFILIACIONptpagrProteccionDatosInstance(aesolicitudesTNUEVAAFILIACIONptProteccionDatos);
            step20Request.setSolicitudTNUEVAAFILIACIONptpagrGrupoAsociadoInstance(aesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociado);
            step20Request.setSolicitudTNUEVAAFILIACIONptpatrFInicioContrato(aesolicitudesTNUEVAAFILIACIONptpatrFInicioContrato);
            step20Request.setSolicitudTNUEVAAFILIACIONptpatrEsTraslado(aesolicitudesTNUEVAAFILIACIONptpatrEsTraslado);
            step20Request.setSolicitudTNUEVAAFILIACIONpCodDirector(aesolicitudesTNUEVAAFILIACIONpDirector.getFuncionarioUsuario());
            step20Request.setSolicitudTNUEVAAFILIACIONptPorcenProrrateo(aesolicitudesTNUEVAAFILIACIONptProrrateo.getProrrateoPorcentaje());
            step20Request.setSolicitudTNUEVAAFILIACIONptTipoFacturaInstance(aesolicitudesTNUEVAAFILIACIONptTipoFactura);
            step20Request.setSolicitudTNUEVAAFILIACIONptMarcaCarnet(aesolicitudesTNUEVAAFILIACIONptMarcaCarnet);
            step20Request.setSolicitudTNUEVAAFILIACIONptNumRadicado(Long.valueOf(0));
            com.keralty.aesolicitudes.viewmodel.solicitud.siu.TNUEVAAFILIACIONResponse step20Response = solicitudSrv.tNUEVAAFILIACIONImplementation(step20Request);
            response.setAesolicitudesTNUEVAAFILIACIONptpsSolicitudInstance(step20Response.getSolicitudTNUEVAAFILIACIONpsSolicitudInstance());
        } else {
            com.keralty.aesolicitudes.viewmodel.solicitud.siu.TNUEVAAFILIACIONRequest step21Request = new com.keralty.aesolicitudes.viewmodel.solicitud.siu.TNUEVAAFILIACIONRequest();
            step21Request.setSolicitudTNUEVAAFILIACIONptpagrAESOLICITUDESInstance(instance);
            step21Request.setSolicitudTNUEVAAFILIACIONptpagrProteccionDatosInstance(aesolicitudesTNUEVAAFILIACIONptProteccionDatos);
            step21Request.setSolicitudTNUEVAAFILIACIONptpagrGrupoAsociadoInstance(aesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociado);
            step21Request.setSolicitudTNUEVAAFILIACIONptpatrFInicioContrato(aesolicitudesTNUEVAAFILIACIONptpatrFInicioContrato);
            step21Request.setSolicitudTNUEVAAFILIACIONptpatrEsTraslado(aesolicitudesTNUEVAAFILIACIONptpatrEsTraslado);
            step21Request.setSolicitudTNUEVAAFILIACIONpCodDirector(aesolicitudesTNUEVAAFILIACIONpDirector.getFuncionarioUsuario());
            step21Request.setSolicitudTNUEVAAFILIACIONptPorcenProrrateo(null);
            step21Request.setSolicitudTNUEVAAFILIACIONptTipoFacturaInstance(aesolicitudesTNUEVAAFILIACIONptTipoFactura);
            step21Request.setSolicitudTNUEVAAFILIACIONptMarcaCarnet(aesolicitudesTNUEVAAFILIACIONptMarcaCarnet);
            step21Request.setSolicitudTNUEVAAFILIACIONptNumRadicado(Long.valueOf(0));
            com.keralty.aesolicitudes.viewmodel.solicitud.siu.TNUEVAAFILIACIONResponse step21Response = solicitudSrv.tNUEVAAFILIACIONImplementation(step21Request);
            response.setAesolicitudesTNUEVAAFILIACIONptpsSolicitudInstance(step21Response.getSolicitudTNUEVAAFILIACIONpsSolicitudInstance());
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    /*
     * Checks service TNUEVAAFILIACION preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TNUEVAAFILIACIONResponse tNUEVAAFILIACIONCheckPreconditions(com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TNUEVAAFILIACIONRequest request) {
        com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TNUEVAAFILIACIONResponse response = new com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TNUEVAAFILIACIONResponse();
        request.setAesolicitudesTNUEVAAFILIACIONptpagrProductoInstance(productosSrv.getByOIDWithHV(new ProductosOid().fromJsonString(request.getAesolicitudesTNUEVAAFILIACIONptpagrProducto())));
        request.setAesolicitudesTNUEVAAFILIACIONptpagrPlanInstance(planesSrv.getByOIDWithHV(new PlanesOid().fromJsonString(request.getAesolicitudesTNUEVAAFILIACIONptpagrPlan())));
        request.setAesolicitudesTNUEVAAFILIACIONptProteccionDatosInstance(proteccionDatosSrv.getByOIDWithHV(request.getAesolicitudesTNUEVAAFILIACIONptProteccionDatos()));
        request.setAesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociadoInstance(grupoAsociadoSrv.getByOIDWithHV(request.getAesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociado()));
        request.setAesolicitudesTNUEVAAFILIACIONpDirectorInstance(asesorSrv.getByOIDWithHV(request.getAesolicitudesTNUEVAAFILIACIONpDirector()));
        request.setAesolicitudesTNUEVAAFILIACIONptProrrateoInstance(prorrateoSrv.getByOIDWithHV(new ProrrateoOid().fromJsonString(request.getAesolicitudesTNUEVAAFILIACIONptProrrateo())));
        request.setAesolicitudesTNUEVAAFILIACIONptTipoFacturaInstance(tipoFacturaSrv.getByOIDWithHV(new TipoFacturaOid().fromJsonString(request.getAesolicitudesTNUEVAAFILIACIONptTipoFactura())));
        try {
            if("Clas_1431956094976663Pre_29".equals(request.getPreconditionId()))
                checkClas1431956094976663Pre29(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tNUEVAAFILIACIONPreconditions(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TNUEVAAFILIACIONRequest request) 
            throws ModelException {
        checkClas1431956094976663Pre29(request);
    }

    private void checkClas1431956094976663Pre29 (
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TNUEVAAFILIACIONRequest request) 
            throws ModelException {
        // (ptpagrPlan.EsVoluntario = TRUE AND ptpagrPlan.InicioContDiaUno = FALSE ) OR ptpatrFInicioContrato <> NULL 

        Planes aesolicitudesTNUEVAAFILIACIONptpagrPlan = request.getAesolicitudesTNUEVAAFILIACIONptpagrPlanInstance();
        Date aesolicitudesTNUEVAAFILIACIONptpatrFInicioContrato = request.getAesolicitudesTNUEVAAFILIACIONptpatrFInicioContrato();
        boolean preconditionHolds = (aesolicitudesTNUEVAAFILIACIONptpagrPlan.getPlanesEsVoluntario().equals(true) && aesolicitudesTNUEVAAFILIACIONptpagrPlan.getPlanesInicioContDiaUno().equals(false)) || aesolicitudesTNUEVAAFILIACIONptpatrFInicioContrato != null;
        if (!preconditionHolds) throw new PreconditionException("Debe diligenciar la fecha de inicio de contratación");
    }

    // Service: TCREARFISICA

    /*
     * Entry point for service TCREARFISICA
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCREARFISICA(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TCREARFISICARequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = aesolicitudesSrv.tCREARFISICATxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREARFISICA
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCREARFISICATxn(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TCREARFISICARequest request) throws ModelException {
        request.setAesolicitudesTCREARFISICAptpagrProductoInstance(productosSrv.getByOIDWithHV(request.getAesolicitudesTCREARFISICAptpagrProducto()));
        return aesolicitudesSrv.tCREARFISICAImplementation(request);
    }

    /*
     * Implements service TCREARFISICA
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCREARFISICAImplementation(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TCREARFISICARequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Productos aesolicitudesTCREARFISICAptpagrProducto = request.getAesolicitudesTCREARFISICAptpagrProductoInstance();
        String aesolicitudesTCREARFISICAptpatrLOGIN = request.getAesolicitudesTCREARFISICAptpatrLOGIN();
        String aesolicitudesTCREARFISICAptpNUMEROSOLICITUD = request.getAesolicitudesTCREARFISICAptpNUMEROSOLICITUD();
        String aesolicitudesTCREARFISICAptpSWESTADO = request.getAesolicitudesTCREARFISICAptpSWESTADO();
        Date aesolicitudesTCREARFISICAptpFECHAESTADO = request.getAesolicitudesTCREARFISICAptpFECHAESTADO();

        request.checkArguments();
        Aesolicitudes instance;

        com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.CrearRequest step1Request = new com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.CrearRequest();
        step1Request.setAesolicitudescrearpagrESTADOSOLICITUDInstance(null);
        step1Request.setAesolicitudescrearpagrProductoTInstance(aesolicitudesTCREARFISICAptpagrProducto);
        step1Request.setAesolicitudescrearpagrPlanTInstance(null);
        step1Request.setAesolicitudescrearpatrLogin(aesolicitudesTCREARFISICAptpatrLOGIN);
        step1Request.setAesolicitudescrearpatrTiposolicitud("F");
        step1Request.setAesolicitudescrearpatrNumerosolicitud(aesolicitudesTCREARFISICAptpNUMEROSOLICITUD);
        instance = (Aesolicitudes) aesolicitudesSrv.crearImplementation(step1Request).getInstance();

        com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.ModificarRequest step2Request = new com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.ModificarRequest();
        step2Request.setAesolicitudesmodificarpthisAESOLICITUDESInstance(instance);
        step2Request.setAesolicitudesmodificarpNUMEROSOLICITUD(aesolicitudesTCREARFISICAptpNUMEROSOLICITUD);
        step2Request.setAesolicitudesmodificarpSWESTADO(aesolicitudesTCREARFISICAptpSWESTADO);
        step2Request.setAesolicitudesmodificarpFECHAESTADO(aesolicitudesTCREARFISICAptpFECHAESTADO);
        step2Request.setAesolicitudesmodificarpCDMOTANU(null);
        step2Request.setAesolicitudesmodificarpCDMOTDEV(null);
        step2Request.setAesolicitudesmodificarpFESOLICI(null);
        step2Request.setAesolicitudesmodificarpLOGIN(aesolicitudesTCREARFISICAptpatrLOGIN);
        step2Request.setAesolicitudesmodificarpOBSERVACION(null);
        step2Request.setAesolicitudesmodificarpTIPOSOLICITUD("F");
        aesolicitudesSrv.modificarImplementation(step2Request);

        com.keralty.aesolicitudes.viewmodel.solicitud.siu.CrearRequest step3Request = new com.keralty.aesolicitudes.viewmodel.solicitud.siu.CrearRequest();
        step3Request.setSolicitudcrearpagrAesolicitudesInstance(instance);
        step3Request.setSolicitudcrearpagrContratantePersonaInstance(null);
        step3Request.setSolicitudcrearpagrTitularPersonaInstance(null);
        step3Request.setSolicitudcrearpagrProteccionDatosInstance(null);
        step3Request.setSolicitudcrearpagrAgenteInstance(userFunctionsSrv.fugetAgenteFun(aesolicitudesTCREARFISICAptpatrLOGIN));
        step3Request.setSolicitudcrearpagrPeriodicidadInstance(null);
        step3Request.setSolicitudcrearpagrGrupoAsociadoInstance(null);
        step3Request.setSolicitudcrearpagrContratoCInstance(null);
        step3Request.setSolicitudcrearpagrUsrAreaMedicaInstance(null);
        step3Request.setSolicitudcrearpagrFormaPagoInstance(null);
        step3Request.setSolicitudcrearpagrTipoFacturaInstance(null);
        step3Request.setSolicitudcrearpagrUsrAfiliacionInstance(null);
        step3Request.setSolicitudcrearpatrTramite(Long.valueOf(1));
        step3Request.setSolicitudcrearpatrFInicioContrato(aesolicitudesTCREARFISICAptpFECHAESTADO);
        step3Request.setSolicitudcrearpatrEsTraslado(Boolean.FALSE);
        step3Request.setSolicitudcrearpatrNumContratoInclusion(null);
        step3Request.setSolicitudcrearpatrNumFamilia(null);
        step3Request.setSolicitudcrearpatrcodDirector("NONE");
        step3Request.setSolicitudcrearpatrCodTarifa(null);
        step3Request.setSolicitudcrearpatrPorcentajeProrrateo(null);
        step3Request.setSolicitudcrearpatrEnvioCarnetFisico(Boolean.TRUE);
        step3Request.setSolicitudcrearpatrNumRadicado(STDFunctions.strToIntFun(aesolicitudesTCREARFISICAptpNUMEROSOLICITUD));
        solicitudSrv.crearImplementation(step3Request);

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TINCLUSIONSC

    /*
     * Entry point for service TINCLUSIONSC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TINCLUSIONSCResponse tINCLUSIONSC(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TINCLUSIONSCRequest request) {
        com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TINCLUSIONSCResponse response = new com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TINCLUSIONSCResponse();
        try {
            response = aesolicitudesSrv.tINCLUSIONSCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TINCLUSIONSC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TINCLUSIONSCResponse tINCLUSIONSCTxn(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TINCLUSIONSCRequest request) throws ModelException, SystemException {
        request.setAesolicitudesTINCLUSIONSCptpagrProductoInstance(productosSrv.getByOIDWithHV(new ProductosOid().fromJsonString(request.getAesolicitudesTINCLUSIONSCptpagrProducto())));
        request.setAesolicitudesTINCLUSIONSCptpagrPlanInstance(planesSrv.getByOIDWithHV(new PlanesOid().fromJsonString(request.getAesolicitudesTINCLUSIONSCptpagrPlan())));
        request.setAesolicitudesTINCLUSIONSCptProteccionDatosInstance(proteccionDatosSrv.getByOIDWithHV(request.getAesolicitudesTINCLUSIONSCptProteccionDatos()));
        request.setAesolicitudesTINCLUSIONSCpDirectorInstance(asesorSrv.getByOIDWithHV(request.getAesolicitudesTINCLUSIONSCpDirector()));
        return aesolicitudesSrv.tINCLUSIONSCImplementation(request);
    }

    /*
     * Implements service TINCLUSIONSC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TINCLUSIONSCResponse tINCLUSIONSCImplementation(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TINCLUSIONSCRequest request) throws ModelException, SystemException {
        com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TINCLUSIONSCResponse response = new com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TINCLUSIONSCResponse();
        Productos aesolicitudesTINCLUSIONSCptpagrProducto = request.getAesolicitudesTINCLUSIONSCptpagrProductoInstance();
        Planes aesolicitudesTINCLUSIONSCptpagrPlan = request.getAesolicitudesTINCLUSIONSCptpagrPlanInstance();
        ProteccionDatos aesolicitudesTINCLUSIONSCptProteccionDatos = request.getAesolicitudesTINCLUSIONSCptProteccionDatosInstance();
        Date aesolicitudesTINCLUSIONSCptpatrFInicioContrato = request.getAesolicitudesTINCLUSIONSCptpatrFInicioContrato();
        String aesolicitudesTINCLUSIONSCptpatrNumContratoInclusion = request.getAesolicitudesTINCLUSIONSCptpatrNumContratoInclusion();
        String aesolicitudesTINCLUSIONSCptpatrNumFamilia = request.getAesolicitudesTINCLUSIONSCptpatrNumFamilia();
        Asesor aesolicitudesTINCLUSIONSCpDirector = request.getAesolicitudesTINCLUSIONSCpDirectorInstance();
        Boolean aesolicitudesTINCLUSIONSCptMarcaCarnet = request.getAesolicitudesTINCLUSIONSCptMarcaCarnet();

        request.checkArguments();

        tINCLUSIONSCPreconditions(request);
        Aesolicitudes instance;

        com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.CrearRequest step1Request = new com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.CrearRequest();
        step1Request.setAesolicitudescrearpagrESTADOSOLICITUDInstance(null);
        step1Request.setAesolicitudescrearpagrProductoTInstance(aesolicitudesTINCLUSIONSCptpagrProducto);
        step1Request.setAesolicitudescrearpagrPlanTInstance(aesolicitudesTINCLUSIONSCptpagrPlan);
        step1Request.setAesolicitudescrearpatrLogin(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).getFuncionarioUsuario());
        step1Request.setAesolicitudescrearpatrTiposolicitud("E");
        step1Request.setAesolicitudescrearpatrNumerosolicitud("");
        instance = (Aesolicitudes) aesolicitudesSrv.crearImplementation(step1Request).getInstance();

        com.keralty.aesolicitudes.viewmodel.solicitud.siu.TINCLUSIONSCRequest step2Request = new com.keralty.aesolicitudes.viewmodel.solicitud.siu.TINCLUSIONSCRequest();
        step2Request.setSolicitudTINCLUSIONSCptpagrAESOLICITUDESInstance(instance);
        step2Request.setSolicitudTINCLUSIONSCptpagrProteccionDatosInstance(aesolicitudesTINCLUSIONSCptProteccionDatos);
        step2Request.setSolicitudTINCLUSIONSCptpatrFInicioContrato(aesolicitudesTINCLUSIONSCptpatrFInicioContrato);
        step2Request.setSolicitudTINCLUSIONSCptpatrNumContratoInclusion(aesolicitudesTINCLUSIONSCptpatrNumContratoInclusion);
        step2Request.setSolicitudTINCLUSIONSCptpatrNumFamilia(aesolicitudesTINCLUSIONSCptpatrNumFamilia);
        step2Request.setSolicitudTINCLUSIONSCpCodDirector(aesolicitudesTINCLUSIONSCpDirector.getFuncionarioUsuario());
        step2Request.setSolicitudTINCLUSIONSCptPorcenProrrateo(null);
        step2Request.setSolicitudTINCLUSIONSCptMarcaCarnet(aesolicitudesTINCLUSIONSCptMarcaCarnet);
        step2Request.setSolicitudTINCLUSIONSCptNumRadicado(Long.valueOf(0));
        com.keralty.aesolicitudes.viewmodel.solicitud.siu.TINCLUSIONSCResponse step2Response = solicitudSrv.tINCLUSIONSCImplementation(step2Request);
        response.setAesolicitudesTINCLUSIONSCptpsSolicitudInstance(step2Response.getSolicitudTINCLUSIONSCpsSolicitudInstance());

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    /*
     * Checks service TINCLUSIONSC preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TINCLUSIONSCResponse tINCLUSIONSCCheckPreconditions(com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TINCLUSIONSCRequest request) {
        com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TINCLUSIONSCResponse response = new com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TINCLUSIONSCResponse();
        request.setAesolicitudesTINCLUSIONSCptpagrProductoInstance(productosSrv.getByOIDWithHV(new ProductosOid().fromJsonString(request.getAesolicitudesTINCLUSIONSCptpagrProducto())));
        request.setAesolicitudesTINCLUSIONSCptpagrPlanInstance(planesSrv.getByOIDWithHV(new PlanesOid().fromJsonString(request.getAesolicitudesTINCLUSIONSCptpagrPlan())));
        request.setAesolicitudesTINCLUSIONSCptProteccionDatosInstance(proteccionDatosSrv.getByOIDWithHV(request.getAesolicitudesTINCLUSIONSCptProteccionDatos()));
        request.setAesolicitudesTINCLUSIONSCpDirectorInstance(asesorSrv.getByOIDWithHV(request.getAesolicitudesTINCLUSIONSCpDirector()));
        try {
            if("Clas_1431956094976663Pre_30".equals(request.getPreconditionId()))
                checkClas1431956094976663Pre30(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tINCLUSIONSCPreconditions(
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TINCLUSIONSCRequest request) 
            throws ModelException {
        checkClas1431956094976663Pre30(request);
    }

    private void checkClas1431956094976663Pre30 (
            com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TINCLUSIONSCRequest request) 
            throws ModelException {
        // (ptpagrPlan.EsVoluntario = TRUE AND ptpagrPlan.InicioContDiaUno = FALSE )  OR ptpatrFInicioContrato <> NULL

        Planes aesolicitudesTINCLUSIONSCptpagrPlan = request.getAesolicitudesTINCLUSIONSCptpagrPlanInstance();
        Date aesolicitudesTINCLUSIONSCptpatrFInicioContrato = request.getAesolicitudesTINCLUSIONSCptpatrFInicioContrato();
        boolean preconditionHolds = (aesolicitudesTINCLUSIONSCptpagrPlan.getPlanesEsVoluntario().equals(true) && aesolicitudesTINCLUSIONSCptpagrPlan.getPlanesInicioContDiaUno().equals(false)) || aesolicitudesTINCLUSIONSCptpatrFInicioContrato != null;
        if (!preconditionHolds) throw new PreconditionException("Debe diligenciar la fecha inicio contratación");
    }


    @Override
    protected void applyHVFilter(SQLSelect sql) throws SystemException {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        SQLWhereDisjunction disjunction = new SQLWhereDisjunction();
        if (getAgentRoles().contains(AsesorConstants.CLASS_NAME)) applyHVFilter4Asesor(sql, disjunction);
        conjunction.addDisjunction(disjunction);
        sql.addConjunction(conjunction);
    }

    private void applyHVFilter4Asesor(SQLSelect sql, SQLWhereDisjunction disjunction) {
        // Solicitud.Agente = agent OR Solicitud.Agente.CodJefe = Agent.Usuario
        Asesor agentInstance = getAgentAsesor();
    {
        // 'or' Logical operator
        SQLWhereDisjunction comparison1 = new SQLWhereDisjunction();
    
        // Operand 1
            // '=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(AesolicitudesConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AGENTE, FuncionarioConstants.CLASS_NAME);
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(Constants.AGENTKEYWORD, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, agentInstance.getOid(), Constants.AGENTKEYWORD);
            comparison2.setSecondOperand(operand224);
            comparison1.addOperand(comparison2);
    
        // Operand 2
            // '=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(AesolicitudesConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AGENTE + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOCODJEFE, Constants.Type.STRING.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(agentInstance.getFuncionarioUsuario(), Constants.Type.STRING.getTypeName()));
            comparison1.addOperand(comparison4);
        
        disjunction.addOperand(comparison1);
    }

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
        select.getOrderByPart().addItem(Constants.normalizePath(AesolicitudesConstants.CLASS_NAME, AesolicitudesConstants.ATTR_FIELD_AESOLICITUDESIDSOLICITUD, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildAesolicitudesRelatedInstance(relatedInstanceJsonOid);
        }
        if (AesolicitudesConstants.ROLE_NAME_SOLICITUD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAesolicitudesRelatedInstance4Solicitud(relatedInstanceJsonOid, remainingPath);
        }
        if (AesolicitudesConstants.ROLE_NAME_PRODUCTOT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAesolicitudesRelatedInstance4Productos(relatedInstanceJsonOid, remainingPath);
        }
        if (AesolicitudesConstants.ROLE_NAME_PLANT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAesolicitudesRelatedInstance4Planes(relatedInstanceJsonOid, remainingPath);
        }
        if (AesolicitudesConstants.ROLE_NAME_ESTADOSOLICITUD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAesolicitudesRelatedInstance4EstadoContrato(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildAesolicitudesRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new Aesolicitudes(mapper.readValue(relatedInstanceJsonOid, AesolicitudesOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAesolicitudesRelatedInstance4Solicitud(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Solicitud(mapper.readValue(relatedInstanceJsonOid, SolicitudOid.class)): Solicitud.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAesolicitudesRelatedInstance4Productos(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Productos(mapper.readValue(relatedInstanceJsonOid, ProductosOid.class)): Productos.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAesolicitudesRelatedInstance4Planes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Planes(mapper.readValue(relatedInstanceJsonOid, PlanesOid.class)): Planes.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAesolicitudesRelatedInstance4EstadoContrato(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new EstadoContrato(mapper.readValue(relatedInstanceJsonOid, EstadoContratoOid.class)): EstadoContrato.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            AesolicitudesOid oid = new AesolicitudesOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(AesolicitudesConstants.ATTR_FIELD_AESOLICITUDESIDSOLICITUD, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getAesolicitudesidsolicitud(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(AesolicitudesService.class).error(e.getMessage());
        }
    }

}
