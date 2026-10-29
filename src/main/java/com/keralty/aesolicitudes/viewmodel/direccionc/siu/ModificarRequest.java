package com.keralty.aesolicitudes.viewmodel.direccionc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DireccionCConstants;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;

public class ModificarRequest {

    @JsonProperty("p_thisdireccionc_oid")
    private DireccionCOid direccionCmodificarpthisDireccionC;
    
    @JsonIgnore
    private DireccionC direccionCmodificarpthisDireccionCInstance;

    @JsonProperty("p_direccioncompleta")
    private String direccionCmodificarpDireccionCompleta;

    @JsonProperty("p_localidad")
    private String direccionCmodificarpLocalidad;

    public void checkArguments() throws NotNullArgumentException {
        checkDireccionCmodificarpthisDireccionC();
    }

    @JsonIgnore
    public DireccionCOid getDireccionCmodificarpthisDireccionC() {
        return this.direccionCmodificarpthisDireccionC;
    }
    
    public void setDireccionCmodificarpthisDireccionC(DireccionCOid direccionCmodificarpthisDireccionC) {
        this.direccionCmodificarpthisDireccionC = direccionCmodificarpthisDireccionC;
    }

    @JsonIgnore
    public DireccionC getDireccionCmodificarpthisDireccionCInstance() {
        return this.direccionCmodificarpthisDireccionCInstance;
    }
    
    public void setDireccionCmodificarpthisDireccionCInstance(DireccionC direccionCmodificarpthisDireccionC) {
        this.direccionCmodificarpthisDireccionCInstance = direccionCmodificarpthisDireccionC;
        this.direccionCmodificarpthisDireccionC = direccionCmodificarpthisDireccionC != null ? direccionCmodificarpthisDireccionC.getOid() : null;
    }

    private void checkDireccionCmodificarpthisDireccionC() throws NotNullArgumentException {
        if(this.getDireccionCmodificarpthisDireccionCInstance() == null || this.getDireccionCmodificarpthisDireccionCInstance().isNull()) {
            throw new NotNullArgumentException(DireccionCConstants.SERV_ID_MODIFICAR, DireccionCConstants.CLASS_ID, DireccionCConstants.ARG_ID_MODIFICAR_DIRECCIONCMODIFICARPTHISDIRECCIONC, DireccionCConstants.SERV_ALIAS_MODIFICAR, DireccionCConstants.CLASS_ALIAS, DireccionCConstants.ARG_ALIAS_MODIFICAR_DIRECCIONCMODIFICARPTHISDIRECCIONC);
        }
    }

    @JsonIgnore
    public String getDireccionCmodificarpDireccionCompleta() {
        return this.direccionCmodificarpDireccionCompleta;
    }
    
    public void setDireccionCmodificarpDireccionCompleta(String direccionCmodificarpDireccionCompleta) {
        this.direccionCmodificarpDireccionCompleta = direccionCmodificarpDireccionCompleta;
    }

    @JsonIgnore
    public String getDireccionCmodificarpLocalidad() {
        return this.direccionCmodificarpLocalidad;
    }
    
    public void setDireccionCmodificarpLocalidad(String direccionCmodificarpLocalidad) {
        this.direccionCmodificarpLocalidad = direccionCmodificarpLocalidad;
    }
}
