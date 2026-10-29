package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.MinCardinalityException;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.BeneficiarioCConstants;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.global.STDFunctions;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.AnexoC;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.Companyia;
import com.keralty.aesolicitudes.persistence.ConceptoC;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Eps;
import com.keralty.aesolicitudes.persistence.EstadoBeneficiario;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.oid.AnexoCOid;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.CompanyiaOid;
import com.keralty.aesolicitudes.persistence.oid.ConceptoCOid;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.EpsOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoBeneficiarioOid;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;
import com.keralty.aesolicitudes.persistence.oid.ParentescoOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.oid.TipoIdentificacionOid;
import com.keralty.aesolicitudes.persistence.oid.UsuarioOid;
import com.keralty.aesolicitudes.persistence.Parentesco;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.PreexistenciaC;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.persistence.Usuario;
import com.keralty.aesolicitudes.repository.BeneficiarioCJpaRepository;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLWhereComparison;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aesolicitudes.utils.Utilities;
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
public class BeneficiarioCService extends AbstractService {

    BeneficiarioCJpaRepository repository;

    BeneficiarioCService beneficiarioCSrv;

    EpsService epsSrv;

    CompanyiaService companyiaSrv;

    ParentescoService parentescoSrv;

    EstadoBeneficiarioService estadoBeneficiarioSrv;

    ContratoCService contratoCSrv;

    FamiliaCService familiaCSrv;

    PersonaCService personaCSrv;

    AnexoCService anexoCSrv;

    ConceptoCService conceptoCSrv;

    UsuarioService usuarioSrv;

    SolicitudService solicitudSrv;

    PersonaService personaSrv;

    AnexoMatService anexoMatSrv;

    PeriodicidadService periodicidadSrv;

    TipoIdentificacionService tipoIdentificacionSrv;

    InstitucionMatNeoService institucionMatNeoSrv;

    TarifaService tarifaSrv;

    ProductosService productosSrv;

    AnexoNeoService anexoNeoSrv;

    PreexistenciaCService preexistenciaCSrv;

