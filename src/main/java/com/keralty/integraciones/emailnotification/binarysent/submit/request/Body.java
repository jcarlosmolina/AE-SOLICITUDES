package com.keralty.integraciones.emailnotification.binarysent.submit.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Body {
    private String tokenPy;
    private String application;
    private EmailIn emailIn;
    private String subject;
    private String mensajeString;
    private String certimail;
    private String mailTo;
    private String mailConfirmation;
    private String annotations;

    @JsonProperty("token_py")
    public String getTokenPy() { return tokenPy; }
    @JsonProperty("token_py")
    public void setTokenPy(String value) { this.tokenPy = value; }

    @JsonProperty("application")
    public String getApplication() { return application; }
    @JsonProperty("application")
    public void setApplication(String value) { this.application = value; }

    @JsonProperty("emailIn")
    public EmailIn getEmailIn() { return emailIn; }
    @JsonProperty("emailIn")
    public void setEmailIn(EmailIn value) { this.emailIn = value; }

    @JsonProperty("subject")
    public String getSubject() { return subject; }
    @JsonProperty("subject")
    public void setSubject(String value) { this.subject = value; }

    @JsonProperty("mensaje_string")
    public String getMensajeString() { return mensajeString; }
    @JsonProperty("mensaje_string")
    public void setMensajeString(String value) { this.mensajeString = value; }

    @JsonProperty("certimail")
    public String getCertimail() { return certimail; }
    @JsonProperty("certimail")
    public void setCertimail(String value) { this.certimail = value; }

    @JsonProperty("mailTo")
    public String getMailTo() { return mailTo; }
    @JsonProperty("mailTo")
    public void setMailTo(String value) { this.mailTo = value; }

    @JsonProperty("mailConfirmation")
    public String getMailConfirmation() { return mailConfirmation; }
    @JsonProperty("mailConfirmation")
    public void setMailConfirmation(String value) { this.mailConfirmation = value; }

    @JsonProperty("annotations")
    public String getAnnotations() { return annotations; }
    @JsonProperty("annotations")
    public void setAnnotations(String value) { this.annotations = value; }
}
