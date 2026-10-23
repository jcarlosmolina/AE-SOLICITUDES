package com.keralty.integraciones.organization.getorganization;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.integraciones.organization.getorganization.response.Address;
import com.keralty.integraciones.organization.getorganization.response.Entry;
import com.keralty.integraciones.organization.getorganization.response.GetOrganizationResponse;
import com.keralty.integraciones.organization.getorganization.response.PurposeCoding;
import com.keralty.integraciones.organization.getorganization.response.Schema;
import com.keralty.integraciones.organization.getorganization.response.Telecom;

public class ConsultarPersonaJuridicaResponse {
    private GetOrganizationResponse getOrganizationResponse;
    private boolean exito = true;
    private String textoError = null;
    private Address direccion = null;
    private String email = null;
    private String telefonoFijo = null;
    private String telefonoCelular = null;

   
	@JsonProperty("getOrganizationResponse")
    public GetOrganizationResponse getGetOrganizationResponse() { return getOrganizationResponse; }
	@JsonProperty("getOrganizationResponse")
	public void setGetOrganizationResponse(GetOrganizationResponse getOrganizationResponse) { this.getOrganizationResponse = getOrganizationResponse; }

	@JsonProperty("exito")
    public boolean isExito() { return exito; }
    @JsonProperty("exito")
	public void setExito(boolean exito) { this.exito = exito; }
	
    @JsonProperty("textoError")
    public String getTextoError() { return textoError; }
    @JsonProperty("textoError")
	public void setTextoError(String textoError) { this.textoError = textoError; }

    
    
	@JsonProperty("email")
    public String getEmail() { return email; }
	@JsonProperty("email")
	public void setEmail(String email) { this.email = email; }
	
	@JsonProperty("telefonoFijo")
	public String getTelefonoFijo() { return telefonoFijo; }
	@JsonProperty("telefonoFijo")
	public void setTelefonoFijo(String telefonoFijo) { this.telefonoFijo = telefonoFijo; }
	
	@JsonProperty("telefonoCelular")
	public String getTelefonoCelular() { return telefonoCelular; }
	@JsonProperty("telefonoCelular")
	public void setTelefonoCelular(String telefonoCelular) { this.telefonoCelular = telefonoCelular; }
	
	@JsonProperty("direccion")
	public void setDireccion(Address direccion) { this.direccion = direccion; }
	@JsonProperty("direccion")
	public Address getDireccion() { return direccion; }
	
	
	/**
     * Comprueba si se ha producido algún error en la respuesta de BH y ajusta los valores de las variables 
     */
    public void checkError() {
    	
	}
    
    @JsonIgnore
	public static String getValueTelecomPorSystem(List<Telecom> lista, String valorSystem) {
    	if (lista == null || valorSystem == null || valorSystem.isEmpty()) {
    		return null;
    	}
    	for (Telecom tele : lista) {
    		if (valorSystem.equals(tele.getSystem())) {
    			return tele.getValue();
    		}
    	}
    	return null;
    }


    private void anyadirTextoError(String texto) {
    	if (texto == null || texto.isEmpty()) {
    		return;
    	}
    	if (getTextoError() == null || getTextoError().isEmpty()) {
    		setTextoError(texto);
    	} else {
    		setTextoError(getTextoError() + " " + texto);
    	}
    }
    
    /**
     * Devuelve la dirección de la sede principal
     * @return
     */
    @JsonIgnore
    public void localizarDatos() {
    	
    	direccion = null;
    	if (getGetOrganizationResponse() == null || getGetOrganizationResponse().getEntry() == null) {
    		return;
    	}
    	
    	// Buscamos la que tenga los sigueitnes valores en el elemento:
    	// resource - schema 
		//"type": {
		//    "coding": [
		//        {
		//            "system": "BH/branchType",
		//            "code": "1"
		//        }
		//    ]
		//},
    	Schema schemaSedePpal = null;
    	for (Entry entry : getGetOrganizationResponse().getEntry()) {
    		if (entry.getResource() == null || 
    				entry.getResource().getSchema() == null ||
    				entry.getResource().getSchema().getType() == null ||
    				entry.getResource().getSchema().getType().getCoding() == null) {
    			continue;
    		}
    		for (PurposeCoding coding : entry.getResource().getSchema().getType().getCoding()) {
    			if ("BH/branchType".equalsIgnoreCase(coding.getSystem()) &&
    				"1".equalsIgnoreCase(coding.getCode())) {
    				schemaSedePpal = entry.getResource().getSchema();
    				break;
    			}
    		}
    	}
    	
    	// Si no la encontramos nos quedamos con la primera, que en realidad es la segunda 
    	if (schemaSedePpal == null && getGetOrganizationResponse().getEntry().size() > 1 &&
    			getGetOrganizationResponse().getEntry().get(1).getResource() != null) {
    		schemaSedePpal = getGetOrganizationResponse().getEntry().get(1).getResource().getSchema();
    	}
    	
    	if (schemaSedePpal != null && schemaSedePpal.getAddress() != null && !schemaSedePpal.getAddress().isEmpty())  {
//    		for (Address add : schemaSedePpal.getAddress()) {
//    			if ("".equalsIgnoreCase(add.getText())) {
//    				address = add;
//    				break;
//    			}
//    		}
    		
    		// Si no encontramos, cogemos la primera
    		direccion = schemaSedePpal.getAddress().get(0);
    		
    		setTelefonoFijo(getValueTelecomPorSystem(schemaSedePpal.getTelecom(), "phone"));
    		setTelefonoCelular(getValueTelecomPorSystem(schemaSedePpal.getTelecom(), "phone"));
    		setEmail(getValueTelecomPorSystem(schemaSedePpal.getTelecom(), "email"));
    	}
    }
}
