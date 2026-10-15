package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.MinCardinalityException;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.global.STDFunctions;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.Asesor;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.EstadoContrato;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.FormaPago;
import com.keralty.aesolicitudes.persistence.GrupoAsociado;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.ObservacionesC;
import com.keralty.aesolicitudes.persistence.oid.AsesorOid;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoContratoOid;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;
import com.keralty.aesolicitudes.persistence.oid.FormaPagoOid;
import com.keralty.aesolicitudes.persistence.oid.GrupoAsociadoOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;
import com.keralty.aesolicitudes.persistence.oid.ObservacionesCOid;
import com.keralty.aesolicitudes.persistence.oid.PeriodicidadOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.PlanesOid;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.oid.SucursalOid;
import com.keralty.aesolicitudes.persistence.oid.TarifaOid;
import com.keralty.aesolicitudes.persistence.oid.TipoIdentificacionOid;
import com.keralty.aesolicitudes.persistence.Periodicidad;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Planes;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.Sucursal;
import com.keralty.aesolicitudes.persistence.Tarifa;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.repository.ContratoCJpaRepository;
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
public class ContratoCService extends AbstractService {

    ContratoCJpaRepository repository;

    ContratoCService contratoCSrv;

    PersonaCService personaCSrv;

    PeriodicidadService periodicidadSrv;

    FormaPagoService formaPagoSrv;

    EstadoContratoService estadoContratoSrv;

    ProductosService productosSrv;

    PlanesService planesSrv;

    TarifaService tarifaSrv;

    GrupoAsociadoService grupoAsociadoSrv;

    MunicipioService municipioSrv;

    SucursalService sucursalSrv;

    SolicitudService solicitudSrv;

    ObservacionesCService observacionesCSrv;

    DireccionService direccionSrv;

    DireccionCService direccionCSrv;

    TipoDireccionService tipoDireccionSrv;

    DepartamentoService departamentoSrv;

    PaisService paisSrv;

    ContratanteService contratanteSrv;

    FamiliaCService familiaCSrv;

    AesolicitudesService aesolicitudesSrv;

    TipoIdentificacionService tipoIdentificacionSrv;

    BeneficiarioCService beneficiarioCSrv;

    UserFunctions userFunctionsSrv;

