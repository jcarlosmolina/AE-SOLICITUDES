package com.keralty.integraciones.emailnotification.singlesent.request;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude( content = Include.NON_NULL)
public class SingleSentRequest {
    private String application;
    private String subject;
    private String certimail;
    private String message;
    private String mailTo;
    private String mailCc;

    @JsonProperty("application")
    public String getApplication() { return application; }
    @JsonProperty("application")
    public void setApplication(String value) { this.application = value; }

    @JsonProperty("subject")
    public String getSubject() { return subject; }
    @JsonProperty("subject")
    public void setSubject(String value) { this.subject = value; }

    @JsonProperty("certimail")
    public String getCertimail() { return certimail; }
    @JsonProperty("certimail")
    public void setCertimail(String value) { this.certimail = value; }

    @JsonProperty("message")
    public String getMessage() { return message; }
    @JsonProperty("message")
    public void setMessage(String value) { this.message = value; }

    @JsonProperty("mailTo")
    public String getMailTo() { return mailTo; }
    @JsonProperty("mailTo")
    public void setMailTo(String value) { this.mailTo = value; }
    
    @JsonProperty("mailCc")
    public String getMailCc() { return mailCc; }
    @JsonProperty("mailCc")
	public void setMailCc(String mailCc) { this.mailCc = mailCc; }
}
