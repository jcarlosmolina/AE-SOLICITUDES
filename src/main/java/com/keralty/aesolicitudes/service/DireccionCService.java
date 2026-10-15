package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.MinCardinalityException;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.DireccionCConstants;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;
import com.keralty.aesolicitudes.persistence.oid.PaisOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.TelefonoCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoDireccionOid;
import com.keralty.aesolicitudes.persistence.Pais;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.TelefonoC;
import com.keralty.aesolicitudes.persistence.TipoDireccion;
import com.keralty.aesolicitudes.repository.DireccionCJpaRepository;
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
public class DireccionCService extends AbstractService {

    DireccionCJpaRepository repository;

    DireccionCService direccionCSrv;

    TipoDireccionService tipoDireccionSrv;

    DepartamentoService departamentoSrv;

    MunicipioService municipioSrv;

    PaisService paisSrv;

    ContratoCService contratoCSrv;

    PersonaCService personaCSrv;

    TelefonoCService telefonoCSrv;

    @Inject
    public DireccionCService(
            DireccionCService direccionCSrv,
            TipoDireccionService tipoDireccionSrv,
            DepartamentoService departamentoSrv,
            MunicipioService municipioSrv,
            PaisService paisSrv,
            ContratoCService contratoCSrv,
            PersonaCService personaCSrv,
            TelefonoCService telefonoCSrv,
            DireccionCJpaRepository repository) {
        this.direccionCSrv = direccionCSrv;
        this.tipoDireccionSrv = tipoDireccionSrv;
        this.departamentoSrv = departamentoSrv;
        this.municipioSrv = municipioSrv;
        this.paisSrv = paisSrv;
        this.contratoCSrv = contratoCSrv;
        this.personaCSrv = personaCSrv;
        this.telefonoCSrv = telefonoCSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, DireccionCConstants.CLASS_NAME);
    }

    private List<DireccionC> solveDireccionCTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, DireccionCConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveDireccionCTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, DireccionCConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class DireccionC
     *
     * @return Population of class DireccionC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<DireccionC> get() {
        List<DireccionC> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class DireccionC that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class DireccionC matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<DireccionC> get(QueryRequest queryRequest) {
        return solveDireccionCTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveDireccionCTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveDireccionCTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveDireccionCTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of DireccionC by ID
     *
     * @param direccionCCodigo Identification field direccionCCodigo
     *
     * @return Instance of DireccionC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public DireccionC getById(Long direccionCCodigo) {
        return getByOID(new DireccionCOid(direccionCCodigo));
    }
    
    /*
     * Returns an instance of DireccionC by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of DireccionC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public DireccionC getByOID(DireccionCOid oid) {
        Optional<DireccionC> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of DireccionC by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of DireccionC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public DireccionC getByOIDWithHV(DireccionCOid oid) {
        Optional<DireccionC> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<DireccionC> getInstanceByOid(DireccionCOid oid) {
        return oid != null && oid.getDireccionCCodigo() != null
               ? repository.findById(oid.getDireccionCCodigo())
               : Optional.empty();
    }

    /*
     * Returns an instance of DireccionC by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of DireccionC
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public DireccionC getByJsonOid(String jsonOid) {
        DireccionCOid oid = new DireccionCOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of DireccionC related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of DireccionC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<DireccionC> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveDireccionCTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of DireccionC related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of DireccionC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<DireccionC> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of DireccionC
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of DireccionC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getDireccionCDynamic(DireccionCOid oid, String displaySetItems) {
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
    public String getSuppInfo(DireccionCOid oid, String dsName) {
        DireccionC instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(DireccionC instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = direccionCSrv.crearTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.CrearRequest request) {
        request.setDireccionCcrearpagrTipoDireccionCInstance(tipoDireccionSrv.getByOIDWithHV(request.getDireccionCcrearpagrTipoDireccionC()));
        request.setDireccionCcrearpagrDepartamentoCInstance(departamentoSrv.getByOIDWithHV(request.getDireccionCcrearpagrDepartamentoC()));
        request.setDireccionCcrearpagrMunicipioCInstance(municipioSrv.getByOIDWithHV(request.getDireccionCcrearpagrMunicipioC()));
        request.setDireccionCcrearpagrPaisCInstance(paisSrv.getByOIDWithHV(request.getDireccionCcrearpagrPaisC()));
        request.setDireccionCcrearpagrContratoCInstance(contratoCSrv.getByOIDWithHV(request.getDireccionCcrearpagrContratoC()));
        request.setDireccionCcrearpagrPersonaCInstance(personaCSrv.getByOIDWithHV(request.getDireccionCcrearpagrPersonaC()));
        return direccionCSrv.crearImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        TipoDireccion direccionCcrearpagrTipoDireccionC = request.getDireccionCcrearpagrTipoDireccionCInstance();
        Departamento direccionCcrearpagrDepartamentoC = request.getDireccionCcrearpagrDepartamentoCInstance();
        Municipio direccionCcrearpagrMunicipioC = request.getDireccionCcrearpagrMunicipioCInstance();
        Pais direccionCcrearpagrPaisC = request.getDireccionCcrearpagrPaisCInstance();
        ContratoC direccionCcrearpagrContratoC = request.getDireccionCcrearpagrContratoCInstance();
        PersonaC direccionCcrearpagrPersonaC = request.getDireccionCcrearpagrPersonaCInstance();
        String direccionCcrearpatrDireccionCompleta = request.getDireccionCcrearpatrDireccionCompleta();
        String direccionCcrearpatrLocalidad = request.getDireccionCcrearpatrLocalidad();
        DireccionC instance = new DireccionC();
        if (direccionCcrearpagrTipoDireccionC != null && !direccionCcrearpagrTipoDireccionC.isNull()) {
            instance.add2TipoDireccionC(direccionCcrearpagrTipoDireccionC);
        }

        if (direccionCcrearpagrDepartamentoC != null && !direccionCcrearpagrDepartamentoC.isNull()) {
            instance.add2DepartamentoC(direccionCcrearpagrDepartamentoC);
        }

        if (direccionCcrearpagrMunicipioC != null && !direccionCcrearpagrMunicipioC.isNull()) {
            instance.add2MunicipioC(direccionCcrearpagrMunicipioC);
        }

        if (direccionCcrearpagrPaisC != null && !direccionCcrearpagrPaisC.isNull()) {
            instance.add2PaisC(direccionCcrearpagrPaisC);
        }

        if (direccionCcrearpagrContratoC != null && !direccionCcrearpagrContratoC.isNull()) {
            instance.add2ContratoC(direccionCcrearpagrContratoC);
        }

        if (direccionCcrearpagrPersonaC != null && !direccionCcrearpagrPersonaC.isNull()) {
            instance.add2PersonaC(direccionCcrearpagrPersonaC);
        }

        instance.setDireccionCCodigo(Long.valueOf(0));
        instance.setDireccionCDireccionCompleta(direccionCcrearpatrDireccionCompleta);
        instance.setDireccionCLocalidad(direccionCcrearpatrLocalidad);

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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = direccionCSrv.eliminarTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.EliminarRequest request) throws ModelException {
        request.setDireccionCeliminarpthisDireccionCInstance(direccionCSrv.getByOIDWithHV(request.getDireccionCeliminarpthisDireccionC()));
        return direccionCSrv.eliminarImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DireccionC direccionCeliminarpthisDireccionC = request.getDireccionCeliminarpthisDireccionCInstance();

        request.checkArguments();
        DireccionC instance = direccionCeliminarpthisDireccionC;
        if(direccionCeliminarpthisDireccionC.getTelefonosC().size() > 0) {
            throw new MinCardinalityException(DireccionCConstants.CLASS_ALIAS, DireccionCConstants.ROLE_ALIAS_TELEFONOSC);
        }


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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.ModificarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = direccionCSrv.modificarTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.ModificarRequest request) throws ModelException {
        request.setDireccionCmodificarpthisDireccionCInstance(direccionCSrv.getByOIDWithHV(request.getDireccionCmodificarpthisDireccionC()));
        return direccionCSrv.modificarImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.ModificarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DireccionC direccionCmodificarpthisDireccionC = request.getDireccionCmodificarpthisDireccionCInstance();
        String direccionCmodificarpDireccionCompleta = request.getDireccionCmodificarpDireccionCompleta();
        String direccionCmodificarpLocalidad = request.getDireccionCmodificarpLocalidad();

        request.checkArguments();
        DireccionC instance = direccionCmodificarpthisDireccionC;
        instance.setDireccionCDireccionCompleta(direccionCmodificarpDireccionCompleta);
        instance.setDireccionCLocalidad(direccionCmodificarpLocalidad);


        response.setInstance(repository.save(instance));

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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsTipoDireccionCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = direccionCSrv.insTipoDireccionCTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsTipoDireccionCRequest request) throws ModelException {
        request.setDireccionCInsTipoDireccionCpthisDireccionCInstance(direccionCSrv.getByOIDWithHV(request.getDireccionCInsTipoDireccionCpthisDireccionC()));
        request.setDireccionCInsTipoDireccionCpevcTipoDireccionInstance(tipoDireccionSrv.getByOIDWithHV(request.getDireccionCInsTipoDireccionCpevcTipoDireccion()));
        return direccionCSrv.insTipoDireccionCImplementation(request, true);
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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsTipoDireccionCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DireccionC direccionCInsTipoDireccionCpthisDireccionC = request.getDireccionCInsTipoDireccionCpthisDireccionCInstance();
        TipoDireccion direccionCInsTipoDireccionCpevcTipoDireccion = request.getDireccionCInsTipoDireccionCpevcTipoDireccionInstance();

        request.checkArguments();
        DireccionC instance = direccionCInsTipoDireccionCpthisDireccionC;

        instance.add2TipoDireccionC(direccionCInsTipoDireccionCpevcTipoDireccion);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.tipodireccion.siu.InsTipoDireccionCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.tipodireccion.siu.InsTipoDireccionCRequest();
            relatedRequest.setTipoDireccionInsTipoDireccionCpthisTipoDireccionInstance(direccionCInsTipoDireccionCpevcTipoDireccion);
            relatedRequest.setTipoDireccionInsTipoDireccionCpevcDireccionCInstance(direccionCInsTipoDireccionCpthisDireccionC);
            tipoDireccionSrv.insTipoDireccionCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelTipoDireccionCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = direccionCSrv.delTipoDireccionCTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelTipoDireccionCRequest request) throws ModelException {
        request.setDireccionCDelTipoDireccionCpthisDireccionCInstance(direccionCSrv.getByOIDWithHV(request.getDireccionCDelTipoDireccionCpthisDireccionC()));
        request.setDireccionCDelTipoDireccionCpevcTipoDireccionInstance(tipoDireccionSrv.getByOIDWithHV(request.getDireccionCDelTipoDireccionCpevcTipoDireccion()));
        return direccionCSrv.delTipoDireccionCImplementation(request, true);
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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelTipoDireccionCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DireccionC direccionCDelTipoDireccionCpthisDireccionC = request.getDireccionCDelTipoDireccionCpthisDireccionCInstance();
        TipoDireccion direccionCDelTipoDireccionCpevcTipoDireccion = request.getDireccionCDelTipoDireccionCpevcTipoDireccionInstance();

        request.checkArguments();
        DireccionC instance = direccionCDelTipoDireccionCpthisDireccionC;

        instance.add2TipoDireccionC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.tipodireccion.siu.DelTipoDireccionCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.tipodireccion.siu.DelTipoDireccionCRequest();
            relatedRequest.setTipoDireccionDelTipoDireccionCpthisTipoDireccionInstance(direccionCDelTipoDireccionCpevcTipoDireccion);
            relatedRequest.setTipoDireccionDelTipoDireccionCpevcDireccionCInstance(direccionCDelTipoDireccionCpthisDireccionC);
            tipoDireccionSrv.delTipoDireccionCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsDepartamentoC

    /*
     * Entry point for service InsDepartamentoC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insDepartamentoC(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsDepartamentoCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = direccionCSrv.insDepartamentoCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsDepartamentoC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insDepartamentoCTxn(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsDepartamentoCRequest request) throws ModelException {
        request.setDireccionCInsDepartamentoCpthisDireccionCInstance(direccionCSrv.getByOIDWithHV(request.getDireccionCInsDepartamentoCpthisDireccionC()));
        request.setDireccionCInsDepartamentoCpevcDepartamentoInstance(departamentoSrv.getByOIDWithHV(request.getDireccionCInsDepartamentoCpevcDepartamento()));
        return direccionCSrv.insDepartamentoCImplementation(request, true);
    }

    /*
     * Implements service InsDepartamentoC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insDepartamentoCImplementation(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsDepartamentoCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DireccionC direccionCInsDepartamentoCpthisDireccionC = request.getDireccionCInsDepartamentoCpthisDireccionCInstance();
        Departamento direccionCInsDepartamentoCpevcDepartamento = request.getDireccionCInsDepartamentoCpevcDepartamentoInstance();

        request.checkArguments();
        DireccionC instance = direccionCInsDepartamentoCpthisDireccionC;

        instance.add2DepartamentoC(direccionCInsDepartamentoCpevcDepartamento);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.departamento.siu.InsDepartamentoCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.departamento.siu.InsDepartamentoCRequest();
            relatedRequest.setDepartamentoInsDepartamentoCpthisDepartamentoInstance(direccionCInsDepartamentoCpevcDepartamento);
            relatedRequest.setDepartamentoInsDepartamentoCpevcDireccionCInstance(direccionCInsDepartamentoCpthisDireccionC);
            departamentoSrv.insDepartamentoCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelDepartamentoC

    /*
     * Entry point for service DelDepartamentoC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delDepartamentoC(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelDepartamentoCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = direccionCSrv.delDepartamentoCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelDepartamentoC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delDepartamentoCTxn(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelDepartamentoCRequest request) throws ModelException {
        request.setDireccionCDelDepartamentoCpthisDireccionCInstance(direccionCSrv.getByOIDWithHV(request.getDireccionCDelDepartamentoCpthisDireccionC()));
        request.setDireccionCDelDepartamentoCpevcDepartamentoInstance(departamentoSrv.getByOIDWithHV(request.getDireccionCDelDepartamentoCpevcDepartamento()));
        return direccionCSrv.delDepartamentoCImplementation(request, true);
    }

    /*
     * Implements service DelDepartamentoC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delDepartamentoCImplementation(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelDepartamentoCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DireccionC direccionCDelDepartamentoCpthisDireccionC = request.getDireccionCDelDepartamentoCpthisDireccionCInstance();
        Departamento direccionCDelDepartamentoCpevcDepartamento = request.getDireccionCDelDepartamentoCpevcDepartamentoInstance();

        request.checkArguments();
        DireccionC instance = direccionCDelDepartamentoCpthisDireccionC;

        instance.add2DepartamentoC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.departamento.siu.DelDepartamentoCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.departamento.siu.DelDepartamentoCRequest();
            relatedRequest.setDepartamentoDelDepartamentoCpthisDepartamentoInstance(direccionCDelDepartamentoCpevcDepartamento);
            relatedRequest.setDepartamentoDelDepartamentoCpevcDireccionCInstance(direccionCDelDepartamentoCpthisDireccionC);
            departamentoSrv.delDepartamentoCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsMunicipioC

    /*
     * Entry point for service InsMunicipioC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insMunicipioC(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsMunicipioCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = direccionCSrv.insMunicipioCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsMunicipioC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insMunicipioCTxn(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsMunicipioCRequest request) throws ModelException {
        request.setDireccionCInsMunicipioCpthisDireccionCInstance(direccionCSrv.getByOIDWithHV(request.getDireccionCInsMunicipioCpthisDireccionC()));
        request.setDireccionCInsMunicipioCpevcMunicipioInstance(municipioSrv.getByOIDWithHV(request.getDireccionCInsMunicipioCpevcMunicipio()));
        return direccionCSrv.insMunicipioCImplementation(request, true);
    }

    /*
     * Implements service InsMunicipioC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insMunicipioCImplementation(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsMunicipioCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DireccionC direccionCInsMunicipioCpthisDireccionC = request.getDireccionCInsMunicipioCpthisDireccionCInstance();
        Municipio direccionCInsMunicipioCpevcMunicipio = request.getDireccionCInsMunicipioCpevcMunicipioInstance();

        request.checkArguments();
        DireccionC instance = direccionCInsMunicipioCpthisDireccionC;

        instance.add2MunicipioC(direccionCInsMunicipioCpevcMunicipio);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.municipio.siu.InsMunicipioCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.municipio.siu.InsMunicipioCRequest();
            relatedRequest.setMunicipioInsMunicipioCpthisMunicipioInstance(direccionCInsMunicipioCpevcMunicipio);
            relatedRequest.setMunicipioInsMunicipioCpevcDireccionCInstance(direccionCInsMunicipioCpthisDireccionC);
            municipioSrv.insMunicipioCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelMunicipioC

    /*
     * Entry point for service DelMunicipioC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delMunicipioC(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelMunicipioCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = direccionCSrv.delMunicipioCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelMunicipioC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delMunicipioCTxn(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelMunicipioCRequest request) throws ModelException {
        request.setDireccionCDelMunicipioCpthisDireccionCInstance(direccionCSrv.getByOIDWithHV(request.getDireccionCDelMunicipioCpthisDireccionC()));
        request.setDireccionCDelMunicipioCpevcMunicipioInstance(municipioSrv.getByOIDWithHV(request.getDireccionCDelMunicipioCpevcMunicipio()));
        return direccionCSrv.delMunicipioCImplementation(request, true);
    }

    /*
     * Implements service DelMunicipioC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delMunicipioCImplementation(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelMunicipioCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DireccionC direccionCDelMunicipioCpthisDireccionC = request.getDireccionCDelMunicipioCpthisDireccionCInstance();
        Municipio direccionCDelMunicipioCpevcMunicipio = request.getDireccionCDelMunicipioCpevcMunicipioInstance();

        request.checkArguments();
        DireccionC instance = direccionCDelMunicipioCpthisDireccionC;

        instance.add2MunicipioC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.municipio.siu.DelMunicipioCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.municipio.siu.DelMunicipioCRequest();
            relatedRequest.setMunicipioDelMunicipioCpthisMunicipioInstance(direccionCDelMunicipioCpevcMunicipio);
            relatedRequest.setMunicipioDelMunicipioCpevcDireccionCInstance(direccionCDelMunicipioCpthisDireccionC);
            municipioSrv.delMunicipioCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsPaisCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = direccionCSrv.insPaisCTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsPaisCRequest request) throws ModelException {
        request.setDireccionCInsPaisCpthisDireccionCInstance(direccionCSrv.getByOIDWithHV(request.getDireccionCInsPaisCpthisDireccionC()));
        request.setDireccionCInsPaisCpevcPaisInstance(paisSrv.getByOIDWithHV(request.getDireccionCInsPaisCpevcPais()));
        return direccionCSrv.insPaisCImplementation(request, true);
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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsPaisCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DireccionC direccionCInsPaisCpthisDireccionC = request.getDireccionCInsPaisCpthisDireccionCInstance();
        Pais direccionCInsPaisCpevcPais = request.getDireccionCInsPaisCpevcPaisInstance();

        request.checkArguments();
        DireccionC instance = direccionCInsPaisCpthisDireccionC;

        instance.add2PaisC(direccionCInsPaisCpevcPais);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.pais.siu.InsPaisCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.pais.siu.InsPaisCRequest();
            relatedRequest.setPaisInsPaisCpthisPaisInstance(direccionCInsPaisCpevcPais);
            relatedRequest.setPaisInsPaisCpevcDireccionCInstance(direccionCInsPaisCpthisDireccionC);
            paisSrv.insPaisCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelPaisCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = direccionCSrv.delPaisCTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelPaisCRequest request) throws ModelException {
        request.setDireccionCDelPaisCpthisDireccionCInstance(direccionCSrv.getByOIDWithHV(request.getDireccionCDelPaisCpthisDireccionC()));
        request.setDireccionCDelPaisCpevcPaisInstance(paisSrv.getByOIDWithHV(request.getDireccionCDelPaisCpevcPais()));
        return direccionCSrv.delPaisCImplementation(request, true);
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
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelPaisCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DireccionC direccionCDelPaisCpthisDireccionC = request.getDireccionCDelPaisCpthisDireccionCInstance();
        Pais direccionCDelPaisCpevcPais = request.getDireccionCDelPaisCpevcPaisInstance();

        request.checkArguments();
        DireccionC instance = direccionCDelPaisCpthisDireccionC;

        instance.add2PaisC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.pais.siu.DelPaisCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.pais.siu.DelPaisCRequest();
            relatedRequest.setPaisDelPaisCpthisPaisInstance(direccionCDelPaisCpevcPais);
            relatedRequest.setPaisDelPaisCpevcDireccionCInstance(direccionCDelPaisCpthisDireccionC);
            paisSrv.delPaisCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: TMODIFICAR

    /*
     * Entry point for service TMODIFICAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tMODIFICAR(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.TMODIFICARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = direccionCSrv.tMODIFICARTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TMODIFICAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tMODIFICARTxn(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.TMODIFICARRequest request) throws ModelException, SystemException {
        request.setDireccionCTMODIFICARpthisDireccionCInstance(direccionCSrv.getByOIDWithHV(request.getDireccionCTMODIFICARpthisDireccionC()));
        request.setDireccionCTMODIFICARptpevcDepartamentoCInstance(departamentoSrv.getByOIDWithHV(request.getDireccionCTMODIFICARptpevcDepartamentoC()));
        request.setDireccionCTMODIFICARptpevcMunicipioCInstance(municipioSrv.getByOIDWithHV(request.getDireccionCTMODIFICARptpevcMunicipioC()));
        request.setDireccionCTMODIFICARptpevcPaisCInstance(paisSrv.getByOIDWithHV(request.getDireccionCTMODIFICARptpevcPaisC()));
        request.setDireccionCTMODIFICARptpevcTipoDireccionCInstance(tipoDireccionSrv.getByOIDWithHV(request.getDireccionCTMODIFICARptpevcTipoDireccionC()));
        return direccionCSrv.tMODIFICARImplementation(request);
    }

    /*
     * Implements service TMODIFICAR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tMODIFICARImplementation(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.TMODIFICARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        String direccionCTMODIFICARptpDireccionCompleta = request.getDireccionCTMODIFICARptpDireccionCompleta();
        String direccionCTMODIFICARptpLocalidad = request.getDireccionCTMODIFICARptpLocalidad();
        Departamento direccionCTMODIFICARptpevcDepartamentoC = request.getDireccionCTMODIFICARptpevcDepartamentoCInstance();
        Municipio direccionCTMODIFICARptpevcMunicipioC = request.getDireccionCTMODIFICARptpevcMunicipioCInstance();
        Pais direccionCTMODIFICARptpevcPaisC = request.getDireccionCTMODIFICARptpevcPaisCInstance();
        TipoDireccion direccionCTMODIFICARptpevcTipoDireccionC = request.getDireccionCTMODIFICARptpevcTipoDireccionCInstance();
        DireccionC direccionCTMODIFICARpthisDireccionC = request.getDireccionCTMODIFICARpthisDireccionCInstance();

        request.checkArguments();
        DireccionC instance = direccionCTMODIFICARpthisDireccionC;

        com.keralty.aesolicitudes.viewmodel.direccionc.siu.ModificarRequest step1Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.ModificarRequest();
        step1Request.setDireccionCmodificarpthisDireccionCInstance(direccionCTMODIFICARpthisDireccionC);
        step1Request.setDireccionCmodificarpDireccionCompleta(direccionCTMODIFICARptpDireccionCompleta);
        step1Request.setDireccionCmodificarpLocalidad(direccionCTMODIFICARptpLocalidad);
        direccionCSrv.modificarImplementation(step1Request);

        boolean guard2 = repository.assocOperator002(direccionCTMODIFICARpthisDireccionC).equals(false) && (direccionCTMODIFICARptpevcDepartamentoC != null && !direccionCTMODIFICARptpevcDepartamentoC.isNull());

        if (guard2) {
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsDepartamentoCRequest step2Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsDepartamentoCRequest();
            step2Request.setDireccionCInsDepartamentoCpthisDireccionCInstance(direccionCTMODIFICARpthisDireccionC);
            step2Request.setDireccionCInsDepartamentoCpevcDepartamentoInstance(direccionCTMODIFICARptpevcDepartamentoC);
            direccionCSrv.insDepartamentoCImplementation(step2Request, true);
        }

        boolean guard3 = repository.assocOperator003(direccionCTMODIFICARpthisDireccionC).equals(true) && (direccionCTMODIFICARptpevcDepartamentoC == null || direccionCTMODIFICARptpevcDepartamentoC.isNull());

        if (guard3) {
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelDepartamentoCRequest step3Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelDepartamentoCRequest();
            step3Request.setDireccionCDelDepartamentoCpthisDireccionCInstance(direccionCTMODIFICARpthisDireccionC);
            step3Request.setDireccionCDelDepartamentoCpevcDepartamentoInstance(direccionCTMODIFICARpthisDireccionC.getDepartamentoC());
            direccionCSrv.delDepartamentoCImplementation(step3Request, true);
        }

        /* Action 4: IF (EXIST (DepartamentoC) = true AND ptpevcDepartamentoC <> NULL AND DepartamentoC <> ptpevcDepartamentoC) */
        boolean ifCondition4 = repository.assocOperator014(direccionCTMODIFICARpthisDireccionC).equals(true) && (direccionCTMODIFICARptpevcDepartamentoC != null && !direccionCTMODIFICARptpevcDepartamentoC.isNull()) && !(direccionCTMODIFICARpthisDireccionC.getDepartamentoC().equalsObject(direccionCTMODIFICARptpevcDepartamentoC));
        if (ifCondition4) {
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelDepartamentoCRequest step40Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelDepartamentoCRequest();
            step40Request.setDireccionCDelDepartamentoCpthisDireccionCInstance(direccionCTMODIFICARpthisDireccionC);
            step40Request.setDireccionCDelDepartamentoCpevcDepartamentoInstance(direccionCTMODIFICARpthisDireccionC.getDepartamentoC());
            direccionCSrv.delDepartamentoCImplementation(step40Request, true);
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsDepartamentoCRequest step41Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsDepartamentoCRequest();
            step41Request.setDireccionCInsDepartamentoCpthisDireccionCInstance(direccionCTMODIFICARpthisDireccionC);
            step41Request.setDireccionCInsDepartamentoCpevcDepartamentoInstance(direccionCTMODIFICARptpevcDepartamentoC);
            direccionCSrv.insDepartamentoCImplementation(step41Request, true);
        }

        boolean guard5 = repository.assocOperator005(direccionCTMODIFICARpthisDireccionC).equals(false) && (direccionCTMODIFICARptpevcMunicipioC != null && !direccionCTMODIFICARptpevcMunicipioC.isNull());

        if (guard5) {
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsMunicipioCRequest step5Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsMunicipioCRequest();
            step5Request.setDireccionCInsMunicipioCpthisDireccionCInstance(direccionCTMODIFICARpthisDireccionC);
            step5Request.setDireccionCInsMunicipioCpevcMunicipioInstance(direccionCTMODIFICARptpevcMunicipioC);
            direccionCSrv.insMunicipioCImplementation(step5Request, true);
        }

        boolean guard6 = repository.assocOperator006(direccionCTMODIFICARpthisDireccionC).equals(true) && (direccionCTMODIFICARptpevcMunicipioC == null || direccionCTMODIFICARptpevcMunicipioC.isNull());

        if (guard6) {
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelMunicipioCRequest step6Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelMunicipioCRequest();
            step6Request.setDireccionCDelMunicipioCpthisDireccionCInstance(direccionCTMODIFICARpthisDireccionC);
            step6Request.setDireccionCDelMunicipioCpevcMunicipioInstance(direccionCTMODIFICARpthisDireccionC.getMunicipioC());
            direccionCSrv.delMunicipioCImplementation(step6Request, true);
        }

        /* Action 7: IF (EXIST (MunicipioC) = true AND ptpevcMunicipioC <> NULL AND MunicipioC <> ptpevcMunicipioC) */
        boolean ifCondition7 = repository.assocOperator015(direccionCTMODIFICARpthisDireccionC).equals(true) && (direccionCTMODIFICARptpevcMunicipioC != null && !direccionCTMODIFICARptpevcMunicipioC.isNull()) && !(direccionCTMODIFICARpthisDireccionC.getMunicipioC().equalsObject(direccionCTMODIFICARptpevcMunicipioC));
        if (ifCondition7) {
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelMunicipioCRequest step70Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelMunicipioCRequest();
            step70Request.setDireccionCDelMunicipioCpthisDireccionCInstance(direccionCTMODIFICARpthisDireccionC);
            step70Request.setDireccionCDelMunicipioCpevcMunicipioInstance(direccionCTMODIFICARpthisDireccionC.getMunicipioC());
            direccionCSrv.delMunicipioCImplementation(step70Request, true);
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsMunicipioCRequest step71Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsMunicipioCRequest();
            step71Request.setDireccionCInsMunicipioCpthisDireccionCInstance(direccionCTMODIFICARpthisDireccionC);
            step71Request.setDireccionCInsMunicipioCpevcMunicipioInstance(direccionCTMODIFICARptpevcMunicipioC);
            direccionCSrv.insMunicipioCImplementation(step71Request, true);
        }

        boolean guard8 = repository.assocOperator008(direccionCTMODIFICARpthisDireccionC).equals(false) && (direccionCTMODIFICARptpevcPaisC != null && !direccionCTMODIFICARptpevcPaisC.isNull());

        if (guard8) {
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsPaisCRequest step8Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsPaisCRequest();
            step8Request.setDireccionCInsPaisCpthisDireccionCInstance(direccionCTMODIFICARpthisDireccionC);
            step8Request.setDireccionCInsPaisCpevcPaisInstance(direccionCTMODIFICARptpevcPaisC);
            direccionCSrv.insPaisCImplementation(step8Request, true);
        }

        boolean guard9 = repository.assocOperator009(direccionCTMODIFICARpthisDireccionC).equals(true) && (direccionCTMODIFICARptpevcPaisC == null || direccionCTMODIFICARptpevcPaisC.isNull());

        if (guard9) {
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelPaisCRequest step9Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelPaisCRequest();
            step9Request.setDireccionCDelPaisCpthisDireccionCInstance(direccionCTMODIFICARpthisDireccionC);
            step9Request.setDireccionCDelPaisCpevcPaisInstance(direccionCTMODIFICARpthisDireccionC.getPaisC());
            direccionCSrv.delPaisCImplementation(step9Request, true);
        }

        /* Action 10: IF (EXIST (PaisC) = true AND ptpevcPaisC <> NULL AND PaisC <> ptpevcPaisC) */
        boolean ifCondition10 = repository.assocOperator016(direccionCTMODIFICARpthisDireccionC).equals(true) && (direccionCTMODIFICARptpevcPaisC != null && !direccionCTMODIFICARptpevcPaisC.isNull()) && !(direccionCTMODIFICARpthisDireccionC.getPaisC().equalsObject(direccionCTMODIFICARptpevcPaisC));
        if (ifCondition10) {
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelPaisCRequest step100Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelPaisCRequest();
            step100Request.setDireccionCDelPaisCpthisDireccionCInstance(direccionCTMODIFICARpthisDireccionC);
            step100Request.setDireccionCDelPaisCpevcPaisInstance(direccionCTMODIFICARpthisDireccionC.getPaisC());
            direccionCSrv.delPaisCImplementation(step100Request, true);
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsPaisCRequest step101Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsPaisCRequest();
            step101Request.setDireccionCInsPaisCpthisDireccionCInstance(direccionCTMODIFICARpthisDireccionC);
            step101Request.setDireccionCInsPaisCpevcPaisInstance(direccionCTMODIFICARptpevcPaisC);
            direccionCSrv.insPaisCImplementation(step101Request, true);
        }

        boolean guard11 = repository.assocOperator011(direccionCTMODIFICARpthisDireccionC).equals(false) && (direccionCTMODIFICARptpevcTipoDireccionC != null && !direccionCTMODIFICARptpevcTipoDireccionC.isNull());

        if (guard11) {
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsTipoDireccionCRequest step11Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsTipoDireccionCRequest();
            step11Request.setDireccionCInsTipoDireccionCpthisDireccionCInstance(direccionCTMODIFICARpthisDireccionC);
            step11Request.setDireccionCInsTipoDireccionCpevcTipoDireccionInstance(direccionCTMODIFICARptpevcTipoDireccionC);
            direccionCSrv.insTipoDireccionCImplementation(step11Request, true);
        }

        boolean guard12 = repository.assocOperator012(direccionCTMODIFICARpthisDireccionC).equals(true) && (direccionCTMODIFICARptpevcTipoDireccionC == null || direccionCTMODIFICARptpevcTipoDireccionC.isNull());

        if (guard12) {
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelTipoDireccionCRequest step12Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelTipoDireccionCRequest();
            step12Request.setDireccionCDelTipoDireccionCpthisDireccionCInstance(direccionCTMODIFICARpthisDireccionC);
            step12Request.setDireccionCDelTipoDireccionCpevcTipoDireccionInstance(direccionCTMODIFICARpthisDireccionC.getTipoDireccionC());
            direccionCSrv.delTipoDireccionCImplementation(step12Request, true);
        }

        /* Action 13: IF (EXIST (TipoDireccionC) = true AND ptpevcTipoDireccionC <> NULL AND TipoDireccionC <> ptpevcTipoDireccionC) */
        boolean ifCondition13 = repository.assocOperator017(direccionCTMODIFICARpthisDireccionC).equals(true) && (direccionCTMODIFICARptpevcTipoDireccionC != null && !direccionCTMODIFICARptpevcTipoDireccionC.isNull()) && !(direccionCTMODIFICARpthisDireccionC.getTipoDireccionC().equalsObject(direccionCTMODIFICARptpevcTipoDireccionC));
        if (ifCondition13) {
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelTipoDireccionCRequest step130Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.DelTipoDireccionCRequest();
            step130Request.setDireccionCDelTipoDireccionCpthisDireccionCInstance(direccionCTMODIFICARpthisDireccionC);
            step130Request.setDireccionCDelTipoDireccionCpevcTipoDireccionInstance(direccionCTMODIFICARpthisDireccionC.getTipoDireccionC());
            direccionCSrv.delTipoDireccionCImplementation(step130Request, true);
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsTipoDireccionCRequest step131Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.InsTipoDireccionCRequest();
            step131Request.setDireccionCInsTipoDireccionCpthisDireccionCInstance(direccionCTMODIFICARpthisDireccionC);
            step131Request.setDireccionCInsTipoDireccionCpevcTipoDireccionInstance(direccionCTMODIFICARptpevcTipoDireccionC);
            direccionCSrv.insTipoDireccionCImplementation(step131Request, true);
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TCREAR

    /*
     * Entry point for service TCREAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCREAR(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.TCREARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = direccionCSrv.tCREARTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCREARTxn(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.TCREARRequest request) throws ModelException {
        request.setDireccionCTCREARpagrDepartamentoCInstance(departamentoSrv.getByOIDWithHV(request.getDireccionCTCREARpagrDepartamentoC()));
        request.setDireccionCTCREARpagrMunicipioCInstance(municipioSrv.getByOIDWithHV(request.getDireccionCTCREARpagrMunicipioC()));
        request.setDireccionCTCREARpagrTipoDireccionCInstance(tipoDireccionSrv.getByOIDWithHV(request.getDireccionCTCREARpagrTipoDireccionC()));
        request.setDireccionCTCREARpagrPaisCInstance(paisSrv.getByOIDWithHV(request.getDireccionCTCREARpagrPaisC()));
        request.setDireccionCTCREARpagrPersonaCInstance(personaCSrv.getByOIDWithHV(request.getDireccionCTCREARpagrPersonaC()));
        request.setDireccionCTCREARpagrContratoCInstance(contratoCSrv.getByOIDWithHV(request.getDireccionCTCREARpagrContratoC()));
        return direccionCSrv.tCREARImplementation(request);
    }

    /*
     * Implements service TCREAR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCREARImplementation(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.TCREARRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoDireccion direccionCTCREARpagrTipoDireccionC = request.getDireccionCTCREARpagrTipoDireccionCInstance();
        Departamento direccionCTCREARpagrDepartamentoC = request.getDireccionCTCREARpagrDepartamentoCInstance();
        Municipio direccionCTCREARpagrMunicipioC = request.getDireccionCTCREARpagrMunicipioCInstance();
        Pais direccionCTCREARpagrPaisC = request.getDireccionCTCREARpagrPaisCInstance();
        ContratoC direccionCTCREARpagrContratoC = request.getDireccionCTCREARpagrContratoCInstance();
        PersonaC direccionCTCREARpagrPersonaC = request.getDireccionCTCREARpagrPersonaCInstance();
        String direccionCTCREARpatrDireccionCompleta = request.getDireccionCTCREARpatrDireccionCompleta();
        String direccionCTCREARpatrLocalidad = request.getDireccionCTCREARpatrLocalidad();
        String direccionCTCREARpTelefonoFijo = request.getDireccionCTCREARpTelefonoFijo();
        String direccionCTCREARpTelefonoCelular = request.getDireccionCTCREARpTelefonoCelular();
        DireccionC instance;

        com.keralty.aesolicitudes.viewmodel.direccionc.siu.CrearRequest step1Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.CrearRequest();
        step1Request.setDireccionCcrearpagrTipoDireccionCInstance(direccionCTCREARpagrTipoDireccionC);
        step1Request.setDireccionCcrearpagrDepartamentoCInstance(direccionCTCREARpagrDepartamentoC);
        step1Request.setDireccionCcrearpagrMunicipioCInstance(direccionCTCREARpagrMunicipioC);
        step1Request.setDireccionCcrearpagrPaisCInstance(direccionCTCREARpagrPaisC);
        step1Request.setDireccionCcrearpagrContratoCInstance(direccionCTCREARpagrContratoC);
        step1Request.setDireccionCcrearpagrPersonaCInstance(direccionCTCREARpagrPersonaC);
        step1Request.setDireccionCcrearpatrDireccionCompleta(direccionCTCREARpatrDireccionCompleta);
        step1Request.setDireccionCcrearpatrLocalidad(direccionCTCREARpatrLocalidad);
        instance = (DireccionC) direccionCSrv.crearImplementation(step1Request).getInstance();

        /* Action 2: IF (pTelefonoFijo <> NULL) */
        boolean ifCondition2 = direccionCTCREARpTelefonoFijo != null;
        if (ifCondition2) {
            com.keralty.aesolicitudes.viewmodel.telefonoc.siu.CrearRequest step20Request = new com.keralty.aesolicitudes.viewmodel.telefonoc.siu.CrearRequest();
            step20Request.setTelefonoCcrearpagrDirSucursalCInstance(null);
            step20Request.setTelefonoCcrearpagrDireccionCInstance(instance);
            step20Request.setTelefonoCcrearpatrTelefono(direccionCTCREARpTelefonoFijo);
            step20Request.setTelefonoCcrearpatrIndicativoPais(null);
            step20Request.setTelefonoCcrearpatrCodigoArea(null);
            step20Request.setTelefonoCcrearpatrExt(null);
            step20Request.setTelefonoCcrearpatrCodigo(Long.valueOf(1));
            telefonoCSrv.crearImplementation(step20Request);
        }

        /* Action 3: IF (pTelefonoCelular <> NULL) */
        boolean ifCondition3 = direccionCTCREARpTelefonoCelular != null;
        if (ifCondition3) {
            com.keralty.aesolicitudes.viewmodel.telefonoc.siu.CrearRequest step30Request = new com.keralty.aesolicitudes.viewmodel.telefonoc.siu.CrearRequest();
            step30Request.setTelefonoCcrearpagrDirSucursalCInstance(null);
            step30Request.setTelefonoCcrearpagrDireccionCInstance(instance);
            step30Request.setTelefonoCcrearpatrTelefono(direccionCTCREARpTelefonoCelular);
            step30Request.setTelefonoCcrearpatrIndicativoPais(null);
            step30Request.setTelefonoCcrearpatrCodigoArea(null);
            step30Request.setTelefonoCcrearpatrExt(null);
            step30Request.setTelefonoCcrearpatrCodigo(Long.valueOf(2));
            telefonoCSrv.crearImplementation(step30Request);
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TELIMINAR

    /*
     * Entry point for service TELIMINAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tELIMINAR(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.TELIMINARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = direccionCSrv.tELIMINARTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TELIMINAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tELIMINARTxn(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.TELIMINARRequest request) throws ModelException, SystemException {
        request.setDireccionCTELIMINARpthisDireccionCInstance(direccionCSrv.getByOIDWithHV(request.getDireccionCTELIMINARpthisDireccionC()));
        return direccionCSrv.tELIMINARImplementation(request);
    }

    /*
     * Implements service TELIMINAR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tELIMINARImplementation(
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.TELIMINARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        DireccionC direccionCTELIMINARpthisDireccionC = request.getDireccionCTELIMINARpthisDireccionCInstance();

        request.checkArguments();
        DireccionC instance = direccionCTELIMINARpthisDireccionC;

        for(TelefonoC step1Entity : repository.assocOperator018(direccionCTELIMINARpthisDireccionC)) {
            com.keralty.aesolicitudes.viewmodel.telefonoc.siu.EliminarRequest step1Request = new com.keralty.aesolicitudes.viewmodel.telefonoc.siu.EliminarRequest();
            step1Request.setTelefonoCeliminarpthisTelefonoCInstance(step1Entity);
            telefonoCSrv.eliminarImplementation(step1Request);
        }

        com.keralty.aesolicitudes.viewmodel.direccionc.siu.EliminarRequest step2Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.EliminarRequest();
        step2Request.setDireccionCeliminarpthisDireccionCInstance(direccionCTELIMINARpthisDireccionC);
        direccionCSrv.eliminarImplementation(step2Request);

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
        select.getOrderByPart().addItem(Constants.normalizePath(DireccionCConstants.CLASS_NAME, DireccionCConstants.ATTR_FIELD_DIRECCIONCCODIGO, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildDireccionCRelatedInstance(relatedInstanceJsonOid);
        }
        if (DireccionCConstants.ROLE_NAME_TELEFONOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDireccionCRelatedInstance4TelefonoC(relatedInstanceJsonOid, remainingPath);
        }
        if (DireccionCConstants.ROLE_NAME_PERSONAC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDireccionCRelatedInstance4PersonaC(relatedInstanceJsonOid, remainingPath);
        }
        if (DireccionCConstants.ROLE_NAME_CONTRATOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDireccionCRelatedInstance4ContratoC(relatedInstanceJsonOid, remainingPath);
        }
        if (DireccionCConstants.ROLE_NAME_TIPODIRECCIONC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDireccionCRelatedInstance4TipoDireccion(relatedInstanceJsonOid, remainingPath);
        }
        if (DireccionCConstants.ROLE_NAME_DEPARTAMENTOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDireccionCRelatedInstance4Departamento(relatedInstanceJsonOid, remainingPath);
        }
        if (DireccionCConstants.ROLE_NAME_MUNICIPIOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDireccionCRelatedInstance4Municipio(relatedInstanceJsonOid, remainingPath);
        }
        if (DireccionCConstants.ROLE_NAME_PAISC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDireccionCRelatedInstance4Pais(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildDireccionCRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new DireccionC(mapper.readValue(relatedInstanceJsonOid, DireccionCOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildDireccionCRelatedInstance4TelefonoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TelefonoC(mapper.readValue(relatedInstanceJsonOid, TelefonoCOid.class)): TelefonoC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildDireccionCRelatedInstance4PersonaC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new PersonaC(mapper.readValue(relatedInstanceJsonOid, PersonaCOid.class)): PersonaC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildDireccionCRelatedInstance4ContratoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ContratoC(mapper.readValue(relatedInstanceJsonOid, ContratoCOid.class)): ContratoC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildDireccionCRelatedInstance4TipoDireccion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TipoDireccion(mapper.readValue(relatedInstanceJsonOid, TipoDireccionOid.class)): TipoDireccion.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildDireccionCRelatedInstance4Departamento(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Departamento(mapper.readValue(relatedInstanceJsonOid, DepartamentoOid.class)): Departamento.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildDireccionCRelatedInstance4Municipio(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Municipio(mapper.readValue(relatedInstanceJsonOid, MunicipioOid.class)): Municipio.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildDireccionCRelatedInstance4Pais(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Pais(mapper.readValue(relatedInstanceJsonOid, PaisOid.class)): Pais.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            DireccionCOid oid = new DireccionCOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(DireccionCConstants.ATTR_FIELD_DIRECCIONCCODIGO, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getDireccionCCodigo(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(DireccionCService.class).error(e.getMessage());
        }
    }

}
