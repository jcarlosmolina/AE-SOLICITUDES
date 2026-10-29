package com.keralty.aesolicitudes.api.documentog;

import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.oid.DocumentoGOid;
import com.keralty.aesolicitudes.service.DocumentoGService;
import com.keralty.aesolicitudes.utils.TokenUtilities;
import com.keralty.aesolicitudes.viewmodel.documentog.ds.DSDocumentoGIIU;
import com.keralty.aesolicitudes.viewmodel.documentog.piu.PIUDocumentoGResponse;
import com.keralty.aesolicitudes.viewmodel.documentog.siu.PrevisualizarATORequest;
import com.keralty.aesolicitudes.viewmodel.documentog.siu.PrevisualizarATOResponse;
import com.keralty.aesolicitudes.viewmodel.documentog.siu.TAPROBARRequest;
import com.keralty.aesolicitudes.viewmodel.documentog.siu.TDEVOLVERRequest;
import com.keralty.aesolicitudes.viewmodel.documentog.siu.TDEVOLVERResponse;
import com.keralty.aesolicitudes.viewmodel.documentog.siu.VerDetallesRequest;
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

@Path("/api/DocumentoGApi")
@RequestScoped
public class DocumentoGApi {

    DocumentoGService service;

    public DocumentoGApi(DocumentoGService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/{documentoGIdentificador}")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public DocumentoG getInstance(Long documentoGIdentificador) {
    	return service.getById(documentoGIdentificador);
    }

    @GET
    @Path(value="/")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public List<DocumentoG> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public DocumentoG getByOid(DocumentoGOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public DocumentoG getByOIDWithHV(DocumentoGOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetDocumentoGDynamic")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public InstanceResponseViewModel getDocumentoGDynamic(QueryRequest request) {
        DocumentoGOid oid = new DocumentoGOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getDocumentoGDynamic(oid, request.getDisplaySetItems());
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PopulationResponseViewModel getDocumentoGPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @POST
    @Path(value = "/verDetalles")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public ServiceResponse documentoGVerDetalles(VerDetallesRequest request) {
        return service.verDetalles(request);
    }
    

    @POST
    @Path(value = "/previsualizarATO")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PrevisualizarATOResponse documentoGPrevisualizarATO(PrevisualizarATORequest request) {
        return service.previsualizarATO(request);
    }
    

    @POST
    @Path(value = "/previsualizarATOCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PrevisualizarATOResponse documentoGPrevisualizarATOCheckPreconditions(PrevisualizarATORequest request) {

        return service.previsualizarATOCheckPreconditions(request);
    }

    @POST
    @Path(value = "/TAPROBAR")
    @RolesAllowed({"SuperAdmin","AreaMedica","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse documentoGTAPROBAR(TAPROBARRequest request) {
        return service.tAPROBAR(request);
    }
    

    @POST
    @Path(value = "/TAPROBARCheckPreconditions")
    @RolesAllowed({"SuperAdmin","AreaMedica","Afiliaciones","MesaDeApoyo"})
    public ServiceResponse documentoGTAPROBARCheckPreconditions(TAPROBARRequest request) {

        return service.tAPROBARCheckPreconditions(request);
    }

    @POST
    @Path(value = "/TDEVOLVER")
    @RolesAllowed({"SuperAdmin","AreaMedica","Afiliaciones","MesaDeApoyo"})
    public TDEVOLVERResponse documentoGTDEVOLVER(TDEVOLVERRequest request) {
        return service.tDEVOLVER(request);
    }
    

    @POST
    @Path(value = "/TDEVOLVERCheckPreconditions")
    @RolesAllowed({"SuperAdmin","AreaMedica","Afiliaciones","MesaDeApoyo"})
    public TDEVOLVERResponse documentoGTDEVOLVERCheckPreconditions(TDEVOLVERRequest request) {

        return service.tDEVOLVERCheckPreconditions(request);
    }

    @POST
    @Path(value = "/IIU_DocumentoG_Maestro")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public DSDocumentoGIIU iiuIIUDocumentoGMaestro(DocumentoGOid oid) {
        return service.iIUDocumentoGMaestro(oid);
    }

    @POST
    @Path(value = "/PIU_DocumentoG")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PIUDocumentoGResponse piuPIUDocumentoG(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUDocumentoGResponse response;
        try
        {
            response = new PIUDocumentoGResponse(service.piuPIUDocumentoG(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUDocumentoG(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUDocumentoGResponse();
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
