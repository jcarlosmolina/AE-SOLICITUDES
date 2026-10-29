package com.keralty.aesolicitudes.viewmodel.familiac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.FamiliaCConstants;
import com.keralty.aesolicitudes.persistence.Companyia;
import com.keralty.aesolicitudes.persistence.Eps;
import com.keralty.aesolicitudes.persistence.EstadoBeneficiario;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.oid.CompanyiaOid;
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

public class TCREARACTBENEFRequest {

    @JsonProperty("p_thisfamiliac_oid")
    private FamiliaCOid familiaCTCREARACTBENEFpthisFamiliaC;
    
    @JsonIgnore
    private FamiliaC familiaCTCREARACTBENEFpthisFamiliaCInstance;

    @JsonProperty("pt_p_agrepsc_oid")
    private EpsOid familiaCTCREARACTBENEFptpagrEPSC;
    
    @JsonIgnore
    private Eps familiaCTCREARACTBENEFptpagrEPSCInstance;

    @JsonProperty("pt_p_agrcompanyiampc_oid")
    private CompanyiaOid familiaCTCREARACTBENEFptpagrCompanyiaMPC;
    
    @JsonIgnore
    private Companyia familiaCTCREARACTBENEFptpagrCompanyiaMPCInstance;

    @JsonProperty("pt_p_agrparentescoc_oid")
    private ParentescoOid familiaCTCREARACTBENEFptpagrParentescoC;
    
    @JsonIgnore
    private Parentesco familiaCTCREARACTBENEFptpagrParentescoCInstance;

    @JsonProperty("pt_p_agrestadobeneficiarioc_oid")
    private EstadoBeneficiarioOid familiaCTCREARACTBENEFptpagrEstadoBeneficiarioC;
    
    @JsonIgnore
    private EstadoBeneficiario familiaCTCREARACTBENEFptpagrEstadoBeneficiarioCInstance;

    @JsonProperty("pt_p_atrcodigotipousuario")
    private String familiaCTCREARACTBENEFptpatrCodigoTipoUsuario;

    @JsonProperty("pt_p_atrindicadorbbgestacion")
    private Boolean familiaCTCREARACTBENEFptpatrIndicadorBBGestacion;

    @JsonProperty("pt_p_atrcodusuariobancorep")
    private String familiaCTCREARACTBENEFptpatrCodUsuarioBancoRep;

    @JsonProperty("pt_p_atrfechaantiguedad")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date familiaCTCREARACTBENEFptpatrFechaAntiguedad;

    @JsonProperty("pt_p_atrfechaantiguedadrealosi")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date familiaCTCREARACTBENEFptpatrFechaAntiguedadRealOSI;

    @JsonProperty("pt_p_atrestadomedico")
    private Long familiaCTCREARACTBENEFptpatrEstadoMedico;

    @JsonProperty("pt_p_atrtienepreexistencias")
    private Boolean familiaCTCREARACTBENEFptpatrTienePreexistencias;

