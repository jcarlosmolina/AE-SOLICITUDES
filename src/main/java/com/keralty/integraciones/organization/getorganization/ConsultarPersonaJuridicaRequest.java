package com.keralty.integraciones.organization.getorganization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConsultarPersonaJuridicaRequest {
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String numSolicitud;


	@JsonProperty("tipoIdentificacion")
    public String getTipoIdentificacion() { return tipoIdentificacion; }
	@JsonProperty("tipoIdentificacion")
	public void setTipoIdentificacion(String tipoIdentificacion) { this.tipoIdentificacion = tipoIdentificacion; }

	@JsonProperty("numeroIdentificacion")
	public String getNumeroIdentificacion() { return numeroIdentificacion; }
	@JsonProperty("numeroIdentificacion")
	public void setNumeroIdentificacion(String numeroIdentificacion) { this.numeroIdentificacion = numeroIdentificacion; }

	@JsonProperty("numSolicitud")
    public String getNumSolicitud() { return numSolicitud; }
    @JsonProperty("numSolicitud")
    public void setNumSolicitud(String value) { this.numSolicitud = value; }
}
