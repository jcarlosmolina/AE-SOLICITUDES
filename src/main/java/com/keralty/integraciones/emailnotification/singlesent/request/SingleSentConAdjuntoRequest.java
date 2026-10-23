package com.keralty.integraciones.emailnotification.singlesent.request;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude( content = Include.NON_NULL)
public class SingleSentConAdjuntoRequest extends SingleSentRequest{
    private EmailIn emailIn;

    @JsonProperty("emailIn")
    public EmailIn getEmailIn() { return emailIn; }
    @JsonProperty("emailIn")
    public void setEmailIn(EmailIn value) { this.emailIn = value; }
}
