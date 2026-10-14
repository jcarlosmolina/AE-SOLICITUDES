package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.persistence.ProteccionDatosC;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.TypedQueryBuilder;
import com.keralty.aesolicitudes.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;

public class ProteccionDatosCJpaRepositoryImpl extends AbstractRepository implements ProteccionDatosCJpaRepositoryCustom {

    @Inject
    public ProteccionDatosCJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<ProteccionDatosC> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<ProteccionDatosC> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<ProteccionDatosC> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<ProteccionDatosC> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, ProteccionDatosC.class);
    }
    
    public List<ProteccionDatosC> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<ProteccionDatosC> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
