package com.keralty.aesolicitudes.viewmodel.conceptoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ConceptoCConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.ConceptoC;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.ConceptoCOid;

public class TCREARFROMWSRequest {

    @JsonProperty("pconceptoc_oid")
    private ConceptoCOid conceptoCTCREARFROMWSpConceptoC;
    
    @JsonIgnore
    private ConceptoC conceptoCTCREARFROMWSpConceptoCInstance;

    @JsonProperty("pbeneficiarioc_oid")
    private BeneficiarioCOid conceptoCTCREARFROMWSpBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC conceptoCTCREARFROMWSpBeneficiarioCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkConceptoCTCREARFROMWSpConceptoC();
        checkConceptoCTCREARFROMWSpBeneficiarioC();
    }

    @JsonIgnore
    public ConceptoCOid getConceptoCTCREARFROMWSpConceptoC() {
        return this.conceptoCTCREARFROMWSpConceptoC;
    }
    
    public void setConceptoCTCREARFROMWSpConceptoC(ConceptoCOid conceptoCTCREARFROMWSpConceptoC) {
        this.conceptoCTCREARFROMWSpConceptoC = conceptoCTCREARFROMWSpConceptoC;
    }

    @JsonIgnore
    public ConceptoC getConceptoCTCREARFROMWSpConceptoCInstance() {
        return this.conceptoCTCREARFROMWSpConceptoCInstance;
    }
    
    public void setConceptoCTCREARFROMWSpConceptoCInstance(ConceptoC conceptoCTCREARFROMWSpConceptoC) {
        this.conceptoCTCREARFROMWSpConceptoCInstance = conceptoCTCREARFROMWSpConceptoC;
        this.conceptoCTCREARFROMWSpConceptoC = conceptoCTCREARFROMWSpConceptoC != null ? conceptoCTCREARFROMWSpConceptoC.getOid() : null;
    }

    private void checkConceptoCTCREARFROMWSpConceptoC() throws NotNullArgumentException {
        if(this.getConceptoCTCREARFROMWSpConceptoCInstance() == null || this.getConceptoCTCREARFROMWSpConceptoCInstance().isNull()) {
            throw new NotNullArgumentException(ConceptoCConstants.SERV_ID_TCREARFROMWS, ConceptoCConstants.CLASS_ID, ConceptoCConstants.ARG_ID_TCREARFROMWS_CONCEPTOCTCREARFROMWSPCONCEPTOC, ConceptoCConstants.SERV_ALIAS_TCREARFROMWS, ConceptoCConstants.CLASS_ALIAS, ConceptoCConstants.ARG_ALIAS_TCREARFROMWS_CONCEPTOCTCREARFROMWSPCONCEPTOC);
        }
    }

    @JsonIgnore
    public BeneficiarioCOid getConceptoCTCREARFROMWSpBeneficiarioC() {
        return this.conceptoCTCREARFROMWSpBeneficiarioC;
    }
    
    public void setConceptoCTCREARFROMWSpBeneficiarioC(BeneficiarioCOid conceptoCTCREARFROMWSpBeneficiarioC) {
        this.conceptoCTCREARFROMWSpBeneficiarioC = conceptoCTCREARFROMWSpBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getConceptoCTCREARFROMWSpBeneficiarioCInstance() {
        return this.conceptoCTCREARFROMWSpBeneficiarioCInstance;
    }
    
    public void setConceptoCTCREARFROMWSpBeneficiarioCInstance(BeneficiarioC conceptoCTCREARFROMWSpBeneficiarioC) {
        this.conceptoCTCREARFROMWSpBeneficiarioCInstance = conceptoCTCREARFROMWSpBeneficiarioC;
        this.conceptoCTCREARFROMWSpBeneficiarioC = conceptoCTCREARFROMWSpBeneficiarioC != null ? conceptoCTCREARFROMWSpBeneficiarioC.getOid() : null;
    }

    private void checkConceptoCTCREARFROMWSpBeneficiarioC() throws NotNullArgumentException {
        if(this.getConceptoCTCREARFROMWSpBeneficiarioCInstance() == null || this.getConceptoCTCREARFROMWSpBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(ConceptoCConstants.SERV_ID_TCREARFROMWS, ConceptoCConstants.CLASS_ID, ConceptoCConstants.ARG_ID_TCREARFROMWS_CONCEPTOCTCREARFROMWSPBENEFICIARIOC, ConceptoCConstants.SERV_ALIAS_TCREARFROMWS, ConceptoCConstants.CLASS_ALIAS, ConceptoCConstants.ARG_ALIAS_TCREARFROMWS_CONCEPTOCTCREARFROMWSPBENEFICIARIOC);
        }
    }
}
