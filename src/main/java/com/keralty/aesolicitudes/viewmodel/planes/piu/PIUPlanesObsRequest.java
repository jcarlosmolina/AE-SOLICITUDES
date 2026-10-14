package com.keralty.aesolicitudes.viewmodel.planes.piu;

import com.keralty.aesolicitudes.viewmodel.PopulationRequestViewModel;
import com.keralty.aesolicitudes.viewmodel.QueryRequest;
import com.keralty.aesolicitudes.viewmodel.planes.filter.FPlanVarios;

public class PIUPlanesObsRequest extends PopulationRequestViewModel{

    private FPlanVarios fPlanVarios;
    
    public void setFPlanVarios(FPlanVarios fPlanVarios) {
        this.fPlanVarios = fPlanVarios;
    }
    
    public FPlanVarios getFPlanVarios() {
        return fPlanVarios;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fPlanVarios != null)
            queryRequest.addFilterRequest(fPlanVarios.buildFilterRequest());
        return queryRequest;
    }
}
