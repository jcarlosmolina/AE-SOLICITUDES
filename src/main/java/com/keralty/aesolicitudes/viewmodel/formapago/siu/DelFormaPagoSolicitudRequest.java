package com.keralty.aesolicitudes.viewmodel.formapago.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.FormaPagoConstants;
import com.keralty.aesolicitudes.persistence.FormaPago;
import com.keralty.aesolicitudes.persistence.oid.FormaPagoOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class DelFormaPagoSolicitudRequest {

    @JsonProperty("p_thisformapago_oid")
    private FormaPagoOid formaPagoDelFormaPagoSolicitudpthisFormaPago;
    
    @JsonIgnore
    private FormaPago formaPagoDelFormaPagoSolicitudpthisFormaPagoInstance;

    @JsonProperty("p_evcsolicitud_oid")
    private SolicitudOid formaPagoDelFormaPagoSolicitudpevcSolicitud;
    
    @JsonIgnore
    private Solicitud formaPagoDelFormaPagoSolicitudpevcSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFormaPagoDelFormaPagoSolicitudpthisFormaPago();
        checkFormaPagoDelFormaPagoSolicitudpevcSolicitud();
    }

    @JsonIgnore
    public FormaPagoOid getFormaPagoDelFormaPagoSolicitudpthisFormaPago() {
        return this.formaPagoDelFormaPagoSolicitudpthisFormaPago;
    }
    
    public void setFormaPagoDelFormaPagoSolicitudpthisFormaPago(FormaPagoOid formaPagoDelFormaPagoSolicitudpthisFormaPago) {
        this.formaPagoDelFormaPagoSolicitudpthisFormaPago = formaPagoDelFormaPagoSolicitudpthisFormaPago;
    }

    @JsonIgnore
    public FormaPago getFormaPagoDelFormaPagoSolicitudpthisFormaPagoInstance() {
        return this.formaPagoDelFormaPagoSolicitudpthisFormaPagoInstance;
    }
    
    public void setFormaPagoDelFormaPagoSolicitudpthisFormaPagoInstance(FormaPago formaPagoDelFormaPagoSolicitudpthisFormaPago) {
        this.formaPagoDelFormaPagoSolicitudpthisFormaPagoInstance = formaPagoDelFormaPagoSolicitudpthisFormaPago;
        this.formaPagoDelFormaPagoSolicitudpthisFormaPago = formaPagoDelFormaPagoSolicitudpthisFormaPago != null ? formaPagoDelFormaPagoSolicitudpthisFormaPago.getOid() : null;
    }

    private void checkFormaPagoDelFormaPagoSolicitudpthisFormaPago() throws NotNullArgumentException {
        if(this.getFormaPagoDelFormaPagoSolicitudpthisFormaPagoInstance() == null || this.getFormaPagoDelFormaPagoSolicitudpthisFormaPagoInstance().isNull()) {
            throw new NotNullArgumentException(FormaPagoConstants.SERV_ID_DELFORMAPAGOSOLICITUD, FormaPagoConstants.CLASS_ID, FormaPagoConstants.ARG_ID_DELFORMAPAGOSOLICITUD_FORMAPAGODELFORMAPAGOSOLICITUDPTHISFORMAPAGO, FormaPagoConstants.SERV_ALIAS_DELFORMAPAGOSOLICITUD, FormaPagoConstants.CLASS_ALIAS, FormaPagoConstants.ARG_ALIAS_DELFORMAPAGOSOLICITUD_FORMAPAGODELFORMAPAGOSOLICITUDPTHISFORMAPAGO);
        }
    }

    @JsonIgnore
    public SolicitudOid getFormaPagoDelFormaPagoSolicitudpevcSolicitud() {
        return this.formaPagoDelFormaPagoSolicitudpevcSolicitud;
    }
    
    public void setFormaPagoDelFormaPagoSolicitudpevcSolicitud(SolicitudOid formaPagoDelFormaPagoSolicitudpevcSolicitud) {
        this.formaPagoDelFormaPagoSolicitudpevcSolicitud = formaPagoDelFormaPagoSolicitudpevcSolicitud;
    }

    @JsonIgnore
    public Solicitud getFormaPagoDelFormaPagoSolicitudpevcSolicitudInstance() {
        return this.formaPagoDelFormaPagoSolicitudpevcSolicitudInstance;
    }
    
    public void setFormaPagoDelFormaPagoSolicitudpevcSolicitudInstance(Solicitud formaPagoDelFormaPagoSolicitudpevcSolicitud) {
        this.formaPagoDelFormaPagoSolicitudpevcSolicitudInstance = formaPagoDelFormaPagoSolicitudpevcSolicitud;
        this.formaPagoDelFormaPagoSolicitudpevcSolicitud = formaPagoDelFormaPagoSolicitudpevcSolicitud != null ? formaPagoDelFormaPagoSolicitudpevcSolicitud.getOid() : null;
    }

    private void checkFormaPagoDelFormaPagoSolicitudpevcSolicitud() throws NotNullArgumentException {
        if(this.getFormaPagoDelFormaPagoSolicitudpevcSolicitudInstance() == null || this.getFormaPagoDelFormaPagoSolicitudpevcSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(FormaPagoConstants.SERV_ID_DELFORMAPAGOSOLICITUD, FormaPagoConstants.CLASS_ID, FormaPagoConstants.ARG_ID_DELFORMAPAGOSOLICITUD_FORMAPAGODELFORMAPAGOSOLICITUDPEVCSOLICITUD, FormaPagoConstants.SERV_ALIAS_DELFORMAPAGOSOLICITUD, FormaPagoConstants.CLASS_ALIAS, FormaPagoConstants.ARG_ALIAS_DELFORMAPAGOSOLICITUD_FORMAPAGODELFORMAPAGOSOLICITUDPEVCSOLICITUD);
        }
    }
}
