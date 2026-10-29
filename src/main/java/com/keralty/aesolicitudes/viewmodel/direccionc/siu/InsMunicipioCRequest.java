package com.keralty.aesolicitudes.viewmodel.direccionc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DireccionCConstants;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;

public class InsMunicipioCRequest {

    @JsonProperty("p_thisdireccionc_oid")
    private DireccionCOid direccionCInsMunicipioCpthisDireccionC;
    
    @JsonIgnore
    private DireccionC direccionCInsMunicipioCpthisDireccionCInstance;

    @JsonProperty("p_evcmunicipio_oid")
    private MunicipioOid direccionCInsMunicipioCpevcMunicipio;
    
    @JsonIgnore
    private Municipio direccionCInsMunicipioCpevcMunicipioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDireccionCInsMunicipioCpthisDireccionC();
        checkDireccionCInsMunicipioCpevcMunicipio();
    }

    @JsonIgnore
    public DireccionCOid getDireccionCInsMunicipioCpthisDireccionC() {
        return this.direccionCInsMunicipioCpthisDireccionC;
    }
    
    public void setDireccionCInsMunicipioCpthisDireccionC(DireccionCOid direccionCInsMunicipioCpthisDireccionC) {
        this.direccionCInsMunicipioCpthisDireccionC = direccionCInsMunicipioCpthisDireccionC;
    }

    @JsonIgnore
    public DireccionC getDireccionCInsMunicipioCpthisDireccionCInstance() {
        return this.direccionCInsMunicipioCpthisDireccionCInstance;
    }
    
    public void setDireccionCInsMunicipioCpthisDireccionCInstance(DireccionC direccionCInsMunicipioCpthisDireccionC) {
        this.direccionCInsMunicipioCpthisDireccionCInstance = direccionCInsMunicipioCpthisDireccionC;
        this.direccionCInsMunicipioCpthisDireccionC = direccionCInsMunicipioCpthisDireccionC != null ? direccionCInsMunicipioCpthisDireccionC.getOid() : null;
    }

    private void checkDireccionCInsMunicipioCpthisDireccionC() throws NotNullArgumentException {
        if(this.getDireccionCInsMunicipioCpthisDireccionCInstance() == null || this.getDireccionCInsMunicipioCpthisDireccionCInstance().isNull()) {
            throw new NotNullArgumentException(DireccionCConstants.SERV_ID_INSMUNICIPIOC, DireccionCConstants.CLASS_ID, DireccionCConstants.ARG_ID_INSMUNICIPIOC_DIRECCIONCINSMUNICIPIOCPTHISDIRECCIONC, DireccionCConstants.SERV_ALIAS_INSMUNICIPIOC, DireccionCConstants.CLASS_ALIAS, DireccionCConstants.ARG_ALIAS_INSMUNICIPIOC_DIRECCIONCINSMUNICIPIOCPTHISDIRECCIONC);
        }
    }

    @JsonIgnore
    public MunicipioOid getDireccionCInsMunicipioCpevcMunicipio() {
        return this.direccionCInsMunicipioCpevcMunicipio;
    }
    
    public void setDireccionCInsMunicipioCpevcMunicipio(MunicipioOid direccionCInsMunicipioCpevcMunicipio) {
        this.direccionCInsMunicipioCpevcMunicipio = direccionCInsMunicipioCpevcMunicipio;
    }

    @JsonIgnore
    public Municipio getDireccionCInsMunicipioCpevcMunicipioInstance() {
        return this.direccionCInsMunicipioCpevcMunicipioInstance;
    }
    
    public void setDireccionCInsMunicipioCpevcMunicipioInstance(Municipio direccionCInsMunicipioCpevcMunicipio) {
        this.direccionCInsMunicipioCpevcMunicipioInstance = direccionCInsMunicipioCpevcMunicipio;
        this.direccionCInsMunicipioCpevcMunicipio = direccionCInsMunicipioCpevcMunicipio != null ? direccionCInsMunicipioCpevcMunicipio.getOid() : null;
    }

    private void checkDireccionCInsMunicipioCpevcMunicipio() throws NotNullArgumentException {
        if(this.getDireccionCInsMunicipioCpevcMunicipioInstance() == null || this.getDireccionCInsMunicipioCpevcMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(DireccionCConstants.SERV_ID_INSMUNICIPIOC, DireccionCConstants.CLASS_ID, DireccionCConstants.ARG_ID_INSMUNICIPIOC_DIRECCIONCINSMUNICIPIOCPEVCMUNICIPIO, DireccionCConstants.SERV_ALIAS_INSMUNICIPIOC, DireccionCConstants.CLASS_ALIAS, DireccionCConstants.ARG_ALIAS_INSMUNICIPIOC_DIRECCIONCINSMUNICIPIOCPEVCMUNICIPIO);
        }
    }
}
