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

import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.Asesor;
import com.keralty.aesolicitudes.persistence.Funcionario;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.HashMap;

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
    
    private String sanitizar(String valor) {
        if (valor == null) {
            return null;
        }
        // \R = any line break (\n, \r, \r\n, \u2028, ...).
        return valor.replaceAll("\\R", "_");
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
            byte[] oGSOLICITUDFISICALEERpArchivo = request.getOGSOLICITUDFISICALEERpArchivo();

            request.checkArguments();

            // Campos del registro 
            // 1. Numero de producto 
            // 2. Asesor
            // 3. Numero de la solicitud
            // 4. Indicador solicitud
            // 5. Fecha del estado

    		String ficheroResultado = "PRODUCTO^LOGIN^NUMSOLICITUD^INDICADOR^FECHAASIGNACION^MENSAJE\n";
    		String oaTextoErrores = "";
    		long oaErrores = 0L;
    		long oaProcesados = 0L;
    		try {


    			ByteArrayInputStream inputStream = new ByteArrayInputStream(oGSOLICITUDFISICALEERpArchivo);
    			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)); 

    			String linea = "";
    			String codProducto = "";
    			String numRadicado = "";
    			String numAsesor = "";
    			String indicadorSolicitud = "";
    			String fechaEstadoStr = "";
    			Productos producto = null;
    			Funcionario funcionario = null;
    	        Date fechaEstado = null;
    			// Cache para los usuarios
        		HashMap < String, Object > cacheProductos = new HashMap < String, Object >();
        		HashMap < String, Object > cacheFuncionarios = new HashMap < String, Object >();
        		boolean primera = true;
    			while((linea = reader.readLine()) != null){

    				// Nos saltamos la primera linea al ser la de cabecera
    				if (primera) {
    					primera = false;
    					continue;
    				}
    				
    				if (linea.isEmpty()) {
    					continue;
    				}
    				
    				oaProcesados++;
    				
    				String[] arrayDatos = linea.split("\\^");
        			codProducto = arrayDatos.length > 0 ? arrayDatos[0] : null;  
        			numAsesor = arrayDatos.length > 1 ? arrayDatos[1] : null;  
        			numRadicado = arrayDatos.length > 2 ? arrayDatos[2] : null;  
        			indicadorSolicitud = arrayDatos.length > 3 ? arrayDatos[3] : null;  
        			fechaEstadoStr = arrayDatos.length > 4 ? arrayDatos[4] : null;  

        			// Datos obligatorios
                    if (codProducto == null) {
                    	oaTextoErrores += SolicitudConstants.MSG_ERR_SOLICITUDFISICALEER_CODLEGALPROD + "\n";
                    	ficheroResultado += linea + "^".repeat(5 - arrayDatos.length + 1) + SolicitudConstants.MSG_ERR_SOLICITUDFISICALEER_CODLEGALPROD + "\n";
                    	oaErrores++;
                    	continue;
                    }
                    if (numAsesor == null) {
                    	oaTextoErrores += SolicitudConstants.MSG_ERR_SOLICITUDFISICALEER_ASESOR + "\n";
                    	ficheroResultado += linea + "^".repeat(5 - arrayDatos.length + 1) + SolicitudConstants.MSG_ERR_SOLICITUDFISICALEER_ASESOR + "\n";
                    	oaErrores++;
                    	continue;
                    }
                    if (numRadicado == null) {
                    	oaTextoErrores += SolicitudConstants.MSG_ERR_SOLICITUDFISICALEER_NUMSOLICITUD + "\n";
                    	ficheroResultado += linea + "^".repeat(5 - arrayDatos.length + 1) + SolicitudConstants.MSG_ERR_SOLICITUDFISICALEER_NUMSOLICITUD + "\n";
                    	oaErrores++;
                    	continue;
                    }

                    // Campo fecha. Debe seguir el formato dd/MM/yyyy
    				if (fechaEstadoStr != null) {
    					
    	                try {
    	                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	                    fechaEstado = new Date( sdf.parse(fechaEstadoStr).getTime());
    	                } catch (Exception e) {
    	                	oaTextoErrores += SolicitudConstants.MSG_ERR_SOLICITUDFISICALEER_FECHAERROR + "\n";
    	                	ficheroResultado += linea + "^".repeat(5 - arrayDatos.length + 1) + SolicitudConstants.MSG_ERR_SOLICITUDFISICALEER_FECHAERROR + "\n";
    	                	oaErrores++;
        					continue;
    	                }
    				} else {
    					fechaEstado = null;
    				}

                    
                    // Comprobacion de existencia
    				if (cacheProductos.containsKey(codProducto)) {
    					producto = (Productos)cacheProductos.get(codProducto);
    				} else {
    					producto = userFunctionsSrv.fugetProductoPorCLFun(codProducto);
    					if (producto != null && !producto.isNull()) {
    						cacheProductos.put(codProducto, producto);
    					} else {
    	                	oaTextoErrores += SolicitudConstants.MSG_ERR_SOLICITUDFISICALEER_PRODNOEXIST + "\n";
    	                	ficheroResultado += linea + "^".repeat(5 - arrayDatos.length + 1) + SolicitudConstants.MSG_ERR_SOLICITUDFISICALEER_PRODNOEXIST + "\n";
    	                	oaErrores++;
        					continue;
    					}
    				}
                    
    				if (cacheFuncionarios.containsKey(numAsesor)) {
    					funcionario = (Funcionario)cacheFuncionarios.get(numAsesor);
    				} else {
    					funcionario = userFunctionsSrv.fugetAgenteFun(numAsesor);
    					if (funcionario != null && !funcionario.isNull()) {
    						cacheFuncionarios.put(numAsesor, funcionario);
    					} else {
    	                	oaTextoErrores += SolicitudConstants.MSG_ERR_SOLICITUDFISICALEER_ASESOR + "\n";
    	                	ficheroResultado += linea + "^".repeat(5 - arrayDatos.length + 1) + SolicitudConstants.MSG_ERR_SOLICITUDFISICALEER_ASESOR + "\n";
    	                	oaErrores++;
        					continue;
    					}
    				}
    				
        			
    				// Buscamos la solicitud por numero de radicado
    				try {

    			        com.keralty.aesolicitudes.viewmodel.globalservices.siu.TGSOLICITUDFISICACARGARRequest stepCargar = new com.keralty.aesolicitudes.viewmodel.globalservices.siu.TGSOLICITUDFISICACARGARRequest();
    			        stepCargar.setTGSOLICITUDFISICACARGARpCLProducto(codProducto);
    			        stepCargar.setTGSOLICITUDFISICACARGARptpatrLOGIN(numAsesor);
    			        stepCargar.setTGSOLICITUDFISICACARGARptpNUMEROSOLICITUD(numRadicado);
    			        stepCargar.setTGSOLICITUDFISICACARGARptpSWESTADO(indicadorSolicitud);
    					stepCargar.setTGSOLICITUDFISICACARGARptpFECHAESTADO(fechaEstado);
    			        ServiceResponse resp = globalServicesSrv.tGSOLICITUDFISICACARGAR(stepCargar);
    			        if (!resp.isOk()) {
        					oaErrores++;
        					oaTextoErrores += resp.getResultDescription() + " " + linea + "\n";
                        	ficheroResultado += linea + "^".repeat(5 - arrayDatos.length + 1) + resp.getResultDescription() + "\n";
    			        }
    			        
    				} catch (ModelException e) {
    					oaErrores++;
    					oaTextoErrores += e.getMessage() + " " + linea + "\n";
                    	ficheroResultado += linea + "^".repeat(5 - arrayDatos.length + 1) + e.getMessage() + "\n";
    				} catch (Exception e) {
    					oaErrores++;
    					oaTextoErrores += numRadicado + " : " + e.getMessage() + "\n";
                    	ficheroResultado += linea + "^".repeat(5 - arrayDatos.length + 1) + e.getMessage() + "\n";
    				}
    			}

    		} catch (Exception e) {
        		org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error("Carga solicitudes fisicas\n" + e.getMessage());
    			oaTextoErrores += "Error procesando fichero\n";
    		}

            String executionSummary = "";
            if (oaErrores  == 0) {
                executionSummary = SolicitudConstants.MSG_ERR_SOLICITUDFISICALEER_SUM_EXITO;
            } else {
                executionSummary += SolicitudConstants.MSG_ERR_SOLICITUDFISICALEER_SUM_ERROR + "\n";
                executionSummary += SolicitudConstants.MSG_ERR_SOLICITUDFISICALEER_SUM_TOTALES + oaProcesados + "\n";
                executionSummary += SolicitudConstants.MSG_ERR_SOLICITUDFISICALEER_SUM_CORRECTOS + (oaProcesados - oaErrores) + "\n";
                executionSummary += SolicitudConstants.MSG_ERR_SOLICITUDFISICALEER_SUM_ERRONEOS + oaErrores + "\n";
                executionSummary += "==============================\n";
                executionSummary += SolicitudConstants.MSG_ERR_SOLICITUDFISICALEER_SUM_FININFORME + "\n";
                executionSummary += "==============================\n";
                executionSummary += oaTextoErrores + "\n";
            }

    		response.setOGSOLICITUDFISICALEERpsResultado(executionSummary);
    		response.setOGSOLICITUDFISICALEERpsNombreArchivoResultado("ResultadoCargaSolicitudesFisicas.txt");
    		response.setOGSOLICITUDFISICALEERpsArchivoResultado(ficheroResultado.getBytes());
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

        if (request == null) {
        	throw new IllegalArgumentException("request cannot be null in oGSOLICITUDFISICALEERImplementation");
        }
        
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
                } catch (Exception e) {
                	org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).info("\n   Error anulando solicitudes del Plan: " + step1Entity.getPlanT().getPlanesCodigoLegal() + " " + step1Entity.getPlanT().getPlanesNombre() + "\n" + e.getMessage());                	
                }
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

        int contador = 0;
        int errores = 0;
        String numRadicado = "";
        try {
            for(Solicitud step1Entity : globalServicesRepository.assocOperator136(oGANULARSOLAUXptPlan, oGANULARSOLAUXptFechaCad)) {
            	numRadicado = step1Entity.getSolicitudNumRadicado().toString();
                try {
                    com.keralty.aesolicitudes.viewmodel.solicitud.siu.TANULARAUTORequest step1Request = new com.keralty.aesolicitudes.viewmodel.solicitud.siu.TANULARAUTORequest();
                    step1Request.setSolicitudTANULARAUTOpthisSolicitudInstance(step1Entity);
                    solicitudSrv.tANULARAUTOTxn(step1Request);
                    contador++;
                } catch (Exception e) {
                	errores++;	
                	org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).info("\n   Error anulando solicitud: " + numRadicado + " - " + e.getMessage());
                }
            }
        } catch (Exception e) { }
        
    	org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).info(sanitizar("\n   Plan: " + oGANULARSOLAUXptPlan.getPlanesCodigoLegal() + " " + oGANULARSOLAUXptPlan.getPlanesNombre() + " solicitudes procesadas: " + contador + ".  Errores: " + errores));
        
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
            byte[] oGASIGUSUARIOSptFichero = request.getOGASIGUSUARIOSptFichero();

            request.checkArguments();

    		String oaTextoErrores = "";
    		long oaErrores = 0L;
    		long oaProcesados = 0L;
    		try {

    			ByteArrayInputStream inputStream = new ByteArrayInputStream(oGASIGUSUARIOSptFichero);
    			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)); 

    			String linea = "";
    			String numRadicado = "";
    			String ldapUsrAfiliacion = "";
    			String ldapUsrAreaMedica = "";
    			Solicitud solicitud = null;
    			SolicitudNovedad solicitudNovedad = null;
    			Funcionario funcionarioAfil = null;
    			Funcionario funcionarioAreaMedica= null;
    			// Cache para los usuarios
        		HashMap < String, Object > cacheUsrAfil = new HashMap < String, Object >();
        		HashMap < String, Object > cacheUsrAreaMedica = new HashMap < String, Object >();
    			while((linea = reader.readLine()) != null){

    				String[] arrayDatos = linea.split(",");
        			numRadicado = "";
        			ldapUsrAfiliacion = "";
        			ldapUsrAreaMedica = "";
        			solicitud = null;
        			funcionarioAfil = null;
        			funcionarioAreaMedica = null;
    				numRadicado = arrayDatos[0];
    				if (arrayDatos.length > 1) {
    					ldapUsrAfiliacion = arrayDatos[1];
    					if (ldapUsrAfiliacion != null && !ldapUsrAfiliacion.isEmpty()) {
        					if (cacheUsrAfil.containsKey(ldapUsrAfiliacion)) {
        						funcionarioAfil = (Funcionario)cacheUsrAfil.get(ldapUsrAfiliacion);
        					} else {
        						funcionarioAfil = userFunctionsSrv.fugetFuncionarioPorLDAPFun(ldapUsrAfiliacion);
        						if (funcionarioAfil != null && !funcionarioAfil.isNull()) {
        							cacheUsrAfil.put(ldapUsrAfiliacion, funcionarioAfil);
        						} else {
    		    					oaErrores++;
    		    					oaTextoErrores += numRadicado + " : Usuario no existente : " + ldapUsrAfiliacion + "\n";
        						}
        					}
    					}
    				}
    				if (arrayDatos.length > 2) {
    					ldapUsrAreaMedica = arrayDatos[2];
    					if (ldapUsrAreaMedica != null && !ldapUsrAreaMedica.isEmpty()) {
        					if (cacheUsrAreaMedica.containsKey(ldapUsrAreaMedica)) {
        						funcionarioAreaMedica = (Funcionario)cacheUsrAreaMedica.get(ldapUsrAreaMedica);
        					} else {
        						funcionarioAreaMedica = userFunctionsSrv.fugetFuncionarioPorLDAPFun(ldapUsrAreaMedica);
        						if (funcionarioAreaMedica != null && !funcionarioAreaMedica.isNull() && 
        								funcionarioAreaMedica.getAreaMedicaFacet() != null && !funcionarioAreaMedica.getAreaMedicaFacet().isNull()) {
        							cacheUsrAreaMedica.put(ldapUsrAreaMedica, funcionarioAreaMedica);
        						} else {
    		    					oaErrores++;
    		    					oaTextoErrores += numRadicado + " : Usuario no existente : " + ldapUsrAreaMedica + "\n";
        						}
        					}
    					}
    				}
    				
    				if (numRadicado != null && !numRadicado.isEmpty()) {
        				oaProcesados++;
        				// Buscamos la solicitud por numero de radicado.
        				solicitud =  userFunctionsSrv.fugetSolicitudByNumeroFun(numRadicado);
        				if (solicitud != null && !solicitud.isNull()) {
    	    				try {
    	    					
    	    	                com.keralty.aesolicitudes.viewmodel.solicitud.siu.TREASIGNARUSUARIOSRequest stepTasignar = new com.keralty.aesolicitudes.viewmodel.solicitud.siu.TREASIGNARUSUARIOSRequest();
    	    	                stepTasignar.setSolicitudTREASIGNARUSUARIOSpthisSolicitudInstance(solicitud);
    	    	                stepTasignar.setSolicitudTREASIGNARUSUARIOSptUsrAfiliacionInstance(funcionarioAfil);
    	    	                stepTasignar.setSolicitudTREASIGNARUSUARIOSptUsrAreaMedicaInstance(funcionarioAreaMedica != null && !funcionarioAreaMedica.isNull() ? funcionarioAreaMedica.getAreaMedicaFacet() : null);
    	    	                com.keralty.aesolicitudes.viewmodel.solicitud.siu.TREASIGNARUSUARIOSResponse resp = solicitudSrv.tREASIGNARUSUARIOS(stepTasignar);
    	    	                if (!resp.isOk()) {
        	    					oaErrores++;
        	    					oaTextoErrores += numRadicado + " : " + resp.getResultDescription() + "\n";
    	    	                }
    	
    	    				} catch (Exception e) {
    	    					oaErrores++;
    	    					oaTextoErrores += numRadicado + " : " + e.getMessage() + "\n";
    	    				}
        					
        				} else {
    	    				// Si no la encontramos, la buscamos como solicitud de novedad
        					solicitudNovedad = userFunctionsSrv.fugetSolicitudNovedadByNumRadicadoFun(numRadicado);
    	    				try {
    	    					if (solicitudNovedad != null && !solicitudNovedad.isNull()) {
    	    						
    	    			            com.keralty.aesolicitudes.viewmodel.solicitudnovedad.siu.TREASIGNARUSUARIOSRequest stepSolNov = new com.keralty.aesolicitudes.viewmodel.solicitudnovedad.siu.TREASIGNARUSUARIOSRequest();
    	    			            stepSolNov.setSolicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedadInstance(solicitudNovedad);
    	    			            stepSolNov.setSolicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacionInstance(funcionarioAfil);
    	    			            ServiceResponse resp = solicitudNovedadSrv.tREASIGNARUSUARIOS(stepSolNov);
    	    			            if (!resp.isOk()) {
            	    					oaErrores++;
            	    					oaTextoErrores += numRadicado + " : " + resp.getResultDescription() + "\n";
        	    	                }    	    			            
    	    					} else {
    		    					oaErrores++;
    		    					oaTextoErrores += numRadicado + " : Solicitud no existente\n";
    	    					}
    	
    	    				} catch (Exception e) {
    	    					oaErrores++;
    	    					oaTextoErrores += numRadicado + " : " + e.getMessage() + "\n";
    	    				}
        					
        				}
    				}
    			}

    		} catch (Exception e) {
        		org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error("Asignacion solicitudes\n" + e.getMessage());
    			oaTextoErrores += "Error procesando fichero\n";
    		}

    		response.setOGASIGUSUARIOSoaProcesados(oaProcesados);
    		response.setOGASIGUSUARIOSoaErrores(oaErrores);
    		response.setOGASIGUSUARIOSoaTextoErrores(oaTextoErrores);
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
        if(request == null) {
        	throw new IllegalArgumentException("request cannot be null in oGASIGUSUARIOSImplementation");
        }
        return response;
    }
}
