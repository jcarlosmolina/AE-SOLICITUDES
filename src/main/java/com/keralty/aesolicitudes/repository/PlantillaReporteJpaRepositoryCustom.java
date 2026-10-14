package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.PlantillaReporte;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface PlantillaReporteJpaRepositoryCustom {

    List<PlantillaReporte> solveQuery(SQLSelect query);
    
    List<PlantillaReporte> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<PlantillaReporte> executeQuery(String query);

    public List<PlantillaReporte> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
