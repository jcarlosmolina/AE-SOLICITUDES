package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TNEWDESDEAEResponse extends ServiceResponse {


    @JsonProperty("pscontratoc")
    private ContratoCOid contratoCTNEWDESDEAEpsContratoC;
    
    @JsonIgnore
    private ContratoC contratoCTNEWDESDEAEpsContratoCInstance;

    @JsonProperty("psnumcontrato")
    private String contratoCTNEWDESDEAEpsNumContrato;

    public TNEWDESDEAEResponse() {
        super();
    }

    @JsonIgnore
    public ContratoCOid getContratoCTNEWDESDEAEpsContratoC() {
        return this.contratoCTNEWDESDEAEpsContratoC;
    }
    
    public void setContratoCTNEWDESDEAEpsContratoC(ContratoCOid contratoCTNEWDESDEAEpsContratoC) {
        this.contratoCTNEWDESDEAEpsContratoC = contratoCTNEWDESDEAEpsContratoC;
    }
    @JsonIgnore
    public ContratoC getContratoCTNEWDESDEAEpsContratoCInstance() {
        return this.contratoCTNEWDESDEAEpsContratoCInstance;
    }
    
    public void setContratoCTNEWDESDEAEpsContratoCInstance(ContratoC contratoCTNEWDESDEAEpsContratoC) {
        if (contratoCTNEWDESDEAEpsContratoC != null && !contratoCTNEWDESDEAEpsContratoC.isNull()) {
            this.contratoCTNEWDESDEAEpsContratoC = contratoCTNEWDESDEAEpsContratoC.getOid();
            this.contratoCTNEWDESDEAEpsContratoCInstance = contratoCTNEWDESDEAEpsContratoC;
        } else {
            this.contratoCTNEWDESDEAEpsContratoC = null;
            this.contratoCTNEWDESDEAEpsContratoCInstance = null;
        }
    }

    @JsonIgnore
    public String getContratoCTNEWDESDEAEpsNumContrato() {
        return this.contratoCTNEWDESDEAEpsNumContrato;
    }
    
    public void setContratoCTNEWDESDEAEpsNumContrato(String contratoCTNEWDESDEAEpsNumContrato) {
        this.contratoCTNEWDESDEAEpsNumContrato = contratoCTNEWDESDEAEpsNumContrato;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("contratoCTNEWDESDEAEpsContratoC", contratoCTNEWDESDEAEpsContratoC);
        outArgs.put("contratoCTNEWDESDEAEpsNumContrato", contratoCTNEWDESDEAEpsNumContrato);
        return outArgs;
    }
}
