package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.UsuarioReg;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface UsuarioRegJpaRepositoryCustom {

    List<UsuarioReg> solveQuery(SQLSelect query);
    
    List<UsuarioReg> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);
    
    Long nextUsuarioRegIdentificador(Long aesolicitudesidsolicitud);

    public List<UsuarioReg> executeQuery(String query);

    public List<UsuarioReg> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
