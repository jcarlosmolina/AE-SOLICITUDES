package com.keralty.aesolicitudes.viewmodel.parentesco.filter;


import com.keralty.aesolicitudes.global.ParentescoConstants;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;

public class IFParentescoConyuge {

    public IFParentescoConyuge() {
        // Default constructor
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(ParentescoConstants.FILTER_NAME_IFPARENTESCOCONYUGE);
        return filterRequest;
    }
}
