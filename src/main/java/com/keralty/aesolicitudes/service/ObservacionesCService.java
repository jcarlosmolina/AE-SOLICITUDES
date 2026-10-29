package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.ObservacionesCConstants;
import com.keralty.aesolicitudes.global.STDFunctions;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.ObservacionesC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.ObservacionesCOid;
import com.keralty.aesolicitudes.repository.ObservacionesCJpaRepository;
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
public class ObservacionesCService extends AbstractService {

    ObservacionesCJpaRepository repository;

    ObservacionesCService observacionesCSrv;

    ContratoCService contratoCSrv;

    @Inject
    public ObservacionesCService(
            ObservacionesCService observacionesCSrv,
            ContratoCService contratoCSrv,
            ObservacionesCJpaRepository repository) {
        this.observacionesCSrv = observacionesCSrv;
        this.contratoCSrv = contratoCSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, ObservacionesCConstants.CLASS_NAME);
    }

    private List<ObservacionesC> solveObservacionesCTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, ObservacionesCConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveObservacionesCTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, ObservacionesCConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class ObservacionesC
     *
     * @return Population of class ObservacionesC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ObservacionesC> get() {
        List<ObservacionesC> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class ObservacionesC that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class ObservacionesC matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ObservacionesC> get(QueryRequest queryRequest) {
        return solveObservacionesCTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveObservacionesCTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveObservacionesCTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveObservacionesCTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of ObservacionesC by ID
     *
     * @param observacionesCIdentificador Identification field observacionesCIdentificador
     *
     * @return Instance of ObservacionesC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ObservacionesC getById(Long observacionesCIdentificador) {
        return getByOID(new ObservacionesCOid(observacionesCIdentificador));
    }
    
    /*
     * Returns an instance of ObservacionesC by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ObservacionesC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ObservacionesC getByOID(ObservacionesCOid oid) {
        Optional<ObservacionesC> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of ObservacionesC by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ObservacionesC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public ObservacionesC getByOIDWithHV(ObservacionesCOid oid) {
        Optional<ObservacionesC> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<ObservacionesC> getInstanceByOid(ObservacionesCOid oid) {
        return oid != null && oid.getObservacionesCIdentificador() != null
               ? repository.findById(oid.getObservacionesCIdentificador())
               : Optional.empty();
    }

    /*
     * Returns an instance of ObservacionesC by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of ObservacionesC
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public ObservacionesC getByJsonOid(String jsonOid) {
        ObservacionesCOid oid = new ObservacionesCOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of ObservacionesC related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ObservacionesC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ObservacionesC> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveObservacionesCTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of ObservacionesC related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ObservacionesC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ObservacionesC> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of ObservacionesC
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of ObservacionesC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getObservacionesCDynamic(ObservacionesCOid oid, String displaySetItems) {
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
    public String getSuppInfo(ObservacionesCOid oid, String dsName) {
        ObservacionesC instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(ObservacionesC instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
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
            com.keralty.aesolicitudes.viewmodel.observacionesc.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = observacionesCSrv.crearTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.observacionesc.siu.CrearRequest request) throws ModelException {
        request.setObservacionesCcrearpagrContratoCInstance(contratoCSrv.getByOIDWithHV(request.getObservacionesCcrearpagrContratoC()));
        return observacionesCSrv.crearImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.observacionesc.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC observacionesCcrearpagrContratoC = request.getObservacionesCcrearpagrContratoCInstance();
        String observacionesCcrearpatrCodTipoObservacion = request.getObservacionesCcrearpatrCodTipoObservacion();
        String observacionesCcrearpatrTipoObservacion = request.getObservacionesCcrearpatrTipoObservacion();
        String observacionesCcrearpatrObservacions = request.getObservacionesCcrearpatrObservacions();

        request.checkArguments();
        ObservacionesC instance = new ObservacionesC();
        instance.add2ContratoC(observacionesCcrearpagrContratoC);

        instance.setObservacionesCIdentificador(Long.valueOf(0));
        instance.setObservacionesCCodTipoObservacion(observacionesCcrearpatrCodTipoObservacion);
        instance.setObservacionesCTipoObservacion(observacionesCcrearpatrTipoObservacion);
        instance.setObservacionesCObservacions(observacionesCcrearpatrObservacions);

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
            com.keralty.aesolicitudes.viewmodel.observacionesc.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = observacionesCSrv.eliminarTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.observacionesc.siu.EliminarRequest request) throws ModelException {
        request.setObservacionesCeliminarpthisObservacionesCInstance(observacionesCSrv.getByOIDWithHV(request.getObservacionesCeliminarpthisObservacionesC()));
        return observacionesCSrv.eliminarImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.observacionesc.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ObservacionesC observacionesCeliminarpthisObservacionesC = request.getObservacionesCeliminarpthisObservacionesCInstance();

        request.checkArguments();
        ObservacionesC instance = observacionesCeliminarpthisObservacionesC;


        repository.delete(instance);
        
        response.setInstance(instance);

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
            com.keralty.aesolicitudes.viewmodel.observacionesc.siu.TCREARFROMWSRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = observacionesCSrv.tCREARFROMWSTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.observacionesc.siu.TCREARFROMWSRequest request) throws ModelException {
        request.setObservacionesCTCREARFROMWSpObservacionesCInstance(observacionesCSrv.getByOIDWithHV(request.getObservacionesCTCREARFROMWSpObservacionesC()));
        request.setObservacionesCTCREARFROMWSpContratoCInstance(contratoCSrv.getByOIDWithHV(request.getObservacionesCTCREARFROMWSpContratoC()));
        return observacionesCSrv.tCREARFROMWSImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.observacionesc.siu.TCREARFROMWSRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC observacionesCTCREARFROMWSpContratoC = request.getObservacionesCTCREARFROMWSpContratoCInstance();
        ObservacionesC observacionesCTCREARFROMWSpObservacionesC = request.getObservacionesCTCREARFROMWSpObservacionesCInstance();

        request.checkArguments();
        ObservacionesC instance;

        com.keralty.aesolicitudes.viewmodel.observacionesc.siu.CrearRequest step1Request = new com.keralty.aesolicitudes.viewmodel.observacionesc.siu.CrearRequest();
        step1Request.setObservacionesCcrearpagrContratoCInstance(observacionesCTCREARFROMWSpContratoC);
        step1Request.setObservacionesCcrearpatrCodTipoObservacion(observacionesCTCREARFROMWSpObservacionesC.getObservacionesCCodTipoObservacion());
        step1Request.setObservacionesCcrearpatrTipoObservacion(observacionesCTCREARFROMWSpObservacionesC.getObservacionesCTipoObservacion());
        step1Request.setObservacionesCcrearpatrObservacions(STDFunctions.leftSubstringFun(observacionesCTCREARFROMWSpObservacionesC.getObservacionesCObservacions(), Long.valueOf(99)));
        instance = (ObservacionesC) observacionesCSrv.crearImplementation(step1Request).getInstance();

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
        select.getOrderByPart().addItem(Constants.normalizePath(ObservacionesCConstants.CLASS_NAME, ObservacionesCConstants.ATTR_FIELD_OBSERVACIONESCIDENTIFICADOR, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildObservacionesCRelatedInstance(relatedInstanceJsonOid);
        }
        if (ObservacionesCConstants.ROLE_NAME_CONTRATOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildObservacionesCRelatedInstance4ContratoC(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildObservacionesCRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new ObservacionesC(mapper.readValue(relatedInstanceJsonOid, ObservacionesCOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildObservacionesCRelatedInstance4ContratoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ContratoC(mapper.readValue(relatedInstanceJsonOid, ContratoCOid.class)): ContratoC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ObservacionesCOid oid = new ObservacionesCOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ObservacionesCConstants.ATTR_FIELD_OBSERVACIONESCIDENTIFICADOR, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getObservacionesCIdentificador(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(ObservacionesCService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
