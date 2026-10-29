package com.keralty.aesolicitudes.viewmodel.persona.piu;

import com.keralty.aesolicitudes.viewmodel.PopulationRequestViewModel;
import com.keralty.aesolicitudes.viewmodel.QueryRequest;
import com.keralty.aesolicitudes.viewmodel.persona.filter.FPersonaVarios;

public class PIUPersonaRequest extends PopulationRequestViewModel{

    private FPersonaVarios fPersonaVarios;
    
    public void setFPersonaVarios(FPersonaVarios fPersonaVarios) {
        this.fPersonaVarios = fPersonaVarios;
    }
    
    public FPersonaVarios getFPersonaVarios() {
        return fPersonaVarios;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fPersonaVarios != null)
            queryRequest.addFilterRequest(fPersonaVarios.buildFilterRequest());
        return queryRequest;
    }
}
