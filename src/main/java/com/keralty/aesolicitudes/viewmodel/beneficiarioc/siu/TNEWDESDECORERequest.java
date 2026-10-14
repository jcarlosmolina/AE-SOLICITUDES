package com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.BeneficiarioCConstants;
import com.keralty.aesolicitudes.persistence.Companyia;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Eps;
import com.keralty.aesolicitudes.persistence.EstadoBeneficiario;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.oid.CompanyiaOid;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.EpsOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoBeneficiarioOid;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;
import com.keralty.aesolicitudes.persistence.oid.ParentescoOid;
import com.keralty.aesolicitudes.persistence.oid.TipoIdentificacionOid;
import com.keralty.aesolicitudes.persistence.Parentesco;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TNEWDESDECORERequest {

    @JsonProperty("pt_p_agrepsc_oid")
    private EpsOid beneficiarioCTNEWDESDECOREptpagrEPSC;
    
    @JsonIgnore
    private Eps beneficiarioCTNEWDESDECOREptpagrEPSCInstance;

    @JsonProperty("pt_p_agrcompanyiampc_oid")
    private CompanyiaOid beneficiarioCTNEWDESDECOREptpagrCompanyiaMPC;
    
    @JsonIgnore
    private Companyia beneficiarioCTNEWDESDECOREptpagrCompanyiaMPCInstance;

    @JsonProperty("pt_p_agrparentescoc_oid")
    private ParentescoOid beneficiarioCTNEWDESDECOREptpagrParentescoC;
    
    @JsonIgnore
    private Parentesco beneficiarioCTNEWDESDECOREptpagrParentescoCInstance;

    @JsonProperty("pt_p_agrestadobeneficiarioc_oid")
    private EstadoBeneficiarioOid beneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioC;
    
    @JsonIgnore
    private EstadoBeneficiario beneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioCInstance;

    @JsonProperty("pt_p_agrcontratoc_oid")
    private ContratoCOid beneficiarioCTNEWDESDECOREptpagrContratoC;
    
    @JsonIgnore
    private ContratoC beneficiarioCTNEWDESDECOREptpagrContratoCInstance;

    @JsonProperty("pt_p_agrfamiliasc_oid")
    private FamiliaCOid beneficiarioCTNEWDESDECOREptpagrFamiliasC;
    
    @JsonIgnore
    private FamiliaC beneficiarioCTNEWDESDECOREptpagrFamiliasCInstance;

    @JsonProperty("pt_p_atrcodigotipousuario")
    private String beneficiarioCTNEWDESDECOREptpatrCodigoTipoUsuario;

    @JsonProperty("pt_p_atrindicadorbbgestacion")
    private Boolean beneficiarioCTNEWDESDECOREptpatrIndicadorBBGestacion;

    @JsonProperty("pt_p_atrcodusuariobancorep")
    private String beneficiarioCTNEWDESDECOREptpatrCodUsuarioBancoRep;

    @JsonProperty("pt_p_atrfechaantiguedad")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCTNEWDESDECOREptpatrFechaAntiguedad;

    @JsonProperty("pt_p_atrfechaantiguedadrealosi")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCTNEWDESDECOREptpatrFechaAntiguedadRealOSI;

    @JsonProperty("pt_p_atrestadomedico")
    private Long beneficiarioCTNEWDESDECOREptpatrEstadoMedico;

    @JsonProperty("pt_p_atrtienepreexistencias")
    private Boolean beneficiarioCTNEWDESDECOREptpatrTienePreexistencias;

    @JsonProperty("pt_p_atrfechainiciovigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCTNEWDESDECOREptpatrFechaInicioVigencia;

    @JsonProperty("pt_p_atrfechafinvigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date beneficiarioCTNEWDESDECOREptpatrFechaFinVigencia;

    @JsonProperty("pt_p_atrnumusuario")
    private Long beneficiarioCTNEWDESDECOREptpatrNumUsuario;

    @JsonProperty("pttipoid_oid")
    private TipoIdentificacionOid beneficiarioCTNEWDESDECOREptTipoId;
    
    @JsonIgnore
    private TipoIdentificacion beneficiarioCTNEWDESDECOREptTipoIdInstance;

    @JsonProperty("ptnumidentificacion")
    private String beneficiarioCTNEWDESDECOREptNumIdentificacion;

    @JsonProperty("ptnombrecompleto")
    private String beneficiarioCTNEWDESDECOREptNombreCompleto;

    @JsonProperty("ptcodigocore")
    private Long beneficiarioCTNEWDESDECOREptCodigoCORE;

    public void checkArguments() throws NotNullArgumentException {
        checkBeneficiarioCTNEWDESDECOREptpagrParentescoC();
        checkBeneficiarioCTNEWDESDECOREptpagrContratoC();
        checkBeneficiarioCTNEWDESDECOREptpagrFamiliasC();
        checkBeneficiarioCTNEWDESDECOREptTipoId();
        checkBeneficiarioCTNEWDESDECOREptNumIdentificacion();
    }

    @JsonIgnore
    public EpsOid getBeneficiarioCTNEWDESDECOREptpagrEPSC() {
        return this.beneficiarioCTNEWDESDECOREptpagrEPSC;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptpagrEPSC(EpsOid beneficiarioCTNEWDESDECOREptpagrEPSC) {
        this.beneficiarioCTNEWDESDECOREptpagrEPSC = beneficiarioCTNEWDESDECOREptpagrEPSC;
    }

    @JsonIgnore
    public Eps getBeneficiarioCTNEWDESDECOREptpagrEPSCInstance() {
        return this.beneficiarioCTNEWDESDECOREptpagrEPSCInstance;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptpagrEPSCInstance(Eps beneficiarioCTNEWDESDECOREptpagrEPSC) {
        this.beneficiarioCTNEWDESDECOREptpagrEPSCInstance = beneficiarioCTNEWDESDECOREptpagrEPSC;
        this.beneficiarioCTNEWDESDECOREptpagrEPSC = beneficiarioCTNEWDESDECOREptpagrEPSC != null ? beneficiarioCTNEWDESDECOREptpagrEPSC.getOid() : null;
    }

    @JsonIgnore
    public CompanyiaOid getBeneficiarioCTNEWDESDECOREptpagrCompanyiaMPC() {
        return this.beneficiarioCTNEWDESDECOREptpagrCompanyiaMPC;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptpagrCompanyiaMPC(CompanyiaOid beneficiarioCTNEWDESDECOREptpagrCompanyiaMPC) {
        this.beneficiarioCTNEWDESDECOREptpagrCompanyiaMPC = beneficiarioCTNEWDESDECOREptpagrCompanyiaMPC;
    }

    @JsonIgnore
    public Companyia getBeneficiarioCTNEWDESDECOREptpagrCompanyiaMPCInstance() {
        return this.beneficiarioCTNEWDESDECOREptpagrCompanyiaMPCInstance;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptpagrCompanyiaMPCInstance(Companyia beneficiarioCTNEWDESDECOREptpagrCompanyiaMPC) {
        this.beneficiarioCTNEWDESDECOREptpagrCompanyiaMPCInstance = beneficiarioCTNEWDESDECOREptpagrCompanyiaMPC;
        this.beneficiarioCTNEWDESDECOREptpagrCompanyiaMPC = beneficiarioCTNEWDESDECOREptpagrCompanyiaMPC != null ? beneficiarioCTNEWDESDECOREptpagrCompanyiaMPC.getOid() : null;
    }

    @JsonIgnore
    public ParentescoOid getBeneficiarioCTNEWDESDECOREptpagrParentescoC() {
        return this.beneficiarioCTNEWDESDECOREptpagrParentescoC;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptpagrParentescoC(ParentescoOid beneficiarioCTNEWDESDECOREptpagrParentescoC) {
        this.beneficiarioCTNEWDESDECOREptpagrParentescoC = beneficiarioCTNEWDESDECOREptpagrParentescoC;
    }

    @JsonIgnore
    public Parentesco getBeneficiarioCTNEWDESDECOREptpagrParentescoCInstance() {
        return this.beneficiarioCTNEWDESDECOREptpagrParentescoCInstance;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptpagrParentescoCInstance(Parentesco beneficiarioCTNEWDESDECOREptpagrParentescoC) {
        this.beneficiarioCTNEWDESDECOREptpagrParentescoCInstance = beneficiarioCTNEWDESDECOREptpagrParentescoC;
        this.beneficiarioCTNEWDESDECOREptpagrParentescoC = beneficiarioCTNEWDESDECOREptpagrParentescoC != null ? beneficiarioCTNEWDESDECOREptpagrParentescoC.getOid() : null;
    }

    private void checkBeneficiarioCTNEWDESDECOREptpagrParentescoC() throws NotNullArgumentException {
        if(this.getBeneficiarioCTNEWDESDECOREptpagrParentescoCInstance() == null || this.getBeneficiarioCTNEWDESDECOREptpagrParentescoCInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_TNEWDESDECORE, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_TNEWDESDECORE_BENEFICIARIOCTNEWDESDECOREPTPAGRPARENTESCOC, BeneficiarioCConstants.SERV_ALIAS_TNEWDESDECORE, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_TNEWDESDECORE_BENEFICIARIOCTNEWDESDECOREPTPAGRPARENTESCOC);
        }
    }

    @JsonIgnore
    public EstadoBeneficiarioOid getBeneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioC() {
        return this.beneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioC;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioC(EstadoBeneficiarioOid beneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioC) {
        this.beneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioC = beneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioC;
    }

    @JsonIgnore
    public EstadoBeneficiario getBeneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioCInstance() {
        return this.beneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioCInstance;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioCInstance(EstadoBeneficiario beneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioC) {
        this.beneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioCInstance = beneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioC;
        this.beneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioC = beneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioC != null ? beneficiarioCTNEWDESDECOREptpagrEstadoBeneficiarioC.getOid() : null;
    }

    @JsonIgnore
    public ContratoCOid getBeneficiarioCTNEWDESDECOREptpagrContratoC() {
        return this.beneficiarioCTNEWDESDECOREptpagrContratoC;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptpagrContratoC(ContratoCOid beneficiarioCTNEWDESDECOREptpagrContratoC) {
        this.beneficiarioCTNEWDESDECOREptpagrContratoC = beneficiarioCTNEWDESDECOREptpagrContratoC;
    }

    @JsonIgnore
    public ContratoC getBeneficiarioCTNEWDESDECOREptpagrContratoCInstance() {
        return this.beneficiarioCTNEWDESDECOREptpagrContratoCInstance;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptpagrContratoCInstance(ContratoC beneficiarioCTNEWDESDECOREptpagrContratoC) {
        this.beneficiarioCTNEWDESDECOREptpagrContratoCInstance = beneficiarioCTNEWDESDECOREptpagrContratoC;
        this.beneficiarioCTNEWDESDECOREptpagrContratoC = beneficiarioCTNEWDESDECOREptpagrContratoC != null ? beneficiarioCTNEWDESDECOREptpagrContratoC.getOid() : null;
    }

    private void checkBeneficiarioCTNEWDESDECOREptpagrContratoC() throws NotNullArgumentException {
        if(this.getBeneficiarioCTNEWDESDECOREptpagrContratoCInstance() == null || this.getBeneficiarioCTNEWDESDECOREptpagrContratoCInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_TNEWDESDECORE, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_TNEWDESDECORE_BENEFICIARIOCTNEWDESDECOREPTPAGRCONTRATOC, BeneficiarioCConstants.SERV_ALIAS_TNEWDESDECORE, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_TNEWDESDECORE_BENEFICIARIOCTNEWDESDECOREPTPAGRCONTRATOC);
        }
    }

    @JsonIgnore
    public FamiliaCOid getBeneficiarioCTNEWDESDECOREptpagrFamiliasC() {
        return this.beneficiarioCTNEWDESDECOREptpagrFamiliasC;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptpagrFamiliasC(FamiliaCOid beneficiarioCTNEWDESDECOREptpagrFamiliasC) {
        this.beneficiarioCTNEWDESDECOREptpagrFamiliasC = beneficiarioCTNEWDESDECOREptpagrFamiliasC;
    }

    @JsonIgnore
    public FamiliaC getBeneficiarioCTNEWDESDECOREptpagrFamiliasCInstance() {
        return this.beneficiarioCTNEWDESDECOREptpagrFamiliasCInstance;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptpagrFamiliasCInstance(FamiliaC beneficiarioCTNEWDESDECOREptpagrFamiliasC) {
        this.beneficiarioCTNEWDESDECOREptpagrFamiliasCInstance = beneficiarioCTNEWDESDECOREptpagrFamiliasC;
        this.beneficiarioCTNEWDESDECOREptpagrFamiliasC = beneficiarioCTNEWDESDECOREptpagrFamiliasC != null ? beneficiarioCTNEWDESDECOREptpagrFamiliasC.getOid() : null;
    }

    private void checkBeneficiarioCTNEWDESDECOREptpagrFamiliasC() throws NotNullArgumentException {
        if(this.getBeneficiarioCTNEWDESDECOREptpagrFamiliasCInstance() == null || this.getBeneficiarioCTNEWDESDECOREptpagrFamiliasCInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_TNEWDESDECORE, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_TNEWDESDECORE_BENEFICIARIOCTNEWDESDECOREPTPAGRFAMILIASC, BeneficiarioCConstants.SERV_ALIAS_TNEWDESDECORE, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_TNEWDESDECORE_BENEFICIARIOCTNEWDESDECOREPTPAGRFAMILIASC);
        }
    }

    @JsonIgnore
    public String getBeneficiarioCTNEWDESDECOREptpatrCodigoTipoUsuario() {
        return this.beneficiarioCTNEWDESDECOREptpatrCodigoTipoUsuario;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptpatrCodigoTipoUsuario(String beneficiarioCTNEWDESDECOREptpatrCodigoTipoUsuario) {
        this.beneficiarioCTNEWDESDECOREptpatrCodigoTipoUsuario = beneficiarioCTNEWDESDECOREptpatrCodigoTipoUsuario;
    }

    @JsonIgnore
    public Boolean getBeneficiarioCTNEWDESDECOREptpatrIndicadorBBGestacion() {
        return this.beneficiarioCTNEWDESDECOREptpatrIndicadorBBGestacion;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptpatrIndicadorBBGestacion(Boolean beneficiarioCTNEWDESDECOREptpatrIndicadorBBGestacion) {
        this.beneficiarioCTNEWDESDECOREptpatrIndicadorBBGestacion = beneficiarioCTNEWDESDECOREptpatrIndicadorBBGestacion;
    }

    @JsonIgnore
    public String getBeneficiarioCTNEWDESDECOREptpatrCodUsuarioBancoRep() {
        return this.beneficiarioCTNEWDESDECOREptpatrCodUsuarioBancoRep;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptpatrCodUsuarioBancoRep(String beneficiarioCTNEWDESDECOREptpatrCodUsuarioBancoRep) {
        this.beneficiarioCTNEWDESDECOREptpatrCodUsuarioBancoRep = beneficiarioCTNEWDESDECOREptpatrCodUsuarioBancoRep;
    }

    @JsonIgnore
    public Date getBeneficiarioCTNEWDESDECOREptpatrFechaAntiguedad() {
        return this.beneficiarioCTNEWDESDECOREptpatrFechaAntiguedad;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCTNEWDESDECOREptpatrFechaAntiguedad(Date beneficiarioCTNEWDESDECOREptpatrFechaAntiguedad) {
        this.beneficiarioCTNEWDESDECOREptpatrFechaAntiguedad = beneficiarioCTNEWDESDECOREptpatrFechaAntiguedad;
    }

    @JsonIgnore
    public Date getBeneficiarioCTNEWDESDECOREptpatrFechaAntiguedadRealOSI() {
        return this.beneficiarioCTNEWDESDECOREptpatrFechaAntiguedadRealOSI;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCTNEWDESDECOREptpatrFechaAntiguedadRealOSI(Date beneficiarioCTNEWDESDECOREptpatrFechaAntiguedadRealOSI) {
        this.beneficiarioCTNEWDESDECOREptpatrFechaAntiguedadRealOSI = beneficiarioCTNEWDESDECOREptpatrFechaAntiguedadRealOSI;
    }

    @JsonIgnore
    public Long getBeneficiarioCTNEWDESDECOREptpatrEstadoMedico() {
        return this.beneficiarioCTNEWDESDECOREptpatrEstadoMedico;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptpatrEstadoMedico(Long beneficiarioCTNEWDESDECOREptpatrEstadoMedico) {
        this.beneficiarioCTNEWDESDECOREptpatrEstadoMedico = beneficiarioCTNEWDESDECOREptpatrEstadoMedico;
    }

    @JsonIgnore
    public Boolean getBeneficiarioCTNEWDESDECOREptpatrTienePreexistencias() {
        return this.beneficiarioCTNEWDESDECOREptpatrTienePreexistencias;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptpatrTienePreexistencias(Boolean beneficiarioCTNEWDESDECOREptpatrTienePreexistencias) {
        this.beneficiarioCTNEWDESDECOREptpatrTienePreexistencias = beneficiarioCTNEWDESDECOREptpatrTienePreexistencias;
    }

    @JsonIgnore
    public Date getBeneficiarioCTNEWDESDECOREptpatrFechaInicioVigencia() {
        return this.beneficiarioCTNEWDESDECOREptpatrFechaInicioVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCTNEWDESDECOREptpatrFechaInicioVigencia(Date beneficiarioCTNEWDESDECOREptpatrFechaInicioVigencia) {
        this.beneficiarioCTNEWDESDECOREptpatrFechaInicioVigencia = beneficiarioCTNEWDESDECOREptpatrFechaInicioVigencia;
    }

    @JsonIgnore
    public Date getBeneficiarioCTNEWDESDECOREptpatrFechaFinVigencia() {
        return this.beneficiarioCTNEWDESDECOREptpatrFechaFinVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setBeneficiarioCTNEWDESDECOREptpatrFechaFinVigencia(Date beneficiarioCTNEWDESDECOREptpatrFechaFinVigencia) {
        this.beneficiarioCTNEWDESDECOREptpatrFechaFinVigencia = beneficiarioCTNEWDESDECOREptpatrFechaFinVigencia;
    }

    @JsonIgnore
    public Long getBeneficiarioCTNEWDESDECOREptpatrNumUsuario() {
        return this.beneficiarioCTNEWDESDECOREptpatrNumUsuario;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptpatrNumUsuario(Long beneficiarioCTNEWDESDECOREptpatrNumUsuario) {
        this.beneficiarioCTNEWDESDECOREptpatrNumUsuario = beneficiarioCTNEWDESDECOREptpatrNumUsuario;
    }

    @JsonIgnore
    public TipoIdentificacionOid getBeneficiarioCTNEWDESDECOREptTipoId() {
        return this.beneficiarioCTNEWDESDECOREptTipoId;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptTipoId(TipoIdentificacionOid beneficiarioCTNEWDESDECOREptTipoId) {
        this.beneficiarioCTNEWDESDECOREptTipoId = beneficiarioCTNEWDESDECOREptTipoId;
    }

    @JsonIgnore
    public TipoIdentificacion getBeneficiarioCTNEWDESDECOREptTipoIdInstance() {
        return this.beneficiarioCTNEWDESDECOREptTipoIdInstance;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptTipoIdInstance(TipoIdentificacion beneficiarioCTNEWDESDECOREptTipoId) {
        this.beneficiarioCTNEWDESDECOREptTipoIdInstance = beneficiarioCTNEWDESDECOREptTipoId;
        this.beneficiarioCTNEWDESDECOREptTipoId = beneficiarioCTNEWDESDECOREptTipoId != null ? beneficiarioCTNEWDESDECOREptTipoId.getOid() : null;
    }

    private void checkBeneficiarioCTNEWDESDECOREptTipoId() throws NotNullArgumentException {
        if(this.getBeneficiarioCTNEWDESDECOREptTipoIdInstance() == null || this.getBeneficiarioCTNEWDESDECOREptTipoIdInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_TNEWDESDECORE, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_TNEWDESDECORE_BENEFICIARIOCTNEWDESDECOREPTTIPOID, BeneficiarioCConstants.SERV_ALIAS_TNEWDESDECORE, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_TNEWDESDECORE_BENEFICIARIOCTNEWDESDECOREPTTIPOID);
        }
    }

    @JsonIgnore
    public String getBeneficiarioCTNEWDESDECOREptNumIdentificacion() {
        return this.beneficiarioCTNEWDESDECOREptNumIdentificacion;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptNumIdentificacion(String beneficiarioCTNEWDESDECOREptNumIdentificacion) {
        this.beneficiarioCTNEWDESDECOREptNumIdentificacion = beneficiarioCTNEWDESDECOREptNumIdentificacion;
    }

    private void checkBeneficiarioCTNEWDESDECOREptNumIdentificacion() throws NotNullArgumentException {
        if(this.getBeneficiarioCTNEWDESDECOREptNumIdentificacion() == null) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_TNEWDESDECORE, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_TNEWDESDECORE_BENEFICIARIOCTNEWDESDECOREPTNUMIDENTIFICACION, BeneficiarioCConstants.SERV_ALIAS_TNEWDESDECORE, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_TNEWDESDECORE_BENEFICIARIOCTNEWDESDECOREPTNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getBeneficiarioCTNEWDESDECOREptNombreCompleto() {
        return this.beneficiarioCTNEWDESDECOREptNombreCompleto;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptNombreCompleto(String beneficiarioCTNEWDESDECOREptNombreCompleto) {
        this.beneficiarioCTNEWDESDECOREptNombreCompleto = beneficiarioCTNEWDESDECOREptNombreCompleto;
    }

    @JsonIgnore
    public Long getBeneficiarioCTNEWDESDECOREptCodigoCORE() {
        return this.beneficiarioCTNEWDESDECOREptCodigoCORE;
    }
    
    public void setBeneficiarioCTNEWDESDECOREptCodigoCORE(Long beneficiarioCTNEWDESDECOREptCodigoCORE) {
        this.beneficiarioCTNEWDESDECOREptCodigoCORE = beneficiarioCTNEWDESDECOREptCodigoCORE;
    }
}
