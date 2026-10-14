package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.DocumentoGConstants;
import com.keralty.aesolicitudes.global.ObsEstadoConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.ObsEstado;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLPopulation;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.TypedQueryBuilder;
import com.keralty.aesolicitudes.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;

public class DocumentoGJpaRepositoryImpl extends AbstractRepository implements DocumentoGJpaRepositoryCustom {

    @Inject
    public DocumentoGJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<DocumentoG> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<DocumentoG> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<DocumentoG> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<DocumentoG> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, DocumentoG.class);
    }
    
    public List<DocumentoG> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<DocumentoG> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
    public Collection<ObsEstado> assocOperator000(DocumentoG instance) throws SystemException {
        try {
            // FOR ALL ObsEstado DO ObsEstado.eliminar(ObsEstado)
        return assocOperator000Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DocumentoG, Assoc.Operator: AssocOperator000, Method: assocOperator000";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator000
    public Collection<ObsEstado> assocOperator000Range1 (DocumentoG instance) throws SystemException {

        SQLSelect sql = assocOperator000Range1Query(instance);
        return new TypedQueryBuilder<ObsEstado>(em, ObsEstado.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator000
    public SQLPopulation assocOperator000Range1Query (DocumentoG instance) throws SystemException {
        try {
            return new SQLPopulation(DocumentoGConstants.CLASS_NAME, ObsEstadoConstants.CLASS_NAME, instance.getOid(), DocumentoGConstants.ROLE_NAME_OBSESTADO);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: DocumentoG, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
