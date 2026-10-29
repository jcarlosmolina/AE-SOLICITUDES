package com.keralty.aesolicitudes.viewmodel.protecciondatos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TCREARPROTECCIONDATOSINCRequest {

    @JsonProperty("pttexto")
    private String proteccionDatosTCREARPROTECCIONDATOSINCptTexto;

    @JsonIgnore
    public String getProteccionDatosTCREARPROTECCIONDATOSINCptTexto() {
        return this.proteccionDatosTCREARPROTECCIONDATOSINCptTexto;
    }
    
    public void setProteccionDatosTCREARPROTECCIONDATOSINCptTexto(String proteccionDatosTCREARPROTECCIONDATOSINCptTexto) {
        this.proteccionDatosTCREARPROTECCIONDATOSINCptTexto = proteccionDatosTCREARPROTECCIONDATOSINCptTexto;
    }
}
