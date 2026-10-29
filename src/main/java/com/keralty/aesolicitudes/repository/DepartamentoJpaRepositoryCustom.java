package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface DepartamentoJpaRepositoryCustom {

    List<Departamento> solveQuery(SQLSelect query);
    
    List<Departamento> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<Departamento> executeQuery(String query);

    public List<Departamento> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
