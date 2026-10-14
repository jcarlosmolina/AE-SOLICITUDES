package com.keralty.aesolicitudes.viewmodel.estadocontrato.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.estadocontrato.ds.AutoDS;

public class PIUEstadoContratoResponse extends QueryResponse {

    private List<AutoDS> results;

    public PIUEstadoContratoResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUEstadoContratoResponse(List<AutoDS> results) {
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
