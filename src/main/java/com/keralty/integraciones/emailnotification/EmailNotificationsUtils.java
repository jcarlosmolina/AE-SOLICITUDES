package com.keralty.integraciones.emailnotification;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;
import org.jose4j.base64url.Base64;

import com.keralty.integraciones.CallBHUtils;
import com.keralty.integraciones.emailnotification.binarysent.file.PayloadFileResponse;
import com.keralty.integraciones.emailnotification.binarysent.payload.PayloadResponse;
import com.keralty.integraciones.emailnotification.binarysent.submit.request.Attachment;
import com.keralty.integraciones.emailnotification.binarysent.submit.request.Body;
import com.keralty.integraciones.emailnotification.binarysent.submit.request.EmailIn;
import com.keralty.integraciones.emailnotification.binarysent.submit.request.Headers;
import com.keralty.integraciones.emailnotification.binarysent.submit.request.PayloadSubmitRequest;
import com.keralty.integraciones.emailnotification.singlesent.request.SingleSentRequest;
import com.keralty.integraciones.emailnotification.singlesent.response.SingleSentResponse;
import com.keralty.integraciones.token.TokenUtils;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
public class EmailNotificationsUtils {

	TokenUtils tokenUtils;

	CallBHUtils callBHUtils;

	@RestClient
	EmailSingleSentProxy singleSentProxy;

	@RestClient
	EmailBinarySentProxy binarySentProxy;

	@ConfigProperty(name="com.keralty.integraciones_emailnotifications.binarysent.usr", defaultValue = "" )
    private String usrBinarySent;

	@ConfigProperty(name="com.keralty.integraciones_emailnotifications.binarysent.pwd", defaultValue = "" )
    private String pwdBinarySent;

	@ConfigProperty(name="com.keralty.integraciones_emailnotifications.binarysent.mailfrom", defaultValue = "" )
    private String mailFrom;

	@ConfigProperty(name="com.keralty.integraciones.codaplicacion", defaultValue = "" )
    private String codAplicacion;

	@ConfigProperty(name="com.keralty.integraciones.maxintentosllamada", defaultValue = "1" )
    private int maxIntentosLlamada;

    private int maxReintentos401 = 2;
	
	@Inject
	public EmailNotificationsUtils(TokenUtils tokenUtils, CallBHUtils callBHUtils) {
		this.tokenUtils = tokenUtils;
		this.callBHUtils = callBHUtils;
	}
	
	/**
	 * Punto de entrada para el envío de correos electrónicos
	 * @param asunto Asunto
	 * @param destinatario Direccion de correo del destinatario
	 * @param cuerpo Cuerpo del mensaje
	 * @param nombreAdjunto Nombre del archivo adjunto, opcional
	 * @param adjunto Datos del archivo adjunto, opcional
	 * @param numSolicitud Nº de solicitud
	 * @return El mensaje de error o cadena vacía
	 */
	public String enviarCorreo(String asunto, String destinatario, String cuerpo, String nombreAdjunto, byte[] adjunto, String numSolicitud, String mailCc) {
		if (nombreAdjunto != null && !nombreAdjunto.isEmpty() && adjunto != null && adjunto.length > 0) {
			return enviarCorreoConAdjunto(asunto, destinatario, cuerpo, nombreAdjunto, adjunto, numSolicitud, mailCc);
		} else {
			return enviarCorreoSinAdjunto(asunto, destinatario, cuerpo, numSolicitud, mailCc);
		}
	}
	
