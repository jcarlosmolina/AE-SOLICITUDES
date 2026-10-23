package com.keralty.integraciones.patient.questionnaire.request;

import com.fasterxml.jackson.annotation.*;

public class Request {
    private String method = "GET";
    private String url = "QuestionnaireResponse?patient=Patient/";

    @JsonProperty("method")
    public String getMethod() { return method; }
    @JsonProperty("method")
    public void setMethod(String value) { this.method = value; }

    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }
    
    @JsonIgnore
    public void asignarIdentificacion(String tipoIdentificiacion, String numeroIdentificacion) {
    	setURL("QuestionnaireResponse?patient=Patient/" + tipoIdentificiacion + numeroIdentificacion);
    }
}
