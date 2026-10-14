package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Afiliaciones;
import com.keralty.aesolicitudes.persistence.Funcionario;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface AfiliacionesJpaRepositoryCustom {

    List<Afiliaciones> solveQuery(SQLSelect query);
    
    List<Afiliaciones> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Funcionario findParent(Long oid);

    public List<Afiliaciones> executeQuery(String query);

    public List<Afiliaciones> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
