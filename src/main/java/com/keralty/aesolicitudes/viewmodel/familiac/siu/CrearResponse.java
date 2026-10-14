package com.keralty.aesolicitudes.viewmodel.familiac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class CrearResponse extends ServiceResponse {


    @JsonProperty("ps_familiacreada")
    private FamiliaCOid familiaCcrearpsFamiliaCreada;
    
    @JsonIgnore
    private FamiliaC familiaCcrearpsFamiliaCreadaInstance;

    public CrearResponse() {
        super();
    }

    @JsonIgnore
    public FamiliaCOid getFamiliaCcrearpsFamiliaCreada() {
        return this.familiaCcrearpsFamiliaCreada;
    }
    
    public void setFamiliaCcrearpsFamiliaCreada(FamiliaCOid familiaCcrearpsFamiliaCreada) {
        this.familiaCcrearpsFamiliaCreada = familiaCcrearpsFamiliaCreada;
    }
    @JsonIgnore
    public FamiliaC getFamiliaCcrearpsFamiliaCreadaInstance() {
        return this.familiaCcrearpsFamiliaCreadaInstance;
    }
    
    public void setFamiliaCcrearpsFamiliaCreadaInstance(FamiliaC familiaCcrearpsFamiliaCreada) {
        if (familiaCcrearpsFamiliaCreada != null && !familiaCcrearpsFamiliaCreada.isNull()) {
            this.familiaCcrearpsFamiliaCreada = familiaCcrearpsFamiliaCreada.getOid();
            this.familiaCcrearpsFamiliaCreadaInstance = familiaCcrearpsFamiliaCreada;
        } else {
            this.familiaCcrearpsFamiliaCreada = null;
            this.familiaCcrearpsFamiliaCreadaInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("familiaCcrearpsFamiliaCreada", familiaCcrearpsFamiliaCreada);
        return outArgs;
    }
}
