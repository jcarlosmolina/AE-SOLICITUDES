package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.CuestionarioMed;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface CuestionarioMedJpaRepositoryCustom {

    List<CuestionarioMed> solveQuery(SQLSelect query);
    
    List<CuestionarioMed> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<CuestionarioMed> executeQuery(String query);

    public List<CuestionarioMed> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
