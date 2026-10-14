package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.global.DocumentoGConstants;
import com.keralty.aesolicitudes.global.ObsEstadoConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.persistence.ObsEstado;
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

public class ObsEstadoJpaRepositoryImpl extends AbstractRepository implements ObsEstadoJpaRepositoryCustom {

    @Inject
    public ObsEstadoJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<ObsEstado> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<ObsEstado> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<ObsEstado> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<ObsEstado> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, ObsEstado.class);
    }
    
    public List<ObsEstado> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<ObsEstado> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    public Long nextObsEstadoId(Long documentoGIdentificador) {
        try {
            SQLMax sql = new SQLMax(null, ObsEstadoConstants.CLASS_NAME, ObsEstadoConstants.CLASS_NAME + "." + ObsEstadoConstants.ATTR_FIELD_OBSESTADOID);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ObsEstadoConstants.ROLE_NAME_DOCUMENTOG + "." + DocumentoGConstants.ATTR_FIELD_DOCUMENTOGIDENTIFICADOR, "Autonumerico"));
            comparison1.setOperator("=");
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(documentoGIdentificador, "Autonumerico"));
            conjunction.addComparison(comparison1);

            sql.getWherePart().addConjunction(conjunction);

            Long tempResult = new TypedQueryBuilder<>(em, Long.class).build(sql).getSingleResult();
            return (tempResult != null ? tempResult + 1L : 1L);
        } catch (Exception e) {
            LoggerFactory.getLogger(ObsEstado.class).error(e.getMessage());
            return 1L;
        }
    }

    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
