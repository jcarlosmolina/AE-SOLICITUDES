package com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.AesolicitudesConstants;
import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.oid.AesolicitudesOid;

public class EliminarRequest {

    @JsonProperty("p_thisae_solicitudes_oid")
    private AesolicitudesOid aesolicitudeseliminarpthisAESOLICITUDES;
    
    @JsonIgnore
    private Aesolicitudes aesolicitudeseliminarpthisAESOLICITUDESInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAesolicitudeseliminarpthisAESOLICITUDES();
    }

    @JsonIgnore
    public AesolicitudesOid getAesolicitudeseliminarpthisAESOLICITUDES() {
        return this.aesolicitudeseliminarpthisAESOLICITUDES;
    }
    
    public void setAesolicitudeseliminarpthisAESOLICITUDES(AesolicitudesOid aesolicitudeseliminarpthisAESOLICITUDES) {
        this.aesolicitudeseliminarpthisAESOLICITUDES = aesolicitudeseliminarpthisAESOLICITUDES;
    }

    @JsonIgnore
    public Aesolicitudes getAesolicitudeseliminarpthisAESOLICITUDESInstance() {
        return this.aesolicitudeseliminarpthisAESOLICITUDESInstance;
    }
    
    public void setAesolicitudeseliminarpthisAESOLICITUDESInstance(Aesolicitudes aesolicitudeseliminarpthisAESOLICITUDES) {
        this.aesolicitudeseliminarpthisAESOLICITUDESInstance = aesolicitudeseliminarpthisAESOLICITUDES;
        this.aesolicitudeseliminarpthisAESOLICITUDES = aesolicitudeseliminarpthisAESOLICITUDES != null ? aesolicitudeseliminarpthisAESOLICITUDES.getOid() : null;
    }

    private void checkAesolicitudeseliminarpthisAESOLICITUDES() throws NotNullArgumentException {
        if(this.getAesolicitudeseliminarpthisAESOLICITUDESInstance() == null || this.getAesolicitudeseliminarpthisAESOLICITUDESInstance().isNull()) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_ELIMINAR, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_ELIMINAR_AESOLICITUDESELIMINARPTHISAESOLICITUDES, AesolicitudesConstants.SERV_ALIAS_ELIMINAR, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_ELIMINAR_AESOLICITUDESELIMINARPTHISAESOLICITUDES);
        }
    }
}
