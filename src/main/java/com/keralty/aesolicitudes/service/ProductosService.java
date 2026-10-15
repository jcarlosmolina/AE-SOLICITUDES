package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.AsesorConstants;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.ProductosConstants;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.AgentexProducto;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Dominio;
import com.keralty.aesolicitudes.persistence.GrupoAsociado;
import com.keralty.aesolicitudes.persistence.MarcaMedicaC;
import com.keralty.aesolicitudes.persistence.oid.AesolicitudesOid;
import com.keralty.aesolicitudes.persistence.oid.AgentexProductoOid;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.DominioOid;
import com.keralty.aesolicitudes.persistence.oid.GrupoAsociadoOid;
import com.keralty.aesolicitudes.persistence.oid.MarcaMedicaCOid;
import com.keralty.aesolicitudes.persistence.oid.PlanesOid;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosCOid;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.oid.TarifaOid;
import com.keralty.aesolicitudes.persistence.oid.TipoIVAOid;
import com.keralty.aesolicitudes.persistence.Planes;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.persistence.ProteccionDatosC;
import com.keralty.aesolicitudes.persistence.Tarifa;
import com.keralty.aesolicitudes.persistence.TipoIVA;
import com.keralty.aesolicitudes.repository.ProductosJpaRepository;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLWhereComparison;
import com.keralty.aesolicitudes.sqlutils.SQLWhereConjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereDisjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;
import com.keralty.aesolicitudes.viewmodel.FilterVariableRequest;
import com.keralty.aesolicitudes.viewmodel.InstanceResponseViewModel;
import com.keralty.aesolicitudes.viewmodel.PopulationResponseViewModel;
import com.keralty.aesolicitudes.viewmodel.PreloadResponseViewModel;
import com.keralty.aesolicitudes.viewmodel.PreloadViewModel;
import com.keralty.aesolicitudes.viewmodel.QueryRequest;
import com.keralty.aesolicitudes.viewmodel.QueryResponse;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class ProductosService extends AbstractService {

    ProductosJpaRepository repository;

    ProductosService productosSrv;

    ProteccionDatosService proteccionDatosSrv;

    ContratoCService contratoCSrv;

    PlanesService planesSrv;

    DominioService dominioSrv;

    TarifaService tarifaSrv;

    GrupoAsociadoService grupoAsociadoSrv;

    TipoIVAService tipoIVASrv;

    AesolicitudesService aesolicitudesSrv;

    ProteccionDatosCService proteccionDatosCSrv;

    MarcaMedicaCService marcaMedicaCSrv;

    AgentexProductoService agentexProductoSrv;

    @Inject
    public ProductosService(
            ProductosService productosSrv,
            ProteccionDatosService proteccionDatosSrv,
            ContratoCService contratoCSrv,
            PlanesService planesSrv,
            DominioService dominioSrv,
            TarifaService tarifaSrv,
            GrupoAsociadoService grupoAsociadoSrv,
            TipoIVAService tipoIVASrv,
            AesolicitudesService aesolicitudesSrv,
            ProteccionDatosCService proteccionDatosCSrv,
            MarcaMedicaCService marcaMedicaCSrv,
            AgentexProductoService agentexProductoSrv,
            ProductosJpaRepository repository) {
        this.productosSrv = productosSrv;
        this.proteccionDatosSrv = proteccionDatosSrv;
        this.contratoCSrv = contratoCSrv;
        this.planesSrv = planesSrv;
        this.dominioSrv = dominioSrv;
        this.tarifaSrv = tarifaSrv;
        this.grupoAsociadoSrv = grupoAsociadoSrv;
        this.tipoIVASrv = tipoIVASrv;
        this.aesolicitudesSrv = aesolicitudesSrv;
        this.proteccionDatosCSrv = proteccionDatosCSrv;
        this.marcaMedicaCSrv = marcaMedicaCSrv;
        this.agentexProductoSrv = agentexProductoSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, ProductosConstants.CLASS_NAME);
    }

    private List<Productos> solveProductosTypedQuery(QueryRequest request) {
        boolean hasInMemoryFilters = hasInMemoryFilters(request);
        int requestedPageSize = request.getPageSize();
        int pageSize = requestedPageSize > 0
                && requestedPageSize <= Constants.MAX_BLOCKSIZE
                ? requestedPageSize
                : Constants.DEFAULT_BLOCKSIZE;
        int pageNumber = Math.max(1, request.getPageNumber());

    	List<Productos> results = repository.solveQuery(processQueryRequest(request, ProductosConstants.CLASS_NAME), (hasInMemoryFilters ? 0 : pageSize), (hasInMemoryFilters ? 1 : pageNumber)).stream()
                .filter(instance -> hasInMemoryFilters ? applyMemoryFilters(request, instance) : true).collect(Collectors.toList()); 

        if (hasInMemoryFilters && results != null && !results.isEmpty()) {
            long fromInstance = ((long) pageNumber - 1) * pageSize;
            long toInstance = (long) pageNumber * pageSize;
            if (pageSize == 0) {
               fromInstance = 0;
               toInstance = results.size();
            }
            int from = (int) Math.min(fromInstance, results.size());
            int to = (int) Math.min(toInstance, results.size());
            results = (fromInstance > results.size() - 1)
                    ? new ArrayList<>()
                    : results.subList(from, Math.max(from, to));
        }

        return results;
    }
    
    private int solveProductosTypedCountQuery(QueryRequest request) {
        return hasInMemoryFilters(request)
               ? repository.solveQuery(processQueryRequest(request, ProductosConstants.CLASS_NAME)).stream().filter(instance -> applyMemoryFilters(request, instance)).collect(Collectors.toList()).size()
               : repository.solveCountQuery(processCountQueryRequest(request, ProductosConstants.CLASS_NAME));
    }

    private boolean hasInMemoryFilters(QueryRequest queryRequest) {
        for(FilterRequest filterRequest : queryRequest.getFilters()) {
            if (hasInMemoryConjunctions(filterRequest)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasInMemoryConjunctions(FilterRequest filterRequest) {
        if ("Ae_solicitudes_TNUEVAAFILIACION_pt_p_agrProducto_NavFilter0".equalsIgnoreCase(filterRequest.getName())) {
            return true;
        }
        if ("Ae_solicitudes_TINCLUSIONSC_pt_p_agrProducto_NavFilter0".equalsIgnoreCase(filterRequest.getName())) {
            return true;
        }
        if ("SolicitudNovedad_TCREAR_ptProducto_NavFilter0".equalsIgnoreCase(filterRequest.getName())) {
            return true;
        }
        if ("SolicitudNovedad_TCREAREXCEPCION_ptProducto_NavFilter0".equalsIgnoreCase(filterRequest.getName())) {
            return true;
        }
        return false;
    }

    /*
     * Returns the population of class Productos
     *
     * @return Population of class Productos
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Productos> get() {
        List<Productos> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class Productos
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class Productos
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<Productos> instances = get(queryRequest);
        if(ProductosConstants.DSICPRODUCTO.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICProducto())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class Productos that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class Productos matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Productos> get(QueryRequest queryRequest) {
        return solveProductosTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveProductosTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveProductosTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveProductosTypedQuery(queryRequest).stream()
                    .map(instance -> buildPreloadViewModel(instance, queryRequest.getDisplaySetName()))
                    .collect(Collectors.toList()));
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
        return new PopulationResponseViewModel(solveProductosTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of Productos by ID
     *
     * @param productosProducto Identification field productosProducto
     *
     * @return Instance of Productos
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Productos getById(Long productosProducto) {
        return getByOID(new ProductosOid(productosProducto));
    }
    
    /*
     * Returns an instance of Productos by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Productos
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Productos getByOID(ProductosOid oid) {
        Optional<Productos> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Productos by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Productos
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Productos getByOIDWithHV(ProductosOid oid) {
        Optional<Productos> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Productos> getInstanceByOid(ProductosOid oid) {
        return oid != null && oid.getProductosProducto() != null
               ? repository.findById(oid.getProductosProducto())
               : Optional.empty();
    }

    /*
     * Returns an instance of Productos by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Productos
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Productos getByJsonOid(String jsonOid) {
        ProductosOid oid = new ProductosOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of Productos related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Productos
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Productos> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveProductosTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of Productos related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Productos
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Productos> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of Productos
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of Productos
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getProductosDynamic(ProductosOid oid, String displaySetItems) {
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
    public String getSuppInfo(ProductosOid oid, String dsName) {
        Productos instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(Productos instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (ProductosConstants.DSICPRODUCTO.equals(dsName))
            return instance.buildICProducto();
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(Productos instance, String dsName) {
        if (ProductosConstants.DSICPRODUCTO.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICProducto());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (ProductosConstants.FILTER_NAME_IFPRODUCTONUMERO.equalsIgnoreCase(filterRequest.getName()))
            iFProductoNumero(filterRequest, sql);
        if (ProductosConstants.FILTER_NAME_IFPRODUCTOSPORCODLEGAL.equalsIgnoreCase(filterRequest.getName()))
            iFProductosPorCodLEgal(filterRequest, sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_Producto".equals(filterRequest.getName()))
            suppInfo4ICProducto(filterRequest.getFilterVariable("searchText").toString(), sql);
    }

    private boolean applyMemoryFilters(QueryRequest queryRequest, Productos instance) {
        for (FilterRequest filterRequest : queryRequest.getFilters()) {
            if (!applyMemoryFilter(filterRequest, instance))
                return false;
        }
        return true;
    }
    
    private boolean applyMemoryFilter(FilterRequest filterRequest, Productos instance) {
        return applyMemoryNavigationalFilter(filterRequest, instance);
    }

    private boolean applyMemoryNavigationalFilter(FilterRequest filterRequest, Productos entity) {
        if ("Ae_solicitudes_TNUEVAAFILIACION_pt_p_agrProducto_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            return inMemoryClas1431956094976663FiltNav11(entity);
        if ("Ae_solicitudes_TINCLUSIONSC_pt_p_agrProducto_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            return inMemoryClas1431956094976663FiltNav12(entity);
        if ("SolicitudNovedad_TCREAR_ptProducto_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            return inMemoryClas1581421428736234FiltNav1(entity);
        if ("SolicitudNovedad_TCREAREXCEPCION_ptProducto_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            return inMemoryClas1581421428736234FiltNav10(entity);
        return true;
    }


    private void iFProductoNumero(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vNumero = filterRequest.hasFilterVariable(ProductosConstants.VAR_NAME_IFPRODUCTONUMERO_VNUMERO) ? (Long) filterRequest.getFilterVariable(ProductosConstants.VAR_NAME_IFPRODUCTONUMERO_VNUMERO, FilterVariableRequest.INT) : null;

        // Producto = vNumero
        if (vNumero != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ProductosConstants.ATTR_NAME_PRODUCTOSPRODUCTO, Constants.Type.INT.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vNumero, Constants.Type.INT.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    private void iFProductosPorCodLEgal(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vCodLegal = filterRequest.hasFilterVariable(ProductosConstants.VAR_NAME_IFPRODUCTOSPORCODLEGAL_VCODLEGAL) ? (String) filterRequest.getFilterVariable(ProductosConstants.VAR_NAME_IFPRODUCTOSPORCODLEGAL_VCODLEGAL, FilterVariableRequest.STRING) : null;

        // CodigoLegal = vCodLegal
        if (vCodLegal != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ProductosConstants.ATTR_NAME_PRODUCTOSCODIGOLEGAL, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vCodLegal, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    private boolean inMemoryClas1431956094976663FiltNav11(Productos entity) {
        if(!(getAgentRoles().contains(AsesorConstants.CLASS_NAME))) return true;
        boolean result = true;

        // EXIST (AgentexProducto) WHERE (AgentexProducto.Asesor = AGENTAsesor AND AgentexProducto.drvVigente = true) = true
        try {
            result = repository.assocOperator010(entity).equals(true);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
        return result;
    }

    private boolean inMemoryClas1431956094976663FiltNav12(Productos entity) {
        return inMemoryClas1431956094976663FiltNav11(entity);
    }

    private boolean inMemoryClas1581421428736234FiltNav1(Productos entity) {
        return inMemoryClas1431956094976663FiltNav11(entity);
    }

    private boolean inMemoryClas1581421428736234FiltNav10(Productos entity) {
        return inMemoryClas1431956094976663FiltNav11(entity);
    }

    // IIU Methods


    /*
     * Solves the query needed for PIUProducto
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Productos using displayset AutoDS that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aesolicitudes.viewmodel.productos.ds.AutoDS> piuPIUProducto(QueryRequest queryRequest) {
        return solveProductosTypedQuery(queryRequest).stream()
                .map(com.keralty.aesolicitudes.viewmodel.productos.ds.AutoDS::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUProducto
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUProducto
     */
    public int getCount4PIUProducto(QueryRequest queryRequest) {
        return solveProductosTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUProductosObs
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Productos using displayset AutoDS that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aesolicitudes.viewmodel.productos.ds.AutoDS> piuPIUProductosObs(QueryRequest queryRequest) {
        return solveProductosTypedQuery(queryRequest).stream()
                .map(com.keralty.aesolicitudes.viewmodel.productos.ds.AutoDS::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUProductosObs
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUProductosObs
     */
    public int getCount4PIUProductosObs(QueryRequest queryRequest) {
        return solveProductosTypedQuery(queryRequest).size();
    }

    // Service: InsProductoProteccionDatos

    /*
     * Entry point for service InsProductoProteccionDatos
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insProductoProteccionDatos(
            com.keralty.aesolicitudes.viewmodel.productos.siu.InsProductoProteccionDatosRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = productosSrv.insProductoProteccionDatosTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsProductoProteccionDatos
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insProductoProteccionDatosTxn(
            com.keralty.aesolicitudes.viewmodel.productos.siu.InsProductoProteccionDatosRequest request) throws ModelException {
        request.setProductosInsProductoProteccionDatospthisProductoInstance(productosSrv.getByOIDWithHV(request.getProductosInsProductoProteccionDatospthisProducto()));
        request.setProductosInsProductoProteccionDatospevcProteccionDatosInstance(proteccionDatosSrv.getByOIDWithHV(request.getProductosInsProductoProteccionDatospevcProteccionDatos()));
        return productosSrv.insProductoProteccionDatosImplementation(request, true);
    }

    /*
     * Implements service InsProductoProteccionDatos
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insProductoProteccionDatosImplementation(
            com.keralty.aesolicitudes.viewmodel.productos.siu.InsProductoProteccionDatosRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Productos productosInsProductoProteccionDatospthisProducto = request.getProductosInsProductoProteccionDatospthisProductoInstance();
        ProteccionDatos productosInsProductoProteccionDatospevcProteccionDatos = request.getProductosInsProductoProteccionDatospevcProteccionDatosInstance();

        request.checkArguments();
        Productos instance = productosInsProductoProteccionDatospthisProducto;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.InsProductoProteccionDatosRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.InsProductoProteccionDatosRequest();
            relatedRequest.setProteccionDatosInsProductoProteccionDatospthisProteccionDatosInstance(productosInsProductoProteccionDatospevcProteccionDatos);
            relatedRequest.setProteccionDatosInsProductoProteccionDatospevcProductosInstance(productosInsProductoProteccionDatospthisProducto);
            proteccionDatosSrv.insProductoProteccionDatosImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICProducto());

        return response;
    }

    // Service: DelProductoProteccionDatos

    /*
     * Entry point for service DelProductoProteccionDatos
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delProductoProteccionDatos(
            com.keralty.aesolicitudes.viewmodel.productos.siu.DelProductoProteccionDatosRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = productosSrv.delProductoProteccionDatosTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelProductoProteccionDatos
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delProductoProteccionDatosTxn(
            com.keralty.aesolicitudes.viewmodel.productos.siu.DelProductoProteccionDatosRequest request) throws ModelException {
        request.setProductosDelProductoProteccionDatospthisProductoInstance(productosSrv.getByOIDWithHV(request.getProductosDelProductoProteccionDatospthisProducto()));
        request.setProductosDelProductoProteccionDatospevcProteccionDatosInstance(proteccionDatosSrv.getByOIDWithHV(request.getProductosDelProductoProteccionDatospevcProteccionDatos()));
        return productosSrv.delProductoProteccionDatosImplementation(request, true);
    }

    /*
     * Implements service DelProductoProteccionDatos
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delProductoProteccionDatosImplementation(
            com.keralty.aesolicitudes.viewmodel.productos.siu.DelProductoProteccionDatosRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Productos productosDelProductoProteccionDatospthisProducto = request.getProductosDelProductoProteccionDatospthisProductoInstance();
        ProteccionDatos productosDelProductoProteccionDatospevcProteccionDatos = request.getProductosDelProductoProteccionDatospevcProteccionDatosInstance();

        request.checkArguments();
        Productos instance = productosDelProductoProteccionDatospthisProducto;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.DelProductoProteccionDatosRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.protecciondatos.siu.DelProductoProteccionDatosRequest();
            relatedRequest.setProteccionDatosDelProductoProteccionDatospthisProteccionDatosInstance(productosDelProductoProteccionDatospevcProteccionDatos);
            relatedRequest.setProteccionDatosDelProductoProteccionDatospevcProductosInstance(productosDelProductoProteccionDatospthisProducto);
            proteccionDatosSrv.delProductoProteccionDatosImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICProducto());

        return response;
    }

    // Service: chgProductoC

    /*
     * Entry point for service chgProductoC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse chgProductoC(
            com.keralty.aesolicitudes.viewmodel.productos.siu.ChgProductoCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = productosSrv.chgProductoCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service chgProductoC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse chgProductoCTxn(
            com.keralty.aesolicitudes.viewmodel.productos.siu.ChgProductoCRequest request) throws ModelException {
        request.setProductoschgProductoCpthisProductosInstance(productosSrv.getByOIDWithHV(request.getProductoschgProductoCpthisProductos()));
        request.setProductoschgProductoCpevcContratoCInstance(contratoCSrv.getByOIDWithHV(request.getProductoschgProductoCpevcContratoC()));
        return productosSrv.chgProductoCImplementation(request, true);
    }

    /*
     * Implements service chgProductoC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse chgProductoCImplementation(
            com.keralty.aesolicitudes.viewmodel.productos.siu.ChgProductoCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Productos productoschgProductoCpthisProductos = request.getProductoschgProductoCpthisProductosInstance();
        ContratoC productoschgProductoCpevcContratoC = request.getProductoschgProductoCpevcContratoCInstance();

        request.checkArguments();
        Productos instance = productoschgProductoCpthisProductos;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.contratoc.siu.ChgProductoCRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.contratoc.siu.ChgProductoCRequest();
            relatedRequest.setContratoCchgProductoCpthisContratoCInstance(productoschgProductoCpevcContratoC);
            relatedRequest.setContratoCchgProductoCpevcProductosInstance(productoschgProductoCpthisProductos);
            contratoCSrv.chgProductoCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICProducto());

        return response;
    }


    private void suppInfo4ICProducto(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ProductosConstants.ATTR_NAME_PRODUCTOSDESCRIPCION, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison1);

            SQLWhereConjunction conjunction = new SQLWhereConjunction();
            conjunction.addDisjunction(disjunction);
            select.addConjunction(conjunction);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyOCOCProducto(queryRequest, select);
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(ProductosConstants.CLASS_NAME, ProductosConstants.ATTR_FIELD_PRODUCTOSPRODUCTO, false), true);
    }


    private void applyOCOCProducto(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_Producto".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(ProductosConstants.CLASS_NAME, ProductosConstants.ATTR_NAME_PRODUCTOSDESCRIPCION, false), true);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildProductosRelatedInstance(relatedInstanceJsonOid);
        }
        if (ProductosConstants.ROLE_NAME_PLANES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildProductosRelatedInstance4Planes(relatedInstanceJsonOid, remainingPath);
        }
        if (ProductosConstants.ROLE_NAME_DOMINIOS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildProductosRelatedInstance4Dominio(relatedInstanceJsonOid, remainingPath);
        }
        if (ProductosConstants.ROLE_NAME_TARIFAS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildProductosRelatedInstance4Tarifa(relatedInstanceJsonOid, remainingPath);
        }
        if (ProductosConstants.ROLE_NAME_GRUPOSASOCIADOS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildProductosRelatedInstance4GrupoAsociado(relatedInstanceJsonOid, remainingPath);
        }
        if (ProductosConstants.ROLE_NAME_TIPOSIVA.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildProductosRelatedInstance4TipoIVA(relatedInstanceJsonOid, remainingPath);
        }
        if (ProductosConstants.ROLE_NAME_AESOLICITUDES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildProductosRelatedInstance4Aesolicitudes(relatedInstanceJsonOid, remainingPath);
        }
        if (ProductosConstants.ROLE_NAME_PROTECCIONDATOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildProductosRelatedInstance4ProteccionDatosC(relatedInstanceJsonOid, remainingPath);
        }
        if (ProductosConstants.ROLE_NAME_PROTECCIONESDATOS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildProductosRelatedInstance4ProteccionDatos(relatedInstanceJsonOid, remainingPath);
        }
        if (ProductosConstants.ROLE_NAME_CONTRATOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildProductosRelatedInstance4ContratoC(relatedInstanceJsonOid, remainingPath);
        }
        if (ProductosConstants.ROLE_NAME_MARCAMEDICAC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildProductosRelatedInstance4MarcaMedicaC(relatedInstanceJsonOid, remainingPath);
        }
        if (ProductosConstants.ROLE_NAME_AGENTEXPRODUCTO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildProductosRelatedInstance4AgentexProducto(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildProductosRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new Productos(mapper.readValue(relatedInstanceJsonOid, ProductosOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildProductosRelatedInstance4Planes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Planes(mapper.readValue(relatedInstanceJsonOid, PlanesOid.class)): Planes.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildProductosRelatedInstance4Dominio(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Dominio(mapper.readValue(relatedInstanceJsonOid, DominioOid.class)): Dominio.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildProductosRelatedInstance4Tarifa(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Tarifa(mapper.readValue(relatedInstanceJsonOid, TarifaOid.class)): Tarifa.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildProductosRelatedInstance4GrupoAsociado(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new GrupoAsociado(mapper.readValue(relatedInstanceJsonOid, GrupoAsociadoOid.class)): GrupoAsociado.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildProductosRelatedInstance4TipoIVA(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TipoIVA(mapper.readValue(relatedInstanceJsonOid, TipoIVAOid.class)): TipoIVA.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildProductosRelatedInstance4Aesolicitudes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Aesolicitudes(mapper.readValue(relatedInstanceJsonOid, AesolicitudesOid.class)): Aesolicitudes.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildProductosRelatedInstance4ProteccionDatosC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ProteccionDatosC(mapper.readValue(relatedInstanceJsonOid, ProteccionDatosCOid.class)): ProteccionDatosC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildProductosRelatedInstance4ProteccionDatos(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ProteccionDatos(mapper.readValue(relatedInstanceJsonOid, ProteccionDatosOid.class)): ProteccionDatos.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildProductosRelatedInstance4ContratoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ContratoC(mapper.readValue(relatedInstanceJsonOid, ContratoCOid.class)): ContratoC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildProductosRelatedInstance4MarcaMedicaC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new MarcaMedicaC(mapper.readValue(relatedInstanceJsonOid, MarcaMedicaCOid.class)): MarcaMedicaC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildProductosRelatedInstance4AgentexProducto(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new AgentexProducto(mapper.readValue(relatedInstanceJsonOid, AgentexProductoOid.class)): AgentexProducto.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ProductosOid oid = new ProductosOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ProductosConstants.ATTR_FIELD_PRODUCTOSPRODUCTO, Constants.Type.INT.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getProductosProducto(), Constants.Type.INT.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(ProductosService.class).error(e.getMessage());
        }
    }

}
