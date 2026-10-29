package com.keralty.aesolicitudes.viewmodel.protecciondatos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TCREARPROTECCIONDATOSNARequest {

    @JsonProperty("pttexto")
    private String proteccionDatosTCREARPROTECCIONDATOSNAptTexto;

    @JsonIgnore
    public String getProteccionDatosTCREARPROTECCIONDATOSNAptTexto() {
        return this.proteccionDatosTCREARPROTECCIONDATOSNAptTexto;
    }
    
    public void setProteccionDatosTCREARPROTECCIONDATOSNAptTexto(String proteccionDatosTCREARPROTECCIONDATOSNAptTexto) {
        this.proteccionDatosTCREARPROTECCIONDATOSNAptTexto = proteccionDatosTCREARPROTECCIONDATOSNAptTexto;
    }
}
