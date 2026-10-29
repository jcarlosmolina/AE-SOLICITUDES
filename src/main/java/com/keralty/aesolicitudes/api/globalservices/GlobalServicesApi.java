package com.keralty.aesolicitudes.api.globalservices;

import com.keralty.aesolicitudes.service.GlobalServicesService;
import com.keralty.aesolicitudes.utils.TokenUtilities;
import com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGANULARSOLAUXRequest;
import com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGANULARSOLRequest;
import com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGASIGUSUARIOSRequest;
import com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGASIGUSUARIOSResponse;
import com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGSOLICITUDFISICALEERRequest;
import com.keralty.aesolicitudes.viewmodel.globalservices.siu.OGSOLICITUDFISICALEERResponse;
import com.keralty.aesolicitudes.viewmodel.globalservices.siu.TGSOLICITUDFISICACARGARRequest;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import org.eclipse.microprofile.jwt.JsonWebToken;

import com.keralty.aesolicitudes.service.GlobalServicesItSelf;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/api/GlobalServicesApi")
@RequestScoped
public class GlobalServicesApi {

    GlobalServicesService service;
    
    @RestClient
    GlobalServicesItSelf globalServicesItSelf;

    public GlobalServicesApi(GlobalServicesService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @POST
    @Path(value = "/OGSOLICITUDFISICALEER")
    @RolesAllowed({"Admin","SuperAdmin"})
    public OGSOLICITUDFISICALEERResponse oGSOLICITUDFISICALEER(OGSOLICITUDFISICALEERRequest request) {
        return service.oGSOLICITUDFISICALEER(request);
    }

    @POST
    @Path(value = "/TGSOLICITUDFISICACARGAR")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse tGSOLICITUDFISICACARGAR(TGSOLICITUDFISICACARGARRequest request) {
        return service.tGSOLICITUDFISICACARGAR(request);
    }

    @POST
    @Path(value = "/OGANULARSOL")
    @RolesAllowed({"SuperAdmin","UsuarioSistemaExterno"})
    public ServiceResponse oGANULARSOL(OGANULARSOLRequest request) {
    	// Llama a un REST que es el mismo, pero sin esperar respuesta
    	globalServicesItSelf.oGANULARSOL_Async(request);
    	
		// Devolvemos Ok 
    	return new ServiceResponse();
    	
        //return service.oGANULARSOL(request);
    }

    @POST
    @Path(value = "/OGANULARSOL_Async")
    @RolesAllowed({"SuperAdmin","UsuarioSistemaExterno"})
    public ServiceResponse OGANULARSOL_Async(OGANULARSOLRequest request) {
    	
    	org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).info("\nINICIO PROCESO ANULACION SOLICITUDES");
    	ServiceResponse retorno = service.oGANULARSOL(request);
    	org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).info("\nFIN PROCESO ANULACION SOLICITUDES");
    	
    	return retorno;    	
    }

    @POST
    @Path(value = "/OGANULARSOLAUX")
    @RolesAllowed({"SuperAdmin"})
    public ServiceResponse oGANULARSOLAUX(OGANULARSOLAUXRequest request) {
        return service.oGANULARSOLAUX(request);
    }

    @POST
    @Path(value = "/OGASIGUSUARIOS")
    @RolesAllowed({"Admin","SuperAdmin"})
    public OGASIGUSUARIOSResponse oGASIGUSUARIOS(OGASIGUSUARIOSRequest request) {
        return service.oGASIGUSUARIOS(request);
    }
}
