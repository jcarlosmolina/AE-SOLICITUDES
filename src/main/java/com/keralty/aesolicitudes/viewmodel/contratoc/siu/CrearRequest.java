package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.Asesor;
import com.keralty.aesolicitudes.persistence.EstadoContrato;
import com.keralty.aesolicitudes.persistence.FormaPago;
import com.keralty.aesolicitudes.persistence.GrupoAsociado;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.AsesorOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoContratoOid;
import com.keralty.aesolicitudes.persistence.oid.FormaPagoOid;
import com.keralty.aesolicitudes.persistence.oid.GrupoAsociadoOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;
import com.keralty.aesolicitudes.persistence.oid.PeriodicidadOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.PlanesOid;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.oid.SucursalOid;
import com.keralty.aesolicitudes.persistence.oid.TarifaOid;
import com.keralty.aesolicitudes.persistence.Periodicidad;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Planes;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.Sucursal;
import com.keralty.aesolicitudes.persistence.Tarifa;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;
import java.sql.Timestamp;

public class CrearRequest {

    @JsonProperty("p_agrpersonaccontratante_oid")
    private PersonaCOid contratoCcrearpagrPersonaCContratante;
    
    @JsonIgnore
    private PersonaC contratoCcrearpagrPersonaCContratanteInstance;

    @JsonProperty("p_agrperiodicidadc_oid")
    private PeriodicidadOid contratoCcrearpagrPeriodicidadC;
    
    @JsonIgnore
    private Periodicidad contratoCcrearpagrPeriodicidadCInstance;

    @JsonProperty("p_agrformapagoc_oid")
    private FormaPagoOid contratoCcrearpagrFormaPagoC;
    
    @JsonIgnore
    private FormaPago contratoCcrearpagrFormaPagoCInstance;

    @JsonProperty("p_agrestadocontratoc_oid")
    private EstadoContratoOid contratoCcrearpagrEstadoContratoC;
    
    @JsonIgnore
    private EstadoContrato contratoCcrearpagrEstadoContratoCInstance;

    @JsonProperty("p_agrproductoc_oid")
    private ProductosOid contratoCcrearpagrProductoC;
    
    @JsonIgnore
    private Productos contratoCcrearpagrProductoCInstance;

    @JsonProperty("p_agrplanc_oid")
    private PlanesOid contratoCcrearpagrPlanC;
    
    @JsonIgnore
    private Planes contratoCcrearpagrPlanCInstance;

    @JsonProperty("p_agrtarifac_oid")
    private TarifaOid contratoCcrearpagrTarifaC;
    
    @JsonIgnore
    private Tarifa contratoCcrearpagrTarifaCInstance;

    @JsonProperty("p_agrgrupoasociadoc_oid")
    private GrupoAsociadoOid contratoCcrearpagrGrupoAsociadoC;
    
    @JsonIgnore
    private GrupoAsociado contratoCcrearpagrGrupoAsociadoCInstance;

    @JsonProperty("p_agrmunicipioc_oid")
    private MunicipioOid contratoCcrearpagrMunicipioC;
    
    @JsonIgnore
    private Municipio contratoCcrearpagrMunicipioCInstance;

    @JsonProperty("p_agrsucursalc_oid")
    private SucursalOid contratoCcrearpagrSucursalC;
    
    @JsonIgnore
    private Sucursal contratoCcrearpagrSucursalCInstance;

    @JsonProperty("p_agrasesorc_oid")
    private AsesorOid contratoCcrearpagrAsesorC;
    
    @JsonIgnore
    private Asesor contratoCcrearpagrAsesorCInstance;

    @JsonProperty("p_atrnumsolicitud")
    private String contratoCcrearpatrNumSolicitud;

    @JsonProperty("p_atrfechasolicitud")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date contratoCcrearpatrFechaSolicitud;

    @JsonProperty("p_atrtipocontrato")
    private Long contratoCcrearpatrTipoContrato;

