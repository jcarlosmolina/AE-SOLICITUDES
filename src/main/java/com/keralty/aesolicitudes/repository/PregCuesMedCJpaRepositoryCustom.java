package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.PregCuesMedC;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface PregCuesMedCJpaRepositoryCustom {

    List<PregCuesMedC> solveQuery(SQLSelect query);
    
    List<PregCuesMedC> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<PregCuesMedC> executeQuery(String query);

    public List<PregCuesMedC> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
