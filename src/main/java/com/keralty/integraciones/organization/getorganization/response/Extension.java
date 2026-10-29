package com.keralty.integraciones.organization.getorganization.response;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Extension {
    private String url;
    private String valueString;

    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }

    @JsonProperty("valueString")
    public String getValueString() { return valueString; }
    @JsonProperty("valueString")
    public void setValueString(String value) { this.valueString = value; }
}
