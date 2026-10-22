package com.keralty.aesolicitudes.service;

import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.STDFunctions;
import com.keralty.aesolicitudes.global.UserFunctions;
import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.Dominio;
import com.keralty.aesolicitudes.persistence.Planes;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;
import com.keralty.aesolicitudes.repository.GlobalServicesJpaRepository;
import com.keralty.aesolicitudes.utils.Utilities;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.sql.Date;

@Transactional
@ApplicationScoped
public class GlobalServicesService extends AbstractService {

    GlobalServicesService globalServicesSrv;

    UserFunctions userFunctionsSrv;

    PlanesService planesSrv;

    SolicitudService solicitudSrv;

    SolicitudNovedadService solicitudNovedadSrv;

    LogLlamadasBHService logLlamadasBHSrv;

    AesolicitudesService aesolicitudesSrv;

    GlobalServicesJpaRepository globalServicesRepository;

    @Inject
    public GlobalServicesService(
            PlanesService planesSrv,
            SolicitudService solicitudSrv,
            SolicitudNovedadService solicitudNovedadSrv,
            LogLlamadasBHService logLlamadasBHSrv,
            AesolicitudesService aesolicitudesSrv,
            GlobalServicesJpaRepository globalServicesRepository,
            UserFunctions userFunctionsSrv,
            GlobalServicesService globalServicesSrv) {
        this.planesSrv = planesSrv;
        this.solicitudSrv = solicitudSrv;
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.logLlamadasBHSrv = logLlamadasBHSrv;
        this.aesolicitudesSrv = aesolicitudesSrv;
        this.globalServicesRepository = globalServicesRepository;
        this.userFunctionsSrv = userFunctionsSrv;
        this.globalServicesSrv = globalServicesSrv;
    }

