package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.GrupoAsociado;
import com.keralty.aesolicitudes.persistence.oid.GrupoAsociadoOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class DelGrupoAsociadoSolicitudRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudDelGrupoAsociadoSolicitudpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudDelGrupoAsociadoSolicitudpthisSolicitudInstance;

    @JsonProperty("p_evcgrupoasociado_oid")
    private GrupoAsociadoOid solicitudDelGrupoAsociadoSolicitudpevcGrupoAsociado;
    
    @JsonIgnore
    private GrupoAsociado solicitudDelGrupoAsociadoSolicitudpevcGrupoAsociadoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudDelGrupoAsociadoSolicitudpthisSolicitud();
        checkSolicitudDelGrupoAsociadoSolicitudpevcGrupoAsociado();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudDelGrupoAsociadoSolicitudpthisSolicitud() {
        return this.solicitudDelGrupoAsociadoSolicitudpthisSolicitud;
    }
    
    public void setSolicitudDelGrupoAsociadoSolicitudpthisSolicitud(SolicitudOid solicitudDelGrupoAsociadoSolicitudpthisSolicitud) {
        this.solicitudDelGrupoAsociadoSolicitudpthisSolicitud = solicitudDelGrupoAsociadoSolicitudpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudDelGrupoAsociadoSolicitudpthisSolicitudInstance() {
        return this.solicitudDelGrupoAsociadoSolicitudpthisSolicitudInstance;
    }
    
    public void setSolicitudDelGrupoAsociadoSolicitudpthisSolicitudInstance(Solicitud solicitudDelGrupoAsociadoSolicitudpthisSolicitud) {
        this.solicitudDelGrupoAsociadoSolicitudpthisSolicitudInstance = solicitudDelGrupoAsociadoSolicitudpthisSolicitud;
        this.solicitudDelGrupoAsociadoSolicitudpthisSolicitud = solicitudDelGrupoAsociadoSolicitudpthisSolicitud != null ? solicitudDelGrupoAsociadoSolicitudpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudDelGrupoAsociadoSolicitudpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudDelGrupoAsociadoSolicitudpthisSolicitudInstance() == null || this.getSolicitudDelGrupoAsociadoSolicitudpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_DELGRUPOASOCIADOSOLICITUD, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_DELGRUPOASOCIADOSOLICITUD_SOLICITUDDELGRUPOASOCIADOSOLICITUDPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_DELGRUPOASOCIADOSOLICITUD, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_DELGRUPOASOCIADOSOLICITUD_SOLICITUDDELGRUPOASOCIADOSOLICITUDPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public GrupoAsociadoOid getSolicitudDelGrupoAsociadoSolicitudpevcGrupoAsociado() {
        return this.solicitudDelGrupoAsociadoSolicitudpevcGrupoAsociado;
    }
    
    public void setSolicitudDelGrupoAsociadoSolicitudpevcGrupoAsociado(GrupoAsociadoOid solicitudDelGrupoAsociadoSolicitudpevcGrupoAsociado) {
        this.solicitudDelGrupoAsociadoSolicitudpevcGrupoAsociado = solicitudDelGrupoAsociadoSolicitudpevcGrupoAsociado;
    }

    @JsonIgnore
    public GrupoAsociado getSolicitudDelGrupoAsociadoSolicitudpevcGrupoAsociadoInstance() {
        return this.solicitudDelGrupoAsociadoSolicitudpevcGrupoAsociadoInstance;
    }
    
    public void setSolicitudDelGrupoAsociadoSolicitudpevcGrupoAsociadoInstance(GrupoAsociado solicitudDelGrupoAsociadoSolicitudpevcGrupoAsociado) {
        this.solicitudDelGrupoAsociadoSolicitudpevcGrupoAsociadoInstance = solicitudDelGrupoAsociadoSolicitudpevcGrupoAsociado;
        this.solicitudDelGrupoAsociadoSolicitudpevcGrupoAsociado = solicitudDelGrupoAsociadoSolicitudpevcGrupoAsociado != null ? solicitudDelGrupoAsociadoSolicitudpevcGrupoAsociado.getOid() : null;
    }

    private void checkSolicitudDelGrupoAsociadoSolicitudpevcGrupoAsociado() throws NotNullArgumentException {
        if(this.getSolicitudDelGrupoAsociadoSolicitudpevcGrupoAsociadoInstance() == null || this.getSolicitudDelGrupoAsociadoSolicitudpevcGrupoAsociadoInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_DELGRUPOASOCIADOSOLICITUD, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_DELGRUPOASOCIADOSOLICITUD_SOLICITUDDELGRUPOASOCIADOSOLICITUDPEVCGRUPOASOCIADO, SolicitudConstants.SERV_ALIAS_DELGRUPOASOCIADOSOLICITUD, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_DELGRUPOASOCIADOSOLICITUD_SOLICITUDDELGRUPOASOCIADOSOLICITUDPEVCGRUPOASOCIADO);
        }
    }
}
