package com.keralty.aesolicitudes.api.protecciondatosc;

import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosCOid;
import com.keralty.aesolicitudes.persistence.ProteccionDatosC;
import com.keralty.aesolicitudes.service.ProteccionDatosCService;
import com.keralty.aesolicitudes.utils.TokenUtilities;
import com.keralty.aesolicitudes.viewmodel.InstanceResponseViewModel;
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

@Path("/api/ProteccionDatosCApi")
@RequestScoped
public class ProteccionDatosCApi {

    ProteccionDatosCService service;

    public ProteccionDatosCApi(ProteccionDatosCService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/{personaCID}/{productosProducto}/{proteccionDatosCCodigo}")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public ProteccionDatosC getInstance(Long personaCID, Long productosProducto, Long proteccionDatosCCodigo) {
    	return service.getById(personaCID, productosProducto, proteccionDatosCCodigo);
    }

    @GET
    @Path(value="/")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public List<ProteccionDatosC> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public ProteccionDatosC getByOid(ProteccionDatosCOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public ProteccionDatosC getByOIDWithHV(ProteccionDatosCOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetProteccionDatosCDynamic")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public InstanceResponseViewModel getProteccionDatosCDynamic(QueryRequest request) {
        ProteccionDatosCOid oid = new ProteccionDatosCOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getProteccionDatosCDynamic(oid, request.getDisplaySetItems());
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","Gestor","MesaDeApoyo"})
    public PopulationResponseViewModel getProteccionDatosCPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }





    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    @Operation(hidden = true)
    public AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath) {
        return service.buildRelatedInstance(relatedInstanceJsonOid, relatedInstancePath);
    }
}
