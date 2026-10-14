package com.keralty.aesolicitudes.api.aesolicitudes;

import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.oid.AesolicitudesOid;
import com.keralty.aesolicitudes.service.AesolicitudesService;
import com.keralty.aesolicitudes.utils.TokenUtilities;
import com.keralty.aesolicitudes.viewmodel.aesolicitudes.piu.PIUAesolicitudesObsResponse;
import com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.ModificarFechaElabRequest;
import com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TINCLUSIONSCRequest;
import com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TINCLUSIONSCResponse;
import com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TNUEVAAFILIACIONRequest;
import com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu.TNUEVAAFILIACIONResponse;
import com.keralty.aesolicitudes.viewmodel.InstanceResponseViewModel;
import com.keralty.aesolicitudes.viewmodel.PopulationRequestViewModel;
import com.keralty.aesolicitudes.viewmodel.PopulationResponseViewModel;
import com.keralty.aesolicitudes.viewmodel.QueryRequest;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import java.util.List;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/api/Ae_solicitudesApi")
@RequestScoped
public class AesolicitudesApi {

    AesolicitudesService service;

    public AesolicitudesApi(AesolicitudesService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/{aesolicitudesidsolicitud}")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public Aesolicitudes getInstance(Long aesolicitudesidsolicitud) {
    	return service.getById(aesolicitudesidsolicitud);
    }

    @GET
    @Path(value="/")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public List<Aesolicitudes> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public Aesolicitudes getByOid(AesolicitudesOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public Aesolicitudes getByOIDWithHV(AesolicitudesOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetAe_solicitudesDynamic")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public InstanceResponseViewModel getAesolicitudesDynamic(QueryRequest request) {
        AesolicitudesOid oid = new AesolicitudesOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getAesolicitudesDynamic(oid, request.getDisplaySetItems());
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PopulationResponseViewModel getAesolicitudesPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @POST
    @Path(value = "/modificarFechaElab")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public ServiceResponse aesolicitudesModificarFechaElab(ModificarFechaElabRequest request) {
        return service.modificarFechaElab(request);
    }
    

    @POST
    @Path(value = "/TNUEVAAFILIACION")
    @RolesAllowed({"Admin","SuperAdmin","Asesor"})
    public TNUEVAAFILIACIONResponse aesolicitudesTNUEVAAFILIACION(TNUEVAAFILIACIONRequest request) {
        return service.tNUEVAAFILIACION(request);
    }
    

    @POST
    @Path(value = "/TNUEVAAFILIACIONCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor"})
    public TNUEVAAFILIACIONResponse aesolicitudesTNUEVAAFILIACIONCheckPreconditions(TNUEVAAFILIACIONRequest request) {

        return service.tNUEVAAFILIACIONCheckPreconditions(request);
    }

    @POST
    @Path(value = "/TINCLUSIONSC")
    @RolesAllowed({"Admin","SuperAdmin","Asesor"})
    public TINCLUSIONSCResponse aesolicitudesTINCLUSIONSC(TINCLUSIONSCRequest request) {
        return service.tINCLUSIONSC(request);
    }
    

    @POST
    @Path(value = "/TINCLUSIONSCCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor"})
    public TINCLUSIONSCResponse aesolicitudesTINCLUSIONSCCheckPreconditions(TINCLUSIONSCRequest request) {

        return service.tINCLUSIONSCCheckPreconditions(request);
    }


    @POST
    @Path(value = "/PIU_Ae_solicitudes_Obs")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PIUAesolicitudesObsResponse piuPIUAesolicitudesObs(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUAesolicitudesObsResponse response;
        try
        {
            response = new PIUAesolicitudesObsResponse(service.piuPIUAesolicitudesObs(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUAesolicitudesObs(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUAesolicitudesObsResponse();
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
