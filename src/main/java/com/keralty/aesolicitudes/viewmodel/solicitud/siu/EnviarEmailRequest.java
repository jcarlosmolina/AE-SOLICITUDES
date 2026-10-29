package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class EnviarEmailRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudenviarEmailpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudenviarEmailpthisSolicitudInstance;

    @JsonProperty("pedestinatario")
    private String solicitudenviarEmailpeDestinatario;

    @JsonProperty("peemailconfirmacion")
    private String solicitudenviarEmailpeEmailConfirmacion;

    @JsonProperty("peasunto")
    private String solicitudenviarEmailpeAsunto;

    @JsonProperty("pecuerpo")
    private String solicitudenviarEmailpeCuerpo;

    @JsonProperty("penombreadjunto")
    private String solicitudenviarEmailpeNombreAdjunto;

    @JsonProperty("peadjunto")
    private byte[] solicitudenviarEmailpeAdjunto;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudenviarEmailpthisSolicitud();
        checkSolicitudenviarEmailpeDestinatario();
        checkSolicitudenviarEmailpeAsunto();
        checkSolicitudenviarEmailpeCuerpo();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudenviarEmailpthisSolicitud() {
        return this.solicitudenviarEmailpthisSolicitud;
    }
    
    public void setSolicitudenviarEmailpthisSolicitud(SolicitudOid solicitudenviarEmailpthisSolicitud) {
        this.solicitudenviarEmailpthisSolicitud = solicitudenviarEmailpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudenviarEmailpthisSolicitudInstance() {
        return this.solicitudenviarEmailpthisSolicitudInstance;
    }
    
    public void setSolicitudenviarEmailpthisSolicitudInstance(Solicitud solicitudenviarEmailpthisSolicitud) {
        this.solicitudenviarEmailpthisSolicitudInstance = solicitudenviarEmailpthisSolicitud;
        this.solicitudenviarEmailpthisSolicitud = solicitudenviarEmailpthisSolicitud != null ? solicitudenviarEmailpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudenviarEmailpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudenviarEmailpthisSolicitudInstance() == null || this.getSolicitudenviarEmailpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_ENVIAREMAIL, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_ENVIAREMAIL_SOLICITUDENVIAREMAILPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_ENVIAREMAIL, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_ENVIAREMAIL_SOLICITUDENVIAREMAILPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudenviarEmailpeDestinatario() {
        return this.solicitudenviarEmailpeDestinatario;
    }
    
    public void setSolicitudenviarEmailpeDestinatario(String solicitudenviarEmailpeDestinatario) {
        this.solicitudenviarEmailpeDestinatario = solicitudenviarEmailpeDestinatario;
    }

    private void checkSolicitudenviarEmailpeDestinatario() throws NotNullArgumentException {
        if(this.getSolicitudenviarEmailpeDestinatario() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_ENVIAREMAIL, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_ENVIAREMAIL_SOLICITUDENVIAREMAILPEDESTINATARIO, SolicitudConstants.SERV_ALIAS_ENVIAREMAIL, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_ENVIAREMAIL_SOLICITUDENVIAREMAILPEDESTINATARIO);
        }
    }

    @JsonIgnore
    public String getSolicitudenviarEmailpeEmailConfirmacion() {
        return this.solicitudenviarEmailpeEmailConfirmacion;
    }
    
    public void setSolicitudenviarEmailpeEmailConfirmacion(String solicitudenviarEmailpeEmailConfirmacion) {
        this.solicitudenviarEmailpeEmailConfirmacion = solicitudenviarEmailpeEmailConfirmacion;
    }

    @JsonIgnore
    public String getSolicitudenviarEmailpeAsunto() {
        return this.solicitudenviarEmailpeAsunto;
    }
    
    public void setSolicitudenviarEmailpeAsunto(String solicitudenviarEmailpeAsunto) {
        this.solicitudenviarEmailpeAsunto = solicitudenviarEmailpeAsunto;
    }

    private void checkSolicitudenviarEmailpeAsunto() throws NotNullArgumentException {
        if(this.getSolicitudenviarEmailpeAsunto() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_ENVIAREMAIL, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_ENVIAREMAIL_SOLICITUDENVIAREMAILPEASUNTO, SolicitudConstants.SERV_ALIAS_ENVIAREMAIL, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_ENVIAREMAIL_SOLICITUDENVIAREMAILPEASUNTO);
        }
    }

    @JsonIgnore
    public String getSolicitudenviarEmailpeCuerpo() {
        return this.solicitudenviarEmailpeCuerpo;
    }
    
    public void setSolicitudenviarEmailpeCuerpo(String solicitudenviarEmailpeCuerpo) {
        this.solicitudenviarEmailpeCuerpo = solicitudenviarEmailpeCuerpo;
    }

    private void checkSolicitudenviarEmailpeCuerpo() throws NotNullArgumentException {
        if(this.getSolicitudenviarEmailpeCuerpo() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_ENVIAREMAIL, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_ENVIAREMAIL_SOLICITUDENVIAREMAILPECUERPO, SolicitudConstants.SERV_ALIAS_ENVIAREMAIL, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_ENVIAREMAIL_SOLICITUDENVIAREMAILPECUERPO);
        }
    }

    @JsonIgnore
    public String getSolicitudenviarEmailpeNombreAdjunto() {
        return this.solicitudenviarEmailpeNombreAdjunto;
    }
    
    public void setSolicitudenviarEmailpeNombreAdjunto(String solicitudenviarEmailpeNombreAdjunto) {
        this.solicitudenviarEmailpeNombreAdjunto = solicitudenviarEmailpeNombreAdjunto;
    }

    @JsonIgnore
    public byte[] getSolicitudenviarEmailpeAdjunto() {
        return this.solicitudenviarEmailpeAdjunto;
    }
    
    public void setSolicitudenviarEmailpeAdjunto(byte[] solicitudenviarEmailpeAdjunto) {
        this.solicitudenviarEmailpeAdjunto = solicitudenviarEmailpeAdjunto;
    }
}
