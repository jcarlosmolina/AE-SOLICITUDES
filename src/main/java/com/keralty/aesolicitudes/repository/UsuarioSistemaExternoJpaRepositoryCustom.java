package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.UsuarioSistemaExterno;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface UsuarioSistemaExternoJpaRepositoryCustom {

    List<UsuarioSistemaExterno> solveQuery(SQLSelect query);
    
    List<UsuarioSistemaExterno> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<UsuarioSistemaExterno> executeQuery(String query);

    public List<UsuarioSistemaExterno> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
