package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.MotDevAreaMedica;
import com.keralty.aesolicitudes.persistence.oid.MotDevAreaMedicaOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TCAMBIARESTDEVAREAMEDRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTCAMBIARESTDEVAREAMEDpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTCAMBIARESTDEVAREAMEDpthisSolicitudInstance;

    @JsonProperty("pt_ptobservaciones")
    private String solicitudTCAMBIARESTDEVAREAMEDptptObservaciones;

    @JsonProperty("ptmotivo_oid")
    private MotDevAreaMedicaOid solicitudTCAMBIARESTDEVAREAMEDptMotivo;
    
    @JsonIgnore
    private MotDevAreaMedica solicitudTCAMBIARESTDEVAREAMEDptMotivoInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTCAMBIARESTDEVAREAMEDpthisSolicitud();
        checkSolicitudTCAMBIARESTDEVAREAMEDptptObservaciones();
        checkSolicitudTCAMBIARESTDEVAREAMEDptMotivo();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTCAMBIARESTDEVAREAMEDpthisSolicitud() {
        return this.solicitudTCAMBIARESTDEVAREAMEDpthisSolicitud;
    }
    
    public void setSolicitudTCAMBIARESTDEVAREAMEDpthisSolicitud(SolicitudOid solicitudTCAMBIARESTDEVAREAMEDpthisSolicitud) {
        this.solicitudTCAMBIARESTDEVAREAMEDpthisSolicitud = solicitudTCAMBIARESTDEVAREAMEDpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTCAMBIARESTDEVAREAMEDpthisSolicitudInstance() {
        return this.solicitudTCAMBIARESTDEVAREAMEDpthisSolicitudInstance;
    }
    
    public void setSolicitudTCAMBIARESTDEVAREAMEDpthisSolicitudInstance(Solicitud solicitudTCAMBIARESTDEVAREAMEDpthisSolicitud) {
        this.solicitudTCAMBIARESTDEVAREAMEDpthisSolicitudInstance = solicitudTCAMBIARESTDEVAREAMEDpthisSolicitud;
        this.solicitudTCAMBIARESTDEVAREAMEDpthisSolicitud = solicitudTCAMBIARESTDEVAREAMEDpthisSolicitud != null ? solicitudTCAMBIARESTDEVAREAMEDpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTCAMBIARESTDEVAREAMEDpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTCAMBIARESTDEVAREAMEDpthisSolicitudInstance() == null || this.getSolicitudTCAMBIARESTDEVAREAMEDpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCAMBIARESTDEVAREAMED, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCAMBIARESTDEVAREAMED_SOLICITUDTCAMBIARESTDEVAREAMEDPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TCAMBIARESTDEVAREAMED, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCAMBIARESTDEVAREAMED_SOLICITUDTCAMBIARESTDEVAREAMEDPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudTCAMBIARESTDEVAREAMEDptptObservaciones() {
        return this.solicitudTCAMBIARESTDEVAREAMEDptptObservaciones;
    }
    
    public void setSolicitudTCAMBIARESTDEVAREAMEDptptObservaciones(String solicitudTCAMBIARESTDEVAREAMEDptptObservaciones) {
        this.solicitudTCAMBIARESTDEVAREAMEDptptObservaciones = solicitudTCAMBIARESTDEVAREAMEDptptObservaciones;
    }

    private void checkSolicitudTCAMBIARESTDEVAREAMEDptptObservaciones() throws NotNullArgumentException {
        if(this.getSolicitudTCAMBIARESTDEVAREAMEDptptObservaciones() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCAMBIARESTDEVAREAMED, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCAMBIARESTDEVAREAMED_SOLICITUDTCAMBIARESTDEVAREAMEDPTPTOBSERVACIONES, SolicitudConstants.SERV_ALIAS_TCAMBIARESTDEVAREAMED, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCAMBIARESTDEVAREAMED_SOLICITUDTCAMBIARESTDEVAREAMEDPTPTOBSERVACIONES);
        }
    }

    @JsonIgnore
    public MotDevAreaMedicaOid getSolicitudTCAMBIARESTDEVAREAMEDptMotivo() {
        return this.solicitudTCAMBIARESTDEVAREAMEDptMotivo;
    }
    
    public void setSolicitudTCAMBIARESTDEVAREAMEDptMotivo(MotDevAreaMedicaOid solicitudTCAMBIARESTDEVAREAMEDptMotivo) {
        this.solicitudTCAMBIARESTDEVAREAMEDptMotivo = solicitudTCAMBIARESTDEVAREAMEDptMotivo;
    }

    @JsonIgnore
    public MotDevAreaMedica getSolicitudTCAMBIARESTDEVAREAMEDptMotivoInstance() {
        return this.solicitudTCAMBIARESTDEVAREAMEDptMotivoInstance;
    }
    
    public void setSolicitudTCAMBIARESTDEVAREAMEDptMotivoInstance(MotDevAreaMedica solicitudTCAMBIARESTDEVAREAMEDptMotivo) {
        this.solicitudTCAMBIARESTDEVAREAMEDptMotivoInstance = solicitudTCAMBIARESTDEVAREAMEDptMotivo;
        this.solicitudTCAMBIARESTDEVAREAMEDptMotivo = solicitudTCAMBIARESTDEVAREAMEDptMotivo != null ? solicitudTCAMBIARESTDEVAREAMEDptMotivo.getOid() : null;
    }

    private void checkSolicitudTCAMBIARESTDEVAREAMEDptMotivo() throws NotNullArgumentException {
        if(this.getSolicitudTCAMBIARESTDEVAREAMEDptMotivoInstance() == null || this.getSolicitudTCAMBIARESTDEVAREAMEDptMotivoInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCAMBIARESTDEVAREAMED, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCAMBIARESTDEVAREAMED_SOLICITUDTCAMBIARESTDEVAREAMEDPTMOTIVO, SolicitudConstants.SERV_ALIAS_TCAMBIARESTDEVAREAMED, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCAMBIARESTDEVAREAMED_SOLICITUDTCAMBIARESTDEVAREAMEDPTMOTIVO);
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
