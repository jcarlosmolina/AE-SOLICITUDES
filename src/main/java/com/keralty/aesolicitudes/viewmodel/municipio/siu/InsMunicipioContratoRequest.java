package com.keralty.aesolicitudes.viewmodel.municipio.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.MunicipioConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;

public class InsMunicipioContratoRequest {

    @JsonProperty("p_thismunicipio_oid")
    private MunicipioOid municipioInsMunicipioContratopthisMunicipio;
    
    @JsonIgnore
    private Municipio municipioInsMunicipioContratopthisMunicipioInstance;

    @JsonProperty("p_evccontratoc_oid")
    private ContratoCOid municipioInsMunicipioContratopevcContratoC;
    
    @JsonIgnore
    private ContratoC municipioInsMunicipioContratopevcContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkMunicipioInsMunicipioContratopthisMunicipio();
        checkMunicipioInsMunicipioContratopevcContratoC();
    }

    @JsonIgnore
    public MunicipioOid getMunicipioInsMunicipioContratopthisMunicipio() {
        return this.municipioInsMunicipioContratopthisMunicipio;
    }
    
    public void setMunicipioInsMunicipioContratopthisMunicipio(MunicipioOid municipioInsMunicipioContratopthisMunicipio) {
        this.municipioInsMunicipioContratopthisMunicipio = municipioInsMunicipioContratopthisMunicipio;
    }

    @JsonIgnore
    public Municipio getMunicipioInsMunicipioContratopthisMunicipioInstance() {
        return this.municipioInsMunicipioContratopthisMunicipioInstance;
    }
    
    public void setMunicipioInsMunicipioContratopthisMunicipioInstance(Municipio municipioInsMunicipioContratopthisMunicipio) {
        this.municipioInsMunicipioContratopthisMunicipioInstance = municipioInsMunicipioContratopthisMunicipio;
        this.municipioInsMunicipioContratopthisMunicipio = municipioInsMunicipioContratopthisMunicipio != null ? municipioInsMunicipioContratopthisMunicipio.getOid() : null;
    }

    private void checkMunicipioInsMunicipioContratopthisMunicipio() throws NotNullArgumentException {
        if(this.getMunicipioInsMunicipioContratopthisMunicipioInstance() == null || this.getMunicipioInsMunicipioContratopthisMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_INSMUNICIPIOCONTRATO, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_INSMUNICIPIOCONTRATO_MUNICIPIOINSMUNICIPIOCONTRATOPTHISMUNICIPIO, MunicipioConstants.SERV_ALIAS_INSMUNICIPIOCONTRATO, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_INSMUNICIPIOCONTRATO_MUNICIPIOINSMUNICIPIOCONTRATOPTHISMUNICIPIO);
        }
    }

    @JsonIgnore
    public ContratoCOid getMunicipioInsMunicipioContratopevcContratoC() {
        return this.municipioInsMunicipioContratopevcContratoC;
    }
    
    public void setMunicipioInsMunicipioContratopevcContratoC(ContratoCOid municipioInsMunicipioContratopevcContratoC) {
        this.municipioInsMunicipioContratopevcContratoC = municipioInsMunicipioContratopevcContratoC;
    }

    @JsonIgnore
    public ContratoC getMunicipioInsMunicipioContratopevcContratoCInstance() {
        return this.municipioInsMunicipioContratopevcContratoCInstance;
    }
    
    public void setMunicipioInsMunicipioContratopevcContratoCInstance(ContratoC municipioInsMunicipioContratopevcContratoC) {
        this.municipioInsMunicipioContratopevcContratoCInstance = municipioInsMunicipioContratopevcContratoC;
        this.municipioInsMunicipioContratopevcContratoC = municipioInsMunicipioContratopevcContratoC != null ? municipioInsMunicipioContratopevcContratoC.getOid() : null;
    }

    private void checkMunicipioInsMunicipioContratopevcContratoC() throws NotNullArgumentException {
        if(this.getMunicipioInsMunicipioContratopevcContratoCInstance() == null || this.getMunicipioInsMunicipioContratopevcContratoCInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_INSMUNICIPIOCONTRATO, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_INSMUNICIPIOCONTRATO_MUNICIPIOINSMUNICIPIOCONTRATOPEVCCONTRATOC, MunicipioConstants.SERV_ALIAS_INSMUNICIPIOCONTRATO, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_INSMUNICIPIOCONTRATO_MUNICIPIOINSMUNICIPIOCONTRATOPEVCCONTRATOC);
        }
    }
}
