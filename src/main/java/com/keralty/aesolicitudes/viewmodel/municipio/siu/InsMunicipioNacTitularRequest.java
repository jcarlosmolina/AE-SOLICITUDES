package com.keralty.aesolicitudes.viewmodel.municipio.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.MunicipioConstants;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;
import com.keralty.aesolicitudes.persistence.oid.TitularOid;
import com.keralty.aesolicitudes.persistence.Titular;

public class InsMunicipioNacTitularRequest {

    @JsonProperty("p_thismunicipio_oid")
    private MunicipioOid municipioInsMunicipioNacTitularpthisMunicipio;
    
    @JsonIgnore
    private Municipio municipioInsMunicipioNacTitularpthisMunicipioInstance;

    @JsonProperty("p_evctitular_oid")
    private TitularOid municipioInsMunicipioNacTitularpevcTitular;
    
    @JsonIgnore
    private Titular municipioInsMunicipioNacTitularpevcTitularInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkMunicipioInsMunicipioNacTitularpthisMunicipio();
        checkMunicipioInsMunicipioNacTitularpevcTitular();
    }

    @JsonIgnore
    public MunicipioOid getMunicipioInsMunicipioNacTitularpthisMunicipio() {
        return this.municipioInsMunicipioNacTitularpthisMunicipio;
    }
    
    public void setMunicipioInsMunicipioNacTitularpthisMunicipio(MunicipioOid municipioInsMunicipioNacTitularpthisMunicipio) {
        this.municipioInsMunicipioNacTitularpthisMunicipio = municipioInsMunicipioNacTitularpthisMunicipio;
    }

    @JsonIgnore
    public Municipio getMunicipioInsMunicipioNacTitularpthisMunicipioInstance() {
        return this.municipioInsMunicipioNacTitularpthisMunicipioInstance;
    }
    
    public void setMunicipioInsMunicipioNacTitularpthisMunicipioInstance(Municipio municipioInsMunicipioNacTitularpthisMunicipio) {
        this.municipioInsMunicipioNacTitularpthisMunicipioInstance = municipioInsMunicipioNacTitularpthisMunicipio;
        this.municipioInsMunicipioNacTitularpthisMunicipio = municipioInsMunicipioNacTitularpthisMunicipio != null ? municipioInsMunicipioNacTitularpthisMunicipio.getOid() : null;
    }

    private void checkMunicipioInsMunicipioNacTitularpthisMunicipio() throws NotNullArgumentException {
        if(this.getMunicipioInsMunicipioNacTitularpthisMunicipioInstance() == null || this.getMunicipioInsMunicipioNacTitularpthisMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_INSMUNICIPIONACTITULAR, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_INSMUNICIPIONACTITULAR_MUNICIPIOINSMUNICIPIONACTITULARPTHISMUNICIPIO, MunicipioConstants.SERV_ALIAS_INSMUNICIPIONACTITULAR, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_INSMUNICIPIONACTITULAR_MUNICIPIOINSMUNICIPIONACTITULARPTHISMUNICIPIO);
        }
    }

    @JsonIgnore
    public TitularOid getMunicipioInsMunicipioNacTitularpevcTitular() {
        return this.municipioInsMunicipioNacTitularpevcTitular;
    }
    
    public void setMunicipioInsMunicipioNacTitularpevcTitular(TitularOid municipioInsMunicipioNacTitularpevcTitular) {
        this.municipioInsMunicipioNacTitularpevcTitular = municipioInsMunicipioNacTitularpevcTitular;
    }

    @JsonIgnore
    public Titular getMunicipioInsMunicipioNacTitularpevcTitularInstance() {
        return this.municipioInsMunicipioNacTitularpevcTitularInstance;
    }
    
    public void setMunicipioInsMunicipioNacTitularpevcTitularInstance(Titular municipioInsMunicipioNacTitularpevcTitular) {
        this.municipioInsMunicipioNacTitularpevcTitularInstance = municipioInsMunicipioNacTitularpevcTitular;
        this.municipioInsMunicipioNacTitularpevcTitular = municipioInsMunicipioNacTitularpevcTitular != null ? municipioInsMunicipioNacTitularpevcTitular.getOid() : null;
    }

    private void checkMunicipioInsMunicipioNacTitularpevcTitular() throws NotNullArgumentException {
        if(this.getMunicipioInsMunicipioNacTitularpevcTitularInstance() == null || this.getMunicipioInsMunicipioNacTitularpevcTitularInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_INSMUNICIPIONACTITULAR, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_INSMUNICIPIONACTITULAR_MUNICIPIOINSMUNICIPIONACTITULARPEVCTITULAR, MunicipioConstants.SERV_ALIAS_INSMUNICIPIONACTITULAR, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_INSMUNICIPIONACTITULAR_MUNICIPIOINSMUNICIPIONACTITULARPEVCTITULAR);
        }
    }
}
