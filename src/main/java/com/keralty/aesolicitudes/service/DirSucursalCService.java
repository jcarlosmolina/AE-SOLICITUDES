package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.MinCardinalityException;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.DirSucursalCConstants;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;
import com.keralty.aesolicitudes.persistence.oid.PaisOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.RegionalOid;
import com.keralty.aesolicitudes.persistence.oid.TelefonoCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoSucursalCOid;
import com.keralty.aesolicitudes.persistence.Pais;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Regional;
import com.keralty.aesolicitudes.persistence.TelefonoC;
import com.keralty.aesolicitudes.persistence.TipoSucursalC;
import com.keralty.aesolicitudes.repository.DirSucursalCJpaRepository;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLWhereComparison;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aesolicitudes.utils.Utilities;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;
import com.keralty.aesolicitudes.viewmodel.FilterVariableRequest;
import com.keralty.aesolicitudes.viewmodel.InstanceResponseViewModel;
import com.keralty.aesolicitudes.viewmodel.PopulationResponseViewModel;
import com.keralty.aesolicitudes.viewmodel.PreloadResponseViewModel;
import com.keralty.aesolicitudes.viewmodel.QueryRequest;
import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class DirSucursalCService extends AbstractService {

    DirSucursalCJpaRepository repository;

    DirSucursalCService dirSucursalCSrv;

    PersonaCService personaCSrv;

    MunicipioService municipioSrv;

    DepartamentoService departamentoSrv;

    PaisService paisSrv;

    RegionalService regionalSrv;

    TipoSucursalCService tipoSucursalCSrv;

    TelefonoCService telefonoCSrv;

    @Inject
    public DirSucursalCService(
            DirSucursalCService dirSucursalCSrv,
            PersonaCService personaCSrv,
            MunicipioService municipioSrv,
            DepartamentoService departamentoSrv,
            PaisService paisSrv,
            RegionalService regionalSrv,
            TipoSucursalCService tipoSucursalCSrv,
            TelefonoCService telefonoCSrv,
            DirSucursalCJpaRepository repository) {
        this.dirSucursalCSrv = dirSucursalCSrv;
        this.personaCSrv = personaCSrv;
        this.municipioSrv = municipioSrv;
        this.departamentoSrv = departamentoSrv;
        this.paisSrv = paisSrv;
        this.regionalSrv = regionalSrv;
        this.tipoSucursalCSrv = tipoSucursalCSrv;
        this.telefonoCSrv = telefonoCSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, DirSucursalCConstants.CLASS_NAME);
    }

    private List<DirSucursalC> solveDirSucursalCTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, DirSucursalCConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveDirSucursalCTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, DirSucursalCConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class DirSucursalC
     *
     * @return Population of class DirSucursalC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<DirSucursalC> get() {
        List<DirSucursalC> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class DirSucursalC that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class DirSucursalC matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<DirSucursalC> get(QueryRequest queryRequest) {
        return solveDirSucursalCTypedQuery(queryRequest);
    }
    
    /*
     * Returns the list of instances that matches certain search criteria
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return List of instances that matches certain search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public QueryResponse getDynamic(QueryRequest queryRequest) {
        if (queryRequest.getDisplaySetName() == null || queryRequest.getDisplaySetName().isEmpty()) {
            return new PopulationResponseViewModel(solveDirSucursalCTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveDirSucursalCTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel();
        }
    }

    /*
     * Returns the population of a class with a certain structure
     *
     * @param relatedInstanceJsonOid Json Oid of the related instance
     *
     * @param relatedInstancePath Path to the related instance
     *
     * @param displaySetItems DisplaySet items for each returned instance
     *
     * @return List of instances
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public PopulationResponseViewModel getByRelatedDynamic(String relatedInstanceJsonOid, String relatedInstancePath, String displaySetItems) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstanceJsonOid))));
        return new PopulationResponseViewModel(solveDirSucursalCTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of DirSucursalC by ID
     *
     * @param dirSucursalCCodigo Identification field dirSucursalCCodigo
     *
     * @return Instance of DirSucursalC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public DirSucursalC getById(Long dirSucursalCCodigo) {
        return getByOID(new DirSucursalCOid(dirSucursalCCodigo));
    }
    
    /*
     * Returns an instance of DirSucursalC by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of DirSucursalC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public DirSucursalC getByOID(DirSucursalCOid oid) {
        Optional<DirSucursalC> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of DirSucursalC by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of DirSucursalC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public DirSucursalC getByOIDWithHV(DirSucursalCOid oid) {
        Optional<DirSucursalC> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<DirSucursalC> getInstanceByOid(DirSucursalCOid oid) {
        return oid != null && oid.getDirSucursalCCodigo() != null
               ? repository.findById(oid.getDirSucursalCCodigo())
               : Optional.empty();
    }

    /*
     * Returns an instance of DirSucursalC by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of DirSucursalC
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public DirSucursalC getByJsonOid(String jsonOid) {
        DirSucursalCOid oid = new DirSucursalCOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of DirSucursalC related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of DirSucursalC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<DirSucursalC> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveDirSucursalCTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of DirSucursalC related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of DirSucursalC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<DirSucursalC> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of DirSucursalC
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of DirSucursalC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getDirSucursalCDynamic(DirSucursalCOid oid, String displaySetItems) {
        return new InstanceResponseViewModel(getByOIDWithHV(oid), displaySetItems);
    }

    /*
     * Returns the supplementary info for a given instance
     *
     * @param oid Instance OID
     *
     * @param dsName DisplaySet name
     *
     * @return Supplementary info for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String getSuppInfo(DirSucursalCOid oid, String dsName) {
        DirSucursalC instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(DirSucursalC instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods



    // Service: crear

    /*
     * Entry point for service crear
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse crear(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = dirSucursalCSrv.crearTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service crear
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse crearTxn(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.CrearRequest request) throws ModelException {
        request.setDirSucursalCcrearpagrPersonaCInstance(personaCSrv.getByOIDWithHV(request.getDirSucursalCcrearpagrPersonaC()));
        request.setDirSucursalCcrearpagrMunicipioCInstance(municipioSrv.getByOIDWithHV(request.getDirSucursalCcrearpagrMunicipioC()));
        request.setDirSucursalCcrearpagrDepartamentoCInstance(departamentoSrv.getByOIDWithHV(request.getDirSucursalCcrearpagrDepartamentoC()));
        request.setDirSucursalCcrearpagrPaisCInstance(paisSrv.getByOIDWithHV(request.getDirSucursalCcrearpagrPaisC()));
        request.setDirSucursalCcrearpagrRegionalCInstance(regionalSrv.getByOIDWithHV(request.getDirSucursalCcrearpagrRegionalC()));
        return dirSucursalCSrv.crearImplementation(request);
    }

    /*
     * Implements service crear
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse crearImplementation(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC dirSucursalCcrearpagrPersonaC = request.getDirSucursalCcrearpagrPersonaCInstance();
        Municipio dirSucursalCcrearpagrMunicipioC = request.getDirSucursalCcrearpagrMunicipioCInstance();
        Departamento dirSucursalCcrearpagrDepartamentoC = request.getDirSucursalCcrearpagrDepartamentoCInstance();
        Pais dirSucursalCcrearpagrPaisC = request.getDirSucursalCcrearpagrPaisCInstance();
        Regional dirSucursalCcrearpagrRegionalC = request.getDirSucursalCcrearpagrRegionalCInstance();
        String dirSucursalCcrearpatrCodLegalSucursal = request.getDirSucursalCcrearpatrCodLegalSucursal();
        String dirSucursalCcrearpatrNombre = request.getDirSucursalCcrearpatrNombre();
        Boolean dirSucursalCcrearpatrEsPrincipal = request.getDirSucursalCcrearpatrEsPrincipal();
        Boolean dirSucursalCcrearpatrActiva = request.getDirSucursalCcrearpatrActiva();
        String dirSucursalCcrearpatrDireccion = request.getDirSucursalCcrearpatrDireccion();
        String dirSucursalCcrearpatrMail = request.getDirSucursalCcrearpatrMail();

        request.checkArguments();
        DirSucursalC instance = new DirSucursalC();
        instance.add2PersonaC(dirSucursalCcrearpagrPersonaC);

        if (dirSucursalCcrearpagrMunicipioC != null && !dirSucursalCcrearpagrMunicipioC.isNull()) {
            instance.add2MunicipioC(dirSucursalCcrearpagrMunicipioC);
        }

        if (dirSucursalCcrearpagrDepartamentoC != null && !dirSucursalCcrearpagrDepartamentoC.isNull()) {
            instance.add2DepartamentoC(dirSucursalCcrearpagrDepartamentoC);
        }

        if (dirSucursalCcrearpagrPaisC != null && !dirSucursalCcrearpagrPaisC.isNull()) {
            instance.add2PaisC(dirSucursalCcrearpagrPaisC);
        }

        if (dirSucursalCcrearpagrRegionalC != null && !dirSucursalCcrearpagrRegionalC.isNull()) {
            instance.add2RegionalC(dirSucursalCcrearpagrRegionalC);
        }

        instance.setDirSucursalCCodigo(Long.valueOf(0));
        instance.setDirSucursalCCodLegalSucursal(dirSucursalCcrearpatrCodLegalSucursal);
        instance.setDirSucursalCNombre(dirSucursalCcrearpatrNombre);
        instance.setDirSucursalCEsPrincipal(dirSucursalCcrearpatrEsPrincipal);
        instance.setDirSucursalCActiva(dirSucursalCcrearpatrActiva);
        instance.setDirSucursalCDireccion(dirSucursalCcrearpatrDireccion);
        instance.setDirSucursalCMail(dirSucursalCcrearpatrMail);

        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: eliminar

    /*
     * Entry point for service eliminar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse eliminar(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = dirSucursalCSrv.eliminarTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service eliminar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse eliminarTxn(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.EliminarRequest request) throws ModelException {
        request.setDirSucursalCeliminarpthisDirSucursalCInstance(dirSucursalCSrv.getByOIDWithHV(request.getDirSucursalCeliminarpthisDirSucursalC()));
        return dirSucursalCSrv.eliminarImplementation(request);
    }

    /*
     * Implements service eliminar
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse eliminarImplementation(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DirSucursalC dirSucursalCeliminarpthisDirSucursalC = request.getDirSucursalCeliminarpthisDirSucursalCInstance();

        request.checkArguments();
        DirSucursalC instance = dirSucursalCeliminarpthisDirSucursalC;
        if(dirSucursalCeliminarpthisDirSucursalC.getTelefonosC().size() > 0) {
            throw new MinCardinalityException(DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ROLE_ALIAS_TELEFONOSC);
        }


        repository.delete(instance);
        
        response.setInstance(instance);

        return response;
    }

    // Service: modificar

    /*
     * Entry point for service modificar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse modificar(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.ModificarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = dirSucursalCSrv.modificarTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service modificar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse modificarTxn(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.ModificarRequest request) throws ModelException {
        request.setDirSucursalCmodificarpthisDirSucursalCInstance(dirSucursalCSrv.getByOIDWithHV(request.getDirSucursalCmodificarpthisDirSucursalC()));
        return dirSucursalCSrv.modificarImplementation(request);
    }

    /*
     * Implements service modificar
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse modificarImplementation(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.ModificarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DirSucursalC dirSucursalCmodificarpthisDirSucursalC = request.getDirSucursalCmodificarpthisDirSucursalCInstance();
        String dirSucursalCmodificarpCodLegalSucursal = request.getDirSucursalCmodificarpCodLegalSucursal();
        String dirSucursalCmodificarpNombre = request.getDirSucursalCmodificarpNombre();
        Boolean dirSucursalCmodificarpEsPrincipal = request.getDirSucursalCmodificarpEsPrincipal();
        Boolean dirSucursalCmodificarpActiva = request.getDirSucursalCmodificarpActiva();
        String dirSucursalCmodificarpDireccion = request.getDirSucursalCmodificarpDireccion();
        String dirSucursalCmodificarpMail = request.getDirSucursalCmodificarpMail();

        request.checkArguments();
        DirSucursalC instance = dirSucursalCmodificarpthisDirSucursalC;
        instance.setDirSucursalCCodLegalSucursal(dirSucursalCmodificarpCodLegalSucursal);
        instance.setDirSucursalCNombre(dirSucursalCmodificarpNombre);
        instance.setDirSucursalCEsPrincipal(dirSucursalCmodificarpEsPrincipal);
        instance.setDirSucursalCActiva(dirSucursalCmodificarpActiva);
        instance.setDirSucursalCDireccion(dirSucursalCmodificarpDireccion);
        instance.setDirSucursalCMail(dirSucursalCmodificarpMail);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsTiposSucursalC

    /*
     * Entry point for service InsTiposSucursalC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insTiposSucursalC(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsTiposSucursalCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = dirSucursalCSrv.insTiposSucursalCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsTiposSucursalC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insTiposSucursalCTxn(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsTiposSucursalCRequest request) throws ModelException {
        request.setDirSucursalCInsTiposSucursalCpthisDirSucursalCInstance(dirSucursalCSrv.getByOIDWithHV(request.getDirSucursalCInsTiposSucursalCpthisDirSucursalC()));
        request.setDirSucursalCInsTiposSucursalCpevcTipoSucursalCInstance(tipoSucursalCSrv.getByOIDWithHV(request.getDirSucursalCInsTiposSucursalCpevcTipoSucursalC()));
        return dirSucursalCSrv.insTiposSucursalCImplementation(request, true);
    }

    /*
     * Implements service InsTiposSucursalC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insTiposSucursalCImplementation(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsTiposSucursalCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DirSucursalC dirSucursalCInsTiposSucursalCpthisDirSucursalC = request.getDirSucursalCInsTiposSucursalCpthisDirSucursalCInstance();
        TipoSucursalC dirSucursalCInsTiposSucursalCpevcTipoSucursalC = request.getDirSucursalCInsTiposSucursalCpevcTipoSucursalCInstance();

        request.checkArguments();
        DirSucursalC instance = dirSucursalCInsTiposSucursalCpthisDirSucursalC;

        instance.add2TiposSucursalC(dirSucursalCInsTiposSucursalCpevcTipoSucursalC);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.tiposucursalc.siu.InsTiposSucursalCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.tiposucursalc.siu.InsTiposSucursalCRequest();
            relatedRequest.setTipoSucursalCInsTiposSucursalCpthisTipoSucursalCInstance(dirSucursalCInsTiposSucursalCpevcTipoSucursalC);
            relatedRequest.setTipoSucursalCInsTiposSucursalCpevcDirSucursalCInstance(dirSucursalCInsTiposSucursalCpthisDirSucursalC);
            tipoSucursalCSrv.insTiposSucursalCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelTiposSucursalC

    /*
     * Entry point for service DelTiposSucursalC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delTiposSucursalC(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelTiposSucursalCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = dirSucursalCSrv.delTiposSucursalCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelTiposSucursalC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delTiposSucursalCTxn(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelTiposSucursalCRequest request) throws ModelException {
        request.setDirSucursalCDelTiposSucursalCpthisDirSucursalCInstance(dirSucursalCSrv.getByOIDWithHV(request.getDirSucursalCDelTiposSucursalCpthisDirSucursalC()));
        request.setDirSucursalCDelTiposSucursalCpevcTipoSucursalCInstance(tipoSucursalCSrv.getByOIDWithHV(request.getDirSucursalCDelTiposSucursalCpevcTipoSucursalC()));
        return dirSucursalCSrv.delTiposSucursalCImplementation(request, true);
    }

    /*
     * Implements service DelTiposSucursalC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delTiposSucursalCImplementation(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelTiposSucursalCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DirSucursalC dirSucursalCDelTiposSucursalCpthisDirSucursalC = request.getDirSucursalCDelTiposSucursalCpthisDirSucursalCInstance();
        TipoSucursalC dirSucursalCDelTiposSucursalCpevcTipoSucursalC = request.getDirSucursalCDelTiposSucursalCpevcTipoSucursalCInstance();

        request.checkArguments();
        DirSucursalC instance = dirSucursalCDelTiposSucursalCpthisDirSucursalC;

        instance.removeFromTiposSucursalC(dirSucursalCDelTiposSucursalCpevcTipoSucursalC);
        dirSucursalCDelTiposSucursalCpevcTipoSucursalC.removeFromDirSucursalesC(instance);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.tiposucursalc.siu.DelTiposSucursalCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.tiposucursalc.siu.DelTiposSucursalCRequest();
            relatedRequest.setTipoSucursalCDelTiposSucursalCpthisTipoSucursalCInstance(dirSucursalCDelTiposSucursalCpevcTipoSucursalC);
            relatedRequest.setTipoSucursalCDelTiposSucursalCpevcDirSucursalCInstance(dirSucursalCDelTiposSucursalCpthisDirSucursalC);
            tipoSucursalCSrv.delTiposSucursalCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsMunicipioDirSucursal

    /*
     * Entry point for service InsMunicipioDirSucursal
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insMunicipioDirSucursal(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsMunicipioDirSucursalRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = dirSucursalCSrv.insMunicipioDirSucursalTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsMunicipioDirSucursal
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insMunicipioDirSucursalTxn(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsMunicipioDirSucursalRequest request) throws ModelException {
        request.setDirSucursalCInsMunicipioDirSucursalpthisDirSucursalCInstance(dirSucursalCSrv.getByOIDWithHV(request.getDirSucursalCInsMunicipioDirSucursalpthisDirSucursalC()));
        request.setDirSucursalCInsMunicipioDirSucursalpevcMunicipioInstance(municipioSrv.getByOIDWithHV(request.getDirSucursalCInsMunicipioDirSucursalpevcMunicipio()));
        return dirSucursalCSrv.insMunicipioDirSucursalImplementation(request, true);
    }

    /*
     * Implements service InsMunicipioDirSucursal
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insMunicipioDirSucursalImplementation(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsMunicipioDirSucursalRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DirSucursalC dirSucursalCInsMunicipioDirSucursalpthisDirSucursalC = request.getDirSucursalCInsMunicipioDirSucursalpthisDirSucursalCInstance();
        Municipio dirSucursalCInsMunicipioDirSucursalpevcMunicipio = request.getDirSucursalCInsMunicipioDirSucursalpevcMunicipioInstance();

        request.checkArguments();
        DirSucursalC instance = dirSucursalCInsMunicipioDirSucursalpthisDirSucursalC;

        instance.add2MunicipioC(dirSucursalCInsMunicipioDirSucursalpevcMunicipio);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.municipio.siu.InsMunicipioDirSucursalRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.municipio.siu.InsMunicipioDirSucursalRequest();
            relatedRequest.setMunicipioInsMunicipioDirSucursalpthisMunicipioInstance(dirSucursalCInsMunicipioDirSucursalpevcMunicipio);
            relatedRequest.setMunicipioInsMunicipioDirSucursalpevcDirSucursalCInstance(dirSucursalCInsMunicipioDirSucursalpthisDirSucursalC);
            municipioSrv.insMunicipioDirSucursalImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelMunicipioDirSucursal

    /*
     * Entry point for service DelMunicipioDirSucursal
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delMunicipioDirSucursal(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelMunicipioDirSucursalRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = dirSucursalCSrv.delMunicipioDirSucursalTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelMunicipioDirSucursal
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delMunicipioDirSucursalTxn(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelMunicipioDirSucursalRequest request) throws ModelException {
        request.setDirSucursalCDelMunicipioDirSucursalpthisDirSucursalCInstance(dirSucursalCSrv.getByOIDWithHV(request.getDirSucursalCDelMunicipioDirSucursalpthisDirSucursalC()));
        request.setDirSucursalCDelMunicipioDirSucursalpevcMunicipioInstance(municipioSrv.getByOIDWithHV(request.getDirSucursalCDelMunicipioDirSucursalpevcMunicipio()));
        return dirSucursalCSrv.delMunicipioDirSucursalImplementation(request, true);
    }

    /*
     * Implements service DelMunicipioDirSucursal
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delMunicipioDirSucursalImplementation(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelMunicipioDirSucursalRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DirSucursalC dirSucursalCDelMunicipioDirSucursalpthisDirSucursalC = request.getDirSucursalCDelMunicipioDirSucursalpthisDirSucursalCInstance();
        Municipio dirSucursalCDelMunicipioDirSucursalpevcMunicipio = request.getDirSucursalCDelMunicipioDirSucursalpevcMunicipioInstance();

        request.checkArguments();
        DirSucursalC instance = dirSucursalCDelMunicipioDirSucursalpthisDirSucursalC;

        instance.add2MunicipioC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.municipio.siu.DelMunicipioDirSucursalRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.municipio.siu.DelMunicipioDirSucursalRequest();
            relatedRequest.setMunicipioDelMunicipioDirSucursalpthisMunicipioInstance(dirSucursalCDelMunicipioDirSucursalpevcMunicipio);
            relatedRequest.setMunicipioDelMunicipioDirSucursalpevcDirSucursalCInstance(dirSucursalCDelMunicipioDirSucursalpthisDirSucursalC);
            municipioSrv.delMunicipioDirSucursalImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsDepartamentoDirSucursalC

    /*
     * Entry point for service InsDepartamentoDirSucursalC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insDepartamentoDirSucursalC(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsDepartamentoDirSucursalCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = dirSucursalCSrv.insDepartamentoDirSucursalCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsDepartamentoDirSucursalC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insDepartamentoDirSucursalCTxn(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsDepartamentoDirSucursalCRequest request) throws ModelException {
        request.setDirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalCInstance(dirSucursalCSrv.getByOIDWithHV(request.getDirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalC()));
        request.setDirSucursalCInsDepartamentoDirSucursalCpevcDepartamentoInstance(departamentoSrv.getByOIDWithHV(request.getDirSucursalCInsDepartamentoDirSucursalCpevcDepartamento()));
        return dirSucursalCSrv.insDepartamentoDirSucursalCImplementation(request, true);
    }

    /*
     * Implements service InsDepartamentoDirSucursalC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insDepartamentoDirSucursalCImplementation(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsDepartamentoDirSucursalCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DirSucursalC dirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalC = request.getDirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalCInstance();
        Departamento dirSucursalCInsDepartamentoDirSucursalCpevcDepartamento = request.getDirSucursalCInsDepartamentoDirSucursalCpevcDepartamentoInstance();

        request.checkArguments();
        DirSucursalC instance = dirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalC;

        instance.add2DepartamentoC(dirSucursalCInsDepartamentoDirSucursalCpevcDepartamento);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.departamento.siu.InsDepartamentoDirSucursalCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.departamento.siu.InsDepartamentoDirSucursalCRequest();
            relatedRequest.setDepartamentoInsDepartamentoDirSucursalCpthisDepartamentoInstance(dirSucursalCInsDepartamentoDirSucursalCpevcDepartamento);
            relatedRequest.setDepartamentoInsDepartamentoDirSucursalCpevcDirSucursalCInstance(dirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalC);
            departamentoSrv.insDepartamentoDirSucursalCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelDepartamentoDirSucursalC

    /*
     * Entry point for service DelDepartamentoDirSucursalC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delDepartamentoDirSucursalC(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelDepartamentoDirSucursalCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = dirSucursalCSrv.delDepartamentoDirSucursalCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelDepartamentoDirSucursalC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delDepartamentoDirSucursalCTxn(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelDepartamentoDirSucursalCRequest request) throws ModelException {
        request.setDirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalCInstance(dirSucursalCSrv.getByOIDWithHV(request.getDirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalC()));
        request.setDirSucursalCDelDepartamentoDirSucursalCpevcDepartamentoInstance(departamentoSrv.getByOIDWithHV(request.getDirSucursalCDelDepartamentoDirSucursalCpevcDepartamento()));
        return dirSucursalCSrv.delDepartamentoDirSucursalCImplementation(request, true);
    }

    /*
     * Implements service DelDepartamentoDirSucursalC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delDepartamentoDirSucursalCImplementation(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelDepartamentoDirSucursalCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DirSucursalC dirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalC = request.getDirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalCInstance();
        Departamento dirSucursalCDelDepartamentoDirSucursalCpevcDepartamento = request.getDirSucursalCDelDepartamentoDirSucursalCpevcDepartamentoInstance();

        request.checkArguments();
        DirSucursalC instance = dirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalC;

        instance.add2DepartamentoC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.departamento.siu.DelDepartamentoDirSucursalCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.departamento.siu.DelDepartamentoDirSucursalCRequest();
            relatedRequest.setDepartamentoDelDepartamentoDirSucursalCpthisDepartamentoInstance(dirSucursalCDelDepartamentoDirSucursalCpevcDepartamento);
            relatedRequest.setDepartamentoDelDepartamentoDirSucursalCpevcDirSucursalCInstance(dirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalC);
            departamentoSrv.delDepartamentoDirSucursalCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsPaisDirSucursalC

    /*
     * Entry point for service InsPaisDirSucursalC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insPaisDirSucursalC(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsPaisDirSucursalCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = dirSucursalCSrv.insPaisDirSucursalCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsPaisDirSucursalC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insPaisDirSucursalCTxn(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsPaisDirSucursalCRequest request) throws ModelException {
        request.setDirSucursalCInsPaisDirSucursalCpthisDirSucursalCInstance(dirSucursalCSrv.getByOIDWithHV(request.getDirSucursalCInsPaisDirSucursalCpthisDirSucursalC()));
        request.setDirSucursalCInsPaisDirSucursalCpevcPaisInstance(paisSrv.getByOIDWithHV(request.getDirSucursalCInsPaisDirSucursalCpevcPais()));
        return dirSucursalCSrv.insPaisDirSucursalCImplementation(request, true);
    }

    /*
     * Implements service InsPaisDirSucursalC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insPaisDirSucursalCImplementation(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsPaisDirSucursalCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DirSucursalC dirSucursalCInsPaisDirSucursalCpthisDirSucursalC = request.getDirSucursalCInsPaisDirSucursalCpthisDirSucursalCInstance();
        Pais dirSucursalCInsPaisDirSucursalCpevcPais = request.getDirSucursalCInsPaisDirSucursalCpevcPaisInstance();

        request.checkArguments();
        DirSucursalC instance = dirSucursalCInsPaisDirSucursalCpthisDirSucursalC;

        instance.add2PaisC(dirSucursalCInsPaisDirSucursalCpevcPais);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.pais.siu.InsPaisDirSucursalCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.pais.siu.InsPaisDirSucursalCRequest();
            relatedRequest.setPaisInsPaisDirSucursalCpthisPaisInstance(dirSucursalCInsPaisDirSucursalCpevcPais);
            relatedRequest.setPaisInsPaisDirSucursalCpevcDirSucursalCInstance(dirSucursalCInsPaisDirSucursalCpthisDirSucursalC);
            paisSrv.insPaisDirSucursalCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelPaisDirSucursalC

    /*
     * Entry point for service DelPaisDirSucursalC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delPaisDirSucursalC(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelPaisDirSucursalCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = dirSucursalCSrv.delPaisDirSucursalCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelPaisDirSucursalC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delPaisDirSucursalCTxn(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelPaisDirSucursalCRequest request) throws ModelException {
        request.setDirSucursalCDelPaisDirSucursalCpthisDirSucursalCInstance(dirSucursalCSrv.getByOIDWithHV(request.getDirSucursalCDelPaisDirSucursalCpthisDirSucursalC()));
        request.setDirSucursalCDelPaisDirSucursalCpevcPaisInstance(paisSrv.getByOIDWithHV(request.getDirSucursalCDelPaisDirSucursalCpevcPais()));
        return dirSucursalCSrv.delPaisDirSucursalCImplementation(request, true);
    }

    /*
     * Implements service DelPaisDirSucursalC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delPaisDirSucursalCImplementation(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelPaisDirSucursalCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DirSucursalC dirSucursalCDelPaisDirSucursalCpthisDirSucursalC = request.getDirSucursalCDelPaisDirSucursalCpthisDirSucursalCInstance();
        Pais dirSucursalCDelPaisDirSucursalCpevcPais = request.getDirSucursalCDelPaisDirSucursalCpevcPaisInstance();

        request.checkArguments();
        DirSucursalC instance = dirSucursalCDelPaisDirSucursalCpthisDirSucursalC;

        instance.add2PaisC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.pais.siu.DelPaisDirSucursalCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.pais.siu.DelPaisDirSucursalCRequest();
            relatedRequest.setPaisDelPaisDirSucursalCpthisPaisInstance(dirSucursalCDelPaisDirSucursalCpevcPais);
            relatedRequest.setPaisDelPaisDirSucursalCpevcDirSucursalCInstance(dirSucursalCDelPaisDirSucursalCpthisDirSucursalC);
            paisSrv.delPaisDirSucursalCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: InsRegionalDirSucursal

    /*
     * Entry point for service InsRegionalDirSucursal
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insRegionalDirSucursal(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsRegionalDirSucursalRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = dirSucursalCSrv.insRegionalDirSucursalTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsRegionalDirSucursal
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insRegionalDirSucursalTxn(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsRegionalDirSucursalRequest request) throws ModelException {
        request.setDirSucursalCInsRegionalDirSucursalpthisDirSucursalCInstance(dirSucursalCSrv.getByOIDWithHV(request.getDirSucursalCInsRegionalDirSucursalpthisDirSucursalC()));
        request.setDirSucursalCInsRegionalDirSucursalpevcRegionalInstance(regionalSrv.getByOIDWithHV(request.getDirSucursalCInsRegionalDirSucursalpevcRegional()));
        return dirSucursalCSrv.insRegionalDirSucursalImplementation(request, true);
    }

    /*
     * Implements service InsRegionalDirSucursal
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insRegionalDirSucursalImplementation(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsRegionalDirSucursalRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DirSucursalC dirSucursalCInsRegionalDirSucursalpthisDirSucursalC = request.getDirSucursalCInsRegionalDirSucursalpthisDirSucursalCInstance();
        Regional dirSucursalCInsRegionalDirSucursalpevcRegional = request.getDirSucursalCInsRegionalDirSucursalpevcRegionalInstance();

        request.checkArguments();
        DirSucursalC instance = dirSucursalCInsRegionalDirSucursalpthisDirSucursalC;

        instance.add2RegionalC(dirSucursalCInsRegionalDirSucursalpevcRegional);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.regional.siu.InsRegionalDirSucursalRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.regional.siu.InsRegionalDirSucursalRequest();
            relatedRequest.setRegionalInsRegionalDirSucursalpthisRegionalInstance(dirSucursalCInsRegionalDirSucursalpevcRegional);
            relatedRequest.setRegionalInsRegionalDirSucursalpevcDirSucursalCInstance(dirSucursalCInsRegionalDirSucursalpthisDirSucursalC);
            regionalSrv.insRegionalDirSucursalImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelRegionalDirSucursal

    /*
     * Entry point for service DelRegionalDirSucursal
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delRegionalDirSucursal(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelRegionalDirSucursalRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = dirSucursalCSrv.delRegionalDirSucursalTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelRegionalDirSucursal
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delRegionalDirSucursalTxn(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelRegionalDirSucursalRequest request) throws ModelException {
        request.setDirSucursalCDelRegionalDirSucursalpthisDirSucursalCInstance(dirSucursalCSrv.getByOIDWithHV(request.getDirSucursalCDelRegionalDirSucursalpthisDirSucursalC()));
        request.setDirSucursalCDelRegionalDirSucursalpevcRegionalInstance(regionalSrv.getByOIDWithHV(request.getDirSucursalCDelRegionalDirSucursalpevcRegional()));
        return dirSucursalCSrv.delRegionalDirSucursalImplementation(request, true);
    }

    /*
     * Implements service DelRegionalDirSucursal
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delRegionalDirSucursalImplementation(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelRegionalDirSucursalRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        DirSucursalC dirSucursalCDelRegionalDirSucursalpthisDirSucursalC = request.getDirSucursalCDelRegionalDirSucursalpthisDirSucursalCInstance();
        Regional dirSucursalCDelRegionalDirSucursalpevcRegional = request.getDirSucursalCDelRegionalDirSucursalpevcRegionalInstance();

        request.checkArguments();
        DirSucursalC instance = dirSucursalCDelRegionalDirSucursalpthisDirSucursalC;

        instance.add2RegionalC(null);
        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.regional.siu.DelRegionalDirSucursalRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.regional.siu.DelRegionalDirSucursalRequest();
            relatedRequest.setRegionalDelRegionalDirSucursalpthisRegionalInstance(dirSucursalCDelRegionalDirSucursalpevcRegional);
            relatedRequest.setRegionalDelRegionalDirSucursalpevcDirSucursalCInstance(dirSucursalCDelRegionalDirSucursalpthisDirSucursalC);
            regionalSrv.delRegionalDirSucursalImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: TMODIFICAR

    /*
     * Entry point for service TMODIFICAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tMODIFICAR(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.TMODIFICARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = dirSucursalCSrv.tMODIFICARTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TMODIFICAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tMODIFICARTxn(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.TMODIFICARRequest request) throws ModelException, SystemException {
        request.setDirSucursalCTMODIFICARpthisDirSucursalCInstance(dirSucursalCSrv.getByOIDWithHV(request.getDirSucursalCTMODIFICARpthisDirSucursalC()));
        request.setDirSucursalCTMODIFICARptpevcDepartamentoCInstance(departamentoSrv.getByOIDWithHV(request.getDirSucursalCTMODIFICARptpevcDepartamentoC()));
        request.setDirSucursalCTMODIFICARptpevcMunicipioCInstance(municipioSrv.getByOIDWithHV(request.getDirSucursalCTMODIFICARptpevcMunicipioC()));
        request.setDirSucursalCTMODIFICARptpevcPaisCInstance(paisSrv.getByOIDWithHV(request.getDirSucursalCTMODIFICARptpevcPaisC()));
        return dirSucursalCSrv.tMODIFICARImplementation(request);
    }

    /*
     * Implements service TMODIFICAR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tMODIFICARImplementation(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.TMODIFICARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        String dirSucursalCTMODIFICARptpCodLegalSucursal = request.getDirSucursalCTMODIFICARptpCodLegalSucursal();
        String dirSucursalCTMODIFICARptpNombre = request.getDirSucursalCTMODIFICARptpNombre();
        Boolean dirSucursalCTMODIFICARptpEsPrincipal = request.getDirSucursalCTMODIFICARptpEsPrincipal();
        Boolean dirSucursalCTMODIFICARptpActiva = request.getDirSucursalCTMODIFICARptpActiva();
        String dirSucursalCTMODIFICARptpDireccion = request.getDirSucursalCTMODIFICARptpDireccion();
        String dirSucursalCTMODIFICARptpMail = request.getDirSucursalCTMODIFICARptpMail();
        Departamento dirSucursalCTMODIFICARptpevcDepartamentoC = request.getDirSucursalCTMODIFICARptpevcDepartamentoCInstance();
        Municipio dirSucursalCTMODIFICARptpevcMunicipioC = request.getDirSucursalCTMODIFICARptpevcMunicipioCInstance();
        Pais dirSucursalCTMODIFICARptpevcPaisC = request.getDirSucursalCTMODIFICARptpevcPaisCInstance();
        DirSucursalC dirSucursalCTMODIFICARpthisDirSucursalC = request.getDirSucursalCTMODIFICARpthisDirSucursalCInstance();

        request.checkArguments();
        DirSucursalC instance = dirSucursalCTMODIFICARpthisDirSucursalC;

        com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.ModificarRequest step1Request = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.ModificarRequest();
        step1Request.setDirSucursalCmodificarpthisDirSucursalCInstance(dirSucursalCTMODIFICARpthisDirSucursalC);
        step1Request.setDirSucursalCmodificarpCodLegalSucursal(dirSucursalCTMODIFICARptpCodLegalSucursal);
        step1Request.setDirSucursalCmodificarpNombre(dirSucursalCTMODIFICARptpNombre);
        step1Request.setDirSucursalCmodificarpEsPrincipal(dirSucursalCTMODIFICARptpEsPrincipal);
        step1Request.setDirSucursalCmodificarpActiva(dirSucursalCTMODIFICARptpActiva);
        step1Request.setDirSucursalCmodificarpDireccion(dirSucursalCTMODIFICARptpDireccion);
        step1Request.setDirSucursalCmodificarpMail(dirSucursalCTMODIFICARptpMail);
        dirSucursalCSrv.modificarImplementation(step1Request);

        boolean guard2 = repository.assocOperator000(dirSucursalCTMODIFICARpthisDirSucursalC).equals(false) && (dirSucursalCTMODIFICARptpevcDepartamentoC != null && !dirSucursalCTMODIFICARptpevcDepartamentoC.isNull());

        if (guard2) {
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsDepartamentoDirSucursalCRequest step2Request = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsDepartamentoDirSucursalCRequest();
            step2Request.setDirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalCInstance(dirSucursalCTMODIFICARpthisDirSucursalC);
            step2Request.setDirSucursalCInsDepartamentoDirSucursalCpevcDepartamentoInstance(dirSucursalCTMODIFICARptpevcDepartamentoC);
            dirSucursalCSrv.insDepartamentoDirSucursalCImplementation(step2Request, true);
        }

        boolean guard3 = repository.assocOperator001(dirSucursalCTMODIFICARpthisDirSucursalC).equals(true) && (dirSucursalCTMODIFICARptpevcDepartamentoC == null || dirSucursalCTMODIFICARptpevcDepartamentoC.isNull());

        if (guard3) {
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelDepartamentoDirSucursalCRequest step3Request = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelDepartamentoDirSucursalCRequest();
            step3Request.setDirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalCInstance(dirSucursalCTMODIFICARpthisDirSucursalC);
            step3Request.setDirSucursalCDelDepartamentoDirSucursalCpevcDepartamentoInstance(dirSucursalCTMODIFICARpthisDirSucursalC.getDepartamentoC());
            dirSucursalCSrv.delDepartamentoDirSucursalCImplementation(step3Request, true);
        }

        /* Action 4: IF (EXIST (DepartamentoC) = true AND ptpevcDepartamentoC <> NULL AND DepartamentoC <> ptpevcDepartamentoC) */
        boolean ifCondition4 = repository.assocOperator009(dirSucursalCTMODIFICARpthisDirSucursalC).equals(true) && (dirSucursalCTMODIFICARptpevcDepartamentoC != null && !dirSucursalCTMODIFICARptpevcDepartamentoC.isNull()) && !Utilities.isEqual(dirSucursalCTMODIFICARpthisDirSucursalC.getDepartamentoC(), dirSucursalCTMODIFICARptpevcDepartamentoC);
        if (ifCondition4) {
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelDepartamentoDirSucursalCRequest step40Request = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelDepartamentoDirSucursalCRequest();
            step40Request.setDirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalCInstance(dirSucursalCTMODIFICARpthisDirSucursalC);
            step40Request.setDirSucursalCDelDepartamentoDirSucursalCpevcDepartamentoInstance(dirSucursalCTMODIFICARpthisDirSucursalC.getDepartamentoC());
            dirSucursalCSrv.delDepartamentoDirSucursalCImplementation(step40Request, true);
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsDepartamentoDirSucursalCRequest step41Request = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsDepartamentoDirSucursalCRequest();
            step41Request.setDirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalCInstance(dirSucursalCTMODIFICARpthisDirSucursalC);
            step41Request.setDirSucursalCInsDepartamentoDirSucursalCpevcDepartamentoInstance(dirSucursalCTMODIFICARptpevcDepartamentoC);
            dirSucursalCSrv.insDepartamentoDirSucursalCImplementation(step41Request, true);
        }

        boolean guard5 = repository.assocOperator003(dirSucursalCTMODIFICARpthisDirSucursalC).equals(false) && (dirSucursalCTMODIFICARptpevcMunicipioC != null && !dirSucursalCTMODIFICARptpevcMunicipioC.isNull());

        if (guard5) {
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsMunicipioDirSucursalRequest step5Request = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsMunicipioDirSucursalRequest();
            step5Request.setDirSucursalCInsMunicipioDirSucursalpthisDirSucursalCInstance(dirSucursalCTMODIFICARpthisDirSucursalC);
            step5Request.setDirSucursalCInsMunicipioDirSucursalpevcMunicipioInstance(dirSucursalCTMODIFICARptpevcMunicipioC);
            dirSucursalCSrv.insMunicipioDirSucursalImplementation(step5Request, true);
        }

        boolean guard6 = repository.assocOperator004(dirSucursalCTMODIFICARpthisDirSucursalC).equals(true) && (dirSucursalCTMODIFICARptpevcMunicipioC == null || dirSucursalCTMODIFICARptpevcMunicipioC.isNull());

        if (guard6) {
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelMunicipioDirSucursalRequest step6Request = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelMunicipioDirSucursalRequest();
            step6Request.setDirSucursalCDelMunicipioDirSucursalpthisDirSucursalCInstance(dirSucursalCTMODIFICARpthisDirSucursalC);
            step6Request.setDirSucursalCDelMunicipioDirSucursalpevcMunicipioInstance(dirSucursalCTMODIFICARpthisDirSucursalC.getMunicipioC());
            dirSucursalCSrv.delMunicipioDirSucursalImplementation(step6Request, true);
        }

        /* Action 7: IF (EXIST (MunicipioC) = true AND ptpevcMunicipioC <> NULL AND MunicipioC <> ptpevcMunicipioC) */
        boolean ifCondition7 = repository.assocOperator010(dirSucursalCTMODIFICARpthisDirSucursalC).equals(true) && (dirSucursalCTMODIFICARptpevcMunicipioC != null && !dirSucursalCTMODIFICARptpevcMunicipioC.isNull()) && !Utilities.isEqual(dirSucursalCTMODIFICARpthisDirSucursalC.getMunicipioC(), dirSucursalCTMODIFICARptpevcMunicipioC);
        if (ifCondition7) {
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelMunicipioDirSucursalRequest step70Request = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelMunicipioDirSucursalRequest();
            step70Request.setDirSucursalCDelMunicipioDirSucursalpthisDirSucursalCInstance(dirSucursalCTMODIFICARpthisDirSucursalC);
            step70Request.setDirSucursalCDelMunicipioDirSucursalpevcMunicipioInstance(dirSucursalCTMODIFICARpthisDirSucursalC.getMunicipioC());
            dirSucursalCSrv.delMunicipioDirSucursalImplementation(step70Request, true);
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsMunicipioDirSucursalRequest step71Request = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsMunicipioDirSucursalRequest();
            step71Request.setDirSucursalCInsMunicipioDirSucursalpthisDirSucursalCInstance(dirSucursalCTMODIFICARpthisDirSucursalC);
            step71Request.setDirSucursalCInsMunicipioDirSucursalpevcMunicipioInstance(dirSucursalCTMODIFICARptpevcMunicipioC);
            dirSucursalCSrv.insMunicipioDirSucursalImplementation(step71Request, true);
        }

        boolean guard8 = repository.assocOperator006(dirSucursalCTMODIFICARpthisDirSucursalC).equals(false) && (dirSucursalCTMODIFICARptpevcPaisC != null && !dirSucursalCTMODIFICARptpevcPaisC.isNull());

        if (guard8) {
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsPaisDirSucursalCRequest step8Request = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsPaisDirSucursalCRequest();
            step8Request.setDirSucursalCInsPaisDirSucursalCpthisDirSucursalCInstance(dirSucursalCTMODIFICARpthisDirSucursalC);
            step8Request.setDirSucursalCInsPaisDirSucursalCpevcPaisInstance(dirSucursalCTMODIFICARptpevcPaisC);
            dirSucursalCSrv.insPaisDirSucursalCImplementation(step8Request, true);
        }

        boolean guard9 = repository.assocOperator007(dirSucursalCTMODIFICARpthisDirSucursalC).equals(true) && (dirSucursalCTMODIFICARptpevcPaisC == null || dirSucursalCTMODIFICARptpevcPaisC.isNull());

        if (guard9) {
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelPaisDirSucursalCRequest step9Request = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelPaisDirSucursalCRequest();
            step9Request.setDirSucursalCDelPaisDirSucursalCpthisDirSucursalCInstance(dirSucursalCTMODIFICARpthisDirSucursalC);
            step9Request.setDirSucursalCDelPaisDirSucursalCpevcPaisInstance(dirSucursalCTMODIFICARpthisDirSucursalC.getPaisC());
            dirSucursalCSrv.delPaisDirSucursalCImplementation(step9Request, true);
        }

        /* Action 10: IF (EXIST (PaisC) = true AND ptpevcPaisC <> NULL AND PaisC <> ptpevcPaisC) */
        boolean ifCondition10 = repository.assocOperator011(dirSucursalCTMODIFICARpthisDirSucursalC).equals(true) && (dirSucursalCTMODIFICARptpevcPaisC != null && !dirSucursalCTMODIFICARptpevcPaisC.isNull()) && !Utilities.isEqual(dirSucursalCTMODIFICARpthisDirSucursalC.getPaisC(), dirSucursalCTMODIFICARptpevcPaisC);
        if (ifCondition10) {
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelPaisDirSucursalCRequest step100Request = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.DelPaisDirSucursalCRequest();
            step100Request.setDirSucursalCDelPaisDirSucursalCpthisDirSucursalCInstance(dirSucursalCTMODIFICARpthisDirSucursalC);
            step100Request.setDirSucursalCDelPaisDirSucursalCpevcPaisInstance(dirSucursalCTMODIFICARpthisDirSucursalC.getPaisC());
            dirSucursalCSrv.delPaisDirSucursalCImplementation(step100Request, true);
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsPaisDirSucursalCRequest step101Request = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.InsPaisDirSucursalCRequest();
            step101Request.setDirSucursalCInsPaisDirSucursalCpthisDirSucursalCInstance(dirSucursalCTMODIFICARpthisDirSucursalC);
            step101Request.setDirSucursalCInsPaisDirSucursalCpevcPaisInstance(dirSucursalCTMODIFICARptpevcPaisC);
            dirSucursalCSrv.insPaisDirSucursalCImplementation(step101Request, true);
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TCREAR

    /*
     * Entry point for service TCREAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCREAR(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.TCREARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = dirSucursalCSrv.tCREARTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCREARTxn(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.TCREARRequest request) throws ModelException {
        request.setDirSucursalCTCREARpagrMunicipioCInstance(municipioSrv.getByOIDWithHV(request.getDirSucursalCTCREARpagrMunicipioC()));
        request.setDirSucursalCTCREARpagrDepartamentoCInstance(departamentoSrv.getByOIDWithHV(request.getDirSucursalCTCREARpagrDepartamentoC()));
        request.setDirSucursalCTCREARpagrPaisCInstance(paisSrv.getByOIDWithHV(request.getDirSucursalCTCREARpagrPaisC()));
        request.setDirSucursalCTCREARpagrPersonaCInstance(personaCSrv.getByOIDWithHV(request.getDirSucursalCTCREARpagrPersonaC()));
        request.setDirSucursalCTCREARpagrRegionalCInstance(regionalSrv.getByOIDWithHV(request.getDirSucursalCTCREARpagrRegionalC()));
        return dirSucursalCSrv.tCREARImplementation(request);
    }

    /*
     * Implements service TCREAR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCREARImplementation(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.TCREARRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PersonaC dirSucursalCTCREARpagrPersonaC = request.getDirSucursalCTCREARpagrPersonaCInstance();
        Municipio dirSucursalCTCREARpagrMunicipioC = request.getDirSucursalCTCREARpagrMunicipioCInstance();
        Departamento dirSucursalCTCREARpagrDepartamentoC = request.getDirSucursalCTCREARpagrDepartamentoCInstance();
        Pais dirSucursalCTCREARpagrPaisC = request.getDirSucursalCTCREARpagrPaisCInstance();
        Regional dirSucursalCTCREARpagrRegionalC = request.getDirSucursalCTCREARpagrRegionalCInstance();
        String dirSucursalCTCREARpatrCodLegalSucursal = request.getDirSucursalCTCREARpatrCodLegalSucursal();
        String dirSucursalCTCREARpatrNombre = request.getDirSucursalCTCREARpatrNombre();
        Boolean dirSucursalCTCREARpatrEsPrincipal = request.getDirSucursalCTCREARpatrEsPrincipal();
        Boolean dirSucursalCTCREARpatrActiva = request.getDirSucursalCTCREARpatrActiva();
        String dirSucursalCTCREARpatrDireccion = request.getDirSucursalCTCREARpatrDireccion();
        String dirSucursalCTCREARpatrMail = request.getDirSucursalCTCREARpatrMail();
        String dirSucursalCTCREARpTelefonoFijo = request.getDirSucursalCTCREARpTelefonoFijo();
        String dirSucursalCTCREARpTelefonoCelular = request.getDirSucursalCTCREARpTelefonoCelular();

        request.checkArguments();
        DirSucursalC instance;

        com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.CrearRequest step1Request = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.CrearRequest();
        step1Request.setDirSucursalCcrearpagrPersonaCInstance(dirSucursalCTCREARpagrPersonaC);
        step1Request.setDirSucursalCcrearpagrMunicipioCInstance(dirSucursalCTCREARpagrMunicipioC);
        step1Request.setDirSucursalCcrearpagrDepartamentoCInstance(dirSucursalCTCREARpagrDepartamentoC);
        step1Request.setDirSucursalCcrearpagrPaisCInstance(dirSucursalCTCREARpagrPaisC);
        step1Request.setDirSucursalCcrearpagrRegionalCInstance(dirSucursalCTCREARpagrRegionalC);
        step1Request.setDirSucursalCcrearpatrCodLegalSucursal(dirSucursalCTCREARpatrCodLegalSucursal);
        step1Request.setDirSucursalCcrearpatrNombre(dirSucursalCTCREARpatrNombre);
        step1Request.setDirSucursalCcrearpatrEsPrincipal(dirSucursalCTCREARpatrEsPrincipal);
        step1Request.setDirSucursalCcrearpatrActiva(dirSucursalCTCREARpatrActiva);
        step1Request.setDirSucursalCcrearpatrDireccion(dirSucursalCTCREARpatrDireccion);
        step1Request.setDirSucursalCcrearpatrMail(dirSucursalCTCREARpatrMail);
        instance = (DirSucursalC) dirSucursalCSrv.crearImplementation(step1Request).getInstance();

        /* Action 2: IF (pTelefonoFijo <> NULL) */
        boolean ifCondition2 = dirSucursalCTCREARpTelefonoFijo != null;
        if (ifCondition2) {
            com.keralty.aesolicitudes.viewmodel.telefonoc.siu.CrearRequest step20Request = new com.keralty.aesolicitudes.viewmodel.telefonoc.siu.CrearRequest();
            step20Request.setTelefonoCcrearpagrDirSucursalCInstance(instance);
            step20Request.setTelefonoCcrearpagrDireccionCInstance(null);
            step20Request.setTelefonoCcrearpatrTelefono(dirSucursalCTCREARpTelefonoFijo);
            step20Request.setTelefonoCcrearpatrIndicativoPais(null);
            step20Request.setTelefonoCcrearpatrCodigoArea(null);
            step20Request.setTelefonoCcrearpatrExt(null);
            step20Request.setTelefonoCcrearpatrCodigo(Long.valueOf(1));
            telefonoCSrv.crearImplementation(step20Request);
        }

        /* Action 3: IF (pTelefonoCelular <> NULL) */
        boolean ifCondition3 = dirSucursalCTCREARpTelefonoCelular != null;
        if (ifCondition3) {
            com.keralty.aesolicitudes.viewmodel.telefonoc.siu.CrearRequest step30Request = new com.keralty.aesolicitudes.viewmodel.telefonoc.siu.CrearRequest();
            step30Request.setTelefonoCcrearpagrDirSucursalCInstance(instance);
            step30Request.setTelefonoCcrearpagrDireccionCInstance(null);
            step30Request.setTelefonoCcrearpatrTelefono(dirSucursalCTCREARpTelefonoCelular);
            step30Request.setTelefonoCcrearpatrIndicativoPais(null);
            step30Request.setTelefonoCcrearpatrCodigoArea(null);
            step30Request.setTelefonoCcrearpatrExt(null);
            step30Request.setTelefonoCcrearpatrCodigo(Long.valueOf(2));
            telefonoCSrv.crearImplementation(step30Request);
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TELIMINAR

    /*
     * Entry point for service TELIMINAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tELIMINAR(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.TELIMINARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = dirSucursalCSrv.tELIMINARTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TELIMINAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tELIMINARTxn(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.TELIMINARRequest request) throws ModelException, SystemException {
        request.setDirSucursalCTELIMINARpthisDirSucursalCInstance(dirSucursalCSrv.getByOIDWithHV(request.getDirSucursalCTELIMINARpthisDirSucursalC()));
        return dirSucursalCSrv.tELIMINARImplementation(request);
    }

    /*
     * Implements service TELIMINAR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tELIMINARImplementation(
            com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.TELIMINARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        DirSucursalC dirSucursalCTELIMINARpthisDirSucursalC = request.getDirSucursalCTELIMINARpthisDirSucursalCInstance();

        request.checkArguments();
        DirSucursalC instance = dirSucursalCTELIMINARpthisDirSucursalC;

        for(TelefonoC step1Entity : repository.assocOperator012(dirSucursalCTELIMINARpthisDirSucursalC)) {
            com.keralty.aesolicitudes.viewmodel.telefonoc.siu.EliminarRequest step1Request = new com.keralty.aesolicitudes.viewmodel.telefonoc.siu.EliminarRequest();
            step1Request.setTelefonoCeliminarpthisTelefonoCInstance(step1Entity);
            telefonoCSrv.eliminarImplementation(step1Request);
        }

        com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.EliminarRequest step2Request = new com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu.EliminarRequest();
        step2Request.setDirSucursalCeliminarpthisDirSucursalCInstance(dirSucursalCTELIMINARpthisDirSucursalC);
        dirSucursalCSrv.eliminarImplementation(step2Request);

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(DirSucursalCConstants.CLASS_NAME, DirSucursalCConstants.ATTR_FIELD_DIRSUCURSALCCODIGO, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildDirSucursalCRelatedInstance(relatedInstanceJsonOid);
        }
        if (DirSucursalCConstants.ROLE_NAME_TELEFONOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDirSucursalCRelatedInstance4TelefonoC(relatedInstanceJsonOid, remainingPath);
        }
        if (DirSucursalCConstants.ROLE_NAME_PERSONAC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDirSucursalCRelatedInstance4PersonaC(relatedInstanceJsonOid, remainingPath);
        }
        if (DirSucursalCConstants.ROLE_NAME_TIPOSSUCURSALC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDirSucursalCRelatedInstance4TipoSucursalC(relatedInstanceJsonOid, remainingPath);
        }
        if (DirSucursalCConstants.ROLE_NAME_MUNICIPIOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDirSucursalCRelatedInstance4Municipio(relatedInstanceJsonOid, remainingPath);
        }
        if (DirSucursalCConstants.ROLE_NAME_DEPARTAMENTOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDirSucursalCRelatedInstance4Departamento(relatedInstanceJsonOid, remainingPath);
        }
        if (DirSucursalCConstants.ROLE_NAME_PAISC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDirSucursalCRelatedInstance4Pais(relatedInstanceJsonOid, remainingPath);
        }
        if (DirSucursalCConstants.ROLE_NAME_REGIONALC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDirSucursalCRelatedInstance4Regional(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildDirSucursalCRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new DirSucursalC(mapper.readValue(relatedInstanceJsonOid, DirSucursalCOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildDirSucursalCRelatedInstance4TelefonoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TelefonoC(mapper.readValue(relatedInstanceJsonOid, TelefonoCOid.class)): TelefonoC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildDirSucursalCRelatedInstance4PersonaC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new PersonaC(mapper.readValue(relatedInstanceJsonOid, PersonaCOid.class)): PersonaC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildDirSucursalCRelatedInstance4TipoSucursalC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TipoSucursalC(mapper.readValue(relatedInstanceJsonOid, TipoSucursalCOid.class)): TipoSucursalC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildDirSucursalCRelatedInstance4Municipio(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Municipio(mapper.readValue(relatedInstanceJsonOid, MunicipioOid.class)): Municipio.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildDirSucursalCRelatedInstance4Departamento(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Departamento(mapper.readValue(relatedInstanceJsonOid, DepartamentoOid.class)): Departamento.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildDirSucursalCRelatedInstance4Pais(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Pais(mapper.readValue(relatedInstanceJsonOid, PaisOid.class)): Pais.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildDirSucursalCRelatedInstance4Regional(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Regional(mapper.readValue(relatedInstanceJsonOid, RegionalOid.class)): Regional.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            DirSucursalCOid oid = new DirSucursalCOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(DirSucursalCConstants.ATTR_FIELD_DIRSUCURSALCCODIGO, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getDirSucursalCCodigo(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(DirSucursalCService.class).error(e.getMessage());
        }
    }

}
