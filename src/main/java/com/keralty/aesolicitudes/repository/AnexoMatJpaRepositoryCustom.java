package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.persistence.AnexoMat;
import com.keralty.aesolicitudes.sqlutils.SQLGetOne;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface AnexoMatJpaRepositoryCustom {

    List<AnexoMat> solveQuery(SQLSelect query);
    
    List<AnexoMat> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Double assocOperator000(AnexoMat instance) throws SystemException;

    Double assocOperator000Range1(AnexoMat instance) throws SystemException;
    
    SQLGetOne assocOperator000Range1Query(AnexoMat instance) throws SystemException;

    public List<AnexoMat> executeQuery(String query);

    public List<AnexoMat> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
