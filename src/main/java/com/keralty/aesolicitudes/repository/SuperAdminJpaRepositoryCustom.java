package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Funcionario;
import com.keralty.aesolicitudes.persistence.SuperAdmin;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface SuperAdminJpaRepositoryCustom {

    List<SuperAdmin> solveQuery(SQLSelect query);
    
    List<SuperAdmin> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Funcionario findParent(Long oid);

    public List<SuperAdmin> executeQuery(String query);

    public List<SuperAdmin> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
