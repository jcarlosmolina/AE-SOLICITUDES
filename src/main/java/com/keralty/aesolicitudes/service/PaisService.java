package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.PaisConstants;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.Direccion;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.NovedadCT;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;
import com.keralty.aesolicitudes.persistence.oid.DireccionOid;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.NovedadCTOid;
import com.keralty.aesolicitudes.persistence.oid.PaisOid;
import com.keralty.aesolicitudes.persistence.Pais;
import com.keralty.aesolicitudes.repository.PaisJpaRepository;
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
public class PaisService extends AbstractService {

    PaisJpaRepository repository;

    PaisService paisSrv;

    DireccionService direccionSrv;

    DireccionCService direccionCSrv;

    DirSucursalCService dirSucursalCSrv;

    NovedadCTService novedadCTSrv;

    @Inject
    public PaisService(
            PaisService paisSrv,
            DireccionService direccionSrv,
            DireccionCService direccionCSrv,
            DirSucursalCService dirSucursalCSrv,
            NovedadCTService novedadCTSrv,
            PaisJpaRepository repository) {
        this.paisSrv = paisSrv;
        this.direccionSrv = direccionSrv;
        this.direccionCSrv = direccionCSrv;
        this.dirSucursalCSrv = dirSucursalCSrv;
        this.novedadCTSrv = novedadCTSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, PaisConstants.CLASS_NAME);
    }

    private List<Pais> solvePaisTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, PaisConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solvePaisTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, PaisConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class Pais
     *
     * @return Population of class Pais
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Pais> get() {
        List<Pais> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class Pais
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class Pais
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<Pais> instances = get(queryRequest);
        if(PaisConstants.DSICPAIS.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICPais())).collect(Collectors.toList());
        }
        return results;
    }

    /*
     * Gets the properties of DisplaySet ICPais for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet ICPais for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aesolicitudes.viewmodel.pais.ds.ICPais getICPais(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        Pais instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.keralty.aesolicitudes.viewmodel.pais.ds.ICPais(instance);
    }

    /*
     * Gets the properties of DisplaySet AutoDS for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet AutoDS for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aesolicitudes.viewmodel.pais.ds.AutoDS getAutoDS(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        Pais instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.keralty.aesolicitudes.viewmodel.pais.ds.AutoDS(instance);
    }

    /*
     * Returns the population of class Pais that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class Pais matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Pais> get(QueryRequest queryRequest) {
        return solvePaisTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solvePaisTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solvePaisTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solvePaisTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solvePaisTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of Pais by ID
     *
     * @param paisCodigo Identification field paisCodigo
     *
     * @return Instance of Pais
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Pais getById(String paisCodigo) {
        return getByOID(new PaisOid(paisCodigo));
    }
    
    /*
     * Returns an instance of Pais by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Pais
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Pais getByOID(PaisOid oid) {
        Optional<Pais> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Pais by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Pais
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Pais getByOIDWithHV(PaisOid oid) {
        Optional<Pais> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Pais> getInstanceByOid(PaisOid oid) {
        return oid != null && oid.getPaisCodigo() != null
               ? repository.findById(oid.getPaisCodigo())
               : Optional.empty();
    }

    /*
     * Returns an instance of Pais by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Pais
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Pais getByJsonOid(String jsonOid) {
        PaisOid oid = new PaisOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of Pais related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Pais
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Pais> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solvePaisTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of Pais related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Pais
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Pais> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of Pais
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of Pais
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getPaisDynamic(PaisOid oid, String displaySetItems) {
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
    public String getSuppInfo(PaisOid oid, String dsName) {
        Pais instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(Pais instance, String dsName) {
        if (PaisConstants.DSICPAIS.equals(dsName))
            return instance.buildICPais();
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(Pais instance, String dsName) {
        if (PaisConstants.DSICPAIS.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICPais());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (PaisConstants.FILTER_NAME_IFPAISCODIGO.equalsIgnoreCase(filterRequest.getName()))
            iFPaisCodigo(filterRequest, sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_Pais".equals(filterRequest.getName()))
            suppInfo4ICPais(filterRequest.getFilterVariable("searchText").toString(), sql);
    }


    private void iFPaisCodigo(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vCodigo = filterRequest.hasFilterVariable(PaisConstants.VAR_NAME_IFPAISCODIGO_VCODIGO) ? (String) filterRequest.getFilterVariable(PaisConstants.VAR_NAME_IFPAISCODIGO_VCODIGO, FilterVariableRequest.STRING) : null;

        // Codigo = vCodigo
        if (vCodigo != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(PaisConstants.ATTR_NAME_PAISCODIGO, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vCodigo, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    // IIU Methods


    /*
     * Solves the query needed for PIUPais
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Pais using displayset AutoDS that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aesolicitudes.viewmodel.pais.ds.AutoDS> piuPIUPais(QueryRequest queryRequest) {
        return solvePaisTypedQuery(queryRequest).stream()
                .map(com.keralty.aesolicitudes.viewmodel.pais.ds.AutoDS::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUPais
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUPais
     */
    public int getCount4PIUPais(QueryRequest queryRequest) {
        return solvePaisTypedQuery(queryRequest).size();
    }

    // Service: InsPaisDireccion

    /*
     * Entry point for service InsPaisDireccion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insPaisDireccion(
            com.keralty.aesolicitudes.viewmodel.pais.siu.InsPaisDireccionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = paisSrv.insPaisDireccionTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsPaisDireccion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insPaisDireccionTxn(
            com.keralty.aesolicitudes.viewmodel.pais.siu.InsPaisDireccionRequest request) throws ModelException {
        request.setPaisInsPaisDireccionpthisPaisInstance(paisSrv.getByOIDWithHV(request.getPaisInsPaisDireccionpthisPais()));
        request.setPaisInsPaisDireccionpevcDireccionInstance(direccionSrv.getByOIDWithHV(request.getPaisInsPaisDireccionpevcDireccion()));
        return paisSrv.insPaisDireccionImplementation(request, true);
    }

    /*
     * Implements service InsPaisDireccion
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insPaisDireccionImplementation(
            com.keralty.aesolicitudes.viewmodel.pais.siu.InsPaisDireccionRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Pais paisInsPaisDireccionpthisPais = request.getPaisInsPaisDireccionpthisPaisInstance();
        Direccion paisInsPaisDireccionpevcDireccion = request.getPaisInsPaisDireccionpevcDireccionInstance();

        request.checkArguments();
        Pais instance = paisInsPaisDireccionpthisPais;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.direccion.siu.InsPaisDireccionRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.direccion.siu.InsPaisDireccionRequest();
            relatedRequest.setDireccionInsPaisDireccionpthisDireccionInstance(paisInsPaisDireccionpevcDireccion);
            relatedRequest.setDireccionInsPaisDireccionpevcPaisInstance(paisInsPaisDireccionpthisPais);
            direccionSrv.insPaisDireccionImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICPais());

        return response;
    }

    // Service: DelPaisDireccion

    /*
     * Entry point for service DelPaisDireccion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delPaisDireccion(
            com.keralty.aesolicitudes.viewmodel.pais.siu.DelPaisDireccionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = paisSrv.delPaisDireccionTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelPaisDireccion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delPaisDireccionTxn(
            com.keralty.aesolicitudes.viewmodel.pais.siu.DelPaisDireccionRequest request) throws ModelException {
        request.setPaisDelPaisDireccionpthisPaisInstance(paisSrv.getByOIDWithHV(request.getPaisDelPaisDireccionpthisPais()));
        request.setPaisDelPaisDireccionpevcDireccionInstance(direccionSrv.getByOIDWithHV(request.getPaisDelPaisDireccionpevcDireccion()));
        return paisSrv.delPaisDireccionImplementation(request, true);
    }

    /*
     * Implements service DelPaisDireccion
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delPaisDireccionImplementation(
            com.keralty.aesolicitudes.viewmodel.pais.siu.DelPaisDireccionRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Pais paisDelPaisDireccionpthisPais = request.getPaisDelPaisDireccionpthisPaisInstance();
        Direccion paisDelPaisDireccionpevcDireccion = request.getPaisDelPaisDireccionpevcDireccionInstance();

        request.checkArguments();
        Pais instance = paisDelPaisDireccionpthisPais;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.direccion.siu.DelPaisDireccionRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.direccion.siu.DelPaisDireccionRequest();
            relatedRequest.setDireccionDelPaisDireccionpthisDireccionInstance(paisDelPaisDireccionpevcDireccion);
            relatedRequest.setDireccionDelPaisDireccionpevcPaisInstance(paisDelPaisDireccionpthisPais);
            direccionSrv.delPaisDireccionImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICPais());

        return response;
    }

    // Service: InsPaisC

    /*
     * Entry point for service InsPaisC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insPaisC(
            com.keralty.aesolicitudes.viewmodel.pais.siu.InsPaisCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = paisSrv.insPaisCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsPaisC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insPaisCTxn(
            com.keralty.aesolicitudes.viewmodel.pais.siu.InsPaisCRequest request) throws ModelException {
        request.setPaisInsPaisCpthisPaisInstance(paisSrv.getByOIDWithHV(request.getPaisInsPaisCpthisPais()));
        request.setPaisInsPaisCpevcDireccionCInstance(direccionCSrv.getByOIDWithHV(request.getPaisInsPaisCpevcDireccionC()));
        return paisSrv.insPaisCImplementation(request, true);
    }

    /*
     * Implements service InsPaisC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insPaisCImplementation(
            com.keralty.aesolicitudes.viewmodel.pais.siu.InsPaisCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Pais paisInsPaisCpthisPais = request.getPaisInsPaisCpthisPaisInstance();
        DireccionC paisInsPaisCpevcDireccionC = request.getPaisInsPaisCpevcDireccionCInstance();

        request.checkArguments();
        Pais instance = paisInsPaisCpthisPais;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsPaisCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsPaisCRequest();
            relatedRequest.setDireccionCInsPaisCpthisDireccionCInstance(paisInsPaisCpevcDireccionC);
            relatedRequest.setDireccionCInsPaisCpevcPaisInstance(paisInsPaisCpthisPais);
            direccionCSrv.insPaisCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICPais());

        return response;
    }

    // Service: DelPaisC

    /*
     * Entry point for service DelPaisC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delPaisC(
            com.keralty.aesolicitudes.viewmodel.pais.siu.DelPaisCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = paisSrv.delPaisCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelPaisC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delPaisCTxn(
            com.keralty.aesolicitudes.viewmodel.pais.siu.DelPaisCRequest request) throws ModelException {
        request.setPaisDelPaisCpthisPaisInstance(paisSrv.getByOIDWithHV(request.getPaisDelPaisCpthisPais()));
        request.setPaisDelPaisCpevcDireccionCInstance(direccionCSrv.getByOIDWithHV(request.getPaisDelPaisCpevcDireccionC()));
        return paisSrv.delPaisCImplementation(request, true);
    }

    /*
     * Implements service DelPaisC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delPaisCImplementation(
            com.keralty.aesolicitudes.viewmodel.pais.siu.DelPaisCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Pais paisDelPaisCpthisPais = request.getPaisDelPaisCpthisPaisInstance();
        DireccionC paisDelPaisCpevcDireccionC = request.getPaisDelPaisCpevcDireccionCInstance();

        request.checkArguments();
        Pais instance = paisDelPaisCpthisPais;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelPaisCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelPaisCRequest();
            relatedRequest.setDireccionCDelPaisCpthisDireccionCInstance(paisDelPaisCpevcDireccionC);
            relatedRequest.setDireccionCDelPaisCpevcPaisInstance(paisDelPaisCpthisPais);
            direccionCSrv.delPaisCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICPais());

        return response;
    }

    // Service: InsPaisDirSucursalC

    /*
     * Entry point for service InsPaisDirSucursalC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insPaisDirSucursalC(
            com.keralty.aesolicitudes.viewmodel.pais.siu.InsPaisDirSucursalCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = paisSrv.insPaisDirSucursalCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsPaisDirSucursalC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insPaisDirSucursalCTxn(
            com.keralty.aesolicitudes.viewmodel.pais.siu.InsPaisDirSucursalCRequest request) throws ModelException {
        request.setPaisInsPaisDirSucursalCpthisPaisInstance(paisSrv.getByOIDWithHV(request.getPaisInsPaisDirSucursalCpthisPais()));
        request.setPaisInsPaisDirSucursalCpevcDirSucursalCInstance(dirSucursalCSrv.getByOIDWithHV(request.getPaisInsPaisDirSucursalCpevcDirSucursalC()));
        return paisSrv.insPaisDirSucursalCImplementation(request, true);
    }

    /*
     * Implements service InsPaisDirSucursalC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insPaisDirSucursalCImplementation(
            com.keralty.aesolicitudes.viewmodel.pais.siu.InsPaisDirSucursalCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Pais paisInsPaisDirSucursalCpthisPais = request.getPaisInsPaisDirSucursalCpthisPaisInstance();
        DirSucursalC paisInsPaisDirSucursalCpevcDirSucursalC = request.getPaisInsPaisDirSucursalCpevcDirSucursalCInstance();

        request.checkArguments();
        Pais instance = paisInsPaisDirSucursalCpthisPais;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsPaisDirSucursalCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsPaisDirSucursalCRequest();
            relatedRequest.setDirSucursalCInsPaisDirSucursalCpthisDirSucursalCInstance(paisInsPaisDirSucursalCpevcDirSucursalC);
            relatedRequest.setDirSucursalCInsPaisDirSucursalCpevcPaisInstance(paisInsPaisDirSucursalCpthisPais);
            dirSucursalCSrv.insPaisDirSucursalCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICPais());

        return response;
    }

    // Service: DelPaisDirSucursalC

    /*
     * Entry point for service DelPaisDirSucursalC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delPaisDirSucursalC(
            com.keralty.aesolicitudes.viewmodel.pais.siu.DelPaisDirSucursalCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = paisSrv.delPaisDirSucursalCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelPaisDirSucursalC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delPaisDirSucursalCTxn(
            com.keralty.aesolicitudes.viewmodel.pais.siu.DelPaisDirSucursalCRequest request) throws ModelException {
        request.setPaisDelPaisDirSucursalCpthisPaisInstance(paisSrv.getByOIDWithHV(request.getPaisDelPaisDirSucursalCpthisPais()));
        request.setPaisDelPaisDirSucursalCpevcDirSucursalCInstance(dirSucursalCSrv.getByOIDWithHV(request.getPaisDelPaisDirSucursalCpevcDirSucursalC()));
        return paisSrv.delPaisDirSucursalCImplementation(request, true);
    }

    /*
     * Implements service DelPaisDirSucursalC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delPaisDirSucursalCImplementation(
            com.keralty.aesolicitudes.viewmodel.pais.siu.DelPaisDirSucursalCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Pais paisDelPaisDirSucursalCpthisPais = request.getPaisDelPaisDirSucursalCpthisPaisInstance();
        DirSucursalC paisDelPaisDirSucursalCpevcDirSucursalC = request.getPaisDelPaisDirSucursalCpevcDirSucursalCInstance();

        request.checkArguments();
        Pais instance = paisDelPaisDirSucursalCpthisPais;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelPaisDirSucursalCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelPaisDirSucursalCRequest();
            relatedRequest.setDirSucursalCDelPaisDirSucursalCpthisDirSucursalCInstance(paisDelPaisDirSucursalCpevcDirSucursalC);
            relatedRequest.setDirSucursalCDelPaisDirSucursalCpevcPaisInstance(paisDelPaisDirSucursalCpthisPais);
            dirSucursalCSrv.delPaisDirSucursalCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICPais());

        return response;
    }


    private void suppInfo4ICPais(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(PaisConstants.ATTR_NAME_PAISDESCRIPCION, Constants.Type.STRING.getTypeName()));
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
        applyOCOCPais(queryRequest, select);
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(PaisConstants.CLASS_NAME, PaisConstants.ATTR_FIELD_PAISCODIGO, false), true);
    }


    private void applyOCOCPais(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_Pais".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(PaisConstants.CLASS_NAME, PaisConstants.ATTR_NAME_PAISDESCRIPCION, false), true);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildPaisRelatedInstance(relatedInstanceJsonOid);
        }
        if (PaisConstants.ROLE_NAME_DIRECCIONESC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPaisRelatedInstance4DireccionC(relatedInstanceJsonOid, remainingPath);
        }
        if (PaisConstants.ROLE_NAME_DIRECCIONES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPaisRelatedInstance4Direccion(relatedInstanceJsonOid, remainingPath);
        }
        if (PaisConstants.ROLE_NAME_DIRSUCURSALC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPaisRelatedInstance4DirSucursalC(relatedInstanceJsonOid, remainingPath);
        }
        if (PaisConstants.ROLE_NAME_NOVEDADCT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPaisRelatedInstance4NovedadCT(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildPaisRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new Pais(mapper.readValue(relatedInstanceJsonOid, PaisOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPaisRelatedInstance4DireccionC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new DireccionC(mapper.readValue(relatedInstanceJsonOid, DireccionCOid.class)): DireccionC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPaisRelatedInstance4Direccion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Direccion(mapper.readValue(relatedInstanceJsonOid, DireccionOid.class)): Direccion.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPaisRelatedInstance4DirSucursalC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new DirSucursalC(mapper.readValue(relatedInstanceJsonOid, DirSucursalCOid.class)): DirSucursalC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPaisRelatedInstance4NovedadCT(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new NovedadCT(mapper.readValue(relatedInstanceJsonOid, NovedadCTOid.class)): NovedadCT.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            PaisOid oid = new PaisOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(PaisConstants.ATTR_FIELD_PAISCODIGO, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getPaisCodigo(), Constants.Type.STRING.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(PaisService.class).error(e.getMessage());
        }
    }

}
