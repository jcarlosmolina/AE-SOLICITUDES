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

public class ModificarTrasCORERequest {

    @JsonProperty("p_thisbeneficiarioc_oid")
    private BeneficiarioCOid beneficiarioCmodificarTrasCOREpthisBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC beneficiarioCmodificarTrasCOREpthisBeneficiarioCInstance;

    @JsonProperty("p_requiereexamenmedico")
    private Boolean beneficiarioCmodificarTrasCOREpRequiereExamenMedico;

    @JsonProperty("p_estadomedico")
    private Long beneficiarioCmodificarTrasCOREpEstadoMedico;

    @JsonProperty("p_fechaantiguedadrealosi")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCmodificarTrasCOREpFechaAntiguedadRealOSI;

    @JsonProperty("p_tienepreexistencias")
    private Boolean beneficiarioCmodificarTrasCOREpTienePreexistencias;

    @JsonProperty("p_numusuario")
    private Long beneficiarioCmodificarTrasCOREpNumUsuario;

    public void checkArguments() throws NotNullArgumentException {
        checkBeneficiarioCmodificarTrasCOREpthisBeneficiarioC();
    }

    @JsonIgnore
    public BeneficiarioCOid getBeneficiarioCmodificarTrasCOREpthisBeneficiarioC() {
        return this.beneficiarioCmodificarTrasCOREpthisBeneficiarioC;
    }
    
    public void setBeneficiarioCmodificarTrasCOREpthisBeneficiarioC(BeneficiarioCOid beneficiarioCmodificarTrasCOREpthisBeneficiarioC) {
        this.beneficiarioCmodificarTrasCOREpthisBeneficiarioC = beneficiarioCmodificarTrasCOREpthisBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getBeneficiarioCmodificarTrasCOREpthisBeneficiarioCInstance() {
        return this.beneficiarioCmodificarTrasCOREpthisBeneficiarioCInstance;
    }
    
    public void setBeneficiarioCmodificarTrasCOREpthisBeneficiarioCInstance(BeneficiarioC beneficiarioCmodificarTrasCOREpthisBeneficiarioC) {
        this.beneficiarioCmodificarTrasCOREpthisBeneficiarioCInstance = beneficiarioCmodificarTrasCOREpthisBeneficiarioC;
        this.beneficiarioCmodificarTrasCOREpthisBeneficiarioC = beneficiarioCmodificarTrasCOREpthisBeneficiarioC != null ? beneficiarioCmodificarTrasCOREpthisBeneficiarioC.getOid() : null;
    }

    private void checkBeneficiarioCmodificarTrasCOREpthisBeneficiarioC() throws NotNullArgumentException {
        if(this.getBeneficiarioCmodificarTrasCOREpthisBeneficiarioCInstance() == null || this.getBeneficiarioCmodificarTrasCOREpthisBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_MODIFICARTRASCORE, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_MODIFICARTRASCORE_BENEFICIARIOCMODIFICARTRASCOREPTHISBENEFICIARIOC, BeneficiarioCConstants.SERV_ALIAS_MODIFICARTRASCORE, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_MODIFICARTRASCORE_BENEFICIARIOCMODIFICARTRASCOREPTHISBENEFICIARIOC);
        }
    }

    @JsonIgnore
    public Boolean getBeneficiarioCmodificarTrasCOREpRequiereExamenMedico() {
        return this.beneficiarioCmodificarTrasCOREpRequiereExamenMedico;
    }
    
    public void setBeneficiarioCmodificarTrasCOREpRequiereExamenMedico(Boolean beneficiarioCmodificarTrasCOREpRequiereExamenMedico) {
        this.beneficiarioCmodificarTrasCOREpRequiereExamenMedico = beneficiarioCmodificarTrasCOREpRequiereExamenMedico;
    }

    @JsonIgnore
    public Long getBeneficiarioCmodificarTrasCOREpEstadoMedico() {
        return this.beneficiarioCmodificarTrasCOREpEstadoMedico;
    }
    
    public void setBeneficiarioCmodificarTrasCOREpEstadoMedico(Long beneficiarioCmodificarTrasCOREpEstadoMedico) {
        this.beneficiarioCmodificarTrasCOREpEstadoMedico = beneficiarioCmodificarTrasCOREpEstadoMedico;
    }

    @JsonIgnore
    public Date getBeneficiarioCmodificarTrasCOREpFechaAntiguedadRealOSI() {
        return this.beneficiarioCmodificarTrasCOREpFechaAntiguedadRealOSI;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCmodificarTrasCOREpFechaAntiguedadRealOSI(Date beneficiarioCmodificarTrasCOREpFechaAntiguedadRealOSI) {
        this.beneficiarioCmodificarTrasCOREpFechaAntiguedadRealOSI = beneficiarioCmodificarTrasCOREpFechaAntiguedadRealOSI;
    }

    @JsonIgnore
    public Boolean getBeneficiarioCmodificarTrasCOREpTienePreexistencias() {
        return this.beneficiarioCmodificarTrasCOREpTienePreexistencias;
    }
    
    public void setBeneficiarioCmodificarTrasCOREpTienePreexistencias(Boolean beneficiarioCmodificarTrasCOREpTienePreexistencias) {
        this.beneficiarioCmodificarTrasCOREpTienePreexistencias = beneficiarioCmodificarTrasCOREpTienePreexistencias;
    }

    @JsonIgnore
    public Long getBeneficiarioCmodificarTrasCOREpNumUsuario() {
        return this.beneficiarioCmodificarTrasCOREpNumUsuario;
    }
    
    public void setBeneficiarioCmodificarTrasCOREpNumUsuario(Long beneficiarioCmodificarTrasCOREpNumUsuario) {
        this.beneficiarioCmodificarTrasCOREpNumUsuario = beneficiarioCmodificarTrasCOREpNumUsuario;
    }
}
