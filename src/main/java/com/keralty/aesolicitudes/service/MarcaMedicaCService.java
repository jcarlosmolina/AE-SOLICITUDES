package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.MarcaMedicaCConstants;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.global.ProductosConstants;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.MarcaMedicaC;
import com.keralty.aesolicitudes.persistence.oid.MarcaMedicaCOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.repository.MarcaMedicaCJpaRepository;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLWhereComparison;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathAttribute;
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
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class MarcaMedicaCService extends AbstractService {

    MarcaMedicaCJpaRepository repository;

    MarcaMedicaCService marcaMedicaCSrv;

    ProductosService productosSrv;

    PersonaCService personaCSrv;

    @Inject
    public MarcaMedicaCService(
            MarcaMedicaCService marcaMedicaCSrv,
            ProductosService productosSrv,
            PersonaCService personaCSrv,
            MarcaMedicaCJpaRepository repository) {
        this.marcaMedicaCSrv = marcaMedicaCSrv;
        this.productosSrv = productosSrv;
        this.personaCSrv = personaCSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, MarcaMedicaCConstants.CLASS_NAME);
    }

    private List<MarcaMedicaC> solveMarcaMedicaCTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, MarcaMedicaCConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveMarcaMedicaCTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, MarcaMedicaCConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class MarcaMedicaC
     *
     * @return Population of class MarcaMedicaC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<MarcaMedicaC> get() {
        List<MarcaMedicaC> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class MarcaMedicaC that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class MarcaMedicaC matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<MarcaMedicaC> get(QueryRequest queryRequest) {
        return solveMarcaMedicaCTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveMarcaMedicaCTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveMarcaMedicaCTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveMarcaMedicaCTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of MarcaMedicaC by ID
     *
     * @param personaCID Identification field personaCID
     *
     * @param productosProducto Identification field productosProducto
     *
     * @param marcaMedicaCCodigo Identification field marcaMedicaCCodigo
     *
     * @return Instance of MarcaMedicaC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public MarcaMedicaC getById(Long personaCID, Long productosProducto, String marcaMedicaCCodigo) {
        return getByOID(new MarcaMedicaCOid(personaCID, productosProducto, marcaMedicaCCodigo));
    }
    
    /*
     * Returns an instance of MarcaMedicaC by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of MarcaMedicaC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public MarcaMedicaC getByOID(MarcaMedicaCOid oid) {
        Optional<MarcaMedicaC> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of MarcaMedicaC by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of MarcaMedicaC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public MarcaMedicaC getByOIDWithHV(MarcaMedicaCOid oid) {
        Optional<MarcaMedicaC> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<MarcaMedicaC> getInstanceByOid(MarcaMedicaCOid oid) {
        return oid != null && oid.getPersonaCID() != null
               ? repository.findById(oid)
               : Optional.empty();
    }

    /*
     * Returns an instance of MarcaMedicaC by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of MarcaMedicaC
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public MarcaMedicaC getByJsonOid(String jsonOid) {
        MarcaMedicaCOid oid = new MarcaMedicaCOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of MarcaMedicaC related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of MarcaMedicaC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<MarcaMedicaC> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveMarcaMedicaCTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of MarcaMedicaC related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of MarcaMedicaC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<MarcaMedicaC> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of MarcaMedicaC
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of MarcaMedicaC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getMarcaMedicaCDynamic(MarcaMedicaCOid oid, String displaySetItems) {
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
    public String getSuppInfo(MarcaMedicaCOid oid, String dsName) {
        MarcaMedicaC instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(MarcaMedicaC instance, String dsName) {
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
            com.keralty.aesolicitudes.viewmodel.marcamedicac.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = marcaMedicaCSrv.crearTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.marcamedicac.siu.CrearRequest request) throws ModelException {
        request.setMarcaMedicaCcrearpagrProductoCInstance(productosSrv.getByOIDWithHV(request.getMarcaMedicaCcrearpagrProductoC()));
        request.setMarcaMedicaCcrearpagrPersonaCInstance(personaCSrv.getByOIDWithHV(request.getMarcaMedicaCcrearpagrPersonaC()));
        return marcaMedicaCSrv.crearImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.marcamedicac.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Productos marcaMedicaCcrearpagrProductoC = request.getMarcaMedicaCcrearpagrProductoCInstance();
        PersonaC marcaMedicaCcrearpagrPersonaC = request.getMarcaMedicaCcrearpagrPersonaCInstance();
        String marcaMedicaCcrearpatrCodigo = request.getMarcaMedicaCcrearpatrCodigo();
        String marcaMedicaCcrearpatrDescripcion = request.getMarcaMedicaCcrearpatrDescripcion();
        String marcaMedicaCcrearpatrTipoMarcacion = request.getMarcaMedicaCcrearpatrTipoMarcacion();
        Boolean marcaMedicaCcrearpatrEximePagoPrestacion = request.getMarcaMedicaCcrearpatrEximePagoPrestacion();
        String marcaMedicaCcrearpatrEstadoMarcacionMedica = request.getMarcaMedicaCcrearpatrEstadoMarcacionMedica();
        Date marcaMedicaCcrearpatrFechaInicio = request.getMarcaMedicaCcrearpatrFechaInicio();
        Date marcaMedicaCcrearpatrFechaFin = request.getMarcaMedicaCcrearpatrFechaFin();

        request.checkArguments();
        MarcaMedicaC instance = new MarcaMedicaC();
        instance.add2ProductoC(marcaMedicaCcrearpagrProductoC);

        instance.add2PersonaC(marcaMedicaCcrearpagrPersonaC);

        instance.setMarcaMedicaCCodigo(marcaMedicaCcrearpatrCodigo);
        instance.setMarcaMedicaCDescripcion(marcaMedicaCcrearpatrDescripcion);
        instance.setMarcaMedicaCTipoMarcacion(marcaMedicaCcrearpatrTipoMarcacion);
        instance.setMarcaMedicaCEximePagoPrestacion(marcaMedicaCcrearpatrEximePagoPrestacion);
        instance.setMarcaMedicaCEstadoMarcacionMedica(marcaMedicaCcrearpatrEstadoMarcacionMedica);
        instance.setMarcaMedicaCFechaInicio(marcaMedicaCcrearpatrFechaInicio);
        instance.setMarcaMedicaCFechaFin(marcaMedicaCcrearpatrFechaFin);

        instance.setOid(instance.getOid());

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
            com.keralty.aesolicitudes.viewmodel.marcamedicac.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = marcaMedicaCSrv.eliminarTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.marcamedicac.siu.EliminarRequest request) throws ModelException {
        request.setMarcaMedicaCeliminarpthisMarcaMedicaCInstance(marcaMedicaCSrv.getByOIDWithHV(request.getMarcaMedicaCeliminarpthisMarcaMedicaC()));
        return marcaMedicaCSrv.eliminarImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.marcamedicac.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        MarcaMedicaC marcaMedicaCeliminarpthisMarcaMedicaC = request.getMarcaMedicaCeliminarpthisMarcaMedicaCInstance();

        request.checkArguments();
        MarcaMedicaC instance = marcaMedicaCeliminarpthisMarcaMedicaC;


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
            com.keralty.aesolicitudes.viewmodel.marcamedicac.siu.ModificarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = marcaMedicaCSrv.modificarTxn(request);
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
            com.keralty.aesolicitudes.viewmodel.marcamedicac.siu.ModificarRequest request) throws ModelException {
        request.setMarcaMedicaCmodificarpthisMarcaMedicaCInstance(marcaMedicaCSrv.getByOIDWithHV(request.getMarcaMedicaCmodificarpthisMarcaMedicaC()));
        return marcaMedicaCSrv.modificarImplementation(request);
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
            com.keralty.aesolicitudes.viewmodel.marcamedicac.siu.ModificarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        MarcaMedicaC marcaMedicaCmodificarpthisMarcaMedicaC = request.getMarcaMedicaCmodificarpthisMarcaMedicaCInstance();
        String marcaMedicaCmodificarpDescripcion = request.getMarcaMedicaCmodificarpDescripcion();
        String marcaMedicaCmodificarpTipoMarcacion = request.getMarcaMedicaCmodificarpTipoMarcacion();
        Boolean marcaMedicaCmodificarpEximePagoPrestacion = request.getMarcaMedicaCmodificarpEximePagoPrestacion();
        String marcaMedicaCmodificarpEstadoMarcacionMedica = request.getMarcaMedicaCmodificarpEstadoMarcacionMedica();
        Date marcaMedicaCmodificarpFechaInicio = request.getMarcaMedicaCmodificarpFechaInicio();
        Date marcaMedicaCmodificarpFechaFin = request.getMarcaMedicaCmodificarpFechaFin();

        request.checkArguments();
        MarcaMedicaC instance = marcaMedicaCmodificarpthisMarcaMedicaC;
        instance.setMarcaMedicaCDescripcion(marcaMedicaCmodificarpDescripcion);
        instance.setMarcaMedicaCTipoMarcacion(marcaMedicaCmodificarpTipoMarcacion);
        instance.setMarcaMedicaCEximePagoPrestacion(marcaMedicaCmodificarpEximePagoPrestacion);
        instance.setMarcaMedicaCEstadoMarcacionMedica(marcaMedicaCmodificarpEstadoMarcacionMedica);
        instance.setMarcaMedicaCFechaInicio(marcaMedicaCmodificarpFechaInicio);
        instance.setMarcaMedicaCFechaFin(marcaMedicaCmodificarpFechaFin);


        response.setInstance(repository.save(instance));

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
        select.getOrderByPart().addItem(Constants.normalizePath(MarcaMedicaCConstants.CLASS_NAME, MarcaMedicaCConstants.ROLE_NAME_PERSONAC + "." + PersonaCConstants.ATTR_FIELD_PERSONACID, false), true);
        select.getOrderByPart().addItem(Constants.normalizePath(MarcaMedicaCConstants.CLASS_NAME, MarcaMedicaCConstants.ROLE_NAME_PRODUCTOC + "." + ProductosConstants.ATTR_FIELD_PRODUCTOSPRODUCTO, false), true);
        select.getOrderByPart().addItem(Constants.normalizePath(MarcaMedicaCConstants.CLASS_NAME, MarcaMedicaCConstants.ATTR_FIELD_MARCAMEDICACCODIGO, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildMarcaMedicaCRelatedInstance(relatedInstanceJsonOid);
        }
        if (MarcaMedicaCConstants.ROLE_NAME_PERSONAC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildMarcaMedicaCRelatedInstance4PersonaC(relatedInstanceJsonOid, remainingPath);
        }
        if (MarcaMedicaCConstants.ROLE_NAME_PRODUCTOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildMarcaMedicaCRelatedInstance4Productos(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildMarcaMedicaCRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new MarcaMedicaC(mapper.readValue(relatedInstanceJsonOid, MarcaMedicaCOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildMarcaMedicaCRelatedInstance4PersonaC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new PersonaC(mapper.readValue(relatedInstanceJsonOid, PersonaCOid.class)): PersonaC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildMarcaMedicaCRelatedInstance4Productos(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Productos(mapper.readValue(relatedInstanceJsonOid, ProductosOid.class)): Productos.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            MarcaMedicaCOid oid = new MarcaMedicaCOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(MarcaMedicaCConstants.ROLE_NAME_PERSONAC + "." + PersonaCConstants.ATTR_FIELD_PERSONACID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getPersonaCID(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(MarcaMedicaCConstants.ROLE_NAME_PRODUCTOC + "." + ProductosConstants.ATTR_FIELD_PRODUCTOSPRODUCTO, Constants.Type.INT.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(oid.getProductosProducto(), Constants.Type.INT.getTypeName()));
            sql.addComparison(comparison2);
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("=");
            comparison3.setFirstOperand(new SQLWhereOperandPathAttribute(MarcaMedicaCConstants.ATTR_FIELD_MARCAMEDICACCODIGO, Constants.Type.STRING.getTypeName()));
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(oid.getMarcaMedicaCCodigo(), Constants.Type.STRING.getTypeName()));
            sql.addComparison(comparison3);
        } catch (Exception e) {
            LoggerFactory.getLogger(MarcaMedicaCService.class).error(e.getMessage());
        }
    }

}
