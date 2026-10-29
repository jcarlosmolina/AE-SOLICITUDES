package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Tarifa;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface TarifaJpaRepositoryCustom {

    List<Tarifa> solveQuery(SQLSelect query);
    
    List<Tarifa> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<Tarifa> executeQuery(String query);

    public List<Tarifa> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
