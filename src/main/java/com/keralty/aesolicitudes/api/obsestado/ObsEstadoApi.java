package com.keralty.aesolicitudes.api.obsestado;

import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.ObsEstado;
import com.keralty.aesolicitudes.persistence.oid.ObsEstadoOid;
import com.keralty.aesolicitudes.service.ObsEstadoService;
import com.keralty.aesolicitudes.utils.TokenUtilities;
import com.keralty.aesolicitudes.viewmodel.InstanceResponseViewModel;
import com.keralty.aesolicitudes.viewmodel.obsestado.piu.PIUObsEstadoNullResponse;
import com.keralty.aesolicitudes.viewmodel.obsestado.piu.PIUObsEstadoResponse;
import com.keralty.aesolicitudes.viewmodel.obsestado.siu.ModificarRequest;
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

@Path("/api/ObsEstadoApi")
@RequestScoped
public class ObsEstadoApi {

    ObsEstadoService service;

    public ObsEstadoApi(ObsEstadoService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/{documentoGIdentificador}/{obsEstadoId}")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public ObsEstado getInstance(Long documentoGIdentificador, Long obsEstadoId) {
    	return service.getById(documentoGIdentificador, obsEstadoId);
    }

    @GET
    @Path(value="/")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public List<ObsEstado> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public ObsEstado getByOid(ObsEstadoOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public ObsEstado getByOIDWithHV(ObsEstadoOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetObsEstadoDynamic")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public InstanceResponseViewModel getObsEstadoDynamic(QueryRequest request) {
        ObsEstadoOid oid = new ObsEstadoOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getObsEstadoDynamic(oid, request.getDisplaySetItems());
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public PopulationResponseViewModel getObsEstadoPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @POST
    @Path(value = "/modificar")
    @RolesAllowed({"SuperAdmin","AreaMedica"})
    public ServiceResponse obsEstadoModificar(ModificarRequest request) {
        return service.modificar(request);
    }
    

    @POST
    @Path(value = "/modificarCheckPreconditions")
    @RolesAllowed({"SuperAdmin","AreaMedica"})
    public ServiceResponse obsEstadoModificarCheckPreconditions(ModificarRequest request) {

        return service.modificarCheckPreconditions(request);
    }


    @POST
    @Path(value = "/PIU_ObsEstado")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public PIUObsEstadoResponse piuPIUObsEstado(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUObsEstadoResponse response;
        try
        {
            response = new PIUObsEstadoResponse(service.piuPIUObsEstado(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUObsEstado(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUObsEstadoResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_ObsEstado_Null")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public PIUObsEstadoNullResponse piuPIUObsEstadoNull(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUObsEstadoNullResponse response;
        try
        {
            response = new PIUObsEstadoNullResponse(service.piuPIUObsEstadoNull(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUObsEstadoNull(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUObsEstadoNullResponse();
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
