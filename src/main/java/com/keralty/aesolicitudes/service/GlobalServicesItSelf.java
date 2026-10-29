package com.keralty.aesolicitudes.service;

import java.util.concurrent.CompletionStage;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGANULARSOLRequest;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/api/GlobalServicesApi")
@RegisterRestClient(configKey="ae-solicitudes")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aesolicitudes.utils.TokenUtilities.getToken4aesolicitudes}")
public interface GlobalServicesItSelf {

	
	// Definimos el mismo interfaz pero asíncrono
    @POST
    @Path(value = "/OGANULARSOL_Async")
    public CompletionStage<ServiceResponse> oGANULARSOL_Async(OGANULARSOLRequest request);

}
