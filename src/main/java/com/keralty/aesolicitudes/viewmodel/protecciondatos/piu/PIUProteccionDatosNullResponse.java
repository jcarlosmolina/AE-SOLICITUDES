package com.keralty.aesolicitudes.viewmodel.protecciondatos.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.protecciondatos.ds.DSProteccionDatosNull;

public class PIUProteccionDatosNullResponse extends QueryResponse {

    private List<DSProteccionDatosNull> results;

    public PIUProteccionDatosNullResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUProteccionDatosNullResponse(List<DSProteccionDatosNull> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSProteccionDatosNull> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSProteccionDatosNull> results) {
        this.results = results;
    }
}
