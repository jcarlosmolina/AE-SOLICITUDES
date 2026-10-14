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

@Path("/api/GlobalServicesApi")
@RequestScoped
public class GlobalServicesApi {

    GlobalServicesService service;

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
        return service.oGANULARSOL(request);
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
