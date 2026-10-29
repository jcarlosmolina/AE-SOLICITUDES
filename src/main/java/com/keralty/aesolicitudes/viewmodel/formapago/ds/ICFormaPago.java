package com.keralty.aesolicitudes.viewmodel.formapago.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.FormaPago;
public class ICFormaPago {

    @JsonProperty("descripcion")
    private String iCFormaPagoDescripcion;

    public ICFormaPago() {
    
    }

    public ICFormaPago(FormaPago instance) {
        if (instance != null) {
            this.iCFormaPagoDescripcion = instance.getFormaPagoDescripcion();
        }
    }

    @JsonIgnore
    public String getICFormaPagoDescripcion() {
        return this.iCFormaPagoDescripcion;
    }
    
    public void setICFormaPagoDescripcion(String iCFormaPagoDescripcion) {
        this.iCFormaPagoDescripcion = iCFormaPagoDescripcion;
    }
}
