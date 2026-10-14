package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TCHGTITBENEFCONTRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTCHGTITBENEFCONTpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTCHGTITBENEFCONTpthisSolicitudInstance;

    @JsonProperty("pttitularconbeneficios")
    private Boolean solicitudTCHGTITBENEFCONTptTitularConBeneficios;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTCHGTITBENEFCONTpthisSolicitud();
        checkSolicitudTCHGTITBENEFCONTptTitularConBeneficios();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTCHGTITBENEFCONTpthisSolicitud() {
        return this.solicitudTCHGTITBENEFCONTpthisSolicitud;
    }
    
    public void setSolicitudTCHGTITBENEFCONTpthisSolicitud(SolicitudOid solicitudTCHGTITBENEFCONTpthisSolicitud) {
        this.solicitudTCHGTITBENEFCONTpthisSolicitud = solicitudTCHGTITBENEFCONTpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTCHGTITBENEFCONTpthisSolicitudInstance() {
        return this.solicitudTCHGTITBENEFCONTpthisSolicitudInstance;
    }
    
    public void setSolicitudTCHGTITBENEFCONTpthisSolicitudInstance(Solicitud solicitudTCHGTITBENEFCONTpthisSolicitud) {
        this.solicitudTCHGTITBENEFCONTpthisSolicitudInstance = solicitudTCHGTITBENEFCONTpthisSolicitud;
        this.solicitudTCHGTITBENEFCONTpthisSolicitud = solicitudTCHGTITBENEFCONTpthisSolicitud != null ? solicitudTCHGTITBENEFCONTpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTCHGTITBENEFCONTpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTCHGTITBENEFCONTpthisSolicitudInstance() == null || this.getSolicitudTCHGTITBENEFCONTpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCHGTITBENEFCONT, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCHGTITBENEFCONT_SOLICITUDTCHGTITBENEFCONTPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TCHGTITBENEFCONT, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCHGTITBENEFCONT_SOLICITUDTCHGTITBENEFCONTPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTCHGTITBENEFCONTptTitularConBeneficios() {
        return this.solicitudTCHGTITBENEFCONTptTitularConBeneficios;
    }
    
    public void setSolicitudTCHGTITBENEFCONTptTitularConBeneficios(Boolean solicitudTCHGTITBENEFCONTptTitularConBeneficios) {
        this.solicitudTCHGTITBENEFCONTptTitularConBeneficios = solicitudTCHGTITBENEFCONTptTitularConBeneficios;
    }

    private void checkSolicitudTCHGTITBENEFCONTptTitularConBeneficios() throws NotNullArgumentException {
        if(this.getSolicitudTCHGTITBENEFCONTptTitularConBeneficios() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCHGTITBENEFCONT, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCHGTITBENEFCONT_SOLICITUDTCHGTITBENEFCONTPTTITULARCONBENEFICIOS, SolicitudConstants.SERV_ALIAS_TCHGTITBENEFCONT, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCHGTITBENEFCONT_SOLICITUDTCHGTITBENEFCONTPTTITULARCONBENEFICIOS);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
