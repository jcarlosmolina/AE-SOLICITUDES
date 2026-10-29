package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.persistence.Novedad;
import com.keralty.aesolicitudes.sqlutils.SQLCount;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface NovedadJpaRepositoryCustom {

    List<Novedad> solveQuery(SQLSelect query);
    
    List<Novedad> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Long assocOperator000(Novedad instance) throws SystemException;

    Long assocOperator000Range1(Novedad instance) throws SystemException;
    
    SQLCount assocOperator000Range1Query(Novedad instance) throws SystemException;

    Long assocOperator001(Novedad instance) throws SystemException;

    Long assocOperator001Range1(Novedad instance) throws SystemException;
    
    SQLCount assocOperator001Range1Query(Novedad instance) throws SystemException;

    public List<Novedad> executeQuery(String query);

    public List<Novedad> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
