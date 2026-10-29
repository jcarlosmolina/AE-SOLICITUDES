package com.keralty.aesolicitudes.viewmodel.tipofactura.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.TipoFacturaConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.oid.TipoFacturaOid;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoFactura;

public class InsTipoFacturaRequest {

    @JsonProperty("p_thistipofactura_oid")
    private TipoFacturaOid tipoFacturaInsTipoFacturapthisTipoFactura;
    
    @JsonIgnore
    private TipoFactura tipoFacturaInsTipoFacturapthisTipoFacturaInstance;

    @JsonProperty("p_evcsolicitud_oid")
    private SolicitudOid tipoFacturaInsTipoFacturapevcSolicitud;
    
    @JsonIgnore
    private Solicitud tipoFacturaInsTipoFacturapevcSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoFacturaInsTipoFacturapthisTipoFactura();
        checkTipoFacturaInsTipoFacturapevcSolicitud();
    }

    @JsonIgnore
    public TipoFacturaOid getTipoFacturaInsTipoFacturapthisTipoFactura() {
        return this.tipoFacturaInsTipoFacturapthisTipoFactura;
    }
    
    public void setTipoFacturaInsTipoFacturapthisTipoFactura(TipoFacturaOid tipoFacturaInsTipoFacturapthisTipoFactura) {
        this.tipoFacturaInsTipoFacturapthisTipoFactura = tipoFacturaInsTipoFacturapthisTipoFactura;
    }

    @JsonIgnore
    public TipoFactura getTipoFacturaInsTipoFacturapthisTipoFacturaInstance() {
        return this.tipoFacturaInsTipoFacturapthisTipoFacturaInstance;
    }
    
    public void setTipoFacturaInsTipoFacturapthisTipoFacturaInstance(TipoFactura tipoFacturaInsTipoFacturapthisTipoFactura) {
        this.tipoFacturaInsTipoFacturapthisTipoFacturaInstance = tipoFacturaInsTipoFacturapthisTipoFactura;
        this.tipoFacturaInsTipoFacturapthisTipoFactura = tipoFacturaInsTipoFacturapthisTipoFactura != null ? tipoFacturaInsTipoFacturapthisTipoFactura.getOid() : null;
    }

    private void checkTipoFacturaInsTipoFacturapthisTipoFactura() throws NotNullArgumentException {
        if(this.getTipoFacturaInsTipoFacturapthisTipoFacturaInstance() == null || this.getTipoFacturaInsTipoFacturapthisTipoFacturaInstance().isNull()) {
            throw new NotNullArgumentException(TipoFacturaConstants.SERV_ID_INSTIPOFACTURA, TipoFacturaConstants.CLASS_ID, TipoFacturaConstants.ARG_ID_INSTIPOFACTURA_TIPOFACTURAINSTIPOFACTURAPTHISTIPOFACTURA, TipoFacturaConstants.SERV_ALIAS_INSTIPOFACTURA, TipoFacturaConstants.CLASS_ALIAS, TipoFacturaConstants.ARG_ALIAS_INSTIPOFACTURA_TIPOFACTURAINSTIPOFACTURAPTHISTIPOFACTURA);
        }
    }

    @JsonIgnore
    public SolicitudOid getTipoFacturaInsTipoFacturapevcSolicitud() {
        return this.tipoFacturaInsTipoFacturapevcSolicitud;
    }
    
    public void setTipoFacturaInsTipoFacturapevcSolicitud(SolicitudOid tipoFacturaInsTipoFacturapevcSolicitud) {
        this.tipoFacturaInsTipoFacturapevcSolicitud = tipoFacturaInsTipoFacturapevcSolicitud;
    }

    @JsonIgnore
    public Solicitud getTipoFacturaInsTipoFacturapevcSolicitudInstance() {
        return this.tipoFacturaInsTipoFacturapevcSolicitudInstance;
    }
    
    public void setTipoFacturaInsTipoFacturapevcSolicitudInstance(Solicitud tipoFacturaInsTipoFacturapevcSolicitud) {
        this.tipoFacturaInsTipoFacturapevcSolicitudInstance = tipoFacturaInsTipoFacturapevcSolicitud;
        this.tipoFacturaInsTipoFacturapevcSolicitud = tipoFacturaInsTipoFacturapevcSolicitud != null ? tipoFacturaInsTipoFacturapevcSolicitud.getOid() : null;
    }

    private void checkTipoFacturaInsTipoFacturapevcSolicitud() throws NotNullArgumentException {
        if(this.getTipoFacturaInsTipoFacturapevcSolicitudInstance() == null || this.getTipoFacturaInsTipoFacturapevcSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(TipoFacturaConstants.SERV_ID_INSTIPOFACTURA, TipoFacturaConstants.CLASS_ID, TipoFacturaConstants.ARG_ID_INSTIPOFACTURA_TIPOFACTURAINSTIPOFACTURAPEVCSOLICITUD, TipoFacturaConstants.SERV_ALIAS_INSTIPOFACTURA, TipoFacturaConstants.CLASS_ALIAS, TipoFacturaConstants.ARG_ALIAS_INSTIPOFACTURA_TIPOFACTURAINSTIPOFACTURAPEVCSOLICITUD);
        }
    }
}
