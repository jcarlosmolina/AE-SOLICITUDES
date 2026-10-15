package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.RegionalConstants;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.RegionalOid;
import com.keralty.aesolicitudes.persistence.oid.RespRegionalOid;
import com.keralty.aesolicitudes.persistence.oid.SucursalOid;
import com.keralty.aesolicitudes.persistence.Regional;
import com.keralty.aesolicitudes.persistence.RespRegional;
import com.keralty.aesolicitudes.persistence.Sucursal;
import com.keralty.aesolicitudes.repository.RegionalJpaRepository;
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
public class RegionalService extends AbstractService {

    RegionalJpaRepository repository;

    RegionalService regionalSrv;

    DirSucursalCService dirSucursalCSrv;

    SucursalService sucursalSrv;

    @Inject
    public RegionalService(
            RegionalService regionalSrv,
            DirSucursalCService dirSucursalCSrv,
            SucursalService sucursalSrv,
            RegionalJpaRepository repository) {
        this.regionalSrv = regionalSrv;
        this.dirSucursalCSrv = dirSucursalCSrv;
        this.sucursalSrv = sucursalSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, RegionalConstants.CLASS_NAME);
    }

    private List<Regional> solveRegionalTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, RegionalConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveRegionalTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, RegionalConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class Regional
     *
     * @return Population of class Regional
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Regional> get() {
        List<Regional> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class Regional
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class Regional
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<Regional> instances = get(queryRequest);
        if(RegionalConstants.DSICREGIONAL.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICRegional())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class Regional that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class Regional matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Regional> get(QueryRequest queryRequest) {
        return solveRegionalTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveRegionalTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveRegionalTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveRegionalTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveRegionalTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of Regional by ID
     *
     * @param regionalCodigo Identification field regionalCodigo
     *
     * @return Instance of Regional
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Regional getById(Long regionalCodigo) {
        return getByOID(new RegionalOid(regionalCodigo));
    }
    
    /*
     * Returns an instance of Regional by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Regional
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Regional getByOID(RegionalOid oid) {
        Optional<Regional> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Regional by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Regional
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Regional getByOIDWithHV(RegionalOid oid) {
        Optional<Regional> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Regional> getInstanceByOid(RegionalOid oid) {
        return oid != null && oid.getRegionalCodigo() != null
               ? repository.findById(oid.getRegionalCodigo())
               : Optional.empty();
    }

    /*
     * Returns an instance of Regional by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Regional
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Regional getByJsonOid(String jsonOid) {
        RegionalOid oid = new RegionalOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of Regional related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Regional
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Regional> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveRegionalTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of Regional related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Regional
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Regional> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of Regional
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of Regional
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getRegionalDynamic(RegionalOid oid, String displaySetItems) {
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
    public String getSuppInfo(RegionalOid oid, String dsName) {
        Regional instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(Regional instance, String dsName) {
        if (RegionalConstants.DSICREGIONAL.equals(dsName))
            return instance.buildICRegional();
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(Regional instance, String dsName) {
        if (RegionalConstants.DSICREGIONAL.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICRegional());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_Regional".equals(filterRequest.getName()))
            suppInfo4ICRegional(filterRequest.getFilterVariable("searchText").toString(), sql);
    }



    // IIU Methods


    /*
     * Solves the query needed for PIURegional
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Regional using displayset AutoDS that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aesolicitudes.viewmodel.regional.ds.AutoDS> piuPIURegional(QueryRequest queryRequest) {
        return solveRegionalTypedQuery(queryRequest).stream()
                .map(com.keralty.aesolicitudes.viewmodel.regional.ds.AutoDS::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIURegional
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIURegional
     */
    public int getCount4PIURegional(QueryRequest queryRequest) {
        return solveRegionalTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIURegionalObs
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Regional using displayset AutoDS that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aesolicitudes.viewmodel.regional.ds.AutoDS> piuPIURegionalObs(QueryRequest queryRequest) {
        return solveRegionalTypedQuery(queryRequest).stream()
                .map(com.keralty.aesolicitudes.viewmodel.regional.ds.AutoDS::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIURegionalObs
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIURegionalObs
     */
    public int getCount4PIURegionalObs(QueryRequest queryRequest) {
        return solveRegionalTypedQuery(queryRequest).size();
    }

    // Service: InsRegionalDirSucursal

    /*
     * Entry point for service InsRegionalDirSucursal
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insRegionalDirSucursal(
            com.keralty.aesolicitudes.viewmodel.regional.siu.InsRegionalDirSucursalRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = regionalSrv.insRegionalDirSucursalTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsRegionalDirSucursal
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insRegionalDirSucursalTxn(
            com.keralty.aesolicitudes.viewmodel.regional.siu.InsRegionalDirSucursalRequest request) throws ModelException {
        request.setRegionalInsRegionalDirSucursalpthisRegionalInstance(regionalSrv.getByOIDWithHV(request.getRegionalInsRegionalDirSucursalpthisRegional()));
        request.setRegionalInsRegionalDirSucursalpevcDirSucursalCInstance(dirSucursalCSrv.getByOIDWithHV(request.getRegionalInsRegionalDirSucursalpevcDirSucursalC()));
        return regionalSrv.insRegionalDirSucursalImplementation(request, true);
    }

    /*
     * Implements service InsRegionalDirSucursal
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insRegionalDirSucursalImplementation(
            com.keralty.aesolicitudes.viewmodel.regional.siu.InsRegionalDirSucursalRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Regional regionalInsRegionalDirSucursalpthisRegional = request.getRegionalInsRegionalDirSucursalpthisRegionalInstance();
        DirSucursalC regionalInsRegionalDirSucursalpevcDirSucursalC = request.getRegionalInsRegionalDirSucursalpevcDirSucursalCInstance();

        request.checkArguments();
        Regional instance = regionalInsRegionalDirSucursalpthisRegional;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsRegionalDirSucursalRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsRegionalDirSucursalRequest();
            relatedRequest.setDirSucursalCInsRegionalDirSucursalpthisDirSucursalCInstance(regionalInsRegionalDirSucursalpevcDirSucursalC);
            relatedRequest.setDirSucursalCInsRegionalDirSucursalpevcRegionalInstance(regionalInsRegionalDirSucursalpthisRegional);
            dirSucursalCSrv.insRegionalDirSucursalImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICRegional());

        return response;
    }

    // Service: DelRegionalDirSucursal

    /*
     * Entry point for service DelRegionalDirSucursal
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delRegionalDirSucursal(
            com.keralty.aesolicitudes.viewmodel.regional.siu.DelRegionalDirSucursalRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = regionalSrv.delRegionalDirSucursalTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelRegionalDirSucursal
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delRegionalDirSucursalTxn(
            com.keralty.aesolicitudes.viewmodel.regional.siu.DelRegionalDirSucursalRequest request) throws ModelException {
        request.setRegionalDelRegionalDirSucursalpthisRegionalInstance(regionalSrv.getByOIDWithHV(request.getRegionalDelRegionalDirSucursalpthisRegional()));
        request.setRegionalDelRegionalDirSucursalpevcDirSucursalCInstance(dirSucursalCSrv.getByOIDWithHV(request.getRegionalDelRegionalDirSucursalpevcDirSucursalC()));
        return regionalSrv.delRegionalDirSucursalImplementation(request, true);
    }

    /*
     * Implements service DelRegionalDirSucursal
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delRegionalDirSucursalImplementation(
            com.keralty.aesolicitudes.viewmodel.regional.siu.DelRegionalDirSucursalRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Regional regionalDelRegionalDirSucursalpthisRegional = request.getRegionalDelRegionalDirSucursalpthisRegionalInstance();
        DirSucursalC regionalDelRegionalDirSucursalpevcDirSucursalC = request.getRegionalDelRegionalDirSucursalpevcDirSucursalCInstance();

        request.checkArguments();
        Regional instance = regionalDelRegionalDirSucursalpthisRegional;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelRegionalDirSucursalRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelRegionalDirSucursalRequest();
            relatedRequest.setDirSucursalCDelRegionalDirSucursalpthisDirSucursalCInstance(regionalDelRegionalDirSucursalpevcDirSucursalC);
            relatedRequest.setDirSucursalCDelRegionalDirSucursalpevcRegionalInstance(regionalDelRegionalDirSucursalpthisRegional);
            dirSucursalCSrv.delRegionalDirSucursalImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICRegional());

        return response;
    }


    private void suppInfo4ICRegional(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(RegionalConstants.ATTR_NAME_REGIONALDESCRIPCION, Constants.Type.STRING.getTypeName()));
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
        applyOCOCRegional(queryRequest, select);
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(RegionalConstants.CLASS_NAME, RegionalConstants.ATTR_FIELD_REGIONALCODIGO, false), true);
    }


    private void applyOCOCRegional(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_Regional".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(RegionalConstants.CLASS_NAME, RegionalConstants.ATTR_NAME_REGIONALDESCRIPCION, false), true);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildRegionalRelatedInstance(relatedInstanceJsonOid);
        }
        if (RegionalConstants.ROLE_NAME_RESPREGIONAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildRegionalRelatedInstance4RespRegional(relatedInstanceJsonOid, remainingPath);
        }
        if (RegionalConstants.ROLE_NAME_SUCURSALES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildRegionalRelatedInstance4Sucursal(relatedInstanceJsonOid, remainingPath);
        }
        if (RegionalConstants.ROLE_NAME_DIRSUCURSALC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildRegionalRelatedInstance4DirSucursalC(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildRegionalRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new Regional(mapper.readValue(relatedInstanceJsonOid, RegionalOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildRegionalRelatedInstance4RespRegional(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new RespRegional(mapper.readValue(relatedInstanceJsonOid, RespRegionalOid.class)): RespRegional.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildRegionalRelatedInstance4Sucursal(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Sucursal(mapper.readValue(relatedInstanceJsonOid, SucursalOid.class)): Sucursal.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildRegionalRelatedInstance4DirSucursalC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new DirSucursalC(mapper.readValue(relatedInstanceJsonOid, DirSucursalCOid.class)): DirSucursalC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            RegionalOid oid = new RegionalOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(RegionalConstants.ATTR_FIELD_REGIONALCODIGO, Constants.Type.INT.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getRegionalCodigo(), Constants.Type.INT.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(RegionalService.class).error(e.getMessage());
        }
    }

}
