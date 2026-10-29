package com.keralty.aesolicitudes.viewmodel.conceptoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ConceptoCConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;

public class CrearRequest {

    @JsonProperty("p_agrbeneficiarioc_oid")
    private BeneficiarioCOid conceptoCcrearpagrBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC conceptoCcrearpagrBeneficiarioCInstance;

    @JsonProperty("p_atrcodconceptocontrato")
    private String conceptoCcrearpatrcodConceptoContrato;

    @JsonProperty("p_atrnombreconcepto")
    private String conceptoCcrearpatrnombreConcepto;

    @JsonProperty("p_atrporcentajeconcepto")
    private Double conceptoCcrearpatrporcentajeConcepto;

    @JsonProperty("p_atrvalorconcepto")
    private Double conceptoCcrearpatrvalorConcepto;

    public void checkArguments() throws NotNullArgumentException {
        checkConceptoCcrearpagrBeneficiarioC();
    }

    @JsonIgnore
    public BeneficiarioCOid getConceptoCcrearpagrBeneficiarioC() {
        return this.conceptoCcrearpagrBeneficiarioC;
    }
    
    public void setConceptoCcrearpagrBeneficiarioC(BeneficiarioCOid conceptoCcrearpagrBeneficiarioC) {
        this.conceptoCcrearpagrBeneficiarioC = conceptoCcrearpagrBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getConceptoCcrearpagrBeneficiarioCInstance() {
        return this.conceptoCcrearpagrBeneficiarioCInstance;
    }
    
    public void setConceptoCcrearpagrBeneficiarioCInstance(BeneficiarioC conceptoCcrearpagrBeneficiarioC) {
        this.conceptoCcrearpagrBeneficiarioCInstance = conceptoCcrearpagrBeneficiarioC;
        this.conceptoCcrearpagrBeneficiarioC = conceptoCcrearpagrBeneficiarioC != null ? conceptoCcrearpagrBeneficiarioC.getOid() : null;
    }

    private void checkConceptoCcrearpagrBeneficiarioC() throws NotNullArgumentException {
        if(this.getConceptoCcrearpagrBeneficiarioCInstance() == null || this.getConceptoCcrearpagrBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(ConceptoCConstants.SERV_ID_CREAR, ConceptoCConstants.CLASS_ID, ConceptoCConstants.ARG_ID_CREAR_CONCEPTOCCREARPAGRBENEFICIARIOC, ConceptoCConstants.SERV_ALIAS_CREAR, ConceptoCConstants.CLASS_ALIAS, ConceptoCConstants.ARG_ALIAS_CREAR_CONCEPTOCCREARPAGRBENEFICIARIOC);
        }
    }

    @JsonIgnore
    public String getConceptoCcrearpatrcodConceptoContrato() {
        return this.conceptoCcrearpatrcodConceptoContrato;
    }
    
    public void setConceptoCcrearpatrcodConceptoContrato(String conceptoCcrearpatrcodConceptoContrato) {
        this.conceptoCcrearpatrcodConceptoContrato = conceptoCcrearpatrcodConceptoContrato;
    }

    @JsonIgnore
    public String getConceptoCcrearpatrnombreConcepto() {
        return this.conceptoCcrearpatrnombreConcepto;
    }
    
    public void setConceptoCcrearpatrnombreConcepto(String conceptoCcrearpatrnombreConcepto) {
        this.conceptoCcrearpatrnombreConcepto = conceptoCcrearpatrnombreConcepto;
    }

    @JsonIgnore
    public Double getConceptoCcrearpatrporcentajeConcepto() {
        return this.conceptoCcrearpatrporcentajeConcepto;
    }
    
    public void setConceptoCcrearpatrporcentajeConcepto(Double conceptoCcrearpatrporcentajeConcepto) {
        this.conceptoCcrearpatrporcentajeConcepto = conceptoCcrearpatrporcentajeConcepto;
    }

    @JsonIgnore
    public Double getConceptoCcrearpatrvalorConcepto() {
        return this.conceptoCcrearpatrvalorConcepto;
    }
    
    public void setConceptoCcrearpatrvalorConcepto(Double conceptoCcrearpatrvalorConcepto) {
        this.conceptoCcrearpatrvalorConcepto = conceptoCcrearpatrvalorConcepto;
    }
}
