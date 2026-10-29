package com.keralty.aesolicitudes.viewmodel.direccionc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DireccionCConstants;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;

public class DelMunicipioCRequest {

    @JsonProperty("p_thisdireccionc_oid")
    private DireccionCOid direccionCDelMunicipioCpthisDireccionC;
    
    @JsonIgnore
    private DireccionC direccionCDelMunicipioCpthisDireccionCInstance;

    @JsonProperty("p_evcmunicipio_oid")
    private MunicipioOid direccionCDelMunicipioCpevcMunicipio;
    
    @JsonIgnore
    private Municipio direccionCDelMunicipioCpevcMunicipioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDireccionCDelMunicipioCpthisDireccionC();
        checkDireccionCDelMunicipioCpevcMunicipio();
    }

    @JsonIgnore
    public DireccionCOid getDireccionCDelMunicipioCpthisDireccionC() {
        return this.direccionCDelMunicipioCpthisDireccionC;
    }
    
    public void setDireccionCDelMunicipioCpthisDireccionC(DireccionCOid direccionCDelMunicipioCpthisDireccionC) {
        this.direccionCDelMunicipioCpthisDireccionC = direccionCDelMunicipioCpthisDireccionC;
    }

    @JsonIgnore
    public DireccionC getDireccionCDelMunicipioCpthisDireccionCInstance() {
        return this.direccionCDelMunicipioCpthisDireccionCInstance;
    }
    
    public void setDireccionCDelMunicipioCpthisDireccionCInstance(DireccionC direccionCDelMunicipioCpthisDireccionC) {
        this.direccionCDelMunicipioCpthisDireccionCInstance = direccionCDelMunicipioCpthisDireccionC;
        this.direccionCDelMunicipioCpthisDireccionC = direccionCDelMunicipioCpthisDireccionC != null ? direccionCDelMunicipioCpthisDireccionC.getOid() : null;
    }

    private void checkDireccionCDelMunicipioCpthisDireccionC() throws NotNullArgumentException {
        if(this.getDireccionCDelMunicipioCpthisDireccionCInstance() == null || this.getDireccionCDelMunicipioCpthisDireccionCInstance().isNull()) {
            throw new NotNullArgumentException(DireccionCConstants.SERV_ID_DELMUNICIPIOC, DireccionCConstants.CLASS_ID, DireccionCConstants.ARG_ID_DELMUNICIPIOC_DIRECCIONCDELMUNICIPIOCPTHISDIRECCIONC, DireccionCConstants.SERV_ALIAS_DELMUNICIPIOC, DireccionCConstants.CLASS_ALIAS, DireccionCConstants.ARG_ALIAS_DELMUNICIPIOC_DIRECCIONCDELMUNICIPIOCPTHISDIRECCIONC);
        }
    }

    @JsonIgnore
    public MunicipioOid getDireccionCDelMunicipioCpevcMunicipio() {
        return this.direccionCDelMunicipioCpevcMunicipio;
    }
    
    public void setDireccionCDelMunicipioCpevcMunicipio(MunicipioOid direccionCDelMunicipioCpevcMunicipio) {
        this.direccionCDelMunicipioCpevcMunicipio = direccionCDelMunicipioCpevcMunicipio;
    }

    @JsonIgnore
    public Municipio getDireccionCDelMunicipioCpevcMunicipioInstance() {
        return this.direccionCDelMunicipioCpevcMunicipioInstance;
    }
    
    public void setDireccionCDelMunicipioCpevcMunicipioInstance(Municipio direccionCDelMunicipioCpevcMunicipio) {
        this.direccionCDelMunicipioCpevcMunicipioInstance = direccionCDelMunicipioCpevcMunicipio;
        this.direccionCDelMunicipioCpevcMunicipio = direccionCDelMunicipioCpevcMunicipio != null ? direccionCDelMunicipioCpevcMunicipio.getOid() : null;
    }

    private void checkDireccionCDelMunicipioCpevcMunicipio() throws NotNullArgumentException {
        if(this.getDireccionCDelMunicipioCpevcMunicipioInstance() == null || this.getDireccionCDelMunicipioCpevcMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(DireccionCConstants.SERV_ID_DELMUNICIPIOC, DireccionCConstants.CLASS_ID, DireccionCConstants.ARG_ID_DELMUNICIPIOC_DIRECCIONCDELMUNICIPIOCPEVCMUNICIPIO, DireccionCConstants.SERV_ALIAS_DELMUNICIPIOC, DireccionCConstants.CLASS_ALIAS, DireccionCConstants.ARG_ALIAS_DELMUNICIPIOC_DIRECCIONCDELMUNICIPIOCPEVCMUNICIPIO);
        }
    }
}
