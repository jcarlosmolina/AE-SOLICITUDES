package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Eps;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface EpsJpaRepositoryCustom {

    List<Eps> solveQuery(SQLSelect query);
    
    List<Eps> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<Eps> executeQuery(String query);

    public List<Eps> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
