package com.keralty.aesolicitudes.viewmodel.protecciondatos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ProteccionDatosConstants;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;

public class ModificarRequest {

    @JsonProperty("p_thisprotecciondatos_oid")
    private ProteccionDatosOid proteccionDatosmodificarpthisProteccionDatos;
    
    @JsonIgnore
    private ProteccionDatos proteccionDatosmodificarpthisProteccionDatosInstance;

    @JsonProperty("p_rol")
    private String proteccionDatosmodificarpRol;

    @JsonProperty("p_saludsms")
    private Boolean proteccionDatosmodificarpSaludSMS;

    @JsonProperty("p_saludemail")
    private Boolean proteccionDatosmodificarpSaludEmail;

    @JsonProperty("p_saludcorreo")
    private Boolean proteccionDatosmodificarpSaludCorreo;

    @JsonProperty("p_publicidadsms")
    private Boolean proteccionDatosmodificarpPublicidadSMS;

    @JsonProperty("p_publicidademail")
    private Boolean proteccionDatosmodificarpPublicidadEmail;

    @JsonProperty("p_publicidadcorreo")
    private Boolean proteccionDatosmodificarpPublicidadCorreo;

    @JsonProperty("p_infoterceros")
    private Boolean proteccionDatosmodificarpInfoTerceros;

    public void checkArguments() throws NotNullArgumentException {
        checkProteccionDatosmodificarpthisProteccionDatos();
    }

    @JsonIgnore
    public ProteccionDatosOid getProteccionDatosmodificarpthisProteccionDatos() {
        return this.proteccionDatosmodificarpthisProteccionDatos;
    }
    
    public void setProteccionDatosmodificarpthisProteccionDatos(ProteccionDatosOid proteccionDatosmodificarpthisProteccionDatos) {
        this.proteccionDatosmodificarpthisProteccionDatos = proteccionDatosmodificarpthisProteccionDatos;
    }

    @JsonIgnore
    public ProteccionDatos getProteccionDatosmodificarpthisProteccionDatosInstance() {
        return this.proteccionDatosmodificarpthisProteccionDatosInstance;
    }
    
    public void setProteccionDatosmodificarpthisProteccionDatosInstance(ProteccionDatos proteccionDatosmodificarpthisProteccionDatos) {
        this.proteccionDatosmodificarpthisProteccionDatosInstance = proteccionDatosmodificarpthisProteccionDatos;
        this.proteccionDatosmodificarpthisProteccionDatos = proteccionDatosmodificarpthisProteccionDatos != null ? proteccionDatosmodificarpthisProteccionDatos.getOid() : null;
    }

    private void checkProteccionDatosmodificarpthisProteccionDatos() throws NotNullArgumentException {
        if(this.getProteccionDatosmodificarpthisProteccionDatosInstance() == null || this.getProteccionDatosmodificarpthisProteccionDatosInstance().isNull()) {
            throw new NotNullArgumentException(ProteccionDatosConstants.SERV_ID_MODIFICAR, ProteccionDatosConstants.CLASS_ID, ProteccionDatosConstants.ARG_ID_MODIFICAR_PROTECCIONDATOSMODIFICARPTHISPROTECCIONDATOS, ProteccionDatosConstants.SERV_ALIAS_MODIFICAR, ProteccionDatosConstants.CLASS_ALIAS, ProteccionDatosConstants.ARG_ALIAS_MODIFICAR_PROTECCIONDATOSMODIFICARPTHISPROTECCIONDATOS);
        }
    }

    @JsonIgnore
    public String getProteccionDatosmodificarpRol() {
        return this.proteccionDatosmodificarpRol;
    }
    
    public void setProteccionDatosmodificarpRol(String proteccionDatosmodificarpRol) {
        this.proteccionDatosmodificarpRol = proteccionDatosmodificarpRol;
    }

    @JsonIgnore
    public Boolean getProteccionDatosmodificarpSaludSMS() {
        return this.proteccionDatosmodificarpSaludSMS;
    }
    
    public void setProteccionDatosmodificarpSaludSMS(Boolean proteccionDatosmodificarpSaludSMS) {
        this.proteccionDatosmodificarpSaludSMS = proteccionDatosmodificarpSaludSMS;
    }

    @JsonIgnore
    public Boolean getProteccionDatosmodificarpSaludEmail() {
        return this.proteccionDatosmodificarpSaludEmail;
    }
    
    public void setProteccionDatosmodificarpSaludEmail(Boolean proteccionDatosmodificarpSaludEmail) {
        this.proteccionDatosmodificarpSaludEmail = proteccionDatosmodificarpSaludEmail;
    }

    @JsonIgnore
    public Boolean getProteccionDatosmodificarpSaludCorreo() {
        return this.proteccionDatosmodificarpSaludCorreo;
    }
    
    public void setProteccionDatosmodificarpSaludCorreo(Boolean proteccionDatosmodificarpSaludCorreo) {
        this.proteccionDatosmodificarpSaludCorreo = proteccionDatosmodificarpSaludCorreo;
    }

    @JsonIgnore
    public Boolean getProteccionDatosmodificarpPublicidadSMS() {
        return this.proteccionDatosmodificarpPublicidadSMS;
    }
    
    public void setProteccionDatosmodificarpPublicidadSMS(Boolean proteccionDatosmodificarpPublicidadSMS) {
        this.proteccionDatosmodificarpPublicidadSMS = proteccionDatosmodificarpPublicidadSMS;
    }

    @JsonIgnore
    public Boolean getProteccionDatosmodificarpPublicidadEmail() {
        return this.proteccionDatosmodificarpPublicidadEmail;
    }
    
    public void setProteccionDatosmodificarpPublicidadEmail(Boolean proteccionDatosmodificarpPublicidadEmail) {
        this.proteccionDatosmodificarpPublicidadEmail = proteccionDatosmodificarpPublicidadEmail;
    }

    @JsonIgnore
    public Boolean getProteccionDatosmodificarpPublicidadCorreo() {
        return this.proteccionDatosmodificarpPublicidadCorreo;
    }
    
    public void setProteccionDatosmodificarpPublicidadCorreo(Boolean proteccionDatosmodificarpPublicidadCorreo) {
        this.proteccionDatosmodificarpPublicidadCorreo = proteccionDatosmodificarpPublicidadCorreo;
    }

    @JsonIgnore
    public Boolean getProteccionDatosmodificarpInfoTerceros() {
        return this.proteccionDatosmodificarpInfoTerceros;
    }
    
    public void setProteccionDatosmodificarpInfoTerceros(Boolean proteccionDatosmodificarpInfoTerceros) {
        this.proteccionDatosmodificarpInfoTerceros = proteccionDatosmodificarpInfoTerceros;
    }
}
