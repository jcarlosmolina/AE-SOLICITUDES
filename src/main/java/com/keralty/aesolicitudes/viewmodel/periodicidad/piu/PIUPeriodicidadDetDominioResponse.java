package com.keralty.aesolicitudes.viewmodel.periodicidad.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.periodicidad.ds.AutoDS;

public class PIUPeriodicidadDetDominioResponse extends QueryResponse {

    private List<AutoDS> results;

    public PIUPeriodicidadDetDominioResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUPeriodicidadDetDominioResponse(List<AutoDS> results) {
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
