package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.BeneficiarioCConstants;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.global.FamiliaCConstants;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.global.TipoIdentificacionConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.global.UsuarioConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.persistence.Usuario;
import com.keralty.aesolicitudes.sqlutils.SQLExists;
import com.keralty.aesolicitudes.sqlutils.SQLMax;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLPopulation;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
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

public class FamiliaCJpaRepositoryImpl extends AbstractRepository implements FamiliaCJpaRepositoryCustom {

    @Inject
    public FamiliaCJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<FamiliaC> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<FamiliaC> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<FamiliaC> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<FamiliaC> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, FamiliaC.class);
    }

    @Override	
    public List<FamiliaC> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<FamiliaC> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    @Override
    public Long nextFamiliaCID(Long contratoCContratoCID) {
        try {
            SQLMax sql = new SQLMax(null, FamiliaCConstants.CLASS_NAME, FamiliaCConstants.CLASS_NAME + "." + FamiliaCConstants.ATTR_FIELD_FAMILIACID);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FamiliaCConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ATTR_FIELD_CONTRATOCID, "Autonumerico"));
            comparison1.setOperator("=");
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(contratoCContratoCID, "Autonumerico"));
            conjunction.addComparison(comparison1);

            sql.getWherePart().addConjunction(conjunction);

            Long tempResult = new TypedQueryBuilder<>(em, Long.class).build(sql).getSingleResult();
            return (tempResult != null ? tempResult + 1L : 1L);
        } catch (Exception e) {
            LoggerFactory.getLogger(FamiliaC.class).error(e.getMessage());
            return 1L;
        }
    }

    // AssocOperator: AssocOperator000
	@Override
    public Collection<BeneficiarioC> assocOperator000(FamiliaC instance) throws SystemException {
        try {
            // FOR ALL BeneficiariosC DO BeneficiariosC.TELIMINAR(BeneficiariosC)
        return assocOperator000Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaC, Assoc.Operator: AssocOperator000, Method: assocOperator000";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator000
	@Override
    public Collection<BeneficiarioC> assocOperator000Range1 (FamiliaC instance) throws SystemException {

        SQLSelect sql = assocOperator000Range1Query(instance);
        return new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator000
	@Override
    public SQLPopulation assocOperator000Range1Query (FamiliaC instance) throws SystemException {
        try {
            return new SQLPopulation(FamiliaCConstants.CLASS_NAME, BeneficiarioCConstants.CLASS_NAME, instance.getOid(), FamiliaCConstants.ROLE_NAME_BENEFICIARIOSC);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaC, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator002
	@Override
    public Boolean assocOperator002(FamiliaC instance) throws SystemException {
        try {
            // EXIST (PersonaCTitular)
            return assocOperator002Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaC, Assoc.Operator: AssocOperator002, Method: assocOperator002";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator002
	@Override
    public Boolean assocOperator002Range1 (FamiliaC instance) throws SystemException {
        SQLExists sql = assocOperator002Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaC>(em, FamiliaC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator002
	@Override
    public SQLExists assocOperator002Range1Query (FamiliaC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaCConstants.CLASS_NAME, FamiliaCConstants.ROLE_NAME_PERSONACTITULAR, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaC, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator003
	@Override
    public Collection<Usuario> assocOperator003(Solicitud familiaCTNEWDESDEAEptSolicitud) throws SystemException {
        try {
            // FOR ALL ptSolicitud.Usuarios DO BeneficiariosC.TNEWDESDEAE(ptContratoC, this, ptSolicitud.Usuarios, ptSolicitud)
        return assocOperator003Range1(familiaCTNEWDESDEAEptSolicitud);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaC, Assoc.Operator: AssocOperator003, Method: assocOperator003";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator003
	@Override
    public Collection<Usuario> assocOperator003Range1 (Solicitud familiaCTNEWDESDEAEptSolicitud) throws SystemException {

        SQLSelect sql = assocOperator003Range1Query(familiaCTNEWDESDEAEptSolicitud);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator003
	@Override
    public SQLPopulation assocOperator003Range1Query (Solicitud familiaCTNEWDESDEAEptSolicitud) throws SystemException {
        try {
            return new SQLPopulation(FamiliaCConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, FamiliaCConstants.ARG_NAME_TNEWDESDEAE_FAMILIACTNEWDESDEAEPTSOLICITUD + "." + SolicitudConstants.ROLE_NAME_USUARIOS, familiaCTNEWDESDEAEptSolicitud.getOid(), FamiliaCConstants.ARG_NAME_TNEWDESDEAE_FAMILIACTNEWDESDEAEPTSOLICITUD);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaC, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator005
	@Override
    public Collection<BeneficiarioC> assocOperator005(FamiliaC instance, TipoIdentificacion familiaCTCREARACTBENEFptptTipoId, String familiaCTCREARACTBENEFptptNumIdentificacion) throws SystemException {
        try {
            // FOR ALL BeneficiariosC WHERE (BeneficiariosC.PersonaC.TipoIdentificacionC = ptptTipoId AND BeneficiariosC.PersonaC.NumIdentificacion = ptptNumIdentificacion) DO BeneficiariosC.TPOSTNOTIFICAR(BeneficiariosC, ptpatrEstadoMedico, ptpatrFechaAntiguedadRealOSI, ptpatrTienePreexistencias, ptpatrFechaInicioVigencia, ptpatrFechaFinVigencia, ptpatrNumUsuario, ptpatrCodigoTipoUsuario, ptpatrIndicadorBBGestacion, ptpatrCodUsuarioBancoRep, ptpatrFechaAntiguedad, ptpagrEstadoBeneficiarioC, ptpagrEPSC, ptpagrCompanyiaMPC, ptpagrParentescoC, ptptNombreCompleto)
        return assocOperator005Range1(instance, familiaCTCREARACTBENEFptptTipoId, familiaCTCREARACTBENEFptptNumIdentificacion);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaC, Assoc.Operator: AssocOperator005, Method: assocOperator005";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator005
	@Override
    public Collection<BeneficiarioC> assocOperator005Range1 (FamiliaC instance, TipoIdentificacion familiaCTCREARACTBENEFptptTipoId, String familiaCTCREARACTBENEFptptNumIdentificacion) throws SystemException {

        SQLSelect sql = assocOperator005Range1Query(instance, familiaCTCREARACTBENEFptptTipoId, familiaCTCREARACTBENEFptptNumIdentificacion);
        return new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator005
	@Override
    public SQLPopulation assocOperator005Range1Query (FamiliaC instance, TipoIdentificacion familiaCTCREARACTBENEFptptTipoId, String familiaCTCREARACTBENEFptptNumIdentificacion) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(FamiliaCConstants.CLASS_NAME, BeneficiarioCConstants.CLASS_NAME, instance.getOid(), FamiliaCConstants.ROLE_NAME_BENEFICIARIOSC);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // BeneficiariosC.PersonaC.TipoIdentificacionC = ptptTipoId
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(FamiliaCConstants.ROLE_NAME_BENEFICIARIOSC + "." + BeneficiarioCConstants.ROLE_NAME_PERSONAC + "." + PersonaCConstants.ROLE_NAME_TIPOIDENTIFICACIONC, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(FamiliaCConstants.ARG_NAME_TCREARACTBENEF_FAMILIACTCREARACTBENEFPTPTTIPOID, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, familiaCTCREARACTBENEFptptTipoId.getOid(), FamiliaCConstants.ARG_NAME_TCREARACTBENEF_FAMILIACTCREARACTBENEFPTPTTIPOID);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // BeneficiariosC.PersonaC.NumIdentificacion = ptptNumIdentificacion
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FamiliaCConstants.ROLE_NAME_BENEFICIARIOSC + "." + BeneficiarioCConstants.ROLE_NAME_PERSONAC + "." + PersonaCConstants.ATTR_NAME_PERSONACNUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(familiaCTCREARACTBENEFptptNumIdentificacion, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaC, Assoc.Operator: AssocOperator005, Method: assocOperator005Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator006
	@Override
    public Boolean assocOperator006(FamiliaC instance, TipoIdentificacion familiaCTCREARACTBENEFptptTipoId, String familiaCTCREARACTBENEFptptNumIdentificacion) throws SystemException {
        try {
            // EXIST (BeneficiariosC.PersonaC) WHERE (BeneficiariosC.PersonaC.TipoIdentificacionC = ptptTipoId AND BeneficiariosC.PersonaC.NumIdentificacion = ptptNumIdentificacion)
            return assocOperator006Range1(instance, familiaCTCREARACTBENEFptptTipoId, familiaCTCREARACTBENEFptptNumIdentificacion);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaC, Assoc.Operator: AssocOperator006, Method: assocOperator006";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator006
	@Override
    public Boolean assocOperator006Range1 (FamiliaC instance, TipoIdentificacion familiaCTCREARACTBENEFptptTipoId, String familiaCTCREARACTBENEFptptNumIdentificacion) throws SystemException {
        SQLExists sql = assocOperator006Range1Query(instance, familiaCTCREARACTBENEFptptTipoId, familiaCTCREARACTBENEFptptNumIdentificacion);
        return !new TypedQueryBuilder<FamiliaC>(em, FamiliaC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator006
	@Override
    public SQLExists assocOperator006Range1Query (FamiliaC instance, TipoIdentificacion familiaCTCREARACTBENEFptptTipoId, String familiaCTCREARACTBENEFptptNumIdentificacion) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(FamiliaCConstants.CLASS_NAME, FamiliaCConstants.ROLE_NAME_BENEFICIARIOSC + "." + BeneficiarioCConstants.ROLE_NAME_PERSONAC, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // BeneficiariosC.PersonaC.TipoIdentificacionC = ptptTipoId
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(FamiliaCConstants.ROLE_NAME_BENEFICIARIOSC + "." + BeneficiarioCConstants.ROLE_NAME_PERSONAC + "." + PersonaCConstants.ROLE_NAME_TIPOIDENTIFICACIONC, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(FamiliaCConstants.ARG_NAME_TCREARACTBENEF_FAMILIACTCREARACTBENEFPTPTTIPOID, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, familiaCTCREARACTBENEFptptTipoId.getOid(), FamiliaCConstants.ARG_NAME_TCREARACTBENEF_FAMILIACTCREARACTBENEFPTPTTIPOID);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // BeneficiariosC.PersonaC.NumIdentificacion = ptptNumIdentificacion
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FamiliaCConstants.ROLE_NAME_BENEFICIARIOSC + "." + BeneficiarioCConstants.ROLE_NAME_PERSONAC + "." + PersonaCConstants.ATTR_NAME_PERSONACNUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(familiaCTCREARACTBENEFptptNumIdentificacion, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaC, Assoc.Operator: AssocOperator006, Method: assocOperator006Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator009
	@Override
    public Boolean assocOperator009(FamiliaC instance) throws SystemException {
        try {
            // EXIST (MunicipioC)
            return assocOperator009Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaC, Assoc.Operator: AssocOperator009, Method: assocOperator009";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator009
	@Override
    public Boolean assocOperator009Range1 (FamiliaC instance) throws SystemException {
        SQLExists sql = assocOperator009Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaC>(em, FamiliaC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator009
	@Override
    public SQLExists assocOperator009Range1Query (FamiliaC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaCConstants.CLASS_NAME, FamiliaCConstants.ROLE_NAME_MUNICIPIOC, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaC, Assoc.Operator: AssocOperator009, Method: assocOperator009Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator010
	@Override
    public Boolean assocOperator010(FamiliaC instance) throws SystemException {
        try {
            // EXIST (PersonaCTitular)
            return assocOperator010Range1(instance);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaC, Assoc.Operator: AssocOperator010, Method: assocOperator010";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 1 for AssocOperator AssocOperator010
	@Override
    public Boolean assocOperator010Range1 (FamiliaC instance) throws SystemException {
        SQLExists sql = assocOperator010Range1Query(instance);
        return !new TypedQueryBuilder<FamiliaC>(em, FamiliaC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator010
	@Override
    public SQLExists assocOperator010Range1Query (FamiliaC instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(FamiliaCConstants.CLASS_NAME, FamiliaCConstants.ROLE_NAME_PERSONACTITULAR, instance.getOid());
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: FamiliaC, Assoc.Operator: AssocOperator010, Method: assocOperator010Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
