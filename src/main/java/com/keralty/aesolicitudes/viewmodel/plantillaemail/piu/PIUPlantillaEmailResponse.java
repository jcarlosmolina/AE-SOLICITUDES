package com.keralty.aesolicitudes.viewmodel.plantillaemail.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.plantillaemail.ds.DSPlantillaEmail;

public class PIUPlantillaEmailResponse extends QueryResponse {

    private List<DSPlantillaEmail> results;

    public PIUPlantillaEmailResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUPlantillaEmailResponse(List<DSPlantillaEmail> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSPlantillaEmail> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSPlantillaEmail> results) {
        this.results = results;
    }
}
