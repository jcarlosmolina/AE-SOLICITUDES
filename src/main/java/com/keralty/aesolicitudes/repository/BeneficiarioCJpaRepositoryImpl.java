package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.AnexoCConstants;
import com.keralty.aesolicitudes.global.BeneficiarioCConstants;
import com.keralty.aesolicitudes.global.ConceptoCConstants;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.global.DominioConstants;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.global.PlanesConstants;
import com.keralty.aesolicitudes.global.PreexistenciaCConstants;
import com.keralty.aesolicitudes.global.ProductosConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.global.UsuarioConstants;
import com.keralty.aesolicitudes.persistence.AnexoC;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.ConceptoC;
import com.keralty.aesolicitudes.persistence.PreexistenciaC;
import com.keralty.aesolicitudes.persistence.Usuario;
import com.keralty.aesolicitudes.sqlutils.SQLExists;
import com.keralty.aesolicitudes.sqlutils.SQLMax;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLPopulation;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLSum;
import com.keralty.aesolicitudes.sqlutils.SQLWhereComparison;
import com.keralty.aesolicitudes.sqlutils.SQLWhereConjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.aesolicitudes.sqlutils.TypedQueryBuilder;
import com.keralty.aesolicitudes.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;
import org.slf4j.LoggerFactory;

public class BeneficiarioCJpaRepositoryImpl extends AbstractRepository implements BeneficiarioCJpaRepositoryCustom {

