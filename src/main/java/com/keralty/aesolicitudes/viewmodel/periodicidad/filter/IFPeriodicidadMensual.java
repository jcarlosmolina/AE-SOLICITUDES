package com.keralty.aesolicitudes.viewmodel.periodicidad.filter;


import com.keralty.aesolicitudes.global.PeriodicidadConstants;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;

public class IFPeriodicidadMensual {

    public IFPeriodicidadMensual() {
        // Default constructor
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(PeriodicidadConstants.FILTER_NAME_IFPERIODICIDADMENSUAL);
        return filterRequest;
    }
}
