package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.AesolicitudesConstants;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.DominioConstants;
import com.keralty.aesolicitudes.global.GlobalServiceConstants;
import com.keralty.aesolicitudes.global.PlanesConstants;
import com.keralty.aesolicitudes.global.ProductosConstants;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.global.SolicitudNovedadConstants;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.Dominio;
import com.keralty.aesolicitudes.persistence.Planes;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;
import com.keralty.aesolicitudes.sqlutils.SQLExists;
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
import java.sql.Date;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service
public class GlobalServicesJpaRepositoryImpl extends AbstractRepository implements GlobalServicesJpaRepository {

    @Inject
    public GlobalServicesJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    // AssocOperator: AssocOperator074
	@Override
    public Collection<Productos> assocOperator074(String tGSOLICITUDFISICACARGARpCLProducto) throws SystemException {
        try {
            // FOR ALL Productos WHERE (Productos.CodigoLegal = pCLProducto) DO Aesolicitudes.TCREARFISICA(Productos, ptpatrLOGIN, ptpNUMEROSOLICITUD, ptpSWESTADO, ptpFECHAESTADO)
            return assocOperator074Range1(tGSOLICITUDFISICACARGARpCLProducto);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator074, Method: assocOperator074";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<Productos> assocOperator074Range1 (String tGSOLICITUDFISICACARGARpCLProducto) throws SystemException {

        SQLSelect sql = assocOperator074Range1Query(tGSOLICITUDFISICACARGARpCLProducto);
        return new TypedQueryBuilder<Productos>(em, Productos.class).build(sql).execute();
    }


    public SQLPopulation assocOperator074Range1Query (String tGSOLICITUDFISICACARGARpCLProducto) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", ProductosConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Productos.CodigoLegal = pCLProducto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ProductosConstants.CLASS_NAME + "." + ProductosConstants.ATTR_NAME_PRODUCTOSCODIGOLEGAL, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGSOLICITUDFISICACARGARpCLProducto, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator074, Method: assocOperator074Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator075
	@Override
    public Collection<Aesolicitudes> assocOperator075(String tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD) throws SystemException {
        try {
            // FOR ALL Aesolicitudes WHERE (Aesolicitudes.Numerosolicitud = ptpNUMEROSOLICITUD) DO Aesolicitudes.cambiarEstado(Aesolicitudes, ptpSWESTADO)
            return assocOperator075Range1(tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator075, Method: assocOperator075";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<Aesolicitudes> assocOperator075Range1 (String tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD) throws SystemException {

        SQLSelect sql = assocOperator075Range1Query(tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD);
        return new TypedQueryBuilder<Aesolicitudes>(em, Aesolicitudes.class).build(sql).execute();
    }


    public SQLPopulation assocOperator075Range1Query (String tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", AesolicitudesConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Aesolicitudes.Numerosolicitud = ptpNUMEROSOLICITUD
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(AesolicitudesConstants.CLASS_NAME + "." + AesolicitudesConstants.ATTR_NAME_AESOLICITUDESNUMEROSOLICITUD, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD!= null){
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD, Constants.Type.STRING.getTypeName()));
                    } else {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator075, Method: assocOperator075Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator076
	@Override
    public Boolean assocOperator076(String tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD) throws SystemException {
        try {
            // EXIST (Solicitud) WHERE (Solicitud.Aesolicitudes.Numerosolicitud = ptpNUMEROSOLICITUD)
            return assocOperator076Range1(tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator076, Method: assocOperator076";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Boolean assocOperator076Range1 (String tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD) throws SystemException {
        SQLExists sql = assocOperator076Range1Query(tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator076Range1Query (String tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, "", SolicitudConstants.CLASS_NAME, SolicitudConstants.CLASS_NAME, null, SolicitudConstants.CLASS_NAME);
            } else {
                sql = new SQLExists("", SolicitudConstants.CLASS_NAME, SolicitudConstants.CLASS_NAME, null, SolicitudConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Solicitud.Aesolicitudes.Numerosolicitud = ptpNUMEROSOLICITUD
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.CLASS_NAME + "." + AesolicitudesConstants.CLASS_NAME + "." + AesolicitudesConstants.ATTR_NAME_AESOLICITUDESNUMEROSOLICITUD, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD!= null){
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD, Constants.Type.STRING.getTypeName()));
                    } else {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator076, Method: assocOperator076Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator129
	@Override
    public Collection<Dominio> assocOperator129() throws SystemException {
        try {
            // FOR ALL Dominio WHERE (Dominio.PlanT.EsVoluntario = true AND Dominio.DiasCaducidad > 0) DO OGANULARSOLAUX(Dominio.PlanT, dateAdd("d", -1 * Dominio.DiasCaducidad, systemDate()))
            return assocOperator129Range1();
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator129, Method: assocOperator129";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<Dominio> assocOperator129Range1 () throws SystemException {

        SQLSelect sql = assocOperator129Range1Query();
        return new TypedQueryBuilder<Dominio>(em, Dominio.class).build(sql).execute();
    }


    public SQLPopulation assocOperator129Range1Query () throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", DominioConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Dominio.PlanT.EsVoluntario = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(DominioConstants.CLASS_NAME + "." + DominioConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ATTR_NAME_PLANESESVOLUNTARIO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);


            // Dominio.DiasCaducidad > 0
                    // '>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator(">");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(DominioConstants.CLASS_NAME + "." + DominioConstants.ATTR_NAME_DOMINIODIASCADUCIDAD, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(0), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator129, Method: assocOperator129Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator130
	@Override
    public Collection<Solicitud> assocOperator130(Planes oGANULARSOLAUXptPlan, Date oGANULARSOLAUXptFechaCad) throws SystemException {
        try {
            // FOR ALL Solicitud WHERE (Solicitud.Aesolicitudes.PlanT = ptPlan AND Solicitud.Completada = false AND Solicitud.Aesolicitudes.Fechaasignacion < ptFechaCad) DO Solicitud.TANULARAUTO(Solicitud)
            return assocOperator130Range1(oGANULARSOLAUXptPlan, oGANULARSOLAUXptFechaCad);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator130, Method: assocOperator130";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<Solicitud> assocOperator130Range1 (Planes oGANULARSOLAUXptPlan, Date oGANULARSOLAUXptFechaCad) throws SystemException {

        SQLSelect sql = assocOperator130Range1Query(oGANULARSOLAUXptPlan, oGANULARSOLAUXptFechaCad);
        return new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute();
    }


    public SQLPopulation assocOperator130Range1Query (Planes oGANULARSOLAUXptPlan, Date oGANULARSOLAUXptFechaCad) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", SolicitudConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Solicitud.Aesolicitudes.PlanT = ptPlan
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.CLASS_NAME + "." + AesolicitudesConstants.CLASS_NAME + "." + AesolicitudesConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(GlobalServiceConstants.GS_ARG_NAME_OGANULARSOLAUX_OGANULARSOLAUXPTPLAN, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, oGANULARSOLAUXptPlan.getOid(), GlobalServiceConstants.GS_ARG_NAME_OGANULARSOLAUX_OGANULARSOLAUXPTPLAN);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Solicitud.Completada = false
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.CLASS_NAME + "." + SolicitudConstants.ATTR_NAME_SOLICITUDCOMPLETADA, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);


            // Solicitud.Aesolicitudes.Fechaasignacion < ptFechaCad
                    // '<' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.CLASS_NAME + "." + AesolicitudesConstants.CLASS_NAME + "." + AesolicitudesConstants.ATTR_NAME_AESOLICITUDESFECHAASIGNACION, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    comparison3.setSecondOperand(new SQLWhereOperandLiteral(oGANULARSOLAUXptFechaCad, Constants.Type.DATE.getTypeName()));
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator130, Method: assocOperator130Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator135
	@Override
    public Collection<Solicitud> assocOperator135() throws SystemException {
        try {
            // FOR ALL Solicitud DO Solicitud.TREASIGNARUSUARIOS(Solicitud, Solicitud.UsrAfiliacion, Solicitud.UsrAreaMedica; oaProcesados, oaErrores, oaTextoErrores)
            return assocOperator135Range1();
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator135, Method: assocOperator135";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<Solicitud> assocOperator135Range1 () throws SystemException {

        SQLSelect sql = assocOperator135Range1Query();
        return new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute();
    }


    public SQLPopulation assocOperator135Range1Query () throws SystemException {
        try {
            return new SQLPopulation("", SolicitudConstants.CLASS_NAME);
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator135, Method: assocOperator135Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator136
	@Override
    public Collection<SolicitudNovedad> assocOperator136() throws SystemException {
        try {
            // FOR ALL SolicitudNovedad DO SolicitudNovedad.TREASIGNARUSUARIOS(SolicitudNovedad, SolicitudNovedad.UsrAfiliacion)
            return assocOperator136Range1();
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator136, Method: assocOperator136";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<SolicitudNovedad> assocOperator136Range1 () throws SystemException {

        SQLSelect sql = assocOperator136Range1Query();
        return new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute();
    }


    public SQLPopulation assocOperator136Range1Query () throws SystemException {
        try {
            return new SQLPopulation("", SolicitudNovedadConstants.CLASS_NAME);
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator136, Method: assocOperator136Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
