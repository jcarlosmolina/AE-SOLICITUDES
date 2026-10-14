package com.keralty.aesolicitudes.viewmodel.plantillaemail.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.plantillaemail.ds.DSPlantillasDominio;

public class PIUPlantillasDominioResponse extends QueryResponse {

    private List<DSPlantillasDominio> results;

    public PIUPlantillasDominioResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUPlantillasDominioResponse(List<DSPlantillasDominio> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSPlantillasDominio> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSPlantillasDominio> results) {
        this.results = results;
    }
}
