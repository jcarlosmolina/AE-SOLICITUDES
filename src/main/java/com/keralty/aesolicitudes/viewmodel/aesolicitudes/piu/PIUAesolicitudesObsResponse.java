package com.keralty.aesolicitudes.viewmodel.aesolicitudes.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.aesolicitudes.ds.DSAesolicitudes;

public class PIUAesolicitudesObsResponse extends QueryResponse {

    private List<DSAesolicitudes> results;

    public PIUAesolicitudesObsResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUAesolicitudesObsResponse(List<DSAesolicitudes> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSAesolicitudes> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSAesolicitudes> results) {
        this.results = results;
    }
}
