package com.keralty.integraciones.organization.getorganization.response;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {
    private PurposeClass purpose;

    @JsonProperty("purpose")
    public PurposeClass getPurpose() { return purpose; }
    @JsonProperty("purpose")
    public void setPurpose(PurposeClass value) { this.purpose = value; }
}
