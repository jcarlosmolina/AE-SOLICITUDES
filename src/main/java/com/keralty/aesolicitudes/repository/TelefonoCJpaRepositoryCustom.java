package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.TelefonoC;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface TelefonoCJpaRepositoryCustom {

    List<TelefonoC> solveQuery(SQLSelect query);
    
    List<TelefonoC> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<TelefonoC> executeQuery(String query);

    public List<TelefonoC> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
