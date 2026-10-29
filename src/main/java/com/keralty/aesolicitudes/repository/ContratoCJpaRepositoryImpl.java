package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.BeneficiarioCConstants;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.global.DireccionCConstants;
import com.keralty.aesolicitudes.global.DireccionConstants;
import com.keralty.aesolicitudes.global.DominioConstants;
import com.keralty.aesolicitudes.global.FamiliaCConstants;
import com.keralty.aesolicitudes.global.ObservacionesCConstants;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.global.PlanesConstants;
import com.keralty.aesolicitudes.global.ProductosConstants;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.global.TipoDireccionConstants;
import com.keralty.aesolicitudes.global.TipoIdentificacionConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.ObservacionesC;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.sqlutils.SQLExists;
import com.keralty.aesolicitudes.sqlutils.SQLGetOne;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLPopulation;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLWhereComparison;
import com.keralty.aesolicitudes.sqlutils.SQLWhereConjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandNull;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.aesolicitudes.sqlutils.TypedQueryBuilder;
import com.keralty.aesolicitudes.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;

public class ContratoCJpaRepositoryImpl extends AbstractRepository implements ContratoCJpaRepositoryCustom {

    @Inject
    public ContratoCJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<ContratoC> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<ContratoC> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<ContratoC> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<ContratoC> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, ContratoC.class);
    }

    @Override	
    public List<ContratoC> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<ContratoC> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
	@Override
    public Double assocOperator000(ContratoC instance) throws SystemException {
        try {
            // SUM (BeneficiariosC.drvValorCuotaAfiliacion)
            double result = 0.0;
            for(BeneficiarioC item : assocOperator000Range1(instance)){
                result += item.getBeneficiarioCdrvValorCuotaAfiliacion();
            }
            return result;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator000, Method: assocOperator000";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator000
	@Override
    public Collection<BeneficiarioC> assocOperator000Range1 (ContratoC instance) throws SystemException {

        SQLSelect sql = assocOperator000Range1Query(instance);
        return new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator000
	@Override
    public SQLPopulation assocOperator000Range1Query (ContratoC instance) throws SystemException {
        try {
            return new SQLPopulation(ContratoCConstants.CLASS_NAME, BeneficiarioCConstants.CLASS_NAME, instance.getOid(), ContratoCConstants.ROLE_NAME_BENEFICIARIOSC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator001
	@Override
    public Double assocOperator001(ContratoC instance) throws SystemException {
        try {
            // SUM (BeneficiariosC.drvValorInicialContrato) WHERE (BeneficiariosC.PersonaC.TipoIdentificacionC.NombreCorto = "MS")
            double result = 0.0;
            for(BeneficiarioC item : assocOperator001Range1(instance)){
                result += item.getBeneficiarioCdrvValorInicialContrato();
            }
            return result;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator001, Method: assocOperator001";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator001
	@Override
    public Collection<BeneficiarioC> assocOperator001Range1 (ContratoC instance) throws SystemException {

        SQLSelect sql = assocOperator001Range1Query(instance);
        return new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator001
	@Override
    public SQLPopulation assocOperator001Range1Query (ContratoC instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(ContratoCConstants.CLASS_NAME, BeneficiarioCConstants.CLASS_NAME, instance.getOid(), ContratoCConstants.ROLE_NAME_BENEFICIARIOSC);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // BeneficiariosC.PersonaC.TipoIdentificacionC.NombreCorto = "MS"
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ContratoCConstants.ROLE_NAME_BENEFICIARIOSC + "." + BeneficiarioCConstants.ROLE_NAME_PERSONAC + "." + PersonaCConstants.ROLE_NAME_TIPOIDENTIFICACIONC + "." + TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONNOMBRECORTO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral("MS", Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator002
	@Override
    public Double assocOperator002(ContratoC instance) throws SystemException {
        try {
            // SUM (BeneficiariosC.drvValorCuotaBruta)
            double result = 0.0;
            for(BeneficiarioC item : assocOperator002Range1(instance)){
                result += item.getBeneficiarioCdrvValorCuotaBruta();
            }
            return result;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator002, Method: assocOperator002";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator002
	@Override
    public Collection<BeneficiarioC> assocOperator002Range1 (ContratoC instance) throws SystemException {

        SQLSelect sql = assocOperator002Range1Query(instance);
        return new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator002
	@Override
    public SQLPopulation assocOperator002Range1Query (ContratoC instance) throws SystemException {
        try {
            return new SQLPopulation(ContratoCConstants.CLASS_NAME, BeneficiarioCConstants.CLASS_NAME, instance.getOid(), ContratoCConstants.ROLE_NAME_BENEFICIARIOSC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator003
	@Override
    public Boolean assocOperator003(ContratoC instance) throws SystemException {
        try {
            // EXIST (ProductoC.Dominios) WHERE (ProductoC.Dominios.PlanT = PlanC AND ProductoC.Dominios.MostrarPreexAnexos = true)
            return assocOperator003Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator003, Method: assocOperator003";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator003
	@Override
    public Boolean assocOperator003Range1 (ContratoC instance) throws SystemException {
        SQLExists sql = assocOperator003Range1Query(instance);
        return !new TypedQueryBuilder<ContratoC>(em, ContratoC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator003
	@Override
    public SQLExists assocOperator003Range1Query (ContratoC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(ContratoCConstants.CLASS_NAME, ContratoCConstants.ROLE_NAME_PRODUCTOC + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ProductoC.Dominios.PlanT = PlanC
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(ContratoCConstants.ROLE_NAME_PRODUCTOC + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(ContratoCConstants.ROLE_NAME_PLANC, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getPlanC().getOid(), ContratoCConstants.ROLE_NAME_PLANC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // ProductoC.Dominios.MostrarPreexAnexos = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(ContratoCConstants.ROLE_NAME_PRODUCTOC + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOMOSTRARPREEXANEXOS, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator004
	@Override
    public Boolean assocOperator004(ContratoC instance) throws SystemException {
        try {
            // EXIST (ProductoC.Dominios) WHERE (ProductoC.Dominios.PlanT = PlanC AND ProductoC.Dominios.MostrarPreexContrato = true)
            return assocOperator004Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator004, Method: assocOperator004";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator004
	@Override
    public Boolean assocOperator004Range1 (ContratoC instance) throws SystemException {
        SQLExists sql = assocOperator004Range1Query(instance);
        return !new TypedQueryBuilder<ContratoC>(em, ContratoC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator004
	@Override
    public SQLExists assocOperator004Range1Query (ContratoC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(ContratoCConstants.CLASS_NAME, ContratoCConstants.ROLE_NAME_PRODUCTOC + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ProductoC.Dominios.PlanT = PlanC
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(ContratoCConstants.ROLE_NAME_PRODUCTOC + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(ContratoCConstants.ROLE_NAME_PLANC, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getPlanC().getOid(), ContratoCConstants.ROLE_NAME_PLANC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // ProductoC.Dominios.MostrarPreexContrato = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(ContratoCConstants.ROLE_NAME_PRODUCTOC + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOMOSTRARPREEXCONTRATO, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator004, Method: assocOperator004Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator005
	@Override
    public Boolean assocOperator005(ContratoC instance) throws SystemException {
        try {
            // EXIST (FamiliasC) WHERE (FamiliasC.NumFamilia <> NULL)
            return assocOperator005Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator005, Method: assocOperator005";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator005
	@Override
    public Boolean assocOperator005Range1 (ContratoC instance) throws SystemException {
        SQLExists sql = assocOperator005Range1Query(instance);
        return !new TypedQueryBuilder<ContratoC>(em, ContratoC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator005
	@Override
    public SQLExists assocOperator005Range1Query (ContratoC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(ContratoCConstants.CLASS_NAME, ContratoCConstants.ROLE_NAME_FAMILIASC, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // FamiliasC.NumFamilia <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ContratoCConstants.ROLE_NAME_FAMILIASC + "." + FamiliaCConstants.ATTR_NAME_FAMILIACNUMFAMILIA, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator005, Method: assocOperator005Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator006
	@Override
    public String assocOperator006(ContratoC instance) throws SystemException {
        try {
            // GETONE (FamiliasC.NumFamilia) WHERE (FamiliasC.NumFamilia <> NULL)
            return assocOperator006Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator006, Method: assocOperator006";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator006
	@Override
    public String assocOperator006Range1 (ContratoC instance) throws SystemException {
        SQLGetOne sql = assocOperator006Range1Query(instance);
        List<String> results = new TypedQueryBuilder<String>(em, String.class).build(sql).execute();
        return !results.isEmpty() ? results.get(0) : null;
    }

    // Range Query 1 for AssocOperator AssocOperator006
	@Override
    public SQLGetOne assocOperator006Range1Query (ContratoC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLGetOne sql = new SQLGetOne(ContratoCConstants.CLASS_NAME, ContratoCConstants.ROLE_NAME_FAMILIASC + "." + FamiliaCConstants.ATTR_NAME_FAMILIACNUMFAMILIA, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // FamiliasC.NumFamilia <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ContratoCConstants.ROLE_NAME_FAMILIASC + "." + FamiliaCConstants.ATTR_NAME_FAMILIACNUMFAMILIA, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator006, Method: assocOperator006Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator007
	@Override
    public Double assocOperator007(ContratoC instance) throws SystemException {
        try {
            // SUM (BeneficiariosC.drvDescuentoComercial)
            double result = 0.0;
            for(BeneficiarioC item : assocOperator007Range1(instance)){
                result += item.getBeneficiarioCdrvDescuentoComercial();
            }
            return result;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator007, Method: assocOperator007";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator007
	@Override
    public Collection<BeneficiarioC> assocOperator007Range1 (ContratoC instance) throws SystemException {

        SQLSelect sql = assocOperator007Range1Query(instance);
        return new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator007
	@Override
    public SQLPopulation assocOperator007Range1Query (ContratoC instance) throws SystemException {
        try {
            return new SQLPopulation(ContratoCConstants.CLASS_NAME, BeneficiarioCConstants.CLASS_NAME, instance.getOid(), ContratoCConstants.ROLE_NAME_BENEFICIARIOSC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator007, Method: assocOperator007Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator008
	@Override
    public Double assocOperator008(ContratoC instance) throws SystemException {
        try {
            // SUM (BeneficiariosC.drvDescuentoFinanciero)
            double result = 0.0;
            for(BeneficiarioC item : assocOperator008Range1(instance)){
                result += item.getBeneficiarioCdrvDescuentoFinanciero();
            }
            return result;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator008, Method: assocOperator008";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator008
	@Override
    public Collection<BeneficiarioC> assocOperator008Range1 (ContratoC instance) throws SystemException {

        SQLSelect sql = assocOperator008Range1Query(instance);
        return new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator008
	@Override
    public SQLPopulation assocOperator008Range1Query (ContratoC instance) throws SystemException {
        try {
            return new SQLPopulation(ContratoCConstants.CLASS_NAME, BeneficiarioCConstants.CLASS_NAME, instance.getOid(), ContratoCConstants.ROLE_NAME_BENEFICIARIOSC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator008, Method: assocOperator008Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator011
	@Override
    public Boolean assocOperator011(ContratoC instance) throws SystemException {
        try {
            // EXIST (PeriodicidadC)
            return assocOperator011Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator011, Method: assocOperator011";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator011
	@Override
    public Boolean assocOperator011Range1 (ContratoC instance) throws SystemException {
        SQLExists sql = assocOperator011Range1Query(instance);
        return !new TypedQueryBuilder<ContratoC>(em, ContratoC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator011
	@Override
    public SQLExists assocOperator011Range1Query (ContratoC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(ContratoCConstants.CLASS_NAME, ContratoCConstants.ROLE_NAME_PERIODICIDADC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator011, Method: assocOperator011Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator012
	@Override
    public Boolean assocOperator012(ContratoC instance) throws SystemException {
        try {
            // EXIST (FormaPagoC)
            return assocOperator012Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator012, Method: assocOperator012";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator012
	@Override
    public Boolean assocOperator012Range1 (ContratoC instance) throws SystemException {
        SQLExists sql = assocOperator012Range1Query(instance);
        return !new TypedQueryBuilder<ContratoC>(em, ContratoC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator012
	@Override
    public SQLExists assocOperator012Range1Query (ContratoC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(ContratoCConstants.CLASS_NAME, ContratoCConstants.ROLE_NAME_FORMAPAGOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator012, Method: assocOperator012Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator013
	@Override
    public Boolean assocOperator013(ContratoC instance) throws SystemException {
        try {
            // EXIST (EstadoContratoC)
            return assocOperator013Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator013, Method: assocOperator013";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator013
	@Override
    public Boolean assocOperator013Range1 (ContratoC instance) throws SystemException {
        SQLExists sql = assocOperator013Range1Query(instance);
        return !new TypedQueryBuilder<ContratoC>(em, ContratoC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator013
	@Override
    public SQLExists assocOperator013Range1Query (ContratoC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(ContratoCConstants.CLASS_NAME, ContratoCConstants.ROLE_NAME_ESTADOCONTRATOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator013, Method: assocOperator013Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator014
	@Override
    public Boolean assocOperator014(ContratoC instance) throws SystemException {
        try {
            // EXIST (EstadoContratoC)
            return assocOperator014Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator014, Method: assocOperator014";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator014
	@Override
    public Boolean assocOperator014Range1 (ContratoC instance) throws SystemException {
        SQLExists sql = assocOperator014Range1Query(instance);
        return !new TypedQueryBuilder<ContratoC>(em, ContratoC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator014
	@Override
    public SQLExists assocOperator014Range1Query (ContratoC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(ContratoCConstants.CLASS_NAME, ContratoCConstants.ROLE_NAME_ESTADOCONTRATOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator014, Method: assocOperator014Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator016
	@Override
    public Boolean assocOperator016(ContratoC instance) throws SystemException {
        try {
            // EXIST (EstadoContratoC)
            return assocOperator016Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator016, Method: assocOperator016";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator016
	@Override
    public Boolean assocOperator016Range1 (ContratoC instance) throws SystemException {
        SQLExists sql = assocOperator016Range1Query(instance);
        return !new TypedQueryBuilder<ContratoC>(em, ContratoC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator016
	@Override
    public SQLExists assocOperator016Range1Query (ContratoC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(ContratoCConstants.CLASS_NAME, ContratoCConstants.ROLE_NAME_ESTADOCONTRATOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator016, Method: assocOperator016Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator018
	@Override
    public Collection<DireccionC> assocOperator018(ContratoC instance, Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAE) throws SystemException {
        try {
            // FOR ALL DireccionesC WHERE (DireccionesC.TipoDireccionC = pSolicitudAE.Direccion.TipoDireccion) DO DireccionesC.TMODIFICAR(DireccionesC, pSolicitudAE.Direccion.DireccionCompleta, pSolicitudAE.Direccion.Departamento, pSolicitudAE.Direccion.Municipio, pSolicitudAE.Direccion.Pais, DireccionesC.TipoDireccionC, DireccionesC.Localidad)
        return assocOperator018Range1(instance, contratoCTCREAROMODDIRDEAEpSolicitudAE);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator018, Method: assocOperator018";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator018
	@Override
    public Collection<DireccionC> assocOperator018Range1 (ContratoC instance, Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAE) throws SystemException {

        SQLSelect sql = assocOperator018Range1Query(instance, contratoCTCREAROMODDIRDEAEpSolicitudAE);
        return new TypedQueryBuilder<DireccionC>(em, DireccionC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator018
	@Override
    public SQLPopulation assocOperator018Range1Query (ContratoC instance, Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAE) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(ContratoCConstants.CLASS_NAME, DireccionCConstants.CLASS_NAME, instance.getOid(), ContratoCConstants.ROLE_NAME_DIRECCIONESC);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // DireccionesC.TipoDireccionC = pSolicitudAE.Direccion.TipoDireccion
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(ContratoCConstants.ROLE_NAME_DIRECCIONESC + "." + DireccionCConstants.ROLE_NAME_TIPODIRECCIONC, TipoDireccionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (contratoCTCREAROMODDIRDEAEpSolicitudAE.isNull() || contratoCTCREAROMODDIRDEAEpSolicitudAE.getDireccion().getTipoDireccion().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(ContratoCConstants.ARG_NAME_TCREAROMODDIRDEAE_CONTRATOCTCREAROMODDIRDEAEPSOLICITUDAE + "." + SolicitudConstants.ROLE_NAME_DIRECCION + "." + DireccionConstants.ROLE_NAME_TIPODIRECCION, SolicitudConstants.CLASS_NAME, TipoDireccionConstants.CLASS_NAME, contratoCTCREAROMODDIRDEAEpSolicitudAE.getOid(), ContratoCConstants.ARG_NAME_TCREAROMODDIRDEAE_CONTRATOCTCREAROMODDIRDEAEPSOLICITUDAE);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator018, Method: assocOperator018Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator020
	@Override
    public Boolean assocOperator020(Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAE) throws SystemException {
        try {
            // EXIST (pSolicitudAE.Direccion)
            return assocOperator020Range1(contratoCTCREAROMODDIRDEAEpSolicitudAE);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator020, Method: assocOperator020";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator020
	@Override
    public Boolean assocOperator020Range1 (Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAE) throws SystemException {
        SQLExists sql = assocOperator020Range1Query(contratoCTCREAROMODDIRDEAEpSolicitudAE, null);
        return !new TypedQueryBuilder<ContratoC>(em, ContratoC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator020
	@Override
    public SQLExists assocOperator020Range1Query (Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAE, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, ContratoCConstants.CLASS_NAME, ContratoCConstants.ARG_NAME_TCREAROMODDIRDEAE_CONTRATOCTCREAROMODDIRDEAEPSOLICITUDAE + "." + SolicitudConstants.ROLE_NAME_DIRECCION, SolicitudConstants.CLASS_NAME, contratoCTCREAROMODDIRDEAEpSolicitudAE.getOid(), ContratoCConstants.ARG_NAME_TCREAROMODDIRDEAE_CONTRATOCTCREAROMODDIRDEAEPSOLICITUDAE);
            } else {
                sql = new SQLExists(ContratoCConstants.CLASS_NAME, ContratoCConstants.ARG_NAME_TCREAROMODDIRDEAE_CONTRATOCTCREAROMODDIRDEAEPSOLICITUDAE + "." + SolicitudConstants.ROLE_NAME_DIRECCION, SolicitudConstants.CLASS_NAME, contratoCTCREAROMODDIRDEAEpSolicitudAE.getOid(), ContratoCConstants.ARG_NAME_TCREAROMODDIRDEAE_CONTRATOCTCREAROMODDIRDEAEPSOLICITUDAE);
            }
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator020, Method: assocOperator020Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator021
	@Override
    public Boolean assocOperator021(ContratoC instance, Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAE) throws SystemException {
        try {
            // EXIST (DireccionesC) WHERE (DireccionesC.TipoDireccionC = pSolicitudAE.Direccion.TipoDireccion)
            return assocOperator021Range1(instance, contratoCTCREAROMODDIRDEAEpSolicitudAE);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator021, Method: assocOperator021";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator021
	@Override
    public Boolean assocOperator021Range1 (ContratoC instance, Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAE) throws SystemException {
        SQLExists sql = assocOperator021Range1Query(instance, contratoCTCREAROMODDIRDEAEpSolicitudAE);
        return !new TypedQueryBuilder<ContratoC>(em, ContratoC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator021
	@Override
    public SQLExists assocOperator021Range1Query (ContratoC instance, Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAE) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(ContratoCConstants.CLASS_NAME, ContratoCConstants.ROLE_NAME_DIRECCIONESC, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // DireccionesC.TipoDireccionC = pSolicitudAE.Direccion.TipoDireccion
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(ContratoCConstants.ROLE_NAME_DIRECCIONESC + "." + DireccionCConstants.ROLE_NAME_TIPODIRECCIONC, TipoDireccionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (contratoCTCREAROMODDIRDEAEpSolicitudAE.isNull() || contratoCTCREAROMODDIRDEAEpSolicitudAE.getDireccion().getTipoDireccion().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(ContratoCConstants.ARG_NAME_TCREAROMODDIRDEAE_CONTRATOCTCREAROMODDIRDEAEPSOLICITUDAE + "." + SolicitudConstants.ROLE_NAME_DIRECCION + "." + DireccionConstants.ROLE_NAME_TIPODIRECCION, SolicitudConstants.CLASS_NAME, TipoDireccionConstants.CLASS_NAME, contratoCTCREAROMODDIRDEAEpSolicitudAE.getOid(), ContratoCConstants.ARG_NAME_TCREAROMODDIRDEAE_CONTRATOCTCREAROMODDIRDEAEPSOLICITUDAE);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator021, Method: assocOperator021Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator022
	@Override
    public Collection<FamiliaC> assocOperator022(ContratoC instance) throws SystemException {
        try {
            // FOR ALL FamiliasC DO FamiliasC.TELIMINAR(FamiliasC)
        return assocOperator022Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator022, Method: assocOperator022";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator022
	@Override
    public Collection<FamiliaC> assocOperator022Range1 (ContratoC instance) throws SystemException {

        SQLSelect sql = assocOperator022Range1Query(instance);
        return new TypedQueryBuilder<FamiliaC>(em, FamiliaC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator022
	@Override
    public SQLPopulation assocOperator022Range1Query (ContratoC instance) throws SystemException {
        try {
            return new SQLPopulation(ContratoCConstants.CLASS_NAME, FamiliaCConstants.CLASS_NAME, instance.getOid(), ContratoCConstants.ROLE_NAME_FAMILIASC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator022, Method: assocOperator022Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator024
	@Override
    public Collection<ObservacionesC> assocOperator024(ContratoC instance) throws SystemException {
        try {
            // FOR ALL ObservacionesC DO ObservacionesC.eliminar(ObservacionesC)
        return assocOperator024Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator024, Method: assocOperator024";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator024
	@Override
    public Collection<ObservacionesC> assocOperator024Range1 (ContratoC instance) throws SystemException {

        SQLSelect sql = assocOperator024Range1Query(instance);
        return new TypedQueryBuilder<ObservacionesC>(em, ObservacionesC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator024
	@Override
    public SQLPopulation assocOperator024Range1Query (ContratoC instance) throws SystemException {
        try {
            return new SQLPopulation(ContratoCConstants.CLASS_NAME, ObservacionesCConstants.CLASS_NAME, instance.getOid(), ContratoCConstants.ROLE_NAME_OBSERVACIONESC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator024, Method: assocOperator024Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator025
	@Override
    public Collection<DireccionC> assocOperator025(ContratoC instance) throws SystemException {
        try {
            // FOR ALL DireccionesC DO DireccionesC.TELIMINAR(DireccionesC)
        return assocOperator025Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator025, Method: assocOperator025";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator025
	@Override
    public Collection<DireccionC> assocOperator025Range1 (ContratoC instance) throws SystemException {

        SQLSelect sql = assocOperator025Range1Query(instance);
        return new TypedQueryBuilder<DireccionC>(em, DireccionC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator025
	@Override
    public SQLPopulation assocOperator025Range1Query (ContratoC instance) throws SystemException {
        try {
            return new SQLPopulation(ContratoCConstants.CLASS_NAME, DireccionCConstants.CLASS_NAME, instance.getOid(), ContratoCConstants.ROLE_NAME_DIRECCIONESC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator025, Method: assocOperator025Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator026
	@Override
    public Boolean assocOperator026(ContratoC instance) throws SystemException {
        try {
            // EXIST (PersonaCContratante)
            return assocOperator026Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator026, Method: assocOperator026";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator026
	@Override
    public Boolean assocOperator026Range1 (ContratoC instance) throws SystemException {
        SQLExists sql = assocOperator026Range1Query(instance);
        return !new TypedQueryBuilder<ContratoC>(em, ContratoC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator026
	@Override
    public SQLExists assocOperator026Range1Query (ContratoC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(ContratoCConstants.CLASS_NAME, ContratoCConstants.ROLE_NAME_PERSONACCONTRATANTE, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator026, Method: assocOperator026Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator028
	@Override
    public Collection<PersonaC> assocOperator028(ContratoC instance) throws SystemException {
        try {
            // FOR ALL PersonaCContratante DO PersonaCContratante.TMODIFICAR(PersonaCContratante, ptNombreCompletoContratante, ptNumIdentificacionContratante, ptTipoIdContratante)
        return assocOperator028Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator028, Method: assocOperator028";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator028
	@Override
    public Collection<PersonaC> assocOperator028Range1 (ContratoC instance) throws SystemException {

        SQLSelect sql = assocOperator028Range1Query(instance);
        return new TypedQueryBuilder<PersonaC>(em, PersonaC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator028
	@Override
    public SQLPopulation assocOperator028Range1Query (ContratoC instance) throws SystemException {
        try {
            return new SQLPopulation(ContratoCConstants.CLASS_NAME, PersonaCConstants.CLASS_NAME, instance.getOid(), ContratoCConstants.ROLE_NAME_PERSONACCONTRATANTE);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator028, Method: assocOperator028Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator032
	@Override
    public Collection<FamiliaC> assocOperator032(ContratoC instance) throws SystemException {
        try {
            // FOR ALL FamiliasC DO FamiliasC.TPOSTNOTICREAR(FamiliasC, ptNumFamilia, ptpeFechaFinVigencia, ptDireccionCompletaTitular, ptMunicipioDireccionTitular, ptTipoIdTitular, ptNumIdentificacionTitular, ptNombreCompletoTitular)
        return assocOperator032Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator032, Method: assocOperator032";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator032
	@Override
    public Collection<FamiliaC> assocOperator032Range1 (ContratoC instance) throws SystemException {

        SQLSelect sql = assocOperator032Range1Query(instance);
        return new TypedQueryBuilder<FamiliaC>(em, FamiliaC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator032
	@Override
    public SQLPopulation assocOperator032Range1Query (ContratoC instance) throws SystemException {
        try {
            return new SQLPopulation(ContratoCConstants.CLASS_NAME, FamiliaCConstants.CLASS_NAME, instance.getOid(), ContratoCConstants.ROLE_NAME_FAMILIASC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator032, Method: assocOperator032Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator033
	@Override
    public Boolean assocOperator033(ContratoC instance) throws SystemException {
        try {
            // EXIST (PersonaCContratante)
            return assocOperator033Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator033, Method: assocOperator033";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator033
	@Override
    public Boolean assocOperator033Range1 (ContratoC instance) throws SystemException {
        SQLExists sql = assocOperator033Range1Query(instance);
        return !new TypedQueryBuilder<ContratoC>(em, ContratoC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator033
	@Override
    public SQLExists assocOperator033Range1Query (ContratoC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(ContratoCConstants.CLASS_NAME, ContratoCConstants.ROLE_NAME_PERSONACCONTRATANTE, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator033, Method: assocOperator033Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator034
	@Override
    public Boolean assocOperator034(ContratoC instance) throws SystemException {
        try {
            // EXIST (MunicipioC)
            return assocOperator034Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator034, Method: assocOperator034";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator034
	@Override
    public Boolean assocOperator034Range1 (ContratoC instance) throws SystemException {
        SQLExists sql = assocOperator034Range1Query(instance);
        return !new TypedQueryBuilder<ContratoC>(em, ContratoC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator034
	@Override
    public SQLExists assocOperator034Range1Query (ContratoC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(ContratoCConstants.CLASS_NAME, ContratoCConstants.ROLE_NAME_MUNICIPIOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator034, Method: assocOperator034Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator035
	@Override
    public Boolean assocOperator035(ContratoC instance) throws SystemException {
        try {
            // EXIST (AsesorC)
            return assocOperator035Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator035, Method: assocOperator035";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator035
	@Override
    public Boolean assocOperator035Range1 (ContratoC instance) throws SystemException {
        SQLExists sql = assocOperator035Range1Query(instance);
        return !new TypedQueryBuilder<ContratoC>(em, ContratoC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator035
	@Override
    public SQLExists assocOperator035Range1Query (ContratoC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(ContratoCConstants.CLASS_NAME, ContratoCConstants.ROLE_NAME_ASESORC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator035, Method: assocOperator035Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator036
	@Override
    public Boolean assocOperator036(ContratoC instance) throws SystemException {
        try {
            // EXIST (PeriodicidadC)
            return assocOperator036Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator036, Method: assocOperator036";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator036
	@Override
    public Boolean assocOperator036Range1 (ContratoC instance) throws SystemException {
        SQLExists sql = assocOperator036Range1Query(instance);
        return !new TypedQueryBuilder<ContratoC>(em, ContratoC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator036
	@Override
    public SQLExists assocOperator036Range1Query (ContratoC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(ContratoCConstants.CLASS_NAME, ContratoCConstants.ROLE_NAME_PERIODICIDADC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: ContratoC, Assoc.Operator: AssocOperator036, Method: assocOperator036Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
