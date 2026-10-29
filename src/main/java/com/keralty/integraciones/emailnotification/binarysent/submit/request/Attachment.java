package com.keralty.integraciones.emailnotification.binarysent.submit.request;

import com.fasterxml.jackson.annotation.*;

public class Attachment {
    private String name;
    private String pdfCipherPass;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("pdfCipherPass")
    public String getPDFCipherPass() { return pdfCipherPass; }
    @JsonProperty("pdfCipherPass")
    public void setPDFCipherPass(String value) { this.pdfCipherPass = value; }
}
