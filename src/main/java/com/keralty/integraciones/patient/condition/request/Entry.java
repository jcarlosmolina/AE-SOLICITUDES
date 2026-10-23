package com.keralty.integraciones.patient.condition.request;

import com.fasterxml.jackson.annotation.*;

public class Entry {
    private Request request;

    @JsonProperty("request")
    public Request getRequest() { return request; }
    @JsonProperty("request")
    public void setRequest(Request value) { this.request = value; }
	public void asignarIdentificacion(String tipoIdentificacion, String numeroIdentificacion) {
		setRequest(new Request());
		getRequest().asignarIdentificacion(tipoIdentificacion, numeroIdentificacion);
	}
}
