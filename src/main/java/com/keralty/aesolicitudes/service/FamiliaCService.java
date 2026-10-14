package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.MinCardinalityException;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.global.FamiliaCConstants;
import com.keralty.aesolicitudes.global.STDFunctions;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.Companyia;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Eps;
import com.keralty.aesolicitudes.persistence.EstadoBeneficiario;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.CompanyiaOid;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.EpsOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoBeneficiarioOid;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;
import com.keralty.aesolicitudes.persistence.oid.ParentescoOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.oid.TipoIdentificacionOid;
import com.keralty.aesolicitudes.persistence.Parentesco;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.persistence.Usuario;
import com.keralty.aesolicitudes.repository.FamiliaCJpaRepository;
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
public class FamiliaCService extends AbstractService {

    FamiliaCJpaRepository repository;

    FamiliaCService familiaCSrv;

    PersonaCService personaCSrv;

    ContratoCService contratoCSrv;

    MunicipioService municipioSrv;

    BeneficiarioCService beneficiarioCSrv;

    SolicitudService solicitudSrv;

    DireccionService direccionSrv;

    ContratanteService contratanteSrv;

    PersonaService personaSrv;

    UsuarioService usuarioSrv;

    EpsService epsSrv;

    CompanyiaService companyiaSrv;

    ParentescoService parentescoSrv;

    EstadoBeneficiarioService estadoBeneficiarioSrv;

    TipoIdentificacionService tipoIdentificacionSrv;

