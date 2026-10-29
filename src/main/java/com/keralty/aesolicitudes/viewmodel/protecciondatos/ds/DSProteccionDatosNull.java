package com.keralty.aesolicitudes.viewmodel.protecciondatos.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
public class DSProteccionDatosNull {

    @JsonProperty("identificador")
    private Long dSProteccionDatosNullIdentificador;

    public DSProteccionDatosNull() {
    
    }

    public DSProteccionDatosNull(ProteccionDatos instance) {
        if (instance != null) {
            this.dSProteccionDatosNullIdentificador = instance.getProteccionDatosIdentificador();
        }
    }

    @JsonIgnore
    public Long getDSProteccionDatosNullIdentificador() {
        return this.dSProteccionDatosNullIdentificador;
    }
    
    public void setDSProteccionDatosNullIdentificador(Long dSProteccionDatosNullIdentificador) {
        this.dSProteccionDatosNullIdentificador = dSProteccionDatosNullIdentificador;
    }
}
