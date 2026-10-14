package com.keralty.aesolicitudes.viewmodel.tipoentidadc.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.tipoentidadc.ds.AutoDS;

public class PIUTipoEntidadResponse extends QueryResponse {

    private List<AutoDS> results;

    public PIUTipoEntidadResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUTipoEntidadResponse(List<AutoDS> results) {
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
