package com.keralty.integraciones.organization.getorganization.response;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    private List<Extension> extension;
    private String text;
    private String line;
    private String city;
    private String state;
    private String country;

    @JsonProperty("extension")
    public List<Extension> getExtension() { return extension; }
    @JsonProperty("extension")
    public void setExtension(List<Extension> value) { this.extension = value; }

    @JsonProperty("text")
    public String getText() { return text; }
    @JsonProperty("text")
    public void setText(String value) { this.text = value; }

    @JsonProperty("line")
    public String getLine() { return line; }
    @JsonProperty("line")
    public void setLine(String value) { this.line = value; }

    @JsonProperty("city")
    public String getCity() { return city; }
    @JsonProperty("city")
    public void setCity(String value) { this.city = value; }

    @JsonProperty("state")
    public String getState() { return state; }
    @JsonProperty("state")
    public void setState(String value) { this.state = value; }

    @JsonProperty("country")
    public String getCountry() { return country; }
    @JsonProperty("country")
    public void setCountry(String value) { this.country = value; }
}
