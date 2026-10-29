package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.PreexistenciaC;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface PreexistenciaCJpaRepositoryCustom {

    List<PreexistenciaC> solveQuery(SQLSelect query);
    
    List<PreexistenciaC> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);
    
    Long nextPreexistenciaCIdentificador(Long personaCID);

    public List<PreexistenciaC> executeQuery(String query);

    public List<PreexistenciaC> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