    @Inject
    public ContratoCService(
            ContratoCService contratoCSrv,
            PersonaCService personaCSrv,
            PeriodicidadService periodicidadSrv,
            FormaPagoService formaPagoSrv,
            EstadoContratoService estadoContratoSrv,
            ProductosService productosSrv,
            PlanesService planesSrv,
            TarifaService tarifaSrv,
            GrupoAsociadoService grupoAsociadoSrv,
            MunicipioService municipioSrv,
            SucursalService sucursalSrv,
            SolicitudService solicitudSrv,
            ObservacionesCService observacionesCSrv,
            DireccionService direccionSrv,
            DireccionCService direccionCSrv,
            TipoDireccionService tipoDireccionSrv,
            DepartamentoService departamentoSrv,
            PaisService paisSrv,
            ContratanteService contratanteSrv,
            FamiliaCService familiaCSrv,
            AesolicitudesService aesolicitudesSrv,
            TipoIdentificacionService tipoIdentificacionSrv,
            BeneficiarioCService beneficiarioCSrv,
            UserFunctions userFunctionsSrv,
            ContratoCJpaRepository repository) {
        this.contratoCSrv = contratoCSrv;
        this.personaCSrv = personaCSrv;
        this.periodicidadSrv = periodicidadSrv;
        this.formaPagoSrv = formaPagoSrv;
        this.estadoContratoSrv = estadoContratoSrv;
        this.productosSrv = productosSrv;
        this.planesSrv = planesSrv;
        this.tarifaSrv = tarifaSrv;
        this.grupoAsociadoSrv = grupoAsociadoSrv;
        this.municipioSrv = municipioSrv;
        this.sucursalSrv = sucursalSrv;
        this.solicitudSrv = solicitudSrv;
        this.observacionesCSrv = observacionesCSrv;
        this.direccionSrv = direccionSrv;
        this.direccionCSrv = direccionCSrv;
        this.tipoDireccionSrv = tipoDireccionSrv;
        this.departamentoSrv = departamentoSrv;
        this.paisSrv = paisSrv;
        this.contratanteSrv = contratanteSrv;
        this.familiaCSrv = familiaCSrv;
        this.aesolicitudesSrv = aesolicitudesSrv;
        this.tipoIdentificacionSrv = tipoIdentificacionSrv;
        this.beneficiarioCSrv = beneficiarioCSrv;
        this.userFunctionsSrv = userFunctionsSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, ContratoCConstants.CLASS_NAME);
    }

    private List<ContratoC> solveContratoCTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, ContratoCConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveContratoCTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, ContratoCConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class ContratoC
     *
     * @return Population of class ContratoC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ContratoC> get() {
        List<ContratoC> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class ContratoC that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class ContratoC matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ContratoC> get(QueryRequest queryRequest) {
        return solveContratoCTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveContratoCTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveContratoCTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveContratoCTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of ContratoC by ID
     *
     * @param contratoCID Identification field contratoCID
     *
     * @return Instance of ContratoC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ContratoC getById(Long contratoCID) {
        return getByOID(new ContratoCOid(contratoCID));
    }
    
    /*
     * Returns an instance of ContratoC by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ContratoC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ContratoC getByOID(ContratoCOid oid) {
        Optional<ContratoC> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of ContratoC by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ContratoC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public ContratoC getByOIDWithHV(ContratoCOid oid) {
        Optional<ContratoC> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<ContratoC> getInstanceByOid(ContratoCOid oid) {
        return oid != null && oid.getContratoCID() != null
               ? repository.findById(oid.getContratoCID())
               : Optional.empty();
    }

    /*
     * Returns an instance of ContratoC by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of ContratoC
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public ContratoC getByJsonOid(String jsonOid) {
        ContratoCOid oid = new ContratoCOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of ContratoC related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ContratoC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ContratoC> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveContratoCTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of ContratoC related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ContratoC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ContratoC> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of ContratoC
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of ContratoC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getContratoCDynamic(ContratoCOid oid, String displaySetItems) {
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
    public String getSuppInfo(ContratoCOid oid, String dsName) {
        ContratoC instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(ContratoC instance, String dsName) {
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.crearTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.CrearRequest request) throws ModelException {
        request.setContratoCcrearpagrPersonaCContratanteInstance(personaCSrv.getByOIDWithHV(request.getContratoCcrearpagrPersonaCContratante()));
        request.setContratoCcrearpagrPeriodicidadCInstance(periodicidadSrv.getByOIDWithHV(request.getContratoCcrearpagrPeriodicidadC()));
        request.setContratoCcrearpagrFormaPagoCInstance(formaPagoSrv.getByOIDWithHV(request.getContratoCcrearpagrFormaPagoC()));
        request.setContratoCcrearpagrEstadoContratoCInstance(estadoContratoSrv.getByOIDWithHV(request.getContratoCcrearpagrEstadoContratoC()));
        request.setContratoCcrearpagrProductoCInstance(productosSrv.getByOIDWithHV(request.getContratoCcrearpagrProductoC()));
        request.setContratoCcrearpagrPlanCInstance(planesSrv.getByOIDWithHV(request.getContratoCcrearpagrPlanC()));
        request.setContratoCcrearpagrTarifaCInstance(tarifaSrv.getByOIDWithHV(request.getContratoCcrearpagrTarifaC()));
        request.setContratoCcrearpagrGrupoAsociadoCInstance(grupoAsociadoSrv.getByOIDWithHV(request.getContratoCcrearpagrGrupoAsociadoC()));
        request.setContratoCcrearpagrMunicipioCInstance(municipioSrv.getByOIDWithHV(request.getContratoCcrearpagrMunicipioC()));
        request.setContratoCcrearpagrSucursalCInstance(sucursalSrv.getByOIDWithHV(request.getContratoCcrearpagrSucursalC()));
        request.setContratoCcrearpagrAsesorCInstance(asesorSrv.getByOIDWithHV(request.getContratoCcrearpagrAsesorC()));
        return contratoCSrv.crearImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Periodicidad contratoCcrearpagrPeriodicidadC = request.getContratoCcrearpagrPeriodicidadCInstance();
        FormaPago contratoCcrearpagrFormaPagoC = request.getContratoCcrearpagrFormaPagoCInstance();
        EstadoContrato contratoCcrearpagrEstadoContratoC = request.getContratoCcrearpagrEstadoContratoCInstance();
        Productos contratoCcrearpagrProductoC = request.getContratoCcrearpagrProductoCInstance();
        Planes contratoCcrearpagrPlanC = request.getContratoCcrearpagrPlanCInstance();
        Tarifa contratoCcrearpagrTarifaC = request.getContratoCcrearpagrTarifaCInstance();
        GrupoAsociado contratoCcrearpagrGrupoAsociadoC = request.getContratoCcrearpagrGrupoAsociadoCInstance();
        Municipio contratoCcrearpagrMunicipioC = request.getContratoCcrearpagrMunicipioCInstance();
        Sucursal contratoCcrearpagrSucursalC = request.getContratoCcrearpagrSucursalCInstance();
        Asesor contratoCcrearpagrAsesorC = request.getContratoCcrearpagrAsesorCInstance();
        String contratoCcrearpatrNumSolicitud = request.getContratoCcrearpatrNumSolicitud();
        Date contratoCcrearpatrFechaSolicitud = request.getContratoCcrearpatrFechaSolicitud();
        Long contratoCcrearpatrTipoContrato = request.getContratoCcrearpatrTipoContrato();
        Date contratoCcrearpatrFechaIniVigencia = request.getContratoCcrearpatrFechaIniVigencia();
        String contratoCcrearpatrDireccion = request.getContratoCcrearpatrDireccion();
        String contratoCcrearpatrcorreoContratante = request.getContratoCcrearpatrcorreoContratante();
        String contratoCcrearpatrnumTelContratante = request.getContratoCcrearpatrnumTelContratante();
        String contratoCcrearpatrnumCelContratante = request.getContratoCcrearpatrnumCelContratante();
        String contratoCcrearpatrexentoIVA = request.getContratoCcrearpatrexentoIVA();
        Boolean contratoCcrearpatrContratoConFirma = request.getContratoCcrearpatrContratoConFirma();
        String contratoCcrearpatrNumContrato = request.getContratoCcrearpatrNumContrato();
        Date contratoCcrearpatrFechaFinVigencia = request.getContratoCcrearpatrFechaFinVigencia();
        Timestamp contratoCcrearpatrUltimaActualizacion = request.getContratoCcrearpatrUltimaActualizacion();
        String contratoCcrearpatrCodTarifa = request.getContratoCcrearpatrCodTarifa();

        request.checkArguments();
        ContratoC instance = new ContratoC();

        if (contratoCcrearpagrPeriodicidadC != null && !contratoCcrearpagrPeriodicidadC.isNull()) {
            instance.add2PeriodicidadC(contratoCcrearpagrPeriodicidadC);
        }

        if (contratoCcrearpagrFormaPagoC != null && !contratoCcrearpagrFormaPagoC.isNull()) {
            instance.add2FormaPagoC(contratoCcrearpagrFormaPagoC);
        }

        if (contratoCcrearpagrEstadoContratoC != null && !contratoCcrearpagrEstadoContratoC.isNull()) {
            instance.add2EstadoContratoC(contratoCcrearpagrEstadoContratoC);
        }

        instance.add2ProductoC(contratoCcrearpagrProductoC);

        instance.add2PlanC(contratoCcrearpagrPlanC);

        if (contratoCcrearpagrTarifaC != null && !contratoCcrearpagrTarifaC.isNull()) {
            instance.add2TarifaC(contratoCcrearpagrTarifaC);
        }

        if (contratoCcrearpagrGrupoAsociadoC != null && !contratoCcrearpagrGrupoAsociadoC.isNull()) {
            instance.add2GrupoAsociadoC(contratoCcrearpagrGrupoAsociadoC);
        }

        if (contratoCcrearpagrMunicipioC != null && !contratoCcrearpagrMunicipioC.isNull()) {
            instance.add2MunicipioC(contratoCcrearpagrMunicipioC);
        }

        if (contratoCcrearpagrSucursalC != null && !contratoCcrearpagrSucursalC.isNull()) {
            instance.add2SucursalC(contratoCcrearpagrSucursalC);
        }

        if (contratoCcrearpagrAsesorC != null && !contratoCcrearpagrAsesorC.isNull()) {
            instance.add2AsesorC(contratoCcrearpagrAsesorC);
        }

        instance.setContratoCID(Long.valueOf(0));
        instance.setContratoCvalorCuotaPeriodo(Utilities.convertToDouble(Long.valueOf(0)));
        instance.setContratoCdescuentoComercial(Utilities.convertToDouble(Long.valueOf(0)));
        instance.setContratoCIVA(Utilities.convertToDouble(Long.valueOf(0)));
        instance.setContratoCdescuentoFinanciero(Utilities.convertToDouble(Long.valueOf(0)));
        instance.setContratoCcontratoNotificado(Boolean.FALSE);
        instance.setContratoCNumSolicitud(contratoCcrearpatrNumSolicitud);
        instance.setContratoCFechaSolicitud(contratoCcrearpatrFechaSolicitud);
        instance.setContratoCTipoContrato(contratoCcrearpatrTipoContrato);
        instance.setContratoCFechaIniVigencia(contratoCcrearpatrFechaIniVigencia);
        instance.setContratoCDireccion(contratoCcrearpatrDireccion);
        instance.setContratoCcorreoContratante(contratoCcrearpatrcorreoContratante);
        instance.setContratoCnumTelContratante(contratoCcrearpatrnumTelContratante);
        instance.setContratoCnumCelContratante(contratoCcrearpatrnumCelContratante);
        instance.setContratoCexentoIVA(contratoCcrearpatrexentoIVA);
        instance.setContratoCContratoConFirma(contratoCcrearpatrContratoConFirma);
        instance.setContratoCNumContrato(contratoCcrearpatrNumContrato);
        instance.setContratoCFechaFinVigencia(contratoCcrearpatrFechaFinVigencia);
        instance.setContratoCUltimaActualizacion(contratoCcrearpatrUltimaActualizacion);
        instance.setContratoCCodTarifa(contratoCcrearpatrCodTarifa);

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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.eliminarTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.EliminarRequest request) throws ModelException {
        request.setContratoCeliminarpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCeliminarpthisContratoC()));
        return contratoCSrv.eliminarImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCeliminarpthisContratoC = request.getContratoCeliminarpthisContratoCInstance();

        request.checkArguments();
        ContratoC instance = contratoCeliminarpthisContratoC;
        if(contratoCeliminarpthisContratoC.getSolicitud().size() > 0) {
            throw new MinCardinalityException(ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ROLE_ALIAS_SOLICITUD);
        }
        if(contratoCeliminarpthisContratoC.getPersonaCContratante() != null && !contratoCeliminarpthisContratoC.getPersonaCContratante().isNull()) {
            throw new MinCardinalityException(ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ROLE_ALIAS_PERSONACCONTRATANTE);
        }
        if(contratoCeliminarpthisContratoC.getDireccionesC().size() > 0) {
            throw new MinCardinalityException(ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ROLE_ALIAS_DIRECCIONESC);
        }
        if(contratoCeliminarpthisContratoC.getObservacionesC().size() > 0) {
            throw new MinCardinalityException(ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ROLE_ALIAS_OBSERVACIONESC);
        }
        if(contratoCeliminarpthisContratoC.getBeneficiariosC().size() > 0) {
            throw new MinCardinalityException(ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ROLE_ALIAS_BENEFICIARIOSC);
        }
        if(contratoCeliminarpthisContratoC.getFamiliasC().size() > 0) {
            throw new MinCardinalityException(ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ROLE_ALIAS_FAMILIASC);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.ModificarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.modificarTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.ModificarRequest request) throws ModelException {
        request.setContratoCmodificarpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCmodificarpthisContratoC()));
        return contratoCSrv.modificarImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.ModificarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCmodificarpthisContratoC = request.getContratoCmodificarpthisContratoCInstance();
        String contratoCmodificarpNumContrato = request.getContratoCmodificarpNumContrato();
        String contratoCmodificarpNumSolicitud = request.getContratoCmodificarpNumSolicitud();
        Date contratoCmodificarpFechaSolicitud = request.getContratoCmodificarpFechaSolicitud();
        Long contratoCmodificarpTipoContrato = request.getContratoCmodificarpTipoContrato();
        Date contratoCmodificarpFechaIniVigencia = request.getContratoCmodificarpFechaIniVigencia();
        Date contratoCmodificarpFechaFinVigencia = request.getContratoCmodificarpFechaFinVigencia();
        String contratoCmodificarpDireccion = request.getContratoCmodificarpDireccion();
        String contratoCmodificarpcorreoContratante = request.getContratoCmodificarpcorreoContratante();
        String contratoCmodificarpnumTelContratante = request.getContratoCmodificarpnumTelContratante();
        String contratoCmodificarpnumCelContratante = request.getContratoCmodificarpnumCelContratante();
        String contratoCmodificarpexentoIVA = request.getContratoCmodificarpexentoIVA();
        Boolean contratoCmodificarpContratoConFirma = request.getContratoCmodificarpContratoConFirma();
        Double contratoCmodificarpvalorCuotaPeriodo = request.getContratoCmodificarpvalorCuotaPeriodo();
        Double contratoCmodificarpdescuentoComercial = request.getContratoCmodificarpdescuentoComercial();
        Double contratoCmodificarpIVA = request.getContratoCmodificarpIVA();
        Double contratoCmodificarpdescuentoFinanciero = request.getContratoCmodificarpdescuentoFinanciero();
        Timestamp contratoCmodificarpUltimaActualizacion = request.getContratoCmodificarpUltimaActualizacion();

        request.checkArguments();
        ContratoC instance = contratoCmodificarpthisContratoC;
        instance.setContratoCNumContrato(contratoCmodificarpNumContrato);
        instance.setContratoCNumSolicitud(contratoCmodificarpNumSolicitud);
        instance.setContratoCFechaSolicitud(contratoCmodificarpFechaSolicitud);
        instance.setContratoCTipoContrato(contratoCmodificarpTipoContrato);
        instance.setContratoCFechaIniVigencia(contratoCmodificarpFechaIniVigencia);
        instance.setContratoCFechaFinVigencia(contratoCmodificarpFechaFinVigencia);
        instance.setContratoCDireccion(contratoCmodificarpDireccion);
        instance.setContratoCcorreoContratante(contratoCmodificarpcorreoContratante);
        instance.setContratoCnumTelContratante(contratoCmodificarpnumTelContratante);
        instance.setContratoCnumCelContratante(contratoCmodificarpnumCelContratante);
        instance.setContratoCexentoIVA(contratoCmodificarpexentoIVA);
        instance.setContratoCContratoConFirma(contratoCmodificarpContratoConFirma);
        instance.setContratoCvalorCuotaPeriodo(contratoCmodificarpvalorCuotaPeriodo);
        instance.setContratoCdescuentoComercial(contratoCmodificarpdescuentoComercial);
        instance.setContratoCIVA(contratoCmodificarpIVA);
        instance.setContratoCdescuentoFinanciero(contratoCmodificarpdescuentoFinanciero);
        instance.setContratoCUltimaActualizacion(contratoCmodificarpUltimaActualizacion);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: modificarNumContrato

    /*
     * Entry point for service modificarNumContrato
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse modificarNumContrato(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.ModificarNumContratoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.modificarNumContratoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service modificarNumContrato
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse modificarNumContratoTxn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.ModificarNumContratoRequest request) throws ModelException {
        request.setContratoCmodificarNumContratopthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCmodificarNumContratopthisContratoC()));
        return contratoCSrv.modificarNumContratoImplementation(request);
    }

    /*
     * Implements service modificarNumContrato
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse modificarNumContratoImplementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.ModificarNumContratoRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCmodificarNumContratopthisContratoC = request.getContratoCmodificarNumContratopthisContratoCInstance();
        String contratoCmodificarNumContratopNumContrato = request.getContratoCmodificarNumContratopNumContrato();

        request.checkArguments();
        ContratoC instance = contratoCmodificarNumContratopthisContratoC;
        instance.setContratoCNumContrato(contratoCmodificarNumContratopNumContrato);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: modificarFechaFin

    /*
     * Entry point for service modificarFechaFin
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse modificarFechaFin(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.ModificarFechaFinRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.modificarFechaFinTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service modificarFechaFin
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse modificarFechaFinTxn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.ModificarFechaFinRequest request) throws ModelException {
        request.setContratoCmodificarFechaFinpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCmodificarFechaFinpthisContratoC()));
        return contratoCSrv.modificarFechaFinImplementation(request);
    }

    /*
     * Implements service modificarFechaFin
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse modificarFechaFinImplementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.ModificarFechaFinRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCmodificarFechaFinpthisContratoC = request.getContratoCmodificarFechaFinpthisContratoCInstance();
        Date contratoCmodificarFechaFinpFechaFin = request.getContratoCmodificarFechaFinpFechaFin();

        request.checkArguments();
        ContratoC instance = contratoCmodificarFechaFinpthisContratoC;
        instance.setContratoCFechaFinVigencia(contratoCmodificarFechaFinpFechaFin);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: CalcularLiquidacion

    /*
     * Entry point for service CalcularLiquidacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse calcularLiquidacion(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.CalcularLiquidacionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.calcularLiquidacionTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service CalcularLiquidacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse calcularLiquidacionTxn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.CalcularLiquidacionRequest request) throws ModelException, SystemException {
        request.setContratoCCalcularLiquidacionpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCCalcularLiquidacionpthisContratoC()));
        return contratoCSrv.calcularLiquidacionImplementation(request);
    }

    /*
     * Implements service CalcularLiquidacion
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse calcularLiquidacionImplementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.CalcularLiquidacionRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCCalcularLiquidacionpthisContratoC = request.getContratoCCalcularLiquidacionpthisContratoCInstance();

        request.checkArguments();
        ContratoC instance = contratoCCalcularLiquidacionpthisContratoC;
        instance.setContratoCvalorCuotaPeriodo(contratoCCalcularLiquidacionpthisContratoC.getContratoCdrvValorCuotaAfiliacion());
        instance.setContratoCdescuentoComercial(repository.assocOperator007(contratoCCalcularLiquidacionpthisContratoC));
        instance.setContratoCdescuentoFinanciero(repository.assocOperator008(contratoCCalcularLiquidacionpthisContratoC));


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsContratoCASolicitud

    /*
     * Entry point for service InsContratoCASolicitud
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insContratoCASolicitud(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsContratoCASolicitudRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.insContratoCASolicitudTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsContratoCASolicitud
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insContratoCASolicitudTxn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsContratoCASolicitudRequest request) throws ModelException {
        request.setContratoCInsContratoCASolicitudpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCInsContratoCASolicitudpthisContratoC()));
        request.setContratoCInsContratoCASolicitudpevcSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getContratoCInsContratoCASolicitudpevcSolicitud()));
        return contratoCSrv.insContratoCASolicitudImplementation(request, true);
    }

    /*
     * Implements service InsContratoCASolicitud
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insContratoCASolicitudImplementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsContratoCASolicitudRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCInsContratoCASolicitudpthisContratoC = request.getContratoCInsContratoCASolicitudpthisContratoCInstance();
        Solicitud contratoCInsContratoCASolicitudpevcSolicitud = request.getContratoCInsContratoCASolicitudpevcSolicitudInstance();

        request.checkArguments();
        ContratoC instance = contratoCInsContratoCASolicitudpthisContratoC;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.solicitud.siu.InsContratoCASolicitudRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.solicitud.siu.InsContratoCASolicitudRequest();
            relatedRequest.setSolicitudInsContratoCASolicitudpthisSolicitudInstance(contratoCInsContratoCASolicitudpevcSolicitud);
            relatedRequest.setSolicitudInsContratoCASolicitudpevcContratoCInstance(contratoCInsContratoCASolicitudpthisContratoC);
            solicitudSrv.insContratoCASolicitudImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelContratoCASolicitud

    /*
     * Entry point for service DelContratoCASolicitud
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delContratoCASolicitud(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelContratoCASolicitudRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.delContratoCASolicitudTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelContratoCASolicitud
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delContratoCASolicitudTxn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelContratoCASolicitudRequest request) throws ModelException {
        request.setContratoCDelContratoCASolicitudpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCDelContratoCASolicitudpthisContratoC()));
        request.setContratoCDelContratoCASolicitudpevcSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getContratoCDelContratoCASolicitudpevcSolicitud()));
        return contratoCSrv.delContratoCASolicitudImplementation(request, true);
    }

    /*
     * Implements service DelContratoCASolicitud
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delContratoCASolicitudImplementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelContratoCASolicitudRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCDelContratoCASolicitudpthisContratoC = request.getContratoCDelContratoCASolicitudpthisContratoCInstance();
        Solicitud contratoCDelContratoCASolicitudpevcSolicitud = request.getContratoCDelContratoCASolicitudpevcSolicitudInstance();

        request.checkArguments();
        ContratoC instance = contratoCDelContratoCASolicitudpthisContratoC;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.solicitud.siu.DelContratoCASolicitudRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.solicitud.siu.DelContratoCASolicitudRequest();
            relatedRequest.setSolicitudDelContratoCASolicitudpthisSolicitudInstance(contratoCDelContratoCASolicitudpevcSolicitud);
            relatedRequest.setSolicitudDelContratoCASolicitudpevcContratoCInstance(contratoCDelContratoCASolicitudpthisContratoC);
            solicitudSrv.delContratoCASolicitudImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: marcarContratoNotificado

    /*
     * Entry point for service marcarContratoNotificado
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse marcarContratoNotificado(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.MarcarContratoNotificadoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.marcarContratoNotificadoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service marcarContratoNotificado
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse marcarContratoNotificadoTxn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.MarcarContratoNotificadoRequest request) throws ModelException {
        request.setContratoCmarcarContratoNotificadopthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCmarcarContratoNotificadopthisContratoC()));
        return contratoCSrv.marcarContratoNotificadoImplementation(request);
    }

    /*
     * Implements service marcarContratoNotificado
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse marcarContratoNotificadoImplementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.MarcarContratoNotificadoRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCmarcarContratoNotificadopthisContratoC = request.getContratoCmarcarContratoNotificadopthisContratoCInstance();

        request.checkArguments();
        ContratoC instance = contratoCmarcarContratoNotificadopthisContratoC;
        instance.setContratoCcontratoNotificado(Boolean.TRUE);


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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsPersonaCContratanteRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.insPersonaCContratanteTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsPersonaCContratanteRequest request) throws ModelException {
        request.setContratoCInsPersonaCContratantepthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCInsPersonaCContratantepthisContratoC()));
        request.setContratoCInsPersonaCContratantepevcPersonaCInstance(personaCSrv.getByOIDWithHV(request.getContratoCInsPersonaCContratantepevcPersonaC()));
        return contratoCSrv.insPersonaCContratanteImplementation(request, true);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsPersonaCContratanteRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCInsPersonaCContratantepthisContratoC = request.getContratoCInsPersonaCContratantepthisContratoCInstance();
        PersonaC contratoCInsPersonaCContratantepevcPersonaC = request.getContratoCInsPersonaCContratantepevcPersonaCInstance();

        request.checkArguments();
        ContratoC instance = contratoCInsPersonaCContratantepthisContratoC;

        instance.add2PersonaCContratante(contratoCInsPersonaCContratantepevcPersonaC);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.personac.siu.InsPersonaCContratanteRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.personac.siu.InsPersonaCContratanteRequest();
            relatedRequest.setPersonaCInsPersonaCContratantepthisPersonaCInstance(contratoCInsPersonaCContratantepevcPersonaC);
            relatedRequest.setPersonaCInsPersonaCContratantepevcContratoCInstance(contratoCInsPersonaCContratantepthisContratoC);
            personaCSrv.insPersonaCContratanteImplementation(relatedRequest, false);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelPersonaCContratanteRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.delPersonaCContratanteTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelPersonaCContratanteRequest request) throws ModelException {
        request.setContratoCDelPersonaCContratantepthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCDelPersonaCContratantepthisContratoC()));
        request.setContratoCDelPersonaCContratantepevcPersonaCInstance(personaCSrv.getByOIDWithHV(request.getContratoCDelPersonaCContratantepevcPersonaC()));
        return contratoCSrv.delPersonaCContratanteImplementation(request, true);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelPersonaCContratanteRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCDelPersonaCContratantepthisContratoC = request.getContratoCDelPersonaCContratantepthisContratoCInstance();
        PersonaC contratoCDelPersonaCContratantepevcPersonaC = request.getContratoCDelPersonaCContratantepevcPersonaCInstance();

        request.checkArguments();
        ContratoC instance = contratoCDelPersonaCContratantepthisContratoC;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.personac.siu.DelPersonaCContratanteRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.personac.siu.DelPersonaCContratanteRequest();
            relatedRequest.setPersonaCDelPersonaCContratantepthisPersonaCInstance(contratoCDelPersonaCContratantepevcPersonaC);
            relatedRequest.setPersonaCDelPersonaCContratantepevcContratoCInstance(contratoCDelPersonaCContratantepthisContratoC);
            personaCSrv.delPersonaCContratanteImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsPeriodicidad

    /*
     * Entry point for service InsPeriodicidad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insPeriodicidad(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsPeriodicidadRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.insPeriodicidadTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsPeriodicidad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insPeriodicidadTxn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsPeriodicidadRequest request) throws ModelException {
        request.setContratoCInsPeriodicidadpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCInsPeriodicidadpthisContratoC()));
        request.setContratoCInsPeriodicidadpevcPeriodicidadInstance(periodicidadSrv.getByOIDWithHV(request.getContratoCInsPeriodicidadpevcPeriodicidad()));
        return contratoCSrv.insPeriodicidadImplementation(request, true);
    }

    /*
     * Implements service InsPeriodicidad
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insPeriodicidadImplementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsPeriodicidadRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCInsPeriodicidadpthisContratoC = request.getContratoCInsPeriodicidadpthisContratoCInstance();
        Periodicidad contratoCInsPeriodicidadpevcPeriodicidad = request.getContratoCInsPeriodicidadpevcPeriodicidadInstance();

        request.checkArguments();
        ContratoC instance = contratoCInsPeriodicidadpthisContratoC;

        instance.add2PeriodicidadC(contratoCInsPeriodicidadpevcPeriodicidad);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.periodicidad.siu.InsPeriodicidadRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.periodicidad.siu.InsPeriodicidadRequest();
            relatedRequest.setPeriodicidadInsPeriodicidadpthisPeriodicidadInstance(contratoCInsPeriodicidadpevcPeriodicidad);
            relatedRequest.setPeriodicidadInsPeriodicidadpevcContratoCInstance(contratoCInsPeriodicidadpthisContratoC);
            periodicidadSrv.insPeriodicidadImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelPeriodicidad

    /*
     * Entry point for service DelPeriodicidad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delPeriodicidad(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelPeriodicidadRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.delPeriodicidadTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelPeriodicidad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delPeriodicidadTxn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelPeriodicidadRequest request) throws ModelException {
        request.setContratoCDelPeriodicidadpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCDelPeriodicidadpthisContratoC()));
        request.setContratoCDelPeriodicidadpevcPeriodicidadInstance(periodicidadSrv.getByOIDWithHV(request.getContratoCDelPeriodicidadpevcPeriodicidad()));
        return contratoCSrv.delPeriodicidadImplementation(request, true);
    }

    /*
     * Implements service DelPeriodicidad
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delPeriodicidadImplementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelPeriodicidadRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCDelPeriodicidadpthisContratoC = request.getContratoCDelPeriodicidadpthisContratoCInstance();
        Periodicidad contratoCDelPeriodicidadpevcPeriodicidad = request.getContratoCDelPeriodicidadpevcPeriodicidadInstance();

        request.checkArguments();
        ContratoC instance = contratoCDelPeriodicidadpthisContratoC;

        instance.add2PeriodicidadC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.periodicidad.siu.DelPeriodicidadRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.periodicidad.siu.DelPeriodicidadRequest();
            relatedRequest.setPeriodicidadDelPeriodicidadpthisPeriodicidadInstance(contratoCDelPeriodicidadpevcPeriodicidad);
            relatedRequest.setPeriodicidadDelPeriodicidadpevcContratoCInstance(contratoCDelPeriodicidadpthisContratoC);
            periodicidadSrv.delPeriodicidadImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsFormaPagoCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.insFormaPagoCTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsFormaPagoCRequest request) throws ModelException {
        request.setContratoCInsFormaPagoCpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCInsFormaPagoCpthisContratoC()));
        request.setContratoCInsFormaPagoCpevcFormaPagoInstance(formaPagoSrv.getByOIDWithHV(request.getContratoCInsFormaPagoCpevcFormaPago()));
        return contratoCSrv.insFormaPagoCImplementation(request, true);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsFormaPagoCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCInsFormaPagoCpthisContratoC = request.getContratoCInsFormaPagoCpthisContratoCInstance();
        FormaPago contratoCInsFormaPagoCpevcFormaPago = request.getContratoCInsFormaPagoCpevcFormaPagoInstance();

        request.checkArguments();
        ContratoC instance = contratoCInsFormaPagoCpthisContratoC;

        instance.add2FormaPagoC(contratoCInsFormaPagoCpevcFormaPago);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.formapago.siu.InsFormaPagoCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.formapago.siu.InsFormaPagoCRequest();
            relatedRequest.setFormaPagoInsFormaPagoCpthisFormaPagoInstance(contratoCInsFormaPagoCpevcFormaPago);
            relatedRequest.setFormaPagoInsFormaPagoCpevcContratoCInstance(contratoCInsFormaPagoCpthisContratoC);
            formaPagoSrv.insFormaPagoCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelFormaPagoCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.delFormaPagoCTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelFormaPagoCRequest request) throws ModelException {
        request.setContratoCDelFormaPagoCpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCDelFormaPagoCpthisContratoC()));
        request.setContratoCDelFormaPagoCpevcFormaPagoInstance(formaPagoSrv.getByOIDWithHV(request.getContratoCDelFormaPagoCpevcFormaPago()));
        return contratoCSrv.delFormaPagoCImplementation(request, true);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelFormaPagoCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCDelFormaPagoCpthisContratoC = request.getContratoCDelFormaPagoCpthisContratoCInstance();
        FormaPago contratoCDelFormaPagoCpevcFormaPago = request.getContratoCDelFormaPagoCpevcFormaPagoInstance();

        request.checkArguments();
        ContratoC instance = contratoCDelFormaPagoCpthisContratoC;

        instance.add2FormaPagoC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.formapago.siu.DelFormaPagoCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.formapago.siu.DelFormaPagoCRequest();
            relatedRequest.setFormaPagoDelFormaPagoCpthisFormaPagoInstance(contratoCDelFormaPagoCpevcFormaPago);
            relatedRequest.setFormaPagoDelFormaPagoCpevcContratoCInstance(contratoCDelFormaPagoCpthisContratoC);
            formaPagoSrv.delFormaPagoCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsEstadoContratoC

    /*
     * Entry point for service InsEstadoContratoC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insEstadoContratoC(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsEstadoContratoCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.insEstadoContratoCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsEstadoContratoC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insEstadoContratoCTxn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsEstadoContratoCRequest request) throws ModelException {
        request.setContratoCInsEstadoContratoCpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCInsEstadoContratoCpthisContratoC()));
        request.setContratoCInsEstadoContratoCpevcEstadoContratoInstance(estadoContratoSrv.getByOIDWithHV(request.getContratoCInsEstadoContratoCpevcEstadoContrato()));
        return contratoCSrv.insEstadoContratoCImplementation(request, true);
    }

    /*
     * Implements service InsEstadoContratoC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insEstadoContratoCImplementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsEstadoContratoCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCInsEstadoContratoCpthisContratoC = request.getContratoCInsEstadoContratoCpthisContratoCInstance();
        EstadoContrato contratoCInsEstadoContratoCpevcEstadoContrato = request.getContratoCInsEstadoContratoCpevcEstadoContratoInstance();

        request.checkArguments();
        ContratoC instance = contratoCInsEstadoContratoCpthisContratoC;

        instance.add2EstadoContratoC(contratoCInsEstadoContratoCpevcEstadoContrato);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.estadocontrato.siu.InsEstadoContratoCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.estadocontrato.siu.InsEstadoContratoCRequest();
            relatedRequest.setEstadoContratoInsEstadoContratoCpthisEstadoContratoInstance(contratoCInsEstadoContratoCpevcEstadoContrato);
            relatedRequest.setEstadoContratoInsEstadoContratoCpevcContratoCInstance(contratoCInsEstadoContratoCpthisContratoC);
            estadoContratoSrv.insEstadoContratoCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelEstadoContratoC

    /*
     * Entry point for service DelEstadoContratoC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delEstadoContratoC(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelEstadoContratoCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.delEstadoContratoCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelEstadoContratoC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delEstadoContratoCTxn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelEstadoContratoCRequest request) throws ModelException {
        request.setContratoCDelEstadoContratoCpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCDelEstadoContratoCpthisContratoC()));
        request.setContratoCDelEstadoContratoCpevcEstadoContratoInstance(estadoContratoSrv.getByOIDWithHV(request.getContratoCDelEstadoContratoCpevcEstadoContrato()));
        return contratoCSrv.delEstadoContratoCImplementation(request, true);
    }

    /*
     * Implements service DelEstadoContratoC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delEstadoContratoCImplementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelEstadoContratoCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCDelEstadoContratoCpthisContratoC = request.getContratoCDelEstadoContratoCpthisContratoCInstance();
        EstadoContrato contratoCDelEstadoContratoCpevcEstadoContrato = request.getContratoCDelEstadoContratoCpevcEstadoContratoInstance();

        request.checkArguments();
        ContratoC instance = contratoCDelEstadoContratoCpthisContratoC;

        instance.add2EstadoContratoC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.estadocontrato.siu.DelEstadoContratoCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.estadocontrato.siu.DelEstadoContratoCRequest();
            relatedRequest.setEstadoContratoDelEstadoContratoCpthisEstadoContratoInstance(contratoCDelEstadoContratoCpevcEstadoContrato);
            relatedRequest.setEstadoContratoDelEstadoContratoCpevcContratoCInstance(contratoCDelEstadoContratoCpthisContratoC);
            estadoContratoSrv.delEstadoContratoCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsMunicipioContrato

    /*
     * Entry point for service InsMunicipioContrato
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insMunicipioContrato(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsMunicipioContratoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.insMunicipioContratoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsMunicipioContrato
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insMunicipioContratoTxn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsMunicipioContratoRequest request) throws ModelException {
        request.setContratoCInsMunicipioContratopthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCInsMunicipioContratopthisContratoC()));
        request.setContratoCInsMunicipioContratopevcMunicipioInstance(municipioSrv.getByOIDWithHV(request.getContratoCInsMunicipioContratopevcMunicipio()));
        return contratoCSrv.insMunicipioContratoImplementation(request, true);
    }

    /*
     * Implements service InsMunicipioContrato
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insMunicipioContratoImplementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsMunicipioContratoRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCInsMunicipioContratopthisContratoC = request.getContratoCInsMunicipioContratopthisContratoCInstance();
        Municipio contratoCInsMunicipioContratopevcMunicipio = request.getContratoCInsMunicipioContratopevcMunicipioInstance();

        request.checkArguments();
        ContratoC instance = contratoCInsMunicipioContratopthisContratoC;

        instance.add2MunicipioC(contratoCInsMunicipioContratopevcMunicipio);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.municipio.siu.InsMunicipioContratoRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.municipio.siu.InsMunicipioContratoRequest();
            relatedRequest.setMunicipioInsMunicipioContratopthisMunicipioInstance(contratoCInsMunicipioContratopevcMunicipio);
            relatedRequest.setMunicipioInsMunicipioContratopevcContratoCInstance(contratoCInsMunicipioContratopthisContratoC);
            municipioSrv.insMunicipioContratoImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelMunicipioContrato

    /*
     * Entry point for service DelMunicipioContrato
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delMunicipioContrato(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelMunicipioContratoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.delMunicipioContratoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelMunicipioContrato
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delMunicipioContratoTxn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelMunicipioContratoRequest request) throws ModelException {
        request.setContratoCDelMunicipioContratopthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCDelMunicipioContratopthisContratoC()));
        request.setContratoCDelMunicipioContratopevcMunicipioInstance(municipioSrv.getByOIDWithHV(request.getContratoCDelMunicipioContratopevcMunicipio()));
        return contratoCSrv.delMunicipioContratoImplementation(request, true);
    }

    /*
     * Implements service DelMunicipioContrato
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delMunicipioContratoImplementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelMunicipioContratoRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCDelMunicipioContratopthisContratoC = request.getContratoCDelMunicipioContratopthisContratoCInstance();
        Municipio contratoCDelMunicipioContratopevcMunicipio = request.getContratoCDelMunicipioContratopevcMunicipioInstance();

        request.checkArguments();
        ContratoC instance = contratoCDelMunicipioContratopthisContratoC;

        instance.add2MunicipioC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.municipio.siu.DelMunicipioContratoRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.municipio.siu.DelMunicipioContratoRequest();
            relatedRequest.setMunicipioDelMunicipioContratopthisMunicipioInstance(contratoCDelMunicipioContratopevcMunicipio);
            relatedRequest.setMunicipioDelMunicipioContratopevcContratoCInstance(contratoCDelMunicipioContratopthisContratoC);
            municipioSrv.delMunicipioContratoImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsAsesorC

    /*
     * Entry point for service InsAsesorC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insAsesorC(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsAsesorCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.insAsesorCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsAsesorC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insAsesorCTxn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsAsesorCRequest request) throws ModelException {
        request.setContratoCInsAsesorCpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCInsAsesorCpthisContratoC()));
        request.setContratoCInsAsesorCpevcAsesorInstance(asesorSrv.getByOIDWithHV(request.getContratoCInsAsesorCpevcAsesor()));
        return contratoCSrv.insAsesorCImplementation(request, true);
    }

    /*
     * Implements service InsAsesorC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insAsesorCImplementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsAsesorCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCInsAsesorCpthisContratoC = request.getContratoCInsAsesorCpthisContratoCInstance();
        Asesor contratoCInsAsesorCpevcAsesor = request.getContratoCInsAsesorCpevcAsesorInstance();

        request.checkArguments();
        ContratoC instance = contratoCInsAsesorCpthisContratoC;

        instance.add2AsesorC(contratoCInsAsesorCpevcAsesor);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.asesor.siu.InsAsesorCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.asesor.siu.InsAsesorCRequest();
            relatedRequest.setAsesorInsAsesorCpthisAsesorInstance(contratoCInsAsesorCpevcAsesor);
            relatedRequest.setAsesorInsAsesorCpevcContratoCInstance(contratoCInsAsesorCpthisContratoC);
            asesorSrv.insAsesorCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelAsesorC

    /*
     * Entry point for service DelAsesorC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delAsesorC(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelAsesorCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.delAsesorCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelAsesorC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delAsesorCTxn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelAsesorCRequest request) throws ModelException {
        request.setContratoCDelAsesorCpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCDelAsesorCpthisContratoC()));
        request.setContratoCDelAsesorCpevcAsesorInstance(asesorSrv.getByOIDWithHV(request.getContratoCDelAsesorCpevcAsesor()));
        return contratoCSrv.delAsesorCImplementation(request, true);
    }

    /*
     * Implements service DelAsesorC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delAsesorCImplementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelAsesorCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCDelAsesorCpthisContratoC = request.getContratoCDelAsesorCpthisContratoCInstance();
        Asesor contratoCDelAsesorCpevcAsesor = request.getContratoCDelAsesorCpevcAsesorInstance();

        request.checkArguments();
        ContratoC instance = contratoCDelAsesorCpthisContratoC;

        instance.add2AsesorC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.asesor.siu.DelAsesorCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.asesor.siu.DelAsesorCRequest();
            relatedRequest.setAsesorDelAsesorCpthisAsesorInstance(contratoCDelAsesorCpevcAsesor);
            relatedRequest.setAsesorDelAsesorCpevcContratoCInstance(contratoCDelAsesorCpthisContratoC);
            asesorSrv.delAsesorCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: chgProductoC

    /*
     * Entry point for service chgProductoC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse chgProductoC(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.ChgProductoCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.chgProductoCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service chgProductoC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse chgProductoCTxn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.ChgProductoCRequest request) throws ModelException {
        request.setContratoCchgProductoCpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCchgProductoCpthisContratoC()));
        request.setContratoCchgProductoCpevcProductosInstance(productosSrv.getByOIDWithHV(request.getContratoCchgProductoCpevcProductos()));
        return contratoCSrv.chgProductoCImplementation(request, true);
    }

    /*
     * Implements service chgProductoC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse chgProductoCImplementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.ChgProductoCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCchgProductoCpthisContratoC = request.getContratoCchgProductoCpthisContratoCInstance();
        Productos contratoCchgProductoCpevcProductos = request.getContratoCchgProductoCpevcProductosInstance();

        request.checkArguments();
        ContratoC instance = contratoCchgProductoCpthisContratoC;

        instance.add2ProductoC(contratoCchgProductoCpevcProductos);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.productos.siu.ChgProductoCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.productos.siu.ChgProductoCRequest();
            relatedRequest.setProductoschgProductoCpthisProductosInstance(contratoCchgProductoCpevcProductos);
            relatedRequest.setProductoschgProductoCpevcContratoCInstance(contratoCchgProductoCpthisContratoC);
            productosSrv.chgProductoCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: chgPlanC

    /*
     * Entry point for service chgPlanC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse chgPlanC(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.ChgPlanCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.chgPlanCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service chgPlanC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse chgPlanCTxn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.ChgPlanCRequest request) throws ModelException {
        request.setContratoCchgPlanCpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCchgPlanCpthisContratoC()));
        request.setContratoCchgPlanCpevcPlanesInstance(planesSrv.getByOIDWithHV(request.getContratoCchgPlanCpevcPlanes()));
        return contratoCSrv.chgPlanCImplementation(request, true);
    }

    /*
     * Implements service chgPlanC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse chgPlanCImplementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.ChgPlanCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCchgPlanCpthisContratoC = request.getContratoCchgPlanCpthisContratoCInstance();
        Planes contratoCchgPlanCpevcPlanes = request.getContratoCchgPlanCpevcPlanesInstance();

        request.checkArguments();
        ContratoC instance = contratoCchgPlanCpthisContratoC;

        instance.add2PlanC(contratoCchgPlanCpevcPlanes);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.planes.siu.ChgPlanCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.planes.siu.ChgPlanCRequest();
            relatedRequest.setPlaneschgPlanCpthisPlanesInstance(contratoCchgPlanCpevcPlanes);
            relatedRequest.setPlaneschgPlanCpevcContratoCInstance(contratoCchgPlanCpthisContratoC);
            planesSrv.chgPlanCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: evalPostNotifCrear

    /*
     * Entry point for service evalPostNotifCrear
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse evalPostNotifCrear(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.EvalPostNotifCrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.evalPostNotifCrearTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service evalPostNotifCrear
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse evalPostNotifCrearTxn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.EvalPostNotifCrearRequest request) throws ModelException {
        request.setContratoCevalPostNotifCrearpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCevalPostNotifCrearpthisContratoC()));
        return contratoCSrv.evalPostNotifCrearImplementation(request);
    }

    /*
     * Implements service evalPostNotifCrear
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse evalPostNotifCrearImplementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.EvalPostNotifCrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCevalPostNotifCrearpthisContratoC = request.getContratoCevalPostNotifCrearpthisContratoCInstance();
        String contratoCevalPostNotifCrearpNumContrato = request.getContratoCevalPostNotifCrearpNumContrato();
        Long contratoCevalPostNotifCrearpTipoContrato = request.getContratoCevalPostNotifCrearpTipoContrato();
        Date contratoCevalPostNotifCrearpFechaIniVigencia = request.getContratoCevalPostNotifCrearpFechaIniVigencia();
        Date contratoCevalPostNotifCrearpFechaFinVigencia = request.getContratoCevalPostNotifCrearpFechaFinVigencia();
        String contratoCevalPostNotifCrearpDireccion = request.getContratoCevalPostNotifCrearpDireccion();
        String contratoCevalPostNotifCrearpnumTelContratante = request.getContratoCevalPostNotifCrearpnumTelContratante();
        String contratoCevalPostNotifCrearpnumCelContratante = request.getContratoCevalPostNotifCrearpnumCelContratante();

        request.checkArguments();
        ContratoC instance = contratoCevalPostNotifCrearpthisContratoC;
        instance.setContratoCNumContrato(contratoCevalPostNotifCrearpNumContrato);
        instance.setContratoCTipoContrato(contratoCevalPostNotifCrearpTipoContrato);
        instance.setContratoCFechaIniVigencia(contratoCevalPostNotifCrearpFechaIniVigencia);
        instance.setContratoCFechaFinVigencia(contratoCevalPostNotifCrearpFechaFinVigencia);
        instance.setContratoCDireccion(contratoCevalPostNotifCrearpDireccion);
        instance.setContratoCnumTelContratante(contratoCevalPostNotifCrearpnumTelContratante);
        instance.setContratoCnumCelContratante(contratoCevalPostNotifCrearpnumCelContratante);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: TCREAROBS100

    /*
     * Entry point for service TCREAROBS100
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCREAROBS100(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TCREAROBS100Request request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.tCREAROBS100Txn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREAROBS100
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCREAROBS100Txn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TCREAROBS100Request request) throws ModelException {
        request.setContratoCTCREAROBS100pthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCTCREAROBS100pthisContratoC()));
        return contratoCSrv.tCREAROBS100Implementation(request);
    }

    /*
     * Implements service TCREAROBS100
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCREAROBS100Implementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TCREAROBS100Request request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        String contratoCTCREAROBS100pObsText = request.getContratoCTCREAROBS100pObsText();
        ContratoC contratoCTCREAROBS100pthisContratoC = request.getContratoCTCREAROBS100pthisContratoCInstance();

        request.checkArguments();
        ContratoC instance = contratoCTCREAROBS100pthisContratoC;

        /* Action 1: IF (length(pObsText) > 100) */
        boolean ifCondition1 = STDFunctions.lengthFun(contratoCTCREAROBS100pObsText) > Long.valueOf(100);
        if (ifCondition1) {
            com.keralty.aesolicitudes.viewmodel.observacionesc.siu.CrearRequest step10Request = new com.keralty.aesolicitudes.viewmodel.observacionesc.siu.CrearRequest();
            step10Request.setObservacionesCcrearpagrContratoCInstance(contratoCTCREAROBS100pthisContratoC);
            step10Request.setObservacionesCcrearpatrCodTipoObservacion("2");
            step10Request.setObservacionesCcrearpatrTipoObservacion("OBSERVACIONES MANUALES");
            step10Request.setObservacionesCcrearpatrObservacions(STDFunctions.leftSubstringFun(contratoCTCREAROBS100pObsText, Long.valueOf(100)));
            observacionesCSrv.crearImplementation(step10Request);
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TCREAROBS100Request step11Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.TCREAROBS100Request();
            step11Request.setContratoCTCREAROBS100pthisContratoCInstance(contratoCTCREAROBS100pthisContratoC);
            step11Request.setContratoCTCREAROBS100pObsText(STDFunctions.substringFun(contratoCTCREAROBS100pObsText, Long.valueOf(100), STDFunctions.lengthFun(contratoCTCREAROBS100pObsText) - Long.valueOf(100)));
            contratoCSrv.tCREAROBS100Implementation(step11Request);
        } else {
            com.keralty.aesolicitudes.viewmodel.observacionesc.siu.CrearRequest step12Request = new com.keralty.aesolicitudes.viewmodel.observacionesc.siu.CrearRequest();
            step12Request.setObservacionesCcrearpagrContratoCInstance(contratoCTCREAROBS100pthisContratoC);
            step12Request.setObservacionesCcrearpatrCodTipoObservacion("2");
            step12Request.setObservacionesCcrearpatrTipoObservacion("OBSERVACIONES MANUALES");
            step12Request.setObservacionesCcrearpatrObservacions(contratoCTCREAROBS100pObsText);
            observacionesCSrv.crearImplementation(step12Request);
        }

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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TMODIFICARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.tMODIFICARTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TMODIFICARRequest request) throws ModelException, SystemException {
        request.setContratoCTMODIFICARpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCTMODIFICARpthisContratoC()));
        request.setContratoCTMODIFICARptpevcPeriodicidadCInstance(periodicidadSrv.getByOIDWithHV(request.getContratoCTMODIFICARptpevcPeriodicidadC()));
        request.setContratoCTMODIFICARptpevcFormaPagoCInstance(formaPagoSrv.getByOIDWithHV(request.getContratoCTMODIFICARptpevcFormaPagoC()));
        return contratoCSrv.tMODIFICARImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TMODIFICARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Double contratoCTMODIFICARptpvalorCuotaPeriodo = request.getContratoCTMODIFICARptpvalorCuotaPeriodo();
        Double contratoCTMODIFICARptpdescuentoComercial = request.getContratoCTMODIFICARptpdescuentoComercial();
        Double contratoCTMODIFICARptpIVA = request.getContratoCTMODIFICARptpIVA();
        Double contratoCTMODIFICARptpdescuentoFinanciero = request.getContratoCTMODIFICARptpdescuentoFinanciero();
        String contratoCTMODIFICARptpNumSolicitud = request.getContratoCTMODIFICARptpNumSolicitud();
        String contratoCTMODIFICARptpNumContrato = request.getContratoCTMODIFICARptpNumContrato();
        Date contratoCTMODIFICARptpFechaSolicitud = request.getContratoCTMODIFICARptpFechaSolicitud();
        Long contratoCTMODIFICARptpTipoContrato = request.getContratoCTMODIFICARptpTipoContrato();
        Date contratoCTMODIFICARptpFechaIniVigencia = request.getContratoCTMODIFICARptpFechaIniVigencia();
        String contratoCTMODIFICARptpDireccion = request.getContratoCTMODIFICARptpDireccion();
        String contratoCTMODIFICARptpcorreoContratante = request.getContratoCTMODIFICARptpcorreoContratante();
        String contratoCTMODIFICARptpnumTelContratante = request.getContratoCTMODIFICARptpnumTelContratante();
        String contratoCTMODIFICARptpnumCelContratante = request.getContratoCTMODIFICARptpnumCelContratante();
        String contratoCTMODIFICARptpexentoIVA = request.getContratoCTMODIFICARptpexentoIVA();
        Boolean contratoCTMODIFICARptpContratoConFirma = request.getContratoCTMODIFICARptpContratoConFirma();
        Date contratoCTMODIFICARptpFechaFinVigencia = request.getContratoCTMODIFICARptpFechaFinVigencia();
        Periodicidad contratoCTMODIFICARptpevcPeriodicidadC = request.getContratoCTMODIFICARptpevcPeriodicidadCInstance();
        FormaPago contratoCTMODIFICARptpevcFormaPagoC = request.getContratoCTMODIFICARptpevcFormaPagoCInstance();
        ContratoC contratoCTMODIFICARpthisContratoC = request.getContratoCTMODIFICARpthisContratoCInstance();

        request.checkArguments();
        ContratoC instance = contratoCTMODIFICARpthisContratoC;

        com.keralty.aesolicitudes.viewmodel.contratoc.siu.ModificarRequest step1Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.ModificarRequest();
        step1Request.setContratoCmodificarpthisContratoCInstance(contratoCTMODIFICARpthisContratoC);
        step1Request.setContratoCmodificarpvalorCuotaPeriodo(contratoCTMODIFICARptpvalorCuotaPeriodo);
        step1Request.setContratoCmodificarpdescuentoComercial(contratoCTMODIFICARptpdescuentoComercial);
        step1Request.setContratoCmodificarpIVA(contratoCTMODIFICARptpIVA);
        step1Request.setContratoCmodificarpdescuentoFinanciero(contratoCTMODIFICARptpdescuentoFinanciero);
        step1Request.setContratoCmodificarpNumSolicitud(contratoCTMODIFICARptpNumSolicitud);
        step1Request.setContratoCmodificarpNumContrato(contratoCTMODIFICARptpNumContrato);
        step1Request.setContratoCmodificarpFechaSolicitud(contratoCTMODIFICARptpFechaSolicitud);
        step1Request.setContratoCmodificarpTipoContrato(contratoCTMODIFICARptpTipoContrato);
        step1Request.setContratoCmodificarpFechaIniVigencia(contratoCTMODIFICARptpFechaIniVigencia);
        step1Request.setContratoCmodificarpDireccion(contratoCTMODIFICARptpDireccion);
        step1Request.setContratoCmodificarpcorreoContratante(contratoCTMODIFICARptpcorreoContratante);
        step1Request.setContratoCmodificarpnumTelContratante(contratoCTMODIFICARptpnumTelContratante);
        step1Request.setContratoCmodificarpnumCelContratante(contratoCTMODIFICARptpnumCelContratante);
        step1Request.setContratoCmodificarpexentoIVA(contratoCTMODIFICARptpexentoIVA);
        step1Request.setContratoCmodificarpContratoConFirma(contratoCTMODIFICARptpContratoConFirma);
        step1Request.setContratoCmodificarpFechaFinVigencia(contratoCTMODIFICARptpFechaFinVigencia);
        step1Request.setContratoCmodificarpUltimaActualizacion(STDFunctions.systemDateTimeFun());
        contratoCSrv.modificarImplementation(step1Request);

        /* Action 2: IF (PeriodicidadC <> ptpevcPeriodicidadC) */
        boolean ifCondition2 = !(contratoCTMODIFICARpthisContratoC.getPeriodicidadC().equalsObject(contratoCTMODIFICARptpevcPeriodicidadC));
        if (ifCondition2) {
            /* Action 20: IF (EXIST (PeriodicidadC) = true) */
            boolean ifCondition20 = repository.assocOperator011(contratoCTMODIFICARpthisContratoC).equals(true);
            if (ifCondition20) {
                com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelPeriodicidadRequest step200Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelPeriodicidadRequest();
                step200Request.setContratoCDelPeriodicidadpthisContratoCInstance(contratoCTMODIFICARpthisContratoC);
                step200Request.setContratoCDelPeriodicidadpevcPeriodicidadInstance(contratoCTMODIFICARpthisContratoC.getPeriodicidadC());
                contratoCSrv.delPeriodicidadImplementation(step200Request, true);
            }
            /* Action 21: IF (ptpevcPeriodicidadC <> NULL) */
            boolean ifCondition21 = (contratoCTMODIFICARptpevcPeriodicidadC != null && !contratoCTMODIFICARptpevcPeriodicidadC.isNull());
            if (ifCondition21) {
                com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsPeriodicidadRequest step210Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsPeriodicidadRequest();
                step210Request.setContratoCInsPeriodicidadpthisContratoCInstance(contratoCTMODIFICARpthisContratoC);
                step210Request.setContratoCInsPeriodicidadpevcPeriodicidadInstance(contratoCTMODIFICARptpevcPeriodicidadC);
                contratoCSrv.insPeriodicidadImplementation(step210Request, true);
            }
        }

        /* Action 3: IF (FormaPagoC <> ptpevcFormaPagoC) */
        boolean ifCondition3 = !(contratoCTMODIFICARpthisContratoC.getFormaPagoC().equalsObject(contratoCTMODIFICARptpevcFormaPagoC));
        if (ifCondition3) {
            /* Action 30: IF (EXIST (FormaPagoC) = true) */
            boolean ifCondition30 = repository.assocOperator012(contratoCTMODIFICARpthisContratoC).equals(true);
            if (ifCondition30) {
                com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelFormaPagoCRequest step300Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelFormaPagoCRequest();
                step300Request.setContratoCDelFormaPagoCpthisContratoCInstance(contratoCTMODIFICARpthisContratoC);
                step300Request.setContratoCDelFormaPagoCpevcFormaPagoInstance(contratoCTMODIFICARpthisContratoC.getFormaPagoC());
                contratoCSrv.delFormaPagoCImplementation(step300Request, true);
            }
            /* Action 31: IF (ptpevcFormaPagoC <> NULL) */
            boolean ifCondition31 = (contratoCTMODIFICARptpevcFormaPagoC != null && !contratoCTMODIFICARptpevcFormaPagoC.isNull());
            if (ifCondition31) {
                com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsFormaPagoCRequest step310Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsFormaPagoCRequest();
                step310Request.setContratoCInsFormaPagoCpthisContratoCInstance(contratoCTMODIFICARpthisContratoC);
                step310Request.setContratoCInsFormaPagoCpevcFormaPagoInstance(contratoCTMODIFICARptpevcFormaPagoC);
                contratoCSrv.insFormaPagoCImplementation(step310Request, true);
            }
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TMODIFICARESTADO

    /*
     * Entry point for service TMODIFICARESTADO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tMODIFICARESTADO(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TMODIFICARESTADORequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.tMODIFICARESTADOTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TMODIFICARESTADO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tMODIFICARESTADOTxn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TMODIFICARESTADORequest request) throws ModelException, SystemException {
        request.setContratoCTMODIFICARESTADOpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCTMODIFICARESTADOpthisContratoC()));
        request.setContratoCTMODIFICARESTADOptpevcEstadoContratoCInstance(estadoContratoSrv.getByOIDWithHV(request.getContratoCTMODIFICARESTADOptpevcEstadoContratoC()));
        return contratoCSrv.tMODIFICARESTADOImplementation(request);
    }

    /*
     * Implements service TMODIFICARESTADO
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tMODIFICARESTADOImplementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TMODIFICARESTADORequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        EstadoContrato contratoCTMODIFICARESTADOptpevcEstadoContratoC = request.getContratoCTMODIFICARESTADOptpevcEstadoContratoCInstance();
        ContratoC contratoCTMODIFICARESTADOpthisContratoC = request.getContratoCTMODIFICARESTADOpthisContratoCInstance();

        request.checkArguments();
        ContratoC instance = contratoCTMODIFICARESTADOpthisContratoC;

        boolean guard1 = repository.assocOperator013(contratoCTMODIFICARESTADOpthisContratoC).equals(false) && (contratoCTMODIFICARESTADOptpevcEstadoContratoC != null && !contratoCTMODIFICARESTADOptpevcEstadoContratoC.isNull());

        if (guard1) {
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsEstadoContratoCRequest step1Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsEstadoContratoCRequest();
            step1Request.setContratoCInsEstadoContratoCpthisContratoCInstance(contratoCTMODIFICARESTADOpthisContratoC);
            step1Request.setContratoCInsEstadoContratoCpevcEstadoContratoInstance(contratoCTMODIFICARESTADOptpevcEstadoContratoC);
            contratoCSrv.insEstadoContratoCImplementation(step1Request, true);
        }

        boolean guard2 = repository.assocOperator014(contratoCTMODIFICARESTADOpthisContratoC).equals(true) && (contratoCTMODIFICARESTADOptpevcEstadoContratoC == null || contratoCTMODIFICARESTADOptpevcEstadoContratoC.isNull());

        if (guard2) {
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelEstadoContratoCRequest step2Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelEstadoContratoCRequest();
            step2Request.setContratoCDelEstadoContratoCpthisContratoCInstance(contratoCTMODIFICARESTADOpthisContratoC);
            step2Request.setContratoCDelEstadoContratoCpevcEstadoContratoInstance(contratoCTMODIFICARESTADOpthisContratoC.getEstadoContratoC());
            contratoCSrv.delEstadoContratoCImplementation(step2Request, true);
        }

        /* Action 3: IF (EXIST (EstadoContratoC) = true AND ptpevcEstadoContratoC <> NULL AND EstadoContratoC <> ptpevcEstadoContratoC) */
        boolean ifCondition3 = repository.assocOperator016(contratoCTMODIFICARESTADOpthisContratoC).equals(true) && (contratoCTMODIFICARESTADOptpevcEstadoContratoC != null && !contratoCTMODIFICARESTADOptpevcEstadoContratoC.isNull()) && !(contratoCTMODIFICARESTADOpthisContratoC.getEstadoContratoC().equalsObject(contratoCTMODIFICARESTADOptpevcEstadoContratoC));
        if (ifCondition3) {
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelEstadoContratoCRequest step30Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelEstadoContratoCRequest();
            step30Request.setContratoCDelEstadoContratoCpthisContratoCInstance(contratoCTMODIFICARESTADOpthisContratoC);
            step30Request.setContratoCDelEstadoContratoCpevcEstadoContratoInstance(contratoCTMODIFICARESTADOpthisContratoC.getEstadoContratoC());
            contratoCSrv.delEstadoContratoCImplementation(step30Request, true);
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsEstadoContratoCRequest step31Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsEstadoContratoCRequest();
            step31Request.setContratoCInsEstadoContratoCpthisContratoCInstance(contratoCTMODIFICARESTADOpthisContratoC);
            step31Request.setContratoCInsEstadoContratoCpevcEstadoContratoInstance(contratoCTMODIFICARESTADOptpevcEstadoContratoC);
            contratoCSrv.insEstadoContratoCImplementation(step31Request, true);
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TCREAROMODDIRDEAE

    /*
     * Entry point for service TCREAROMODDIRDEAE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCREAROMODDIRDEAE(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TCREAROMODDIRDEAERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.tCREAROMODDIRDEAETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREAROMODDIRDEAE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCREAROMODDIRDEAETxn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TCREAROMODDIRDEAERequest request) throws ModelException, SystemException {
        request.setContratoCTCREAROMODDIRDEAEpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCTCREAROMODDIRDEAEpthisContratoC()));
        request.setContratoCTCREAROMODDIRDEAEpSolicitudAEInstance(solicitudSrv.getByOIDWithHV(request.getContratoCTCREAROMODDIRDEAEpSolicitudAE()));
        return contratoCSrv.tCREAROMODDIRDEAEImplementation(request);
    }

    /*
     * Implements service TCREAROMODDIRDEAE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCREAROMODDIRDEAEImplementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TCREAROMODDIRDEAERequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAE = request.getContratoCTCREAROMODDIRDEAEpSolicitudAEInstance();
        ContratoC contratoCTCREAROMODDIRDEAEpthisContratoC = request.getContratoCTCREAROMODDIRDEAEpthisContratoCInstance();

        request.checkArguments();
        ContratoC instance = contratoCTCREAROMODDIRDEAEpthisContratoC;

        /* Action 1: IF (EXIST (pSolicitudAE.Direccion) = true) */
        boolean ifCondition1 = repository.assocOperator020(contratoCTCREAROMODDIRDEAEpSolicitudAE).equals(true);
        if (ifCondition1) {
            for(DireccionC step1010Entity : repository.assocOperator018(contratoCTCREAROMODDIRDEAEpthisContratoC, contratoCTCREAROMODDIRDEAEpSolicitudAE)) {
                com.keralty.aesolicitudes.viewmodel.direccionc.siu.TMODIFICARRequest step10Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.TMODIFICARRequest();
                step10Request.setDireccionCTMODIFICARpthisDireccionCInstance(step1010Entity);
                step10Request.setDireccionCTMODIFICARptpDireccionCompleta(contratoCTCREAROMODDIRDEAEpSolicitudAE.getDireccion().getDireccionDireccionCompleta());
                step10Request.setDireccionCTMODIFICARptpevcDepartamentoCInstance(contratoCTCREAROMODDIRDEAEpSolicitudAE.getDireccion().getDepartamento());
                step10Request.setDireccionCTMODIFICARptpevcMunicipioCInstance(contratoCTCREAROMODDIRDEAEpSolicitudAE.getDireccion().getMunicipio());
                step10Request.setDireccionCTMODIFICARptpevcPaisCInstance(contratoCTCREAROMODDIRDEAEpSolicitudAE.getDireccion().getPais());
                step10Request.setDireccionCTMODIFICARptpevcTipoDireccionCInstance(step1010Entity.getTipoDireccionC());
                step10Request.setDireccionCTMODIFICARptpLocalidad(step1010Entity.getDireccionCLocalidad());
                direccionCSrv.tMODIFICARImplementation(step10Request);
            }
            /* Action 11: IF (EXIST (DireccionesC) WHERE (DireccionesC.TipoDireccionC = pSolicitudAE.Direccion.TipoDireccion) = false) */
            boolean ifCondition11 = repository.assocOperator021(contratoCTCREAROMODDIRDEAEpthisContratoC, contratoCTCREAROMODDIRDEAEpSolicitudAE).equals(false);
            if (ifCondition11) {
                com.keralty.aesolicitudes.viewmodel.direccionc.siu.TCREARRequest step110Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.TCREARRequest();
                step110Request.setDireccionCTCREARpagrDepartamentoCInstance(contratoCTCREAROMODDIRDEAEpSolicitudAE.getDireccion().getDepartamento());
                step110Request.setDireccionCTCREARpagrMunicipioCInstance(contratoCTCREAROMODDIRDEAEpSolicitudAE.getDireccion().getMunicipio());
                step110Request.setDireccionCTCREARpagrTipoDireccionCInstance(contratoCTCREAROMODDIRDEAEpSolicitudAE.getDireccion().getTipoDireccion());
                step110Request.setDireccionCTCREARpagrPaisCInstance(contratoCTCREAROMODDIRDEAEpSolicitudAE.getDireccion().getPais());
                step110Request.setDireccionCTCREARpagrPersonaCInstance(null);
                step110Request.setDireccionCTCREARpatrDireccionCompleta(contratoCTCREAROMODDIRDEAEpSolicitudAE.getDireccion().getDireccionDireccionCompleta());
                step110Request.setDireccionCTCREARpatrLocalidad(null);
                step110Request.setDireccionCTCREARpTelefonoFijo(contratoCTCREAROMODDIRDEAEpSolicitudAE.getContratante().getContratanteTelefonoFijo());
                step110Request.setDireccionCTCREARpTelefonoCelular(contratoCTCREAROMODDIRDEAEpSolicitudAE.getContratante().getContratanteTelefonoCelular());
                step110Request.setDireccionCTCREARpagrContratoCInstance(contratoCTCREAROMODDIRDEAEpthisContratoC);
                direccionCSrv.tCREARImplementation(step110Request);
            }
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TELIMINARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.tELIMINARTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TELIMINARRequest request) throws ModelException, SystemException {
        request.setContratoCTELIMINARpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCTELIMINARpthisContratoC()));
        return contratoCSrv.tELIMINARImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TELIMINARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCTELIMINARpthisContratoC = request.getContratoCTELIMINARpthisContratoCInstance();

        request.checkArguments();
        ContratoC instance = contratoCTELIMINARpthisContratoC;

        for(FamiliaC step1Entity : repository.assocOperator022(contratoCTELIMINARpthisContratoC)) {
            com.keralty.aesolicitudes.viewmodel.familiac.siu.TELIMINARRequest step1Request = new com.keralty.aesolicitudes.viewmodel.familiac.siu.TELIMINARRequest();
            step1Request.setFamiliaCTELIMINARpthisFamiliaCInstance(step1Entity);
            familiaCSrv.tELIMINARImplementation(step1Request);
        }

        /* Action 2: IF (EXIST (PersonaCContratante) = true) */
        boolean ifCondition2 = repository.assocOperator026(contratoCTELIMINARpthisContratoC).equals(true);
        if (ifCondition2) {
            com.keralty.aesolicitudes.viewmodel.personac.siu.TELIMINARRequest step20Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.TELIMINARRequest();
            step20Request.setPersonaCTELIMINARpthisPersonaCInstance(contratoCTELIMINARpthisContratoC.getPersonaCContratante());
            personaCSrv.tELIMINARImplementation(step20Request);
        }

        for(ObservacionesC step3Entity : repository.assocOperator024(contratoCTELIMINARpthisContratoC)) {
            com.keralty.aesolicitudes.viewmodel.observacionesc.siu.EliminarRequest step3Request = new com.keralty.aesolicitudes.viewmodel.observacionesc.siu.EliminarRequest();
            step3Request.setObservacionesCeliminarpthisObservacionesCInstance(step3Entity);
            observacionesCSrv.eliminarImplementation(step3Request);
        }

        for(DireccionC step4Entity : repository.assocOperator025(contratoCTELIMINARpthisContratoC)) {
            com.keralty.aesolicitudes.viewmodel.direccionc.siu.TELIMINARRequest step4Request = new com.keralty.aesolicitudes.viewmodel.direccionc.siu.TELIMINARRequest();
            step4Request.setDireccionCTELIMINARpthisDireccionCInstance(step4Entity);
            direccionCSrv.tELIMINARImplementation(step4Request);
        }

        com.keralty.aesolicitudes.viewmodel.contratoc.siu.EliminarRequest step5Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.EliminarRequest();
        step5Request.setContratoCeliminarpthisContratoCInstance(contratoCTELIMINARpthisContratoC);
        contratoCSrv.eliminarImplementation(step5Request);

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
    public com.keralty.aesolicitudes.viewmodel.contratoc.siu.TNEWDESDEAEResponse tNEWDESDEAE(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TNEWDESDEAERequest request) {
        com.keralty.aesolicitudes.viewmodel.contratoc.siu.TNEWDESDEAEResponse response = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.TNEWDESDEAEResponse();
        try {
            response = contratoCSrv.tNEWDESDEAETxn(request);
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
    public com.keralty.aesolicitudes.viewmodel.contratoc.siu.TNEWDESDEAEResponse tNEWDESDEAETxn(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TNEWDESDEAERequest request) throws ModelException, SystemException {
        request.setContratoCTNEWDESDEAEptSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getContratoCTNEWDESDEAEptSolicitud()));
        return contratoCSrv.tNEWDESDEAEImplementation(request);
    }

    /*
     * Implements service TNEWDESDEAE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aesolicitudes.viewmodel.contratoc.siu.TNEWDESDEAEResponse tNEWDESDEAEImplementation(
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TNEWDESDEAERequest request) throws ModelException, SystemException {
        com.keralty.aesolicitudes.viewmodel.contratoc.siu.TNEWDESDEAEResponse response = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.TNEWDESDEAEResponse();
        Solicitud contratoCTNEWDESDEAEptSolicitud = request.getContratoCTNEWDESDEAEptSolicitudInstance();
        String contratoCTNEWDESDEAEptNumFamiliaCORE = request.getContratoCTNEWDESDEAEptNumFamiliaCORE();

        request.checkArguments();
        ContratoC instance;

        /* Action 1: IF (ptSolicitud.Aesolicitudes.Tiposolicitud = "E") */
        boolean ifCondition1 = (contratoCTNEWDESDEAEptSolicitud.getAesolicitudes().getAesolicitudesTiposolicitud()).equals("E");
        if (ifCondition1) {
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.CrearRequest step10Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.CrearRequest();
            step10Request.setContratoCcrearpagrPersonaCContratanteInstance(null);
            step10Request.setContratoCcrearpagrPeriodicidadCInstance(contratoCTNEWDESDEAEptSolicitud.getPeriodicidad());
            step10Request.setContratoCcrearpagrFormaPagoCInstance(contratoCTNEWDESDEAEptSolicitud.getFormaPago());
            step10Request.setContratoCcrearpagrEstadoContratoCInstance(null);
            step10Request.setContratoCcrearpagrProductoCInstance(contratoCTNEWDESDEAEptSolicitud.getAesolicitudes().getProductoT());
            step10Request.setContratoCcrearpagrPlanCInstance(contratoCTNEWDESDEAEptSolicitud.getAesolicitudes().getPlanT());
            step10Request.setContratoCcrearpagrTarifaCInstance(null);
            step10Request.setContratoCcrearpagrGrupoAsociadoCInstance(contratoCTNEWDESDEAEptSolicitud.getGrupoAsociado());
            step10Request.setContratoCcrearpagrMunicipioCInstance(contratoCTNEWDESDEAEptSolicitud.getDireccion().getMunicipio());
            step10Request.setContratoCcrearpagrSucursalCInstance(contratoCTNEWDESDEAEptSolicitud.getAgente().getSucursal());
            step10Request.setContratoCcrearpagrAsesorCInstance(contratoCTNEWDESDEAEptSolicitud.getAgente().getAsesorFacet());
            step10Request.setContratoCcrearpatrNumSolicitud(STDFunctions.intToStrFun(contratoCTNEWDESDEAEptSolicitud.getSolicitudNumRadicado()));
            step10Request.setContratoCcrearpatrFechaSolicitud(contratoCTNEWDESDEAEptSolicitud.getAesolicitudes().getAesolicitudesFechaasignacion());
            step10Request.setContratoCcrearpatrTipoContrato(contratoCTNEWDESDEAEptSolicitud.getSolicitudtipoContrato());
            step10Request.setContratoCcrearpatrFechaIniVigencia(contratoCTNEWDESDEAEptSolicitud.getSolicitudFInicioContrato());
            step10Request.setContratoCcrearpatrDireccion(contratoCTNEWDESDEAEptSolicitud.getDireccion().getDireccionDireccionCompleta());
            step10Request.setContratoCcrearpatrcorreoContratante(contratoCTNEWDESDEAEptSolicitud.getContratante().getContratanteCorreoElectronico());
            step10Request.setContratoCcrearpatrnumTelContratante(contratoCTNEWDESDEAEptSolicitud.getContratante().getContratanteTelefonoFijo());
            step10Request.setContratoCcrearpatrnumCelContratante(contratoCTNEWDESDEAEptSolicitud.getContratante().getContratanteTelefonoCelular());
            step10Request.setContratoCcrearpatrexentoIVA(contratoCTNEWDESDEAEptSolicitud.getSolicitudexentoIVA());
            step10Request.setContratoCcrearpatrContratoConFirma(contratoCTNEWDESDEAEptSolicitud.getSolicitudcontratoConFirma());
            step10Request.setContratoCcrearpatrNumContrato(null);
            step10Request.setContratoCcrearpatrFechaFinVigencia(null);
            step10Request.setContratoCcrearpatrUltimaActualizacion(STDFunctions.systemDateTimeFun());
            step10Request.setContratoCcrearpatrCodTarifa(userFunctionsSrv.fuGetCodTarifaProdPlanAnyoFun(contratoCTNEWDESDEAEptSolicitud.getAesolicitudes().getProductoT(), contratoCTNEWDESDEAEptSolicitud.getAesolicitudes().getPlanT(), STDFunctions.getYearFun(contratoCTNEWDESDEAEptSolicitud.getSolicitudFInicioContrato()), contratoCTNEWDESDEAEptSolicitud.getSolicitudtipoContrato()));
            instance = (ContratoC) contratoCSrv.crearImplementation(step10Request).getInstance();
        } else {
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.CrearRequest step11Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.CrearRequest();
            step11Request.setContratoCcrearpagrPersonaCContratanteInstance(null);
            step11Request.setContratoCcrearpagrPeriodicidadCInstance(null);
            step11Request.setContratoCcrearpagrFormaPagoCInstance(null);
            step11Request.setContratoCcrearpagrEstadoContratoCInstance(null);
            step11Request.setContratoCcrearpagrProductoCInstance(contratoCTNEWDESDEAEptSolicitud.getAesolicitudes().getProductoT());
            step11Request.setContratoCcrearpagrPlanCInstance(contratoCTNEWDESDEAEptSolicitud.getAesolicitudes().getPlanT());
            step11Request.setContratoCcrearpagrTarifaCInstance(null);
            step11Request.setContratoCcrearpagrGrupoAsociadoCInstance(null);
            step11Request.setContratoCcrearpagrMunicipioCInstance(null);
            step11Request.setContratoCcrearpagrSucursalCInstance(null);
            step11Request.setContratoCcrearpagrAsesorCInstance(null);
            step11Request.setContratoCcrearpatrNumSolicitud(contratoCTNEWDESDEAEptSolicitud.getAesolicitudes().getAesolicitudesNumerosolicitud());
            step11Request.setContratoCcrearpatrFechaSolicitud(null);
            step11Request.setContratoCcrearpatrTipoContrato(null);
            step11Request.setContratoCcrearpatrFechaIniVigencia(null);
            step11Request.setContratoCcrearpatrDireccion(null);
            step11Request.setContratoCcrearpatrcorreoContratante(null);
            step11Request.setContratoCcrearpatrnumTelContratante(null);
            step11Request.setContratoCcrearpatrnumCelContratante(null);
            step11Request.setContratoCcrearpatrexentoIVA(null);
            step11Request.setContratoCcrearpatrContratoConFirma(null);
            step11Request.setContratoCcrearpatrNumContrato(null);
            step11Request.setContratoCcrearpatrFechaFinVigencia(null);
            step11Request.setContratoCcrearpatrUltimaActualizacion(STDFunctions.systemDateTimeFun());
            step11Request.setContratoCcrearpatrCodTarifa(null);
            instance = (ContratoC) contratoCSrv.crearImplementation(step11Request).getInstance();
        }

        com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsContratoCASolicitudRequest step2Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsContratoCASolicitudRequest();
        step2Request.setContratoCInsContratoCASolicitudpthisContratoCInstance(instance);
        step2Request.setContratoCInsContratoCASolicitudpevcSolicitudInstance(contratoCTNEWDESDEAEptSolicitud);
        contratoCSrv.insContratoCASolicitudImplementation(step2Request, true);

        /* Action 3: IF (ptSolicitud.Aesolicitudes.Tiposolicitud = "E") */
        boolean ifCondition3 = (contratoCTNEWDESDEAEptSolicitud.getAesolicitudes().getAesolicitudesTiposolicitud()).equals("E");
        if (ifCondition3) {
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TCREAROMODDIRDEAERequest step30Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.TCREAROMODDIRDEAERequest();
            step30Request.setContratoCTCREAROMODDIRDEAEpthisContratoCInstance(instance);
            step30Request.setContratoCTCREAROMODDIRDEAEpSolicitudAEInstance(contratoCTNEWDESDEAEptSolicitud);
            contratoCSrv.tCREAROMODDIRDEAEImplementation(step30Request);
            com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWCONTRADESDEAERequest step31Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWCONTRADESDEAERequest();
            step31Request.setPersonaCTNEWCONTRADESDEAEptSolicitudInstance(contratoCTNEWDESDEAEptSolicitud);
            step31Request.setPersonaCTNEWCONTRADESDEAEptContratoInstance(instance);
            personaCSrv.tNEWCONTRADESDEAEImplementation(step31Request);
            /* Action 32: IF (ptSolicitud.observacions <> NULL) */
            boolean ifCondition32 = contratoCTNEWDESDEAEptSolicitud.getSolicitudobservacions() != null;
            if (ifCondition32) {
                com.keralty.aesolicitudes.viewmodel.contratoc.siu.TCREAROBS100Request step320Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.TCREAROBS100Request();
                step320Request.setContratoCTCREAROBS100pthisContratoCInstance(instance);
                step320Request.setContratoCTCREAROBS100pObsText(contratoCTNEWDESDEAEptSolicitud.getSolicitudobservacions());
                contratoCSrv.tCREAROBS100Implementation(step320Request);
            }
            com.keralty.aesolicitudes.viewmodel.familiac.siu.TNEWDESDEAERequest step33Request = new com.keralty.aesolicitudes.viewmodel.familiac.siu.TNEWDESDEAERequest();
            step33Request.setFamiliaCTNEWDESDEAEptContratoCInstance(instance);
            step33Request.setFamiliaCTNEWDESDEAEptSolicitudInstance(contratoCTNEWDESDEAEptSolicitud);
            step33Request.setFamiliaCTNEWDESDEAEptNumFamiliaCORE(contratoCTNEWDESDEAEptNumFamiliaCORE);
            familiaCSrv.tNEWDESDEAEImplementation(step33Request);
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.CalcularLiquidacionRequest step34Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.CalcularLiquidacionRequest();
            step34Request.setContratoCCalcularLiquidacionpthisContratoCInstance(instance);
            contratoCSrv.calcularLiquidacionImplementation(step34Request);
        } else {
            com.keralty.aesolicitudes.viewmodel.familiac.siu.CrearRequest step35Request = new com.keralty.aesolicitudes.viewmodel.familiac.siu.CrearRequest();
            step35Request.setFamiliaCcrearpagrPersonaCTitularInstance(null);
            step35Request.setFamiliaCcrearpagrContratoCInstance(instance);
            step35Request.setFamiliaCcrearpagrMunicipioCInstance(null);
            step35Request.setFamiliaCcrearpatrTitularConBeneficios(Boolean.FALSE);
            step35Request.setFamiliaCcrearpatrdireccionCorrespondencia(null);
            step35Request.setFamiliaCcrearpatrEstadoTitularFamilia(null);
            step35Request.setFamiliaCcrearpatrFechaFinVigencia(null);
            step35Request.setFamiliaCcrearpatrNumFamilia(null);
            familiaCSrv.crearImplementation(step35Request);
            
        }

        response.setInstance(getByOID(instance.getOid()));

        // Value expressions for outgoing argument 'contratoCTNEWDESDEAEpsContratoC'
        // DEFAULT  : THIS
        response.setContratoCTNEWDESDEAEpsContratoCInstance(instance);


        // Value expressions for outgoing argument 'contratoCTNEWDESDEAEpsNumContrato'
        // CONDITION: NumContrato <> NULL
        // EFFECT   : NumContrato
        if (instance.getContratoCNumContrato() != null) {
            response.setContratoCTNEWDESDEAEpsNumContrato(instance.getContratoCNumContrato());
        }
         else {
            // DEFAULT  : "0"
            response.setContratoCTNEWDESDEAEpsNumContrato("0");
        }


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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TPOSTNOTICREARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.tPOSTNOTICREARTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TPOSTNOTICREARRequest request) throws ModelException, SystemException {
        request.setContratoCTPOSTNOTICREARpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCTPOSTNOTICREARpthisContratoC()));
        request.setContratoCTPOSTNOTICREARptAsesorSolicitudInstance(asesorSrv.getByOIDWithHV(request.getContratoCTPOSTNOTICREARptAsesorSolicitud()));
        request.setContratoCTPOSTNOTICREARptPeriodicidadInstance(periodicidadSrv.getByOIDWithHV(request.getContratoCTPOSTNOTICREARptPeriodicidad()));
        request.setContratoCTPOSTNOTICREARptProductoInstance(productosSrv.getByOIDWithHV(request.getContratoCTPOSTNOTICREARptProducto()));
        request.setContratoCTPOSTNOTICREARptPlanInstance(planesSrv.getByOIDWithHV(request.getContratoCTPOSTNOTICREARptPlan()));
        request.setContratoCTPOSTNOTICREARptMunicipioDireccionInstance(municipioSrv.getByOIDWithHV(request.getContratoCTPOSTNOTICREARptMunicipioDireccion()));
        request.setContratoCTPOSTNOTICREARptTipoIdContratanteInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getContratoCTPOSTNOTICREARptTipoIdContratante()));
        request.setContratoCTPOSTNOTICREARptTipoIdTitularInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getContratoCTPOSTNOTICREARptTipoIdTitular()));
        request.setContratoCTPOSTNOTICREARptMunicipioDireccionTitularInstance(municipioSrv.getByOIDWithHV(request.getContratoCTPOSTNOTICREARptMunicipioDireccionTitular()));
        return contratoCSrv.tPOSTNOTICREARImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.TPOSTNOTICREARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        String contratoCTPOSTNOTICREARptpeNumContrato = request.getContratoCTPOSTNOTICREARptpeNumContrato();
        Long contratoCTPOSTNOTICREARptCodTipoContrato = request.getContratoCTPOSTNOTICREARptCodTipoContrato();
        Date contratoCTPOSTNOTICREARptpeFechaIniVigencia = request.getContratoCTPOSTNOTICREARptpeFechaIniVigencia();
        String contratoCTPOSTNOTICREARptDireccionCompletaContrato = request.getContratoCTPOSTNOTICREARptDireccionCompletaContrato();
        String contratoCTPOSTNOTICREARptTelefonoContratante = request.getContratoCTPOSTNOTICREARptTelefonoContratante();
        String contratoCTPOSTNOTICREARptCelularContratante = request.getContratoCTPOSTNOTICREARptCelularContratante();
        Date contratoCTPOSTNOTICREARptpeFechaFinVigencia = request.getContratoCTPOSTNOTICREARptpeFechaFinVigencia();
        TipoIdentificacion contratoCTPOSTNOTICREARptTipoIdContratante = request.getContratoCTPOSTNOTICREARptTipoIdContratanteInstance();
        String contratoCTPOSTNOTICREARptNumIdentificacionContratante = request.getContratoCTPOSTNOTICREARptNumIdentificacionContratante();
        String contratoCTPOSTNOTICREARptNombreCompletoContratante = request.getContratoCTPOSTNOTICREARptNombreCompletoContratante();
        Municipio contratoCTPOSTNOTICREARptMunicipioDireccion = request.getContratoCTPOSTNOTICREARptMunicipioDireccionInstance();
        Asesor contratoCTPOSTNOTICREARptAsesorSolicitud = request.getContratoCTPOSTNOTICREARptAsesorSolicitudInstance();
        Periodicidad contratoCTPOSTNOTICREARptPeriodicidad = request.getContratoCTPOSTNOTICREARptPeriodicidadInstance();
        Productos contratoCTPOSTNOTICREARptProducto = request.getContratoCTPOSTNOTICREARptProductoInstance();
        Planes contratoCTPOSTNOTICREARptPlan = request.getContratoCTPOSTNOTICREARptPlanInstance();
        String contratoCTPOSTNOTICREARptNumFamilia = request.getContratoCTPOSTNOTICREARptNumFamilia();
        String contratoCTPOSTNOTICREARptDireccionCompletaTitular = request.getContratoCTPOSTNOTICREARptDireccionCompletaTitular();
        Municipio contratoCTPOSTNOTICREARptMunicipioDireccionTitular = request.getContratoCTPOSTNOTICREARptMunicipioDireccionTitularInstance();
        TipoIdentificacion contratoCTPOSTNOTICREARptTipoIdTitular = request.getContratoCTPOSTNOTICREARptTipoIdTitularInstance();
        String contratoCTPOSTNOTICREARptNumIdentificacionTitular = request.getContratoCTPOSTNOTICREARptNumIdentificacionTitular();
        String contratoCTPOSTNOTICREARptNombreCompletoTitular = request.getContratoCTPOSTNOTICREARptNombreCompletoTitular();
        ContratoC contratoCTPOSTNOTICREARpthisContratoC = request.getContratoCTPOSTNOTICREARpthisContratoCInstance();

        request.checkArguments();
        ContratoC instance = contratoCTPOSTNOTICREARpthisContratoC;

        com.keralty.aesolicitudes.viewmodel.contratoc.siu.EvalPostNotifCrearRequest step1Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.EvalPostNotifCrearRequest();
        step1Request.setContratoCevalPostNotifCrearpthisContratoCInstance(contratoCTPOSTNOTICREARpthisContratoC);
        step1Request.setContratoCevalPostNotifCrearpNumContrato(contratoCTPOSTNOTICREARptpeNumContrato);
        step1Request.setContratoCevalPostNotifCrearpTipoContrato(contratoCTPOSTNOTICREARptCodTipoContrato);
        step1Request.setContratoCevalPostNotifCrearpFechaIniVigencia(contratoCTPOSTNOTICREARptpeFechaIniVigencia);
        step1Request.setContratoCevalPostNotifCrearpDireccion(contratoCTPOSTNOTICREARptDireccionCompletaContrato);
        step1Request.setContratoCevalPostNotifCrearpnumTelContratante(contratoCTPOSTNOTICREARptTelefonoContratante);
        step1Request.setContratoCevalPostNotifCrearpnumCelContratante(contratoCTPOSTNOTICREARptCelularContratante);
        step1Request.setContratoCevalPostNotifCrearpFechaFinVigencia(contratoCTPOSTNOTICREARptpeFechaFinVigencia);
        contratoCSrv.evalPostNotifCrearImplementation(step1Request);

        /* Action 2: IF (ptTipoIdContratante <> NULL AND ptNumIdentificacionContratante <> NULL) */
        boolean ifCondition2 = (contratoCTPOSTNOTICREARptTipoIdContratante != null && !contratoCTPOSTNOTICREARptTipoIdContratante.isNull()) && contratoCTPOSTNOTICREARptNumIdentificacionContratante != null;
        if (ifCondition2) {
            /* Action 20: IF (EXIST (PersonaCContratante) = true) */
            boolean ifCondition20 = repository.assocOperator033(contratoCTPOSTNOTICREARpthisContratoC).equals(true);
            if (ifCondition20) {
                for(PersonaC step2200Entity : repository.assocOperator028(contratoCTPOSTNOTICREARpthisContratoC)) {
                    com.keralty.aesolicitudes.viewmodel.personac.siu.TMODIFICARRequest step200Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.TMODIFICARRequest();
                    step200Request.setPersonaCTMODIFICARpthisPersonaCInstance(step2200Entity);
                    step200Request.setPersonaCTMODIFICARptpeNombreCompleto(contratoCTPOSTNOTICREARptNombreCompletoContratante);
                    step200Request.setPersonaCTMODIFICARptpeNumIdent(contratoCTPOSTNOTICREARptNumIdentificacionContratante);
                    step200Request.setPersonaCTMODIFICARptpevcTipoIdentificacionInstance(contratoCTPOSTNOTICREARptTipoIdContratante);
                    personaCSrv.tMODIFICARImplementation(step200Request);
                }
            } else {
                com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWRequest step201Request = new com.keralty.aesolicitudes.viewmodel.personac.siu.TNEWRequest();
                step201Request.setPersonaCTNEWptpagrTipoInstitucionCInstance(null);
                step201Request.setPersonaCTNEWptpagrTipoEntidadCInstance(null);
                step201Request.setPersonaCTNEWptpagrEstadoCivilCInstance(null);
                step201Request.setPersonaCTNEWptpagrEstadoPersonaCInstance(null);
                step201Request.setPersonaCTNEWptpagrTipoIdentificacionCInstance(contratoCTPOSTNOTICREARptTipoIdContratante);
                step201Request.setPersonaCTNEWptpagrMunicipioCNacInstance(null);
                step201Request.setPersonaCTNEWptpagrDepartamentoCNacInstance(null);
                step201Request.setPersonaCTNEWptpagrContratosCInstance(contratoCTPOSTNOTICREARpthisContratoC);
                step201Request.setPersonaCTNEWptpagrFamiliasCInstance(null);
                step201Request.setPersonaCTNEWptpagrBeneficiariosCInstance(null);
                step201Request.setPersonaCTNEWptpatrNumIdentificacion(contratoCTPOSTNOTICREARptNumIdentificacionContratante);
                step201Request.setPersonaCTNEWptpatrMail(null);
                step201Request.setPersonaCTNEWptpatrPrimerNombre(null);
                step201Request.setPersonaCTNEWptpatrSegundoNombre(null);
                step201Request.setPersonaCTNEWptpatrPrimerApellido(null);
                step201Request.setPersonaCTNEWptpatrSegundoApellido(null);
                step201Request.setPersonaCTNEWptpatrFechaNacimiento(null);
                step201Request.setPersonaCTNEWptpatrGenero(null);
                step201Request.setPersonaCTNEWptpatrIndicadorExtranjero(Boolean.FALSE);
                step201Request.setPersonaCTNEWptpatrRazonSocial(null);
                step201Request.setPersonaCTNEWptpatrTieneEPSSanitas(Boolean.FALSE);
                step201Request.setPersonaCTNEWptpatrRechazadoAfiliacion(null);
                step201Request.setPersonaCTNEWptpatrNombreCompleto(contratoCTPOSTNOTICREARptNombreCompletoContratante);
                step201Request.setPersonaCTNEWptpatrCodigo(null);
                personaCSrv.tNEWImplementation(step201Request);
            }
        }

        /* Action 3: IF (MunicipioC <> ptMunicipioDireccion) */
        boolean ifCondition3 = !(contratoCTPOSTNOTICREARpthisContratoC.getMunicipioC().equalsObject(contratoCTPOSTNOTICREARptMunicipioDireccion));
        if (ifCondition3) {
            /* Action 30: IF (ptMunicipioDireccion <> NULL) */
            boolean ifCondition30 = (contratoCTPOSTNOTICREARptMunicipioDireccion != null && !contratoCTPOSTNOTICREARptMunicipioDireccion.isNull());
            if (ifCondition30) {
                /* Action 300: IF (EXIST (MunicipioC) = true) */
                boolean ifCondition300 = repository.assocOperator034(contratoCTPOSTNOTICREARpthisContratoC).equals(true);
                if (ifCondition300) {
                    com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelMunicipioContratoRequest step3000Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelMunicipioContratoRequest();
                    step3000Request.setContratoCDelMunicipioContratopthisContratoCInstance(contratoCTPOSTNOTICREARpthisContratoC);
                    step3000Request.setContratoCDelMunicipioContratopevcMunicipioInstance(contratoCTPOSTNOTICREARpthisContratoC.getMunicipioC());
                    contratoCSrv.delMunicipioContratoImplementation(step3000Request, true);
                }
                com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsMunicipioContratoRequest step301Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsMunicipioContratoRequest();
                step301Request.setContratoCInsMunicipioContratopthisContratoCInstance(contratoCTPOSTNOTICREARpthisContratoC);
                step301Request.setContratoCInsMunicipioContratopevcMunicipioInstance(contratoCTPOSTNOTICREARptMunicipioDireccion);
                contratoCSrv.insMunicipioContratoImplementation(step301Request, true);
            }
        }

        /* Action 4: IF (AsesorC <> ptAsesorSolicitud) */
        boolean ifCondition4 = !(contratoCTPOSTNOTICREARpthisContratoC.getAsesorC().equalsObject(contratoCTPOSTNOTICREARptAsesorSolicitud));
        if (ifCondition4) {
            /* Action 40: IF (ptAsesorSolicitud <> NULL) */
            boolean ifCondition40 = (contratoCTPOSTNOTICREARptAsesorSolicitud != null && !contratoCTPOSTNOTICREARptAsesorSolicitud.isNull());
            if (ifCondition40) {
                /* Action 400: IF (EXIST (AsesorC) = true) */
                boolean ifCondition400 = repository.assocOperator035(contratoCTPOSTNOTICREARpthisContratoC).equals(true);
                if (ifCondition400) {
                    com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelAsesorCRequest step4000Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelAsesorCRequest();
                    step4000Request.setContratoCDelAsesorCpthisContratoCInstance(contratoCTPOSTNOTICREARpthisContratoC);
                    step4000Request.setContratoCDelAsesorCpevcAsesorInstance(contratoCTPOSTNOTICREARpthisContratoC.getAsesorC());
                    contratoCSrv.delAsesorCImplementation(step4000Request, true);
                }
                com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsAsesorCRequest step401Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsAsesorCRequest();
                step401Request.setContratoCInsAsesorCpthisContratoCInstance(contratoCTPOSTNOTICREARpthisContratoC);
                step401Request.setContratoCInsAsesorCpevcAsesorInstance(contratoCTPOSTNOTICREARptAsesorSolicitud);
                contratoCSrv.insAsesorCImplementation(step401Request, true);
            }
        }

        /* Action 5: IF (PeriodicidadC <> ptPeriodicidad) */
        boolean ifCondition5 = !(contratoCTPOSTNOTICREARpthisContratoC.getPeriodicidadC().equalsObject(contratoCTPOSTNOTICREARptPeriodicidad));
        if (ifCondition5) {
            /* Action 50: IF (ptPeriodicidad <> NULL) */
            boolean ifCondition50 = (contratoCTPOSTNOTICREARptPeriodicidad != null && !contratoCTPOSTNOTICREARptPeriodicidad.isNull());
            if (ifCondition50) {
                /* Action 500: IF (EXIST (PeriodicidadC) = true) */
                boolean ifCondition500 = repository.assocOperator036(contratoCTPOSTNOTICREARpthisContratoC).equals(true);
                if (ifCondition500) {
                    com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelPeriodicidadRequest step5000Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.DelPeriodicidadRequest();
                    step5000Request.setContratoCDelPeriodicidadpthisContratoCInstance(contratoCTPOSTNOTICREARpthisContratoC);
                    step5000Request.setContratoCDelPeriodicidadpevcPeriodicidadInstance(contratoCTPOSTNOTICREARpthisContratoC.getPeriodicidadC());
                    contratoCSrv.delPeriodicidadImplementation(step5000Request, true);
                }
                com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsPeriodicidadRequest step501Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.InsPeriodicidadRequest();
                step501Request.setContratoCInsPeriodicidadpthisContratoCInstance(contratoCTPOSTNOTICREARpthisContratoC);
                step501Request.setContratoCInsPeriodicidadpevcPeriodicidadInstance(contratoCTPOSTNOTICREARptPeriodicidad);
                contratoCSrv.insPeriodicidadImplementation(step501Request, true);
            }
        }

        /* Action 6: IF (ProductoC <> ptProducto) */
        boolean ifCondition6 = !(contratoCTPOSTNOTICREARpthisContratoC.getProductoC().equalsObject(contratoCTPOSTNOTICREARptProducto));
        if (ifCondition6) {
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.ChgProductoCRequest step60Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.ChgProductoCRequest();
            step60Request.setContratoCchgProductoCpthisContratoCInstance(contratoCTPOSTNOTICREARpthisContratoC);
            step60Request.setContratoCchgProductoCpevcProductosInstance(contratoCTPOSTNOTICREARptProducto);
            contratoCSrv.chgProductoCImplementation(step60Request, true);
        }

        /* Action 7: IF (PlanC <> ptPlan) */
        boolean ifCondition7 = !(contratoCTPOSTNOTICREARpthisContratoC.getPlanC().equalsObject(contratoCTPOSTNOTICREARptPlan));
        if (ifCondition7) {
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.ChgPlanCRequest step70Request = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.ChgPlanCRequest();
            step70Request.setContratoCchgPlanCpthisContratoCInstance(contratoCTPOSTNOTICREARpthisContratoC);
            step70Request.setContratoCchgPlanCpevcPlanesInstance(contratoCTPOSTNOTICREARptPlan);
            contratoCSrv.chgPlanCImplementation(step70Request, true);
        }

        for(FamiliaC step8Entity : repository.assocOperator032(contratoCTPOSTNOTICREARpthisContratoC)) {
            com.keralty.aesolicitudes.viewmodel.familiac.siu.TPOSTNOTICREARRequest step8Request = new com.keralty.aesolicitudes.viewmodel.familiac.siu.TPOSTNOTICREARRequest();
            step8Request.setFamiliaCTPOSTNOTICREARpthisFamiliaCInstance(step8Entity);
            step8Request.setFamiliaCTPOSTNOTICREARptpeNumFamilia(contratoCTPOSTNOTICREARptNumFamilia);
            step8Request.setFamiliaCTPOSTNOTICREARptpeFechaFinVigencia(contratoCTPOSTNOTICREARptpeFechaFinVigencia);
            step8Request.setFamiliaCTPOSTNOTICREARptpeDirCorresp(contratoCTPOSTNOTICREARptDireccionCompletaTitular);
            step8Request.setFamiliaCTPOSTNOTICREARptMunicipioDireccionInstance(contratoCTPOSTNOTICREARptMunicipioDireccionTitular);
            step8Request.setFamiliaCTPOSTNOTICREARptTipoIdentTitularInstance(contratoCTPOSTNOTICREARptTipoIdTitular);
            step8Request.setFamiliaCTPOSTNOTICREARptNumIdentTitular(contratoCTPOSTNOTICREARptNumIdentificacionTitular);
            step8Request.setFamiliaCTPOSTNOTICREARptNombreCompletoTitular(contratoCTPOSTNOTICREARptNombreCompletoTitular);
            familiaCSrv.tPOSTNOTICREARImplementation(step8Request);
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
        select.getOrderByPart().addItem(Constants.normalizePath(ContratoCConstants.CLASS_NAME, ContratoCConstants.ATTR_FIELD_CONTRATOCID, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildContratoCRelatedInstance(relatedInstanceJsonOid);
        }
        if (ContratoCConstants.ROLE_NAME_SOLICITUD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4Solicitud(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_PERSONACCONTRATANTE.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4PersonaC(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_DIRECCIONESC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4DireccionC(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_OBSERVACIONESC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4ObservacionesC(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_BENEFICIARIOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4BeneficiarioC(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_FAMILIASC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4FamiliaC(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_PERIODICIDADC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4Periodicidad(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_FORMAPAGOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4FormaPago(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_ESTADOCONTRATOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4EstadoContrato(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_PRODUCTOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4Productos(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_PLANC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4Planes(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_TARIFAC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4Tarifa(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_GRUPOASOCIADOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4GrupoAsociado(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_MUNICIPIOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4Municipio(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_SUCURSALC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4Sucursal(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_ASESORC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4Asesor(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildContratoCRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new ContratoC(mapper.readValue(relatedInstanceJsonOid, ContratoCOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4Solicitud(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Solicitud(mapper.readValue(relatedInstanceJsonOid, SolicitudOid.class)): Solicitud.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4PersonaC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new PersonaC(mapper.readValue(relatedInstanceJsonOid, PersonaCOid.class)): PersonaC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4DireccionC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new DireccionC(mapper.readValue(relatedInstanceJsonOid, DireccionCOid.class)): DireccionC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4ObservacionesC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ObservacionesC(mapper.readValue(relatedInstanceJsonOid, ObservacionesCOid.class)): ObservacionesC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4BeneficiarioC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new BeneficiarioC(mapper.readValue(relatedInstanceJsonOid, BeneficiarioCOid.class)): BeneficiarioC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4FamiliaC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new FamiliaC(mapper.readValue(relatedInstanceJsonOid, FamiliaCOid.class)): FamiliaC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4Periodicidad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Periodicidad(mapper.readValue(relatedInstanceJsonOid, PeriodicidadOid.class)): Periodicidad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4FormaPago(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new FormaPago(mapper.readValue(relatedInstanceJsonOid, FormaPagoOid.class)): FormaPago.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4EstadoContrato(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new EstadoContrato(mapper.readValue(relatedInstanceJsonOid, EstadoContratoOid.class)): EstadoContrato.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4Productos(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Productos(mapper.readValue(relatedInstanceJsonOid, ProductosOid.class)): Productos.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4Planes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Planes(mapper.readValue(relatedInstanceJsonOid, PlanesOid.class)): Planes.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4Tarifa(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Tarifa(mapper.readValue(relatedInstanceJsonOid, TarifaOid.class)): Tarifa.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4GrupoAsociado(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new GrupoAsociado(mapper.readValue(relatedInstanceJsonOid, GrupoAsociadoOid.class)): GrupoAsociado.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4Municipio(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Municipio(mapper.readValue(relatedInstanceJsonOid, MunicipioOid.class)): Municipio.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4Sucursal(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Sucursal(mapper.readValue(relatedInstanceJsonOid, SucursalOid.class)): Sucursal.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4Asesor(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Asesor(mapper.readValue(relatedInstanceJsonOid, AsesorOid.class)): Asesor.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ContratoCOid oid = new ContratoCOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ContratoCConstants.ATTR_FIELD_CONTRATOCID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getContratoCID(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(ContratoCService.class).error(e.getMessage());
        }
    }

}
