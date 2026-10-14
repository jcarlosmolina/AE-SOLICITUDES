package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;

public class TCREAROBS100Request {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCTCREAROBS100pthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCTCREAROBS100pthisContratoCInstance;

    @JsonProperty("p_obstext")
    private String contratoCTCREAROBS100pObsText;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCTCREAROBS100pthisContratoC();
        checkContratoCTCREAROBS100pObsText();
    }

    @JsonIgnore
    public ContratoCOid getContratoCTCREAROBS100pthisContratoC() {
        return this.contratoCTCREAROBS100pthisContratoC;
    }
    
    public void setContratoCTCREAROBS100pthisContratoC(ContratoCOid contratoCTCREAROBS100pthisContratoC) {
        this.contratoCTCREAROBS100pthisContratoC = contratoCTCREAROBS100pthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCTCREAROBS100pthisContratoCInstance() {
        return this.contratoCTCREAROBS100pthisContratoCInstance;
    }
    
    public void setContratoCTCREAROBS100pthisContratoCInstance(ContratoC contratoCTCREAROBS100pthisContratoC) {
        this.contratoCTCREAROBS100pthisContratoCInstance = contratoCTCREAROBS100pthisContratoC;
        this.contratoCTCREAROBS100pthisContratoC = contratoCTCREAROBS100pthisContratoC != null ? contratoCTCREAROBS100pthisContratoC.getOid() : null;
    }

    private void checkContratoCTCREAROBS100pthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCTCREAROBS100pthisContratoCInstance() == null || this.getContratoCTCREAROBS100pthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_TCREAROBS100, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_TCREAROBS100_CONTRATOCTCREAROBS100PTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_TCREAROBS100, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_TCREAROBS100_CONTRATOCTCREAROBS100PTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public String getContratoCTCREAROBS100pObsText() {
        return this.contratoCTCREAROBS100pObsText;
    }
    
    public void setContratoCTCREAROBS100pObsText(String contratoCTCREAROBS100pObsText) {
        this.contratoCTCREAROBS100pObsText = contratoCTCREAROBS100pObsText;
    }

    private void checkContratoCTCREAROBS100pObsText() throws NotNullArgumentException {
        if(this.getContratoCTCREAROBS100pObsText() == null) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_TCREAROBS100, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_TCREAROBS100_CONTRATOCTCREAROBS100POBSTEXT, ContratoCConstants.SERV_ALIAS_TCREAROBS100, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_TCREAROBS100_CONTRATOCTCREAROBS100POBSTEXT);
        }
    }
}
