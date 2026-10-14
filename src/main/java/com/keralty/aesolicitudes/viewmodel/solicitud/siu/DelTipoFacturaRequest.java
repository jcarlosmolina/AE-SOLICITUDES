package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.oid.TipoFacturaOid;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoFactura;

public class DelTipoFacturaRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudDelTipoFacturapthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudDelTipoFacturapthisSolicitudInstance;

    @JsonProperty("p_evctipofactura_oid")
    private TipoFacturaOid solicitudDelTipoFacturapevcTipoFactura;
    
    @JsonIgnore
    private TipoFactura solicitudDelTipoFacturapevcTipoFacturaInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudDelTipoFacturapthisSolicitud();
        checkSolicitudDelTipoFacturapevcTipoFactura();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudDelTipoFacturapthisSolicitud() {
        return this.solicitudDelTipoFacturapthisSolicitud;
    }
    
    public void setSolicitudDelTipoFacturapthisSolicitud(SolicitudOid solicitudDelTipoFacturapthisSolicitud) {
        this.solicitudDelTipoFacturapthisSolicitud = solicitudDelTipoFacturapthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudDelTipoFacturapthisSolicitudInstance() {
        return this.solicitudDelTipoFacturapthisSolicitudInstance;
    }
    
    public void setSolicitudDelTipoFacturapthisSolicitudInstance(Solicitud solicitudDelTipoFacturapthisSolicitud) {
        this.solicitudDelTipoFacturapthisSolicitudInstance = solicitudDelTipoFacturapthisSolicitud;
        this.solicitudDelTipoFacturapthisSolicitud = solicitudDelTipoFacturapthisSolicitud != null ? solicitudDelTipoFacturapthisSolicitud.getOid() : null;
    }

    private void checkSolicitudDelTipoFacturapthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudDelTipoFacturapthisSolicitudInstance() == null || this.getSolicitudDelTipoFacturapthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_DELTIPOFACTURA, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_DELTIPOFACTURA_SOLICITUDDELTIPOFACTURAPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_DELTIPOFACTURA, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_DELTIPOFACTURA_SOLICITUDDELTIPOFACTURAPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public TipoFacturaOid getSolicitudDelTipoFacturapevcTipoFactura() {
        return this.solicitudDelTipoFacturapevcTipoFactura;
    }
    
    public void setSolicitudDelTipoFacturapevcTipoFactura(TipoFacturaOid solicitudDelTipoFacturapevcTipoFactura) {
        this.solicitudDelTipoFacturapevcTipoFactura = solicitudDelTipoFacturapevcTipoFactura;
    }

    @JsonIgnore
    public TipoFactura getSolicitudDelTipoFacturapevcTipoFacturaInstance() {
        return this.solicitudDelTipoFacturapevcTipoFacturaInstance;
    }
    
    public void setSolicitudDelTipoFacturapevcTipoFacturaInstance(TipoFactura solicitudDelTipoFacturapevcTipoFactura) {
        this.solicitudDelTipoFacturapevcTipoFacturaInstance = solicitudDelTipoFacturapevcTipoFactura;
        this.solicitudDelTipoFacturapevcTipoFactura = solicitudDelTipoFacturapevcTipoFactura != null ? solicitudDelTipoFacturapevcTipoFactura.getOid() : null;
    }

    private void checkSolicitudDelTipoFacturapevcTipoFactura() throws NotNullArgumentException {
        if(this.getSolicitudDelTipoFacturapevcTipoFacturaInstance() == null || this.getSolicitudDelTipoFacturapevcTipoFacturaInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_DELTIPOFACTURA, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_DELTIPOFACTURA_SOLICITUDDELTIPOFACTURAPEVCTIPOFACTURA, SolicitudConstants.SERV_ALIAS_DELTIPOFACTURA, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_DELTIPOFACTURA_SOLICITUDDELTIPOFACTURAPEVCTIPOFACTURA);
        }
    }
}
