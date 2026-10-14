package com.keralty.aesolicitudes.viewmodel.anexoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.AnexoCConstants;
import com.keralty.aesolicitudes.persistence.AnexoC;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.oid.AnexoCOid;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;

public class TCREARFROMWSRequest {

    @JsonProperty("pbeneficiarioc_oid")
    private BeneficiarioCOid anexoCTCREARFROMWSpBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC anexoCTCREARFROMWSpBeneficiarioCInstance;

    @JsonProperty("panexoc_oid")
    private AnexoCOid anexoCTCREARFROMWSpAnexoC;
    
    @JsonIgnore
    private AnexoC anexoCTCREARFROMWSpAnexoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAnexoCTCREARFROMWSpBeneficiarioC();
        checkAnexoCTCREARFROMWSpAnexoC();
    }

    @JsonIgnore
    public BeneficiarioCOid getAnexoCTCREARFROMWSpBeneficiarioC() {
        return this.anexoCTCREARFROMWSpBeneficiarioC;
    }
    
    public void setAnexoCTCREARFROMWSpBeneficiarioC(BeneficiarioCOid anexoCTCREARFROMWSpBeneficiarioC) {
        this.anexoCTCREARFROMWSpBeneficiarioC = anexoCTCREARFROMWSpBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getAnexoCTCREARFROMWSpBeneficiarioCInstance() {
        return this.anexoCTCREARFROMWSpBeneficiarioCInstance;
    }
    
    public void setAnexoCTCREARFROMWSpBeneficiarioCInstance(BeneficiarioC anexoCTCREARFROMWSpBeneficiarioC) {
        this.anexoCTCREARFROMWSpBeneficiarioCInstance = anexoCTCREARFROMWSpBeneficiarioC;
        this.anexoCTCREARFROMWSpBeneficiarioC = anexoCTCREARFROMWSpBeneficiarioC != null ? anexoCTCREARFROMWSpBeneficiarioC.getOid() : null;
    }

    private void checkAnexoCTCREARFROMWSpBeneficiarioC() throws NotNullArgumentException {
        if(this.getAnexoCTCREARFROMWSpBeneficiarioCInstance() == null || this.getAnexoCTCREARFROMWSpBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(AnexoCConstants.SERV_ID_TCREARFROMWS, AnexoCConstants.CLASS_ID, AnexoCConstants.ARG_ID_TCREARFROMWS_ANEXOCTCREARFROMWSPBENEFICIARIOC, AnexoCConstants.SERV_ALIAS_TCREARFROMWS, AnexoCConstants.CLASS_ALIAS, AnexoCConstants.ARG_ALIAS_TCREARFROMWS_ANEXOCTCREARFROMWSPBENEFICIARIOC);
        }
    }

    @JsonIgnore
    public AnexoCOid getAnexoCTCREARFROMWSpAnexoC() {
        return this.anexoCTCREARFROMWSpAnexoC;
    }
    
    public void setAnexoCTCREARFROMWSpAnexoC(AnexoCOid anexoCTCREARFROMWSpAnexoC) {
        this.anexoCTCREARFROMWSpAnexoC = anexoCTCREARFROMWSpAnexoC;
    }

    @JsonIgnore
    public AnexoC getAnexoCTCREARFROMWSpAnexoCInstance() {
        return this.anexoCTCREARFROMWSpAnexoCInstance;
    }
    
    public void setAnexoCTCREARFROMWSpAnexoCInstance(AnexoC anexoCTCREARFROMWSpAnexoC) {
        this.anexoCTCREARFROMWSpAnexoCInstance = anexoCTCREARFROMWSpAnexoC;
        this.anexoCTCREARFROMWSpAnexoC = anexoCTCREARFROMWSpAnexoC != null ? anexoCTCREARFROMWSpAnexoC.getOid() : null;
    }

    private void checkAnexoCTCREARFROMWSpAnexoC() throws NotNullArgumentException {
        if(this.getAnexoCTCREARFROMWSpAnexoCInstance() == null || this.getAnexoCTCREARFROMWSpAnexoCInstance().isNull()) {
            throw new NotNullArgumentException(AnexoCConstants.SERV_ID_TCREARFROMWS, AnexoCConstants.CLASS_ID, AnexoCConstants.ARG_ID_TCREARFROMWS_ANEXOCTCREARFROMWSPANEXOC, AnexoCConstants.SERV_ALIAS_TCREARFROMWS, AnexoCConstants.CLASS_ALIAS, AnexoCConstants.ARG_ALIAS_TCREARFROMWS_ANEXOCTCREARFROMWSPANEXOC);
        }
    }
}
