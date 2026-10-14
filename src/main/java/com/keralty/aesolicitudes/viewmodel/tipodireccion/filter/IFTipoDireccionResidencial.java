package com.keralty.aesolicitudes.viewmodel.tipodireccion.filter;


import com.keralty.aesolicitudes.global.TipoDireccionConstants;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;

public class IFTipoDireccionResidencial {

    public IFTipoDireccionResidencial() {
        // Default constructor
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(TipoDireccionConstants.FILTER_NAME_IFTIPODIRECCIONRESIDENCIAL);
        return filterRequest;
    }
}
