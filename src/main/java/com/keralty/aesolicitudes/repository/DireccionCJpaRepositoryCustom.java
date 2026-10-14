package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.TelefonoC;
import com.keralty.aesolicitudes.sqlutils.SQLExists;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLPopulation;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.Collection;
import java.util.List;

public interface DireccionCJpaRepositoryCustom {

    List<DireccionC> solveQuery(SQLSelect query);
    
    List<DireccionC> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Boolean assocOperator000(DireccionC instance) throws SystemException;

    Boolean assocOperator000Range1(DireccionC instance) throws SystemException;
    
    SQLExists assocOperator000Range1Query(DireccionC instance) throws SystemException;

    Boolean assocOperator001(DireccionC instance) throws SystemException;

    Boolean assocOperator001Range1(DireccionC instance) throws SystemException;
    
    SQLExists assocOperator001Range1Query(DireccionC instance) throws SystemException;

    Boolean assocOperator002(DireccionC instance) throws SystemException;

    Boolean assocOperator002Range1(DireccionC instance) throws SystemException;
    
    SQLExists assocOperator002Range1Query(DireccionC instance) throws SystemException;

    Boolean assocOperator003(DireccionC instance) throws SystemException;

    Boolean assocOperator003Range1(DireccionC instance) throws SystemException;
    
    SQLExists assocOperator003Range1Query(DireccionC instance) throws SystemException;

    Boolean assocOperator005(DireccionC instance) throws SystemException;

    Boolean assocOperator005Range1(DireccionC instance) throws SystemException;
    
    SQLExists assocOperator005Range1Query(DireccionC instance) throws SystemException;

    Boolean assocOperator006(DireccionC instance) throws SystemException;

    Boolean assocOperator006Range1(DireccionC instance) throws SystemException;
    
    SQLExists assocOperator006Range1Query(DireccionC instance) throws SystemException;

    Boolean assocOperator008(DireccionC instance) throws SystemException;

    Boolean assocOperator008Range1(DireccionC instance) throws SystemException;
    
    SQLExists assocOperator008Range1Query(DireccionC instance) throws SystemException;

    Boolean assocOperator009(DireccionC instance) throws SystemException;

    Boolean assocOperator009Range1(DireccionC instance) throws SystemException;
    
    SQLExists assocOperator009Range1Query(DireccionC instance) throws SystemException;

    Boolean assocOperator011(DireccionC instance) throws SystemException;

    Boolean assocOperator011Range1(DireccionC instance) throws SystemException;
    
    SQLExists assocOperator011Range1Query(DireccionC instance) throws SystemException;

    Boolean assocOperator012(DireccionC instance) throws SystemException;

    Boolean assocOperator012Range1(DireccionC instance) throws SystemException;
    
    SQLExists assocOperator012Range1Query(DireccionC instance) throws SystemException;

    Boolean assocOperator014(DireccionC instance) throws SystemException;

    Boolean assocOperator014Range1(DireccionC instance) throws SystemException;
    
    SQLExists assocOperator014Range1Query(DireccionC instance) throws SystemException;

    Boolean assocOperator015(DireccionC instance) throws SystemException;

    Boolean assocOperator015Range1(DireccionC instance) throws SystemException;
    
    SQLExists assocOperator015Range1Query(DireccionC instance) throws SystemException;

    Boolean assocOperator016(DireccionC instance) throws SystemException;

    Boolean assocOperator016Range1(DireccionC instance) throws SystemException;
    
    SQLExists assocOperator016Range1Query(DireccionC instance) throws SystemException;

    Boolean assocOperator017(DireccionC instance) throws SystemException;

    Boolean assocOperator017Range1(DireccionC instance) throws SystemException;
    
    SQLExists assocOperator017Range1Query(DireccionC instance) throws SystemException;

    Collection<TelefonoC> assocOperator018(DireccionC instance) throws SystemException;

    Collection<TelefonoC> assocOperator018Range1(DireccionC instance) throws SystemException;
    
    SQLPopulation assocOperator018Range1Query(DireccionC instance) throws SystemException;

    public List<DireccionC> executeQuery(String query);

    public List<DireccionC> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
