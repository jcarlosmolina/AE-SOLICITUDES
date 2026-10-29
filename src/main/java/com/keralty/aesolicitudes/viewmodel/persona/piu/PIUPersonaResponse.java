package com.keralty.aesolicitudes.viewmodel.persona.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.persona.ds.DSPersonaPIU;

public class PIUPersonaResponse extends QueryResponse {

    private List<DSPersonaPIU> results;

    public PIUPersonaResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUPersonaResponse(List<DSPersonaPIU> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSPersonaPIU> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSPersonaPIU> results) {
        this.results = results;
    }
}
