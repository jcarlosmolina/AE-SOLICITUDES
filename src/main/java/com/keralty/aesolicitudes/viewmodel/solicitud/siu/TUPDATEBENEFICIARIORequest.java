package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TUPDATEBENEFICIARIORequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTUPDATEBENEFICIARIOpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTUPDATEBENEFICIARIOpthisSolicitudInstance;

    @JsonProperty("p_beneficiarioc_oid")
    private BeneficiarioCOid solicitudTUPDATEBENEFICIARIOpBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC solicitudTUPDATEBENEFICIARIOpBeneficiarioCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTUPDATEBENEFICIARIOpthisSolicitud();
        checkSolicitudTUPDATEBENEFICIARIOpBeneficiarioC();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTUPDATEBENEFICIARIOpthisSolicitud() {
        return this.solicitudTUPDATEBENEFICIARIOpthisSolicitud;
    }
    
    public void setSolicitudTUPDATEBENEFICIARIOpthisSolicitud(SolicitudOid solicitudTUPDATEBENEFICIARIOpthisSolicitud) {
        this.solicitudTUPDATEBENEFICIARIOpthisSolicitud = solicitudTUPDATEBENEFICIARIOpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTUPDATEBENEFICIARIOpthisSolicitudInstance() {
        return this.solicitudTUPDATEBENEFICIARIOpthisSolicitudInstance;
    }
    
    public void setSolicitudTUPDATEBENEFICIARIOpthisSolicitudInstance(Solicitud solicitudTUPDATEBENEFICIARIOpthisSolicitud) {
        this.solicitudTUPDATEBENEFICIARIOpthisSolicitudInstance = solicitudTUPDATEBENEFICIARIOpthisSolicitud;
        this.solicitudTUPDATEBENEFICIARIOpthisSolicitud = solicitudTUPDATEBENEFICIARIOpthisSolicitud != null ? solicitudTUPDATEBENEFICIARIOpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTUPDATEBENEFICIARIOpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTUPDATEBENEFICIARIOpthisSolicitudInstance() == null || this.getSolicitudTUPDATEBENEFICIARIOpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TUPDATEBENEFICIARIO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TUPDATEBENEFICIARIO_SOLICITUDTUPDATEBENEFICIARIOPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TUPDATEBENEFICIARIO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TUPDATEBENEFICIARIO_SOLICITUDTUPDATEBENEFICIARIOPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public BeneficiarioCOid getSolicitudTUPDATEBENEFICIARIOpBeneficiarioC() {
        return this.solicitudTUPDATEBENEFICIARIOpBeneficiarioC;
    }
    
    public void setSolicitudTUPDATEBENEFICIARIOpBeneficiarioC(BeneficiarioCOid solicitudTUPDATEBENEFICIARIOpBeneficiarioC) {
        this.solicitudTUPDATEBENEFICIARIOpBeneficiarioC = solicitudTUPDATEBENEFICIARIOpBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getSolicitudTUPDATEBENEFICIARIOpBeneficiarioCInstance() {
        return this.solicitudTUPDATEBENEFICIARIOpBeneficiarioCInstance;
    }
    
    public void setSolicitudTUPDATEBENEFICIARIOpBeneficiarioCInstance(BeneficiarioC solicitudTUPDATEBENEFICIARIOpBeneficiarioC) {
        this.solicitudTUPDATEBENEFICIARIOpBeneficiarioCInstance = solicitudTUPDATEBENEFICIARIOpBeneficiarioC;
        this.solicitudTUPDATEBENEFICIARIOpBeneficiarioC = solicitudTUPDATEBENEFICIARIOpBeneficiarioC != null ? solicitudTUPDATEBENEFICIARIOpBeneficiarioC.getOid() : null;
    }

    private void checkSolicitudTUPDATEBENEFICIARIOpBeneficiarioC() throws NotNullArgumentException {
        if(this.getSolicitudTUPDATEBENEFICIARIOpBeneficiarioCInstance() == null || this.getSolicitudTUPDATEBENEFICIARIOpBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TUPDATEBENEFICIARIO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TUPDATEBENEFICIARIO_SOLICITUDTUPDATEBENEFICIARIOPBENEFICIARIOC, SolicitudConstants.SERV_ALIAS_TUPDATEBENEFICIARIO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TUPDATEBENEFICIARIO_SOLICITUDTUPDATEBENEFICIARIOPBENEFICIARIOC);
        }
    }
}
