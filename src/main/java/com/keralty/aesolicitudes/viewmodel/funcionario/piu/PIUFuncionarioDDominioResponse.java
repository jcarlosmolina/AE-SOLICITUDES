package com.keralty.aesolicitudes.viewmodel.funcionario.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.funcionario.ds.DSFuncionarioDGrupo;

public class PIUFuncionarioDDominioResponse extends QueryResponse {

    private List<DSFuncionarioDGrupo> results;

    public PIUFuncionarioDDominioResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUFuncionarioDDominioResponse(List<DSFuncionarioDGrupo> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSFuncionarioDGrupo> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSFuncionarioDGrupo> results) {
        this.results = results;
    }
}