    @Inject
    public BeneficiarioCService(
            BeneficiarioCService beneficiarioCSrv,
            EpsService epsSrv,
            CompanyiaService companyiaSrv,
            ParentescoService parentescoSrv,
            EstadoBeneficiarioService estadoBeneficiarioSrv,
            ContratoCService contratoCSrv,
            FamiliaCService familiaCSrv,
            PersonaCService personaCSrv,
            AnexoCService anexoCSrv,
            ConceptoCService conceptoCSrv,
            UsuarioService usuarioSrv,
            SolicitudService solicitudSrv,
            PersonaService personaSrv,
            AnexoMatService anexoMatSrv,
            PeriodicidadService periodicidadSrv,
            TipoIdentificacionService tipoIdentificacionSrv,
            InstitucionMatNeoService institucionMatNeoSrv,
            TarifaService tarifaSrv,
            ProductosService productosSrv,
            AnexoNeoService anexoNeoSrv,
            PreexistenciaCService preexistenciaCSrv,
            BeneficiarioCJpaRepository repository) {
        this.beneficiarioCSrv = beneficiarioCSrv;
        this.epsSrv = epsSrv;
        this.companyiaSrv = companyiaSrv;
        this.parentescoSrv = parentescoSrv;
        this.estadoBeneficiarioSrv = estadoBeneficiarioSrv;
        this.contratoCSrv = contratoCSrv;
        this.familiaCSrv = familiaCSrv;
        this.personaCSrv = personaCSrv;
        this.anexoCSrv = anexoCSrv;
        this.conceptoCSrv = conceptoCSrv;
        this.usuarioSrv = usuarioSrv;
        this.solicitudSrv = solicitudSrv;
        this.personaSrv = personaSrv;
        this.anexoMatSrv = anexoMatSrv;
        this.periodicidadSrv = periodicidadSrv;
        this.tipoIdentificacionSrv = tipoIdentificacionSrv;
        this.institucionMatNeoSrv = institucionMatNeoSrv;
        this.tarifaSrv = tarifaSrv;
        this.productosSrv = productosSrv;
        this.anexoNeoSrv = anexoNeoSrv;
        this.preexistenciaCSrv = preexistenciaCSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, BeneficiarioCConstants.CLASS_NAME);
    }

    private List<BeneficiarioC> solveBeneficiarioCTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, BeneficiarioCConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveBeneficiarioCTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, BeneficiarioCConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class BeneficiarioC
     *
     * @return Population of class BeneficiarioC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<BeneficiarioC> get() {
        List<BeneficiarioC> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class BeneficiarioC that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class BeneficiarioC matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<BeneficiarioC> get(QueryRequest queryRequest) {
        return solveBeneficiarioCTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveBeneficiarioCTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveBeneficiarioCTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveBeneficiarioCTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of BeneficiarioC by ID
     *
     * @param contratoCContratoCID Identification field contratoCContratoCID
     *
     * @param beneficiarioCID Identification field beneficiarioCID
     *
     * @return Instance of BeneficiarioC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public BeneficiarioC getById(Long contratoCContratoCID, Long beneficiarioCID) {
        return getByOID(new BeneficiarioCOid(contratoCContratoCID, beneficiarioCID));
    }
    
    /*
     * Returns an instance of BeneficiarioC by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of BeneficiarioC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public BeneficiarioC getByOID(BeneficiarioCOid oid) {
        Optional<BeneficiarioC> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of BeneficiarioC by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of BeneficiarioC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public BeneficiarioC getByOIDWithHV(BeneficiarioCOid oid) {
        Optional<BeneficiarioC> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<BeneficiarioC> getInstanceByOid(BeneficiarioCOid oid) {
        return oid != null && oid.getContratoCContratoCID() != null
               ? repository.findById(oid)
               : Optional.empty();
    }

    /*
     * Returns an instance of BeneficiarioC by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of BeneficiarioC
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public BeneficiarioC getByJsonOid(String jsonOid) {
        BeneficiarioCOid oid = new BeneficiarioCOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of BeneficiarioC related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of BeneficiarioC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<BeneficiarioC> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveBeneficiarioCTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of BeneficiarioC related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of BeneficiarioC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<BeneficiarioC> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of BeneficiarioC
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of BeneficiarioC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getBeneficiarioCDynamic(BeneficiarioCOid oid, String displaySetItems) {
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
    public String getSuppInfo(BeneficiarioCOid oid, String dsName) {
        BeneficiarioC instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(BeneficiarioC instance, String dsName) {
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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.crearTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.CrearRequest request) throws ModelException {
        request.setBeneficiarioCcrearpagrEPSCInstance(epsSrv.getByOIDWithHV(request.getBeneficiarioCcrearpagrEPSC()));
        request.setBeneficiarioCcrearpagrCompanyiaMPCInstance(companyiaSrv.getByOIDWithHV(request.getBeneficiarioCcrearpagrCompanyiaMPC()));
        request.setBeneficiarioCcrearpagrParentescoCInstance(parentescoSrv.getByOIDWithHV(request.getBeneficiarioCcrearpagrParentescoC()));
        request.setBeneficiarioCcrearpagrEstadoBeneficiarioCInstance(estadoBeneficiarioSrv.getByOIDWithHV(request.getBeneficiarioCcrearpagrEstadoBeneficiarioC()));
        request.setBeneficiarioCcrearpagrContratoCInstance(contratoCSrv.getByOIDWithHV(request.getBeneficiarioCcrearpagrContratoC()));
        request.setBeneficiarioCcrearpagrFamiliasCInstance(familiaCSrv.getByOIDWithHV(request.getBeneficiarioCcrearpagrFamiliasC()));
        request.setBeneficiarioCcrearpagrPersonaCInstance(personaCSrv.getByOIDWithHV(request.getBeneficiarioCcrearpagrPersonaC()));
        return beneficiarioCSrv.crearImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Eps beneficiarioCcrearpagrEPSC = request.getBeneficiarioCcrearpagrEPSCInstance();
        Companyia beneficiarioCcrearpagrCompanyiaMPC = request.getBeneficiarioCcrearpagrCompanyiaMPCInstance();
        Parentesco beneficiarioCcrearpagrParentescoC = request.getBeneficiarioCcrearpagrParentescoCInstance();
        EstadoBeneficiario beneficiarioCcrearpagrEstadoBeneficiarioC = request.getBeneficiarioCcrearpagrEstadoBeneficiarioCInstance();
        ContratoC beneficiarioCcrearpagrContratoC = request.getBeneficiarioCcrearpagrContratoCInstance();
        FamiliaC beneficiarioCcrearpagrFamiliasC = request.getBeneficiarioCcrearpagrFamiliasCInstance();
        String beneficiarioCcrearpatrCodigoTipoUsuario = request.getBeneficiarioCcrearpatrCodigoTipoUsuario();
        Boolean beneficiarioCcrearpatrIndicadorBBGestacion = request.getBeneficiarioCcrearpatrIndicadorBBGestacion();
        String beneficiarioCcrearpatrCodUsuarioBancoRep = request.getBeneficiarioCcrearpatrCodUsuarioBancoRep();
        Date beneficiarioCcrearpatrFechaAntiguedad = request.getBeneficiarioCcrearpatrFechaAntiguedad();
        Date beneficiarioCcrearpatrFechaAntiguedadRealOSI = request.getBeneficiarioCcrearpatrFechaAntiguedadRealOSI();
        Boolean beneficiarioCcrearpatrRequiereExamenMedico = request.getBeneficiarioCcrearpatrRequiereExamenMedico();
        Long beneficiarioCcrearpatrEstadoMedico = request.getBeneficiarioCcrearpatrEstadoMedico();
        Double beneficiarioCcrearpatrValorCuotaInscripcion = request.getBeneficiarioCcrearpatrValorCuotaInscripcion();
        Boolean beneficiarioCcrearpatrTienePreexistencias = request.getBeneficiarioCcrearpatrTienePreexistencias();
        Date beneficiarioCcrearpatrFechaInicioVigencia = request.getBeneficiarioCcrearpatrFechaInicioVigencia();
        Date beneficiarioCcrearpatrFechaFinVigencia = request.getBeneficiarioCcrearpatrFechaFinVigencia();
        Long beneficiarioCcrearpatrNumUsuario = request.getBeneficiarioCcrearpatrNumUsuario();

        request.checkArguments();
        BeneficiarioC instance = new BeneficiarioC();
        if (beneficiarioCcrearpagrEPSC != null && !beneficiarioCcrearpagrEPSC.isNull()) {
            instance.add2EPSC(beneficiarioCcrearpagrEPSC);
        }

        if (beneficiarioCcrearpagrCompanyiaMPC != null && !beneficiarioCcrearpagrCompanyiaMPC.isNull()) {
            instance.add2CompanyiaMPC(beneficiarioCcrearpagrCompanyiaMPC);
        }

        instance.add2ParentescoC(beneficiarioCcrearpagrParentescoC);

        if (beneficiarioCcrearpagrEstadoBeneficiarioC != null && !beneficiarioCcrearpagrEstadoBeneficiarioC.isNull()) {
            instance.add2EstadoBeneficiarioC(beneficiarioCcrearpagrEstadoBeneficiarioC);
        }

        instance.add2ContratoC(beneficiarioCcrearpagrContratoC);

        instance.add2FamiliasC(beneficiarioCcrearpagrFamiliasC);


        instance.setBeneficiarioCID(Long.valueOf(0));
        instance.setBeneficiarioCID(repository.nextBeneficiarioCID(instance.getContratoCContratoCID()));
        instance.setBeneficiarioCCodigoTipoUsuario(beneficiarioCcrearpatrCodigoTipoUsuario);
        instance.setBeneficiarioCIndicadorBBGestacion(beneficiarioCcrearpatrIndicadorBBGestacion);
        instance.setBeneficiarioCCodUsuarioBancoRep(beneficiarioCcrearpatrCodUsuarioBancoRep);
        instance.setBeneficiarioCFechaAntiguedad(beneficiarioCcrearpatrFechaAntiguedad);
        instance.setBeneficiarioCFechaAntiguedadRealOSI(beneficiarioCcrearpatrFechaAntiguedadRealOSI);
        instance.setBeneficiarioCRequiereExamenMedico(beneficiarioCcrearpatrRequiereExamenMedico);
        instance.setBeneficiarioCEstadoMedico(beneficiarioCcrearpatrEstadoMedico);
        instance.setBeneficiarioCValorCuotaInscripcion(beneficiarioCcrearpatrValorCuotaInscripcion);
        instance.setBeneficiarioCTienePreexistencias(beneficiarioCcrearpatrTienePreexistencias);
        instance.setBeneficiarioCFechaInicioVigencia(beneficiarioCcrearpatrFechaInicioVigencia);
        instance.setBeneficiarioCFechaFinVigencia(beneficiarioCcrearpatrFechaFinVigencia);
        instance.setBeneficiarioCNumUsuario(beneficiarioCcrearpatrNumUsuario);

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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.eliminarTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.EliminarRequest request) throws ModelException {
        request.setBeneficiarioCeliminarpthisBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getBeneficiarioCeliminarpthisBeneficiarioC()));
        return beneficiarioCSrv.eliminarImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        BeneficiarioC beneficiarioCeliminarpthisBeneficiarioC = request.getBeneficiarioCeliminarpthisBeneficiarioCInstance();

        request.checkArguments();
        BeneficiarioC instance = beneficiarioCeliminarpthisBeneficiarioC;
        if(beneficiarioCeliminarpthisBeneficiarioC.getPersonaC() != null && !beneficiarioCeliminarpthisBeneficiarioC.getPersonaC().isNull()) {
            throw new MinCardinalityException(BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ROLE_ALIAS_PERSONAC);
        }
        if(beneficiarioCeliminarpthisBeneficiarioC.getAnexosC().size() > 0) {
            throw new MinCardinalityException(BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ROLE_ALIAS_ANEXOSC);
        }
        if(beneficiarioCeliminarpthisBeneficiarioC.getConceptosC().size() > 0) {
            throw new MinCardinalityException(BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ROLE_ALIAS_CONCEPTOSC);
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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.ModificarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.modificarTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.ModificarRequest request) throws ModelException {
        request.setBeneficiarioCmodificarpthisBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getBeneficiarioCmodificarpthisBeneficiarioC()));
        return beneficiarioCSrv.modificarImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.ModificarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        BeneficiarioC beneficiarioCmodificarpthisBeneficiarioC = request.getBeneficiarioCmodificarpthisBeneficiarioCInstance();
        Long beneficiarioCmodificarpNumUsuario = request.getBeneficiarioCmodificarpNumUsuario();
        String beneficiarioCmodificarpCodigoTipoUsuario = request.getBeneficiarioCmodificarpCodigoTipoUsuario();
        Boolean beneficiarioCmodificarpIndicadorBBGestacion = request.getBeneficiarioCmodificarpIndicadorBBGestacion();
        String beneficiarioCmodificarpCodUsuarioBancoRep = request.getBeneficiarioCmodificarpCodUsuarioBancoRep();
        Date beneficiarioCmodificarpFechaAntiguedad = request.getBeneficiarioCmodificarpFechaAntiguedad();
        Boolean beneficiarioCmodificarpRequiereExamenMedico = request.getBeneficiarioCmodificarpRequiereExamenMedico();
        Long beneficiarioCmodificarpEstadoMedico = request.getBeneficiarioCmodificarpEstadoMedico();
        Date beneficiarioCmodificarpFechaAntiguedadRealOSI = request.getBeneficiarioCmodificarpFechaAntiguedadRealOSI();
        Double beneficiarioCmodificarpValorCuotaInscripcion = request.getBeneficiarioCmodificarpValorCuotaInscripcion();
        Boolean beneficiarioCmodificarpTienePreexistencias = request.getBeneficiarioCmodificarpTienePreexistencias();
        Date beneficiarioCmodificarpFechaInicioVigencia = request.getBeneficiarioCmodificarpFechaInicioVigencia();
        Date beneficiarioCmodificarpFechaFinVigencia = request.getBeneficiarioCmodificarpFechaFinVigencia();

        request.checkArguments();
        BeneficiarioC instance = beneficiarioCmodificarpthisBeneficiarioC;
        instance.setBeneficiarioCNumUsuario(beneficiarioCmodificarpNumUsuario);
        instance.setBeneficiarioCCodigoTipoUsuario(beneficiarioCmodificarpCodigoTipoUsuario);
        instance.setBeneficiarioCIndicadorBBGestacion(beneficiarioCmodificarpIndicadorBBGestacion);
        instance.setBeneficiarioCCodUsuarioBancoRep(beneficiarioCmodificarpCodUsuarioBancoRep);
        instance.setBeneficiarioCFechaAntiguedad(beneficiarioCmodificarpFechaAntiguedad);
        instance.setBeneficiarioCRequiereExamenMedico(beneficiarioCmodificarpRequiereExamenMedico);
        instance.setBeneficiarioCEstadoMedico(beneficiarioCmodificarpEstadoMedico);
        instance.setBeneficiarioCFechaAntiguedadRealOSI(beneficiarioCmodificarpFechaAntiguedadRealOSI);
        instance.setBeneficiarioCValorCuotaInscripcion(beneficiarioCmodificarpValorCuotaInscripcion);
        instance.setBeneficiarioCTienePreexistencias(beneficiarioCmodificarpTienePreexistencias);
        instance.setBeneficiarioCFechaInicioVigencia(beneficiarioCmodificarpFechaInicioVigencia);
        instance.setBeneficiarioCFechaFinVigencia(beneficiarioCmodificarpFechaFinVigencia);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: modificarTrasCORE

    /*
     * Entry point for service modificarTrasCORE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse modificarTrasCORE(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.ModificarTrasCORERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.modificarTrasCORETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service modificarTrasCORE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse modificarTrasCORETxn(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.ModificarTrasCORERequest request) throws ModelException {
        request.setBeneficiarioCmodificarTrasCOREpthisBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getBeneficiarioCmodificarTrasCOREpthisBeneficiarioC()));
        return beneficiarioCSrv.modificarTrasCOREImplementation(request);
    }

    /*
     * Implements service modificarTrasCORE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse modificarTrasCOREImplementation(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.ModificarTrasCORERequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        BeneficiarioC beneficiarioCmodificarTrasCOREpthisBeneficiarioC = request.getBeneficiarioCmodificarTrasCOREpthisBeneficiarioCInstance();
        Long beneficiarioCmodificarTrasCOREpNumUsuario = request.getBeneficiarioCmodificarTrasCOREpNumUsuario();
        Boolean beneficiarioCmodificarTrasCOREpRequiereExamenMedico = request.getBeneficiarioCmodificarTrasCOREpRequiereExamenMedico();
        Long beneficiarioCmodificarTrasCOREpEstadoMedico = request.getBeneficiarioCmodificarTrasCOREpEstadoMedico();
        Date beneficiarioCmodificarTrasCOREpFechaAntiguedadRealOSI = request.getBeneficiarioCmodificarTrasCOREpFechaAntiguedadRealOSI();
        Boolean beneficiarioCmodificarTrasCOREpTienePreexistencias = request.getBeneficiarioCmodificarTrasCOREpTienePreexistencias();

        request.checkArguments();
        BeneficiarioC instance = beneficiarioCmodificarTrasCOREpthisBeneficiarioC;
        instance.setBeneficiarioCNumUsuario(beneficiarioCmodificarTrasCOREpNumUsuario);
        instance.setBeneficiarioCRequiereExamenMedico(beneficiarioCmodificarTrasCOREpRequiereExamenMedico);
        instance.setBeneficiarioCEstadoMedico(beneficiarioCmodificarTrasCOREpEstadoMedico);
        instance.setBeneficiarioCFechaAntiguedadRealOSI(beneficiarioCmodificarTrasCOREpFechaAntiguedadRealOSI);
        instance.setBeneficiarioCTienePreexistencias(beneficiarioCmodificarTrasCOREpTienePreexistencias);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsEstadoBeneficiarioC

    /*
     * Entry point for service InsEstadoBeneficiarioC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insEstadoBeneficiarioC(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsEstadoBeneficiarioCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.insEstadoBeneficiarioCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsEstadoBeneficiarioC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insEstadoBeneficiarioCTxn(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsEstadoBeneficiarioCRequest request) throws ModelException {
        request.setBeneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getBeneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioC()));
        request.setBeneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiarioInstance(estadoBeneficiarioSrv.getByOIDWithHV(request.getBeneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiario()));
        return beneficiarioCSrv.insEstadoBeneficiarioCImplementation(request, true);
    }

    /*
     * Implements service InsEstadoBeneficiarioC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insEstadoBeneficiarioCImplementation(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsEstadoBeneficiarioCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        BeneficiarioC beneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioC = request.getBeneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioCInstance();
        EstadoBeneficiario beneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiario = request.getBeneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiarioInstance();

        request.checkArguments();
        BeneficiarioC instance = beneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioC;

        instance.add2EstadoBeneficiarioC(beneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiario);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.estadobeneficiario.siu.InsEstadoBeneficiarioCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.estadobeneficiario.siu.InsEstadoBeneficiarioCRequest();
            relatedRequest.setEstadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiarioInstance(beneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiario);
            relatedRequest.setEstadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioCInstance(beneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioC);
            estadoBeneficiarioSrv.insEstadoBeneficiarioCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelEstadoBeneficiarioC

    /*
     * Entry point for service DelEstadoBeneficiarioC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delEstadoBeneficiarioC(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelEstadoBeneficiarioCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.delEstadoBeneficiarioCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelEstadoBeneficiarioC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delEstadoBeneficiarioCTxn(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelEstadoBeneficiarioCRequest request) throws ModelException {
        request.setBeneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getBeneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioC()));
        request.setBeneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiarioInstance(estadoBeneficiarioSrv.getByOIDWithHV(request.getBeneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiario()));
        return beneficiarioCSrv.delEstadoBeneficiarioCImplementation(request, true);
    }

    /*
     * Implements service DelEstadoBeneficiarioC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delEstadoBeneficiarioCImplementation(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelEstadoBeneficiarioCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        BeneficiarioC beneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioC = request.getBeneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioCInstance();
        EstadoBeneficiario beneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiario = request.getBeneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiarioInstance();

        request.checkArguments();
        BeneficiarioC instance = beneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioC;

        instance.add2EstadoBeneficiarioC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.estadobeneficiario.siu.DelEstadoBeneficiarioCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.estadobeneficiario.siu.DelEstadoBeneficiarioCRequest();
            relatedRequest.setEstadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiarioInstance(beneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiario);
            relatedRequest.setEstadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioCInstance(beneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioC);
            estadoBeneficiarioSrv.delEstadoBeneficiarioCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsBeneficiariosC

    /*
     * Entry point for service InsBeneficiariosC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insBeneficiariosC(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsBeneficiariosCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.insBeneficiariosCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsBeneficiariosC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insBeneficiariosCTxn(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsBeneficiariosCRequest request) throws ModelException {
        request.setBeneficiarioCInsBeneficiariosCpthisBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getBeneficiarioCInsBeneficiariosCpthisBeneficiarioC()));
        request.setBeneficiarioCInsBeneficiariosCpevcPersonaCInstance(personaCSrv.getByOIDWithHV(request.getBeneficiarioCInsBeneficiariosCpevcPersonaC()));
        return beneficiarioCSrv.insBeneficiariosCImplementation(request, true);
    }

    /*
     * Implements service InsBeneficiariosC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insBeneficiariosCImplementation(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsBeneficiariosCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        BeneficiarioC beneficiarioCInsBeneficiariosCpthisBeneficiarioC = request.getBeneficiarioCInsBeneficiariosCpthisBeneficiarioCInstance();
        PersonaC beneficiarioCInsBeneficiariosCpevcPersonaC = request.getBeneficiarioCInsBeneficiariosCpevcPersonaCInstance();

        request.checkArguments();
        BeneficiarioC instance = beneficiarioCInsBeneficiariosCpthisBeneficiarioC;

        instance.add2PersonaC(beneficiarioCInsBeneficiariosCpevcPersonaC);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsBeneficiariosCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.personac.siu.InsBeneficiariosCRequest();
            relatedRequest.setPersonaCInsBeneficiariosCpthisPersonaCInstance(beneficiarioCInsBeneficiariosCpevcPersonaC);
            relatedRequest.setPersonaCInsBeneficiariosCpevcBeneficiarioCInstance(beneficiarioCInsBeneficiariosCpthisBeneficiarioC);
            personaCSrv.insBeneficiariosCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelBeneficiariosC

    /*
     * Entry point for service DelBeneficiariosC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delBeneficiariosC(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelBeneficiariosCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.delBeneficiariosCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelBeneficiariosC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delBeneficiariosCTxn(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelBeneficiariosCRequest request) throws ModelException {
        request.setBeneficiarioCDelBeneficiariosCpthisBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getBeneficiarioCDelBeneficiariosCpthisBeneficiarioC()));
        request.setBeneficiarioCDelBeneficiariosCpevcPersonaCInstance(personaCSrv.getByOIDWithHV(request.getBeneficiarioCDelBeneficiariosCpevcPersonaC()));
        return beneficiarioCSrv.delBeneficiariosCImplementation(request, true);
    }

    /*
     * Implements service DelBeneficiariosC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delBeneficiariosCImplementation(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelBeneficiariosCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        BeneficiarioC beneficiarioCDelBeneficiariosCpthisBeneficiarioC = request.getBeneficiarioCDelBeneficiariosCpthisBeneficiarioCInstance();
        PersonaC beneficiarioCDelBeneficiariosCpevcPersonaC = request.getBeneficiarioCDelBeneficiariosCpevcPersonaCInstance();

        request.checkArguments();
        BeneficiarioC instance = beneficiarioCDelBeneficiariosCpthisBeneficiarioC;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelBeneficiariosCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.personac.siu.DelBeneficiariosCRequest();
            relatedRequest.setPersonaCDelBeneficiariosCpthisPersonaCInstance(beneficiarioCDelBeneficiariosCpevcPersonaC);
            relatedRequest.setPersonaCDelBeneficiariosCpevcBeneficiarioCInstance(beneficiarioCDelBeneficiariosCpthisBeneficiarioC);
            personaCSrv.delBeneficiariosCImplementation(relatedRequest, false);
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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.EvalPostNotiCrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.evalPostNotiCrearTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.EvalPostNotiCrearRequest request) throws ModelException {
        request.setBeneficiarioCevalPostNotiCrearpthisBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getBeneficiarioCevalPostNotiCrearpthisBeneficiarioC()));
        return beneficiarioCSrv.evalPostNotiCrearImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.EvalPostNotiCrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        BeneficiarioC beneficiarioCevalPostNotiCrearpthisBeneficiarioC = request.getBeneficiarioCevalPostNotiCrearpthisBeneficiarioCInstance();
        Long beneficiarioCevalPostNotiCrearpNumUsuario = request.getBeneficiarioCevalPostNotiCrearpNumUsuario();
        String beneficiarioCevalPostNotiCrearpCodigoTipoUsuario = request.getBeneficiarioCevalPostNotiCrearpCodigoTipoUsuario();
        Boolean beneficiarioCevalPostNotiCrearpIndicadorBBGestacion = request.getBeneficiarioCevalPostNotiCrearpIndicadorBBGestacion();
        String beneficiarioCevalPostNotiCrearpCodUsuarioBancoRep = request.getBeneficiarioCevalPostNotiCrearpCodUsuarioBancoRep();
        Date beneficiarioCevalPostNotiCrearpFechaAntiguedad = request.getBeneficiarioCevalPostNotiCrearpFechaAntiguedad();
        Long beneficiarioCevalPostNotiCrearpEstadoMedico = request.getBeneficiarioCevalPostNotiCrearpEstadoMedico();
        Date beneficiarioCevalPostNotiCrearpFechaAntiguedadRealOSI = request.getBeneficiarioCevalPostNotiCrearpFechaAntiguedadRealOSI();
        Boolean beneficiarioCevalPostNotiCrearpTienePreexistencias = request.getBeneficiarioCevalPostNotiCrearpTienePreexistencias();
        Date beneficiarioCevalPostNotiCrearpFechaInicioVigencia = request.getBeneficiarioCevalPostNotiCrearpFechaInicioVigencia();
        Date beneficiarioCevalPostNotiCrearpFechaFinVigencia = request.getBeneficiarioCevalPostNotiCrearpFechaFinVigencia();

        request.checkArguments();
        BeneficiarioC instance = beneficiarioCevalPostNotiCrearpthisBeneficiarioC;
        instance.setBeneficiarioCNumUsuario(beneficiarioCevalPostNotiCrearpNumUsuario);
        instance.setBeneficiarioCCodigoTipoUsuario(beneficiarioCevalPostNotiCrearpCodigoTipoUsuario);
        instance.setBeneficiarioCIndicadorBBGestacion(beneficiarioCevalPostNotiCrearpIndicadorBBGestacion);
        instance.setBeneficiarioCCodUsuarioBancoRep(beneficiarioCevalPostNotiCrearpCodUsuarioBancoRep);
        instance.setBeneficiarioCFechaAntiguedad(beneficiarioCevalPostNotiCrearpFechaAntiguedad);
        instance.setBeneficiarioCEstadoMedico(beneficiarioCevalPostNotiCrearpEstadoMedico);
        instance.setBeneficiarioCFechaAntiguedadRealOSI(beneficiarioCevalPostNotiCrearpFechaAntiguedadRealOSI);
        instance.setBeneficiarioCTienePreexistencias(beneficiarioCevalPostNotiCrearpTienePreexistencias);
        instance.setBeneficiarioCFechaInicioVigencia(beneficiarioCevalPostNotiCrearpFechaInicioVigencia);
        instance.setBeneficiarioCFechaFinVigencia(beneficiarioCevalPostNotiCrearpFechaFinVigencia);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: chgParentescoC

    /*
     * Entry point for service chgParentescoC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse chgParentescoC(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.ChgParentescoCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.chgParentescoCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service chgParentescoC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse chgParentescoCTxn(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.ChgParentescoCRequest request) throws ModelException {
        request.setBeneficiarioCchgParentescoCpthisBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getBeneficiarioCchgParentescoCpthisBeneficiarioC()));
        request.setBeneficiarioCchgParentescoCpevcParentescoInstance(parentescoSrv.getByOIDWithHV(request.getBeneficiarioCchgParentescoCpevcParentesco()));
        return beneficiarioCSrv.chgParentescoCImplementation(request, true);
    }

    /*
     * Implements service chgParentescoC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse chgParentescoCImplementation(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.ChgParentescoCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        BeneficiarioC beneficiarioCchgParentescoCpthisBeneficiarioC = request.getBeneficiarioCchgParentescoCpthisBeneficiarioCInstance();
        Parentesco beneficiarioCchgParentescoCpevcParentesco = request.getBeneficiarioCchgParentescoCpevcParentescoInstance();

        request.checkArguments();
        BeneficiarioC instance = beneficiarioCchgParentescoCpthisBeneficiarioC;

        instance.add2ParentescoC(beneficiarioCchgParentescoCpevcParentesco);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.parentesco.siu.ChgParentescoCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.parentesco.siu.ChgParentescoCRequest();
            relatedRequest.setParentescochgParentescoCpthisParentescoInstance(beneficiarioCchgParentescoCpevcParentesco);
            relatedRequest.setParentescochgParentescoCpevcBeneficiarioCInstance(beneficiarioCchgParentescoCpthisBeneficiarioC);
            parentescoSrv.chgParentescoCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsEPSC

    /*
     * Entry point for service InsEPSC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insEPSC(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsEPSCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.insEPSCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsEPSC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insEPSCTxn(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsEPSCRequest request) throws ModelException {
        request.setBeneficiarioCInsEPSCpthisBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getBeneficiarioCInsEPSCpthisBeneficiarioC()));
        request.setBeneficiarioCInsEPSCpevcEpsInstance(epsSrv.getByOIDWithHV(request.getBeneficiarioCInsEPSCpevcEps()));
        return beneficiarioCSrv.insEPSCImplementation(request, true);
    }

    /*
     * Implements service InsEPSC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insEPSCImplementation(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsEPSCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        BeneficiarioC beneficiarioCInsEPSCpthisBeneficiarioC = request.getBeneficiarioCInsEPSCpthisBeneficiarioCInstance();
        Eps beneficiarioCInsEPSCpevcEps = request.getBeneficiarioCInsEPSCpevcEpsInstance();

        request.checkArguments();
        BeneficiarioC instance = beneficiarioCInsEPSCpthisBeneficiarioC;

        instance.add2EPSC(beneficiarioCInsEPSCpevcEps);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.eps.siu.InsEPSCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.eps.siu.InsEPSCRequest();
            relatedRequest.setEpsInsEPSCpthisEPSInstance(beneficiarioCInsEPSCpevcEps);
            relatedRequest.setEpsInsEPSCpevcBeneficiarioCInstance(beneficiarioCInsEPSCpthisBeneficiarioC);
            epsSrv.insEPSCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelEPSC

    /*
     * Entry point for service DelEPSC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delEPSC(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelEPSCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.delEPSCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelEPSC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delEPSCTxn(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelEPSCRequest request) throws ModelException {
        request.setBeneficiarioCDelEPSCpthisBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getBeneficiarioCDelEPSCpthisBeneficiarioC()));
        request.setBeneficiarioCDelEPSCpevcEpsInstance(epsSrv.getByOIDWithHV(request.getBeneficiarioCDelEPSCpevcEps()));
        return beneficiarioCSrv.delEPSCImplementation(request, true);
    }

    /*
     * Implements service DelEPSC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delEPSCImplementation(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelEPSCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        BeneficiarioC beneficiarioCDelEPSCpthisBeneficiarioC = request.getBeneficiarioCDelEPSCpthisBeneficiarioCInstance();
        Eps beneficiarioCDelEPSCpevcEps = request.getBeneficiarioCDelEPSCpevcEpsInstance();

        request.checkArguments();
        BeneficiarioC instance = beneficiarioCDelEPSCpthisBeneficiarioC;

        instance.add2EPSC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.eps.siu.DelEPSCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.eps.siu.DelEPSCRequest();
            relatedRequest.setEpsDelEPSCpthisEPSInstance(beneficiarioCDelEPSCpevcEps);
            relatedRequest.setEpsDelEPSCpevcBeneficiarioCInstance(beneficiarioCDelEPSCpthisBeneficiarioC);
            epsSrv.delEPSCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsCompanyiaMPC

    /*
     * Entry point for service InsCompanyiaMPC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insCompanyiaMPC(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsCompanyiaMPCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.insCompanyiaMPCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsCompanyiaMPC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insCompanyiaMPCTxn(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsCompanyiaMPCRequest request) throws ModelException {
        request.setBeneficiarioCInsCompanyiaMPCpthisBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getBeneficiarioCInsCompanyiaMPCpthisBeneficiarioC()));
        request.setBeneficiarioCInsCompanyiaMPCpevcCompanyiaInstance(companyiaSrv.getByOIDWithHV(request.getBeneficiarioCInsCompanyiaMPCpevcCompanyia()));
        return beneficiarioCSrv.insCompanyiaMPCImplementation(request, true);
    }

    /*
     * Implements service InsCompanyiaMPC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insCompanyiaMPCImplementation(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsCompanyiaMPCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        BeneficiarioC beneficiarioCInsCompanyiaMPCpthisBeneficiarioC = request.getBeneficiarioCInsCompanyiaMPCpthisBeneficiarioCInstance();
        Companyia beneficiarioCInsCompanyiaMPCpevcCompanyia = request.getBeneficiarioCInsCompanyiaMPCpevcCompanyiaInstance();

        request.checkArguments();
        BeneficiarioC instance = beneficiarioCInsCompanyiaMPCpthisBeneficiarioC;

        instance.add2CompanyiaMPC(beneficiarioCInsCompanyiaMPCpevcCompanyia);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.companyia.siu.InsCompanyiaMPCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.companyia.siu.InsCompanyiaMPCRequest();
            relatedRequest.setCompanyiaInsCompanyiaMPCpthisCompanyiaInstance(beneficiarioCInsCompanyiaMPCpevcCompanyia);
            relatedRequest.setCompanyiaInsCompanyiaMPCpevcBeneficiarioCInstance(beneficiarioCInsCompanyiaMPCpthisBeneficiarioC);
            companyiaSrv.insCompanyiaMPCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelCompanyiaMPC

    /*
     * Entry point for service DelCompanyiaMPC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delCompanyiaMPC(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelCompanyiaMPCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.delCompanyiaMPCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelCompanyiaMPC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delCompanyiaMPCTxn(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelCompanyiaMPCRequest request) throws ModelException {
        request.setBeneficiarioCDelCompanyiaMPCpthisBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getBeneficiarioCDelCompanyiaMPCpthisBeneficiarioC()));
        request.setBeneficiarioCDelCompanyiaMPCpevcCompanyiaInstance(companyiaSrv.getByOIDWithHV(request.getBeneficiarioCDelCompanyiaMPCpevcCompanyia()));
        return beneficiarioCSrv.delCompanyiaMPCImplementation(request, true);
    }

    /*
     * Implements service DelCompanyiaMPC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delCompanyiaMPCImplementation(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelCompanyiaMPCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        BeneficiarioC beneficiarioCDelCompanyiaMPCpthisBeneficiarioC = request.getBeneficiarioCDelCompanyiaMPCpthisBeneficiarioCInstance();
        Companyia beneficiarioCDelCompanyiaMPCpevcCompanyia = request.getBeneficiarioCDelCompanyiaMPCpevcCompanyiaInstance();

        request.checkArguments();
        BeneficiarioC instance = beneficiarioCDelCompanyiaMPCpthisBeneficiarioC;

        instance.add2CompanyiaMPC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.companyia.siu.DelCompanyiaMPCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.companyia.siu.DelCompanyiaMPCRequest();
            relatedRequest.setCompanyiaDelCompanyiaMPCpthisCompanyiaInstance(beneficiarioCDelCompanyiaMPCpevcCompanyia);
            relatedRequest.setCompanyiaDelCompanyiaMPCpevcBeneficiarioCInstance(beneficiarioCDelCompanyiaMPCpthisBeneficiarioC);
            companyiaSrv.delCompanyiaMPCImplementation(relatedRequest, false);
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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TELIMINARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.tELIMINARTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TELIMINARRequest request) throws ModelException, SystemException {
        request.setBeneficiarioCTELIMINARpthisBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getBeneficiarioCTELIMINARpthisBeneficiarioC()));
        return beneficiarioCSrv.tELIMINARImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TELIMINARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        BeneficiarioC beneficiarioCTELIMINARpthisBeneficiarioC = request.getBeneficiarioCTELIMINARpthisBeneficiarioCInstance();

        request.checkArguments();
        BeneficiarioC instance = beneficiarioCTELIMINARpthisBeneficiarioC;

        for(AnexoC step1Entity : repository.assocOperator010(beneficiarioCTELIMINARpthisBeneficiarioC)) {
            com.keralty.aesolicitudes.viewmodel.anexoc.siu.EliminarRequest step1Request = new com.keralty.aesolicitudes.viewmodel.anexoc.siu.EliminarRequest();
            step1Request.setAnexoCeliminarpthisAnexoCInstance(step1Entity);
            anexoCSrv.eliminarImplementation(step1Request);
        }

        for(ConceptoC step2Entity : repository.assocOperator011(beneficiarioCTELIMINARpthisBeneficiarioC)) {
            com.keralty.aesolicitudes.viewmodel.conceptoc.siu.EliminarRequest step2Request = new com.keralty.aesolicitudes.viewmodel.conceptoc.siu.EliminarRequest();
            step2Request.setConceptoCeliminarpthisConceptoCInstance(step2Entity);
            conceptoCSrv.eliminarImplementation(step2Request);
        }

        /* Action 3: IF (EXIST (PersonaC) = true AND FamiliasC.ContratoC.PersonaCContratante <> PersonaC AND FamiliasC.PersonaCTitular <> PersonaC) */
        boolean ifCondition3 = repository.assocOperator013(beneficiarioCTELIMINARpthisBeneficiarioC).equals(true) && !Utilities.isEqual(beneficiarioCTELIMINARpthisBeneficiarioC.getFamiliasC().getContratoC().getPersonaCContratante(), beneficiarioCTELIMINARpthisBeneficiarioC.getPersonaC()) && !Utilities.isEqual(beneficiarioCTELIMINARpthisBeneficiarioC.getFamiliasC().getPersonaCTitular(), beneficiarioCTELIMINARpthisBeneficiarioC.getPersonaC());
        if (ifCondition3) {
            com.keralty.aesolicitudes.viewmodel.personac.siu.TELIMINARRequest step30Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.TELIMINARRequest();
            step30Request.setPersonaCTELIMINARpthisPersonaCInstance(beneficiarioCTELIMINARpthisBeneficiarioC.getPersonaC());
            personaCSrv.tELIMINARImplementation(step30Request);
        }

        com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.EliminarRequest step4Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.EliminarRequest();
        step4Request.setBeneficiarioCeliminarpthisBeneficiarioCInstance(beneficiarioCTELIMINARpthisBeneficiarioC);
        beneficiarioCSrv.eliminarImplementation(step4Request);

        response.setInstance(getByOID(instance.getOid()));

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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TMODIFICARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.tMODIFICARTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TMODIFICARRequest request) throws ModelException, SystemException {
        request.setBeneficiarioCTMODIFICARpthisBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getBeneficiarioCTMODIFICARpthisBeneficiarioC()));
        request.setBeneficiarioCTMODIFICARptpevcEstadoBeneficiarioCInstance(estadoBeneficiarioSrv.getByOIDWithHV(request.getBeneficiarioCTMODIFICARptpevcEstadoBeneficiarioC()));
        return beneficiarioCSrv.tMODIFICARImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TMODIFICARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        EstadoBeneficiario beneficiarioCTMODIFICARptpevcEstadoBeneficiarioC = request.getBeneficiarioCTMODIFICARptpevcEstadoBeneficiarioCInstance();
        Boolean beneficiarioCTMODIFICARptpRequiereExamenMedico = request.getBeneficiarioCTMODIFICARptpRequiereExamenMedico();
        Long beneficiarioCTMODIFICARptpEstadoMedico = request.getBeneficiarioCTMODIFICARptpEstadoMedico();
        Date beneficiarioCTMODIFICARptpFechaAntiguedadRealOSI = request.getBeneficiarioCTMODIFICARptpFechaAntiguedadRealOSI();
        Double beneficiarioCTMODIFICARptpValorCuotaInscripcion = request.getBeneficiarioCTMODIFICARptpValorCuotaInscripcion();
        Boolean beneficiarioCTMODIFICARptpTienePreexistencias = request.getBeneficiarioCTMODIFICARptpTienePreexistencias();
        Date beneficiarioCTMODIFICARptpFechaInicioVigencia = request.getBeneficiarioCTMODIFICARptpFechaInicioVigencia();
        Date beneficiarioCTMODIFICARptpFechaFinVigencia = request.getBeneficiarioCTMODIFICARptpFechaFinVigencia();
        Long beneficiarioCTMODIFICARptpNumUsuario = request.getBeneficiarioCTMODIFICARptpNumUsuario();
        String beneficiarioCTMODIFICARptpCodigoTipoUsuario = request.getBeneficiarioCTMODIFICARptpCodigoTipoUsuario();
        Boolean beneficiarioCTMODIFICARptpIndicadorBBGestacion = request.getBeneficiarioCTMODIFICARptpIndicadorBBGestacion();
        String beneficiarioCTMODIFICARptpCodUsuarioBancoRep = request.getBeneficiarioCTMODIFICARptpCodUsuarioBancoRep();
        Date beneficiarioCTMODIFICARptpFechaAntiguedad = request.getBeneficiarioCTMODIFICARptpFechaAntiguedad();
        BeneficiarioC beneficiarioCTMODIFICARpthisBeneficiarioC = request.getBeneficiarioCTMODIFICARpthisBeneficiarioCInstance();

        request.checkArguments();
        BeneficiarioC instance = beneficiarioCTMODIFICARpthisBeneficiarioC;

        boolean guard1 = repository.assocOperator014(beneficiarioCTMODIFICARpthisBeneficiarioC).equals(false) && (beneficiarioCTMODIFICARptpevcEstadoBeneficiarioC != null && !beneficiarioCTMODIFICARptpevcEstadoBeneficiarioC.isNull());

        if (guard1) {
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsEstadoBeneficiarioCRequest step1Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsEstadoBeneficiarioCRequest();
            step1Request.setBeneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioCInstance(beneficiarioCTMODIFICARpthisBeneficiarioC);
            step1Request.setBeneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiarioInstance(beneficiarioCTMODIFICARptpevcEstadoBeneficiarioC);
            beneficiarioCSrv.insEstadoBeneficiarioCImplementation(step1Request, true);
        }

        boolean guard2 = repository.assocOperator015(beneficiarioCTMODIFICARpthisBeneficiarioC).equals(true) && (beneficiarioCTMODIFICARptpevcEstadoBeneficiarioC == null || beneficiarioCTMODIFICARptpevcEstadoBeneficiarioC.isNull());

        if (guard2) {
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelEstadoBeneficiarioCRequest step2Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelEstadoBeneficiarioCRequest();
            step2Request.setBeneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioCInstance(beneficiarioCTMODIFICARpthisBeneficiarioC);
            step2Request.setBeneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiarioInstance(beneficiarioCTMODIFICARpthisBeneficiarioC.getEstadoBeneficiarioC());
            beneficiarioCSrv.delEstadoBeneficiarioCImplementation(step2Request, true);
        }

        /* Action 3: IF (EXIST (EstadoBeneficiarioC) = true AND ptpevcEstadoBeneficiarioC <> NULL AND EstadoBeneficiarioC <> ptpevcEstadoBeneficiarioC) */
        boolean ifCondition3 = repository.assocOperator017(beneficiarioCTMODIFICARpthisBeneficiarioC).equals(true) && (beneficiarioCTMODIFICARptpevcEstadoBeneficiarioC != null && !beneficiarioCTMODIFICARptpevcEstadoBeneficiarioC.isNull()) && !Utilities.isEqual(beneficiarioCTMODIFICARpthisBeneficiarioC.getEstadoBeneficiarioC(), beneficiarioCTMODIFICARptpevcEstadoBeneficiarioC);
        if (ifCondition3) {
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelEstadoBeneficiarioCRequest step30Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelEstadoBeneficiarioCRequest();
            step30Request.setBeneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioCInstance(beneficiarioCTMODIFICARpthisBeneficiarioC);
            step30Request.setBeneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiarioInstance(beneficiarioCTMODIFICARpthisBeneficiarioC.getEstadoBeneficiarioC());
            beneficiarioCSrv.delEstadoBeneficiarioCImplementation(step30Request, true);
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsEstadoBeneficiarioCRequest step31Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsEstadoBeneficiarioCRequest();
            step31Request.setBeneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioCInstance(beneficiarioCTMODIFICARpthisBeneficiarioC);
            step31Request.setBeneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiarioInstance(beneficiarioCTMODIFICARptpevcEstadoBeneficiarioC);
            beneficiarioCSrv.insEstadoBeneficiarioCImplementation(step31Request, true);
        }

        com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.ModificarRequest step4Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.ModificarRequest();
        step4Request.setBeneficiarioCmodificarpthisBeneficiarioCInstance(beneficiarioCTMODIFICARpthisBeneficiarioC);
        step4Request.setBeneficiarioCmodificarpRequiereExamenMedico(beneficiarioCTMODIFICARptpRequiereExamenMedico);
        step4Request.setBeneficiarioCmodificarpEstadoMedico(beneficiarioCTMODIFICARptpEstadoMedico);
        step4Request.setBeneficiarioCmodificarpFechaAntiguedadRealOSI(beneficiarioCTMODIFICARptpFechaAntiguedadRealOSI);
        step4Request.setBeneficiarioCmodificarpValorCuotaInscripcion(beneficiarioCTMODIFICARptpValorCuotaInscripcion);
        step4Request.setBeneficiarioCmodificarpTienePreexistencias(beneficiarioCTMODIFICARptpTienePreexistencias);
        step4Request.setBeneficiarioCmodificarpFechaInicioVigencia(beneficiarioCTMODIFICARptpFechaInicioVigencia);
        step4Request.setBeneficiarioCmodificarpFechaFinVigencia(beneficiarioCTMODIFICARptpFechaFinVigencia);
        step4Request.setBeneficiarioCmodificarpNumUsuario(beneficiarioCTMODIFICARptpNumUsuario);
        step4Request.setBeneficiarioCmodificarpCodigoTipoUsuario(beneficiarioCTMODIFICARptpCodigoTipoUsuario);
        step4Request.setBeneficiarioCmodificarpIndicadorBBGestacion(beneficiarioCTMODIFICARptpIndicadorBBGestacion);
        step4Request.setBeneficiarioCmodificarpCodUsuarioBancoRep(beneficiarioCTMODIFICARptpCodUsuarioBancoRep);
        step4Request.setBeneficiarioCmodificarpFechaAntiguedad(beneficiarioCTMODIFICARptpFechaAntiguedad);
        beneficiarioCSrv.modificarImplementation(step4Request);

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TACTTRASCORE

    /*
     * Entry point for service TACTTRASCORE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tACTTRASCORE(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TACTTRASCORERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.tACTTRASCORETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TACTTRASCORE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tACTTRASCORETxn(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TACTTRASCORERequest request) throws ModelException, SystemException {
        request.setBeneficiarioCTACTTRASCOREpthisBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getBeneficiarioCTACTTRASCOREpthisBeneficiarioC()));
        request.setBeneficiarioCTACTTRASCOREptEstadoBeneficiarioCInstance(estadoBeneficiarioSrv.getByOIDWithHV(request.getBeneficiarioCTACTTRASCOREptEstadoBeneficiarioC()));
        return beneficiarioCSrv.tACTTRASCOREImplementation(request);
    }

    /*
     * Implements service TACTTRASCORE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tACTTRASCOREImplementation(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TACTTRASCORERequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Boolean beneficiarioCTACTTRASCOREptpRequiereExamenMedico = request.getBeneficiarioCTACTTRASCOREptpRequiereExamenMedico();
        Long beneficiarioCTACTTRASCOREptpEstadoMedico = request.getBeneficiarioCTACTTRASCOREptpEstadoMedico();
        Date beneficiarioCTACTTRASCOREptpFechaAntiguedadRealOSI = request.getBeneficiarioCTACTTRASCOREptpFechaAntiguedadRealOSI();
        Boolean beneficiarioCTACTTRASCOREptpTienePreexistencias = request.getBeneficiarioCTACTTRASCOREptpTienePreexistencias();
        Long beneficiarioCTACTTRASCOREptpNumUsuario = request.getBeneficiarioCTACTTRASCOREptpNumUsuario();
        EstadoBeneficiario beneficiarioCTACTTRASCOREptEstadoBeneficiarioC = request.getBeneficiarioCTACTTRASCOREptEstadoBeneficiarioCInstance();
        BeneficiarioC beneficiarioCTACTTRASCOREpthisBeneficiarioC = request.getBeneficiarioCTACTTRASCOREpthisBeneficiarioCInstance();

        request.checkArguments();
        BeneficiarioC instance = beneficiarioCTACTTRASCOREpthisBeneficiarioC;

        com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.ModificarTrasCORERequest step1Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.ModificarTrasCORERequest();
        step1Request.setBeneficiarioCmodificarTrasCOREpthisBeneficiarioCInstance(beneficiarioCTACTTRASCOREpthisBeneficiarioC);
        step1Request.setBeneficiarioCmodificarTrasCOREpRequiereExamenMedico(beneficiarioCTACTTRASCOREptpRequiereExamenMedico);
        step1Request.setBeneficiarioCmodificarTrasCOREpEstadoMedico(beneficiarioCTACTTRASCOREptpEstadoMedico);
        step1Request.setBeneficiarioCmodificarTrasCOREpFechaAntiguedadRealOSI(beneficiarioCTACTTRASCOREptpFechaAntiguedadRealOSI);
        step1Request.setBeneficiarioCmodificarTrasCOREpTienePreexistencias(beneficiarioCTACTTRASCOREptpTienePreexistencias);
        step1Request.setBeneficiarioCmodificarTrasCOREpNumUsuario(beneficiarioCTACTTRASCOREptpNumUsuario);
        beneficiarioCSrv.modificarTrasCOREImplementation(step1Request);

        /* Action 2: IF (EstadoBeneficiarioC <> ptEstadoBeneficiarioC) */
        boolean ifCondition2 = !Utilities.isEqual(beneficiarioCTACTTRASCOREpthisBeneficiarioC.getEstadoBeneficiarioC(), beneficiarioCTACTTRASCOREptEstadoBeneficiarioC);
        if (ifCondition2) {
            /* Action 20: IF (ptEstadoBeneficiarioC <> NULL) */
            boolean ifCondition20 = (beneficiarioCTACTTRASCOREptEstadoBeneficiarioC != null && !beneficiarioCTACTTRASCOREptEstadoBeneficiarioC.isNull());
            if (ifCondition20) {
                /* Action 200: IF (EXIST (EstadoBeneficiarioC) = true) */
                boolean ifCondition200 = repository.assocOperator019(beneficiarioCTACTTRASCOREpthisBeneficiarioC).equals(true);
                if (ifCondition200) {
                    com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelEstadoBeneficiarioCRequest step2000Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelEstadoBeneficiarioCRequest();
                    step2000Request.setBeneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioCInstance(beneficiarioCTACTTRASCOREpthisBeneficiarioC);
                    step2000Request.setBeneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiarioInstance(beneficiarioCTACTTRASCOREpthisBeneficiarioC.getEstadoBeneficiarioC());
                    beneficiarioCSrv.delEstadoBeneficiarioCImplementation(step2000Request, true);
                }
                com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsEstadoBeneficiarioCRequest step201Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsEstadoBeneficiarioCRequest();
                step201Request.setBeneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioCInstance(beneficiarioCTACTTRASCOREpthisBeneficiarioC);
                step201Request.setBeneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiarioInstance(beneficiarioCTACTTRASCOREptEstadoBeneficiarioC);
                beneficiarioCSrv.insEstadoBeneficiarioCImplementation(step201Request, true);
            }
        }

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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TNEWDESDEAERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.tNEWDESDEAETxn(request);
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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TNEWDESDEAERequest request) throws ModelException, SystemException {
        request.setBeneficiarioCTNEWDESDEAEptContratoInstance(contratoCSrv.getByOIDWithHV(request.getBeneficiarioCTNEWDESDEAEptContrato()));
        request.setBeneficiarioCTNEWDESDEAEptFamiliaInstance(familiaCSrv.getByOIDWithHV(request.getBeneficiarioCTNEWDESDEAEptFamilia()));
        request.setBeneficiarioCTNEWDESDEAEptUsuarioInstance(usuarioSrv.getByOIDWithHV(request.getBeneficiarioCTNEWDESDEAEptUsuario()));
        request.setBeneficiarioCTNEWDESDEAEptSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getBeneficiarioCTNEWDESDEAEptSolicitud()));
        return beneficiarioCSrv.tNEWDESDEAEImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TNEWDESDEAERequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Usuario beneficiarioCTNEWDESDEAEptUsuario = request.getBeneficiarioCTNEWDESDEAEptUsuarioInstance();
        ContratoC beneficiarioCTNEWDESDEAEptContrato = request.getBeneficiarioCTNEWDESDEAEptContratoInstance();
        FamiliaC beneficiarioCTNEWDESDEAEptFamilia = request.getBeneficiarioCTNEWDESDEAEptFamiliaInstance();
        Solicitud beneficiarioCTNEWDESDEAEptSolicitud = request.getBeneficiarioCTNEWDESDEAEptSolicitudInstance();

        request.checkArguments();
        BeneficiarioC instance;

        com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.CrearRequest step1Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.CrearRequest();
        step1Request.setBeneficiarioCcrearpagrEPSCInstance(beneficiarioCTNEWDESDEAEptUsuario.getEps());
        step1Request.setBeneficiarioCcrearpagrCompanyiaMPCInstance(beneficiarioCTNEWDESDEAEptUsuario.getCompanyia());
        step1Request.setBeneficiarioCcrearpagrParentescoCInstance(beneficiarioCTNEWDESDEAEptUsuario.getParentesco());
        step1Request.setBeneficiarioCcrearpagrEstadoBeneficiarioCInstance(beneficiarioCTNEWDESDEAEptUsuario.getEstadoBeneficiario());
        step1Request.setBeneficiarioCcrearpagrContratoCInstance(beneficiarioCTNEWDESDEAEptContrato);
        step1Request.setBeneficiarioCcrearpagrFamiliasCInstance(beneficiarioCTNEWDESDEAEptFamilia);
        step1Request.setBeneficiarioCcrearpagrPersonaCInstance(null);
        step1Request.setBeneficiarioCcrearpatrCodigoTipoUsuario(STDFunctions.intToStrFun(beneficiarioCTNEWDESDEAEptUsuario.getUsuarioCodigoTipoUsuario()));
        step1Request.setBeneficiarioCcrearpatrIndicadorBBGestacion(beneficiarioCTNEWDESDEAEptUsuario.getUsuarioBebeGestante());
        step1Request.setBeneficiarioCcrearpatrCodUsuarioBancoRep(beneficiarioCTNEWDESDEAEptUsuario.getUsuariocodigoBancoRep());
        step1Request.setBeneficiarioCcrearpatrFechaAntiguedad(beneficiarioCTNEWDESDEAEptUsuario.getUsuarioFechaAntiguedadBeneficiario());
        step1Request.setBeneficiarioCcrearpatrFechaAntiguedadRealOSI(null);
        step1Request.setBeneficiarioCcrearpatrRequiereExamenMedico(null);
        step1Request.setBeneficiarioCcrearpatrEstadoMedico(null);
        step1Request.setBeneficiarioCcrearpatrValorCuotaInscripcion(beneficiarioCTNEWDESDEAEptUsuario.getUsuarioValorCuotaInscripcion());
        step1Request.setBeneficiarioCcrearpatrTienePreexistencias(beneficiarioCTNEWDESDEAEptUsuario.getUsuarioTienePreexistencias());
        step1Request.setBeneficiarioCcrearpatrFechaInicioVigencia(beneficiarioCTNEWDESDEAEptUsuario.getUsuarioFechaInicioVigencia());
        step1Request.setBeneficiarioCcrearpatrFechaFinVigencia(beneficiarioCTNEWDESDEAEptUsuario.getUsuarioFechaFinVigencia());
        step1Request.setBeneficiarioCcrearpatrNumUsuario(beneficiarioCTNEWDESDEAEptUsuario.getUsuarioNumUsuario());
        instance = (BeneficiarioC) beneficiarioCSrv.crearImplementation(step1Request).getInstance();

        /* Action 2: IF (ptSolicitud.ContratantePersona = ptUsuario.UsuarioPersona) */
        boolean ifCondition2 = Utilities.isEqual(beneficiarioCTNEWDESDEAEptSolicitud.getContratantePersona(), beneficiarioCTNEWDESDEAEptUsuario.getUsuarioPersona());
        if (ifCondition2) {
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsBeneficiariosCRequest step20Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsBeneficiariosCRequest();
            step20Request.setBeneficiarioCInsBeneficiariosCpthisBeneficiarioCInstance(instance);
            step20Request.setBeneficiarioCInsBeneficiariosCpevcPersonaCInstance(instance.getFamiliasC().getContratoC().getPersonaCContratante());
            beneficiarioCSrv.insBeneficiariosCImplementation(step20Request, true);
        } else {
            /* Action 21: IF (ptSolicitud.TitularPersona = ptUsuario.UsuarioPersona) */
            boolean ifCondition21 = Utilities.isEqual(beneficiarioCTNEWDESDEAEptSolicitud.getTitularPersona(), beneficiarioCTNEWDESDEAEptUsuario.getUsuarioPersona());
            if (ifCondition21) {
                com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsBeneficiariosCRequest step210Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsBeneficiariosCRequest();
                step210Request.setBeneficiarioCInsBeneficiariosCpthisBeneficiarioCInstance(instance);
                step210Request.setBeneficiarioCInsBeneficiariosCpevcPersonaCInstance(instance.getFamiliasC().getPersonaCTitular());
                beneficiarioCSrv.insBeneficiariosCImplementation(step210Request, true);
            } else {
                com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWBENEFDESDEAERequest step211Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWBENEFDESDEAERequest();
                step211Request.setPersonaCTNEWBENEFDESDEAEptBeneficiarioInstance(instance);
                step211Request.setPersonaCTNEWBENEFDESDEAEptUsuarioInstance(beneficiarioCTNEWDESDEAEptUsuario);
                personaCSrv.tNEWBENEFDESDEAEImplementation(step211Request);
            }
        }

        /* Action 3: IF (EXIST (ptUsuario.AnexoMat) = true) */
        boolean ifCondition3 = repository.assocOperator022(beneficiarioCTNEWDESDEAEptUsuario).equals(true);
        if (ifCondition3) {
            com.keralty.aesolicitudes.viewmodel.anexoc.siu.CrearRequest step30Request = new com.keralty.aesolicitudes.viewmodel.anexoc.siu.CrearRequest();
            step30Request.setAnexoCcrearpagrPeriodicidadCInstance(beneficiarioCTNEWDESDEAEptUsuario.getAnexoMat().getPeriodicidad());
            step30Request.setAnexoCcrearpagrBeneficiarioCInstance(instance);
            step30Request.setAnexoCcrearpagrTipoIdentificacionCInstance(beneficiarioCTNEWDESDEAEptUsuario.getAnexoMat().getInstitucionMaternal().getTipoIdentificacion());
            step30Request.setAnexoCcrearpatrCodigoPlanAnexo(STDFunctions.intToStrFun(beneficiarioCTNEWDESDEAEptUsuario.getAnexoMat().getInstitucionMaternal().getTarifa().getProductoT().getProductosCodAnexoMat()));
            step30Request.setAnexoCcrearpatrCodigoTarifa(beneficiarioCTNEWDESDEAEptUsuario.getAnexoMat().getInstitucionMaternal().getTarifa().getTarifaCodigo());
            step30Request.setAnexoCcrearpatrFechaInicioVigencia(beneficiarioCTNEWDESDEAEptUsuario.getSolicitud().getSolicitudFInicioContrato());
            step30Request.setAnexoCcrearpatrFechaUltimaRegla(beneficiarioCTNEWDESDEAEptUsuario.getAnexoMat().getAnexoMatFechaUltRegla());
            step30Request.setAnexoCcrearpatrNumCuotasPago(beneficiarioCTNEWDESDEAEptUsuario.getAnexoMat().getAnexoMatNumCuotas());
            step30Request.setAnexoCcrearpatrNumIdentificacion(beneficiarioCTNEWDESDEAEptUsuario.getAnexoMat().getInstitucionMaternal().getInstitucionMatNeoNumIdentificacion());
            step30Request.setAnexoCcrearpatrCodSucursal(beneficiarioCTNEWDESDEAEptUsuario.getAnexoMat().getInstitucionMaternal().getInstitucionMatNeoCodigo());
            anexoCSrv.crearImplementation(step30Request);
        }

        /* Action 4: IF (EXIST (ptUsuario.AnexoNeo) = true) */
        boolean ifCondition4 = repository.assocOperator023(beneficiarioCTNEWDESDEAEptUsuario).equals(true);
        if (ifCondition4) {
            com.keralty.aesolicitudes.viewmodel.anexoc.siu.CrearRequest step40Request = new com.keralty.aesolicitudes.viewmodel.anexoc.siu.CrearRequest();
            step40Request.setAnexoCcrearpagrPeriodicidadCInstance(beneficiarioCTNEWDESDEAEptUsuario.getAnexoNeo().getPeriodicidad());
            step40Request.setAnexoCcrearpagrBeneficiarioCInstance(instance);
            step40Request.setAnexoCcrearpagrTipoIdentificacionCInstance(beneficiarioCTNEWDESDEAEptUsuario.getAnexoNeo().getInstitucionNeonatal().getTipoIdentificacion());
            step40Request.setAnexoCcrearpatrCodigoPlanAnexo(STDFunctions.intToStrFun(beneficiarioCTNEWDESDEAEptUsuario.getAnexoNeo().getInstitucionNeonatal().getTarifa().getProductoT().getProductosCodAnexoNeo()));
            step40Request.setAnexoCcrearpatrCodigoTarifa(beneficiarioCTNEWDESDEAEptUsuario.getAnexoNeo().getInstitucionNeonatal().getTarifa().getTarifaCodigo());
            step40Request.setAnexoCcrearpatrFechaInicioVigencia(beneficiarioCTNEWDESDEAEptUsuario.getSolicitud().getSolicitudFInicioContrato());
            step40Request.setAnexoCcrearpatrFechaUltimaRegla(beneficiarioCTNEWDESDEAEptUsuario.getAnexoNeo().getAnexoNeoFechaUltRegla());
            step40Request.setAnexoCcrearpatrNumCuotasPago(beneficiarioCTNEWDESDEAEptUsuario.getAnexoNeo().getAnexoNeoNumCuotas());
            step40Request.setAnexoCcrearpatrNumIdentificacion(beneficiarioCTNEWDESDEAEptUsuario.getAnexoNeo().getInstitucionNeonatal().getInstitucionMatNeoNumIdentificacion());
            step40Request.setAnexoCcrearpatrCodSucursal(beneficiarioCTNEWDESDEAEptUsuario.getAnexoNeo().getInstitucionNeonatal().getInstitucionMatNeoCodigo());
            anexoCSrv.crearImplementation(step40Request);
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TPOSTNOTIFICAR

    /*
     * Entry point for service TPOSTNOTIFICAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tPOSTNOTIFICAR(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TPOSTNOTIFICARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.tPOSTNOTIFICARTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TPOSTNOTIFICAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tPOSTNOTIFICARTxn(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TPOSTNOTIFICARRequest request) throws ModelException, SystemException {
        request.setBeneficiarioCTPOSTNOTIFICARpthisBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getBeneficiarioCTPOSTNOTIFICARpthisBeneficiarioC()));
        request.setBeneficiarioCTPOSTNOTIFICARptEstadoBeneficiarioInstance(estadoBeneficiarioSrv.getByOIDWithHV(request.getBeneficiarioCTPOSTNOTIFICARptEstadoBeneficiario()));
        request.setBeneficiarioCTPOSTNOTIFICARptpagrEPSCInstance(epsSrv.getByOIDWithHV(request.getBeneficiarioCTPOSTNOTIFICARptpagrEPSC()));
        request.setBeneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPCInstance(companyiaSrv.getByOIDWithHV(request.getBeneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPC()));
        request.setBeneficiarioCTPOSTNOTIFICARptpagrParentescoCInstance(parentescoSrv.getByOIDWithHV(request.getBeneficiarioCTPOSTNOTIFICARptpagrParentescoC()));
        return beneficiarioCSrv.tPOSTNOTIFICARImplementation(request);
    }

    /*
     * Implements service TPOSTNOTIFICAR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tPOSTNOTIFICARImplementation(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TPOSTNOTIFICARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Long beneficiarioCTPOSTNOTIFICARptpEstadoMedico = request.getBeneficiarioCTPOSTNOTIFICARptpEstadoMedico();
        Date beneficiarioCTPOSTNOTIFICARptpFechaAntiguedadRealOSI = request.getBeneficiarioCTPOSTNOTIFICARptpFechaAntiguedadRealOSI();
        Boolean beneficiarioCTPOSTNOTIFICARptpTienePreexistencias = request.getBeneficiarioCTPOSTNOTIFICARptpTienePreexistencias();
        Date beneficiarioCTPOSTNOTIFICARptpFechaInicioVigencia = request.getBeneficiarioCTPOSTNOTIFICARptpFechaInicioVigencia();
        Date beneficiarioCTPOSTNOTIFICARptpFechaFinVigencia = request.getBeneficiarioCTPOSTNOTIFICARptpFechaFinVigencia();
        Long beneficiarioCTPOSTNOTIFICARptpNumUsuario = request.getBeneficiarioCTPOSTNOTIFICARptpNumUsuario();
        String beneficiarioCTPOSTNOTIFICARptpCodigoTipoUsuario = request.getBeneficiarioCTPOSTNOTIFICARptpCodigoTipoUsuario();
        Boolean beneficiarioCTPOSTNOTIFICARptpIndicadorBBGestacion = request.getBeneficiarioCTPOSTNOTIFICARptpIndicadorBBGestacion();
        String beneficiarioCTPOSTNOTIFICARptpCodUsuarioBancoRep = request.getBeneficiarioCTPOSTNOTIFICARptpCodUsuarioBancoRep();
        Date beneficiarioCTPOSTNOTIFICARptpFechaAntiguedad = request.getBeneficiarioCTPOSTNOTIFICARptpFechaAntiguedad();
        EstadoBeneficiario beneficiarioCTPOSTNOTIFICARptEstadoBeneficiario = request.getBeneficiarioCTPOSTNOTIFICARptEstadoBeneficiarioInstance();
        Parentesco beneficiarioCTPOSTNOTIFICARptpagrParentescoC = request.getBeneficiarioCTPOSTNOTIFICARptpagrParentescoCInstance();
        Eps beneficiarioCTPOSTNOTIFICARptpagrEPSC = request.getBeneficiarioCTPOSTNOTIFICARptpagrEPSCInstance();
        Companyia beneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPC = request.getBeneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPCInstance();
        BeneficiarioC beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC = request.getBeneficiarioCTPOSTNOTIFICARpthisBeneficiarioCInstance();

        request.checkArguments();
        BeneficiarioC instance = beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC;

        for(PreexistenciaC step1Entity : repository.assocOperator024(beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC)) {
            com.keralty.aesolicitudes.viewmodel.preexistenciac.siu.EliminarRequest step1Request = new com.keralty.aesolicitudes.viewmodel.preexistenciac.siu.EliminarRequest();
            step1Request.setPreexistenciaCeliminarpthisPreexistenciaCInstance(step1Entity);
            preexistenciaCSrv.eliminarImplementation(step1Request);
        }

        for(ConceptoC step2Entity : repository.assocOperator025(beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC)) {
            com.keralty.aesolicitudes.viewmodel.conceptoc.siu.EliminarRequest step2Request = new com.keralty.aesolicitudes.viewmodel.conceptoc.siu.EliminarRequest();
            step2Request.setConceptoCeliminarpthisConceptoCInstance(step2Entity);
            conceptoCSrv.eliminarImplementation(step2Request);
        }

        com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.EvalPostNotiCrearRequest step3Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.EvalPostNotiCrearRequest();
        step3Request.setBeneficiarioCevalPostNotiCrearpthisBeneficiarioCInstance(beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC);
        step3Request.setBeneficiarioCevalPostNotiCrearpEstadoMedico(beneficiarioCTPOSTNOTIFICARptpEstadoMedico);
        step3Request.setBeneficiarioCevalPostNotiCrearpFechaAntiguedadRealOSI(beneficiarioCTPOSTNOTIFICARptpFechaAntiguedadRealOSI);
        step3Request.setBeneficiarioCevalPostNotiCrearpTienePreexistencias(beneficiarioCTPOSTNOTIFICARptpTienePreexistencias);
        step3Request.setBeneficiarioCevalPostNotiCrearpFechaInicioVigencia(beneficiarioCTPOSTNOTIFICARptpFechaInicioVigencia);
        step3Request.setBeneficiarioCevalPostNotiCrearpFechaFinVigencia(beneficiarioCTPOSTNOTIFICARptpFechaFinVigencia);
        step3Request.setBeneficiarioCevalPostNotiCrearpNumUsuario(beneficiarioCTPOSTNOTIFICARptpNumUsuario);
        step3Request.setBeneficiarioCevalPostNotiCrearpCodigoTipoUsuario(beneficiarioCTPOSTNOTIFICARptpCodigoTipoUsuario);
        step3Request.setBeneficiarioCevalPostNotiCrearpIndicadorBBGestacion(beneficiarioCTPOSTNOTIFICARptpIndicadorBBGestacion);
        step3Request.setBeneficiarioCevalPostNotiCrearpCodUsuarioBancoRep(beneficiarioCTPOSTNOTIFICARptpCodUsuarioBancoRep);
        step3Request.setBeneficiarioCevalPostNotiCrearpFechaAntiguedad(beneficiarioCTPOSTNOTIFICARptpFechaAntiguedad);
        beneficiarioCSrv.evalPostNotiCrearImplementation(step3Request);

        /* Action 4: IF (EstadoBeneficiarioC <> ptEstadoBeneficiario) */
        boolean ifCondition4 = !Utilities.isEqual(beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC.getEstadoBeneficiarioC(), beneficiarioCTPOSTNOTIFICARptEstadoBeneficiario);
        if (ifCondition4) {
            /* Action 40: IF (ptEstadoBeneficiario <> NULL) */
            boolean ifCondition40 = (beneficiarioCTPOSTNOTIFICARptEstadoBeneficiario != null && !beneficiarioCTPOSTNOTIFICARptEstadoBeneficiario.isNull());
            if (ifCondition40) {
                /* Action 400: IF (EXIST (EstadoBeneficiarioC) = true) */
                boolean ifCondition400 = repository.assocOperator029(beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC).equals(true);
                if (ifCondition400) {
                    com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelEstadoBeneficiarioCRequest step4000Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelEstadoBeneficiarioCRequest();
                    step4000Request.setBeneficiarioCDelEstadoBeneficiarioCpthisBeneficiarioCInstance(beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC);
                    step4000Request.setBeneficiarioCDelEstadoBeneficiarioCpevcEstadoBeneficiarioInstance(beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC.getEstadoBeneficiarioC());
                    beneficiarioCSrv.delEstadoBeneficiarioCImplementation(step4000Request, true);
                }
                com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsEstadoBeneficiarioCRequest step401Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsEstadoBeneficiarioCRequest();
                step401Request.setBeneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioCInstance(beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC);
                step401Request.setBeneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiarioInstance(beneficiarioCTPOSTNOTIFICARptEstadoBeneficiario);
                beneficiarioCSrv.insEstadoBeneficiarioCImplementation(step401Request, true);
            }
        }

        /* Action 5: IF (ParentescoC <> ptpagrParentescoC) */
        boolean ifCondition5 = !Utilities.isEqual(beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC.getParentescoC(), beneficiarioCTPOSTNOTIFICARptpagrParentescoC);
        if (ifCondition5) {
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.ChgParentescoCRequest step50Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.ChgParentescoCRequest();
            step50Request.setBeneficiarioCchgParentescoCpthisBeneficiarioCInstance(beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC);
            step50Request.setBeneficiarioCchgParentescoCpevcParentescoInstance(beneficiarioCTPOSTNOTIFICARptpagrParentescoC);
            beneficiarioCSrv.chgParentescoCImplementation(step50Request, true);
        }

        /* Action 6: IF (EPSC <> ptpagrEPSC) */
        boolean ifCondition6 = !Utilities.isEqual(beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC.getEPSC(), beneficiarioCTPOSTNOTIFICARptpagrEPSC);
        if (ifCondition6) {
            /* Action 60: IF (ptpagrEPSC <> NULL) */
            boolean ifCondition60 = (beneficiarioCTPOSTNOTIFICARptpagrEPSC != null && !beneficiarioCTPOSTNOTIFICARptpagrEPSC.isNull());
            if (ifCondition60) {
                /* Action 600: IF (EXIST (EPSC) = true) */
                boolean ifCondition600 = repository.assocOperator030(beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC).equals(true);
                if (ifCondition600) {
                    com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelEPSCRequest step6000Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelEPSCRequest();
                    step6000Request.setBeneficiarioCDelEPSCpthisBeneficiarioCInstance(beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC);
                    step6000Request.setBeneficiarioCDelEPSCpevcEpsInstance(beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC.getEPSC());
                    beneficiarioCSrv.delEPSCImplementation(step6000Request, true);
                }
                com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsEPSCRequest step601Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsEPSCRequest();
                step601Request.setBeneficiarioCInsEPSCpthisBeneficiarioCInstance(beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC);
                step601Request.setBeneficiarioCInsEPSCpevcEpsInstance(beneficiarioCTPOSTNOTIFICARptpagrEPSC);
                beneficiarioCSrv.insEPSCImplementation(step601Request, true);
            }
        }

        /* Action 7: IF (CompanyiaMPC <> ptpagrCompanyiaMPC) */
        boolean ifCondition7 = !Utilities.isEqual(beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC.getCompanyiaMPC(), beneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPC);
        if (ifCondition7) {
            /* Action 70: IF (ptpagrCompanyiaMPC <> NULL) */
            boolean ifCondition70 = (beneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPC != null && !beneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPC.isNull());
            if (ifCondition70) {
                /* Action 700: IF (EXIST (CompanyiaMPC) = true) */
                boolean ifCondition700 = repository.assocOperator031(beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC).equals(true);
                if (ifCondition700) {
                    com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelCompanyiaMPCRequest step7000Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelCompanyiaMPCRequest();
                    step7000Request.setBeneficiarioCDelCompanyiaMPCpthisBeneficiarioCInstance(beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC);
                    step7000Request.setBeneficiarioCDelCompanyiaMPCpevcCompanyiaInstance(beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC.getCompanyiaMPC());
                    beneficiarioCSrv.delCompanyiaMPCImplementation(step7000Request, true);
                }
                com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsCompanyiaMPCRequest step701Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsCompanyiaMPCRequest();
                step701Request.setBeneficiarioCInsCompanyiaMPCpthisBeneficiarioCInstance(beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC);
                step701Request.setBeneficiarioCInsCompanyiaMPCpevcCompanyiaInstance(beneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPC);
                beneficiarioCSrv.insCompanyiaMPCImplementation(step701Request, true);
            }
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TNEWDESDECORE

    /*
     * Entry point for service TNEWDESDECORE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tNEWDESDECORE(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TNEWDESDECORERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.tNEWDESDECORETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TNEWDESDECORE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tNEWDESDECORETxn(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TNEWDESDECORERequest request) throws ModelException {
        request.setBeneficiarioCTNEWDESDECOREptpagrEPSCInstance(epsSrv.getByOIDWithHV(request.getBeneficiarioCTNEWDESDECOREptpagrEPSC()));
        request.setBeneficiarioCTNEWDESDECOREptpagrCompanyiaMPCInstance(companyiaSrv.getByOIDWithHV(request.getBeneficiarioCTNEWDESDECOREptpagrCompanyiaMPC()));
        request.setBeneficiarioCTNEWDESDECOREptpagrParentescoCInstance(parentescoSrv.getByOIDWithHV(request.getBeneficiarioCTNEWDESDECOREptpagrParentescoC()));
        request.setBeneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioCInstance(estadoBeneficiarioSrv.getByOIDWithHV(request.getBeneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioC()));
        request.setBeneficiarioCTNEWDESDECOREptpagrContratoCInstance(contratoCSrv.getByOIDWithHV(request.getBeneficiarioCTNEWDESDECOREptpagrContratoC()));
        request.setBeneficiarioCTNEWDESDECOREptpagrFamiliasCInstance(familiaCSrv.getByOIDWithHV(request.getBeneficiarioCTNEWDESDECOREptpagrFamiliasC()));
        request.setBeneficiarioCTNEWDESDECOREptTipoIdInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getBeneficiarioCTNEWDESDECOREptTipoId()));
        return beneficiarioCSrv.tNEWDESDECOREImplementation(request);
    }

    /*
     * Implements service TNEWDESDECORE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tNEWDESDECOREImplementation(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TNEWDESDECORERequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Eps beneficiarioCTNEWDESDECOREptpagrEPSC = request.getBeneficiarioCTNEWDESDECOREptpagrEPSCInstance();
        Companyia beneficiarioCTNEWDESDECOREptpagrCompanyiaMPC = request.getBeneficiarioCTNEWDESDECOREptpagrCompanyiaMPCInstance();
        Parentesco beneficiarioCTNEWDESDECOREptpagrParentescoC = request.getBeneficiarioCTNEWDESDECOREptpagrParentescoCInstance();
        EstadoBeneficiario beneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioC = request.getBeneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioCInstance();
        ContratoC beneficiarioCTNEWDESDECOREptpagrContratoC = request.getBeneficiarioCTNEWDESDECOREptpagrContratoCInstance();
        FamiliaC beneficiarioCTNEWDESDECOREptpagrFamiliasC = request.getBeneficiarioCTNEWDESDECOREptpagrFamiliasCInstance();
        String beneficiarioCTNEWDESDECOREptpatrCodigoTipoUsuario = request.getBeneficiarioCTNEWDESDECOREptpatrCodigoTipoUsuario();
        Boolean beneficiarioCTNEWDESDECOREptpatrIndicadorBBGestacion = request.getBeneficiarioCTNEWDESDECOREptpatrIndicadorBBGestacion();
        String beneficiarioCTNEWDESDECOREptpatrCodUsuarioBancoRep = request.getBeneficiarioCTNEWDESDECOREptpatrCodUsuarioBancoRep();
        Date beneficiarioCTNEWDESDECOREptpatrFechaAntiguedad = request.getBeneficiarioCTNEWDESDECOREptpatrFechaAntiguedad();
        Date beneficiarioCTNEWDESDECOREptpatrFechaAntiguedadRealOSI = request.getBeneficiarioCTNEWDESDECOREptpatrFechaAntiguedadRealOSI();
        Long beneficiarioCTNEWDESDECOREptpatrEstadoMedico = request.getBeneficiarioCTNEWDESDECOREptpatrEstadoMedico();
        Boolean beneficiarioCTNEWDESDECOREptpatrTienePreexistencias = request.getBeneficiarioCTNEWDESDECOREptpatrTienePreexistencias();
        Date beneficiarioCTNEWDESDECOREptpatrFechaInicioVigencia = request.getBeneficiarioCTNEWDESDECOREptpatrFechaInicioVigencia();
        Date beneficiarioCTNEWDESDECOREptpatrFechaFinVigencia = request.getBeneficiarioCTNEWDESDECOREptpatrFechaFinVigencia();
        Long beneficiarioCTNEWDESDECOREptpatrNumUsuario = request.getBeneficiarioCTNEWDESDECOREptpatrNumUsuario();
        TipoIdentificacion beneficiarioCTNEWDESDECOREptTipoId = request.getBeneficiarioCTNEWDESDECOREptTipoIdInstance();
        String beneficiarioCTNEWDESDECOREptNumIdentificacion = request.getBeneficiarioCTNEWDESDECOREptNumIdentificacion();
        String beneficiarioCTNEWDESDECOREptNombreCompleto = request.getBeneficiarioCTNEWDESDECOREptNombreCompleto();
        Long beneficiarioCTNEWDESDECOREptCodigoCORE = request.getBeneficiarioCTNEWDESDECOREptCodigoCORE();

        request.checkArguments();
        BeneficiarioC instance;

        com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.CrearRequest step1Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.CrearRequest();
        step1Request.setBeneficiarioCcrearpagrEPSCInstance(beneficiarioCTNEWDESDECOREptpagrEPSC);
        step1Request.setBeneficiarioCcrearpagrCompanyiaMPCInstance(beneficiarioCTNEWDESDECOREptpagrCompanyiaMPC);
        step1Request.setBeneficiarioCcrearpagrParentescoCInstance(beneficiarioCTNEWDESDECOREptpagrParentescoC);
        step1Request.setBeneficiarioCcrearpagrEstadoBeneficiarioCInstance(beneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioC);
        step1Request.setBeneficiarioCcrearpagrContratoCInstance(beneficiarioCTNEWDESDECOREptpagrContratoC);
        step1Request.setBeneficiarioCcrearpagrFamiliasCInstance(beneficiarioCTNEWDESDECOREptpagrFamiliasC);
        step1Request.setBeneficiarioCcrearpagrPersonaCInstance(null);
        step1Request.setBeneficiarioCcrearpatrCodigoTipoUsuario(beneficiarioCTNEWDESDECOREptpatrCodigoTipoUsuario);
        step1Request.setBeneficiarioCcrearpatrIndicadorBBGestacion(beneficiarioCTNEWDESDECOREptpatrIndicadorBBGestacion);
        step1Request.setBeneficiarioCcrearpatrCodUsuarioBancoRep(beneficiarioCTNEWDESDECOREptpatrCodUsuarioBancoRep);
        step1Request.setBeneficiarioCcrearpatrFechaAntiguedad(beneficiarioCTNEWDESDECOREptpatrFechaAntiguedad);
        step1Request.setBeneficiarioCcrearpatrFechaAntiguedadRealOSI(beneficiarioCTNEWDESDECOREptpatrFechaAntiguedadRealOSI);
        step1Request.setBeneficiarioCcrearpatrRequiereExamenMedico(Boolean.FALSE);
        step1Request.setBeneficiarioCcrearpatrEstadoMedico(beneficiarioCTNEWDESDECOREptpatrEstadoMedico);
        step1Request.setBeneficiarioCcrearpatrValorCuotaInscripcion(Utilities.convertToDouble(Long.valueOf(0)));
        step1Request.setBeneficiarioCcrearpatrTienePreexistencias(beneficiarioCTNEWDESDECOREptpatrTienePreexistencias);
        step1Request.setBeneficiarioCcrearpatrFechaInicioVigencia(beneficiarioCTNEWDESDECOREptpatrFechaInicioVigencia);
        step1Request.setBeneficiarioCcrearpatrFechaFinVigencia(beneficiarioCTNEWDESDECOREptpatrFechaFinVigencia);
        step1Request.setBeneficiarioCcrearpatrNumUsuario(beneficiarioCTNEWDESDECOREptpatrNumUsuario);
        instance = (BeneficiarioC) beneficiarioCSrv.crearImplementation(step1Request).getInstance();

        /* Action 2: IF (ContratoC.PersonaCContratante.TipoIdentificacionC = ptTipoId AND ContratoC.PersonaCContratante.NumIdentificacion = ptNumIdentificacion) */
        boolean ifCondition2 = Utilities.isEqual(instance.getContratoC().getPersonaCContratante().getTipoIdentificacionC(), beneficiarioCTNEWDESDECOREptTipoId) && (instance.getContratoC().getPersonaCContratante().getPersonaCNumIdentificacion()).equals(beneficiarioCTNEWDESDECOREptNumIdentificacion);
        if (ifCondition2) {
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsBeneficiariosCRequest step20Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsBeneficiariosCRequest();
            step20Request.setBeneficiarioCInsBeneficiariosCpthisBeneficiarioCInstance(instance);
            step20Request.setBeneficiarioCInsBeneficiariosCpevcPersonaCInstance(instance.getContratoC().getPersonaCContratante());
            beneficiarioCSrv.insBeneficiariosCImplementation(step20Request, true);
        } else {
            /* Action 21: IF (FamiliasC.PersonaCTitular.TipoIdentificacionC = ptTipoId AND FamiliasC.PersonaCTitular.NumIdentificacion = ptNumIdentificacion) */
            boolean ifCondition21 = Utilities.isEqual(instance.getFamiliasC().getPersonaCTitular().getTipoIdentificacionC(), beneficiarioCTNEWDESDECOREptTipoId) && (instance.getFamiliasC().getPersonaCTitular().getPersonaCNumIdentificacion()).equals(beneficiarioCTNEWDESDECOREptNumIdentificacion);
            if (ifCondition21) {
                com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsBeneficiariosCRequest step210Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsBeneficiariosCRequest();
                step210Request.setBeneficiarioCInsBeneficiariosCpthisBeneficiarioCInstance(instance);
                step210Request.setBeneficiarioCInsBeneficiariosCpevcPersonaCInstance(instance.getFamiliasC().getPersonaCTitular());
                beneficiarioCSrv.insBeneficiariosCImplementation(step210Request, true);
            } else {
                com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWRequest step211Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWRequest();
                step211Request.setPersonaCTNEWptpagrTipoInstitucionCInstance(null);
                step211Request.setPersonaCTNEWptpagrTipoEntidadCInstance(null);
                step211Request.setPersonaCTNEWptpagrEstadoCivilCInstance(null);
                step211Request.setPersonaCTNEWptpagrEstadoPersonaCInstance(null);
                step211Request.setPersonaCTNEWptpagrTipoIdentificacionCInstance(beneficiarioCTNEWDESDECOREptTipoId);
                step211Request.setPersonaCTNEWptpagrMunicipioCNacInstance(null);
                step211Request.setPersonaCTNEWptpagrDepartamentoCNacInstance(null);
                step211Request.setPersonaCTNEWptpagrContratosCInstance(null);
                step211Request.setPersonaCTNEWptpagrFamiliasCInstance(null);
                step211Request.setPersonaCTNEWptpagrBeneficiariosCInstance(instance);
                step211Request.setPersonaCTNEWptpatrNumIdentificacion(beneficiarioCTNEWDESDECOREptNumIdentificacion);
                step211Request.setPersonaCTNEWptpatrMail(null);
                step211Request.setPersonaCTNEWptpatrPrimerNombre(null);
                step211Request.setPersonaCTNEWptpatrSegundoNombre(null);
                step211Request.setPersonaCTNEWptpatrPrimerApellido(null);
                step211Request.setPersonaCTNEWptpatrSegundoApellido(null);
                step211Request.setPersonaCTNEWptpatrFechaNacimiento(null);
                step211Request.setPersonaCTNEWptpatrGenero(null);
                step211Request.setPersonaCTNEWptpatrIndicadorExtranjero(null);
                step211Request.setPersonaCTNEWptpatrRazonSocial(null);
                step211Request.setPersonaCTNEWptpatrTieneEPSSanitas(Boolean.FALSE);
                step211Request.setPersonaCTNEWptpatrRechazadoAfiliacion(null);
                step211Request.setPersonaCTNEWptpatrNombreCompleto(beneficiarioCTNEWDESDECOREptNombreCompleto);
                step211Request.setPersonaCTNEWptpatrCodigo(beneficiarioCTNEWDESDECOREptCodigoCORE);
                personaCSrv.tNEWImplementation(step211Request);
            }
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TASGESTADOSINOTIENE

    /*
     * Entry point for service TASGESTADOSINOTIENE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tASGESTADOSINOTIENE(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TASGESTADOSINOTIENERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = beneficiarioCSrv.tASGESTADOSINOTIENETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TASGESTADOSINOTIENE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tASGESTADOSINOTIENETxn(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TASGESTADOSINOTIENERequest request) throws ModelException, SystemException {
        request.setBeneficiarioCTASGESTADOSINOTIENEpthisBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getBeneficiarioCTASGESTADOSINOTIENEpthisBeneficiarioC()));
        request.setBeneficiarioCTASGESTADOSINOTIENEptEstadoInstance(estadoBeneficiarioSrv.getByOIDWithHV(request.getBeneficiarioCTASGESTADOSINOTIENEptEstado()));
        return beneficiarioCSrv.tASGESTADOSINOTIENEImplementation(request);
    }

    /*
     * Implements service TASGESTADOSINOTIENE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tASGESTADOSINOTIENEImplementation(
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.TASGESTADOSINOTIENERequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        EstadoBeneficiario beneficiarioCTASGESTADOSINOTIENEptEstado = request.getBeneficiarioCTASGESTADOSINOTIENEptEstadoInstance();
        BeneficiarioC beneficiarioCTASGESTADOSINOTIENEpthisBeneficiarioC = request.getBeneficiarioCTASGESTADOSINOTIENEpthisBeneficiarioCInstance();

        request.checkArguments();
        BeneficiarioC instance = beneficiarioCTASGESTADOSINOTIENEpthisBeneficiarioC;

        /* Action 1: IF (ptEstado <> NULL AND EXIST (EstadoBeneficiarioC) = false) */
        boolean ifCondition1 = (beneficiarioCTASGESTADOSINOTIENEptEstado != null && !beneficiarioCTASGESTADOSINOTIENEptEstado.isNull()) && repository.assocOperator033(beneficiarioCTASGESTADOSINOTIENEpthisBeneficiarioC).equals(false);
        if (ifCondition1) {
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsEstadoBeneficiarioCRequest step10Request = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsEstadoBeneficiarioCRequest();
            step10Request.setBeneficiarioCInsEstadoBeneficiarioCpthisBeneficiarioCInstance(beneficiarioCTASGESTADOSINOTIENEpthisBeneficiarioC);
            step10Request.setBeneficiarioCInsEstadoBeneficiarioCpevcEstadoBeneficiarioInstance(beneficiarioCTASGESTADOSINOTIENEptEstado);
            beneficiarioCSrv.insEstadoBeneficiarioCImplementation(step10Request, true);
        }

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
        select.getOrderByPart().addItem(Constants.normalizePath(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ATTR_FIELD_CONTRATOCID, false), true);
        select.getOrderByPart().addItem(Constants.normalizePath(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ATTR_FIELD_BENEFICIARIOCID, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildBeneficiarioCRelatedInstance(relatedInstanceJsonOid);
        }
        if (BeneficiarioCConstants.ROLE_NAME_PERSONAC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildBeneficiarioCRelatedInstance4PersonaC(relatedInstanceJsonOid, remainingPath);
        }
        if (BeneficiarioCConstants.ROLE_NAME_ANEXOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildBeneficiarioCRelatedInstance4AnexoC(relatedInstanceJsonOid, remainingPath);
        }
        if (BeneficiarioCConstants.ROLE_NAME_CONCEPTOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildBeneficiarioCRelatedInstance4ConceptoC(relatedInstanceJsonOid, remainingPath);
        }
        if (BeneficiarioCConstants.ROLE_NAME_CONTRATOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildBeneficiarioCRelatedInstance4ContratoC(relatedInstanceJsonOid, remainingPath);
        }
        if (BeneficiarioCConstants.ROLE_NAME_FAMILIASC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildBeneficiarioCRelatedInstance4FamiliaC(relatedInstanceJsonOid, remainingPath);
        }
        if (BeneficiarioCConstants.ROLE_NAME_EPSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildBeneficiarioCRelatedInstance4Eps(relatedInstanceJsonOid, remainingPath);
        }
        if (BeneficiarioCConstants.ROLE_NAME_COMPANYIAMPC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildBeneficiarioCRelatedInstance4Companyia(relatedInstanceJsonOid, remainingPath);
        }
        if (BeneficiarioCConstants.ROLE_NAME_PARENTESCOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildBeneficiarioCRelatedInstance4Parentesco(relatedInstanceJsonOid, remainingPath);
        }
        if (BeneficiarioCConstants.ROLE_NAME_ESTADOBENEFICIARIOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildBeneficiarioCRelatedInstance4EstadoBeneficiario(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildBeneficiarioCRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new BeneficiarioC(mapper.readValue(relatedInstanceJsonOid, BeneficiarioCOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildBeneficiarioCRelatedInstance4PersonaC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new PersonaC(mapper.readValue(relatedInstanceJsonOid, PersonaCOid.class)): PersonaC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildBeneficiarioCRelatedInstance4AnexoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new AnexoC(mapper.readValue(relatedInstanceJsonOid, AnexoCOid.class)): AnexoC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildBeneficiarioCRelatedInstance4ConceptoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ConceptoC(mapper.readValue(relatedInstanceJsonOid, ConceptoCOid.class)): ConceptoC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildBeneficiarioCRelatedInstance4ContratoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ContratoC(mapper.readValue(relatedInstanceJsonOid, ContratoCOid.class)): ContratoC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildBeneficiarioCRelatedInstance4FamiliaC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new FamiliaC(mapper.readValue(relatedInstanceJsonOid, FamiliaCOid.class)): FamiliaC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildBeneficiarioCRelatedInstance4Eps(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Eps(mapper.readValue(relatedInstanceJsonOid, EpsOid.class)): Eps.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildBeneficiarioCRelatedInstance4Companyia(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Companyia(mapper.readValue(relatedInstanceJsonOid, CompanyiaOid.class)): Companyia.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildBeneficiarioCRelatedInstance4Parentesco(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Parentesco(mapper.readValue(relatedInstanceJsonOid, ParentescoOid.class)): Parentesco.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildBeneficiarioCRelatedInstance4EstadoBeneficiario(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new EstadoBeneficiario(mapper.readValue(relatedInstanceJsonOid, EstadoBeneficiarioOid.class)): EstadoBeneficiario.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            BeneficiarioCOid oid = new BeneficiarioCOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(BeneficiarioCConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ATTR_FIELD_CONTRATOCID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getContratoCContratoCID(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(BeneficiarioCConstants.ATTR_FIELD_BENEFICIARIOCID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(oid.getBeneficiarioCID(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison2);
        } catch (Exception e) {
            LoggerFactory.getLogger(BeneficiarioCService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
