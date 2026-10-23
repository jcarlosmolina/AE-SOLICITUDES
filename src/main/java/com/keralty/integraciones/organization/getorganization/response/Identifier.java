package com.keralty.integraciones.organization.getorganization.response;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Identifier {
    private IdentifierType type;
    private String value;

    @JsonProperty("type")
    public IdentifierType getType() { return type; }
    @JsonProperty("type")
    public void setType(IdentifierType value) { this.type = value; }

    @JsonProperty("value")
    public String getValue() { return value; }
    @JsonProperty("value")
    public void setValue(String value) { this.value = value; }
}
