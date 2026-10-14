package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.LogLlamadasBH;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface LogLlamadasBHJpaRepositoryCustom {

    List<LogLlamadasBH> solveQuery(SQLSelect query);
    
    List<LogLlamadasBH> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<LogLlamadasBH> executeQuery(String query);

    public List<LogLlamadasBH> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
