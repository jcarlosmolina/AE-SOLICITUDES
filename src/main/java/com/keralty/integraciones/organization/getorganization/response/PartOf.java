package com.keralty.integraciones.organization.getorganization.response;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PartOf {
    private String reference;
    private String type;

    @JsonProperty("reference")
    public String getReference() { return reference; }
    @JsonProperty("reference")
    public void setReference(String value) { this.reference = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }
}
