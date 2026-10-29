package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.GrupoAsociado;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface GrupoAsociadoJpaRepositoryCustom {

    List<GrupoAsociado> solveQuery(SQLSelect query);
    
    List<GrupoAsociado> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<GrupoAsociado> executeQuery(String query);

    public List<GrupoAsociado> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
