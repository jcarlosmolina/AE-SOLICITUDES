package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.global.DominioConstants;
import com.keralty.aesolicitudes.global.ProrrateoConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.persistence.Prorrateo;
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

public class ProrrateoJpaRepositoryImpl extends AbstractRepository implements ProrrateoJpaRepositoryCustom {

    @Inject
    public ProrrateoJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<Prorrateo> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Prorrateo> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Prorrateo> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Prorrateo> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Prorrateo.class);
    }
    
    public List<Prorrateo> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<Prorrateo> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    public Long nextProrrateoidProrrateo(Long dominioNumero) {
        try {
            SQLMax sql = new SQLMax(null, ProrrateoConstants.CLASS_NAME, ProrrateoConstants.CLASS_NAME + "." + ProrrateoConstants.ATTR_FIELD_PRORRATEOIDPRORRATEO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ProrrateoConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ATTR_FIELD_DOMINIONUMERO, "Autonumerico"));
            comparison1.setOperator("=");
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(dominioNumero, "Autonumerico"));
            conjunction.addComparison(comparison1);

            sql.getWherePart().addConjunction(conjunction);

            Long tempResult = new TypedQueryBuilder<>(em, Long.class).build(sql).getSingleResult();
            return (tempResult != null ? tempResult + 1L : 1L);
        } catch (Exception e) {
            LoggerFactory.getLogger(Prorrateo.class).error(e.getMessage());
            return 1L;
        }
    }

    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
