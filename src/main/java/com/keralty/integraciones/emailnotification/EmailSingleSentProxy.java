package com.keralty.integraciones.emailnotification;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.keralty.integraciones.emailnotification.singlesent.request.SingleSentRequest;
import com.keralty.integraciones.emailnotification.singlesent.response.SingleSentResponse;

import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("")
@RegisterRestClient(configKey="integraciones_emailnotifications")
public interface EmailSingleSentProxy {
	
	@POST
	@Path("/singleSent")
	@ClientHeaderParam(name="Content-Type", value="application/json")
	@ClientHeaderParam(name="Accept", value="*/*")
	@ClientHeaderParam(name="aplicationCod", value="${com.keralty.integraciones.codaplicacion}")
	@ClientHeaderParam(name="mailFrom", value="${com.keralty.integraciones_emailnotifications.mailFrom}")
	@ClientHeaderParam(name="sentType", value="noAttachment")
	public SingleSentResponse singleSent(
			@HeaderParam("Authorization") String token, 
			@HeaderParam("petitionId") String idPeticion, 
			@HeaderParam("terminalId") String idTerminal, 
			@HeaderParam("APIuser") String usuario, 
			@HeaderParam("dateRequest") String fechaPeticion, 
			@RequestBody SingleSentRequest request);
	
}
