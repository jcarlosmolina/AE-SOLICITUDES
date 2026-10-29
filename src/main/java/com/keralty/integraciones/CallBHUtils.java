/**
 * Clase utility para tareas comunes en las llamadas a los servicios de BH
 */
package com.keralty.integraciones;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.eclipse.microprofile.jwt.JsonWebToken;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.persistence.Funcionario;
import com.keralty.aesolicitudes.persistence.oid.FuncionarioOid;
import com.keralty.aesolicitudes.service.FuncionarioService;
import com.keralty.aesolicitudes.service.LogLlamadasBHService;
import com.keralty.aesolicitudes.viewmodel.logllamadasbh.siu.CreateinstanceRequest;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CallBHUtils {

    LogLlamadasBHService logLlamadasBHService;

    FuncionarioService serviceFuncionario;

    JsonWebToken jwt;

	@Inject
	public CallBHUtils(FuncionarioService serviceFuncionario, LogLlamadasBHService logLlamadasBHService, JsonWebToken jwt){
		this.serviceFuncionario = serviceFuncionario;
		this.logLlamadasBHService = logLlamadasBHService;
		this.jwt = jwt;
	}
	
    private String sanitizar(String valor) {
        if (valor == null) {
            return null;
        }
        // \R = any line break (\n, \r, \r\n, \u2028, ...).
        return valor.replaceAll("\\R", "_");
    }
	
	public String getUsuario() {
		
		if (jwt != null && jwt.getName() != null) {
			Set<String> grupos = jwt.getGroups();
			if (grupos.contains("UsuarioSistemaExterno")) {
				int i = jwt.getName().indexOf(":");
				if (i >= 0) {
					String nombre = jwt.getName().substring(i+1);
					nombre = nombre.replaceAll("\"", "").replaceAll(" ", "").replaceAll("}", "");
					return nombre;
				} else {
					org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error("CallBHUtils getUsuario - GU020");
				}
			} else {
				try {
					Funcionario funcionario = serviceFuncionario.getByOID(new FuncionarioOid( Long.valueOf(jwt.getName())));
					return funcionario.getFuncionarioUsuario();
				} catch (Exception e) {
		    		org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error(sanitizar("CallBHUtils getUsuario - " + e.getMessage()));
				}
			}
		}
		
		return "";
	}
	
    
    public String fromJsonToString(Object objetoJson) {
    	String retorno = "";
		ObjectMapper mapper= new ObjectMapper();
		if (objetoJson != null) {
			try {
				retorno = mapper.writeValueAsString(objetoJson);
			} catch (JsonProcessingException e) {
	    		org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error(e.getMessage());
			}
		}
		return retorno;
    }

    public byte[] fromJsonToByteArray(Object objetoJson) {
    	byte[] retorno = null;
		ObjectMapper mapper= new ObjectMapper();
		if (objetoJson != null) {
			try {
				retorno = mapper.writeValueAsBytes(objetoJson);
			} catch (JsonProcessingException e) {
	    		org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error(e.getMessage());
			}
		}
		return retorno;
    }

	public void guardarLlamadaBH(Timestamp fechaHora, String usuario, 
			String capacidad, String servicio, String numSolicitud, Object peticion, Object respuesta,
			Double tiempoEjecucion, String textoError){
		if (servicio == null || servicio.isEmpty()) {
			servicio = capacidad;
		}
		
		boolean exito = textoError == null || textoError.isEmpty();
		
		String texto = "Llamada a: " + servicio + " - " + capacidad;
		if (exito) {
			texto += " - Exito";
		} else {
			texto += " - Error";
		}
		if (numSolicitud != null && !numSolicitud.isEmpty()) {
			texto += " - Numero solicitud:" + numSolicitud;
		}
		if (tiempoEjecucion != null) {
			texto += " - Tiempo (seg):" + String.valueOf( tiempoEjecucion);
		}
		org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).info(sanitizar(texto));
		
		String peticionStr = fromJsonToString(peticion);
		String respuestaStr = fromJsonToString(respuesta);
		
		CreateinstanceRequest request = new CreateinstanceRequest();
		request.setLogLlamadasBHcreateinstancepatrFechaHora(fechaHora);
		request.setLogLlamadasBHcreateinstancepatrUsuario(usuario);
		request.setLogLlamadasBHcreateinstancepatrCapacidad(capacidad != null ? capacidad.toUpperCase() : "");
		request.setLogLlamadasBHcreateinstancepatrServicio(servicio);
		request.setLogLlamadasBHcreateinstancepatrSolicitud(numSolicitud);
		request.setLogLlamadasBHcreateinstancepatrPeticion(peticionStr);
		request.setLogLlamadasBHcreateinstancepatrRespuesta(respuestaStr);
		request.setLogLlamadasBHcreateinstancepatrTipoServicio("REST Service");
		request.setLogLlamadasBHcreateinstancepatrTiempoEjecucion(tiempoEjecucion);
		request.setLogLlamadasBHcreateinstancepatrTextoError(textoError);

		try {
			logLlamadasBHService.createinstanceTxn(request);
		} catch(Exception e) {
    		org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error(e.getMessage());
		}
	}
	
	public static String formatearFechaHoraREST(Timestamp fechaHora) {
		SimpleDateFormat dateTimeFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateTimeFormat.format(fechaHora);
	}
	
	public String getRequestDate() {
		java.util.Date currentDate = new java.util.Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(currentDate); 
	}

	public String formatFechaJson(java.sql.Date fecha) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(fecha); 
	}

	public static Timestamp systemDateTimeFun() {

		Date lDate = new Date();
		long lnMilisegundos = lDate.getTime();

		return new Timestamp(lnMilisegundos);
	}

}