    @JsonProperty("pt_p_atrfechainiciovigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date familiaCTCREARACTBENEFptpatrFechaInicioVigencia;

    @JsonProperty("pt_p_atrfechafinvigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date familiaCTCREARACTBENEFptpatrFechaFinVigencia;

    @JsonProperty("pt_p_atrnumusuario")
    private Long familiaCTCREARACTBENEFptpatrNumUsuario;

    @JsonProperty("pt_pttipoid_oid")
    private TipoIdentificacionOid familiaCTCREARACTBENEFptptTipoId;
    
    @JsonIgnore
    private TipoIdentificacion familiaCTCREARACTBENEFptptTipoIdInstance;

    @JsonProperty("pt_ptnumidentificacion")
    private String familiaCTCREARACTBENEFptptNumIdentificacion;

    @JsonProperty("pt_ptnombrecompleto")
    private String familiaCTCREARACTBENEFptptNombreCompleto;

    @JsonProperty("pt_ptcodigocore")
    private Long familiaCTCREARACTBENEFptptCodigoCORE;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaCTCREARACTBENEFpthisFamiliaC();
        checkFamiliaCTCREARACTBENEFptpagrParentescoC();
        checkFamiliaCTCREARACTBENEFptptTipoId();
        checkFamiliaCTCREARACTBENEFptptNumIdentificacion();
    }

    @JsonIgnore
    public FamiliaCOid getFamiliaCTCREARACTBENEFpthisFamiliaC() {
        return this.familiaCTCREARACTBENEFpthisFamiliaC;
    }
    
    public void setFamiliaCTCREARACTBENEFpthisFamiliaC(FamiliaCOid familiaCTCREARACTBENEFpthisFamiliaC) {
        this.familiaCTCREARACTBENEFpthisFamiliaC = familiaCTCREARACTBENEFpthisFamiliaC;
    }

    @JsonIgnore
    public FamiliaC getFamiliaCTCREARACTBENEFpthisFamiliaCInstance() {
        return this.familiaCTCREARACTBENEFpthisFamiliaCInstance;
    }
    
    public void setFamiliaCTCREARACTBENEFpthisFamiliaCInstance(FamiliaC familiaCTCREARACTBENEFpthisFamiliaC) {
        this.familiaCTCREARACTBENEFpthisFamiliaCInstance = familiaCTCREARACTBENEFpthisFamiliaC;
        this.familiaCTCREARACTBENEFpthisFamiliaC = familiaCTCREARACTBENEFpthisFamiliaC != null ? familiaCTCREARACTBENEFpthisFamiliaC.getOid() : null;
    }

    private void checkFamiliaCTCREARACTBENEFpthisFamiliaC() throws NotNullArgumentException {
        if(this.getFamiliaCTCREARACTBENEFpthisFamiliaCInstance() == null || this.getFamiliaCTCREARACTBENEFpthisFamiliaCInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaCConstants.SERV_ID_TCREARACTBENEF, FamiliaCConstants.CLASS_ID, FamiliaCConstants.ARG_ID_TCREARACTBENEF_FAMILIACTCREARACTBENEFPTHISFAMILIAC, FamiliaCConstants.SERV_ALIAS_TCREARACTBENEF, FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ARG_ALIAS_TCREARACTBENEF_FAMILIACTCREARACTBENEFPTHISFAMILIAC);
        }
    }

    @JsonIgnore
    public EpsOid getFamiliaCTCREARACTBENEFptpagrEPSC() {
        return this.familiaCTCREARACTBENEFptpagrEPSC;
    }
    
    public void setFamiliaCTCREARACTBENEFptpagrEPSC(EpsOid familiaCTCREARACTBENEFptpagrEPSC) {
        this.familiaCTCREARACTBENEFptpagrEPSC = familiaCTCREARACTBENEFptpagrEPSC;
    }

    @JsonIgnore
    public Eps getFamiliaCTCREARACTBENEFptpagrEPSCInstance() {
        return this.familiaCTCREARACTBENEFptpagrEPSCInstance;
    }
    
    public void setFamiliaCTCREARACTBENEFptpagrEPSCInstance(Eps familiaCTCREARACTBENEFptpagrEPSC) {
        this.familiaCTCREARACTBENEFptpagrEPSCInstance = familiaCTCREARACTBENEFptpagrEPSC;
        this.familiaCTCREARACTBENEFptpagrEPSC = familiaCTCREARACTBENEFptpagrEPSC != null ? familiaCTCREARACTBENEFptpagrEPSC.getOid() : null;
    }

    @JsonIgnore
    public CompanyiaOid getFamiliaCTCREARACTBENEFptpagrCompanyiaMPC() {
        return this.familiaCTCREARACTBENEFptpagrCompanyiaMPC;
    }
    
    public void setFamiliaCTCREARACTBENEFptpagrCompanyiaMPC(CompanyiaOid familiaCTCREARACTBENEFptpagrCompanyiaMPC) {
        this.familiaCTCREARACTBENEFptpagrCompanyiaMPC = familiaCTCREARACTBENEFptpagrCompanyiaMPC;
    }

    @JsonIgnore
    public Companyia getFamiliaCTCREARACTBENEFptpagrCompanyiaMPCInstance() {
        return this.familiaCTCREARACTBENEFptpagrCompanyiaMPCInstance;
    }
    
    public void setFamiliaCTCREARACTBENEFptpagrCompanyiaMPCInstance(Companyia familiaCTCREARACTBENEFptpagrCompanyiaMPC) {
        this.familiaCTCREARACTBENEFptpagrCompanyiaMPCInstance = familiaCTCREARACTBENEFptpagrCompanyiaMPC;
        this.familiaCTCREARACTBENEFptpagrCompanyiaMPC = familiaCTCREARACTBENEFptpagrCompanyiaMPC != null ? familiaCTCREARACTBENEFptpagrCompanyiaMPC.getOid() : null;
    }

