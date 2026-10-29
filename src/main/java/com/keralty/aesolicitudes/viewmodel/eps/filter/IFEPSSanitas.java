package com.keralty.aesolicitudes.viewmodel.eps.filter;


import com.keralty.aesolicitudes.global.EpsConstants;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;

public class IFEPSSanitas {

    public IFEPSSanitas() {
        // Default constructor
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(EpsConstants.FILTER_NAME_IFEPSSANITAS);
        return filterRequest;
    }
}
