package com.keralty.integraciones.emailnotification.binarysent.submit.request;

import com.fasterxml.jackson.annotation.*;

public class PayloadSubmitRequest {
    private Headers headers;
    private Body body;

    @JsonProperty("HEADERS")
    public Headers getHeaders() { return headers; }
    @JsonProperty("HEADERS")
    public void setHeaders(Headers value) { this.headers = value; }

    @JsonProperty("BODY")
    public Body getBody() { return body; }
    @JsonProperty("BODY")
    public void setBody(Body value) { this.body = value; }
}