	private String enviarCorreoSinAdjunto(String asunto, String destinatario, String cuerpo, String numSolicitud, String mailCc) {
		
		SingleSentRequest requestSinAdjunto = new SingleSentRequest();
		requestSinAdjunto.setApplication( codAplicacion );
		requestSinAdjunto.setCertimail("CNC");
		requestSinAdjunto.setMailTo(destinatario);
		requestSinAdjunto.setMessage(cuerpo);
		requestSinAdjunto.setSubject(asunto);
		requestSinAdjunto.setMailCc(mailCc);
		
		// Datos de headers
		String idPeticion = "AE" + numSolicitud;
		String idTerminal = "1";
		String usuario = "";
		try {
			usuario = callBHUtils.getUsuario();
		} catch (Exception e) {
			org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error("EMN-0005. Error recuperando usuario. " + e.getMessage());
			return "EMN-0005";
		}
		
        long startTime = System.currentTimeMillis();
        Timestamp fechaHora = CallBHUtils.systemDateTimeFun();	
        String mensajeError = "";
        long endTime = startTime;
		Double tiempoEjecucion = 0.0;
		int numIntentos = 1;
		int numReintentos401 = 0;

		String token = "";
		try {
			token = tokenUtils.getTokenValue();
		} catch (Exception e) {
			org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error("EMN-0010. Error obteniendo token. " + e.getMessage());
			return "EMN-0010";
		}
		SingleSentResponse response = null;
		while (numIntentos <= maxIntentosLlamada && numReintentos401 < maxReintentos401) {

            startTime = System.currentTimeMillis();
            fechaHora = CallBHUtils.systemDateTimeFun();	
        	try {
        		response = singleSentProxy.singleSent(token, 
        				idPeticion, 
        				idTerminal, 
        				usuario, 
        				callBHUtils.getRequestDate(), 
        				requestSinAdjunto);
        		endTime = System.currentTimeMillis();
        		mensajeError = "";
        		if (!"Ok".equalsIgnoreCase(response.getCode())) {
        			mensajeError = response.getValue();
        		}
        		break;
        	} catch (Exception e) {
        		endTime = System.currentTimeMillis();
        		mensajeError = e.getMessage();
    			if (mensajeError != null && mensajeError.indexOf("401") >= 0) {
					org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).info("Notifications singleSent. Reintento por 401");
    				// Guardamos la llamada al WS
    				tiempoEjecucion = (double) ((endTime - startTime)/1000.0f);
    				callBHUtils.guardarLlamadaBH(fechaHora, usuario, 
    						"singleSent",
    						"Notifications", 
    						numSolicitud, 
    						requestSinAdjunto, response, tiempoEjecucion, mensajeError);
					// Esperamos 2 segundos
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error(e1.getMessage());
						Thread.currentThread().interrupt();
					}
					try {
						token = tokenUtils.getTokenValue();					
					} catch (Exception e2) {
						org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error("EMN-0020. Error obteniendo token. " + e.getMessage());
						return "EMN-0020";
					}
    				numReintentos401++;			
    			} else {
    				numIntentos++;
        		}
        	}
        }
		
		tiempoEjecucion = (double) ((endTime - startTime)/1000.0f);
		// Guardamos la llamada al WS
		callBHUtils.guardarLlamadaBH(fechaHora, usuario, 
				"singleSent",
				"Notifications", 
				numSolicitud, 
				requestSinAdjunto, response, tiempoEjecucion, mensajeError);
		
		return mensajeError != null && !mensajeError.isEmpty() ? mensajeError : "Email enviado";
	}

	private String enviarCorreoConAdjunto(String asunto, String destinatario, String cuerpo, String nombreAdjunto, byte[] adjunto, String numSolicitud, String mailCc) {
		
		// Se utiliza autorizacion Basica, con lo que se aplica lo siguiente: 
		// Basic base64(username:password)
		if (usrBinarySent == null || usrBinarySent.isEmpty()) {
			org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error("EMN-1010. Error Usuario Configuracion");
			return "EMN-1010. Error Usuario Configuracion";
		}
		if (pwdBinarySent == null || pwdBinarySent.isEmpty()) {
			org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error("EMN-1020. Error pwd Configuracion");
			return "EMN-1020. Error pwd Configuracion";
		}
		String autorization = "Basic " + Base64.encode((usrBinarySent + ":" + pwdBinarySent).getBytes());
		
		String usuario = null;
		try {
			usuario = callBHUtils.getUsuario();
		} catch (Exception e) {
			org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error("EMN-0030. Error recuperando usuario. " + e.getMessage());
			return "EMN-0030";
		}

		
		// Paso 1: Obtenemos el Payload Id:
		String payloadId = obtenerPayLoadId(autorization, usuario, numSolicitud);
		if (payloadId == null) {
			return "EMN-0040";
		}
		
		// Paso 2: Enviamos el adjunto y el body del mensaje (como fichero de texto html)
		
		if (!enviarFicheros(autorization, payloadId, usuario, numSolicitud, adjunto, nombreAdjunto)) {
			return "EMN-0050";
		}

		// Paso 3: Enviamos datos del correo
		if (!enviarDatos(autorization, payloadId, usuario, numSolicitud, destinatario, asunto, nombreAdjunto, mailCc, cuerpo)) {
			return "EMN-0060";
		}

		return "Email enviado";
	}
	
	private boolean enviarDatos(String autorization, String payloadId, String usuario, String numSolicitud, String destinatario, String asunto, String nombreAdjunto, String mailCc, String cuerpo) {
        long startTime = System.currentTimeMillis();
        Timestamp fechaHora = CallBHUtils.systemDateTimeFun();	
        String mensajeError = "";
        long endTime = startTime;
		Double tiempoEjecucion = 0.0;
		int numIntentos = 1;

		PayloadSubmitRequest request = new PayloadSubmitRequest();
		request.setHeaders(new Headers());
		request.getHeaders().setAccept("application/json");
		request.getHeaders().setApIuser("NOTIFICACIONES_COLSANITAS");
		request.getHeaders().setAplicationCod(codAplicacion);
		request.getHeaders().setContentType("application/json");
		request.getHeaders().setDateRequest(callBHUtils.getRequestDate());
		request.getHeaders().setMailFrom(mailFrom);
		request.getHeaders().setPetitionID(numSolicitud);
		request.getHeaders().setSentType("Attachment");
		request.getHeaders().setTerminalID(".");
		
		request.setBody(new Body());
		request.getBody().setAnnotations(".");
		request.getBody().setApplication(codAplicacion);
		request.getBody().setCertimail("CNC");
		request.getBody().setEmailIn(new EmailIn());
		// Añadimos el nmobre del adjunto
		request.getBody().getEmailIn().setAttachments(new ArrayList<Attachment>());
		Attachment attachment = new Attachment();
		attachment.setName(nombreAdjunto);
		attachment.setPDFCipherPass("");
		request.getBody().getEmailIn().getAttachments().add(attachment);
		request.getBody().setMailConfirmation(".");
		request.getBody().setMailTo(destinatario);
		request.getBody().setMailConfirmation(mailCc);
		request.getBody().setMensajeString(cuerpo);
		request.getBody().setSubject(asunto);
		request.getBody().setTokenPy(payloadId);
		
		
		String respuesta = null;
		while (numIntentos <= maxIntentosLlamada) {
			mensajeError = "";
            startTime = System.currentTimeMillis();
            fechaHora = CallBHUtils.systemDateTimeFun();	
        	try {
        		respuesta = binarySentProxy.submit(autorization, payloadId, request );
        		
        		endTime = System.currentTimeMillis();
        		break;

        	} catch (Exception e) {
        		endTime = System.currentTimeMillis();
        		mensajeError = e.getMessage();
        	}
			numIntentos++;
        }
		
		tiempoEjecucion = (double) ((endTime - startTime)/1000.0f);
		// Guardamos la llamada al WS
		callBHUtils.guardarLlamadaBH(fechaHora, usuario, 
				"BinarySent Submmit",
				"Notifications", 
				numSolicitud, 
				request, respuesta, tiempoEjecucion, mensajeError);
		
		return mensajeError.isEmpty();
	}	
	
	private boolean enviarFicheros(String autorization, String payloadId, String usuario, String numSolicitud, byte[] adjunto, String nombreAdjunto) {
        long startTime = System.currentTimeMillis();
        Timestamp fechaHora = CallBHUtils.systemDateTimeFun();	
        String mensajeError = "";
        long endTime = startTime;
		Double tiempoEjecucion = 0.0;
		int numIntentos = 1;

		// El adjunto

		
		MultipartFormDataOutput multiOuput = new MultipartFormDataOutput();
		// El endpoint espera el archivo en la parte `content`, tal como en el curl de Postman
		MediaType mediaTypeAdjunto = (nombreAdjunto != null && nombreAdjunto.toLowerCase().endsWith(".zip"))
				? MediaType.valueOf("application/zip")
				: MediaType.APPLICATION_OCTET_STREAM_TYPE;
		multiOuput.addFormData("content", adjunto, mediaTypeAdjunto, nombreAdjunto);

		PayloadFileResponse respuesta = null;
		while (numIntentos <= maxIntentosLlamada) {
			mensajeError = "";
            startTime = System.currentTimeMillis();
            fechaHora = CallBHUtils.systemDateTimeFun();	
        	try {
        		respuesta = binarySentProxy.file(autorization, payloadId, multiOuput );
        		
        		endTime = System.currentTimeMillis();
        		if (respuesta.getData() == null || respuesta.getData().getStatus() == null) {
        			mensajeError = "EMN-3010. Error BinarySent - File: Respuesta no esperada";
        			org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error(mensajeError);
        		} else if ("DRAFT".equalsIgnoreCase(respuesta.getData().getStatus())) {
        			break;
        		} else {
        			mensajeError = "EMN-3020. Error BinarySent - File: " + respuesta.getData().getStatus() + " " + respuesta.getData().getMessage();
        			org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error(mensajeError);
        		}
        	} catch (Exception e) {
        		endTime = System.currentTimeMillis();
        		mensajeError = e.getMessage();
        	}
			numIntentos++;
        }
		
		tiempoEjecucion = (double) ((endTime - startTime)/1000.0f);
		// Guardamos la llamada al WS
		callBHUtils.guardarLlamadaBH(fechaHora, usuario, 
				"BinarySent file",
				"Notifications", 
				numSolicitud, 
				"", respuesta, tiempoEjecucion, mensajeError);
		
		return mensajeError.isEmpty();
	}
	
	
	private String obtenerPayLoadId(String autorization, String usuario, String numSolicitud) {
        long startTime = System.currentTimeMillis();
        Timestamp fechaHora = CallBHUtils.systemDateTimeFun();	
        String mensajeError = "";
        long endTime = startTime;
		Double tiempoEjecucion = 0.0;
		int numIntentos = 1;

		String payloadId = null;
		PayloadResponse payloadResp = null;
		while (numIntentos <= maxIntentosLlamada) {
            startTime = System.currentTimeMillis();
            fechaHora = CallBHUtils.systemDateTimeFun();	
        	try {
    			payloadResp = binarySentProxy.payload(autorization);
        		
        		endTime = System.currentTimeMillis();
        		if (payloadResp.getData() == null || payloadResp.getData().getPayloadID() == null) {
        			org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error("EMN-2010. Error obtenido PayloadId");
        		} else  {
        			payloadId = payloadResp.getData().getPayloadID();
        			break;
        		}
        	} catch (Exception e) {
        		endTime = System.currentTimeMillis();
        		mensajeError = e.getMessage();
        	}
			numIntentos++;
        }
		
		tiempoEjecucion = (double) ((endTime - startTime)/1000.0f);
		// Guardamos la llamada al WS
		callBHUtils.guardarLlamadaBH(fechaHora, usuario, 
				"BinarySent payload",
				"Notifications", 
				numSolicitud, 
				null, payloadResp, tiempoEjecucion, mensajeError);
		
		return payloadId;
	}
}