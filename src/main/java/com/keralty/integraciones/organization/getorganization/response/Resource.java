package com.keralty.integraciones.organization.getorganization.response;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Resource {
    private Schema schema;

    @JsonProperty("schema")
    public Schema getSchema() { return schema; }
    @JsonProperty("schema")
    public void setSchema(Schema value) { this.schema = value; }
}
