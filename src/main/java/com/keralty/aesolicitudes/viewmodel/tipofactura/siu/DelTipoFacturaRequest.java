package com.keralty.aesolicitudes.viewmodel.tipofactura.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.TipoFacturaConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.oid.TipoFacturaOid;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoFactura;

public class DelTipoFacturaRequest {

    @JsonProperty("p_thistipofactura_oid")
    private TipoFacturaOid tipoFacturaDelTipoFacturapthisTipoFactura;
    
    @JsonIgnore
    private TipoFactura tipoFacturaDelTipoFacturapthisTipoFacturaInstance;

    @JsonProperty("p_evcsolicitud_oid")
    private SolicitudOid tipoFacturaDelTipoFacturapevcSolicitud;
    
    @JsonIgnore
    private Solicitud tipoFacturaDelTipoFacturapevcSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoFacturaDelTipoFacturapthisTipoFactura();
        checkTipoFacturaDelTipoFacturapevcSolicitud();
    }

    @JsonIgnore
    public TipoFacturaOid getTipoFacturaDelTipoFacturapthisTipoFactura() {
        return this.tipoFacturaDelTipoFacturapthisTipoFactura;
    }
    
    public void setTipoFacturaDelTipoFacturapthisTipoFactura(TipoFacturaOid tipoFacturaDelTipoFacturapthisTipoFactura) {
        this.tipoFacturaDelTipoFacturapthisTipoFactura = tipoFacturaDelTipoFacturapthisTipoFactura;
    }

    @JsonIgnore
    public TipoFactura getTipoFacturaDelTipoFacturapthisTipoFacturaInstance() {
        return this.tipoFacturaDelTipoFacturapthisTipoFacturaInstance;
    }
    
    public void setTipoFacturaDelTipoFacturapthisTipoFacturaInstance(TipoFactura tipoFacturaDelTipoFacturapthisTipoFactura) {
        this.tipoFacturaDelTipoFacturapthisTipoFacturaInstance = tipoFacturaDelTipoFacturapthisTipoFactura;
        this.tipoFacturaDelTipoFacturapthisTipoFactura = tipoFacturaDelTipoFacturapthisTipoFactura != null ? tipoFacturaDelTipoFacturapthisTipoFactura.getOid() : null;
    }

    private void checkTipoFacturaDelTipoFacturapthisTipoFactura() throws NotNullArgumentException {
        if(this.getTipoFacturaDelTipoFacturapthisTipoFacturaInstance() == null || this.getTipoFacturaDelTipoFacturapthisTipoFacturaInstance().isNull()) {
            throw new NotNullArgumentException(TipoFacturaConstants.SERV_ID_DELTIPOFACTURA, TipoFacturaConstants.CLASS_ID, TipoFacturaConstants.ARG_ID_DELTIPOFACTURA_TIPOFACTURADELTIPOFACTURAPTHISTIPOFACTURA, TipoFacturaConstants.SERV_ALIAS_DELTIPOFACTURA, TipoFacturaConstants.CLASS_ALIAS, TipoFacturaConstants.ARG_ALIAS_DELTIPOFACTURA_TIPOFACTURADELTIPOFACTURAPTHISTIPOFACTURA);
        }
    }

    @JsonIgnore
    public SolicitudOid getTipoFacturaDelTipoFacturapevcSolicitud() {
        return this.tipoFacturaDelTipoFacturapevcSolicitud;
    }
    
    public void setTipoFacturaDelTipoFacturapevcSolicitud(SolicitudOid tipoFacturaDelTipoFacturapevcSolicitud) {
        this.tipoFacturaDelTipoFacturapevcSolicitud = tipoFacturaDelTipoFacturapevcSolicitud;
    }

    @JsonIgnore
    public Solicitud getTipoFacturaDelTipoFacturapevcSolicitudInstance() {
        return this.tipoFacturaDelTipoFacturapevcSolicitudInstance;
    }
    
    public void setTipoFacturaDelTipoFacturapevcSolicitudInstance(Solicitud tipoFacturaDelTipoFacturapevcSolicitud) {
        this.tipoFacturaDelTipoFacturapevcSolicitudInstance = tipoFacturaDelTipoFacturapevcSolicitud;
        this.tipoFacturaDelTipoFacturapevcSolicitud = tipoFacturaDelTipoFacturapevcSolicitud != null ? tipoFacturaDelTipoFacturapevcSolicitud.getOid() : null;
    }

    private void checkTipoFacturaDelTipoFacturapevcSolicitud() throws NotNullArgumentException {
        if(this.getTipoFacturaDelTipoFacturapevcSolicitudInstance() == null || this.getTipoFacturaDelTipoFacturapevcSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(TipoFacturaConstants.SERV_ID_DELTIPOFACTURA, TipoFacturaConstants.CLASS_ID, TipoFacturaConstants.ARG_ID_DELTIPOFACTURA_TIPOFACTURADELTIPOFACTURAPEVCSOLICITUD, TipoFacturaConstants.SERV_ALIAS_DELTIPOFACTURA, TipoFacturaConstants.CLASS_ALIAS, TipoFacturaConstants.ARG_ALIAS_DELTIPOFACTURA_TIPOFACTURADELTIPOFACTURAPEVCSOLICITUD);
        }
    }
}
