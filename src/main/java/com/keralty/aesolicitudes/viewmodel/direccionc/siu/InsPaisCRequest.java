package com.keralty.aesolicitudes.viewmodel.direccionc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DireccionCConstants;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;
import com.keralty.aesolicitudes.persistence.oid.PaisOid;
import com.keralty.aesolicitudes.persistence.Pais;

public class InsPaisCRequest {

    @JsonProperty("p_thisdireccionc_oid")
    private DireccionCOid direccionCInsPaisCpthisDireccionC;
    
    @JsonIgnore
    private DireccionC direccionCInsPaisCpthisDireccionCInstance;

    @JsonProperty("p_evcpais_oid")
    private PaisOid direccionCInsPaisCpevcPais;
    
    @JsonIgnore
    private Pais direccionCInsPaisCpevcPaisInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDireccionCInsPaisCpthisDireccionC();
        checkDireccionCInsPaisCpevcPais();
    }

    @JsonIgnore
    public DireccionCOid getDireccionCInsPaisCpthisDireccionC() {
        return this.direccionCInsPaisCpthisDireccionC;
    }
    
    public void setDireccionCInsPaisCpthisDireccionC(DireccionCOid direccionCInsPaisCpthisDireccionC) {
        this.direccionCInsPaisCpthisDireccionC = direccionCInsPaisCpthisDireccionC;
    }

    @JsonIgnore
    public DireccionC getDireccionCInsPaisCpthisDireccionCInstance() {
        return this.direccionCInsPaisCpthisDireccionCInstance;
    }
    
    public void setDireccionCInsPaisCpthisDireccionCInstance(DireccionC direccionCInsPaisCpthisDireccionC) {
        this.direccionCInsPaisCpthisDireccionCInstance = direccionCInsPaisCpthisDireccionC;
        this.direccionCInsPaisCpthisDireccionC = direccionCInsPaisCpthisDireccionC != null ? direccionCInsPaisCpthisDireccionC.getOid() : null;
    }

    private void checkDireccionCInsPaisCpthisDireccionC() throws NotNullArgumentException {
        if(this.getDireccionCInsPaisCpthisDireccionCInstance() == null || this.getDireccionCInsPaisCpthisDireccionCInstance().isNull()) {
            throw new NotNullArgumentException(DireccionCConstants.SERV_ID_INSPAISC, DireccionCConstants.CLASS_ID, DireccionCConstants.ARG_ID_INSPAISC_DIRECCIONCINSPAISCPTHISDIRECCIONC, DireccionCConstants.SERV_ALIAS_INSPAISC, DireccionCConstants.CLASS_ALIAS, DireccionCConstants.ARG_ALIAS_INSPAISC_DIRECCIONCINSPAISCPTHISDIRECCIONC);
        }
    }

    @JsonIgnore
    public PaisOid getDireccionCInsPaisCpevcPais() {
        return this.direccionCInsPaisCpevcPais;
    }
    
    public void setDireccionCInsPaisCpevcPais(PaisOid direccionCInsPaisCpevcPais) {
        this.direccionCInsPaisCpevcPais = direccionCInsPaisCpevcPais;
    }

    @JsonIgnore
    public Pais getDireccionCInsPaisCpevcPaisInstance() {
        return this.direccionCInsPaisCpevcPaisInstance;
    }
    
    public void setDireccionCInsPaisCpevcPaisInstance(Pais direccionCInsPaisCpevcPais) {
        this.direccionCInsPaisCpevcPaisInstance = direccionCInsPaisCpevcPais;
        this.direccionCInsPaisCpevcPais = direccionCInsPaisCpevcPais != null ? direccionCInsPaisCpevcPais.getOid() : null;
    }

    private void checkDireccionCInsPaisCpevcPais() throws NotNullArgumentException {
        if(this.getDireccionCInsPaisCpevcPaisInstance() == null || this.getDireccionCInsPaisCpevcPaisInstance().isNull()) {
            throw new NotNullArgumentException(DireccionCConstants.SERV_ID_INSPAISC, DireccionCConstants.CLASS_ID, DireccionCConstants.ARG_ID_INSPAISC_DIRECCIONCINSPAISCPEVCPAIS, DireccionCConstants.SERV_ALIAS_INSPAISC, DireccionCConstants.CLASS_ALIAS, DireccionCConstants.ARG_ALIAS_INSPAISC_DIRECCIONCINSPAISCPEVCPAIS);
        }
    }
}
