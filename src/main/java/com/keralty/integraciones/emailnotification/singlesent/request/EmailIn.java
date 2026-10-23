package com.keralty.integraciones.emailnotification.singlesent.request;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class EmailIn {
    private List<Attachment> attachments;

    @JsonProperty("attachments")
    public List<Attachment> getAttachments() { return attachments; }
    @JsonProperty("attachments")
    public void setAttachments(List<Attachment> value) { this.attachments = value; }
}
