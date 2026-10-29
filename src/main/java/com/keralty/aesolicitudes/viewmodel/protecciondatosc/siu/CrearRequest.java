package com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ProteccionDatosCConstants;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Productos;

public class CrearRequest {

    @JsonProperty("p_agrproductoc_oid")
    private ProductosOid proteccionDatosCcrearpagrProductoC;
    
    @JsonIgnore
    private Productos proteccionDatosCcrearpagrProductoCInstance;

    @JsonProperty("p_agrpersonac_oid")
    private PersonaCOid proteccionDatosCcrearpagrPersonaC;
    
    @JsonIgnore
    private PersonaC proteccionDatosCcrearpagrPersonaCInstance;

    @JsonProperty("p_atrcodrol")
    private String proteccionDatosCcrearpatrCodRol;

    @JsonProperty("p_atrinformacionsaludsms")
    private Boolean proteccionDatosCcrearpatrInformacionSaludSMS;

    @JsonProperty("p_atrinformacionsaludemail")
    private Boolean proteccionDatosCcrearpatrInformacionSaludEmail;

    @JsonProperty("p_atriinformacionsaludcorreo")
    private Boolean proteccionDatosCcrearpatrIinformacionSaludCorreo;

    @JsonProperty("p_atrinformacionpublicidadsms")
    private Boolean proteccionDatosCcrearpatrInformacionPublicidadSMS;

    @JsonProperty("p_atrinformacionpublicidademai")
    private Boolean proteccionDatosCcrearpatrInformacionPublicidadEmai;

    @JsonProperty("p_atrinformacionpublicidadcorr")
    private Boolean proteccionDatosCcrearpatrInformacionPublicidadCorr;

    @JsonProperty("p_atrinformacionterceros")
    private Boolean proteccionDatosCcrearpatrInformacionTerceros;

    @JsonProperty("p_atrrol")
    private String proteccionDatosCcrearpatrRol;

    @JsonProperty("p_atrcodigo")
    private Long proteccionDatosCcrearpatrCodigo;

    public void checkArguments() throws NotNullArgumentException {
        checkProteccionDatosCcrearpagrProductoC();
        checkProteccionDatosCcrearpagrPersonaC();
        checkProteccionDatosCcrearpatrCodigo();
    }

    @JsonIgnore
    public ProductosOid getProteccionDatosCcrearpagrProductoC() {
        return this.proteccionDatosCcrearpagrProductoC;
    }
    
    public void setProteccionDatosCcrearpagrProductoC(ProductosOid proteccionDatosCcrearpagrProductoC) {
        this.proteccionDatosCcrearpagrProductoC = proteccionDatosCcrearpagrProductoC;
    }

    @JsonIgnore
    public Productos getProteccionDatosCcrearpagrProductoCInstance() {
        return this.proteccionDatosCcrearpagrProductoCInstance;
    }
    
    public void setProteccionDatosCcrearpagrProductoCInstance(Productos proteccionDatosCcrearpagrProductoC) {
        this.proteccionDatosCcrearpagrProductoCInstance = proteccionDatosCcrearpagrProductoC;
        this.proteccionDatosCcrearpagrProductoC = proteccionDatosCcrearpagrProductoC != null ? proteccionDatosCcrearpagrProductoC.getOid() : null;
    }

    private void checkProteccionDatosCcrearpagrProductoC() throws NotNullArgumentException {
        if(this.getProteccionDatosCcrearpagrProductoCInstance() == null || this.getProteccionDatosCcrearpagrProductoCInstance().isNull()) {
            throw new NotNullArgumentException(ProteccionDatosCConstants.SERV_ID_CREAR, ProteccionDatosCConstants.CLASS_ID, ProteccionDatosCConstants.ARG_ID_CREAR_PROTECCIONDATOSCCREARPAGRPRODUCTOC, ProteccionDatosCConstants.SERV_ALIAS_CREAR, ProteccionDatosCConstants.CLASS_ALIAS, ProteccionDatosCConstants.ARG_ALIAS_CREAR_PROTECCIONDATOSCCREARPAGRPRODUCTOC);
        }
    }

    @JsonIgnore
    public PersonaCOid getProteccionDatosCcrearpagrPersonaC() {
        return this.proteccionDatosCcrearpagrPersonaC;
    }
    
    public void setProteccionDatosCcrearpagrPersonaC(PersonaCOid proteccionDatosCcrearpagrPersonaC) {
        this.proteccionDatosCcrearpagrPersonaC = proteccionDatosCcrearpagrPersonaC;
    }

    @JsonIgnore
    public PersonaC getProteccionDatosCcrearpagrPersonaCInstance() {
        return this.proteccionDatosCcrearpagrPersonaCInstance;
    }
    
    public void setProteccionDatosCcrearpagrPersonaCInstance(PersonaC proteccionDatosCcrearpagrPersonaC) {
        this.proteccionDatosCcrearpagrPersonaCInstance = proteccionDatosCcrearpagrPersonaC;
        this.proteccionDatosCcrearpagrPersonaC = proteccionDatosCcrearpagrPersonaC != null ? proteccionDatosCcrearpagrPersonaC.getOid() : null;
    }

