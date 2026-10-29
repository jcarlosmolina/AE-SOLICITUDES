package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.GrupoAsociado;
import com.keralty.aesolicitudes.persistence.oid.GrupoAsociadoOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class InsGrupoAsociadoSolicitudRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudInsGrupoAsociadoSolicitudpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudInsGrupoAsociadoSolicitudpthisSolicitudInstance;

    @JsonProperty("p_evcgrupoasociado_oid")
    private GrupoAsociadoOid solicitudInsGrupoAsociadoSolicitudpevcGrupoAsociado;
    
    @JsonIgnore
    private GrupoAsociado solicitudInsGrupoAsociadoSolicitudpevcGrupoAsociadoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudInsGrupoAsociadoSolicitudpthisSolicitud();
        checkSolicitudInsGrupoAsociadoSolicitudpevcGrupoAsociado();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudInsGrupoAsociadoSolicitudpthisSolicitud() {
        return this.solicitudInsGrupoAsociadoSolicitudpthisSolicitud;
    }
    
    public void setSolicitudInsGrupoAsociadoSolicitudpthisSolicitud(SolicitudOid solicitudInsGrupoAsociadoSolicitudpthisSolicitud) {
        this.solicitudInsGrupoAsociadoSolicitudpthisSolicitud = solicitudInsGrupoAsociadoSolicitudpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudInsGrupoAsociadoSolicitudpthisSolicitudInstance() {
        return this.solicitudInsGrupoAsociadoSolicitudpthisSolicitudInstance;
    }
    
    public void setSolicitudInsGrupoAsociadoSolicitudpthisSolicitudInstance(Solicitud solicitudInsGrupoAsociadoSolicitudpthisSolicitud) {
        this.solicitudInsGrupoAsociadoSolicitudpthisSolicitudInstance = solicitudInsGrupoAsociadoSolicitudpthisSolicitud;
        this.solicitudInsGrupoAsociadoSolicitudpthisSolicitud = solicitudInsGrupoAsociadoSolicitudpthisSolicitud != null ? solicitudInsGrupoAsociadoSolicitudpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudInsGrupoAsociadoSolicitudpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudInsGrupoAsociadoSolicitudpthisSolicitudInstance() == null || this.getSolicitudInsGrupoAsociadoSolicitudpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_INSGRUPOASOCIADOSOLICITUD, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_INSGRUPOASOCIADOSOLICITUD_SOLICITUDINSGRUPOASOCIADOSOLICITUDPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_INSGRUPOASOCIADOSOLICITUD, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_INSGRUPOASOCIADOSOLICITUD_SOLICITUDINSGRUPOASOCIADOSOLICITUDPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public GrupoAsociadoOid getSolicitudInsGrupoAsociadoSolicitudpevcGrupoAsociado() {
        return this.solicitudInsGrupoAsociadoSolicitudpevcGrupoAsociado;
    }
    
    public void setSolicitudInsGrupoAsociadoSolicitudpevcGrupoAsociado(GrupoAsociadoOid solicitudInsGrupoAsociadoSolicitudpevcGrupoAsociado) {
        this.solicitudInsGrupoAsociadoSolicitudpevcGrupoAsociado = solicitudInsGrupoAsociadoSolicitudpevcGrupoAsociado;
    }

    @JsonIgnore
    public GrupoAsociado getSolicitudInsGrupoAsociadoSolicitudpevcGrupoAsociadoInstance() {
        return this.solicitudInsGrupoAsociadoSolicitudpevcGrupoAsociadoInstance;
    }
    
    public void setSolicitudInsGrupoAsociadoSolicitudpevcGrupoAsociadoInstance(GrupoAsociado solicitudInsGrupoAsociadoSolicitudpevcGrupoAsociado) {
        this.solicitudInsGrupoAsociadoSolicitudpevcGrupoAsociadoInstance = solicitudInsGrupoAsociadoSolicitudpevcGrupoAsociado;
        this.solicitudInsGrupoAsociadoSolicitudpevcGrupoAsociado = solicitudInsGrupoAsociadoSolicitudpevcGrupoAsociado != null ? solicitudInsGrupoAsociadoSolicitudpevcGrupoAsociado.getOid() : null;
    }

    private void checkSolicitudInsGrupoAsociadoSolicitudpevcGrupoAsociado() throws NotNullArgumentException {
        if(this.getSolicitudInsGrupoAsociadoSolicitudpevcGrupoAsociadoInstance() == null || this.getSolicitudInsGrupoAsociadoSolicitudpevcGrupoAsociadoInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_INSGRUPOASOCIADOSOLICITUD, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_INSGRUPOASOCIADOSOLICITUD_SOLICITUDINSGRUPOASOCIADOSOLICITUDPEVCGRUPOASOCIADO, SolicitudConstants.SERV_ALIAS_INSGRUPOASOCIADOSOLICITUD, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_INSGRUPOASOCIADOSOLICITUD_SOLICITUDINSGRUPOASOCIADOSOLICITUDPEVCGRUPOASOCIADO);
        }
    }
}
