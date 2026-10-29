package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.InstitucionMatNeo;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface InstitucionMatNeoJpaRepositoryCustom {

    List<InstitucionMatNeo> solveQuery(SQLSelect query);
    
    List<InstitucionMatNeo> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<InstitucionMatNeo> executeQuery(String query);

    public List<InstitucionMatNeo> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
