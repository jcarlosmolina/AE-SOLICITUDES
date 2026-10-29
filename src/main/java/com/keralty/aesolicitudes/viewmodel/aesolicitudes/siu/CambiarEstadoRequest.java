package com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.AesolicitudesConstants;
import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.oid.AesolicitudesOid;

public class CambiarEstadoRequest {

    @JsonProperty("p_thisae_solicitudes_oid")
    private AesolicitudesOid aesolicitudescambiarEstadopthisAESOLICITUDES;
    
    @JsonIgnore
    private Aesolicitudes aesolicitudescambiarEstadopthisAESOLICITUDESInstance;

    @JsonProperty("p_sw_estado")
    private String aesolicitudescambiarEstadopSWESTADO;

    public void checkArguments() throws NotNullArgumentException {
        checkAesolicitudescambiarEstadopthisAESOLICITUDES();
    }

    @JsonIgnore
    public AesolicitudesOid getAesolicitudescambiarEstadopthisAESOLICITUDES() {
        return this.aesolicitudescambiarEstadopthisAESOLICITUDES;
    }
    
    public void setAesolicitudescambiarEstadopthisAESOLICITUDES(AesolicitudesOid aesolicitudescambiarEstadopthisAESOLICITUDES) {
        this.aesolicitudescambiarEstadopthisAESOLICITUDES = aesolicitudescambiarEstadopthisAESOLICITUDES;
    }

    @JsonIgnore
    public Aesolicitudes getAesolicitudescambiarEstadopthisAESOLICITUDESInstance() {
        return this.aesolicitudescambiarEstadopthisAESOLICITUDESInstance;
    }
    
    public void setAesolicitudescambiarEstadopthisAESOLICITUDESInstance(Aesolicitudes aesolicitudescambiarEstadopthisAESOLICITUDES) {
        this.aesolicitudescambiarEstadopthisAESOLICITUDESInstance = aesolicitudescambiarEstadopthisAESOLICITUDES;
        this.aesolicitudescambiarEstadopthisAESOLICITUDES = aesolicitudescambiarEstadopthisAESOLICITUDES != null ? aesolicitudescambiarEstadopthisAESOLICITUDES.getOid() : null;
    }

    private void checkAesolicitudescambiarEstadopthisAESOLICITUDES() throws NotNullArgumentException {
        if(this.getAesolicitudescambiarEstadopthisAESOLICITUDESInstance() == null || this.getAesolicitudescambiarEstadopthisAESOLICITUDESInstance().isNull()) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_CAMBIARESTADO, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_CAMBIARESTADO_AESOLICITUDESCAMBIARESTADOPTHISAESOLICITUDES, AesolicitudesConstants.SERV_ALIAS_CAMBIARESTADO, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_CAMBIARESTADO_AESOLICITUDESCAMBIARESTADOPTHISAESOLICITUDES);
        }
    }

    @JsonIgnore
    public String getAesolicitudescambiarEstadopSWESTADO() {
        return this.aesolicitudescambiarEstadopSWESTADO;
    }
    
    public void setAesolicitudescambiarEstadopSWESTADO(String aesolicitudescambiarEstadopSWESTADO) {
        this.aesolicitudescambiarEstadopSWESTADO = aesolicitudescambiarEstadopSWESTADO;
    }
}
