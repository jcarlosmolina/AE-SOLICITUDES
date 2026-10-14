package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.AesolicitudesConstants;
import com.keralty.aesolicitudes.global.DominioConstants;
import com.keralty.aesolicitudes.global.FamiliaNovedadConstants;
import com.keralty.aesolicitudes.global.ParentescoConstants;
import com.keralty.aesolicitudes.global.ParentescoDomConstants;
import com.keralty.aesolicitudes.global.PlanesConstants;
import com.keralty.aesolicitudes.global.ProductosConstants;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.global.SolicitudNovedadConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.global.UsuarioConstants;
import com.keralty.aesolicitudes.global.UsuarioNovedadConstants;
import com.keralty.aesolicitudes.persistence.Parentesco;
import com.keralty.aesolicitudes.persistence.Usuario;
import com.keralty.aesolicitudes.persistence.UsuarioNovedad;
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

public class ParentescoJpaRepositoryImpl extends AbstractRepository implements ParentescoJpaRepositoryCustom {

    @Inject
    public ParentescoJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    @Override
    public List<Parentesco> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Parentesco> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Parentesco> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Parentesco> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Parentesco.class);
    }

    @Override	
    public List<Parentesco> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    @Override
    public List<Parentesco> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator001
	@Override
    public Boolean assocOperator001(Usuario usuarioTMODIFICARATTRpthisAttrUsuario) throws SystemException {
        try {
            // EXIST (ParentescosDom) WHERE (ParentescosDom.Dominio.ProductoT = pthisAttrUsuario.Solicitud.Aesolicitudes.ProductoT AND ParentescosDom.Dominio.PlanT = pthisAttrUsuario.Solicitud.Aesolicitudes.PlanT)
            return assocOperator001Range1(usuarioTMODIFICARATTRpthisAttrUsuario);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Parentesco, Assoc.Operator: AssocOperator001, Method: assocOperator001";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator001
	@Override
    public Boolean assocOperator001Range1 (Usuario usuarioTMODIFICARATTRpthisAttrUsuario) throws SystemException {
        SQLExists sql = assocOperator001Range1Query(usuarioTMODIFICARATTRpthisAttrUsuario, null);
        return !new TypedQueryBuilder<Parentesco>(em, Parentesco.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator001
	@Override
    public SQLExists assocOperator001Range1Query (Usuario usuarioTMODIFICARATTRpthisAttrUsuario, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, ParentescoConstants.CLASS_NAME, ParentescoConstants.ROLE_NAME_PARENTESCOSDOM);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ParentescosDom.Dominio.ProductoT = pthisAttrUsuario.Solicitud.Aesolicitudes.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(ParentescoConstants.ROLE_NAME_PARENTESCOSDOM + "." + ParentescoDomConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(UsuarioConstants.ARG_NAME_TMODIFICARATTR_USUARIOTMODIFICARATTRPTHISATTRUSUARIO + "." + UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT, UsuarioConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, usuarioTMODIFICARATTRpthisAttrUsuario.getOid(), UsuarioConstants.ARG_NAME_TMODIFICARATTR_USUARIOTMODIFICARATTRPTHISATTRUSUARIO);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // ParentescosDom.Dominio.PlanT = pthisAttrUsuario.Solicitud.Aesolicitudes.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(ParentescoConstants.ROLE_NAME_PARENTESCOSDOM + "." + ParentescoDomConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    if (usuarioTMODIFICARATTRpthisAttrUsuario.isNull() || usuarioTMODIFICARATTRpthisAttrUsuario.getSolicitud().getAesolicitudes().getPlanT().isNull())
                    {
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(UsuarioConstants.ARG_NAME_TMODIFICARATTR_USUARIOTMODIFICARATTRPTHISATTRUSUARIO + "." + UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, UsuarioConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, usuarioTMODIFICARATTRpthisAttrUsuario.getOid(), UsuarioConstants.ARG_NAME_TMODIFICARATTR_USUARIOTMODIFICARATTRPTHISATTRUSUARIO);
                    comparison2.setSecondOperand(operand224);
                    }
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Parentesco, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator002
	@Override
    public Boolean assocOperator002(UsuarioNovedad usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad) throws SystemException {
        try {
            // EXIST (ParentescosDom.Dominio.PlanT) WHERE (ParentescosDom.Dominio.PlanT = pthisUsuarioNovedad.FamiliaNovedad.Solicitud.PlanT)
            return assocOperator002Range1(usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Parentesco, Assoc.Operator: AssocOperator002, Method: assocOperator002";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // Range 0 for AssocOperator AssocOperator002
	@Override
    public Boolean assocOperator002Range1 (UsuarioNovedad usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad) throws SystemException {
        SQLExists sql = assocOperator002Range1Query(usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad, null);
        return !new TypedQueryBuilder<Parentesco>(em, Parentesco.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator002
	@Override
    public SQLExists assocOperator002Range1Query (UsuarioNovedad usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, ParentescoConstants.CLASS_NAME, ParentescoConstants.ROLE_NAME_PARENTESCOSDOM + "." + ParentescoDomConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ParentescosDom.Dominio.PlanT = pthisUsuarioNovedad.FamiliaNovedad.Solicitud.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(ParentescoConstants.ROLE_NAME_PARENTESCOSDOM + "." + ParentescoDomConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(UsuarioNovedadConstants.ARG_NAME_TCAMBIARPARENTESCO_USUARIONOVEDADTCAMBIARPARENTESCOPTHISUSUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_FAMILIANOVEDAD + "." + FamiliaNovedadConstants.ROLE_NAME_SOLICITUD + "." + SolicitudNovedadConstants.ROLE_NAME_PLANT, UsuarioNovedadConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, usuarioNovedadTCAMBIARPARENTESCOpthisUsuarioNovedad.getOid(), UsuarioNovedadConstants.ARG_NAME_TCAMBIARPARENTESCO_USUARIONOVEDADTCAMBIARPARENTESCOPTHISUSUARIONOVEDAD);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: Parentesco, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
