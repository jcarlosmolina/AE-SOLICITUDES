package com.keralty.aesolicitudes.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class OGASIGUSUARIOSResponse extends ServiceResponse {

    @JsonProperty("oaprocesados")
    private Long oGASIGUSUARIOSoaProcesados;

    @JsonProperty("oaerrores")
    private Long oGASIGUSUARIOSoaErrores;

    @JsonProperty("oatextoerrores")
    private String oGASIGUSUARIOSoaTextoErrores;

    public OGASIGUSUARIOSResponse() {
        super();
    }

    @JsonIgnore
    public Long getOGASIGUSUARIOSoaProcesados() {
        return this.oGASIGUSUARIOSoaProcesados;
    }

    public void setOGASIGUSUARIOSoaProcesados(Long oGASIGUSUARIOSoaProcesados) {
        this.oGASIGUSUARIOSoaProcesados = oGASIGUSUARIOSoaProcesados;
    }

    @JsonIgnore
    public Long getOGASIGUSUARIOSoaErrores() {
        return this.oGASIGUSUARIOSoaErrores;
    }

    public void setOGASIGUSUARIOSoaErrores(Long oGASIGUSUARIOSoaErrores) {
        this.oGASIGUSUARIOSoaErrores = oGASIGUSUARIOSoaErrores;
    }

    @JsonIgnore
    public String getOGASIGUSUARIOSoaTextoErrores() {
        return this.oGASIGUSUARIOSoaTextoErrores;
    }

    public void setOGASIGUSUARIOSoaTextoErrores(String oGASIGUSUARIOSoaTextoErrores) {
        this.oGASIGUSUARIOSoaTextoErrores = oGASIGUSUARIOSoaTextoErrores;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("oGASIGUSUARIOSoaProcesados", oGASIGUSUARIOSoaProcesados);
        outArgs.put("oGASIGUSUARIOSoaErrores", oGASIGUSUARIOSoaErrores);
        outArgs.put("oGASIGUSUARIOSoaTextoErrores", oGASIGUSUARIOSoaTextoErrores);
        return outArgs;
    }
}
