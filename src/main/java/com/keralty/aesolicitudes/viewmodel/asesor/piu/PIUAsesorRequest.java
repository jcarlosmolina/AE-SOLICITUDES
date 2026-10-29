package com.keralty.aesolicitudes.viewmodel.asesor.piu;

import com.keralty.aesolicitudes.viewmodel.PopulationRequestViewModel;
import com.keralty.aesolicitudes.viewmodel.QueryRequest;
import com.keralty.aesolicitudes.viewmodel.asesor.filter.FAsesores;

public class PIUAsesorRequest extends PopulationRequestViewModel{

    private FAsesores fAsesores;
    
    public void setFAsesores(FAsesores fAsesores) {
        this.fAsesores = fAsesores;
    }
    
    public FAsesores getFAsesores() {
        return fAsesores;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fAsesores != null)
            queryRequest.addFilterRequest(fAsesores.buildFilterRequest());
        return queryRequest;
    }
}
