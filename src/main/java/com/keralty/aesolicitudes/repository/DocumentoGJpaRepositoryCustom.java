package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.ObsEstado;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLPopulation;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.Collection;
import java.util.List;

public interface DocumentoGJpaRepositoryCustom {

    List<DocumentoG> solveQuery(SQLSelect query);
    
    List<DocumentoG> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Collection<ObsEstado> assocOperator000(DocumentoG instance) throws SystemException;

    Collection<ObsEstado> assocOperator000Range1(DocumentoG instance) throws SystemException;
    
    SQLPopulation assocOperator000Range1Query(DocumentoG instance) throws SystemException;

    public List<DocumentoG> executeQuery(String query);

    public List<DocumentoG> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
