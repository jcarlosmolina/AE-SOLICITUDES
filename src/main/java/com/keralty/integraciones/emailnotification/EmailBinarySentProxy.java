package com.keralty.integraciones.emailnotification;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;

import com.keralty.integraciones.emailnotification.binarysent.file.PayloadFileResponse;
import com.keralty.integraciones.emailnotification.binarysent.payload.PayloadResponse;
import com.keralty.integraciones.emailnotification.binarysent.submit.request.PayloadSubmitRequest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

@Path("")
@RegisterRestClient(configKey="integraciones_emailnotifications_binarysent")
public interface EmailBinarySentProxy {
	
	@GET
	@Path("/payload")
	public PayloadResponse payload(
			@HeaderParam("Authorization") String autorizacion);
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path("/payload/{payloadid}/file")
	public PayloadFileResponse file(
			@HeaderParam("Authorization") String autorizacion,
			@PathParam("payloadid") String payloadid,
			@MultipartForm MultipartFormDataOutput formData);

	@POST
	@Path("/payload/{payloadid}/submit")
	public String submit(
			@HeaderParam("Authorization") String autorizacion,
			@PathParam("payloadid") String payloadid,
			PayloadSubmitRequest request);
}
