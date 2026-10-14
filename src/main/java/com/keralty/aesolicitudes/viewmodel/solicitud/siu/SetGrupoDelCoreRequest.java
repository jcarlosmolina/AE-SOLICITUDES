package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class SetGrupoDelCoreRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudsetGrupoDelCorepthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudsetGrupoDelCorepthisSolicitudInstance;

    @JsonProperty("pecodgrupo")
    private Long solicitudsetGrupoDelCorepeCodGrupo;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudsetGrupoDelCorepthisSolicitud();
        checkSolicitudsetGrupoDelCorepeCodGrupo();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudsetGrupoDelCorepthisSolicitud() {
        return this.solicitudsetGrupoDelCorepthisSolicitud;
    }
    
    public void setSolicitudsetGrupoDelCorepthisSolicitud(SolicitudOid solicitudsetGrupoDelCorepthisSolicitud) {
        this.solicitudsetGrupoDelCorepthisSolicitud = solicitudsetGrupoDelCorepthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudsetGrupoDelCorepthisSolicitudInstance() {
        return this.solicitudsetGrupoDelCorepthisSolicitudInstance;
    }
    
    public void setSolicitudsetGrupoDelCorepthisSolicitudInstance(Solicitud solicitudsetGrupoDelCorepthisSolicitud) {
        this.solicitudsetGrupoDelCorepthisSolicitudInstance = solicitudsetGrupoDelCorepthisSolicitud;
        this.solicitudsetGrupoDelCorepthisSolicitud = solicitudsetGrupoDelCorepthisSolicitud != null ? solicitudsetGrupoDelCorepthisSolicitud.getOid() : null;
    }

    private void checkSolicitudsetGrupoDelCorepthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudsetGrupoDelCorepthisSolicitudInstance() == null || this.getSolicitudsetGrupoDelCorepthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_SETGRUPODELCORE, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_SETGRUPODELCORE_SOLICITUDSETGRUPODELCOREPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_SETGRUPODELCORE, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_SETGRUPODELCORE_SOLICITUDSETGRUPODELCOREPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public Long getSolicitudsetGrupoDelCorepeCodGrupo() {
        return this.solicitudsetGrupoDelCorepeCodGrupo;
    }
    
    public void setSolicitudsetGrupoDelCorepeCodGrupo(Long solicitudsetGrupoDelCorepeCodGrupo) {
        this.solicitudsetGrupoDelCorepeCodGrupo = solicitudsetGrupoDelCorepeCodGrupo;
    }

    private void checkSolicitudsetGrupoDelCorepeCodGrupo() throws NotNullArgumentException {
        if(this.getSolicitudsetGrupoDelCorepeCodGrupo() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_SETGRUPODELCORE, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_SETGRUPODELCORE_SOLICITUDSETGRUPODELCOREPECODGRUPO, SolicitudConstants.SERV_ALIAS_SETGRUPODELCORE, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_SETGRUPODELCORE_SOLICITUDSETGRUPODELCOREPECODGRUPO);
        }
    }
}
