package com.keralty.aesolicitudes.viewmodel.municipio.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.MunicipioConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;

public class DelMunicipioContratoRequest {

    @JsonProperty("p_thismunicipio_oid")
    private MunicipioOid municipioDelMunicipioContratopthisMunicipio;
    
    @JsonIgnore
    private Municipio municipioDelMunicipioContratopthisMunicipioInstance;

    @JsonProperty("p_evccontratoc_oid")
    private ContratoCOid municipioDelMunicipioContratopevcContratoC;
    
    @JsonIgnore
    private ContratoC municipioDelMunicipioContratopevcContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkMunicipioDelMunicipioContratopthisMunicipio();
        checkMunicipioDelMunicipioContratopevcContratoC();
    }

    @JsonIgnore
    public MunicipioOid getMunicipioDelMunicipioContratopthisMunicipio() {
        return this.municipioDelMunicipioContratopthisMunicipio;
    }
    
    public void setMunicipioDelMunicipioContratopthisMunicipio(MunicipioOid municipioDelMunicipioContratopthisMunicipio) {
        this.municipioDelMunicipioContratopthisMunicipio = municipioDelMunicipioContratopthisMunicipio;
    }

    @JsonIgnore
    public Municipio getMunicipioDelMunicipioContratopthisMunicipioInstance() {
        return this.municipioDelMunicipioContratopthisMunicipioInstance;
    }
    
    public void setMunicipioDelMunicipioContratopthisMunicipioInstance(Municipio municipioDelMunicipioContratopthisMunicipio) {
        this.municipioDelMunicipioContratopthisMunicipioInstance = municipioDelMunicipioContratopthisMunicipio;
        this.municipioDelMunicipioContratopthisMunicipio = municipioDelMunicipioContratopthisMunicipio != null ? municipioDelMunicipioContratopthisMunicipio.getOid() : null;
    }

    private void checkMunicipioDelMunicipioContratopthisMunicipio() throws NotNullArgumentException {
        if(this.getMunicipioDelMunicipioContratopthisMunicipioInstance() == null || this.getMunicipioDelMunicipioContratopthisMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_DELMUNICIPIOCONTRATO, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_DELMUNICIPIOCONTRATO_MUNICIPIODELMUNICIPIOCONTRATOPTHISMUNICIPIO, MunicipioConstants.SERV_ALIAS_DELMUNICIPIOCONTRATO, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_DELMUNICIPIOCONTRATO_MUNICIPIODELMUNICIPIOCONTRATOPTHISMUNICIPIO);
        }
    }

    @JsonIgnore
    public ContratoCOid getMunicipioDelMunicipioContratopevcContratoC() {
        return this.municipioDelMunicipioContratopevcContratoC;
    }
    
    public void setMunicipioDelMunicipioContratopevcContratoC(ContratoCOid municipioDelMunicipioContratopevcContratoC) {
        this.municipioDelMunicipioContratopevcContratoC = municipioDelMunicipioContratopevcContratoC;
    }

    @JsonIgnore
    public ContratoC getMunicipioDelMunicipioContratopevcContratoCInstance() {
        return this.municipioDelMunicipioContratopevcContratoCInstance;
    }
    
    public void setMunicipioDelMunicipioContratopevcContratoCInstance(ContratoC municipioDelMunicipioContratopevcContratoC) {
        this.municipioDelMunicipioContratopevcContratoCInstance = municipioDelMunicipioContratopevcContratoC;
        this.municipioDelMunicipioContratopevcContratoC = municipioDelMunicipioContratopevcContratoC != null ? municipioDelMunicipioContratopevcContratoC.getOid() : null;
    }

    private void checkMunicipioDelMunicipioContratopevcContratoC() throws NotNullArgumentException {
        if(this.getMunicipioDelMunicipioContratopevcContratoCInstance() == null || this.getMunicipioDelMunicipioContratopevcContratoCInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_DELMUNICIPIOCONTRATO, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_DELMUNICIPIOCONTRATO_MUNICIPIODELMUNICIPIOCONTRATOPEVCCONTRATOC, MunicipioConstants.SERV_ALIAS_DELMUNICIPIOCONTRATO, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_DELMUNICIPIOCONTRATO_MUNICIPIODELMUNICIPIOCONTRATOPEVCCONTRATOC);
        }
    }
}
