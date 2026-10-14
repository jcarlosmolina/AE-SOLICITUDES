package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.PreguntaConstants;
import com.keralty.aesolicitudes.global.PreguntaPConstants;
import com.keralty.aesolicitudes.global.SeccionConstants;
import com.keralty.aesolicitudes.global.SeccionPConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.persistence.Pregunta;
import com.keralty.aesolicitudes.persistence.PreguntaP;
import com.keralty.aesolicitudes.persistence.Seccion;
import com.keralty.aesolicitudes.persistence.SeccionP;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLPopulation;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.TypedQueryBuilder;
import com.keralty.aesolicitudes.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;

public class SeccionPJpaRepositoryImpl extends AbstractRepository implements SeccionPJpaRepositoryCustom {

    @Inject
    public SeccionPJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<SeccionP> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<SeccionP> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<SeccionP> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<SeccionP> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, SeccionP.class);
    }
    
    public List<SeccionP> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<SeccionP> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
    public Collection<Pregunta> assocOperator000(Seccion seccionPTCREARYPREGUNTASptSeccion) throws SystemException {
        try {
            // FOR ALL ptSeccion.Preguntas ORDER BY ((ptSeccion.Preguntas.NumOrden "A")) DO TCREARPREGUNTASITOCA(this, ptSeccion.Preguntas)
        return assocOperator000Range1(seccionPTCREARYPREGUNTASptSeccion);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SeccionP, Assoc.Operator: AssocOperator000, Method: assocOperator000";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator000
    public Collection<Pregunta> assocOperator000Range1 (Seccion seccionPTCREARYPREGUNTASptSeccion) throws SystemException {

        SQLSelect sql = assocOperator000Range1Query(seccionPTCREARYPREGUNTASptSeccion);
        return new TypedQueryBuilder<Pregunta>(em, Pregunta.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator000
    public SQLPopulation assocOperator000Range1Query (Seccion seccionPTCREARYPREGUNTASptSeccion) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SeccionPConstants.CLASS_NAME, PreguntaConstants.CLASS_NAME, SeccionPConstants.ARG_NAME_TCREARYPREGUNTAS_SECCIONPTCREARYPREGUNTASPTSECCION + "." + SeccionConstants.ROLE_NAME_PREGUNTAS, seccionPTCREARYPREGUNTASptSeccion.getOid(), SeccionPConstants.ARG_NAME_TCREARYPREGUNTAS_SECCIONPTCREARYPREGUNTASPTSECCION);

            // Order Criteria Elements
            sql.getOrderByPart().addItem(SeccionPConstants.ARG_NAME_TCREARYPREGUNTAS_SECCIONPTCREARYPREGUNTASPTSECCION + "." + SeccionConstants.ROLE_NAME_PREGUNTAS + "." + PreguntaConstants.ATTR_NAME_PREGUNTANUMORDEN, SeccionConstants.CLASS_NAME, seccionPTCREARYPREGUNTASptSeccion.getOid(), SeccionPConstants.ARG_NAME_TCREARYPREGUNTAS_SECCIONPTCREARYPREGUNTASPTSECCION, true);
            // Default Order Criteria
            sql.getOrderByPart().addItem(SeccionPConstants.ARG_NAME_TCREARYPREGUNTAS_SECCIONPTCREARYPREGUNTASPTSECCION + "." + SeccionConstants.ROLE_NAME_PREGUNTAS + "." + PreguntaConstants.ATTR_NAME_PREGUNTANUMERO, SeccionConstants.CLASS_NAME, seccionPTCREARYPREGUNTASptSeccion.getOid(), SeccionPConstants.ARG_NAME_TCREARYPREGUNTAS_SECCIONPTCREARYPREGUNTASPTSECCION, true);

            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SeccionP, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator001
    public Collection<PreguntaP> assocOperator001(SeccionP instance) throws SystemException {
        try {
            // FOR ALL Preguntas DO Preguntas.TELIMINAR(Preguntas)
        return assocOperator001Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SeccionP, Assoc.Operator: AssocOperator001, Method: assocOperator001";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator001
    public Collection<PreguntaP> assocOperator001Range1 (SeccionP instance) throws SystemException {

        SQLSelect sql = assocOperator001Range1Query(instance);
        return new TypedQueryBuilder<PreguntaP>(em, PreguntaP.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator001
    public SQLPopulation assocOperator001Range1Query (SeccionP instance) throws SystemException {
        try {
            return new SQLPopulation(SeccionPConstants.CLASS_NAME, PreguntaPConstants.CLASS_NAME, instance.getOid(), SeccionPConstants.ROLE_NAME_PREGUNTAS);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: SeccionP, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
