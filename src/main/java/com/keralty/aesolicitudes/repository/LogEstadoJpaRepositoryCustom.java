package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.LogEstado;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface LogEstadoJpaRepositoryCustom {

    List<LogEstado> solveQuery(SQLSelect query);
    
    List<LogEstado> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<LogEstado> executeQuery(String query);

    public List<LogEstado> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
