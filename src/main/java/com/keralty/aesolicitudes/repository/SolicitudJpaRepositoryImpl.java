package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.AesolicitudesConstants;
import com.keralty.aesolicitudes.global.AfiliacionesConstants;
import com.keralty.aesolicitudes.global.AnexoMatConstants;
import com.keralty.aesolicitudes.global.AnexoNeoConstants;
import com.keralty.aesolicitudes.global.AsesorConstants;
import com.keralty.aesolicitudes.global.BeneficiarioCConstants;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.ContratanteConstants;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.global.CuestionarioPConstants;
import com.keralty.aesolicitudes.global.DetalleTarifaConstants;
import com.keralty.aesolicitudes.global.DireccionConstants;
import com.keralty.aesolicitudes.global.DocumentoGConstants;
import com.keralty.aesolicitudes.global.DominioConstants;
import com.keralty.aesolicitudes.global.EstadoBeneficiarioConstants;
import com.keralty.aesolicitudes.global.EstadoPersonaConstants;
import com.keralty.aesolicitudes.global.FuncionarioConstants;
import com.keralty.aesolicitudes.global.ParentescoConstants;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.global.PersonaConstants;
import com.keralty.aesolicitudes.global.PlanesConstants;
import com.keralty.aesolicitudes.global.PlantillaEmailConstants;
import com.keralty.aesolicitudes.global.PlantillaReporteConstants;
import com.keralty.aesolicitudes.global.PreexistenciaConstants;
import com.keralty.aesolicitudes.global.ProductosConstants;
import com.keralty.aesolicitudes.global.ReportesDominioConstants;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.global.STDFunctions;
import com.keralty.aesolicitudes.global.TarifaConstants;
import com.keralty.aesolicitudes.global.TipoDireccionConstants;
import com.keralty.aesolicitudes.global.TipoIdentificacionConstants;
import com.keralty.aesolicitudes.global.TipoIVAConstants;
import com.keralty.aesolicitudes.global.TitularConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.global.UsuarioConstants;
import com.keralty.aesolicitudes.global.UsuarioRegConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.Direccion;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.PlantillaEmail;
import com.keralty.aesolicitudes.persistence.ReportesDominio;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.persistence.Usuario;
import com.keralty.aesolicitudes.persistence.UsuarioReg;
import com.keralty.aesolicitudes.sqlutils.SQLCount;
import com.keralty.aesolicitudes.sqlutils.SQLExists;
import com.keralty.aesolicitudes.sqlutils.SQLForAllCondition;
import com.keralty.aesolicitudes.sqlutils.SQLGetOne;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLPopulation;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLSum;
import com.keralty.aesolicitudes.sqlutils.SQLWhereComparison;
import com.keralty.aesolicitudes.sqlutils.SQLWhereConjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereDisjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereNegation;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandNull;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandSubQuery;
import com.keralty.aesolicitudes.sqlutils.TypedQueryBuilder;
import com.keralty.aesolicitudes.utils.Agent;
import com.keralty.aesolicitudes.utils.Utilities;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SolicitudJpaRepositoryImpl extends AbstractRepository implements SolicitudJpaRepositoryCustom {

    @Inject
    public SolicitudJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<Solicitud> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Solicitud> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Solicitud> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Solicitud> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Solicitud.class);
    }

    @Override	
    public List<Solicitud> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<Solicitud> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
	@Override
    public Boolean assocOperator000() throws SystemException {
        try {
            // EXIST (UsrAfiliacion) WHERE (UsrAfiliacion = agent)
            return assocOperator000Range1();
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator000, Method: assocOperator000";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator000
	@Override
    public Boolean assocOperator000Range1 () throws SystemException {
        SQLExists sql = assocOperator000Range1Query(null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator000
	@Override
    public SQLExists assocOperator000Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USRAFILIACION);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsrAfiliacion = agent
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USRAFILIACION, FuncionarioConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.AGENTKEYWORD, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, agent.getAgentInstance().getOid(), Constants.AGENTKEYWORD);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator001
	@Override
    public Long assocOperator001() throws SystemException {
        try {
            // COUNT (Aesolicitudes.PlanT.Afiliaciones) WHERE (Aesolicitudes.PlanT.Afiliaciones = agent)
            return assocOperator001Range1();
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator001, Method: assocOperator001";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator001
	@Override
    public Long assocOperator001Range1 () throws SystemException {
        SQLCount sql = assocOperator001Range1Query(null);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 0 for AssocOperator AssocOperator001
	@Override
    public SQLCount assocOperator001Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_AFILIACIONES);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.PlanT.Afiliaciones = agent
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_AFILIACIONES, AfiliacionesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.AGENTKEYWORD, AfiliacionesConstants.CLASS_NAME, AfiliacionesConstants.CLASS_NAME, agent.getAgentInstance().getOid(), Constants.AGENTKEYWORD);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator002
	@Override
    public Boolean assocOperator002(Solicitud instance) throws SystemException {
        try {
            // EXIST (Aesolicitudes.ProductoT.Dominios) WHERE (Aesolicitudes.ProductoT.Dominios.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.ReqCuesMed = true)
            return assocOperator002Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator002, Method: assocOperator002";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator002
	@Override
    public Boolean assocOperator002Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator002Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator002
	@Override
    public SQLExists assocOperator002Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.ReqCuesMed = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOREQCUESMED, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator003
	@Override
    public Boolean assocOperator003(Solicitud instance) throws SystemException {
        try {
            // EXIST (Aesolicitudes.ProductoT.Dominios) WHERE (Aesolicitudes.ProductoT.Dominios.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.ReqCuesMed = true AND (Aesolicitudes.ProductoT.Dominios.NoCuesMedTras = false))
            return assocOperator003Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator003, Method: assocOperator003";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator003
	@Override
    public Boolean assocOperator003Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator003Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator003
	@Override
    public SQLExists assocOperator003Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.ReqCuesMed = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOREQCUESMED, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);


            // (Aesolicitudes.ProductoT.Dominios.NoCuesMedTras = false)
                    // '=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIONOCUESMEDTRAS, Constants.Type.BOOL.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator004
	@Override
    public Boolean assocOperator004(Solicitud instance) throws SystemException {
        try {
            // EXIST (ContratantePersona)
            return assocOperator004Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator004, Method: assocOperator004";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator004
	@Override
    public Boolean assocOperator004Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator004Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator004
	@Override
    public SQLExists assocOperator004Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator004, Method: assocOperator004Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator005
	@Override
    public Boolean assocOperator005(Solicitud instance) throws SystemException {
        try {
            // EXIST (Contratante)
            return assocOperator005Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator005, Method: assocOperator005";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator005
	@Override
    public Boolean assocOperator005Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator005Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator005
	@Override
    public SQLExists assocOperator005Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATANTE, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator005, Method: assocOperator005Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator006
	@Override
    public Boolean assocOperator006(Solicitud instance) throws SystemException {
        try {
            // EXIST (Periodicidad)
            return assocOperator006Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator006, Method: assocOperator006";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator006
	@Override
    public Boolean assocOperator006Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator006Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator006
	@Override
    public SQLExists assocOperator006Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_PERIODICIDAD, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator006, Method: assocOperator006Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator007
	@Override
    public Boolean assocOperator007(Solicitud instance) throws SystemException {
        try {
            // EXIST (Direccion.Municipio)
            return assocOperator007Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator007, Method: assocOperator007";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator007
	@Override
    public Boolean assocOperator007Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator007Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator007
	@Override
    public SQLExists assocOperator007Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_DIRECCION + "." + DireccionConstants.ROLE_NAME_MUNICIPIO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator007, Method: assocOperator007Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator008
	@Override
    public Double assocOperator008(Solicitud instance) throws SystemException {
        try {
            // SUM (Aesolicitudes.PlanT.TiposIVA.Porcentaje) WHERE (Aesolicitudes.PlanT.TiposIVA.FechaInicio <= drvFechaPorcenIVA AND Aesolicitudes.PlanT.TiposIVA.FechaFin >= drvFechaPorcenIVA)
            return assocOperator008Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator008, Method: assocOperator008";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator008
	@Override
    public Double assocOperator008Range1 (Solicitud instance) throws SystemException {
        SQLSum sql = assocOperator008Range1Query(instance);
        return new TypedQueryBuilder<Double>(em, Double.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator008
	@Override
    public SQLSum assocOperator008Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLSum sql = new SQLSum(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_TIPOSIVA + "." + TipoIVAConstants.ATTR_NAME_TIPOIVAPORCENTAJE, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.PlanT.TiposIVA.FechaInicio <= drvFechaPorcenIVA
                    // '<=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_TIPOSIVA + "." + TipoIVAConstants.ATTR_NAME_TIPOIVAFECHAINICIO, Constants.Type.DATE.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(instance.getSolicituddrvFechaPorcenIVA(), Constants.Type.DATE.getTypeName()));
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.PlanT.TiposIVA.FechaFin >= drvFechaPorcenIVA
                    // '>=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator(">=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_TIPOSIVA + "." + TipoIVAConstants.ATTR_NAME_TIPOIVAFECHAFIN, Constants.Type.DATE.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(instance.getSolicituddrvFechaPorcenIVA(), Constants.Type.DATE.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator008, Method: assocOperator008Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator009
	@Override
    public Boolean assocOperator009(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios(Usuarios.drvCuesMedOK = true)
            for(Usuario item : assocOperator009Range1(instance)){
                // Usuarios.drvCuesMedOK = true
                boolean conditionsMet = item.getUsuariodrvCuesMedOK().equals(true);
                if (!conditionsMet) return false;
            }
            return true;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator009, Method: assocOperator009";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator009
	@Override
    public Collection<Usuario> assocOperator009Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator009Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator009
	@Override
    public SQLPopulation assocOperator009Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator009, Method: assocOperator009Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator010
	@Override
    public Boolean assocOperator010(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona)
            return assocOperator010Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator010, Method: assocOperator010";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator010
	@Override
    public Boolean assocOperator010Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator010Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator010
	@Override
    public SQLExists assocOperator010Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator010, Method: assocOperator010Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator011
	@Override
    public Boolean assocOperator011(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios.Preexistencias)
            return assocOperator011Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator011, Method: assocOperator011";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator011
	@Override
    public Boolean assocOperator011Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator011Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator011
	@Override
    public SQLExists assocOperator011Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PREEXISTENCIAS, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator011, Method: assocOperator011Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator012
	@Override
    public Boolean assocOperator012(Solicitud instance) throws SystemException {
        try {
            // EXIST (SegundaFirma)
            return assocOperator012Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator012, Method: assocOperator012";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator012
	@Override
    public Boolean assocOperator012Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator012Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator012
	@Override
    public SQLExists assocOperator012Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_SEGUNDAFIRMA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator012, Method: assocOperator012Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator013
	@Override
    public Boolean assocOperator013(Solicitud instance) throws SystemException {
        try {
            // EXIST (GrupoAsociado)
            return assocOperator013Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator013, Method: assocOperator013";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator013
	@Override
    public Boolean assocOperator013Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator013Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator013
	@Override
    public SQLExists assocOperator013Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_GRUPOASOCIADO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator013, Method: assocOperator013Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator014
	@Override
    public Boolean assocOperator014(Solicitud instance) throws SystemException {
        try {
            // EXIST (Aesolicitudes.ProductoT.Dominios.ReportesDominio) WHERE (Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 1 AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici)
            for(ReportesDominio item : assocOperator014Range1(instance)){
                // Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAesolicitudes().getAesolicitudesFesolici()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator014, Method: assocOperator014";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator014
	@Override
    public Collection<ReportesDominio> assocOperator014Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator014Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator014
	@Override
    public SQLPopulation assocOperator014Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 1
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison2);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().getAesolicitudesFesolici()!= null){
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(instance.getAesolicitudes().getAesolicitudesFesolici(), Constants.Type.DATE.getTypeName()));
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator014, Method: assocOperator014Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator015
	@Override
    public Boolean assocOperator015(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.EstadoBeneficiario.EsActivo = true)
            return assocOperator015Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator015, Method: assocOperator015";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator015
	@Override
    public Boolean assocOperator015Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator015Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator015
	@Override
    public SQLExists assocOperator015Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator015, Method: assocOperator015Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator016
	@Override
    public Boolean assocOperator016(Solicitud instance) throws SystemException {
        try {
            // EXIST (Aesolicitudes.ProductoT.Dominios.ReportesDominio) WHERE (Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 3 AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici)
            for(ReportesDominio item : assocOperator016Range1(instance)){
                // Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAesolicitudes().getAesolicitudesFesolici()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator016, Method: assocOperator016";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator016
	@Override
    public Collection<ReportesDominio> assocOperator016Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator016Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator016
	@Override
    public SQLPopulation assocOperator016Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 3
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(3), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison2);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().getAesolicitudesFesolici()!= null){
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(instance.getAesolicitudes().getAesolicitudesFesolici(), Constants.Type.DATE.getTypeName()));
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator016, Method: assocOperator016Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator017
	@Override
    public Boolean assocOperator017(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios.Preexistencias) WHERE (Usuarios.Preexistencias.Usuario.EstadoBeneficiario.EsActivo = true)
            return assocOperator017Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator017, Method: assocOperator017";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator017
	@Override
    public Boolean assocOperator017Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator017Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator017
	@Override
    public SQLExists assocOperator017Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PREEXISTENCIAS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Preexistencias.Usuario.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PREEXISTENCIAS + "." + PreexistenciaConstants.ROLE_NAME_USUARIO + "." + UsuarioConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator017, Method: assocOperator017Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator018
	@Override
    public Boolean assocOperator018(Solicitud instance) throws SystemException {
        try {
            // EXIST (Aesolicitudes.ProductoT.Dominios.ReportesDominio) WHERE (Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 6 AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici)
            for(ReportesDominio item : assocOperator018Range1(instance)){
                // Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAesolicitudes().getAesolicitudesFesolici()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator018, Method: assocOperator018";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator018
	@Override
    public Collection<ReportesDominio> assocOperator018Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator018Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator018
	@Override
    public SQLPopulation assocOperator018Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 6
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(6), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison2);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().getAesolicitudesFesolici()!= null){
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(instance.getAesolicitudes().getAesolicitudesFesolici(), Constants.Type.DATE.getTypeName()));
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator018, Method: assocOperator018Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator019
	@Override
    public Boolean assocOperator019(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.BebeGestante = true AND Usuarios.EstadoBeneficiario.EsActivo = true)
            return assocOperator019Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator019, Method: assocOperator019";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator019
	@Override
    public Boolean assocOperator019Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator019Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator019
	@Override
    public SQLExists assocOperator019Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.BebeGestante = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIOBEBEGESTANTE, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);


            // Usuarios.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator019, Method: assocOperator019Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator020
	@Override
    public Boolean assocOperator020(Solicitud instance) throws SystemException {
        try {
            // EXIST (Aesolicitudes.ProductoT.Dominios.ReportesDominio) WHERE (Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 8 AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici)
            for(ReportesDominio item : assocOperator020Range1(instance)){
                // Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAesolicitudes().getAesolicitudesFesolici()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator020, Method: assocOperator020";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator020
	@Override
    public Collection<ReportesDominio> assocOperator020Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator020Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator020
	@Override
    public SQLPopulation assocOperator020Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 8
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(8), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison2);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().getAesolicitudesFesolici()!= null){
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(instance.getAesolicitudes().getAesolicitudesFesolici(), Constants.Type.DATE.getTypeName()));
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator020, Method: assocOperator020Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator021
	@Override
    public Boolean assocOperator021(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios.AnexoMat) WHERE (Usuarios.AnexoMat.Usuario.EstadoBeneficiario.EsActivo = true)
            return assocOperator021Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator021, Method: assocOperator021";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator021
	@Override
    public Boolean assocOperator021Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator021Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator021
	@Override
    public SQLExists assocOperator021Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_ANEXOMAT, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.AnexoMat.Usuario.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_ANEXOMAT + "." + AnexoMatConstants.ROLE_NAME_USUARIO + "." + UsuarioConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator021, Method: assocOperator021Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator022
	@Override
    public Boolean assocOperator022(Solicitud instance) throws SystemException {
        try {
            // EXIST (Aesolicitudes.ProductoT.Dominios.ReportesDominio) WHERE (Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 10 AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici)
            for(ReportesDominio item : assocOperator022Range1(instance)){
                // Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAesolicitudes().getAesolicitudesFesolici()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator022, Method: assocOperator022";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator022
	@Override
    public Collection<ReportesDominio> assocOperator022Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator022Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator022
	@Override
    public SQLPopulation assocOperator022Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 10
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(10), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison2);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().getAesolicitudesFesolici()!= null){
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(instance.getAesolicitudes().getAesolicitudesFesolici(), Constants.Type.DATE.getTypeName()));
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator022, Method: assocOperator022Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator023
	@Override
    public Boolean assocOperator023(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios.CuestionarioP) WHERE (Usuarios.CuestionarioP.YaDiligenciado = true)
            return assocOperator023Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator023, Method: assocOperator023";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator023
	@Override
    public Boolean assocOperator023Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator023Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator023
	@Override
    public SQLExists assocOperator023Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_CUESTIONARIOP, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.CuestionarioP.YaDiligenciado = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_CUESTIONARIOP + "." + CuestionarioPConstants.ATTR_NAME_CUESTIONARIOPYADILIGENCIADO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator023, Method: assocOperator023Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator024
	@Override
    public Boolean assocOperator024(Solicitud instance) throws SystemException {
        try {
            // EXIST (Aesolicitudes.ProductoT.Dominios.ReportesDominio) WHERE (Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 4 AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici)
            for(ReportesDominio item : assocOperator024Range1(instance)){
                // Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAesolicitudes().getAesolicitudesFesolici()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator024, Method: assocOperator024";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator024
	@Override
    public Collection<ReportesDominio> assocOperator024Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator024Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator024
	@Override
    public SQLPopulation assocOperator024Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 4
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(4), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison2);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().getAesolicitudesFesolici()!= null){
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(instance.getAesolicitudes().getAesolicitudesFesolici(), Constants.Type.DATE.getTypeName()));
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator024, Method: assocOperator024Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator025
	@Override
    public Boolean assocOperator025(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.EstadoMedico = 4 AND Usuarios.EstadoBeneficiario.EsActivo = true)
            return assocOperator025Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator025, Method: assocOperator025";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator025
	@Override
    public Boolean assocOperator025Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator025Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator025
	@Override
    public SQLExists assocOperator025Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.EstadoMedico = 4
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIOESTADOMEDICO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(4), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);


            // Usuarios.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator025, Method: assocOperator025Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator026
	@Override
    public Double assocOperator026(Solicitud instance) throws SystemException {
        try {
            // SUM (Usuarios.drvTotalAnexos)
            double result = 0.0;
            for(Usuario item : assocOperator026Range1(instance)){
                result += item.getUsuariodrvTotalAnexos();
            }
            return result;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator026, Method: assocOperator026";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator026
	@Override
    public Collection<Usuario> assocOperator026Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator026Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator026
	@Override
    public SQLPopulation assocOperator026Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator026, Method: assocOperator026Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator027
	@Override
    public Boolean assocOperator027(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.drvTieneEPSSanitas = true)
            for(Usuario item : assocOperator027Range1(instance)){
                // Usuarios.drvTieneEPSSanitas = true
                if(item.getUsuariodrvTieneEPSSanitas().equals(true))
                    return true;
            }
            return false;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator027, Method: assocOperator027";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator027
	@Override
    public Collection<Usuario> assocOperator027Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator027Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator027
	@Override
    public SQLPopulation assocOperator027Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator027, Method: assocOperator027Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator028
	@Override
    public Long assocOperator028(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.Parentesco.EsTitular = true AND Usuarios.drvEstaActivo = true)
            long count = 0L;
            for(Usuario item : assocOperator028Range1(instance)){
                // Usuarios.drvEstaActivo = true
                if(item.getUsuariodrvEstaActivo().equals(true))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator028, Method: assocOperator028";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator028
	@Override
    public Collection<Usuario> assocOperator028Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator028Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator028
	@Override
    public SQLPopulation assocOperator028Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator028, Method: assocOperator028Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator029
	@Override
    public Long assocOperator029(Solicitud instance) throws SystemException {
        try {
            // COUNT (UsuariosRegistrados) WHERE (UsuariosRegistrados.Parentesco.EsTitular = true AND UsuariosRegistrados.EstadoBeneficiario.EsActivo = true)
            return assocOperator029Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator029, Method: assocOperator029";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator029
	@Override
    public Long assocOperator029Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator029Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator029
	@Override
    public SQLCount assocOperator029Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);


            // UsuariosRegistrados.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator029, Method: assocOperator029Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator030
	@Override
    public Long assocOperator030(Solicitud instance) throws SystemException {
        try {
            // COUNT (Aesolicitudes.ProductoT.Dominios.ReportesDominio) WHERE (Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici)
            long count = 0L;
            for(ReportesDominio item : assocOperator030Range1(instance)){
                // Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAesolicitudes().getAesolicitudesFesolici()))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator030, Method: assocOperator030";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator030
	@Override
    public Collection<ReportesDominio> assocOperator030Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator030Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator030
	@Override
    public SQLPopulation assocOperator030Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici
                    // '<=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().getAesolicitudesFesolici()!= null){
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(instance.getAesolicitudes().getAesolicitudesFesolici(), Constants.Type.DATE.getTypeName()));
                    } else {
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator030, Method: assocOperator030Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator031
	@Override
    public Boolean assocOperator031(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona)
            return assocOperator031Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator031, Method: assocOperator031";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator031
	@Override
    public Boolean assocOperator031Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator031Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator031
	@Override
    public SQLExists assocOperator031Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator031, Method: assocOperator031Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator032
	@Override
    public Boolean assocOperator032(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona) WHERE (TitularPersona.TipoIdentificacion.NIT = false)
            return assocOperator032Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator032, Method: assocOperator032";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator032
	@Override
    public Boolean assocOperator032Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator032Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator032
	@Override
    public SQLExists assocOperator032Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // TitularPersona.TipoIdentificacion.NIT = false
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    if (instance.getTitularPersona().getTipoIdentificacion().getTipoIdentificacionNIT()!= null){
                    comparison1.setFirstOperand(new SQLWhereOperandLiteral(instance.getTitularPersona().getTipoIdentificacion().getTipoIdentificacionNIT(), Constants.Type.BOOL.getTypeName()));
                    } else {
                    comparison1.setFirstOperand(new SQLWhereOperandNull());
                    }
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator032, Method: assocOperator032Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator033
	@Override
    public Boolean assocOperator033(Solicitud instance) throws SystemException {
        try {
            // EXIST (Firma)
            return assocOperator033Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator033, Method: assocOperator033";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator033
	@Override
    public Boolean assocOperator033Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator033Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator033
	@Override
    public SQLExists assocOperator033Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_FIRMA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator033, Method: assocOperator033Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator034
	@Override
    public Long assocOperator034(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.drvTieneDocumentos = false)
            long count = 0L;
            for(Usuario item : assocOperator034Range1(instance)){
                // Usuarios.drvTieneDocumentos = false
                if(item.getUsuariodrvTieneDocumentos().equals(false))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator034, Method: assocOperator034";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator034
	@Override
    public Collection<Usuario> assocOperator034Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator034Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator034
	@Override
    public SQLPopulation assocOperator034Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator034, Method: assocOperator034Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator035
	@Override
    public Long assocOperator035(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.drvTieneParentesco = false)
            long count = 0L;
            for(Usuario item : assocOperator035Range1(instance)){
                // Usuarios.drvTieneParentesco = false
                if(item.getUsuariodrvTieneParentesco().equals(false))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator035, Method: assocOperator035";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator035
	@Override
    public Collection<Usuario> assocOperator035Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator035Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator035
	@Override
    public SQLPopulation assocOperator035Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator035, Method: assocOperator035Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator036
	@Override
    public Long assocOperator036(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.Parentesco.EsTitular = true)
            return assocOperator036Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator036, Method: assocOperator036";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator036
	@Override
    public Long assocOperator036Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator036Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator036
	@Override
    public SQLCount assocOperator036Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator036, Method: assocOperator036Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator037
	@Override
    public Long assocOperator037(Solicitud instance) throws SystemException {
        try {
            // COUNT (UsuariosRegistrados) WHERE (UsuariosRegistrados.Parentesco.EsTitular = true)
            return assocOperator037Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator037, Method: assocOperator037";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator037
	@Override
    public Long assocOperator037Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator037Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator037
	@Override
    public SQLCount assocOperator037Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator037, Method: assocOperator037Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator038
	@Override
    public Boolean assocOperator038(Solicitud instance) throws SystemException {
        try {
            // EXIST (Aesolicitudes.ProductoT.Dominios.ReportesDominio) WHERE (Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 9 AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici)
            for(ReportesDominio item : assocOperator038Range1(instance)){
                // Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAesolicitudes().getAesolicitudesFesolici()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator038, Method: assocOperator038";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator038
	@Override
    public Collection<ReportesDominio> assocOperator038Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator038Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator038
	@Override
    public SQLPopulation assocOperator038Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 9
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(9), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison2);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().getAesolicitudesFesolici()!= null){
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(instance.getAesolicitudes().getAesolicitudesFesolici(), Constants.Type.DATE.getTypeName()));
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator038, Method: assocOperator038Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator039
	@Override
    public Boolean assocOperator039(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios.AnexoNeo) WHERE (Usuarios.AnexoNeo.Usuario.EstadoBeneficiario.EsActivo = true)
            return assocOperator039Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator039, Method: assocOperator039";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator039
	@Override
    public Boolean assocOperator039Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator039Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator039
	@Override
    public SQLExists assocOperator039Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_ANEXONEO, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.AnexoNeo.Usuario.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_ANEXONEO + "." + AnexoNeoConstants.ROLE_NAME_USUARIO + "." + UsuarioConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator039, Method: assocOperator039Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator040
	@Override
    public Boolean assocOperator040(Solicitud instance) throws SystemException {
        try {
            // EXIST (Aesolicitudes.ProductoT.Dominios.ReportesDominio) WHERE (Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 2 AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici)
            for(ReportesDominio item : assocOperator040Range1(instance)){
                // Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAesolicitudes().getAesolicitudesFesolici()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator040, Method: assocOperator040";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator040
	@Override
    public Collection<ReportesDominio> assocOperator040Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator040Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator040
	@Override
    public SQLPopulation assocOperator040Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 2
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(2), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison2);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().getAesolicitudesFesolici()!= null){
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(instance.getAesolicitudes().getAesolicitudesFesolici(), Constants.Type.DATE.getTypeName()));
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator040, Method: assocOperator040Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator041
	@Override
    public Boolean assocOperator041(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.EstadoBeneficiario.EsActivo = true)
            return assocOperator041Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator041, Method: assocOperator041";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator041
	@Override
    public Boolean assocOperator041Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator041Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator041
	@Override
    public SQLExists assocOperator041Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator041, Method: assocOperator041Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator042
	@Override
    public Boolean assocOperator042(Solicitud instance) throws SystemException {
        try {
            // EXIST (Contratante)
            return assocOperator042Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator042, Method: assocOperator042";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator042
	@Override
    public Boolean assocOperator042Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator042Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator042
	@Override
    public SQLExists assocOperator042Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATANTE, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator042, Method: assocOperator042Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator043
	@Override
    public Long assocOperator043(Solicitud instance) throws SystemException {
        try {
            // COUNT (UsuariosRegistrados) WHERE (UsuariosRegistrados.Parentesco.EsTitular = true)
            return assocOperator043Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator043, Method: assocOperator043";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator043
	@Override
    public Long assocOperator043Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator043Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator043
	@Override
    public SQLCount assocOperator043Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator043, Method: assocOperator043Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator044
	@Override
    public Long assocOperator044(Solicitud instance) throws SystemException {
        try {
            // COUNT (UsuariosRegistrados) WHERE (UsuariosRegistrados.Parentesco.EsTitular = true)
            return assocOperator044Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator044, Method: assocOperator044";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator044
	@Override
    public Long assocOperator044Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator044Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator044
	@Override
    public SQLCount assocOperator044Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator044, Method: assocOperator044Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator045
	@Override
    public Long assocOperator045(Solicitud instance) throws SystemException {
        try {
            // MAX (UsuariosRegistrados.drvEdad) WHERE (UsuariosRegistrados.Parentesco.EsTitular = true)
            long result = Long.MIN_VALUE;
            for(UsuarioReg item : assocOperator045Range1(instance)){
                if(result < item.getUsuarioRegdrvEdad())
                    result = item.getUsuarioRegdrvEdad();
            }
            return result;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator045, Method: assocOperator045";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator045
	@Override
    public Collection<UsuarioReg> assocOperator045Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator045Range1Query(instance);
        return new TypedQueryBuilder<UsuarioReg>(em, UsuarioReg.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator045
	@Override
    public SQLPopulation assocOperator045Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioRegConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator045, Method: assocOperator045Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator046
	@Override
    public Long assocOperator046(Solicitud instance) throws SystemException {
        try {
            // MAX (Usuarios.drvEdad) WHERE (Usuarios.drvEsElTitular = true)
            long result = Long.MIN_VALUE;
            for(Usuario item : assocOperator046Range1(instance)){
                // Usuarios.drvEsElTitular = true
                boolean conditionsMet = item.getUsuariodrvEsElTitular().equals(true);
                if (!conditionsMet) continue;

                if(result < item.getUsuariodrvEdad())
                    result = item.getUsuariodrvEdad();
            }
            return result;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator046, Method: assocOperator046";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator046
	@Override
    public Collection<Usuario> assocOperator046Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator046Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator046
	@Override
    public SQLPopulation assocOperator046Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator046, Method: assocOperator046Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator047
	@Override
    public Long assocOperator047(Solicitud instance) throws SystemException {
        try {
            // COUNT (UsuariosRegistrados) WHERE (UsuariosRegistrados.Parentesco.EsTitular = true)
            return assocOperator047Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator047, Method: assocOperator047";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator047
	@Override
    public Long assocOperator047Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator047Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator047
	@Override
    public SQLCount assocOperator047Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator047, Method: assocOperator047Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator048
	@Override
    public String assocOperator048(Solicitud instance) throws SystemException {
        try {
            // GETONE (UsuariosRegistrados.Genero) WHERE (UsuariosRegistrados.Parentesco.EsTitular = true)
            return assocOperator048Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator048, Method: assocOperator048";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator048
	@Override
    public String assocOperator048Range1 (Solicitud instance) throws SystemException {
        SQLGetOne sql = assocOperator048Range1Query(instance);
        List<String> results = new TypedQueryBuilder<String>(em, String.class).build(sql).execute();
        return !results.isEmpty() ? results.get(0) : null;
    }

    // Range Query 1 for AssocOperator AssocOperator048
	@Override
    public SQLGetOne assocOperator048Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLGetOne sql = new SQLGetOne(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ATTR_NAME_USUARIOREGGENERO, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator048, Method: assocOperator048Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator049
	@Override
    public Boolean assocOperator049(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.drvEsElTitular = true AND Usuarios.UsuarioPersona.Genero = "F")
            for(Usuario item : assocOperator049Range1(instance)){
                // Usuarios.drvEsElTitular = true
                if(item.getUsuariodrvEsElTitular().equals(true))
                    return true;
            }
            return false;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator049, Method: assocOperator049";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator049
	@Override
    public Collection<Usuario> assocOperator049Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator049Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator049
	@Override
    public SQLPopulation assocOperator049Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.UsuarioPersona.Genero = "F"
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA + "." + PersonaConstants.ATTR_NAME_PERSONAGENERO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral("F", Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator049, Method: assocOperator049Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator050
	@Override
    public Boolean assocOperator050(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.drvEsElTitular = true AND Usuarios.UsuarioPersona.Genero = "M")
            for(Usuario item : assocOperator050Range1(instance)){
                // Usuarios.drvEsElTitular = true
                if(item.getUsuariodrvEsElTitular().equals(true))
                    return true;
            }
            return false;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator050, Method: assocOperator050";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator050
	@Override
    public Collection<Usuario> assocOperator050Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator050Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator050
	@Override
    public SQLPopulation assocOperator050Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.UsuarioPersona.Genero = "M"
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA + "." + PersonaConstants.ATTR_NAME_PERSONAGENERO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral("M", Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator050, Method: assocOperator050Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator051
	@Override
    public Long assocOperator051(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.Parentesco.EsTitular = true)
            return assocOperator051Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator051, Method: assocOperator051";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator051
	@Override
    public Long assocOperator051Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator051Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator051
	@Override
    public SQLCount assocOperator051Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator051, Method: assocOperator051Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator052
	@Override
    public Long assocOperator052(Solicitud instance) throws SystemException {
        try {
            // COUNT (UsuariosRegistrados) WHERE (UsuariosRegistrados.Parentesco.EsTitular = true)
            return assocOperator052Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator052, Method: assocOperator052";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator052
	@Override
    public Long assocOperator052Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator052Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator052
	@Override
    public SQLCount assocOperator052Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator052, Method: assocOperator052Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator053
	@Override
    public Boolean assocOperator053(Solicitud instance) throws SystemException {
        try {
            // EXIST (Aesolicitudes.ProductoT.Dominios.ReportesDominio) WHERE (Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 0 AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici)
            for(ReportesDominio item : assocOperator053Range1(instance)){
                // Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAesolicitudes().getAesolicitudesFesolici()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator053, Method: assocOperator053";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator053
	@Override
    public Collection<ReportesDominio> assocOperator053Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator053Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator053
	@Override
    public SQLPopulation assocOperator053Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 0
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(0), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison2);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().getAesolicitudesFesolici()!= null){
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(instance.getAesolicitudes().getAesolicitudesFesolici(), Constants.Type.DATE.getTypeName()));
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator053, Method: assocOperator053Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator054
	@Override
    public Boolean assocOperator054(Solicitud instance) throws SystemException {
        try {
            // EXIST (Aesolicitudes.ProductoT.Dominios) WHERE (Aesolicitudes.ProductoT.Dominios.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.IgnorarPreexistencias = true)
            return assocOperator054Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator054, Method: assocOperator054";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator054
	@Override
    public Boolean assocOperator054Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator054Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator054
	@Override
    public SQLExists assocOperator054Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.IgnorarPreexistencias = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOIGNORARPREEXISTENCIAS, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator054, Method: assocOperator054Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator055
	@Override
    public Boolean assocOperator055(Solicitud instance) throws SystemException {
        try {
            // EXIST (Firma)
            return assocOperator055Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator055, Method: assocOperator055";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator055
	@Override
    public Boolean assocOperator055Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator055Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator055
	@Override
    public SQLExists assocOperator055Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_FIRMA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator055, Method: assocOperator055Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator056
	@Override
    public Boolean assocOperator056(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.drvImpTarifaPlanVol = 0)
            for(Usuario item : assocOperator056Range1(instance)){
                // Usuarios.drvImpTarifaPlanVol = 0
                if((item.getUsuariodrvImpTarifaPlanVol()).equals(Utilities.convertToDouble(Utilities.convertToDouble(Utilities.convertToDouble(Long.valueOf(0))))))
                    return true;
            }
            return false;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator056, Method: assocOperator056";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator056
	@Override
    public Collection<Usuario> assocOperator056Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator056Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator056
	@Override
    public SQLPopulation assocOperator056Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator056, Method: assocOperator056Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator057
	@Override
    public Double assocOperator057(Solicitud instance) throws SystemException {
        try {
            // SUM (Usuarios.drvImpTarifaPlanVol)
            double result = 0.0;
            for(Usuario item : assocOperator057Range1(instance)){
                result += item.getUsuariodrvImpTarifaPlanVol();
            }
            return result;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator057, Method: assocOperator057";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator057
	@Override
    public Collection<Usuario> assocOperator057Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator057Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator057
	@Override
    public SQLPopulation assocOperator057Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator057, Method: assocOperator057Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator058
	@Override
    public Boolean assocOperator058(Solicitud instance) throws SystemException {
        try {
            // EXIST (Aesolicitudes.ProductoT.Dominios.ReportesDominio) WHERE (Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 5 AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici)
            for(ReportesDominio item : assocOperator058Range1(instance)){
                // Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAesolicitudes().getAesolicitudesFesolici()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator058, Method: assocOperator058";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator058
	@Override
    public Collection<ReportesDominio> assocOperator058Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator058Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator058
	@Override
    public SQLPopulation assocOperator058Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 5
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(5), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison2);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().getAesolicitudesFesolici()!= null){
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(instance.getAesolicitudes().getAesolicitudesFesolici(), Constants.Type.DATE.getTypeName()));
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator058, Method: assocOperator058Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator059
	@Override
    public Boolean assocOperator059(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.EstadoBeneficiario.EsActivo = true)
            return assocOperator059Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator059, Method: assocOperator059";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator059
	@Override
    public Boolean assocOperator059Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator059Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator059
	@Override
    public SQLExists assocOperator059Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator059, Method: assocOperator059Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator060
	@Override
    public Boolean assocOperator060(Solicitud instance) throws SystemException {
        try {
            // EXIST (Aesolicitudes.ProductoT.Dominios) WHERE (Aesolicitudes.ProductoT.Dominios.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.InclusionModGrupoAsoc = true)
            return assocOperator060Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator060, Method: assocOperator060";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator060
	@Override
    public Boolean assocOperator060Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator060Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator060
	@Override
    public SQLExists assocOperator060Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.InclusionModGrupoAsoc = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOINCLUSIONMODGRUPOASOC, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator060, Method: assocOperator060Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator061
	@Override
    public Boolean assocOperator061(Solicitud instance) throws SystemException {
        try {
            // EXIST (Aesolicitudes.ProductoT.Dominios) WHERE (Aesolicitudes.ProductoT.Dominios.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.AcepPolizaInter = true)
            return assocOperator061Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator061, Method: assocOperator061";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator061
	@Override
    public Boolean assocOperator061Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator061Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator061
	@Override
    public SQLExists assocOperator061Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.AcepPolizaInter = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOACEPPOLIZAINTER, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator061, Method: assocOperator061Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator062
	@Override
    public Long assocOperator062(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.PolizaInternacional = true)
            return assocOperator062Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator062, Method: assocOperator062";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator062
	@Override
    public Long assocOperator062Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator062Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator062
	@Override
    public SQLCount assocOperator062Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.PolizaInternacional = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIOPOLIZAINTERNACIONAL, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator062, Method: assocOperator062Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator063
	@Override
    public Boolean assocOperator063(Solicitud instance) throws SystemException {
        try {
            // EXIST (Aesolicitudes.ProductoT.Dominios) WHERE (Aesolicitudes.ProductoT.Dominios.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.PermiteRechazadosAfi = true)
            return assocOperator063Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator063, Method: assocOperator063";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator063
	@Override
    public Boolean assocOperator063Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator063Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator063
	@Override
    public SQLExists assocOperator063Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.PermiteRechazadosAfi = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOPERMITERECHAZADOSAFI, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator063, Method: assocOperator063Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator064
	@Override
    public Long assocOperator064(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.IMC <> NULL AND Usuarios.drvEdad >= StrToReal(fugetValorParametroConf("EDADIMC")) AND Usuarios.IMC > StrToReal(fugetValorParametroConf("MAXIMC")))
            long count = 0L;
            for(Usuario item : assocOperator064Range1(instance)){
                // Usuarios.drvEdad >= StrToReal(fugetValorParametroConf("EDADIMC"))
                if(Utilities.convertToDouble(Utilities.convertToDouble(item.getUsuariodrvEdad())) >= STDFunctions.strToRealFun(userFunctionsSrv.fugetValorParametroConfFun("EDADIMC")))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator064, Method: assocOperator064";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator064
	@Override
    public Collection<Usuario> assocOperator064Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator064Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator064
	@Override
    public SQLPopulation assocOperator064Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.IMC <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIOIMC, Constants.Type.REAL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison1);


            // Usuarios.IMC > StrToReal(fugetValorParametroConf("MAXIMC"))
                    // '>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator(">");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIOIMC, Constants.Type.REAL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                            if (STDFunctions.strToRealFun(userFunctionsSrv.fugetValorParametroConfFun("MAXIMC")) != null) {
                                comparison2.setSecondOperand(new SQLWhereOperandLiteral(STDFunctions.strToRealFun(userFunctionsSrv.fugetValorParametroConfFun("MAXIMC")), Constants.Type.REAL.getTypeName()));
                            } else {
                                comparison2.setSecondOperand(new SQLWhereOperandNull());
                                }
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator064, Method: assocOperator064Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator065
	@Override
    public Boolean assocOperator065(Solicitud instance) throws SystemException {
        try {
            // EXIST (UsrAreaMedica)
            return assocOperator065Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator065, Method: assocOperator065";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator065
	@Override
    public Boolean assocOperator065Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator065Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator065
	@Override
    public SQLExists assocOperator065Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USRAREAMEDICA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator065, Method: assocOperator065Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator066
	@Override
    public Boolean assocOperator066(Solicitud instance) throws SystemException {
        try {
            // EXIST (ContratantePersona)
            return assocOperator066Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator066, Method: assocOperator066";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator066
	@Override
    public Boolean assocOperator066Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator066Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator066
	@Override
    public SQLExists assocOperator066Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator066, Method: assocOperator066Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator067
	@Override
    public Long assocOperator067(Solicitud instance) throws SystemException {
        try {
            // COUNT (Aesolicitudes.ProductoT.Dominios) WHERE (Aesolicitudes.ProductoT.Dominios.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.TramiteEnLinea = true)
            return assocOperator067Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator067, Method: assocOperator067";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator067
	@Override
    public Long assocOperator067Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator067Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator067
	@Override
    public SQLCount assocOperator067Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.TramiteEnLinea = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOTRAMITEENLINEA, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator067, Method: assocOperator067Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator068
	@Override
    public String assocOperator068(Solicitud instance) throws SystemException {
        try {
            // GETONE (Aesolicitudes.PlanT.Tarifas.Codigo) WHERE (Aesolicitudes.PlanT.Tarifas.ProductoT = Aesolicitudes.ProductoT AND Aesolicitudes.PlanT.Tarifas.TipoContrato = tipoContrato AND EXIST (Aesolicitudes.PlanT.Tarifas.DetallesTarifa) WHERE (Aesolicitudes.PlanT.Tarifas.DetallesTarifa.Anyo = getYear(FInicioContrato)) = true)
            return assocOperator068Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator068, Method: assocOperator068";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator068
	@Override
    public String assocOperator068Range1 (Solicitud instance) throws SystemException {
        SQLGetOne sql = assocOperator068Range1Query(instance);
        List<String> results = new TypedQueryBuilder<String>(em, String.class).build(sql).execute();
        return !results.isEmpty() ? results.get(0) : null;
    }

    // Range Query 1 for AssocOperator AssocOperator068
	@Override
    public SQLGetOne assocOperator068Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLGetOne sql = new SQLGetOne(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_TARIFAS + "." + TarifaConstants.ATTR_NAME_TARIFACODIGO, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.PlanT.Tarifas.ProductoT = Aesolicitudes.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_TARIFAS + "." + TarifaConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getAesolicitudes().getProductoT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.PlanT.Tarifas.TipoContrato = tipoContrato
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_TARIFAS + "." + TarifaConstants.ATTR_NAME_TARIFATIPOCONTRATO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(instance.getSolicitudtipoContrato(), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison2);


            // EXIST (Aesolicitudes.PlanT.Tarifas.DetallesTarifa) WHERE (Aesolicitudes.PlanT.Tarifas.DetallesTarifa.Anyo = getYear(FInicioContrato)) = true
                // 'exist' Association operator
                SQLWhereOperandSubQuery operandSubQueryAssocOperator069 = new SQLWhereOperandSubQuery(assocOperator069Range1Query(instance, sql));
                conjunction.addOperand(operandSubQueryAssocOperator069);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator068, Method: assocOperator068Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator069
	@Override
    public Boolean assocOperator069(Solicitud instance) throws SystemException {
        try {
            // EXIST (Aesolicitudes.PlanT.Tarifas.DetallesTarifa) WHERE (Aesolicitudes.PlanT.Tarifas.DetallesTarifa.Anyo = getYear(FInicioContrato))
            return assocOperator069Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator069, Method: assocOperator069";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator069
	@Override
    public Boolean assocOperator069Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator069Range1Query(instance, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator069
	@Override
    public SQLExists assocOperator069Range1Query (Solicitud instance, SQLSelect superQuery) throws SystemException {
        try {
            // Path starts with a class in the subquery
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_TARIFAS + "." + TarifaConstants.ROLE_NAME_DETALLESTARIFA);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.PlanT.Tarifas.DetallesTarifa.Anyo = getYear(FInicioContrato)
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_TARIFAS + "." + TarifaConstants.ROLE_NAME_DETALLESTARIFA + "." + DetalleTarifaConstants.ATTR_NAME_DETALLETARIFAANYO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                            if (STDFunctions.getYearFun(instance.getSolicitudFInicioContrato()) != null) {
                                comparison1.setSecondOperand(new SQLWhereOperandLiteral(STDFunctions.getYearFun(instance.getSolicitudFInicioContrato()), Constants.Type.INT.getTypeName()));
                            } else {
                                comparison1.setSecondOperand(new SQLWhereOperandNull());
                                }
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator069, Method: assocOperator069Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator070
	@Override
    public Boolean assocOperator070(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona)
            return assocOperator070Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator070, Method: assocOperator070";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator070
	@Override
    public Boolean assocOperator070Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator070Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator070
	@Override
    public SQLExists assocOperator070Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator070, Method: assocOperator070Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator071
	@Override
    public Boolean assocOperator071() throws SystemException {
        try {
            // EXIST (ContratoC)
            return assocOperator071Range1();
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator071, Method: assocOperator071";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator071
	@Override
    public Boolean assocOperator071Range1 () throws SystemException {
        SQLExists sql = assocOperator071Range1Query(null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator071
	@Override
    public SQLExists assocOperator071Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATOC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator071, Method: assocOperator071Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator072
	@Override
    public Long assocOperator072() throws SystemException {
        try {
            // COUNT (Usuarios)
            return assocOperator072Range1();
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator072, Method: assocOperator072";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator072
	@Override
    public Long assocOperator072Range1 () throws SystemException {
        SQLCount sql = assocOperator072Range1Query(null);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 0 for AssocOperator AssocOperator072
	@Override
    public SQLCount assocOperator072Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator072, Method: assocOperator072Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator073
	@Override
    public Long assocOperator073() throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.EstadoBeneficiario.Confirmado = true)
            return assocOperator073Range1();
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator073, Method: assocOperator073";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator073
	@Override
    public Long assocOperator073Range1 () throws SystemException {
        SQLCount sql = assocOperator073Range1Query(null);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 0 for AssocOperator AssocOperator073
	@Override
    public SQLCount assocOperator073Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.EstadoBeneficiario.Confirmado = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOCONFIRMADO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator073, Method: assocOperator073Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator074
	@Override
    public Boolean assocOperator074(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.TipoIdentificacion = vTipoDoc AND Usuarios.NumIdentificacion = vNumDoc)
            return assocOperator074Range1(vTipoDoc, vNumDoc);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator074, Method: assocOperator074";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator074
	@Override
    public Boolean assocOperator074Range1 (TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator074Range1Query(vTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator074
	@Override
    public SQLExists assocOperator074Range1Query (TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.TipoIdentificacion = vTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSADMIN_VTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, vTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSADMIN_VTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Usuarios.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIONUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator074, Method: assocOperator074Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator075
	@Override
    public Boolean assocOperator075(Persona voPersona) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.UsuarioPersona.TipoIdentificacion = voPersona.TipoIdentificacion AND Usuarios.UsuarioPersona.NumIdentificacion = voPersona.NumIdentificacion)
            return assocOperator075Range1(voPersona);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator075, Method: assocOperator075";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator075
	@Override
    public Boolean assocOperator075Range1 (Persona voPersona) throws SystemException {
        SQLExists sql = assocOperator075Range1Query(voPersona, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator075
	@Override
    public SQLExists assocOperator075Range1Query (Persona voPersona, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.UsuarioPersona.TipoIdentificacion = voPersona.TipoIdentificacion
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA + "." + PersonaConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (voPersona.isNull() || voPersona.getTipoIdentificacion().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDCONTRATANTETITULAR_VOPERSONA + "." + PersonaConstants.ROLE_NAME_TIPOIDENTIFICACION, PersonaConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, voPersona.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDCONTRATANTETITULAR_VOPERSONA);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Usuarios.UsuarioPersona.NumIdentificacion = voPersona.NumIdentificacion
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA + "." + PersonaConstants.ATTR_NAME_PERSONANUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    if (voPersona.getPersonaNumIdentificacion()!= null){
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(voPersona.getPersonaNumIdentificacion(), Constants.Type.STRING.getTypeName()));
                    } else {
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator075, Method: assocOperator075Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator076
	@Override
    public Boolean assocOperator076() throws SystemException {
        try {
            // EXIST (ContratoC)
            return assocOperator076Range1();
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator076, Method: assocOperator076";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator076
	@Override
    public Boolean assocOperator076Range1 () throws SystemException {
        SQLExists sql = assocOperator076Range1Query(null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator076
	@Override
    public SQLExists assocOperator076Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATOC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator076, Method: assocOperator076Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator077
	@Override
    public Long assocOperator077() throws SystemException {
        try {
            // COUNT (Usuarios)
            return assocOperator077Range1();
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator077, Method: assocOperator077";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator077
	@Override
    public Long assocOperator077Range1 () throws SystemException {
        SQLCount sql = assocOperator077Range1Query(null);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 0 for AssocOperator AssocOperator077
	@Override
    public SQLCount assocOperator077Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator077, Method: assocOperator077Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator078
	@Override
    public Long assocOperator078() throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.EstadoBeneficiario.Confirmado = true)
            return assocOperator078Range1();
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator078, Method: assocOperator078";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator078
	@Override
    public Long assocOperator078Range1 () throws SystemException {
        SQLCount sql = assocOperator078Range1Query(null);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 0 for AssocOperator AssocOperator078
	@Override
    public SQLCount assocOperator078Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.EstadoBeneficiario.Confirmado = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOCONFIRMADO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator078, Method: assocOperator078Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator079
	@Override
    public Boolean assocOperator079(TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Contratante) WHERE (Contratante.TipoIdentificacion = voTipoDoc AND Contratante.NumIdentificacion = vNumDoc)
            return assocOperator079Range1(voTipoDoc, vNumDoc);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator079, Method: assocOperator079";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator079
	@Override
    public Boolean assocOperator079Range1 (TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator079Range1Query(voTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator079
	@Override
    public SQLExists assocOperator079Range1Query (TipoIdentificacion voTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATANTE);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Contratante.TipoIdentificacion = voTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_CONTRATANTE + "." + ContratanteConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDCONSULTARADICADO_VOTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, voTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDCONSULTARADICADO_VOTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Contratante.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_CONTRATANTE + "." + ContratanteConstants.ATTR_NAME_CONTRATANTENUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator079, Method: assocOperator079Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator080
	@Override
    public Boolean assocOperator080(TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Titular) WHERE (Titular.TipoIdentificacion = voTipoDoc AND Titular.NumIdentificacion = vNumDoc)
            return assocOperator080Range1(voTipoDoc, vNumDoc);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator080, Method: assocOperator080";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator080
	@Override
    public Boolean assocOperator080Range1 (TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator080Range1Query(voTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator080
	@Override
    public SQLExists assocOperator080Range1Query (TipoIdentificacion voTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULAR);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Titular.TipoIdentificacion = voTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_TITULAR + "." + TitularConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDCONSULTARADICADO_VOTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, voTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDCONSULTARADICADO_VOTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Titular.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_TITULAR + "." + TitularConstants.ATTR_NAME_TITULARNUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator080, Method: assocOperator080Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator081
	@Override
    public Boolean assocOperator081(TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.TipoIdentificacion = voTipoDoc AND Usuarios.NumIdentificacion = vNumDoc)
            return assocOperator081Range1(voTipoDoc, vNumDoc);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator081, Method: assocOperator081";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator081
	@Override
    public Boolean assocOperator081Range1 (TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator081Range1Query(voTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator081
	@Override
    public SQLExists assocOperator081Range1Query (TipoIdentificacion voTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.TipoIdentificacion = voTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDCONSULTARADICADO_VOTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, voTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDCONSULTARADICADO_VOTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Usuarios.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIONUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator081, Method: assocOperator081Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator082
	@Override
    public Boolean assocOperator082(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.TipoIdentificacion = vTipoDoc AND Usuarios.NumIdentificacion = vNumDoc)
            return assocOperator082Range1(vTipoDoc, vNumDoc);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator082, Method: assocOperator082";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator082
	@Override
    public Boolean assocOperator082Range1 (TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator082Range1Query(vTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator082
	@Override
    public SQLExists assocOperator082Range1Query (TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.TipoIdentificacion = vTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSAFIL1_VTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, vTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSAFIL1_VTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Usuarios.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIONUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator082, Method: assocOperator082Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator083
	@Override
    public Boolean assocOperator083(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.TipoIdentificacion = vTipoDoc AND Usuarios.NumIdentificacion = vNumDoc)
            return assocOperator083Range1(vTipoDoc, vNumDoc);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator083, Method: assocOperator083";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator083
	@Override
    public Boolean assocOperator083Range1 (TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator083Range1Query(vTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator083
	@Override
    public SQLExists assocOperator083Range1Query (TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.TipoIdentificacion = vTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSAFIL2_VTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, vTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSAFIL2_VTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Usuarios.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIONUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator083, Method: assocOperator083Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator084
	@Override
    public Boolean assocOperator084(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.TipoIdentificacion = vTipoDoc AND Usuarios.NumIdentificacion = vNumDoc)
            return assocOperator084Range1(vTipoDoc, vNumDoc);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator084, Method: assocOperator084";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator084
	@Override
    public Boolean assocOperator084Range1 (TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator084Range1Query(vTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator084
	@Override
    public SQLExists assocOperator084Range1Query (TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.TipoIdentificacion = vTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSAFIL3_VTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, vTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSAFIL3_VTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Usuarios.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIONUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator084, Method: assocOperator084Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator085
	@Override
    public Boolean assocOperator085(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.TipoIdentificacion = vTipoDoc AND Usuarios.NumIdentificacion = vNumDoc)
            return assocOperator085Range1(vTipoDoc, vNumDoc);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator085, Method: assocOperator085";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator085
	@Override
    public Boolean assocOperator085Range1 (TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator085Range1Query(vTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator085
	@Override
    public SQLExists assocOperator085Range1Query (TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.TipoIdentificacion = vTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED1_VTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, vTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED1_VTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Usuarios.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIONUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator085, Method: assocOperator085Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator086
	@Override
    public Boolean assocOperator086(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.TipoIdentificacion = vTipoDoc AND Usuarios.NumIdentificacion = vNumDoc)
            return assocOperator086Range1(vTipoDoc, vNumDoc);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator086, Method: assocOperator086";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator086
	@Override
    public Boolean assocOperator086Range1 (TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator086Range1Query(vTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator086
	@Override
    public SQLExists assocOperator086Range1Query (TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.TipoIdentificacion = vTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED2_VTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, vTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED2_VTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Usuarios.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIONUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator086, Method: assocOperator086Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator087
	@Override
    public Boolean assocOperator087(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.TipoIdentificacion = vTipoDoc AND Usuarios.NumIdentificacion = vNumDoc)
            return assocOperator087Range1(vTipoDoc, vNumDoc);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator087, Method: assocOperator087";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator087
	@Override
    public Boolean assocOperator087Range1 (TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator087Range1Query(vTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator087
	@Override
    public SQLExists assocOperator087Range1Query (TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.TipoIdentificacion = vTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED3_VTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, vTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED3_VTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Usuarios.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIONUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator087, Method: assocOperator087Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator088
	@Override
    public Boolean assocOperator088(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.TipoIdentificacion = vTipoDoc AND Usuarios.NumIdentificacion = vNumDoc)
            return assocOperator088Range1(vTipoDoc, vNumDoc);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator088, Method: assocOperator088";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator088
	@Override
    public Boolean assocOperator088Range1 (TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator088Range1Query(vTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator088
	@Override
    public SQLExists assocOperator088Range1Query (TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.TipoIdentificacion = vTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSESTHOMO_VTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, vTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSESTHOMO_VTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Usuarios.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIONUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator088, Method: assocOperator088Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator089
	@Override
    public Boolean assocOperator089(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios(Usuarios.drvTieneDocumentos = true)
            for(Usuario item : assocOperator089Range1(instance)){
                // Usuarios.drvTieneDocumentos = true
                boolean conditionsMet = item.getUsuariodrvTieneDocumentos().equals(true);
                if (!conditionsMet) return false;
            }
            return true;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator089, Method: assocOperator089";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator089
	@Override
    public Collection<Usuario> assocOperator089Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator089Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator089
	@Override
    public SQLPopulation assocOperator089Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator089, Method: assocOperator089Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator090
	@Override
    public Boolean assocOperator090(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios(Usuarios.drvTieneParentesco = true)
            for(Usuario item : assocOperator090Range1(instance)){
                // Usuarios.drvTieneParentesco = true
                boolean conditionsMet = item.getUsuariodrvTieneParentesco().equals(true);
                if (!conditionsMet) return false;
            }
            return true;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator090, Method: assocOperator090";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator090
	@Override
    public Collection<Usuario> assocOperator090Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator090Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator090
	@Override
    public SQLPopulation assocOperator090Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator090, Method: assocOperator090Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator091
	@Override
    public Long assocOperator091(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.Parentesco.EsTitular = true)
            return assocOperator091Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator091, Method: assocOperator091";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator091
	@Override
    public Long assocOperator091Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator091Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator091
	@Override
    public SQLCount assocOperator091Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator091, Method: assocOperator091Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator092
	@Override
    public Long assocOperator092(Solicitud instance) throws SystemException {
        try {
            // COUNT (UsuariosRegistrados) WHERE (UsuariosRegistrados.Parentesco.EsTitular = true)
            return assocOperator092Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator092, Method: assocOperator092";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator092
	@Override
    public Long assocOperator092Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator092Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator092
	@Override
    public SQLCount assocOperator092Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator092, Method: assocOperator092Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator093
	@Override
    public Boolean assocOperator093(Solicitud instance) throws SystemException {
        try {
            // EXIST (ContratantePersona)
            return assocOperator093Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator093, Method: assocOperator093";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator093
	@Override
    public Boolean assocOperator093Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator093Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator093
	@Override
    public SQLExists assocOperator093Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator093, Method: assocOperator093Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator094
	@Override
    public Boolean assocOperator094(Solicitud instance) throws SystemException {
        try {
            // EXIST (ContratantePersona.DocumentosG) WHERE (ContratantePersona.DocumentosG.Tipo = 1)
            return assocOperator094Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator094, Method: assocOperator094";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator094
	@Override
    public Boolean assocOperator094Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator094Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator094
	@Override
    public SQLExists assocOperator094Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA + "." + PersonaConstants.ROLE_NAME_DOCUMENTOSG, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ContratantePersona.DocumentosG.Tipo = 1
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA + "." + PersonaConstants.ROLE_NAME_DOCUMENTOSG + "." + DocumentoGConstants.ATTR_NAME_DOCUMENTOGTIPO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator094, Method: assocOperator094Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator095
	@Override
    public Boolean assocOperator095(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona)
            return assocOperator095Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator095, Method: assocOperator095";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator095
	@Override
    public Boolean assocOperator095Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator095Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator095
	@Override
    public SQLExists assocOperator095Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator095, Method: assocOperator095Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator096
	@Override
    public Boolean assocOperator096(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona.DocumentosG) WHERE (TitularPersona.DocumentosG.Tipo = 1)
            return assocOperator096Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator096, Method: assocOperator096";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator096
	@Override
    public Boolean assocOperator096Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator096Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator096
	@Override
    public SQLExists assocOperator096Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA + "." + PersonaConstants.ROLE_NAME_DOCUMENTOSG, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // TitularPersona.DocumentosG.Tipo = 1
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_TITULARPERSONA + "." + PersonaConstants.ROLE_NAME_DOCUMENTOSG + "." + DocumentoGConstants.ATTR_NAME_DOCUMENTOGTIPO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator096, Method: assocOperator096Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator097
	@Override
    public Long assocOperator097(Solicitud instance) throws SystemException {
        try {
            // COUNT (DocumentosGestor) WHERE (DocumentosGestor.Tipo = 2)
            return assocOperator097Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator097, Method: assocOperator097";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator097
	@Override
    public Long assocOperator097Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator097Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator097
	@Override
    public SQLCount assocOperator097Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_DOCUMENTOSGESTOR, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // DocumentosGestor.Tipo = 2
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_DOCUMENTOSGESTOR + "." + DocumentoGConstants.ATTR_NAME_DOCUMENTOGTIPO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(2), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator097, Method: assocOperator097Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator098
	@Override
    public Boolean assocOperator098(Solicitud instance) throws SystemException {
        try {
            // EXIST (Titular)
            return assocOperator098Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator098, Method: assocOperator098";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator098
	@Override
    public Boolean assocOperator098Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator098Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator098
	@Override
    public SQLExists assocOperator098Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULAR, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator098, Method: assocOperator098Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator099
	@Override
    public Boolean assocOperator099(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona)
            return assocOperator099Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator099, Method: assocOperator099";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator099
	@Override
    public Boolean assocOperator099Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator099Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator099
	@Override
    public SQLExists assocOperator099Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator099, Method: assocOperator099Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator100
	@Override
    public Boolean assocOperator100(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona.DocumentosG) WHERE (TitularPersona.DocumentosG.Tipo = 1)
            return assocOperator100Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator100, Method: assocOperator100";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator100
	@Override
    public Boolean assocOperator100Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator100Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator100
	@Override
    public SQLExists assocOperator100Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA + "." + PersonaConstants.ROLE_NAME_DOCUMENTOSG, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // TitularPersona.DocumentosG.Tipo = 1
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_TITULARPERSONA + "." + PersonaConstants.ROLE_NAME_DOCUMENTOSG + "." + DocumentoGConstants.ATTR_NAME_DOCUMENTOGTIPO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator100, Method: assocOperator100Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator101
	@Override
    public Boolean assocOperator101(Solicitud instance) throws SystemException {
        try {
            // EXIST (Titular)
            return assocOperator101Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator101, Method: assocOperator101";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator101
	@Override
    public Boolean assocOperator101Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator101Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator101
	@Override
    public SQLExists assocOperator101Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULAR, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator101, Method: assocOperator101Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator102
	@Override
    public Boolean assocOperator102(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona)
            return assocOperator102Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator102, Method: assocOperator102";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator102
	@Override
    public Boolean assocOperator102Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator102Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator102
	@Override
    public SQLExists assocOperator102Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator102, Method: assocOperator102Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator103
	@Override
    public Boolean assocOperator103(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona.DocumentosG) WHERE (TitularPersona.DocumentosG.Tipo = 1)
            return assocOperator103Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator103, Method: assocOperator103";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator103
	@Override
    public Boolean assocOperator103Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator103Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator103
	@Override
    public SQLExists assocOperator103Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA + "." + PersonaConstants.ROLE_NAME_DOCUMENTOSG, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // TitularPersona.DocumentosG.Tipo = 1
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_TITULARPERSONA + "." + PersonaConstants.ROLE_NAME_DOCUMENTOSG + "." + DocumentoGConstants.ATTR_NAME_DOCUMENTOGTIPO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator103, Method: assocOperator103Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator104
	@Override
    public Boolean assocOperator104(Solicitud instance) throws SystemException {
        try {
            // EXIST (ContratantePersona)
            return assocOperator104Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator104, Method: assocOperator104";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator104
	@Override
    public Boolean assocOperator104Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator104Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator104
	@Override
    public SQLExists assocOperator104Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator104, Method: assocOperator104Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator105
	@Override
    public Boolean assocOperator105(Solicitud instance) throws SystemException {
        try {
            // EXIST (ContratantePersona.DocumentosG) WHERE (ContratantePersona.DocumentosG.Tipo = 1)
            return assocOperator105Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator105, Method: assocOperator105";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator105
	@Override
    public Boolean assocOperator105Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator105Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator105
	@Override
    public SQLExists assocOperator105Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA + "." + PersonaConstants.ROLE_NAME_DOCUMENTOSG, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ContratantePersona.DocumentosG.Tipo = 1
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA + "." + PersonaConstants.ROLE_NAME_DOCUMENTOSG + "." + DocumentoGConstants.ATTR_NAME_DOCUMENTOGTIPO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator105, Method: assocOperator105Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator106
	@Override
    public Boolean assocOperator106(Solicitud instance) throws SystemException {
        try {
            // EXIST (Titular)
            return assocOperator106Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator106, Method: assocOperator106";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator106
	@Override
    public Boolean assocOperator106Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator106Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator106
	@Override
    public SQLExists assocOperator106Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULAR, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator106, Method: assocOperator106Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator107
	@Override
    public Boolean assocOperator107(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona.DocumentosG) WHERE (TitularPersona.DocumentosG.Tipo = 1)
            return assocOperator107Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator107, Method: assocOperator107";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator107
	@Override
    public Boolean assocOperator107Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator107Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator107
	@Override
    public SQLExists assocOperator107Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA + "." + PersonaConstants.ROLE_NAME_DOCUMENTOSG, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // TitularPersona.DocumentosG.Tipo = 1
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_TITULARPERSONA + "." + PersonaConstants.ROLE_NAME_DOCUMENTOSG + "." + DocumentoGConstants.ATTR_NAME_DOCUMENTOGTIPO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator107, Method: assocOperator107Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator108
	@Override
    public Boolean assocOperator108(Solicitud instance) throws SystemException {
        try {
            // EXIST (TipoFactura)
            return assocOperator108Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator108, Method: assocOperator108";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator108
	@Override
    public Boolean assocOperator108Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator108Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator108
	@Override
    public SQLExists assocOperator108Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TIPOFACTURA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator108, Method: assocOperator108Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator109
	@Override
    public Boolean assocOperator109(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona)
            return assocOperator109Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator109, Method: assocOperator109";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator109
	@Override
    public Boolean assocOperator109Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator109Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator109
	@Override
    public SQLExists assocOperator109Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator109, Method: assocOperator109Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator110
	@Override
    public Boolean assocOperator110(Solicitud instance) throws SystemException {
        try {
            // EXIST (TipoFactura)
            return assocOperator110Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator110, Method: assocOperator110";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator110
	@Override
    public Boolean assocOperator110Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator110Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator110
	@Override
    public SQLExists assocOperator110Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TIPOFACTURA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator110, Method: assocOperator110Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator111
	@Override
    public Boolean assocOperator111(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona)
            return assocOperator111Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator111, Method: assocOperator111";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator111
	@Override
    public Boolean assocOperator111Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator111Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator111
	@Override
    public SQLExists assocOperator111Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator111, Method: assocOperator111Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator112
	@Override
    public Boolean assocOperator112(Solicitud instance) throws SystemException {
        try {
            // EXIST (Aesolicitudes.ProductoT.Tarifas.DetallesTarifa) WHERE (Aesolicitudes.ProductoT.Tarifas.DetallesTarifa.Tarifa.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Tarifas.DetallesTarifa.Anyo = getYear(FInicioContrato))
            return assocOperator112Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator112, Method: assocOperator112";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator112
	@Override
    public Boolean assocOperator112Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator112Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator112
	@Override
    public SQLExists assocOperator112Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_TARIFAS + "." + TarifaConstants.ROLE_NAME_DETALLESTARIFA, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Tarifas.DetallesTarifa.Tarifa.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_TARIFAS + "." + TarifaConstants.ROLE_NAME_DETALLESTARIFA + "." + DetalleTarifaConstants.ROLE_NAME_TARIFA + "." + TarifaConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Tarifas.DetallesTarifa.Anyo = getYear(FInicioContrato)
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_TARIFAS + "." + TarifaConstants.ROLE_NAME_DETALLESTARIFA + "." + DetalleTarifaConstants.ATTR_NAME_DETALLETARIFAANYO, Constants.Type.INT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                            if (STDFunctions.getYearFun(instance.getSolicitudFInicioContrato()) != null) {
                                comparison2.setSecondOperand(new SQLWhereOperandLiteral(STDFunctions.getYearFun(instance.getSolicitudFInicioContrato()), Constants.Type.INT.getTypeName()));
                            } else {
                                comparison2.setSecondOperand(new SQLWhereOperandNull());
                                }
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator112, Method: assocOperator112Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator113
	@Override
    public Long assocOperator113(Solicitud instance) throws SystemException {
        try {
            // COUNT (Aesolicitudes.ProductoT.Dominios) WHERE (Aesolicitudes.ProductoT.Dominios.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.VigenciaRadicacion = true)
            return assocOperator113Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator113, Method: assocOperator113";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator113
	@Override
    public Long assocOperator113Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator113Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator113
	@Override
    public SQLCount assocOperator113Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.VigenciaRadicacion = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOVIGENCIARADICACION, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator113, Method: assocOperator113Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator114
	@Override
    public Boolean assocOperator114(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.drvEstaActivo = true)
            for(Usuario item : assocOperator114Range1(instance)){
                // Usuarios.drvEstaActivo = true
                if(item.getUsuariodrvEstaActivo().equals(true))
                    return true;
            }
            return false;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator114, Method: assocOperator114";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator114
	@Override
    public Collection<Usuario> assocOperator114Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator114Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator114
	@Override
    public SQLPopulation assocOperator114Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator114, Method: assocOperator114Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator115
	@Override
    public Boolean assocOperator115(Solicitud instance) throws SystemException {
        try {
            // EXIST (UsuariosRegistrados) WHERE (UsuariosRegistrados.EstadoBeneficiario.EsActivo = true)
            return assocOperator115Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator115, Method: assocOperator115";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator115
	@Override
    public Boolean assocOperator115Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator115Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator115
	@Override
    public SQLExists assocOperator115Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator115, Method: assocOperator115Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator116
	@Override
    public Boolean assocOperator116(Solicitud instance) throws SystemException {
        try {
            // EXIST (Direccion) WHERE (Direccion.TipoDireccion.EsCorrespondencia = true)
            return assocOperator116Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator116, Method: assocOperator116";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator116
	@Override
    public Boolean assocOperator116Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator116Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator116
	@Override
    public SQLExists assocOperator116Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_DIRECCION, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Direccion.TipoDireccion.EsCorrespondencia = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    if (instance.getDireccion().getTipoDireccion().getTipoDireccionEsCorrespondencia()!= null){
                    comparison1.setFirstOperand(new SQLWhereOperandLiteral(instance.getDireccion().getTipoDireccion().getTipoDireccionEsCorrespondencia(), Constants.Type.BOOL.getTypeName()));
                    } else {
                    comparison1.setFirstOperand(new SQLWhereOperandNull());
                    }
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator116, Method: assocOperator116Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator117
	@Override
    public Long assocOperator117(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.Parentesco.EsTitular = true AND Usuarios.drvEstaActivo = true)
            long count = 0L;
            for(Usuario item : assocOperator117Range1(instance)){
                // Usuarios.drvEstaActivo = true
                if(item.getUsuariodrvEstaActivo().equals(true))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator117, Method: assocOperator117";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator117
	@Override
    public Collection<Usuario> assocOperator117Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator117Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator117
	@Override
    public SQLPopulation assocOperator117Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator117, Method: assocOperator117Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator118
	@Override
    public Long assocOperator118(Solicitud instance) throws SystemException {
        try {
            // COUNT (UsuariosRegistrados) WHERE (UsuariosRegistrados.Parentesco.EsTitular = true AND UsuariosRegistrados.EstadoBeneficiario.EsActivo = true)
            return assocOperator118Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator118, Method: assocOperator118";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator118
	@Override
    public Long assocOperator118Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator118Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator118
	@Override
    public SQLCount assocOperator118Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);


            // UsuariosRegistrados.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator118, Method: assocOperator118Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator119
	@Override
    public Boolean assocOperator119(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (EXIST (Usuarios.UsuarioPersona.EstadoPersona) = true)(Usuarios.UsuarioPersona.EstadoPersona.ProhibidoBeneficiarios = false)
            return assocOperator119Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator119, Method: assocOperator119";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator119
	@Override
    public Boolean assocOperator119Range1 (Solicitud instance) throws SystemException {
        SQLSelect sql = assocOperator119Range1Query(instance);
        return new TypedQueryBuilder<Long>(em, Long.class).build(sql).getSingleResult() == 0;
    }

    // Range Query 1 for AssocOperator AssocOperator119
	@Override
    public SQLForAllCondition assocOperator119Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLForAllCondition sql = new SQLForAllCondition(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();
            SQLWhereNegation negation = null;

            // EXIST (Usuarios.UsuarioPersona.EstadoPersona) = true
                // 'exist' Association operator
                SQLWhereOperandSubQuery operandSubQueryAssocOperator120 = new SQLWhereOperandSubQuery(assocOperator120Range1Query(instance, sql));
                conjunction.addOperand(operandSubQueryAssocOperator120);


            // Usuarios.UsuarioPersona.EstadoPersona.ProhibidoBeneficiarios = false
            negation = new SQLWhereNegation(sql);
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA + "." + PersonaConstants.ROLE_NAME_ESTADOPERSONA + "." + EstadoPersonaConstants.ATTR_NAME_ESTADOPERSONAPROHIBIDOBENEFICIARIOS, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName()));
                    negation.addOperand(comparison2);

            conjunction.addOperand(negation);
            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator119, Method: assocOperator119Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator120
	@Override
    public Boolean assocOperator120(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios.UsuarioPersona.EstadoPersona)
            return assocOperator120Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator120, Method: assocOperator120";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator120
	@Override
    public Boolean assocOperator120Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator120Range1Query(instance, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator120
	@Override
    public SQLExists assocOperator120Range1Query (Solicitud instance, SQLSelect superQuery) throws SystemException {
        try {
            // Path starts with a class in the subquery
            return new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA + "." + PersonaConstants.ROLE_NAME_ESTADOPERSONA);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator120, Method: assocOperator120Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator121
	@Override
    public Boolean assocOperator121(Solicitud instance, Solicitud solicitudvalidarAtributosUsuariopthisSolicitud) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (Usuarios.BebeGestante = true AND Usuarios.UsuarioPersona.drvVieneDeCORE = false)(Usuarios.UsuarioPersona.FechaNacimiento <= pthisSolicitud.Aesolicitudes.Fechaasignacion)
            for(Usuario item : assocOperator121Range1(instance, solicitudvalidarAtributosUsuariopthisSolicitud)){
                // Usuarios.UsuarioPersona.drvVieneDeCORE = false
                boolean whereConditionsMet = item.getUsuarioPersona().getPersonadrvVieneDeCORE().equals(false);
                if (whereConditionsMet) {
                    // TODO: REVIEW
                    continue;
                }
                return false;  // TODO: REVIEW
            }
            return true;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator121, Method: assocOperator121";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator121
	@Override
    public Collection<Usuario> assocOperator121Range1 (Solicitud instance, Solicitud solicitudvalidarAtributosUsuariopthisSolicitud) throws SystemException {

        SQLSelect sql = assocOperator121Range1Query(instance, solicitudvalidarAtributosUsuariopthisSolicitud);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator121
	@Override
    public SQLPopulation assocOperator121Range1Query (Solicitud instance, Solicitud solicitudvalidarAtributosUsuariopthisSolicitud) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();
            SQLWhereNegation negation = null;

            // Usuarios.BebeGestante = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIOBEBEGESTANTE, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);


            // Usuarios.UsuarioPersona.FechaNacimiento <= pthisSolicitud.Aesolicitudes.Fechaasignacion
            negation = new SQLWhereNegation(sql);
                    // '<=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA + "." + PersonaConstants.ATTR_NAME_PERSONAFECHANACIMIENTO, Constants.Type.DATE.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(solicitudvalidarAtributosUsuariopthisSolicitud.getAesolicitudes().getAesolicitudesFechaasignacion(), Constants.Type.DATE.getTypeName()));
                    negation.addOperand(comparison2);

            conjunction.addOperand(negation);
            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator121, Method: assocOperator121Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator122
	@Override
    public Boolean assocOperator122(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.Parentesco.EsPadre = true)
            return assocOperator122Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator122, Method: assocOperator122";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator122
	@Override
    public Boolean assocOperator122Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator122Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator122
	@Override
    public SQLExists assocOperator122Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco.EsPadre = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESPADRE, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator122, Method: assocOperator122Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator123
	@Override
    public Boolean assocOperator123(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (Usuarios.Parentesco.EsPadre = true)(Usuarios.drvEdad - drvEdadTitular > 10)
            for(Usuario item : assocOperator123Range1(instance)){
                // Usuarios.drvEdad - drvEdadTitular > 10
                boolean conditionsMet = item.getUsuariodrvEdad() - instance.getSolicituddrvEdadTitular() > Long.valueOf(10);
                if (!conditionsMet) return false;
            }
            return true;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator123, Method: assocOperator123";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator123
	@Override
    public Collection<Usuario> assocOperator123Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator123Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator123
	@Override
    public SQLPopulation assocOperator123Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco.EsPadre = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESPADRE, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator123, Method: assocOperator123Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator124
	@Override
    public Boolean assocOperator124(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.Parentesco.EsHijo = true)
            return assocOperator124Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator124, Method: assocOperator124";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator124
	@Override
    public Boolean assocOperator124Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator124Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator124
	@Override
    public SQLExists assocOperator124Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco.EsHijo = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESHIJO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator124, Method: assocOperator124Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator125
	@Override
    public Boolean assocOperator125(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (Usuarios.Parentesco.EsHijo = true)(drvEdadTitular - Usuarios.drvEdad > 10)
            for(Usuario item : assocOperator125Range1(instance)){
                // drvEdadTitular - Usuarios.drvEdad > 10
                boolean conditionsMet = instance.getSolicituddrvEdadTitular() - item.getUsuariodrvEdad() > Long.valueOf(10);
                if (!conditionsMet) return false;
            }
            return true;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator125, Method: assocOperator125";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator125
	@Override
    public Collection<Usuario> assocOperator125Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator125Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator125
	@Override
    public SQLPopulation assocOperator125Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco.EsHijo = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESHIJO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator125, Method: assocOperator125Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator126
	@Override
    public Boolean assocOperator126(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.Parentesco.EsConyuge = true)
            return assocOperator126Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator126, Method: assocOperator126";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator126
	@Override
    public Boolean assocOperator126Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator126Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator126
	@Override
    public SQLExists assocOperator126Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco.EsConyuge = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESCONYUGE, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator126, Method: assocOperator126Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator127
	@Override
    public Boolean assocOperator127(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (Usuarios.Parentesco.EsConyuge = true)(Usuarios.UsuarioPersona.Genero <> drvGeneroTitular)
            return assocOperator127Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator127, Method: assocOperator127";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator127
	@Override
    public Boolean assocOperator127Range1 (Solicitud instance) throws SystemException {
        SQLSelect sql = assocOperator127Range1Query(instance);
        return new TypedQueryBuilder<Long>(em, Long.class).build(sql).getSingleResult() == 0;
    }

    // Range Query 1 for AssocOperator AssocOperator127
	@Override
    public SQLForAllCondition assocOperator127Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLForAllCondition sql = new SQLForAllCondition(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();
            SQLWhereNegation negation = null;

            // Usuarios.Parentesco.EsConyuge = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESCONYUGE, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);


            // Usuarios.UsuarioPersona.Genero <> drvGeneroTitular
            negation = new SQLWhereNegation(sql);
                    // '<>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA + "." + PersonaConstants.ATTR_NAME_PERSONAGENERO, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(instance.getSolicituddrvGeneroTitular(), Constants.Type.STRING.getTypeName()));
                    negation.addOperand(comparison2);

            conjunction.addOperand(negation);
            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator127, Method: assocOperator127Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator128
	@Override
    public Boolean assocOperator128(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.Parentesco.EsConyuge = true)
            return assocOperator128Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator128, Method: assocOperator128";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator128
	@Override
    public Boolean assocOperator128Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator128Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator128
	@Override
    public SQLExists assocOperator128Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco.EsConyuge = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESCONYUGE, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator128, Method: assocOperator128Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator129
	@Override
    public Boolean assocOperator129(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (Usuarios.Parentesco.EsConyuge = true)(Usuarios.drvEdad >= 13)
            for(Usuario item : assocOperator129Range1(instance)){
                // Usuarios.drvEdad >= 13
                boolean conditionsMet = item.getUsuariodrvEdad() >= Long.valueOf(13);
                if (!conditionsMet) return false;
            }
            return true;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator129, Method: assocOperator129";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator129
	@Override
    public Collection<Usuario> assocOperator129Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator129Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator129
	@Override
    public SQLPopulation assocOperator129Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco.EsConyuge = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESCONYUGE, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator129, Method: assocOperator129Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator130
	@Override
    public Long assocOperator130(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.Parentesco.EsConyuge = true AND Usuarios.drvEstaActivo = true)
            long count = 0L;
            for(Usuario item : assocOperator130Range1(instance)){
                // Usuarios.drvEstaActivo = true
                if(item.getUsuariodrvEstaActivo().equals(true))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator130, Method: assocOperator130";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator130
	@Override
    public Collection<Usuario> assocOperator130Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator130Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator130
	@Override
    public SQLPopulation assocOperator130Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco.EsConyuge = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESCONYUGE, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator130, Method: assocOperator130Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator131
	@Override
    public Long assocOperator131(Solicitud instance) throws SystemException {
        try {
            // COUNT (UsuariosRegistrados) WHERE (UsuariosRegistrados.Parentesco.EsConyuge = true AND UsuariosRegistrados.EstadoBeneficiario.EsActivo = true)
            return assocOperator131Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator131, Method: assocOperator131";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator131
	@Override
    public Long assocOperator131Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator131Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator131
	@Override
    public SQLCount assocOperator131Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.Parentesco.EsConyuge = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESCONYUGE, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);


            // UsuariosRegistrados.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator131, Method: assocOperator131Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator132
	@Override
    public Boolean assocOperator132(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.Parentesco.EsConyuge = true)
            return assocOperator132Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator132, Method: assocOperator132";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator132
	@Override
    public Boolean assocOperator132Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator132Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator132
	@Override
    public SQLExists assocOperator132Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco.EsConyuge = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESCONYUGE, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator132, Method: assocOperator132Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator133
	@Override
    public Long assocOperator133(Solicitud instance) throws SystemException {
        try {
            // COUNT (UsuariosRegistrados) WHERE (UsuariosRegistrados.Parentesco.EsConyuge = true AND UsuariosRegistrados.EstadoBeneficiario.EsActivo = false AND UsuariosRegistrados.FechaFinVigencia >= FInicioContrato)
            return assocOperator133Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator133, Method: assocOperator133";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator133
	@Override
    public Long assocOperator133Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator133Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator133
	@Override
    public SQLCount assocOperator133Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.Parentesco.EsConyuge = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESCONYUGE, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);


            // UsuariosRegistrados.EstadoBeneficiario.EsActivo = false
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);


            // UsuariosRegistrados.FechaFinVigencia >= FInicioContrato
                    // '>=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator(">=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ATTR_NAME_USUARIOREGFECHAFINVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getSolicitudFInicioContrato()!= null){
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(instance.getSolicitudFInicioContrato(), Constants.Type.DATE.getTypeName()));
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator133, Method: assocOperator133Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator134
	@Override
    public Boolean assocOperator134(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (Usuarios.FechaAntiguedadBeneficiario <> NULL)(Usuarios.FechaAntiguedadBeneficiario <= FInicioContrato)
            return assocOperator134Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator134, Method: assocOperator134";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator134
	@Override
    public Boolean assocOperator134Range1 (Solicitud instance) throws SystemException {
        SQLSelect sql = assocOperator134Range1Query(instance);
        return new TypedQueryBuilder<Long>(em, Long.class).build(sql).getSingleResult() == 0;
    }

    // Range Query 1 for AssocOperator AssocOperator134
	@Override
    public SQLForAllCondition assocOperator134Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLForAllCondition sql = new SQLForAllCondition(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();
            SQLWhereNegation negation = null;

            // Usuarios.FechaAntiguedadBeneficiario <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIOFECHAANTIGUEDADBENEFICIARIO, Constants.Type.DATE.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison1);


            // Usuarios.FechaAntiguedadBeneficiario <= FInicioContrato
            negation = new SQLWhereNegation(sql);
                    // '<=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIOFECHAANTIGUEDADBENEFICIARIO, Constants.Type.DATE.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    if (instance.getSolicitudFInicioContrato()!= null){
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(instance.getSolicitudFInicioContrato(), Constants.Type.DATE.getTypeName()));
                    } else {
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    }
                    negation.addOperand(comparison2);

            conjunction.addOperand(negation);
            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator134, Method: assocOperator134Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator135
	@Override
    public Boolean assocOperator135(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (Usuarios.FechaAntiguedadBeneficiario <> NULL)(EXIST (Usuarios.Companyia) = true)
            return assocOperator135Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator135, Method: assocOperator135";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator135
	@Override
    public Boolean assocOperator135Range1 (Solicitud instance) throws SystemException {
        SQLSelect sql = assocOperator135Range1Query(instance);
        return new TypedQueryBuilder<Long>(em, Long.class).build(sql).getSingleResult() == 0;
    }

    // Range Query 1 for AssocOperator AssocOperator135
	@Override
    public SQLForAllCondition assocOperator135Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLForAllCondition sql = new SQLForAllCondition(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();
            SQLWhereNegation negation = null;

            // Usuarios.FechaAntiguedadBeneficiario <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIOFECHAANTIGUEDADBENEFICIARIO, Constants.Type.DATE.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison1);


            // EXIST (Usuarios.Companyia) = true
            negation = new SQLWhereNegation(sql);
                // 'exist' Association operator
                SQLWhereOperandSubQuery operandSubQueryAssocOperator136 = new SQLWhereOperandSubQuery(assocOperator136Range1Query(instance, sql));
                negation.addOperand(operandSubQueryAssocOperator136);

            conjunction.addOperand(negation);
            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator135, Method: assocOperator135Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator136
	@Override
    public Boolean assocOperator136(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios.Companyia)
            return assocOperator136Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator136, Method: assocOperator136";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator136
	@Override
    public Boolean assocOperator136Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator136Range1Query(instance, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator136
	@Override
    public SQLExists assocOperator136Range1Query (Solicitud instance, SQLSelect superQuery) throws SystemException {
        try {
            // Path starts with a class in the subquery
            return new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_COMPANYIA);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator136, Method: assocOperator136Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator137
	@Override
    public Boolean assocOperator137(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios(EXIST (Usuarios.UsuarioPersona.Direcciones) WHERE (Usuarios.UsuarioPersona.Direcciones.TipoDireccion.EsResidencia = true) = true)
            return assocOperator137Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator137, Method: assocOperator137";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator137
	@Override
    public Boolean assocOperator137Range1 (Solicitud instance) throws SystemException {
        SQLSelect sql = assocOperator137Range1Query(instance);
        return new TypedQueryBuilder<Long>(em, Long.class).build(sql).getSingleResult() == 0;
    }

    // Range Query 1 for AssocOperator AssocOperator137
	@Override
    public SQLForAllCondition assocOperator137Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLForAllCondition sql = new SQLForAllCondition(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();
            SQLWhereNegation negation = null;

            // EXIST (Usuarios.UsuarioPersona.Direcciones) WHERE (Usuarios.UsuarioPersona.Direcciones.TipoDireccion.EsResidencia = true) = true
            negation = new SQLWhereNegation(sql);
                // 'exist' Association operator
                SQLWhereOperandSubQuery operandSubQueryAssocOperator138 = new SQLWhereOperandSubQuery(assocOperator138Range1Query(instance, sql));
                negation.addOperand(operandSubQueryAssocOperator138);

            conjunction.addOperand(negation);
            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator137, Method: assocOperator137Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator138
	@Override
    public Boolean assocOperator138(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios.UsuarioPersona.Direcciones) WHERE (Usuarios.UsuarioPersona.Direcciones.TipoDireccion.EsResidencia = true)
            return assocOperator138Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator138, Method: assocOperator138";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator138
	@Override
    public Boolean assocOperator138Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator138Range1Query(instance, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator138
	@Override
    public SQLExists assocOperator138Range1Query (Solicitud instance, SQLSelect superQuery) throws SystemException {
        try {
            // Path starts with a class in the subquery
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA + "." + PersonaConstants.ROLE_NAME_DIRECCIONES);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.UsuarioPersona.Direcciones.TipoDireccion.EsResidencia = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA + "." + PersonaConstants.ROLE_NAME_DIRECCIONES + "." + DireccionConstants.ROLE_NAME_TIPODIRECCION + "." + TipoDireccionConstants.ATTR_NAME_TIPODIRECCIONESRESIDENCIA, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator138, Method: assocOperator138Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator139
	@Override
    public Boolean assocOperator139(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios(Usuarios.drvEdad <= Usuarios.drvEdadMaxIngreso)
            for(Usuario item : assocOperator139Range1(instance)){
                // Usuarios.drvEdad <= Usuarios.drvEdadMaxIngreso
                boolean conditionsMet = item.getUsuariodrvEdad() <= item.getUsuariodrvEdadMaxIngreso();
                if (!conditionsMet) return false;
            }
            return true;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator139, Method: assocOperator139";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator139
	@Override
    public Collection<Usuario> assocOperator139Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator139Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator139
	@Override
    public SQLPopulation assocOperator139Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator139, Method: assocOperator139Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator140
	@Override
    public Boolean assocOperator140(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios(Usuarios.drvEdad <= Usuarios.drvEdadMaxPerm)
            for(Usuario item : assocOperator140Range1(instance)){
                // Usuarios.drvEdad <= Usuarios.drvEdadMaxPerm
                boolean conditionsMet = item.getUsuariodrvEdad() <= item.getUsuariodrvEdadMaxPerm();
                if (!conditionsMet) return false;
            }
            return true;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator140, Method: assocOperator140";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator140
	@Override
    public Collection<Usuario> assocOperator140Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator140Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator140
	@Override
    public SQLPopulation assocOperator140Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator140, Method: assocOperator140Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator141
	@Override
    public Long assocOperator141(Solicitud instance, Solicitud solicitudvalidarAtributosUsuariopthisSolicitud) throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.BebeGestante = true AND Usuarios.UsuarioPersona.drvVieneDeCORE = false AND (Usuarios.TipoIdentificacion.NombreCorto = "MS" OR Usuarios.TipoIdentificacion.NombreCorto = "RC") AND Usuarios.FechaAntiguedadBeneficiario = NULL AND Usuarios.UsuarioPersona.FechaNacimiento <> pthisSolicitud.Aesolicitudes.Fechaasignacion)
            long count = 0L;
            for(Usuario item : assocOperator141Range1(instance, solicitudvalidarAtributosUsuariopthisSolicitud)){
                // Usuarios.UsuarioPersona.drvVieneDeCORE = false
                if(item.getUsuarioPersona().getPersonadrvVieneDeCORE().equals(false))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator141, Method: assocOperator141";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator141
	@Override
    public Collection<Usuario> assocOperator141Range1 (Solicitud instance, Solicitud solicitudvalidarAtributosUsuariopthisSolicitud) throws SystemException {

        SQLSelect sql = assocOperator141Range1Query(instance, solicitudvalidarAtributosUsuariopthisSolicitud);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator141
	@Override
    public SQLPopulation assocOperator141Range1Query (Solicitud instance, Solicitud solicitudvalidarAtributosUsuariopthisSolicitud) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.BebeGestante = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIOBEBEGESTANTE, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);


            // (Usuarios.TipoIdentificacion.NombreCorto = "MS" OR Usuarios.TipoIdentificacion.NombreCorto = "RC")
                {
                    // 'or' Logical operator
                    SQLWhereDisjunction comparison2 = new SQLWhereDisjunction();
                
                    // Operand 1
                        // '=' Comparison
                        SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                        comparison3.setOperator("=");
                        
                        // Operand 1
                        SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION + "." + TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONNOMBRECORTO, Constants.Type.STRING.getTypeName());
                        comparison3.setFirstOperand(operand114);
                        
                        // Operand 2
                        comparison3.setSecondOperand(new SQLWhereOperandLiteral("MS", Constants.Type.STRING.getTypeName()));
                        comparison2.addOperand(comparison3);
                
                    // Operand 2
                        // '=' Comparison
                        SQLWhereComparison comparison5 = new SQLWhereComparison(sql);
                        comparison5.setOperator("=");
                        
                        // Operand 1
                        SQLWhereOperandPathAttribute operand116 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION + "." + TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONNOMBRECORTO, Constants.Type.STRING.getTypeName());
                        comparison5.setFirstOperand(operand116);
                        
                        // Operand 2
                        comparison5.setSecondOperand(new SQLWhereOperandLiteral("RC", Constants.Type.STRING.getTypeName()));
                        comparison2.addOperand(comparison5);
                    
                    conjunction.addOperand(comparison2);
                }


            // Usuarios.FechaAntiguedadBeneficiario = NULL
                    // '=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIOFECHAANTIGUEDADBENEFICIARIO, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison3);


            // Usuarios.UsuarioPersona.FechaNacimiento <> pthisSolicitud.Aesolicitudes.Fechaasignacion
                    // '<>' Comparison
                    SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
                    comparison4.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA + "." + PersonaConstants.ATTR_NAME_PERSONAFECHANACIMIENTO, Constants.Type.DATE.getTypeName());
                    comparison4.setFirstOperand(operand115);
                    
                    // Operand 2
                    comparison4.setSecondOperand(new SQLWhereOperandLiteral(solicitudvalidarAtributosUsuariopthisSolicitud.getAesolicitudes().getAesolicitudesFechaasignacion(), Constants.Type.DATE.getTypeName()));
                    conjunction.addOperand(comparison4);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator141, Method: assocOperator141Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator142
	@Override
    public Boolean assocOperator142(Solicitud instance) throws SystemException {
        try {
            // EXIST (Contratante.DepartamentoRes)
            return assocOperator142Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator142, Method: assocOperator142";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator142
	@Override
    public Boolean assocOperator142Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator142Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator142
	@Override
    public SQLExists assocOperator142Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATANTE + "." + ContratanteConstants.ROLE_NAME_DEPARTAMENTORES, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator142, Method: assocOperator142Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator143
	@Override
    public Boolean assocOperator143(Solicitud instance) throws SystemException {
        try {
            // EXIST (Contratante.MunicipioRes)
            return assocOperator143Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator143, Method: assocOperator143";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator143
	@Override
    public Boolean assocOperator143Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator143Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator143
	@Override
    public SQLExists assocOperator143Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATANTE + "." + ContratanteConstants.ROLE_NAME_MUNICIPIORES, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator143, Method: assocOperator143Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator144
	@Override
    public Long assocOperator144(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios)
            return assocOperator144Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator144, Method: assocOperator144";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator144
	@Override
    public Long assocOperator144Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator144Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator144
	@Override
    public SQLCount assocOperator144Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator144, Method: assocOperator144Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator145
	@Override
    public Long assocOperator145(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios.Eps)
            return assocOperator145Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator145, Method: assocOperator145";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator145
	@Override
    public Long assocOperator145Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator145Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator145
	@Override
    public SQLCount assocOperator145Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_EPS, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator145, Method: assocOperator145Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator146
	@Override
    public Long assocOperator146(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios)
            return assocOperator146Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator146, Method: assocOperator146";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator146
	@Override
    public Long assocOperator146Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator146Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator146
	@Override
    public SQLCount assocOperator146Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator146, Method: assocOperator146Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator147
	@Override
    public Long assocOperator147(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios.Parentesco)
            return assocOperator147Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator147, Method: assocOperator147";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator147
	@Override
    public Long assocOperator147Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator147Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator147
	@Override
    public SQLCount assocOperator147Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator147, Method: assocOperator147Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator148
	@Override
    public Long assocOperator148(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.BebeGestante = true AND Usuarios.TipoIdentificacion.MenorSinIdentificar = false)
            return assocOperator148Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator148, Method: assocOperator148";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator148
	@Override
    public Long assocOperator148Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator148Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator148
	@Override
    public SQLCount assocOperator148Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.BebeGestante = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIOBEBEGESTANTE, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);


            // Usuarios.TipoIdentificacion.MenorSinIdentificar = false
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION + "." + TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONMENORSINIDENTIFICAR, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator148, Method: assocOperator148Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator149
	@Override
    public Long assocOperator149(Solicitud instance, Long solicitudTGETPLANTILLAREPORTEptTipo) throws SystemException {
        try {
            // COUNT (Aesolicitudes.ProductoT.Dominios.ReportesDominio) WHERE (Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = ptTipo AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici)
            long count = 0L;
            for(ReportesDominio item : assocOperator149Range1(instance, solicitudTGETPLANTILLAREPORTEptTipo)){
                // Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAesolicitudes().getAesolicitudesFesolici()))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator149, Method: assocOperator149";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator149
	@Override
    public Collection<ReportesDominio> assocOperator149Range1 (Solicitud instance, Long solicitudTGETPLANTILLAREPORTEptTipo) throws SystemException {

        SQLSelect sql = assocOperator149Range1Query(instance, solicitudTGETPLANTILLAREPORTEptTipo);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator149
	@Override
    public SQLPopulation assocOperator149Range1Query (Solicitud instance, Long solicitudTGETPLANTILLAREPORTEptTipo) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = ptTipo
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(solicitudTGETPLANTILLAREPORTEptTipo, Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison2);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().getAesolicitudesFesolici()!= null){
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(instance.getAesolicitudes().getAesolicitudesFesolici(), Constants.Type.DATE.getTypeName()));
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator149, Method: assocOperator149Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator150
	@Override
    public Long assocOperator150(Solicitud instance) throws SystemException {
        try {
            // COUNT (Aesolicitudes.PlanT.Dominios) WHERE (Aesolicitudes.PlanT.Dominios.ProductoT = Aesolicitudes.ProductoT AND Aesolicitudes.PlanT.Dominios.DiaIniVigencia <> NULL AND Aesolicitudes.PlanT.Dominios.DiaFinVigencia <> NULL)
            return assocOperator150Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator150, Method: assocOperator150";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator150
	@Override
    public Long assocOperator150Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator150Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator150
	@Override
    public SQLCount assocOperator150Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.PlanT.Dominios.ProductoT = Aesolicitudes.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getAesolicitudes().getProductoT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.PlanT.Dominios.DiaIniVigencia <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIODIAINIVIGENCIA, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison2);


            // Aesolicitudes.PlanT.Dominios.DiaFinVigencia <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIODIAFINVIGENCIA, Constants.Type.NAT.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator150, Method: assocOperator150Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator151
	@Override
    public Boolean assocOperator151(Solicitud instance) throws SystemException {
        try {
            // EXIST (FormaPago)
            return assocOperator151Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator151, Method: assocOperator151";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator151
	@Override
    public Boolean assocOperator151Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator151Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator151
	@Override
    public SQLExists assocOperator151Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_FORMAPAGO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator151, Method: assocOperator151Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator152
	@Override
    public Long assocOperator152(Solicitud instance) throws SystemException {
        try {
            // COUNT (ErroresWS)
            return assocOperator152Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator152, Method: assocOperator152";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator152
	@Override
    public Long assocOperator152Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator152Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator152
	@Override
    public SQLCount assocOperator152Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_ERRORESWS, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator152, Method: assocOperator152Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator154
	@Override
    public Boolean assocOperator154(Solicitud instance) throws SystemException {
        try {
            // EXIST (ProteccionDatos)
            return assocOperator154Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator154, Method: assocOperator154";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator154
	@Override
    public Boolean assocOperator154Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator154Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator154
	@Override
    public SQLExists assocOperator154Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_PROTECCIONDATOS, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator154, Method: assocOperator154Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator156
	@Override
    public Boolean assocOperator156(Solicitud instance) throws SystemException {
        try {
            // EXIST (Direccion)
            return assocOperator156Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator156, Method: assocOperator156";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator156
	@Override
    public Boolean assocOperator156Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator156Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator156
	@Override
    public SQLExists assocOperator156Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_DIRECCION, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator156, Method: assocOperator156Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator158
	@Override
    public Collection<Direccion> assocOperator158(Persona solicitudTCREAROMODCONTRATANTEptPersonaContratante) throws SystemException {
        try {
            // FOR ALL ptPersonaContratante.Direcciones WHERE (ptPersonaContratante.Direcciones.TipoDireccion = fugetTipoDirResidencial()) DO Contratante.TSETDIRECCIONRES(Contratante, ptPersonaContratante.Direcciones.DireccionCompleta, ptPersonaContratante.Direcciones.Departamento, ptPersonaContratante.Direcciones.Municipio, ptPersonaContratante.Direcciones.Rural)
        return assocOperator158Range1(solicitudTCREAROMODCONTRATANTEptPersonaContratante);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator158, Method: assocOperator158";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator158
	@Override
    public Collection<Direccion> assocOperator158Range1 (Persona solicitudTCREAROMODCONTRATANTEptPersonaContratante) throws SystemException {

        SQLSelect sql = assocOperator158Range1Query(solicitudTCREAROMODCONTRATANTEptPersonaContratante);
        return new TypedQueryBuilder<Direccion>(em, Direccion.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator158
	@Override
    public SQLPopulation assocOperator158Range1Query (Persona solicitudTCREAROMODCONTRATANTEptPersonaContratante) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, DireccionConstants.CLASS_NAME, SolicitudConstants.ARG_NAME_TCREAROMODCONTRATANTE_SOLICITUDTCREAROMODCONTRATANTEPTPERSONACONTRATANTE + "." + PersonaConstants.ROLE_NAME_DIRECCIONES, solicitudTCREAROMODCONTRATANTEptPersonaContratante.getOid(), SolicitudConstants.ARG_NAME_TCREAROMODCONTRATANTE_SOLICITUDTCREAROMODCONTRATANTEPTPERSONACONTRATANTE);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ptPersonaContratante.Direcciones.TipoDireccion = fugetTipoDirResidencial()
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameter operand112 = new SQLWhereOperandOVParameter(SolicitudConstants.ARG_NAME_TCREAROMODCONTRATANTE_SOLICITUDTCREAROMODCONTRATANTEPTPERSONACONTRATANTE + "." + PersonaConstants.ROLE_NAME_DIRECCIONES + "." + DireccionConstants.ROLE_NAME_TIPODIRECCION, PersonaConstants.CLASS_NAME, TipoDireccionConstants.CLASS_NAME, solicitudTCREAROMODCONTRATANTEptPersonaContratante.getOid(), SolicitudConstants.ARG_NAME_TCREAROMODCONTRATANTE_SOLICITUDTCREAROMODCONTRATANTEPTPERSONACONTRATANTE);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (userFunctionsSrv.fugetTipoDirResidencialFun() == null ||
                        userFunctionsSrv.fugetTipoDirResidencialFun().isNull())
                    {
                        SQLWhereOperandNull operand = new SQLWhereOperandNull();
                    comparison1.setSecondOperand(operand);
                    } else {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.UF_NAME_FUGETTIPODIRRESIDENCIAL, TipoDireccionConstants.CLASS_NAME, TipoDireccionConstants.CLASS_NAME, userFunctionsSrv.fugetTipoDirResidencialFun().getOid(), Constants.UF_NAME_FUGETTIPODIRRESIDENCIAL);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator158, Method: assocOperator158Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator159
	@Override
    public Collection<Direccion> assocOperator159(Persona solicitudTCREAROMODCONTRATANTEptPersonaContratante) throws SystemException {
        try {
            // FOR ALL ptPersonaContratante.Direcciones WHERE (ptPersonaContratante.Direcciones.TipoDireccion = fugetTipoDirCorrespondencia()) DO Contratante.TSETDIRECCIONRES(Contratante, ptPersonaContratante.Direcciones.DireccionCompleta, ptPersonaContratante.Direcciones.Departamento, ptPersonaContratante.Direcciones.Municipio, ptPersonaContratante.Direcciones.Rural)
        return assocOperator159Range1(solicitudTCREAROMODCONTRATANTEptPersonaContratante);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator159, Method: assocOperator159";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator159
	@Override
    public Collection<Direccion> assocOperator159Range1 (Persona solicitudTCREAROMODCONTRATANTEptPersonaContratante) throws SystemException {

        SQLSelect sql = assocOperator159Range1Query(solicitudTCREAROMODCONTRATANTEptPersonaContratante);
        return new TypedQueryBuilder<Direccion>(em, Direccion.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator159
	@Override
    public SQLPopulation assocOperator159Range1Query (Persona solicitudTCREAROMODCONTRATANTEptPersonaContratante) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, DireccionConstants.CLASS_NAME, SolicitudConstants.ARG_NAME_TCREAROMODCONTRATANTE_SOLICITUDTCREAROMODCONTRATANTEPTPERSONACONTRATANTE + "." + PersonaConstants.ROLE_NAME_DIRECCIONES, solicitudTCREAROMODCONTRATANTEptPersonaContratante.getOid(), SolicitudConstants.ARG_NAME_TCREAROMODCONTRATANTE_SOLICITUDTCREAROMODCONTRATANTEPTPERSONACONTRATANTE);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ptPersonaContratante.Direcciones.TipoDireccion = fugetTipoDirCorrespondencia()
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameter operand112 = new SQLWhereOperandOVParameter(SolicitudConstants.ARG_NAME_TCREAROMODCONTRATANTE_SOLICITUDTCREAROMODCONTRATANTEPTPERSONACONTRATANTE + "." + PersonaConstants.ROLE_NAME_DIRECCIONES + "." + DireccionConstants.ROLE_NAME_TIPODIRECCION, PersonaConstants.CLASS_NAME, TipoDireccionConstants.CLASS_NAME, solicitudTCREAROMODCONTRATANTEptPersonaContratante.getOid(), SolicitudConstants.ARG_NAME_TCREAROMODCONTRATANTE_SOLICITUDTCREAROMODCONTRATANTEPTPERSONACONTRATANTE);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (userFunctionsSrv.fugetTipoDirCorrespondenciaFun() == null ||
                        userFunctionsSrv.fugetTipoDirCorrespondenciaFun().isNull())
                    {
                        SQLWhereOperandNull operand = new SQLWhereOperandNull();
                    comparison1.setSecondOperand(operand);
                    } else {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.UF_NAME_FUGETTIPODIRCORRESPONDENCIA, TipoDireccionConstants.CLASS_NAME, TipoDireccionConstants.CLASS_NAME, userFunctionsSrv.fugetTipoDirCorrespondenciaFun().getOid(), Constants.UF_NAME_FUGETTIPODIRCORRESPONDENCIA);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator159, Method: assocOperator159Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator160
	@Override
    public Boolean assocOperator160(Solicitud instance) throws SystemException {
        try {
            // EXIST (Contratante)
            return assocOperator160Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator160, Method: assocOperator160";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator160
	@Override
    public Boolean assocOperator160Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator160Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator160
	@Override
    public SQLExists assocOperator160Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATANTE, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator160, Method: assocOperator160Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator161
	@Override
    public Boolean assocOperator161(Solicitud instance) throws SystemException {
        try {
            // EXIST (Periodicidad)
            return assocOperator161Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator161, Method: assocOperator161";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator161
	@Override
    public Boolean assocOperator161Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator161Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator161
	@Override
    public SQLExists assocOperator161Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_PERIODICIDAD, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator161, Method: assocOperator161Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator163
	@Override
    public Boolean assocOperator163(Solicitud instance) throws SystemException {
        try {
            // EXIST (FormaPago)
            return assocOperator163Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator163, Method: assocOperator163";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator163
	@Override
    public Boolean assocOperator163Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator163Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator163
	@Override
    public SQLExists assocOperator163Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_FORMAPAGO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator163, Method: assocOperator163Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator165
	@Override
    public Boolean assocOperator165(Solicitud instance) throws SystemException {
        try {
            // EXIST (Periodicidad)
            return assocOperator165Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator165, Method: assocOperator165";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator165
	@Override
    public Boolean assocOperator165Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator165Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator165
	@Override
    public SQLExists assocOperator165Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_PERIODICIDAD, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator165, Method: assocOperator165Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator166
	@Override
    public Boolean assocOperator166(Solicitud instance) throws SystemException {
        try {
            // EXIST (FormaPago)
            return assocOperator166Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator166, Method: assocOperator166";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator166
	@Override
    public Boolean assocOperator166Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator166Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator166
	@Override
    public SQLExists assocOperator166Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_FORMAPAGO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator166, Method: assocOperator166Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator168
	@Override
    public Boolean assocOperator168(Solicitud instance) throws SystemException {
        try {
            // EXIST (Firma)
            return assocOperator168Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator168, Method: assocOperator168";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator168
	@Override
    public Boolean assocOperator168Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator168Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator168
	@Override
    public SQLExists assocOperator168Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_FIRMA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator168, Method: assocOperator168Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator170
	@Override
    public Collection<Direccion> assocOperator170(Solicitud instance) throws SystemException {
        try {
            // FOR ALL TitularPersona.Direcciones WHERE (TitularPersona.Direcciones.TipoDireccion.EsResidencia = true) DO Titular.TCREAROMODDIRECCION(Titular, TitularPersona.Direcciones.TipoDireccion, TitularPersona.Direcciones.Pais, TitularPersona.Direcciones.Departamento, TitularPersona.Direcciones.Municipio, TitularPersona.Direcciones.DireccionCompleta, TitularPersona.Direcciones.Rural)
        return assocOperator170Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator170, Method: assocOperator170";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator170
	@Override
    public Collection<Direccion> assocOperator170Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator170Range1Query(instance);
        return new TypedQueryBuilder<Direccion>(em, Direccion.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator170
	@Override
    public SQLPopulation assocOperator170Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, DireccionConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_TITULARPERSONA + "." + PersonaConstants.ROLE_NAME_DIRECCIONES);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // TitularPersona.Direcciones.TipoDireccion.EsResidencia = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_TITULARPERSONA + "." + PersonaConstants.ROLE_NAME_DIRECCIONES + "." + DireccionConstants.ROLE_NAME_TIPODIRECCION + "." + TipoDireccionConstants.ATTR_NAME_TIPODIRECCIONESRESIDENCIA, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator170, Method: assocOperator170Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator171
	@Override
    public Boolean assocOperator171(Solicitud instance) throws SystemException {
        try {
            // EXIST (Titular)
            return assocOperator171Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator171, Method: assocOperator171";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator171
	@Override
    public Boolean assocOperator171Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator171Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator171
	@Override
    public SQLExists assocOperator171Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULAR, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator171, Method: assocOperator171Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator175
	@Override
    public Collection<BeneficiarioC> assocOperator175(Solicitud instance, Solicitud solicitudTNOTIFICARCREARpthisSolicitud) throws SystemException {
        try {
            // FOR ALL ContratoC.BeneficiariosC DO TUPDATEBENEFICIARIO(this, ContratoC.BeneficiariosC)
        return assocOperator175Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator175, Method: assocOperator175";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator175
	@Override
    public Collection<BeneficiarioC> assocOperator175Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator175Range1Query(instance);
        return new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator175
	@Override
    public SQLPopulation assocOperator175Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, BeneficiarioCConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ROLE_NAME_BENEFICIARIOSC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator175, Method: assocOperator175Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator176
	@Override
    public Boolean assocOperator176(Solicitud instance) throws SystemException {
        try {
            // EXIST (ContratoC)
            return assocOperator176Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator176, Method: assocOperator176";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator176
	@Override
    public Boolean assocOperator176Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator176Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator176
	@Override
    public SQLExists assocOperator176Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator176, Method: assocOperator176Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator177
	@Override
    public Boolean assocOperator177(Solicitud instance) throws SystemException {
        try {
            // EXIST (ContratoC.BeneficiariosC.PersonaC) WHERE (ContratoC.BeneficiariosC.PersonaC.drvEdad >= StrToInt(fugetValorParametroConf("EDADIMC")) AND ContratoC.BeneficiariosC.PersonaC.drvIMC > StrToInt(fugetValorParametroConf("MAXIMC")))
            for(PersonaC item : assocOperator177Range1(instance)){
                // ContratoC.BeneficiariosC.PersonaC.drvEdad >= StrToInt(fugetValorParametroConf("EDADIMC"))
                boolean conditionsMet = (item.getPersonaCdrvEdad() >= STDFunctions.strToIntFun(userFunctionsSrv.fugetValorParametroConfFun("EDADIMC")));
                // ContratoC.BeneficiariosC.PersonaC.drvIMC > StrToInt(fugetValorParametroConf("MAXIMC"))
                conditionsMet &= (item.getPersonaCdrvIMC() > Utilities.convertToDouble(Utilities.convertToDouble(STDFunctions.strToIntFun(userFunctionsSrv.fugetValorParametroConfFun("MAXIMC")))));
                if (conditionsMet) return true;
            }
            return false;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator177, Method: assocOperator177";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator177
	@Override
    public Collection<PersonaC> assocOperator177Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator177Range1Query(instance);
        return new TypedQueryBuilder<PersonaC>(em, PersonaC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator177
	@Override
    public SQLPopulation assocOperator177Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, PersonaCConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ROLE_NAME_BENEFICIARIOSC + "." + BeneficiarioCConstants.ROLE_NAME_PERSONAC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator177, Method: assocOperator177Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator178
	@Override
    public Boolean assocOperator178(Solicitud instance) throws SystemException {
        try {
            // EXIST (ContratoC.BeneficiariosC) WHERE (ContratoC.BeneficiariosC.TienePreexistencias = true)
            return assocOperator178Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator178, Method: assocOperator178";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator178
	@Override
    public Boolean assocOperator178Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator178Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator178
	@Override
    public SQLExists assocOperator178Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ROLE_NAME_BENEFICIARIOSC, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ContratoC.BeneficiariosC.TienePreexistencias = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ROLE_NAME_BENEFICIARIOSC + "." + BeneficiarioCConstants.ATTR_NAME_BENEFICIARIOCTIENEPREEXISTENCIAS, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator178, Method: assocOperator178Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator180
	@Override
    public Collection<BeneficiarioC> assocOperator180(Solicitud instance, BeneficiarioC solicitudTUPDATEBENEFICIARIOpBeneficiarioC) throws SystemException {
        try {
            // FOR ALL ContratoC.BeneficiariosC WHERE (ContratoC.BeneficiariosC = pBeneficiarioC) DO ContratoC.BeneficiariosC.TASGESTADOSINOTIENE(ContratoC.BeneficiariosC, fuGetEstadoPersonaError())
        return assocOperator180Range1(instance, solicitudTUPDATEBENEFICIARIOpBeneficiarioC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator180, Method: assocOperator180";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator180
	@Override
    public Collection<BeneficiarioC> assocOperator180Range1 (Solicitud instance, BeneficiarioC solicitudTUPDATEBENEFICIARIOpBeneficiarioC) throws SystemException {

        SQLSelect sql = assocOperator180Range1Query(instance, solicitudTUPDATEBENEFICIARIOpBeneficiarioC);
        return new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator180
	@Override
    public SQLPopulation assocOperator180Range1Query (Solicitud instance, BeneficiarioC solicitudTUPDATEBENEFICIARIOpBeneficiarioC) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, BeneficiarioCConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ROLE_NAME_BENEFICIARIOSC);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ContratoC.BeneficiariosC = pBeneficiarioC
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ROLE_NAME_BENEFICIARIOSC, BeneficiarioCConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ARG_NAME_TUPDATEBENEFICIARIO_SOLICITUDTUPDATEBENEFICIARIOPBENEFICIARIOC, BeneficiarioCConstants.CLASS_NAME, BeneficiarioCConstants.CLASS_NAME, solicitudTUPDATEBENEFICIARIOpBeneficiarioC.getOid(), SolicitudConstants.ARG_NAME_TUPDATEBENEFICIARIO_SOLICITUDTUPDATEBENEFICIARIOPBENEFICIARIOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator180, Method: assocOperator180Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator181
	@Override
    public Collection<Usuario> assocOperator181(Solicitud instance, BeneficiarioC solicitudTUPDATEBENEFICIARIOpBeneficiarioC) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (Usuarios.TipoIdentificacion.NombreCorto = pBeneficiarioC.PersonaC.TipoIdentificacionC.NombreCorto AND Usuarios.NumIdentificacion = pBeneficiarioC.PersonaC.NumIdentificacion) DO Usuarios.TACTDESDECORE(Usuarios, pBeneficiarioC)
        return assocOperator181Range1(instance, solicitudTUPDATEBENEFICIARIOpBeneficiarioC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator181, Method: assocOperator181";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator181
	@Override
    public Collection<Usuario> assocOperator181Range1 (Solicitud instance, BeneficiarioC solicitudTUPDATEBENEFICIARIOpBeneficiarioC) throws SystemException {

        SQLSelect sql = assocOperator181Range1Query(instance, solicitudTUPDATEBENEFICIARIOpBeneficiarioC);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator181
	@Override
    public SQLPopulation assocOperator181Range1Query (Solicitud instance, BeneficiarioC solicitudTUPDATEBENEFICIARIOpBeneficiarioC) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.TipoIdentificacion.NombreCorto = pBeneficiarioC.PersonaC.TipoIdentificacionC.NombreCorto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION + "." + TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONNOMBRECORTO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (solicitudTUPDATEBENEFICIARIOpBeneficiarioC.getPersonaC().getTipoIdentificacionC().getTipoIdentificacionNombreCorto()!= null){
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(solicitudTUPDATEBENEFICIARIOpBeneficiarioC.getPersonaC().getTipoIdentificacionC().getTipoIdentificacionNombreCorto(), Constants.Type.STRING.getTypeName()));
                    } else {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison1);


            // Usuarios.NumIdentificacion = pBeneficiarioC.PersonaC.NumIdentificacion
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIONUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    if (solicitudTUPDATEBENEFICIARIOpBeneficiarioC.getPersonaC().getPersonaCNumIdentificacion()!= null){
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(solicitudTUPDATEBENEFICIARIOpBeneficiarioC.getPersonaC().getPersonaCNumIdentificacion(), Constants.Type.STRING.getTypeName()));
                    } else {
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator181, Method: assocOperator181Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator182
	@Override
    public Boolean assocOperator182(BeneficiarioC solicitudTUPDATEBENEFICIARIOpBeneficiarioC) throws SystemException {
        try {
            // EXIST (pBeneficiarioC.EstadoBeneficiarioC)
            return assocOperator182Range1(solicitudTUPDATEBENEFICIARIOpBeneficiarioC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator182, Method: assocOperator182";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator182
	@Override
    public Boolean assocOperator182Range1 (BeneficiarioC solicitudTUPDATEBENEFICIARIOpBeneficiarioC) throws SystemException {
        SQLExists sql = assocOperator182Range1Query(solicitudTUPDATEBENEFICIARIOpBeneficiarioC, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator182
	@Override
    public SQLExists assocOperator182Range1Query (BeneficiarioC solicitudTUPDATEBENEFICIARIOpBeneficiarioC, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ARG_NAME_TUPDATEBENEFICIARIO_SOLICITUDTUPDATEBENEFICIARIOPBENEFICIARIOC + "." + BeneficiarioCConstants.ROLE_NAME_ESTADOBENEFICIARIOC, BeneficiarioCConstants.CLASS_NAME, solicitudTUPDATEBENEFICIARIOpBeneficiarioC.getOid(), SolicitudConstants.ARG_NAME_TUPDATEBENEFICIARIO_SOLICITUDTUPDATEBENEFICIARIOPBENEFICIARIOC);
            } else {
                sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ARG_NAME_TUPDATEBENEFICIARIO_SOLICITUDTUPDATEBENEFICIARIOPBENEFICIARIOC + "." + BeneficiarioCConstants.ROLE_NAME_ESTADOBENEFICIARIOC, BeneficiarioCConstants.CLASS_NAME, solicitudTUPDATEBENEFICIARIOpBeneficiarioC.getOid(), SolicitudConstants.ARG_NAME_TUPDATEBENEFICIARIO_SOLICITUDTUPDATEBENEFICIARIOPBENEFICIARIOC);
            }
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator182, Method: assocOperator182Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator185
	@Override
    public Collection<BeneficiarioC> assocOperator185(Solicitud instance, Solicitud solicitudTNOTIFICARINCLUSIONpthisSolicitud) throws SystemException {
        try {
            // FOR ALL ContratoC.BeneficiariosC DO TUPDATEBENEFICIARIO(this, ContratoC.BeneficiariosC)
        return assocOperator185Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator185, Method: assocOperator185";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator185
	@Override
    public Collection<BeneficiarioC> assocOperator185Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator185Range1Query(instance);
        return new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator185
	@Override
    public SQLPopulation assocOperator185Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, BeneficiarioCConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ROLE_NAME_BENEFICIARIOSC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator185, Method: assocOperator185Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator186
	@Override
    public Boolean assocOperator186(Solicitud instance) throws SystemException {
        try {
            // EXIST (ContratoC)
            return assocOperator186Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator186, Method: assocOperator186";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator186
	@Override
    public Boolean assocOperator186Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator186Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator186
	@Override
    public SQLExists assocOperator186Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator186, Method: assocOperator186Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator187
	@Override
    public Boolean assocOperator187(Solicitud instance) throws SystemException {
        try {
            // EXIST (ContratoC.BeneficiariosC) WHERE (ContratoC.BeneficiariosC.TienePreexistencias = true)
            return assocOperator187Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator187, Method: assocOperator187";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator187
	@Override
    public Boolean assocOperator187Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator187Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator187
	@Override
    public SQLExists assocOperator187Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ROLE_NAME_BENEFICIARIOSC, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ContratoC.BeneficiariosC.TienePreexistencias = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ROLE_NAME_BENEFICIARIOSC + "." + BeneficiarioCConstants.ATTR_NAME_BENEFICIARIOCTIENEPREEXISTENCIAS, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator187, Method: assocOperator187Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator188
	@Override
    public Collection<Usuario> assocOperator188(Solicitud instance, String solicitudTCREARDOCNUMIDSIEXISTEpNumIdentificacion) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (Usuarios.NumIdentificacion = pNumIdentificacion) DO Usuarios.TNOTIFICARDOCUMENTO(Usuarios, 1)
        return assocOperator188Range1(instance, solicitudTCREARDOCNUMIDSIEXISTEpNumIdentificacion);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator188, Method: assocOperator188";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator188
	@Override
    public Collection<Usuario> assocOperator188Range1 (Solicitud instance, String solicitudTCREARDOCNUMIDSIEXISTEpNumIdentificacion) throws SystemException {

        SQLSelect sql = assocOperator188Range1Query(instance, solicitudTCREARDOCNUMIDSIEXISTEpNumIdentificacion);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator188
	@Override
    public SQLPopulation assocOperator188Range1Query (Solicitud instance, String solicitudTCREARDOCNUMIDSIEXISTEpNumIdentificacion) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.NumIdentificacion = pNumIdentificacion
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIONUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(solicitudTCREARDOCNUMIDSIEXISTEpNumIdentificacion, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator188, Method: assocOperator188Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator190
	@Override
    public Boolean assocOperator190(Solicitud instance) throws SystemException {
        try {
            // EXIST (ProteccionDatos)
            return assocOperator190Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator190, Method: assocOperator190";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator190
	@Override
    public Boolean assocOperator190Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator190Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator190
	@Override
    public SQLExists assocOperator190Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_PROTECCIONDATOS, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator190, Method: assocOperator190Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator193
	@Override
    public Collection<Usuario> assocOperator193(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (Usuarios.Parentesco = fugetParentescoTitular()) DO Usuarios.DelParentescorUsuario(Usuarios, Usuarios.Parentesco)
        return assocOperator193Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator193, Method: assocOperator193";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator193
	@Override
    public Collection<Usuario> assocOperator193Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator193Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator193
	@Override
    public SQLPopulation assocOperator193Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco = fugetParentescoTitular()
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO, ParentescoConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (userFunctionsSrv.fugetParentescoTitularFun() == null ||
                        userFunctionsSrv.fugetParentescoTitularFun().isNull())
                    {
                        SQLWhereOperandNull operand = new SQLWhereOperandNull();
                    comparison1.setSecondOperand(operand);
                    } else {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.UF_NAME_FUGETPARENTESCOTITULAR, ParentescoConstants.CLASS_NAME, ParentescoConstants.CLASS_NAME, userFunctionsSrv.fugetParentescoTitularFun().getOid(), Constants.UF_NAME_FUGETPARENTESCOTITULAR);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator193, Method: assocOperator193Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator194
	@Override
    public Collection<Usuario> assocOperator194(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (Usuarios.UsuarioPersona = ContratantePersona) DO Usuarios.TELIMINARSINPREC(Usuarios)
        return assocOperator194Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator194, Method: assocOperator194";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator194
	@Override
    public Collection<Usuario> assocOperator194Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator194Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator194
	@Override
    public SQLPopulation assocOperator194Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.UsuarioPersona = ContratantePersona
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA, PersonaConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA, PersonaConstants.CLASS_NAME, PersonaConstants.CLASS_NAME, instance.getContratantePersona().getOid(), SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator194, Method: assocOperator194Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator196
	@Override
    public Collection<Usuario> assocOperator196(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (Usuarios.UsuarioPersona = ContratantePersona) DO Usuarios.TMODIFICAR(Usuarios, ContratantePersona.Codigo, ContratantePersona.NumIdentificacion, ContratantePersona.PrimerNombre, ContratantePersona.SegundoNombre, ContratantePersona.PrimerApellido, ContratantePersona.SegundoApellido, ContratantePersona.TipoIdentificacion, true)
        return assocOperator196Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator196, Method: assocOperator196";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator196
	@Override
    public Collection<Usuario> assocOperator196Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator196Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator196
	@Override
    public SQLPopulation assocOperator196Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.UsuarioPersona = ContratantePersona
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA, PersonaConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA, PersonaConstants.CLASS_NAME, PersonaConstants.CLASS_NAME, instance.getContratantePersona().getOid(), SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator196, Method: assocOperator196Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator197
	@Override
    public Collection<Usuario> assocOperator197(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (Usuarios.Parentesco = fugetParentescoTitular()) DO Usuarios.DelParentescorUsuario(Usuarios, Usuarios.Parentesco)
        return assocOperator197Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator197, Method: assocOperator197";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator197
	@Override
    public Collection<Usuario> assocOperator197Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator197Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator197
	@Override
    public SQLPopulation assocOperator197Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco = fugetParentescoTitular()
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO, ParentescoConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (userFunctionsSrv.fugetParentescoTitularFun() == null ||
                        userFunctionsSrv.fugetParentescoTitularFun().isNull())
                    {
                        SQLWhereOperandNull operand = new SQLWhereOperandNull();
                    comparison1.setSecondOperand(operand);
                    } else {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.UF_NAME_FUGETPARENTESCOTITULAR, ParentescoConstants.CLASS_NAME, ParentescoConstants.CLASS_NAME, userFunctionsSrv.fugetParentescoTitularFun().getOid(), Constants.UF_NAME_FUGETPARENTESCOTITULAR);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator197, Method: assocOperator197Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator199
	@Override
    public Boolean assocOperator199(Solicitud instance) throws SystemException {
        try {
            // EXIST (ContratantePersona)
            return assocOperator199Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator199, Method: assocOperator199";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator199
	@Override
    public Boolean assocOperator199Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator199Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator199
	@Override
    public SQLExists assocOperator199Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator199, Method: assocOperator199Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator200
	@Override
    public Boolean assocOperator200(Solicitud instance) throws SystemException {
        try {
            // EXIST (UsuariosRegistrados) WHERE (UsuariosRegistrados.TipoIdentificacion = ContratantePersona.TipoIdentificacion.NombreCorto AND UsuariosRegistrados.NumIdentificacion = ContratantePersona.NumIdentificacion AND UsuariosRegistrados.EstadoBeneficiario.EsActivo = true)
            return assocOperator200Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator200, Method: assocOperator200";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator200
	@Override
    public Boolean assocOperator200Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator200Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator200
	@Override
    public SQLExists assocOperator200Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.TipoIdentificacion = ContratantePersona.TipoIdentificacion.NombreCorto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ATTR_NAME_USUARIOREGTIPOIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getContratantePersona().getTipoIdentificacion().getTipoIdentificacionNombreCorto()!= null){
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(instance.getContratantePersona().getTipoIdentificacion().getTipoIdentificacionNombreCorto(), Constants.Type.STRING.getTypeName()));
                    } else {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison1);


            // UsuariosRegistrados.NumIdentificacion = ContratantePersona.NumIdentificacion
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ATTR_NAME_USUARIOREGNUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    if (instance.getContratantePersona().getPersonaNumIdentificacion()!= null){
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(instance.getContratantePersona().getPersonaNumIdentificacion(), Constants.Type.STRING.getTypeName()));
                    } else {
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison2);


            // UsuariosRegistrados.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator200, Method: assocOperator200Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator201
	@Override
    public Boolean assocOperator201(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.UsuarioPersona = ContratantePersona)
            return assocOperator201Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator201, Method: assocOperator201";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator201
	@Override
    public Boolean assocOperator201Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator201Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator201
	@Override
    public SQLExists assocOperator201Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.UsuarioPersona = ContratantePersona
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA, PersonaConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA, PersonaConstants.CLASS_NAME, PersonaConstants.CLASS_NAME, instance.getContratantePersona().getOid(), SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator201, Method: assocOperator201Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator202
	@Override
    public Boolean assocOperator202(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona)
            return assocOperator202Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator202, Method: assocOperator202";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator202
	@Override
    public Boolean assocOperator202Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator202Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator202
	@Override
    public SQLExists assocOperator202Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator202, Method: assocOperator202Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator205
	@Override
    public Collection<Usuario> assocOperator205(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (Usuarios.Parentesco = fugetParentescoTitular()) DO Usuarios.DelParentescorUsuario(Usuarios, Usuarios.Parentesco)
        return assocOperator205Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator205, Method: assocOperator205";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator205
	@Override
    public Collection<Usuario> assocOperator205Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator205Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator205
	@Override
    public SQLPopulation assocOperator205Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco = fugetParentescoTitular()
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO, ParentescoConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (userFunctionsSrv.fugetParentescoTitularFun() == null ||
                        userFunctionsSrv.fugetParentescoTitularFun().isNull())
                    {
                        SQLWhereOperandNull operand = new SQLWhereOperandNull();
                    comparison1.setSecondOperand(operand);
                    } else {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.UF_NAME_FUGETPARENTESCOTITULAR, ParentescoConstants.CLASS_NAME, ParentescoConstants.CLASS_NAME, userFunctionsSrv.fugetParentescoTitularFun().getOid(), Constants.UF_NAME_FUGETPARENTESCOTITULAR);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator205, Method: assocOperator205Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator206
	@Override
    public Collection<Usuario> assocOperator206(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (Usuarios.UsuarioPersona = TitularPersona) DO Usuarios.TELIMINARSINPREC(Usuarios)
        return assocOperator206Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator206, Method: assocOperator206";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator206
	@Override
    public Collection<Usuario> assocOperator206Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator206Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator206
	@Override
    public SQLPopulation assocOperator206Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.UsuarioPersona = TitularPersona
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA, PersonaConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_TITULARPERSONA, PersonaConstants.CLASS_NAME, PersonaConstants.CLASS_NAME, instance.getTitularPersona().getOid(), SolicitudConstants.ROLE_NAME_TITULARPERSONA);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator206, Method: assocOperator206Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator208
	@Override
    public Collection<Usuario> assocOperator208(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (Usuarios.UsuarioPersona = TitularPersona) DO Usuarios.TMODIFICAR(Usuarios, TitularPersona.Codigo, TitularPersona.NumIdentificacion, TitularPersona.PrimerNombre, TitularPersona.SegundoNombre, TitularPersona.PrimerApellido, TitularPersona.SegundoApellido, TitularPersona.TipoIdentificacion, true)
        return assocOperator208Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator208, Method: assocOperator208";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator208
	@Override
    public Collection<Usuario> assocOperator208Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator208Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator208
	@Override
    public SQLPopulation assocOperator208Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.UsuarioPersona = TitularPersona
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA, PersonaConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_TITULARPERSONA, PersonaConstants.CLASS_NAME, PersonaConstants.CLASS_NAME, instance.getTitularPersona().getOid(), SolicitudConstants.ROLE_NAME_TITULARPERSONA);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator208, Method: assocOperator208Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator210
	@Override
    public Collection<Usuario> assocOperator210(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (Usuarios.Parentesco = fugetParentescoTitular()) DO Usuarios.DelParentescorUsuario(Usuarios, Usuarios.Parentesco)
        return assocOperator210Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator210, Method: assocOperator210";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator210
	@Override
    public Collection<Usuario> assocOperator210Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator210Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator210
	@Override
    public SQLPopulation assocOperator210Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco = fugetParentescoTitular()
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO, ParentescoConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (userFunctionsSrv.fugetParentescoTitularFun() == null ||
                        userFunctionsSrv.fugetParentescoTitularFun().isNull())
                    {
                        SQLWhereOperandNull operand = new SQLWhereOperandNull();
                    comparison1.setSecondOperand(operand);
                    } else {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.UF_NAME_FUGETPARENTESCOTITULAR, ParentescoConstants.CLASS_NAME, ParentescoConstants.CLASS_NAME, userFunctionsSrv.fugetParentescoTitularFun().getOid(), Constants.UF_NAME_FUGETPARENTESCOTITULAR);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator210, Method: assocOperator210Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator211
	@Override
    public Boolean assocOperator211(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona)
            return assocOperator211Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator211, Method: assocOperator211";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator211
	@Override
    public Boolean assocOperator211Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator211Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator211
	@Override
    public SQLExists assocOperator211Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator211, Method: assocOperator211Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator212
	@Override
    public Boolean assocOperator212(Solicitud instance, TipoIdentificacion solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion, String solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion) throws SystemException {
        try {
            // EXIST (UsuariosRegistrados) WHERE (UsuariosRegistrados.TipoIdentificacion = ptpagrTipoIdentificacion.NombreCorto AND UsuariosRegistrados.NumIdentificacion = ptpatrNumIdentificacion AND UsuariosRegistrados.EstadoBeneficiario.EsActivo = true)
            return assocOperator212Range1(instance, solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion, solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator212, Method: assocOperator212";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator212
	@Override
    public Boolean assocOperator212Range1 (Solicitud instance, TipoIdentificacion solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion, String solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion) throws SystemException {
        SQLExists sql = assocOperator212Range1Query(instance, solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion, solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator212
	@Override
    public SQLExists assocOperator212Range1Query (Solicitud instance, TipoIdentificacion solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion, String solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.TipoIdentificacion = ptpagrTipoIdentificacion.NombreCorto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ATTR_NAME_USUARIOREGTIPOIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion.getTipoIdentificacionNombreCorto(), Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);


            // UsuariosRegistrados.NumIdentificacion = ptpatrNumIdentificacion
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ATTR_NAME_USUARIOREGNUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison2);


            // UsuariosRegistrados.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator212, Method: assocOperator212Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator213
	@Override
    public Boolean assocOperator213(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.UsuarioPersona = TitularPersona)
            return assocOperator213Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator213, Method: assocOperator213";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator213
	@Override
    public Boolean assocOperator213Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator213Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator213
	@Override
    public SQLExists assocOperator213Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.UsuarioPersona = TitularPersona
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA, PersonaConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_TITULARPERSONA, PersonaConstants.CLASS_NAME, PersonaConstants.CLASS_NAME, instance.getTitularPersona().getOid(), SolicitudConstants.ROLE_NAME_TITULARPERSONA);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator213, Method: assocOperator213Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator214
	@Override
    public Boolean assocOperator214(Solicitud instance, TipoIdentificacion solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion, String solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion) throws SystemException {
        try {
            // EXIST (UsuariosRegistrados) WHERE (UsuariosRegistrados.TipoIdentificacion = ptpagrTipoIdentificacion.NombreCorto AND UsuariosRegistrados.NumIdentificacion = ptpatrNumIdentificacion AND UsuariosRegistrados.EstadoBeneficiario.EsActivo = true)
            return assocOperator214Range1(instance, solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion, solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator214, Method: assocOperator214";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator214
	@Override
    public Boolean assocOperator214Range1 (Solicitud instance, TipoIdentificacion solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion, String solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion) throws SystemException {
        SQLExists sql = assocOperator214Range1Query(instance, solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion, solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator214
	@Override
    public SQLExists assocOperator214Range1Query (Solicitud instance, TipoIdentificacion solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion, String solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.TipoIdentificacion = ptpagrTipoIdentificacion.NombreCorto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ATTR_NAME_USUARIOREGTIPOIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion.getTipoIdentificacionNombreCorto(), Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);


            // UsuariosRegistrados.NumIdentificacion = ptpatrNumIdentificacion
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ATTR_NAME_USUARIOREGNUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison2);


            // UsuariosRegistrados.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator214, Method: assocOperator214Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator216
	@Override
    public Boolean assocOperator216(Solicitud instance) throws SystemException {
        try {
            // EXIST (ContratantePersona)
            return assocOperator216Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator216, Method: assocOperator216";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator216
	@Override
    public Boolean assocOperator216Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator216Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator216
	@Override
    public SQLExists assocOperator216Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator216, Method: assocOperator216Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator218
	@Override
    public Boolean assocOperator218(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona)
            return assocOperator218Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator218, Method: assocOperator218";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator218
	@Override
    public Boolean assocOperator218Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator218Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator218
	@Override
    public SQLExists assocOperator218Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator218, Method: assocOperator218Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator219
	@Override
    public Collection<Usuario> assocOperator219(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (Usuarios.UsuarioPersona = ContratantePersona) DO Usuarios.TELIMINARSINPREC(Usuarios)
        return assocOperator219Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator219, Method: assocOperator219";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator219
	@Override
    public Collection<Usuario> assocOperator219Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator219Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator219
	@Override
    public SQLPopulation assocOperator219Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.UsuarioPersona = ContratantePersona
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA, PersonaConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA, PersonaConstants.CLASS_NAME, PersonaConstants.CLASS_NAME, instance.getContratantePersona().getOid(), SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator219, Method: assocOperator219Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator222
	@Override
    public Collection<Usuario> assocOperator222(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (Usuarios.TipoIdentificacion.MenorSinIdentificar = true AND Usuarios.drvTieneCuesMed = true) DO Usuarios.CuestionarioP.TCAMBIARPREGUNTA108(Usuarios.CuestionarioP)
            Collection<Usuario> results = new ArrayList<>();
            for(Usuario item : assocOperator222Range1(instance)){
                // Usuarios.drvTieneCuesMed = true
                if(item.getUsuariodrvTieneCuesMed().equals(true))
                    results.add(item);
            }
            return results;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator222, Method: assocOperator222";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator222
	@Override
    public Collection<Usuario> assocOperator222Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator222Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator222
	@Override
    public SQLPopulation assocOperator222Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.TipoIdentificacion.MenorSinIdentificar = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION + "." + TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONMENORSINIDENTIFICAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator222, Method: assocOperator222Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator223
	@Override
    public Collection<DocumentoG> assocOperator223(Solicitud instance) throws SystemException {
        try {
            // FOR ALL DocumentosGestor DO DocumentosGestor.setFechaSubida(DocumentosGestor, FechaCompletada)
        return assocOperator223Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator223, Method: assocOperator223";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator223
	@Override
    public Collection<DocumentoG> assocOperator223Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator223Range1Query(instance);
        return new TypedQueryBuilder<DocumentoG>(em, DocumentoG.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator223
	@Override
    public SQLPopulation assocOperator223Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, DocumentoGConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_DOCUMENTOSGESTOR);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator223, Method: assocOperator223Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator224
	@Override
    public Long assocOperator224(Solicitud instance) throws SystemException {
        try {
            // SUM (Aesolicitudes.PlanT.Dominios.DiaIniVigencia) WHERE (Aesolicitudes.PlanT.Dominios.ProductoT = Aesolicitudes.ProductoT)
            return assocOperator224Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator224, Method: assocOperator224";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator224
	@Override
    public Long assocOperator224Range1 (Solicitud instance) throws SystemException {
        SQLSum sql = assocOperator224Range1Query(instance);
        return new TypedQueryBuilder<Long>(em, Long.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator224
	@Override
    public SQLSum assocOperator224Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLSum sql = new SQLSum(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIODIAINIVIGENCIA, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.PlanT.Dominios.ProductoT = Aesolicitudes.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getAesolicitudes().getProductoT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator224, Method: assocOperator224Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator225
	@Override
    public Long assocOperator225(Solicitud instance) throws SystemException {
        try {
            // SUM (Aesolicitudes.PlanT.Dominios.DiaFinVigencia) WHERE (Aesolicitudes.PlanT.Dominios.ProductoT = Aesolicitudes.ProductoT)
            return assocOperator225Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator225, Method: assocOperator225";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator225
	@Override
    public Long assocOperator225Range1 (Solicitud instance) throws SystemException {
        SQLSum sql = assocOperator225Range1Query(instance);
        return new TypedQueryBuilder<Long>(em, Long.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator225
	@Override
    public SQLSum assocOperator225Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLSum sql = new SQLSum(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIODIAFINVIGENCIA, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.PlanT.Dominios.ProductoT = Aesolicitudes.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getAesolicitudes().getProductoT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator225, Method: assocOperator225Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator228
	@Override
    public Boolean assocOperator228(Solicitud instance) throws SystemException {
        try {
            // EXIST (UsrAfiliacion)
            return assocOperator228Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator228, Method: assocOperator228";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator228
	@Override
    public Boolean assocOperator228Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator228Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator228
	@Override
    public SQLExists assocOperator228Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USRAFILIACION, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator228, Method: assocOperator228Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator229
	@Override
    public Boolean assocOperator229(Solicitud instance) throws SystemException {
        try {
            // EXIST (UsrAreaMedica)
            return assocOperator229Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator229, Method: assocOperator229";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator229
	@Override
    public Boolean assocOperator229Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator229Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator229
	@Override
    public SQLExists assocOperator229Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USRAREAMEDICA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator229, Method: assocOperator229Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator234
	@Override
    public Boolean assocOperator234(Solicitud instance) throws SystemException {
        try {
            // EXIST (GrupoAsociado)
            return assocOperator234Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator234, Method: assocOperator234";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator234
	@Override
    public Boolean assocOperator234Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator234Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator234
	@Override
    public SQLExists assocOperator234Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_GRUPOASOCIADO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator234, Method: assocOperator234Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator235
	@Override
    public Boolean assocOperator235(Solicitud instance) throws SystemException {
        try {
            // EXIST (GrupoAsociado)
            return assocOperator235Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator235, Method: assocOperator235";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator235
	@Override
    public Boolean assocOperator235Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator235Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator235
	@Override
    public SQLExists assocOperator235Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_GRUPOASOCIADO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator235, Method: assocOperator235Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator236
	@Override
    public Boolean assocOperator236(Solicitud instance) throws SystemException {
        try {
            // EXIST (TipoFactura)
            return assocOperator236Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator236, Method: assocOperator236";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator236
	@Override
    public Boolean assocOperator236Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator236Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator236
	@Override
    public SQLExists assocOperator236Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TIPOFACTURA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator236, Method: assocOperator236Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator237
	@Override
    public Boolean assocOperator237(Solicitud instance) throws SystemException {
        try {
            // EXIST (TipoFactura)
            return assocOperator237Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator237, Method: assocOperator237";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator237
	@Override
    public Boolean assocOperator237Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator237Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator237
	@Override
    public SQLExists assocOperator237Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TIPOFACTURA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator237, Method: assocOperator237Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator239
	@Override
    public Boolean assocOperator239(Solicitud instance) throws SystemException {
        try {
            // EXIST (UsrAfiliacion)
            return assocOperator239Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator239, Method: assocOperator239";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator239
	@Override
    public Boolean assocOperator239Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator239Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator239
	@Override
    public SQLExists assocOperator239Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USRAFILIACION, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator239, Method: assocOperator239Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator241
	@Override
    public Boolean assocOperator241(Solicitud instance) throws SystemException {
        try {
            // EXIST (UsrAreaMedica)
            return assocOperator241Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator241, Method: assocOperator241";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator241
	@Override
    public Boolean assocOperator241Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator241Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator241
	@Override
    public SQLExists assocOperator241Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USRAREAMEDICA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator241, Method: assocOperator241Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator243
	@Override
    public Boolean assocOperator243(Solicitud instance) throws SystemException {
        try {
            // EXIST (ContratantePersona)
            return assocOperator243Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator243, Method: assocOperator243";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator243
	@Override
    public Boolean assocOperator243Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator243Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator243
	@Override
    public SQLExists assocOperator243Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator243, Method: assocOperator243Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator245
	@Override
    public Boolean assocOperator245(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona)
            return assocOperator245Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator245, Method: assocOperator245";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator245
	@Override
    public Boolean assocOperator245Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator245Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator245
	@Override
    public SQLExists assocOperator245Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator245, Method: assocOperator245Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator249
	@Override
    public Boolean assocOperator249(Solicitud instance) throws SystemException {
        try {
            // EXIST (GrupoAsociado)
            return assocOperator249Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator249, Method: assocOperator249";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator249
	@Override
    public Boolean assocOperator249Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator249Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator249
	@Override
    public SQLExists assocOperator249Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_GRUPOASOCIADO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator249, Method: assocOperator249Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator250
	@Override
    public Boolean assocOperator250(Solicitud instance) throws SystemException {
        try {
            // EXIST (GrupoAsociado)
            return assocOperator250Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator250, Method: assocOperator250";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator250
	@Override
    public Boolean assocOperator250Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator250Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator250
	@Override
    public SQLExists assocOperator250Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_GRUPOASOCIADO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator250, Method: assocOperator250Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator251
	@Override
    public Boolean assocOperator251(Solicitud instance) throws SystemException {
        try {
            // EXIST (GrupoAsociado)
            return assocOperator251Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator251, Method: assocOperator251";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator251
	@Override
    public Boolean assocOperator251Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator251Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator251
	@Override
    public SQLExists assocOperator251Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_GRUPOASOCIADO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator251, Method: assocOperator251Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator253
	@Override
    public Boolean assocOperator253(Solicitud instance) throws SystemException {
        try {
            // EXIST (FirmaContratanteIncl)
            return assocOperator253Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator253, Method: assocOperator253";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator253
	@Override
    public Boolean assocOperator253Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator253Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator253
	@Override
    public SQLExists assocOperator253Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_FIRMACONTRATANTEINCL, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator253, Method: assocOperator253Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator254
	@Override
    public Boolean assocOperator254(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona)
            return assocOperator254Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator254, Method: assocOperator254";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator254
	@Override
    public Boolean assocOperator254Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator254Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator254
	@Override
    public SQLExists assocOperator254Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator254, Method: assocOperator254Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator255
	@Override
    public Boolean assocOperator255(Solicitud instance) throws SystemException {
        try {
            // EXIST (Titular)
            return assocOperator255Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator255, Method: assocOperator255";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator255
	@Override
    public Boolean assocOperator255Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator255Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator255
	@Override
    public SQLExists assocOperator255Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULAR, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator255, Method: assocOperator255Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator257
	@Override
    public Boolean assocOperator257(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona)
            return assocOperator257Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator257, Method: assocOperator257";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator257
	@Override
    public Boolean assocOperator257Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator257Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator257
	@Override
    public SQLExists assocOperator257Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator257, Method: assocOperator257Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator260
	@Override
    public Boolean assocOperator260(Solicitud instance) throws SystemException {
        try {
            // EXIST (UsrAfiliacion)
            return assocOperator260Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator260, Method: assocOperator260";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator260
	@Override
    public Boolean assocOperator260Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator260Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator260
	@Override
    public SQLExists assocOperator260Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USRAFILIACION, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator260, Method: assocOperator260Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator261
	@Override
    public Boolean assocOperator261(Solicitud instance) throws SystemException {
        try {
            // EXIST (UsrAreaMedica)
            return assocOperator261Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator261, Method: assocOperator261";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator261
	@Override
    public Boolean assocOperator261Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator261Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator261
	@Override
    public SQLExists assocOperator261Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USRAREAMEDICA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator261, Method: assocOperator261Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator264
	@Override
    public Boolean assocOperator264(Solicitud instance) throws SystemException {
        try {
            // EXIST (UsrAfiliacion)
            return assocOperator264Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator264, Method: assocOperator264";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator264
	@Override
    public Boolean assocOperator264Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator264Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator264
	@Override
    public SQLExists assocOperator264Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USRAFILIACION, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator264, Method: assocOperator264Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator265
	@Override
    public Boolean assocOperator265(Solicitud instance) throws SystemException {
        try {
            // EXIST (UsrAreaMedica)
            return assocOperator265Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator265, Method: assocOperator265";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator265
	@Override
    public Boolean assocOperator265Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator265Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator265
	@Override
    public SQLExists assocOperator265Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USRAREAMEDICA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator265, Method: assocOperator265Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator268
	@Override
    public Boolean assocOperator268(Solicitud instance) throws SystemException {
        try {
            // EXIST (UsrAfiliacion)
            return assocOperator268Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator268, Method: assocOperator268";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator268
	@Override
    public Boolean assocOperator268Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator268Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator268
	@Override
    public SQLExists assocOperator268Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USRAFILIACION, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator268, Method: assocOperator268Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator269
	@Override
    public Boolean assocOperator269(Solicitud instance) throws SystemException {
        try {
            // EXIST (UsrAreaMedica)
            return assocOperator269Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator269, Method: assocOperator269";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator269
	@Override
    public Boolean assocOperator269Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator269Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator269
	@Override
    public SQLExists assocOperator269Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USRAREAMEDICA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator269, Method: assocOperator269Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator273
	@Override
    public Long assocOperator273(Solicitud instance) throws SystemException {
        try {
            // COUNT (DocumentosGestor)
            return assocOperator273Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator273, Method: assocOperator273";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator273
	@Override
    public Long assocOperator273Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator273Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator273
	@Override
    public SQLCount assocOperator273Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_DOCUMENTOSGESTOR, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator273, Method: assocOperator273Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator274
	@Override
    public Long assocOperator274(Solicitud instance) throws SystemException {
        try {
            // COUNT (DocumentosGestor) WHERE (DocumentosGestor.Estado = 1)
            return assocOperator274Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator274, Method: assocOperator274";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator274
	@Override
    public Long assocOperator274Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator274Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator274
	@Override
    public SQLCount assocOperator274Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_DOCUMENTOSGESTOR, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // DocumentosGestor.Estado = 1
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_DOCUMENTOSGESTOR + "." + DocumentoGConstants.ATTR_NAME_DOCUMENTOGESTADO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator274, Method: assocOperator274Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator275
	@Override
    public Long assocOperator275(Solicitud instance) throws SystemException {
        try {
            // COUNT (DocumentosGestor) WHERE (DocumentosGestor.Estado = 3)
            return assocOperator275Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator275, Method: assocOperator275";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator275
	@Override
    public Long assocOperator275Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator275Range1Query(instance);
        return Long.valueOf(solveCountQuery(sql));
    }

    // Range Query 1 for AssocOperator AssocOperator275
	@Override
    public SQLCount assocOperator275Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_DOCUMENTOSGESTOR, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // DocumentosGestor.Estado = 3
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_DOCUMENTOSGESTOR + "." + DocumentoGConstants.ATTR_NAME_DOCUMENTOGESTADO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(3), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator275, Method: assocOperator275Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator276
	@Override
    public Collection<DocumentoG> assocOperator276(Solicitud instance) throws SystemException {
        try {
            // FOR ALL DocumentosGestor WHERE (DocumentosGestor.Tipo = 2 AND DocumentosGestor.Estado = 3) DO DocumentosGestor.sustituir(DocumentosGestor)
        return assocOperator276Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator276, Method: assocOperator276";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator276
	@Override
    public Collection<DocumentoG> assocOperator276Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator276Range1Query(instance);
        return new TypedQueryBuilder<DocumentoG>(em, DocumentoG.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator276
	@Override
    public SQLPopulation assocOperator276Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, DocumentoGConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_DOCUMENTOSGESTOR);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // DocumentosGestor.Tipo = 2
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_DOCUMENTOSGESTOR + "." + DocumentoGConstants.ATTR_NAME_DOCUMENTOGTIPO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(2), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);


            // DocumentosGestor.Estado = 3
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_DOCUMENTOSGESTOR + "." + DocumentoGConstants.ATTR_NAME_DOCUMENTOGESTADO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(3), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator276, Method: assocOperator276Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator278
	@Override
    public Collection<DocumentoG> assocOperator278(Solicitud instance, Persona solicitudTSUBIRDOCUMENTOATOptPersona, Long solicitudTSUBIRDOCUMENTOATOptpatrTipo) throws SystemException {
        try {
            // FOR ALL DocumentosGestor WHERE (DocumentosGestor.Persona = ptPersona AND DocumentosGestor.Tipo = ptpatrTipo) DO DocumentosGestor.TMODIFICARATO(DocumentosGestor, ptpatrDescripcion, ptpatrTipo, 1, systemDateTime(), ptIdDocGestor, ptpExtension, DocumentosGestor.Nombre)
        return assocOperator278Range1(instance, solicitudTSUBIRDOCUMENTOATOptPersona, solicitudTSUBIRDOCUMENTOATOptpatrTipo);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator278, Method: assocOperator278";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator278
	@Override
    public Collection<DocumentoG> assocOperator278Range1 (Solicitud instance, Persona solicitudTSUBIRDOCUMENTOATOptPersona, Long solicitudTSUBIRDOCUMENTOATOptpatrTipo) throws SystemException {

        SQLSelect sql = assocOperator278Range1Query(instance, solicitudTSUBIRDOCUMENTOATOptPersona, solicitudTSUBIRDOCUMENTOATOptpatrTipo);
        return new TypedQueryBuilder<DocumentoG>(em, DocumentoG.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator278
	@Override
    public SQLPopulation assocOperator278Range1Query (Solicitud instance, Persona solicitudTSUBIRDOCUMENTOATOptPersona, Long solicitudTSUBIRDOCUMENTOATOptpatrTipo) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, DocumentoGConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_DOCUMENTOSGESTOR);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // DocumentosGestor.Persona = ptPersona
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_DOCUMENTOSGESTOR + "." + DocumentoGConstants.ROLE_NAME_PERSONA, PersonaConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ARG_NAME_TSUBIRDOCUMENTOATO_SOLICITUDTSUBIRDOCUMENTOATOPTPERSONA, PersonaConstants.CLASS_NAME, PersonaConstants.CLASS_NAME, solicitudTSUBIRDOCUMENTOATOptPersona.getOid(), SolicitudConstants.ARG_NAME_TSUBIRDOCUMENTOATO_SOLICITUDTSUBIRDOCUMENTOATOPTPERSONA);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // DocumentosGestor.Tipo = ptpatrTipo
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_DOCUMENTOSGESTOR + "." + DocumentoGConstants.ATTR_NAME_DOCUMENTOGTIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    if (solicitudTSUBIRDOCUMENTOATOptpatrTipo!= null){
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(solicitudTSUBIRDOCUMENTOATOptpatrTipo, Constants.Type.NAT.getTypeName()));
                    } else {
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator278, Method: assocOperator278Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator279
	@Override
    public Collection<Usuario> assocOperator279(Solicitud instance, Persona solicitudTSUBIRDOCUMENTOATOptPersona) throws SystemException {
        try {
            // FOR ALL Usuarios WHERE (Usuarios.UsuarioPersona = ptPersona) DO Usuarios.TNOTIFICARDOCUMENTO(Usuarios, ptpatrTipo)
        return assocOperator279Range1(instance, solicitudTSUBIRDOCUMENTOATOptPersona);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator279, Method: assocOperator279";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator279
	@Override
    public Collection<Usuario> assocOperator279Range1 (Solicitud instance, Persona solicitudTSUBIRDOCUMENTOATOptPersona) throws SystemException {

        SQLSelect sql = assocOperator279Range1Query(instance, solicitudTSUBIRDOCUMENTOATOptPersona);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator279
	@Override
    public SQLPopulation assocOperator279Range1Query (Solicitud instance, Persona solicitudTSUBIRDOCUMENTOATOptPersona) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.UsuarioPersona = ptPersona
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA, PersonaConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ARG_NAME_TSUBIRDOCUMENTOATO_SOLICITUDTSUBIRDOCUMENTOATOPTPERSONA, PersonaConstants.CLASS_NAME, PersonaConstants.CLASS_NAME, solicitudTSUBIRDOCUMENTOATOptPersona.getOid(), SolicitudConstants.ARG_NAME_TSUBIRDOCUMENTOATO_SOLICITUDTSUBIRDOCUMENTOATOPTPERSONA);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator279, Method: assocOperator279Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator280
	@Override
    public Boolean assocOperator280(Solicitud instance, Persona solicitudTSUBIRDOCUMENTOATOptPersona, Long solicitudTSUBIRDOCUMENTOATOptpatrTipo) throws SystemException {
        try {
            // EXIST (DocumentosGestor) WHERE (DocumentosGestor.Persona = ptPersona AND DocumentosGestor.Tipo = ptpatrTipo)
            return assocOperator280Range1(instance, solicitudTSUBIRDOCUMENTOATOptPersona, solicitudTSUBIRDOCUMENTOATOptpatrTipo);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator280, Method: assocOperator280";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator280
	@Override
    public Boolean assocOperator280Range1 (Solicitud instance, Persona solicitudTSUBIRDOCUMENTOATOptPersona, Long solicitudTSUBIRDOCUMENTOATOptpatrTipo) throws SystemException {
        SQLExists sql = assocOperator280Range1Query(instance, solicitudTSUBIRDOCUMENTOATOptPersona, solicitudTSUBIRDOCUMENTOATOptpatrTipo);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator280
	@Override
    public SQLExists assocOperator280Range1Query (Solicitud instance, Persona solicitudTSUBIRDOCUMENTOATOptPersona, Long solicitudTSUBIRDOCUMENTOATOptpatrTipo) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_DOCUMENTOSGESTOR, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // DocumentosGestor.Persona = ptPersona
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_DOCUMENTOSGESTOR + "." + DocumentoGConstants.ROLE_NAME_PERSONA, PersonaConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ARG_NAME_TSUBIRDOCUMENTOATO_SOLICITUDTSUBIRDOCUMENTOATOPTPERSONA, PersonaConstants.CLASS_NAME, PersonaConstants.CLASS_NAME, solicitudTSUBIRDOCUMENTOATOptPersona.getOid(), SolicitudConstants.ARG_NAME_TSUBIRDOCUMENTOATO_SOLICITUDTSUBIRDOCUMENTOATOPTPERSONA);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // DocumentosGestor.Tipo = ptpatrTipo
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_DOCUMENTOSGESTOR + "." + DocumentoGConstants.ATTR_NAME_DOCUMENTOGTIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    if (solicitudTSUBIRDOCUMENTOATOptpatrTipo!= null){
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(solicitudTSUBIRDOCUMENTOATOptpatrTipo, Constants.Type.NAT.getTypeName()));
                    } else {
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator280, Method: assocOperator280Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator281
	@Override
    public Collection<PlantillaEmail> assocOperator281(Solicitud instance, Long solicitudTGETPLANTILLACORREOptTipo) throws SystemException {
        try {
            // FOR ALL Aesolicitudes.ProductoT.Dominios.Plantillas WHERE (Aesolicitudes.ProductoT.Dominios.Plantillas.Codigo = ptTipo AND EXIST (Aesolicitudes.ProductoT.Dominios.Plantillas.Dominios) WHERE (Aesolicitudes.ProductoT.Dominios.Plantillas.Dominios.ProductoT = Aesolicitudes.ProductoT AND Aesolicitudes.ProductoT.Dominios.Plantillas.Dominios.PlanT = Aesolicitudes.PlanT) = true) DO Aesolicitudes.ProductoT.Dominios.Plantillas.getDummy(Aesolicitudes.ProductoT.Dominios.Plantillas; oaPlantilla)
        return assocOperator281Range1(instance, solicitudTGETPLANTILLACORREOptTipo);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator281, Method: assocOperator281";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator281
	@Override
    public Collection<PlantillaEmail> assocOperator281Range1 (Solicitud instance, Long solicitudTGETPLANTILLACORREOptTipo) throws SystemException {

        SQLSelect sql = assocOperator281Range1Query(instance, solicitudTGETPLANTILLACORREOptTipo);
        return new TypedQueryBuilder<PlantillaEmail>(em, PlantillaEmail.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator281
	@Override
    public SQLPopulation assocOperator281Range1Query (Solicitud instance, Long solicitudTGETPLANTILLACORREOptTipo) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, PlantillaEmailConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANTILLAS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.Plantillas.Codigo = ptTipo
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANTILLAS + "." + PlantillaEmailConstants.ATTR_NAME_PLANTILLAEMAILCODIGO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(solicitudTGETPLANTILLACORREOptTipo, Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);


            // EXIST (Aesolicitudes.ProductoT.Dominios.Plantillas.Dominios) WHERE (Aesolicitudes.ProductoT.Dominios.Plantillas.Dominios.ProductoT = Aesolicitudes.ProductoT AND Aesolicitudes.ProductoT.Dominios.Plantillas.Dominios.PlanT = Aesolicitudes.PlanT) = true
                // 'exist' Association operator
                SQLWhereOperandSubQuery operandSubQueryAssocOperator282 = new SQLWhereOperandSubQuery(assocOperator282Range1Query(instance, sql));
                conjunction.addOperand(operandSubQueryAssocOperator282);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator281, Method: assocOperator281Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator282
	@Override
    public Boolean assocOperator282(Solicitud instance) throws SystemException {
        try {
            // EXIST (Aesolicitudes.ProductoT.Dominios.Plantillas.Dominios) WHERE (Aesolicitudes.ProductoT.Dominios.Plantillas.Dominios.ProductoT = Aesolicitudes.ProductoT AND Aesolicitudes.ProductoT.Dominios.Plantillas.Dominios.PlanT = Aesolicitudes.PlanT)
            return assocOperator282Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator282, Method: assocOperator282";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator282
	@Override
    public Boolean assocOperator282Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator282Range1Query(instance, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator282
	@Override
    public SQLExists assocOperator282Range1Query (Solicitud instance, SQLSelect superQuery) throws SystemException {
        try {
            // Path starts with a class in the subquery
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANTILLAS + "." + PlantillaEmailConstants.ROLE_NAME_DOMINIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.Plantillas.Dominios.ProductoT = Aesolicitudes.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANTILLAS + "." + PlantillaEmailConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getAesolicitudes().getProductoT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.Plantillas.Dominios.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANTILLAS + "." + PlantillaEmailConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison2.setSecondOperand(operand224);
                    }
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator282, Method: assocOperator282Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator283
	@Override
    public Collection<ReportesDominio> assocOperator283(Solicitud instance, Long solicitudTGETPLANTILLAREPORTEptTipo) throws SystemException {
        try {
            // FOR ALL Aesolicitudes.ProductoT.Dominios.ReportesDominio WHERE (Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = ptTipo AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici AND Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici) DO Aesolicitudes.ProductoT.Dominios.ReportesDominio.getDummy(Aesolicitudes.ProductoT.Dominios.ReportesDominio; oaPlantilla)
            Collection<ReportesDominio> results = new ArrayList<>();
            for(ReportesDominio item : assocOperator283Range1(instance, solicitudTGETPLANTILLAREPORTEptTipo)){
                // Aesolicitudes.ProductoT.Dominios.ReportesDominio.drvFechaHasta > Aesolicitudes.Fesolici
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAesolicitudes().getAesolicitudesFesolici()))
                    results.add(item);
            }
            return results;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator283, Method: assocOperator283";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator283
	@Override
    public Collection<ReportesDominio> assocOperator283Range1 (Solicitud instance, Long solicitudTGETPLANTILLAREPORTEptTipo) throws SystemException {

        SQLSelect sql = assocOperator283Range1Query(instance, solicitudTGETPLANTILLAREPORTEptTipo);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator283
	@Override
    public SQLPopulation assocOperator283Range1Query (Solicitud instance, Long solicitudTGETPLANTILLAREPORTEptTipo) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = ptTipo
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(solicitudTGETPLANTILLAREPORTEptTipo, Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().isNull() || instance.getAesolicitudes().getPlanT().isNull())
                    {
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAesolicitudes().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT);
                    comparison2.setSecondOperand(operand224);
                    }
                    conjunction.addOperand(comparison2);


            // Aesolicitudes.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= Aesolicitudes.Fesolici
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAesolicitudes().getAesolicitudesFesolici()!= null){
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(instance.getAesolicitudes().getAesolicitudesFesolici(), Constants.Type.DATE.getTypeName()));
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Solicitud, Assoc.Operator: AssocOperator283, Method: assocOperator283Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
