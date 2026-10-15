package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.global.ConceptoCConstants;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.ConceptoC;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.ConceptoCOid;
import com.keralty.aesolicitudes.repository.ConceptoCJpaRepository;
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
public class ConceptoCService extends AbstractService {

    ConceptoCJpaRepository repository;

    ConceptoCService conceptoCSrv;

    BeneficiarioCService beneficiarioCSrv;

    @Inject
    public ConceptoCService(
            ConceptoCService conceptoCSrv,
            BeneficiarioCService beneficiarioCSrv,
            ConceptoCJpaRepository repository) {
        this.conceptoCSrv = conceptoCSrv;
        this.beneficiarioCSrv = beneficiarioCSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, ConceptoCConstants.CLASS_NAME);
    }

    private List<ConceptoC> solveConceptoCTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, ConceptoCConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveConceptoCTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, ConceptoCConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class ConceptoC
     *
     * @return Population of class ConceptoC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ConceptoC> get() {
        List<ConceptoC> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class ConceptoC that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class ConceptoC matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ConceptoC> get(QueryRequest queryRequest) {
        return solveConceptoCTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveConceptoCTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveConceptoCTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveConceptoCTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of ConceptoC by ID
     *
     * @param conceptoCIdConcepto Identification field conceptoCIdConcepto
     *
     * @return Instance of ConceptoC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ConceptoC getById(Long conceptoCIdConcepto) {
        return getByOID(new ConceptoCOid(conceptoCIdConcepto));
    }
    
    /*
     * Returns an instance of ConceptoC by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ConceptoC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ConceptoC getByOID(ConceptoCOid oid) {
        Optional<ConceptoC> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of ConceptoC by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ConceptoC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public ConceptoC getByOIDWithHV(ConceptoCOid oid) {
        Optional<ConceptoC> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<ConceptoC> getInstanceByOid(ConceptoCOid oid) {
        return oid != null && oid.getConceptoCIdConcepto() != null
               ? repository.findById(oid.getConceptoCIdConcepto())
               : Optional.empty();
    }

    /*
     * Returns an instance of ConceptoC by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of ConceptoC
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public ConceptoC getByJsonOid(String jsonOid) {
        ConceptoCOid oid = new ConceptoCOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of ConceptoC related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ConceptoC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ConceptoC> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveConceptoCTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of ConceptoC related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ConceptoC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ConceptoC> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of ConceptoC
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of ConceptoC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getConceptoCDynamic(ConceptoCOid oid, String displaySetItems) {
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
    public String getSuppInfo(ConceptoCOid oid, String dsName) {
        ConceptoC instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(ConceptoC instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
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
            com.keralty.aesolicitudes.viewmodel.conceptoc.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = conceptoCSrv.crearTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.conceptoc.siu.CrearRequest request) throws ModelException {
        request.setConceptoCcrearpagrBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getConceptoCcrearpagrBeneficiarioC()));
        return conceptoCSrv.crearImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.conceptoc.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        BeneficiarioC conceptoCcrearpagrBeneficiarioC = request.getConceptoCcrearpagrBeneficiarioCInstance();
        String conceptoCcrearpatrcodConceptoContrato = request.getConceptoCcrearpatrcodConceptoContrato();
        String conceptoCcrearpatrnombreConcepto = request.getConceptoCcrearpatrnombreConcepto();
        Double conceptoCcrearpatrporcentajeConcepto = request.getConceptoCcrearpatrporcentajeConcepto();
        Double conceptoCcrearpatrvalorConcepto = request.getConceptoCcrearpatrvalorConcepto();

        request.checkArguments();
        ConceptoC instance = new ConceptoC();
        instance.add2BeneficiarioC(conceptoCcrearpagrBeneficiarioC);

        instance.setConceptoCIdConcepto(Long.valueOf(0));
        instance.setConceptoCcodConceptoContrato(conceptoCcrearpatrcodConceptoContrato);
        instance.setConceptoCnombreConcepto(conceptoCcrearpatrnombreConcepto);
        instance.setConceptoCporcentajeConcepto(conceptoCcrearpatrporcentajeConcepto);
        instance.setConceptoCvalorConcepto(conceptoCcrearpatrvalorConcepto);

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
            com.keralty.aesolicitudes.viewmodel.conceptoc.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = conceptoCSrv.eliminarTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.conceptoc.siu.EliminarRequest request) throws ModelException {
        request.setConceptoCeliminarpthisConceptoCInstance(conceptoCSrv.getByOIDWithHV(request.getConceptoCeliminarpthisConceptoC()));
        return conceptoCSrv.eliminarImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.conceptoc.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ConceptoC conceptoCeliminarpthisConceptoC = request.getConceptoCeliminarpthisConceptoCInstance();

        request.checkArguments();
        ConceptoC instance = conceptoCeliminarpthisConceptoC;


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
            com.keralty.aesolicitudes.viewmodel.conceptoc.siu.TCREARFROMWSRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = conceptoCSrv.tCREARFROMWSTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.conceptoc.siu.TCREARFROMWSRequest request) throws ModelException {
        request.setConceptoCTCREARFROMWSpConceptoCInstance(conceptoCSrv.getByOIDWithHV(request.getConceptoCTCREARFROMWSpConceptoC()));
        request.setConceptoCTCREARFROMWSpBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getConceptoCTCREARFROMWSpBeneficiarioC()));
        return conceptoCSrv.tCREARFROMWSImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.conceptoc.siu.TCREARFROMWSRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        BeneficiarioC conceptoCTCREARFROMWSpBeneficiarioC = request.getConceptoCTCREARFROMWSpBeneficiarioCInstance();
        ConceptoC conceptoCTCREARFROMWSpConceptoC = request.getConceptoCTCREARFROMWSpConceptoCInstance();

        request.checkArguments();
        ConceptoC instance;

        com.keralty.aesolicitudes.viewmodel.conceptoc.siu.CrearRequest step1Request = new com.keralty.aesolicitudes.viewmodel.conceptoc.siu.CrearRequest();
        step1Request.setConceptoCcrearpagrBeneficiarioCInstance(conceptoCTCREARFROMWSpBeneficiarioC);
        step1Request.setConceptoCcrearpatrcodConceptoContrato(conceptoCTCREARFROMWSpConceptoC.getConceptoCcodConceptoContrato());
        step1Request.setConceptoCcrearpatrnombreConcepto(conceptoCTCREARFROMWSpConceptoC.getConceptoCnombreConcepto());
        step1Request.setConceptoCcrearpatrporcentajeConcepto(conceptoCTCREARFROMWSpConceptoC.getConceptoCporcentajeConcepto());
        step1Request.setConceptoCcrearpatrvalorConcepto(conceptoCTCREARFROMWSpConceptoC.getConceptoCvalorConcepto());
        instance = (ConceptoC) conceptoCSrv.crearImplementation(step1Request).getInstance();

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
        select.getOrderByPart().addItem(Constants.normalizePath(ConceptoCConstants.CLASS_NAME, ConceptoCConstants.ATTR_FIELD_CONCEPTOCIDCONCEPTO, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildConceptoCRelatedInstance(relatedInstanceJsonOid);
        }
        if (ConceptoCConstants.ROLE_NAME_BENEFICIARIOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildConceptoCRelatedInstance4BeneficiarioC(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildConceptoCRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new ConceptoC(mapper.readValue(relatedInstanceJsonOid, ConceptoCOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildConceptoCRelatedInstance4BeneficiarioC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new BeneficiarioC(mapper.readValue(relatedInstanceJsonOid, BeneficiarioCOid.class)): BeneficiarioC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ConceptoCOid oid = new ConceptoCOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ConceptoCConstants.ATTR_FIELD_CONCEPTOCIDCONCEPTO, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getConceptoCIdConcepto(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(ConceptoCService.class).error(e.getMessage());
        }
    }

}
