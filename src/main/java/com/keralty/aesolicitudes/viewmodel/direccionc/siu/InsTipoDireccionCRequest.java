package com.keralty.aesolicitudes.viewmodel.direccionc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DireccionCConstants;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoDireccionOid;
import com.keralty.aesolicitudes.persistence.TipoDireccion;

public class InsTipoDireccionCRequest {

    @JsonProperty("p_thisdireccionc_oid")
    private DireccionCOid direccionCInsTipoDireccionCpthisDireccionC;
    
    @JsonIgnore
    private DireccionC direccionCInsTipoDireccionCpthisDireccionCInstance;

    @JsonProperty("p_evctipodireccion_oid")
    private TipoDireccionOid direccionCInsTipoDireccionCpevcTipoDireccion;
    
    @JsonIgnore
    private TipoDireccion direccionCInsTipoDireccionCpevcTipoDireccionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDireccionCInsTipoDireccionCpthisDireccionC();
        checkDireccionCInsTipoDireccionCpevcTipoDireccion();
    }

    @JsonIgnore
    public DireccionCOid getDireccionCInsTipoDireccionCpthisDireccionC() {
        return this.direccionCInsTipoDireccionCpthisDireccionC;
    }
    
    public void setDireccionCInsTipoDireccionCpthisDireccionC(DireccionCOid direccionCInsTipoDireccionCpthisDireccionC) {
        this.direccionCInsTipoDireccionCpthisDireccionC = direccionCInsTipoDireccionCpthisDireccionC;
    }

    @JsonIgnore
    public DireccionC getDireccionCInsTipoDireccionCpthisDireccionCInstance() {
        return this.direccionCInsTipoDireccionCpthisDireccionCInstance;
    }
    
    public void setDireccionCInsTipoDireccionCpthisDireccionCInstance(DireccionC direccionCInsTipoDireccionCpthisDireccionC) {
        this.direccionCInsTipoDireccionCpthisDireccionCInstance = direccionCInsTipoDireccionCpthisDireccionC;
        this.direccionCInsTipoDireccionCpthisDireccionC = direccionCInsTipoDireccionCpthisDireccionC != null ? direccionCInsTipoDireccionCpthisDireccionC.getOid() : null;
    }

    private void checkDireccionCInsTipoDireccionCpthisDireccionC() throws NotNullArgumentException {
        if(this.getDireccionCInsTipoDireccionCpthisDireccionCInstance() == null || this.getDireccionCInsTipoDireccionCpthisDireccionCInstance().isNull()) {
            throw new NotNullArgumentException(DireccionCConstants.SERV_ID_INSTIPODIRECCIONC, DireccionCConstants.CLASS_ID, DireccionCConstants.ARG_ID_INSTIPODIRECCIONC_DIRECCIONCINSTIPODIRECCIONCPTHISDIRECCIONC, DireccionCConstants.SERV_ALIAS_INSTIPODIRECCIONC, DireccionCConstants.CLASS_ALIAS, DireccionCConstants.ARG_ALIAS_INSTIPODIRECCIONC_DIRECCIONCINSTIPODIRECCIONCPTHISDIRECCIONC);
        }
    }

    @JsonIgnore
    public TipoDireccionOid getDireccionCInsTipoDireccionCpevcTipoDireccion() {
        return this.direccionCInsTipoDireccionCpevcTipoDireccion;
    }
    
    public void setDireccionCInsTipoDireccionCpevcTipoDireccion(TipoDireccionOid direccionCInsTipoDireccionCpevcTipoDireccion) {
        this.direccionCInsTipoDireccionCpevcTipoDireccion = direccionCInsTipoDireccionCpevcTipoDireccion;
    }

    @JsonIgnore
    public TipoDireccion getDireccionCInsTipoDireccionCpevcTipoDireccionInstance() {
        return this.direccionCInsTipoDireccionCpevcTipoDireccionInstance;
    }
    
    public void setDireccionCInsTipoDireccionCpevcTipoDireccionInstance(TipoDireccion direccionCInsTipoDireccionCpevcTipoDireccion) {
        this.direccionCInsTipoDireccionCpevcTipoDireccionInstance = direccionCInsTipoDireccionCpevcTipoDireccion;
        this.direccionCInsTipoDireccionCpevcTipoDireccion = direccionCInsTipoDireccionCpevcTipoDireccion != null ? direccionCInsTipoDireccionCpevcTipoDireccion.getOid() : null;
    }

    private void checkDireccionCInsTipoDireccionCpevcTipoDireccion() throws NotNullArgumentException {
        if(this.getDireccionCInsTipoDireccionCpevcTipoDireccionInstance() == null || this.getDireccionCInsTipoDireccionCpevcTipoDireccionInstance().isNull()) {
            throw new NotNullArgumentException(DireccionCConstants.SERV_ID_INSTIPODIRECCIONC, DireccionCConstants.CLASS_ID, DireccionCConstants.ARG_ID_INSTIPODIRECCIONC_DIRECCIONCINSTIPODIRECCIONCPEVCTIPODIRECCION, DireccionCConstants.SERV_ALIAS_INSTIPODIRECCIONC, DireccionCConstants.CLASS_ALIAS, DireccionCConstants.ARG_ALIAS_INSTIPODIRECCIONC_DIRECCIONCINSTIPODIRECCIONCPEVCTIPODIRECCION);
        }
    }
}
