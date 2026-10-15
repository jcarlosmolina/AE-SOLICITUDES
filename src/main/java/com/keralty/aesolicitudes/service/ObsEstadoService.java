package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.exception.PreconditionException;
import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.AsesorConstants;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.DocumentoGConstants;
import com.keralty.aesolicitudes.global.FuncionarioConstants;
import com.keralty.aesolicitudes.global.ObsEstadoConstants;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.global.STDFunctions;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.Asesor;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.Funcionario;
import com.keralty.aesolicitudes.persistence.ObsEstado;
import com.keralty.aesolicitudes.persistence.oid.DocumentoGOid;
import com.keralty.aesolicitudes.persistence.oid.FuncionarioOid;
import com.keralty.aesolicitudes.persistence.oid.ObsEstadoOid;
import com.keralty.aesolicitudes.repository.ObsEstadoJpaRepository;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLWhereComparison;
import com.keralty.aesolicitudes.sqlutils.SQLWhereConjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereDisjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathInstance;
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
public class ObsEstadoService extends AbstractService {

    ObsEstadoJpaRepository repository;

    ObsEstadoService obsEstadoSrv;

    DocumentoGService documentoGSrv;

    @Inject
    public ObsEstadoService(
            ObsEstadoService obsEstadoSrv,
            DocumentoGService documentoGSrv,
            ObsEstadoJpaRepository repository) {
        this.obsEstadoSrv = obsEstadoSrv;
        this.documentoGSrv = documentoGSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, ObsEstadoConstants.CLASS_NAME);
    }

    private List<ObsEstado> solveObsEstadoTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, ObsEstadoConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveObsEstadoTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, ObsEstadoConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class ObsEstado
     *
     * @return Population of class ObsEstado
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ObsEstado> get() {
        List<ObsEstado> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class ObsEstado that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class ObsEstado matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ObsEstado> get(QueryRequest queryRequest) {
        return solveObsEstadoTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveObsEstadoTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveObsEstadoTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveObsEstadoTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of ObsEstado by ID
     *
     * @param documentoGIdentificador Identification field documentoGIdentificador
     *
     * @param obsEstadoId Identification field obsEstadoId
     *
     * @return Instance of ObsEstado
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ObsEstado getById(Long documentoGIdentificador, Long obsEstadoId) {
        return getByOID(new ObsEstadoOid(documentoGIdentificador, obsEstadoId));
    }
    
    /*
     * Returns an instance of ObsEstado by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ObsEstado
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ObsEstado getByOID(ObsEstadoOid oid) {
        Optional<ObsEstado> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of ObsEstado by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ObsEstado
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public ObsEstado getByOIDWithHV(ObsEstadoOid oid) {
        Optional<ObsEstado> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<ObsEstado> getInstanceByOid(ObsEstadoOid oid) {
        return oid != null && oid.getDocumentoGIdentificador() != null
               ? repository.findById(oid)
               : Optional.empty();
    }

    /*
     * Returns an instance of ObsEstado by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of ObsEstado
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public ObsEstado getByJsonOid(String jsonOid) {
        ObsEstadoOid oid = new ObsEstadoOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of ObsEstado related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ObsEstado
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ObsEstado> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveObsEstadoTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of ObsEstado related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ObsEstado
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ObsEstado> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of ObsEstado
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of ObsEstado
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getObsEstadoDynamic(ObsEstadoOid oid, String displaySetItems) {
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
    public String getSuppInfo(ObsEstadoOid oid, String dsName) {
        ObsEstado instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(ObsEstado instance, String dsName) {
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods


    /*
     * Solves the query needed for PIUObsEstado
     *
     * @param queryRequest Query request
     * @return List of viewmodels for ObsEstado using displayset DSObsEstadoPIU that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aesolicitudes.viewmodel.obsestado.ds.DSObsEstadoPIU> piuPIUObsEstado(QueryRequest queryRequest) {
        return solveObsEstadoTypedQuery(queryRequest).stream()
                .map(com.keralty.aesolicitudes.viewmodel.obsestado.ds.DSObsEstadoPIU::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUObsEstado
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUObsEstado
     */
    public int getCount4PIUObsEstado(QueryRequest queryRequest) {
        return solveObsEstadoTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUObsEstadoNull
     *
     * @param queryRequest Query request
     * @return List of viewmodels for ObsEstado using displayset DSObsEstadoNull that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aesolicitudes.viewmodel.obsestado.ds.DSObsEstadoNull> piuPIUObsEstadoNull(QueryRequest queryRequest) {
        return solveObsEstadoTypedQuery(queryRequest).stream()
                .map(com.keralty.aesolicitudes.viewmodel.obsestado.ds.DSObsEstadoNull::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUObsEstadoNull
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUObsEstadoNull
     */
    public int getCount4PIUObsEstadoNull(QueryRequest queryRequest) {
        return solveObsEstadoTypedQuery(queryRequest).size();
    }

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
            com.keralty.aesolicitudes.viewmodel.obsestado.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = obsEstadoSrv.crearTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.obsestado.siu.CrearRequest request) throws ModelException {
        request.setObsEstadocrearpagrAgenteInstance(funcionarioSrv.getByOIDWithHV(request.getObsEstadocrearpagrAgente()));
        request.setObsEstadocrearpagrDocumentoGInstance(documentoGSrv.getByOIDWithHV(request.getObsEstadocrearpagrDocumentoG()));
        return obsEstadoSrv.crearImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.obsestado.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario obsEstadocrearpagrAgente = request.getObsEstadocrearpagrAgenteInstance();
        DocumentoG obsEstadocrearpagrDocumentoG = request.getObsEstadocrearpagrDocumentoGInstance();
        String obsEstadocrearpatrObservacions = request.getObsEstadocrearpatrObservacions();
        Long obsEstadocrearpatrEstadoAnterior = request.getObsEstadocrearpatrEstadoAnterior();
        Long obsEstadocrearpatrEstadoNuevo = request.getObsEstadocrearpatrEstadoNuevo();

        request.checkArguments();
        ObsEstado instance = new ObsEstado();
        instance.add2Agente(obsEstadocrearpagrAgente);

        instance.add2DocumentoG(obsEstadocrearpagrDocumentoG);

        instance.setObsEstadoId(Long.valueOf(0));
        instance.setObsEstadoFecha(STDFunctions.systemDateTimeFun());
        instance.setObsEstadoId(repository.nextObsEstadoId(instance.getDocumentoGIdentificador()));
        instance.setObsEstadoObservacions(obsEstadocrearpatrObservacions);
        instance.setObsEstadoEstadoAnterior(obsEstadocrearpatrEstadoAnterior);
        instance.setObsEstadoEstadoNuevo(obsEstadocrearpatrEstadoNuevo);

        instance.setOid(instance.getOid());

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
            com.keralty.aesolicitudes.viewmodel.obsestado.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = obsEstadoSrv.eliminarTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.obsestado.siu.EliminarRequest request) throws ModelException {
        request.setObsEstadoeliminarpthisObsEstadoInstance(obsEstadoSrv.getByOIDWithHV(request.getObsEstadoeliminarpthisObsEstado()));
        return obsEstadoSrv.eliminarImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.obsestado.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ObsEstado obsEstadoeliminarpthisObsEstado = request.getObsEstadoeliminarpthisObsEstadoInstance();

        request.checkArguments();
        ObsEstado instance = obsEstadoeliminarpthisObsEstado;


        repository.delete(instance);
        
        response.setInstance(instance);

        return response;
    }

    // Service: modificar

    /*
     * Entry point for service modificar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse modificar(
            com.keralty.aesolicitudes.viewmodel.obsestado.siu.ModificarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = obsEstadoSrv.modificarTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service modificar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse modificarTxn(
            com.keralty.aesolicitudes.viewmodel.obsestado.siu.ModificarRequest request) throws ModelException {
        request.setObsEstadomodificarpthisObsEstadoInstance(obsEstadoSrv.getByOIDWithHV(request.getObsEstadomodificarpthisObsEstado()));
        return obsEstadoSrv.modificarImplementation(request);
    }

    /*
     * Implements service modificar
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse modificarImplementation(
            com.keralty.aesolicitudes.viewmodel.obsestado.siu.ModificarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ObsEstado obsEstadomodificarpthisObsEstado = request.getObsEstadomodificarpthisObsEstadoInstance();
        String obsEstadomodificarpObservacions = request.getObsEstadomodificarpObservacions();

        request.checkArguments();

        modificarPreconditions(request);
        ObsEstado instance = obsEstadomodificarpthisObsEstado;
        instance.setObsEstadoObservacions(obsEstadomodificarpObservacions);


        response.setInstance(repository.save(instance));

        return response;
    }

    /*
     * Checks service modificar preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse modificarCheckPreconditions(com.keralty.aesolicitudes.viewmodel.obsestado.siu.ModificarRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setObsEstadomodificarpthisObsEstadoInstance(obsEstadoSrv.getByOIDWithHV(request.getObsEstadomodificarpthisObsEstado()));
        try {
            if("Clas_1434446856192292Pre_1".equals(request.getPreconditionId()))
                checkClas1434446856192292Pre1(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void modificarPreconditions(
            com.keralty.aesolicitudes.viewmodel.obsestado.siu.ModificarRequest request) 
            throws ModelException {
        checkClas1434446856192292Pre1(request);
    }

    private void checkClas1434446856192292Pre1 (
            com.keralty.aesolicitudes.viewmodel.obsestado.siu.ModificarRequest request) 
            throws ModelException {
        // DocumentoG.Estado <> 2

        ObsEstado obsEstadomodificarpthisObsEstado = request.getObsEstadomodificarpthisObsEstadoInstance();
        boolean preconditionHolds = !(obsEstadomodificarpthisObsEstado.getDocumentoG().getDocumentoGEstado()).equals(Long.valueOf(2));
        if (!preconditionHolds) throw new PreconditionException("El documento ya se encuentra aprobado, no se puede modificar");
    }


    @Override
    protected void applyHVFilter(SQLSelect sql) throws SystemException {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        SQLWhereDisjunction disjunction = new SQLWhereDisjunction();
        if (getAgentRoles().contains(AsesorConstants.CLASS_NAME)) applyHVFilter4Asesor(sql, disjunction);
        conjunction.addDisjunction(disjunction);
        sql.addConjunction(conjunction);
    }

    private void applyHVFilter4Asesor(SQLSelect sql, SQLWhereDisjunction disjunction) {
        // DocumentoG.Solicitud.Agente = agent OR DocumentoG.Solicitud.Agente.CodJefe = Agent.Usuario
        Asesor agentInstance = getAgentAsesor();
    {
        // 'or' Logical operator
        SQLWhereDisjunction comparison1 = new SQLWhereDisjunction();
    
        // Operand 1
            // '=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(ObsEstadoConstants.ROLE_NAME_DOCUMENTOG + "." + DocumentoGConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AGENTE, FuncionarioConstants.CLASS_NAME);
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(Constants.AGENTKEYWORD, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, agentInstance.getOid(), Constants.AGENTKEYWORD);
            comparison2.setSecondOperand(operand224);
            comparison1.addOperand(comparison2);
    
        // Operand 2
            // '=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(ObsEstadoConstants.ROLE_NAME_DOCUMENTOG + "." + DocumentoGConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AGENTE + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOCODJEFE, Constants.Type.STRING.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(agentInstance.getFuncionarioUsuario(), Constants.Type.STRING.getTypeName()));
            comparison1.addOperand(comparison4);
        
        disjunction.addOperand(comparison1);
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
        select.getOrderByPart().addItem(Constants.normalizePath(ObsEstadoConstants.CLASS_NAME, ObsEstadoConstants.ROLE_NAME_DOCUMENTOG + "." + DocumentoGConstants.ATTR_FIELD_DOCUMENTOGIDENTIFICADOR, false), true);
        select.getOrderByPart().addItem(Constants.normalizePath(ObsEstadoConstants.CLASS_NAME, ObsEstadoConstants.ATTR_FIELD_OBSESTADOID, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildObsEstadoRelatedInstance(relatedInstanceJsonOid);
        }
        if (ObsEstadoConstants.ROLE_NAME_DOCUMENTOG.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildObsEstadoRelatedInstance4DocumentoG(relatedInstanceJsonOid, remainingPath);
        }
        if (ObsEstadoConstants.ROLE_NAME_AGENTE.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildObsEstadoRelatedInstance4Funcionario(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildObsEstadoRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new ObsEstado(mapper.readValue(relatedInstanceJsonOid, ObsEstadoOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildObsEstadoRelatedInstance4DocumentoG(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new DocumentoG(mapper.readValue(relatedInstanceJsonOid, DocumentoGOid.class)): DocumentoG.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildObsEstadoRelatedInstance4Funcionario(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Funcionario(mapper.readValue(relatedInstanceJsonOid, FuncionarioOid.class)): Funcionario.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ObsEstadoOid oid = new ObsEstadoOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ObsEstadoConstants.ROLE_NAME_DOCUMENTOG + "." + DocumentoGConstants.ATTR_FIELD_DOCUMENTOGIDENTIFICADOR, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getDocumentoGIdentificador(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(ObsEstadoConstants.ATTR_FIELD_OBSESTADOID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(oid.getObsEstadoId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison2);
        } catch (Exception e) {
            LoggerFactory.getLogger(ObsEstadoService.class).error(e.getMessage());
        }
    }

}
