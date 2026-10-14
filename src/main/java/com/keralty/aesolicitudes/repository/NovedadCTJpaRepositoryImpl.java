package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.persistence.NovedadCT;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.TypedQueryBuilder;
import com.keralty.aesolicitudes.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;

public class NovedadCTJpaRepositoryImpl extends AbstractRepository implements NovedadCTJpaRepositoryCustom {

    @Inject
    public NovedadCTJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<NovedadCT> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<NovedadCT> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<NovedadCT> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<NovedadCT> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, NovedadCT.class);
    }
    
    public List<NovedadCT> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<NovedadCT> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
