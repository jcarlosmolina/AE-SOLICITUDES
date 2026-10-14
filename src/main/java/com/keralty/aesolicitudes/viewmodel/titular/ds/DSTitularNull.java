package com.keralty.aesolicitudes.viewmodel.titular.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.Titular;
public class DSTitularNull {

    @JsonProperty("codigo")
    private Long dSTitularNullCodigo;

    public DSTitularNull() {
    
    }

    public DSTitularNull(Titular instance) {
        if (instance != null) {
            this.dSTitularNullCodigo = instance.getTitularCodigo();
        }
    }

    @JsonIgnore
    public Long getDSTitularNullCodigo() {
        return this.dSTitularNullCodigo;
    }
    
    public void setDSTitularNullCodigo(Long dSTitularNullCodigo) {
        this.dSTitularNullCodigo = dSTitularNullCodigo;
    }
}
