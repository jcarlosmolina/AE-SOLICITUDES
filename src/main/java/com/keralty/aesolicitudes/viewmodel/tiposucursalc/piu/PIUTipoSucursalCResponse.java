package com.keralty.aesolicitudes.viewmodel.tiposucursalc.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.tiposucursalc.ds.AutoDS;

public class PIUTipoSucursalCResponse extends QueryResponse {

    private List<AutoDS> results;

    public PIUTipoSucursalCResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUTipoSucursalCResponse(List<AutoDS> results) {
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
