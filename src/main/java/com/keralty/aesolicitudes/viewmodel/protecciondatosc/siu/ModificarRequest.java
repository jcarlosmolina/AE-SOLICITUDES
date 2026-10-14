package com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ProteccionDatosCConstants;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosCOid;
import com.keralty.aesolicitudes.persistence.ProteccionDatosC;

public class ModificarRequest {

    @JsonProperty("p_thisprotecciondatosc_oid")
    private ProteccionDatosCOid proteccionDatosCmodificarpthisProteccionDatosC;
    
    @JsonIgnore
    private ProteccionDatosC proteccionDatosCmodificarpthisProteccionDatosCInstance;

    @JsonProperty("p_codrol")
    private String proteccionDatosCmodificarpCodRol;

    @JsonProperty("p_informacionsaludsms")
    private Boolean proteccionDatosCmodificarpInformacionSaludSMS;

    @JsonProperty("p_informacionsaludemail")
    private Boolean proteccionDatosCmodificarpInformacionSaludEmail;

    @JsonProperty("p_iinformacionsaludcorreo")
    private Boolean proteccionDatosCmodificarpIinformacionSaludCorreo;

    @JsonProperty("p_informacionpublicidadsms")
    private Boolean proteccionDatosCmodificarpInformacionPublicidadSMS;

    @JsonProperty("p_informacionpublicidademail")
    private Boolean proteccionDatosCmodificarpInformacionPublicidadEmail;

    @JsonProperty("p_informacionpublicidadcorreo")
    private Boolean proteccionDatosCmodificarpInformacionPublicidadCorreo;

    @JsonProperty("p_informacionterceros")
    private Boolean proteccionDatosCmodificarpInformacionTerceros;

    @JsonProperty("p_rol")
    private String proteccionDatosCmodificarpRol;

    public void checkArguments() throws NotNullArgumentException {
        checkProteccionDatosCmodificarpthisProteccionDatosC();
    }

    @JsonIgnore
    public ProteccionDatosCOid getProteccionDatosCmodificarpthisProteccionDatosC() {
        return this.proteccionDatosCmodificarpthisProteccionDatosC;
    }
    
    public void setProteccionDatosCmodificarpthisProteccionDatosC(ProteccionDatosCOid proteccionDatosCmodificarpthisProteccionDatosC) {
        this.proteccionDatosCmodificarpthisProteccionDatosC = proteccionDatosCmodificarpthisProteccionDatosC;
    }

    @JsonIgnore
    public ProteccionDatosC getProteccionDatosCmodificarpthisProteccionDatosCInstance() {
        return this.proteccionDatosCmodificarpthisProteccionDatosCInstance;
    }
    
    public void setProteccionDatosCmodificarpthisProteccionDatosCInstance(ProteccionDatosC proteccionDatosCmodificarpthisProteccionDatosC) {
        this.proteccionDatosCmodificarpthisProteccionDatosCInstance = proteccionDatosCmodificarpthisProteccionDatosC;
        this.proteccionDatosCmodificarpthisProteccionDatosC = proteccionDatosCmodificarpthisProteccionDatosC != null ? proteccionDatosCmodificarpthisProteccionDatosC.getOid() : null;
    }

    private void checkProteccionDatosCmodificarpthisProteccionDatosC() throws NotNullArgumentException {
        if(this.getProteccionDatosCmodificarpthisProteccionDatosCInstance() == null || this.getProteccionDatosCmodificarpthisProteccionDatosCInstance().isNull()) {
            throw new NotNullArgumentException(ProteccionDatosCConstants.SERV_ID_MODIFICAR, ProteccionDatosCConstants.CLASS_ID, ProteccionDatosCConstants.ARG_ID_MODIFICAR_PROTECCIONDATOSCMODIFICARPTHISPROTECCIONDATOSC, ProteccionDatosCConstants.SERV_ALIAS_MODIFICAR, ProteccionDatosCConstants.CLASS_ALIAS, ProteccionDatosCConstants.ARG_ALIAS_MODIFICAR_PROTECCIONDATOSCMODIFICARPTHISPROTECCIONDATOSC);
        }
    }

