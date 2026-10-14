package com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.BeneficiarioCConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.Companyia;
import com.keralty.aesolicitudes.persistence.Eps;
import com.keralty.aesolicitudes.persistence.EstadoBeneficiario;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.CompanyiaOid;
import com.keralty.aesolicitudes.persistence.oid.EpsOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoBeneficiarioOid;
import com.keralty.aesolicitudes.persistence.oid.ParentescoOid;
import com.keralty.aesolicitudes.persistence.Parentesco;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TPOSTNOTIFICARRequest {

    @JsonProperty("p_thisbeneficiarioc_oid")
    private BeneficiarioCOid beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC beneficiarioCTPOSTNOTIFICARpthisBeneficiarioCInstance;

    @JsonProperty("pt_p_estadomedico")
    private Long beneficiarioCTPOSTNOTIFICARptpEstadoMedico;

    @JsonProperty("pt_p_fechaantiguedadrealosi")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCTPOSTNOTIFICARptpFechaAntiguedadRealOSI;

    @JsonProperty("pt_p_tienepreexistencias")
    private Boolean beneficiarioCTPOSTNOTIFICARptpTienePreexistencias;

    @JsonProperty("pt_p_fechainiciovigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCTPOSTNOTIFICARptpFechaInicioVigencia;

    @JsonProperty("pt_p_fechafinvigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCTPOSTNOTIFICARptpFechaFinVigencia;

    @JsonProperty("pt_p_numusuario")
    private Long beneficiarioCTPOSTNOTIFICARptpNumUsuario;

    @JsonProperty("pt_p_codigotipousuario")
    private String beneficiarioCTPOSTNOTIFICARptpCodigoTipoUsuario;

    @JsonProperty("pt_p_indicadorbbgestacion")
    private Boolean beneficiarioCTPOSTNOTIFICARptpIndicadorBBGestacion;

    @JsonProperty("pt_p_codusuariobancorep")
    private String beneficiarioCTPOSTNOTIFICARptpCodUsuarioBancoRep;

    @JsonProperty("pt_p_fechaantiguedad")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCTPOSTNOTIFICARptpFechaAntiguedad;

    @JsonProperty("ptestadobeneficiario_oid")
    private EstadoBeneficiarioOid beneficiarioCTPOSTNOTIFICARptEstadoBeneficiario;
    
    @JsonIgnore
    private EstadoBeneficiario beneficiarioCTPOSTNOTIFICARptEstadoBeneficiarioInstance;

    @JsonProperty("pt_p_agrepsc_oid")
    private EpsOid beneficiarioCTPOSTNOTIFICARptpagrEPSC;
    
    @JsonIgnore
    private Eps beneficiarioCTPOSTNOTIFICARptpagrEPSCInstance;

    @JsonProperty("pt_p_agrcompanyiampc_oid")
    private CompanyiaOid beneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPC;
    
    @JsonIgnore
    private Companyia beneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPCInstance;

    @JsonProperty("pt_p_agrparentescoc_oid")
    private ParentescoOid beneficiarioCTPOSTNOTIFICARptpagrParentescoC;
    
    @JsonIgnore
    private Parentesco beneficiarioCTPOSTNOTIFICARptpagrParentescoCInstance;

    @JsonProperty("pt_ptnombrecompleto")
    private String beneficiarioCTPOSTNOTIFICARptptNombreCompleto;

    public void checkArguments() throws NotNullArgumentException {
        checkBeneficiarioCTPOSTNOTIFICARpthisBeneficiarioC();
        checkBeneficiarioCTPOSTNOTIFICARptpagrParentescoC();
    }

    @JsonIgnore
    public BeneficiarioCOid getBeneficiarioCTPOSTNOTIFICARpthisBeneficiarioC() {
        return this.beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC;
    }
    
    public void setBeneficiarioCTPOSTNOTIFICARpthisBeneficiarioC(BeneficiarioCOid beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC) {
        this.beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC = beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getBeneficiarioCTPOSTNOTIFICARpthisBeneficiarioCInstance() {
        return this.beneficiarioCTPOSTNOTIFICARpthisBeneficiarioCInstance;
    }
    
    public void setBeneficiarioCTPOSTNOTIFICARpthisBeneficiarioCInstance(BeneficiarioC beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC) {
        this.beneficiarioCTPOSTNOTIFICARpthisBeneficiarioCInstance = beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC;
        this.beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC = beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC != null ? beneficiarioCTPOSTNOTIFICARpthisBeneficiarioC.getOid() : null;
    }

    private void checkBeneficiarioCTPOSTNOTIFICARpthisBeneficiarioC() throws NotNullArgumentException {
        if(this.getBeneficiarioCTPOSTNOTIFICARpthisBeneficiarioCInstance() == null || this.getBeneficiarioCTPOSTNOTIFICARpthisBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_TPOSTNOTIFICAR, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_TPOSTNOTIFICAR_BENEFICIARIOCTPOSTNOTIFICARPTHISBENEFICIARIOC, BeneficiarioCConstants.SERV_ALIAS_TPOSTNOTIFICAR, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_TPOSTNOTIFICAR_BENEFICIARIOCTPOSTNOTIFICARPTHISBENEFICIARIOC);
        }
    }

    @JsonIgnore
    public Long getBeneficiarioCTPOSTNOTIFICARptpEstadoMedico() {
        return this.beneficiarioCTPOSTNOTIFICARptpEstadoMedico;
    }
    
    public void setBeneficiarioCTPOSTNOTIFICARptpEstadoMedico(Long beneficiarioCTPOSTNOTIFICARptpEstadoMedico) {
        this.beneficiarioCTPOSTNOTIFICARptpEstadoMedico = beneficiarioCTPOSTNOTIFICARptpEstadoMedico;
    }

    @JsonIgnore
    public Date getBeneficiarioCTPOSTNOTIFICARptpFechaAntiguedadRealOSI() {
        return this.beneficiarioCTPOSTNOTIFICARptpFechaAntiguedadRealOSI;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCTPOSTNOTIFICARptpFechaAntiguedadRealOSI(Date beneficiarioCTPOSTNOTIFICARptpFechaAntiguedadRealOSI) {
        this.beneficiarioCTPOSTNOTIFICARptpFechaAntiguedadRealOSI = beneficiarioCTPOSTNOTIFICARptpFechaAntiguedadRealOSI;
    }

    @JsonIgnore
    public Boolean getBeneficiarioCTPOSTNOTIFICARptpTienePreexistencias() {
        return this.beneficiarioCTPOSTNOTIFICARptpTienePreexistencias;
    }
    
    public void setBeneficiarioCTPOSTNOTIFICARptpTienePreexistencias(Boolean beneficiarioCTPOSTNOTIFICARptpTienePreexistencias) {
        this.beneficiarioCTPOSTNOTIFICARptpTienePreexistencias = beneficiarioCTPOSTNOTIFICARptpTienePreexistencias;
    }

    @JsonIgnore
    public Date getBeneficiarioCTPOSTNOTIFICARptpFechaInicioVigencia() {
        return this.beneficiarioCTPOSTNOTIFICARptpFechaInicioVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCTPOSTNOTIFICARptpFechaInicioVigencia(Date beneficiarioCTPOSTNOTIFICARptpFechaInicioVigencia) {
        this.beneficiarioCTPOSTNOTIFICARptpFechaInicioVigencia = beneficiarioCTPOSTNOTIFICARptpFechaInicioVigencia;
    }

    @JsonIgnore
    public Date getBeneficiarioCTPOSTNOTIFICARptpFechaFinVigencia() {
        return this.beneficiarioCTPOSTNOTIFICARptpFechaFinVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCTPOSTNOTIFICARptpFechaFinVigencia(Date beneficiarioCTPOSTNOTIFICARptpFechaFinVigencia) {
        this.beneficiarioCTPOSTNOTIFICARptpFechaFinVigencia = beneficiarioCTPOSTNOTIFICARptpFechaFinVigencia;
    }

    @JsonIgnore
    public Long getBeneficiarioCTPOSTNOTIFICARptpNumUsuario() {
        return this.beneficiarioCTPOSTNOTIFICARptpNumUsuario;
    }
    
    public void setBeneficiarioCTPOSTNOTIFICARptpNumUsuario(Long beneficiarioCTPOSTNOTIFICARptpNumUsuario) {
        this.beneficiarioCTPOSTNOTIFICARptpNumUsuario = beneficiarioCTPOSTNOTIFICARptpNumUsuario;
    }

    @JsonIgnore
    public String getBeneficiarioCTPOSTNOTIFICARptpCodigoTipoUsuario() {
        return this.beneficiarioCTPOSTNOTIFICARptpCodigoTipoUsuario;
    }
    
    public void setBeneficiarioCTPOSTNOTIFICARptpCodigoTipoUsuario(String beneficiarioCTPOSTNOTIFICARptpCodigoTipoUsuario) {
        this.beneficiarioCTPOSTNOTIFICARptpCodigoTipoUsuario = beneficiarioCTPOSTNOTIFICARptpCodigoTipoUsuario;
    }

    @JsonIgnore
    public Boolean getBeneficiarioCTPOSTNOTIFICARptpIndicadorBBGestacion() {
        return this.beneficiarioCTPOSTNOTIFICARptpIndicadorBBGestacion;
    }
    
    public void setBeneficiarioCTPOSTNOTIFICARptpIndicadorBBGestacion(Boolean beneficiarioCTPOSTNOTIFICARptpIndicadorBBGestacion) {
        this.beneficiarioCTPOSTNOTIFICARptpIndicadorBBGestacion = beneficiarioCTPOSTNOTIFICARptpIndicadorBBGestacion;
    }

    @JsonIgnore
    public String getBeneficiarioCTPOSTNOTIFICARptpCodUsuarioBancoRep() {
        return this.beneficiarioCTPOSTNOTIFICARptpCodUsuarioBancoRep;
    }
    
    public void setBeneficiarioCTPOSTNOTIFICARptpCodUsuarioBancoRep(String beneficiarioCTPOSTNOTIFICARptpCodUsuarioBancoRep) {
        this.beneficiarioCTPOSTNOTIFICARptpCodUsuarioBancoRep = beneficiarioCTPOSTNOTIFICARptpCodUsuarioBancoRep;
    }

    @JsonIgnore
    public Date getBeneficiarioCTPOSTNOTIFICARptpFechaAntiguedad() {
        return this.beneficiarioCTPOSTNOTIFICARptpFechaAntiguedad;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCTPOSTNOTIFICARptpFechaAntiguedad(Date beneficiarioCTPOSTNOTIFICARptpFechaAntiguedad) {
        this.beneficiarioCTPOSTNOTIFICARptpFechaAntiguedad = beneficiarioCTPOSTNOTIFICARptpFechaAntiguedad;
    }

    @JsonIgnore
    public EstadoBeneficiarioOid getBeneficiarioCTPOSTNOTIFICARptEstadoBeneficiario() {
        return this.beneficiarioCTPOSTNOTIFICARptEstadoBeneficiario;
    }
    
    public void setBeneficiarioCTPOSTNOTIFICARptEstadoBeneficiario(EstadoBeneficiarioOid beneficiarioCTPOSTNOTIFICARptEstadoBeneficiario) {
        this.beneficiarioCTPOSTNOTIFICARptEstadoBeneficiario = beneficiarioCTPOSTNOTIFICARptEstadoBeneficiario;
    }

    @JsonIgnore
    public EstadoBeneficiario getBeneficiarioCTPOSTNOTIFICARptEstadoBeneficiarioInstance() {
        return this.beneficiarioCTPOSTNOTIFICARptEstadoBeneficiarioInstance;
    }
    
    public void setBeneficiarioCTPOSTNOTIFICARptEstadoBeneficiarioInstance(EstadoBeneficiario beneficiarioCTPOSTNOTIFICARptEstadoBeneficiario) {
        this.beneficiarioCTPOSTNOTIFICARptEstadoBeneficiarioInstance = beneficiarioCTPOSTNOTIFICARptEstadoBeneficiario;
        this.beneficiarioCTPOSTNOTIFICARptEstadoBeneficiario = beneficiarioCTPOSTNOTIFICARptEstadoBeneficiario != null ? beneficiarioCTPOSTNOTIFICARptEstadoBeneficiario.getOid() : null;
    }

    @JsonIgnore
    public EpsOid getBeneficiarioCTPOSTNOTIFICARptpagrEPSC() {
        return this.beneficiarioCTPOSTNOTIFICARptpagrEPSC;
    }
    
    public void setBeneficiarioCTPOSTNOTIFICARptpagrEPSC(EpsOid beneficiarioCTPOSTNOTIFICARptpagrEPSC) {
        this.beneficiarioCTPOSTNOTIFICARptpagrEPSC = beneficiarioCTPOSTNOTIFICARptpagrEPSC;
    }

    @JsonIgnore
    public Eps getBeneficiarioCTPOSTNOTIFICARptpagrEPSCInstance() {
        return this.beneficiarioCTPOSTNOTIFICARptpagrEPSCInstance;
    }
    
    public void setBeneficiarioCTPOSTNOTIFICARptpagrEPSCInstance(Eps beneficiarioCTPOSTNOTIFICARptpagrEPSC) {
        this.beneficiarioCTPOSTNOTIFICARptpagrEPSCInstance = beneficiarioCTPOSTNOTIFICARptpagrEPSC;
        this.beneficiarioCTPOSTNOTIFICARptpagrEPSC = beneficiarioCTPOSTNOTIFICARptpagrEPSC != null ? beneficiarioCTPOSTNOTIFICARptpagrEPSC.getOid() : null;
    }

    @JsonIgnore
    public CompanyiaOid getBeneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPC() {
        return this.beneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPC;
    }
    
    public void setBeneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPC(CompanyiaOid beneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPC) {
        this.beneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPC = beneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPC;
    }

    @JsonIgnore
    public Companyia getBeneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPCInstance() {
        return this.beneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPCInstance;
    }
    
    public void setBeneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPCInstance(Companyia beneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPC) {
        this.beneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPCInstance = beneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPC;
        this.beneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPC = beneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPC != null ? beneficiarioCTPOSTNOTIFICARptpagrCompanyiaMPC.getOid() : null;
    }

    @JsonIgnore
    public ParentescoOid getBeneficiarioCTPOSTNOTIFICARptpagrParentescoC() {
        return this.beneficiarioCTPOSTNOTIFICARptpagrParentescoC;
    }
    
    public void setBeneficiarioCTPOSTNOTIFICARptpagrParentescoC(ParentescoOid beneficiarioCTPOSTNOTIFICARptpagrParentescoC) {
        this.beneficiarioCTPOSTNOTIFICARptpagrParentescoC = beneficiarioCTPOSTNOTIFICARptpagrParentescoC;
    }

    @JsonIgnore
    public Parentesco getBeneficiarioCTPOSTNOTIFICARptpagrParentescoCInstance() {
        return this.beneficiarioCTPOSTNOTIFICARptpagrParentescoCInstance;
    }
    
    public void setBeneficiarioCTPOSTNOTIFICARptpagrParentescoCInstance(Parentesco beneficiarioCTPOSTNOTIFICARptpagrParentescoC) {
        this.beneficiarioCTPOSTNOTIFICARptpagrParentescoCInstance = beneficiarioCTPOSTNOTIFICARptpagrParentescoC;
        this.beneficiarioCTPOSTNOTIFICARptpagrParentescoC = beneficiarioCTPOSTNOTIFICARptpagrParentescoC != null ? beneficiarioCTPOSTNOTIFICARptpagrParentescoC.getOid() : null;
    }

    private void checkBeneficiarioCTPOSTNOTIFICARptpagrParentescoC() throws NotNullArgumentException {
        if(this.getBeneficiarioCTPOSTNOTIFICARptpagrParentescoCInstance() == null || this.getBeneficiarioCTPOSTNOTIFICARptpagrParentescoCInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_TPOSTNOTIFICAR, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_TPOSTNOTIFICAR_BENEFICIARIOCTPOSTNOTIFICARPTPAGRPARENTESCOC, BeneficiarioCConstants.SERV_ALIAS_TPOSTNOTIFICAR, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_TPOSTNOTIFICAR_BENEFICIARIOCTPOSTNOTIFICARPTPAGRPARENTESCOC);
        }
    }

    @JsonIgnore
    public String getBeneficiarioCTPOSTNOTIFICARptptNombreCompleto() {
        return this.beneficiarioCTPOSTNOTIFICARptptNombreCompleto;
    }
    
    public void setBeneficiarioCTPOSTNOTIFICARptptNombreCompleto(String beneficiarioCTPOSTNOTIFICARptptNombreCompleto) {
        this.beneficiarioCTPOSTNOTIFICARptptNombreCompleto = beneficiarioCTPOSTNOTIFICARptptNombreCompleto;
    }
}