    @Inject
    public BeneficiarioCJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<BeneficiarioC> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<BeneficiarioC> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<BeneficiarioC> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<BeneficiarioC> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, BeneficiarioC.class);
    }

    @Override	
    public List<BeneficiarioC> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<BeneficiarioC> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    @Override
    public Long nextBeneficiarioCID(Long contratoCContratoCID) {
        try {
            SQLMax sql = new SQLMax(null, BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.CLASS_NAME + "." + BeneficiarioCConstants.ATTR_FIELD_BENEFICIARIOCID);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(BeneficiarioCConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ATTR_FIELD_CONTRATOCID, "Autonumerico"));
            comparison1.setOperator("=");
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(contratoCContratoCID, "Autonumerico"));
            conjunction.addComparison(comparison1);

            sql.getWherePart().addConjunction(conjunction);

            Long tempResult = new TypedQueryBuilder<>(em, Long.class).build(sql).getSingleResult();
            return (tempResult != null ? tempResult + 1L : 1L);
        } catch (Exception e) {
            LoggerFactory.getLogger(BeneficiarioC.class).error(e.getMessage());
            return 1L;
        }
    }

    // AssocOperator: AssocOperator000
	@Override
    public Double assocOperator000(BeneficiarioC instance) throws SystemException {
        try {
            // SUM (ConceptosC.valorConcepto) WHERE (ConceptosC.nombreConcepto LIKE "%VALOR%BRUTO%")
            return assocOperator000Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator000, Method: assocOperator000";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator000
	@Override
    public Double assocOperator000Range1 (BeneficiarioC instance) throws SystemException {
        SQLSum sql = assocOperator000Range1Query(instance);
        return new TypedQueryBuilder<Double>(em, Double.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator000
	@Override
    public SQLSum assocOperator000Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLSum sql = new SQLSum(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ROLE_NAME_CONCEPTOSC + "." + ConceptoCConstants.ATTR_NAME_CONCEPTOCVALORCONCEPTO, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ConceptosC.nombreConcepto LIKE "%VALOR%BRUTO%"
                    // 'like' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("like");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(BeneficiarioCConstants.ROLE_NAME_CONCEPTOSC + "." + ConceptoCConstants.ATTR_NAME_CONCEPTOCNOMBRECONCEPTO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral("%VALOR%BRUTO%", Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator001
	@Override
    public Double assocOperator001(BeneficiarioC instance) throws SystemException {
        try {
            // SUM (ConceptosC.valorConcepto) WHERE (ConceptosC.nombreConcepto LIKE "%VALOR%BRUTO%")
            return assocOperator001Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator001, Method: assocOperator001";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator001
	@Override
    public Double assocOperator001Range1 (BeneficiarioC instance) throws SystemException {
        SQLSum sql = assocOperator001Range1Query(instance);
        return new TypedQueryBuilder<Double>(em, Double.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator001
	@Override
    public SQLSum assocOperator001Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLSum sql = new SQLSum(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ROLE_NAME_CONCEPTOSC + "." + ConceptoCConstants.ATTR_NAME_CONCEPTOCVALORCONCEPTO, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ConceptosC.nombreConcepto LIKE "%VALOR%BRUTO%"
                    // 'like' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("like");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(BeneficiarioCConstants.ROLE_NAME_CONCEPTOSC + "." + ConceptoCConstants.ATTR_NAME_CONCEPTOCNOMBRECONCEPTO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral("%VALOR%BRUTO%", Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator002
	@Override
    public Double assocOperator002(BeneficiarioC instance) throws SystemException {
        try {
            // SUM (ConceptosC.valorConcepto) WHERE (ConceptosC.nombreConcepto LIKE "%VALOR%BRUTO%")
            return assocOperator002Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator002, Method: assocOperator002";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator002
	@Override
    public Double assocOperator002Range1 (BeneficiarioC instance) throws SystemException {
        SQLSum sql = assocOperator002Range1Query(instance);
        return new TypedQueryBuilder<Double>(em, Double.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator002
	@Override
    public SQLSum assocOperator002Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLSum sql = new SQLSum(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ROLE_NAME_CONCEPTOSC + "." + ConceptoCConstants.ATTR_NAME_CONCEPTOCVALORCONCEPTO, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ConceptosC.nombreConcepto LIKE "%VALOR%BRUTO%"
                    // 'like' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("like");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(BeneficiarioCConstants.ROLE_NAME_CONCEPTOSC + "." + ConceptoCConstants.ATTR_NAME_CONCEPTOCNOMBRECONCEPTO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral("%VALOR%BRUTO%", Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator003
	@Override
    public Double assocOperator003(BeneficiarioC instance) throws SystemException {
        try {
            // SUM (ConceptosC.valorConcepto) WHERE (ConceptosC.nombreConcepto LIKE "%DESC%BEN%")
            return assocOperator003Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator003, Method: assocOperator003";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator003
	@Override
    public Double assocOperator003Range1 (BeneficiarioC instance) throws SystemException {
        SQLSum sql = assocOperator003Range1Query(instance);
        return new TypedQueryBuilder<Double>(em, Double.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator003
	@Override
    public SQLSum assocOperator003Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLSum sql = new SQLSum(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ROLE_NAME_CONCEPTOSC + "." + ConceptoCConstants.ATTR_NAME_CONCEPTOCVALORCONCEPTO, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ConceptosC.nombreConcepto LIKE "%DESC%BEN%"
                    // 'like' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("like");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(BeneficiarioCConstants.ROLE_NAME_CONCEPTOSC + "." + ConceptoCConstants.ATTR_NAME_CONCEPTOCNOMBRECONCEPTO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral("%DESC%BEN%", Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator004
	@Override
    public Double assocOperator004(BeneficiarioC instance) throws SystemException {
        try {
            // SUM (ConceptosC.valorConcepto) WHERE (ConceptosC.nombreConcepto LIKE "%DESC%FAM%")
            return assocOperator004Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator004, Method: assocOperator004";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator004
	@Override
    public Double assocOperator004Range1 (BeneficiarioC instance) throws SystemException {
        SQLSum sql = assocOperator004Range1Query(instance);
        return new TypedQueryBuilder<Double>(em, Double.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator004
	@Override
    public SQLSum assocOperator004Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLSum sql = new SQLSum(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ROLE_NAME_CONCEPTOSC + "." + ConceptoCConstants.ATTR_NAME_CONCEPTOCVALORCONCEPTO, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ConceptosC.nombreConcepto LIKE "%DESC%FAM%"
                    // 'like' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("like");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(BeneficiarioCConstants.ROLE_NAME_CONCEPTOSC + "." + ConceptoCConstants.ATTR_NAME_CONCEPTOCNOMBRECONCEPTO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral("%DESC%FAM%", Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator004, Method: assocOperator004Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator005
	@Override
    public Double assocOperator005(BeneficiarioC instance) throws SystemException {
        try {
            // SUM (ConceptosC.valorConcepto) WHERE (ConceptosC.nombreConcepto LIKE "%DESC%CON%")
            return assocOperator005Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator005, Method: assocOperator005";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator005
	@Override
    public Double assocOperator005Range1 (BeneficiarioC instance) throws SystemException {
        SQLSum sql = assocOperator005Range1Query(instance);
        return new TypedQueryBuilder<Double>(em, Double.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator005
	@Override
    public SQLSum assocOperator005Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLSum sql = new SQLSum(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ROLE_NAME_CONCEPTOSC + "." + ConceptoCConstants.ATTR_NAME_CONCEPTOCVALORCONCEPTO, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ConceptosC.nombreConcepto LIKE "%DESC%CON%"
                    // 'like' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("like");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(BeneficiarioCConstants.ROLE_NAME_CONCEPTOSC + "." + ConceptoCConstants.ATTR_NAME_CONCEPTOCNOMBRECONCEPTO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral("%DESC%CON%", Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator005, Method: assocOperator005Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator006
	@Override
    public Double assocOperator006(BeneficiarioC instance) throws SystemException {
        try {
            // SUM (ConceptosC.valorConcepto) WHERE (ConceptosC.nombreConcepto LIKE "%DESC%FINANCIERO%")
            return assocOperator006Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator006, Method: assocOperator006";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator006
	@Override
    public Double assocOperator006Range1 (BeneficiarioC instance) throws SystemException {
        SQLSum sql = assocOperator006Range1Query(instance);
        return new TypedQueryBuilder<Double>(em, Double.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator006
	@Override
    public SQLSum assocOperator006Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLSum sql = new SQLSum(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ROLE_NAME_CONCEPTOSC + "." + ConceptoCConstants.ATTR_NAME_CONCEPTOCVALORCONCEPTO, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ConceptosC.nombreConcepto LIKE "%DESC%FINANCIERO%"
                    // 'like' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("like");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(BeneficiarioCConstants.ROLE_NAME_CONCEPTOSC + "." + ConceptoCConstants.ATTR_NAME_CONCEPTOCNOMBRECONCEPTO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral("%DESC%FINANCIERO%", Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator006, Method: assocOperator006Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator007
	@Override
    public Double assocOperator007(BeneficiarioC instance) throws SystemException {
        try {
            // SUM (ConceptosC.valorConcepto) WHERE (ConceptosC.nombreConcepto LIKE "%VALOR%BRUTO%")
            return assocOperator007Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator007, Method: assocOperator007";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator007
	@Override
    public Double assocOperator007Range1 (BeneficiarioC instance) throws SystemException {
        SQLSum sql = assocOperator007Range1Query(instance);
        return new TypedQueryBuilder<Double>(em, Double.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator007
	@Override
    public SQLSum assocOperator007Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLSum sql = new SQLSum(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ROLE_NAME_CONCEPTOSC + "." + ConceptoCConstants.ATTR_NAME_CONCEPTOCVALORCONCEPTO, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ConceptosC.nombreConcepto LIKE "%VALOR%BRUTO%"
                    // 'like' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("like");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(BeneficiarioCConstants.ROLE_NAME_CONCEPTOSC + "." + ConceptoCConstants.ATTR_NAME_CONCEPTOCNOMBRECONCEPTO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral("%VALOR%BRUTO%", Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator007, Method: assocOperator007Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator008
	@Override
    public Boolean assocOperator008(BeneficiarioC instance) throws SystemException {
        try {
            // EXIST (ContratoC.ProductoC.Dominios) WHERE (ContratoC.ProductoC.Dominios.PlanT = ContratoC.PlanC AND ContratoC.ProductoC.Dominios.IgnorarPreexistencias = true)
            return assocOperator008Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator008, Method: assocOperator008";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator008
	@Override
    public Boolean assocOperator008Range1 (BeneficiarioC instance) throws SystemException {
        SQLExists sql = assocOperator008Range1Query(instance);
        return !new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator008
	@Override
    public SQLExists assocOperator008Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ROLE_NAME_PRODUCTOC + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ContratoC.ProductoC.Dominios.PlanT = ContratoC.PlanC
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(BeneficiarioCConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ROLE_NAME_PRODUCTOC + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(BeneficiarioCConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ROLE_NAME_PLANC, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getContratoC().getPlanC().getOid(), BeneficiarioCConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ROLE_NAME_PLANC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // ContratoC.ProductoC.Dominios.IgnorarPreexistencias = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(BeneficiarioCConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ROLE_NAME_PRODUCTOC + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOIGNORARPREEXISTENCIAS, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator008, Method: assocOperator008Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator009
	@Override
    public Boolean assocOperator009(BeneficiarioC instance) throws SystemException {
        try {
            // EXIST (PersonaC.PreexistenciasC)
            return assocOperator009Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator009, Method: assocOperator009";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator009
	@Override
    public Boolean assocOperator009Range1 (BeneficiarioC instance) throws SystemException {
        SQLExists sql = assocOperator009Range1Query(instance);
        return !new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator009
	@Override
    public SQLExists assocOperator009Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ROLE_NAME_PERSONAC + "." + PersonaCConstants.ROLE_NAME_PREEXISTENCIASC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator009, Method: assocOperator009Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator010
	@Override
    public Collection<AnexoC> assocOperator010(BeneficiarioC instance) throws SystemException {
        try {
            // FOR ALL AnexosC DO AnexosC.eliminar(AnexosC)
        return assocOperator010Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator010, Method: assocOperator010";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator010
	@Override
    public Collection<AnexoC> assocOperator010Range1 (BeneficiarioC instance) throws SystemException {

        SQLSelect sql = assocOperator010Range1Query(instance);
        return new TypedQueryBuilder<AnexoC>(em, AnexoC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator010
	@Override
    public SQLPopulation assocOperator010Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            return new SQLPopulation(BeneficiarioCConstants.CLASS_NAME, AnexoCConstants.CLASS_NAME, instance.getOid(), BeneficiarioCConstants.ROLE_NAME_ANEXOSC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator010, Method: assocOperator010Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator011
	@Override
    public Collection<ConceptoC> assocOperator011(BeneficiarioC instance) throws SystemException {
        try {
            // FOR ALL ConceptosC DO ConceptosC.eliminar(ConceptosC)
        return assocOperator011Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator011, Method: assocOperator011";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator011
	@Override
    public Collection<ConceptoC> assocOperator011Range1 (BeneficiarioC instance) throws SystemException {

        SQLSelect sql = assocOperator011Range1Query(instance);
        return new TypedQueryBuilder<ConceptoC>(em, ConceptoC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator011
	@Override
    public SQLPopulation assocOperator011Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            return new SQLPopulation(BeneficiarioCConstants.CLASS_NAME, ConceptoCConstants.CLASS_NAME, instance.getOid(), BeneficiarioCConstants.ROLE_NAME_CONCEPTOSC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator011, Method: assocOperator011Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator013
	@Override
    public Boolean assocOperator013(BeneficiarioC instance) throws SystemException {
        try {
            // EXIST (PersonaC)
            return assocOperator013Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator013, Method: assocOperator013";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator013
	@Override
    public Boolean assocOperator013Range1 (BeneficiarioC instance) throws SystemException {
        SQLExists sql = assocOperator013Range1Query(instance);
        return !new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator013
	@Override
    public SQLExists assocOperator013Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ROLE_NAME_PERSONAC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator013, Method: assocOperator013Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator014
	@Override
    public Boolean assocOperator014(BeneficiarioC instance) throws SystemException {
        try {
            // EXIST (EstadoBeneficiarioC)
            return assocOperator014Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator014, Method: assocOperator014";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator014
	@Override
    public Boolean assocOperator014Range1 (BeneficiarioC instance) throws SystemException {
        SQLExists sql = assocOperator014Range1Query(instance);
        return !new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator014
	@Override
    public SQLExists assocOperator014Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ROLE_NAME_ESTADOBENEFICIARIOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator014, Method: assocOperator014Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator015
	@Override
    public Boolean assocOperator015(BeneficiarioC instance) throws SystemException {
        try {
            // EXIST (EstadoBeneficiarioC)
            return assocOperator015Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator015, Method: assocOperator015";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator015
	@Override
    public Boolean assocOperator015Range1 (BeneficiarioC instance) throws SystemException {
        SQLExists sql = assocOperator015Range1Query(instance);
        return !new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator015
	@Override
    public SQLExists assocOperator015Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ROLE_NAME_ESTADOBENEFICIARIOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator015, Method: assocOperator015Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator017
	@Override
    public Boolean assocOperator017(BeneficiarioC instance) throws SystemException {
        try {
            // EXIST (EstadoBeneficiarioC)
            return assocOperator017Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator017, Method: assocOperator017";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator017
	@Override
    public Boolean assocOperator017Range1 (BeneficiarioC instance) throws SystemException {
        SQLExists sql = assocOperator017Range1Query(instance);
        return !new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator017
	@Override
    public SQLExists assocOperator017Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ROLE_NAME_ESTADOBENEFICIARIOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator017, Method: assocOperator017Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator019
	@Override
    public Boolean assocOperator019(BeneficiarioC instance) throws SystemException {
        try {
            // EXIST (EstadoBeneficiarioC)
            return assocOperator019Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator019, Method: assocOperator019";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator019
	@Override
    public Boolean assocOperator019Range1 (BeneficiarioC instance) throws SystemException {
        SQLExists sql = assocOperator019Range1Query(instance);
        return !new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator019
	@Override
    public SQLExists assocOperator019Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ROLE_NAME_ESTADOBENEFICIARIOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator019, Method: assocOperator019Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator022
	@Override
    public Boolean assocOperator022(Usuario beneficiarioCTNEWDESDEAEptUsuario) throws SystemException {
        try {
            // EXIST (ptUsuario.AnexoMat)
            return assocOperator022Range1(beneficiarioCTNEWDESDEAEptUsuario);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator022, Method: assocOperator022";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator022
	@Override
    public Boolean assocOperator022Range1 (Usuario beneficiarioCTNEWDESDEAEptUsuario) throws SystemException {
        SQLExists sql = assocOperator022Range1Query(beneficiarioCTNEWDESDEAEptUsuario, null);
        return !new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator022
	@Override
    public SQLExists assocOperator022Range1Query (Usuario beneficiarioCTNEWDESDEAEptUsuario, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ARG_NAME_TNEWDESDEAE_BENEFICIARIOCTNEWDESDEAEPTUSUARIO + "." + UsuarioConstants.ROLE_NAME_ANEXOMAT, UsuarioConstants.CLASS_NAME, beneficiarioCTNEWDESDEAEptUsuario.getOid(), BeneficiarioCConstants.ARG_NAME_TNEWDESDEAE_BENEFICIARIOCTNEWDESDEAEPTUSUARIO);
            } else {
                sql = new SQLExists(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ARG_NAME_TNEWDESDEAE_BENEFICIARIOCTNEWDESDEAEPTUSUARIO + "." + UsuarioConstants.ROLE_NAME_ANEXOMAT, UsuarioConstants.CLASS_NAME, beneficiarioCTNEWDESDEAEptUsuario.getOid(), BeneficiarioCConstants.ARG_NAME_TNEWDESDEAE_BENEFICIARIOCTNEWDESDEAEPTUSUARIO);
            }
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator022, Method: assocOperator022Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator023
	@Override
    public Boolean assocOperator023(Usuario beneficiarioCTNEWDESDEAEptUsuario) throws SystemException {
        try {
            // EXIST (ptUsuario.AnexoNeo)
            return assocOperator023Range1(beneficiarioCTNEWDESDEAEptUsuario);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator023, Method: assocOperator023";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator023
	@Override
    public Boolean assocOperator023Range1 (Usuario beneficiarioCTNEWDESDEAEptUsuario) throws SystemException {
        SQLExists sql = assocOperator023Range1Query(beneficiarioCTNEWDESDEAEptUsuario, null);
        return !new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator023
	@Override
    public SQLExists assocOperator023Range1Query (Usuario beneficiarioCTNEWDESDEAEptUsuario, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ARG_NAME_TNEWDESDEAE_BENEFICIARIOCTNEWDESDEAEPTUSUARIO + "." + UsuarioConstants.ROLE_NAME_ANEXONEO, UsuarioConstants.CLASS_NAME, beneficiarioCTNEWDESDEAEptUsuario.getOid(), BeneficiarioCConstants.ARG_NAME_TNEWDESDEAE_BENEFICIARIOCTNEWDESDEAEPTUSUARIO);
            } else {
                sql = new SQLExists(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ARG_NAME_TNEWDESDEAE_BENEFICIARIOCTNEWDESDEAEPTUSUARIO + "." + UsuarioConstants.ROLE_NAME_ANEXONEO, UsuarioConstants.CLASS_NAME, beneficiarioCTNEWDESDEAEptUsuario.getOid(), BeneficiarioCConstants.ARG_NAME_TNEWDESDEAE_BENEFICIARIOCTNEWDESDEAEPTUSUARIO);
            }
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator023, Method: assocOperator023Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator024
	@Override
    public Collection<PreexistenciaC> assocOperator024(BeneficiarioC instance) throws SystemException {
        try {
            // FOR ALL PersonaC.PreexistenciasC DO PersonaC.PreexistenciasC.eliminar(PersonaC.PreexistenciasC)
        return assocOperator024Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator024, Method: assocOperator024";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator024
	@Override
    public Collection<PreexistenciaC> assocOperator024Range1 (BeneficiarioC instance) throws SystemException {

        SQLSelect sql = assocOperator024Range1Query(instance);
        return new TypedQueryBuilder<PreexistenciaC>(em, PreexistenciaC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator024
	@Override
    public SQLPopulation assocOperator024Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            return new SQLPopulation(BeneficiarioCConstants.CLASS_NAME, PreexistenciaCConstants.CLASS_NAME, instance.getOid(), BeneficiarioCConstants.ROLE_NAME_PERSONAC + "." + PersonaCConstants.ROLE_NAME_PREEXISTENCIASC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator024, Method: assocOperator024Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator025
	@Override
    public Collection<ConceptoC> assocOperator025(BeneficiarioC instance) throws SystemException {
        try {
            // FOR ALL ConceptosC DO ConceptosC.eliminar(ConceptosC)
        return assocOperator025Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator025, Method: assocOperator025";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator025
	@Override
    public Collection<ConceptoC> assocOperator025Range1 (BeneficiarioC instance) throws SystemException {

        SQLSelect sql = assocOperator025Range1Query(instance);
        return new TypedQueryBuilder<ConceptoC>(em, ConceptoC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator025
	@Override
    public SQLPopulation assocOperator025Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            return new SQLPopulation(BeneficiarioCConstants.CLASS_NAME, ConceptoCConstants.CLASS_NAME, instance.getOid(), BeneficiarioCConstants.ROLE_NAME_CONCEPTOSC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator025, Method: assocOperator025Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator029
	@Override
    public Boolean assocOperator029(BeneficiarioC instance) throws SystemException {
        try {
            // EXIST (EstadoBeneficiarioC)
            return assocOperator029Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator029, Method: assocOperator029";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator029
	@Override
    public Boolean assocOperator029Range1 (BeneficiarioC instance) throws SystemException {
        SQLExists sql = assocOperator029Range1Query(instance);
        return !new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator029
	@Override
    public SQLExists assocOperator029Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ROLE_NAME_ESTADOBENEFICIARIOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator029, Method: assocOperator029Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator030
	@Override
    public Boolean assocOperator030(BeneficiarioC instance) throws SystemException {
        try {
            // EXIST (EPSC)
            return assocOperator030Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator030, Method: assocOperator030";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator030
	@Override
    public Boolean assocOperator030Range1 (BeneficiarioC instance) throws SystemException {
        SQLExists sql = assocOperator030Range1Query(instance);
        return !new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator030
	@Override
    public SQLExists assocOperator030Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ROLE_NAME_EPSC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator030, Method: assocOperator030Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator031
	@Override
    public Boolean assocOperator031(BeneficiarioC instance) throws SystemException {
        try {
            // EXIST (CompanyiaMPC)
            return assocOperator031Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator031, Method: assocOperator031";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator031
	@Override
    public Boolean assocOperator031Range1 (BeneficiarioC instance) throws SystemException {
        SQLExists sql = assocOperator031Range1Query(instance);
        return !new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator031
	@Override
    public SQLExists assocOperator031Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ROLE_NAME_COMPANYIAMPC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator031, Method: assocOperator031Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator033
	@Override
    public Boolean assocOperator033(BeneficiarioC instance) throws SystemException {
        try {
            // EXIST (EstadoBeneficiarioC)
            return assocOperator033Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator033, Method: assocOperator033";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator033
	@Override
    public Boolean assocOperator033Range1 (BeneficiarioC instance) throws SystemException {
        SQLExists sql = assocOperator033Range1Query(instance);
        return !new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator033
	@Override
    public SQLExists assocOperator033Range1Query (BeneficiarioC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.ROLE_NAME_ESTADOBENEFICIARIOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: BeneficiarioC, Assoc.Operator: AssocOperator033, Method: assocOperator033Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
