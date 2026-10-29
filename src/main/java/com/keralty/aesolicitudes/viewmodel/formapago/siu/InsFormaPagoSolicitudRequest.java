package com.keralty.aesolicitudes.viewmodel.formapago.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.FormaPagoConstants;
import com.keralty.aesolicitudes.persistence.FormaPago;
import com.keralty.aesolicitudes.persistence.oid.FormaPagoOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class InsFormaPagoSolicitudRequest {

    @JsonProperty("p_thisformapago_oid")
    private FormaPagoOid formaPagoInsFormaPagoSolicitudpthisFormaPago;
    
    @JsonIgnore
    private FormaPago formaPagoInsFormaPagoSolicitudpthisFormaPagoInstance;

    @JsonProperty("p_evcsolicitud_oid")
    private SolicitudOid formaPagoInsFormaPagoSolicitudpevcSolicitud;
    
    @JsonIgnore
    private Solicitud formaPagoInsFormaPagoSolicitudpevcSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFormaPagoInsFormaPagoSolicitudpthisFormaPago();
        checkFormaPagoInsFormaPagoSolicitudpevcSolicitud();
    }

    @JsonIgnore
    public FormaPagoOid getFormaPagoInsFormaPagoSolicitudpthisFormaPago() {
        return this.formaPagoInsFormaPagoSolicitudpthisFormaPago;
    }
    
    public void setFormaPagoInsFormaPagoSolicitudpthisFormaPago(FormaPagoOid formaPagoInsFormaPagoSolicitudpthisFormaPago) {
        this.formaPagoInsFormaPagoSolicitudpthisFormaPago = formaPagoInsFormaPagoSolicitudpthisFormaPago;
    }

    @JsonIgnore
    public FormaPago getFormaPagoInsFormaPagoSolicitudpthisFormaPagoInstance() {
        return this.formaPagoInsFormaPagoSolicitudpthisFormaPagoInstance;
    }
    
    public void setFormaPagoInsFormaPagoSolicitudpthisFormaPagoInstance(FormaPago formaPagoInsFormaPagoSolicitudpthisFormaPago) {
        this.formaPagoInsFormaPagoSolicitudpthisFormaPagoInstance = formaPagoInsFormaPagoSolicitudpthisFormaPago;
        this.formaPagoInsFormaPagoSolicitudpthisFormaPago = formaPagoInsFormaPagoSolicitudpthisFormaPago != null ? formaPagoInsFormaPagoSolicitudpthisFormaPago.getOid() : null;
    }

    private void checkFormaPagoInsFormaPagoSolicitudpthisFormaPago() throws NotNullArgumentException {
        if(this.getFormaPagoInsFormaPagoSolicitudpthisFormaPagoInstance() == null || this.getFormaPagoInsFormaPagoSolicitudpthisFormaPagoInstance().isNull()) {
            throw new NotNullArgumentException(FormaPagoConstants.SERV_ID_INSFORMAPAGOSOLICITUD, FormaPagoConstants.CLASS_ID, FormaPagoConstants.ARG_ID_INSFORMAPAGOSOLICITUD_FORMAPAGOINSFORMAPAGOSOLICITUDPTHISFORMAPAGO, FormaPagoConstants.SERV_ALIAS_INSFORMAPAGOSOLICITUD, FormaPagoConstants.CLASS_ALIAS, FormaPagoConstants.ARG_ALIAS_INSFORMAPAGOSOLICITUD_FORMAPAGOINSFORMAPAGOSOLICITUDPTHISFORMAPAGO);
        }
    }

    @JsonIgnore
    public SolicitudOid getFormaPagoInsFormaPagoSolicitudpevcSolicitud() {
        return this.formaPagoInsFormaPagoSolicitudpevcSolicitud;
    }
    
    public void setFormaPagoInsFormaPagoSolicitudpevcSolicitud(SolicitudOid formaPagoInsFormaPagoSolicitudpevcSolicitud) {
        this.formaPagoInsFormaPagoSolicitudpevcSolicitud = formaPagoInsFormaPagoSolicitudpevcSolicitud;
    }

    @JsonIgnore
    public Solicitud getFormaPagoInsFormaPagoSolicitudpevcSolicitudInstance() {
        return this.formaPagoInsFormaPagoSolicitudpevcSolicitudInstance;
    }
    
    public void setFormaPagoInsFormaPagoSolicitudpevcSolicitudInstance(Solicitud formaPagoInsFormaPagoSolicitudpevcSolicitud) {
        this.formaPagoInsFormaPagoSolicitudpevcSolicitudInstance = formaPagoInsFormaPagoSolicitudpevcSolicitud;
        this.formaPagoInsFormaPagoSolicitudpevcSolicitud = formaPagoInsFormaPagoSolicitudpevcSolicitud != null ? formaPagoInsFormaPagoSolicitudpevcSolicitud.getOid() : null;
    }

    private void checkFormaPagoInsFormaPagoSolicitudpevcSolicitud() throws NotNullArgumentException {
        if(this.getFormaPagoInsFormaPagoSolicitudpevcSolicitudInstance() == null || this.getFormaPagoInsFormaPagoSolicitudpevcSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(FormaPagoConstants.SERV_ID_INSFORMAPAGOSOLICITUD, FormaPagoConstants.CLASS_ID, FormaPagoConstants.ARG_ID_INSFORMAPAGOSOLICITUD_FORMAPAGOINSFORMAPAGOSOLICITUDPEVCSOLICITUD, FormaPagoConstants.SERV_ALIAS_INSFORMAPAGOSOLICITUD, FormaPagoConstants.CLASS_ALIAS, FormaPagoConstants.ARG_ALIAS_INSFORMAPAGOSOLICITUD_FORMAPAGOINSFORMAPAGOSOLICITUDPEVCSOLICITUD);
        }
    }
}
