package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.global.AnexoMatConstants;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.AnexoMat;
import com.keralty.aesolicitudes.persistence.InstitucionMatNeo;
import com.keralty.aesolicitudes.persistence.oid.AnexoMatOid;
import com.keralty.aesolicitudes.persistence.oid.InstitucionMatNeoOid;
import com.keralty.aesolicitudes.persistence.oid.PeriodicidadOid;
import com.keralty.aesolicitudes.persistence.oid.UsuarioOid;
import com.keralty.aesolicitudes.persistence.Periodicidad;
import com.keralty.aesolicitudes.persistence.Usuario;
import com.keralty.aesolicitudes.repository.AnexoMatJpaRepository;
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
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class AnexoMatService extends AbstractService {

    AnexoMatJpaRepository repository;

    AnexoMatService anexoMatSrv;

    UsuarioService usuarioSrv;

    PeriodicidadService periodicidadSrv;

    InstitucionMatNeoService institucionMatNeoSrv;

    @Inject
    public AnexoMatService(
            AnexoMatService anexoMatSrv,
            UsuarioService usuarioSrv,
            PeriodicidadService periodicidadSrv,
            InstitucionMatNeoService institucionMatNeoSrv,
            AnexoMatJpaRepository repository) {
        this.anexoMatSrv = anexoMatSrv;
        this.usuarioSrv = usuarioSrv;
        this.periodicidadSrv = periodicidadSrv;
        this.institucionMatNeoSrv = institucionMatNeoSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, AnexoMatConstants.CLASS_NAME);
    }

    private List<AnexoMat> solveAnexoMatTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, AnexoMatConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveAnexoMatTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, AnexoMatConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class AnexoMat
     *
     * @return Population of class AnexoMat
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<AnexoMat> get() {
        List<AnexoMat> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class AnexoMat that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class AnexoMat matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<AnexoMat> get(QueryRequest queryRequest) {
        return solveAnexoMatTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveAnexoMatTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveAnexoMatTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveAnexoMatTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of AnexoMat by ID
     *
     * @param anexoMatIdentificador Identification field anexoMatIdentificador
     *
     * @return Instance of AnexoMat
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public AnexoMat getById(Long anexoMatIdentificador) {
        return getByOID(new AnexoMatOid(anexoMatIdentificador));
    }
    
    /*
     * Returns an instance of AnexoMat by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of AnexoMat
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public AnexoMat getByOID(AnexoMatOid oid) {
        Optional<AnexoMat> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of AnexoMat by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of AnexoMat
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public AnexoMat getByOIDWithHV(AnexoMatOid oid) {
        Optional<AnexoMat> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<AnexoMat> getInstanceByOid(AnexoMatOid oid) {
        return oid != null && oid.getAnexoMatIdentificador() != null
               ? repository.findById(oid.getAnexoMatIdentificador())
               : Optional.empty();
    }

    /*
     * Returns an instance of AnexoMat by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of AnexoMat
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public AnexoMat getByJsonOid(String jsonOid) {
        AnexoMatOid oid = new AnexoMatOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of AnexoMat related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of AnexoMat
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<AnexoMat> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveAnexoMatTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of AnexoMat related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of AnexoMat
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<AnexoMat> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of AnexoMat
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of AnexoMat
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getAnexoMatDynamic(AnexoMatOid oid, String displaySetItems) {
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
    public String getSuppInfo(AnexoMatOid oid, String dsName) {
        AnexoMat instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(AnexoMat instance, String dsName) {
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods


    /*
     * Solves the query needed for PIUAnexoMatNull
     *
     * @param queryRequest Query request
     * @return List of viewmodels for AnexoMat using displayset AutoDS that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aesolicitudes.viewmodel.anexomat.ds.AutoDS> piuPIUAnexoMatNull(QueryRequest queryRequest) {
        return solveAnexoMatTypedQuery(queryRequest).stream()
                .map(com.keralty.aesolicitudes.viewmodel.anexomat.ds.AutoDS::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUAnexoMatNull
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUAnexoMatNull
     */
    public int getCount4PIUAnexoMatNull(QueryRequest queryRequest) {
        return solveAnexoMatTypedQuery(queryRequest).size();
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
            com.keralty.aesolicitudes.viewmodel.anexomat.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = anexoMatSrv.eliminarTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.anexomat.siu.EliminarRequest request) throws ModelException {
        request.setAnexoMateliminarpthisAnexoMatInstance(anexoMatSrv.getByOIDWithHV(request.getAnexoMateliminarpthisAnexoMat()));
        return anexoMatSrv.eliminarImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.anexomat.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        AnexoMat anexoMateliminarpthisAnexoMat = request.getAnexoMateliminarpthisAnexoMatInstance();

        request.checkArguments();
        AnexoMat instance = anexoMateliminarpthisAnexoMat;

        instance.getUsuario().add2AnexoMat(null);

        repository.delete(instance);
        
        response.setInstance(instance);

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
        select.getOrderByPart().addItem(Constants.normalizePath(AnexoMatConstants.CLASS_NAME, AnexoMatConstants.ATTR_FIELD_ANEXOMATIDENTIFICADOR, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildAnexoMatRelatedInstance(relatedInstanceJsonOid);
        }
        if (AnexoMatConstants.ROLE_NAME_USUARIO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAnexoMatRelatedInstance4Usuario(relatedInstanceJsonOid, remainingPath);
        }
        if (AnexoMatConstants.ROLE_NAME_PERIODICIDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAnexoMatRelatedInstance4Periodicidad(relatedInstanceJsonOid, remainingPath);
        }
        if (AnexoMatConstants.ROLE_NAME_INSTITUCIONMATERNAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAnexoMatRelatedInstance4InstitucionMatNeo(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildAnexoMatRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new AnexoMat(mapper.readValue(relatedInstanceJsonOid, AnexoMatOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAnexoMatRelatedInstance4Usuario(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Usuario(mapper.readValue(relatedInstanceJsonOid, UsuarioOid.class)): Usuario.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAnexoMatRelatedInstance4Periodicidad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Periodicidad(mapper.readValue(relatedInstanceJsonOid, PeriodicidadOid.class)): Periodicidad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAnexoMatRelatedInstance4InstitucionMatNeo(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new InstitucionMatNeo(mapper.readValue(relatedInstanceJsonOid, InstitucionMatNeoOid.class)): InstitucionMatNeo.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            AnexoMatOid oid = new AnexoMatOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(AnexoMatConstants.ATTR_FIELD_ANEXOMATIDENTIFICADOR, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getAnexoMatIdentificador(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(AnexoMatService.class).error(e.getMessage());
        }
    }

}
