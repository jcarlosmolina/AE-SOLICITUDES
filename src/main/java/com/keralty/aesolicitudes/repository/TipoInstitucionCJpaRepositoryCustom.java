package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.TipoInstitucionC;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface TipoInstitucionCJpaRepositoryCustom {

    List<TipoInstitucionC> solveQuery(SQLSelect query);
    
    List<TipoInstitucionC> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<TipoInstitucionC> executeQuery(String query);

    public List<TipoInstitucionC> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
