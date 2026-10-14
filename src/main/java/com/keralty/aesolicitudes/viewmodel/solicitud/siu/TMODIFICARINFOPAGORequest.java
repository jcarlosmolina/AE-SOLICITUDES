package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.FormaPago;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Periodicidad;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TMODIFICARINFOPAGORequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTMODIFICARINFOPAGOpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTMODIFICARINFOPAGOpthisSolicitudInstance;

    @JsonProperty("pt_p_evcperiodicidad_json")
    private String solicitudTMODIFICARINFOPAGOptpevcPeriodicidad;
    
    @JsonIgnore
    private Periodicidad solicitudTMODIFICARINFOPAGOptpevcPeriodicidadInstance;

    @JsonProperty("pt_p_evcformapago_json")
    private String solicitudTMODIFICARINFOPAGOptpevcFormaPago;
    
    @JsonIgnore
    private FormaPago solicitudTMODIFICARINFOPAGOptpevcFormaPagoInstance;

    @JsonProperty("pt_p_valorcuota")
    private Long solicitudTMODIFICARINFOPAGOptpvalorCuota;

    @JsonProperty("pt_p_valordtocomercialsim")
    private Long solicitudTMODIFICARINFOPAGOptpvalorDtoComercialSim;

    @JsonProperty("pt_p_valordtofinanciero")
    private Long solicitudTMODIFICARINFOPAGOptpValorDtoFinanciero;

    @JsonProperty("p_valorcuotainscripcion")
    private Long solicitudTMODIFICARINFOPAGOpValorCuotaInscripcion;

    @JsonProperty("p_subtotal")
    private Long solicitudTMODIFICARINFOPAGOpSubtotal;

    @JsonProperty("p_basegrabable")
    private Long solicitudTMODIFICARINFOPAGOpBaseGrabable;

    @JsonProperty("p_porceniva")
    private Double solicitudTMODIFICARINFOPAGOpPorcenIVA;

    @JsonProperty("p_iva")
    private Long solicitudTMODIFICARINFOPAGOpIVA;

    @JsonProperty("p_total")
    private Long solicitudTMODIFICARINFOPAGOpTotal;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTMODIFICARINFOPAGOpthisSolicitud();
        checkSolicitudTMODIFICARINFOPAGOptpevcPeriodicidad();
        checkSolicitudTMODIFICARINFOPAGOptpevcFormaPago();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTMODIFICARINFOPAGOpthisSolicitud() {
        return this.solicitudTMODIFICARINFOPAGOpthisSolicitud;
    }
    
    public void setSolicitudTMODIFICARINFOPAGOpthisSolicitud(SolicitudOid solicitudTMODIFICARINFOPAGOpthisSolicitud) {
        this.solicitudTMODIFICARINFOPAGOpthisSolicitud = solicitudTMODIFICARINFOPAGOpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTMODIFICARINFOPAGOpthisSolicitudInstance() {
        return this.solicitudTMODIFICARINFOPAGOpthisSolicitudInstance;
    }
    
    public void setSolicitudTMODIFICARINFOPAGOpthisSolicitudInstance(Solicitud solicitudTMODIFICARINFOPAGOpthisSolicitud) {
        this.solicitudTMODIFICARINFOPAGOpthisSolicitudInstance = solicitudTMODIFICARINFOPAGOpthisSolicitud;
        this.solicitudTMODIFICARINFOPAGOpthisSolicitud = solicitudTMODIFICARINFOPAGOpthisSolicitud != null ? solicitudTMODIFICARINFOPAGOpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTMODIFICARINFOPAGOpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTMODIFICARINFOPAGOpthisSolicitudInstance() == null || this.getSolicitudTMODIFICARINFOPAGOpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TMODIFICARINFOPAGO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TMODIFICARINFOPAGO_SOLICITUDTMODIFICARINFOPAGOPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TMODIFICARINFOPAGO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TMODIFICARINFOPAGO_SOLICITUDTMODIFICARINFOPAGOPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudTMODIFICARINFOPAGOptpevcPeriodicidad() {
        return this.solicitudTMODIFICARINFOPAGOptpevcPeriodicidad;
    }
    
    public void setSolicitudTMODIFICARINFOPAGOptpevcPeriodicidad(String solicitudTMODIFICARINFOPAGOptpevcPeriodicidad) {
        this.solicitudTMODIFICARINFOPAGOptpevcPeriodicidad = solicitudTMODIFICARINFOPAGOptpevcPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getSolicitudTMODIFICARINFOPAGOptpevcPeriodicidadInstance() {
        return this.solicitudTMODIFICARINFOPAGOptpevcPeriodicidadInstance;
    }
    
    public void setSolicitudTMODIFICARINFOPAGOptpevcPeriodicidadInstance(Periodicidad solicitudTMODIFICARINFOPAGOptpevcPeriodicidad) {
        this.solicitudTMODIFICARINFOPAGOptpevcPeriodicidadInstance = solicitudTMODIFICARINFOPAGOptpevcPeriodicidad;
        this.solicitudTMODIFICARINFOPAGOptpevcPeriodicidad = solicitudTMODIFICARINFOPAGOptpevcPeriodicidad != null ? solicitudTMODIFICARINFOPAGOptpevcPeriodicidad.getOid().toJson() : "";
    }

    private void checkSolicitudTMODIFICARINFOPAGOptpevcPeriodicidad() throws NotNullArgumentException {
        if(this.getSolicitudTMODIFICARINFOPAGOptpevcPeriodicidadInstance() == null || this.getSolicitudTMODIFICARINFOPAGOptpevcPeriodicidadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TMODIFICARINFOPAGO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TMODIFICARINFOPAGO_SOLICITUDTMODIFICARINFOPAGOPTPEVCPERIODICIDAD, SolicitudConstants.SERV_ALIAS_TMODIFICARINFOPAGO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TMODIFICARINFOPAGO_SOLICITUDTMODIFICARINFOPAGOPTPEVCPERIODICIDAD);
        }
    }

    @JsonIgnore
    public String getSolicitudTMODIFICARINFOPAGOptpevcFormaPago() {
        return this.solicitudTMODIFICARINFOPAGOptpevcFormaPago;
    }
    
    public void setSolicitudTMODIFICARINFOPAGOptpevcFormaPago(String solicitudTMODIFICARINFOPAGOptpevcFormaPago) {
        this.solicitudTMODIFICARINFOPAGOptpevcFormaPago = solicitudTMODIFICARINFOPAGOptpevcFormaPago;
    }

    @JsonIgnore
    public FormaPago getSolicitudTMODIFICARINFOPAGOptpevcFormaPagoInstance() {
        return this.solicitudTMODIFICARINFOPAGOptpevcFormaPagoInstance;
    }
    
    public void setSolicitudTMODIFICARINFOPAGOptpevcFormaPagoInstance(FormaPago solicitudTMODIFICARINFOPAGOptpevcFormaPago) {
        this.solicitudTMODIFICARINFOPAGOptpevcFormaPagoInstance = solicitudTMODIFICARINFOPAGOptpevcFormaPago;
        this.solicitudTMODIFICARINFOPAGOptpevcFormaPago = solicitudTMODIFICARINFOPAGOptpevcFormaPago != null ? solicitudTMODIFICARINFOPAGOptpevcFormaPago.getOid().toJson() : "";
    }

    private void checkSolicitudTMODIFICARINFOPAGOptpevcFormaPago() throws NotNullArgumentException {
        if(this.getSolicitudTMODIFICARINFOPAGOptpevcFormaPagoInstance() == null || this.getSolicitudTMODIFICARINFOPAGOptpevcFormaPagoInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TMODIFICARINFOPAGO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TMODIFICARINFOPAGO_SOLICITUDTMODIFICARINFOPAGOPTPEVCFORMAPAGO, SolicitudConstants.SERV_ALIAS_TMODIFICARINFOPAGO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TMODIFICARINFOPAGO_SOLICITUDTMODIFICARINFOPAGOPTPEVCFORMAPAGO);
        }
    }

    @JsonIgnore
    public Long getSolicitudTMODIFICARINFOPAGOptpvalorCuota() {
        return this.solicitudTMODIFICARINFOPAGOptpvalorCuota;
    }
    
    public void setSolicitudTMODIFICARINFOPAGOptpvalorCuota(Long solicitudTMODIFICARINFOPAGOptpvalorCuota) {
        this.solicitudTMODIFICARINFOPAGOptpvalorCuota = solicitudTMODIFICARINFOPAGOptpvalorCuota;
    }

    @JsonIgnore
    public Long getSolicitudTMODIFICARINFOPAGOptpvalorDtoComercialSim() {
        return this.solicitudTMODIFICARINFOPAGOptpvalorDtoComercialSim;
    }
    
    public void setSolicitudTMODIFICARINFOPAGOptpvalorDtoComercialSim(Long solicitudTMODIFICARINFOPAGOptpvalorDtoComercialSim) {
        this.solicitudTMODIFICARINFOPAGOptpvalorDtoComercialSim = solicitudTMODIFICARINFOPAGOptpvalorDtoComercialSim;
    }

    @JsonIgnore
    public Long getSolicitudTMODIFICARINFOPAGOptpValorDtoFinanciero() {
        return this.solicitudTMODIFICARINFOPAGOptpValorDtoFinanciero;
    }
    
    public void setSolicitudTMODIFICARINFOPAGOptpValorDtoFinanciero(Long solicitudTMODIFICARINFOPAGOptpValorDtoFinanciero) {
        this.solicitudTMODIFICARINFOPAGOptpValorDtoFinanciero = solicitudTMODIFICARINFOPAGOptpValorDtoFinanciero;
    }

    @JsonIgnore
    public Long getSolicitudTMODIFICARINFOPAGOpValorCuotaInscripcion() {
        return this.solicitudTMODIFICARINFOPAGOpValorCuotaInscripcion;
    }
    
    public void setSolicitudTMODIFICARINFOPAGOpValorCuotaInscripcion(Long solicitudTMODIFICARINFOPAGOpValorCuotaInscripcion) {
        this.solicitudTMODIFICARINFOPAGOpValorCuotaInscripcion = solicitudTMODIFICARINFOPAGOpValorCuotaInscripcion;
    }

    @JsonIgnore
    public Long getSolicitudTMODIFICARINFOPAGOpSubtotal() {
        return this.solicitudTMODIFICARINFOPAGOpSubtotal;
    }
    
    public void setSolicitudTMODIFICARINFOPAGOpSubtotal(Long solicitudTMODIFICARINFOPAGOpSubtotal) {
        this.solicitudTMODIFICARINFOPAGOpSubtotal = solicitudTMODIFICARINFOPAGOpSubtotal;
    }

    @JsonIgnore
    public Long getSolicitudTMODIFICARINFOPAGOpBaseGrabable() {
        return this.solicitudTMODIFICARINFOPAGOpBaseGrabable;
    }
    
    public void setSolicitudTMODIFICARINFOPAGOpBaseGrabable(Long solicitudTMODIFICARINFOPAGOpBaseGrabable) {
        this.solicitudTMODIFICARINFOPAGOpBaseGrabable = solicitudTMODIFICARINFOPAGOpBaseGrabable;
    }

    @JsonIgnore
    public Double getSolicitudTMODIFICARINFOPAGOpPorcenIVA() {
        return this.solicitudTMODIFICARINFOPAGOpPorcenIVA;
    }
    
    public void setSolicitudTMODIFICARINFOPAGOpPorcenIVA(Double solicitudTMODIFICARINFOPAGOpPorcenIVA) {
        this.solicitudTMODIFICARINFOPAGOpPorcenIVA = solicitudTMODIFICARINFOPAGOpPorcenIVA;
    }

    @JsonIgnore
    public Long getSolicitudTMODIFICARINFOPAGOpIVA() {
        return this.solicitudTMODIFICARINFOPAGOpIVA;
    }
    
    public void setSolicitudTMODIFICARINFOPAGOpIVA(Long solicitudTMODIFICARINFOPAGOpIVA) {
        this.solicitudTMODIFICARINFOPAGOpIVA = solicitudTMODIFICARINFOPAGOpIVA;
    }

    @JsonIgnore
    public Long getSolicitudTMODIFICARINFOPAGOpTotal() {
        return this.solicitudTMODIFICARINFOPAGOpTotal;
    }
    
    public void setSolicitudTMODIFICARINFOPAGOpTotal(Long solicitudTMODIFICARINFOPAGOpTotal) {
        this.solicitudTMODIFICARINFOPAGOpTotal = solicitudTMODIFICARINFOPAGOpTotal;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