    private void checkProteccionDatosCcrearpagrPersonaC() throws NotNullArgumentException {
        if(this.getProteccionDatosCcrearpagrPersonaCInstance() == null || this.getProteccionDatosCcrearpagrPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(ProteccionDatosCConstants.SERV_ID_CREAR, ProteccionDatosCConstants.CLASS_ID, ProteccionDatosCConstants.ARG_ID_CREAR_PROTECCIONDATOSCCREARPAGRPERSONAC, ProteccionDatosCConstants.SERV_ALIAS_CREAR, ProteccionDatosCConstants.CLASS_ALIAS, ProteccionDatosCConstants.ARG_ALIAS_CREAR_PROTECCIONDATOSCCREARPAGRPERSONAC);
        }
    }

    @JsonIgnore
    public String getProteccionDatosCcrearpatrCodRol() {
        return this.proteccionDatosCcrearpatrCodRol;
    }
    
    public void setProteccionDatosCcrearpatrCodRol(String proteccionDatosCcrearpatrCodRol) {
        this.proteccionDatosCcrearpatrCodRol = proteccionDatosCcrearpatrCodRol;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCcrearpatrInformacionSaludSMS() {
        return this.proteccionDatosCcrearpatrInformacionSaludSMS;
    }
    
    public void setProteccionDatosCcrearpatrInformacionSaludSMS(Boolean proteccionDatosCcrearpatrInformacionSaludSMS) {
        this.proteccionDatosCcrearpatrInformacionSaludSMS = proteccionDatosCcrearpatrInformacionSaludSMS;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCcrearpatrInformacionSaludEmail() {
        return this.proteccionDatosCcrearpatrInformacionSaludEmail;
    }
    
    public void setProteccionDatosCcrearpatrInformacionSaludEmail(Boolean proteccionDatosCcrearpatrInformacionSaludEmail) {
        this.proteccionDatosCcrearpatrInformacionSaludEmail = proteccionDatosCcrearpatrInformacionSaludEmail;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCcrearpatrIinformacionSaludCorreo() {
        return this.proteccionDatosCcrearpatrIinformacionSaludCorreo;
    }
    
    public void setProteccionDatosCcrearpatrIinformacionSaludCorreo(Boolean proteccionDatosCcrearpatrIinformacionSaludCorreo) {
        this.proteccionDatosCcrearpatrIinformacionSaludCorreo = proteccionDatosCcrearpatrIinformacionSaludCorreo;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCcrearpatrInformacionPublicidadSMS() {
        return this.proteccionDatosCcrearpatrInformacionPublicidadSMS;
    }
    
    public void setProteccionDatosCcrearpatrInformacionPublicidadSMS(Boolean proteccionDatosCcrearpatrInformacionPublicidadSMS) {
        this.proteccionDatosCcrearpatrInformacionPublicidadSMS = proteccionDatosCcrearpatrInformacionPublicidadSMS;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCcrearpatrInformacionPublicidadEmai() {
        return this.proteccionDatosCcrearpatrInformacionPublicidadEmai;
    }
    
    public void setProteccionDatosCcrearpatrInformacionPublicidadEmai(Boolean proteccionDatosCcrearpatrInformacionPublicidadEmai) {
        this.proteccionDatosCcrearpatrInformacionPublicidadEmai = proteccionDatosCcrearpatrInformacionPublicidadEmai;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCcrearpatrInformacionPublicidadCorr() {
        return this.proteccionDatosCcrearpatrInformacionPublicidadCorr;
    }
    
    public void setProteccionDatosCcrearpatrInformacionPublicidadCorr(Boolean proteccionDatosCcrearpatrInformacionPublicidadCorr) {
        this.proteccionDatosCcrearpatrInformacionPublicidadCorr = proteccionDatosCcrearpatrInformacionPublicidadCorr;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCcrearpatrInformacionTerceros() {
        return this.proteccionDatosCcrearpatrInformacionTerceros;
    }
    
    public void setProteccionDatosCcrearpatrInformacionTerceros(Boolean proteccionDatosCcrearpatrInformacionTerceros) {
        this.proteccionDatosCcrearpatrInformacionTerceros = proteccionDatosCcrearpatrInformacionTerceros;
    }

    @JsonIgnore
    public String getProteccionDatosCcrearpatrRol() {
        return this.proteccionDatosCcrearpatrRol;
    }
    
    public void setProteccionDatosCcrearpatrRol(String proteccionDatosCcrearpatrRol) {
        this.proteccionDatosCcrearpatrRol = proteccionDatosCcrearpatrRol;
    }

    @JsonIgnore
    public Long getProteccionDatosCcrearpatrCodigo() {
        return this.proteccionDatosCcrearpatrCodigo;
    }
    
    public void setProteccionDatosCcrearpatrCodigo(Long proteccionDatosCcrearpatrCodigo) {
        this.proteccionDatosCcrearpatrCodigo = proteccionDatosCcrearpatrCodigo;
    }

    private void checkProteccionDatosCcrearpatrCodigo() throws NotNullArgumentException {
        if(this.getProteccionDatosCcrearpatrCodigo() == null) {
            throw new NotNullArgumentException(ProteccionDatosCConstants.SERV_ID_CREAR, ProteccionDatosCConstants.CLASS_ID, ProteccionDatosCConstants.ARG_ID_CREAR_PROTECCIONDATOSCCREARPATRCODIGO, ProteccionDatosCConstants.SERV_ALIAS_CREAR, ProteccionDatosCConstants.CLASS_ALIAS, ProteccionDatosCConstants.ARG_ALIAS_CREAR_PROTECCIONDATOSCCREARPATRCODIGO);
        }
    }
}