    /*
     * Entry point for global service OGSOLICITUDFISICALEER
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGSOLICITUDFISICALEERResponse oGSOLICITUDFISICALEER(
            com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGSOLICITUDFISICALEERRequest request) {
        com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGSOLICITUDFISICALEERResponse response = new com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGSOLICITUDFISICALEERResponse();
        try {
            response = globalServicesSrv.oGSOLICITUDFISICALEERTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service OGSOLICITUDFISICALEER
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGSOLICITUDFISICALEERResponse oGSOLICITUDFISICALEERTxn(
            com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGSOLICITUDFISICALEERRequest request) throws ModelException, SystemException {
        return globalServicesSrv.oGSOLICITUDFISICALEERImplementation(request);
    }

    /*
     * Implements global service OGSOLICITUDFISICALEER
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGSOLICITUDFISICALEERResponse oGSOLICITUDFISICALEERImplementation(
            com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGSOLICITUDFISICALEERRequest request) throws ModelException, SystemException {
        com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGSOLICITUDFISICALEERResponse response = new com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGSOLICITUDFISICALEERResponse();
        byte[] oGSOLICITUDFISICALEERpArchivo = request.getOGSOLICITUDFISICALEERpArchivo();

        request.checkArguments();

        try {
            com.keralty.aesolicitudes.viewmodel.globalservices.siu.TGSOLICITUDFISICACARGARRequest step1Request = new com.keralty.aesolicitudes.viewmodel.globalservices.siu.TGSOLICITUDFISICACARGARRequest();
            step1Request.setTGSOLICITUDFISICACARGARpCLProducto("");
            step1Request.setTGSOLICITUDFISICACARGARptpatrLOGIN("");
            step1Request.setTGSOLICITUDFISICACARGARptpNUMEROSOLICITUD("");
            step1Request.setTGSOLICITUDFISICACARGARptpSWESTADO("");
            step1Request.setTGSOLICITUDFISICACARGARptpFECHAESTADO(STDFunctions.systemDateFun());
            globalServicesSrv.tGSOLICITUDFISICACARGARTxn(step1Request);
        } catch (Exception e) { }

        try {
            com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGSOLICITUDFISICALEERRequest step2Request = new com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGSOLICITUDFISICALEERRequest();
            step2Request.setOGSOLICITUDFISICALEERpArchivo(oGSOLICITUDFISICALEERpArchivo);
            com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGSOLICITUDFISICALEERResponse step2Response = globalServicesSrv.oGSOLICITUDFISICALEERTxn(step2Request);
            response.setOGSOLICITUDFISICALEERpsArchivoResultado(step2Response.getOGSOLICITUDFISICALEERpsArchivoResultado());
            response.setOGSOLICITUDFISICALEERpsNombreArchivoResultado(step2Response.getOGSOLICITUDFISICALEERpsNombreArchivoResultado());
            response.setOGSOLICITUDFISICALEERpsResultado(step2Response.getOGSOLICITUDFISICALEERpsResultado());
        } catch (Exception e) { }
        return response;
    }

    /*
     * Entry point for global service TGSOLICITUDFISICACARGAR
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tGSOLICITUDFISICACARGAR(
            com.keralty.aesolicitudes.viewmodel.globalservices.siu.TGSOLICITUDFISICACARGARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = globalServicesSrv.tGSOLICITUDFISICACARGARTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service TGSOLICITUDFISICACARGAR
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tGSOLICITUDFISICACARGARTxn(
            com.keralty.aesolicitudes.viewmodel.globalservices.siu.TGSOLICITUDFISICACARGARRequest request) throws ModelException, SystemException {
        return globalServicesSrv.tGSOLICITUDFISICACARGARImplementation(request);
    }

    /*
     * Implements global service TGSOLICITUDFISICACARGAR
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tGSOLICITUDFISICACARGARImplementation(
            com.keralty.aesolicitudes.viewmodel.globalservices.siu.TGSOLICITUDFISICACARGARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        String tGSOLICITUDFISICACARGARpCLProducto = request.getTGSOLICITUDFISICACARGARpCLProducto();
        String tGSOLICITUDFISICACARGARptpatrLOGIN = request.getTGSOLICITUDFISICACARGARptpatrLOGIN();
        String tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD = request.getTGSOLICITUDFISICACARGARptpNUMEROSOLICITUD();
        String tGSOLICITUDFISICACARGARptpSWESTADO = request.getTGSOLICITUDFISICACARGARptpSWESTADO();
        Date tGSOLICITUDFISICACARGARptpFECHAESTADO = request.getTGSOLICITUDFISICACARGARptpFECHAESTADO();

        request.checkArguments();

        /* Action 1: IF (EXIST (Solicitud) WHERE (Solicitud.Aesolicitudes.Numerosolicitud = ptpNUMEROSOLICITUD) = false) */
        boolean ifCondition1 = globalServicesRepository.assocOperator076(tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD).equals(false);
        if (ifCondition1) {
            for(Productos step110Entity : globalServicesRepository.assocOperator074(tGSOLICITUDFISICACARGARpCLProducto)) {
                com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TCREARFISICARequest step10Request = new com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TCREARFISICARequest();
                step10Request.setAesolicitudesTCREARFISICAptpagrProductoInstance(step110Entity);
                step10Request.setAesolicitudesTCREARFISICAptpatrLOGIN(tGSOLICITUDFISICACARGARptpatrLOGIN);
                step10Request.setAesolicitudesTCREARFISICAptpNUMEROSOLICITUD(tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD);
                step10Request.setAesolicitudesTCREARFISICAptpSWESTADO(tGSOLICITUDFISICACARGARptpSWESTADO);
                step10Request.setAesolicitudesTCREARFISICAptpFECHAESTADO(tGSOLICITUDFISICACARGARptpFECHAESTADO);
                aesolicitudesSrv.tCREARFISICAImplementation(step10Request);
            }
        } else {
            for(Aesolicitudes step111Entity : globalServicesRepository.assocOperator075(tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD)) {
                com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.CambiarEstadoRequest step11Request = new com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.CambiarEstadoRequest();
                step11Request.setAesolicitudescambiarEstadopthisAESOLICITUDESInstance(step111Entity);
                step11Request.setAesolicitudescambiarEstadopSWESTADO(tGSOLICITUDFISICACARGARptpSWESTADO);
                aesolicitudesSrv.cambiarEstadoImplementation(step11Request);
            }
        }
        return response;
    }

    /*
     * Entry point for global service OGANULARSOL
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse oGANULARSOL(
            com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGANULARSOLRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = globalServicesSrv.oGANULARSOLTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service OGANULARSOL
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse oGANULARSOLTxn(
            com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGANULARSOLRequest request) throws ModelException, SystemException {
        return globalServicesSrv.oGANULARSOLImplementation(request);
    }

    /*
     * Implements global service OGANULARSOL
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse oGANULARSOLImplementation(
            com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGANULARSOLRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();

        if (request == null) {
            throw new IllegalArgumentException("Invalid request to oGANULARSOLImplementation");
        }


        try {
            for(Dominio step1Entity : globalServicesRepository.assocOperator135()) {
                try {
                    com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGANULARSOLAUXRequest step1Request = new com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGANULARSOLAUXRequest();
                    step1Request.setOGANULARSOLAUXptPlanInstance(step1Entity.getPlanT());
                    step1Request.setOGANULARSOLAUXptFechaCad(STDFunctions.dateAddFun("d", Long.valueOf(-1) * step1Entity.getDominioDiasCaducidad(), STDFunctions.systemDateFun()));
                    globalServicesSrv.oGANULARSOLAUXTxn(step1Request);
                } catch (Exception e) { }
            }
        } catch (Exception e) { }
        return response;
    }

    /*
     * Entry point for global service OGANULARSOLAUX
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse oGANULARSOLAUX(
            com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGANULARSOLAUXRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = globalServicesSrv.oGANULARSOLAUXTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service OGANULARSOLAUX
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse oGANULARSOLAUXTxn(
            com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGANULARSOLAUXRequest request) throws ModelException, SystemException {
        request.setOGANULARSOLAUXptPlanInstance(planesSrv.getByOIDWithHV(request.getOGANULARSOLAUXptPlan()));
        return globalServicesSrv.oGANULARSOLAUXImplementation(request);
    }

    /*
     * Implements global service OGANULARSOLAUX
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse oGANULARSOLAUXImplementation(
            com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGANULARSOLAUXRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Planes oGANULARSOLAUXptPlan = request.getOGANULARSOLAUXptPlanInstance();
        Date oGANULARSOLAUXptFechaCad = request.getOGANULARSOLAUXptFechaCad();

        request.checkArguments();

        try {
            for(Solicitud step1Entity : globalServicesRepository.assocOperator136(oGANULARSOLAUXptPlan, oGANULARSOLAUXptFechaCad)) {
                try {
                    com.keralty.aesolicitudes.viewmodel.solicitud.siu.TANULARAUTORequest step1Request = new com.keralty.aesolicitudes.viewmodel.solicitud.siu.TANULARAUTORequest();
                    step1Request.setSolicitudTANULARAUTOpthisSolicitudInstance(step1Entity);
                    solicitudSrv.tANULARAUTOTxn(step1Request);
                } catch (Exception e) { }
                globalServicesRepository.refreshEntity(oGANULARSOLAUXptPlan);
            }
        } catch (Exception e) { }
        return response;
    }

    /*
     * Entry point for global service OGASIGUSUARIOS
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGASIGUSUARIOSResponse oGASIGUSUARIOS(
            com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGASIGUSUARIOSRequest request) {
        com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGASIGUSUARIOSResponse response = new com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGASIGUSUARIOSResponse();
        try {
            response = globalServicesSrv.oGASIGUSUARIOSTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service OGASIGUSUARIOS
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGASIGUSUARIOSResponse oGASIGUSUARIOSTxn(
            com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGASIGUSUARIOSRequest request) throws ModelException, SystemException {
        return globalServicesSrv.oGASIGUSUARIOSImplementation(request);
    }

    /*
     * Implements global service OGASIGUSUARIOS
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGASIGUSUARIOSResponse oGASIGUSUARIOSImplementation(
            com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGASIGUSUARIOSRequest request) throws ModelException, SystemException {
        com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGASIGUSUARIOSResponse response = new com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGASIGUSUARIOSResponse();
        byte[] oGASIGUSUARIOSptFichero = request.getOGASIGUSUARIOSptFichero();

        request.checkArguments();

        boolean guard1 = Long.valueOf(1) < Long.valueOf(2);

        if (guard1) {
            for(Solicitud step1Entity : globalServicesRepository.assocOperator141()) {
                com.keralty.aesolicitudes.viewmodel.solicitud.siu.TREASIGNARUSUARIOSRequest step1Request = new com.keralty.aesolicitudes.viewmodel.solicitud.siu.TREASIGNARUSUARIOSRequest();
                step1Request.setSolicitudTREASIGNARUSUARIOSpthisSolicitudInstance(step1Entity);
                step1Request.setSolicitudTREASIGNARUSUARIOSptUsrAfiliacionInstance(step1Entity.getUsrAfiliacion());
                step1Request.setSolicitudTREASIGNARUSUARIOSptUsrAreaMedicaInstance(step1Entity.getUsrAreaMedica());
                com.keralty.aesolicitudes.viewmodel.solicitud.siu.TREASIGNARUSUARIOSResponse step1Response = solicitudSrv.tREASIGNARUSUARIOSImplementation(step1Request);
        response.setOGASIGUSUARIOSoaProcesados(step1Response.getSolicitudTREASIGNARUSUARIOSoaNumProcesados());
        response.setOGASIGUSUARIOSoaErrores(step1Response.getSolicitudTREASIGNARUSUARIOSoaNumErrores());
        response.setOGASIGUSUARIOSoaTextoErrores(step1Response.getSolicitudTREASIGNARUSUARIOSoaTextoErrores());
            }
        }

        for(SolicitudNovedad step2Entity : globalServicesRepository.assocOperator142()) {
            com.keralty.aesolicitudes.viewmodel.solicitudnovedad.siu.TREASIGNARUSUARIOSRequest step2Request = new com.keralty.aesolicitudes.viewmodel.solicitudnovedad.siu.TREASIGNARUSUARIOSRequest();
            step2Request.setSolicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedadInstance(step2Entity);
            step2Request.setSolicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacionInstance(step2Entity.getUsrAfiliacion());
            solicitudNovedadSrv.tREASIGNARUSUARIOSImplementation(step2Request);
        }

        com.keralty.aesolicitudes.viewmodel.logllamadasbh.siu.CreateinstanceRequest step3Request = new com.keralty.aesolicitudes.viewmodel.logllamadasbh.siu.CreateinstanceRequest();
        step3Request.setLogLlamadasBHcreateinstancepatrFechaHora(STDFunctions.systemDateTimeFun());
        step3Request.setLogLlamadasBHcreateinstancepatrUsuario("");
        step3Request.setLogLlamadasBHcreateinstancepatrCapacidad("");
        step3Request.setLogLlamadasBHcreateinstancepatrServicio("");
        step3Request.setLogLlamadasBHcreateinstancepatrSolicitud("");
        step3Request.setLogLlamadasBHcreateinstancepatrPeticion("");
        step3Request.setLogLlamadasBHcreateinstancepatrRespuesta("");
        step3Request.setLogLlamadasBHcreateinstancepatrTipoServicio("");
        step3Request.setLogLlamadasBHcreateinstancepatrTiempoEjecucion(Utilities.convertToDouble(Long.valueOf(0)));
        step3Request.setLogLlamadasBHcreateinstancepatrTextoError("");
        logLlamadasBHSrv.createinstanceImplementation(step3Request);
        return response;
    }
}
