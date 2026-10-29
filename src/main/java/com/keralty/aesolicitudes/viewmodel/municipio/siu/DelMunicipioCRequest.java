package com.keralty.aesolicitudes.viewmodel.municipio.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.MunicipioConstants;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;

public class DelMunicipioCRequest {

    @JsonProperty("p_thismunicipio_oid")
    private MunicipioOid municipioDelMunicipioCpthisMunicipio;
    
    @JsonIgnore
    private Municipio municipioDelMunicipioCpthisMunicipioInstance;

    @JsonProperty("p_evcdireccionc_oid")
    private DireccionCOid municipioDelMunicipioCpevcDireccionC;
    
    @JsonIgnore
    private DireccionC municipioDelMunicipioCpevcDireccionCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkMunicipioDelMunicipioCpthisMunicipio();
        checkMunicipioDelMunicipioCpevcDireccionC();
    }

    @JsonIgnore
    public MunicipioOid getMunicipioDelMunicipioCpthisMunicipio() {
        return this.municipioDelMunicipioCpthisMunicipio;
    }
    
    public void setMunicipioDelMunicipioCpthisMunicipio(MunicipioOid municipioDelMunicipioCpthisMunicipio) {
        this.municipioDelMunicipioCpthisMunicipio = municipioDelMunicipioCpthisMunicipio;
    }

    @JsonIgnore
    public Municipio getMunicipioDelMunicipioCpthisMunicipioInstance() {
        return this.municipioDelMunicipioCpthisMunicipioInstance;
    }
    
    public void setMunicipioDelMunicipioCpthisMunicipioInstance(Municipio municipioDelMunicipioCpthisMunicipio) {
        this.municipioDelMunicipioCpthisMunicipioInstance = municipioDelMunicipioCpthisMunicipio;
        this.municipioDelMunicipioCpthisMunicipio = municipioDelMunicipioCpthisMunicipio != null ? municipioDelMunicipioCpthisMunicipio.getOid() : null;
    }

    private void checkMunicipioDelMunicipioCpthisMunicipio() throws NotNullArgumentException {
        if(this.getMunicipioDelMunicipioCpthisMunicipioInstance() == null || this.getMunicipioDelMunicipioCpthisMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_DELMUNICIPIOC, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_DELMUNICIPIOC_MUNICIPIODELMUNICIPIOCPTHISMUNICIPIO, MunicipioConstants.SERV_ALIAS_DELMUNICIPIOC, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_DELMUNICIPIOC_MUNICIPIODELMUNICIPIOCPTHISMUNICIPIO);
        }
    }

    @JsonIgnore
    public DireccionCOid getMunicipioDelMunicipioCpevcDireccionC() {
        return this.municipioDelMunicipioCpevcDireccionC;
    }
    
    public void setMunicipioDelMunicipioCpevcDireccionC(DireccionCOid municipioDelMunicipioCpevcDireccionC) {
        this.municipioDelMunicipioCpevcDireccionC = municipioDelMunicipioCpevcDireccionC;
    }

    @JsonIgnore
    public DireccionC getMunicipioDelMunicipioCpevcDireccionCInstance() {
        return this.municipioDelMunicipioCpevcDireccionCInstance;
    }
    
    public void setMunicipioDelMunicipioCpevcDireccionCInstance(DireccionC municipioDelMunicipioCpevcDireccionC) {
        this.municipioDelMunicipioCpevcDireccionCInstance = municipioDelMunicipioCpevcDireccionC;
        this.municipioDelMunicipioCpevcDireccionC = municipioDelMunicipioCpevcDireccionC != null ? municipioDelMunicipioCpevcDireccionC.getOid() : null;
    }

    private void checkMunicipioDelMunicipioCpevcDireccionC() throws NotNullArgumentException {
        if(this.getMunicipioDelMunicipioCpevcDireccionCInstance() == null || this.getMunicipioDelMunicipioCpevcDireccionCInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_DELMUNICIPIOC, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_DELMUNICIPIOC_MUNICIPIODELMUNICIPIOCPEVCDIRECCIONC, MunicipioConstants.SERV_ALIAS_DELMUNICIPIOC, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_DELMUNICIPIOC_MUNICIPIODELMUNICIPIOCPEVCDIRECCIONC);
        }
    }
}
