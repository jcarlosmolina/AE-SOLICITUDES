package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.MotDevAreaMedica;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface MotDevAreaMedicaJpaRepositoryCustom {

    List<MotDevAreaMedica> solveQuery(SQLSelect query);
    
    List<MotDevAreaMedica> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<MotDevAreaMedica> executeQuery(String query);

    public List<MotDevAreaMedica> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
