package com.keralty.integraciones.emailnotification.binarysent.payload;

import com.fasterxml.jackson.annotation.*;
import java.util.UUID;

public class Data {
    private String payloadID;
    private String uploadFileLink;
    private String submitFormLink;

    @JsonProperty("payloadId")
    public String getPayloadID() { return payloadID; }
    @JsonProperty("payloadId")
    public void setPayloadID(String value) { this.payloadID = value; }

    @JsonProperty("uploadFileLink")
    public String getUploadFileLink() { return uploadFileLink; }
    @JsonProperty("uploadFileLink")
    public void setUploadFileLink(String value) { this.uploadFileLink = value; }

    @JsonProperty("submitFormLink")
    public String getSubmitFormLink() { return submitFormLink; }
    @JsonProperty("submitFormLink")
    public void setSubmitFormLink(String value) { this.submitFormLink = value; }
}
