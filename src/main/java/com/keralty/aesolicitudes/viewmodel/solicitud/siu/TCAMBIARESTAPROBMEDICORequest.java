package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TCAMBIARESTAPROBMEDICORequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTCAMBIARESTAPROBMEDICOpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTCAMBIARESTAPROBMEDICOpthisSolicitudInstance;

    @JsonProperty("pt_ptobservaciones")
    private String solicitudTCAMBIARESTAPROBMEDICOptptObservaciones;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTCAMBIARESTAPROBMEDICOpthisSolicitud();
        checkSolicitudTCAMBIARESTAPROBMEDICOptptObservaciones();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTCAMBIARESTAPROBMEDICOpthisSolicitud() {
        return this.solicitudTCAMBIARESTAPROBMEDICOpthisSolicitud;
    }
    
    public void setSolicitudTCAMBIARESTAPROBMEDICOpthisSolicitud(SolicitudOid solicitudTCAMBIARESTAPROBMEDICOpthisSolicitud) {
        this.solicitudTCAMBIARESTAPROBMEDICOpthisSolicitud = solicitudTCAMBIARESTAPROBMEDICOpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTCAMBIARESTAPROBMEDICOpthisSolicitudInstance() {
        return this.solicitudTCAMBIARESTAPROBMEDICOpthisSolicitudInstance;
    }
    
    public void setSolicitudTCAMBIARESTAPROBMEDICOpthisSolicitudInstance(Solicitud solicitudTCAMBIARESTAPROBMEDICOpthisSolicitud) {
        this.solicitudTCAMBIARESTAPROBMEDICOpthisSolicitudInstance = solicitudTCAMBIARESTAPROBMEDICOpthisSolicitud;
        this.solicitudTCAMBIARESTAPROBMEDICOpthisSolicitud = solicitudTCAMBIARESTAPROBMEDICOpthisSolicitud != null ? solicitudTCAMBIARESTAPROBMEDICOpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTCAMBIARESTAPROBMEDICOpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTCAMBIARESTAPROBMEDICOpthisSolicitudInstance() == null || this.getSolicitudTCAMBIARESTAPROBMEDICOpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCAMBIARESTAPROBMEDICO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCAMBIARESTAPROBMEDICO_SOLICITUDTCAMBIARESTAPROBMEDICOPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TCAMBIARESTAPROBMEDICO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCAMBIARESTAPROBMEDICO_SOLICITUDTCAMBIARESTAPROBMEDICOPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudTCAMBIARESTAPROBMEDICOptptObservaciones() {
        return this.solicitudTCAMBIARESTAPROBMEDICOptptObservaciones;
    }
    
    public void setSolicitudTCAMBIARESTAPROBMEDICOptptObservaciones(String solicitudTCAMBIARESTAPROBMEDICOptptObservaciones) {
        this.solicitudTCAMBIARESTAPROBMEDICOptptObservaciones = solicitudTCAMBIARESTAPROBMEDICOptptObservaciones;
    }

    private void checkSolicitudTCAMBIARESTAPROBMEDICOptptObservaciones() throws NotNullArgumentException {
        if(this.getSolicitudTCAMBIARESTAPROBMEDICOptptObservaciones() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCAMBIARESTAPROBMEDICO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCAMBIARESTAPROBMEDICO_SOLICITUDTCAMBIARESTAPROBMEDICOPTPTOBSERVACIONES, SolicitudConstants.SERV_ALIAS_TCAMBIARESTAPROBMEDICO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCAMBIARESTAPROBMEDICO_SOLICITUDTCAMBIARESTAPROBMEDICOPTPTOBSERVACIONES);
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
