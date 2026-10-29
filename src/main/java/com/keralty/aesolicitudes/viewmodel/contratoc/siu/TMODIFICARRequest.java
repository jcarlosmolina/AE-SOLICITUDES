package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.FormaPago;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.FormaPagoOid;
import com.keralty.aesolicitudes.persistence.oid.PeriodicidadOid;
import com.keralty.aesolicitudes.persistence.Periodicidad;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TMODIFICARRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCTMODIFICARpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCTMODIFICARpthisContratoCInstance;

    @JsonProperty("pt_p_valorcuotaperiodo")
    private Double contratoCTMODIFICARptpvalorCuotaPeriodo;

    @JsonProperty("pt_p_descuentocomercial")
    private Double contratoCTMODIFICARptpdescuentoComercial;

    @JsonProperty("pt_p_iva")
    private Double contratoCTMODIFICARptpIVA;

    @JsonProperty("pt_p_descuentofinanciero")
    private Double contratoCTMODIFICARptpdescuentoFinanciero;

    @JsonProperty("pt_p_evcperiodicidadc_oid")
    private PeriodicidadOid contratoCTMODIFICARptpevcPeriodicidadC;
    
    @JsonIgnore
    private Periodicidad contratoCTMODIFICARptpevcPeriodicidadCInstance;

    @JsonProperty("pt_p_evcformapagoc_oid")
    private FormaPagoOid contratoCTMODIFICARptpevcFormaPagoC;
    
    @JsonIgnore
    private FormaPago contratoCTMODIFICARptpevcFormaPagoCInstance;

    @JsonProperty("pt_p_numsolicitud")
    private String contratoCTMODIFICARptpNumSolicitud;

    @JsonProperty("pt_p_numcontrato")
    private String contratoCTMODIFICARptpNumContrato;

    @JsonProperty("pt_p_fechasolicitud")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date contratoCTMODIFICARptpFechaSolicitud;

    @JsonProperty("pt_p_tipocontrato")
    private Long contratoCTMODIFICARptpTipoContrato;

    @JsonProperty("pt_p_fechainivigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date contratoCTMODIFICARptpFechaIniVigencia;

    @JsonProperty("pt_p_direccion")
    private String contratoCTMODIFICARptpDireccion;

    @JsonProperty("pt_p_correocontratante")
    private String contratoCTMODIFICARptpcorreoContratante;

    @JsonProperty("pt_p_numtelcontratante")
    private String contratoCTMODIFICARptpnumTelContratante;

    @JsonProperty("pt_p_numcelcontratante")
    private String contratoCTMODIFICARptpnumCelContratante;

    @JsonProperty("pt_p_exentoiva")
    private String contratoCTMODIFICARptpexentoIVA;

    @JsonProperty("pt_p_contratoconfirma")
    private Boolean contratoCTMODIFICARptpContratoConFirma;

    @JsonProperty("pt_p_fechafinvigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date contratoCTMODIFICARptpFechaFinVigencia;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCTMODIFICARpthisContratoC();
        checkContratoCTMODIFICARptpvalorCuotaPeriodo();
        checkContratoCTMODIFICARptpdescuentoComercial();
        checkContratoCTMODIFICARptpIVA();
        checkContratoCTMODIFICARptpdescuentoFinanciero();
    }

    @JsonIgnore
    public ContratoCOid getContratoCTMODIFICARpthisContratoC() {
        return this.contratoCTMODIFICARpthisContratoC;
    }
    
    public void setContratoCTMODIFICARpthisContratoC(ContratoCOid contratoCTMODIFICARpthisContratoC) {
        this.contratoCTMODIFICARpthisContratoC = contratoCTMODIFICARpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCTMODIFICARpthisContratoCInstance() {
        return this.contratoCTMODIFICARpthisContratoCInstance;
    }
    
    public void setContratoCTMODIFICARpthisContratoCInstance(ContratoC contratoCTMODIFICARpthisContratoC) {
        this.contratoCTMODIFICARpthisContratoCInstance = contratoCTMODIFICARpthisContratoC;
        this.contratoCTMODIFICARpthisContratoC = contratoCTMODIFICARpthisContratoC != null ? contratoCTMODIFICARpthisContratoC.getOid() : null;
    }

    private void checkContratoCTMODIFICARpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCTMODIFICARpthisContratoCInstance() == null || this.getContratoCTMODIFICARpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_TMODIFICAR, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_TMODIFICAR_CONTRATOCTMODIFICARPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_TMODIFICAR, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_TMODIFICAR_CONTRATOCTMODIFICARPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public Double getContratoCTMODIFICARptpvalorCuotaPeriodo() {
        return this.contratoCTMODIFICARptpvalorCuotaPeriodo;
    }
    
    public void setContratoCTMODIFICARptpvalorCuotaPeriodo(Double contratoCTMODIFICARptpvalorCuotaPeriodo) {
        this.contratoCTMODIFICARptpvalorCuotaPeriodo = contratoCTMODIFICARptpvalorCuotaPeriodo;
    }

    private void checkContratoCTMODIFICARptpvalorCuotaPeriodo() throws NotNullArgumentException {
        if(this.getContratoCTMODIFICARptpvalorCuotaPeriodo() == null) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_TMODIFICAR, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_TMODIFICAR_CONTRATOCTMODIFICARPTPVALORCUOTAPERIODO, ContratoCConstants.SERV_ALIAS_TMODIFICAR, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_TMODIFICAR_CONTRATOCTMODIFICARPTPVALORCUOTAPERIODO);
        }
    }

    @JsonIgnore
    public Double getContratoCTMODIFICARptpdescuentoComercial() {
        return this.contratoCTMODIFICARptpdescuentoComercial;
    }
    
    public void setContratoCTMODIFICARptpdescuentoComercial(Double contratoCTMODIFICARptpdescuentoComercial) {
        this.contratoCTMODIFICARptpdescuentoComercial = contratoCTMODIFICARptpdescuentoComercial;
    }

    private void checkContratoCTMODIFICARptpdescuentoComercial() throws NotNullArgumentException {
        if(this.getContratoCTMODIFICARptpdescuentoComercial() == null) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_TMODIFICAR, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_TMODIFICAR_CONTRATOCTMODIFICARPTPDESCUENTOCOMERCIAL, ContratoCConstants.SERV_ALIAS_TMODIFICAR, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_TMODIFICAR_CONTRATOCTMODIFICARPTPDESCUENTOCOMERCIAL);
        }
    }

    @JsonIgnore
    public Double getContratoCTMODIFICARptpIVA() {
        return this.contratoCTMODIFICARptpIVA;
    }
    
    public void setContratoCTMODIFICARptpIVA(Double contratoCTMODIFICARptpIVA) {
        this.contratoCTMODIFICARptpIVA = contratoCTMODIFICARptpIVA;
    }

    private void checkContratoCTMODIFICARptpIVA() throws NotNullArgumentException {
        if(this.getContratoCTMODIFICARptpIVA() == null) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_TMODIFICAR, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_TMODIFICAR_CONTRATOCTMODIFICARPTPIVA, ContratoCConstants.SERV_ALIAS_TMODIFICAR, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_TMODIFICAR_CONTRATOCTMODIFICARPTPIVA);
        }
    }

    @JsonIgnore
    public Double getContratoCTMODIFICARptpdescuentoFinanciero() {
        return this.contratoCTMODIFICARptpdescuentoFinanciero;
    }
    
    public void setContratoCTMODIFICARptpdescuentoFinanciero(Double contratoCTMODIFICARptpdescuentoFinanciero) {
        this.contratoCTMODIFICARptpdescuentoFinanciero = contratoCTMODIFICARptpdescuentoFinanciero;
    }

    private void checkContratoCTMODIFICARptpdescuentoFinanciero() throws NotNullArgumentException {
        if(this.getContratoCTMODIFICARptpdescuentoFinanciero() == null) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_TMODIFICAR, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_TMODIFICAR_CONTRATOCTMODIFICARPTPDESCUENTOFINANCIERO, ContratoCConstants.SERV_ALIAS_TMODIFICAR, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_TMODIFICAR_CONTRATOCTMODIFICARPTPDESCUENTOFINANCIERO);
        }
    }

    @JsonIgnore
    public PeriodicidadOid getContratoCTMODIFICARptpevcPeriodicidadC() {
        return this.contratoCTMODIFICARptpevcPeriodicidadC;
    }
    
    public void setContratoCTMODIFICARptpevcPeriodicidadC(PeriodicidadOid contratoCTMODIFICARptpevcPeriodicidadC) {
        this.contratoCTMODIFICARptpevcPeriodicidadC = contratoCTMODIFICARptpevcPeriodicidadC;
    }

    @JsonIgnore
    public Periodicidad getContratoCTMODIFICARptpevcPeriodicidadCInstance() {
        return this.contratoCTMODIFICARptpevcPeriodicidadCInstance;
    }
    
    public void setContratoCTMODIFICARptpevcPeriodicidadCInstance(Periodicidad contratoCTMODIFICARptpevcPeriodicidadC) {
        this.contratoCTMODIFICARptpevcPeriodicidadCInstance = contratoCTMODIFICARptpevcPeriodicidadC;
        this.contratoCTMODIFICARptpevcPeriodicidadC = contratoCTMODIFICARptpevcPeriodicidadC != null ? contratoCTMODIFICARptpevcPeriodicidadC.getOid() : null;
    }

    @JsonIgnore
    public FormaPagoOid getContratoCTMODIFICARptpevcFormaPagoC() {
        return this.contratoCTMODIFICARptpevcFormaPagoC;
    }
    
    public void setContratoCTMODIFICARptpevcFormaPagoC(FormaPagoOid contratoCTMODIFICARptpevcFormaPagoC) {
        this.contratoCTMODIFICARptpevcFormaPagoC = contratoCTMODIFICARptpevcFormaPagoC;
    }

    @JsonIgnore
    public FormaPago getContratoCTMODIFICARptpevcFormaPagoCInstance() {
        return this.contratoCTMODIFICARptpevcFormaPagoCInstance;
    }
    
    public void setContratoCTMODIFICARptpevcFormaPagoCInstance(FormaPago contratoCTMODIFICARptpevcFormaPagoC) {
        this.contratoCTMODIFICARptpevcFormaPagoCInstance = contratoCTMODIFICARptpevcFormaPagoC;
        this.contratoCTMODIFICARptpevcFormaPagoC = contratoCTMODIFICARptpevcFormaPagoC != null ? contratoCTMODIFICARptpevcFormaPagoC.getOid() : null;
    }

    @JsonIgnore
    public String getContratoCTMODIFICARptpNumSolicitud() {
        return this.contratoCTMODIFICARptpNumSolicitud;
    }
    
    public void setContratoCTMODIFICARptpNumSolicitud(String contratoCTMODIFICARptpNumSolicitud) {
        this.contratoCTMODIFICARptpNumSolicitud = contratoCTMODIFICARptpNumSolicitud;
    }

    @JsonIgnore
    public String getContratoCTMODIFICARptpNumContrato() {
        return this.contratoCTMODIFICARptpNumContrato;
    }
    
    public void setContratoCTMODIFICARptpNumContrato(String contratoCTMODIFICARptpNumContrato) {
        this.contratoCTMODIFICARptpNumContrato = contratoCTMODIFICARptpNumContrato;
    }

    @JsonIgnore
    public Date getContratoCTMODIFICARptpFechaSolicitud() {
        return this.contratoCTMODIFICARptpFechaSolicitud;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setContratoCTMODIFICARptpFechaSolicitud(Date contratoCTMODIFICARptpFechaSolicitud) {
        this.contratoCTMODIFICARptpFechaSolicitud = contratoCTMODIFICARptpFechaSolicitud;
    }

    @JsonIgnore
    public Long getContratoCTMODIFICARptpTipoContrato() {
        return this.contratoCTMODIFICARptpTipoContrato;
    }
    
    public void setContratoCTMODIFICARptpTipoContrato(Long contratoCTMODIFICARptpTipoContrato) {
        this.contratoCTMODIFICARptpTipoContrato = contratoCTMODIFICARptpTipoContrato;
    }

    @JsonIgnore
    public Date getContratoCTMODIFICARptpFechaIniVigencia() {
        return this.contratoCTMODIFICARptpFechaIniVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setContratoCTMODIFICARptpFechaIniVigencia(Date contratoCTMODIFICARptpFechaIniVigencia) {
        this.contratoCTMODIFICARptpFechaIniVigencia = contratoCTMODIFICARptpFechaIniVigencia;
    }

    @JsonIgnore
    public String getContratoCTMODIFICARptpDireccion() {
        return this.contratoCTMODIFICARptpDireccion;
    }
    
    public void setContratoCTMODIFICARptpDireccion(String contratoCTMODIFICARptpDireccion) {
        this.contratoCTMODIFICARptpDireccion = contratoCTMODIFICARptpDireccion;
    }

    @JsonIgnore
    public String getContratoCTMODIFICARptpcorreoContratante() {
        return this.contratoCTMODIFICARptpcorreoContratante;
    }
    
    public void setContratoCTMODIFICARptpcorreoContratante(String contratoCTMODIFICARptpcorreoContratante) {
        this.contratoCTMODIFICARptpcorreoContratante = contratoCTMODIFICARptpcorreoContratante;
    }

    @JsonIgnore
    public String getContratoCTMODIFICARptpnumTelContratante() {
        return this.contratoCTMODIFICARptpnumTelContratante;
    }
    
    public void setContratoCTMODIFICARptpnumTelContratante(String contratoCTMODIFICARptpnumTelContratante) {
        this.contratoCTMODIFICARptpnumTelContratante = contratoCTMODIFICARptpnumTelContratante;
    }

    @JsonIgnore
    public String getContratoCTMODIFICARptpnumCelContratante() {
        return this.contratoCTMODIFICARptpnumCelContratante;
    }
    
    public void setContratoCTMODIFICARptpnumCelContratante(String contratoCTMODIFICARptpnumCelContratante) {
        this.contratoCTMODIFICARptpnumCelContratante = contratoCTMODIFICARptpnumCelContratante;
    }

    @JsonIgnore
    public String getContratoCTMODIFICARptpexentoIVA() {
        return this.contratoCTMODIFICARptpexentoIVA;
    }
    
    public void setContratoCTMODIFICARptpexentoIVA(String contratoCTMODIFICARptpexentoIVA) {
        this.contratoCTMODIFICARptpexentoIVA = contratoCTMODIFICARptpexentoIVA;
    }

    @JsonIgnore
    public Boolean getContratoCTMODIFICARptpContratoConFirma() {
        return this.contratoCTMODIFICARptpContratoConFirma;
    }
    
    public void setContratoCTMODIFICARptpContratoConFirma(Boolean contratoCTMODIFICARptpContratoConFirma) {
        this.contratoCTMODIFICARptpContratoConFirma = contratoCTMODIFICARptpContratoConFirma;
    }

    @JsonIgnore
    public Date getContratoCTMODIFICARptpFechaFinVigencia() {
        return this.contratoCTMODIFICARptpFechaFinVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setContratoCTMODIFICARptpFechaFinVigencia(Date contratoCTMODIFICARptpFechaFinVigencia) {
        this.contratoCTMODIFICARptpFechaFinVigencia = contratoCTMODIFICARptpFechaFinVigencia;
    }
}
