package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class CalcularURLPasarelaPagosRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudcalcularURLPasarelaPagospthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudcalcularURLPasarelaPagospthisSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudcalcularURLPasarelaPagospthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudcalcularURLPasarelaPagospthisSolicitud() {
        return this.solicitudcalcularURLPasarelaPagospthisSolicitud;
    }
    
    public void setSolicitudcalcularURLPasarelaPagospthisSolicitud(SolicitudOid solicitudcalcularURLPasarelaPagospthisSolicitud) {
        this.solicitudcalcularURLPasarelaPagospthisSolicitud = solicitudcalcularURLPasarelaPagospthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudcalcularURLPasarelaPagospthisSolicitudInstance() {
        return this.solicitudcalcularURLPasarelaPagospthisSolicitudInstance;
    }
    
    public void setSolicitudcalcularURLPasarelaPagospthisSolicitudInstance(Solicitud solicitudcalcularURLPasarelaPagospthisSolicitud) {
        this.solicitudcalcularURLPasarelaPagospthisSolicitudInstance = solicitudcalcularURLPasarelaPagospthisSolicitud;
        this.solicitudcalcularURLPasarelaPagospthisSolicitud = solicitudcalcularURLPasarelaPagospthisSolicitud != null ? solicitudcalcularURLPasarelaPagospthisSolicitud.getOid() : null;
    }

    private void checkSolicitudcalcularURLPasarelaPagospthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudcalcularURLPasarelaPagospthisSolicitudInstance() == null || this.getSolicitudcalcularURLPasarelaPagospthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_CALCULARURLPASARELAPAGOS, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_CALCULARURLPASARELAPAGOS_SOLICITUDCALCULARURLPASARELAPAGOSPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_CALCULARURLPASARELAPAGOS, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_CALCULARURLPASARELAPAGOS_SOLICITUDCALCULARURLPASARELAPAGOSPTHISSOLICITUD);
        }
    }
}
