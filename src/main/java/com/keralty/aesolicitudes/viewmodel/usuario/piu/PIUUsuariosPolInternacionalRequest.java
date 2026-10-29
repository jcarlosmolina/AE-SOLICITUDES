package com.keralty.aesolicitudes.viewmodel.usuario.piu;

import com.keralty.aesolicitudes.viewmodel.PopulationRequestViewModel;
import com.keralty.aesolicitudes.viewmodel.QueryRequest;
import com.keralty.aesolicitudes.viewmodel.usuario.filter.FUsuariosPolizaInter;

public class PIUUsuariosPolInternacionalRequest extends PopulationRequestViewModel{

    private FUsuariosPolizaInter fUsuariosPolizaInter;
    
    public void setFUsuariosPolizaInter(FUsuariosPolizaInter fUsuariosPolizaInter) {
        this.fUsuariosPolizaInter = fUsuariosPolizaInter;
    }
    
    public FUsuariosPolizaInter getFUsuariosPolizaInter() {
        return fUsuariosPolizaInter;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fUsuariosPolizaInter != null)
            queryRequest.addFilterRequest(fUsuariosPolizaInter.buildFilterRequest());
        return queryRequest;
    }
}
