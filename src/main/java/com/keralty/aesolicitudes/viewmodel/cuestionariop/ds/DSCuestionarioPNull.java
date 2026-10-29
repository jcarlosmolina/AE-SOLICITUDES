package com.keralty.aesolicitudes.viewmodel.cuestionariop.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.CuestionarioP;
public class DSCuestionarioPNull {

    @JsonProperty("numero")
    private Long dSCuestionarioPNullNumero;

    public DSCuestionarioPNull() {
    
    }

    public DSCuestionarioPNull(CuestionarioP instance) {
        if (instance != null) {
            this.dSCuestionarioPNullNumero = instance.getCuestionarioPNumero();
        }
    }

    @JsonIgnore
    public Long getDSCuestionarioPNullNumero() {
        return this.dSCuestionarioPNullNumero;
    }
    
    public void setDSCuestionarioPNullNumero(Long dSCuestionarioPNullNumero) {
        this.dSCuestionarioPNullNumero = dSCuestionarioPNullNumero;
    }
}
