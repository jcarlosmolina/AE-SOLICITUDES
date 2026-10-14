package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.global.AesolicitudesConstants;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.global.UsuarioRegConstants;
import com.keralty.aesolicitudes.persistence.UsuarioReg;
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

public class UsuarioRegJpaRepositoryImpl extends AbstractRepository implements UsuarioRegJpaRepositoryCustom {

    @Inject
    public UsuarioRegJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<UsuarioReg> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<UsuarioReg> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<UsuarioReg> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<UsuarioReg> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, UsuarioReg.class);
    }

    @Override	
    public List<UsuarioReg> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<UsuarioReg> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    public Long nextUsuarioRegIdentificador(Long aesolicitudesidsolicitud) {
        try {
            SQLMax sql = new SQLMax(null, UsuarioRegConstants.CLASS_NAME, UsuarioRegConstants.CLASS_NAME + "." + UsuarioRegConstants.ATTR_FIELD_USUARIOREGIDENTIFICADOR);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(UsuarioRegConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ATTR_FIELD_AESOLICITUDESIDSOLICITUD, "Autonumerico"));
            comparison1.setOperator("=");
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(aesolicitudesidsolicitud, "Autonumerico"));
            conjunction.addComparison(comparison1);

            sql.getWherePart().addConjunction(conjunction);

            Long tempResult = new TypedQueryBuilder<>(em, Long.class).build(sql).getSingleResult();
            return (tempResult != null ? tempResult + 1L : 1L);
        } catch (Exception e) {
            LoggerFactory.getLogger(UsuarioReg.class).error(e.getMessage());
            return 1L;
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
