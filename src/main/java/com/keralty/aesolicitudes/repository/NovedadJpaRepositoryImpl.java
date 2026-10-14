package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.NovedadConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.persistence.Novedad;
import com.keralty.aesolicitudes.sqlutils.SQLCount;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.TypedQueryBuilder;
import com.keralty.aesolicitudes.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;

public class NovedadJpaRepositoryImpl extends AbstractRepository implements NovedadJpaRepositoryCustom {

    @Inject
    public NovedadJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<Novedad> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Novedad> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Novedad> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Novedad> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Novedad.class);
    }
    
    public List<Novedad> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<Novedad> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
    public Long assocOperator000(Novedad instance) throws SystemException {
        try {
            // COUNT (Causales)
            return assocOperator000Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Novedad, Assoc.Operator: AssocOperator000, Method: assocOperator000";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator000
    public Long assocOperator000Range1 (Novedad instance) throws SystemException {
        SQLCount sql = assocOperator000Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator000
    public SQLCount assocOperator000Range1Query (Novedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(NovedadConstants.CLASS_NAME, NovedadConstants.ROLE_NAME_CAUSALES, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Novedad, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator001
    public Long assocOperator001(Novedad instance) throws SystemException {
        try {
            // COUNT (CausasExclusion)
            return assocOperator001Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Novedad, Assoc.Operator: AssocOperator001, Method: assocOperator001";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator001
    public Long assocOperator001Range1 (Novedad instance) throws SystemException {
        SQLCount sql = assocOperator001Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator001
    public SQLCount assocOperator001Range1Query (Novedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(NovedadConstants.CLASS_NAME, NovedadConstants.ROLE_NAME_CAUSASEXCLUSION, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Novedad, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
