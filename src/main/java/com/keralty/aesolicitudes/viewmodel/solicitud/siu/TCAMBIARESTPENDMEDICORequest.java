package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TCAMBIARESTPENDMEDICORequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTCAMBIARESTPENDMEDICOpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTCAMBIARESTPENDMEDICOpthisSolicitudInstance;

    @JsonProperty("pt_ptobservaciones")
    private String solicitudTCAMBIARESTPENDMEDICOptptObservaciones;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTCAMBIARESTPENDMEDICOpthisSolicitud();
        checkSolicitudTCAMBIARESTPENDMEDICOptptObservaciones();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTCAMBIARESTPENDMEDICOpthisSolicitud() {
        return this.solicitudTCAMBIARESTPENDMEDICOpthisSolicitud;
    }
    
    public void setSolicitudTCAMBIARESTPENDMEDICOpthisSolicitud(SolicitudOid solicitudTCAMBIARESTPENDMEDICOpthisSolicitud) {
        this.solicitudTCAMBIARESTPENDMEDICOpthisSolicitud = solicitudTCAMBIARESTPENDMEDICOpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTCAMBIARESTPENDMEDICOpthisSolicitudInstance() {
        return this.solicitudTCAMBIARESTPENDMEDICOpthisSolicitudInstance;
    }
    
    public void setSolicitudTCAMBIARESTPENDMEDICOpthisSolicitudInstance(Solicitud solicitudTCAMBIARESTPENDMEDICOpthisSolicitud) {
        this.solicitudTCAMBIARESTPENDMEDICOpthisSolicitudInstance = solicitudTCAMBIARESTPENDMEDICOpthisSolicitud;
        this.solicitudTCAMBIARESTPENDMEDICOpthisSolicitud = solicitudTCAMBIARESTPENDMEDICOpthisSolicitud != null ? solicitudTCAMBIARESTPENDMEDICOpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTCAMBIARESTPENDMEDICOpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTCAMBIARESTPENDMEDICOpthisSolicitudInstance() == null || this.getSolicitudTCAMBIARESTPENDMEDICOpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCAMBIARESTPENDMEDICO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCAMBIARESTPENDMEDICO_SOLICITUDTCAMBIARESTPENDMEDICOPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TCAMBIARESTPENDMEDICO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCAMBIARESTPENDMEDICO_SOLICITUDTCAMBIARESTPENDMEDICOPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudTCAMBIARESTPENDMEDICOptptObservaciones() {
        return this.solicitudTCAMBIARESTPENDMEDICOptptObservaciones;
    }
    
    public void setSolicitudTCAMBIARESTPENDMEDICOptptObservaciones(String solicitudTCAMBIARESTPENDMEDICOptptObservaciones) {
        this.solicitudTCAMBIARESTPENDMEDICOptptObservaciones = solicitudTCAMBIARESTPENDMEDICOptptObservaciones;
    }

    private void checkSolicitudTCAMBIARESTPENDMEDICOptptObservaciones() throws NotNullArgumentException {
        if(this.getSolicitudTCAMBIARESTPENDMEDICOptptObservaciones() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCAMBIARESTPENDMEDICO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCAMBIARESTPENDMEDICO_SOLICITUDTCAMBIARESTPENDMEDICOPTPTOBSERVACIONES, SolicitudConstants.SERV_ALIAS_TCAMBIARESTPENDMEDICO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCAMBIARESTPENDMEDICO_SOLICITUDTCAMBIARESTPENDMEDICOPTPTOBSERVACIONES);
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
