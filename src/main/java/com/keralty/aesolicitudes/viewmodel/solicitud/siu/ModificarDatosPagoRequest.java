package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class ModificarDatosPagoRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudmodificarDatosPagopthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudmodificarDatosPagopthisSolicitudInstance;

    @JsonProperty("p_valorcuota")
    private Double solicitudmodificarDatosPagopvalorCuota;

    @JsonProperty("p_valordtocomercialsim")
    private Double solicitudmodificarDatosPagopvalorDtoComercialSim;

    @JsonProperty("p_valordtofinanciero")
    private Double solicitudmodificarDatosPagopValorDtoFinanciero;

    @JsonProperty("pevalorcuotainscripcion")
    private Double solicitudmodificarDatosPagopeValorCuotaInscripcion;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudmodificarDatosPagopthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudmodificarDatosPagopthisSolicitud() {
        return this.solicitudmodificarDatosPagopthisSolicitud;
    }
    
    public void setSolicitudmodificarDatosPagopthisSolicitud(SolicitudOid solicitudmodificarDatosPagopthisSolicitud) {
        this.solicitudmodificarDatosPagopthisSolicitud = solicitudmodificarDatosPagopthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudmodificarDatosPagopthisSolicitudInstance() {
        return this.solicitudmodificarDatosPagopthisSolicitudInstance;
    }
    
    public void setSolicitudmodificarDatosPagopthisSolicitudInstance(Solicitud solicitudmodificarDatosPagopthisSolicitud) {
        this.solicitudmodificarDatosPagopthisSolicitudInstance = solicitudmodificarDatosPagopthisSolicitud;
        this.solicitudmodificarDatosPagopthisSolicitud = solicitudmodificarDatosPagopthisSolicitud != null ? solicitudmodificarDatosPagopthisSolicitud.getOid() : null;
    }

    private void checkSolicitudmodificarDatosPagopthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudmodificarDatosPagopthisSolicitudInstance() == null || this.getSolicitudmodificarDatosPagopthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_MODIFICARDATOSPAGO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_MODIFICARDATOSPAGO_SOLICITUDMODIFICARDATOSPAGOPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_MODIFICARDATOSPAGO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_MODIFICARDATOSPAGO_SOLICITUDMODIFICARDATOSPAGOPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public Double getSolicitudmodificarDatosPagopvalorCuota() {
        return this.solicitudmodificarDatosPagopvalorCuota;
    }
    
    public void setSolicitudmodificarDatosPagopvalorCuota(Double solicitudmodificarDatosPagopvalorCuota) {
        this.solicitudmodificarDatosPagopvalorCuota = solicitudmodificarDatosPagopvalorCuota;
    }

    @JsonIgnore
    public Double getSolicitudmodificarDatosPagopvalorDtoComercialSim() {
        return this.solicitudmodificarDatosPagopvalorDtoComercialSim;
    }
    
    public void setSolicitudmodificarDatosPagopvalorDtoComercialSim(Double solicitudmodificarDatosPagopvalorDtoComercialSim) {
        this.solicitudmodificarDatosPagopvalorDtoComercialSim = solicitudmodificarDatosPagopvalorDtoComercialSim;
    }

    @JsonIgnore
    public Double getSolicitudmodificarDatosPagopValorDtoFinanciero() {
        return this.solicitudmodificarDatosPagopValorDtoFinanciero;
    }
    
    public void setSolicitudmodificarDatosPagopValorDtoFinanciero(Double solicitudmodificarDatosPagopValorDtoFinanciero) {
        this.solicitudmodificarDatosPagopValorDtoFinanciero = solicitudmodificarDatosPagopValorDtoFinanciero;
    }

    @JsonIgnore
    public Double getSolicitudmodificarDatosPagopeValorCuotaInscripcion() {
        return this.solicitudmodificarDatosPagopeValorCuotaInscripcion;
    }
    
    public void setSolicitudmodificarDatosPagopeValorCuotaInscripcion(Double solicitudmodificarDatosPagopeValorCuotaInscripcion) {
        this.solicitudmodificarDatosPagopeValorCuotaInscripcion = solicitudmodificarDatosPagopeValorCuotaInscripcion;
    }
}
