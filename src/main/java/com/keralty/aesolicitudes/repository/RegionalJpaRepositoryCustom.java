package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Regional;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface RegionalJpaRepositoryCustom {

    List<Regional> solveQuery(SQLSelect query);
    
    List<Regional> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<Regional> executeQuery(String query);

    public List<Regional> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
