package com.keralty.aesolicitudes.viewmodel.tipoidentificacion.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.tipoidentificacion.ds.DSTipoIdentificacionNull;

public class PIUTipoIdentificacionNullResponse extends QueryResponse {

    private List<DSTipoIdentificacionNull> results;

    public PIUTipoIdentificacionNullResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUTipoIdentificacionNullResponse(List<DSTipoIdentificacionNull> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSTipoIdentificacionNull> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSTipoIdentificacionNull> results) {
        this.results = results;
    }
}
