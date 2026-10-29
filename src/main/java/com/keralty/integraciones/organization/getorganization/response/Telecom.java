package com.keralty.integraciones.organization.getorganization.response;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Telecom {
    private List<Extension> extension;
    private String system;
    private String value;

    @JsonProperty("extension")
    public List<Extension> getExtension() { return extension; }
    @JsonProperty("extension")
    public void setExtension(List<Extension> value) { this.extension = value; }

    @JsonProperty("system")
    public String getSystem() { return system; }
    @JsonProperty("system")
    public void setSystem(String value) { this.system = value; }

    @JsonProperty("value")
    public String getValue() { return value; }
    @JsonProperty("value")
    public void setValue(String value) { this.value = value; }
}
