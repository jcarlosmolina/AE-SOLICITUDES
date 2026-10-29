package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.PreguntaP;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface PreguntaPJpaRepositoryCustom {

    List<PreguntaP> solveQuery(SQLSelect query);
    
    List<PreguntaP> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<PreguntaP> executeQuery(String query);

    public List<PreguntaP> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
