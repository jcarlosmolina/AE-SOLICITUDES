package com.keralty.aesolicitudes.api.protecciondatos;

import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.service.ProteccionDatosService;
import com.keralty.aesolicitudes.utils.TokenUtilities;
import com.keralty.aesolicitudes.viewmodel.InstanceResponseViewModel;
import com.keralty.aesolicitudes.viewmodel.PopulationRequestViewModel;
import com.keralty.aesolicitudes.viewmodel.PopulationResponseViewModel;
import com.keralty.aesolicitudes.viewmodel.protecciondatos.piu.PIUProteccionDatosNullResponse;
import com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSINCRequest;
import com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSINCResponse;
import com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSNARequest;
import com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARPROTECCIONDATOSNAResponse;
import com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADEXCEPCIONRequest;
import com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADEXCEPCIONResponse;
import com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADRequest;
import com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.TCREARSOLNOVEDADResponse;
import com.keralty.aesolicitudes.viewmodel.QueryRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import java.util.List;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/api/ProteccionDatosApi")
@RequestScoped
public class ProteccionDatosApi {

    ProteccionDatosService service;

    public ProteccionDatosApi(ProteccionDatosService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/{proteccionDatosIdentificador}")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public ProteccionDatos getInstance(Long proteccionDatosIdentificador) {
    	return service.getById(proteccionDatosIdentificador);
    }

    @GET
    @Path(value="/")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public List<ProteccionDatos> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public ProteccionDatos getByOid(ProteccionDatosOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public ProteccionDatos getByOIDWithHV(ProteccionDatosOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetProteccionDatosDynamic")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public InstanceResponseViewModel getProteccionDatosDynamic(QueryRequest request) {
        ProteccionDatosOid oid = new ProteccionDatosOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getProteccionDatosDynamic(oid, request.getDisplaySetItems());
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public PopulationResponseViewModel getProteccionDatosPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @POST
    @Path(value = "/TCREARPROTECCIONDATOSNA")
    @RolesAllowed({"Admin","SuperAdmin","Asesor"})
    public TCREARPROTECCIONDATOSNAResponse proteccionDatosTCREARPROTECCIONDATOSNA(TCREARPROTECCIONDATOSNARequest request) {
        return service.tCREARPROTECCIONDATOSNA(request);
    }
    

    @POST
    @Path(value = "/TCREARPROTECCIONDATOSINC")
    @RolesAllowed({"Admin","SuperAdmin","Asesor"})
    public TCREARPROTECCIONDATOSINCResponse proteccionDatosTCREARPROTECCIONDATOSINC(TCREARPROTECCIONDATOSINCRequest request) {
        return service.tCREARPROTECCIONDATOSINC(request);
    }
    

    @POST
    @Path(value = "/TCREARSOLNOVEDAD")
    @RolesAllowed({"Admin","SuperAdmin","Asesor"})
    public TCREARSOLNOVEDADResponse proteccionDatosTCREARSOLNOVEDAD(TCREARSOLNOVEDADRequest request) {
        return service.tCREARSOLNOVEDAD(request);
    }
    

    @POST
    @Path(value = "/TCREARSOLNOVEDADEXCEPCION")
    @RolesAllowed({"Admin","SuperAdmin"})
    public TCREARSOLNOVEDADEXCEPCIONResponse proteccionDatosTCREARSOLNOVEDADEXCEPCION(TCREARSOLNOVEDADEXCEPCIONRequest request) {
        return service.tCREARSOLNOVEDADEXCEPCION(request);
    }
    


    @POST
    @Path(value = "/PIU_ProteccionDatos_Null")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public PIUProteccionDatosNullResponse piuPIUProteccionDatosNull(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUProteccionDatosNullResponse response;
        try
        {
            response = new PIUProteccionDatosNullResponse(service.piuPIUProteccionDatosNull(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUProteccionDatosNull(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUProteccionDatosNullResponse();
            response.setException(e);
        }
        return response;
    }


    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    @Operation(hidden = true)
    public AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath) {
        return service.buildRelatedInstance(relatedInstanceJsonOid, relatedInstancePath);
    }
}
