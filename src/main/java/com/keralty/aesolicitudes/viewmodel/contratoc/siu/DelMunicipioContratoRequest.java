package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;

public class DelMunicipioContratoRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCDelMunicipioContratopthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCDelMunicipioContratopthisContratoCInstance;

    @JsonProperty("p_evcmunicipio_oid")
    private MunicipioOid contratoCDelMunicipioContratopevcMunicipio;
    
    @JsonIgnore
    private Municipio contratoCDelMunicipioContratopevcMunicipioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCDelMunicipioContratopthisContratoC();
        checkContratoCDelMunicipioContratopevcMunicipio();
    }

    @JsonIgnore
    public ContratoCOid getContratoCDelMunicipioContratopthisContratoC() {
        return this.contratoCDelMunicipioContratopthisContratoC;
    }
    
    public void setContratoCDelMunicipioContratopthisContratoC(ContratoCOid contratoCDelMunicipioContratopthisContratoC) {
        this.contratoCDelMunicipioContratopthisContratoC = contratoCDelMunicipioContratopthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCDelMunicipioContratopthisContratoCInstance() {
        return this.contratoCDelMunicipioContratopthisContratoCInstance;
    }
    
    public void setContratoCDelMunicipioContratopthisContratoCInstance(ContratoC contratoCDelMunicipioContratopthisContratoC) {
        this.contratoCDelMunicipioContratopthisContratoCInstance = contratoCDelMunicipioContratopthisContratoC;
        this.contratoCDelMunicipioContratopthisContratoC = contratoCDelMunicipioContratopthisContratoC != null ? contratoCDelMunicipioContratopthisContratoC.getOid() : null;
    }

    private void checkContratoCDelMunicipioContratopthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCDelMunicipioContratopthisContratoCInstance() == null || this.getContratoCDelMunicipioContratopthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_DELMUNICIPIOCONTRATO, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_DELMUNICIPIOCONTRATO_CONTRATOCDELMUNICIPIOCONTRATOPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_DELMUNICIPIOCONTRATO, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_DELMUNICIPIOCONTRATO_CONTRATOCDELMUNICIPIOCONTRATOPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public MunicipioOid getContratoCDelMunicipioContratopevcMunicipio() {
        return this.contratoCDelMunicipioContratopevcMunicipio;
    }
    
    public void setContratoCDelMunicipioContratopevcMunicipio(MunicipioOid contratoCDelMunicipioContratopevcMunicipio) {
        this.contratoCDelMunicipioContratopevcMunicipio = contratoCDelMunicipioContratopevcMunicipio;
    }

    @JsonIgnore
    public Municipio getContratoCDelMunicipioContratopevcMunicipioInstance() {
        return this.contratoCDelMunicipioContratopevcMunicipioInstance;
    }
    
    public void setContratoCDelMunicipioContratopevcMunicipioInstance(Municipio contratoCDelMunicipioContratopevcMunicipio) {
        this.contratoCDelMunicipioContratopevcMunicipioInstance = contratoCDelMunicipioContratopevcMunicipio;
        this.contratoCDelMunicipioContratopevcMunicipio = contratoCDelMunicipioContratopevcMunicipio != null ? contratoCDelMunicipioContratopevcMunicipio.getOid() : null;
    }

    private void checkContratoCDelMunicipioContratopevcMunicipio() throws NotNullArgumentException {
        if(this.getContratoCDelMunicipioContratopevcMunicipioInstance() == null || this.getContratoCDelMunicipioContratopevcMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_DELMUNICIPIOCONTRATO, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_DELMUNICIPIOCONTRATO_CONTRATOCDELMUNICIPIOCONTRATOPEVCMUNICIPIO, ContratoCConstants.SERV_ALIAS_DELMUNICIPIOCONTRATO, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_DELMUNICIPIOCONTRATO_CONTRATOCDELMUNICIPIOCONTRATOPEVCMUNICIPIO);
        }
    }
}
