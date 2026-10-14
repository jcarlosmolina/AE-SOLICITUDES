package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.FormaPago;
import com.keralty.aesolicitudes.persistence.oid.FormaPagoOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class InsFormaPagoSolicitudRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudInsFormaPagoSolicitudpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudInsFormaPagoSolicitudpthisSolicitudInstance;

    @JsonProperty("p_evcformapago_oid")
    private FormaPagoOid solicitudInsFormaPagoSolicitudpevcFormaPago;
    
    @JsonIgnore
    private FormaPago solicitudInsFormaPagoSolicitudpevcFormaPagoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudInsFormaPagoSolicitudpthisSolicitud();
        checkSolicitudInsFormaPagoSolicitudpevcFormaPago();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudInsFormaPagoSolicitudpthisSolicitud() {
        return this.solicitudInsFormaPagoSolicitudpthisSolicitud;
    }
    
    public void setSolicitudInsFormaPagoSolicitudpthisSolicitud(SolicitudOid solicitudInsFormaPagoSolicitudpthisSolicitud) {
        this.solicitudInsFormaPagoSolicitudpthisSolicitud = solicitudInsFormaPagoSolicitudpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudInsFormaPagoSolicitudpthisSolicitudInstance() {
        return this.solicitudInsFormaPagoSolicitudpthisSolicitudInstance;
    }
    
    public void setSolicitudInsFormaPagoSolicitudpthisSolicitudInstance(Solicitud solicitudInsFormaPagoSolicitudpthisSolicitud) {
        this.solicitudInsFormaPagoSolicitudpthisSolicitudInstance = solicitudInsFormaPagoSolicitudpthisSolicitud;
        this.solicitudInsFormaPagoSolicitudpthisSolicitud = solicitudInsFormaPagoSolicitudpthisSolicitud != null ? solicitudInsFormaPagoSolicitudpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudInsFormaPagoSolicitudpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudInsFormaPagoSolicitudpthisSolicitudInstance() == null || this.getSolicitudInsFormaPagoSolicitudpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_INSFORMAPAGOSOLICITUD, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_INSFORMAPAGOSOLICITUD_SOLICITUDINSFORMAPAGOSOLICITUDPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_INSFORMAPAGOSOLICITUD, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_INSFORMAPAGOSOLICITUD_SOLICITUDINSFORMAPAGOSOLICITUDPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public FormaPagoOid getSolicitudInsFormaPagoSolicitudpevcFormaPago() {
        return this.solicitudInsFormaPagoSolicitudpevcFormaPago;
    }
    
    public void setSolicitudInsFormaPagoSolicitudpevcFormaPago(FormaPagoOid solicitudInsFormaPagoSolicitudpevcFormaPago) {
        this.solicitudInsFormaPagoSolicitudpevcFormaPago = solicitudInsFormaPagoSolicitudpevcFormaPago;
    }

    @JsonIgnore
    public FormaPago getSolicitudInsFormaPagoSolicitudpevcFormaPagoInstance() {
        return this.solicitudInsFormaPagoSolicitudpevcFormaPagoInstance;
    }
    
    public void setSolicitudInsFormaPagoSolicitudpevcFormaPagoInstance(FormaPago solicitudInsFormaPagoSolicitudpevcFormaPago) {
        this.solicitudInsFormaPagoSolicitudpevcFormaPagoInstance = solicitudInsFormaPagoSolicitudpevcFormaPago;
        this.solicitudInsFormaPagoSolicitudpevcFormaPago = solicitudInsFormaPagoSolicitudpevcFormaPago != null ? solicitudInsFormaPagoSolicitudpevcFormaPago.getOid() : null;
    }

    private void checkSolicitudInsFormaPagoSolicitudpevcFormaPago() throws NotNullArgumentException {
        if(this.getSolicitudInsFormaPagoSolicitudpevcFormaPagoInstance() == null || this.getSolicitudInsFormaPagoSolicitudpevcFormaPagoInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_INSFORMAPAGOSOLICITUD, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_INSFORMAPAGOSOLICITUD_SOLICITUDINSFORMAPAGOSOLICITUDPEVCFORMAPAGO, SolicitudConstants.SERV_ALIAS_INSFORMAPAGOSOLICITUD, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_INSFORMAPAGOSOLICITUD_SOLICITUDINSFORMAPAGOSOLICITUDPEVCFORMAPAGO);
        }
    }
}
