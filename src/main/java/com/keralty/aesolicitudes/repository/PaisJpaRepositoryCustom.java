package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Pais;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface PaisJpaRepositoryCustom {

    List<Pais> solveQuery(SQLSelect query);
    
    List<Pais> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<Pais> executeQuery(String query);

    public List<Pais> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
