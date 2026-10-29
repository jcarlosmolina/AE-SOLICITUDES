package com.keralty.aesolicitudes.viewmodel.logllamadasbh.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.logllamadasbh.ds.DSLogLlamadasBH;

public class PIULogLlamadasBHResponse extends QueryResponse {

    private List<DSLogLlamadasBH> results;

    public PIULogLlamadasBHResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIULogLlamadasBHResponse(List<DSLogLlamadasBH> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSLogLlamadasBH> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSLogLlamadasBH> results) {
        this.results = results;
    }
}
