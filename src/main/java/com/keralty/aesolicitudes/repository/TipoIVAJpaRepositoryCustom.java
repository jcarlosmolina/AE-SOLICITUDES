package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.TipoIVA;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.sql.Date;
import java.util.List;

public interface TipoIVAJpaRepositoryCustom {

    List<TipoIVA> solveQuery(SQLSelect query);
    
    List<TipoIVA> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<TipoIVA> executeQuery(String query);

    public List<TipoIVA> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
