package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.global.PreexistenciaCConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.persistence.PreexistenciaC;
import com.keralty.aesolicitudes.sqlutils.SQLMax;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLWhereComparison;
import com.keralty.aesolicitudes.sqlutils.SQLWhereConjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aesolicitudes.sqlutils.TypedQueryBuilder;
import com.keralty.aesolicitudes.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;
import org.slf4j.LoggerFactory;

public class PreexistenciaCJpaRepositoryImpl extends AbstractRepository implements PreexistenciaCJpaRepositoryCustom {

    @Inject
    public PreexistenciaCJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<PreexistenciaC> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<PreexistenciaC> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<PreexistenciaC> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<PreexistenciaC> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, PreexistenciaC.class);
    }

    @Override	
    public List<PreexistenciaC> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<PreexistenciaC> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    public Long nextPreexistenciaCIdentificador(Long personaCID) {
        try {
            SQLMax sql = new SQLMax(null, PreexistenciaCConstants.CLASS_NAME, PreexistenciaCConstants.CLASS_NAME + "." + PreexistenciaCConstants.ATTR_FIELD_PREEXISTENCIACIDENTIFICADOR);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(PreexistenciaCConstants.ROLE_NAME_PERSONAC + "." + PersonaCConstants.ATTR_FIELD_PERSONACID, "Autonumerico"));
            comparison1.setOperator("=");
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(personaCID, "Autonumerico"));
            conjunction.addComparison(comparison1);

            sql.getWherePart().addConjunction(conjunction);

            Long tempResult = new TypedQueryBuilder<>(em, Long.class).build(sql).getSingleResult();
            return (tempResult != null ? tempResult + 1L : 1L);
        } catch (Exception e) {
            LoggerFactory.getLogger(PreexistenciaC.class).error(e.getMessage());
            return 1L;
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
