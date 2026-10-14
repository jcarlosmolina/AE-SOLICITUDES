package com.keralty.aesolicitudes.service;

import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.LogLlamadasBHConstants;
import com.keralty.aesolicitudes.persistence.LogLlamadasBH;
import com.keralty.aesolicitudes.persistence.oid.LogLlamadasBHOid;
import com.keralty.aesolicitudes.repository.LogLlamadasBHJpaRepository;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLWhereComparison;
import com.keralty.aesolicitudes.sqlutils.SQLWhereConjunction;
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
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class LogLlamadasBHService extends AbstractService {

    LogLlamadasBHJpaRepository repository;

    LogLlamadasBHService logLlamadasBHSrv;

    @Inject
    public LogLlamadasBHService(
            LogLlamadasBHService logLlamadasBHSrv,
            LogLlamadasBHJpaRepository repository) {
        this.logLlamadasBHSrv = logLlamadasBHSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, LogLlamadasBHConstants.CLASS_NAME);
    }

    private List<LogLlamadasBH> solveLogLlamadasBHTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, LogLlamadasBHConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveLogLlamadasBHTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, LogLlamadasBHConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class LogLlamadasBH
     *
     * @return Population of class LogLlamadasBH
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogLlamadasBH> get() {
        List<LogLlamadasBH> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    /*
     * Gets the properties of DisplaySet DSLogLlamadasBH for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSLogLlamadasBH for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aesolicitudes.viewmodel.logllamadasbh.ds.DSLogLlamadasBH getDSLogLlamadasBH(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        LogLlamadasBH instance = getByJsonOid(instanceOid);
        return new com.keralty.aesolicitudes.viewmodel.logllamadasbh.ds.DSLogLlamadasBH(instance);
    }

    /*
     * Gets the properties of DisplaySet DSLogLlamadasBHIIU for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSLogLlamadasBHIIU for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aesolicitudes.viewmodel.logllamadasbh.ds.DSLogLlamadasBHIIU getDSLogLlamadasBHIIU(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        LogLlamadasBH instance = getByJsonOid(instanceOid);
        return new com.keralty.aesolicitudes.viewmodel.logllamadasbh.ds.DSLogLlamadasBHIIU(instance);
    }

    /*
     * Returns the population of class LogLlamadasBH that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class LogLlamadasBH matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogLlamadasBH> get(QueryRequest queryRequest) {
        return solveLogLlamadasBHTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveLogLlamadasBHTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveLogLlamadasBHTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel();
        }
    }

    /*
     * Returns an instance of LogLlamadasBH by ID
     *
     * @param logLlamadasBHID Identification field logLlamadasBHID
     *
     * @return Instance of LogLlamadasBH
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public LogLlamadasBH getById(Long logLlamadasBHID) {
        return getByOID(new LogLlamadasBHOid(logLlamadasBHID));
    }
    
    /*
     * Returns an instance of LogLlamadasBH by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of LogLlamadasBH
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public LogLlamadasBH getByOID(LogLlamadasBHOid oid) {
        Optional<LogLlamadasBH> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of LogLlamadasBH by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of LogLlamadasBH
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public LogLlamadasBH getByOIDWithHV(LogLlamadasBHOid oid) {
        Optional<LogLlamadasBH> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<LogLlamadasBH> getInstanceByOid(LogLlamadasBHOid oid) {
        return oid != null && oid.getLogLlamadasBHID() != null
               ? repository.findById(oid.getLogLlamadasBHID())
               : Optional.empty();
    }

    /*
     * Returns an instance of LogLlamadasBH by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of LogLlamadasBH
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public LogLlamadasBH getByJsonOid(String jsonOid) {
        LogLlamadasBHOid oid = new LogLlamadasBHOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns a set of displayset items for an instance of LogLlamadasBH
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of LogLlamadasBH
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getLogLlamadasBHDynamic(LogLlamadasBHOid oid, String displaySetItems) {
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
    public String getSuppInfo(LogLlamadasBHOid oid, String dsName) {
        LogLlamadasBH instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(LogLlamadasBH instance, String dsName) {
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (LogLlamadasBHConstants.FILTER_NAME_FLOGLLAMADASBH.equalsIgnoreCase(filterRequest.getName()))
            fLogLlamadasBH(filterRequest, sql);
    }


    private void fLogLlamadasBH(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Timestamp vfDesde = filterRequest.hasFilterVariable(LogLlamadasBHConstants.VAR_NAME_FLOGLLAMADASBH_VFDESDE) ? (Timestamp) filterRequest.getFilterVariable(LogLlamadasBHConstants.VAR_NAME_FLOGLLAMADASBH_VFDESDE, FilterVariableRequest.DATETIME) : null;
        Timestamp vfHasta = filterRequest.hasFilterVariable(LogLlamadasBHConstants.VAR_NAME_FLOGLLAMADASBH_VFHASTA) ? (Timestamp) filterRequest.getFilterVariable(LogLlamadasBHConstants.VAR_NAME_FLOGLLAMADASBH_VFHASTA, FilterVariableRequest.DATETIME) : null;
        String vfCapa = filterRequest.hasFilterVariable(LogLlamadasBHConstants.VAR_NAME_FLOGLLAMADASBH_VFCAPA) ? (String) filterRequest.getFilterVariable(LogLlamadasBHConstants.VAR_NAME_FLOGLLAMADASBH_VFCAPA, FilterVariableRequest.STRING) : null;
        String vfServicio = filterRequest.hasFilterVariable(LogLlamadasBHConstants.VAR_NAME_FLOGLLAMADASBH_VFSERVICIO) ? (String) filterRequest.getFilterVariable(LogLlamadasBHConstants.VAR_NAME_FLOGLLAMADASBH_VFSERVICIO, FilterVariableRequest.STRING) : null;
        String vfTipoServicio = filterRequest.hasFilterVariable(LogLlamadasBHConstants.VAR_NAME_FLOGLLAMADASBH_VFTIPOSERVICIO) ? (String) filterRequest.getFilterVariable(LogLlamadasBHConstants.VAR_NAME_FLOGLLAMADASBH_VFTIPOSERVICIO, FilterVariableRequest.STRING) : null;
        String vfNumSolicitud = filterRequest.hasFilterVariable(LogLlamadasBHConstants.VAR_NAME_FLOGLLAMADASBH_VFNUMSOLICITUD) ? (String) filterRequest.getFilterVariable(LogLlamadasBHConstants.VAR_NAME_FLOGLLAMADASBH_VFNUMSOLICITUD, FilterVariableRequest.STRING) : null;

        // FechaHora >= vfDesde
        if (vfDesde != null) {
            // '>=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator(">=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(LogLlamadasBHConstants.ATTR_NAME_LOGLLAMADASBHFECHAHORA, Constants.Type.DATETIME.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vfDesde, Constants.Type.DATETIME.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        // FechaHora <= vfHasta
        if (vfHasta != null) {
            // '<=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("<=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(LogLlamadasBHConstants.ATTR_NAME_LOGLLAMADASBHFECHAHORA, Constants.Type.DATETIME.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(vfHasta, Constants.Type.DATETIME.getTypeName()));
            conjunction.addOperand(comparison2);

        }        

        // Capacidad LIKE "%" + vfCapa
        if (vfCapa != null) {
            // 'like' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(LogLlamadasBHConstants.ATTR_NAME_LOGLLAMADASBHCAPACIDAD, Constants.Type.STRING.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral("%" + vfCapa, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // Servicio LIKE "%" + vfServicio
        if (vfServicio != null) {
            // 'like' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(LogLlamadasBHConstants.ATTR_NAME_LOGLLAMADASBHSERVICIO, Constants.Type.STRING.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral("%" + vfServicio, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        // TipoServicio LIKE "%" + vfTipoServicio
        if (vfTipoServicio != null) {
            // 'like' Comparison
            SQLWhereComparison comparison5 = new SQLWhereComparison(sql);
            comparison5.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand116 = new SQLWhereOperandPathAttribute(LogLlamadasBHConstants.ATTR_NAME_LOGLLAMADASBHTIPOSERVICIO, Constants.Type.STRING.getTypeName());
            comparison5.setFirstOperand(operand116);
            
            // Operand 2
            comparison5.setSecondOperand(new SQLWhereOperandLiteral("%" + vfTipoServicio, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison5);

        }        

        // Solicitud LIKE "%" + vfNumSolicitud
        if (vfNumSolicitud != null) {
            // 'like' Comparison
            SQLWhereComparison comparison6 = new SQLWhereComparison(sql);
            comparison6.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand117 = new SQLWhereOperandPathAttribute(LogLlamadasBHConstants.ATTR_NAME_LOGLLAMADASBHSOLICITUD, Constants.Type.STRING.getTypeName());
            comparison6.setFirstOperand(operand117);
            
            // Operand 2
            comparison6.setSecondOperand(new SQLWhereOperandLiteral("%" + vfNumSolicitud, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison6);

        }        

        sql.addConjunction(conjunction);
    }

    // IIU Methods

    /*
     * Returns a viewmodel for class LogLlamadasBH with displayset DSLogLlamadasBHIIU for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class LogLlamadasBH with displayset DSLogLlamadasBHIIU
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aesolicitudes.viewmodel.logllamadasbh.ds.DSLogLlamadasBHIIU iIULogLlamadasBH(LogLlamadasBHOid oid) {
        return new com.keralty.aesolicitudes.viewmodel.logllamadasbh.ds.DSLogLlamadasBHIIU(getByOIDWithHV(oid));
    }


    /*
     * Solves the query needed for PIULogLlamadasBH
     *
     * @param queryRequest Query request
     * @return List of viewmodels for LogLlamadasBH using displayset DSLogLlamadasBH that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aesolicitudes.viewmodel.logllamadasbh.ds.DSLogLlamadasBH> piuPIULogLlamadasBH(QueryRequest queryRequest) {
        return solveLogLlamadasBHTypedQuery(queryRequest).stream()
                .map(com.keralty.aesolicitudes.viewmodel.logllamadasbh.ds.DSLogLlamadasBH::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIULogLlamadasBH
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIULogLlamadasBH
     */
    public int getCount4PIULogLlamadasBH(QueryRequest queryRequest) {
        return solveLogLlamadasBHTypedQuery(queryRequest).size();
    }

    // Service: createinstance

    /*
     * Entry point for service createinstance
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse createinstance(
            com.keralty.aesolicitudes.viewmodel.logllamadasbh.siu.CreateinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = logLlamadasBHSrv.createinstanceTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service createinstance
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse createinstanceTxn(
            com.keralty.aesolicitudes.viewmodel.logllamadasbh.siu.CreateinstanceRequest request) throws ModelException {
        return logLlamadasBHSrv.createinstanceImplementation(request);
    }

    /*
     * Implements service createinstance
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse createinstanceImplementation(
            com.keralty.aesolicitudes.viewmodel.logllamadasbh.siu.CreateinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Timestamp logLlamadasBHcreateinstancepatrFechaHora = request.getLogLlamadasBHcreateinstancepatrFechaHora();
        String logLlamadasBHcreateinstancepatrUsuario = request.getLogLlamadasBHcreateinstancepatrUsuario();
        String logLlamadasBHcreateinstancepatrCapacidad = request.getLogLlamadasBHcreateinstancepatrCapacidad();
        String logLlamadasBHcreateinstancepatrServicio = request.getLogLlamadasBHcreateinstancepatrServicio();
        String logLlamadasBHcreateinstancepatrSolicitud = request.getLogLlamadasBHcreateinstancepatrSolicitud();
        String logLlamadasBHcreateinstancepatrPeticion = request.getLogLlamadasBHcreateinstancepatrPeticion();
        String logLlamadasBHcreateinstancepatrRespuesta = request.getLogLlamadasBHcreateinstancepatrRespuesta();
        String logLlamadasBHcreateinstancepatrTipoServicio = request.getLogLlamadasBHcreateinstancepatrTipoServicio();
        Double logLlamadasBHcreateinstancepatrTiempoEjecucion = request.getLogLlamadasBHcreateinstancepatrTiempoEjecucion();
        String logLlamadasBHcreateinstancepatrTextoError = request.getLogLlamadasBHcreateinstancepatrTextoError();

        request.checkArguments();
        LogLlamadasBH instance = new LogLlamadasBH();
        instance.setLogLlamadasBHID(Long.valueOf(0));
        instance.setLogLlamadasBHFechaHora(logLlamadasBHcreateinstancepatrFechaHora);
        instance.setLogLlamadasBHUsuario(logLlamadasBHcreateinstancepatrUsuario);
        instance.setLogLlamadasBHCapacidad(logLlamadasBHcreateinstancepatrCapacidad);
        instance.setLogLlamadasBHServicio(logLlamadasBHcreateinstancepatrServicio);
        instance.setLogLlamadasBHSolicitud(logLlamadasBHcreateinstancepatrSolicitud);
        instance.setLogLlamadasBHPeticion(logLlamadasBHcreateinstancepatrPeticion);
        instance.setLogLlamadasBHRespuesta(logLlamadasBHcreateinstancepatrRespuesta);
        instance.setLogLlamadasBHTipoServicio(logLlamadasBHcreateinstancepatrTipoServicio);
        instance.setLogLlamadasBHTiempoEjecucion(logLlamadasBHcreateinstancepatrTiempoEjecucion);
        instance.setLogLlamadasBHTextoError(logLlamadasBHcreateinstancepatrTextoError);

        response.setInstance(repository.save(instance));

        return response;
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyOCOCLogLlamadasBH(queryRequest, select);
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(LogLlamadasBHConstants.CLASS_NAME, LogLlamadasBHConstants.ATTR_FIELD_LOGLLAMADASBHID, false), true);
    }


    private void applyOCOCLogLlamadasBH(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_LogLlamadasBH".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(LogLlamadasBHConstants.CLASS_NAME, LogLlamadasBHConstants.ATTR_NAME_LOGLLAMADASBHFECHAHORA, false), false);
        }
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            LogLlamadasBHOid oid = new LogLlamadasBHOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(LogLlamadasBHConstants.ATTR_FIELD_LOGLLAMADASBHID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getLogLlamadasBHID(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(LogLlamadasBHService.class).error(e.getMessage());
        }
    }

}
