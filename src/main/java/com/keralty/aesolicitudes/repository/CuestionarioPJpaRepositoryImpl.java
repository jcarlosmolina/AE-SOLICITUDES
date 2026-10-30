package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.CuestionarioMedConstants;
import com.keralty.aesolicitudes.global.CuestionarioPConstants;
import com.keralty.aesolicitudes.global.PreguntaPConstants;
import com.keralty.aesolicitudes.global.SeccionConstants;
import com.keralty.aesolicitudes.global.SeccionPConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.persistence.CuestionarioMed;
import com.keralty.aesolicitudes.persistence.CuestionarioP;
import com.keralty.aesolicitudes.persistence.PreguntaP;
import com.keralty.aesolicitudes.persistence.Seccion;
import com.keralty.aesolicitudes.persistence.SeccionP;
import com.keralty.aesolicitudes.sqlutils.SQLCount;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLPopulation;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLWhereComparison;
import com.keralty.aesolicitudes.sqlutils.SQLWhereConjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandSubQuery;
import com.keralty.aesolicitudes.sqlutils.TypedQueryBuilder;
import com.keralty.aesolicitudes.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;

public class CuestionarioPJpaRepositoryImpl extends AbstractRepository implements CuestionarioPJpaRepositoryCustom {

    @Inject
    public CuestionarioPJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<CuestionarioP> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<CuestionarioP> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<CuestionarioP> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<CuestionarioP> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, CuestionarioP.class);
    }

    @Override	
    public List<CuestionarioP> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<CuestionarioP> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
	@Override
    public Collection<Seccion> assocOperator000(CuestionarioMed cuestionarioPTCREARYSECCIONESptCuestionario) throws SystemException {
        try {
            // FOR ALL ptCuestionario.Secciones ORDER BY ((ptCuestionario.Secciones.NumOrden "A")) DO Secciones.TCREARYPREGUNTAS(ptCuestionario.Secciones, this)
        return assocOperator000Range1(cuestionarioPTCREARYSECCIONESptCuestionario);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: CuestionarioP, Assoc.Operator: AssocOperator000, Method: assocOperator000";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator000
	@Override
    public Collection<Seccion> assocOperator000Range1 (CuestionarioMed cuestionarioPTCREARYSECCIONESptCuestionario) throws SystemException {

        SQLSelect sql = assocOperator000Range1Query(cuestionarioPTCREARYSECCIONESptCuestionario);
        return new TypedQueryBuilder<Seccion>(em, Seccion.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator000
	@Override
    public SQLPopulation assocOperator000Range1Query (CuestionarioMed cuestionarioPTCREARYSECCIONESptCuestionario) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(CuestionarioPConstants.CLASS_NAME, SeccionConstants.CLASS_NAME, CuestionarioPConstants.ARG_NAME_TCREARYSECCIONES_CUESTIONARIOPTCREARYSECCIONESPTCUESTIONARIO + "." + CuestionarioMedConstants.ROLE_NAME_SECCIONES, cuestionarioPTCREARYSECCIONESptCuestionario.getOid(), CuestionarioPConstants.ARG_NAME_TCREARYSECCIONES_CUESTIONARIOPTCREARYSECCIONESPTCUESTIONARIO);

            // Order Criteria Elements
            sql.getOrderByPart().addItem(CuestionarioPConstants.ARG_NAME_TCREARYSECCIONES_CUESTIONARIOPTCREARYSECCIONESPTCUESTIONARIO + "." + CuestionarioMedConstants.ROLE_NAME_SECCIONES + "." + SeccionConstants.ATTR_NAME_SECCIONNUMORDEN, CuestionarioMedConstants.CLASS_NAME, cuestionarioPTCREARYSECCIONESptCuestionario.getOid(), CuestionarioPConstants.ARG_NAME_TCREARYSECCIONES_CUESTIONARIOPTCREARYSECCIONESPTCUESTIONARIO, true);
            // Default Order Criteria
            sql.getOrderByPart().addItem(CuestionarioPConstants.ARG_NAME_TCREARYSECCIONES_CUESTIONARIOPTCREARYSECCIONESPTCUESTIONARIO + "." + CuestionarioMedConstants.ROLE_NAME_SECCIONES + "." + SeccionConstants.ATTR_NAME_SECCIONIDENTIFICADOR, CuestionarioMedConstants.CLASS_NAME, cuestionarioPTCREARYSECCIONESptCuestionario.getOid(), CuestionarioPConstants.ARG_NAME_TCREARYSECCIONES_CUESTIONARIOPTCREARYSECCIONESPTCUESTIONARIO, true);

            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: CuestionarioP, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator001
	@Override
    public Collection<SeccionP> assocOperator001(CuestionarioP instance) throws SystemException {
        try {
            // FOR ALL Secciones WHERE (COUNT (Secciones.Preguntas) = 0) DO Secciones.TELIMINAR(Secciones)
        return assocOperator001Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: CuestionarioP, Assoc.Operator: AssocOperator001, Method: assocOperator001";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator001
	@Override
    public Collection<SeccionP> assocOperator001Range1 (CuestionarioP instance) throws SystemException {

        SQLSelect sql = assocOperator001Range1Query(instance);
        return new TypedQueryBuilder<SeccionP>(em, SeccionP.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator001
	@Override
    public SQLPopulation assocOperator001Range1Query (CuestionarioP instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(CuestionarioPConstants.CLASS_NAME, SeccionPConstants.CLASS_NAME, instance.getOid(), CuestionarioPConstants.ROLE_NAME_SECCIONES);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // COUNT (Secciones.Preguntas) = 0
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                        // 'count' Association operator
                        SQLWhereOperandSubQuery operandSubQueryAssocOperator002 = new SQLWhereOperandSubQuery(assocOperator002Range1Query(instance, sql));
                    comparison1.setFirstOperand(operandSubQueryAssocOperator002);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(0), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: CuestionarioP, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator002
	@Override
    public Long assocOperator002(CuestionarioP instance) throws SystemException {
        try {
            // COUNT (Secciones.Preguntas)
            return assocOperator002Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: CuestionarioP, Assoc.Operator: AssocOperator002, Method: assocOperator002";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator002
	@Override
    public Long assocOperator002Range1 (CuestionarioP instance) throws SystemException {
        SQLCount sql = assocOperator002Range1Query(instance, null);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator002
	@Override
    public SQLCount assocOperator002Range1Query (CuestionarioP instance, SQLSelect superQuery) throws SystemException {
        try {
            // Path starts with a class in the subquery
        	if (superQuery == null) {
        		return new SQLCount(CuestionarioPConstants.CLASS_NAME, CuestionarioPConstants.ROLE_NAME_SECCIONES + "." + SeccionPConstants.ROLE_NAME_PREGUNTAS, instance.getOid());
        	} else {
        		return new SQLCount(superQuery, CuestionarioPConstants.CLASS_NAME, CuestionarioPConstants.ROLE_NAME_SECCIONES + "." + SeccionPConstants.ROLE_NAME_PREGUNTAS);
        	}
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: CuestionarioP, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator003
	@Override
    public Collection<SeccionP> assocOperator003(CuestionarioP instance) throws SystemException {
        try {
            // FOR ALL Secciones DO Secciones.TELIMINAR(Secciones)
        return assocOperator003Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: CuestionarioP, Assoc.Operator: AssocOperator003, Method: assocOperator003";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator003
	@Override
    public Collection<SeccionP> assocOperator003Range1 (CuestionarioP instance) throws SystemException {

        SQLSelect sql = assocOperator003Range1Query(instance);
        return new TypedQueryBuilder<SeccionP>(em, SeccionP.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator003
	@Override
    public SQLPopulation assocOperator003Range1Query (CuestionarioP instance) throws SystemException {
        try {
            return new SQLPopulation(CuestionarioPConstants.CLASS_NAME, SeccionPConstants.CLASS_NAME, instance.getOid(), CuestionarioPConstants.ROLE_NAME_SECCIONES);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: CuestionarioP, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator007
	@Override
    public Collection<PreguntaP> assocOperator007(CuestionarioP instance, Long cuestionarioPTMARCARDATOSPREGUNTACOREptNumPregunta) throws SystemException {
        try {
            // FOR ALL Secciones.Preguntas WHERE (Secciones.Preguntas.Numero = ptNumPregunta) DO Secciones.Preguntas.marcarDatosCORE(Secciones.Preguntas, ptpRespuestaSiNo, ptpRespuestaObs)
        return assocOperator007Range1(instance, cuestionarioPTMARCARDATOSPREGUNTACOREptNumPregunta);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: CuestionarioP, Assoc.Operator: AssocOperator007, Method: assocOperator007";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator007
	@Override
    public Collection<PreguntaP> assocOperator007Range1 (CuestionarioP instance, Long cuestionarioPTMARCARDATOSPREGUNTACOREptNumPregunta) throws SystemException {

        SQLSelect sql = assocOperator007Range1Query(instance, cuestionarioPTMARCARDATOSPREGUNTACOREptNumPregunta);
        return new TypedQueryBuilder<PreguntaP>(em, PreguntaP.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator007
	@Override
    public SQLPopulation assocOperator007Range1Query (CuestionarioP instance, Long cuestionarioPTMARCARDATOSPREGUNTACOREptNumPregunta) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(CuestionarioPConstants.CLASS_NAME, PreguntaPConstants.CLASS_NAME, instance.getOid(), CuestionarioPConstants.ROLE_NAME_SECCIONES + "." + SeccionPConstants.ROLE_NAME_PREGUNTAS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Secciones.Preguntas.Numero = ptNumPregunta
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(CuestionarioPConstants.ROLE_NAME_SECCIONES + "." + SeccionPConstants.ROLE_NAME_PREGUNTAS + "." + PreguntaPConstants.ATTR_NAME_PREGUNTAPNUMERO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(cuestionarioPTMARCARDATOSPREGUNTACOREptNumPregunta, Constants.Type.INT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: CuestionarioP, Assoc.Operator: AssocOperator007, Method: assocOperator007Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator008
	@Override
    public Collection<PreguntaP> assocOperator008(CuestionarioP instance) throws SystemException {
        try {
            // FOR ALL Secciones.Preguntas WHERE (Secciones.Preguntas.Numero = 108) DO Secciones.Preguntas.marcarRespuesta(Secciones.Preguntas, true, fugetValorParametroConf("COMENTARIOSPREGUNTA108"), "")
        return assocOperator008Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: CuestionarioP, Assoc.Operator: AssocOperator008, Method: assocOperator008";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator008
	@Override
    public Collection<PreguntaP> assocOperator008Range1 (CuestionarioP instance) throws SystemException {

        SQLSelect sql = assocOperator008Range1Query(instance);
        return new TypedQueryBuilder<PreguntaP>(em, PreguntaP.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator008
	@Override
    public SQLPopulation assocOperator008Range1Query (CuestionarioP instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(CuestionarioPConstants.CLASS_NAME, PreguntaPConstants.CLASS_NAME, instance.getOid(), CuestionarioPConstants.ROLE_NAME_SECCIONES + "." + SeccionPConstants.ROLE_NAME_PREGUNTAS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Secciones.Preguntas.Numero = 108
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(CuestionarioPConstants.ROLE_NAME_SECCIONES + "." + SeccionPConstants.ROLE_NAME_PREGUNTAS + "." + PreguntaPConstants.ATTR_NAME_PREGUNTAPNUMERO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(108), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: CuestionarioP, Assoc.Operator: AssocOperator008, Method: assocOperator008Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
