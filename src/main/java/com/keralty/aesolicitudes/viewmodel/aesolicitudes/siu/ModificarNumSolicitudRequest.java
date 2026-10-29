package com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.AesolicitudesConstants;
import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.oid.AesolicitudesOid;

public class ModificarNumSolicitudRequest {

    @JsonProperty("p_thisae_solicitudes_oid")
    private AesolicitudesOid aesolicitudesmodificarNumSolicitudpthisAESOLICITUDES;
    
    @JsonIgnore
    private Aesolicitudes aesolicitudesmodificarNumSolicitudpthisAESOLICITUDESInstance;

    @JsonProperty("p_numero_solicitud")
    private String aesolicitudesmodificarNumSolicitudpNUMEROSOLICITUD;

    public void checkArguments() throws NotNullArgumentException {
        checkAesolicitudesmodificarNumSolicitudpthisAESOLICITUDES();
        checkAesolicitudesmodificarNumSolicitudpNUMEROSOLICITUD();
    }

    @JsonIgnore
    public AesolicitudesOid getAesolicitudesmodificarNumSolicitudpthisAESOLICITUDES() {
        return this.aesolicitudesmodificarNumSolicitudpthisAESOLICITUDES;
    }
    
    public void setAesolicitudesmodificarNumSolicitudpthisAESOLICITUDES(AesolicitudesOid aesolicitudesmodificarNumSolicitudpthisAESOLICITUDES) {
        this.aesolicitudesmodificarNumSolicitudpthisAESOLICITUDES = aesolicitudesmodificarNumSolicitudpthisAESOLICITUDES;
    }

    @JsonIgnore
    public Aesolicitudes getAesolicitudesmodificarNumSolicitudpthisAESOLICITUDESInstance() {
        return this.aesolicitudesmodificarNumSolicitudpthisAESOLICITUDESInstance;
    }
    
    public void setAesolicitudesmodificarNumSolicitudpthisAESOLICITUDESInstance(Aesolicitudes aesolicitudesmodificarNumSolicitudpthisAESOLICITUDES) {
        this.aesolicitudesmodificarNumSolicitudpthisAESOLICITUDESInstance = aesolicitudesmodificarNumSolicitudpthisAESOLICITUDES;
        this.aesolicitudesmodificarNumSolicitudpthisAESOLICITUDES = aesolicitudesmodificarNumSolicitudpthisAESOLICITUDES != null ? aesolicitudesmodificarNumSolicitudpthisAESOLICITUDES.getOid() : null;
    }

    private void checkAesolicitudesmodificarNumSolicitudpthisAESOLICITUDES() throws NotNullArgumentException {
        if(this.getAesolicitudesmodificarNumSolicitudpthisAESOLICITUDESInstance() == null || this.getAesolicitudesmodificarNumSolicitudpthisAESOLICITUDESInstance().isNull()) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_MODIFICARNUMSOLICITUD, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_MODIFICARNUMSOLICITUD_AESOLICITUDESMODIFICARNUMSOLICITUDPTHISAESOLICITUDES, AesolicitudesConstants.SERV_ALIAS_MODIFICARNUMSOLICITUD, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_MODIFICARNUMSOLICITUD_AESOLICITUDESMODIFICARNUMSOLICITUDPTHISAESOLICITUDES);
        }
    }

    @JsonIgnore
    public String getAesolicitudesmodificarNumSolicitudpNUMEROSOLICITUD() {
        return this.aesolicitudesmodificarNumSolicitudpNUMEROSOLICITUD;
    }
    
    public void setAesolicitudesmodificarNumSolicitudpNUMEROSOLICITUD(String aesolicitudesmodificarNumSolicitudpNUMEROSOLICITUD) {
        this.aesolicitudesmodificarNumSolicitudpNUMEROSOLICITUD = aesolicitudesmodificarNumSolicitudpNUMEROSOLICITUD;
    }

    private void checkAesolicitudesmodificarNumSolicitudpNUMEROSOLICITUD() throws NotNullArgumentException {
        if(this.getAesolicitudesmodificarNumSolicitudpNUMEROSOLICITUD() == null) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_MODIFICARNUMSOLICITUD, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_MODIFICARNUMSOLICITUD_AESOLICITUDESMODIFICARNUMSOLICITUDPNUMEROSOLICITUD, AesolicitudesConstants.SERV_ALIAS_MODIFICARNUMSOLICITUD, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_MODIFICARNUMSOLICITUD_AESOLICITUDESMODIFICARNUMSOLICITUDPNUMEROSOLICITUD);
        }
    }
}
