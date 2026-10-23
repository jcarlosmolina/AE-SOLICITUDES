package com.keralty.integraciones.organization.getorganization.response;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class PurposeClass {
    private List<PurposeCoding> coding;

    @JsonProperty("coding")
    public List<PurposeCoding> getCoding() { return coding; }
    @JsonProperty("coding")
    public void setCoding(List<PurposeCoding> value) { this.coding = value; }
}
