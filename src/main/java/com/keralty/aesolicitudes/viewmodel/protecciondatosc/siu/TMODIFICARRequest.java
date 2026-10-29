package com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ProteccionDatosCConstants;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosCOid;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.ProteccionDatosC;

public class TMODIFICARRequest {

    @JsonProperty("p_thisprotecciondatosc_oid")
    private ProteccionDatosCOid proteccionDatosCTMODIFICARpthisProteccionDatosC;
    
    @JsonIgnore
    private ProteccionDatosC proteccionDatosCTMODIFICARpthisProteccionDatosCInstance;

    @JsonProperty("pt_p_codrol")
    private String proteccionDatosCTMODIFICARptpCodRol;

    @JsonProperty("pt_p_informacionsaludsms")
    private Boolean proteccionDatosCTMODIFICARptpInformacionSaludSMS;

    @JsonProperty("pt_p_informacionsaludemail")
    private Boolean proteccionDatosCTMODIFICARptpInformacionSaludEmail;

    @JsonProperty("pt_p_iinformacionsaludcorreo")
    private Boolean proteccionDatosCTMODIFICARptpIinformacionSaludCorreo;

    @JsonProperty("pt_p_informacionpublicidadsms")
    private Boolean proteccionDatosCTMODIFICARptpInformacionPublicidadSMS;

    @JsonProperty("pt_p_informacionpublicidademai")
    private Boolean proteccionDatosCTMODIFICARptpInformacionPublicidadEmai;

    @JsonProperty("pt_p_informacionpublicidadcorr")
    private Boolean proteccionDatosCTMODIFICARptpInformacionPublicidadCorr;

    @JsonProperty("pt_p_informacionterceros")
    private Boolean proteccionDatosCTMODIFICARptpInformacionTerceros;

    @JsonProperty("pt_p_evcproductoc_oid")
    private ProductosOid proteccionDatosCTMODIFICARptpevcProductoC;
    
    @JsonIgnore
    private Productos proteccionDatosCTMODIFICARptpevcProductoCInstance;

    @JsonProperty("pt_p_rol")
    private String proteccionDatosCTMODIFICARptpRol;

    public void checkArguments() throws NotNullArgumentException {
        checkProteccionDatosCTMODIFICARpthisProteccionDatosC();
    }

    @JsonIgnore
    public ProteccionDatosCOid getProteccionDatosCTMODIFICARpthisProteccionDatosC() {
        return this.proteccionDatosCTMODIFICARpthisProteccionDatosC;
    }
    
    public void setProteccionDatosCTMODIFICARpthisProteccionDatosC(ProteccionDatosCOid proteccionDatosCTMODIFICARpthisProteccionDatosC) {
        this.proteccionDatosCTMODIFICARpthisProteccionDatosC = proteccionDatosCTMODIFICARpthisProteccionDatosC;
    }

    @JsonIgnore
    public ProteccionDatosC getProteccionDatosCTMODIFICARpthisProteccionDatosCInstance() {
        return this.proteccionDatosCTMODIFICARpthisProteccionDatosCInstance;
    }
    
    public void setProteccionDatosCTMODIFICARpthisProteccionDatosCInstance(ProteccionDatosC proteccionDatosCTMODIFICARpthisProteccionDatosC) {
        this.proteccionDatosCTMODIFICARpthisProteccionDatosCInstance = proteccionDatosCTMODIFICARpthisProteccionDatosC;
        this.proteccionDatosCTMODIFICARpthisProteccionDatosC = proteccionDatosCTMODIFICARpthisProteccionDatosC != null ? proteccionDatosCTMODIFICARpthisProteccionDatosC.getOid() : null;
    }

    private void checkProteccionDatosCTMODIFICARpthisProteccionDatosC() throws NotNullArgumentException {
        if(this.getProteccionDatosCTMODIFICARpthisProteccionDatosCInstance() == null || this.getProteccionDatosCTMODIFICARpthisProteccionDatosCInstance().isNull()) {
            throw new NotNullArgumentException(ProteccionDatosCConstants.SERV_ID_TMODIFICAR, ProteccionDatosCConstants.CLASS_ID, ProteccionDatosCConstants.ARG_ID_TMODIFICAR_PROTECCIONDATOSCTMODIFICARPTHISPROTECCIONDATOSC, ProteccionDatosCConstants.SERV_ALIAS_TMODIFICAR, ProteccionDatosCConstants.CLASS_ALIAS, ProteccionDatosCConstants.ARG_ALIAS_TMODIFICAR_PROTECCIONDATOSCTMODIFICARPTHISPROTECCIONDATOSC);
        }
    }

    @JsonIgnore
    public String getProteccionDatosCTMODIFICARptpCodRol() {
        return this.proteccionDatosCTMODIFICARptpCodRol;
    }
    
