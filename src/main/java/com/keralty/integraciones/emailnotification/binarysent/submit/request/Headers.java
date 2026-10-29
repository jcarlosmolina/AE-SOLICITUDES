package com.keralty.integraciones.emailnotification.binarysent.submit.request;

import com.fasterxml.jackson.annotation.*;

public class Headers {
    private String accept;
    private String petitionID;
    private String sentType;
    private String aplicationCod;
    private String terminalID;
    private String apIuser;
    private String dateRequest;
    private String mailFrom;
    private String contentType;

    @JsonProperty("accept")
    public String getAccept() { return accept; }
    @JsonProperty("accept")
    public void setAccept(String value) { this.accept = value; }

    @JsonProperty("petitionId")
    public String getPetitionID() { return petitionID; }
    @JsonProperty("petitionId")
    public void setPetitionID(String value) { this.petitionID = value; }

    @JsonProperty("sentType")
    public String getSentType() { return sentType; }
    @JsonProperty("sentType")
    public void setSentType(String value) { this.sentType = value; }

    @JsonProperty("aplicationCod")
    public String getAplicationCod() { return aplicationCod; }
    @JsonProperty("aplicationCod")
    public void setAplicationCod(String value) { this.aplicationCod = value; }

    @JsonProperty("terminalId")
    public String getTerminalID() { return terminalID; }
    @JsonProperty("terminalId")
    public void setTerminalID(String value) { this.terminalID = value; }

    @JsonProperty("APIuser")
    public String getApIuser() { return apIuser; }
    @JsonProperty("APIuser")
    public void setApIuser(String value) { this.apIuser = value; }

    @JsonProperty("dateRequest")
    public String getDateRequest() { return dateRequest; }
    @JsonProperty("dateRequest")
    public void setDateRequest(String value) { this.dateRequest = value; }

    @JsonProperty("mailFrom")
    public String getMailFrom() { return mailFrom; }
    @JsonProperty("mailFrom")
    public void setMailFrom(String value) { this.mailFrom = value; }

    @JsonProperty("Content_Type")
    public String getContentType() { return contentType; }
    @JsonProperty("Content_Type")
    public void setContentType(String value) { this.contentType = value; }
}