    @JsonIgnore
    public ParentescoOid getFamiliaCTCREARACTBENEFptpagrParentescoC() {
        return this.familiaCTCREARACTBENEFptpagrParentescoC;
    }
    
    public void setFamiliaCTCREARACTBENEFptpagrParentescoC(ParentescoOid familiaCTCREARACTBENEFptpagrParentescoC) {
        this.familiaCTCREARACTBENEFptpagrParentescoC = familiaCTCREARACTBENEFptpagrParentescoC;
    }

    @JsonIgnore
    public Parentesco getFamiliaCTCREARACTBENEFptpagrParentescoCInstance() {
        return this.familiaCTCREARACTBENEFptpagrParentescoCInstance;
    }
    
    public void setFamiliaCTCREARACTBENEFptpagrParentescoCInstance(Parentesco familiaCTCREARACTBENEFptpagrParentescoC) {
        this.familiaCTCREARACTBENEFptpagrParentescoCInstance = familiaCTCREARACTBENEFptpagrParentescoC;
        this.familiaCTCREARACTBENEFptpagrParentescoC = familiaCTCREARACTBENEFptpagrParentescoC != null ? familiaCTCREARACTBENEFptpagrParentescoC.getOid() : null;
    }

    private void checkFamiliaCTCREARACTBENEFptpagrParentescoC() throws NotNullArgumentException {
        if(this.getFamiliaCTCREARACTBENEFptpagrParentescoCInstance() == null || this.getFamiliaCTCREARACTBENEFptpagrParentescoCInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaCConstants.SERV_ID_TCREARACTBENEF, FamiliaCConstants.CLASS_ID, FamiliaCConstants.ARG_ID_TCREARACTBENEF_FAMILIACTCREARACTBENEFPTPAGRPARENTESCOC, FamiliaCConstants.SERV_ALIAS_TCREARACTBENEF, FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ARG_ALIAS_TCREARACTBENEF_FAMILIACTCREARACTBENEFPTPAGRPARENTESCOC);
        }
    }

    @JsonIgnore
    public EstadoBeneficiarioOid getFamiliaCTCREARACTBENEFptpagrEstadoBeneficiarioC() {
        return this.familiaCTCREARACTBENEFptpagrEstadoBeneficiarioC;
    }
    
    public void setFamiliaCTCREARACTBENEFptpagrEstadoBeneficiarioC(EstadoBeneficiarioOid familiaCTCREARACTBENEFptpagrEstadoBeneficiarioC) {
        this.familiaCTCREARACTBENEFptpagrEstadoBeneficiarioC = familiaCTCREARACTBENEFptpagrEstadoBeneficiarioC;
    }

    @JsonIgnore
    public EstadoBeneficiario getFamiliaCTCREARACTBENEFptpagrEstadoBeneficiarioCInstance() {
        return this.familiaCTCREARACTBENEFptpagrEstadoBeneficiarioCInstance;
    }
    
    public void setFamiliaCTCREARACTBENEFptpagrEstadoBeneficiarioCInstance(EstadoBeneficiario familiaCTCREARACTBENEFptpagrEstadoBeneficiarioC) {
        this.familiaCTCREARACTBENEFptpagrEstadoBeneficiarioCInstance = familiaCTCREARACTBENEFptpagrEstadoBeneficiarioC;
        this.familiaCTCREARACTBENEFptpagrEstadoBeneficiarioC = familiaCTCREARACTBENEFptpagrEstadoBeneficiarioC != null ? familiaCTCREARACTBENEFptpagrEstadoBeneficiarioC.getOid() : null;
    }

    @JsonIgnore
    public String getFamiliaCTCREARACTBENEFptpatrCodigoTipoUsuario() {
        return this.familiaCTCREARACTBENEFptpatrCodigoTipoUsuario;
    }
    
    public void setFamiliaCTCREARACTBENEFptpatrCodigoTipoUsuario(String familiaCTCREARACTBENEFptpatrCodigoTipoUsuario) {
        this.familiaCTCREARACTBENEFptpatrCodigoTipoUsuario = familiaCTCREARACTBENEFptpatrCodigoTipoUsuario;
    }

    @JsonIgnore
    public Boolean getFamiliaCTCREARACTBENEFptpatrIndicadorBBGestacion() {
        return this.familiaCTCREARACTBENEFptpatrIndicadorBBGestacion;
    }
    
    public void setFamiliaCTCREARACTBENEFptpatrIndicadorBBGestacion(Boolean familiaCTCREARACTBENEFptpatrIndicadorBBGestacion) {
        this.familiaCTCREARACTBENEFptpatrIndicadorBBGestacion = familiaCTCREARACTBENEFptpatrIndicadorBBGestacion;
    }

    @JsonIgnore
    public String getFamiliaCTCREARACTBENEFptpatrCodUsuarioBancoRep() {
        return this.familiaCTCREARACTBENEFptpatrCodUsuarioBancoRep;
    }
    
    public void setFamiliaCTCREARACTBENEFptpatrCodUsuarioBancoRep(String familiaCTCREARACTBENEFptpatrCodUsuarioBancoRep) {
        this.familiaCTCREARACTBENEFptpatrCodUsuarioBancoRep = familiaCTCREARACTBENEFptpatrCodUsuarioBancoRep;
    }

    @JsonIgnore
    public Date getFamiliaCTCREARACTBENEFptpatrFechaAntiguedad() {
        return this.familiaCTCREARACTBENEFptpatrFechaAntiguedad;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setFamiliaCTCREARACTBENEFptpatrFechaAntiguedad(Date familiaCTCREARACTBENEFptpatrFechaAntiguedad) {
        this.familiaCTCREARACTBENEFptpatrFechaAntiguedad = familiaCTCREARACTBENEFptpatrFechaAntiguedad;
    }

    @JsonIgnore
    public Date getFamiliaCTCREARACTBENEFptpatrFechaAntiguedadRealOSI() {
        return this.familiaCTCREARACTBENEFptpatrFechaAntiguedadRealOSI;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setFamiliaCTCREARACTBENEFptpatrFechaAntiguedadRealOSI(Date familiaCTCREARACTBENEFptpatrFechaAntiguedadRealOSI) {
        this.familiaCTCREARACTBENEFptpatrFechaAntiguedadRealOSI = familiaCTCREARACTBENEFptpatrFechaAntiguedadRealOSI;
    }

    @JsonIgnore
    public Long getFamiliaCTCREARACTBENEFptpatrEstadoMedico() {
        return this.familiaCTCREARACTBENEFptpatrEstadoMedico;
    }
    
    public void setFamiliaCTCREARACTBENEFptpatrEstadoMedico(Long familiaCTCREARACTBENEFptpatrEstadoMedico) {
        this.familiaCTCREARACTBENEFptpatrEstadoMedico = familiaCTCREARACTBENEFptpatrEstadoMedico;
    }

    @JsonIgnore
    public Boolean getFamiliaCTCREARACTBENEFptpatrTienePreexistencias() {
        return this.familiaCTCREARACTBENEFptpatrTienePreexistencias;
    }
    
    public void setFamiliaCTCREARACTBENEFptpatrTienePreexistencias(Boolean familiaCTCREARACTBENEFptpatrTienePreexistencias) {
        this.familiaCTCREARACTBENEFptpatrTienePreexistencias = familiaCTCREARACTBENEFptpatrTienePreexistencias;
    }

    @JsonIgnore
    public Date getFamiliaCTCREARACTBENEFptpatrFechaInicioVigencia() {
        return this.familiaCTCREARACTBENEFptpatrFechaInicioVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setFamiliaCTCREARACTBENEFptpatrFechaInicioVigencia(Date familiaCTCREARACTBENEFptpatrFechaInicioVigencia) {
        this.familiaCTCREARACTBENEFptpatrFechaInicioVigencia = familiaCTCREARACTBENEFptpatrFechaInicioVigencia;
    }

    @JsonIgnore
    public Date getFamiliaCTCREARACTBENEFptpatrFechaFinVigencia() {
        return this.familiaCTCREARACTBENEFptpatrFechaFinVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setFamiliaCTCREARACTBENEFptpatrFechaFinVigencia(Date familiaCTCREARACTBENEFptpatrFechaFinVigencia) {
        this.familiaCTCREARACTBENEFptpatrFechaFinVigencia = familiaCTCREARACTBENEFptpatrFechaFinVigencia;
    }

    @JsonIgnore
    public Long getFamiliaCTCREARACTBENEFptpatrNumUsuario() {
        return this.familiaCTCREARACTBENEFptpatrNumUsuario;
    }
    
    public void setFamiliaCTCREARACTBENEFptpatrNumUsuario(Long familiaCTCREARACTBENEFptpatrNumUsuario) {
        this.familiaCTCREARACTBENEFptpatrNumUsuario = familiaCTCREARACTBENEFptpatrNumUsuario;
    }

    @JsonIgnore
    public TipoIdentificacionOid getFamiliaCTCREARACTBENEFptptTipoId() {
        return this.familiaCTCREARACTBENEFptptTipoId;
    }
    
    public void setFamiliaCTCREARACTBENEFptptTipoId(TipoIdentificacionOid familiaCTCREARACTBENEFptptTipoId) {
        this.familiaCTCREARACTBENEFptptTipoId = familiaCTCREARACTBENEFptptTipoId;
    }

    @JsonIgnore
    public TipoIdentificacion getFamiliaCTCREARACTBENEFptptTipoIdInstance() {
        return this.familiaCTCREARACTBENEFptptTipoIdInstance;
    }
    
    public void setFamiliaCTCREARACTBENEFptptTipoIdInstance(TipoIdentificacion familiaCTCREARACTBENEFptptTipoId) {
        this.familiaCTCREARACTBENEFptptTipoIdInstance = familiaCTCREARACTBENEFptptTipoId;
        this.familiaCTCREARACTBENEFptptTipoId = familiaCTCREARACTBENEFptptTipoId != null ? familiaCTCREARACTBENEFptptTipoId.getOid() : null;
    }

    private void checkFamiliaCTCREARACTBENEFptptTipoId() throws NotNullArgumentException {
        if(this.getFamiliaCTCREARACTBENEFptptTipoIdInstance() == null || this.getFamiliaCTCREARACTBENEFptptTipoIdInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaCConstants.SERV_ID_TCREARACTBENEF, FamiliaCConstants.CLASS_ID, FamiliaCConstants.ARG_ID_TCREARACTBENEF_FAMILIACTCREARACTBENEFPTPTTIPOID, FamiliaCConstants.SERV_ALIAS_TCREARACTBENEF, FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ARG_ALIAS_TCREARACTBENEF_FAMILIACTCREARACTBENEFPTPTTIPOID);
        }
    }

    @JsonIgnore
    public String getFamiliaCTCREARACTBENEFptptNumIdentificacion() {
        return this.familiaCTCREARACTBENEFptptNumIdentificacion;
    }
    
    public void setFamiliaCTCREARACTBENEFptptNumIdentificacion(String familiaCTCREARACTBENEFptptNumIdentificacion) {
        this.familiaCTCREARACTBENEFptptNumIdentificacion = familiaCTCREARACTBENEFptptNumIdentificacion;
    }

    private void checkFamiliaCTCREARACTBENEFptptNumIdentificacion() throws NotNullArgumentException {
        if(this.getFamiliaCTCREARACTBENEFptptNumIdentificacion() == null) {
            throw new NotNullArgumentException(FamiliaCConstants.SERV_ID_TCREARACTBENEF, FamiliaCConstants.CLASS_ID, FamiliaCConstants.ARG_ID_TCREARACTBENEF_FAMILIACTCREARACTBENEFPTPTNUMIDENTIFICACION, FamiliaCConstants.SERV_ALIAS_TCREARACTBENEF, FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ARG_ALIAS_TCREARACTBENEF_FAMILIACTCREARACTBENEFPTPTNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getFamiliaCTCREARACTBENEFptptNombreCompleto() {
        return this.familiaCTCREARACTBENEFptptNombreCompleto;
    }
    
    public void setFamiliaCTCREARACTBENEFptptNombreCompleto(String familiaCTCREARACTBENEFptptNombreCompleto) {
        this.familiaCTCREARACTBENEFptptNombreCompleto = familiaCTCREARACTBENEFptptNombreCompleto;
    }

    @JsonIgnore
    public Long getFamiliaCTCREARACTBENEFptptCodigoCORE() {
        return this.familiaCTCREARACTBENEFptptCodigoCORE;
    }
    
    public void setFamiliaCTCREARACTBENEFptptCodigoCORE(Long familiaCTCREARACTBENEFptptCodigoCORE) {
        this.familiaCTCREARACTBENEFptptCodigoCORE = familiaCTCREARACTBENEFptptCodigoCORE;
    }
}
