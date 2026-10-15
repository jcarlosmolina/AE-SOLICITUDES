package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.TipoEntidadCConstants;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoEntidadCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.TipoEntidadC;
import com.keralty.aesolicitudes.repository.TipoEntidadCJpaRepository;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLWhereComparison;
import com.keralty.aesolicitudes.sqlutils.SQLWhereConjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereDisjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;
import com.keralty.aesolicitudes.viewmodel.FilterVariableRequest;
import com.keralty.aesolicitudes.viewmodel.InstanceResponseViewModel;
import com.keralty.aesolicitudes.viewmodel.PopulationResponseViewModel;
import com.keralty.aesolicitudes.viewmodel.PreloadResponseViewModel;
import com.keralty.aesolicitudes.viewmodel.PreloadViewModel;
import com.keralty.aesolicitudes.viewmodel.QueryRequest;
import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class TipoEntidadCService extends AbstractService {

    TipoEntidadCJpaRepository repository;

    TipoEntidadCService tipoEntidadCSrv;

    PersonaCService personaCSrv;

    @Inject
    public TipoEntidadCService(
            TipoEntidadCService tipoEntidadCSrv,
            PersonaCService personaCSrv,
            TipoEntidadCJpaRepository repository) {
        this.tipoEntidadCSrv = tipoEntidadCSrv;
        this.personaCSrv = personaCSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, TipoEntidadCConstants.CLASS_NAME);
    }

    private List<TipoEntidadC> solveTipoEntidadCTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, TipoEntidadCConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveTipoEntidadCTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, TipoEntidadCConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class TipoEntidadC
     *
     * @return Population of class TipoEntidadC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<TipoEntidadC> get() {
        List<TipoEntidadC> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class TipoEntidadC
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class TipoEntidadC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<TipoEntidadC> instances = get(queryRequest);
        if(TipoEntidadCConstants.DSICTIPOENTIDAD.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICTipoEntidad())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class TipoEntidadC that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class TipoEntidadC matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<TipoEntidadC> get(QueryRequest queryRequest) {
        return solveTipoEntidadCTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveTipoEntidadCTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveTipoEntidadCTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveTipoEntidadCTypedQuery(queryRequest).stream()
                    .map(instance -> buildPreloadViewModel(instance, queryRequest.getDisplaySetName()))
                    .collect(Collectors.toList()));
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
        return new PopulationResponseViewModel(solveTipoEntidadCTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of TipoEntidadC by ID
     *
     * @param tipoEntidadCCodigo Identification field tipoEntidadCCodigo
     *
     * @return Instance of TipoEntidadC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public TipoEntidadC getById(Long tipoEntidadCCodigo) {
        return getByOID(new TipoEntidadCOid(tipoEntidadCCodigo));
    }
    
    /*
     * Returns an instance of TipoEntidadC by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of TipoEntidadC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public TipoEntidadC getByOID(TipoEntidadCOid oid) {
        Optional<TipoEntidadC> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of TipoEntidadC by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of TipoEntidadC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public TipoEntidadC getByOIDWithHV(TipoEntidadCOid oid) {
        Optional<TipoEntidadC> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<TipoEntidadC> getInstanceByOid(TipoEntidadCOid oid) {
        return oid != null && oid.getTipoEntidadCCodigo() != null
               ? repository.findById(oid.getTipoEntidadCCodigo())
               : Optional.empty();
    }

    /*
     * Returns an instance of TipoEntidadC by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of TipoEntidadC
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public TipoEntidadC getByJsonOid(String jsonOid) {
        TipoEntidadCOid oid = new TipoEntidadCOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of TipoEntidadC related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of TipoEntidadC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<TipoEntidadC> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveTipoEntidadCTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of TipoEntidadC related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of TipoEntidadC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<TipoEntidadC> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of TipoEntidadC
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of TipoEntidadC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getTipoEntidadCDynamic(TipoEntidadCOid oid, String displaySetItems) {
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
    public String getSuppInfo(TipoEntidadCOid oid, String dsName) {
        TipoEntidadC instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(TipoEntidadC instance, String dsName) {
        if (TipoEntidadCConstants.DSICTIPOENTIDAD.equals(dsName))
            return instance.buildICTipoEntidad();
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(TipoEntidadC instance, String dsName) {
        if (TipoEntidadCConstants.DSICTIPOENTIDAD.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICTipoEntidad());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_TipoEntidad".equals(filterRequest.getName()))
            suppInfo4ICTipoEntidad(filterRequest.getFilterVariable("searchText").toString(), sql);
    }



    // IIU Methods


    /*
     * Solves the query needed for PIUTipoEntidad
     *
     * @param queryRequest Query request
     * @return List of viewmodels for TipoEntidadC using displayset AutoDS that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aesolicitudes.viewmodel.tipoentidadc.ds.AutoDS> piuPIUTipoEntidad(QueryRequest queryRequest) {
        return solveTipoEntidadCTypedQuery(queryRequest).stream()
                .map(com.keralty.aesolicitudes.viewmodel.tipoentidadc.ds.AutoDS::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUTipoEntidad
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUTipoEntidad
     */
    public int getCount4PIUTipoEntidad(QueryRequest queryRequest) {
        return solveTipoEntidadCTypedQuery(queryRequest).size();
    }

    // Service: InsTipoEntidadCPersonaC

    /*
     * Entry point for service InsTipoEntidadCPersonaC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insTipoEntidadCPersonaC(
            com.keralty.aesolicitudes.viewmodel.tipoentidadc.siu.InsTipoEntidadCPersonaCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = tipoEntidadCSrv.insTipoEntidadCPersonaCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsTipoEntidadCPersonaC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insTipoEntidadCPersonaCTxn(
            com.keralty.aesolicitudes.viewmodel.tipoentidadc.siu.InsTipoEntidadCPersonaCRequest request) throws ModelException {
        request.setTipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadCInstance(tipoEntidadCSrv.getByOIDWithHV(request.getTipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadC()));
        request.setTipoEntidadCInsTipoEntidadCPersonaCpevcPersonaCInstance(personaCSrv.getByOIDWithHV(request.getTipoEntidadCInsTipoEntidadCPersonaCpevcPersonaC()));
        return tipoEntidadCSrv.insTipoEntidadCPersonaCImplementation(request, true);
    }

    /*
     * Implements service InsTipoEntidadCPersonaC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insTipoEntidadCPersonaCImplementation(
            com.keralty.aesolicitudes.viewmodel.tipoentidadc.siu.InsTipoEntidadCPersonaCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoEntidadC tipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadC = request.getTipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadCInstance();
        PersonaC tipoEntidadCInsTipoEntidadCPersonaCpevcPersonaC = request.getTipoEntidadCInsTipoEntidadCPersonaCpevcPersonaCInstance();

        request.checkArguments();
        TipoEntidadC instance = tipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadC;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsTipoEntidadCPersonaCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.personac.siu.InsTipoEntidadCPersonaCRequest();
            relatedRequest.setPersonaCInsTipoEntidadCPersonaCpthisPersonaCInstance(tipoEntidadCInsTipoEntidadCPersonaCpevcPersonaC);
            relatedRequest.setPersonaCInsTipoEntidadCPersonaCpevcTipoEntidadCInstance(tipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadC);
            personaCSrv.insTipoEntidadCPersonaCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICTipoEntidad());

        return response;
    }

    // Service: DelTipoEntidadCPersonaC

    /*
     * Entry point for service DelTipoEntidadCPersonaC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delTipoEntidadCPersonaC(
            com.keralty.aesolicitudes.viewmodel.tipoentidadc.siu.DelTipoEntidadCPersonaCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = tipoEntidadCSrv.delTipoEntidadCPersonaCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelTipoEntidadCPersonaC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delTipoEntidadCPersonaCTxn(
            com.keralty.aesolicitudes.viewmodel.tipoentidadc.siu.DelTipoEntidadCPersonaCRequest request) throws ModelException {
        request.setTipoEntidadCDelTipoEntidadCPersonaCpthisTipoEntidadCInstance(tipoEntidadCSrv.getByOIDWithHV(request.getTipoEntidadCDelTipoEntidadCPersonaCpthisTipoEntidadC()));
        request.setTipoEntidadCDelTipoEntidadCPersonaCpevcPersonaCInstance(personaCSrv.getByOIDWithHV(request.getTipoEntidadCDelTipoEntidadCPersonaCpevcPersonaC()));
        return tipoEntidadCSrv.delTipoEntidadCPersonaCImplementation(request, true);
    }

    /*
     * Implements service DelTipoEntidadCPersonaC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delTipoEntidadCPersonaCImplementation(
            com.keralty.aesolicitudes.viewmodel.tipoentidadc.siu.DelTipoEntidadCPersonaCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoEntidadC tipoEntidadCDelTipoEntidadCPersonaCpthisTipoEntidadC = request.getTipoEntidadCDelTipoEntidadCPersonaCpthisTipoEntidadCInstance();
        PersonaC tipoEntidadCDelTipoEntidadCPersonaCpevcPersonaC = request.getTipoEntidadCDelTipoEntidadCPersonaCpevcPersonaCInstance();

        request.checkArguments();
        TipoEntidadC instance = tipoEntidadCDelTipoEntidadCPersonaCpthisTipoEntidadC;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelTipoEntidadCPersonaCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.personac.siu.DelTipoEntidadCPersonaCRequest();
            relatedRequest.setPersonaCDelTipoEntidadCPersonaCpthisPersonaCInstance(tipoEntidadCDelTipoEntidadCPersonaCpevcPersonaC);
            relatedRequest.setPersonaCDelTipoEntidadCPersonaCpevcTipoEntidadCInstance(tipoEntidadCDelTipoEntidadCPersonaCpthisTipoEntidadC);
            personaCSrv.delTipoEntidadCPersonaCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICTipoEntidad());

        return response;
    }


    private void suppInfo4ICTipoEntidad(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(TipoEntidadCConstants.ATTR_NAME_TIPOENTIDADCDESCRIPCION, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison1);

            SQLWhereConjunction conjunction = new SQLWhereConjunction();
            conjunction.addDisjunction(disjunction);
            select.addConjunction(conjunction);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
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
        select.getOrderByPart().addItem(Constants.normalizePath(TipoEntidadCConstants.CLASS_NAME, TipoEntidadCConstants.ATTR_FIELD_TIPOENTIDADCCODIGO, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildTipoEntidadCRelatedInstance(relatedInstanceJsonOid);
        }
        if (TipoEntidadCConstants.ROLE_NAME_PERSONASC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTipoEntidadCRelatedInstance4PersonaC(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildTipoEntidadCRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new TipoEntidadC(mapper.readValue(relatedInstanceJsonOid, TipoEntidadCOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildTipoEntidadCRelatedInstance4PersonaC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new PersonaC(mapper.readValue(relatedInstanceJsonOid, PersonaCOid.class)): PersonaC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            TipoEntidadCOid oid = new TipoEntidadCOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(TipoEntidadCConstants.ATTR_FIELD_TIPOENTIDADCCODIGO, Constants.Type.INT.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getTipoEntidadCCodigo(), Constants.Type.INT.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(TipoEntidadCService.class).error(e.getMessage());
        }
    }

}
