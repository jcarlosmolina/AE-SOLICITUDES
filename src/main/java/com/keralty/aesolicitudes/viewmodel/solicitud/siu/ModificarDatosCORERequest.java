package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class ModificarDatosCORERequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudmodificarDatosCOREpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudmodificarDatosCOREpthisSolicitudInstance;

    @JsonProperty("p_numcontrato")
    private String solicitudmodificarDatosCOREpNumContrato;

    @JsonProperty("p_valorcuotaperiodoc")
    private Double solicitudmodificarDatosCOREpvalorCuotaPeriodoC;

    @JsonProperty("p_descuentocomercialc")
    private Double solicitudmodificarDatosCOREpdescuentoComercialC;

    @JsonProperty("p_ivac")
    private Double solicitudmodificarDatosCOREpIVAC;

    @JsonProperty("p_descuentofinancieroc")
    private Double solicitudmodificarDatosCOREpdescuentoFinancieroC;

    @JsonProperty("p_valorcuotabrutac")
    private Double solicitudmodificarDatosCOREpvalorCuotaBrutaC;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudmodificarDatosCOREpthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudmodificarDatosCOREpthisSolicitud() {
        return this.solicitudmodificarDatosCOREpthisSolicitud;
    }
    
    public void setSolicitudmodificarDatosCOREpthisSolicitud(SolicitudOid solicitudmodificarDatosCOREpthisSolicitud) {
        this.solicitudmodificarDatosCOREpthisSolicitud = solicitudmodificarDatosCOREpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudmodificarDatosCOREpthisSolicitudInstance() {
        return this.solicitudmodificarDatosCOREpthisSolicitudInstance;
    }
    
    public void setSolicitudmodificarDatosCOREpthisSolicitudInstance(Solicitud solicitudmodificarDatosCOREpthisSolicitud) {
        this.solicitudmodificarDatosCOREpthisSolicitudInstance = solicitudmodificarDatosCOREpthisSolicitud;
        this.solicitudmodificarDatosCOREpthisSolicitud = solicitudmodificarDatosCOREpthisSolicitud != null ? solicitudmodificarDatosCOREpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudmodificarDatosCOREpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudmodificarDatosCOREpthisSolicitudInstance() == null || this.getSolicitudmodificarDatosCOREpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_MODIFICARDATOSCORE, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_MODIFICARDATOSCORE_SOLICITUDMODIFICARDATOSCOREPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_MODIFICARDATOSCORE, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_MODIFICARDATOSCORE_SOLICITUDMODIFICARDATOSCOREPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudmodificarDatosCOREpNumContrato() {
        return this.solicitudmodificarDatosCOREpNumContrato;
    }
    
    public void setSolicitudmodificarDatosCOREpNumContrato(String solicitudmodificarDatosCOREpNumContrato) {
        this.solicitudmodificarDatosCOREpNumContrato = solicitudmodificarDatosCOREpNumContrato;
    }

    @JsonIgnore
    public Double getSolicitudmodificarDatosCOREpvalorCuotaPeriodoC() {
        return this.solicitudmodificarDatosCOREpvalorCuotaPeriodoC;
    }
    
    public void setSolicitudmodificarDatosCOREpvalorCuotaPeriodoC(Double solicitudmodificarDatosCOREpvalorCuotaPeriodoC) {
        this.solicitudmodificarDatosCOREpvalorCuotaPeriodoC = solicitudmodificarDatosCOREpvalorCuotaPeriodoC;
    }

    @JsonIgnore
    public Double getSolicitudmodificarDatosCOREpdescuentoComercialC() {
        return this.solicitudmodificarDatosCOREpdescuentoComercialC;
    }
    
    public void setSolicitudmodificarDatosCOREpdescuentoComercialC(Double solicitudmodificarDatosCOREpdescuentoComercialC) {
        this.solicitudmodificarDatosCOREpdescuentoComercialC = solicitudmodificarDatosCOREpdescuentoComercialC;
    }

    @JsonIgnore
    public Double getSolicitudmodificarDatosCOREpIVAC() {
        return this.solicitudmodificarDatosCOREpIVAC;
    }
    
    public void setSolicitudmodificarDatosCOREpIVAC(Double solicitudmodificarDatosCOREpIVAC) {
        this.solicitudmodificarDatosCOREpIVAC = solicitudmodificarDatosCOREpIVAC;
    }

    @JsonIgnore
    public Double getSolicitudmodificarDatosCOREpdescuentoFinancieroC() {
        return this.solicitudmodificarDatosCOREpdescuentoFinancieroC;
    }
    
    public void setSolicitudmodificarDatosCOREpdescuentoFinancieroC(Double solicitudmodificarDatosCOREpdescuentoFinancieroC) {
        this.solicitudmodificarDatosCOREpdescuentoFinancieroC = solicitudmodificarDatosCOREpdescuentoFinancieroC;
    }

    @JsonIgnore
    public Double getSolicitudmodificarDatosCOREpvalorCuotaBrutaC() {
        return this.solicitudmodificarDatosCOREpvalorCuotaBrutaC;
    }
    
    public void setSolicitudmodificarDatosCOREpvalorCuotaBrutaC(Double solicitudmodificarDatosCOREpvalorCuotaBrutaC) {
        this.solicitudmodificarDatosCOREpvalorCuotaBrutaC = solicitudmodificarDatosCOREpvalorCuotaBrutaC;
    }
}