    @JsonIgnore
    public String getProteccionDatosCmodificarpCodRol() {
        return this.proteccionDatosCmodificarpCodRol;
    }
    
    public void setProteccionDatosCmodificarpCodRol(String proteccionDatosCmodificarpCodRol) {
        this.proteccionDatosCmodificarpCodRol = proteccionDatosCmodificarpCodRol;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCmodificarpInformacionSaludSMS() {
        return this.proteccionDatosCmodificarpInformacionSaludSMS;
    }
    
    public void setProteccionDatosCmodificarpInformacionSaludSMS(Boolean proteccionDatosCmodificarpInformacionSaludSMS) {
        this.proteccionDatosCmodificarpInformacionSaludSMS = proteccionDatosCmodificarpInformacionSaludSMS;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCmodificarpInformacionSaludEmail() {
        return this.proteccionDatosCmodificarpInformacionSaludEmail;
    }
    
    public void setProteccionDatosCmodificarpInformacionSaludEmail(Boolean proteccionDatosCmodificarpInformacionSaludEmail) {
        this.proteccionDatosCmodificarpInformacionSaludEmail = proteccionDatosCmodificarpInformacionSaludEmail;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCmodificarpIinformacionSaludCorreo() {
        return this.proteccionDatosCmodificarpIinformacionSaludCorreo;
    }
    
    public void setProteccionDatosCmodificarpIinformacionSaludCorreo(Boolean proteccionDatosCmodificarpIinformacionSaludCorreo) {
        this.proteccionDatosCmodificarpIinformacionSaludCorreo = proteccionDatosCmodificarpIinformacionSaludCorreo;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCmodificarpInformacionPublicidadSMS() {
        return this.proteccionDatosCmodificarpInformacionPublicidadSMS;
    }
    
    public void setProteccionDatosCmodificarpInformacionPublicidadSMS(Boolean proteccionDatosCmodificarpInformacionPublicidadSMS) {
        this.proteccionDatosCmodificarpInformacionPublicidadSMS = proteccionDatosCmodificarpInformacionPublicidadSMS;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCmodificarpInformacionPublicidadEmail() {
        return this.proteccionDatosCmodificarpInformacionPublicidadEmail;
    }
    
    public void setProteccionDatosCmodificarpInformacionPublicidadEmail(Boolean proteccionDatosCmodificarpInformacionPublicidadEmail) {
        this.proteccionDatosCmodificarpInformacionPublicidadEmail = proteccionDatosCmodificarpInformacionPublicidadEmail;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCmodificarpInformacionPublicidadCorreo() {
        return this.proteccionDatosCmodificarpInformacionPublicidadCorreo;
    }
    
    public void setProteccionDatosCmodificarpInformacionPublicidadCorreo(Boolean proteccionDatosCmodificarpInformacionPublicidadCorreo) {
        this.proteccionDatosCmodificarpInformacionPublicidadCorreo = proteccionDatosCmodificarpInformacionPublicidadCorreo;
    }

    @JsonIgnore
    public Boolean getProteccionDatosCmodificarpInformacionTerceros() {
        return this.proteccionDatosCmodificarpInformacionTerceros;
    }
    
    public void setProteccionDatosCmodificarpInformacionTerceros(Boolean proteccionDatosCmodificarpInformacionTerceros) {
        this.proteccionDatosCmodificarpInformacionTerceros = proteccionDatosCmodificarpInformacionTerceros;
    }

    @JsonIgnore
    public String getProteccionDatosCmodificarpRol() {
        return this.proteccionDatosCmodificarpRol;
    }
    
    public void setProteccionDatosCmodificarpRol(String proteccionDatosCmodificarpRol) {
        this.proteccionDatosCmodificarpRol = proteccionDatosCmodificarpRol;
    }
}
