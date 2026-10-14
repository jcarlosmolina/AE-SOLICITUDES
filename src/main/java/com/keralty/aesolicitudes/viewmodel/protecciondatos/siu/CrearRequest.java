package com.keralty.aesolicitudes.viewmodel.protecciondatos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class CrearRequest {

    @JsonProperty("p_agrproductot_oid")
    private ProductosOid proteccionDatoscrearpagrProductoT;
    
    @JsonIgnore
    private Productos proteccionDatoscrearpagrProductoTInstance;

    @JsonProperty("p_agrsolicitud_oid")
    private SolicitudOid proteccionDatoscrearpagrSolicitud;
    
    @JsonIgnore
    private Solicitud proteccionDatoscrearpagrSolicitudInstance;

    @JsonProperty("p_atrrol")
    private String proteccionDatoscrearpatrRol;

    @JsonProperty("p_atrsaludsms")
    private Boolean proteccionDatoscrearpatrSaludSMS;

    @JsonProperty("p_atrsaludemail")
    private Boolean proteccionDatoscrearpatrSaludEmail;

    @JsonProperty("p_atrsaludcorreo")
    private Boolean proteccionDatoscrearpatrSaludCorreo;

    @JsonProperty("p_atrpublicidadsms")
    private Boolean proteccionDatoscrearpatrPublicidadSMS;

    @JsonProperty("p_atrpublicidademail")
    private Boolean proteccionDatoscrearpatrPublicidadEmail;

    @JsonProperty("p_atrpublicidadcorreo")
    private Boolean proteccionDatoscrearpatrPublicidadCorreo;

    @JsonProperty("p_atrinfoterceros")
    private Boolean proteccionDatoscrearpatrInfoTerceros;

    @JsonIgnore
    public ProductosOid getProteccionDatoscrearpagrProductoT() {
        return this.proteccionDatoscrearpagrProductoT;
    }
    
    public void setProteccionDatoscrearpagrProductoT(ProductosOid proteccionDatoscrearpagrProductoT) {
        this.proteccionDatoscrearpagrProductoT = proteccionDatoscrearpagrProductoT;
    }

    @JsonIgnore
    public Productos getProteccionDatoscrearpagrProductoTInstance() {
        return this.proteccionDatoscrearpagrProductoTInstance;
    }
    
    public void setProteccionDatoscrearpagrProductoTInstance(Productos proteccionDatoscrearpagrProductoT) {
        this.proteccionDatoscrearpagrProductoTInstance = proteccionDatoscrearpagrProductoT;
        this.proteccionDatoscrearpagrProductoT = proteccionDatoscrearpagrProductoT != null ? proteccionDatoscrearpagrProductoT.getOid() : null;
    }

    @JsonIgnore
    public SolicitudOid getProteccionDatoscrearpagrSolicitud() {
        return this.proteccionDatoscrearpagrSolicitud;
    }
    
    public void setProteccionDatoscrearpagrSolicitud(SolicitudOid proteccionDatoscrearpagrSolicitud) {
        this.proteccionDatoscrearpagrSolicitud = proteccionDatoscrearpagrSolicitud;
    }

    @JsonIgnore
    public Solicitud getProteccionDatoscrearpagrSolicitudInstance() {
        return this.proteccionDatoscrearpagrSolicitudInstance;
    }
    
    public void setProteccionDatoscrearpagrSolicitudInstance(Solicitud proteccionDatoscrearpagrSolicitud) {
        this.proteccionDatoscrearpagrSolicitudInstance = proteccionDatoscrearpagrSolicitud;
        this.proteccionDatoscrearpagrSolicitud = proteccionDatoscrearpagrSolicitud != null ? proteccionDatoscrearpagrSolicitud.getOid() : null;
    }

    @JsonIgnore
    public String getProteccionDatoscrearpatrRol() {
        return this.proteccionDatoscrearpatrRol;
    }
    
    public void setProteccionDatoscrearpatrRol(String proteccionDatoscrearpatrRol) {
        this.proteccionDatoscrearpatrRol = proteccionDatoscrearpatrRol;
    }

    @JsonIgnore
    public Boolean getProteccionDatoscrearpatrSaludSMS() {
        return this.proteccionDatoscrearpatrSaludSMS;
    }
    
    public void setProteccionDatoscrearpatrSaludSMS(Boolean proteccionDatoscrearpatrSaludSMS) {
        this.proteccionDatoscrearpatrSaludSMS = proteccionDatoscrearpatrSaludSMS;
    }

    @JsonIgnore
    public Boolean getProteccionDatoscrearpatrSaludEmail() {
        return this.proteccionDatoscrearpatrSaludEmail;
    }
    
    public void setProteccionDatoscrearpatrSaludEmail(Boolean proteccionDatoscrearpatrSaludEmail) {
        this.proteccionDatoscrearpatrSaludEmail = proteccionDatoscrearpatrSaludEmail;
    }

    @JsonIgnore
    public Boolean getProteccionDatoscrearpatrSaludCorreo() {
        return this.proteccionDatoscrearpatrSaludCorreo;
    }
    
    public void setProteccionDatoscrearpatrSaludCorreo(Boolean proteccionDatoscrearpatrSaludCorreo) {
        this.proteccionDatoscrearpatrSaludCorreo = proteccionDatoscrearpatrSaludCorreo;
    }

    @JsonIgnore
    public Boolean getProteccionDatoscrearpatrPublicidadSMS() {
        return this.proteccionDatoscrearpatrPublicidadSMS;
    }
    
    public void setProteccionDatoscrearpatrPublicidadSMS(Boolean proteccionDatoscrearpatrPublicidadSMS) {
        this.proteccionDatoscrearpatrPublicidadSMS = proteccionDatoscrearpatrPublicidadSMS;
    }

    @JsonIgnore
    public Boolean getProteccionDatoscrearpatrPublicidadEmail() {
        return this.proteccionDatoscrearpatrPublicidadEmail;
    }
    
    public void setProteccionDatoscrearpatrPublicidadEmail(Boolean proteccionDatoscrearpatrPublicidadEmail) {
        this.proteccionDatoscrearpatrPublicidadEmail = proteccionDatoscrearpatrPublicidadEmail;
    }

    @JsonIgnore
    public Boolean getProteccionDatoscrearpatrPublicidadCorreo() {
        return this.proteccionDatoscrearpatrPublicidadCorreo;
    }
    
    public void setProteccionDatoscrearpatrPublicidadCorreo(Boolean proteccionDatoscrearpatrPublicidadCorreo) {
        this.proteccionDatoscrearpatrPublicidadCorreo = proteccionDatoscrearpatrPublicidadCorreo;
    }

    @JsonIgnore
    public Boolean getProteccionDatoscrearpatrInfoTerceros() {
        return this.proteccionDatoscrearpatrInfoTerceros;
    }
    
    public void setProteccionDatoscrearpatrInfoTerceros(Boolean proteccionDatoscrearpatrInfoTerceros) {
        this.proteccionDatoscrearpatrInfoTerceros = proteccionDatoscrearpatrInfoTerceros;
    }
}
