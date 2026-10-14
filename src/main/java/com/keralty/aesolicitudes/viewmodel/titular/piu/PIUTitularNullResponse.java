package com.keralty.aesolicitudes.viewmodel.titular.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.titular.ds.DSTitularNull;

public class PIUTitularNullResponse extends QueryResponse {

    private List<DSTitularNull> results;

    public PIUTitularNullResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUTitularNullResponse(List<DSTitularNull> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSTitularNull> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSTitularNull> results) {
        this.results = results;
    }
}
