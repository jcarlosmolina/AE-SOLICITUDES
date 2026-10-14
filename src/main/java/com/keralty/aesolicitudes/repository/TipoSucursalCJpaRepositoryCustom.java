package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.TipoSucursalC;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface TipoSucursalCJpaRepositoryCustom {

    List<TipoSucursalC> solveQuery(SQLSelect query);
    
    List<TipoSucursalC> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<TipoSucursalC> executeQuery(String query);

    public List<TipoSucursalC> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
