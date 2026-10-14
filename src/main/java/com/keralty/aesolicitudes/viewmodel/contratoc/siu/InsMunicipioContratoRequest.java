package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;

public class InsMunicipioContratoRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCInsMunicipioContratopthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCInsMunicipioContratopthisContratoCInstance;

    @JsonProperty("p_evcmunicipio_oid")
    private MunicipioOid contratoCInsMunicipioContratopevcMunicipio;
    
    @JsonIgnore
    private Municipio contratoCInsMunicipioContratopevcMunicipioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCInsMunicipioContratopthisContratoC();
        checkContratoCInsMunicipioContratopevcMunicipio();
    }

    @JsonIgnore
    public ContratoCOid getContratoCInsMunicipioContratopthisContratoC() {
        return this.contratoCInsMunicipioContratopthisContratoC;
    }
    
    public void setContratoCInsMunicipioContratopthisContratoC(ContratoCOid contratoCInsMunicipioContratopthisContratoC) {
        this.contratoCInsMunicipioContratopthisContratoC = contratoCInsMunicipioContratopthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCInsMunicipioContratopthisContratoCInstance() {
        return this.contratoCInsMunicipioContratopthisContratoCInstance;
    }
    
    public void setContratoCInsMunicipioContratopthisContratoCInstance(ContratoC contratoCInsMunicipioContratopthisContratoC) {
        this.contratoCInsMunicipioContratopthisContratoCInstance = contratoCInsMunicipioContratopthisContratoC;
        this.contratoCInsMunicipioContratopthisContratoC = contratoCInsMunicipioContratopthisContratoC != null ? contratoCInsMunicipioContratopthisContratoC.getOid() : null;
    }

    private void checkContratoCInsMunicipioContratopthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCInsMunicipioContratopthisContratoCInstance() == null || this.getContratoCInsMunicipioContratopthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_INSMUNICIPIOCONTRATO, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_INSMUNICIPIOCONTRATO_CONTRATOCINSMUNICIPIOCONTRATOPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_INSMUNICIPIOCONTRATO, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_INSMUNICIPIOCONTRATO_CONTRATOCINSMUNICIPIOCONTRATOPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public MunicipioOid getContratoCInsMunicipioContratopevcMunicipio() {
        return this.contratoCInsMunicipioContratopevcMunicipio;
    }
    
    public void setContratoCInsMunicipioContratopevcMunicipio(MunicipioOid contratoCInsMunicipioContratopevcMunicipio) {
        this.contratoCInsMunicipioContratopevcMunicipio = contratoCInsMunicipioContratopevcMunicipio;
    }

    @JsonIgnore
    public Municipio getContratoCInsMunicipioContratopevcMunicipioInstance() {
        return this.contratoCInsMunicipioContratopevcMunicipioInstance;
    }
    
    public void setContratoCInsMunicipioContratopevcMunicipioInstance(Municipio contratoCInsMunicipioContratopevcMunicipio) {
        this.contratoCInsMunicipioContratopevcMunicipioInstance = contratoCInsMunicipioContratopevcMunicipio;
        this.contratoCInsMunicipioContratopevcMunicipio = contratoCInsMunicipioContratopevcMunicipio != null ? contratoCInsMunicipioContratopevcMunicipio.getOid() : null;
    }

    private void checkContratoCInsMunicipioContratopevcMunicipio() throws NotNullArgumentException {
        if(this.getContratoCInsMunicipioContratopevcMunicipioInstance() == null || this.getContratoCInsMunicipioContratopevcMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_INSMUNICIPIOCONTRATO, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_INSMUNICIPIOCONTRATO_CONTRATOCINSMUNICIPIOCONTRATOPEVCMUNICIPIO, ContratoCConstants.SERV_ALIAS_INSMUNICIPIOCONTRATO, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_INSMUNICIPIOCONTRATO_CONTRATOCINSMUNICIPIOCONTRATOPEVCMUNICIPIO);
        }
    }
}
