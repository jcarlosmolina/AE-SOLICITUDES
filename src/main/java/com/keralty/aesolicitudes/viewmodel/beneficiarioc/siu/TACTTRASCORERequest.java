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

public class TACTTRASCORERequest {

    @JsonProperty("p_thisbeneficiarioc_oid")
    private BeneficiarioCOid beneficiarioCTACTTRASCOREpthisBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC beneficiarioCTACTTRASCOREpthisBeneficiarioCInstance;

    @JsonProperty("pt_p_requiereexamenmedico")
    private Boolean beneficiarioCTACTTRASCOREptpRequiereExamenMedico;

    @JsonProperty("pt_p_estadomedico")
    private Long beneficiarioCTACTTRASCOREptpEstadoMedico;

    @JsonProperty("pt_p_fechaantiguedadrealosi")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCTACTTRASCOREptpFechaAntiguedadRealOSI;

    @JsonProperty("pt_p_tienepreexistencias")
    private Boolean beneficiarioCTACTTRASCOREptpTienePreexistencias;

    @JsonProperty("pt_p_numusuario")
    private Long beneficiarioCTACTTRASCOREptpNumUsuario;

    @JsonProperty("ptestadobeneficiarioc_oid")
    private EstadoBeneficiarioOid beneficiarioCTACTTRASCOREptEstadoBeneficiarioC;
    
    @JsonIgnore
    private EstadoBeneficiario beneficiarioCTACTTRASCOREptEstadoBeneficiarioCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkBeneficiarioCTACTTRASCOREpthisBeneficiarioC();
    }

    @JsonIgnore
    public BeneficiarioCOid getBeneficiarioCTACTTRASCOREpthisBeneficiarioC() {
        return this.beneficiarioCTACTTRASCOREpthisBeneficiarioC;
    }
    
    public void setBeneficiarioCTACTTRASCOREpthisBeneficiarioC(BeneficiarioCOid beneficiarioCTACTTRASCOREpthisBeneficiarioC) {
        this.beneficiarioCTACTTRASCOREpthisBeneficiarioC = beneficiarioCTACTTRASCOREpthisBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getBeneficiarioCTACTTRASCOREpthisBeneficiarioCInstance() {
        return this.beneficiarioCTACTTRASCOREpthisBeneficiarioCInstance;
    }
    
    public void setBeneficiarioCTACTTRASCOREpthisBeneficiarioCInstance(BeneficiarioC beneficiarioCTACTTRASCOREpthisBeneficiarioC) {
        this.beneficiarioCTACTTRASCOREpthisBeneficiarioCInstance = beneficiarioCTACTTRASCOREpthisBeneficiarioC;
        this.beneficiarioCTACTTRASCOREpthisBeneficiarioC = beneficiarioCTACTTRASCOREpthisBeneficiarioC != null ? beneficiarioCTACTTRASCOREpthisBeneficiarioC.getOid() : null;
    }

    private void checkBeneficiarioCTACTTRASCOREpthisBeneficiarioC() throws NotNullArgumentException {
        if(this.getBeneficiarioCTACTTRASCOREpthisBeneficiarioCInstance() == null || this.getBeneficiarioCTACTTRASCOREpthisBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_TACTTRASCORE, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_TACTTRASCORE_BENEFICIARIOCTACTTRASCOREPTHISBENEFICIARIOC, BeneficiarioCConstants.SERV_ALIAS_TACTTRASCORE, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_TACTTRASCORE_BENEFICIARIOCTACTTRASCOREPTHISBENEFICIARIOC);
        }
    }

    @JsonIgnore
    public Boolean getBeneficiarioCTACTTRASCOREptpRequiereExamenMedico() {
        return this.beneficiarioCTACTTRASCOREptpRequiereExamenMedico;
    }
    
    public void setBeneficiarioCTACTTRASCOREptpRequiereExamenMedico(Boolean beneficiarioCTACTTRASCOREptpRequiereExamenMedico) {
        this.beneficiarioCTACTTRASCOREptpRequiereExamenMedico = beneficiarioCTACTTRASCOREptpRequiereExamenMedico;
    }

    @JsonIgnore
    public Long getBeneficiarioCTACTTRASCOREptpEstadoMedico() {
        return this.beneficiarioCTACTTRASCOREptpEstadoMedico;
    }
    
    public void setBeneficiarioCTACTTRASCOREptpEstadoMedico(Long beneficiarioCTACTTRASCOREptpEstadoMedico) {
        this.beneficiarioCTACTTRASCOREptpEstadoMedico = beneficiarioCTACTTRASCOREptpEstadoMedico;
    }

    @JsonIgnore
    public Date getBeneficiarioCTACTTRASCOREptpFechaAntiguedadRealOSI() {
        return this.beneficiarioCTACTTRASCOREptpFechaAntiguedadRealOSI;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCTACTTRASCOREptpFechaAntiguedadRealOSI(Date beneficiarioCTACTTRASCOREptpFechaAntiguedadRealOSI) {
        this.beneficiarioCTACTTRASCOREptpFechaAntiguedadRealOSI = beneficiarioCTACTTRASCOREptpFechaAntiguedadRealOSI;
    }

    @JsonIgnore
    public Boolean getBeneficiarioCTACTTRASCOREptpTienePreexistencias() {
        return this.beneficiarioCTACTTRASCOREptpTienePreexistencias;
    }
    
    public void setBeneficiarioCTACTTRASCOREptpTienePreexistencias(Boolean beneficiarioCTACTTRASCOREptpTienePreexistencias) {
        this.beneficiarioCTACTTRASCOREptpTienePreexistencias = beneficiarioCTACTTRASCOREptpTienePreexistencias;
    }

    @JsonIgnore
    public Long getBeneficiarioCTACTTRASCOREptpNumUsuario() {
        return this.beneficiarioCTACTTRASCOREptpNumUsuario;
    }
    
    public void setBeneficiarioCTACTTRASCOREptpNumUsuario(Long beneficiarioCTACTTRASCOREptpNumUsuario) {
        this.beneficiarioCTACTTRASCOREptpNumUsuario = beneficiarioCTACTTRASCOREptpNumUsuario;
    }

    @JsonIgnore
    public EstadoBeneficiarioOid getBeneficiarioCTACTTRASCOREptEstadoBeneficiarioC() {
        return this.beneficiarioCTACTTRASCOREptEstadoBeneficiarioC;
    }
    
    public void setBeneficiarioCTACTTRASCOREptEstadoBeneficiarioC(EstadoBeneficiarioOid beneficiarioCTACTTRASCOREptEstadoBeneficiarioC) {
        this.beneficiarioCTACTTRASCOREptEstadoBeneficiarioC = beneficiarioCTACTTRASCOREptEstadoBeneficiarioC;
    }

    @JsonIgnore
    public EstadoBeneficiario getBeneficiarioCTACTTRASCOREptEstadoBeneficiarioCInstance() {
        return this.beneficiarioCTACTTRASCOREptEstadoBeneficiarioCInstance;
    }
    
    public void setBeneficiarioCTACTTRASCOREptEstadoBeneficiarioCInstance(EstadoBeneficiario beneficiarioCTACTTRASCOREptEstadoBeneficiarioC) {
        this.beneficiarioCTACTTRASCOREptEstadoBeneficiarioCInstance = beneficiarioCTACTTRASCOREptEstadoBeneficiarioC;
        this.beneficiarioCTACTTRASCOREptEstadoBeneficiarioC = beneficiarioCTACTTRASCOREptEstadoBeneficiarioC != null ? beneficiarioCTACTTRASCOREptEstadoBeneficiarioC.getOid() : null;
    }
}
