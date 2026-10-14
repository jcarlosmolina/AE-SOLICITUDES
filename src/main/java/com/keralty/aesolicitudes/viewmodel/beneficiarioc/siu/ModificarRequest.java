package com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.BeneficiarioCConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class ModificarRequest {

    @JsonProperty("p_thisbeneficiarioc_oid")
    private BeneficiarioCOid beneficiarioCmodificarpthisBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC beneficiarioCmodificarpthisBeneficiarioCInstance;

    @JsonProperty("p_requiereexamenmedico")
    private Boolean beneficiarioCmodificarpRequiereExamenMedico;

    @JsonProperty("p_estadomedico")
    private Long beneficiarioCmodificarpEstadoMedico;

    @JsonProperty("p_fechaantiguedadrealosi")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCmodificarpFechaAntiguedadRealOSI;

    @JsonProperty("p_valorcuotainscripcion")
    private Double beneficiarioCmodificarpValorCuotaInscripcion;

    @JsonProperty("p_tienepreexistencias")
    private Boolean beneficiarioCmodificarpTienePreexistencias;

    @JsonProperty("p_fechainiciovigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCmodificarpFechaInicioVigencia;

    @JsonProperty("p_fechafinvigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCmodificarpFechaFinVigencia;

    @JsonProperty("p_numusuario")
    private Long beneficiarioCmodificarpNumUsuario;

    @JsonProperty("p_codigotipousuario")
    private String beneficiarioCmodificarpCodigoTipoUsuario;

    @JsonProperty("p_indicadorbbgestacion")
    private Boolean beneficiarioCmodificarpIndicadorBBGestacion;

    @JsonProperty("p_codusuariobancorep")
    private String beneficiarioCmodificarpCodUsuarioBancoRep;

    @JsonProperty("p_fechaantiguedad")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCmodificarpFechaAntiguedad;

    public void checkArguments() throws NotNullArgumentException {
        checkBeneficiarioCmodificarpthisBeneficiarioC();
    }

    @JsonIgnore
    public BeneficiarioCOid getBeneficiarioCmodificarpthisBeneficiarioC() {
        return this.beneficiarioCmodificarpthisBeneficiarioC;
    }
    
    public void setBeneficiarioCmodificarpthisBeneficiarioC(BeneficiarioCOid beneficiarioCmodificarpthisBeneficiarioC) {
        this.beneficiarioCmodificarpthisBeneficiarioC = beneficiarioCmodificarpthisBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getBeneficiarioCmodificarpthisBeneficiarioCInstance() {
        return this.beneficiarioCmodificarpthisBeneficiarioCInstance;
    }
    
    public void setBeneficiarioCmodificarpthisBeneficiarioCInstance(BeneficiarioC beneficiarioCmodificarpthisBeneficiarioC) {
        this.beneficiarioCmodificarpthisBeneficiarioCInstance = beneficiarioCmodificarpthisBeneficiarioC;
        this.beneficiarioCmodificarpthisBeneficiarioC = beneficiarioCmodificarpthisBeneficiarioC != null ? beneficiarioCmodificarpthisBeneficiarioC.getOid() : null;
    }

    private void checkBeneficiarioCmodificarpthisBeneficiarioC() throws NotNullArgumentException {
        if(this.getBeneficiarioCmodificarpthisBeneficiarioCInstance() == null || this.getBeneficiarioCmodificarpthisBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_MODIFICAR, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_MODIFICAR_BENEFICIARIOCMODIFICARPTHISBENEFICIARIOC, BeneficiarioCConstants.SERV_ALIAS_MODIFICAR, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_MODIFICAR_BENEFICIARIOCMODIFICARPTHISBENEFICIARIOC);
        }
    }

    @JsonIgnore
    public Boolean getBeneficiarioCmodificarpRequiereExamenMedico() {
        return this.beneficiarioCmodificarpRequiereExamenMedico;
    }
    
    public void setBeneficiarioCmodificarpRequiereExamenMedico(Boolean beneficiarioCmodificarpRequiereExamenMedico) {
        this.beneficiarioCmodificarpRequiereExamenMedico = beneficiarioCmodificarpRequiereExamenMedico;
    }

    @JsonIgnore
    public Long getBeneficiarioCmodificarpEstadoMedico() {
        return this.beneficiarioCmodificarpEstadoMedico;
    }
    
    public void setBeneficiarioCmodificarpEstadoMedico(Long beneficiarioCmodificarpEstadoMedico) {
        this.beneficiarioCmodificarpEstadoMedico = beneficiarioCmodificarpEstadoMedico;
    }

    @JsonIgnore
    public Date getBeneficiarioCmodificarpFechaAntiguedadRealOSI() {
        return this.beneficiarioCmodificarpFechaAntiguedadRealOSI;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCmodificarpFechaAntiguedadRealOSI(Date beneficiarioCmodificarpFechaAntiguedadRealOSI) {
        this.beneficiarioCmodificarpFechaAntiguedadRealOSI = beneficiarioCmodificarpFechaAntiguedadRealOSI;
    }

    @JsonIgnore
    public Double getBeneficiarioCmodificarpValorCuotaInscripcion() {
        return this.beneficiarioCmodificarpValorCuotaInscripcion;
    }
    
    public void setBeneficiarioCmodificarpValorCuotaInscripcion(Double beneficiarioCmodificarpValorCuotaInscripcion) {
        this.beneficiarioCmodificarpValorCuotaInscripcion = beneficiarioCmodificarpValorCuotaInscripcion;
    }

    @JsonIgnore
    public Boolean getBeneficiarioCmodificarpTienePreexistencias() {
        return this.beneficiarioCmodificarpTienePreexistencias;
    }
    
    public void setBeneficiarioCmodificarpTienePreexistencias(Boolean beneficiarioCmodificarpTienePreexistencias) {
        this.beneficiarioCmodificarpTienePreexistencias = beneficiarioCmodificarpTienePreexistencias;
    }

    @JsonIgnore
    public Date getBeneficiarioCmodificarpFechaInicioVigencia() {
        return this.beneficiarioCmodificarpFechaInicioVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCmodificarpFechaInicioVigencia(Date beneficiarioCmodificarpFechaInicioVigencia) {
        this.beneficiarioCmodificarpFechaInicioVigencia = beneficiarioCmodificarpFechaInicioVigencia;
    }

    @JsonIgnore
    public Date getBeneficiarioCmodificarpFechaFinVigencia() {
        return this.beneficiarioCmodificarpFechaFinVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCmodificarpFechaFinVigencia(Date beneficiarioCmodificarpFechaFinVigencia) {
        this.beneficiarioCmodificarpFechaFinVigencia = beneficiarioCmodificarpFechaFinVigencia;
    }

    @JsonIgnore
    public Long getBeneficiarioCmodificarpNumUsuario() {
        return this.beneficiarioCmodificarpNumUsuario;
    }
    
    public void setBeneficiarioCmodificarpNumUsuario(Long beneficiarioCmodificarpNumUsuario) {
        this.beneficiarioCmodificarpNumUsuario = beneficiarioCmodificarpNumUsuario;
    }

    @JsonIgnore
    public String getBeneficiarioCmodificarpCodigoTipoUsuario() {
        return this.beneficiarioCmodificarpCodigoTipoUsuario;
    }
    
    public void setBeneficiarioCmodificarpCodigoTipoUsuario(String beneficiarioCmodificarpCodigoTipoUsuario) {
        this.beneficiarioCmodificarpCodigoTipoUsuario = beneficiarioCmodificarpCodigoTipoUsuario;
    }

    @JsonIgnore
    public Boolean getBeneficiarioCmodificarpIndicadorBBGestacion() {
        return this.beneficiarioCmodificarpIndicadorBBGestacion;
    }
    
    public void setBeneficiarioCmodificarpIndicadorBBGestacion(Boolean beneficiarioCmodificarpIndicadorBBGestacion) {
        this.beneficiarioCmodificarpIndicadorBBGestacion = beneficiarioCmodificarpIndicadorBBGestacion;
    }

    @JsonIgnore
    public String getBeneficiarioCmodificarpCodUsuarioBancoRep() {
        return this.beneficiarioCmodificarpCodUsuarioBancoRep;
    }
    
    public void setBeneficiarioCmodificarpCodUsuarioBancoRep(String beneficiarioCmodificarpCodUsuarioBancoRep) {
        this.beneficiarioCmodificarpCodUsuarioBancoRep = beneficiarioCmodificarpCodUsuarioBancoRep;
    }

    @JsonIgnore
    public Date getBeneficiarioCmodificarpFechaAntiguedad() {
        return this.beneficiarioCmodificarpFechaAntiguedad;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCmodificarpFechaAntiguedad(Date beneficiarioCmodificarpFechaAntiguedad) {
        this.beneficiarioCmodificarpFechaAntiguedad = beneficiarioCmodificarpFechaAntiguedad;
    }
}