    @JsonProperty("p_atrfechainivigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date contratoCcrearpatrFechaIniVigencia;

    @JsonProperty("p_atrdireccion")
    private String contratoCcrearpatrDireccion;

    @JsonProperty("p_atrcorreocontratante")
    private String contratoCcrearpatrcorreoContratante;

    @JsonProperty("p_atrnumtelcontratante")
    private String contratoCcrearpatrnumTelContratante;

    @JsonProperty("p_atrnumcelcontratante")
    private String contratoCcrearpatrnumCelContratante;

    @JsonProperty("p_atrexentoiva")
    private String contratoCcrearpatrexentoIVA;

    @JsonProperty("p_atrcontratoconfirma")
    private Boolean contratoCcrearpatrContratoConFirma;

    @JsonProperty("p_atrnumcontrato")
    private String contratoCcrearpatrNumContrato;

    @JsonProperty("p_atrfechafinvigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date contratoCcrearpatrFechaFinVigencia;

    @JsonProperty("p_atrultimaactualizacion")
    private Timestamp contratoCcrearpatrUltimaActualizacion;

    @JsonProperty("p_atrcodtarifa")
    private String contratoCcrearpatrCodTarifa;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCcrearpagrProductoC();
        checkContratoCcrearpagrPlanC();
    }

    @JsonIgnore
    public PersonaCOid getContratoCcrearpagrPersonaCContratante() {
        return this.contratoCcrearpagrPersonaCContratante;
    }
    
    public void setContratoCcrearpagrPersonaCContratante(PersonaCOid contratoCcrearpagrPersonaCContratante) {
        this.contratoCcrearpagrPersonaCContratante = contratoCcrearpagrPersonaCContratante;
    }

    @JsonIgnore
    public PersonaC getContratoCcrearpagrPersonaCContratanteInstance() {
        return this.contratoCcrearpagrPersonaCContratanteInstance;
    }
    
    public void setContratoCcrearpagrPersonaCContratanteInstance(PersonaC contratoCcrearpagrPersonaCContratante) {
        this.contratoCcrearpagrPersonaCContratanteInstance = contratoCcrearpagrPersonaCContratante;
        this.contratoCcrearpagrPersonaCContratante = contratoCcrearpagrPersonaCContratante != null ? contratoCcrearpagrPersonaCContratante.getOid() : null;
    }

    @JsonIgnore
    public PeriodicidadOid getContratoCcrearpagrPeriodicidadC() {
        return this.contratoCcrearpagrPeriodicidadC;
    }
    
    public void setContratoCcrearpagrPeriodicidadC(PeriodicidadOid contratoCcrearpagrPeriodicidadC) {
        this.contratoCcrearpagrPeriodicidadC = contratoCcrearpagrPeriodicidadC;
    }

    @JsonIgnore
    public Periodicidad getContratoCcrearpagrPeriodicidadCInstance() {
        return this.contratoCcrearpagrPeriodicidadCInstance;
    }
    
    public void setContratoCcrearpagrPeriodicidadCInstance(Periodicidad contratoCcrearpagrPeriodicidadC) {
        this.contratoCcrearpagrPeriodicidadCInstance = contratoCcrearpagrPeriodicidadC;
        this.contratoCcrearpagrPeriodicidadC = contratoCcrearpagrPeriodicidadC != null ? contratoCcrearpagrPeriodicidadC.getOid() : null;
    }

    @JsonIgnore
    public FormaPagoOid getContratoCcrearpagrFormaPagoC() {
        return this.contratoCcrearpagrFormaPagoC;
    }
    
    public void setContratoCcrearpagrFormaPagoC(FormaPagoOid contratoCcrearpagrFormaPagoC) {
        this.contratoCcrearpagrFormaPagoC = contratoCcrearpagrFormaPagoC;
    }

    @JsonIgnore
    public FormaPago getContratoCcrearpagrFormaPagoCInstance() {
        return this.contratoCcrearpagrFormaPagoCInstance;
    }
    
    public void setContratoCcrearpagrFormaPagoCInstance(FormaPago contratoCcrearpagrFormaPagoC) {
        this.contratoCcrearpagrFormaPagoCInstance = contratoCcrearpagrFormaPagoC;
        this.contratoCcrearpagrFormaPagoC = contratoCcrearpagrFormaPagoC != null ? contratoCcrearpagrFormaPagoC.getOid() : null;
    }

    @JsonIgnore
    public EstadoContratoOid getContratoCcrearpagrEstadoContratoC() {
        return this.contratoCcrearpagrEstadoContratoC;
    }
    
    public void setContratoCcrearpagrEstadoContratoC(EstadoContratoOid contratoCcrearpagrEstadoContratoC) {
        this.contratoCcrearpagrEstadoContratoC = contratoCcrearpagrEstadoContratoC;
    }

    @JsonIgnore
    public EstadoContrato getContratoCcrearpagrEstadoContratoCInstance() {
        return this.contratoCcrearpagrEstadoContratoCInstance;
    }
    
    public void setContratoCcrearpagrEstadoContratoCInstance(EstadoContrato contratoCcrearpagrEstadoContratoC) {
        this.contratoCcrearpagrEstadoContratoCInstance = contratoCcrearpagrEstadoContratoC;
        this.contratoCcrearpagrEstadoContratoC = contratoCcrearpagrEstadoContratoC != null ? contratoCcrearpagrEstadoContratoC.getOid() : null;
    }

    @JsonIgnore
    public ProductosOid getContratoCcrearpagrProductoC() {
        return this.contratoCcrearpagrProductoC;
    }
    
    public void setContratoCcrearpagrProductoC(ProductosOid contratoCcrearpagrProductoC) {
        this.contratoCcrearpagrProductoC = contratoCcrearpagrProductoC;
    }

    @JsonIgnore
    public Productos getContratoCcrearpagrProductoCInstance() {
        return this.contratoCcrearpagrProductoCInstance;
    }
    
    public void setContratoCcrearpagrProductoCInstance(Productos contratoCcrearpagrProductoC) {
        this.contratoCcrearpagrProductoCInstance = contratoCcrearpagrProductoC;
        this.contratoCcrearpagrProductoC = contratoCcrearpagrProductoC != null ? contratoCcrearpagrProductoC.getOid() : null;
    }

    private void checkContratoCcrearpagrProductoC() throws NotNullArgumentException {
        if(this.getContratoCcrearpagrProductoCInstance() == null || this.getContratoCcrearpagrProductoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_CREAR, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_CREAR_CONTRATOCCREARPAGRPRODUCTOC, ContratoCConstants.SERV_ALIAS_CREAR, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_CREAR_CONTRATOCCREARPAGRPRODUCTOC);
        }
    }