    public void setProteccionDatosCTMODIFICARptpCodRol(String proteccionDatosCTMODIFICARptpCodRol) {
        this.proteccionDatosCTMODIFICARptpCodRol = proteccionDatosCTMODIFICARptpCodRol;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCTMODIFICARptpInformacionSaludSMS() {
        return this.proteccionDatosCTMODIFICARptpInformacionSaludSMS;
    }
    
    public void setProteccionDatosCTMODIFICARptpInformacionSaludSMS(Boolean proteccionDatosCTMODIFICARptpInformacionSaludSMS) {
        this.proteccionDatosCTMODIFICARptpInformacionSaludSMS = proteccionDatosCTMODIFICARptpInformacionSaludSMS;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCTMODIFICARptpInformacionSaludEmail() {
        return this.proteccionDatosCTMODIFICARptpInformacionSaludEmail;
    }
    
    public void setProteccionDatosCTMODIFICARptpInformacionSaludEmail(Boolean proteccionDatosCTMODIFICARptpInformacionSaludEmail) {
        this.proteccionDatosCTMODIFICARptpInformacionSaludEmail = proteccionDatosCTMODIFICARptpInformacionSaludEmail;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCTMODIFICARptpIinformacionSaludCorreo() {
        return this.proteccionDatosCTMODIFICARptpIinformacionSaludCorreo;
    }
    
    public void setProteccionDatosCTMODIFICARptpIinformacionSaludCorreo(Boolean proteccionDatosCTMODIFICARptpIinformacionSaludCorreo) {
        this.proteccionDatosCTMODIFICARptpIinformacionSaludCorreo = proteccionDatosCTMODIFICARptpIinformacionSaludCorreo;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCTMODIFICARptpInformacionPublicidadSMS() {
        return this.proteccionDatosCTMODIFICARptpInformacionPublicidadSMS;
    }
    
    public void setProteccionDatosCTMODIFICARptpInformacionPublicidadSMS(Boolean proteccionDatosCTMODIFICARptpInformacionPublicidadSMS) {
        this.proteccionDatosCTMODIFICARptpInformacionPublicidadSMS = proteccionDatosCTMODIFICARptpInformacionPublicidadSMS;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCTMODIFICARptpInformacionPublicidadEmai() {
        return this.proteccionDatosCTMODIFICARptpInformacionPublicidadEmai;
    }
    
    public void setProteccionDatosCTMODIFICARptpInformacionPublicidadEmai(Boolean proteccionDatosCTMODIFICARptpInformacionPublicidadEmai) {
        this.proteccionDatosCTMODIFICARptpInformacionPublicidadEmai = proteccionDatosCTMODIFICARptpInformacionPublicidadEmai;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCTMODIFICARptpInformacionPublicidadCorr() {
        return this.proteccionDatosCTMODIFICARptpInformacionPublicidadCorr;
    }
    
    public void setProteccionDatosCTMODIFICARptpInformacionPublicidadCorr(Boolean proteccionDatosCTMODIFICARptpInformacionPublicidadCorr) {
        this.proteccionDatosCTMODIFICARptpInformacionPublicidadCorr = proteccionDatosCTMODIFICARptpInformacionPublicidadCorr;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCTMODIFICARptpInformacionTerceros() {
        return this.proteccionDatosCTMODIFICARptpInformacionTerceros;
    }
    
    public void setProteccionDatosCTMODIFICARptpInformacionTerceros(Boolean proteccionDatosCTMODIFICARptpInformacionTerceros) {
        this.proteccionDatosCTMODIFICARptpInformacionTerceros = proteccionDatosCTMODIFICARptpInformacionTerceros;
    }

    @JsonIgnore
    public ProductosOid getProteccionDatosCTMODIFICARptpevcProductoC() {
        return this.proteccionDatosCTMODIFICARptpevcProductoC;
    }
    
    public void setProteccionDatosCTMODIFICARptpevcProductoC(ProductosOid proteccionDatosCTMODIFICARptpevcProductoC) {
        this.proteccionDatosCTMODIFICARptpevcProductoC = proteccionDatosCTMODIFICARptpevcProductoC;
    }

    @JsonIgnore
    public Productos getProteccionDatosCTMODIFICARptpevcProductoCInstance() {
        return this.proteccionDatosCTMODIFICARptpevcProductoCInstance;
    }
    
    public void setProteccionDatosCTMODIFICARptpevcProductoCInstance(Productos proteccionDatosCTMODIFICARptpevcProductoC) {
        this.proteccionDatosCTMODIFICARptpevcProductoCInstance = proteccionDatosCTMODIFICARptpevcProductoC;
        this.proteccionDatosCTMODIFICARptpevcProductoC = proteccionDatosCTMODIFICARptpevcProductoC != null ? proteccionDatosCTMODIFICARptpevcProductoC.getOid() : null;
    }

    @JsonIgnore
    public String getProteccionDatosCTMODIFICARptpRol() {
        return this.proteccionDatosCTMODIFICARptpRol;
    }
    
    public void setProteccionDatosCTMODIFICARptpRol(String proteccionDatosCTMODIFICARptpRol) {
        this.proteccionDatosCTMODIFICARptpRol = proteccionDatosCTMODIFICARptpRol;
    }
}
