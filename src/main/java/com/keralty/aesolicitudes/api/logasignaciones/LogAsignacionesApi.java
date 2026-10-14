package com.keralty.aesolicitudes.api.logasignaciones;

import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.LogAsignaciones;
import com.keralty.aesolicitudes.persistence.oid.LogAsignacionesOid;
import com.keralty.aesolicitudes.service.LogAsignacionesService;
import com.keralty.aesolicitudes.utils.TokenUtilities;
import com.keralty.aesolicitudes.viewmodel.InstanceResponseViewModel;
import com.keralty.aesolicitudes.viewmodel.logasignaciones.piu.PIULogAsignacionesResponse;
import com.keralty.aesolicitudes.viewmodel.PopulationRequestViewModel;
import com.keralty.aesolicitudes.viewmodel.PopulationResponseViewModel;
import com.keralty.aesolicitudes.viewmodel.QueryRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import java.util.List;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/api/LogAsignacionesApi")
@RequestScoped
public class LogAsignacionesApi {

    LogAsignacionesService service;

    public LogAsignacionesApi(LogAsignacionesService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/{logAsignacionesidLogAsignaciones}")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","MesaDeApoyo"})
    public LogAsignaciones getInstance(Long logAsignacionesidLogAsignaciones) {
    	return service.getById(logAsignacionesidLogAsignaciones);
    }

    @GET
    @Path(value="/")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","MesaDeApoyo"})
    public List<LogAsignaciones> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","MesaDeApoyo"})
    public LogAsignaciones getByOid(LogAsignacionesOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","MesaDeApoyo"})
    public LogAsignaciones getByOIDWithHV(LogAsignacionesOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetLogAsignacionesDynamic")
    @RolesAllowed({"Admin","SuperAdmin","MesaDeApoyo"})
    public InstanceResponseViewModel getLogAsignacionesDynamic(QueryRequest request) {
        LogAsignacionesOid oid = new LogAsignacionesOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getLogAsignacionesDynamic(oid, request.getDisplaySetItems());
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    @RolesAllowed({"Admin","SuperAdmin","MesaDeApoyo"})
    public PopulationResponseViewModel getLogAsignacionesPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }



    @POST
    @Path(value = "/PIU_LogAsignaciones")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","MesaDeApoyo"})
    public PIULogAsignacionesResponse piuPIULogAsignaciones(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIULogAsignacionesResponse response;
        try
        {
            response = new PIULogAsignacionesResponse(service.piuPIULogAsignaciones(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIULogAsignaciones(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIULogAsignacionesResponse();
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
