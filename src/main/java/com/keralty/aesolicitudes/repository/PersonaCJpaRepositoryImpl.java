package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.CuestionarioPConstants;
import com.keralty.aesolicitudes.global.DireccionCConstants;
import com.keralty.aesolicitudes.global.DireccionConstants;
import com.keralty.aesolicitudes.global.DirSucursalCConstants;
import com.keralty.aesolicitudes.global.MarcaMedicaCConstants;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.global.PersonaConstants;
import com.keralty.aesolicitudes.global.PreexistenciaCConstants;
import com.keralty.aesolicitudes.global.PreexistenciaConstants;
import com.keralty.aesolicitudes.global.PregCuesMedCConstants;
import com.keralty.aesolicitudes.global.PreguntaPConstants;
import com.keralty.aesolicitudes.global.ProteccionDatosCConstants;
import com.keralty.aesolicitudes.global.SeccionPConstants;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.global.TipoDireccionConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.global.UsuarioConstants;
import com.keralty.aesolicitudes.persistence.CuestionarioP;
import com.keralty.aesolicitudes.persistence.Direccion;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.MarcaMedicaC;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Preexistencia;
import com.keralty.aesolicitudes.persistence.PreexistenciaC;
import com.keralty.aesolicitudes.persistence.PregCuesMedC;
import com.keralty.aesolicitudes.persistence.PreguntaP;
import com.keralty.aesolicitudes.persistence.ProteccionDatosC;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.Usuario;
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
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandSubQuery;
import com.keralty.aesolicitudes.sqlutils.TypedQueryBuilder;
import com.keralty.aesolicitudes.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import java.util.List;

public class PersonaCJpaRepositoryImpl extends AbstractRepository implements PersonaCJpaRepositoryCustom {

