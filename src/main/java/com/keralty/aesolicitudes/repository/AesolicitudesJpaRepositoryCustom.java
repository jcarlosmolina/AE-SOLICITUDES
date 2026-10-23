package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface AesolicitudesJpaRepositoryCustom {

    Long getSiguienteNumRadicado(boolean esVoluntario);

    List<Aesolicitudes> solveQuery(SQLSelect query);
    
    List<Aesolicitudes> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<Aesolicitudes> executeQuery(String query);

    public List<Aesolicitudes> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
