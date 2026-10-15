package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.DominioConstants;
import com.keralty.aesolicitudes.global.FormaPagoConstants;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Dominio;
import com.keralty.aesolicitudes.persistence.FormaPago;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.DominioOid;
import com.keralty.aesolicitudes.persistence.oid.FormaPagoOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.repository.FormaPagoJpaRepository;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLWhereComparison;
import com.keralty.aesolicitudes.sqlutils.SQLWhereConjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereDisjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereNegation;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandSubQuery;
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
public class FormaPagoService extends AbstractService {

    FormaPagoJpaRepository repository;

    FormaPagoService formaPagoSrv;

    SolicitudService solicitudSrv;

    ContratoCService contratoCSrv;

    DominioService dominioSrv;

    @Inject
    public FormaPagoService(
            FormaPagoService formaPagoSrv,
            SolicitudService solicitudSrv,
            ContratoCService contratoCSrv,
            DominioService dominioSrv,
            FormaPagoJpaRepository repository) {
        this.formaPagoSrv = formaPagoSrv;
        this.solicitudSrv = solicitudSrv;
        this.contratoCSrv = contratoCSrv;
        this.dominioSrv = dominioSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, FormaPagoConstants.CLASS_NAME);
    }

    private List<FormaPago> solveFormaPagoTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, FormaPagoConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveFormaPagoTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, FormaPagoConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class FormaPago
     *
     * @return Population of class FormaPago
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<FormaPago> get() {
        List<FormaPago> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class FormaPago
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class FormaPago
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<FormaPago> instances = get(queryRequest);
        if(FormaPagoConstants.DSICFORMAPAGO.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICFormaPago())).collect(Collectors.toList());
        }
        if(FormaPagoConstants.DSDSFORMAPAGODETDOMINIO.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSFormaPagoDetDominio())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class FormaPago that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class FormaPago matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<FormaPago> get(QueryRequest queryRequest) {
        return solveFormaPagoTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveFormaPagoTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveFormaPagoTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveFormaPagoTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveFormaPagoTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of FormaPago by ID
     *
     * @param formaPagoCodigo Identification field formaPagoCodigo
     *
     * @return Instance of FormaPago
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public FormaPago getById(Long formaPagoCodigo) {
        return getByOID(new FormaPagoOid(formaPagoCodigo));
    }
    
    /*
     * Returns an instance of FormaPago by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of FormaPago
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public FormaPago getByOID(FormaPagoOid oid) {
        Optional<FormaPago> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of FormaPago by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of FormaPago
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public FormaPago getByOIDWithHV(FormaPagoOid oid) {
        Optional<FormaPago> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<FormaPago> getInstanceByOid(FormaPagoOid oid) {
        return oid != null && oid.getFormaPagoCodigo() != null
               ? repository.findById(oid.getFormaPagoCodigo())
               : Optional.empty();
    }

    /*
     * Returns an instance of FormaPago by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of FormaPago
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public FormaPago getByJsonOid(String jsonOid) {
        FormaPagoOid oid = new FormaPagoOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of FormaPago related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of FormaPago
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<FormaPago> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveFormaPagoTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of FormaPago related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of FormaPago
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<FormaPago> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of FormaPago
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of FormaPago
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getFormaPagoDynamic(FormaPagoOid oid, String displaySetItems) {
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
    public String getSuppInfo(FormaPagoOid oid, String dsName) {
        FormaPago instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(FormaPago instance, String dsName) {
        if (FormaPagoConstants.DSICFORMAPAGO.equals(dsName))
            return instance.buildICFormaPago();
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(FormaPago instance, String dsName) {
        if (FormaPagoConstants.DSICFORMAPAGO.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICFormaPago());
        if (FormaPagoConstants.DSDSFORMAPAGODETDOMINIO.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSFormaPagoDetDominio());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyNavigationalFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if ("Dominio_InsFormaPago_p_evcFormaPago_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431701422080423FiltNav11(filterRequest, sql);
        if ("Dominio_DelFormaPago_p_evcFormaPago_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431701422080423FiltNav10(filterRequest, sql);
        if ("Solicitud_TMODIFICARINFOPAGO_pt_p_evcFormaPago_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431957012480960FiltNav36(sql);
        if ("Solicitud_TMODIFICARINFOPAGO_pt_p_evcFormaPago_NavFilter1".equalsIgnoreCase(filterRequest.getName()))
            clas1431957012480960FiltNav38(filterRequest, sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_FormaPago".equals(filterRequest.getName()))
            suppInfo4ICFormaPago(filterRequest.getFilterVariable("searchText").toString(), sql);
    }


    private void clas1431701422080423FiltNav11(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Dominio dominioInsFormaPagopthisDominio = filterRequest.hasFilterVariable(DominioConstants.ARG_NAME_INSFORMAPAGO_DOMINIOINSFORMAPAGOPTHISDOMINIO) ? dominioSrv.getByOID(new DominioOid().fromJsonString(toJson(filterRequest.getFilterVariable(DominioConstants.ARG_NAME_INSFORMAPAGO_DOMINIOINSFORMAPAGOPTHISDOMINIO)))) : null;

        // EXIST (Dominios) WHERE (Dominios = pthisDominio) = false
        if (dominioInsFormaPagopthisDominio != null) {
        {
            // 'not' Logical operator
            SQLWhereNegation comparison1 = new SQLWhereNegation(sql);
        
            // Operand 1
            // 'exist' Association operator
            SQLWhereOperandSubQuery operandSubQueryAssocOperator000 = new SQLWhereOperandSubQuery(repository.assocOperator000Range1Query(dominioInsFormaPagopthisDominio, sql));
            comparison1.addOperand(operandSubQueryAssocOperator000);
            
            conjunction.addOperand(comparison1);
        }

        }        
        sql.addConjunction(conjunction);
    }

    private void clas1431701422080423FiltNav10(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Dominio dominioDelFormaPagopthisDominio = filterRequest.hasFilterVariable(DominioConstants.ARG_NAME_DELFORMAPAGO_DOMINIODELFORMAPAGOPTHISDOMINIO) ? dominioSrv.getByOID(new DominioOid().fromJsonString(toJson(filterRequest.getFilterVariable(DominioConstants.ARG_NAME_DELFORMAPAGO_DOMINIODELFORMAPAGOPTHISDOMINIO)))) : null;

        // EXIST (Dominios) WHERE (Dominios = pthisDominio) = true
        if (dominioDelFormaPagopthisDominio != null) {
    // 'exist' Association operator
    SQLWhereOperandSubQuery operandSubQueryAssocOperator001 = new SQLWhereOperandSubQuery(repository.assocOperator001Range1Query(dominioDelFormaPagopthisDominio, sql));
    conjunction.addOperand(operandSubQueryAssocOperator001);

        }        
        sql.addConjunction(conjunction);
    }

    private void clas1431957012480960FiltNav36(SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();

        // EsVisible = true
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FormaPagoConstants.ATTR_NAME_FORMAPAGOESVISIBLE, Constants.Type.BOOL.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison1);

        sql.addConjunction(conjunction);
    }

    private void clas1431957012480960FiltNav38(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Solicitud solicitudTMODIFICARINFOPAGOpthisSolicitud = filterRequest.hasFilterVariable(SolicitudConstants.ARG_NAME_TMODIFICARINFOPAGO_SOLICITUDTMODIFICARINFOPAGOPTHISSOLICITUD) ? solicitudSrv.getByOID(new SolicitudOid().fromJsonString(toJson(filterRequest.getFilterVariable(SolicitudConstants.ARG_NAME_TMODIFICARINFOPAGO_SOLICITUDTMODIFICARINFOPAGOPTHISSOLICITUD)))) : null;

        // EXIST (Dominios) WHERE (Dominios.ProductoT = pthisSolicitud.Aesolicitudes.ProductoT AND Dominios.PlanT = pthisSolicitud.Aesolicitudes.PlanT) = true
        if (solicitudTMODIFICARINFOPAGOpthisSolicitud != null) {
    // 'exist' Association operator
    SQLWhereOperandSubQuery operandSubQueryAssocOperator002 = new SQLWhereOperandSubQuery(repository.assocOperator002Range1Query(solicitudTMODIFICARINFOPAGOpthisSolicitud, sql));
    conjunction.addOperand(operandSubQueryAssocOperator002);

        }        
        sql.addConjunction(conjunction);
    }

    // IIU Methods


    /*
     * Solves the query needed for PIUFormaPago
     *
     * @param queryRequest Query request
     * @return List of viewmodels for FormaPago using displayset AutoDS that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aesolicitudes.viewmodel.formapago.ds.AutoDS> piuPIUFormaPago(QueryRequest queryRequest) {
        return solveFormaPagoTypedQuery(queryRequest).stream()
                .map(com.keralty.aesolicitudes.viewmodel.formapago.ds.AutoDS::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUFormaPago
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUFormaPago
     */
    public int getCount4PIUFormaPago(QueryRequest queryRequest) {
        return solveFormaPagoTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUFormaPagoDetDominio
     *
     * @param queryRequest Query request
     * @return List of viewmodels for FormaPago using displayset DSFormaPagoDetDominio that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aesolicitudes.viewmodel.formapago.ds.DSFormaPagoDetDominio> piuPIUFormaPagoDetDominio(QueryRequest queryRequest) {
        return solveFormaPagoTypedQuery(queryRequest).stream()
                .map(com.keralty.aesolicitudes.viewmodel.formapago.ds.DSFormaPagoDetDominio::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUFormaPagoDetDominio
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUFormaPagoDetDominio
     */
    public int getCount4PIUFormaPagoDetDominio(QueryRequest queryRequest) {
        return solveFormaPagoTypedQuery(queryRequest).size();
    }

    // Service: InsFormaPagoSolicitud

    /*
     * Entry point for service InsFormaPagoSolicitud
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insFormaPagoSolicitud(
            com.keralty.aesolicitudes.viewmodel.formapago.siu.InsFormaPagoSolicitudRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = formaPagoSrv.insFormaPagoSolicitudTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsFormaPagoSolicitud
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insFormaPagoSolicitudTxn(
            com.keralty.aesolicitudes.viewmodel.formapago.siu.InsFormaPagoSolicitudRequest request) throws ModelException {
        request.setFormaPagoInsFormaPagoSolicitudpthisFormaPagoInstance(formaPagoSrv.getByOIDWithHV(request.getFormaPagoInsFormaPagoSolicitudpthisFormaPago()));
        request.setFormaPagoInsFormaPagoSolicitudpevcSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getFormaPagoInsFormaPagoSolicitudpevcSolicitud()));
        return formaPagoSrv.insFormaPagoSolicitudImplementation(request, true);
    }

    /*
     * Implements service InsFormaPagoSolicitud
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insFormaPagoSolicitudImplementation(
            com.keralty.aesolicitudes.viewmodel.formapago.siu.InsFormaPagoSolicitudRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FormaPago formaPagoInsFormaPagoSolicitudpthisFormaPago = request.getFormaPagoInsFormaPagoSolicitudpthisFormaPagoInstance();
        Solicitud formaPagoInsFormaPagoSolicitudpevcSolicitud = request.getFormaPagoInsFormaPagoSolicitudpevcSolicitudInstance();

        request.checkArguments();
        FormaPago instance = formaPagoInsFormaPagoSolicitudpthisFormaPago;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.solicitud.siu.InsFormaPagoSolicitudRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.solicitud.siu.InsFormaPagoSolicitudRequest();
            relatedRequest.setSolicitudInsFormaPagoSolicitudpthisSolicitudInstance(formaPagoInsFormaPagoSolicitudpevcSolicitud);
            relatedRequest.setSolicitudInsFormaPagoSolicitudpevcFormaPagoInstance(formaPagoInsFormaPagoSolicitudpthisFormaPago);
            solicitudSrv.insFormaPagoSolicitudImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICFormaPago());

        return response;
    }

    // Service: DelFormaPagoSolicitud

    /*
     * Entry point for service DelFormaPagoSolicitud
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delFormaPagoSolicitud(
            com.keralty.aesolicitudes.viewmodel.formapago.siu.DelFormaPagoSolicitudRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = formaPagoSrv.delFormaPagoSolicitudTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelFormaPagoSolicitud
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delFormaPagoSolicitudTxn(
            com.keralty.aesolicitudes.viewmodel.formapago.siu.DelFormaPagoSolicitudRequest request) throws ModelException {
        request.setFormaPagoDelFormaPagoSolicitudpthisFormaPagoInstance(formaPagoSrv.getByOIDWithHV(request.getFormaPagoDelFormaPagoSolicitudpthisFormaPago()));
        request.setFormaPagoDelFormaPagoSolicitudpevcSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getFormaPagoDelFormaPagoSolicitudpevcSolicitud()));
        return formaPagoSrv.delFormaPagoSolicitudImplementation(request, true);
    }

    /*
     * Implements service DelFormaPagoSolicitud
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delFormaPagoSolicitudImplementation(
            com.keralty.aesolicitudes.viewmodel.formapago.siu.DelFormaPagoSolicitudRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FormaPago formaPagoDelFormaPagoSolicitudpthisFormaPago = request.getFormaPagoDelFormaPagoSolicitudpthisFormaPagoInstance();
        Solicitud formaPagoDelFormaPagoSolicitudpevcSolicitud = request.getFormaPagoDelFormaPagoSolicitudpevcSolicitudInstance();

        request.checkArguments();
        FormaPago instance = formaPagoDelFormaPagoSolicitudpthisFormaPago;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.solicitud.siu.DelFormaPagoSolicitudRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.solicitud.siu.DelFormaPagoSolicitudRequest();
            relatedRequest.setSolicitudDelFormaPagoSolicitudpthisSolicitudInstance(formaPagoDelFormaPagoSolicitudpevcSolicitud);
            relatedRequest.setSolicitudDelFormaPagoSolicitudpevcFormaPagoInstance(formaPagoDelFormaPagoSolicitudpthisFormaPago);
            solicitudSrv.delFormaPagoSolicitudImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICFormaPago());

        return response;
    }

    // Service: InsFormaPagoC

    /*
     * Entry point for service InsFormaPagoC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insFormaPagoC(
            com.keralty.aesolicitudes.viewmodel.formapago.siu.InsFormaPagoCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = formaPagoSrv.insFormaPagoCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsFormaPagoC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insFormaPagoCTxn(
            com.keralty.aesolicitudes.viewmodel.formapago.siu.InsFormaPagoCRequest request) throws ModelException {
        request.setFormaPagoInsFormaPagoCpthisFormaPagoInstance(formaPagoSrv.getByOIDWithHV(request.getFormaPagoInsFormaPagoCpthisFormaPago()));
        request.setFormaPagoInsFormaPagoCpevcContratoCInstance(contratoCSrv.getByOIDWithHV(request.getFormaPagoInsFormaPagoCpevcContratoC()));
        return formaPagoSrv.insFormaPagoCImplementation(request, true);
    }

    /*
     * Implements service InsFormaPagoC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insFormaPagoCImplementation(
            com.keralty.aesolicitudes.viewmodel.formapago.siu.InsFormaPagoCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FormaPago formaPagoInsFormaPagoCpthisFormaPago = request.getFormaPagoInsFormaPagoCpthisFormaPagoInstance();
        ContratoC formaPagoInsFormaPagoCpevcContratoC = request.getFormaPagoInsFormaPagoCpevcContratoCInstance();

        request.checkArguments();
        FormaPago instance = formaPagoInsFormaPagoCpthisFormaPago;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsFormaPagoCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsFormaPagoCRequest();
            relatedRequest.setContratoCInsFormaPagoCpthisContratoCInstance(formaPagoInsFormaPagoCpevcContratoC);
            relatedRequest.setContratoCInsFormaPagoCpevcFormaPagoInstance(formaPagoInsFormaPagoCpthisFormaPago);
            contratoCSrv.insFormaPagoCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICFormaPago());

        return response;
    }

    // Service: DelFormaPagoC

    /*
     * Entry point for service DelFormaPagoC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delFormaPagoC(
            com.keralty.aesolicitudes.viewmodel.formapago.siu.DelFormaPagoCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = formaPagoSrv.delFormaPagoCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelFormaPagoC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delFormaPagoCTxn(
            com.keralty.aesolicitudes.viewmodel.formapago.siu.DelFormaPagoCRequest request) throws ModelException {
        request.setFormaPagoDelFormaPagoCpthisFormaPagoInstance(formaPagoSrv.getByOIDWithHV(request.getFormaPagoDelFormaPagoCpthisFormaPago()));
        request.setFormaPagoDelFormaPagoCpevcContratoCInstance(contratoCSrv.getByOIDWithHV(request.getFormaPagoDelFormaPagoCpevcContratoC()));
        return formaPagoSrv.delFormaPagoCImplementation(request, true);
    }

    /*
     * Implements service DelFormaPagoC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delFormaPagoCImplementation(
            com.keralty.aesolicitudes.viewmodel.formapago.siu.DelFormaPagoCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FormaPago formaPagoDelFormaPagoCpthisFormaPago = request.getFormaPagoDelFormaPagoCpthisFormaPagoInstance();
        ContratoC formaPagoDelFormaPagoCpevcContratoC = request.getFormaPagoDelFormaPagoCpevcContratoCInstance();

        request.checkArguments();
        FormaPago instance = formaPagoDelFormaPagoCpthisFormaPago;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelFormaPagoCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelFormaPagoCRequest();
            relatedRequest.setContratoCDelFormaPagoCpthisContratoCInstance(formaPagoDelFormaPagoCpevcContratoC);
            relatedRequest.setContratoCDelFormaPagoCpevcFormaPagoInstance(formaPagoDelFormaPagoCpthisFormaPago);
            contratoCSrv.delFormaPagoCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICFormaPago());

        return response;
    }


    private void suppInfo4ICFormaPago(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FormaPagoConstants.ATTR_NAME_FORMAPAGODESCRIPCION, Constants.Type.STRING.getTypeName()));
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
        applyOCOCFormaPago(queryRequest, select);
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(FormaPagoConstants.CLASS_NAME, FormaPagoConstants.ATTR_FIELD_FORMAPAGOCODIGO, false), true);
    }


    private void applyOCOCFormaPago(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_FormaPago".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(FormaPagoConstants.CLASS_NAME, FormaPagoConstants.ATTR_NAME_FORMAPAGODESCRIPCION, false), true);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildFormaPagoRelatedInstance(relatedInstanceJsonOid);
        }
        if (FormaPagoConstants.ROLE_NAME_DOMINIOS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFormaPagoRelatedInstance4Dominio(relatedInstanceJsonOid, remainingPath);
        }
        if (FormaPagoConstants.ROLE_NAME_SOLICITUDES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFormaPagoRelatedInstance4Solicitud(relatedInstanceJsonOid, remainingPath);
        }
        if (FormaPagoConstants.ROLE_NAME_CONTRATOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFormaPagoRelatedInstance4ContratoC(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildFormaPagoRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new FormaPago(mapper.readValue(relatedInstanceJsonOid, FormaPagoOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFormaPagoRelatedInstance4Dominio(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Dominio(mapper.readValue(relatedInstanceJsonOid, DominioOid.class)): Dominio.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFormaPagoRelatedInstance4Solicitud(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Solicitud(mapper.readValue(relatedInstanceJsonOid, SolicitudOid.class)): Solicitud.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFormaPagoRelatedInstance4ContratoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ContratoC(mapper.readValue(relatedInstanceJsonOid, ContratoCOid.class)): ContratoC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            FormaPagoOid oid = new FormaPagoOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FormaPagoConstants.ATTR_FIELD_FORMAPAGOCODIGO, Constants.Type.INT.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getFormaPagoCodigo(), Constants.Type.INT.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(FormaPagoService.class).error(e.getMessage());
        }
    }

}
