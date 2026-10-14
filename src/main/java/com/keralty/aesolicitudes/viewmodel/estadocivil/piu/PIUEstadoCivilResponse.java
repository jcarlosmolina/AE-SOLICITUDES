package com.keralty.aesolicitudes.viewmodel.estadocivil.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.estadocivil.ds.AutoDS;

public class PIUEstadoCivilResponse extends QueryResponse {

    private List<AutoDS> results;

    public PIUEstadoCivilResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUEstadoCivilResponse(List<AutoDS> results) {
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
