package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.oid.TipoFacturaOid;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoFactura;

public class InsTipoFacturaRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudInsTipoFacturapthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudInsTipoFacturapthisSolicitudInstance;

    @JsonProperty("p_evctipofactura_oid")
    private TipoFacturaOid solicitudInsTipoFacturapevcTipoFactura;
    
    @JsonIgnore
    private TipoFactura solicitudInsTipoFacturapevcTipoFacturaInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudInsTipoFacturapthisSolicitud();
        checkSolicitudInsTipoFacturapevcTipoFactura();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudInsTipoFacturapthisSolicitud() {
        return this.solicitudInsTipoFacturapthisSolicitud;
    }
    
    public void setSolicitudInsTipoFacturapthisSolicitud(SolicitudOid solicitudInsTipoFacturapthisSolicitud) {
        this.solicitudInsTipoFacturapthisSolicitud = solicitudInsTipoFacturapthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudInsTipoFacturapthisSolicitudInstance() {
        return this.solicitudInsTipoFacturapthisSolicitudInstance;
    }
    
    public void setSolicitudInsTipoFacturapthisSolicitudInstance(Solicitud solicitudInsTipoFacturapthisSolicitud) {
        this.solicitudInsTipoFacturapthisSolicitudInstance = solicitudInsTipoFacturapthisSolicitud;
        this.solicitudInsTipoFacturapthisSolicitud = solicitudInsTipoFacturapthisSolicitud != null ? solicitudInsTipoFacturapthisSolicitud.getOid() : null;
    }

    private void checkSolicitudInsTipoFacturapthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudInsTipoFacturapthisSolicitudInstance() == null || this.getSolicitudInsTipoFacturapthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_INSTIPOFACTURA, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_INSTIPOFACTURA_SOLICITUDINSTIPOFACTURAPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_INSTIPOFACTURA, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_INSTIPOFACTURA_SOLICITUDINSTIPOFACTURAPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public TipoFacturaOid getSolicitudInsTipoFacturapevcTipoFactura() {
        return this.solicitudInsTipoFacturapevcTipoFactura;
    }
    
    public void setSolicitudInsTipoFacturapevcTipoFactura(TipoFacturaOid solicitudInsTipoFacturapevcTipoFactura) {
        this.solicitudInsTipoFacturapevcTipoFactura = solicitudInsTipoFacturapevcTipoFactura;
    }

    @JsonIgnore
    public TipoFactura getSolicitudInsTipoFacturapevcTipoFacturaInstance() {
        return this.solicitudInsTipoFacturapevcTipoFacturaInstance;
    }
    
    public void setSolicitudInsTipoFacturapevcTipoFacturaInstance(TipoFactura solicitudInsTipoFacturapevcTipoFactura) {
        this.solicitudInsTipoFacturapevcTipoFacturaInstance = solicitudInsTipoFacturapevcTipoFactura;
        this.solicitudInsTipoFacturapevcTipoFactura = solicitudInsTipoFacturapevcTipoFactura != null ? solicitudInsTipoFacturapevcTipoFactura.getOid() : null;
    }

    private void checkSolicitudInsTipoFacturapevcTipoFactura() throws NotNullArgumentException {
        if(this.getSolicitudInsTipoFacturapevcTipoFacturaInstance() == null || this.getSolicitudInsTipoFacturapevcTipoFacturaInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_INSTIPOFACTURA, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_INSTIPOFACTURA_SOLICITUDINSTIPOFACTURAPEVCTIPOFACTURA, SolicitudConstants.SERV_ALIAS_INSTIPOFACTURA, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_INSTIPOFACTURA_SOLICITUDINSTIPOFACTURAPEVCTIPOFACTURA);
        }
    }
}
