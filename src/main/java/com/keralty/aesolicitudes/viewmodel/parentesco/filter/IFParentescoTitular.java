package com.keralty.aesolicitudes.viewmodel.parentesco.filter;


import com.keralty.aesolicitudes.global.ParentescoConstants;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;

public class IFParentescoTitular {

    public IFParentescoTitular() {
        // Default constructor
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(ParentescoConstants.FILTER_NAME_IFPARENTESCOTITULAR);
        return filterRequest;
    }
}
