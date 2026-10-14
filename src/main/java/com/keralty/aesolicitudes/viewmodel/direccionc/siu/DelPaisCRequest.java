package com.keralty.aesolicitudes.viewmodel.direccionc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DireccionCConstants;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;
import com.keralty.aesolicitudes.persistence.oid.PaisOid;
import com.keralty.aesolicitudes.persistence.Pais;

public class DelPaisCRequest {

    @JsonProperty("p_thisdireccionc_oid")
    private DireccionCOid direccionCDelPaisCpthisDireccionC;
    
    @JsonIgnore
    private DireccionC direccionCDelPaisCpthisDireccionCInstance;

    @JsonProperty("p_evcpais_oid")
    private PaisOid direccionCDelPaisCpevcPais;
    
    @JsonIgnore
    private Pais direccionCDelPaisCpevcPaisInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDireccionCDelPaisCpthisDireccionC();
        checkDireccionCDelPaisCpevcPais();
    }

    @JsonIgnore
    public DireccionCOid getDireccionCDelPaisCpthisDireccionC() {
        return this.direccionCDelPaisCpthisDireccionC;
    }
    
    public void setDireccionCDelPaisCpthisDireccionC(DireccionCOid direccionCDelPaisCpthisDireccionC) {
        this.direccionCDelPaisCpthisDireccionC = direccionCDelPaisCpthisDireccionC;
    }

    @JsonIgnore
    public DireccionC getDireccionCDelPaisCpthisDireccionCInstance() {
        return this.direccionCDelPaisCpthisDireccionCInstance;
    }
    
    public void setDireccionCDelPaisCpthisDireccionCInstance(DireccionC direccionCDelPaisCpthisDireccionC) {
        this.direccionCDelPaisCpthisDireccionCInstance = direccionCDelPaisCpthisDireccionC;
        this.direccionCDelPaisCpthisDireccionC = direccionCDelPaisCpthisDireccionC != null ? direccionCDelPaisCpthisDireccionC.getOid() : null;
    }

    private void checkDireccionCDelPaisCpthisDireccionC() throws NotNullArgumentException {
        if(this.getDireccionCDelPaisCpthisDireccionCInstance() == null || this.getDireccionCDelPaisCpthisDireccionCInstance().isNull()) {
            throw new NotNullArgumentException(DireccionCConstants.SERV_ID_DELPAISC, DireccionCConstants.CLASS_ID, DireccionCConstants.ARG_ID_DELPAISC_DIRECCIONCDELPAISCPTHISDIRECCIONC, DireccionCConstants.SERV_ALIAS_DELPAISC, DireccionCConstants.CLASS_ALIAS, DireccionCConstants.ARG_ALIAS_DELPAISC_DIRECCIONCDELPAISCPTHISDIRECCIONC);
        }
    }

    @JsonIgnore
    public PaisOid getDireccionCDelPaisCpevcPais() {
        return this.direccionCDelPaisCpevcPais;
    }
    
    public void setDireccionCDelPaisCpevcPais(PaisOid direccionCDelPaisCpevcPais) {
        this.direccionCDelPaisCpevcPais = direccionCDelPaisCpevcPais;
    }

    @JsonIgnore
    public Pais getDireccionCDelPaisCpevcPaisInstance() {
        return this.direccionCDelPaisCpevcPaisInstance;
    }
    
    public void setDireccionCDelPaisCpevcPaisInstance(Pais direccionCDelPaisCpevcPais) {
        this.direccionCDelPaisCpevcPaisInstance = direccionCDelPaisCpevcPais;
        this.direccionCDelPaisCpevcPais = direccionCDelPaisCpevcPais != null ? direccionCDelPaisCpevcPais.getOid() : null;
    }

    private void checkDireccionCDelPaisCpevcPais() throws NotNullArgumentException {
        if(this.getDireccionCDelPaisCpevcPaisInstance() == null || this.getDireccionCDelPaisCpevcPaisInstance().isNull()) {
            throw new NotNullArgumentException(DireccionCConstants.SERV_ID_DELPAISC, DireccionCConstants.CLASS_ID, DireccionCConstants.ARG_ID_DELPAISC_DIRECCIONCDELPAISCPEVCPAIS, DireccionCConstants.SERV_ALIAS_DELPAISC, DireccionCConstants.CLASS_ALIAS, DireccionCConstants.ARG_ALIAS_DELPAISC_DIRECCIONCDELPAISCPEVCPAIS);
        }
    }
}
