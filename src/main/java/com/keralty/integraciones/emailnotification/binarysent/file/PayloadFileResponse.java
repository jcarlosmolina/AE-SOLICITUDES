package com.keralty.integraciones.emailnotification.binarysent.file;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PayloadFileResponse {
    private Data data;

    @JsonProperty("data")
    public Data getData() { return data; }
    @JsonProperty("data")
    public void setData(Data value) { this.data = value; }
}
