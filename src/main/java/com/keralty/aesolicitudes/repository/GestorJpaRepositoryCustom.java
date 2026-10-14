package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Funcionario;
import com.keralty.aesolicitudes.persistence.Gestor;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface GestorJpaRepositoryCustom {

    List<Gestor> solveQuery(SQLSelect query);
    
    List<Gestor> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Funcionario findParent(Long oid);

    public List<Gestor> executeQuery(String query);

    public List<Gestor> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
