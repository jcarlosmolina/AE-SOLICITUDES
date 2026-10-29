package com.keralty.aesolicitudes.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.GlobalServiceConstants;

public class OGSOLICITUDFISICALEERRequest {

    @JsonProperty("p_archivo")
    private byte[] oGSOLICITUDFISICALEERpArchivo;

    public void checkArguments() throws NotNullArgumentException {
        checkOGSOLICITUDFISICALEERpArchivo();
    }

    @JsonIgnore
    public byte[] getOGSOLICITUDFISICALEERpArchivo() {
        return this.oGSOLICITUDFISICALEERpArchivo;
    }
    
    public void setOGSOLICITUDFISICALEERpArchivo(byte[] oGSOLICITUDFISICALEERpArchivo) {
        this.oGSOLICITUDFISICALEERpArchivo = oGSOLICITUDFISICALEERpArchivo;
    }

    private void checkOGSOLICITUDFISICALEERpArchivo() throws NotNullArgumentException {
        if(this.getOGSOLICITUDFISICALEERpArchivo() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_OGSOLICITUDFISICALEER, GlobalServiceConstants.GS_ARG_ID_OGSOLICITUDFISICALEER_OGSOLICITUDFISICALEERPARCHIVO, GlobalServiceConstants.G_SERV_ALIAS_OGSOLICITUDFISICALEER, GlobalServiceConstants.GS_ARG_ALIAS_OGSOLICITUDFISICALEER_OGSOLICITUDFISICALEERPARCHIVO);
        }
    }
}
