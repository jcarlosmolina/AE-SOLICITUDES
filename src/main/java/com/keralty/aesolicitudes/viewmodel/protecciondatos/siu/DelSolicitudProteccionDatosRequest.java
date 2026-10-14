package com.keralty.aesolicitudes.viewmodel.protecciondatos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ProteccionDatosConstants;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class DelSolicitudProteccionDatosRequest {

    @JsonProperty("p_thisprotecciondatos_oid")
    private ProteccionDatosOid proteccionDatosDelSolicitudProteccionDatospthisProteccionDatos;
    
    @JsonIgnore
    private ProteccionDatos proteccionDatosDelSolicitudProteccionDatospthisProteccionDatosInstance;

    @JsonProperty("p_evcsolicitud_oid")
    private SolicitudOid proteccionDatosDelSolicitudProteccionDatospevcSolicitud;
    
    @JsonIgnore
    private Solicitud proteccionDatosDelSolicitudProteccionDatospevcSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkProteccionDatosDelSolicitudProteccionDatospthisProteccionDatos();
        checkProteccionDatosDelSolicitudProteccionDatospevcSolicitud();
    }

    @JsonIgnore
    public ProteccionDatosOid getProteccionDatosDelSolicitudProteccionDatospthisProteccionDatos() {
        return this.proteccionDatosDelSolicitudProteccionDatospthisProteccionDatos;
    }
    
    public void setProteccionDatosDelSolicitudProteccionDatospthisProteccionDatos(ProteccionDatosOid proteccionDatosDelSolicitudProteccionDatospthisProteccionDatos) {
        this.proteccionDatosDelSolicitudProteccionDatospthisProteccionDatos = proteccionDatosDelSolicitudProteccionDatospthisProteccionDatos;
    }

    @JsonIgnore
    public ProteccionDatos getProteccionDatosDelSolicitudProteccionDatospthisProteccionDatosInstance() {
        return this.proteccionDatosDelSolicitudProteccionDatospthisProteccionDatosInstance;
    }
    
    public void setProteccionDatosDelSolicitudProteccionDatospthisProteccionDatosInstance(ProteccionDatos proteccionDatosDelSolicitudProteccionDatospthisProteccionDatos) {
        this.proteccionDatosDelSolicitudProteccionDatospthisProteccionDatosInstance = proteccionDatosDelSolicitudProteccionDatospthisProteccionDatos;
        this.proteccionDatosDelSolicitudProteccionDatospthisProteccionDatos = proteccionDatosDelSolicitudProteccionDatospthisProteccionDatos != null ? proteccionDatosDelSolicitudProteccionDatospthisProteccionDatos.getOid() : null;
    }

    private void checkProteccionDatosDelSolicitudProteccionDatospthisProteccionDatos() throws NotNullArgumentException {
        if(this.getProteccionDatosDelSolicitudProteccionDatospthisProteccionDatosInstance() == null || this.getProteccionDatosDelSolicitudProteccionDatospthisProteccionDatosInstance().isNull()) {
            throw new NotNullArgumentException(ProteccionDatosConstants.SERV_ID_DELSOLICITUDPROTECCIONDATOS, ProteccionDatosConstants.CLASS_ID, ProteccionDatosConstants.ARG_ID_DELSOLICITUDPROTECCIONDATOS_PROTECCIONDATOSDELSOLICITUDPROTECCIONDATOSPTHISPROTECCIONDATOS, ProteccionDatosConstants.SERV_ALIAS_DELSOLICITUDPROTECCIONDATOS, ProteccionDatosConstants.CLASS_ALIAS, ProteccionDatosConstants.ARG_ALIAS_DELSOLICITUDPROTECCIONDATOS_PROTECCIONDATOSDELSOLICITUDPROTECCIONDATOSPTHISPROTECCIONDATOS);
        }
    }

    @JsonIgnore
    public SolicitudOid getProteccionDatosDelSolicitudProteccionDatospevcSolicitud() {
        return this.proteccionDatosDelSolicitudProteccionDatospevcSolicitud;
    }
    
    public void setProteccionDatosDelSolicitudProteccionDatospevcSolicitud(SolicitudOid proteccionDatosDelSolicitudProteccionDatospevcSolicitud) {
        this.proteccionDatosDelSolicitudProteccionDatospevcSolicitud = proteccionDatosDelSolicitudProteccionDatospevcSolicitud;
    }

    @JsonIgnore
    public Solicitud getProteccionDatosDelSolicitudProteccionDatospevcSolicitudInstance() {
        return this.proteccionDatosDelSolicitudProteccionDatospevcSolicitudInstance;
    }
    
    public void setProteccionDatosDelSolicitudProteccionDatospevcSolicitudInstance(Solicitud proteccionDatosDelSolicitudProteccionDatospevcSolicitud) {
        this.proteccionDatosDelSolicitudProteccionDatospevcSolicitudInstance = proteccionDatosDelSolicitudProteccionDatospevcSolicitud;
        this.proteccionDatosDelSolicitudProteccionDatospevcSolicitud = proteccionDatosDelSolicitudProteccionDatospevcSolicitud != null ? proteccionDatosDelSolicitudProteccionDatospevcSolicitud.getOid() : null;
    }

    private void checkProteccionDatosDelSolicitudProteccionDatospevcSolicitud() throws NotNullArgumentException {
        if(this.getProteccionDatosDelSolicitudProteccionDatospevcSolicitudInstance() == null || this.getProteccionDatosDelSolicitudProteccionDatospevcSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(ProteccionDatosConstants.SERV_ID_DELSOLICITUDPROTECCIONDATOS, ProteccionDatosConstants.CLASS_ID, ProteccionDatosConstants.ARG_ID_DELSOLICITUDPROTECCIONDATOS_PROTECCIONDATOSDELSOLICITUDPROTECCIONDATOSPEVCSOLICITUD, ProteccionDatosConstants.SERV_ALIAS_DELSOLICITUDPROTECCIONDATOS, ProteccionDatosConstants.CLASS_ALIAS, ProteccionDatosConstants.ARG_ALIAS_DELSOLICITUDPROTECCIONDATOS_PROTECCIONDATOSDELSOLICITUDPROTECCIONDATOSPEVCSOLICITUD);
        }
    }
}
