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

public class EvalPostNotiCrearRequest {

    @JsonProperty("p_thisbeneficiarioc_oid")
    private BeneficiarioCOid beneficiarioCevalPostNotiCrearpthisBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC beneficiarioCevalPostNotiCrearpthisBeneficiarioCInstance;

    @JsonProperty("p_estadomedico")
    private Long beneficiarioCevalPostNotiCrearpEstadoMedico;

    @JsonProperty("p_fechaantiguedadrealosi")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCevalPostNotiCrearpFechaAntiguedadRealOSI;

    @JsonProperty("p_tienepreexistencias")
    private Boolean beneficiarioCevalPostNotiCrearpTienePreexistencias;

    @JsonProperty("p_fechainiciovigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCevalPostNotiCrearpFechaInicioVigencia;

    @JsonProperty("p_fechafinvigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCevalPostNotiCrearpFechaFinVigencia;

    @JsonProperty("p_numusuario")
    private Long beneficiarioCevalPostNotiCrearpNumUsuario;

    @JsonProperty("p_codigotipousuario")
    private String beneficiarioCevalPostNotiCrearpCodigoTipoUsuario;

    @JsonProperty("p_indicadorbbgestacion")
    private Boolean beneficiarioCevalPostNotiCrearpIndicadorBBGestacion;

    @JsonProperty("p_codusuariobancorep")
    private String beneficiarioCevalPostNotiCrearpCodUsuarioBancoRep;

    @JsonProperty("p_fechaantiguedad")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCevalPostNotiCrearpFechaAntiguedad;

    public void checkArguments() throws NotNullArgumentException {
        checkBeneficiarioCevalPostNotiCrearpthisBeneficiarioC();
    }

    @JsonIgnore
    public BeneficiarioCOid getBeneficiarioCevalPostNotiCrearpthisBeneficiarioC() {
        return this.beneficiarioCevalPostNotiCrearpthisBeneficiarioC;
    }
    
    public void setBeneficiarioCevalPostNotiCrearpthisBeneficiarioC(BeneficiarioCOid beneficiarioCevalPostNotiCrearpthisBeneficiarioC) {
        this.beneficiarioCevalPostNotiCrearpthisBeneficiarioC = beneficiarioCevalPostNotiCrearpthisBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getBeneficiarioCevalPostNotiCrearpthisBeneficiarioCInstance() {
        return this.beneficiarioCevalPostNotiCrearpthisBeneficiarioCInstance;
    }
    
    public void setBeneficiarioCevalPostNotiCrearpthisBeneficiarioCInstance(BeneficiarioC beneficiarioCevalPostNotiCrearpthisBeneficiarioC) {
        this.beneficiarioCevalPostNotiCrearpthisBeneficiarioCInstance = beneficiarioCevalPostNotiCrearpthisBeneficiarioC;
        this.beneficiarioCevalPostNotiCrearpthisBeneficiarioC = beneficiarioCevalPostNotiCrearpthisBeneficiarioC != null ? beneficiarioCevalPostNotiCrearpthisBeneficiarioC.getOid() : null;
    }

    private void checkBeneficiarioCevalPostNotiCrearpthisBeneficiarioC() throws NotNullArgumentException {
        if(this.getBeneficiarioCevalPostNotiCrearpthisBeneficiarioCInstance() == null || this.getBeneficiarioCevalPostNotiCrearpthisBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_EVALPOSTNOTICREAR, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_EVALPOSTNOTICREAR_BENEFICIARIOCEVALPOSTNOTICREARPTHISBENEFICIARIOC, BeneficiarioCConstants.SERV_ALIAS_EVALPOSTNOTICREAR, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_EVALPOSTNOTICREAR_BENEFICIARIOCEVALPOSTNOTICREARPTHISBENEFICIARIOC);
        }
    }

    @JsonIgnore
    public Long getBeneficiarioCevalPostNotiCrearpEstadoMedico() {
        return this.beneficiarioCevalPostNotiCrearpEstadoMedico;
    }
    
    public void setBeneficiarioCevalPostNotiCrearpEstadoMedico(Long beneficiarioCevalPostNotiCrearpEstadoMedico) {
        this.beneficiarioCevalPostNotiCrearpEstadoMedico = beneficiarioCevalPostNotiCrearpEstadoMedico;
    }

    @JsonIgnore
    public Date getBeneficiarioCevalPostNotiCrearpFechaAntiguedadRealOSI() {
        return this.beneficiarioCevalPostNotiCrearpFechaAntiguedadRealOSI;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCevalPostNotiCrearpFechaAntiguedadRealOSI(Date beneficiarioCevalPostNotiCrearpFechaAntiguedadRealOSI) {
        this.beneficiarioCevalPostNotiCrearpFechaAntiguedadRealOSI = beneficiarioCevalPostNotiCrearpFechaAntiguedadRealOSI;
    }

    @JsonIgnore
    public Boolean getBeneficiarioCevalPostNotiCrearpTienePreexistencias() {
        return this.beneficiarioCevalPostNotiCrearpTienePreexistencias;
    }
    
    public void setBeneficiarioCevalPostNotiCrearpTienePreexistencias(Boolean beneficiarioCevalPostNotiCrearpTienePreexistencias) {
        this.beneficiarioCevalPostNotiCrearpTienePreexistencias = beneficiarioCevalPostNotiCrearpTienePreexistencias;
    }

    @JsonIgnore
    public Date getBeneficiarioCevalPostNotiCrearpFechaInicioVigencia() {
        return this.beneficiarioCevalPostNotiCrearpFechaInicioVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCevalPostNotiCrearpFechaInicioVigencia(Date beneficiarioCevalPostNotiCrearpFechaInicioVigencia) {
        this.beneficiarioCevalPostNotiCrearpFechaInicioVigencia = beneficiarioCevalPostNotiCrearpFechaInicioVigencia;
    }

    @JsonIgnore
    public Date getBeneficiarioCevalPostNotiCrearpFechaFinVigencia() {
        return this.beneficiarioCevalPostNotiCrearpFechaFinVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCevalPostNotiCrearpFechaFinVigencia(Date beneficiarioCevalPostNotiCrearpFechaFinVigencia) {
        this.beneficiarioCevalPostNotiCrearpFechaFinVigencia = beneficiarioCevalPostNotiCrearpFechaFinVigencia;
    }

    @JsonIgnore
    public Long getBeneficiarioCevalPostNotiCrearpNumUsuario() {
        return this.beneficiarioCevalPostNotiCrearpNumUsuario;
    }
    
    public void setBeneficiarioCevalPostNotiCrearpNumUsuario(Long beneficiarioCevalPostNotiCrearpNumUsuario) {
        this.beneficiarioCevalPostNotiCrearpNumUsuario = beneficiarioCevalPostNotiCrearpNumUsuario;
    }

    @JsonIgnore
    public String getBeneficiarioCevalPostNotiCrearpCodigoTipoUsuario() {
        return this.beneficiarioCevalPostNotiCrearpCodigoTipoUsuario;
    }
    
    public void setBeneficiarioCevalPostNotiCrearpCodigoTipoUsuario(String beneficiarioCevalPostNotiCrearpCodigoTipoUsuario) {
        this.beneficiarioCevalPostNotiCrearpCodigoTipoUsuario = beneficiarioCevalPostNotiCrearpCodigoTipoUsuario;
    }

    @JsonIgnore
    public Boolean getBeneficiarioCevalPostNotiCrearpIndicadorBBGestacion() {
        return this.beneficiarioCevalPostNotiCrearpIndicadorBBGestacion;
    }
    
    public void setBeneficiarioCevalPostNotiCrearpIndicadorBBGestacion(Boolean beneficiarioCevalPostNotiCrearpIndicadorBBGestacion) {
        this.beneficiarioCevalPostNotiCrearpIndicadorBBGestacion = beneficiarioCevalPostNotiCrearpIndicadorBBGestacion;
    }

    @JsonIgnore
    public String getBeneficiarioCevalPostNotiCrearpCodUsuarioBancoRep() {
        return this.beneficiarioCevalPostNotiCrearpCodUsuarioBancoRep;
    }
    
    public void setBeneficiarioCevalPostNotiCrearpCodUsuarioBancoRep(String beneficiarioCevalPostNotiCrearpCodUsuarioBancoRep) {
        this.beneficiarioCevalPostNotiCrearpCodUsuarioBancoRep = beneficiarioCevalPostNotiCrearpCodUsuarioBancoRep;
    }

    @JsonIgnore
    public Date getBeneficiarioCevalPostNotiCrearpFechaAntiguedad() {
        return this.beneficiarioCevalPostNotiCrearpFechaAntiguedad;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCevalPostNotiCrearpFechaAntiguedad(Date beneficiarioCevalPostNotiCrearpFechaAntiguedad) {
        this.beneficiarioCevalPostNotiCrearpFechaAntiguedad = beneficiarioCevalPostNotiCrearpFechaAntiguedad;
    }
}
