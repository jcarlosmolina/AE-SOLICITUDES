package com.keralty.integraciones.patient.questionnaire.request;

import com.fasterxml.jackson.annotation.*;

public class Entry {
    private Request request;

    @JsonProperty("request")
    public Request getRequest() { return request; }
    @JsonProperty("request")
    public void setRequest(Request value) { this.request = value; }

    
    @JsonIgnore
    public void asignarIdentificacion(String tipoIdentificiacion, String numeroIdentificacion) {
    	setRequest(new Request());
    	getRequest().asignarIdentificacion(tipoIdentificiacion, numeroIdentificacion);
	}
}
