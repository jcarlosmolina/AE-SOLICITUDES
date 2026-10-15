package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.TipoDireccionConstants;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.Direccion;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;
import com.keralty.aesolicitudes.persistence.oid.DireccionOid;
import com.keralty.aesolicitudes.persistence.oid.TipoDireccionOid;
import com.keralty.aesolicitudes.persistence.TipoDireccion;
import com.keralty.aesolicitudes.repository.TipoDireccionJpaRepository;
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
public class TipoDireccionService extends AbstractService {

    TipoDireccionJpaRepository repository;

    TipoDireccionService tipoDireccionSrv;

    DireccionService direccionSrv;

    DireccionCService direccionCSrv;

    @Inject
    public TipoDireccionService(
            TipoDireccionService tipoDireccionSrv,
            DireccionService direccionSrv,
            DireccionCService direccionCSrv,
            TipoDireccionJpaRepository repository) {
        this.tipoDireccionSrv = tipoDireccionSrv;
        this.direccionSrv = direccionSrv;
        this.direccionCSrv = direccionCSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, TipoDireccionConstants.CLASS_NAME);
    }

    private List<TipoDireccion> solveTipoDireccionTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, TipoDireccionConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveTipoDireccionTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, TipoDireccionConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class TipoDireccion
     *
     * @return Population of class TipoDireccion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<TipoDireccion> get() {
        List<TipoDireccion> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class TipoDireccion
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class TipoDireccion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<TipoDireccion> instances = get(queryRequest);
        if(TipoDireccionConstants.DSICTIPODIRECCION.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICTipoDireccion())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class TipoDireccion that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class TipoDireccion matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<TipoDireccion> get(QueryRequest queryRequest) {
        return solveTipoDireccionTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveTipoDireccionTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveTipoDireccionTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveTipoDireccionTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveTipoDireccionTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of TipoDireccion by ID
     *
     * @param tipoDireccionCodigo Identification field tipoDireccionCodigo
     *
     * @return Instance of TipoDireccion
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public TipoDireccion getById(Long tipoDireccionCodigo) {
        return getByOID(new TipoDireccionOid(tipoDireccionCodigo));
    }
    
    /*
     * Returns an instance of TipoDireccion by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of TipoDireccion
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public TipoDireccion getByOID(TipoDireccionOid oid) {
        Optional<TipoDireccion> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of TipoDireccion by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of TipoDireccion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public TipoDireccion getByOIDWithHV(TipoDireccionOid oid) {
        Optional<TipoDireccion> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<TipoDireccion> getInstanceByOid(TipoDireccionOid oid) {
        return oid != null && oid.getTipoDireccionCodigo() != null
               ? repository.findById(oid.getTipoDireccionCodigo())
               : Optional.empty();
    }

    /*
     * Returns an instance of TipoDireccion by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of TipoDireccion
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public TipoDireccion getByJsonOid(String jsonOid) {
        TipoDireccionOid oid = new TipoDireccionOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of TipoDireccion related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of TipoDireccion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<TipoDireccion> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveTipoDireccionTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of TipoDireccion related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of TipoDireccion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<TipoDireccion> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of TipoDireccion
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of TipoDireccion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getTipoDireccionDynamic(TipoDireccionOid oid, String displaySetItems) {
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
    public String getSuppInfo(TipoDireccionOid oid, String dsName) {
        TipoDireccion instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(TipoDireccion instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (TipoDireccionConstants.DSICTIPODIRECCION.equals(dsName))
            return instance.buildICTipoDireccion();
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(TipoDireccion instance, String dsName) {
        if (TipoDireccionConstants.DSICTIPODIRECCION.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICTipoDireccion());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (TipoDireccionConstants.FILTER_NAME_IFTIPODIRECCIONRESIDENCIAL.equalsIgnoreCase(filterRequest.getName()))
            iFTipoDireccionResidencial(sql);
        if (TipoDireccionConstants.FILTER_NAME_IFTIPODIRECCIONCODIGO.equalsIgnoreCase(filterRequest.getName()))
            iFTipoDireccionCodigo(filterRequest, sql);
        if (TipoDireccionConstants.FILTER_NAME_IFTIPODIRECCIONCORRESPONDENCI.equalsIgnoreCase(filterRequest.getName()))
            iFTipoDireccionCorrespondenci(sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_TipoDireccion".equals(filterRequest.getName()))
            suppInfo4ICTipoDireccion(filterRequest.getFilterVariable("searchText").toString(), sql);
    }


    private void iFTipoDireccionResidencial(SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();

        // EsResidencia = true
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(TipoDireccionConstants.ATTR_NAME_TIPODIRECCIONESRESIDENCIA, Constants.Type.BOOL.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison1);


        sql.addConjunction(conjunction);
    }

    private void iFTipoDireccionCodigo(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vCodigo = filterRequest.hasFilterVariable(TipoDireccionConstants.VAR_NAME_IFTIPODIRECCIONCODIGO_VCODIGO) ? (Long) filterRequest.getFilterVariable(TipoDireccionConstants.VAR_NAME_IFTIPODIRECCIONCODIGO_VCODIGO, FilterVariableRequest.INT) : null;

        // Codigo = vCodigo
        if (vCodigo != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(TipoDireccionConstants.ATTR_NAME_TIPODIRECCIONCODIGO, Constants.Type.INT.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vCodigo, Constants.Type.INT.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    private void iFTipoDireccionCorrespondenci(SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();

        // EsCorrespondencia = true
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(TipoDireccionConstants.ATTR_NAME_TIPODIRECCIONESCORRESPONDENCIA, Constants.Type.BOOL.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison1);


        sql.addConjunction(conjunction);
    }

    // IIU Methods


    /*
     * Solves the query needed for PIUTipoDireccion
     *
     * @param queryRequest Query request
     * @return List of viewmodels for TipoDireccion using displayset AutoDS that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aesolicitudes.viewmodel.tipodireccion.ds.AutoDS> piuPIUTipoDireccion(QueryRequest queryRequest) {
        return solveTipoDireccionTypedQuery(queryRequest).stream()
                .map(com.keralty.aesolicitudes.viewmodel.tipodireccion.ds.AutoDS::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUTipoDireccion
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUTipoDireccion
     */
    public int getCount4PIUTipoDireccion(QueryRequest queryRequest) {
        return solveTipoDireccionTypedQuery(queryRequest).size();
    }

    // Service: InsTipoDireccion

    /*
     * Entry point for service InsTipoDireccion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insTipoDireccion(
            com.keralty.aesolicitudes.viewmodel.tipodireccion.siu.InsTipoDireccionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = tipoDireccionSrv.insTipoDireccionTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsTipoDireccion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insTipoDireccionTxn(
            com.keralty.aesolicitudes.viewmodel.tipodireccion.siu.InsTipoDireccionRequest request) throws ModelException {
        request.setTipoDireccionInsTipoDireccionpthisTipoDireccionInstance(tipoDireccionSrv.getByOIDWithHV(request.getTipoDireccionInsTipoDireccionpthisTipoDireccion()));
        request.setTipoDireccionInsTipoDireccionpevcDireccionInstance(direccionSrv.getByOIDWithHV(request.getTipoDireccionInsTipoDireccionpevcDireccion()));
        return tipoDireccionSrv.insTipoDireccionImplementation(request, true);
    }

    /*
     * Implements service InsTipoDireccion
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insTipoDireccionImplementation(
            com.keralty.aesolicitudes.viewmodel.tipodireccion.siu.InsTipoDireccionRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoDireccion tipoDireccionInsTipoDireccionpthisTipoDireccion = request.getTipoDireccionInsTipoDireccionpthisTipoDireccionInstance();
        Direccion tipoDireccionInsTipoDireccionpevcDireccion = request.getTipoDireccionInsTipoDireccionpevcDireccionInstance();

        request.checkArguments();
        TipoDireccion instance = tipoDireccionInsTipoDireccionpthisTipoDireccion;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.direccion.siu.InsTipoDireccionRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.direccion.siu.InsTipoDireccionRequest();
            relatedRequest.setDireccionInsTipoDireccionpthisDireccionInstance(tipoDireccionInsTipoDireccionpevcDireccion);
            relatedRequest.setDireccionInsTipoDireccionpevcTipoDireccionInstance(tipoDireccionInsTipoDireccionpthisTipoDireccion);
            direccionSrv.insTipoDireccionImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICTipoDireccion());

        return response;
    }

    // Service: DelTipoDireccion

    /*
     * Entry point for service DelTipoDireccion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delTipoDireccion(
            com.keralty.aesolicitudes.viewmodel.tipodireccion.siu.DelTipoDireccionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = tipoDireccionSrv.delTipoDireccionTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelTipoDireccion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delTipoDireccionTxn(
            com.keralty.aesolicitudes.viewmodel.tipodireccion.siu.DelTipoDireccionRequest request) throws ModelException {
        request.setTipoDireccionDelTipoDireccionpthisTipoDireccionInstance(tipoDireccionSrv.getByOIDWithHV(request.getTipoDireccionDelTipoDireccionpthisTipoDireccion()));
        request.setTipoDireccionDelTipoDireccionpevcDireccionInstance(direccionSrv.getByOIDWithHV(request.getTipoDireccionDelTipoDireccionpevcDireccion()));
        return tipoDireccionSrv.delTipoDireccionImplementation(request, true);
    }

    /*
     * Implements service DelTipoDireccion
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delTipoDireccionImplementation(
            com.keralty.aesolicitudes.viewmodel.tipodireccion.siu.DelTipoDireccionRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoDireccion tipoDireccionDelTipoDireccionpthisTipoDireccion = request.getTipoDireccionDelTipoDireccionpthisTipoDireccionInstance();
        Direccion tipoDireccionDelTipoDireccionpevcDireccion = request.getTipoDireccionDelTipoDireccionpevcDireccionInstance();

        request.checkArguments();
        TipoDireccion instance = tipoDireccionDelTipoDireccionpthisTipoDireccion;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.direccion.siu.DelTipoDireccionRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.direccion.siu.DelTipoDireccionRequest();
            relatedRequest.setDireccionDelTipoDireccionpthisDireccionInstance(tipoDireccionDelTipoDireccionpevcDireccion);
            relatedRequest.setDireccionDelTipoDireccionpevcTipoDireccionInstance(tipoDireccionDelTipoDireccionpthisTipoDireccion);
            direccionSrv.delTipoDireccionImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICTipoDireccion());

        return response;
    }

    // Service: InsTipoDireccionC

    /*
     * Entry point for service InsTipoDireccionC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insTipoDireccionC(
            com.keralty.aesolicitudes.viewmodel.tipodireccion.siu.InsTipoDireccionCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = tipoDireccionSrv.insTipoDireccionCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsTipoDireccionC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insTipoDireccionCTxn(
            com.keralty.aesolicitudes.viewmodel.tipodireccion.siu.InsTipoDireccionCRequest request) throws ModelException {
        request.setTipoDireccionInsTipoDireccionCpthisTipoDireccionInstance(tipoDireccionSrv.getByOIDWithHV(request.getTipoDireccionInsTipoDireccionCpthisTipoDireccion()));
        request.setTipoDireccionInsTipoDireccionCpevcDireccionCInstance(direccionCSrv.getByOIDWithHV(request.getTipoDireccionInsTipoDireccionCpevcDireccionC()));
        return tipoDireccionSrv.insTipoDireccionCImplementation(request, true);
    }

    /*
     * Implements service InsTipoDireccionC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insTipoDireccionCImplementation(
            com.keralty.aesolicitudes.viewmodel.tipodireccion.siu.InsTipoDireccionCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoDireccion tipoDireccionInsTipoDireccionCpthisTipoDireccion = request.getTipoDireccionInsTipoDireccionCpthisTipoDireccionInstance();
        DireccionC tipoDireccionInsTipoDireccionCpevcDireccionC = request.getTipoDireccionInsTipoDireccionCpevcDireccionCInstance();

        request.checkArguments();
        TipoDireccion instance = tipoDireccionInsTipoDireccionCpthisTipoDireccion;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsTipoDireccionCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsTipoDireccionCRequest();
            relatedRequest.setDireccionCInsTipoDireccionCpthisDireccionCInstance(tipoDireccionInsTipoDireccionCpevcDireccionC);
            relatedRequest.setDireccionCInsTipoDireccionCpevcTipoDireccionInstance(tipoDireccionInsTipoDireccionCpthisTipoDireccion);
            direccionCSrv.insTipoDireccionCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICTipoDireccion());

        return response;
    }

    // Service: DelTipoDireccionC

    /*
     * Entry point for service DelTipoDireccionC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delTipoDireccionC(
            com.keralty.aesolicitudes.viewmodel.tipodireccion.siu.DelTipoDireccionCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = tipoDireccionSrv.delTipoDireccionCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelTipoDireccionC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delTipoDireccionCTxn(
            com.keralty.aesolicitudes.viewmodel.tipodireccion.siu.DelTipoDireccionCRequest request) throws ModelException {
        request.setTipoDireccionDelTipoDireccionCpthisTipoDireccionInstance(tipoDireccionSrv.getByOIDWithHV(request.getTipoDireccionDelTipoDireccionCpthisTipoDireccion()));
        request.setTipoDireccionDelTipoDireccionCpevcDireccionCInstance(direccionCSrv.getByOIDWithHV(request.getTipoDireccionDelTipoDireccionCpevcDireccionC()));
        return tipoDireccionSrv.delTipoDireccionCImplementation(request, true);
    }

    /*
     * Implements service DelTipoDireccionC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delTipoDireccionCImplementation(
            com.keralty.aesolicitudes.viewmodel.tipodireccion.siu.DelTipoDireccionCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoDireccion tipoDireccionDelTipoDireccionCpthisTipoDireccion = request.getTipoDireccionDelTipoDireccionCpthisTipoDireccionInstance();
        DireccionC tipoDireccionDelTipoDireccionCpevcDireccionC = request.getTipoDireccionDelTipoDireccionCpevcDireccionCInstance();

        request.checkArguments();
        TipoDireccion instance = tipoDireccionDelTipoDireccionCpthisTipoDireccion;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelTipoDireccionCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelTipoDireccionCRequest();
            relatedRequest.setDireccionCDelTipoDireccionCpthisDireccionCInstance(tipoDireccionDelTipoDireccionCpevcDireccionC);
            relatedRequest.setDireccionCDelTipoDireccionCpevcTipoDireccionInstance(tipoDireccionDelTipoDireccionCpthisTipoDireccion);
            direccionCSrv.delTipoDireccionCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICTipoDireccion());

        return response;
    }


    private void suppInfo4ICTipoDireccion(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(TipoDireccionConstants.ATTR_NAME_TIPODIRECCIONDESCRIPCION, Constants.Type.STRING.getTypeName()));
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
        applyOCOCTipoDireccion(queryRequest, select);
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(TipoDireccionConstants.CLASS_NAME, TipoDireccionConstants.ATTR_FIELD_TIPODIRECCIONCODIGO, false), true);
    }


    private void applyOCOCTipoDireccion(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_TipoDireccion".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(TipoDireccionConstants.CLASS_NAME, TipoDireccionConstants.ATTR_NAME_TIPODIRECCIONDESCRIPCION, false), true);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildTipoDireccionRelatedInstance(relatedInstanceJsonOid);
        }
        if (TipoDireccionConstants.ROLE_NAME_DIRECCIONESC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTipoDireccionRelatedInstance4DireccionC(relatedInstanceJsonOid, remainingPath);
        }
        if (TipoDireccionConstants.ROLE_NAME_DIRECCIONES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTipoDireccionRelatedInstance4Direccion(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildTipoDireccionRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new TipoDireccion(mapper.readValue(relatedInstanceJsonOid, TipoDireccionOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildTipoDireccionRelatedInstance4DireccionC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new DireccionC(mapper.readValue(relatedInstanceJsonOid, DireccionCOid.class)): DireccionC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildTipoDireccionRelatedInstance4Direccion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Direccion(mapper.readValue(relatedInstanceJsonOid, DireccionOid.class)): Direccion.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            TipoDireccionOid oid = new TipoDireccionOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(TipoDireccionConstants.ATTR_FIELD_TIPODIRECCIONCODIGO, Constants.Type.INT.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getTipoDireccionCodigo(), Constants.Type.INT.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(TipoDireccionService.class).error(e.getMessage());
        }
    }

}
