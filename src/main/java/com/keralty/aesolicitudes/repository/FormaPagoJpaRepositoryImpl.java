package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.AesolicitudesConstants;
import com.keralty.aesolicitudes.global.DominioConstants;
import com.keralty.aesolicitudes.global.FormaPagoConstants;
import com.keralty.aesolicitudes.global.PlanesConstants;
import com.keralty.aesolicitudes.global.ProductosConstants;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.persistence.Dominio;
import com.keralty.aesolicitudes.persistence.FormaPago;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.sqlutils.SQLExists;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLWhereComparison;
import com.keralty.aesolicitudes.sqlutils.SQLWhereConjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandNull;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.aesolicitudes.sqlutils.TypedQueryBuilder;
import com.keralty.aesolicitudes.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;

public class FormaPagoJpaRepositoryImpl extends AbstractRepository implements FormaPagoJpaRepositoryCustom {

    @Inject
    public FormaPagoJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<FormaPago> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<FormaPago> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<FormaPago> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<FormaPago> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, FormaPago.class);
    }
    
    public List<FormaPago> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<FormaPago> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
    public Boolean assocOperator000(Dominio dominioInsFormaPagopthisDominio) throws SystemException {
        try {
            // EXIST (Dominios) WHERE (Dominios = pthisDominio)
            return assocOperator000Range1(dominioInsFormaPagopthisDominio);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FormaPago, Assoc.Operator: AssocOperator000, Method: assocOperator000";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator000
    public Boolean assocOperator000Range1 (Dominio dominioInsFormaPagopthisDominio) throws SystemException {
        SQLExists sql = assocOperator000Range1Query(dominioInsFormaPagopthisDominio, null);
        return !new TypedQueryBuilder<FormaPago>(em, FormaPago.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator000
    public SQLExists assocOperator000Range1Query (Dominio dominioInsFormaPagopthisDominio, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, FormaPagoConstants.CLASS_NAME, FormaPagoConstants.ROLE_NAME_DOMINIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Dominios = pthisDominio
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(FormaPagoConstants.ROLE_NAME_DOMINIOS, DominioConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(DominioConstants.ARG_NAME_INSFORMAPAGO_DOMINIOINSFORMAPAGOPTHISDOMINIO, DominioConstants.CLASS_NAME, DominioConstants.CLASS_NAME, dominioInsFormaPagopthisDominio.getOid(), DominioConstants.ARG_NAME_INSFORMAPAGO_DOMINIOINSFORMAPAGOPTHISDOMINIO);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FormaPago, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator001
    public Boolean assocOperator001(Dominio dominioDelFormaPagopthisDominio) throws SystemException {
        try {
            // EXIST (Dominios) WHERE (Dominios = pthisDominio)
            return assocOperator001Range1(dominioDelFormaPagopthisDominio);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FormaPago, Assoc.Operator: AssocOperator001, Method: assocOperator001";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator001
    public Boolean assocOperator001Range1 (Dominio dominioDelFormaPagopthisDominio) throws SystemException {
        SQLExists sql = assocOperator001Range1Query(dominioDelFormaPagopthisDominio, null);
        return !new TypedQueryBuilder<FormaPago>(em, FormaPago.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator001
    public SQLExists assocOperator001Range1Query (Dominio dominioDelFormaPagopthisDominio, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, FormaPagoConstants.CLASS_NAME, FormaPagoConstants.ROLE_NAME_DOMINIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Dominios = pthisDominio
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(FormaPagoConstants.ROLE_NAME_DOMINIOS, DominioConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(DominioConstants.ARG_NAME_DELFORMAPAGO_DOMINIODELFORMAPAGOPTHISDOMINIO, DominioConstants.CLASS_NAME, DominioConstants.CLASS_NAME, dominioDelFormaPagopthisDominio.getOid(), DominioConstants.ARG_NAME_DELFORMAPAGO_DOMINIODELFORMAPAGOPTHISDOMINIO);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FormaPago, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator002
    public Boolean assocOperator002(Solicitud solicitudTMODIFICARINFOPAGOpthisSolicitud) throws SystemException {
        try {
            // EXIST (Dominios) WHERE (Dominios.ProductoT = pthisSolicitud.Aesolicitudes.ProductoT AND Dominios.PlanT = pthisSolicitud.Aesolicitudes.PlanT)
            return assocOperator002Range1(solicitudTMODIFICARINFOPAGOpthisSolicitud);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FormaPago, Assoc.Operator: AssocOperator002, Method: assocOperator002";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator002
    public Boolean assocOperator002Range1 (Solicitud solicitudTMODIFICARINFOPAGOpthisSolicitud) throws SystemException {
        SQLExists sql = assocOperator002Range1Query(solicitudTMODIFICARINFOPAGOpthisSolicitud, null);
        return !new TypedQueryBuilder<FormaPago>(em, FormaPago.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator002
    public SQLExists assocOperator002Range1Query (Solicitud solicitudTMODIFICARINFOPAGOpthisSolicitud, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, FormaPagoConstants.CLASS_NAME, FormaPagoConstants.ROLE_NAME_DOMINIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Dominios.ProductoT = pthisSolicitud.Aesolicitudes.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(FormaPagoConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ARG_NAME_TMODIFICARINFOPAGO_SOLICITUDTMODIFICARINFOPAGOPTHISSOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT, SolicitudConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, solicitudTMODIFICARINFOPAGOpthisSolicitud.getOid(), SolicitudConstants.ARG_NAME_TMODIFICARINFOPAGO_SOLICITUDTMODIFICARINFOPAGOPTHISSOLICITUD);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Dominios.PlanT = pthisSolicitud.Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(FormaPagoConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    if (solicitudTMODIFICARINFOPAGOpthisSolicitud.isNull() || solicitudTMODIFICARINFOPAGOpthisSolicitud.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(SolicitudConstants.ARG_NAME_TMODIFICARINFOPAGO_SOLICITUDTMODIFICARINFOPAGOPTHISSOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, SolicitudConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, solicitudTMODIFICARINFOPAGOpthisSolicitud.getOid(), SolicitudConstants.ARG_NAME_TMODIFICARINFOPAGO_SOLICITUDTMODIFICARINFOPAGOPTHISSOLICITUD);
                    comparison2.setSecondOperand(operand224);
                    }
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FormaPago, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
