package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.MinCardinalityException;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.global.STDFunctions;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.CuestionarioP;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.Direccion;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.EstadoCivil;
import com.keralty.aesolicitudes.persistence.EstadoPersona;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.MarcaMedicaC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.CuestionarioPOid;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoCivilOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoPersonaOid;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;
import com.keralty.aesolicitudes.persistence.oid.MarcaMedicaCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.PreexistenciaCOid;
import com.keralty.aesolicitudes.persistence.oid.PregCuesMedCOid;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosCOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.oid.TipoEntidadCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoIdentificacionOid;
import com.keralty.aesolicitudes.persistence.oid.TipoInstitucionCOid;
import com.keralty.aesolicitudes.persistence.oid.UsuarioOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Preexistencia;
import com.keralty.aesolicitudes.persistence.PreexistenciaC;
import com.keralty.aesolicitudes.persistence.PregCuesMedC;
import com.keralty.aesolicitudes.persistence.PreguntaP;
import com.keralty.aesolicitudes.persistence.ProteccionDatosC;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoEntidadC;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.persistence.TipoInstitucionC;
import com.keralty.aesolicitudes.persistence.Usuario;
import com.keralty.aesolicitudes.repository.PersonaCJpaRepository;
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
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class PersonaCService extends AbstractService {

    PersonaCJpaRepository repository;

    PersonaCService personaCSrv;

    TipoInstitucionCService tipoInstitucionCSrv;

    TipoEntidadCService tipoEntidadCSrv;

    EstadoCivilService estadoCivilSrv;

    EstadoPersonaService estadoPersonaSrv;

    TipoIdentificacionService tipoIdentificacionSrv;

    MunicipioService municipioSrv;

    DepartamentoService departamentoSrv;

    ContratoCService contratoCSrv;

    FamiliaCService familiaCSrv;

    BeneficiarioCService beneficiarioCSrv;

    CuestionarioPService cuestionarioPSrv;

    PregCuesMedCService pregCuesMedCSrv;

    SeccionPService seccionPSrv;

    PreguntaPService preguntaPSrv;

    DireccionCService direccionCSrv;

    DirSucursalCService dirSucursalCSrv;

    ProteccionDatosCService proteccionDatosCSrv;

    MarcaMedicaCService marcaMedicaCSrv;

    PreexistenciaCService preexistenciaCSrv;

    SolicitudService solicitudSrv;

    PersonaService personaSrv;

    DireccionService direccionSrv;

    TipoDireccionService tipoDireccionSrv;

    PaisService paisSrv;

    ProteccionDatosService proteccionDatosSrv;

    ProductosService productosSrv;

    AesolicitudesService aesolicitudesSrv;

    UsuarioService usuarioSrv;

    PreexistenciaService preexistenciaSrv;

    @Inject
    public PersonaCService(
            PersonaCService personaCSrv,
            TipoInstitucionCService tipoInstitucionCSrv,
            TipoEntidadCService tipoEntidadCSrv,
            EstadoCivilService estadoCivilSrv,
            EstadoPersonaService estadoPersonaSrv,
            TipoIdentificacionService tipoIdentificacionSrv,
            MunicipioService municipioSrv,
            DepartamentoService departamentoSrv,
            ContratoCService contratoCSrv,
            FamiliaCService familiaCSrv,
            BeneficiarioCService beneficiarioCSrv,
            CuestionarioPService cuestionarioPSrv,
            PregCuesMedCService pregCuesMedCSrv,
            SeccionPService seccionPSrv,
            PreguntaPService preguntaPSrv,
            DireccionCService direccionCSrv,
            DirSucursalCService dirSucursalCSrv,
            ProteccionDatosCService proteccionDatosCSrv,
            MarcaMedicaCService marcaMedicaCSrv,
            PreexistenciaCService preexistenciaCSrv,
            SolicitudService solicitudSrv,
            PersonaService personaSrv,
            DireccionService direccionSrv,
            TipoDireccionService tipoDireccionSrv,
            PaisService paisSrv,
            ProteccionDatosService proteccionDatosSrv,
            ProductosService productosSrv,
            AesolicitudesService aesolicitudesSrv,
            UsuarioService usuarioSrv,
            PreexistenciaService preexistenciaSrv,
            PersonaCJpaRepository repository) {
        this.personaCSrv = personaCSrv;
        this.tipoInstitucionCSrv = tipoInstitucionCSrv;
        this.tipoEntidadCSrv = tipoEntidadCSrv;
        this.estadoCivilSrv = estadoCivilSrv;
        this.estadoPersonaSrv = estadoPersonaSrv;
        this.tipoIdentificacionSrv = tipoIdentificacionSrv;
        this.municipioSrv = municipioSrv;
        this.departamentoSrv = departamentoSrv;
        this.contratoCSrv = contratoCSrv;
        this.familiaCSrv = familiaCSrv;
        this.beneficiarioCSrv = beneficiarioCSrv;
        this.cuestionarioPSrv = cuestionarioPSrv;
        this.pregCuesMedCSrv = pregCuesMedCSrv;
        this.seccionPSrv = seccionPSrv;
        this.preguntaPSrv = preguntaPSrv;
        this.direccionCSrv = direccionCSrv;
        this.dirSucursalCSrv = dirSucursalCSrv;
        this.proteccionDatosCSrv = proteccionDatosCSrv;
        this.marcaMedicaCSrv = marcaMedicaCSrv;
        this.preexistenciaCSrv = preexistenciaCSrv;
        this.solicitudSrv = solicitudSrv;
        this.personaSrv = personaSrv;
        this.direccionSrv = direccionSrv;
        this.tipoDireccionSrv = tipoDireccionSrv;
        this.paisSrv = paisSrv;
        this.proteccionDatosSrv = proteccionDatosSrv;
        this.productosSrv = productosSrv;
        this.aesolicitudesSrv = aesolicitudesSrv;
        this.usuarioSrv = usuarioSrv;
        this.preexistenciaSrv = preexistenciaSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, PersonaCConstants.CLASS_NAME);
    }

    private List<PersonaC> solvePersonaCTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, PersonaCConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solvePersonaCTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, PersonaCConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class PersonaC
     *
     * @return Population of class PersonaC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PersonaC> get() {
        List<PersonaC> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class PersonaC that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class PersonaC matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PersonaC> get(QueryRequest queryRequest) {
        return solvePersonaCTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solvePersonaCTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solvePersonaCTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solvePersonaCTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of PersonaC by ID
     *
     * @param personaCID Identification field personaCID
     *
     * @return Instance of PersonaC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public PersonaC getById(Long personaCID) {
        return getByOID(new PersonaCOid(personaCID));
    }
    
    /*
     * Returns an instance of PersonaC by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of PersonaC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public PersonaC getByOID(PersonaCOid oid) {
        Optional<PersonaC> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of PersonaC by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of PersonaC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public PersonaC getByOIDWithHV(PersonaCOid oid) {
        Optional<PersonaC> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<PersonaC> getInstanceByOid(PersonaCOid oid) {
        return oid != null && oid.getPersonaCID() != null
               ? repository.findById(oid.getPersonaCID())
               : Optional.empty();
    }

    /*
     * Returns an instance of PersonaC by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of PersonaC
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public PersonaC getByJsonOid(String jsonOid) {
        PersonaCOid oid = new PersonaCOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of PersonaC related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of PersonaC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PersonaC> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solvePersonaCTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of PersonaC related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of PersonaC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PersonaC> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of PersonaC
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of PersonaC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getPersonaCDynamic(PersonaCOid oid, String displaySetItems) {
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
    public String getSuppInfo(PersonaCOid oid, String dsName) {
        PersonaC instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(PersonaC instance, String dsName) {
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.crearTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.CrearRequest request) throws ModelException {
        request.setPersonaCcrearpagrTipoInstitucionCInstance(tipoInstitucionCSrv.getByOIDWithHV(request.getPersonaCcrearpagrTipoInstitucionC()));
        request.setPersonaCcrearpagrTipoEntidadCInstance(tipoEntidadCSrv.getByOIDWithHV(request.getPersonaCcrearpagrTipoEntidadC()));
        request.setPersonaCcrearpagrEstadoCivilCInstance(estadoCivilSrv.getByOIDWithHV(request.getPersonaCcrearpagrEstadoCivilC()));
        request.setPersonaCcrearpagrEstadoPersonaCInstance(estadoPersonaSrv.getByOIDWithHV(request.getPersonaCcrearpagrEstadoPersonaC()));
        request.setPersonaCcrearpagrTipoIdentificacionCInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getPersonaCcrearpagrTipoIdentificacionC()));
        request.setPersonaCcrearpagrMunicipioCNacInstance(municipioSrv.getByOIDWithHV(request.getPersonaCcrearpagrMunicipioCNac()));
        request.setPersonaCcrearpagrDepartamentoCNacInstance(departamentoSrv.getByOIDWithHV(request.getPersonaCcrearpagrDepartamentoCNac()));
        request.setPersonaCcrearpagrContratosCInstance(contratoCSrv.getByOIDWithHV(request.getPersonaCcrearpagrContratosC()));
        request.setPersonaCcrearpagrFamiliasCInstance(familiaCSrv.getByOIDWithHV(request.getPersonaCcrearpagrFamiliasC()));
        request.setPersonaCcrearpagrBeneficiariosCInstance(beneficiarioCSrv.getByOIDWithHV(request.getPersonaCcrearpagrBeneficiariosC()));
        return personaCSrv.crearImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoInstitucionC personaCcrearpagrTipoInstitucionC = request.getPersonaCcrearpagrTipoInstitucionCInstance();
        TipoEntidadC personaCcrearpagrTipoEntidadC = request.getPersonaCcrearpagrTipoEntidadCInstance();
        EstadoCivil personaCcrearpagrEstadoCivilC = request.getPersonaCcrearpagrEstadoCivilCInstance();
        EstadoPersona personaCcrearpagrEstadoPersonaC = request.getPersonaCcrearpagrEstadoPersonaCInstance();
        TipoIdentificacion personaCcrearpagrTipoIdentificacionC = request.getPersonaCcrearpagrTipoIdentificacionCInstance();
        Municipio personaCcrearpagrMunicipioCNac = request.getPersonaCcrearpagrMunicipioCNacInstance();
        Departamento personaCcrearpagrDepartamentoCNac = request.getPersonaCcrearpagrDepartamentoCNacInstance();
        ContratoC personaCcrearpagrContratosC = request.getPersonaCcrearpagrContratosCInstance();
        FamiliaC personaCcrearpagrFamiliasC = request.getPersonaCcrearpagrFamiliasCInstance();
        BeneficiarioC personaCcrearpagrBeneficiariosC = request.getPersonaCcrearpagrBeneficiariosCInstance();
        String personaCcrearpatrNumIdentificacion = request.getPersonaCcrearpatrNumIdentificacion();
        String personaCcrearpatrMail = request.getPersonaCcrearpatrMail();
        String personaCcrearpatrPrimerNombre = request.getPersonaCcrearpatrPrimerNombre();
        String personaCcrearpatrSegundoNombre = request.getPersonaCcrearpatrSegundoNombre();
        String personaCcrearpatrPrimerApellido = request.getPersonaCcrearpatrPrimerApellido();
        String personaCcrearpatrSegundoApellido = request.getPersonaCcrearpatrSegundoApellido();
        Date personaCcrearpatrFechaNacimiento = request.getPersonaCcrearpatrFechaNacimiento();
        String personaCcrearpatrGenero = request.getPersonaCcrearpatrGenero();
        Boolean personaCcrearpatrIndicadorExtranjero = request.getPersonaCcrearpatrIndicadorExtranjero();
        String personaCcrearpatrRazonSocial = request.getPersonaCcrearpatrRazonSocial();
        Boolean personaCcrearpatrTieneEPSSanitas = request.getPersonaCcrearpatrTieneEPSSanitas();
        String personaCcrearpatrRechazadoAfiliacion = request.getPersonaCcrearpatrRechazadoAfiliacion();
        String personaCcrearpatrNombreCompleto = request.getPersonaCcrearpatrNombreCompleto();
        Long personaCcrearpatrCodigo = request.getPersonaCcrearpatrCodigo();
        Timestamp personaCcrearpatrUltimaActualizacion = request.getPersonaCcrearpatrUltimaActualizacion();

        request.checkArguments();
        PersonaC instance = new PersonaC();
        if (personaCcrearpagrTipoInstitucionC != null && !personaCcrearpagrTipoInstitucionC.isNull()) {
            instance.add2TipoInstitucionC(personaCcrearpagrTipoInstitucionC);
        }

        if (personaCcrearpagrTipoEntidadC != null && !personaCcrearpagrTipoEntidadC.isNull()) {
            instance.add2TipoEntidadC(personaCcrearpagrTipoEntidadC);
        }

        if (personaCcrearpagrEstadoCivilC != null && !personaCcrearpagrEstadoCivilC.isNull()) {
            instance.add2EstadoCivilC(personaCcrearpagrEstadoCivilC);
        }

        if (personaCcrearpagrEstadoPersonaC != null && !personaCcrearpagrEstadoPersonaC.isNull()) {
            instance.add2EstadoPersonaC(personaCcrearpagrEstadoPersonaC);
        }

        instance.add2TipoIdentificacionC(personaCcrearpagrTipoIdentificacionC);

        if (personaCcrearpagrMunicipioCNac != null && !personaCcrearpagrMunicipioCNac.isNull()) {
            instance.add2MunicipioCNac(personaCcrearpagrMunicipioCNac);
        }

        if (personaCcrearpagrDepartamentoCNac != null && !personaCcrearpagrDepartamentoCNac.isNull()) {
            instance.add2DepartamentoCNac(personaCcrearpagrDepartamentoCNac);
        }

        if (personaCcrearpagrContratosC != null && !personaCcrearpagrContratosC.isNull()) {
            personaCcrearpagrContratosC.add2PersonaCContratante(instance);
            instance.add2ContratosC(personaCcrearpagrContratosC);
        }

        if (personaCcrearpagrFamiliasC != null && !personaCcrearpagrFamiliasC.isNull()) {
            personaCcrearpagrFamiliasC.add2PersonaCTitular(instance);
            instance.add2FamiliasC(personaCcrearpagrFamiliasC);
        }

        if (personaCcrearpagrBeneficiariosC != null && !personaCcrearpagrBeneficiariosC.isNull()) {
            personaCcrearpagrBeneficiariosC.add2PersonaC(instance);
            instance.add2BeneficiariosC(personaCcrearpagrBeneficiariosC);
        }

        instance.setPersonaCID(Long.valueOf(0));
        instance.setPersonaCNumIdentificacion(personaCcrearpatrNumIdentificacion);
        instance.setPersonaCMail(personaCcrearpatrMail);
        instance.setPersonaCPrimerNombre(personaCcrearpatrPrimerNombre);
        instance.setPersonaCSegundoNombre(personaCcrearpatrSegundoNombre);
        instance.setPersonaCPrimerApellido(personaCcrearpatrPrimerApellido);
        instance.setPersonaCSegundoApellido(personaCcrearpatrSegundoApellido);
        instance.setPersonaCFechaNacimiento(personaCcrearpatrFechaNacimiento);
        instance.setPersonaCGenero(personaCcrearpatrGenero);
        instance.setPersonaCIndicadorExtranjero(personaCcrearpatrIndicadorExtranjero);
        instance.setPersonaCRazonSocial(personaCcrearpatrRazonSocial);
        instance.setPersonaCTieneEPSSanitas(personaCcrearpatrTieneEPSSanitas);
        instance.setPersonaCRechazadoAfiliacion(personaCcrearpatrRechazadoAfiliacion);
        instance.setPersonaCNombreCompleto(personaCcrearpatrNombreCompleto);
        instance.setPersonaCCodigo(personaCcrearpatrCodigo);
        instance.setPersonaCUltimaActualizacion(personaCcrearpatrUltimaActualizacion);

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
            com.keralty.aesolicitudes.viewmodel.personac.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.eliminarTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.EliminarRequest request) throws ModelException {
        request.setPersonaCeliminarpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCeliminarpthisPersonaC()));
        return personaCSrv.eliminarImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCeliminarpthisPersonaC = request.getPersonaCeliminarpthisPersonaCInstance();

        request.checkArguments();
        PersonaC instance = personaCeliminarpthisPersonaC;
        if(personaCeliminarpthisPersonaC.getDireccionesC().size() > 0) {
            throw new MinCardinalityException(PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ROLE_ALIAS_DIRECCIONESC);
        }
        if(personaCeliminarpthisPersonaC.getProteccionesDatosC().size() > 0) {
            throw new MinCardinalityException(PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ROLE_ALIAS_PROTECCIONESDATOSC);
        }
        if(personaCeliminarpthisPersonaC.getPregsCuesMedC().size() > 0) {
            throw new MinCardinalityException(PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ROLE_ALIAS_PREGSCUESMEDC);
        }
        if(personaCeliminarpthisPersonaC.getDirSucursalesC().size() > 0) {
            throw new MinCardinalityException(PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ROLE_ALIAS_DIRSUCURSALESC);
        }
        if(personaCeliminarpthisPersonaC.getPreexistenciasC().size() > 0) {
            throw new MinCardinalityException(PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ROLE_ALIAS_PREEXISTENCIASC);
        }
        if(personaCeliminarpthisPersonaC.getMarcasMedicasC().size() > 0) {
            throw new MinCardinalityException(PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ROLE_ALIAS_MARCASMEDICASC);
        }


        repository.delete(instance);
        
        response.setInstance(instance);

        return response;
    }

    // Service: InsTipoInstitucionCPersonaC

    /*
     * Entry point for service InsTipoInstitucionCPersonaC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insTipoInstitucionCPersonaC(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsTipoInstitucionCPersonaCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.insTipoInstitucionCPersonaCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsTipoInstitucionCPersonaC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insTipoInstitucionCPersonaCTxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsTipoInstitucionCPersonaCRequest request) throws ModelException {
        request.setPersonaCInsTipoInstitucionCPersonaCpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCInsTipoInstitucionCPersonaCpthisPersonaC()));
        request.setPersonaCInsTipoInstitucionCPersonaCpevcTipoInstitucionCInstance(tipoInstitucionCSrv.getByOIDWithHV(request.getPersonaCInsTipoInstitucionCPersonaCpevcTipoInstitucionC()));
        return personaCSrv.insTipoInstitucionCPersonaCImplementation(request, true);
    }

    /*
     * Implements service InsTipoInstitucionCPersonaC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insTipoInstitucionCPersonaCImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsTipoInstitucionCPersonaCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCInsTipoInstitucionCPersonaCpthisPersonaC = request.getPersonaCInsTipoInstitucionCPersonaCpthisPersonaCInstance();
        TipoInstitucionC personaCInsTipoInstitucionCPersonaCpevcTipoInstitucionC = request.getPersonaCInsTipoInstitucionCPersonaCpevcTipoInstitucionCInstance();

        request.checkArguments();
        PersonaC instance = personaCInsTipoInstitucionCPersonaCpthisPersonaC;

        instance.add2TipoInstitucionC(personaCInsTipoInstitucionCPersonaCpevcTipoInstitucionC);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.tipoinstitucionc.siu.InsTipoInstitucionCPersonaCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.tipoinstitucionc.siu.InsTipoInstitucionCPersonaCRequest();
            relatedRequest.setTipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionCInstance(personaCInsTipoInstitucionCPersonaCpevcTipoInstitucionC);
            relatedRequest.setTipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaCInstance(personaCInsTipoInstitucionCPersonaCpthisPersonaC);
            tipoInstitucionCSrv.insTipoInstitucionCPersonaCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelTipoInstitucionCPersonaC

    /*
     * Entry point for service DelTipoInstitucionCPersonaC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delTipoInstitucionCPersonaC(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelTipoInstitucionCPersonaCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.delTipoInstitucionCPersonaCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelTipoInstitucionCPersonaC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delTipoInstitucionCPersonaCTxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelTipoInstitucionCPersonaCRequest request) throws ModelException {
        request.setPersonaCDelTipoInstitucionCPersonaCpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCDelTipoInstitucionCPersonaCpthisPersonaC()));
        request.setPersonaCDelTipoInstitucionCPersonaCpevcTipoInstitucionCInstance(tipoInstitucionCSrv.getByOIDWithHV(request.getPersonaCDelTipoInstitucionCPersonaCpevcTipoInstitucionC()));
        return personaCSrv.delTipoInstitucionCPersonaCImplementation(request, true);
    }

    /*
     * Implements service DelTipoInstitucionCPersonaC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delTipoInstitucionCPersonaCImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelTipoInstitucionCPersonaCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCDelTipoInstitucionCPersonaCpthisPersonaC = request.getPersonaCDelTipoInstitucionCPersonaCpthisPersonaCInstance();
        TipoInstitucionC personaCDelTipoInstitucionCPersonaCpevcTipoInstitucionC = request.getPersonaCDelTipoInstitucionCPersonaCpevcTipoInstitucionCInstance();

        request.checkArguments();
        PersonaC instance = personaCDelTipoInstitucionCPersonaCpthisPersonaC;

        instance.add2TipoInstitucionC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.tipoinstitucionc.siu.DelTipoInstitucionCPersonaCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.tipoinstitucionc.siu.DelTipoInstitucionCPersonaCRequest();
            relatedRequest.setTipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionCInstance(personaCDelTipoInstitucionCPersonaCpevcTipoInstitucionC);
            relatedRequest.setTipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaCInstance(personaCDelTipoInstitucionCPersonaCpthisPersonaC);
            tipoInstitucionCSrv.delTipoInstitucionCPersonaCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsTipoEntidadCPersonaC

    /*
     * Entry point for service InsTipoEntidadCPersonaC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insTipoEntidadCPersonaC(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsTipoEntidadCPersonaCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.insTipoEntidadCPersonaCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsTipoEntidadCPersonaC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insTipoEntidadCPersonaCTxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsTipoEntidadCPersonaCRequest request) throws ModelException {
        request.setPersonaCInsTipoEntidadCPersonaCpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCInsTipoEntidadCPersonaCpthisPersonaC()));
        request.setPersonaCInsTipoEntidadCPersonaCpevcTipoEntidadCInstance(tipoEntidadCSrv.getByOIDWithHV(request.getPersonaCInsTipoEntidadCPersonaCpevcTipoEntidadC()));
        return personaCSrv.insTipoEntidadCPersonaCImplementation(request, true);
    }

    /*
     * Implements service InsTipoEntidadCPersonaC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insTipoEntidadCPersonaCImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsTipoEntidadCPersonaCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCInsTipoEntidadCPersonaCpthisPersonaC = request.getPersonaCInsTipoEntidadCPersonaCpthisPersonaCInstance();
        TipoEntidadC personaCInsTipoEntidadCPersonaCpevcTipoEntidadC = request.getPersonaCInsTipoEntidadCPersonaCpevcTipoEntidadCInstance();

        request.checkArguments();
        PersonaC instance = personaCInsTipoEntidadCPersonaCpthisPersonaC;

        instance.add2TipoEntidadC(personaCInsTipoEntidadCPersonaCpevcTipoEntidadC);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.tipoentidadc.siu.InsTipoEntidadCPersonaCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.tipoentidadc.siu.InsTipoEntidadCPersonaCRequest();
            relatedRequest.setTipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadCInstance(personaCInsTipoEntidadCPersonaCpevcTipoEntidadC);
            relatedRequest.setTipoEntidadCInsTipoEntidadCPersonaCpevcPersonaCInstance(personaCInsTipoEntidadCPersonaCpthisPersonaC);
            tipoEntidadCSrv.insTipoEntidadCPersonaCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelTipoEntidadCPersonaC

    /*
     * Entry point for service DelTipoEntidadCPersonaC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delTipoEntidadCPersonaC(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelTipoEntidadCPersonaCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.delTipoEntidadCPersonaCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelTipoEntidadCPersonaC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delTipoEntidadCPersonaCTxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelTipoEntidadCPersonaCRequest request) throws ModelException {
        request.setPersonaCDelTipoEntidadCPersonaCpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCDelTipoEntidadCPersonaCpthisPersonaC()));
        request.setPersonaCDelTipoEntidadCPersonaCpevcTipoEntidadCInstance(tipoEntidadCSrv.getByOIDWithHV(request.getPersonaCDelTipoEntidadCPersonaCpevcTipoEntidadC()));
        return personaCSrv.delTipoEntidadCPersonaCImplementation(request, true);
    }

    /*
     * Implements service DelTipoEntidadCPersonaC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delTipoEntidadCPersonaCImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelTipoEntidadCPersonaCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCDelTipoEntidadCPersonaCpthisPersonaC = request.getPersonaCDelTipoEntidadCPersonaCpthisPersonaCInstance();
        TipoEntidadC personaCDelTipoEntidadCPersonaCpevcTipoEntidadC = request.getPersonaCDelTipoEntidadCPersonaCpevcTipoEntidadCInstance();

        request.checkArguments();
        PersonaC instance = personaCDelTipoEntidadCPersonaCpthisPersonaC;

        instance.add2TipoEntidadC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.tipoentidadc.siu.DelTipoEntidadCPersonaCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.tipoentidadc.siu.DelTipoEntidadCPersonaCRequest();
            relatedRequest.setTipoEntidadCDelTipoEntidadCPersonaCpthisTipoEntidadCInstance(personaCDelTipoEntidadCPersonaCpevcTipoEntidadC);
            relatedRequest.setTipoEntidadCDelTipoEntidadCPersonaCpevcPersonaCInstance(personaCDelTipoEntidadCPersonaCpthisPersonaC);
            tipoEntidadCSrv.delTipoEntidadCPersonaCImplementation(relatedRequest, false);
        }


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
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsPersonaCTitularRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.insPersonaCTitularTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsPersonaCTitularRequest request) throws ModelException {
        request.setPersonaCInsPersonaCTitularpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCInsPersonaCTitularpthisPersonaC()));
        request.setPersonaCInsPersonaCTitularpevcFamiliaCInstance(familiaCSrv.getByOIDWithHV(request.getPersonaCInsPersonaCTitularpevcFamiliaC()));
        return personaCSrv.insPersonaCTitularImplementation(request, true);
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsPersonaCTitularRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCInsPersonaCTitularpthisPersonaC = request.getPersonaCInsPersonaCTitularpthisPersonaCInstance();
        FamiliaC personaCInsPersonaCTitularpevcFamiliaC = request.getPersonaCInsPersonaCTitularpevcFamiliaCInstance();

        request.checkArguments();
        PersonaC instance = personaCInsPersonaCTitularpthisPersonaC;

        instance.add2FamiliasC(personaCInsPersonaCTitularpevcFamiliaC);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.familiac.siu.InsPersonaCTitularRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.familiac.siu.InsPersonaCTitularRequest();
            relatedRequest.setFamiliaCInsPersonaCTitularpthisFamiliaCInstance(personaCInsPersonaCTitularpevcFamiliaC);
            relatedRequest.setFamiliaCInsPersonaCTitularpevcPersonaCInstance(personaCInsPersonaCTitularpthisPersonaC);
            familiaCSrv.insPersonaCTitularImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: actualizarCodigo

    /*
     * Entry point for service actualizarCodigo
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse actualizarCodigo(
            com.keralty.aesolicitudes.viewmodel.personac.siu.ActualizarCodigoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.actualizarCodigoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service actualizarCodigo
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse actualizarCodigoTxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.ActualizarCodigoRequest request) throws ModelException {
        request.setPersonaCactualizarCodigopthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCactualizarCodigopthisPersonaC()));
        return personaCSrv.actualizarCodigoImplementation(request);
    }

    /*
     * Implements service actualizarCodigo
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse actualizarCodigoImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.ActualizarCodigoRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCactualizarCodigopthisPersonaC = request.getPersonaCactualizarCodigopthisPersonaCInstance();
        Long personaCactualizarCodigopCodigo = request.getPersonaCactualizarCodigopCodigo();

        request.checkArguments();
        PersonaC instance = personaCactualizarCodigopthisPersonaC;
        instance.setPersonaCCodigo(personaCactualizarCodigopCodigo);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsPersonaCContratante

    /*
     * Entry point for service InsPersonaCContratante
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insPersonaCContratante(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsPersonaCContratanteRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.insPersonaCContratanteTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsPersonaCContratante
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insPersonaCContratanteTxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsPersonaCContratanteRequest request) throws ModelException {
        request.setPersonaCInsPersonaCContratantepthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCInsPersonaCContratantepthisPersonaC()));
        request.setPersonaCInsPersonaCContratantepevcContratoCInstance(contratoCSrv.getByOIDWithHV(request.getPersonaCInsPersonaCContratantepevcContratoC()));
        return personaCSrv.insPersonaCContratanteImplementation(request, true);
    }

    /*
     * Implements service InsPersonaCContratante
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insPersonaCContratanteImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsPersonaCContratanteRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCInsPersonaCContratantepthisPersonaC = request.getPersonaCInsPersonaCContratantepthisPersonaCInstance();
        ContratoC personaCInsPersonaCContratantepevcContratoC = request.getPersonaCInsPersonaCContratantepevcContratoCInstance();

        request.checkArguments();
        PersonaC instance = personaCInsPersonaCContratantepthisPersonaC;

        instance.add2ContratosC(personaCInsPersonaCContratantepevcContratoC);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsPersonaCContratanteRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsPersonaCContratanteRequest();
            relatedRequest.setContratoCInsPersonaCContratantepthisContratoCInstance(personaCInsPersonaCContratantepevcContratoC);
            relatedRequest.setContratoCInsPersonaCContratantepevcPersonaCInstance(personaCInsPersonaCContratantepthisPersonaC);
            contratoCSrv.insPersonaCContratanteImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelPersonaCContratante

    /*
     * Entry point for service DelPersonaCContratante
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delPersonaCContratante(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelPersonaCContratanteRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.delPersonaCContratanteTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelPersonaCContratante
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delPersonaCContratanteTxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelPersonaCContratanteRequest request) throws ModelException {
        request.setPersonaCDelPersonaCContratantepthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCDelPersonaCContratantepthisPersonaC()));
        request.setPersonaCDelPersonaCContratantepevcContratoCInstance(contratoCSrv.getByOIDWithHV(request.getPersonaCDelPersonaCContratantepevcContratoC()));
        return personaCSrv.delPersonaCContratanteImplementation(request, true);
    }

    /*
     * Implements service DelPersonaCContratante
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delPersonaCContratanteImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelPersonaCContratanteRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCDelPersonaCContratantepthisPersonaC = request.getPersonaCDelPersonaCContratantepthisPersonaCInstance();
        ContratoC personaCDelPersonaCContratantepevcContratoC = request.getPersonaCDelPersonaCContratantepevcContratoCInstance();

        request.checkArguments();
        PersonaC instance = personaCDelPersonaCContratantepthisPersonaC;

        instance.add2ContratosC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelPersonaCContratanteRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelPersonaCContratanteRequest();
            relatedRequest.setContratoCDelPersonaCContratantepthisContratoCInstance(personaCDelPersonaCContratantepevcContratoC);
            relatedRequest.setContratoCDelPersonaCContratantepevcPersonaCInstance(personaCDelPersonaCContratantepthisPersonaC);
            contratoCSrv.delPersonaCContratanteImplementation(relatedRequest, false);
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelPersonaCTitularRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.delPersonaCTitularTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelPersonaCTitularRequest request) throws ModelException {
        request.setPersonaCDelPersonaCTitularpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCDelPersonaCTitularpthisPersonaC()));
        request.setPersonaCDelPersonaCTitularpevcFamiliaCInstance(familiaCSrv.getByOIDWithHV(request.getPersonaCDelPersonaCTitularpevcFamiliaC()));
        return personaCSrv.delPersonaCTitularImplementation(request, true);
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelPersonaCTitularRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCDelPersonaCTitularpthisPersonaC = request.getPersonaCDelPersonaCTitularpthisPersonaCInstance();
        FamiliaC personaCDelPersonaCTitularpevcFamiliaC = request.getPersonaCDelPersonaCTitularpevcFamiliaCInstance();

        request.checkArguments();
        PersonaC instance = personaCDelPersonaCTitularpthisPersonaC;

        instance.add2FamiliasC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.familiac.siu.DelPersonaCTitularRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.familiac.siu.DelPersonaCTitularRequest();
            relatedRequest.setFamiliaCDelPersonaCTitularpthisFamiliaCInstance(personaCDelPersonaCTitularpevcFamiliaC);
            relatedRequest.setFamiliaCDelPersonaCTitularpevcPersonaCInstance(personaCDelPersonaCTitularpthisPersonaC);
            familiaCSrv.delPersonaCTitularImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsEstadoCivilC

    /*
     * Entry point for service InsEstadoCivilC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insEstadoCivilC(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsEstadoCivilCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.insEstadoCivilCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsEstadoCivilC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insEstadoCivilCTxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsEstadoCivilCRequest request) throws ModelException {
        request.setPersonaCInsEstadoCivilCpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCInsEstadoCivilCpthisPersonaC()));
        request.setPersonaCInsEstadoCivilCpevcEstadoCivilInstance(estadoCivilSrv.getByOIDWithHV(request.getPersonaCInsEstadoCivilCpevcEstadoCivil()));
        return personaCSrv.insEstadoCivilCImplementation(request, true);
    }

    /*
     * Implements service InsEstadoCivilC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insEstadoCivilCImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsEstadoCivilCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCInsEstadoCivilCpthisPersonaC = request.getPersonaCInsEstadoCivilCpthisPersonaCInstance();
        EstadoCivil personaCInsEstadoCivilCpevcEstadoCivil = request.getPersonaCInsEstadoCivilCpevcEstadoCivilInstance();

        request.checkArguments();
        PersonaC instance = personaCInsEstadoCivilCpthisPersonaC;

        instance.add2EstadoCivilC(personaCInsEstadoCivilCpevcEstadoCivil);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.estadocivil.siu.InsEstadoCivilCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.estadocivil.siu.InsEstadoCivilCRequest();
            relatedRequest.setEstadoCivilInsEstadoCivilCpthisEstadoCivilInstance(personaCInsEstadoCivilCpevcEstadoCivil);
            relatedRequest.setEstadoCivilInsEstadoCivilCpevcPersonaCInstance(personaCInsEstadoCivilCpthisPersonaC);
            estadoCivilSrv.insEstadoCivilCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelEstadoCivilC

    /*
     * Entry point for service DelEstadoCivilC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delEstadoCivilC(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelEstadoCivilCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.delEstadoCivilCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelEstadoCivilC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delEstadoCivilCTxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelEstadoCivilCRequest request) throws ModelException {
        request.setPersonaCDelEstadoCivilCpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCDelEstadoCivilCpthisPersonaC()));
        request.setPersonaCDelEstadoCivilCpevcEstadoCivilInstance(estadoCivilSrv.getByOIDWithHV(request.getPersonaCDelEstadoCivilCpevcEstadoCivil()));
        return personaCSrv.delEstadoCivilCImplementation(request, true);
    }

    /*
     * Implements service DelEstadoCivilC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delEstadoCivilCImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelEstadoCivilCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCDelEstadoCivilCpthisPersonaC = request.getPersonaCDelEstadoCivilCpthisPersonaCInstance();
        EstadoCivil personaCDelEstadoCivilCpevcEstadoCivil = request.getPersonaCDelEstadoCivilCpevcEstadoCivilInstance();

        request.checkArguments();
        PersonaC instance = personaCDelEstadoCivilCpthisPersonaC;

        instance.add2EstadoCivilC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.estadocivil.siu.DelEstadoCivilCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.estadocivil.siu.DelEstadoCivilCRequest();
            relatedRequest.setEstadoCivilDelEstadoCivilCpthisEstadoCivilInstance(personaCDelEstadoCivilCpevcEstadoCivil);
            relatedRequest.setEstadoCivilDelEstadoCivilCpevcPersonaCInstance(personaCDelEstadoCivilCpthisPersonaC);
            estadoCivilSrv.delEstadoCivilCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsEstadoPersonaC

    /*
     * Entry point for service InsEstadoPersonaC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insEstadoPersonaC(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsEstadoPersonaCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.insEstadoPersonaCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsEstadoPersonaC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insEstadoPersonaCTxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsEstadoPersonaCRequest request) throws ModelException {
        request.setPersonaCInsEstadoPersonaCpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCInsEstadoPersonaCpthisPersonaC()));
        request.setPersonaCInsEstadoPersonaCpevcEstadoPersonaInstance(estadoPersonaSrv.getByOIDWithHV(request.getPersonaCInsEstadoPersonaCpevcEstadoPersona()));
        return personaCSrv.insEstadoPersonaCImplementation(request, true);
    }

    /*
     * Implements service InsEstadoPersonaC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insEstadoPersonaCImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsEstadoPersonaCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCInsEstadoPersonaCpthisPersonaC = request.getPersonaCInsEstadoPersonaCpthisPersonaCInstance();
        EstadoPersona personaCInsEstadoPersonaCpevcEstadoPersona = request.getPersonaCInsEstadoPersonaCpevcEstadoPersonaInstance();

        request.checkArguments();
        PersonaC instance = personaCInsEstadoPersonaCpthisPersonaC;

        instance.add2EstadoPersonaC(personaCInsEstadoPersonaCpevcEstadoPersona);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.estadopersona.siu.InsEstadoPersonaCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.estadopersona.siu.InsEstadoPersonaCRequest();
            relatedRequest.setEstadoPersonaInsEstadoPersonaCpthisEstadoPersonaInstance(personaCInsEstadoPersonaCpevcEstadoPersona);
            relatedRequest.setEstadoPersonaInsEstadoPersonaCpevcPersonaCInstance(personaCInsEstadoPersonaCpthisPersonaC);
            estadoPersonaSrv.insEstadoPersonaCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelEstadoPersonaC

    /*
     * Entry point for service DelEstadoPersonaC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delEstadoPersonaC(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelEstadoPersonaCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.delEstadoPersonaCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelEstadoPersonaC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delEstadoPersonaCTxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelEstadoPersonaCRequest request) throws ModelException {
        request.setPersonaCDelEstadoPersonaCpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCDelEstadoPersonaCpthisPersonaC()));
        request.setPersonaCDelEstadoPersonaCpevcEstadoPersonaInstance(estadoPersonaSrv.getByOIDWithHV(request.getPersonaCDelEstadoPersonaCpevcEstadoPersona()));
        return personaCSrv.delEstadoPersonaCImplementation(request, true);
    }

    /*
     * Implements service DelEstadoPersonaC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delEstadoPersonaCImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelEstadoPersonaCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCDelEstadoPersonaCpthisPersonaC = request.getPersonaCDelEstadoPersonaCpthisPersonaCInstance();
        EstadoPersona personaCDelEstadoPersonaCpevcEstadoPersona = request.getPersonaCDelEstadoPersonaCpevcEstadoPersonaInstance();

        request.checkArguments();
        PersonaC instance = personaCDelEstadoPersonaCpthisPersonaC;

        instance.add2EstadoPersonaC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.estadopersona.siu.DelEstadoPersonaCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.estadopersona.siu.DelEstadoPersonaCRequest();
            relatedRequest.setEstadoPersonaDelEstadoPersonaCpthisEstadoPersonaInstance(personaCDelEstadoPersonaCpevcEstadoPersona);
            relatedRequest.setEstadoPersonaDelEstadoPersonaCpevcPersonaCInstance(personaCDelEstadoPersonaCpthisPersonaC);
            estadoPersonaSrv.delEstadoPersonaCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: CambTipoIdentificacionC

    /*
     * Entry point for service CambTipoIdentificacionC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse cambTipoIdentificacionC(
            com.keralty.aesolicitudes.viewmodel.personac.siu.CambTipoIdentificacionCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.cambTipoIdentificacionCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service CambTipoIdentificacionC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse cambTipoIdentificacionCTxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.CambTipoIdentificacionCRequest request) throws ModelException {
        request.setPersonaCCambTipoIdentificacionCpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCCambTipoIdentificacionCpthisPersonaC()));
        request.setPersonaCCambTipoIdentificacionCpevcTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getPersonaCCambTipoIdentificacionCpevcTipoIdentificacion()));
        return personaCSrv.cambTipoIdentificacionCImplementation(request, true);
    }

    /*
     * Implements service CambTipoIdentificacionC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse cambTipoIdentificacionCImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.CambTipoIdentificacionCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCCambTipoIdentificacionCpthisPersonaC = request.getPersonaCCambTipoIdentificacionCpthisPersonaCInstance();
        TipoIdentificacion personaCCambTipoIdentificacionCpevcTipoIdentificacion = request.getPersonaCCambTipoIdentificacionCpevcTipoIdentificacionInstance();

        request.checkArguments();
        PersonaC instance = personaCCambTipoIdentificacionCpthisPersonaC;

        instance.add2TipoIdentificacionC(personaCCambTipoIdentificacionCpevcTipoIdentificacion);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.tipoidentificacion.siu.CambTipoIdentificacionCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.tipoidentificacion.siu.CambTipoIdentificacionCRequest();
            relatedRequest.setTipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacionInstance(personaCCambTipoIdentificacionCpevcTipoIdentificacion);
            relatedRequest.setTipoIdentificacionCambTipoIdentificacionCpevcPersonaCInstance(personaCCambTipoIdentificacionCpthisPersonaC);
            tipoIdentificacionSrv.cambTipoIdentificacionCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsMunicipioCNac

    /*
     * Entry point for service InsMunicipioCNac
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insMunicipioCNac(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsMunicipioCNacRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.insMunicipioCNacTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsMunicipioCNac
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insMunicipioCNacTxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsMunicipioCNacRequest request) throws ModelException {
        request.setPersonaCInsMunicipioCNacpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCInsMunicipioCNacpthisPersonaC()));
        request.setPersonaCInsMunicipioCNacpevcMunicipioInstance(municipioSrv.getByOIDWithHV(request.getPersonaCInsMunicipioCNacpevcMunicipio()));
        return personaCSrv.insMunicipioCNacImplementation(request, true);
    }

    /*
     * Implements service InsMunicipioCNac
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insMunicipioCNacImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsMunicipioCNacRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCInsMunicipioCNacpthisPersonaC = request.getPersonaCInsMunicipioCNacpthisPersonaCInstance();
        Municipio personaCInsMunicipioCNacpevcMunicipio = request.getPersonaCInsMunicipioCNacpevcMunicipioInstance();

        request.checkArguments();
        PersonaC instance = personaCInsMunicipioCNacpthisPersonaC;

        instance.add2MunicipioCNac(personaCInsMunicipioCNacpevcMunicipio);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.municipio.siu.InsMunicipioCNacRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.municipio.siu.InsMunicipioCNacRequest();
            relatedRequest.setMunicipioInsMunicipioCNacpthisMunicipioInstance(personaCInsMunicipioCNacpevcMunicipio);
            relatedRequest.setMunicipioInsMunicipioCNacpevcPersonaCInstance(personaCInsMunicipioCNacpthisPersonaC);
            municipioSrv.insMunicipioCNacImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelMunicipioCNac

    /*
     * Entry point for service DelMunicipioCNac
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delMunicipioCNac(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelMunicipioCNacRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.delMunicipioCNacTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelMunicipioCNac
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delMunicipioCNacTxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelMunicipioCNacRequest request) throws ModelException {
        request.setPersonaCDelMunicipioCNacpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCDelMunicipioCNacpthisPersonaC()));
        request.setPersonaCDelMunicipioCNacpevcMunicipioInstance(municipioSrv.getByOIDWithHV(request.getPersonaCDelMunicipioCNacpevcMunicipio()));
        return personaCSrv.delMunicipioCNacImplementation(request, true);
    }

    /*
     * Implements service DelMunicipioCNac
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delMunicipioCNacImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelMunicipioCNacRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCDelMunicipioCNacpthisPersonaC = request.getPersonaCDelMunicipioCNacpthisPersonaCInstance();
        Municipio personaCDelMunicipioCNacpevcMunicipio = request.getPersonaCDelMunicipioCNacpevcMunicipioInstance();

        request.checkArguments();
        PersonaC instance = personaCDelMunicipioCNacpthisPersonaC;

        instance.add2MunicipioCNac(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.municipio.siu.DelMunicipioCNacRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.municipio.siu.DelMunicipioCNacRequest();
            relatedRequest.setMunicipioDelMunicipioCNacpthisMunicipioInstance(personaCDelMunicipioCNacpevcMunicipio);
            relatedRequest.setMunicipioDelMunicipioCNacpevcPersonaCInstance(personaCDelMunicipioCNacpthisPersonaC);
            municipioSrv.delMunicipioCNacImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsDepartamentoCNac

    /*
     * Entry point for service InsDepartamentoCNac
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insDepartamentoCNac(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsDepartamentoCNacRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.insDepartamentoCNacTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsDepartamentoCNac
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insDepartamentoCNacTxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsDepartamentoCNacRequest request) throws ModelException {
        request.setPersonaCInsDepartamentoCNacpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCInsDepartamentoCNacpthisPersonaC()));
        request.setPersonaCInsDepartamentoCNacpevcDepartamentoInstance(departamentoSrv.getByOIDWithHV(request.getPersonaCInsDepartamentoCNacpevcDepartamento()));
        return personaCSrv.insDepartamentoCNacImplementation(request, true);
    }

    /*
     * Implements service InsDepartamentoCNac
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insDepartamentoCNacImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsDepartamentoCNacRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCInsDepartamentoCNacpthisPersonaC = request.getPersonaCInsDepartamentoCNacpthisPersonaCInstance();
        Departamento personaCInsDepartamentoCNacpevcDepartamento = request.getPersonaCInsDepartamentoCNacpevcDepartamentoInstance();

        request.checkArguments();
        PersonaC instance = personaCInsDepartamentoCNacpthisPersonaC;

        instance.add2DepartamentoCNac(personaCInsDepartamentoCNacpevcDepartamento);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.departamento.siu.InsDepartamentoCNacRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.departamento.siu.InsDepartamentoCNacRequest();
            relatedRequest.setDepartamentoInsDepartamentoCNacpthisDepartamentoInstance(personaCInsDepartamentoCNacpevcDepartamento);
            relatedRequest.setDepartamentoInsDepartamentoCNacpevcPersonaCInstance(personaCInsDepartamentoCNacpthisPersonaC);
            departamentoSrv.insDepartamentoCNacImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelDepartamentoCNac

    /*
     * Entry point for service DelDepartamentoCNac
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delDepartamentoCNac(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelDepartamentoCNacRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.delDepartamentoCNacTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelDepartamentoCNac
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delDepartamentoCNacTxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelDepartamentoCNacRequest request) throws ModelException {
        request.setPersonaCDelDepartamentoCNacpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCDelDepartamentoCNacpthisPersonaC()));
        request.setPersonaCDelDepartamentoCNacpevcDepartamentoInstance(departamentoSrv.getByOIDWithHV(request.getPersonaCDelDepartamentoCNacpevcDepartamento()));
        return personaCSrv.delDepartamentoCNacImplementation(request, true);
    }

    /*
     * Implements service DelDepartamentoCNac
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delDepartamentoCNacImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelDepartamentoCNacRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCDelDepartamentoCNacpthisPersonaC = request.getPersonaCDelDepartamentoCNacpthisPersonaCInstance();
        Departamento personaCDelDepartamentoCNacpevcDepartamento = request.getPersonaCDelDepartamentoCNacpevcDepartamentoInstance();

        request.checkArguments();
        PersonaC instance = personaCDelDepartamentoCNacpthisPersonaC;

        instance.add2DepartamentoCNac(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.departamento.siu.DelDepartamentoCNacRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.departamento.siu.DelDepartamentoCNacRequest();
            relatedRequest.setDepartamentoDelDepartamentoCNacpthisDepartamentoInstance(personaCDelDepartamentoCNacpevcDepartamento);
            relatedRequest.setDepartamentoDelDepartamentoCNacpevcPersonaCInstance(personaCDelDepartamentoCNacpthisPersonaC);
            departamentoSrv.delDepartamentoCNacImplementation(relatedRequest, false);
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsBeneficiariosCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.insBeneficiariosCTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsBeneficiariosCRequest request) throws ModelException {
        request.setPersonaCInsBeneficiariosCpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCInsBeneficiariosCpthisPersonaC()));
        request.setPersonaCInsBeneficiariosCpevcBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getPersonaCInsBeneficiariosCpevcBeneficiarioC()));
        return personaCSrv.insBeneficiariosCImplementation(request, true);
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsBeneficiariosCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCInsBeneficiariosCpthisPersonaC = request.getPersonaCInsBeneficiariosCpthisPersonaCInstance();
        BeneficiarioC personaCInsBeneficiariosCpevcBeneficiarioC = request.getPersonaCInsBeneficiariosCpevcBeneficiarioCInstance();

        request.checkArguments();
        PersonaC instance = personaCInsBeneficiariosCpthisPersonaC;

        instance.add2BeneficiariosC(personaCInsBeneficiariosCpevcBeneficiarioC);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsBeneficiariosCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.InsBeneficiariosCRequest();
            relatedRequest.setBeneficiarioCInsBeneficiariosCpthisBeneficiarioCInstance(personaCInsBeneficiariosCpevcBeneficiarioC);
            relatedRequest.setBeneficiarioCInsBeneficiariosCpevcPersonaCInstance(personaCInsBeneficiariosCpthisPersonaC);
            beneficiarioCSrv.insBeneficiariosCImplementation(relatedRequest, false);
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelBeneficiariosCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.delBeneficiariosCTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelBeneficiariosCRequest request) throws ModelException {
        request.setPersonaCDelBeneficiariosCpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCDelBeneficiariosCpthisPersonaC()));
        request.setPersonaCDelBeneficiariosCpevcBeneficiarioCInstance(beneficiarioCSrv.getByOIDWithHV(request.getPersonaCDelBeneficiariosCpevcBeneficiarioC()));
        return personaCSrv.delBeneficiariosCImplementation(request, true);
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelBeneficiariosCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCDelBeneficiariosCpthisPersonaC = request.getPersonaCDelBeneficiariosCpthisPersonaCInstance();
        BeneficiarioC personaCDelBeneficiariosCpevcBeneficiarioC = request.getPersonaCDelBeneficiariosCpevcBeneficiarioCInstance();

        request.checkArguments();
        PersonaC instance = personaCDelBeneficiariosCpthisPersonaC;

        instance.add2BeneficiariosC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelBeneficiariosCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu.DelBeneficiariosCRequest();
            relatedRequest.setBeneficiarioCDelBeneficiariosCpthisBeneficiarioCInstance(personaCDelBeneficiariosCpevcBeneficiarioC);
            relatedRequest.setBeneficiarioCDelBeneficiariosCpevcPersonaCInstance(personaCDelBeneficiariosCpthisPersonaC);
            beneficiarioCSrv.delBeneficiariosCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: evalPostNotificar

    /*
     * Entry point for service evalPostNotificar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse evalPostNotificar(
            com.keralty.aesolicitudes.viewmodel.personac.siu.EvalPostNotificarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.evalPostNotificarTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service evalPostNotificar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse evalPostNotificarTxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.EvalPostNotificarRequest request) throws ModelException {
        request.setPersonaCevalPostNotificarpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCevalPostNotificarpthisPersonaC()));
        return personaCSrv.evalPostNotificarImplementation(request);
    }

    /*
     * Implements service evalPostNotificar
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse evalPostNotificarImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.EvalPostNotificarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCevalPostNotificarpthisPersonaC = request.getPersonaCevalPostNotificarpthisPersonaCInstance();
        String personaCevalPostNotificarpeNumIdent = request.getPersonaCevalPostNotificarpeNumIdent();
        String personaCevalPostNotificarpeNombreCompleto = request.getPersonaCevalPostNotificarpeNombreCompleto();

        request.checkArguments();
        PersonaC instance = personaCevalPostNotificarpthisPersonaC;
        instance.setPersonaCNumIdentificacion(personaCevalPostNotificarpeNumIdent);
        instance.setPersonaCNombreCompleto(personaCevalPostNotificarpeNombreCompleto);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: TCREAROCUESDEAE

    /*
     * Entry point for service TCREAROCUESDEAE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCREAROCUESDEAE(
            com.keralty.aesolicitudes.viewmodel.personac.siu.TCREAROCUESDEAERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.tCREAROCUESDEAETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREAROCUESDEAE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCREAROCUESDEAETxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.TCREAROCUESDEAERequest request) throws ModelException, SystemException {
        request.setPersonaCTCREAROCUESDEAEpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCTCREAROCUESDEAEpthisPersonaC()));
        request.setPersonaCTCREAROCUESDEAEpCuestionarioPInstance(cuestionarioPSrv.getByOIDWithHV(request.getPersonaCTCREAROCUESDEAEpCuestionarioP()));
        return personaCSrv.tCREAROCUESDEAEImplementation(request);
    }

    /*
     * Implements service TCREAROCUESDEAE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCREAROCUESDEAEImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.TCREAROCUESDEAERequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        CuestionarioP personaCTCREAROCUESDEAEpCuestionarioP = request.getPersonaCTCREAROCUESDEAEpCuestionarioPInstance();
        PersonaC personaCTCREAROCUESDEAEpthisPersonaC = request.getPersonaCTCREAROCUESDEAEpthisPersonaCInstance();

        request.checkArguments();
        PersonaC instance = personaCTCREAROCUESDEAEpthisPersonaC;

        /* Action 1: IF (EXIST (PregsCuesMedC) = true) */
        boolean ifCondition1 = repository.assocOperator015(personaCTCREAROCUESDEAEpthisPersonaC).equals(true);
        if (ifCondition1) {
            for(PregCuesMedC step110Entity : repository.assocOperator013(personaCTCREAROCUESDEAEpthisPersonaC)) {
                com.keralty.aesolicitudes.viewmodel.pregcuesmedc.siu.EliminarRequest step10Request = new com.keralty.aesolicitudes.viewmodel.pregcuesmedc.siu.EliminarRequest();
                step10Request.setPregCuesMedCeliminarpthisPregCuesMedCInstance(step110Entity);
                pregCuesMedCSrv.eliminarImplementation(step10Request);
            }
        }

        for(PreguntaP step2Entity : repository.assocOperator014(personaCTCREAROCUESDEAEpthisPersonaC, personaCTCREAROCUESDEAEpCuestionarioP)) {
            com.keralty.aesolicitudes.viewmodel.pregcuesmedc.siu.CrearRequest step2Request = new com.keralty.aesolicitudes.viewmodel.pregcuesmedc.siu.CrearRequest();
            step2Request.setPregCuesMedCcrearpagrPersonaCInstance(personaCTCREAROCUESDEAEpthisPersonaC);
            step2Request.setPregCuesMedCcrearpatrCodPregunta(step2Entity.getPreguntaPNumero());
            step2Request.setPregCuesMedCcrearpatrRptaPregunta(step2Entity.getPreguntaPRespuestaSiNo());
            step2Request.setPregCuesMedCcrearpatrObservacions(step2Entity.getPreguntaPdrvRespuesta());
            pregCuesMedCSrv.crearImplementation(step2Request);
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.TELIMINARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.tELIMINARTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.TELIMINARRequest request) throws ModelException, SystemException {
        request.setPersonaCTELIMINARpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCTELIMINARpthisPersonaC()));
        return personaCSrv.tELIMINARImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.TELIMINARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        PersonaC personaCTELIMINARpthisPersonaC = request.getPersonaCTELIMINARpthisPersonaCInstance();

        request.checkArguments();
        PersonaC instance = personaCTELIMINARpthisPersonaC;

        for(PregCuesMedC step1Entity : repository.assocOperator016(personaCTELIMINARpthisPersonaC)) {
            com.keralty.aesolicitudes.viewmodel.pregcuesmedc.siu.EliminarRequest step1Request = new com.keralty.aesolicitudes.viewmodel.pregcuesmedc.siu.EliminarRequest();
            step1Request.setPregCuesMedCeliminarpthisPregCuesMedCInstance(step1Entity);
            pregCuesMedCSrv.eliminarImplementation(step1Request);
        }

        for(DireccionC step2Entity : repository.assocOperator017(personaCTELIMINARpthisPersonaC)) {
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.TELIMINARRequest step2Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.TELIMINARRequest();
            step2Request.setDireccionCTELIMINARpthisDireccionCInstance(step2Entity);
            direccionCSrv.tELIMINARImplementation(step2Request);
        }

        for(DirSucursalC step3Entity : repository.assocOperator018(personaCTELIMINARpthisPersonaC)) {
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.TELIMINARRequest step3Request = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.TELIMINARRequest();
            step3Request.setDirSucursalCTELIMINARpthisDirSucursalCInstance(step3Entity);
            dirSucursalCSrv.tELIMINARImplementation(step3Request);
        }

        for(ProteccionDatosC step4Entity : repository.assocOperator019(personaCTELIMINARpthisPersonaC)) {
            com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.EliminarRequest step4Request = new com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.EliminarRequest();
            step4Request.setProteccionDatosCeliminarpthisProteccionDatosCInstance(step4Entity);
            proteccionDatosCSrv.eliminarImplementation(step4Request);
        }

        for(MarcaMedicaC step5Entity : repository.assocOperator020(personaCTELIMINARpthisPersonaC)) {
            com.keralty.aesolicitudes.viewmodel.marcamedicac.siu.EliminarRequest step5Request = new com.keralty.aesolicitudes.viewmodel.marcamedicac.siu.EliminarRequest();
            step5Request.setMarcaMedicaCeliminarpthisMarcaMedicaCInstance(step5Entity);
            marcaMedicaCSrv.eliminarImplementation(step5Request);
        }

        for(PreexistenciaC step6Entity : repository.assocOperator021(personaCTELIMINARpthisPersonaC)) {
            com.keralty.aesolicitudes.viewmodel.preexistenciac.siu.EliminarRequest step6Request = new com.keralty.aesolicitudes.viewmodel.preexistenciac.siu.EliminarRequest();
            step6Request.setPreexistenciaCeliminarpthisPreexistenciaCInstance(step6Entity);
            preexistenciaCSrv.eliminarImplementation(step6Request);
        }

        com.keralty.aesolicitudes.viewmodel.personac.siu.EliminarRequest step7Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.EliminarRequest();
        step7Request.setPersonaCeliminarpthisPersonaCInstance(personaCTELIMINARpthisPersonaC);
        personaCSrv.eliminarImplementation(step7Request);

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TNEWCONTRADESDEAE

    /*
     * Entry point for service TNEWCONTRADESDEAE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tNEWCONTRADESDEAE(
            com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWCONTRADESDEAERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.tNEWCONTRADESDEAETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TNEWCONTRADESDEAE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tNEWCONTRADESDEAETxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWCONTRADESDEAERequest request) throws ModelException, SystemException {
        request.setPersonaCTNEWCONTRADESDEAEptSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getPersonaCTNEWCONTRADESDEAEptSolicitud()));
        request.setPersonaCTNEWCONTRADESDEAEptContratoInstance(contratoCSrv.getByOIDWithHV(request.getPersonaCTNEWCONTRADESDEAEptContrato()));
        return personaCSrv.tNEWCONTRADESDEAEImplementation(request);
    }

    /*
     * Implements service TNEWCONTRADESDEAE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tNEWCONTRADESDEAEImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWCONTRADESDEAERequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Solicitud personaCTNEWCONTRADESDEAEptSolicitud = request.getPersonaCTNEWCONTRADESDEAEptSolicitudInstance();
        ContratoC personaCTNEWCONTRADESDEAEptContrato = request.getPersonaCTNEWCONTRADESDEAEptContratoInstance();

        request.checkArguments();
        PersonaC instance;

        com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWRequest step1Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWRequest();
        step1Request.setPersonaCTNEWptpagrTipoInstitucionCInstance(null);
        step1Request.setPersonaCTNEWptpagrTipoEntidadCInstance(null);
        step1Request.setPersonaCTNEWptpagrEstadoCivilCInstance(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getEstadoCivil());
        step1Request.setPersonaCTNEWptpagrEstadoPersonaCInstance(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getEstadoPersona());
        step1Request.setPersonaCTNEWptpagrTipoIdentificacionCInstance(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getTipoIdentificacion());
        step1Request.setPersonaCTNEWptpagrMunicipioCNacInstance(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getMunicipioNacimiento());
        step1Request.setPersonaCTNEWptpagrDepartamentoCNacInstance(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getDepartamentoNacimiento());
        step1Request.setPersonaCTNEWptpagrContratosCInstance(personaCTNEWCONTRADESDEAEptContrato);
        step1Request.setPersonaCTNEWptpagrFamiliasCInstance(null);
        step1Request.setPersonaCTNEWptpagrBeneficiariosCInstance(null);
        step1Request.setPersonaCTNEWptpatrNumIdentificacion(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getPersonaNumIdentificacion());
        step1Request.setPersonaCTNEWptpatrMail(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getPersonaCorreoElectronico());
        step1Request.setPersonaCTNEWptpatrPrimerNombre(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getPersonaPrimerNombre());
        step1Request.setPersonaCTNEWptpatrSegundoNombre(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getPersonaSegundoNombre());
        step1Request.setPersonaCTNEWptpatrPrimerApellido(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getPersonaPrimerApellido());
        step1Request.setPersonaCTNEWptpatrSegundoApellido(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getPersonaSegundoApellido());
        step1Request.setPersonaCTNEWptpatrFechaNacimiento(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getPersonaFechaNacimiento());
        step1Request.setPersonaCTNEWptpatrGenero(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getPersonaGenero());
        step1Request.setPersonaCTNEWptpatrIndicadorExtranjero(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getPersonaIndicadorExtranjero());
        step1Request.setPersonaCTNEWptpatrRazonSocial(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getPersonaRazonSocial());
        step1Request.setPersonaCTNEWptpatrTieneEPSSanitas(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getPersonaTieneEPSSanitas());
        step1Request.setPersonaCTNEWptpatrRechazadoAfiliacion(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getPersonaRechazadoAfiliacion());
        step1Request.setPersonaCTNEWptpatrNombreCompleto(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getPersonadrvNombreCompleto());
        step1Request.setPersonaCTNEWptpatrCodigo(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getPersonaCodigo());
        instance = (PersonaC) personaCSrv.tNEWImplementation(step1Request).getInstance();

        /* Action 2: IF (ptSolicitud.ContratantePersona.TipoIdentificacion.NIT = false) */
        boolean ifCondition2 = personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getTipoIdentificacion().getTipoIdentificacionNIT().equals(false);
        if (ifCondition2) {
            for(Direccion step220Entity : repository.assocOperator022(personaCTNEWCONTRADESDEAEptSolicitud)) {
                com.keralty.aesolicitudes.viewmodel.direccionc.siu.TCREARRequest step20Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.TCREARRequest();
                step20Request.setDireccionCTCREARpagrDepartamentoCInstance(step220Entity.getDepartamento());
                step20Request.setDireccionCTCREARpagrMunicipioCInstance(step220Entity.getMunicipio());
                step20Request.setDireccionCTCREARpagrTipoDireccionCInstance(step220Entity.getTipoDireccion());
                step20Request.setDireccionCTCREARpagrPaisCInstance(step220Entity.getPais());
                step20Request.setDireccionCTCREARpagrPersonaCInstance(instance);
                step20Request.setDireccionCTCREARpatrDireccionCompleta(step220Entity.getDireccionDireccionCompleta());
                step20Request.setDireccionCTCREARpatrLocalidad(null);
                step20Request.setDireccionCTCREARpTelefonoFijo(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getPersonaTelefonoFijo());
                step20Request.setDireccionCTCREARpTelefonoCelular(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getPersonaTelefonoCelular());
                step20Request.setDireccionCTCREARpagrContratoCInstance(null);
                direccionCSrv.tCREARImplementation(step20Request);
            }
        } else {
            for(Direccion step221Entity : repository.assocOperator023(personaCTNEWCONTRADESDEAEptSolicitud)) {
                com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.TCREARRequest step21Request = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.TCREARRequest();
                step21Request.setDirSucursalCTCREARpagrMunicipioCInstance(step221Entity.getMunicipio());
                step21Request.setDirSucursalCTCREARpagrDepartamentoCInstance(step221Entity.getDepartamento());
                step21Request.setDirSucursalCTCREARpagrPaisCInstance(step221Entity.getPais());
                step21Request.setDirSucursalCTCREARpagrPersonaCInstance(instance);
                step21Request.setDirSucursalCTCREARpagrRegionalCInstance(null);
                step21Request.setDirSucursalCTCREARpatrCodLegalSucursal("1");
                step21Request.setDirSucursalCTCREARpatrNombre(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getPersonaRazonSocial());
                step21Request.setDirSucursalCTCREARpatrEsPrincipal(Boolean.TRUE);
                step21Request.setDirSucursalCTCREARpatrActiva(Boolean.TRUE);
                step21Request.setDirSucursalCTCREARpatrDireccion(step221Entity.getDireccionDireccionCompleta());
                step21Request.setDirSucursalCTCREARpatrMail(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getPersonaCorreoElectronico());
                step21Request.setDirSucursalCTCREARpTelefonoFijo(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getPersonaTelefonoFijo());
                step21Request.setDirSucursalCTCREARpTelefonoCelular(personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().getPersonaTelefonoCelular());
                dirSucursalCSrv.tCREARImplementation(step21Request);
            }
        }

        /* Action 3: IF (EXIST (ptSolicitud.ProteccionDatos) = true) */
        boolean ifCondition3 = repository.assocOperator028(personaCTNEWCONTRADESDEAEptSolicitud).equals(true);
        if (ifCondition3) {
            com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.CrearRequest step30Request = new com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.CrearRequest();
            step30Request.setProteccionDatosCcrearpagrProductoCInstance(personaCTNEWCONTRADESDEAEptSolicitud.getAesolicitudes().getProductoT());
            step30Request.setProteccionDatosCcrearpagrPersonaCInstance(instance);
            step30Request.setProteccionDatosCcrearpatrCodRol(personaCTNEWCONTRADESDEAEptSolicitud.getProteccionDatos().getProteccionDatosRol());
            step30Request.setProteccionDatosCcrearpatrInformacionSaludSMS(personaCTNEWCONTRADESDEAEptSolicitud.getProteccionDatos().getProteccionDatosSaludSMS());
            step30Request.setProteccionDatosCcrearpatrInformacionSaludEmail(personaCTNEWCONTRADESDEAEptSolicitud.getProteccionDatos().getProteccionDatosSaludEmail());
            step30Request.setProteccionDatosCcrearpatrIinformacionSaludCorreo(personaCTNEWCONTRADESDEAEptSolicitud.getProteccionDatos().getProteccionDatosSaludCorreo());
            step30Request.setProteccionDatosCcrearpatrInformacionPublicidadSMS(personaCTNEWCONTRADESDEAEptSolicitud.getProteccionDatos().getProteccionDatosPublicidadSMS());
            step30Request.setProteccionDatosCcrearpatrInformacionPublicidadEmai(personaCTNEWCONTRADESDEAEptSolicitud.getProteccionDatos().getProteccionDatosPublicidadEmail());
            step30Request.setProteccionDatosCcrearpatrInformacionPublicidadCorr(personaCTNEWCONTRADESDEAEptSolicitud.getProteccionDatos().getProteccionDatosPublicidadCorreo());
            step30Request.setProteccionDatosCcrearpatrInformacionTerceros(personaCTNEWCONTRADESDEAEptSolicitud.getProteccionDatos().getProteccionDatosInfoTerceros());
            step30Request.setProteccionDatosCcrearpatrRol(null);
            step30Request.setProteccionDatosCcrearpatrCodigo(Long.valueOf(1));
            proteccionDatosCSrv.crearImplementation(step30Request);
        }

        for(Usuario step4Entity : repository.assocOperator025(personaCTNEWCONTRADESDEAEptSolicitud)) {
            com.keralty.aesolicitudes.viewmodel.personac.siu.TCREAROCUESDEAERequest step4Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.TCREAROCUESDEAERequest();
            step4Request.setPersonaCTCREAROCUESDEAEpthisPersonaCInstance(instance);
            step4Request.setPersonaCTCREAROCUESDEAEpCuestionarioPInstance(step4Entity.getCuestionarioP());
            personaCSrv.tCREAROCUESDEAEImplementation(step4Request);
        }

        for(Usuario step5Entity : repository.assocOperator027(personaCTNEWCONTRADESDEAEptSolicitud)) {
            com.keralty.aesolicitudes.viewmodel.personac.siu.TCOPIARPREEXDEUSURequest step5Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.TCOPIARPREEXDEUSURequest();
            step5Request.setPersonaCTCOPIARPREEXDEUSUpthisPersonaCInstance(instance);
            step5Request.setPersonaCTCOPIARPREEXDEUSUpUsuarioInstance(step5Entity);
            personaCSrv.tCOPIARPREEXDEUSUImplementation(step5Request);
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TNEWTITULARDESDEAE

    /*
     * Entry point for service TNEWTITULARDESDEAE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tNEWTITULARDESDEAE(
            com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWTITULARDESDEAERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.tNEWTITULARDESDEAETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TNEWTITULARDESDEAE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tNEWTITULARDESDEAETxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWTITULARDESDEAERequest request) throws ModelException, SystemException {
        request.setPersonaCTNEWTITULARDESDEAEptSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getPersonaCTNEWTITULARDESDEAEptSolicitud()));
        request.setPersonaCTNEWTITULARDESDEAEptFamiliaCInstance(familiaCSrv.getByOIDWithHV(request.getPersonaCTNEWTITULARDESDEAEptFamiliaC()));
        return personaCSrv.tNEWTITULARDESDEAEImplementation(request);
    }

    /*
     * Implements service TNEWTITULARDESDEAE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tNEWTITULARDESDEAEImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWTITULARDESDEAERequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Solicitud personaCTNEWTITULARDESDEAEptSolicitud = request.getPersonaCTNEWTITULARDESDEAEptSolicitudInstance();
        FamiliaC personaCTNEWTITULARDESDEAEptFamiliaC = request.getPersonaCTNEWTITULARDESDEAEptFamiliaCInstance();

        request.checkArguments();
        PersonaC instance;

        com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWRequest step1Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWRequest();
        step1Request.setPersonaCTNEWptpagrTipoInstitucionCInstance(null);
        step1Request.setPersonaCTNEWptpagrTipoEntidadCInstance(null);
        step1Request.setPersonaCTNEWptpagrEstadoCivilCInstance(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getEstadoCivil());
        step1Request.setPersonaCTNEWptpagrEstadoPersonaCInstance(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getEstadoPersona());
        step1Request.setPersonaCTNEWptpagrTipoIdentificacionCInstance(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getTipoIdentificacion());
        step1Request.setPersonaCTNEWptpagrMunicipioCNacInstance(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getMunicipioNacimiento());
        step1Request.setPersonaCTNEWptpagrDepartamentoCNacInstance(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getDepartamentoNacimiento());
        step1Request.setPersonaCTNEWptpagrContratosCInstance(null);
        step1Request.setPersonaCTNEWptpagrFamiliasCInstance(personaCTNEWTITULARDESDEAEptFamiliaC);
        step1Request.setPersonaCTNEWptpagrBeneficiariosCInstance(null);
        step1Request.setPersonaCTNEWptpatrNumIdentificacion(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getPersonaNumIdentificacion());
        step1Request.setPersonaCTNEWptpatrMail(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getPersonaCorreoElectronico());
        step1Request.setPersonaCTNEWptpatrPrimerNombre(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getPersonaPrimerNombre());
        step1Request.setPersonaCTNEWptpatrSegundoNombre(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getPersonaSegundoNombre());
        step1Request.setPersonaCTNEWptpatrPrimerApellido(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getPersonaPrimerApellido());
        step1Request.setPersonaCTNEWptpatrSegundoApellido(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getPersonaSegundoApellido());
        step1Request.setPersonaCTNEWptpatrFechaNacimiento(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getPersonaFechaNacimiento());
        step1Request.setPersonaCTNEWptpatrGenero(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getPersonaGenero());
        step1Request.setPersonaCTNEWptpatrIndicadorExtranjero(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getPersonaIndicadorExtranjero());
        step1Request.setPersonaCTNEWptpatrRazonSocial(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getPersonaRazonSocial());
        step1Request.setPersonaCTNEWptpatrTieneEPSSanitas(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getPersonaTieneEPSSanitas());
        step1Request.setPersonaCTNEWptpatrRechazadoAfiliacion(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getPersonaRechazadoAfiliacion());
        step1Request.setPersonaCTNEWptpatrNombreCompleto(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getPersonadrvNombreCompleto());
        step1Request.setPersonaCTNEWptpatrCodigo(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getPersonaCodigo());
        instance = (PersonaC) personaCSrv.tNEWImplementation(step1Request).getInstance();

        /* Action 2: IF (ptSolicitud.TitularPersona.TipoIdentificacion.NIT = false) */
        boolean ifCondition2 = personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getTipoIdentificacion().getTipoIdentificacionNIT().equals(false);
        if (ifCondition2) {
            for(Direccion step220Entity : repository.assocOperator029(personaCTNEWTITULARDESDEAEptSolicitud)) {
                com.keralty.aesolicitudes.viewmodel.direccionc.siu.TCREARRequest step20Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.TCREARRequest();
                step20Request.setDireccionCTCREARpagrDepartamentoCInstance(step220Entity.getDepartamento());
                step20Request.setDireccionCTCREARpagrMunicipioCInstance(step220Entity.getMunicipio());
                step20Request.setDireccionCTCREARpagrTipoDireccionCInstance(step220Entity.getTipoDireccion());
                step20Request.setDireccionCTCREARpagrPaisCInstance(step220Entity.getPais());
                step20Request.setDireccionCTCREARpagrPersonaCInstance(instance);
                step20Request.setDireccionCTCREARpatrDireccionCompleta(step220Entity.getDireccionDireccionCompleta());
                step20Request.setDireccionCTCREARpatrLocalidad(null);
                step20Request.setDireccionCTCREARpTelefonoFijo(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getPersonaTelefonoFijo());
                step20Request.setDireccionCTCREARpTelefonoCelular(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getPersonaTelefonoCelular());
                step20Request.setDireccionCTCREARpagrContratoCInstance(null);
                direccionCSrv.tCREARImplementation(step20Request);
            }
        } else {
            for(Direccion step221Entity : repository.assocOperator030(personaCTNEWTITULARDESDEAEptSolicitud)) {
                com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.TCREARRequest step21Request = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.TCREARRequest();
                step21Request.setDirSucursalCTCREARpagrMunicipioCInstance(step221Entity.getMunicipio());
                step21Request.setDirSucursalCTCREARpagrDepartamentoCInstance(step221Entity.getDepartamento());
                step21Request.setDirSucursalCTCREARpagrPaisCInstance(step221Entity.getPais());
                step21Request.setDirSucursalCTCREARpagrPersonaCInstance(instance);
                step21Request.setDirSucursalCTCREARpagrRegionalCInstance(null);
                step21Request.setDirSucursalCTCREARpatrCodLegalSucursal("1");
                step21Request.setDirSucursalCTCREARpatrNombre(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getPersonaRazonSocial());
                step21Request.setDirSucursalCTCREARpatrEsPrincipal(Boolean.TRUE);
                step21Request.setDirSucursalCTCREARpatrActiva(Boolean.TRUE);
                step21Request.setDirSucursalCTCREARpatrDireccion(step221Entity.getDireccionDireccionCompleta());
                step21Request.setDirSucursalCTCREARpatrMail(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getPersonaCorreoElectronico());
                step21Request.setDirSucursalCTCREARpTelefonoFijo(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getPersonaTelefonoFijo());
                step21Request.setDirSucursalCTCREARpTelefonoCelular(personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().getPersonaTelefonoCelular());
                dirSucursalCSrv.tCREARImplementation(step21Request);
            }
        }

        /* Action 3: IF (EXIST (ptSolicitud.ProteccionDatos) = true) */
        boolean ifCondition3 = repository.assocOperator035(personaCTNEWTITULARDESDEAEptSolicitud).equals(true);
        if (ifCondition3) {
            com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.CrearRequest step30Request = new com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.CrearRequest();
            step30Request.setProteccionDatosCcrearpagrProductoCInstance(personaCTNEWTITULARDESDEAEptSolicitud.getAesolicitudes().getProductoT());
            step30Request.setProteccionDatosCcrearpagrPersonaCInstance(instance);
            step30Request.setProteccionDatosCcrearpatrCodRol(personaCTNEWTITULARDESDEAEptSolicitud.getProteccionDatos().getProteccionDatosRol());
            step30Request.setProteccionDatosCcrearpatrInformacionSaludSMS(personaCTNEWTITULARDESDEAEptSolicitud.getProteccionDatos().getProteccionDatosSaludSMS());
            step30Request.setProteccionDatosCcrearpatrInformacionSaludEmail(personaCTNEWTITULARDESDEAEptSolicitud.getProteccionDatos().getProteccionDatosSaludEmail());
            step30Request.setProteccionDatosCcrearpatrIinformacionSaludCorreo(personaCTNEWTITULARDESDEAEptSolicitud.getProteccionDatos().getProteccionDatosSaludCorreo());
            step30Request.setProteccionDatosCcrearpatrInformacionPublicidadSMS(personaCTNEWTITULARDESDEAEptSolicitud.getProteccionDatos().getProteccionDatosPublicidadSMS());
            step30Request.setProteccionDatosCcrearpatrInformacionPublicidadEmai(personaCTNEWTITULARDESDEAEptSolicitud.getProteccionDatos().getProteccionDatosPublicidadEmail());
            step30Request.setProteccionDatosCcrearpatrInformacionPublicidadCorr(personaCTNEWTITULARDESDEAEptSolicitud.getProteccionDatos().getProteccionDatosPublicidadCorreo());
            step30Request.setProteccionDatosCcrearpatrInformacionTerceros(personaCTNEWTITULARDESDEAEptSolicitud.getProteccionDatos().getProteccionDatosInfoTerceros());
            step30Request.setProteccionDatosCcrearpatrRol(null);
            step30Request.setProteccionDatosCcrearpatrCodigo(Long.valueOf(1));
            proteccionDatosCSrv.crearImplementation(step30Request);
        }

        for(Usuario step4Entity : repository.assocOperator032(personaCTNEWTITULARDESDEAEptSolicitud)) {
            com.keralty.aesolicitudes.viewmodel.personac.siu.TCREAROCUESDEAERequest step4Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.TCREAROCUESDEAERequest();
            step4Request.setPersonaCTCREAROCUESDEAEpthisPersonaCInstance(instance);
            step4Request.setPersonaCTCREAROCUESDEAEpCuestionarioPInstance(step4Entity.getCuestionarioP());
            personaCSrv.tCREAROCUESDEAEImplementation(step4Request);
        }

        for(Usuario step5Entity : repository.assocOperator034(personaCTNEWTITULARDESDEAEptSolicitud)) {
            com.keralty.aesolicitudes.viewmodel.personac.siu.TCOPIARPREEXDEUSURequest step5Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.TCOPIARPREEXDEUSURequest();
            step5Request.setPersonaCTCOPIARPREEXDEUSUpthisPersonaCInstance(instance);
            step5Request.setPersonaCTCOPIARPREEXDEUSUpUsuarioInstance(step5Entity);
            personaCSrv.tCOPIARPREEXDEUSUImplementation(step5Request);
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TNEWBENEFDESDEAE

    /*
     * Entry point for service TNEWBENEFDESDEAE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tNEWBENEFDESDEAE(
            com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWBENEFDESDEAERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.tNEWBENEFDESDEAETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TNEWBENEFDESDEAE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tNEWBENEFDESDEAETxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWBENEFDESDEAERequest request) throws ModelException, SystemException {
        request.setPersonaCTNEWBENEFDESDEAEptBeneficiarioInstance(beneficiarioCSrv.getByOIDWithHV(request.getPersonaCTNEWBENEFDESDEAEptBeneficiario()));
        request.setPersonaCTNEWBENEFDESDEAEptUsuarioInstance(usuarioSrv.getByOIDWithHV(request.getPersonaCTNEWBENEFDESDEAEptUsuario()));
        return personaCSrv.tNEWBENEFDESDEAEImplementation(request);
    }

    /*
     * Implements service TNEWBENEFDESDEAE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tNEWBENEFDESDEAEImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWBENEFDESDEAERequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Usuario personaCTNEWBENEFDESDEAEptUsuario = request.getPersonaCTNEWBENEFDESDEAEptUsuarioInstance();
        BeneficiarioC personaCTNEWBENEFDESDEAEptBeneficiario = request.getPersonaCTNEWBENEFDESDEAEptBeneficiarioInstance();

        request.checkArguments();
        PersonaC instance;

        com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWRequest step1Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWRequest();
        step1Request.setPersonaCTNEWptpagrTipoInstitucionCInstance(null);
        step1Request.setPersonaCTNEWptpagrTipoEntidadCInstance(null);
        step1Request.setPersonaCTNEWptpagrEstadoCivilCInstance(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getEstadoCivil());
        step1Request.setPersonaCTNEWptpagrEstadoPersonaCInstance(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getEstadoPersona());
        step1Request.setPersonaCTNEWptpagrTipoIdentificacionCInstance(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getTipoIdentificacion());
        step1Request.setPersonaCTNEWptpagrMunicipioCNacInstance(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getMunicipioNacimiento());
        step1Request.setPersonaCTNEWptpagrDepartamentoCNacInstance(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getDepartamentoNacimiento());
        step1Request.setPersonaCTNEWptpagrContratosCInstance(null);
        step1Request.setPersonaCTNEWptpagrFamiliasCInstance(null);
        step1Request.setPersonaCTNEWptpagrBeneficiariosCInstance(personaCTNEWBENEFDESDEAEptBeneficiario);
        step1Request.setPersonaCTNEWptpatrNumIdentificacion(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getPersonaNumIdentificacion());
        step1Request.setPersonaCTNEWptpatrMail(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getPersonaCorreoElectronico());
        step1Request.setPersonaCTNEWptpatrPrimerNombre(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getPersonaPrimerNombre());
        step1Request.setPersonaCTNEWptpatrSegundoNombre(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getPersonaSegundoNombre());
        step1Request.setPersonaCTNEWptpatrPrimerApellido(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getPersonaPrimerApellido());
        step1Request.setPersonaCTNEWptpatrSegundoApellido(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getPersonaSegundoApellido());
        step1Request.setPersonaCTNEWptpatrFechaNacimiento(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getPersonaFechaNacimiento());
        step1Request.setPersonaCTNEWptpatrGenero(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getPersonaGenero());
        step1Request.setPersonaCTNEWptpatrIndicadorExtranjero(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getPersonaIndicadorExtranjero());
        step1Request.setPersonaCTNEWptpatrRazonSocial(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getPersonaRazonSocial());
        step1Request.setPersonaCTNEWptpatrTieneEPSSanitas(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getPersonaTieneEPSSanitas());
        step1Request.setPersonaCTNEWptpatrRechazadoAfiliacion(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getPersonaRechazadoAfiliacion());
        step1Request.setPersonaCTNEWptpatrNombreCompleto(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getPersonadrvNombreCompleto());
        step1Request.setPersonaCTNEWptpatrCodigo(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getPersonaCodigo());
        instance = (PersonaC) personaCSrv.tNEWImplementation(step1Request).getInstance();

        for(Direccion step2Entity : repository.assocOperator036(personaCTNEWBENEFDESDEAEptUsuario)) {
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.TCREARRequest step2Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.TCREARRequest();
            step2Request.setDireccionCTCREARpagrDepartamentoCInstance(step2Entity.getDepartamento());
            step2Request.setDireccionCTCREARpagrMunicipioCInstance(step2Entity.getMunicipio());
            step2Request.setDireccionCTCREARpagrTipoDireccionCInstance(step2Entity.getTipoDireccion());
            step2Request.setDireccionCTCREARpagrPaisCInstance(step2Entity.getPais());
            step2Request.setDireccionCTCREARpagrPersonaCInstance(instance);
            step2Request.setDireccionCTCREARpatrDireccionCompleta(step2Entity.getDireccionDireccionCompleta());
            step2Request.setDireccionCTCREARpatrLocalidad(null);
            step2Request.setDireccionCTCREARpTelefonoFijo(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getPersonaTelefonoFijo());
            step2Request.setDireccionCTCREARpTelefonoCelular(personaCTNEWBENEFDESDEAEptUsuario.getUsuarioPersona().getPersonaTelefonoCelular());
            step2Request.setDireccionCTCREARpagrContratoCInstance(null);
            direccionCSrv.tCREARImplementation(step2Request);
        }

        /* Action 3: IF (EXIST (ptUsuario.Solicitud.ProteccionDatos) = true) */
        boolean ifCondition3 = repository.assocOperator039(personaCTNEWBENEFDESDEAEptUsuario).equals(true);
        if (ifCondition3) {
            com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.CrearRequest step30Request = new com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu.CrearRequest();
            step30Request.setProteccionDatosCcrearpagrProductoCInstance(personaCTNEWBENEFDESDEAEptUsuario.getSolicitud().getAesolicitudes().getProductoT());
            step30Request.setProteccionDatosCcrearpagrPersonaCInstance(instance);
            step30Request.setProteccionDatosCcrearpatrCodRol(personaCTNEWBENEFDESDEAEptUsuario.getSolicitud().getProteccionDatos().getProteccionDatosRol());
            step30Request.setProteccionDatosCcrearpatrInformacionSaludSMS(personaCTNEWBENEFDESDEAEptUsuario.getSolicitud().getProteccionDatos().getProteccionDatosSaludSMS());
            step30Request.setProteccionDatosCcrearpatrInformacionSaludEmail(personaCTNEWBENEFDESDEAEptUsuario.getSolicitud().getProteccionDatos().getProteccionDatosSaludEmail());
            step30Request.setProteccionDatosCcrearpatrIinformacionSaludCorreo(personaCTNEWBENEFDESDEAEptUsuario.getSolicitud().getProteccionDatos().getProteccionDatosSaludCorreo());
            step30Request.setProteccionDatosCcrearpatrInformacionPublicidadSMS(personaCTNEWBENEFDESDEAEptUsuario.getSolicitud().getProteccionDatos().getProteccionDatosPublicidadSMS());
            step30Request.setProteccionDatosCcrearpatrInformacionPublicidadEmai(personaCTNEWBENEFDESDEAEptUsuario.getSolicitud().getProteccionDatos().getProteccionDatosPublicidadEmail());
            step30Request.setProteccionDatosCcrearpatrInformacionPublicidadCorr(personaCTNEWBENEFDESDEAEptUsuario.getSolicitud().getProteccionDatos().getProteccionDatosPublicidadCorreo());
            step30Request.setProteccionDatosCcrearpatrInformacionTerceros(personaCTNEWBENEFDESDEAEptUsuario.getSolicitud().getProteccionDatos().getProteccionDatosInfoTerceros());
            step30Request.setProteccionDatosCcrearpatrRol(null);
            step30Request.setProteccionDatosCcrearpatrCodigo(Long.valueOf(1));
            proteccionDatosCSrv.crearImplementation(step30Request);
        }

        for(CuestionarioP step4Entity : repository.assocOperator038(personaCTNEWBENEFDESDEAEptUsuario)) {
            com.keralty.aesolicitudes.viewmodel.personac.siu.TCREAROCUESDEAERequest step4Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.TCREAROCUESDEAERequest();
            step4Request.setPersonaCTCREAROCUESDEAEpthisPersonaCInstance(instance);
            step4Request.setPersonaCTCREAROCUESDEAEpCuestionarioPInstance(step4Entity);
            personaCSrv.tCREAROCUESDEAEImplementation(step4Request);
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TNEW

    /*
     * Entry point for service TNEW
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tNEW(
            com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.tNEWTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TNEW
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tNEWTxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWRequest request) throws ModelException {
        request.setPersonaCTNEWptpagrTipoInstitucionCInstance(tipoInstitucionCSrv.getByOIDWithHV(request.getPersonaCTNEWptpagrTipoInstitucionC()));
        request.setPersonaCTNEWptpagrTipoEntidadCInstance(tipoEntidadCSrv.getByOIDWithHV(request.getPersonaCTNEWptpagrTipoEntidadC()));
        request.setPersonaCTNEWptpagrEstadoCivilCInstance(estadoCivilSrv.getByOIDWithHV(request.getPersonaCTNEWptpagrEstadoCivilC()));
        request.setPersonaCTNEWptpagrEstadoPersonaCInstance(estadoPersonaSrv.getByOIDWithHV(request.getPersonaCTNEWptpagrEstadoPersonaC()));
        request.setPersonaCTNEWptpagrTipoIdentificacionCInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getPersonaCTNEWptpagrTipoIdentificacionC()));
        request.setPersonaCTNEWptpagrMunicipioCNacInstance(municipioSrv.getByOIDWithHV(request.getPersonaCTNEWptpagrMunicipioCNac()));
        request.setPersonaCTNEWptpagrDepartamentoCNacInstance(departamentoSrv.getByOIDWithHV(request.getPersonaCTNEWptpagrDepartamentoCNac()));
        request.setPersonaCTNEWptpagrContratosCInstance(contratoCSrv.getByOIDWithHV(request.getPersonaCTNEWptpagrContratosC()));
        request.setPersonaCTNEWptpagrFamiliasCInstance(familiaCSrv.getByOIDWithHV(request.getPersonaCTNEWptpagrFamiliasC()));
        request.setPersonaCTNEWptpagrBeneficiariosCInstance(beneficiarioCSrv.getByOIDWithHV(request.getPersonaCTNEWptpagrBeneficiariosC()));
        return personaCSrv.tNEWImplementation(request);
    }

    /*
     * Implements service TNEW
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tNEWImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoInstitucionC personaCTNEWptpagrTipoInstitucionC = request.getPersonaCTNEWptpagrTipoInstitucionCInstance();
        TipoEntidadC personaCTNEWptpagrTipoEntidadC = request.getPersonaCTNEWptpagrTipoEntidadCInstance();
        EstadoCivil personaCTNEWptpagrEstadoCivilC = request.getPersonaCTNEWptpagrEstadoCivilCInstance();
        EstadoPersona personaCTNEWptpagrEstadoPersonaC = request.getPersonaCTNEWptpagrEstadoPersonaCInstance();
        TipoIdentificacion personaCTNEWptpagrTipoIdentificacionC = request.getPersonaCTNEWptpagrTipoIdentificacionCInstance();
        Municipio personaCTNEWptpagrMunicipioCNac = request.getPersonaCTNEWptpagrMunicipioCNacInstance();
        Departamento personaCTNEWptpagrDepartamentoCNac = request.getPersonaCTNEWptpagrDepartamentoCNacInstance();
        ContratoC personaCTNEWptpagrContratosC = request.getPersonaCTNEWptpagrContratosCInstance();
        FamiliaC personaCTNEWptpagrFamiliasC = request.getPersonaCTNEWptpagrFamiliasCInstance();
        BeneficiarioC personaCTNEWptpagrBeneficiariosC = request.getPersonaCTNEWptpagrBeneficiariosCInstance();
        String personaCTNEWptpatrNumIdentificacion = request.getPersonaCTNEWptpatrNumIdentificacion();
        String personaCTNEWptpatrMail = request.getPersonaCTNEWptpatrMail();
        String personaCTNEWptpatrPrimerNombre = request.getPersonaCTNEWptpatrPrimerNombre();
        String personaCTNEWptpatrSegundoNombre = request.getPersonaCTNEWptpatrSegundoNombre();
        String personaCTNEWptpatrPrimerApellido = request.getPersonaCTNEWptpatrPrimerApellido();
        String personaCTNEWptpatrSegundoApellido = request.getPersonaCTNEWptpatrSegundoApellido();
        Date personaCTNEWptpatrFechaNacimiento = request.getPersonaCTNEWptpatrFechaNacimiento();
        String personaCTNEWptpatrGenero = request.getPersonaCTNEWptpatrGenero();
        Boolean personaCTNEWptpatrIndicadorExtranjero = request.getPersonaCTNEWptpatrIndicadorExtranjero();
        String personaCTNEWptpatrRazonSocial = request.getPersonaCTNEWptpatrRazonSocial();
        Boolean personaCTNEWptpatrTieneEPSSanitas = request.getPersonaCTNEWptpatrTieneEPSSanitas();
        String personaCTNEWptpatrRechazadoAfiliacion = request.getPersonaCTNEWptpatrRechazadoAfiliacion();
        String personaCTNEWptpatrNombreCompleto = request.getPersonaCTNEWptpatrNombreCompleto();
        Long personaCTNEWptpatrCodigo = request.getPersonaCTNEWptpatrCodigo();

        request.checkArguments();
        PersonaC instance;

        com.keralty.aesolicitudes.viewmodel.personac.siu.CrearRequest step1Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.CrearRequest();
        step1Request.setPersonaCcrearpagrTipoInstitucionCInstance(personaCTNEWptpagrTipoInstitucionC);
        step1Request.setPersonaCcrearpagrTipoEntidadCInstance(personaCTNEWptpagrTipoEntidadC);
        step1Request.setPersonaCcrearpagrEstadoCivilCInstance(personaCTNEWptpagrEstadoCivilC);
        step1Request.setPersonaCcrearpagrEstadoPersonaCInstance(personaCTNEWptpagrEstadoPersonaC);
        step1Request.setPersonaCcrearpagrTipoIdentificacionCInstance(personaCTNEWptpagrTipoIdentificacionC);
        step1Request.setPersonaCcrearpagrMunicipioCNacInstance(personaCTNEWptpagrMunicipioCNac);
        step1Request.setPersonaCcrearpagrDepartamentoCNacInstance(personaCTNEWptpagrDepartamentoCNac);
        step1Request.setPersonaCcrearpagrContratosCInstance(personaCTNEWptpagrContratosC);
        step1Request.setPersonaCcrearpagrFamiliasCInstance(personaCTNEWptpagrFamiliasC);
        step1Request.setPersonaCcrearpagrBeneficiariosCInstance(personaCTNEWptpagrBeneficiariosC);
        step1Request.setPersonaCcrearpatrNumIdentificacion(personaCTNEWptpatrNumIdentificacion);
        step1Request.setPersonaCcrearpatrMail(personaCTNEWptpatrMail);
        step1Request.setPersonaCcrearpatrPrimerNombre(personaCTNEWptpatrPrimerNombre);
        step1Request.setPersonaCcrearpatrSegundoNombre(personaCTNEWptpatrSegundoNombre);
        step1Request.setPersonaCcrearpatrPrimerApellido(personaCTNEWptpatrPrimerApellido);
        step1Request.setPersonaCcrearpatrSegundoApellido(personaCTNEWptpatrSegundoApellido);
        step1Request.setPersonaCcrearpatrFechaNacimiento(personaCTNEWptpatrFechaNacimiento);
        step1Request.setPersonaCcrearpatrGenero(personaCTNEWptpatrGenero);
        step1Request.setPersonaCcrearpatrIndicadorExtranjero(personaCTNEWptpatrIndicadorExtranjero);
        step1Request.setPersonaCcrearpatrRazonSocial(personaCTNEWptpatrRazonSocial);
        step1Request.setPersonaCcrearpatrTieneEPSSanitas(personaCTNEWptpatrTieneEPSSanitas);
        step1Request.setPersonaCcrearpatrRechazadoAfiliacion(personaCTNEWptpatrRechazadoAfiliacion);
        step1Request.setPersonaCcrearpatrNombreCompleto(personaCTNEWptpatrNombreCompleto);
        step1Request.setPersonaCcrearpatrCodigo(personaCTNEWptpatrCodigo);
        step1Request.setPersonaCcrearpatrUltimaActualizacion(STDFunctions.systemDateTimeFun());
        instance = (PersonaC) personaCSrv.crearImplementation(step1Request).getInstance();

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
            com.keralty.aesolicitudes.viewmodel.personac.siu.TMODIFICARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.tMODIFICARTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.TMODIFICARRequest request) throws ModelException {
        request.setPersonaCTMODIFICARpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCTMODIFICARpthisPersonaC()));
        request.setPersonaCTMODIFICARptpevcTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getPersonaCTMODIFICARptpevcTipoIdentificacion()));
        return personaCSrv.tMODIFICARImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.personac.siu.TMODIFICARRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        String personaCTMODIFICARptpeNombreCompleto = request.getPersonaCTMODIFICARptpeNombreCompleto();
        String personaCTMODIFICARptpeNumIdent = request.getPersonaCTMODIFICARptpeNumIdent();
        TipoIdentificacion personaCTMODIFICARptpevcTipoIdentificacion = request.getPersonaCTMODIFICARptpevcTipoIdentificacionInstance();
        PersonaC personaCTMODIFICARpthisPersonaC = request.getPersonaCTMODIFICARpthisPersonaCInstance();

        request.checkArguments();
        PersonaC instance = personaCTMODIFICARpthisPersonaC;

        com.keralty.aesolicitudes.viewmodel.personac.siu.EvalPostNotificarRequest step1Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.EvalPostNotificarRequest();
        step1Request.setPersonaCevalPostNotificarpthisPersonaCInstance(personaCTMODIFICARpthisPersonaC);
        step1Request.setPersonaCevalPostNotificarpeNombreCompleto(personaCTMODIFICARptpeNombreCompleto);
        step1Request.setPersonaCevalPostNotificarpeNumIdent(personaCTMODIFICARptpeNumIdent);
        personaCSrv.evalPostNotificarImplementation(step1Request);

        /* Action 2: IF (TipoIdentificacionC <> ptpevcTipoIdentificacion) */
        boolean ifCondition2 = !Utilities.isEqual(personaCTMODIFICARpthisPersonaC.getTipoIdentificacionC(), personaCTMODIFICARptpevcTipoIdentificacion);
        if (ifCondition2) {
            com.keralty.aesolicitudes.viewmodel.personac.siu.CambTipoIdentificacionCRequest step20Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.CambTipoIdentificacionCRequest();
            step20Request.setPersonaCCambTipoIdentificacionCpthisPersonaCInstance(personaCTMODIFICARpthisPersonaC);
            step20Request.setPersonaCCambTipoIdentificacionCpevcTipoIdentificacionInstance(personaCTMODIFICARptpevcTipoIdentificacion);
            personaCSrv.cambTipoIdentificacionCImplementation(step20Request, true);
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TCOPIARPREEXDEUSU

    /*
     * Entry point for service TCOPIARPREEXDEUSU
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCOPIARPREEXDEUSU(
            com.keralty.aesolicitudes.viewmodel.personac.siu.TCOPIARPREEXDEUSURequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = personaCSrv.tCOPIARPREEXDEUSUTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCOPIARPREEXDEUSU
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCOPIARPREEXDEUSUTxn(
            com.keralty.aesolicitudes.viewmodel.personac.siu.TCOPIARPREEXDEUSURequest request) throws ModelException, SystemException {
        request.setPersonaCTCOPIARPREEXDEUSUpthisPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPersonaCTCOPIARPREEXDEUSUpthisPersonaC()));
        request.setPersonaCTCOPIARPREEXDEUSUpUsuarioInstance(usuarioSrv.getByOIDWithHV(request.getPersonaCTCOPIARPREEXDEUSUpUsuario()));
        return personaCSrv.tCOPIARPREEXDEUSUImplementation(request);
    }

    /*
     * Implements service TCOPIARPREEXDEUSU
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCOPIARPREEXDEUSUImplementation(
            com.keralty.aesolicitudes.viewmodel.personac.siu.TCOPIARPREEXDEUSURequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Usuario personaCTCOPIARPREEXDEUSUpUsuario = request.getPersonaCTCOPIARPREEXDEUSUpUsuarioInstance();
        PersonaC personaCTCOPIARPREEXDEUSUpthisPersonaC = request.getPersonaCTCOPIARPREEXDEUSUpthisPersonaCInstance();

        request.checkArguments();
        PersonaC instance = personaCTCOPIARPREEXDEUSUpthisPersonaC;

        for(Preexistencia step1Entity : repository.assocOperator040(personaCTCOPIARPREEXDEUSUpthisPersonaC, personaCTCOPIARPREEXDEUSUpUsuario)) {
            com.keralty.aesolicitudes.viewmodel.preexistenciac.siu.CrearRequest step1Request = new com.keralty.aesolicitudes.viewmodel.preexistenciac.siu.CrearRequest();
            step1Request.setPreexistenciaCcrearpagrPersonaCInstance(personaCTCOPIARPREEXDEUSUpthisPersonaC);
            step1Request.setPreexistenciaCcrearpatrDescripcion(step1Entity.getPreexistenciaDescripcion());
            step1Request.setPreexistenciaCcrearpatrFecInicio(step1Entity.getPreexistenciaFecInicio());
            step1Request.setPreexistenciaCcrearpatrFecFin(step1Entity.getPreexistenciaFecFin());
            step1Request.setPreexistenciaCcrearpatrObservacion(step1Entity.getPreexistenciaObservacion());
            preexistenciaCSrv.crearImplementation(step1Request);
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
        select.getOrderByPart().addItem(Constants.normalizePath(PersonaCConstants.CLASS_NAME, PersonaCConstants.ATTR_FIELD_PERSONACID, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildPersonaCRelatedInstance(relatedInstanceJsonOid);
        }
        if (PersonaCConstants.ROLE_NAME_DIRECCIONESC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPersonaCRelatedInstance4DireccionC(relatedInstanceJsonOid, remainingPath);
        }
        if (PersonaCConstants.ROLE_NAME_PROTECCIONESDATOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPersonaCRelatedInstance4ProteccionDatosC(relatedInstanceJsonOid, remainingPath);
        }
        if (PersonaCConstants.ROLE_NAME_PREGSCUESMEDC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPersonaCRelatedInstance4PregCuesMedC(relatedInstanceJsonOid, remainingPath);
        }
        if (PersonaCConstants.ROLE_NAME_DIRSUCURSALESC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPersonaCRelatedInstance4DirSucursalC(relatedInstanceJsonOid, remainingPath);
        }
        if (PersonaCConstants.ROLE_NAME_PREEXISTENCIASC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPersonaCRelatedInstance4PreexistenciaC(relatedInstanceJsonOid, remainingPath);
        }
        if (PersonaCConstants.ROLE_NAME_MARCASMEDICASC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPersonaCRelatedInstance4MarcaMedicaC(relatedInstanceJsonOid, remainingPath);
        }
        if (PersonaCConstants.ROLE_NAME_TIPOINSTITUCIONC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPersonaCRelatedInstance4TipoInstitucionC(relatedInstanceJsonOid, remainingPath);
        }
        if (PersonaCConstants.ROLE_NAME_TIPOENTIDADC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPersonaCRelatedInstance4TipoEntidadC(relatedInstanceJsonOid, remainingPath);
        }
        if (PersonaCConstants.ROLE_NAME_ESTADOCIVILC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPersonaCRelatedInstance4EstadoCivil(relatedInstanceJsonOid, remainingPath);
        }
        if (PersonaCConstants.ROLE_NAME_ESTADOPERSONAC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPersonaCRelatedInstance4EstadoPersona(relatedInstanceJsonOid, remainingPath);
        }
        if (PersonaCConstants.ROLE_NAME_TIPOIDENTIFICACIONC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPersonaCRelatedInstance4TipoIdentificacion(relatedInstanceJsonOid, remainingPath);
        }
        if (PersonaCConstants.ROLE_NAME_MUNICIPIOCNAC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPersonaCRelatedInstance4Municipio(relatedInstanceJsonOid, remainingPath);
        }
        if (PersonaCConstants.ROLE_NAME_DEPARTAMENTOCNAC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPersonaCRelatedInstance4Departamento(relatedInstanceJsonOid, remainingPath);
        }
        if (PersonaCConstants.ROLE_NAME_CONTRATOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPersonaCRelatedInstance4ContratoC(relatedInstanceJsonOid, remainingPath);
        }
        if (PersonaCConstants.ROLE_NAME_FAMILIASC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPersonaCRelatedInstance4FamiliaC(relatedInstanceJsonOid, remainingPath);
        }
        if (PersonaCConstants.ROLE_NAME_BENEFICIARIOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPersonaCRelatedInstance4BeneficiarioC(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildPersonaCRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new PersonaC(mapper.readValue(relatedInstanceJsonOid, PersonaCOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPersonaCRelatedInstance4DireccionC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new DireccionC(mapper.readValue(relatedInstanceJsonOid, DireccionCOid.class)): DireccionC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPersonaCRelatedInstance4ProteccionDatosC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ProteccionDatosC(mapper.readValue(relatedInstanceJsonOid, ProteccionDatosCOid.class)): ProteccionDatosC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPersonaCRelatedInstance4PregCuesMedC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new PregCuesMedC(mapper.readValue(relatedInstanceJsonOid, PregCuesMedCOid.class)): PregCuesMedC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPersonaCRelatedInstance4DirSucursalC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new DirSucursalC(mapper.readValue(relatedInstanceJsonOid, DirSucursalCOid.class)): DirSucursalC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPersonaCRelatedInstance4PreexistenciaC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new PreexistenciaC(mapper.readValue(relatedInstanceJsonOid, PreexistenciaCOid.class)): PreexistenciaC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPersonaCRelatedInstance4MarcaMedicaC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new MarcaMedicaC(mapper.readValue(relatedInstanceJsonOid, MarcaMedicaCOid.class)): MarcaMedicaC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPersonaCRelatedInstance4TipoInstitucionC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TipoInstitucionC(mapper.readValue(relatedInstanceJsonOid, TipoInstitucionCOid.class)): TipoInstitucionC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPersonaCRelatedInstance4TipoEntidadC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TipoEntidadC(mapper.readValue(relatedInstanceJsonOid, TipoEntidadCOid.class)): TipoEntidadC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPersonaCRelatedInstance4EstadoCivil(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new EstadoCivil(mapper.readValue(relatedInstanceJsonOid, EstadoCivilOid.class)): EstadoCivil.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPersonaCRelatedInstance4EstadoPersona(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new EstadoPersona(mapper.readValue(relatedInstanceJsonOid, EstadoPersonaOid.class)): EstadoPersona.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPersonaCRelatedInstance4TipoIdentificacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TipoIdentificacion(mapper.readValue(relatedInstanceJsonOid, TipoIdentificacionOid.class)): TipoIdentificacion.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPersonaCRelatedInstance4Municipio(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Municipio(mapper.readValue(relatedInstanceJsonOid, MunicipioOid.class)): Municipio.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPersonaCRelatedInstance4Departamento(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Departamento(mapper.readValue(relatedInstanceJsonOid, DepartamentoOid.class)): Departamento.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPersonaCRelatedInstance4ContratoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ContratoC(mapper.readValue(relatedInstanceJsonOid, ContratoCOid.class)): ContratoC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPersonaCRelatedInstance4FamiliaC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new FamiliaC(mapper.readValue(relatedInstanceJsonOid, FamiliaCOid.class)): FamiliaC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPersonaCRelatedInstance4BeneficiarioC(String relatedInstanceJsonOid, String remainingPath) {
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
            PersonaCOid oid = new PersonaCOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(PersonaCConstants.ATTR_FIELD_PERSONACID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getPersonaCID(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(PersonaCService.class).error(e.getMessage());
        }
    }

}
