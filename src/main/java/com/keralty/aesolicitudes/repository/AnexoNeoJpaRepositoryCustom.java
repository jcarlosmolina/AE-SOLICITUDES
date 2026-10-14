package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.persistence.AnexoNeo;
import com.keralty.aesolicitudes.sqlutils.SQLGetOne;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface AnexoNeoJpaRepositoryCustom {

    List<AnexoNeo> solveQuery(SQLSelect query);
    
    List<AnexoNeo> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Double assocOperator000(AnexoNeo instance) throws SystemException;

    Double assocOperator000Range1(AnexoNeo instance) throws SystemException;
    
    SQLGetOne assocOperator000Range1Query(AnexoNeo instance) throws SystemException;

    public List<AnexoNeo> executeQuery(String query);

    public List<AnexoNeo> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
