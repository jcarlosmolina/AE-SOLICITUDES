package com.keralty.integraciones.organization.getorganization.response;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IdentifierType {
    private List<PurpleCoding> coding;

    @JsonProperty("coding")
    public List<PurpleCoding> getCoding() { return coding; }
    @JsonProperty("coding")
    public void setCoding(List<PurpleCoding> value) { this.coding = value; }
}
