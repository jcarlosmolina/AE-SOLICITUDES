package com.keralty.integraciones.emailnotification.binarysent.file;

import com.fasterxml.jackson.annotation.*;

public class Data {
    private String status;
    private String message;

    @JsonProperty("status")
    public String getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(String value) { this.status = value; }

    @JsonProperty("message")
    public String getMessage() { return message; }
    @JsonProperty("message")
    public void setMessage(String value) { this.message = value; }
}
