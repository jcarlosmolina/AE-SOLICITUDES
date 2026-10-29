package com.keralty.aesolicitudes.viewmodel.formapago.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.FormaPago;
public class AutoDS {

    @JsonProperty("codigo")
    private Long autoDSCodigo;

    @JsonProperty("descripcion")
    private String autoDSDescripcion;

    @JsonProperty("abrirurl")
    private Boolean autoDSAbrirURL;

    @JsonProperty("esvisible")
    private Boolean autoDSEsVisible;

    public AutoDS() {
    
    }

    public AutoDS(FormaPago instance) {
        if (instance != null) {
            this.autoDSCodigo = instance.getFormaPagoCodigo();
            this.autoDSDescripcion = instance.getFormaPagoDescripcion();
            this.autoDSAbrirURL = instance.getFormaPagoAbrirURL();
            this.autoDSEsVisible = instance.getFormaPagoEsVisible();
        }
    }

    @JsonIgnore
    public Long getAutoDSCodigo() {
        return this.autoDSCodigo;
    }
    
    public void setAutoDSCodigo(Long autoDSCodigo) {
        this.autoDSCodigo = autoDSCodigo;
    }

    @JsonIgnore
    public String getAutoDSDescripcion() {
        return this.autoDSDescripcion;
    }
    
    public void setAutoDSDescripcion(String autoDSDescripcion) {
        this.autoDSDescripcion = autoDSDescripcion;
    }

    @JsonIgnore
    public Boolean getAutoDSAbrirURL() {
        return this.autoDSAbrirURL;
    }
    
    public void setAutoDSAbrirURL(Boolean autoDSAbrirURL) {
        this.autoDSAbrirURL = autoDSAbrirURL;
    }

    @JsonIgnore
    public Boolean getAutoDSEsVisible() {
        return this.autoDSEsVisible;
    }
    
    public void setAutoDSEsVisible(Boolean autoDSEsVisible) {
        this.autoDSEsVisible = autoDSEsVisible;
    }
}
