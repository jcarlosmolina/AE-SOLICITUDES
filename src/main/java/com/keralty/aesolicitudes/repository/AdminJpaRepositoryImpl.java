package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.global.AdminConstants;
import com.keralty.aesolicitudes.global.FuncionarioConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.persistence.Admin;
import com.keralty.aesolicitudes.persistence.Funcionario;
import com.keralty.aesolicitudes.sqlutils.SQLJoin;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.TypedQueryBuilder;
import com.keralty.aesolicitudes.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;

public class AdminJpaRepositoryImpl extends AbstractRepository implements AdminJpaRepositoryCustom {

    @Inject
    public AdminJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<Admin> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Admin> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Admin> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Admin> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Admin.class);
    }
    
    public List<Admin> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<Admin> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    public Funcionario findParent(Long oid) {
        return em.find(Funcionario.class, oid);
    }

    /**
     * Adds facet where
     * @param myAlias Entity/Table alias.
     * @param join Join clause to add the where to.
     * @param parentAlias Alias of the parent entity.
     */
    public void addFacetWhereparentfuncionario (String myAlias, SQLJoin join, String parentAlias) {
        join.getWheres().add(myAlias + "." + AdminConstants.FLD_FUNCIONARIOID + " = " + parentAlias + "." + FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID);
    }

    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
