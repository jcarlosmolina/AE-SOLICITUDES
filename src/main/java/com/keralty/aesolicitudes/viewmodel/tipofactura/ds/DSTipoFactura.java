package com.keralty.aesolicitudes.viewmodel.tipofactura.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.TipoFactura;
public class DSTipoFactura {

    @JsonProperty("codigo")
    private String dSTipoFacturaCodigo;

    @JsonProperty("descripcion")
    private String dSTipoFacturaDescripcion;

    @JsonProperty("esemail")
    private Boolean dSTipoFacturaEsEmail;

    @JsonProperty("escelular")
    private Boolean dSTipoFacturaEsCelular;

    @JsonProperty("activo")
    private Boolean dSTipoFacturaActivo;

    public DSTipoFactura() {
    
    }

    public DSTipoFactura(TipoFactura instance) {
        if (instance != null) {
            this.dSTipoFacturaCodigo = instance.getTipoFacturaCodigo();
            this.dSTipoFacturaDescripcion = instance.getTipoFacturaDescripcion();
            this.dSTipoFacturaEsEmail = instance.getTipoFacturaEsEmail();
            this.dSTipoFacturaEsCelular = instance.getTipoFacturaEsCelular();
            this.dSTipoFacturaActivo = instance.getTipoFacturaActivo();
        }
    }

    @JsonIgnore
    public String getDSTipoFacturaCodigo() {
        return this.dSTipoFacturaCodigo;
    }
    
    public void setDSTipoFacturaCodigo(String dSTipoFacturaCodigo) {
        this.dSTipoFacturaCodigo = dSTipoFacturaCodigo;
    }

    @JsonIgnore
    public String getDSTipoFacturaDescripcion() {
        return this.dSTipoFacturaDescripcion;
    }
    
    public void setDSTipoFacturaDescripcion(String dSTipoFacturaDescripcion) {
        this.dSTipoFacturaDescripcion = dSTipoFacturaDescripcion;
    }

    @JsonIgnore
    public Boolean getDSTipoFacturaEsEmail() {
        return this.dSTipoFacturaEsEmail;
    }
    
    public void setDSTipoFacturaEsEmail(Boolean dSTipoFacturaEsEmail) {
        this.dSTipoFacturaEsEmail = dSTipoFacturaEsEmail;
    }

    @JsonIgnore
    public Boolean getDSTipoFacturaEsCelular() {
        return this.dSTipoFacturaEsCelular;
    }
    
    public void setDSTipoFacturaEsCelular(Boolean dSTipoFacturaEsCelular) {
        this.dSTipoFacturaEsCelular = dSTipoFacturaEsCelular;
    }

    @JsonIgnore
    public Boolean getDSTipoFacturaActivo() {
        return this.dSTipoFacturaActivo;
    }
    
    public void setDSTipoFacturaActivo(Boolean dSTipoFacturaActivo) {
        this.dSTipoFacturaActivo = dSTipoFacturaActivo;
    }
}
