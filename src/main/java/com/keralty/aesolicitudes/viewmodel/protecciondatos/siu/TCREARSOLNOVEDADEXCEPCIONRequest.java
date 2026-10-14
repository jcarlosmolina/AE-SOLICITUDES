package com.keralty.aesolicitudes.viewmodel.protecciondatos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TCREARSOLNOVEDADEXCEPCIONRequest {

    @JsonProperty("pttexto")
    private String proteccionDatosTCREARSOLNOVEDADEXCEPCIONptTexto;

    @JsonIgnore
    public String getProteccionDatosTCREARSOLNOVEDADEXCEPCIONptTexto() {
        return this.proteccionDatosTCREARSOLNOVEDADEXCEPCIONptTexto;
    }
    
    public void setProteccionDatosTCREARSOLNOVEDADEXCEPCIONptTexto(String proteccionDatosTCREARSOLNOVEDADEXCEPCIONptTexto) {
        this.proteccionDatosTCREARSOLNOVEDADEXCEPCIONptTexto = proteccionDatosTCREARSOLNOVEDADEXCEPCIONptTexto;
    }
}