    @Inject
    public FamiliaCService(
            FamiliaCService familiaCSrv,
            PersonaCService personaCSrv,
            ContratoCService contratoCSrv,
            MunicipioService municipioSrv,
            BeneficiarioCService beneficiarioCSrv,
            SolicitudService solicitudSrv,
            DireccionService direccionSrv,
            ContratanteService contratanteSrv,
            PersonaService personaSrv,
            UsuarioService usuarioSrv,
            EpsService epsSrv,
            CompanyiaService companyiaSrv,
            ParentescoService parentescoSrv,
            EstadoBeneficiarioService estadoBeneficiarioSrv,
            TipoIdentificacionService tipoIdentificacionSrv,
            FamiliaCJpaRepository repository) {
        this.familiaCSrv = familiaCSrv;
        this.personaCSrv = personaCSrv;
        this.contratoCSrv = contratoCSrv;
        this.municipioSrv = municipioSrv;
        this.beneficiarioCSrv = beneficiarioCSrv;
        this.solicitudSrv = solicitudSrv;
        this.direccionSrv = direccionSrv;
        this.contratanteSrv = contratanteSrv;
        this.personaSrv = personaSrv;
        this.usuarioSrv = usuarioSrv;
        this.epsSrv = epsSrv;
        this.companyiaSrv = companyiaSrv;
        this.parentescoSrv = parentescoSrv;
        this.estadoBeneficiarioSrv = estadoBeneficiarioSrv;
        this.tipoIdentificacionSrv = tipoIdentificacionSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, FamiliaCConstants.CLASS_NAME);
    }

    private List<FamiliaC> solveFamiliaCTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, FamiliaCConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveFamiliaCTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, FamiliaCConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class FamiliaC
     *
     * @return Population of class FamiliaC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<FamiliaC> get() {
        List<FamiliaC> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    /*
     * Returns the population of class FamiliaC that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class FamiliaC matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<FamiliaC> get(QueryRequest queryRequest) {
        return solveFamiliaCTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveFamiliaCTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveFamiliaCTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveFamiliaCTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of FamiliaC by ID
     *
     * @param contratoCContratoCID Identification field contratoCContratoCID
     *
     * @param familiaCID Identification field familiaCID
     *
     * @return Instance of FamiliaC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public FamiliaC getById(Long contratoCContratoCID, Long familiaCID) {
        return getByOID(new FamiliaCOid(contratoCContratoCID, familiaCID));
    }
    
    /*
     * Returns an instance of FamiliaC by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of FamiliaC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public FamiliaC getByOID(FamiliaCOid oid) {
        Optional<FamiliaC> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of FamiliaC by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of FamiliaC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public FamiliaC getByOIDWithHV(FamiliaCOid oid) {
        Optional<FamiliaC> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<FamiliaC> getInstanceByOid(FamiliaCOid oid) {
        return oid != null && oid.getContratoCContratoCID() != null
               ? repository.findById(oid)
               : Optional.empty();
    }

    /*
     * Returns an instance of FamiliaC by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of FamiliaC
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public FamiliaC getByJsonOid(String jsonOid) {
        FamiliaCOid oid = new FamiliaCOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of FamiliaC related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of FamiliaC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<FamiliaC> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveFamiliaCTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of FamiliaC related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of FamiliaC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<FamiliaC> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of FamiliaC
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of FamiliaC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getFamiliaCDynamic(FamiliaCOid oid, String displaySetItems) {
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
    public String getSuppInfo(FamiliaCOid oid, String dsName) {
        FamiliaC instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(FamiliaC instance, String dsName) {
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
    public com.keralty.aesolicitudes.viewmodel.familiac.siu.CrearResponse crear(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.CrearRequest request) {
        com.keralty.aesolicitudes.viewmodel.familiac.siu.CrearResponse response = new com.keralty.aesolicitudes.viewmodel.familiac.siu.CrearResponse();
        try {
            response = familiaCSrv.crearTxn(request);
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
    public com.keralty.aesolicitudes.viewmodel.familiac.siu.CrearResponse crearTxn(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.CrearRequest request) throws ModelException {
        request.setFamiliaCcrearpagrPersonaCTitularInstance(personaCSrv.getByOIDWithHV(request.getFamiliaCcrearpagrPersonaCTitular()));
        request.setFamiliaCcrearpagrContratoCInstance(contratoCSrv.getByOIDWithHV(request.getFamiliaCcrearpagrContratoC()));
        request.setFamiliaCcrearpagrMunicipioCInstance(municipioSrv.getByOIDWithHV(request.getFamiliaCcrearpagrMunicipioC()));
        return familiaCSrv.crearImplementation(request);
    }

    /*
     * Implements service crear
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aesolicitudes.viewmodel.familiac.siu.CrearResponse crearImplementation(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.CrearRequest request) throws ModelException {
        com.keralty.aesolicitudes.viewmodel.familiac.siu.CrearResponse response = new com.keralty.aesolicitudes.viewmodel.familiac.siu.CrearResponse();
        ContratoC familiaCcrearpagrContratoC = request.getFamiliaCcrearpagrContratoCInstance();
        Municipio familiaCcrearpagrMunicipioC = request.getFamiliaCcrearpagrMunicipioCInstance();
        Boolean familiaCcrearpatrTitularConBeneficios = request.getFamiliaCcrearpatrTitularConBeneficios();
        String familiaCcrearpatrdireccionCorrespondencia = request.getFamiliaCcrearpatrdireccionCorrespondencia();
        String familiaCcrearpatrEstadoTitularFamilia = request.getFamiliaCcrearpatrEstadoTitularFamilia();
        Date familiaCcrearpatrFechaFinVigencia = request.getFamiliaCcrearpatrFechaFinVigencia();
        String familiaCcrearpatrNumFamilia = request.getFamiliaCcrearpatrNumFamilia();

        request.checkArguments();
        FamiliaC instance = new FamiliaC();

        instance.add2ContratoC(familiaCcrearpagrContratoC);

        if (familiaCcrearpagrMunicipioC != null && !familiaCcrearpagrMunicipioC.isNull()) {
            instance.add2MunicipioC(familiaCcrearpagrMunicipioC);
        }

        instance.setFamiliaCID(Long.valueOf(0));
        instance.setFamiliaCID(repository.nextFamiliaCID(instance.getContratoCContratoCID()));
        instance.setFamiliaCTitularConBeneficios(familiaCcrearpatrTitularConBeneficios);
        instance.setFamiliaCdireccionCorrespondencia(familiaCcrearpatrdireccionCorrespondencia);
        instance.setFamiliaCEstadoTitularFamilia(familiaCcrearpatrEstadoTitularFamilia);
        instance.setFamiliaCFechaFinVigencia(familiaCcrearpatrFechaFinVigencia);
        instance.setFamiliaCNumFamilia(familiaCcrearpatrNumFamilia);

        instance.setOid(instance.getOid());

        response.setInstance(repository.save(instance));

        // Value expressions for outgoing argument 'familiaCcrearpsFamiliaCreada'
        // DEFAULT  : THIS
        response.setFamiliaCcrearpsFamiliaCreadaInstance(instance);


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
            com.keralty.aesolicitudes.viewmodel.familiac.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaCSrv.eliminarTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.familiac.siu.EliminarRequest request) throws ModelException {
        request.setFamiliaCeliminarpthisFamiliaCInstance(familiaCSrv.getByOIDWithHV(request.getFamiliaCeliminarpthisFamiliaC()));
        return familiaCSrv.eliminarImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.familiac.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaC familiaCeliminarpthisFamiliaC = request.getFamiliaCeliminarpthisFamiliaCInstance();

        request.checkArguments();
        FamiliaC instance = familiaCeliminarpthisFamiliaC;
        if(familiaCeliminarpthisFamiliaC.getPersonaCTitular() != null && !familiaCeliminarpthisFamiliaC.getPersonaCTitular().isNull()) {
            throw new MinCardinalityException(FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ROLE_ALIAS_PERSONACTITULAR);
        }
        if(familiaCeliminarpthisFamiliaC.getBeneficiariosC().size() > 0) {
            throw new MinCardinalityException(FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ROLE_ALIAS_BENEFICIARIOSC);
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
            com.keralty.aesolicitudes.viewmodel.familiac.siu.ModificarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaCSrv.modificarTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.familiac.siu.ModificarRequest request) throws ModelException {
        request.setFamiliaCmodificarpthisFamiliaCInstance(familiaCSrv.getByOIDWithHV(request.getFamiliaCmodificarpthisFamiliaC()));
        return familiaCSrv.modificarImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.familiac.siu.ModificarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaC familiaCmodificarpthisFamiliaC = request.getFamiliaCmodificarpthisFamiliaCInstance();
        String familiaCmodificarpNumFamilia = request.getFamiliaCmodificarpNumFamilia();
        Boolean familiaCmodificarpTitularConBeneficios = request.getFamiliaCmodificarpTitularConBeneficios();
        String familiaCmodificarpEstadoTitularFamilia = request.getFamiliaCmodificarpEstadoTitularFamilia();
        Date familiaCmodificarpFechaFinVigencia = request.getFamiliaCmodificarpFechaFinVigencia();
        String familiaCmodificarpdireccionCorrespondencia = request.getFamiliaCmodificarpdireccionCorrespondencia();

        request.checkArguments();
        FamiliaC instance = familiaCmodificarpthisFamiliaC;
        instance.setFamiliaCNumFamilia(familiaCmodificarpNumFamilia);
        instance.setFamiliaCTitularConBeneficios(familiaCmodificarpTitularConBeneficios);
        instance.setFamiliaCEstadoTitularFamilia(familiaCmodificarpEstadoTitularFamilia);
        instance.setFamiliaCFechaFinVigencia(familiaCmodificarpFechaFinVigencia);
        instance.setFamiliaCdireccionCorrespondencia(familiaCmodificarpdireccionCorrespondencia);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsPersonaCTitular

    /*
     * Entry point for service InsPersonaCTitular
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insPersonaCTitular(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.InsPersonaCTitularRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaCSrv.insPersonaCTitularTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsPersonaCTitular
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insPersonaCTitularTxn(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.InsPersonaCTitularRequest request) throws ModelException {
        request.setFamiliaCInsPersonaCTitularpthisFamiliaCInstance(familiaCSrv.getByOIDWithHV(request.getFamiliaCInsPersonaCTitularpthisFamiliaC()));
        request.setFamiliaCInsPersonaCTitularpevcPersonaCInstance(personaCSrv.getByOIDWithHV(request.getFamiliaCInsPersonaCTitularpevcPersonaC()));
        return familiaCSrv.insPersonaCTitularImplementation(request, true);
    }

    /*
     * Implements service InsPersonaCTitular
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insPersonaCTitularImplementation(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.InsPersonaCTitularRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaC familiaCInsPersonaCTitularpthisFamiliaC = request.getFamiliaCInsPersonaCTitularpthisFamiliaCInstance();
        PersonaC familiaCInsPersonaCTitularpevcPersonaC = request.getFamiliaCInsPersonaCTitularpevcPersonaCInstance();

        request.checkArguments();
        FamiliaC instance = familiaCInsPersonaCTitularpthisFamiliaC;

        instance.add2PersonaCTitular(familiaCInsPersonaCTitularpevcPersonaC);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsPersonaCTitularRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.personac.siu.InsPersonaCTitularRequest();
            relatedRequest.setPersonaCInsPersonaCTitularpthisPersonaCInstance(familiaCInsPersonaCTitularpevcPersonaC);
            relatedRequest.setPersonaCInsPersonaCTitularpevcFamiliaCInstance(familiaCInsPersonaCTitularpthisFamiliaC);
            personaCSrv.insPersonaCTitularImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelPersonaCTitular

    /*
     * Entry point for service DelPersonaCTitular
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delPersonaCTitular(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.DelPersonaCTitularRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaCSrv.delPersonaCTitularTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelPersonaCTitular
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delPersonaCTitularTxn(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.DelPersonaCTitularRequest request) throws ModelException {
        request.setFamiliaCDelPersonaCTitularpthisFamiliaCInstance(familiaCSrv.getByOIDWithHV(request.getFamiliaCDelPersonaCTitularpthisFamiliaC()));
        request.setFamiliaCDelPersonaCTitularpevcPersonaCInstance(personaCSrv.getByOIDWithHV(request.getFamiliaCDelPersonaCTitularpevcPersonaC()));
        return familiaCSrv.delPersonaCTitularImplementation(request, true);
    }

    /*
     * Implements service DelPersonaCTitular
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delPersonaCTitularImplementation(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.DelPersonaCTitularRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaC familiaCDelPersonaCTitularpthisFamiliaC = request.getFamiliaCDelPersonaCTitularpthisFamiliaCInstance();
        PersonaC familiaCDelPersonaCTitularpevcPersonaC = request.getFamiliaCDelPersonaCTitularpevcPersonaCInstance();

        request.checkArguments();
        FamiliaC instance = familiaCDelPersonaCTitularpthisFamiliaC;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelPersonaCTitularRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.personac.siu.DelPersonaCTitularRequest();
            relatedRequest.setPersonaCDelPersonaCTitularpthisPersonaCInstance(familiaCDelPersonaCTitularpevcPersonaC);
            relatedRequest.setPersonaCDelPersonaCTitularpevcFamiliaCInstance(familiaCDelPersonaCTitularpthisFamiliaC);
            personaCSrv.delPersonaCTitularImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: evalPostNotiCrear

    /*
     * Entry point for service evalPostNotiCrear
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse evalPostNotiCrear(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.EvalPostNotiCrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaCSrv.evalPostNotiCrearTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service evalPostNotiCrear
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse evalPostNotiCrearTxn(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.EvalPostNotiCrearRequest request) throws ModelException {
        request.setFamiliaCevalPostNotiCrearpthisFamiliaCInstance(familiaCSrv.getByOIDWithHV(request.getFamiliaCevalPostNotiCrearpthisFamiliaC()));
        return familiaCSrv.evalPostNotiCrearImplementation(request);
    }

    /*
     * Implements service evalPostNotiCrear
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse evalPostNotiCrearImplementation(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.EvalPostNotiCrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaC familiaCevalPostNotiCrearpthisFamiliaC = request.getFamiliaCevalPostNotiCrearpthisFamiliaCInstance();
        String familiaCevalPostNotiCrearpeNumFamilia = request.getFamiliaCevalPostNotiCrearpeNumFamilia();
        Date familiaCevalPostNotiCrearpeFechaFinVigencia = request.getFamiliaCevalPostNotiCrearpeFechaFinVigencia();
        String familiaCevalPostNotiCrearpeDirCorresp = request.getFamiliaCevalPostNotiCrearpeDirCorresp();

        request.checkArguments();
        FamiliaC instance = familiaCevalPostNotiCrearpthisFamiliaC;
        instance.setFamiliaCNumFamilia(familiaCevalPostNotiCrearpeNumFamilia);
        instance.setFamiliaCFechaFinVigencia(familiaCevalPostNotiCrearpeFechaFinVigencia);
        instance.setFamiliaCdireccionCorrespondencia(familiaCevalPostNotiCrearpeDirCorresp);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsMunicipioFamilia

    /*
     * Entry point for service InsMunicipioFamilia
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insMunicipioFamilia(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.InsMunicipioFamiliaRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaCSrv.insMunicipioFamiliaTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsMunicipioFamilia
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insMunicipioFamiliaTxn(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.InsMunicipioFamiliaRequest request) throws ModelException {
        request.setFamiliaCInsMunicipioFamiliapthisFamiliaCInstance(familiaCSrv.getByOIDWithHV(request.getFamiliaCInsMunicipioFamiliapthisFamiliaC()));
        request.setFamiliaCInsMunicipioFamiliapevcMunicipioInstance(municipioSrv.getByOIDWithHV(request.getFamiliaCInsMunicipioFamiliapevcMunicipio()));
        return familiaCSrv.insMunicipioFamiliaImplementation(request, true);
    }

    /*
     * Implements service InsMunicipioFamilia
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insMunicipioFamiliaImplementation(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.InsMunicipioFamiliaRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaC familiaCInsMunicipioFamiliapthisFamiliaC = request.getFamiliaCInsMunicipioFamiliapthisFamiliaCInstance();
        Municipio familiaCInsMunicipioFamiliapevcMunicipio = request.getFamiliaCInsMunicipioFamiliapevcMunicipioInstance();

        request.checkArguments();
        FamiliaC instance = familiaCInsMunicipioFamiliapthisFamiliaC;

        instance.add2MunicipioC(familiaCInsMunicipioFamiliapevcMunicipio);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.municipio.siu.InsMunicipioFamiliaRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.municipio.siu.InsMunicipioFamiliaRequest();
            relatedRequest.setMunicipioInsMunicipioFamiliapthisMunicipioInstance(familiaCInsMunicipioFamiliapevcMunicipio);
            relatedRequest.setMunicipioInsMunicipioFamiliapevcFamiliaCInstance(familiaCInsMunicipioFamiliapthisFamiliaC);
            municipioSrv.insMunicipioFamiliaImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelMunicipioFamilia

    /*
     * Entry point for service DelMunicipioFamilia
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delMunicipioFamilia(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.DelMunicipioFamiliaRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaCSrv.delMunicipioFamiliaTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelMunicipioFamilia
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delMunicipioFamiliaTxn(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.DelMunicipioFamiliaRequest request) throws ModelException {
        request.setFamiliaCDelMunicipioFamiliapthisFamiliaCInstance(familiaCSrv.getByOIDWithHV(request.getFamiliaCDelMunicipioFamiliapthisFamiliaC()));
        request.setFamiliaCDelMunicipioFamiliapevcMunicipioInstance(municipioSrv.getByOIDWithHV(request.getFamiliaCDelMunicipioFamiliapevcMunicipio()));
        return familiaCSrv.delMunicipioFamiliaImplementation(request, true);
    }

    /*
     * Implements service DelMunicipioFamilia
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delMunicipioFamiliaImplementation(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.DelMunicipioFamiliaRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FamiliaC familiaCDelMunicipioFamiliapthisFamiliaC = request.getFamiliaCDelMunicipioFamiliapthisFamiliaCInstance();
        Municipio familiaCDelMunicipioFamiliapevcMunicipio = request.getFamiliaCDelMunicipioFamiliapevcMunicipioInstance();

        request.checkArguments();
        FamiliaC instance = familiaCDelMunicipioFamiliapthisFamiliaC;

        instance.add2MunicipioC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.municipio.siu.DelMunicipioFamiliaRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.municipio.siu.DelMunicipioFamiliaRequest();
            relatedRequest.setMunicipioDelMunicipioFamiliapthisMunicipioInstance(familiaCDelMunicipioFamiliapevcMunicipio);
            relatedRequest.setMunicipioDelMunicipioFamiliapevcFamiliaCInstance(familiaCDelMunicipioFamiliapthisFamiliaC);
            municipioSrv.delMunicipioFamiliaImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

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
            com.keralty.aesolicitudes.viewmodel.familiac.siu.TELIMINARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaCSrv.tELIMINARTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.familiac.siu.TELIMINARRequest request) throws ModelException, SystemException {
        request.setFamiliaCTELIMINARpthisFamiliaCInstance(familiaCSrv.getByOIDWithHV(request.getFamiliaCTELIMINARpthisFamiliaC()));
        return familiaCSrv.tELIMINARImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.familiac.siu.TELIMINARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        FamiliaC familiaCTELIMINARpthisFamiliaC = request.getFamiliaCTELIMINARpthisFamiliaCInstance();

        request.checkArguments();
        FamiliaC instance = familiaCTELIMINARpthisFamiliaC;

        for(BeneficiarioC step1Entity : repository.assocOperator000(familiaCTELIMINARpthisFamiliaC)) {
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TELIMINARRequest step1Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TELIMINARRequest();
            step1Request.setBeneficiarioCTELIMINARpthisBeneficiarioCInstance(step1Entity);
            beneficiarioCSrv.tELIMINARImplementation(step1Request);
        }

        /* Action 2: IF (EXIST (PersonaCTitular) = true AND ContratoC.PersonaCContratante <> PersonaCTitular) */
        boolean ifCondition2 = repository.assocOperator002(familiaCTELIMINARpthisFamiliaC).equals(true) && !(familiaCTELIMINARpthisFamiliaC.getContratoC().getPersonaCContratante().equalsObject(familiaCTELIMINARpthisFamiliaC.getPersonaCTitular()));
        if (ifCondition2) {
            com.keralty.aesolicitudes.viewmodel.personac.siu.TELIMINARRequest step20Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.TELIMINARRequest();
            step20Request.setPersonaCTELIMINARpthisPersonaCInstance(familiaCTELIMINARpthisFamiliaC.getPersonaCTitular());
            personaCSrv.tELIMINARImplementation(step20Request);
        }

        com.keralty.aesolicitudes.viewmodel.familiac.siu.EliminarRequest step3Request = new com.keralty.aesolicitudes.viewmodel.familiac.siu.EliminarRequest();
        step3Request.setFamiliaCeliminarpthisFamiliaCInstance(familiaCTELIMINARpthisFamiliaC);
        familiaCSrv.eliminarImplementation(step3Request);

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TNEWDESDEAE

    /*
     * Entry point for service TNEWDESDEAE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tNEWDESDEAE(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.TNEWDESDEAERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaCSrv.tNEWDESDEAETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TNEWDESDEAE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tNEWDESDEAETxn(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.TNEWDESDEAERequest request) throws ModelException, SystemException {
        request.setFamiliaCTNEWDESDEAEptContratoCInstance(contratoCSrv.getByOIDWithHV(request.getFamiliaCTNEWDESDEAEptContratoC()));
        request.setFamiliaCTNEWDESDEAEptSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getFamiliaCTNEWDESDEAEptSolicitud()));
        return familiaCSrv.tNEWDESDEAEImplementation(request);
    }

    /*
     * Implements service TNEWDESDEAE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tNEWDESDEAEImplementation(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.TNEWDESDEAERequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        String familiaCTNEWDESDEAEptNumFamiliaCORE = request.getFamiliaCTNEWDESDEAEptNumFamiliaCORE();
        ContratoC familiaCTNEWDESDEAEptContratoC = request.getFamiliaCTNEWDESDEAEptContratoCInstance();
        Solicitud familiaCTNEWDESDEAEptSolicitud = request.getFamiliaCTNEWDESDEAEptSolicitudInstance();

        request.checkArguments();
        FamiliaC instance;

        /* Action 1: IF (ptNumFamiliaCORE <> NULL) */
        boolean ifCondition1 = familiaCTNEWDESDEAEptNumFamiliaCORE != null;
        if (ifCondition1) {
            com.keralty.aesolicitudes.viewmodel.familiac.siu.CrearRequest step10Request = new com.keralty.aesolicitudes.viewmodel.familiac.siu.CrearRequest();
            step10Request.setFamiliaCcrearpagrPersonaCTitularInstance(null);
            step10Request.setFamiliaCcrearpagrContratoCInstance(familiaCTNEWDESDEAEptContratoC);
            step10Request.setFamiliaCcrearpagrMunicipioCInstance(familiaCTNEWDESDEAEptSolicitud.getDireccion().getMunicipio());
            step10Request.setFamiliaCcrearpatrTitularConBeneficios(familiaCTNEWDESDEAEptSolicitud.getContratante().getContratanteTitularConBeneficios());
            step10Request.setFamiliaCcrearpatrdireccionCorrespondencia(familiaCTNEWDESDEAEptSolicitud.getDireccion().getDireccionDireccionCompleta());
            step10Request.setFamiliaCcrearpatrEstadoTitularFamilia(null);
            step10Request.setFamiliaCcrearpatrFechaFinVigencia(null);
            step10Request.setFamiliaCcrearpatrNumFamilia(familiaCTNEWDESDEAEptNumFamiliaCORE);
            instance = (FamiliaC) familiaCSrv.crearImplementation(step10Request).getInstance();
            
        } else {
            com.keralty.aesolicitudes.viewmodel.familiac.siu.CrearRequest step11Request = new com.keralty.aesolicitudes.viewmodel.familiac.siu.CrearRequest();
            step11Request.setFamiliaCcrearpagrPersonaCTitularInstance(null);
            step11Request.setFamiliaCcrearpagrContratoCInstance(familiaCTNEWDESDEAEptContratoC);
            step11Request.setFamiliaCcrearpagrMunicipioCInstance(familiaCTNEWDESDEAEptSolicitud.getDireccion().getMunicipio());
            step11Request.setFamiliaCcrearpatrTitularConBeneficios(familiaCTNEWDESDEAEptSolicitud.getContratante().getContratanteTitularConBeneficios());
            step11Request.setFamiliaCcrearpatrdireccionCorrespondencia(familiaCTNEWDESDEAEptSolicitud.getDireccion().getDireccionDireccionCompleta());
            step11Request.setFamiliaCcrearpatrEstadoTitularFamilia(null);
            step11Request.setFamiliaCcrearpatrFechaFinVigencia(null);
            step11Request.setFamiliaCcrearpatrNumFamilia("1");
            instance = (FamiliaC) familiaCSrv.crearImplementation(step11Request).getInstance();
            
        }

        /* Action 2: IF (ptSolicitud.ContratantePersona = ptSolicitud.TitularPersona) */
        boolean ifCondition2 = familiaCTNEWDESDEAEptSolicitud.getContratantePersona().equalsObject(familiaCTNEWDESDEAEptSolicitud.getTitularPersona());
        if (ifCondition2) {
            com.keralty.aesolicitudes.viewmodel.familiac.siu.InsPersonaCTitularRequest step20Request = new com.keralty.aesolicitudes.viewmodel.familiac.siu.InsPersonaCTitularRequest();
            step20Request.setFamiliaCInsPersonaCTitularpthisFamiliaCInstance(instance);
            step20Request.setFamiliaCInsPersonaCTitularpevcPersonaCInstance(instance.getContratoC().getPersonaCContratante());
            familiaCSrv.insPersonaCTitularImplementation(step20Request, true);
        } else {
            com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWTITULARDESDEAERequest step21Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWTITULARDESDEAERequest();
            step21Request.setPersonaCTNEWTITULARDESDEAEptSolicitudInstance(familiaCTNEWDESDEAEptSolicitud);
            step21Request.setPersonaCTNEWTITULARDESDEAEptFamiliaCInstance(instance);
            personaCSrv.tNEWTITULARDESDEAEImplementation(step21Request);
        }

        for(Usuario step3Entity : repository.assocOperator003(familiaCTNEWDESDEAEptSolicitud)) {
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TNEWDESDEAERequest step3Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TNEWDESDEAERequest();
            step3Request.setBeneficiarioCTNEWDESDEAEptContratoInstance(familiaCTNEWDESDEAEptContratoC);
            step3Request.setBeneficiarioCTNEWDESDEAEptFamiliaInstance(instance);
            step3Request.setBeneficiarioCTNEWDESDEAEptUsuarioInstance(step3Entity);
            step3Request.setBeneficiarioCTNEWDESDEAEptSolicitudInstance(familiaCTNEWDESDEAEptSolicitud);
            beneficiarioCSrv.tNEWDESDEAEImplementation(step3Request);
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TCREARACTBENEF

    /*
     * Entry point for service TCREARACTBENEF
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCREARACTBENEF(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.TCREARACTBENEFRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaCSrv.tCREARACTBENEFTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREARACTBENEF
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCREARACTBENEFTxn(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.TCREARACTBENEFRequest request) throws ModelException, SystemException {
        request.setFamiliaCTCREARACTBENEFpthisFamiliaCInstance(familiaCSrv.getByOIDWithHV(request.getFamiliaCTCREARACTBENEFpthisFamiliaC()));
        request.setFamiliaCTCREARACTBENEFptpagrEPSCInstance(epsSrv.getByOIDWithHV(request.getFamiliaCTCREARACTBENEFptpagrEPSC()));
        request.setFamiliaCTCREARACTBENEFptpagrCompanyiaMPCInstance(companyiaSrv.getByOIDWithHV(request.getFamiliaCTCREARACTBENEFptpagrCompanyiaMPC()));
        request.setFamiliaCTCREARACTBENEFptpagrParentescoCInstance(parentescoSrv.getByOIDWithHV(request.getFamiliaCTCREARACTBENEFptpagrParentescoC()));
        request.setFamiliaCTCREARACTBENEFptpagrEstadoBeneficiarioCInstance(estadoBeneficiarioSrv.getByOIDWithHV(request.getFamiliaCTCREARACTBENEFptpagrEstadoBeneficiarioC()));
        request.setFamiliaCTCREARACTBENEFptptTipoIdInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getFamiliaCTCREARACTBENEFptptTipoId()));
        return familiaCSrv.tCREARACTBENEFImplementation(request);
    }

    /*
     * Implements service TCREARACTBENEF
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCREARACTBENEFImplementation(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.TCREARACTBENEFRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        TipoIdentificacion familiaCTCREARACTBENEFptptTipoId = request.getFamiliaCTCREARACTBENEFptptTipoIdInstance();
        String familiaCTCREARACTBENEFptptNumIdentificacion = request.getFamiliaCTCREARACTBENEFptptNumIdentificacion();
        Eps familiaCTCREARACTBENEFptpagrEPSC = request.getFamiliaCTCREARACTBENEFptpagrEPSCInstance();
        Companyia familiaCTCREARACTBENEFptpagrCompanyiaMPC = request.getFamiliaCTCREARACTBENEFptpagrCompanyiaMPCInstance();
        Parentesco familiaCTCREARACTBENEFptpagrParentescoC = request.getFamiliaCTCREARACTBENEFptpagrParentescoCInstance();
        EstadoBeneficiario familiaCTCREARACTBENEFptpagrEstadoBeneficiarioC = request.getFamiliaCTCREARACTBENEFptpagrEstadoBeneficiarioCInstance();
        String familiaCTCREARACTBENEFptpatrCodigoTipoUsuario = request.getFamiliaCTCREARACTBENEFptpatrCodigoTipoUsuario();
        Boolean familiaCTCREARACTBENEFptpatrIndicadorBBGestacion = request.getFamiliaCTCREARACTBENEFptpatrIndicadorBBGestacion();
        String familiaCTCREARACTBENEFptpatrCodUsuarioBancoRep = request.getFamiliaCTCREARACTBENEFptpatrCodUsuarioBancoRep();
        Date familiaCTCREARACTBENEFptpatrFechaAntiguedad = request.getFamiliaCTCREARACTBENEFptpatrFechaAntiguedad();
        Date familiaCTCREARACTBENEFptpatrFechaAntiguedadRealOSI = request.getFamiliaCTCREARACTBENEFptpatrFechaAntiguedadRealOSI();
        Long familiaCTCREARACTBENEFptpatrEstadoMedico = request.getFamiliaCTCREARACTBENEFptpatrEstadoMedico();
        Boolean familiaCTCREARACTBENEFptpatrTienePreexistencias = request.getFamiliaCTCREARACTBENEFptpatrTienePreexistencias();
        Date familiaCTCREARACTBENEFptpatrFechaInicioVigencia = request.getFamiliaCTCREARACTBENEFptpatrFechaInicioVigencia();
        Date familiaCTCREARACTBENEFptpatrFechaFinVigencia = request.getFamiliaCTCREARACTBENEFptpatrFechaFinVigencia();
        Long familiaCTCREARACTBENEFptpatrNumUsuario = request.getFamiliaCTCREARACTBENEFptpatrNumUsuario();
        String familiaCTCREARACTBENEFptptNombreCompleto = request.getFamiliaCTCREARACTBENEFptptNombreCompleto();
        Long familiaCTCREARACTBENEFptptCodigoCORE = request.getFamiliaCTCREARACTBENEFptptCodigoCORE();
        FamiliaC familiaCTCREARACTBENEFpthisFamiliaC = request.getFamiliaCTCREARACTBENEFpthisFamiliaCInstance();

        request.checkArguments();
        FamiliaC instance = familiaCTCREARACTBENEFpthisFamiliaC;

        /* Action 1: IF (EXIST (BeneficiariosC.PersonaC) WHERE (BeneficiariosC.PersonaC.TipoIdentificacionC = ptptTipoId AND BeneficiariosC.PersonaC.NumIdentificacion = ptptNumIdentificacion) = false) */
        boolean ifCondition1 = repository.assocOperator006(familiaCTCREARACTBENEFpthisFamiliaC, familiaCTCREARACTBENEFptptTipoId, familiaCTCREARACTBENEFptptNumIdentificacion).equals(false);
        if (ifCondition1) {
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TNEWDESDECORERequest step10Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TNEWDESDECORERequest();
            step10Request.setBeneficiarioCTNEWDESDECOREptpagrEPSCInstance(familiaCTCREARACTBENEFptpagrEPSC);
            step10Request.setBeneficiarioCTNEWDESDECOREptpagrCompanyiaMPCInstance(familiaCTCREARACTBENEFptpagrCompanyiaMPC);
            step10Request.setBeneficiarioCTNEWDESDECOREptpagrParentescoCInstance(familiaCTCREARACTBENEFptpagrParentescoC);
            step10Request.setBeneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioCInstance(familiaCTCREARACTBENEFptpagrEstadoBeneficiarioC);
            step10Request.setBeneficiarioCTNEWDESDECOREptpagrContratoCInstance(familiaCTCREARACTBENEFpthisFamiliaC.getContratoC());
            step10Request.setBeneficiarioCTNEWDESDECOREptpagrFamiliasCInstance(familiaCTCREARACTBENEFpthisFamiliaC);
            step10Request.setBeneficiarioCTNEWDESDECOREptpatrCodigoTipoUsuario(familiaCTCREARACTBENEFptpatrCodigoTipoUsuario);
            step10Request.setBeneficiarioCTNEWDESDECOREptpatrIndicadorBBGestacion(familiaCTCREARACTBENEFptpatrIndicadorBBGestacion);
            step10Request.setBeneficiarioCTNEWDESDECOREptpatrCodUsuarioBancoRep(familiaCTCREARACTBENEFptpatrCodUsuarioBancoRep);
            step10Request.setBeneficiarioCTNEWDESDECOREptpatrFechaAntiguedad(familiaCTCREARACTBENEFptpatrFechaAntiguedad);
            step10Request.setBeneficiarioCTNEWDESDECOREptpatrFechaAntiguedadRealOSI(familiaCTCREARACTBENEFptpatrFechaAntiguedadRealOSI);
            step10Request.setBeneficiarioCTNEWDESDECOREptpatrEstadoMedico(familiaCTCREARACTBENEFptpatrEstadoMedico);
            step10Request.setBeneficiarioCTNEWDESDECOREptpatrTienePreexistencias(familiaCTCREARACTBENEFptpatrTienePreexistencias);
            step10Request.setBeneficiarioCTNEWDESDECOREptpatrFechaInicioVigencia(familiaCTCREARACTBENEFptpatrFechaInicioVigencia);
            step10Request.setBeneficiarioCTNEWDESDECOREptpatrFechaFinVigencia(familiaCTCREARACTBENEFptpatrFechaFinVigencia);
            step10Request.setBeneficiarioCTNEWDESDECOREptpatrNumUsuario(familiaCTCREARACTBENEFptpatrNumUsuario);
            step10Request.setBeneficiarioCTNEWDESDECOREptTipoIdInstance(familiaCTCREARACTBENEFptptTipoId);
            step10Request.setBeneficiarioCTNEWDESDECOREptNumIdentificacion(familiaCTCREARACTBENEFptptNumIdentificacion);
            step10Request.setBeneficiarioCTNEWDESDECOREptNombreCompleto(familiaCTCREARACTBENEFptptNombreCompleto);
            step10Request.setBeneficiarioCTNEWDESDECOREptCodigoCORE(familiaCTCREARACTBENEFptptCodigoCORE);
            beneficiarioCSrv.tNEWDESDECOREImplementation(step10Request);
        } else {
            for(BeneficiarioC step111Entity : repository.assocOperator005(familiaCTCREARACTBENEFpthisFamiliaC, familiaCTCREARACTBENEFptptTipoId, familiaCTCREARACTBENEFptptNumIdentificacion)) {
                com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TPOSTNOTIFICARRequest step11Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TPOSTNOTIFICARRequest();
                step11Request.setBeneficiarioCTPOSTNOTIFICARpthisBeneficiarioCInstance(step111Entity);
                step11Request.setBeneficiarioCTPOSTNOTIFICARptpEstadoMedico(familiaCTCREARACTBENEFptpatrEstadoMedico);
                step11Request.setBeneficiarioCTPOSTNOTIFICARptpFechaAntiguedadRealOSI(familiaCTCREARACTBENEFptpatrFechaAntiguedadRealOSI);
                step11Request.setBeneficiarioCTPOSTNOTIFICARptpTienePreexistencias(familiaCTCREARACTBENEFptpatrTienePreexistencias);
                step11Request.setBeneficiarioCTPOSTNOTIFICARptpFechaInicioVigencia(familiaCTCREARACTBENEFptpatrFechaInicioVigencia);
                step11Request.setBeneficiarioCTPOSTNOTIFICARptpFechaFinVigencia(familiaCTCREARACTBENEFptpatrFechaFinVigencia);
                step11Request.setBeneficiarioCTPOSTNOTIFICARptpNumUsuario(familiaCTCREARACTBENEFptpatrNumUsuario);
                step11Request.setBeneficiarioCTPOSTNOTIFICARptpCodigoTipoUsuario(familiaCTCREARACTBENEFptpatrCodigoTipoUsuario);
                step11Request.setBeneficiarioCTPOSTNOTIFICARptpIndicadorBBGestacion(familiaCTCREARACTBENEFptpatrIndicadorBBGestacion);
                step11Request.setBeneficiarioCTPOSTNOTIFICARptpCodUsuarioBancoRep(familiaCTCREARACTBENEFptpatrCodUsuarioBancoRep);
                step11Request.setBeneficiarioCTPOSTNOTIFICARptpFechaAntiguedad(familiaCTCREARACTBENEFptpatrFechaAntiguedad);
                step11Request.setBeneficiarioCTPOSTNOTIFICARptEstadoBeneficiarioInstance(familiaCTCREARACTBENEFptpagrEstadoBeneficiarioC);
                step11Request.setBeneficiarioCTPOSTNOTIFICARptpagrEPSCInstance(familiaCTCREARACTBENEFptpagrEPSC);
                step11Request.setBeneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPCInstance(familiaCTCREARACTBENEFptpagrCompanyiaMPC);
                step11Request.setBeneficiarioCTPOSTNOTIFICARptpagrParentescoCInstance(familiaCTCREARACTBENEFptpagrParentescoC);
                step11Request.setBeneficiarioCTPOSTNOTIFICARptptNombreCompleto(familiaCTCREARACTBENEFptptNombreCompleto);
                beneficiarioCSrv.tPOSTNOTIFICARImplementation(step11Request);
            }
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TPOSTNOTICREAR

    /*
     * Entry point for service TPOSTNOTICREAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tPOSTNOTICREAR(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.TPOSTNOTICREARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = familiaCSrv.tPOSTNOTICREARTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TPOSTNOTICREAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tPOSTNOTICREARTxn(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.TPOSTNOTICREARRequest request) throws ModelException, SystemException {
        request.setFamiliaCTPOSTNOTICREARpthisFamiliaCInstance(familiaCSrv.getByOIDWithHV(request.getFamiliaCTPOSTNOTICREARpthisFamiliaC()));
        request.setFamiliaCTPOSTNOTICREARptMunicipioDireccionInstance(municipioSrv.getByOIDWithHV(request.getFamiliaCTPOSTNOTICREARptMunicipioDireccion()));
        request.setFamiliaCTPOSTNOTICREARptTipoIdentTitularInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getFamiliaCTPOSTNOTICREARptTipoIdentTitular()));
        return familiaCSrv.tPOSTNOTICREARImplementation(request);
    }

    /*
     * Implements service TPOSTNOTICREAR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tPOSTNOTICREARImplementation(
            com.keralty.aesolicitudes.viewmodel.familiac.siu.TPOSTNOTICREARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        String familiaCTPOSTNOTICREARptpeNumFamilia = request.getFamiliaCTPOSTNOTICREARptpeNumFamilia();
        Date familiaCTPOSTNOTICREARptpeFechaFinVigencia = request.getFamiliaCTPOSTNOTICREARptpeFechaFinVigencia();
        String familiaCTPOSTNOTICREARptpeDirCorresp = request.getFamiliaCTPOSTNOTICREARptpeDirCorresp();
        Municipio familiaCTPOSTNOTICREARptMunicipioDireccion = request.getFamiliaCTPOSTNOTICREARptMunicipioDireccionInstance();
        TipoIdentificacion familiaCTPOSTNOTICREARptTipoIdentTitular = request.getFamiliaCTPOSTNOTICREARptTipoIdentTitularInstance();
        String familiaCTPOSTNOTICREARptNumIdentTitular = request.getFamiliaCTPOSTNOTICREARptNumIdentTitular();
        String familiaCTPOSTNOTICREARptNombreCompletoTitular = request.getFamiliaCTPOSTNOTICREARptNombreCompletoTitular();
        FamiliaC familiaCTPOSTNOTICREARpthisFamiliaC = request.getFamiliaCTPOSTNOTICREARpthisFamiliaCInstance();

        request.checkArguments();
        FamiliaC instance = familiaCTPOSTNOTICREARpthisFamiliaC;

        com.keralty.aesolicitudes.viewmodel.familiac.siu.EvalPostNotiCrearRequest step1Request = new com.keralty.aesolicitudes.viewmodel.familiac.siu.EvalPostNotiCrearRequest();
        step1Request.setFamiliaCevalPostNotiCrearpthisFamiliaCInstance(familiaCTPOSTNOTICREARpthisFamiliaC);
        step1Request.setFamiliaCevalPostNotiCrearpeNumFamilia(familiaCTPOSTNOTICREARptpeNumFamilia);
        step1Request.setFamiliaCevalPostNotiCrearpeFechaFinVigencia(familiaCTPOSTNOTICREARptpeFechaFinVigencia);
        step1Request.setFamiliaCevalPostNotiCrearpeDirCorresp(familiaCTPOSTNOTICREARptpeDirCorresp);
        familiaCSrv.evalPostNotiCrearImplementation(step1Request);

        /* Action 2: IF (MunicipioC <> ptMunicipioDireccion) */
        boolean ifCondition2 = !(familiaCTPOSTNOTICREARpthisFamiliaC.getMunicipioC().equalsObject(familiaCTPOSTNOTICREARptMunicipioDireccion));
        if (ifCondition2) {
            /* Action 20: IF (ptMunicipioDireccion <> NULL) */
            boolean ifCondition20 = (familiaCTPOSTNOTICREARptMunicipioDireccion != null && !familiaCTPOSTNOTICREARptMunicipioDireccion.isNull());
            if (ifCondition20) {
                /* Action 200: IF (EXIST (MunicipioC) = true) */
                boolean ifCondition200 = repository.assocOperator009(familiaCTPOSTNOTICREARpthisFamiliaC).equals(true);
                if (ifCondition200) {
                    com.keralty.aesolicitudes.viewmodel.familiac.siu.DelMunicipioFamiliaRequest step2000Request = new com.keralty.aesolicitudes.viewmodel.familiac.siu.DelMunicipioFamiliaRequest();
                    step2000Request.setFamiliaCDelMunicipioFamiliapthisFamiliaCInstance(familiaCTPOSTNOTICREARpthisFamiliaC);
                    step2000Request.setFamiliaCDelMunicipioFamiliapevcMunicipioInstance(familiaCTPOSTNOTICREARpthisFamiliaC.getMunicipioC());
                    familiaCSrv.delMunicipioFamiliaImplementation(step2000Request, true);
                }
                com.keralty.aesolicitudes.viewmodel.familiac.siu.InsMunicipioFamiliaRequest step201Request = new com.keralty.aesolicitudes.viewmodel.familiac.siu.InsMunicipioFamiliaRequest();
                step201Request.setFamiliaCInsMunicipioFamiliapthisFamiliaCInstance(familiaCTPOSTNOTICREARpthisFamiliaC);
                step201Request.setFamiliaCInsMunicipioFamiliapevcMunicipioInstance(familiaCTPOSTNOTICREARptMunicipioDireccion);
                familiaCSrv.insMunicipioFamiliaImplementation(step201Request, true);
            }
        }

        /* Action 3: IF (ptTipoIdentTitular <> NULL AND ptNumIdentTitular <> NULL) */
        boolean ifCondition3 = (familiaCTPOSTNOTICREARptTipoIdentTitular != null && !familiaCTPOSTNOTICREARptTipoIdentTitular.isNull()) && familiaCTPOSTNOTICREARptNumIdentTitular != null;
        if (ifCondition3) {
            /* Action 30: IF (EXIST (PersonaCTitular) = false) */
            boolean ifCondition30 = repository.assocOperator010(familiaCTPOSTNOTICREARpthisFamiliaC).equals(false);
            if (ifCondition30) {
                com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWRequest step300Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWRequest();
                step300Request.setPersonaCTNEWptpagrTipoInstitucionCInstance(null);
                step300Request.setPersonaCTNEWptpagrTipoEntidadCInstance(null);
                step300Request.setPersonaCTNEWptpagrEstadoCivilCInstance(null);
                step300Request.setPersonaCTNEWptpagrEstadoPersonaCInstance(null);
                step300Request.setPersonaCTNEWptpagrTipoIdentificacionCInstance(familiaCTPOSTNOTICREARptTipoIdentTitular);
                step300Request.setPersonaCTNEWptpagrMunicipioCNacInstance(null);
                step300Request.setPersonaCTNEWptpagrDepartamentoCNacInstance(null);
                step300Request.setPersonaCTNEWptpagrContratosCInstance(null);
                step300Request.setPersonaCTNEWptpagrFamiliasCInstance(familiaCTPOSTNOTICREARpthisFamiliaC);
                step300Request.setPersonaCTNEWptpagrBeneficiariosCInstance(null);
                step300Request.setPersonaCTNEWptpatrNumIdentificacion(familiaCTPOSTNOTICREARptNumIdentTitular);
                step300Request.setPersonaCTNEWptpatrMail(null);
                step300Request.setPersonaCTNEWptpatrPrimerNombre(null);
                step300Request.setPersonaCTNEWptpatrSegundoNombre(null);
                step300Request.setPersonaCTNEWptpatrPrimerApellido(null);
                step300Request.setPersonaCTNEWptpatrSegundoApellido(null);
                step300Request.setPersonaCTNEWptpatrFechaNacimiento(null);
                step300Request.setPersonaCTNEWptpatrGenero(null);
                step300Request.setPersonaCTNEWptpatrIndicadorExtranjero(Boolean.FALSE);
                step300Request.setPersonaCTNEWptpatrRazonSocial(null);
                step300Request.setPersonaCTNEWptpatrTieneEPSSanitas(Boolean.FALSE);
                step300Request.setPersonaCTNEWptpatrRechazadoAfiliacion(null);
                step300Request.setPersonaCTNEWptpatrNombreCompleto(familiaCTPOSTNOTICREARptNombreCompletoTitular);
                step300Request.setPersonaCTNEWptpatrCodigo(null);
                personaCSrv.tNEWImplementation(step300Request);
            } else {
                /* Action 301: IF (ContratoC.PersonaCContratante = PersonaCTitular AND (ContratoC.PersonaCContratante.TipoIdentificacionC <> ptTipoIdentTitular OR ContratoC.PersonaCContratante.NumIdentificacion <> ptNumIdentTitular)) */
                boolean ifCondition301 = familiaCTPOSTNOTICREARpthisFamiliaC.getContratoC().getPersonaCContratante().equalsObject(familiaCTPOSTNOTICREARpthisFamiliaC.getPersonaCTitular()) && (!(familiaCTPOSTNOTICREARpthisFamiliaC.getContratoC().getPersonaCContratante().getTipoIdentificacionC().equalsObject(familiaCTPOSTNOTICREARptTipoIdentTitular)) || !STDFunctions.areEqual(familiaCTPOSTNOTICREARpthisFamiliaC.getContratoC().getPersonaCContratante().getPersonaCNumIdentificacion(),familiaCTPOSTNOTICREARptNumIdentTitular));
                if (ifCondition301) {
                    com.keralty.aesolicitudes.viewmodel.familiac.siu.DelPersonaCTitularRequest step3010Request = new com.keralty.aesolicitudes.viewmodel.familiac.siu.DelPersonaCTitularRequest();
                    step3010Request.setFamiliaCDelPersonaCTitularpthisFamiliaCInstance(familiaCTPOSTNOTICREARpthisFamiliaC);
                    step3010Request.setFamiliaCDelPersonaCTitularpevcPersonaCInstance(familiaCTPOSTNOTICREARpthisFamiliaC.getPersonaCTitular());
                    familiaCSrv.delPersonaCTitularImplementation(step3010Request, true);
                    com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWRequest step3011Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWRequest();
                    step3011Request.setPersonaCTNEWptpagrTipoInstitucionCInstance(null);
                    step3011Request.setPersonaCTNEWptpagrTipoEntidadCInstance(null);
                    step3011Request.setPersonaCTNEWptpagrEstadoCivilCInstance(null);
                    step3011Request.setPersonaCTNEWptpagrEstadoPersonaCInstance(null);
                    step3011Request.setPersonaCTNEWptpagrTipoIdentificacionCInstance(familiaCTPOSTNOTICREARptTipoIdentTitular);
                    step3011Request.setPersonaCTNEWptpagrMunicipioCNacInstance(null);
                    step3011Request.setPersonaCTNEWptpagrDepartamentoCNacInstance(null);
                    step3011Request.setPersonaCTNEWptpagrContratosCInstance(null);
                    step3011Request.setPersonaCTNEWptpagrFamiliasCInstance(familiaCTPOSTNOTICREARpthisFamiliaC);
                    step3011Request.setPersonaCTNEWptpagrBeneficiariosCInstance(null);
                    step3011Request.setPersonaCTNEWptpatrNumIdentificacion(familiaCTPOSTNOTICREARptNumIdentTitular);
                    step3011Request.setPersonaCTNEWptpatrMail(null);
                    step3011Request.setPersonaCTNEWptpatrPrimerNombre(null);
                    step3011Request.setPersonaCTNEWptpatrSegundoNombre(null);
                    step3011Request.setPersonaCTNEWptpatrPrimerApellido(null);
                    step3011Request.setPersonaCTNEWptpatrSegundoApellido(null);
                    step3011Request.setPersonaCTNEWptpatrFechaNacimiento(null);
                    step3011Request.setPersonaCTNEWptpatrGenero(null);
                    step3011Request.setPersonaCTNEWptpatrIndicadorExtranjero(Boolean.FALSE);
                    step3011Request.setPersonaCTNEWptpatrRazonSocial(null);
                    step3011Request.setPersonaCTNEWptpatrTieneEPSSanitas(Boolean.FALSE);
                    step3011Request.setPersonaCTNEWptpatrRechazadoAfiliacion(null);
                    step3011Request.setPersonaCTNEWptpatrNombreCompleto(familiaCTPOSTNOTICREARptNombreCompletoTitular);
                    step3011Request.setPersonaCTNEWptpatrCodigo(null);
                    personaCSrv.tNEWImplementation(step3011Request);
                } else {
                    com.keralty.aesolicitudes.viewmodel.personac.siu.TMODIFICARRequest step3012Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.TMODIFICARRequest();
                    step3012Request.setPersonaCTMODIFICARpthisPersonaCInstance(familiaCTPOSTNOTICREARpthisFamiliaC.getPersonaCTitular());
                    step3012Request.setPersonaCTMODIFICARptpeNombreCompleto(familiaCTPOSTNOTICREARptNombreCompletoTitular);
                    step3012Request.setPersonaCTMODIFICARptpeNumIdent(familiaCTPOSTNOTICREARptNumIdentTitular);
                    step3012Request.setPersonaCTMODIFICARptpevcTipoIdentificacionInstance(familiaCTPOSTNOTICREARptTipoIdentTitular);
                    personaCSrv.tMODIFICARImplementation(step3012Request);
                }
            }
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyOCOCFamiliaCNumero(queryRequest, select);
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(FamiliaCConstants.CLASS_NAME, FamiliaCConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ATTR_FIELD_CONTRATOCID, false), true);
        select.getOrderByPart().addItem(Constants.normalizePath(FamiliaCConstants.CLASS_NAME, FamiliaCConstants.ATTR_FIELD_FAMILIACID, false), true);
    }


    private void applyOCOCFamiliaCNumero(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_FamiliaCNumero".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(FamiliaCConstants.CLASS_NAME, FamiliaCConstants.ATTR_NAME_FAMILIACNUMFAMILIA, false), true);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildFamiliaCRelatedInstance(relatedInstanceJsonOid);
        }
        if (FamiliaCConstants.ROLE_NAME_PERSONACTITULAR.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFamiliaCRelatedInstance4PersonaC(relatedInstanceJsonOid, remainingPath);
        }
        if (FamiliaCConstants.ROLE_NAME_BENEFICIARIOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFamiliaCRelatedInstance4BeneficiarioC(relatedInstanceJsonOid, remainingPath);
        }
        if (FamiliaCConstants.ROLE_NAME_CONTRATOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFamiliaCRelatedInstance4ContratoC(relatedInstanceJsonOid, remainingPath);
        }
        if (FamiliaCConstants.ROLE_NAME_MUNICIPIOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFamiliaCRelatedInstance4Municipio(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildFamiliaCRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new FamiliaC(mapper.readValue(relatedInstanceJsonOid, FamiliaCOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFamiliaCRelatedInstance4PersonaC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new PersonaC(mapper.readValue(relatedInstanceJsonOid, PersonaCOid.class)): PersonaC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFamiliaCRelatedInstance4BeneficiarioC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new BeneficiarioC(mapper.readValue(relatedInstanceJsonOid, BeneficiarioCOid.class)): BeneficiarioC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFamiliaCRelatedInstance4ContratoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ContratoC(mapper.readValue(relatedInstanceJsonOid, ContratoCOid.class)): ContratoC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFamiliaCRelatedInstance4Municipio(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Municipio(mapper.readValue(relatedInstanceJsonOid, MunicipioOid.class)): Municipio.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            FamiliaCOid oid = new FamiliaCOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FamiliaCConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ATTR_FIELD_CONTRATOCID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getContratoCContratoCID(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(FamiliaCConstants.ATTR_FIELD_FAMILIACID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(oid.getFamiliaCID(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison2);
        } catch (Exception e) {
            LoggerFactory.getLogger(FamiliaCService.class).error(e.getMessage());
        }
    }

}
