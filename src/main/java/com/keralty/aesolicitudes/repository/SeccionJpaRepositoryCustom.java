package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Seccion;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface SeccionJpaRepositoryCustom {

    List<Seccion> solveQuery(SQLSelect query);
    
    List<Seccion> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<Seccion> executeQuery(String query);

    public List<Seccion> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
