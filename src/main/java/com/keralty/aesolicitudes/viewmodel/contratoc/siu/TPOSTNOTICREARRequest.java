package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.Asesor;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.AsesorOid;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;
import com.keralty.aesolicitudes.persistence.oid.PeriodicidadOid;
import com.keralty.aesolicitudes.persistence.oid.PlanesOid;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.oid.TipoIdentificacionOid;
import com.keralty.aesolicitudes.persistence.Periodicidad;
import com.keralty.aesolicitudes.persistence.Planes;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TPOSTNOTICREARRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCTPOSTNOTICREARpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCTPOSTNOTICREARpthisContratoCInstance;

    @JsonProperty("pt_penumcontrato")
    private String contratoCTPOSTNOTICREARptpeNumContrato;

    @JsonProperty("pt_pefechainivigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date contratoCTPOSTNOTICREARptpeFechaIniVigencia;

    @JsonProperty("pt_pefechafinvigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date contratoCTPOSTNOTICREARptpeFechaFinVigencia;

    @JsonProperty("ptnumfamilia")
    private String contratoCTPOSTNOTICREARptNumFamilia;

    @JsonProperty("ptasesorsolicitud_oid")
    private AsesorOid contratoCTPOSTNOTICREARptAsesorSolicitud;
    
    @JsonIgnore
    private Asesor contratoCTPOSTNOTICREARptAsesorSolicitudInstance;

    @JsonProperty("ptperiodicidad_oid")
    private PeriodicidadOid contratoCTPOSTNOTICREARptPeriodicidad;
    
    @JsonIgnore
    private Periodicidad contratoCTPOSTNOTICREARptPeriodicidadInstance;

    @JsonProperty("ptproducto_oid")
    private ProductosOid contratoCTPOSTNOTICREARptProducto;
    
    @JsonIgnore
    private Productos contratoCTPOSTNOTICREARptProductoInstance;

    @JsonProperty("ptplan_oid")
    private PlanesOid contratoCTPOSTNOTICREARptPlan;
    
    @JsonIgnore
    private Planes contratoCTPOSTNOTICREARptPlanInstance;

    @JsonProperty("ptcodtipocontrato")
    private Long contratoCTPOSTNOTICREARptCodTipoContrato;

    @JsonProperty("ptdireccioncompletacontrato")
    private String contratoCTPOSTNOTICREARptDireccionCompletaContrato;

    @JsonProperty("ptmunicipiodireccion_oid")
    private MunicipioOid contratoCTPOSTNOTICREARptMunicipioDireccion;
    
    @JsonIgnore
    private Municipio contratoCTPOSTNOTICREARptMunicipioDireccionInstance;

    @JsonProperty("pttelefonocontratante")
    private String contratoCTPOSTNOTICREARptTelefonoContratante;

    @JsonProperty("ptcelularcontratante")
    private String contratoCTPOSTNOTICREARptCelularContratante;

    @JsonProperty("pttipoidcontratante_oid")
    private TipoIdentificacionOid contratoCTPOSTNOTICREARptTipoIdContratante;
    
    @JsonIgnore
    private TipoIdentificacion contratoCTPOSTNOTICREARptTipoIdContratanteInstance;

    @JsonProperty("ptnumidentificacioncontratante")
    private String contratoCTPOSTNOTICREARptNumIdentificacionContratante;

    @JsonProperty("ptnombrecompletocontratante")
    private String contratoCTPOSTNOTICREARptNombreCompletoContratante;

    @JsonProperty("ptdireccioncompletatitular")
    private String contratoCTPOSTNOTICREARptDireccionCompletaTitular;

    @JsonProperty("pttipoidtitular_oid")
    private TipoIdentificacionOid contratoCTPOSTNOTICREARptTipoIdTitular;
    
    @JsonIgnore
    private TipoIdentificacion contratoCTPOSTNOTICREARptTipoIdTitularInstance;

    @JsonProperty("ptnumidentificaciontitular")
    private String contratoCTPOSTNOTICREARptNumIdentificacionTitular;

    @JsonProperty("ptnombrecompletotitular")
    private String contratoCTPOSTNOTICREARptNombreCompletoTitular;

    @JsonProperty("ptmunicipiodirecciontitular_oid")
    private MunicipioOid contratoCTPOSTNOTICREARptMunicipioDireccionTitular;
    
    @JsonIgnore
    private Municipio contratoCTPOSTNOTICREARptMunicipioDireccionTitularInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCTPOSTNOTICREARpthisContratoC();
        checkContratoCTPOSTNOTICREARptpeNumContrato();
        checkContratoCTPOSTNOTICREARptNumFamilia();
    }

    @JsonIgnore
    public ContratoCOid getContratoCTPOSTNOTICREARpthisContratoC() {
        return this.contratoCTPOSTNOTICREARpthisContratoC;
    }
    
    public void setContratoCTPOSTNOTICREARpthisContratoC(ContratoCOid contratoCTPOSTNOTICREARpthisContratoC) {
        this.contratoCTPOSTNOTICREARpthisContratoC = contratoCTPOSTNOTICREARpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCTPOSTNOTICREARpthisContratoCInstance() {
        return this.contratoCTPOSTNOTICREARpthisContratoCInstance;
    }
    
    public void setContratoCTPOSTNOTICREARpthisContratoCInstance(ContratoC contratoCTPOSTNOTICREARpthisContratoC) {
        this.contratoCTPOSTNOTICREARpthisContratoCInstance = contratoCTPOSTNOTICREARpthisContratoC;
        this.contratoCTPOSTNOTICREARpthisContratoC = contratoCTPOSTNOTICREARpthisContratoC != null ? contratoCTPOSTNOTICREARpthisContratoC.getOid() : null;
    }

    private void checkContratoCTPOSTNOTICREARpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCTPOSTNOTICREARpthisContratoCInstance() == null || this.getContratoCTPOSTNOTICREARpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_TPOSTNOTICREAR, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_TPOSTNOTICREAR_CONTRATOCTPOSTNOTICREARPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_TPOSTNOTICREAR, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_TPOSTNOTICREAR_CONTRATOCTPOSTNOTICREARPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public String getContratoCTPOSTNOTICREARptpeNumContrato() {
        return this.contratoCTPOSTNOTICREARptpeNumContrato;
    }
    
    public void setContratoCTPOSTNOTICREARptpeNumContrato(String contratoCTPOSTNOTICREARptpeNumContrato) {
        this.contratoCTPOSTNOTICREARptpeNumContrato = contratoCTPOSTNOTICREARptpeNumContrato;
    }

    private void checkContratoCTPOSTNOTICREARptpeNumContrato() throws NotNullArgumentException {
        if(this.getContratoCTPOSTNOTICREARptpeNumContrato() == null) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_TPOSTNOTICREAR, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_TPOSTNOTICREAR_CONTRATOCTPOSTNOTICREARPTPENUMCONTRATO, ContratoCConstants.SERV_ALIAS_TPOSTNOTICREAR, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_TPOSTNOTICREAR_CONTRATOCTPOSTNOTICREARPTPENUMCONTRATO);
        }
    }

    @JsonIgnore
    public Date getContratoCTPOSTNOTICREARptpeFechaIniVigencia() {
        return this.contratoCTPOSTNOTICREARptpeFechaIniVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setContratoCTPOSTNOTICREARptpeFechaIniVigencia(Date contratoCTPOSTNOTICREARptpeFechaIniVigencia) {
        this.contratoCTPOSTNOTICREARptpeFechaIniVigencia = contratoCTPOSTNOTICREARptpeFechaIniVigencia;
    }

    @JsonIgnore
    public Date getContratoCTPOSTNOTICREARptpeFechaFinVigencia() {
        return this.contratoCTPOSTNOTICREARptpeFechaFinVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setContratoCTPOSTNOTICREARptpeFechaFinVigencia(Date contratoCTPOSTNOTICREARptpeFechaFinVigencia) {
        this.contratoCTPOSTNOTICREARptpeFechaFinVigencia = contratoCTPOSTNOTICREARptpeFechaFinVigencia;
    }

    @JsonIgnore
    public String getContratoCTPOSTNOTICREARptNumFamilia() {
        return this.contratoCTPOSTNOTICREARptNumFamilia;
    }
    
    public void setContratoCTPOSTNOTICREARptNumFamilia(String contratoCTPOSTNOTICREARptNumFamilia) {
        this.contratoCTPOSTNOTICREARptNumFamilia = contratoCTPOSTNOTICREARptNumFamilia;
    }

    private void checkContratoCTPOSTNOTICREARptNumFamilia() throws NotNullArgumentException {
        if(this.getContratoCTPOSTNOTICREARptNumFamilia() == null) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_TPOSTNOTICREAR, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_TPOSTNOTICREAR_CONTRATOCTPOSTNOTICREARPTNUMFAMILIA, ContratoCConstants.SERV_ALIAS_TPOSTNOTICREAR, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_TPOSTNOTICREAR_CONTRATOCTPOSTNOTICREARPTNUMFAMILIA);
        }
    }

    @JsonIgnore
    public AsesorOid getContratoCTPOSTNOTICREARptAsesorSolicitud() {
        return this.contratoCTPOSTNOTICREARptAsesorSolicitud;
    }
    
    public void setContratoCTPOSTNOTICREARptAsesorSolicitud(AsesorOid contratoCTPOSTNOTICREARptAsesorSolicitud) {
        this.contratoCTPOSTNOTICREARptAsesorSolicitud = contratoCTPOSTNOTICREARptAsesorSolicitud;
    }

    @JsonIgnore
    public Asesor getContratoCTPOSTNOTICREARptAsesorSolicitudInstance() {
        return this.contratoCTPOSTNOTICREARptAsesorSolicitudInstance;
    }
    
    public void setContratoCTPOSTNOTICREARptAsesorSolicitudInstance(Asesor contratoCTPOSTNOTICREARptAsesorSolicitud) {
        this.contratoCTPOSTNOTICREARptAsesorSolicitudInstance = contratoCTPOSTNOTICREARptAsesorSolicitud;
        this.contratoCTPOSTNOTICREARptAsesorSolicitud = contratoCTPOSTNOTICREARptAsesorSolicitud != null ? contratoCTPOSTNOTICREARptAsesorSolicitud.getOid() : null;
    }

    @JsonIgnore
    public PeriodicidadOid getContratoCTPOSTNOTICREARptPeriodicidad() {
        return this.contratoCTPOSTNOTICREARptPeriodicidad;
    }
    
    public void setContratoCTPOSTNOTICREARptPeriodicidad(PeriodicidadOid contratoCTPOSTNOTICREARptPeriodicidad) {
        this.contratoCTPOSTNOTICREARptPeriodicidad = contratoCTPOSTNOTICREARptPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getContratoCTPOSTNOTICREARptPeriodicidadInstance() {
        return this.contratoCTPOSTNOTICREARptPeriodicidadInstance;
    }
    
    public void setContratoCTPOSTNOTICREARptPeriodicidadInstance(Periodicidad contratoCTPOSTNOTICREARptPeriodicidad) {
        this.contratoCTPOSTNOTICREARptPeriodicidadInstance = contratoCTPOSTNOTICREARptPeriodicidad;
        this.contratoCTPOSTNOTICREARptPeriodicidad = contratoCTPOSTNOTICREARptPeriodicidad != null ? contratoCTPOSTNOTICREARptPeriodicidad.getOid() : null;
    }

    @JsonIgnore
    public ProductosOid getContratoCTPOSTNOTICREARptProducto() {
        return this.contratoCTPOSTNOTICREARptProducto;
    }
    
    public void setContratoCTPOSTNOTICREARptProducto(ProductosOid contratoCTPOSTNOTICREARptProducto) {
        this.contratoCTPOSTNOTICREARptProducto = contratoCTPOSTNOTICREARptProducto;
    }

    @JsonIgnore
    public Productos getContratoCTPOSTNOTICREARptProductoInstance() {
        return this.contratoCTPOSTNOTICREARptProductoInstance;
    }
    
    public void setContratoCTPOSTNOTICREARptProductoInstance(Productos contratoCTPOSTNOTICREARptProducto) {
        this.contratoCTPOSTNOTICREARptProductoInstance = contratoCTPOSTNOTICREARptProducto;
        this.contratoCTPOSTNOTICREARptProducto = contratoCTPOSTNOTICREARptProducto != null ? contratoCTPOSTNOTICREARptProducto.getOid() : null;
    }

    @JsonIgnore
    public PlanesOid getContratoCTPOSTNOTICREARptPlan() {
        return this.contratoCTPOSTNOTICREARptPlan;
    }
    
    public void setContratoCTPOSTNOTICREARptPlan(PlanesOid contratoCTPOSTNOTICREARptPlan) {
        this.contratoCTPOSTNOTICREARptPlan = contratoCTPOSTNOTICREARptPlan;
    }

    @JsonIgnore
    public Planes getContratoCTPOSTNOTICREARptPlanInstance() {
        return this.contratoCTPOSTNOTICREARptPlanInstance;
    }
    
    public void setContratoCTPOSTNOTICREARptPlanInstance(Planes contratoCTPOSTNOTICREARptPlan) {
        this.contratoCTPOSTNOTICREARptPlanInstance = contratoCTPOSTNOTICREARptPlan;
        this.contratoCTPOSTNOTICREARptPlan = contratoCTPOSTNOTICREARptPlan != null ? contratoCTPOSTNOTICREARptPlan.getOid() : null;
    }

    @JsonIgnore
    public Long getContratoCTPOSTNOTICREARptCodTipoContrato() {
        return this.contratoCTPOSTNOTICREARptCodTipoContrato;
    }
    
    public void setContratoCTPOSTNOTICREARptCodTipoContrato(Long contratoCTPOSTNOTICREARptCodTipoContrato) {
        this.contratoCTPOSTNOTICREARptCodTipoContrato = contratoCTPOSTNOTICREARptCodTipoContrato;
    }

    @JsonIgnore
    public String getContratoCTPOSTNOTICREARptDireccionCompletaContrato() {
        return this.contratoCTPOSTNOTICREARptDireccionCompletaContrato;
    }
    
    public void setContratoCTPOSTNOTICREARptDireccionCompletaContrato(String contratoCTPOSTNOTICREARptDireccionCompletaContrato) {
        this.contratoCTPOSTNOTICREARptDireccionCompletaContrato = contratoCTPOSTNOTICREARptDireccionCompletaContrato;
    }

    @JsonIgnore
    public MunicipioOid getContratoCTPOSTNOTICREARptMunicipioDireccion() {
        return this.contratoCTPOSTNOTICREARptMunicipioDireccion;
    }
    
    public void setContratoCTPOSTNOTICREARptMunicipioDireccion(MunicipioOid contratoCTPOSTNOTICREARptMunicipioDireccion) {
        this.contratoCTPOSTNOTICREARptMunicipioDireccion = contratoCTPOSTNOTICREARptMunicipioDireccion;
    }

    @JsonIgnore
    public Municipio getContratoCTPOSTNOTICREARptMunicipioDireccionInstance() {
        return this.contratoCTPOSTNOTICREARptMunicipioDireccionInstance;
    }
    
    public void setContratoCTPOSTNOTICREARptMunicipioDireccionInstance(Municipio contratoCTPOSTNOTICREARptMunicipioDireccion) {
        this.contratoCTPOSTNOTICREARptMunicipioDireccionInstance = contratoCTPOSTNOTICREARptMunicipioDireccion;
        this.contratoCTPOSTNOTICREARptMunicipioDireccion = contratoCTPOSTNOTICREARptMunicipioDireccion != null ? contratoCTPOSTNOTICREARptMunicipioDireccion.getOid() : null;
    }

    @JsonIgnore
    public String getContratoCTPOSTNOTICREARptTelefonoContratante() {
        return this.contratoCTPOSTNOTICREARptTelefonoContratante;
    }
    
    public void setContratoCTPOSTNOTICREARptTelefonoContratante(String contratoCTPOSTNOTICREARptTelefonoContratante) {
        this.contratoCTPOSTNOTICREARptTelefonoContratante = contratoCTPOSTNOTICREARptTelefonoContratante;
    }

    @JsonIgnore
    public String getContratoCTPOSTNOTICREARptCelularContratante() {
        return this.contratoCTPOSTNOTICREARptCelularContratante;
    }
    
    public void setContratoCTPOSTNOTICREARptCelularContratante(String contratoCTPOSTNOTICREARptCelularContratante) {
        this.contratoCTPOSTNOTICREARptCelularContratante = contratoCTPOSTNOTICREARptCelularContratante;
    }

    @JsonIgnore
    public TipoIdentificacionOid getContratoCTPOSTNOTICREARptTipoIdContratante() {
        return this.contratoCTPOSTNOTICREARptTipoIdContratante;
    }
    
    public void setContratoCTPOSTNOTICREARptTipoIdContratante(TipoIdentificacionOid contratoCTPOSTNOTICREARptTipoIdContratante) {
        this.contratoCTPOSTNOTICREARptTipoIdContratante = contratoCTPOSTNOTICREARptTipoIdContratante;
    }

    @JsonIgnore
    public TipoIdentificacion getContratoCTPOSTNOTICREARptTipoIdContratanteInstance() {
        return this.contratoCTPOSTNOTICREARptTipoIdContratanteInstance;
    }
    
    public void setContratoCTPOSTNOTICREARptTipoIdContratanteInstance(TipoIdentificacion contratoCTPOSTNOTICREARptTipoIdContratante) {
        this.contratoCTPOSTNOTICREARptTipoIdContratanteInstance = contratoCTPOSTNOTICREARptTipoIdContratante;
        this.contratoCTPOSTNOTICREARptTipoIdContratante = contratoCTPOSTNOTICREARptTipoIdContratante != null ? contratoCTPOSTNOTICREARptTipoIdContratante.getOid() : null;
    }

    @JsonIgnore
    public String getContratoCTPOSTNOTICREARptNumIdentificacionContratante() {
        return this.contratoCTPOSTNOTICREARptNumIdentificacionContratante;
    }
    
    public void setContratoCTPOSTNOTICREARptNumIdentificacionContratante(String contratoCTPOSTNOTICREARptNumIdentificacionContratante) {
        this.contratoCTPOSTNOTICREARptNumIdentificacionContratante = contratoCTPOSTNOTICREARptNumIdentificacionContratante;
    }

    @JsonIgnore
    public String getContratoCTPOSTNOTICREARptNombreCompletoContratante() {
        return this.contratoCTPOSTNOTICREARptNombreCompletoContratante;
    }
    
    public void setContratoCTPOSTNOTICREARptNombreCompletoContratante(String contratoCTPOSTNOTICREARptNombreCompletoContratante) {
        this.contratoCTPOSTNOTICREARptNombreCompletoContratante = contratoCTPOSTNOTICREARptNombreCompletoContratante;
    }

    @JsonIgnore
    public String getContratoCTPOSTNOTICREARptDireccionCompletaTitular() {
        return this.contratoCTPOSTNOTICREARptDireccionCompletaTitular;
    }
    
    public void setContratoCTPOSTNOTICREARptDireccionCompletaTitular(String contratoCTPOSTNOTICREARptDireccionCompletaTitular) {
        this.contratoCTPOSTNOTICREARptDireccionCompletaTitular = contratoCTPOSTNOTICREARptDireccionCompletaTitular;
    }

    @JsonIgnore
    public TipoIdentificacionOid getContratoCTPOSTNOTICREARptTipoIdTitular() {
        return this.contratoCTPOSTNOTICREARptTipoIdTitular;
    }
    
    public void setContratoCTPOSTNOTICREARptTipoIdTitular(TipoIdentificacionOid contratoCTPOSTNOTICREARptTipoIdTitular) {
        this.contratoCTPOSTNOTICREARptTipoIdTitular = contratoCTPOSTNOTICREARptTipoIdTitular;
    }

    @JsonIgnore
    public TipoIdentificacion getContratoCTPOSTNOTICREARptTipoIdTitularInstance() {
        return this.contratoCTPOSTNOTICREARptTipoIdTitularInstance;
    }
    
    public void setContratoCTPOSTNOTICREARptTipoIdTitularInstance(TipoIdentificacion contratoCTPOSTNOTICREARptTipoIdTitular) {
        this.contratoCTPOSTNOTICREARptTipoIdTitularInstance = contratoCTPOSTNOTICREARptTipoIdTitular;
        this.contratoCTPOSTNOTICREARptTipoIdTitular = contratoCTPOSTNOTICREARptTipoIdTitular != null ? contratoCTPOSTNOTICREARptTipoIdTitular.getOid() : null;
    }

    @JsonIgnore
    public String getContratoCTPOSTNOTICREARptNumIdentificacionTitular() {
        return this.contratoCTPOSTNOTICREARptNumIdentificacionTitular;
    }
    
    public void setContratoCTPOSTNOTICREARptNumIdentificacionTitular(String contratoCTPOSTNOTICREARptNumIdentificacionTitular) {
        this.contratoCTPOSTNOTICREARptNumIdentificacionTitular = contratoCTPOSTNOTICREARptNumIdentificacionTitular;
    }

    @JsonIgnore
    public String getContratoCTPOSTNOTICREARptNombreCompletoTitular() {
        return this.contratoCTPOSTNOTICREARptNombreCompletoTitular;
    }
    
    public void setContratoCTPOSTNOTICREARptNombreCompletoTitular(String contratoCTPOSTNOTICREARptNombreCompletoTitular) {
        this.contratoCTPOSTNOTICREARptNombreCompletoTitular = contratoCTPOSTNOTICREARptNombreCompletoTitular;
    }

    @JsonIgnore
    public MunicipioOid getContratoCTPOSTNOTICREARptMunicipioDireccionTitular() {
        return this.contratoCTPOSTNOTICREARptMunicipioDireccionTitular;
    }
    
    public void setContratoCTPOSTNOTICREARptMunicipioDireccionTitular(MunicipioOid contratoCTPOSTNOTICREARptMunicipioDireccionTitular) {
        this.contratoCTPOSTNOTICREARptMunicipioDireccionTitular = contratoCTPOSTNOTICREARptMunicipioDireccionTitular;
    }

    @JsonIgnore
    public Municipio getContratoCTPOSTNOTICREARptMunicipioDireccionTitularInstance() {
        return this.contratoCTPOSTNOTICREARptMunicipioDireccionTitularInstance;
    }
    
    public void setContratoCTPOSTNOTICREARptMunicipioDireccionTitularInstance(Municipio contratoCTPOSTNOTICREARptMunicipioDireccionTitular) {
        this.contratoCTPOSTNOTICREARptMunicipioDireccionTitularInstance = contratoCTPOSTNOTICREARptMunicipioDireccionTitular;
        this.contratoCTPOSTNOTICREARptMunicipioDireccionTitular = contratoCTPOSTNOTICREARptMunicipioDireccionTitular != null ? contratoCTPOSTNOTICREARptMunicipioDireccionTitular.getOid() : null;
    }
}
