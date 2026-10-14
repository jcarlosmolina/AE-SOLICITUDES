package com.keralty.aesolicitudes.viewmodel.firma.piu;

import com.keralty.aesolicitudes.viewmodel.PopulationRequestViewModel;
import com.keralty.aesolicitudes.viewmodel.QueryRequest;
import com.keralty.aesolicitudes.viewmodel.firma.filter.FFirmasResponsables;

public class PIUFirmasRespRegionalRequest extends PopulationRequestViewModel{

    private FFirmasResponsables fFirmasResponsables;
    
    public void setFFirmasResponsables(FFirmasResponsables fFirmasResponsables) {
        this.fFirmasResponsables = fFirmasResponsables;
    }
    
    public FFirmasResponsables getFFirmasResponsables() {
        return fFirmasResponsables;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fFirmasResponsables != null)
            queryRequest.addFilterRequest(fFirmasResponsables.buildFilterRequest());
        return queryRequest;
    }
}
