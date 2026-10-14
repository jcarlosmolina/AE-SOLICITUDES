package com.keralty.aesolicitudes.viewmodel.tipoinstitucionc.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.TipoInstitucionC;
public class ICTipoInstitucion {

    @JsonProperty("nombre")
    private String iCTipoInstitucionNombre;

    public ICTipoInstitucion() {
    
    }

    public ICTipoInstitucion(TipoInstitucionC instance) {
        if (instance != null) {
            this.iCTipoInstitucionNombre = instance.getTipoInstitucionCNombre();
        }
    }

    @JsonIgnore
    public String getICTipoInstitucionNombre() {
        return this.iCTipoInstitucionNombre;
    }
    
    public void setICTipoInstitucionNombre(String iCTipoInstitucionNombre) {
        this.iCTipoInstitucionNombre = iCTipoInstitucionNombre;
    }
}
