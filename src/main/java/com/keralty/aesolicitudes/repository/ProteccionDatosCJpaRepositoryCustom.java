package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.ProteccionDatosC;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface ProteccionDatosCJpaRepositoryCustom {

    List<ProteccionDatosC> solveQuery(SQLSelect query);
    
    List<ProteccionDatosC> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<ProteccionDatosC> executeQuery(String query);

    public List<ProteccionDatosC> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
