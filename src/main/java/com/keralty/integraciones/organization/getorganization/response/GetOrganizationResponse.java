package com.keralty.integraciones.organization.getorganization.response;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetOrganizationResponse {
    private String resourceType;
    private String type;
    private String total;
    private List<Entry> entry;
    private Search search;

    @JsonProperty("resourceType")
    public String getResourceType() { return resourceType; }
    @JsonProperty("resourceType")
    public void setResourceType(String value) { this.resourceType = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("total")
    public String getTotal() { return total; }
    @JsonProperty("total")
    public void setTotal(String value) { this.total = value; }

    @JsonProperty("entry")
    public List<Entry> getEntry() { return entry; }
    @JsonProperty("entry")
    public void setEntry(List<Entry> value) { this.entry = value; }

    @JsonProperty("search")
    public Search getSearch() { return search; }
    @JsonProperty("search")
    public void setSearch(Search value) { this.search = value; }
    
    public void addEntry(Entry entry) {
    	this.entry.add(entry);
    }
}
