package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.ObservacionesC;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface ObservacionesCJpaRepositoryCustom {

    List<ObservacionesC> solveQuery(SQLSelect query);
    
    List<ObservacionesC> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<ObservacionesC> executeQuery(String query);

    public List<ObservacionesC> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
