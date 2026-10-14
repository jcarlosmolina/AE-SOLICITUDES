package com.keralty.aesolicitudes.viewmodel.protecciondatos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ProteccionDatosConstants;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class InsSolicitudProteccionDatosRequest {

    @JsonProperty("p_thisprotecciondatos_oid")
    private ProteccionDatosOid proteccionDatosInsSolicitudProteccionDatospthisProteccionDatos;
    
    @JsonIgnore
    private ProteccionDatos proteccionDatosInsSolicitudProteccionDatospthisProteccionDatosInstance;

    @JsonProperty("p_evcsolicitud_oid")
    private SolicitudOid proteccionDatosInsSolicitudProteccionDatospevcSolicitud;
    
    @JsonIgnore
    private Solicitud proteccionDatosInsSolicitudProteccionDatospevcSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkProteccionDatosInsSolicitudProteccionDatospthisProteccionDatos();
        checkProteccionDatosInsSolicitudProteccionDatospevcSolicitud();
    }

    @JsonIgnore
    public ProteccionDatosOid getProteccionDatosInsSolicitudProteccionDatospthisProteccionDatos() {
        return this.proteccionDatosInsSolicitudProteccionDatospthisProteccionDatos;
    }
    
    public void setProteccionDatosInsSolicitudProteccionDatospthisProteccionDatos(ProteccionDatosOid proteccionDatosInsSolicitudProteccionDatospthisProteccionDatos) {
        this.proteccionDatosInsSolicitudProteccionDatospthisProteccionDatos = proteccionDatosInsSolicitudProteccionDatospthisProteccionDatos;
    }

    @JsonIgnore
    public ProteccionDatos getProteccionDatosInsSolicitudProteccionDatospthisProteccionDatosInstance() {
        return this.proteccionDatosInsSolicitudProteccionDatospthisProteccionDatosInstance;
    }
    
    public void setProteccionDatosInsSolicitudProteccionDatospthisProteccionDatosInstance(ProteccionDatos proteccionDatosInsSolicitudProteccionDatospthisProteccionDatos) {
        this.proteccionDatosInsSolicitudProteccionDatospthisProteccionDatosInstance = proteccionDatosInsSolicitudProteccionDatospthisProteccionDatos;
        this.proteccionDatosInsSolicitudProteccionDatospthisProteccionDatos = proteccionDatosInsSolicitudProteccionDatospthisProteccionDatos != null ? proteccionDatosInsSolicitudProteccionDatospthisProteccionDatos.getOid() : null;
    }

    private void checkProteccionDatosInsSolicitudProteccionDatospthisProteccionDatos() throws NotNullArgumentException {
        if(this.getProteccionDatosInsSolicitudProteccionDatospthisProteccionDatosInstance() == null || this.getProteccionDatosInsSolicitudProteccionDatospthisProteccionDatosInstance().isNull()) {
            throw new NotNullArgumentException(ProteccionDatosConstants.SERV_ID_INSSOLICITUDPROTECCIONDATOS, ProteccionDatosConstants.CLASS_ID, ProteccionDatosConstants.ARG_ID_INSSOLICITUDPROTECCIONDATOS_PROTECCIONDATOSINSSOLICITUDPROTECCIONDATOSPTHISPROTECCIONDATOS, ProteccionDatosConstants.SERV_ALIAS_INSSOLICITUDPROTECCIONDATOS, ProteccionDatosConstants.CLASS_ALIAS, ProteccionDatosConstants.ARG_ALIAS_INSSOLICITUDPROTECCIONDATOS_PROTECCIONDATOSINSSOLICITUDPROTECCIONDATOSPTHISPROTECCIONDATOS);
        }
    }

    @JsonIgnore
    public SolicitudOid getProteccionDatosInsSolicitudProteccionDatospevcSolicitud() {
        return this.proteccionDatosInsSolicitudProteccionDatospevcSolicitud;
    }
    
    public void setProteccionDatosInsSolicitudProteccionDatospevcSolicitud(SolicitudOid proteccionDatosInsSolicitudProteccionDatospevcSolicitud) {
        this.proteccionDatosInsSolicitudProteccionDatospevcSolicitud = proteccionDatosInsSolicitudProteccionDatospevcSolicitud;
    }

    @JsonIgnore
    public Solicitud getProteccionDatosInsSolicitudProteccionDatospevcSolicitudInstance() {
        return this.proteccionDatosInsSolicitudProteccionDatospevcSolicitudInstance;
    }
    
    public void setProteccionDatosInsSolicitudProteccionDatospevcSolicitudInstance(Solicitud proteccionDatosInsSolicitudProteccionDatospevcSolicitud) {
        this.proteccionDatosInsSolicitudProteccionDatospevcSolicitudInstance = proteccionDatosInsSolicitudProteccionDatospevcSolicitud;
        this.proteccionDatosInsSolicitudProteccionDatospevcSolicitud = proteccionDatosInsSolicitudProteccionDatospevcSolicitud != null ? proteccionDatosInsSolicitudProteccionDatospevcSolicitud.getOid() : null;
    }

    private void checkProteccionDatosInsSolicitudProteccionDatospevcSolicitud() throws NotNullArgumentException {
        if(this.getProteccionDatosInsSolicitudProteccionDatospevcSolicitudInstance() == null || this.getProteccionDatosInsSolicitudProteccionDatospevcSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(ProteccionDatosConstants.SERV_ID_INSSOLICITUDPROTECCIONDATOS, ProteccionDatosConstants.CLASS_ID, ProteccionDatosConstants.ARG_ID_INSSOLICITUDPROTECCIONDATOS_PROTECCIONDATOSINSSOLICITUDPROTECCIONDATOSPEVCSOLICITUD, ProteccionDatosConstants.SERV_ALIAS_INSSOLICITUDPROTECCIONDATOS, ProteccionDatosConstants.CLASS_ALIAS, ProteccionDatosConstants.ARG_ALIAS_INSSOLICITUDPROTECCIONDATOS_PROTECCIONDATOSINSSOLICITUDPROTECCIONDATOSPEVCSOLICITUD);
        }
    }
}
