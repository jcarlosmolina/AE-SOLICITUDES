package com.keralty.aesolicitudes.viewmodel.funcionario.piu;

import com.keralty.aesolicitudes.viewmodel.PopulationRequestViewModel;
import com.keralty.aesolicitudes.viewmodel.QueryRequest;
import com.keralty.aesolicitudes.viewmodel.funcionario.filter.FFuncionarioPorNombre;

public class PIUFuncionarioObsRequest extends PopulationRequestViewModel{

    private FFuncionarioPorNombre fFuncionarioPorNombre;
    
    public void setFFuncionarioPorNombre(FFuncionarioPorNombre fFuncionarioPorNombre) {
        this.fFuncionarioPorNombre = fFuncionarioPorNombre;
    }
    
    public FFuncionarioPorNombre getFFuncionarioPorNombre() {
        return fFuncionarioPorNombre;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fFuncionarioPorNombre != null)
            queryRequest.addFilterRequest(fFuncionarioPorNombre.buildFilterRequest());
        return queryRequest;
    }
}
