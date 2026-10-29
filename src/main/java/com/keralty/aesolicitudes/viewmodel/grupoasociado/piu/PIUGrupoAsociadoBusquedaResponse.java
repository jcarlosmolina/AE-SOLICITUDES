package com.keralty.aesolicitudes.viewmodel.grupoasociado.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.grupoasociado.ds.DSGrupoAsociadoPIUBusqueda;

public class PIUGrupoAsociadoBusquedaResponse extends QueryResponse {

    private List<DSGrupoAsociadoPIUBusqueda> results;

    public PIUGrupoAsociadoBusquedaResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUGrupoAsociadoBusquedaResponse(List<DSGrupoAsociadoPIUBusqueda> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSGrupoAsociadoPIUBusqueda> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSGrupoAsociadoPIUBusqueda> results) {
        this.results = results;
    }
}