    @JsonIgnore
    public PlanesOid getContratoCcrearpagrPlanC() {
        return this.contratoCcrearpagrPlanC;
    }
    
    public void setContratoCcrearpagrPlanC(PlanesOid contratoCcrearpagrPlanC) {
        this.contratoCcrearpagrPlanC = contratoCcrearpagrPlanC;
    }

    @JsonIgnore
    public Planes getContratoCcrearpagrPlanCInstance() {
        return this.contratoCcrearpagrPlanCInstance;
    }
    
    public void setContratoCcrearpagrPlanCInstance(Planes contratoCcrearpagrPlanC) {
        this.contratoCcrearpagrPlanCInstance = contratoCcrearpagrPlanC;
        this.contratoCcrearpagrPlanC = contratoCcrearpagrPlanC != null ? contratoCcrearpagrPlanC.getOid() : null;
    }

    private void checkContratoCcrearpagrPlanC() throws NotNullArgumentException {
        if(this.getContratoCcrearpagrPlanCInstance() == null || this.getContratoCcrearpagrPlanCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_CREAR, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_CREAR_CONTRATOCCREARPAGRPLANC, ContratoCConstants.SERV_ALIAS_CREAR, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_CREAR_CONTRATOCCREARPAGRPLANC);
        }
    }

    @JsonIgnore
    public TarifaOid getContratoCcrearpagrTarifaC() {
        return this.contratoCcrearpagrTarifaC;
    }
    
    public void setContratoCcrearpagrTarifaC(TarifaOid contratoCcrearpagrTarifaC) {
        this.contratoCcrearpagrTarifaC = contratoCcrearpagrTarifaC;
    }

    @JsonIgnore
    public Tarifa getContratoCcrearpagrTarifaCInstance() {
        return this.contratoCcrearpagrTarifaCInstance;
    }
    
    public void setContratoCcrearpagrTarifaCInstance(Tarifa contratoCcrearpagrTarifaC) {
        this.contratoCcrearpagrTarifaCInstance = contratoCcrearpagrTarifaC;
        this.contratoCcrearpagrTarifaC = contratoCcrearpagrTarifaC != null ? contratoCcrearpagrTarifaC.getOid() : null;
    }

    @JsonIgnore
    public GrupoAsociadoOid getContratoCcrearpagrGrupoAsociadoC() {
        return this.contratoCcrearpagrGrupoAsociadoC;
    }
    
    public void setContratoCcrearpagrGrupoAsociadoC(GrupoAsociadoOid contratoCcrearpagrGrupoAsociadoC) {
        this.contratoCcrearpagrGrupoAsociadoC = contratoCcrearpagrGrupoAsociadoC;
    }

    @JsonIgnore
    public GrupoAsociado getContratoCcrearpagrGrupoAsociadoCInstance() {
        return this.contratoCcrearpagrGrupoAsociadoCInstance;
    }
    
    public void setContratoCcrearpagrGrupoAsociadoCInstance(GrupoAsociado contratoCcrearpagrGrupoAsociadoC) {
        this.contratoCcrearpagrGrupoAsociadoCInstance = contratoCcrearpagrGrupoAsociadoC;
        this.contratoCcrearpagrGrupoAsociadoC = contratoCcrearpagrGrupoAsociadoC != null ? contratoCcrearpagrGrupoAsociadoC.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getContratoCcrearpagrMunicipioC() {
        return this.contratoCcrearpagrMunicipioC;
    }
    
    public void setContratoCcrearpagrMunicipioC(MunicipioOid contratoCcrearpagrMunicipioC) {
        this.contratoCcrearpagrMunicipioC = contratoCcrearpagrMunicipioC;
    }

    @JsonIgnore
    public Municipio getContratoCcrearpagrMunicipioCInstance() {
        return this.contratoCcrearpagrMunicipioCInstance;
    }
    
    public void setContratoCcrearpagrMunicipioCInstance(Municipio contratoCcrearpagrMunicipioC) {
        this.contratoCcrearpagrMunicipioCInstance = contratoCcrearpagrMunicipioC;
        this.contratoCcrearpagrMunicipioC = contratoCcrearpagrMunicipioC != null ? contratoCcrearpagrMunicipioC.getOid() : null;
    }

    @JsonIgnore
    public SucursalOid getContratoCcrearpagrSucursalC() {
        return this.contratoCcrearpagrSucursalC;
    }
    
    public void setContratoCcrearpagrSucursalC(SucursalOid contratoCcrearpagrSucursalC) {
        this.contratoCcrearpagrSucursalC = contratoCcrearpagrSucursalC;
    }

    @JsonIgnore
    public Sucursal getContratoCcrearpagrSucursalCInstance() {
        return this.contratoCcrearpagrSucursalCInstance;
    }
    
    public void setContratoCcrearpagrSucursalCInstance(Sucursal contratoCcrearpagrSucursalC) {
        this.contratoCcrearpagrSucursalCInstance = contratoCcrearpagrSucursalC;
        this.contratoCcrearpagrSucursalC = contratoCcrearpagrSucursalC != null ? contratoCcrearpagrSucursalC.getOid() : null;
    }

    @JsonIgnore
    public AsesorOid getContratoCcrearpagrAsesorC() {
        return this.contratoCcrearpagrAsesorC;
    }
    
    public void setContratoCcrearpagrAsesorC(AsesorOid contratoCcrearpagrAsesorC) {
        this.contratoCcrearpagrAsesorC = contratoCcrearpagrAsesorC;
    }

    @JsonIgnore
    public Asesor getContratoCcrearpagrAsesorCInstance() {
        return this.contratoCcrearpagrAsesorCInstance;
    }
    
    public void setContratoCcrearpagrAsesorCInstance(Asesor contratoCcrearpagrAsesorC) {
        this.contratoCcrearpagrAsesorCInstance = contratoCcrearpagrAsesorC;
        this.contratoCcrearpagrAsesorC = contratoCcrearpagrAsesorC != null ? contratoCcrearpagrAsesorC.getOid() : null;
    }

    @JsonIgnore
    public String getContratoCcrearpatrNumSolicitud() {
        return this.contratoCcrearpatrNumSolicitud;
    }
    
    public void setContratoCcrearpatrNumSolicitud(String contratoCcrearpatrNumSolicitud) {
        this.contratoCcrearpatrNumSolicitud = contratoCcrearpatrNumSolicitud;
    }

    @JsonIgnore
    public Date getContratoCcrearpatrFechaSolicitud() {
        return this.contratoCcrearpatrFechaSolicitud;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setContratoCcrearpatrFechaSolicitud(Date contratoCcrearpatrFechaSolicitud) {
        this.contratoCcrearpatrFechaSolicitud = contratoCcrearpatrFechaSolicitud;
    }

    @JsonIgnore
    public Long getContratoCcrearpatrTipoContrato() {
        return this.contratoCcrearpatrTipoContrato;
    }
    
    public void setContratoCcrearpatrTipoContrato(Long contratoCcrearpatrTipoContrato) {
        this.contratoCcrearpatrTipoContrato = contratoCcrearpatrTipoContrato;
    }

    @JsonIgnore
    public Date getContratoCcrearpatrFechaIniVigencia() {
        return this.contratoCcrearpatrFechaIniVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setContratoCcrearpatrFechaIniVigencia(Date contratoCcrearpatrFechaIniVigencia) {
        this.contratoCcrearpatrFechaIniVigencia = contratoCcrearpatrFechaIniVigencia;
    }

    @JsonIgnore
    public String getContratoCcrearpatrDireccion() {
        return this.contratoCcrearpatrDireccion;
    }
    
    public void setContratoCcrearpatrDireccion(String contratoCcrearpatrDireccion) {
        this.contratoCcrearpatrDireccion = contratoCcrearpatrDireccion;
    }

    @JsonIgnore
    public String getContratoCcrearpatrcorreoContratante() {
        return this.contratoCcrearpatrcorreoContratante;
    }
    
    public void setContratoCcrearpatrcorreoContratante(String contratoCcrearpatrcorreoContratante) {
        this.contratoCcrearpatrcorreoContratante = contratoCcrearpatrcorreoContratante;
    }

    @JsonIgnore
    public String getContratoCcrearpatrnumTelContratante() {
        return this.contratoCcrearpatrnumTelContratante;
    }
    
    public void setContratoCcrearpatrnumTelContratante(String contratoCcrearpatrnumTelContratante) {
        this.contratoCcrearpatrnumTelContratante = contratoCcrearpatrnumTelContratante;
    }

    @JsonIgnore
    public String getContratoCcrearpatrnumCelContratante() {
        return this.contratoCcrearpatrnumCelContratante;
    }
    
    public void setContratoCcrearpatrnumCelContratante(String contratoCcrearpatrnumCelContratante) {
        this.contratoCcrearpatrnumCelContratante = contratoCcrearpatrnumCelContratante;
    }

    @JsonIgnore
    public String getContratoCcrearpatrexentoIVA() {
        return this.contratoCcrearpatrexentoIVA;
    }
    
    public void setContratoCcrearpatrexentoIVA(String contratoCcrearpatrexentoIVA) {
        this.contratoCcrearpatrexentoIVA = contratoCcrearpatrexentoIVA;
    }

    @JsonIgnore
    public Boolean getContratoCcrearpatrContratoConFirma() {
        return this.contratoCcrearpatrContratoConFirma;
    }
    
    public void setContratoCcrearpatrContratoConFirma(Boolean contratoCcrearpatrContratoConFirma) {
        this.contratoCcrearpatrContratoConFirma = contratoCcrearpatrContratoConFirma;
    }

    @JsonIgnore
    public String getContratoCcrearpatrNumContrato() {
        return this.contratoCcrearpatrNumContrato;
    }
    
    public void setContratoCcrearpatrNumContrato(String contratoCcrearpatrNumContrato) {
        this.contratoCcrearpatrNumContrato = contratoCcrearpatrNumContrato;
    }

    @JsonIgnore
    public Date getContratoCcrearpatrFechaFinVigencia() {
        return this.contratoCcrearpatrFechaFinVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setContratoCcrearpatrFechaFinVigencia(Date contratoCcrearpatrFechaFinVigencia) {
        this.contratoCcrearpatrFechaFinVigencia = contratoCcrearpatrFechaFinVigencia;
    }

    @JsonIgnore
    public Timestamp getContratoCcrearpatrUltimaActualizacion() {
        return this.contratoCcrearpatrUltimaActualizacion;
    }
    
    public void setContratoCcrearpatrUltimaActualizacion(Timestamp contratoCcrearpatrUltimaActualizacion) {
        this.contratoCcrearpatrUltimaActualizacion = contratoCcrearpatrUltimaActualizacion;
    }

    @JsonIgnore
    public String getContratoCcrearpatrCodTarifa() {
        return this.contratoCcrearpatrCodTarifa;
    }
    
    public void setContratoCcrearpatrCodTarifa(String contratoCcrearpatrCodTarifa) {
        this.contratoCcrearpatrCodTarifa = contratoCcrearpatrCodTarifa;
    }
}
