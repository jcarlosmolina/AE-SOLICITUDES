package com.keralty.aesolicitudes.viewmodel.municipio.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.MunicipioConstants;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;

public class InsMunicipioCRequest {

    @JsonProperty("p_thismunicipio_oid")
    private MunicipioOid municipioInsMunicipioCpthisMunicipio;
    
    @JsonIgnore
    private Municipio municipioInsMunicipioCpthisMunicipioInstance;

    @JsonProperty("p_evcdireccionc_oid")
    private DireccionCOid municipioInsMunicipioCpevcDireccionC;
    
    @JsonIgnore
    private DireccionC municipioInsMunicipioCpevcDireccionCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkMunicipioInsMunicipioCpthisMunicipio();
        checkMunicipioInsMunicipioCpevcDireccionC();
    }

    @JsonIgnore
    public MunicipioOid getMunicipioInsMunicipioCpthisMunicipio() {
        return this.municipioInsMunicipioCpthisMunicipio;
    }
    
    public void setMunicipioInsMunicipioCpthisMunicipio(MunicipioOid municipioInsMunicipioCpthisMunicipio) {
        this.municipioInsMunicipioCpthisMunicipio = municipioInsMunicipioCpthisMunicipio;
    }

    @JsonIgnore
    public Municipio getMunicipioInsMunicipioCpthisMunicipioInstance() {
        return this.municipioInsMunicipioCpthisMunicipioInstance;
    }
    
    public void setMunicipioInsMunicipioCpthisMunicipioInstance(Municipio municipioInsMunicipioCpthisMunicipio) {
        this.municipioInsMunicipioCpthisMunicipioInstance = municipioInsMunicipioCpthisMunicipio;
        this.municipioInsMunicipioCpthisMunicipio = municipioInsMunicipioCpthisMunicipio != null ? municipioInsMunicipioCpthisMunicipio.getOid() : null;
    }

    private void checkMunicipioInsMunicipioCpthisMunicipio() throws NotNullArgumentException {
        if(this.getMunicipioInsMunicipioCpthisMunicipioInstance() == null || this.getMunicipioInsMunicipioCpthisMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_INSMUNICIPIOC, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_INSMUNICIPIOC_MUNICIPIOINSMUNICIPIOCPTHISMUNICIPIO, MunicipioConstants.SERV_ALIAS_INSMUNICIPIOC, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_INSMUNICIPIOC_MUNICIPIOINSMUNICIPIOCPTHISMUNICIPIO);
        }
    }

    @JsonIgnore
    public DireccionCOid getMunicipioInsMunicipioCpevcDireccionC() {
        return this.municipioInsMunicipioCpevcDireccionC;
    }
    
    public void setMunicipioInsMunicipioCpevcDireccionC(DireccionCOid municipioInsMunicipioCpevcDireccionC) {
        this.municipioInsMunicipioCpevcDireccionC = municipioInsMunicipioCpevcDireccionC;
    }

    @JsonIgnore
    public DireccionC getMunicipioInsMunicipioCpevcDireccionCInstance() {
        return this.municipioInsMunicipioCpevcDireccionCInstance;
    }
    
    public void setMunicipioInsMunicipioCpevcDireccionCInstance(DireccionC municipioInsMunicipioCpevcDireccionC) {
        this.municipioInsMunicipioCpevcDireccionCInstance = municipioInsMunicipioCpevcDireccionC;
        this.municipioInsMunicipioCpevcDireccionC = municipioInsMunicipioCpevcDireccionC != null ? municipioInsMunicipioCpevcDireccionC.getOid() : null;
    }

    private void checkMunicipioInsMunicipioCpevcDireccionC() throws NotNullArgumentException {
        if(this.getMunicipioInsMunicipioCpevcDireccionCInstance() == null || this.getMunicipioInsMunicipioCpevcDireccionCInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_INSMUNICIPIOC, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_INSMUNICIPIOC_MUNICIPIOINSMUNICIPIOCPEVCDIRECCIONC, MunicipioConstants.SERV_ALIAS_INSMUNICIPIOC, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_INSMUNICIPIOC_MUNICIPIOINSMUNICIPIOCPEVCDIRECCIONC);
        }
    }
}
