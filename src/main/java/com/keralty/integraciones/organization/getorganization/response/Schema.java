package com.keralty.integraciones.organization.getorganization.response;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Schema {
    private String resourcetype;
    private List<Identifier> identifier;
    private String active;
    private PurposeClass type;
    private String name;
    private List<Telecom> telecom;
    private List<Address> address;
//    private List<PartOf> partOf;
    private List<Contact> contact;

    @JsonProperty("resourcetype")
    public String getResourcetype() { return resourcetype; }
    @JsonProperty("resourcetype")
    public void setResourcetype(String value) { this.resourcetype = value; }

    @JsonProperty("identifier")
    public List<Identifier> getIdentifier() { return identifier; }
    @JsonProperty("identifier")
    public void setIdentifier(List<Identifier> value) { this.identifier = value; }

    @JsonProperty("active")
    public String getActive() { return active; }
    @JsonProperty("active")
    public void setActive(String value) { this.active = value; }

    @JsonProperty("type")
    public PurposeClass getType() { return type; }
    @JsonProperty("type")
    public void setType(PurposeClass value) { this.type = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("telecom")
    public List<Telecom> getTelecom() { return telecom; }
    @JsonProperty("telecom")
    public void setTelecom(List<Telecom> value) { this.telecom = value; }

    @JsonProperty("address")
    public List<Address> getAddress() { return address; }
    @JsonProperty("address")
    public void setAddress(List<Address> value) { this.address = value; }

//    @JsonProperty("partOf")
//    public List<PartOf> getPartOf() { return partOf; }
//    @JsonProperty("partOf")
//    public void setPartOf(List<PartOf> value) { this.partOf = value; }

    @JsonProperty("contact")
    public List<Contact> getContact() { return contact; }
    @JsonProperty("contact")
    public void setContact(List<Contact> value) { this.contact = value; }
    
    /**
     * Devuelve el valor del regional
     */
    @JsonIgnore
    public String getRegional() {
    	
//        "address": [
//                    {
//                        "extension": [
//                            {
//                                "url": "co-bh-regional",
//                                "valueString": "1"
//                            }

    	if (getAddress() != null && !getAddress().isEmpty()) {
    		for (Address address : getAddress()) {
    			if (address.getExtension() != null && ! address.getExtension().isEmpty()) {
    				for (Extension ext : address.getExtension()) {
    					if ("co-bh-regional".equalsIgnoreCase(ext.getURL()) && ext.getValueString() != null) {
    						return ext.getValueString();
    					}
    				}
    			}
    		}
    	}
    	
    	return "0";
    }
}
