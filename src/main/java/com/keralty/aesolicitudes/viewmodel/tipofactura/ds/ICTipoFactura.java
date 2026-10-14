package com.keralty.aesolicitudes.viewmodel.tipofactura.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.TipoFactura;
public class ICTipoFactura {

    @JsonProperty("descripcion")
    private String iCTipoFacturaDescripcion;

    public ICTipoFactura() {
    
    }

    public ICTipoFactura(TipoFactura instance) {
        if (instance != null) {
            this.iCTipoFacturaDescripcion = instance.getTipoFacturaDescripcion();
        }
    }

    @JsonIgnore
    public String getICTipoFacturaDescripcion() {
        return this.iCTipoFacturaDescripcion;
    }
    
    public void setICTipoFacturaDescripcion(String iCTipoFacturaDescripcion) {
        this.iCTipoFacturaDescripcion = iCTipoFacturaDescripcion;
    }
}