    @Inject
    public PersonaCJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<PersonaC> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<PersonaC> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<PersonaC> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<PersonaC> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, PersonaC.class);
    }

    @Override	
    public List<PersonaC> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<PersonaC> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
	@Override
    public Boolean assocOperator000(PersonaC instance) throws SystemException {
        try {
            // EXIST (DireccionesC) WHERE (DireccionesC.TipoDireccionC.Descripcion LIKE "CORR%")
            return assocOperator000Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator000, Method: assocOperator000";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator000
	@Override
    public Boolean assocOperator000Range1 (PersonaC instance) throws SystemException {
        SQLExists sql = assocOperator000Range1Query(instance);
        return !new TypedQueryBuilder<PersonaC>(em, PersonaC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator000
	@Override
    public SQLExists assocOperator000Range1Query (PersonaC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(PersonaCConstants.CLASS_NAME, PersonaCConstants.ROLE_NAME_DIRECCIONESC, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // DireccionesC.TipoDireccionC.Descripcion LIKE "CORR%"
                    // 'like' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("like");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(PersonaCConstants.ROLE_NAME_DIRECCIONESC + "." + DireccionCConstants.ROLE_NAME_TIPODIRECCIONC + "." + TipoDireccionConstants.ATTR_NAME_TIPODIRECCIONDESCRIPCION, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral("CORR%", Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator001
	@Override
    public String assocOperator001(PersonaC instance) throws SystemException {
        try {
            // GETONE (DireccionesC.DireccionCompleta) WHERE (DireccionesC.TipoDireccionC.Descripcion LIKE "CORR%")
            return assocOperator001Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator001, Method: assocOperator001";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator001
	@Override
    public String assocOperator001Range1 (PersonaC instance) throws SystemException {
        SQLGetOne sql = assocOperator001Range1Query(instance);
        List<String> results = new TypedQueryBuilder<String>(em, String.class).build(sql).execute();
        return !results.isEmpty() ? results.get(0) : null;
    }

    // Range Query 1 for AssocOperator AssocOperator001
	@Override
    public SQLGetOne assocOperator001Range1Query (PersonaC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLGetOne sql = new SQLGetOne(PersonaCConstants.CLASS_NAME, PersonaCConstants.ROLE_NAME_DIRECCIONESC + "." + DireccionCConstants.ATTR_NAME_DIRECCIONCDIRECCIONCOMPLETA, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // DireccionesC.TipoDireccionC.Descripcion LIKE "CORR%"
                    // 'like' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("like");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(PersonaCConstants.ROLE_NAME_DIRECCIONESC + "." + DireccionCConstants.ROLE_NAME_TIPODIRECCIONC + "." + TipoDireccionConstants.ATTR_NAME_TIPODIRECCIONDESCRIPCION, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral("CORR%", Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator002
	@Override
    public Boolean assocOperator002(PersonaC instance) throws SystemException {
        try {
            // EXIST (DirSucursalesC) WHERE (DirSucursalesC.EsPrincipal = true)
            return assocOperator002Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator002, Method: assocOperator002";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator002
	@Override
    public Boolean assocOperator002Range1 (PersonaC instance) throws SystemException {
        SQLExists sql = assocOperator002Range1Query(instance);
        return !new TypedQueryBuilder<PersonaC>(em, PersonaC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator002
	@Override
    public SQLExists assocOperator002Range1Query (PersonaC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(PersonaCConstants.CLASS_NAME, PersonaCConstants.ROLE_NAME_DIRSUCURSALESC, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // DirSucursalesC.EsPrincipal = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(PersonaCConstants.ROLE_NAME_DIRSUCURSALESC + "." + DirSucursalCConstants.ATTR_NAME_DIRSUCURSALCESPRINCIPAL, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator003
	@Override
    public String assocOperator003(PersonaC instance) throws SystemException {
        try {
            // GETONE (DirSucursalesC.Direccion) WHERE (DirSucursalesC.EsPrincipal = true)
            return assocOperator003Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator003, Method: assocOperator003";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator003
	@Override
    public String assocOperator003Range1 (PersonaC instance) throws SystemException {
        SQLGetOne sql = assocOperator003Range1Query(instance);
        List<String> results = new TypedQueryBuilder<String>(em, String.class).build(sql).execute();
        return !results.isEmpty() ? results.get(0) : null;
    }

    // Range Query 1 for AssocOperator AssocOperator003
	@Override
    public SQLGetOne assocOperator003Range1Query (PersonaC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLGetOne sql = new SQLGetOne(PersonaCConstants.CLASS_NAME, PersonaCConstants.ROLE_NAME_DIRSUCURSALESC + "." + DirSucursalCConstants.ATTR_NAME_DIRSUCURSALCDIRECCION, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // DirSucursalesC.EsPrincipal = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(PersonaCConstants.ROLE_NAME_DIRSUCURSALESC + "." + DirSucursalCConstants.ATTR_NAME_DIRSUCURSALCESPRINCIPAL, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator004
	@Override
    public Boolean assocOperator004(PersonaC instance) throws SystemException {
        try {
            // EXIST (DireccionesC) WHERE (DireccionesC.TipoDireccionC.Descripcion LIKE "CORR%")
            return assocOperator004Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator004, Method: assocOperator004";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator004
	@Override
    public Boolean assocOperator004Range1 (PersonaC instance) throws SystemException {
        SQLExists sql = assocOperator004Range1Query(instance);
        return !new TypedQueryBuilder<PersonaC>(em, PersonaC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator004
	@Override
    public SQLExists assocOperator004Range1Query (PersonaC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(PersonaCConstants.CLASS_NAME, PersonaCConstants.ROLE_NAME_DIRECCIONESC, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // DireccionesC.TipoDireccionC.Descripcion LIKE "CORR%"
                    // 'like' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("like");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(PersonaCConstants.ROLE_NAME_DIRECCIONESC + "." + DireccionCConstants.ROLE_NAME_TIPODIRECCIONC + "." + TipoDireccionConstants.ATTR_NAME_TIPODIRECCIONDESCRIPCION, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral("CORR%", Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator004, Method: assocOperator004Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator005
	@Override
    public String assocOperator005(PersonaC instance) throws SystemException {
        try {
            // GETONE (DireccionesC.drvCiudad) WHERE (DireccionesC.TipoDireccionC.Descripcion LIKE "CORR%")
            String result = null;
            for(DireccionC item : assocOperator005Range1(instance)){

                if (result == null) result = item.getDireccionCdrvCiudad();
            }
            return result != null ? result : "";
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator005, Method: assocOperator005";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator005
	@Override
    public Collection<DireccionC> assocOperator005Range1 (PersonaC instance) throws SystemException {

        SQLSelect sql = assocOperator005Range1Query(instance);
        return new TypedQueryBuilder<DireccionC>(em, DireccionC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator005
	@Override
    public SQLPopulation assocOperator005Range1Query (PersonaC instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(PersonaCConstants.CLASS_NAME, DireccionCConstants.CLASS_NAME, instance.getOid(), PersonaCConstants.ROLE_NAME_DIRECCIONESC);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // DireccionesC.TipoDireccionC.Descripcion LIKE "CORR%"
                    // 'like' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("like");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(PersonaCConstants.ROLE_NAME_DIRECCIONESC + "." + DireccionCConstants.ROLE_NAME_TIPODIRECCIONC + "." + TipoDireccionConstants.ATTR_NAME_TIPODIRECCIONDESCRIPCION, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral("CORR%", Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator005, Method: assocOperator005Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator006
	@Override
    public Boolean assocOperator006(PersonaC instance) throws SystemException {
        try {
            // EXIST (DirSucursalesC) WHERE (DirSucursalesC.EsPrincipal = true)
            return assocOperator006Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator006, Method: assocOperator006";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator006
	@Override
    public Boolean assocOperator006Range1 (PersonaC instance) throws SystemException {
        SQLExists sql = assocOperator006Range1Query(instance);
        return !new TypedQueryBuilder<PersonaC>(em, PersonaC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator006
	@Override
    public SQLExists assocOperator006Range1Query (PersonaC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(PersonaCConstants.CLASS_NAME, PersonaCConstants.ROLE_NAME_DIRSUCURSALESC, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // DirSucursalesC.EsPrincipal = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(PersonaCConstants.ROLE_NAME_DIRSUCURSALESC + "." + DirSucursalCConstants.ATTR_NAME_DIRSUCURSALCESPRINCIPAL, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator006, Method: assocOperator006Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator007
	@Override
    public String assocOperator007(PersonaC instance) throws SystemException {
        try {
            // GETONE (DirSucursalesC.drvCiudad) WHERE (DirSucursalesC.EsPrincipal = true)
            String result = null;
            for(DirSucursalC item : assocOperator007Range1(instance)){

                if (result == null) result = item.getDirSucursalCdrvCiudad();
            }
            return result != null ? result : "";
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator007, Method: assocOperator007";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator007
	@Override
    public Collection<DirSucursalC> assocOperator007Range1 (PersonaC instance) throws SystemException {

        SQLSelect sql = assocOperator007Range1Query(instance);
        return new TypedQueryBuilder<DirSucursalC>(em, DirSucursalC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator007
	@Override
    public SQLPopulation assocOperator007Range1Query (PersonaC instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(PersonaCConstants.CLASS_NAME, DirSucursalCConstants.CLASS_NAME, instance.getOid(), PersonaCConstants.ROLE_NAME_DIRSUCURSALESC);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // DirSucursalesC.EsPrincipal = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(PersonaCConstants.ROLE_NAME_DIRSUCURSALESC + "." + DirSucursalCConstants.ATTR_NAME_DIRSUCURSALCESPRINCIPAL, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator007, Method: assocOperator007Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator008
	@Override
    public Boolean assocOperator008(PersonaC instance) throws SystemException {
        try {
            // EXIST (PreexistenciasC)
            return assocOperator008Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator008, Method: assocOperator008";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator008
	@Override
    public Boolean assocOperator008Range1 (PersonaC instance) throws SystemException {
        SQLExists sql = assocOperator008Range1Query(instance);
        return !new TypedQueryBuilder<PersonaC>(em, PersonaC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator008
	@Override
    public SQLExists assocOperator008Range1Query (PersonaC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaCConstants.CLASS_NAME, PersonaCConstants.ROLE_NAME_PREEXISTENCIASC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator008, Method: assocOperator008Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator009
	@Override
    public Boolean assocOperator009(PersonaC instance) throws SystemException {
        try {
            // EXIST (ContratosC)
            return assocOperator009Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator009, Method: assocOperator009";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator009
	@Override
    public Boolean assocOperator009Range1 (PersonaC instance) throws SystemException {
        SQLExists sql = assocOperator009Range1Query(instance);
        return !new TypedQueryBuilder<PersonaC>(em, PersonaC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator009
	@Override
    public SQLExists assocOperator009Range1Query (PersonaC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaCConstants.CLASS_NAME, PersonaCConstants.ROLE_NAME_CONTRATOSC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator009, Method: assocOperator009Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator010
	@Override
    public Boolean assocOperator010(PersonaC instance) throws SystemException {
        try {
            // EXIST (FamiliasC)
            return assocOperator010Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator010, Method: assocOperator010";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator010
	@Override
    public Boolean assocOperator010Range1 (PersonaC instance) throws SystemException {
        SQLExists sql = assocOperator010Range1Query(instance);
        return !new TypedQueryBuilder<PersonaC>(em, PersonaC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator010
	@Override
    public SQLExists assocOperator010Range1Query (PersonaC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaCConstants.CLASS_NAME, PersonaCConstants.ROLE_NAME_FAMILIASC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator010, Method: assocOperator010Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator011
	@Override
    public Boolean assocOperator011(PersonaC instance) throws SystemException {
        try {
            // EXIST (BeneficiariosC)
            return assocOperator011Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator011, Method: assocOperator011";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator011
	@Override
    public Boolean assocOperator011Range1 (PersonaC instance) throws SystemException {
        SQLExists sql = assocOperator011Range1Query(instance);
        return !new TypedQueryBuilder<PersonaC>(em, PersonaC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator011
	@Override
    public SQLExists assocOperator011Range1Query (PersonaC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaCConstants.CLASS_NAME, PersonaCConstants.ROLE_NAME_BENEFICIARIOSC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator011, Method: assocOperator011Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator013
	@Override
    public Collection<PregCuesMedC> assocOperator013(PersonaC instance) throws SystemException {
        try {
            // FOR ALL PregsCuesMedC DO PregsCuesMedC.eliminar(PregsCuesMedC)
        return assocOperator013Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator013, Method: assocOperator013";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator013
	@Override
    public Collection<PregCuesMedC> assocOperator013Range1 (PersonaC instance) throws SystemException {

        SQLSelect sql = assocOperator013Range1Query(instance);
        return new TypedQueryBuilder<PregCuesMedC>(em, PregCuesMedC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator013
	@Override
    public SQLPopulation assocOperator013Range1Query (PersonaC instance) throws SystemException {
        try {
            return new SQLPopulation(PersonaCConstants.CLASS_NAME, PregCuesMedCConstants.CLASS_NAME, instance.getOid(), PersonaCConstants.ROLE_NAME_PREGSCUESMEDC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator013, Method: assocOperator013Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator014
	@Override
    public Collection<PreguntaP> assocOperator014(PersonaC personaCTCREAROCUESDEAEpthisPersonaC, CuestionarioP personaCTCREAROCUESDEAEpCuestionarioP) throws SystemException {
        try {
            // FOR ALL pCuestionarioP.Secciones.Preguntas DO PregsCuesMedC.crear(this, pCuestionarioP.Secciones.Preguntas.Numero, pCuestionarioP.Secciones.Preguntas.RespuestaSiNo, pCuestionarioP.Secciones.Preguntas.drvRespuesta)
        return assocOperator014Range1(personaCTCREAROCUESDEAEpCuestionarioP);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator014, Method: assocOperator014";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator014
	@Override
    public Collection<PreguntaP> assocOperator014Range1 (CuestionarioP personaCTCREAROCUESDEAEpCuestionarioP) throws SystemException {

        SQLSelect sql = assocOperator014Range1Query(personaCTCREAROCUESDEAEpCuestionarioP);
        return new TypedQueryBuilder<PreguntaP>(em, PreguntaP.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator014
	@Override
    public SQLPopulation assocOperator014Range1Query (CuestionarioP personaCTCREAROCUESDEAEpCuestionarioP) throws SystemException {
        try {
            return new SQLPopulation(PersonaCConstants.CLASS_NAME, PreguntaPConstants.CLASS_NAME, PersonaCConstants.ARG_NAME_TCREAROCUESDEAE_PERSONACTCREAROCUESDEAEPCUESTIONARIOP + "." + CuestionarioPConstants.ROLE_NAME_SECCIONES + "." + SeccionPConstants.ROLE_NAME_PREGUNTAS, personaCTCREAROCUESDEAEpCuestionarioP.getOid(), PersonaCConstants.ARG_NAME_TCREAROCUESDEAE_PERSONACTCREAROCUESDEAEPCUESTIONARIOP);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator014, Method: assocOperator014Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator015
	@Override
    public Boolean assocOperator015(PersonaC instance) throws SystemException {
        try {
            // EXIST (PregsCuesMedC)
            return assocOperator015Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator015, Method: assocOperator015";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator015
	@Override
    public Boolean assocOperator015Range1 (PersonaC instance) throws SystemException {
        SQLExists sql = assocOperator015Range1Query(instance);
        return !new TypedQueryBuilder<PersonaC>(em, PersonaC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator015
	@Override
    public SQLExists assocOperator015Range1Query (PersonaC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(PersonaCConstants.CLASS_NAME, PersonaCConstants.ROLE_NAME_PREGSCUESMEDC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator015, Method: assocOperator015Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator016
	@Override
    public Collection<PregCuesMedC> assocOperator016(PersonaC instance) throws SystemException {
        try {
            // FOR ALL PregsCuesMedC DO PregsCuesMedC.eliminar(PregsCuesMedC)
        return assocOperator016Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator016, Method: assocOperator016";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator016
	@Override
    public Collection<PregCuesMedC> assocOperator016Range1 (PersonaC instance) throws SystemException {

        SQLSelect sql = assocOperator016Range1Query(instance);
        return new TypedQueryBuilder<PregCuesMedC>(em, PregCuesMedC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator016
	@Override
    public SQLPopulation assocOperator016Range1Query (PersonaC instance) throws SystemException {
        try {
            return new SQLPopulation(PersonaCConstants.CLASS_NAME, PregCuesMedCConstants.CLASS_NAME, instance.getOid(), PersonaCConstants.ROLE_NAME_PREGSCUESMEDC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator016, Method: assocOperator016Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator017
	@Override
    public Collection<DireccionC> assocOperator017(PersonaC instance) throws SystemException {
        try {
            // FOR ALL DireccionesC DO DireccionesC.TELIMINAR(DireccionesC)
        return assocOperator017Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator017, Method: assocOperator017";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator017
	@Override
    public Collection<DireccionC> assocOperator017Range1 (PersonaC instance) throws SystemException {

        SQLSelect sql = assocOperator017Range1Query(instance);
        return new TypedQueryBuilder<DireccionC>(em, DireccionC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator017
	@Override
    public SQLPopulation assocOperator017Range1Query (PersonaC instance) throws SystemException {
        try {
            return new SQLPopulation(PersonaCConstants.CLASS_NAME, DireccionCConstants.CLASS_NAME, instance.getOid(), PersonaCConstants.ROLE_NAME_DIRECCIONESC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator017, Method: assocOperator017Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator018
	@Override
    public Collection<DirSucursalC> assocOperator018(PersonaC instance) throws SystemException {
        try {
            // FOR ALL DirSucursalesC DO DirSucursalesC.TELIMINAR(DirSucursalesC)
        return assocOperator018Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator018, Method: assocOperator018";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator018
	@Override
    public Collection<DirSucursalC> assocOperator018Range1 (PersonaC instance) throws SystemException {

        SQLSelect sql = assocOperator018Range1Query(instance);
        return new TypedQueryBuilder<DirSucursalC>(em, DirSucursalC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator018
	@Override
    public SQLPopulation assocOperator018Range1Query (PersonaC instance) throws SystemException {
        try {
            return new SQLPopulation(PersonaCConstants.CLASS_NAME, DirSucursalCConstants.CLASS_NAME, instance.getOid(), PersonaCConstants.ROLE_NAME_DIRSUCURSALESC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator018, Method: assocOperator018Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator019
	@Override
    public Collection<ProteccionDatosC> assocOperator019(PersonaC instance) throws SystemException {
        try {
            // FOR ALL ProteccionesDatosC DO ProteccionesDatosC.eliminar(ProteccionesDatosC)
        return assocOperator019Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator019, Method: assocOperator019";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator019
	@Override
    public Collection<ProteccionDatosC> assocOperator019Range1 (PersonaC instance) throws SystemException {

        SQLSelect sql = assocOperator019Range1Query(instance);
        return new TypedQueryBuilder<ProteccionDatosC>(em, ProteccionDatosC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator019
	@Override
    public SQLPopulation assocOperator019Range1Query (PersonaC instance) throws SystemException {
        try {
            return new SQLPopulation(PersonaCConstants.CLASS_NAME, ProteccionDatosCConstants.CLASS_NAME, instance.getOid(), PersonaCConstants.ROLE_NAME_PROTECCIONESDATOSC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator019, Method: assocOperator019Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator020
	@Override
    public Collection<MarcaMedicaC> assocOperator020(PersonaC instance) throws SystemException {
        try {
            // FOR ALL MarcasMedicasC DO MarcasMedicasC.eliminar(MarcasMedicasC)
        return assocOperator020Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator020, Method: assocOperator020";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator020
	@Override
    public Collection<MarcaMedicaC> assocOperator020Range1 (PersonaC instance) throws SystemException {

        SQLSelect sql = assocOperator020Range1Query(instance);
        return new TypedQueryBuilder<MarcaMedicaC>(em, MarcaMedicaC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator020
	@Override
    public SQLPopulation assocOperator020Range1Query (PersonaC instance) throws SystemException {
        try {
            return new SQLPopulation(PersonaCConstants.CLASS_NAME, MarcaMedicaCConstants.CLASS_NAME, instance.getOid(), PersonaCConstants.ROLE_NAME_MARCASMEDICASC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator020, Method: assocOperator020Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator021
	@Override
    public Collection<PreexistenciaC> assocOperator021(PersonaC instance) throws SystemException {
        try {
            // FOR ALL PreexistenciasC DO PreexistenciasC.eliminar(PreexistenciasC)
        return assocOperator021Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator021, Method: assocOperator021";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator021
	@Override
    public Collection<PreexistenciaC> assocOperator021Range1 (PersonaC instance) throws SystemException {

        SQLSelect sql = assocOperator021Range1Query(instance);
        return new TypedQueryBuilder<PreexistenciaC>(em, PreexistenciaC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator021
	@Override
    public SQLPopulation assocOperator021Range1Query (PersonaC instance) throws SystemException {
        try {
            return new SQLPopulation(PersonaCConstants.CLASS_NAME, PreexistenciaCConstants.CLASS_NAME, instance.getOid(), PersonaCConstants.ROLE_NAME_PREEXISTENCIASC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator021, Method: assocOperator021Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator022
	@Override
    public Collection<Direccion> assocOperator022(Solicitud personaCTNEWCONTRADESDEAEptSolicitud) throws SystemException {
        try {
            // FOR ALL ptSolicitud.ContratantePersona.Direcciones DO DireccionesC.TCREAR(ptSolicitud.ContratantePersona.Direcciones.Departamento, ptSolicitud.ContratantePersona.Direcciones.Municipio, ptSolicitud.ContratantePersona.Direcciones.TipoDireccion, ptSolicitud.ContratantePersona.Direcciones.Pais, this, ptSolicitud.ContratantePersona.Direcciones.DireccionCompleta, NULL, ptSolicitud.ContratantePersona.TelefonoFijo, ptSolicitud.ContratantePersona.TelefonoCelular, NULL)
        return assocOperator022Range1(personaCTNEWCONTRADESDEAEptSolicitud);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator022, Method: assocOperator022";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator022
	@Override
    public Collection<Direccion> assocOperator022Range1 (Solicitud personaCTNEWCONTRADESDEAEptSolicitud) throws SystemException {

        SQLSelect sql = assocOperator022Range1Query(personaCTNEWCONTRADESDEAEptSolicitud);
        return new TypedQueryBuilder<Direccion>(em, Direccion.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator022
	@Override
    public SQLPopulation assocOperator022Range1Query (Solicitud personaCTNEWCONTRADESDEAEptSolicitud) throws SystemException {
        try {
            return new SQLPopulation(PersonaCConstants.CLASS_NAME, DireccionConstants.CLASS_NAME, PersonaCConstants.ARG_NAME_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA + "." + PersonaConstants.ROLE_NAME_DIRECCIONES, personaCTNEWCONTRADESDEAEptSolicitud.getOid(), PersonaCConstants.ARG_NAME_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator022, Method: assocOperator022Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator023
	@Override
    public Collection<Direccion> assocOperator023(Solicitud personaCTNEWCONTRADESDEAEptSolicitud) throws SystemException {
        try {
            // FOR ALL ptSolicitud.ContratantePersona.Direcciones DO DirSucursalesC.TCREAR(ptSolicitud.ContratantePersona.Direcciones.Municipio, ptSolicitud.ContratantePersona.Direcciones.Departamento, ptSolicitud.ContratantePersona.Direcciones.Pais, this, NULL, "1", ptSolicitud.ContratantePersona.RazonSocial, true, true, ptSolicitud.ContratantePersona.Direcciones.DireccionCompleta, ptSolicitud.ContratantePersona.CorreoElectronico, ptSolicitud.ContratantePersona.TelefonoFijo, ptSolicitud.ContratantePersona.TelefonoCelular)
            return assocOperator022(personaCTNEWCONTRADESDEAEptSolicitud);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator023, Method: assocOperator023";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator025
	@Override
    public Collection<Usuario> assocOperator025(Solicitud personaCTNEWCONTRADESDEAEptSolicitud) throws SystemException {
        try {
            // FOR ALL ptSolicitud.Usuarios WHERE (ptSolicitud.Usuarios.UsuarioPersona = ptSolicitud.ContratantePersona AND EXIST (ptSolicitud.Usuarios.CuestionarioP) = true) DO TCREAROCUESDEAE(this, ptSolicitud.Usuarios.CuestionarioP)
        return assocOperator025Range1(personaCTNEWCONTRADESDEAEptSolicitud);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator025, Method: assocOperator025";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator025
	@Override
    public Collection<Usuario> assocOperator025Range1 (Solicitud personaCTNEWCONTRADESDEAEptSolicitud) throws SystemException {

        SQLSelect sql = assocOperator025Range1Query(personaCTNEWCONTRADESDEAEptSolicitud);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator025
	@Override
    public SQLPopulation assocOperator025Range1Query (Solicitud personaCTNEWCONTRADESDEAEptSolicitud) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(PersonaCConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, PersonaCConstants.ARG_NAME_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_USUARIOS, personaCTNEWCONTRADESDEAEptSolicitud.getOid(), PersonaCConstants.ARG_NAME_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ptSolicitud.Usuarios.UsuarioPersona = ptSolicitud.ContratantePersona
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameter operand112 = new SQLWhereOperandOVParameter(PersonaCConstants.ARG_NAME_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA, SolicitudConstants.CLASS_NAME, PersonaConstants.CLASS_NAME, personaCTNEWCONTRADESDEAEptSolicitud.getOid(), PersonaCConstants.ARG_NAME_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (personaCTNEWCONTRADESDEAEptSolicitud.isNull() || personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(PersonaCConstants.ARG_NAME_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA, SolicitudConstants.CLASS_NAME, PersonaConstants.CLASS_NAME, personaCTNEWCONTRADESDEAEptSolicitud.getOid(), PersonaCConstants.ARG_NAME_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // EXIST (ptSolicitud.Usuarios.CuestionarioP) = true
                // 'exist' Association operator
                SQLWhereOperandSubQuery operandSubQueryAssocOperator026 = new SQLWhereOperandSubQuery(assocOperator026Range1Query(personaCTNEWCONTRADESDEAEptSolicitud, sql));
                conjunction.addOperand(operandSubQueryAssocOperator026);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator025, Method: assocOperator025Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator026
	@Override
    public Boolean assocOperator026(Solicitud personaCTNEWCONTRADESDEAEptSolicitud) throws SystemException {
        try {
            // EXIST (ptSolicitud.Usuarios.CuestionarioP)
            return assocOperator026Range1(personaCTNEWCONTRADESDEAEptSolicitud);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator026, Method: assocOperator026";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator026
	@Override
    public Boolean assocOperator026Range1 (Solicitud personaCTNEWCONTRADESDEAEptSolicitud) throws SystemException {
        SQLExists sql = assocOperator026Range1Query(personaCTNEWCONTRADESDEAEptSolicitud, null);
        return !new TypedQueryBuilder<PersonaC>(em, PersonaC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator026
	@Override
    public SQLExists assocOperator026Range1Query (Solicitud personaCTNEWCONTRADESDEAEptSolicitud, SQLSelect superQuery) throws SystemException {
        try {
            // Path starts with an OV in the subquery
            return new SQLExists(superQuery, PersonaCConstants.CLASS_NAME, PersonaCConstants.ARG_NAME_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_CUESTIONARIOP, SolicitudConstants.CLASS_NAME, personaCTNEWCONTRADESDEAEptSolicitud.getOid(), "ptSolicitud");
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator026, Method: assocOperator026Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator027
	@Override
    public Collection<Usuario> assocOperator027(Solicitud personaCTNEWCONTRADESDEAEptSolicitud) throws SystemException {
        try {
            // FOR ALL ptSolicitud.Usuarios WHERE (ptSolicitud.Usuarios.UsuarioPersona = ptSolicitud.ContratantePersona) DO TCOPIARPREEXDEUSU(this, ptSolicitud.Usuarios)
        return assocOperator027Range1(personaCTNEWCONTRADESDEAEptSolicitud);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator027, Method: assocOperator027";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator027
	@Override
    public Collection<Usuario> assocOperator027Range1 (Solicitud personaCTNEWCONTRADESDEAEptSolicitud) throws SystemException {

        SQLSelect sql = assocOperator027Range1Query(personaCTNEWCONTRADESDEAEptSolicitud);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator027
	@Override
    public SQLPopulation assocOperator027Range1Query (Solicitud personaCTNEWCONTRADESDEAEptSolicitud) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(PersonaCConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, PersonaCConstants.ARG_NAME_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_USUARIOS, personaCTNEWCONTRADESDEAEptSolicitud.getOid(), PersonaCConstants.ARG_NAME_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ptSolicitud.Usuarios.UsuarioPersona = ptSolicitud.ContratantePersona
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameter operand112 = new SQLWhereOperandOVParameter(PersonaCConstants.ARG_NAME_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA, SolicitudConstants.CLASS_NAME, PersonaConstants.CLASS_NAME, personaCTNEWCONTRADESDEAEptSolicitud.getOid(), PersonaCConstants.ARG_NAME_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (personaCTNEWCONTRADESDEAEptSolicitud.isNull() || personaCTNEWCONTRADESDEAEptSolicitud.getContratantePersona().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(PersonaCConstants.ARG_NAME_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA, SolicitudConstants.CLASS_NAME, PersonaConstants.CLASS_NAME, personaCTNEWCONTRADESDEAEptSolicitud.getOid(), PersonaCConstants.ARG_NAME_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator027, Method: assocOperator027Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator028
	@Override
    public Boolean assocOperator028(Solicitud personaCTNEWCONTRADESDEAEptSolicitud) throws SystemException {
        try {
            // EXIST (ptSolicitud.ProteccionDatos)
            return assocOperator028Range1(personaCTNEWCONTRADESDEAEptSolicitud);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator028, Method: assocOperator028";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator028
	@Override
    public Boolean assocOperator028Range1 (Solicitud personaCTNEWCONTRADESDEAEptSolicitud) throws SystemException {
        SQLExists sql = assocOperator028Range1Query(personaCTNEWCONTRADESDEAEptSolicitud, null);
        return !new TypedQueryBuilder<PersonaC>(em, PersonaC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator028
	@Override
    public SQLExists assocOperator028Range1Query (Solicitud personaCTNEWCONTRADESDEAEptSolicitud, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, PersonaCConstants.CLASS_NAME, PersonaCConstants.ARG_NAME_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_PROTECCIONDATOS, SolicitudConstants.CLASS_NAME, personaCTNEWCONTRADESDEAEptSolicitud.getOid(), PersonaCConstants.ARG_NAME_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD);
            } else {
                sql = new SQLExists(PersonaCConstants.CLASS_NAME, PersonaCConstants.ARG_NAME_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_PROTECCIONDATOS, SolicitudConstants.CLASS_NAME, personaCTNEWCONTRADESDEAEptSolicitud.getOid(), PersonaCConstants.ARG_NAME_TNEWCONTRADESDEAE_PERSONACTNEWCONTRADESDEAEPTSOLICITUD);
            }
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator028, Method: assocOperator028Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator029
	@Override
    public Collection<Direccion> assocOperator029(Solicitud personaCTNEWTITULARDESDEAEptSolicitud) throws SystemException {
        try {
            // FOR ALL ptSolicitud.TitularPersona.Direcciones DO DireccionesC.TCREAR(ptSolicitud.TitularPersona.Direcciones.Departamento, ptSolicitud.TitularPersona.Direcciones.Municipio, ptSolicitud.TitularPersona.Direcciones.TipoDireccion, ptSolicitud.TitularPersona.Direcciones.Pais, this, ptSolicitud.TitularPersona.Direcciones.DireccionCompleta, NULL, ptSolicitud.TitularPersona.TelefonoFijo, ptSolicitud.TitularPersona.TelefonoCelular, NULL)
        return assocOperator029Range1(personaCTNEWTITULARDESDEAEptSolicitud);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator029, Method: assocOperator029";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator029
	@Override
    public Collection<Direccion> assocOperator029Range1 (Solicitud personaCTNEWTITULARDESDEAEptSolicitud) throws SystemException {

        SQLSelect sql = assocOperator029Range1Query(personaCTNEWTITULARDESDEAEptSolicitud);
        return new TypedQueryBuilder<Direccion>(em, Direccion.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator029
	@Override
    public SQLPopulation assocOperator029Range1Query (Solicitud personaCTNEWTITULARDESDEAEptSolicitud) throws SystemException {
        try {
            return new SQLPopulation(PersonaCConstants.CLASS_NAME, DireccionConstants.CLASS_NAME, PersonaCConstants.ARG_NAME_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_TITULARPERSONA + "." + PersonaConstants.ROLE_NAME_DIRECCIONES, personaCTNEWTITULARDESDEAEptSolicitud.getOid(), PersonaCConstants.ARG_NAME_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator029, Method: assocOperator029Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator030
	@Override
    public Collection<Direccion> assocOperator030(Solicitud personaCTNEWTITULARDESDEAEptSolicitud) throws SystemException {
        try {
            // FOR ALL ptSolicitud.TitularPersona.Direcciones DO DirSucursalesC.TCREAR(ptSolicitud.TitularPersona.Direcciones.Municipio, ptSolicitud.TitularPersona.Direcciones.Departamento, ptSolicitud.TitularPersona.Direcciones.Pais, this, NULL, "1", ptSolicitud.TitularPersona.RazonSocial, true, true, ptSolicitud.TitularPersona.Direcciones.DireccionCompleta, ptSolicitud.TitularPersona.CorreoElectronico, ptSolicitud.TitularPersona.TelefonoFijo, ptSolicitud.TitularPersona.TelefonoCelular)
            return assocOperator029(personaCTNEWTITULARDESDEAEptSolicitud);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator030, Method: assocOperator030";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator032
	@Override
    public Collection<Usuario> assocOperator032(Solicitud personaCTNEWTITULARDESDEAEptSolicitud) throws SystemException {
        try {
            // FOR ALL ptSolicitud.Usuarios WHERE (ptSolicitud.Usuarios.UsuarioPersona = ptSolicitud.TitularPersona AND EXIST (ptSolicitud.Usuarios.CuestionarioP) = true) DO TCREAROCUESDEAE(this, ptSolicitud.Usuarios.CuestionarioP)
        return assocOperator032Range1(personaCTNEWTITULARDESDEAEptSolicitud);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator032, Method: assocOperator032";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator032
	@Override
    public Collection<Usuario> assocOperator032Range1 (Solicitud personaCTNEWTITULARDESDEAEptSolicitud) throws SystemException {

        SQLSelect sql = assocOperator032Range1Query(personaCTNEWTITULARDESDEAEptSolicitud);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator032
	@Override
    public SQLPopulation assocOperator032Range1Query (Solicitud personaCTNEWTITULARDESDEAEptSolicitud) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(PersonaCConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, PersonaCConstants.ARG_NAME_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_USUARIOS, personaCTNEWTITULARDESDEAEptSolicitud.getOid(), PersonaCConstants.ARG_NAME_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ptSolicitud.Usuarios.UsuarioPersona = ptSolicitud.TitularPersona
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameter operand112 = new SQLWhereOperandOVParameter(PersonaCConstants.ARG_NAME_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA, SolicitudConstants.CLASS_NAME, PersonaConstants.CLASS_NAME, personaCTNEWTITULARDESDEAEptSolicitud.getOid(), PersonaCConstants.ARG_NAME_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (personaCTNEWTITULARDESDEAEptSolicitud.isNull() || personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(PersonaCConstants.ARG_NAME_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_TITULARPERSONA, SolicitudConstants.CLASS_NAME, PersonaConstants.CLASS_NAME, personaCTNEWTITULARDESDEAEptSolicitud.getOid(), PersonaCConstants.ARG_NAME_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // EXIST (ptSolicitud.Usuarios.CuestionarioP) = true
                // 'exist' Association operator
                SQLWhereOperandSubQuery operandSubQueryAssocOperator033 = new SQLWhereOperandSubQuery(assocOperator033Range1Query(personaCTNEWTITULARDESDEAEptSolicitud, sql));
                conjunction.addOperand(operandSubQueryAssocOperator033);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator032, Method: assocOperator032Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator033
	@Override
    public Boolean assocOperator033(Solicitud personaCTNEWTITULARDESDEAEptSolicitud) throws SystemException {
        try {
            // EXIST (ptSolicitud.Usuarios.CuestionarioP)
            return assocOperator033Range1(personaCTNEWTITULARDESDEAEptSolicitud);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator033, Method: assocOperator033";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator033
	@Override
    public Boolean assocOperator033Range1 (Solicitud personaCTNEWTITULARDESDEAEptSolicitud) throws SystemException {
        SQLExists sql = assocOperator033Range1Query(personaCTNEWTITULARDESDEAEptSolicitud, null);
        return !new TypedQueryBuilder<PersonaC>(em, PersonaC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator033
	@Override
    public SQLExists assocOperator033Range1Query (Solicitud personaCTNEWTITULARDESDEAEptSolicitud, SQLSelect superQuery) throws SystemException {
        try {
            // Path starts with an OV in the subquery
            return new SQLExists(superQuery, PersonaCConstants.CLASS_NAME, PersonaCConstants.ARG_NAME_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_CUESTIONARIOP, SolicitudConstants.CLASS_NAME, personaCTNEWTITULARDESDEAEptSolicitud.getOid(), "ptSolicitud");
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator033, Method: assocOperator033Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator034
	@Override
    public Collection<Usuario> assocOperator034(Solicitud personaCTNEWTITULARDESDEAEptSolicitud) throws SystemException {
        try {
            // FOR ALL ptSolicitud.Usuarios WHERE (ptSolicitud.Usuarios.UsuarioPersona = ptSolicitud.TitularPersona) DO TCOPIARPREEXDEUSU(this, ptSolicitud.Usuarios)
        return assocOperator034Range1(personaCTNEWTITULARDESDEAEptSolicitud);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator034, Method: assocOperator034";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator034
	@Override
    public Collection<Usuario> assocOperator034Range1 (Solicitud personaCTNEWTITULARDESDEAEptSolicitud) throws SystemException {

        SQLSelect sql = assocOperator034Range1Query(personaCTNEWTITULARDESDEAEptSolicitud);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator034
	@Override
    public SQLPopulation assocOperator034Range1Query (Solicitud personaCTNEWTITULARDESDEAEptSolicitud) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(PersonaCConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, PersonaCConstants.ARG_NAME_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_USUARIOS, personaCTNEWTITULARDESDEAEptSolicitud.getOid(), PersonaCConstants.ARG_NAME_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ptSolicitud.Usuarios.UsuarioPersona = ptSolicitud.TitularPersona
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameter operand112 = new SQLWhereOperandOVParameter(PersonaCConstants.ARG_NAME_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA, SolicitudConstants.CLASS_NAME, PersonaConstants.CLASS_NAME, personaCTNEWTITULARDESDEAEptSolicitud.getOid(), PersonaCConstants.ARG_NAME_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (personaCTNEWTITULARDESDEAEptSolicitud.isNull() || personaCTNEWTITULARDESDEAEptSolicitud.getTitularPersona().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(PersonaCConstants.ARG_NAME_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_TITULARPERSONA, SolicitudConstants.CLASS_NAME, PersonaConstants.CLASS_NAME, personaCTNEWTITULARDESDEAEptSolicitud.getOid(), PersonaCConstants.ARG_NAME_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator034, Method: assocOperator034Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator035
	@Override
    public Boolean assocOperator035(Solicitud personaCTNEWTITULARDESDEAEptSolicitud) throws SystemException {
        try {
            // EXIST (ptSolicitud.ProteccionDatos)
            return assocOperator035Range1(personaCTNEWTITULARDESDEAEptSolicitud);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator035, Method: assocOperator035";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator035
	@Override
    public Boolean assocOperator035Range1 (Solicitud personaCTNEWTITULARDESDEAEptSolicitud) throws SystemException {
        SQLExists sql = assocOperator035Range1Query(personaCTNEWTITULARDESDEAEptSolicitud, null);
        return !new TypedQueryBuilder<PersonaC>(em, PersonaC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator035
	@Override
    public SQLExists assocOperator035Range1Query (Solicitud personaCTNEWTITULARDESDEAEptSolicitud, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, PersonaCConstants.CLASS_NAME, PersonaCConstants.ARG_NAME_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_PROTECCIONDATOS, SolicitudConstants.CLASS_NAME, personaCTNEWTITULARDESDEAEptSolicitud.getOid(), PersonaCConstants.ARG_NAME_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD);
            } else {
                sql = new SQLExists(PersonaCConstants.CLASS_NAME, PersonaCConstants.ARG_NAME_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_PROTECCIONDATOS, SolicitudConstants.CLASS_NAME, personaCTNEWTITULARDESDEAEptSolicitud.getOid(), PersonaCConstants.ARG_NAME_TNEWTITULARDESDEAE_PERSONACTNEWTITULARDESDEAEPTSOLICITUD);
            }
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator035, Method: assocOperator035Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator036
	@Override
    public Collection<Direccion> assocOperator036(Usuario personaCTNEWBENEFDESDEAEptUsuario) throws SystemException {
        try {
            // FOR ALL ptUsuario.UsuarioPersona.Direcciones DO DireccionesC.TCREAR(ptUsuario.UsuarioPersona.Direcciones.Departamento, ptUsuario.UsuarioPersona.Direcciones.Municipio, ptUsuario.UsuarioPersona.Direcciones.TipoDireccion, ptUsuario.UsuarioPersona.Direcciones.Pais, this, ptUsuario.UsuarioPersona.Direcciones.DireccionCompleta, NULL, ptUsuario.UsuarioPersona.TelefonoFijo, ptUsuario.UsuarioPersona.TelefonoCelular, NULL)
        return assocOperator036Range1(personaCTNEWBENEFDESDEAEptUsuario);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator036, Method: assocOperator036";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator036
	@Override
    public Collection<Direccion> assocOperator036Range1 (Usuario personaCTNEWBENEFDESDEAEptUsuario) throws SystemException {

        SQLSelect sql = assocOperator036Range1Query(personaCTNEWBENEFDESDEAEptUsuario);
        return new TypedQueryBuilder<Direccion>(em, Direccion.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator036
	@Override
    public SQLPopulation assocOperator036Range1Query (Usuario personaCTNEWBENEFDESDEAEptUsuario) throws SystemException {
        try {
            return new SQLPopulation(PersonaCConstants.CLASS_NAME, DireccionConstants.CLASS_NAME, PersonaCConstants.ARG_NAME_TNEWBENEFDESDEAE_PERSONACTNEWBENEFDESDEAEPTUSUARIO + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA + "." + PersonaConstants.ROLE_NAME_DIRECCIONES, personaCTNEWBENEFDESDEAEptUsuario.getOid(), PersonaCConstants.ARG_NAME_TNEWBENEFDESDEAE_PERSONACTNEWBENEFDESDEAEPTUSUARIO);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator036, Method: assocOperator036Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator038
	@Override
    public Collection<CuestionarioP> assocOperator038(Usuario personaCTNEWBENEFDESDEAEptUsuario) throws SystemException {
        try {
            // FOR ALL ptUsuario.CuestionarioP DO TCREAROCUESDEAE(this, ptUsuario.CuestionarioP)
        return assocOperator038Range1(personaCTNEWBENEFDESDEAEptUsuario);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator038, Method: assocOperator038";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator038
	@Override
    public Collection<CuestionarioP> assocOperator038Range1 (Usuario personaCTNEWBENEFDESDEAEptUsuario) throws SystemException {

        SQLSelect sql = assocOperator038Range1Query(personaCTNEWBENEFDESDEAEptUsuario);
        return new TypedQueryBuilder<CuestionarioP>(em, CuestionarioP.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator038
	@Override
    public SQLPopulation assocOperator038Range1Query (Usuario personaCTNEWBENEFDESDEAEptUsuario) throws SystemException {
        try {
            return new SQLPopulation(PersonaCConstants.CLASS_NAME, CuestionarioPConstants.CLASS_NAME, PersonaCConstants.ARG_NAME_TNEWBENEFDESDEAE_PERSONACTNEWBENEFDESDEAEPTUSUARIO + "." + UsuarioConstants.ROLE_NAME_CUESTIONARIOP, personaCTNEWBENEFDESDEAEptUsuario.getOid(), PersonaCConstants.ARG_NAME_TNEWBENEFDESDEAE_PERSONACTNEWBENEFDESDEAEPTUSUARIO);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator038, Method: assocOperator038Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator039
	@Override
    public Boolean assocOperator039(Usuario personaCTNEWBENEFDESDEAEptUsuario) throws SystemException {
        try {
            // EXIST (ptUsuario.Solicitud.ProteccionDatos)
            return assocOperator039Range1(personaCTNEWBENEFDESDEAEptUsuario);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator039, Method: assocOperator039";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator039
	@Override
    public Boolean assocOperator039Range1 (Usuario personaCTNEWBENEFDESDEAEptUsuario) throws SystemException {
        SQLExists sql = assocOperator039Range1Query(personaCTNEWBENEFDESDEAEptUsuario, null);
        return !new TypedQueryBuilder<PersonaC>(em, PersonaC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator039
	@Override
    public SQLExists assocOperator039Range1Query (Usuario personaCTNEWBENEFDESDEAEptUsuario, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, PersonaCConstants.CLASS_NAME, PersonaCConstants.ARG_NAME_TNEWBENEFDESDEAE_PERSONACTNEWBENEFDESDEAEPTUSUARIO + "." + UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_PROTECCIONDATOS, UsuarioConstants.CLASS_NAME, personaCTNEWBENEFDESDEAEptUsuario.getOid(), PersonaCConstants.ARG_NAME_TNEWBENEFDESDEAE_PERSONACTNEWBENEFDESDEAEPTUSUARIO);
            } else {
                sql = new SQLExists(PersonaCConstants.CLASS_NAME, PersonaCConstants.ARG_NAME_TNEWBENEFDESDEAE_PERSONACTNEWBENEFDESDEAEPTUSUARIO + "." + UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_PROTECCIONDATOS, UsuarioConstants.CLASS_NAME, personaCTNEWBENEFDESDEAEptUsuario.getOid(), PersonaCConstants.ARG_NAME_TNEWBENEFDESDEAE_PERSONACTNEWBENEFDESDEAEPTUSUARIO);
            }
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator039, Method: assocOperator039Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator040
	@Override
    public Collection<Preexistencia> assocOperator040(PersonaC personaCTCOPIARPREEXDEUSUpthisPersonaC, Usuario personaCTCOPIARPREEXDEUSUpUsuario) throws SystemException {
        try {
            // FOR ALL pUsuario.Preexistencias DO PreexistenciasC.crear(this, pUsuario.Preexistencias.Descripcion, pUsuario.Preexistencias.FecInicio, pUsuario.Preexistencias.FecFin, pUsuario.Preexistencias.Observacion)
        return assocOperator040Range1(personaCTCOPIARPREEXDEUSUpUsuario);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator040, Method: assocOperator040";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator040
	@Override
    public Collection<Preexistencia> assocOperator040Range1 (Usuario personaCTCOPIARPREEXDEUSUpUsuario) throws SystemException {

        SQLSelect sql = assocOperator040Range1Query(personaCTCOPIARPREEXDEUSUpUsuario);
        return new TypedQueryBuilder<Preexistencia>(em, Preexistencia.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator040
	@Override
    public SQLPopulation assocOperator040Range1Query (Usuario personaCTCOPIARPREEXDEUSUpUsuario) throws SystemException {
        try {
            return new SQLPopulation(PersonaCConstants.CLASS_NAME, PreexistenciaConstants.CLASS_NAME, PersonaCConstants.ARG_NAME_TCOPIARPREEXDEUSU_PERSONACTCOPIARPREEXDEUSUPUSUARIO + "." + UsuarioConstants.ROLE_NAME_PREEXISTENCIAS, personaCTCOPIARPREEXDEUSUpUsuario.getOid(), PersonaCConstants.ARG_NAME_TCOPIARPREEXDEUSU_PERSONACTCOPIARPREEXDEUSUPUSUARIO);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: PersonaC, Assoc.Operator: AssocOperator040, Method: assocOperator040Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
