package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.LogUsrSolNov;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface LogUsrSolNovJpaRepositoryCustom {

    List<LogUsrSolNov> solveQuery(SQLSelect query);
    
    List<LogUsrSolNov> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<LogUsrSolNov> executeQuery(String query);

    public List<LogUsrSolNov> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
