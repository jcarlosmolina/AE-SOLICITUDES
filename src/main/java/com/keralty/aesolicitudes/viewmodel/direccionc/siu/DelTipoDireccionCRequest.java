package com.keralty.aesolicitudes.viewmodel.direccionc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DireccionCConstants;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoDireccionOid;
import com.keralty.aesolicitudes.persistence.TipoDireccion;

public class DelTipoDireccionCRequest {

    @JsonProperty("p_thisdireccionc_oid")
    private DireccionCOid direccionCDelTipoDireccionCpthisDireccionC;
    
    @JsonIgnore
    private DireccionC direccionCDelTipoDireccionCpthisDireccionCInstance;

    @JsonProperty("p_evctipodireccion_oid")
    private TipoDireccionOid direccionCDelTipoDireccionCpevcTipoDireccion;
    
    @JsonIgnore
    private TipoDireccion direccionCDelTipoDireccionCpevcTipoDireccionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDireccionCDelTipoDireccionCpthisDireccionC();
        checkDireccionCDelTipoDireccionCpevcTipoDireccion();
    }

    @JsonIgnore
    public DireccionCOid getDireccionCDelTipoDireccionCpthisDireccionC() {
        return this.direccionCDelTipoDireccionCpthisDireccionC;
    }
    
    public void setDireccionCDelTipoDireccionCpthisDireccionC(DireccionCOid direccionCDelTipoDireccionCpthisDireccionC) {
        this.direccionCDelTipoDireccionCpthisDireccionC = direccionCDelTipoDireccionCpthisDireccionC;
    }

    @JsonIgnore
    public DireccionC getDireccionCDelTipoDireccionCpthisDireccionCInstance() {
        return this.direccionCDelTipoDireccionCpthisDireccionCInstance;
    }
    
    public void setDireccionCDelTipoDireccionCpthisDireccionCInstance(DireccionC direccionCDelTipoDireccionCpthisDireccionC) {
        this.direccionCDelTipoDireccionCpthisDireccionCInstance = direccionCDelTipoDireccionCpthisDireccionC;
        this.direccionCDelTipoDireccionCpthisDireccionC = direccionCDelTipoDireccionCpthisDireccionC != null ? direccionCDelTipoDireccionCpthisDireccionC.getOid() : null;
    }

    private void checkDireccionCDelTipoDireccionCpthisDireccionC() throws NotNullArgumentException {
        if(this.getDireccionCDelTipoDireccionCpthisDireccionCInstance() == null || this.getDireccionCDelTipoDireccionCpthisDireccionCInstance().isNull()) {
            throw new NotNullArgumentException(DireccionCConstants.SERV_ID_DELTIPODIRECCIONC, DireccionCConstants.CLASS_ID, DireccionCConstants.ARG_ID_DELTIPODIRECCIONC_DIRECCIONCDELTIPODIRECCIONCPTHISDIRECCIONC, DireccionCConstants.SERV_ALIAS_DELTIPODIRECCIONC, DireccionCConstants.CLASS_ALIAS, DireccionCConstants.ARG_ALIAS_DELTIPODIRECCIONC_DIRECCIONCDELTIPODIRECCIONCPTHISDIRECCIONC);
        }
    }

    @JsonIgnore
    public TipoDireccionOid getDireccionCDelTipoDireccionCpevcTipoDireccion() {
        return this.direccionCDelTipoDireccionCpevcTipoDireccion;
    }
    
    public void setDireccionCDelTipoDireccionCpevcTipoDireccion(TipoDireccionOid direccionCDelTipoDireccionCpevcTipoDireccion) {
        this.direccionCDelTipoDireccionCpevcTipoDireccion = direccionCDelTipoDireccionCpevcTipoDireccion;
    }

    @JsonIgnore
    public TipoDireccion getDireccionCDelTipoDireccionCpevcTipoDireccionInstance() {
        return this.direccionCDelTipoDireccionCpevcTipoDireccionInstance;
    }
    
    public void setDireccionCDelTipoDireccionCpevcTipoDireccionInstance(TipoDireccion direccionCDelTipoDireccionCpevcTipoDireccion) {
        this.direccionCDelTipoDireccionCpevcTipoDireccionInstance = direccionCDelTipoDireccionCpevcTipoDireccion;
        this.direccionCDelTipoDireccionCpevcTipoDireccion = direccionCDelTipoDireccionCpevcTipoDireccion != null ? direccionCDelTipoDireccionCpevcTipoDireccion.getOid() : null;
    }

    private void checkDireccionCDelTipoDireccionCpevcTipoDireccion() throws NotNullArgumentException {
        if(this.getDireccionCDelTipoDireccionCpevcTipoDireccionInstance() == null || this.getDireccionCDelTipoDireccionCpevcTipoDireccionInstance().isNull()) {
            throw new NotNullArgumentException(DireccionCConstants.SERV_ID_DELTIPODIRECCIONC, DireccionCConstants.CLASS_ID, DireccionCConstants.ARG_ID_DELTIPODIRECCIONC_DIRECCIONCDELTIPODIRECCIONCPEVCTIPODIRECCION, DireccionCConstants.SERV_ALIAS_DELTIPODIRECCIONC, DireccionCConstants.CLASS_ALIAS, DireccionCConstants.ARG_ALIAS_DELTIPODIRECCIONC_DIRECCIONCDELTIPODIRECCIONCPEVCTIPODIRECCION);
        }
    }
}
