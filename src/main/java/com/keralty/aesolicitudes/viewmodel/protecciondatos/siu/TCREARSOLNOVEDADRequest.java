package com.keralty.aesolicitudes.viewmodel.protecciondatos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TCREARSOLNOVEDADRequest {

    @JsonProperty("pttexto")
    private String proteccionDatosTCREARSOLNOVEDADptTexto;

    @JsonIgnore
    public String getProteccionDatosTCREARSOLNOVEDADptTexto() {
        return this.proteccionDatosTCREARSOLNOVEDADptTexto;
    }
    
    public void setProteccionDatosTCREARSOLNOVEDADptTexto(String proteccionDatosTCREARSOLNOVEDADptTexto) {
        this.proteccionDatosTCREARSOLNOVEDADptTexto = proteccionDatosTCREARSOLNOVEDADptTexto;
    }
}
