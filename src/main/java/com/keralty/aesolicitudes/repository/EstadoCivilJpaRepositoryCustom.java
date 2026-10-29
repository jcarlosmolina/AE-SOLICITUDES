package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.EstadoCivil;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface EstadoCivilJpaRepositoryCustom {

    List<EstadoCivil> solveQuery(SQLSelect query);
    
    List<EstadoCivil> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<EstadoCivil> executeQuery(String query);

    public List<EstadoCivil> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
