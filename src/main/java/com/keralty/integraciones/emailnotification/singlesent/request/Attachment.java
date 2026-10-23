package com.keralty.integraciones.emailnotification.singlesent.request;

import com.fasterxml.jackson.annotation.*;

public class Attachment {
    private String content;
    private String name;

    @JsonProperty("content")
    public String getContent() { return content; }
    @JsonProperty("content")
    public void setContent(String value) { this.content = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }
}
