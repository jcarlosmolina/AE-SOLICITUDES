package com.keralty.aesolicitudes.viewmodel.grupoasociado.piu;

import com.keralty.aesolicitudes.viewmodel.PopulationRequestViewModel;
import com.keralty.aesolicitudes.viewmodel.QueryRequest;
import com.keralty.aesolicitudes.viewmodel.grupoasociado.filter.FGrupoAsociadoBusqueda;

public class PIUGrupoAsociadoBusquedaRequest extends PopulationRequestViewModel{

    private FGrupoAsociadoBusqueda fGrupoAsociadoBusqueda;
    
    public void setFGrupoAsociadoBusqueda(FGrupoAsociadoBusqueda fGrupoAsociadoBusqueda) {
        this.fGrupoAsociadoBusqueda = fGrupoAsociadoBusqueda;
    }
    
    public FGrupoAsociadoBusqueda getFGrupoAsociadoBusqueda() {
        return fGrupoAsociadoBusqueda;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fGrupoAsociadoBusqueda != null)
            queryRequest.addFilterRequest(fGrupoAsociadoBusqueda.buildFilterRequest());
        return queryRequest;
    }
}
