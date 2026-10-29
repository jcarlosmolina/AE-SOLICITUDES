package com.keralty.integraciones.emailnotification.binarysent.submit.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PayloadSubmitResponse {
    private String code;
    private String value;

	@JsonProperty("code")
    public String getCode() { return code; }
	@JsonProperty("code")
	public void setCode(String code) { this.code = code; }

	@JsonProperty("value")
	public String getValue() { return value; }
	@JsonProperty("value")
	public void setValue(String value) { this.value = value; }
}
