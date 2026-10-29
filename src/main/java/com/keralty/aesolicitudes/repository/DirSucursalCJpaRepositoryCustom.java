package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.TelefonoC;
import com.keralty.aesolicitudes.sqlutils.SQLExists;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLPopulation;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.Collection;
import java.util.List;

public interface DirSucursalCJpaRepositoryCustom {

    List<DirSucursalC> solveQuery(SQLSelect query);
    
    List<DirSucursalC> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Boolean assocOperator000(DirSucursalC instance) throws SystemException;

    Boolean assocOperator000Range1(DirSucursalC instance) throws SystemException;
    
    SQLExists assocOperator000Range1Query(DirSucursalC instance) throws SystemException;

    Boolean assocOperator001(DirSucursalC instance) throws SystemException;

    Boolean assocOperator001Range1(DirSucursalC instance) throws SystemException;
    
    SQLExists assocOperator001Range1Query(DirSucursalC instance) throws SystemException;

    Boolean assocOperator003(DirSucursalC instance) throws SystemException;

    Boolean assocOperator003Range1(DirSucursalC instance) throws SystemException;
    
    SQLExists assocOperator003Range1Query(DirSucursalC instance) throws SystemException;

    Boolean assocOperator004(DirSucursalC instance) throws SystemException;

    Boolean assocOperator004Range1(DirSucursalC instance) throws SystemException;
    
    SQLExists assocOperator004Range1Query(DirSucursalC instance) throws SystemException;

    Boolean assocOperator006(DirSucursalC instance) throws SystemException;

    Boolean assocOperator006Range1(DirSucursalC instance) throws SystemException;
    
    SQLExists assocOperator006Range1Query(DirSucursalC instance) throws SystemException;

    Boolean assocOperator007(DirSucursalC instance) throws SystemException;

    Boolean assocOperator007Range1(DirSucursalC instance) throws SystemException;
    
    SQLExists assocOperator007Range1Query(DirSucursalC instance) throws SystemException;

    Boolean assocOperator009(DirSucursalC instance) throws SystemException;

    Boolean assocOperator009Range1(DirSucursalC instance) throws SystemException;
    
    SQLExists assocOperator009Range1Query(DirSucursalC instance) throws SystemException;

    Boolean assocOperator010(DirSucursalC instance) throws SystemException;

    Boolean assocOperator010Range1(DirSucursalC instance) throws SystemException;
    
    SQLExists assocOperator010Range1Query(DirSucursalC instance) throws SystemException;

    Boolean assocOperator011(DirSucursalC instance) throws SystemException;

    Boolean assocOperator011Range1(DirSucursalC instance) throws SystemException;
    
    SQLExists assocOperator011Range1Query(DirSucursalC instance) throws SystemException;

    Collection<TelefonoC> assocOperator012(DirSucursalC instance) throws SystemException;

    Collection<TelefonoC> assocOperator012Range1(DirSucursalC instance) throws SystemException;
    
    SQLPopulation assocOperator012Range1Query(DirSucursalC instance) throws SystemException;

    public List<DirSucursalC> executeQuery(String query);

    public List<DirSucursalC> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
