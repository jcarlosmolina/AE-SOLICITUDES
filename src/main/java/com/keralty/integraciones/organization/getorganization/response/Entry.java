package com.keralty.integraciones.organization.getorganization.response;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Entry {
    private Resource resource;

    @JsonProperty("resource")
    public Resource getResource() { return resource; }
    @JsonProperty("resource")
    public void setResource(Resource value) { this.resource = value; }
    
    @JsonIgnore
	public String getCorreoElectronico() {
		if (getResource() != null && getResource().getSchema() != null && getResource().getSchema().getTelecom() != null) {
			for (Telecom tele : getResource().getSchema().getTelecom()) {
				if ("email".equalsIgnoreCase(tele.getSystem())) {
					return tele.getValue();
				}
			}
		}
    	return null;
    }

    @JsonIgnore
    public String getTelefonoCelular() {
		if (getResource() != null && getResource().getSchema() != null && getResource().getSchema().getTelecom() != null) {
			for (Telecom tele : getResource().getSchema().getTelecom()) {
				if ("phone".equalsIgnoreCase(tele.getSystem())) {
					return tele.getValue();
				}
			}
		}		
		return null;
	}
    
    @JsonIgnore
	public String getTelefonoFijoResidencia() {
		if (getResource() != null && getResource().getSchema() != null && getResource().getSchema().getTelecom() != null) {
			for (Telecom tele : getResource().getSchema().getTelecom()) {
				if ("phone".equalsIgnoreCase(tele.getSystem())) {
					return tele.getValue();
				}
			}
		}		
		return null;
	}
    
    
    @JsonIgnore
    public String getCodeBySystem(String systemValue) {
    	if (systemValue != null && getResource() != null && getResource().getSchema() != null && getResource().getSchema().getType() != null &&
    			getResource().getSchema().getType().getCoding() != null) {
			for (PurposeCoding coding : getResource().getSchema().getType().getCoding()) {
				if (systemValue.equalsIgnoreCase(coding.getSystem())) {
					return coding.getCode();
				}
			}
    	}
    	return null;
    }

    @JsonIgnore
    public String getNombre() {
    	if (getResource() != null && getResource().getSchema() != null) {
    		return getResource().getSchema().getName();
    	}
    	return "";
    }    
    
}
