package com.keralty.aesolicitudes.viewmodel.departamento.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.departamento.ds.AutoDS;

public class PIUDepartamentoResponse extends QueryResponse {

    private List<AutoDS> results;

    public PIUDepartamentoResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUDepartamentoResponse(List<AutoDS> results) {
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
