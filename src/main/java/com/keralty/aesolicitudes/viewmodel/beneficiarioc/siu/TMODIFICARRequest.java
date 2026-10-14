package com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.BeneficiarioCConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.EstadoBeneficiario;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoBeneficiarioOid;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TMODIFICARRequest {

    @JsonProperty("p_thisbeneficiarioc_oid")
    private BeneficiarioCOid beneficiarioCTMODIFICARpthisBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC beneficiarioCTMODIFICARpthisBeneficiarioCInstance;

    @JsonProperty("pt_p_evcestadobeneficiarioc_oid")
    private EstadoBeneficiarioOid beneficiarioCTMODIFICARptpevcEstadoBeneficiarioC;
    
    @JsonIgnore
    private EstadoBeneficiario beneficiarioCTMODIFICARptpevcEstadoBeneficiarioCInstance;

    @JsonProperty("pt_p_requiereexamenmedico")
    private Boolean beneficiarioCTMODIFICARptpRequiereExamenMedico;

    @JsonProperty("pt_p_estadomedico")
    private Long beneficiarioCTMODIFICARptpEstadoMedico;

    @JsonProperty("pt_p_fechaantiguedadrealosi")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCTMODIFICARptpFechaAntiguedadRealOSI;

    @JsonProperty("pt_p_valorcuotainscripcion")
    private Double beneficiarioCTMODIFICARptpValorCuotaInscripcion;

    @JsonProperty("pt_p_tienepreexistencias")
    private Boolean beneficiarioCTMODIFICARptpTienePreexistencias;

    @JsonProperty("pt_p_fechainiciovigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCTMODIFICARptpFechaInicioVigencia;

    @JsonProperty("pt_p_fechafinvigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCTMODIFICARptpFechaFinVigencia;

    @JsonProperty("pt_p_numusuario")
    private Long beneficiarioCTMODIFICARptpNumUsuario;

    @JsonProperty("pt_p_codigotipousuario")
    private String beneficiarioCTMODIFICARptpCodigoTipoUsuario;

    @JsonProperty("pt_p_indicadorbbgestacion")
    private Boolean beneficiarioCTMODIFICARptpIndicadorBBGestacion;

    @JsonProperty("pt_p_codusuariobancorep")
    private String beneficiarioCTMODIFICARptpCodUsuarioBancoRep;

    @JsonProperty("pt_p_fechaantiguedad")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCTMODIFICARptpFechaAntiguedad;

    public void checkArguments() throws NotNullArgumentException {
        checkBeneficiarioCTMODIFICARpthisBeneficiarioC();
    }

    @JsonIgnore
    public BeneficiarioCOid getBeneficiarioCTMODIFICARpthisBeneficiarioC() {
        return this.beneficiarioCTMODIFICARpthisBeneficiarioC;
    }
    
    public void setBeneficiarioCTMODIFICARpthisBeneficiarioC(BeneficiarioCOid beneficiarioCTMODIFICARpthisBeneficiarioC) {
        this.beneficiarioCTMODIFICARpthisBeneficiarioC = beneficiarioCTMODIFICARpthisBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getBeneficiarioCTMODIFICARpthisBeneficiarioCInstance() {
        return this.beneficiarioCTMODIFICARpthisBeneficiarioCInstance;
    }
    
    public void setBeneficiarioCTMODIFICARpthisBeneficiarioCInstance(BeneficiarioC beneficiarioCTMODIFICARpthisBeneficiarioC) {
        this.beneficiarioCTMODIFICARpthisBeneficiarioCInstance = beneficiarioCTMODIFICARpthisBeneficiarioC;
        this.beneficiarioCTMODIFICARpthisBeneficiarioC = beneficiarioCTMODIFICARpthisBeneficiarioC != null ? beneficiarioCTMODIFICARpthisBeneficiarioC.getOid() : null;
    }

    private void checkBeneficiarioCTMODIFICARpthisBeneficiarioC() throws NotNullArgumentException {
        if(this.getBeneficiarioCTMODIFICARpthisBeneficiarioCInstance() == null || this.getBeneficiarioCTMODIFICARpthisBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_TMODIFICAR, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_TMODIFICAR_BENEFICIARIOCTMODIFICARPTHISBENEFICIARIOC, BeneficiarioCConstants.SERV_ALIAS_TMODIFICAR, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_TMODIFICAR_BENEFICIARIOCTMODIFICARPTHISBENEFICIARIOC);
        }
    }

    @JsonIgnore
    public EstadoBeneficiarioOid getBeneficiarioCTMODIFICARptpevcEstadoBeneficiarioC() {
        return this.beneficiarioCTMODIFICARptpevcEstadoBeneficiarioC;
    }
    
    public void setBeneficiarioCTMODIFICARptpevcEstadoBeneficiarioC(EstadoBeneficiarioOid beneficiarioCTMODIFICARptpevcEstadoBeneficiarioC) {
        this.beneficiarioCTMODIFICARptpevcEstadoBeneficiarioC = beneficiarioCTMODIFICARptpevcEstadoBeneficiarioC;
    }

    @JsonIgnore
    public EstadoBeneficiario getBeneficiarioCTMODIFICARptpevcEstadoBeneficiarioCInstance() {
        return this.beneficiarioCTMODIFICARptpevcEstadoBeneficiarioCInstance;
    }
    
    public void setBeneficiarioCTMODIFICARptpevcEstadoBeneficiarioCInstance(EstadoBeneficiario beneficiarioCTMODIFICARptpevcEstadoBeneficiarioC) {
        this.beneficiarioCTMODIFICARptpevcEstadoBeneficiarioCInstance = beneficiarioCTMODIFICARptpevcEstadoBeneficiarioC;
        this.beneficiarioCTMODIFICARptpevcEstadoBeneficiarioC = beneficiarioCTMODIFICARptpevcEstadoBeneficiarioC != null ? beneficiarioCTMODIFICARptpevcEstadoBeneficiarioC.getOid() : null;
    }

    @JsonIgnore
    public Boolean getBeneficiarioCTMODIFICARptpRequiereExamenMedico() {
        return this.beneficiarioCTMODIFICARptpRequiereExamenMedico;
    }
    
    public void setBeneficiarioCTMODIFICARptpRequiereExamenMedico(Boolean beneficiarioCTMODIFICARptpRequiereExamenMedico) {
        this.beneficiarioCTMODIFICARptpRequiereExamenMedico = beneficiarioCTMODIFICARptpRequiereExamenMedico;
    }

    @JsonIgnore
    public Long getBeneficiarioCTMODIFICARptpEstadoMedico() {
        return this.beneficiarioCTMODIFICARptpEstadoMedico;
    }
    
    public void setBeneficiarioCTMODIFICARptpEstadoMedico(Long beneficiarioCTMODIFICARptpEstadoMedico) {
        this.beneficiarioCTMODIFICARptpEstadoMedico = beneficiarioCTMODIFICARptpEstadoMedico;
    }

    @JsonIgnore
    public Date getBeneficiarioCTMODIFICARptpFechaAntiguedadRealOSI() {
        return this.beneficiarioCTMODIFICARptpFechaAntiguedadRealOSI;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCTMODIFICARptpFechaAntiguedadRealOSI(Date beneficiarioCTMODIFICARptpFechaAntiguedadRealOSI) {
        this.beneficiarioCTMODIFICARptpFechaAntiguedadRealOSI = beneficiarioCTMODIFICARptpFechaAntiguedadRealOSI;
    }

    @JsonIgnore
    public Double getBeneficiarioCTMODIFICARptpValorCuotaInscripcion() {
        return this.beneficiarioCTMODIFICARptpValorCuotaInscripcion;
    }
    
    public void setBeneficiarioCTMODIFICARptpValorCuotaInscripcion(Double beneficiarioCTMODIFICARptpValorCuotaInscripcion) {
        this.beneficiarioCTMODIFICARptpValorCuotaInscripcion = beneficiarioCTMODIFICARptpValorCuotaInscripcion;
    }

    @JsonIgnore
    public Boolean getBeneficiarioCTMODIFICARptpTienePreexistencias() {
        return this.beneficiarioCTMODIFICARptpTienePreexistencias;
    }
    
    public void setBeneficiarioCTMODIFICARptpTienePreexistencias(Boolean beneficiarioCTMODIFICARptpTienePreexistencias) {
        this.beneficiarioCTMODIFICARptpTienePreexistencias = beneficiarioCTMODIFICARptpTienePreexistencias;
    }

    @JsonIgnore
    public Date getBeneficiarioCTMODIFICARptpFechaInicioVigencia() {
        return this.beneficiarioCTMODIFICARptpFechaInicioVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCTMODIFICARptpFechaInicioVigencia(Date beneficiarioCTMODIFICARptpFechaInicioVigencia) {
        this.beneficiarioCTMODIFICARptpFechaInicioVigencia = beneficiarioCTMODIFICARptpFechaInicioVigencia;
    }

    @JsonIgnore
    public Date getBeneficiarioCTMODIFICARptpFechaFinVigencia() {
        return this.beneficiarioCTMODIFICARptpFechaFinVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCTMODIFICARptpFechaFinVigencia(Date beneficiarioCTMODIFICARptpFechaFinVigencia) {
        this.beneficiarioCTMODIFICARptpFechaFinVigencia = beneficiarioCTMODIFICARptpFechaFinVigencia;
    }

    @JsonIgnore
    public Long getBeneficiarioCTMODIFICARptpNumUsuario() {
        return this.beneficiarioCTMODIFICARptpNumUsuario;
    }
    
    public void setBeneficiarioCTMODIFICARptpNumUsuario(Long beneficiarioCTMODIFICARptpNumUsuario) {
        this.beneficiarioCTMODIFICARptpNumUsuario = beneficiarioCTMODIFICARptpNumUsuario;
    }

    @JsonIgnore
    public String getBeneficiarioCTMODIFICARptpCodigoTipoUsuario() {
        return this.beneficiarioCTMODIFICARptpCodigoTipoUsuario;
    }
    
    public void setBeneficiarioCTMODIFICARptpCodigoTipoUsuario(String beneficiarioCTMODIFICARptpCodigoTipoUsuario) {
        this.beneficiarioCTMODIFICARptpCodigoTipoUsuario = beneficiarioCTMODIFICARptpCodigoTipoUsuario;
    }

    @JsonIgnore
    public Boolean getBeneficiarioCTMODIFICARptpIndicadorBBGestacion() {
        return this.beneficiarioCTMODIFICARptpIndicadorBBGestacion;
    }
    
    public void setBeneficiarioCTMODIFICARptpIndicadorBBGestacion(Boolean beneficiarioCTMODIFICARptpIndicadorBBGestacion) {
        this.beneficiarioCTMODIFICARptpIndicadorBBGestacion = beneficiarioCTMODIFICARptpIndicadorBBGestacion;
    }

    @JsonIgnore
    public String getBeneficiarioCTMODIFICARptpCodUsuarioBancoRep() {
        return this.beneficiarioCTMODIFICARptpCodUsuarioBancoRep;
    }
    
    public void setBeneficiarioCTMODIFICARptpCodUsuarioBancoRep(String beneficiarioCTMODIFICARptpCodUsuarioBancoRep) {
        this.beneficiarioCTMODIFICARptpCodUsuarioBancoRep = beneficiarioCTMODIFICARptpCodUsuarioBancoRep;
    }

    @JsonIgnore
    public Date getBeneficiarioCTMODIFICARptpFechaAntiguedad() {
        return this.beneficiarioCTMODIFICARptpFechaAntiguedad;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCTMODIFICARptpFechaAntiguedad(Date beneficiarioCTMODIFICARptpFechaAntiguedad) {
        this.beneficiarioCTMODIFICARptpFechaAntiguedad = beneficiarioCTMODIFICARptpFechaAntiguedad;
    }
}
