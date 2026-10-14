package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;
import java.sql.Timestamp;

public class ModificarRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCmodificarpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCmodificarpthisContratoCInstance;

    @JsonProperty("p_valorcuotaperiodo")
    private Double contratoCmodificarpvalorCuotaPeriodo;

    @JsonProperty("p_descuentocomercial")
    private Double contratoCmodificarpdescuentoComercial;

    @JsonProperty("p_iva")
    private Double contratoCmodificarpIVA;

    @JsonProperty("p_descuentofinanciero")
    private Double contratoCmodificarpdescuentoFinanciero;

    @JsonProperty("p_numsolicitud")
    private String contratoCmodificarpNumSolicitud;

    @JsonProperty("p_numcontrato")
    private String contratoCmodificarpNumContrato;

    @JsonProperty("p_fechasolicitud")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date contratoCmodificarpFechaSolicitud;

    @JsonProperty("p_tipocontrato")
    private Long contratoCmodificarpTipoContrato;

    @JsonProperty("p_fechainivigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date contratoCmodificarpFechaIniVigencia;

    @JsonProperty("p_direccion")
    private String contratoCmodificarpDireccion;

    @JsonProperty("p_correocontratante")
    private String contratoCmodificarpcorreoContratante;

    @JsonProperty("p_numtelcontratante")
    private String contratoCmodificarpnumTelContratante;

    @JsonProperty("p_numcelcontratante")
    private String contratoCmodificarpnumCelContratante;

    @JsonProperty("p_exentoiva")
    private String contratoCmodificarpexentoIVA;

    @JsonProperty("p_contratoconfirma")
    private Boolean contratoCmodificarpContratoConFirma;

    @JsonProperty("p_fechafinvigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date contratoCmodificarpFechaFinVigencia;

    @JsonProperty("p_ultimaactualizacion")
    private Timestamp contratoCmodificarpUltimaActualizacion;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCmodificarpthisContratoC();
        checkContratoCmodificarpvalorCuotaPeriodo();
        checkContratoCmodificarpdescuentoComercial();
        checkContratoCmodificarpIVA();
        checkContratoCmodificarpdescuentoFinanciero();
    }

    @JsonIgnore
    public ContratoCOid getContratoCmodificarpthisContratoC() {
        return this.contratoCmodificarpthisContratoC;
    }
    
    public void setContratoCmodificarpthisContratoC(ContratoCOid contratoCmodificarpthisContratoC) {
        this.contratoCmodificarpthisContratoC = contratoCmodificarpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCmodificarpthisContratoCInstance() {
        return this.contratoCmodificarpthisContratoCInstance;
    }
    
    public void setContratoCmodificarpthisContratoCInstance(ContratoC contratoCmodificarpthisContratoC) {
        this.contratoCmodificarpthisContratoCInstance = contratoCmodificarpthisContratoC;
        this.contratoCmodificarpthisContratoC = contratoCmodificarpthisContratoC != null ? contratoCmodificarpthisContratoC.getOid() : null;
    }

    private void checkContratoCmodificarpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCmodificarpthisContratoCInstance() == null || this.getContratoCmodificarpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_MODIFICAR, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_MODIFICAR_CONTRATOCMODIFICARPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_MODIFICAR, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_MODIFICAR_CONTRATOCMODIFICARPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public Double getContratoCmodificarpvalorCuotaPeriodo() {
        return this.contratoCmodificarpvalorCuotaPeriodo;
    }
    
    public void setContratoCmodificarpvalorCuotaPeriodo(Double contratoCmodificarpvalorCuotaPeriodo) {
        this.contratoCmodificarpvalorCuotaPeriodo = contratoCmodificarpvalorCuotaPeriodo;
    }

    private void checkContratoCmodificarpvalorCuotaPeriodo() throws NotNullArgumentException {
        if(this.getContratoCmodificarpvalorCuotaPeriodo() == null) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_MODIFICAR, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_MODIFICAR_CONTRATOCMODIFICARPVALORCUOTAPERIODO, ContratoCConstants.SERV_ALIAS_MODIFICAR, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_MODIFICAR_CONTRATOCMODIFICARPVALORCUOTAPERIODO);
        }
    }

    @JsonIgnore
    public Double getContratoCmodificarpdescuentoComercial() {
        return this.contratoCmodificarpdescuentoComercial;
    }
    
    public void setContratoCmodificarpdescuentoComercial(Double contratoCmodificarpdescuentoComercial) {
        this.contratoCmodificarpdescuentoComercial = contratoCmodificarpdescuentoComercial;
    }

    private void checkContratoCmodificarpdescuentoComercial() throws NotNullArgumentException {
        if(this.getContratoCmodificarpdescuentoComercial() == null) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_MODIFICAR, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_MODIFICAR_CONTRATOCMODIFICARPDESCUENTOCOMERCIAL, ContratoCConstants.SERV_ALIAS_MODIFICAR, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_MODIFICAR_CONTRATOCMODIFICARPDESCUENTOCOMERCIAL);
        }
    }

    @JsonIgnore
    public Double getContratoCmodificarpIVA() {
        return this.contratoCmodificarpIVA;
    }
    
    public void setContratoCmodificarpIVA(Double contratoCmodificarpIVA) {
        this.contratoCmodificarpIVA = contratoCmodificarpIVA;
    }

    private void checkContratoCmodificarpIVA() throws NotNullArgumentException {
        if(this.getContratoCmodificarpIVA() == null) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_MODIFICAR, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_MODIFICAR_CONTRATOCMODIFICARPIVA, ContratoCConstants.SERV_ALIAS_MODIFICAR, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_MODIFICAR_CONTRATOCMODIFICARPIVA);
        }
    }

    @JsonIgnore
    public Double getContratoCmodificarpdescuentoFinanciero() {
        return this.contratoCmodificarpdescuentoFinanciero;
    }
    
    public void setContratoCmodificarpdescuentoFinanciero(Double contratoCmodificarpdescuentoFinanciero) {
        this.contratoCmodificarpdescuentoFinanciero = contratoCmodificarpdescuentoFinanciero;
    }

    private void checkContratoCmodificarpdescuentoFinanciero() throws NotNullArgumentException {
        if(this.getContratoCmodificarpdescuentoFinanciero() == null) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_MODIFICAR, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_MODIFICAR_CONTRATOCMODIFICARPDESCUENTOFINANCIERO, ContratoCConstants.SERV_ALIAS_MODIFICAR, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_MODIFICAR_CONTRATOCMODIFICARPDESCUENTOFINANCIERO);
        }
    }

    @JsonIgnore
    public String getContratoCmodificarpNumSolicitud() {
        return this.contratoCmodificarpNumSolicitud;
    }
    
    public void setContratoCmodificarpNumSolicitud(String contratoCmodificarpNumSolicitud) {
        this.contratoCmodificarpNumSolicitud = contratoCmodificarpNumSolicitud;
    }

    @JsonIgnore
    public String getContratoCmodificarpNumContrato() {
        return this.contratoCmodificarpNumContrato;
    }
    
    public void setContratoCmodificarpNumContrato(String contratoCmodificarpNumContrato) {
        this.contratoCmodificarpNumContrato = contratoCmodificarpNumContrato;
    }

    @JsonIgnore
    public Date getContratoCmodificarpFechaSolicitud() {
        return this.contratoCmodificarpFechaSolicitud;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setContratoCmodificarpFechaSolicitud(Date contratoCmodificarpFechaSolicitud) {
        this.contratoCmodificarpFechaSolicitud = contratoCmodificarpFechaSolicitud;
    }

    @JsonIgnore
    public Long getContratoCmodificarpTipoContrato() {
        return this.contratoCmodificarpTipoContrato;
    }
    
    public void setContratoCmodificarpTipoContrato(Long contratoCmodificarpTipoContrato) {
        this.contratoCmodificarpTipoContrato = contratoCmodificarpTipoContrato;
    }

    @JsonIgnore
    public Date getContratoCmodificarpFechaIniVigencia() {
        return this.contratoCmodificarpFechaIniVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setContratoCmodificarpFechaIniVigencia(Date contratoCmodificarpFechaIniVigencia) {
        this.contratoCmodificarpFechaIniVigencia = contratoCmodificarpFechaIniVigencia;
    }

    @JsonIgnore
    public String getContratoCmodificarpDireccion() {
        return this.contratoCmodificarpDireccion;
    }
    
    public void setContratoCmodificarpDireccion(String contratoCmodificarpDireccion) {
        this.contratoCmodificarpDireccion = contratoCmodificarpDireccion;
    }

    @JsonIgnore
    public String getContratoCmodificarpcorreoContratante() {
        return this.contratoCmodificarpcorreoContratante;
    }
    
    public void setContratoCmodificarpcorreoContratante(String contratoCmodificarpcorreoContratante) {
        this.contratoCmodificarpcorreoContratante = contratoCmodificarpcorreoContratante;
    }

    @JsonIgnore
    public String getContratoCmodificarpnumTelContratante() {
        return this.contratoCmodificarpnumTelContratante;
    }
    
    public void setContratoCmodificarpnumTelContratante(String contratoCmodificarpnumTelContratante) {
        this.contratoCmodificarpnumTelContratante = contratoCmodificarpnumTelContratante;
    }

    @JsonIgnore
    public String getContratoCmodificarpnumCelContratante() {
        return this.contratoCmodificarpnumCelContratante;
    }
    
    public void setContratoCmodificarpnumCelContratante(String contratoCmodificarpnumCelContratante) {
        this.contratoCmodificarpnumCelContratante = contratoCmodificarpnumCelContratante;
    }

    @JsonIgnore
    public String getContratoCmodificarpexentoIVA() {
        return this.contratoCmodificarpexentoIVA;
    }
    
    public void setContratoCmodificarpexentoIVA(String contratoCmodificarpexentoIVA) {
        this.contratoCmodificarpexentoIVA = contratoCmodificarpexentoIVA;
    }

    @JsonIgnore
    public Boolean getContratoCmodificarpContratoConFirma() {
        return this.contratoCmodificarpContratoConFirma;
    }
    
    public void setContratoCmodificarpContratoConFirma(Boolean contratoCmodificarpContratoConFirma) {
        this.contratoCmodificarpContratoConFirma = contratoCmodificarpContratoConFirma;
    }

    @JsonIgnore
    public Date getContratoCmodificarpFechaFinVigencia() {
        return this.contratoCmodificarpFechaFinVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setContratoCmodificarpFechaFinVigencia(Date contratoCmodificarpFechaFinVigencia) {
        this.contratoCmodificarpFechaFinVigencia = contratoCmodificarpFechaFinVigencia;
    }

    @JsonIgnore
    public Timestamp getContratoCmodificarpUltimaActualizacion() {
        return this.contratoCmodificarpUltimaActualizacion;
    }
    
    public void setContratoCmodificarpUltimaActualizacion(Timestamp contratoCmodificarpUltimaActualizacion) {
        this.contratoCmodificarpUltimaActualizacion = contratoCmodificarpUltimaActualizacion;
    }
}
