package com.keralty.aesolicitudes.viewmodel.regional.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.regional.ds.AutoDS;

public class PIURegionalObsResponse extends QueryResponse {

    private List<AutoDS> results;

    public PIURegionalObsResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIURegionalObsResponse(List<AutoDS> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<AutoDS> getResults() {
        return this.results;
    }
    
    public void setResults(List<AutoDS> results) {
        this.results = results;
    }
}
