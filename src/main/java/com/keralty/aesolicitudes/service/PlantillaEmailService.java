package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.PlantillaEmailConstants;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.Dominio;
import com.keralty.aesolicitudes.persistence.oid.DominioOid;
import com.keralty.aesolicitudes.persistence.oid.PlantillaEmailOid;
import com.keralty.aesolicitudes.persistence.PlantillaEmail;
import com.keralty.aesolicitudes.repository.PlantillaEmailJpaRepository;
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
public class PlantillaEmailService extends AbstractService {

    PlantillaEmailJpaRepository repository;

    PlantillaEmailService plantillaEmailSrv;

    DominioService dominioSrv;

    @Inject
    public PlantillaEmailService(
            PlantillaEmailService plantillaEmailSrv,
            DominioService dominioSrv,
            PlantillaEmailJpaRepository repository) {
        this.plantillaEmailSrv = plantillaEmailSrv;
        this.dominioSrv = dominioSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, PlantillaEmailConstants.CLASS_NAME);
    }

    private List<PlantillaEmail> solvePlantillaEmailTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, PlantillaEmailConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solvePlantillaEmailTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, PlantillaEmailConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class PlantillaEmail
     *
     * @return Population of class PlantillaEmail
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PlantillaEmail> get() {
        List<PlantillaEmail> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class PlantillaEmail
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class PlantillaEmail
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<PlantillaEmail> instances = get(queryRequest);
        if(PlantillaEmailConstants.DSICPLANTILLAEMAIL.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICPlantillaEmail())).collect(Collectors.toList());
        }
        if(PlantillaEmailConstants.DSDSPLANTILLASDOMINIO.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSPlantillasDominio())).collect(Collectors.toList());
        }
        if(PlantillaEmailConstants.DSDSPLANTILLAEMAIL.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSPlantillaEmail())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class PlantillaEmail that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class PlantillaEmail matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PlantillaEmail> get(QueryRequest queryRequest) {
        return solvePlantillaEmailTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solvePlantillaEmailTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solvePlantillaEmailTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solvePlantillaEmailTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solvePlantillaEmailTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of PlantillaEmail by ID
     *
     * @param plantillaEmailIdPlantilla Identification field plantillaEmailIdPlantilla
     *
     * @return Instance of PlantillaEmail
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public PlantillaEmail getById(Long plantillaEmailIdPlantilla) {
        return getByOID(new PlantillaEmailOid(plantillaEmailIdPlantilla));
    }
    
    /*
     * Returns an instance of PlantillaEmail by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of PlantillaEmail
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public PlantillaEmail getByOID(PlantillaEmailOid oid) {
        Optional<PlantillaEmail> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of PlantillaEmail by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of PlantillaEmail
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public PlantillaEmail getByOIDWithHV(PlantillaEmailOid oid) {
        Optional<PlantillaEmail> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<PlantillaEmail> getInstanceByOid(PlantillaEmailOid oid) {
        return oid != null && oid.getPlantillaEmailIdPlantilla() != null
               ? repository.findById(oid.getPlantillaEmailIdPlantilla())
               : Optional.empty();
    }

    /*
     * Returns an instance of PlantillaEmail by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of PlantillaEmail
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public PlantillaEmail getByJsonOid(String jsonOid) {
        PlantillaEmailOid oid = new PlantillaEmailOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of PlantillaEmail related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of PlantillaEmail
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PlantillaEmail> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solvePlantillaEmailTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of PlantillaEmail related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of PlantillaEmail
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PlantillaEmail> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of PlantillaEmail
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of PlantillaEmail
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getPlantillaEmailDynamic(PlantillaEmailOid oid, String displaySetItems) {
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
    public String getSuppInfo(PlantillaEmailOid oid, String dsName) {
        PlantillaEmail instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(PlantillaEmail instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (PlantillaEmailConstants.DSICPLANTILLAEMAIL.equals(dsName))
            return instance.buildICPlantillaEmail();
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(PlantillaEmail instance, String dsName) {
        if (PlantillaEmailConstants.DSICPLANTILLAEMAIL.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICPlantillaEmail());
        if (PlantillaEmailConstants.DSDSPLANTILLASDOMINIO.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSPlantillasDominio());
        if (PlantillaEmailConstants.DSDSPLANTILLAEMAIL.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSPlantillaEmail());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (PlantillaEmailConstants.FILTER_NAME_IFPLANTILLAEMAILCODIGO.equalsIgnoreCase(filterRequest.getName()))
            iFPlantillaEmailCodigo(filterRequest, sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_PlantillaEmail".equals(filterRequest.getName()))
            suppInfo4ICPlantillaEmail(filterRequest.getFilterVariable("searchText").toString(), sql);
    }


    private void iFPlantillaEmailCodigo(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vCodigo = filterRequest.hasFilterVariable(PlantillaEmailConstants.VAR_NAME_IFPLANTILLAEMAILCODIGO_VCODIGO) ? (Long) filterRequest.getFilterVariable(PlantillaEmailConstants.VAR_NAME_IFPLANTILLAEMAILCODIGO_VCODIGO, FilterVariableRequest.NAT) : null;

        // Codigo = vCodigo
        if (vCodigo != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(PlantillaEmailConstants.ATTR_NAME_PLANTILLAEMAILCODIGO, Constants.Type.NAT.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vCodigo, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    // IIU Methods


    /*
     * Solves the query needed for PIUPlantillaEmail
     *
     * @param queryRequest Query request
     * @return List of viewmodels for PlantillaEmail using displayset DSPlantillaEmail that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aesolicitudes.viewmodel.plantillaemail.ds.DSPlantillaEmail> piuPIUPlantillaEmail(QueryRequest queryRequest) {
        return solvePlantillaEmailTypedQuery(queryRequest).stream()
                .map(com.keralty.aesolicitudes.viewmodel.plantillaemail.ds.DSPlantillaEmail::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUPlantillaEmail
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUPlantillaEmail
     */
    public int getCount4PIUPlantillaEmail(QueryRequest queryRequest) {
        return solvePlantillaEmailTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUPlantillasDominio
     *
     * @param queryRequest Query request
     * @return List of viewmodels for PlantillaEmail using displayset DSPlantillasDominio that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aesolicitudes.viewmodel.plantillaemail.ds.DSPlantillasDominio> piuPIUPlantillasDominio(QueryRequest queryRequest) {
        return solvePlantillaEmailTypedQuery(queryRequest).stream()
                .map(com.keralty.aesolicitudes.viewmodel.plantillaemail.ds.DSPlantillasDominio::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUPlantillasDominio
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUPlantillasDominio
     */
    public int getCount4PIUPlantillasDominio(QueryRequest queryRequest) {
        return solvePlantillaEmailTypedQuery(queryRequest).size();
    }

    // Service: getDummy

    /*
     * Entry point for service getDummy
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aesolicitudes.viewmodel.plantillaemail.siu.GetDummyResponse getDummy(
            com.keralty.aesolicitudes.viewmodel.plantillaemail.siu.GetDummyRequest request) {
        com.keralty.aesolicitudes.viewmodel.plantillaemail.siu.GetDummyResponse response = new com.keralty.aesolicitudes.viewmodel.plantillaemail.siu.GetDummyResponse();
        try {
            response = plantillaEmailSrv.getDummyTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service getDummy
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aesolicitudes.viewmodel.plantillaemail.siu.GetDummyResponse getDummyTxn(
            com.keralty.aesolicitudes.viewmodel.plantillaemail.siu.GetDummyRequest request) throws ModelException {
        request.setPlantillaEmailgetDummypthisPlantillaEmailInstance(plantillaEmailSrv.getByOIDWithHV(request.getPlantillaEmailgetDummypthisPlantillaEmail()));
        return plantillaEmailSrv.getDummyImplementation(request);
    }

    /*
     * Implements service getDummy
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aesolicitudes.viewmodel.plantillaemail.siu.GetDummyResponse getDummyImplementation(
            com.keralty.aesolicitudes.viewmodel.plantillaemail.siu.GetDummyRequest request) throws ModelException {
        com.keralty.aesolicitudes.viewmodel.plantillaemail.siu.GetDummyResponse response = new com.keralty.aesolicitudes.viewmodel.plantillaemail.siu.GetDummyResponse();
        PlantillaEmail plantillaEmailgetDummypthisPlantillaEmail = request.getPlantillaEmailgetDummypthisPlantillaEmailInstance();

        request.checkArguments();
        PlantillaEmail instance = plantillaEmailgetDummypthisPlantillaEmail;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICPlantillaEmail());

        // Value expressions for outgoing argument 'plantillaEmailgetDummyoaPlantillaEmail'
        // DEFAULT  : THIS
        response.setPlantillaEmailgetDummyoaPlantillaEmailInstance(plantillaEmailgetDummypthisPlantillaEmail);


        return response;
    }


    private void suppInfo4ICPlantillaEmail(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(PlantillaEmailConstants.ATTR_NAME_PLANTILLAEMAILDESCRIPCION, Constants.Type.STRING.getTypeName()));
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
        select.getOrderByPart().addItem(Constants.normalizePath(PlantillaEmailConstants.CLASS_NAME, PlantillaEmailConstants.ATTR_FIELD_PLANTILLAEMAILIDPLANTILLA, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildPlantillaEmailRelatedInstance(relatedInstanceJsonOid);
        }
        if (PlantillaEmailConstants.ROLE_NAME_DOMINIOS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPlantillaEmailRelatedInstance4Dominio(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildPlantillaEmailRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new PlantillaEmail(mapper.readValue(relatedInstanceJsonOid, PlantillaEmailOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPlantillaEmailRelatedInstance4Dominio(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Dominio(mapper.readValue(relatedInstanceJsonOid, DominioOid.class)): Dominio.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            PlantillaEmailOid oid = new PlantillaEmailOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(PlantillaEmailConstants.ATTR_FIELD_PLANTILLAEMAILIDPLANTILLA, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getPlantillaEmailIdPlantilla(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(PlantillaEmailService.class).error(e.getMessage());
        }
    }

}
