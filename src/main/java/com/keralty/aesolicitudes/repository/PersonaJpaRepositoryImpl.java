package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.DireccionConstants;
import com.keralty.aesolicitudes.global.PersonaConstants;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.global.TipoDireccionConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.persistence.Direccion;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.sqlutils.SQLExists;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLPopulation;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLWhereComparison;
import com.keralty.aesolicitudes.sqlutils.SQLWhereConjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandNull;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aesolicitudes.sqlutils.TypedQueryBuilder;
import com.keralty.aesolicitudes.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;

public class PersonaJpaRepositoryImpl extends AbstractRepository implements PersonaJpaRepositoryCustom {

    @Inject
    public PersonaJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<Persona> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Persona> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Persona> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Persona> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Persona.class);
    }

    @Override	
    public List<Persona> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<Persona> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
	@Override
    public Boolean assocOperator000(Persona instance) throws SystemException {
        try {
            // EXIST (Direcciones)
            return assocOperator000Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator000, Method: assocOperator000";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator000
	@Override
    public Boolean assocOperator000Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator000Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator000
	@Override
    public SQLExists assocOperator000Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_DIRECCIONES, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator001
	@Override
    public Boolean assocOperator001(Persona instance) throws SystemException {
        try {
            // EXIST (SolicitudesContratante.GrupoAsociado)
            return assocOperator001Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator001, Method: assocOperator001";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator001
	@Override
    public Boolean assocOperator001Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator001Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator001
	@Override
    public SQLExists assocOperator001Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_SOLICITUDESCONTRATANTE + "." + SolicitudConstants.ROLE_NAME_GRUPOASOCIADO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator002
	@Override
    public Boolean assocOperator002(Persona instance) throws SystemException {
        try {
            // EXIST (SolicitudesContratante) WHERE (SolicitudesContratante.Tramite = 2)
            return assocOperator002Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator002, Method: assocOperator002";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator002
	@Override
    public Boolean assocOperator002Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator002Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator002
	@Override
    public SQLExists assocOperator002Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_SOLICITUDESCONTRATANTE, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // SolicitudesContratante.Tramite = 2
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(PersonaConstants.ROLE_NAME_SOLICITUDESCONTRATANTE + "." + SolicitudConstants.ATTR_NAME_SOLICITUDTRAMITE, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(2), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator003
	@Override
    public Boolean assocOperator003(Persona instance) throws SystemException {
        try {
            // EXIST (SolicitudesTitular) WHERE (SolicitudesTitular.Tramite = 1)
            return assocOperator003Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator003, Method: assocOperator003";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator003
	@Override
    public Boolean assocOperator003Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator003Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator003
	@Override
    public SQLExists assocOperator003Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_SOLICITUDESTITULAR, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // SolicitudesTitular.Tramite = 1
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(PersonaConstants.ROLE_NAME_SOLICITUDESTITULAR + "." + SolicitudConstants.ATTR_NAME_SOLICITUDTRAMITE, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator004
	@Override
    public Boolean assocOperator004(Persona instance) throws SystemException {
        try {
            // EXIST (SolicitudesTitular) WHERE (SolicitudesTitular.Tramite <> 1 AND SolicitudesTitular.NumFamilia = NULL)
            return assocOperator004Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator004, Method: assocOperator004";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator004
	@Override
    public Boolean assocOperator004Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator004Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator004
	@Override
    public SQLExists assocOperator004Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_SOLICITUDESTITULAR, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // SolicitudesTitular.Tramite <> 1
                    // '<>' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(PersonaConstants.ROLE_NAME_SOLICITUDESTITULAR + "." + SolicitudConstants.ATTR_NAME_SOLICITUDTRAMITE, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);


            // SolicitudesTitular.NumFamilia = NULL
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(PersonaConstants.ROLE_NAME_SOLICITUDESTITULAR + "." + SolicitudConstants.ATTR_NAME_SOLICITUDNUMFAMILIA, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator004, Method: assocOperator004Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator015
	@Override
    public Boolean assocOperator015(Persona instance) throws SystemException {
        try {
            // EXIST (DepartamentoNacimiento)
            return assocOperator015Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator015, Method: assocOperator015";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator015
	@Override
    public Boolean assocOperator015Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator015Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator015
	@Override
    public SQLExists assocOperator015Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_DEPARTAMENTONACIMIENTO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator015, Method: assocOperator015Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator016
	@Override
    public Boolean assocOperator016(Persona instance) throws SystemException {
        try {
            // EXIST (DepartamentoNacimiento)
            return assocOperator016Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator016, Method: assocOperator016";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator016
	@Override
    public Boolean assocOperator016Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator016Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator016
	@Override
    public SQLExists assocOperator016Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_DEPARTAMENTONACIMIENTO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator016, Method: assocOperator016Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator018
	@Override
    public Boolean assocOperator018(Persona instance) throws SystemException {
        try {
            // EXIST (MunicipioNacimiento)
            return assocOperator018Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator018, Method: assocOperator018";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator018
	@Override
    public Boolean assocOperator018Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator018Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator018
	@Override
    public SQLExists assocOperator018Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_MUNICIPIONACIMIENTO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator018, Method: assocOperator018Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator019
	@Override
    public Boolean assocOperator019(Persona instance) throws SystemException {
        try {
            // EXIST (MunicipioNacimiento)
            return assocOperator019Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator019, Method: assocOperator019";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator019
	@Override
    public Boolean assocOperator019Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator019Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator019
	@Override
    public SQLExists assocOperator019Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_MUNICIPIONACIMIENTO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator019, Method: assocOperator019Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator021
	@Override
    public Boolean assocOperator021(Persona instance) throws SystemException {
        try {
            // EXIST (EstadoCivil)
            return assocOperator021Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator021, Method: assocOperator021";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator021
	@Override
    public Boolean assocOperator021Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator021Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator021
	@Override
    public SQLExists assocOperator021Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_ESTADOCIVIL, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator021, Method: assocOperator021Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator022
	@Override
    public Boolean assocOperator022(Persona instance) throws SystemException {
        try {
            // EXIST (EstadoCivil)
            return assocOperator022Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator022, Method: assocOperator022";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator022
	@Override
    public Boolean assocOperator022Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator022Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator022
	@Override
    public SQLExists assocOperator022Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_ESTADOCIVIL, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator022, Method: assocOperator022Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator024
	@Override
    public Boolean assocOperator024(Persona instance) throws SystemException {
        try {
            // EXIST (DepartamentoNacimiento)
            return assocOperator024Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator024, Method: assocOperator024";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator024
	@Override
    public Boolean assocOperator024Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator024Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator024
	@Override
    public SQLExists assocOperator024Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_DEPARTAMENTONACIMIENTO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator024, Method: assocOperator024Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator025
	@Override
    public Boolean assocOperator025(Persona instance) throws SystemException {
        try {
            // EXIST (DepartamentoNacimiento)
            return assocOperator025Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator025, Method: assocOperator025";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator025
	@Override
    public Boolean assocOperator025Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator025Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator025
	@Override
    public SQLExists assocOperator025Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_DEPARTAMENTONACIMIENTO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator025, Method: assocOperator025Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator026
	@Override
    public Boolean assocOperator026(Persona instance) throws SystemException {
        try {
            // EXIST (DepartamentoNacimiento)
            return assocOperator026Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator026, Method: assocOperator026";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator026
	@Override
    public Boolean assocOperator026Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator026Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator026
	@Override
    public SQLExists assocOperator026Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_DEPARTAMENTONACIMIENTO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator026, Method: assocOperator026Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator027
	@Override
    public Boolean assocOperator027(Persona instance) throws SystemException {
        try {
            // EXIST (MunicipioNacimiento)
            return assocOperator027Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator027, Method: assocOperator027";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator027
	@Override
    public Boolean assocOperator027Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator027Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator027
	@Override
    public SQLExists assocOperator027Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_MUNICIPIONACIMIENTO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator027, Method: assocOperator027Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator028
	@Override
    public Boolean assocOperator028(Persona instance) throws SystemException {
        try {
            // EXIST (MunicipioNacimiento)
            return assocOperator028Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator028, Method: assocOperator028";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator028
	@Override
    public Boolean assocOperator028Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator028Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator028
	@Override
    public SQLExists assocOperator028Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_MUNICIPIONACIMIENTO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator028, Method: assocOperator028Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator029
	@Override
    public Boolean assocOperator029(Persona instance) throws SystemException {
        try {
            // EXIST (MunicipioNacimiento)
            return assocOperator029Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator029, Method: assocOperator029";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator029
	@Override
    public Boolean assocOperator029Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator029Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator029
	@Override
    public SQLExists assocOperator029Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_MUNICIPIONACIMIENTO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator029, Method: assocOperator029Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator030
	@Override
    public Boolean assocOperator030(Persona instance) throws SystemException {
        try {
            // EXIST (EstadoPersona)
            return assocOperator030Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator030, Method: assocOperator030";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator030
	@Override
    public Boolean assocOperator030Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator030Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator030
	@Override
    public SQLExists assocOperator030Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_ESTADOPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator030, Method: assocOperator030Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator031
	@Override
    public Boolean assocOperator031(Persona instance) throws SystemException {
        try {
            // EXIST (DepartamentoNacimiento)
            return assocOperator031Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator031, Method: assocOperator031";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator031
	@Override
    public Boolean assocOperator031Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator031Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator031
	@Override
    public SQLExists assocOperator031Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_DEPARTAMENTONACIMIENTO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator031, Method: assocOperator031Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator032
	@Override
    public Boolean assocOperator032(Persona instance) throws SystemException {
        try {
            // EXIST (MunicipioNacimiento)
            return assocOperator032Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator032, Method: assocOperator032";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator032
	@Override
    public Boolean assocOperator032Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator032Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator032
	@Override
    public SQLExists assocOperator032Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_MUNICIPIONACIMIENTO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator032, Method: assocOperator032Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator033
	@Override
    public Boolean assocOperator033(Persona instance) throws SystemException {
        try {
            // EXIST (EstadoCivil)
            return assocOperator033Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator033, Method: assocOperator033";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator033
	@Override
    public Boolean assocOperator033Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator033Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator033
	@Override
    public SQLExists assocOperator033Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_ESTADOCIVIL, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator033, Method: assocOperator033Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator052
	@Override
    public Boolean assocOperator052(Persona instance) throws SystemException {
        try {
            // EXIST (DepartamentoNacimiento)
            return assocOperator052Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator052, Method: assocOperator052";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator052
	@Override
    public Boolean assocOperator052Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator052Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator052
	@Override
    public SQLExists assocOperator052Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_DEPARTAMENTONACIMIENTO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator052, Method: assocOperator052Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator053
	@Override
    public Boolean assocOperator053(Persona instance) throws SystemException {
        try {
            // EXIST (DepartamentoNacimiento)
            return assocOperator053Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator053, Method: assocOperator053";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator053
	@Override
    public Boolean assocOperator053Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator053Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator053
	@Override
    public SQLExists assocOperator053Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_DEPARTAMENTONACIMIENTO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator053, Method: assocOperator053Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator055
	@Override
    public Boolean assocOperator055(Persona instance) throws SystemException {
        try {
            // EXIST (MunicipioNacimiento)
            return assocOperator055Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator055, Method: assocOperator055";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator055
	@Override
    public Boolean assocOperator055Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator055Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator055
	@Override
    public SQLExists assocOperator055Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_MUNICIPIONACIMIENTO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator055, Method: assocOperator055Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator056
	@Override
    public Boolean assocOperator056(Persona instance) throws SystemException {
        try {
            // EXIST (MunicipioNacimiento)
            return assocOperator056Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator056, Method: assocOperator056";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator056
	@Override
    public Boolean assocOperator056Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator056Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator056
	@Override
    public SQLExists assocOperator056Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_MUNICIPIONACIMIENTO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator056, Method: assocOperator056Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator058
	@Override
    public Boolean assocOperator058(Persona instance) throws SystemException {
        try {
            // EXIST (EstadoCivil)
            return assocOperator058Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator058, Method: assocOperator058";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator058
	@Override
    public Boolean assocOperator058Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator058Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator058
	@Override
    public SQLExists assocOperator058Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_ESTADOCIVIL, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator058, Method: assocOperator058Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator059
	@Override
    public Boolean assocOperator059(Persona instance) throws SystemException {
        try {
            // EXIST (EstadoCivil)
            return assocOperator059Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator059, Method: assocOperator059";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator059
	@Override
    public Boolean assocOperator059Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator059Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator059
	@Override
    public SQLExists assocOperator059Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_ESTADOCIVIL, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator059, Method: assocOperator059Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator061
	@Override
    public Boolean assocOperator061(Persona instance) throws SystemException {
        try {
            // EXIST (EstadoPersona)
            return assocOperator061Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator061, Method: assocOperator061";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator061
	@Override
    public Boolean assocOperator061Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator061Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator061
	@Override
    public SQLExists assocOperator061Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_ESTADOPERSONA, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator061, Method: assocOperator061Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator062
	@Override
    public Boolean assocOperator062(Persona instance) throws SystemException {
        try {
            // EXIST (DepartamentoNacimiento)
            return assocOperator062Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator062, Method: assocOperator062";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator062
	@Override
    public Boolean assocOperator062Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator062Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator062
	@Override
    public SQLExists assocOperator062Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_DEPARTAMENTONACIMIENTO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator062, Method: assocOperator062Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator063
	@Override
    public Boolean assocOperator063(Persona instance) throws SystemException {
        try {
            // EXIST (MunicipioNacimiento)
            return assocOperator063Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator063, Method: assocOperator063";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator063
	@Override
    public Boolean assocOperator063Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator063Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator063
	@Override
    public SQLExists assocOperator063Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_MUNICIPIONACIMIENTO, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator063, Method: assocOperator063Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator064
	@Override
    public Boolean assocOperator064(Persona instance) throws SystemException {
        try {
            // EXIST (EstadoCivil)
            return assocOperator064Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator064, Method: assocOperator064";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator064
	@Override
    public Boolean assocOperator064Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator064Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator064
	@Override
    public SQLExists assocOperator064Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_ESTADOCIVIL, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator064, Method: assocOperator064Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator071
	@Override
    public Collection<Direccion> assocOperator071(Persona instance) throws SystemException {
        try {
            // FOR ALL Direcciones WHERE (Direcciones.TipoDireccion.EsResidencia = true) DO Direcciones.TMODIFICAR(Direcciones, ptpDireccionCompleta, ptpRural, ptpevcDepartamento, ptpevcMunicipio, ptpagrPais, Direcciones.TipoDireccion)
        return assocOperator071Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator071, Method: assocOperator071";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator071
	@Override
    public Collection<Direccion> assocOperator071Range1 (Persona instance) throws SystemException {

        SQLSelect sql = assocOperator071Range1Query(instance);
        return new TypedQueryBuilder<Direccion>(em, Direccion.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator071
	@Override
    public SQLPopulation assocOperator071Range1Query (Persona instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(PersonaConstants.CLASS_NAME, DireccionConstants.CLASS_NAME, instance.getOid(), PersonaConstants.ROLE_NAME_DIRECCIONES);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Direcciones.TipoDireccion.EsResidencia = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(PersonaConstants.ROLE_NAME_DIRECCIONES + "." + DireccionConstants.ROLE_NAME_TIPODIRECCION + "." + TipoDireccionConstants.ATTR_NAME_TIPODIRECCIONESRESIDENCIA, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator071, Method: assocOperator071Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator073
	@Override
    public Collection<Direccion> assocOperator073(Persona instance) throws SystemException {
        try {
            // FOR ALL Direcciones WHERE (Direcciones.TipoDireccion.EsCorrespondencia = true) DO Direcciones.TMODIFICAR(Direcciones, pDCDireccionCompleta, pDCRural, pDCDepartamento, pDCMunicipio, ptpagrPais, Direcciones.TipoDireccion)
        return assocOperator073Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator073, Method: assocOperator073";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator073
	@Override
    public Collection<Direccion> assocOperator073Range1 (Persona instance) throws SystemException {

        SQLSelect sql = assocOperator073Range1Query(instance);
        return new TypedQueryBuilder<Direccion>(em, Direccion.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator073
	@Override
    public SQLPopulation assocOperator073Range1Query (Persona instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(PersonaConstants.CLASS_NAME, DireccionConstants.CLASS_NAME, instance.getOid(), PersonaConstants.ROLE_NAME_DIRECCIONES);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Direcciones.TipoDireccion.EsCorrespondencia = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(PersonaConstants.ROLE_NAME_DIRECCIONES + "." + DireccionConstants.ROLE_NAME_TIPODIRECCION + "." + TipoDireccionConstants.ATTR_NAME_TIPODIRECCIONESCORRESPONDENCIA, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator073, Method: assocOperator073Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator074
	@Override
    public Boolean assocOperator074(Persona instance) throws SystemException {
        try {
            // EXIST (Direcciones) WHERE (Direcciones.TipoDireccion.EsResidencia = true)
            return assocOperator074Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator074, Method: assocOperator074";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator074
	@Override
    public Boolean assocOperator074Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator074Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator074
	@Override
    public SQLExists assocOperator074Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_DIRECCIONES, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Direcciones.TipoDireccion.EsResidencia = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(PersonaConstants.ROLE_NAME_DIRECCIONES + "." + DireccionConstants.ROLE_NAME_TIPODIRECCION + "." + TipoDireccionConstants.ATTR_NAME_TIPODIRECCIONESRESIDENCIA, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator074, Method: assocOperator074Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator075
	@Override
    public Boolean assocOperator075(Persona instance) throws SystemException {
        try {
            // EXIST (Direcciones) WHERE (Direcciones.TipoDireccion.EsCorrespondencia = true)
            return assocOperator075Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator075, Method: assocOperator075";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator075
	@Override
    public Boolean assocOperator075Range1 (Persona instance) throws SystemException {
        SQLExists sql = assocOperator075Range1Query(instance);
        return !new TypedQueryBuilder<Persona>(em, Persona.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator075
	@Override
    public SQLExists assocOperator075Range1Query (Persona instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(PersonaConstants.CLASS_NAME, PersonaConstants.ROLE_NAME_DIRECCIONES, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Direcciones.TipoDireccion.EsCorrespondencia = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(PersonaConstants.ROLE_NAME_DIRECCIONES + "." + DireccionConstants.ROLE_NAME_TIPODIRECCION + "." + TipoDireccionConstants.ATTR_NAME_TIPODIRECCIONESCORRESPONDENCIA, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Persona, Assoc.Operator: AssocOperator075, Method: assocOperator075Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
