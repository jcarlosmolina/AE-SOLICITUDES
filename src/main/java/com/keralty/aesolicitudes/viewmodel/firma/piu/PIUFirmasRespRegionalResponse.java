package com.keralty.aesolicitudes.viewmodel.firma.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.firma.ds.DSFirmaPIUResponsable;

public class PIUFirmasRespRegionalResponse extends QueryResponse {

    private List<DSFirmaPIUResponsable> results;

    public PIUFirmasRespRegionalResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUFirmasRespRegionalResponse(List<DSFirmaPIUResponsable> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSFirmaPIUResponsable> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSFirmaPIUResponsable> results) {
        this.results = results;
    }
}
