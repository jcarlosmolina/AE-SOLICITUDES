package com.keralty.aesolicitudes.viewmodel.reportesdominio.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.reportesdominio.ds.DSReportesDominio;

public class PIUReportesDominioResponse extends QueryResponse {

    private List<DSReportesDominio> results;

    public PIUReportesDominioResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUReportesDominioResponse(List<DSReportesDominio> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSReportesDominio> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSReportesDominio> results) {
        this.results = results;
    }
}
