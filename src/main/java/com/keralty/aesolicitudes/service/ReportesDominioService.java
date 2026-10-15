package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.AesolicitudesConstants;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.DominioConstants;
import com.keralty.aesolicitudes.global.PlanesConstants;
import com.keralty.aesolicitudes.global.PlantillaReporteConstants;
import com.keralty.aesolicitudes.global.ProductosConstants;
import com.keralty.aesolicitudes.global.ReportesDominioConstants;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.global.SolicitudNovedadConstants;
import com.keralty.aesolicitudes.global.STDFunctions;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.Dominio;
import com.keralty.aesolicitudes.persistence.oid.DominioOid;
import com.keralty.aesolicitudes.persistence.oid.PlantillaReporteOid;
import com.keralty.aesolicitudes.persistence.oid.ReportesDominioOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudNovedadOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.PlantillaReporte;
import com.keralty.aesolicitudes.persistence.ReportesDominio;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;
import com.keralty.aesolicitudes.repository.ReportesDominioJpaRepository;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLWhereComparison;
import com.keralty.aesolicitudes.sqlutils.SQLWhereConjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereDisjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandNull;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathInstance;
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
public class ReportesDominioService extends AbstractService {

    ReportesDominioJpaRepository repository;

    ReportesDominioService reportesDominioSrv;

    SolicitudService solicitudSrv;

    SolicitudNovedadService solicitudNovedadSrv;

    DominioService dominioSrv;

    PlantillaReporteService plantillaReporteSrv;

    @Inject
    public ReportesDominioService(
            ReportesDominioService reportesDominioSrv,
            SolicitudService solicitudSrv,
            SolicitudNovedadService solicitudNovedadSrv,
            DominioService dominioSrv,
            PlantillaReporteService plantillaReporteSrv,
            ReportesDominioJpaRepository repository) {
        this.reportesDominioSrv = reportesDominioSrv;
        this.solicitudSrv = solicitudSrv;
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.dominioSrv = dominioSrv;
        this.plantillaReporteSrv = plantillaReporteSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, ReportesDominioConstants.CLASS_NAME);
    }

    private List<ReportesDominio> solveReportesDominioTypedQuery(QueryRequest request) {
        boolean hasInMemoryFilters = hasInMemoryFilters(request);
        int requestedPageSize = request.getPageSize();
        int pageSize = requestedPageSize > 0
                && requestedPageSize <= Constants.MAX_BLOCKSIZE
                ? requestedPageSize
                : Constants.DEFAULT_BLOCKSIZE;
        int pageNumber = Math.max(1, request.getPageNumber());

    	List<ReportesDominio> results = repository.solveQuery(processQueryRequest(request, ReportesDominioConstants.CLASS_NAME), (hasInMemoryFilters ? 0 : pageSize), (hasInMemoryFilters ? 1 : pageNumber)).stream()
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
    
    private int solveReportesDominioTypedCountQuery(QueryRequest request) {
        return hasInMemoryFilters(request)
               ? repository.solveQuery(processQueryRequest(request, ReportesDominioConstants.CLASS_NAME)).stream().filter(instance -> applyMemoryFilters(request, instance)).collect(Collectors.toList()).size()
               : repository.solveCountQuery(processCountQueryRequest(request, ReportesDominioConstants.CLASS_NAME));
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
        if (ReportesDominioConstants.FILTER_NAME_FIPARASOLICITUD.equalsIgnoreCase(filterRequest.getName())) {
            return true;
        }
        if (ReportesDominioConstants.FILTER_NAME_FIPARASOLICITUDNOVEDAD.equalsIgnoreCase(filterRequest.getName())) {
            return true;
        }
        return false;
    }

    /*
     * Returns the population of class ReportesDominio
     *
     * @return Population of class ReportesDominio
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ReportesDominio> get() {
        List<ReportesDominio> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class ReportesDominio
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class ReportesDominio
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<ReportesDominio> instances = get(queryRequest);
        if(ReportesDominioConstants.DSDSREPORTESDOMINIO.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSReportesDominio())).collect(Collectors.toList());
        }
        if(ReportesDominioConstants.DSICREPORTESDOMINIO.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICReportesDominio())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class ReportesDominio that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class ReportesDominio matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ReportesDominio> get(QueryRequest queryRequest) {
        return solveReportesDominioTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveReportesDominioTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveReportesDominioTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveReportesDominioTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveReportesDominioTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of ReportesDominio by ID
     *
     * @param dominioNumero Identification field dominioNumero
     *
     * @param plantillaReporteidPlantillaReporte Identification field plantillaReporteidPlantillaReporte
     *
     * @return Instance of ReportesDominio
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ReportesDominio getById(Long dominioNumero, Long plantillaReporteidPlantillaReporte) {
        return getByOID(new ReportesDominioOid(dominioNumero, plantillaReporteidPlantillaReporte));
    }
    
    /*
     * Returns an instance of ReportesDominio by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ReportesDominio
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ReportesDominio getByOID(ReportesDominioOid oid) {
        Optional<ReportesDominio> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of ReportesDominio by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ReportesDominio
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public ReportesDominio getByOIDWithHV(ReportesDominioOid oid) {
        Optional<ReportesDominio> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<ReportesDominio> getInstanceByOid(ReportesDominioOid oid) {
        return oid != null && oid.getDominioNumero() != null
               ? repository.findById(oid)
               : Optional.empty();
    }

    /*
     * Returns an instance of ReportesDominio by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of ReportesDominio
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public ReportesDominio getByJsonOid(String jsonOid) {
        ReportesDominioOid oid = new ReportesDominioOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of ReportesDominio related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ReportesDominio
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ReportesDominio> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveReportesDominioTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of ReportesDominio related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ReportesDominio
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ReportesDominio> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of ReportesDominio
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of ReportesDominio
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getReportesDominioDynamic(ReportesDominioOid oid, String displaySetItems) {
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
    public String getSuppInfo(ReportesDominioOid oid, String dsName) {
        ReportesDominio instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(ReportesDominio instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (ReportesDominioConstants.DSICREPORTESDOMINIO.equals(dsName))
            return instance.buildICReportesDominio();
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(ReportesDominio instance, String dsName) {
        if (ReportesDominioConstants.DSDSREPORTESDOMINIO.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSReportesDominio());
        if (ReportesDominioConstants.DSICREPORTESDOMINIO.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICReportesDominio());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (ReportesDominioConstants.FILTER_NAME_FIPARASOLICITUD.equalsIgnoreCase(filterRequest.getName()))
            fIParaSolicitud(filterRequest, sql);
        if (ReportesDominioConstants.FILTER_NAME_FIPARASOLICITUDNOVEDAD.equalsIgnoreCase(filterRequest.getName()))
            fIParaSolicitudNovedad(filterRequest, sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_ReportesDominio".equals(filterRequest.getName()))
            suppInfo4ICReportesDominio(filterRequest.getFilterVariable("searchText").toString(), sql);
    }

    private boolean applyMemoryFilters(QueryRequest queryRequest, ReportesDominio instance) {
        for (FilterRequest filterRequest : queryRequest.getFilters()) {
            if (!applyMemoryFilter(filterRequest, instance))
                return false;
        }
        return true;
    }
    
    private boolean applyMemoryFilter(FilterRequest filterRequest, ReportesDominio instance) {
        return applyMemoryQueryFilter(filterRequest, instance);
    }

    private boolean applyMemoryQueryFilter(FilterRequest filterRequest, ReportesDominio entity) {
        if (ReportesDominioConstants.FILTER_NAME_FIPARASOLICITUD.equalsIgnoreCase(filterRequest.getName()))
            return inMemoryFIParaSolicitud(filterRequest,  entity);
        if (ReportesDominioConstants.FILTER_NAME_FIPARASOLICITUDNOVEDAD.equalsIgnoreCase(filterRequest.getName()))
            return inMemoryFIParaSolicitudNovedad(filterRequest,  entity);
        return true;
    }


    private void fIParaSolicitud(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Solicitud vfSolicitud = filterRequest.hasFilterVariable(ReportesDominioConstants.VAR_NAME_FIPARASOLICITUD_VFSOLICITUD) ? solicitudSrv.getByOID(new SolicitudOid().fromJsonString(toJson(filterRequest.getFilterVariable(ReportesDominioConstants.VAR_NAME_FIPARASOLICITUD_VFSOLICITUD)))) : null;
        Long vfTipo = filterRequest.hasFilterVariable(ReportesDominioConstants.VAR_NAME_FIPARASOLICITUD_VFTIPO) ? (Long) filterRequest.getFilterVariable(ReportesDominioConstants.VAR_NAME_FIPARASOLICITUD_VFTIPO, FilterVariableRequest.NAT) : null;

        // Dominio.ProductoT = vfSolicitud.Aesolicitudes.ProductoT
        if (vfSolicitud != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            if (vfSolicitud.isNull() || vfSolicitud.getAesolicitudes().getProductoT().isNull())
            {
            comparison1.setSecondOperand(new SQLWhereOperandNull());
            }
            else
            {
            SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(ReportesDominioConstants.VAR_NAME_FIPARASOLICITUD_VFSOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PRODUCTOT, SolicitudConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, vfSolicitud.getOid(), ReportesDominioConstants.VAR_NAME_FIPARASOLICITUD_VFSOLICITUD);
            comparison1.setSecondOperand(operand223);
            }
            conjunction.addOperand(comparison1);

        }        

        // Dominio.PlanT = vfSolicitud.Aesolicitudes.PlanT
        if (vfSolicitud != null) {
            // '=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            if (vfSolicitud.isNull() || vfSolicitud.getAesolicitudes().getPlanT().isNull())
            {
            comparison2.setSecondOperand(new SQLWhereOperandNull());
            }
            else
            {
            SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(ReportesDominioConstants.VAR_NAME_FIPARASOLICITUD_VFSOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ROLE_NAME_PLANT, SolicitudConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, vfSolicitud.getOid(), ReportesDominioConstants.VAR_NAME_FIPARASOLICITUD_VFSOLICITUD);
            comparison2.setSecondOperand(operand224);
            }
            conjunction.addOperand(comparison2);

        }        

        // PlantillaReporte.Tipo = vfTipo
        if (vfTipo != null) {
            // '=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(vfTipo, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // vfSolicitud.Aesolicitudes.Fesolici >= PlantillaReporte.FechaVigencia
        if (vfSolicitud != null) {
            // '>=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator(">=");
            
            // Operand 1
            if (vfSolicitud.getAesolicitudes().getAesolicitudesFesolici()!= null){
            comparison4.setFirstOperand(new SQLWhereOperandLiteral(vfSolicitud.getAesolicitudes().getAesolicitudesFesolici(), Constants.Type.DATE.getTypeName()));
            } else {
            comparison4.setFirstOperand(new SQLWhereOperandNull());
            }
            
            // Operand 2
            SQLWhereOperandPathAttribute operand226 = new SQLWhereOperandPathAttribute(ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
            comparison4.setSecondOperand(operand226);
            conjunction.addOperand(comparison4);

        }        

        sql.addConjunction(conjunction);
    }

    private void fIParaSolicitudNovedad(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        SolicitudNovedad vfSolicitudNovedad = filterRequest.hasFilterVariable(ReportesDominioConstants.VAR_NAME_FIPARASOLICITUDNOVEDAD_VFSOLICITUDNOVEDAD) ? solicitudNovedadSrv.getByOID(new SolicitudNovedadOid().fromJsonString(toJson(filterRequest.getFilterVariable(ReportesDominioConstants.VAR_NAME_FIPARASOLICITUDNOVEDAD_VFSOLICITUDNOVEDAD)))) : null;

        // Dominio.ProductoT = vfSolicitudNovedad.PlanT.ProductoT
        if (vfSolicitudNovedad != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            if (vfSolicitudNovedad.isNull() || vfSolicitudNovedad.getPlanT().getProductoT().isNull())
            {
            comparison1.setSecondOperand(new SQLWhereOperandNull());
            }
            else
            {
            SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(ReportesDominioConstants.VAR_NAME_FIPARASOLICITUDNOVEDAD_VFSOLICITUDNOVEDAD + "." + SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT, SolicitudNovedadConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, vfSolicitudNovedad.getOid(), ReportesDominioConstants.VAR_NAME_FIPARASOLICITUDNOVEDAD_VFSOLICITUDNOVEDAD);
            comparison1.setSecondOperand(operand223);
            }
            conjunction.addOperand(comparison1);

        }        

        // Dominio.PlanT = vfSolicitudNovedad.PlanT
        if (vfSolicitudNovedad != null) {
            // '=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            if (vfSolicitudNovedad.isNull() || vfSolicitudNovedad.getPlanT().isNull())
            {
            comparison2.setSecondOperand(new SQLWhereOperandNull());
            }
            else
            {
            SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(ReportesDominioConstants.VAR_NAME_FIPARASOLICITUDNOVEDAD_VFSOLICITUDNOVEDAD + "." + SolicitudNovedadConstants.ROLE_NAME_PLANT, SolicitudNovedadConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, vfSolicitudNovedad.getOid(), ReportesDominioConstants.VAR_NAME_FIPARASOLICITUDNOVEDAD_VFSOLICITUDNOVEDAD);
            comparison2.setSecondOperand(operand224);
            }
            conjunction.addOperand(comparison2);

        }        

        // PlantillaReporte.Tipo = 12
        // '=' Comparison
        SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
        comparison3.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
        comparison3.setFirstOperand(operand114);
        
        // Operand 2
        comparison3.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(12), Constants.Type.NAT.getTypeName()));
        conjunction.addOperand(comparison3);


        // vfSolicitudNovedad.FechaCreacion >= PlantillaReporte.FechaVigencia
        if (vfSolicitudNovedad != null) {
            // '>=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator(">=");
            
            // Operand 1
            if (vfSolicitudNovedad.getSolicitudNovedadFechaCreacion()!= null){
            comparison4.setFirstOperand(new SQLWhereOperandLiteral(vfSolicitudNovedad.getSolicitudNovedadFechaCreacion(), Constants.Type.DATE.getTypeName()));
            } else {
            comparison4.setFirstOperand(new SQLWhereOperandNull());
            }
            
            // Operand 2
            SQLWhereOperandPathAttribute operand226 = new SQLWhereOperandPathAttribute(ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
            comparison4.setSecondOperand(operand226);
            conjunction.addOperand(comparison4);

        }        

        sql.addConjunction(conjunction);
    }

    private boolean inMemoryFIParaSolicitud(FilterRequest filterRequest, ReportesDominio entity) {
        boolean result = true;
        Solicitud vfSolicitud = filterRequest.hasFilterVariable(ReportesDominioConstants.VAR_NAME_FIPARASOLICITUD_VFSOLICITUD) ? solicitudSrv.getByOID(new SolicitudOid().fromJsonString(toJson(filterRequest.getFilterVariable(ReportesDominioConstants.VAR_NAME_FIPARASOLICITUD_VFSOLICITUD)))) : null;

        // vfSolicitud.Aesolicitudes.Fesolici < drvFechaHasta
        try {
            if (vfSolicitud != null) {
                result = STDFunctions.dateBeforeFun(vfSolicitud.getAesolicitudes().getAesolicitudesFesolici(),entity.getReportesDominiodrvFechaHasta());
            }
        } catch(Exception e) {
           LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
        return result;
    }

    private boolean inMemoryFIParaSolicitudNovedad(FilterRequest filterRequest, ReportesDominio entity) {
        boolean result = true;
        SolicitudNovedad vfSolicitudNovedad = filterRequest.hasFilterVariable(ReportesDominioConstants.VAR_NAME_FIPARASOLICITUDNOVEDAD_VFSOLICITUDNOVEDAD) ? solicitudNovedadSrv.getByOID(new SolicitudNovedadOid().fromJsonString(toJson(filterRequest.getFilterVariable(ReportesDominioConstants.VAR_NAME_FIPARASOLICITUDNOVEDAD_VFSOLICITUDNOVEDAD)))) : null;

        // vfSolicitudNovedad.FechaCreacion < drvFechaHasta
        try {
            if (vfSolicitudNovedad != null) {
                result = STDFunctions.dateBeforeFun(vfSolicitudNovedad.getSolicitudNovedadFechaCreacion(),entity.getReportesDominiodrvFechaHasta());
            }
        } catch(Exception e) {
           LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
        return result;
    }

    // IIU Methods


    /*
     * Solves the query needed for PIUReportesDominio
     *
     * @param queryRequest Query request
     * @return List of viewmodels for ReportesDominio using displayset DSReportesDominio that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aesolicitudes.viewmodel.reportesdominio.ds.DSReportesDominio> piuPIUReportesDominio(QueryRequest queryRequest) {
        return solveReportesDominioTypedQuery(queryRequest).stream()
                .map(com.keralty.aesolicitudes.viewmodel.reportesdominio.ds.DSReportesDominio::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUReportesDominio
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUReportesDominio
     */
    public int getCount4PIUReportesDominio(QueryRequest queryRequest) {
        return solveReportesDominioTypedQuery(queryRequest).size();
    }

    // Service: getDummy

    /*
     * Entry point for service getDummy
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aesolicitudes.viewmodel.reportesdominio.siu.GetDummyResponse getDummy(
            com.keralty.aesolicitudes.viewmodel.reportesdominio.siu.GetDummyRequest request) {
        com.keralty.aesolicitudes.viewmodel.reportesdominio.siu.GetDummyResponse response = new com.keralty.aesolicitudes.viewmodel.reportesdominio.siu.GetDummyResponse();
        try {
            response = reportesDominioSrv.getDummyTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service getDummy
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aesolicitudes.viewmodel.reportesdominio.siu.GetDummyResponse getDummyTxn(
            com.keralty.aesolicitudes.viewmodel.reportesdominio.siu.GetDummyRequest request) throws ModelException {
        request.setReportesDominiogetDummypthisReportesDominioInstance(reportesDominioSrv.getByOIDWithHV(request.getReportesDominiogetDummypthisReportesDominio()));
        return reportesDominioSrv.getDummyImplementation(request);
    }

    /*
     * Implements service getDummy
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aesolicitudes.viewmodel.reportesdominio.siu.GetDummyResponse getDummyImplementation(
            com.keralty.aesolicitudes.viewmodel.reportesdominio.siu.GetDummyRequest request) throws ModelException {
        com.keralty.aesolicitudes.viewmodel.reportesdominio.siu.GetDummyResponse response = new com.keralty.aesolicitudes.viewmodel.reportesdominio.siu.GetDummyResponse();
        ReportesDominio reportesDominiogetDummypthisReportesDominio = request.getReportesDominiogetDummypthisReportesDominioInstance();

        request.checkArguments();
        ReportesDominio instance = reportesDominiogetDummypthisReportesDominio;


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICReportesDominio());

        // Value expressions for outgoing argument 'reportesDominiogetDummyoaReporteDominio'
        // DEFAULT  : THIS
        response.setReportesDominiogetDummyoaReporteDominioInstance(reportesDominiogetDummypthisReportesDominio);


        return response;
    }


    private void suppInfo4ICReportesDominio(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETITULO, Constants.Type.STRING.getTypeName()));
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
        applyOCOCReportesDominio(queryRequest, select);
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(ReportesDominioConstants.CLASS_NAME, ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ATTR_FIELD_DOMINIONUMERO, false), true);
        select.getOrderByPart().addItem(Constants.normalizePath(ReportesDominioConstants.CLASS_NAME, ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_FIELD_PLANTILLAREPORTEIDPLANTILLAREPORTE, false), true);
    }


    private void applyOCOCReportesDominio(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_ReportesDominio".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(ReportesDominioConstants.CLASS_NAME, ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, false), true);
            select.getOrderByPart().addItem(Constants.normalizePath(ReportesDominioConstants.CLASS_NAME, ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, false), true);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildReportesDominioRelatedInstance(relatedInstanceJsonOid);
        }
        if (ReportesDominioConstants.ROLE_NAME_DOMINIO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildReportesDominioRelatedInstance4Dominio(relatedInstanceJsonOid, remainingPath);
        }
        if (ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildReportesDominioRelatedInstance4PlantillaReporte(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildReportesDominioRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new ReportesDominio(mapper.readValue(relatedInstanceJsonOid, ReportesDominioOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildReportesDominioRelatedInstance4Dominio(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Dominio(mapper.readValue(relatedInstanceJsonOid, DominioOid.class)): Dominio.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildReportesDominioRelatedInstance4PlantillaReporte(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new PlantillaReporte(mapper.readValue(relatedInstanceJsonOid, PlantillaReporteOid.class)): PlantillaReporte.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ReportesDominioOid oid = new ReportesDominioOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ATTR_FIELD_DOMINIONUMERO, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getDominioNumero(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_FIELD_PLANTILLAREPORTEIDPLANTILLAREPORTE, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(oid.getPlantillaReporteidPlantillaReporte(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison2);
        } catch (Exception e) {
            LoggerFactory.getLogger(ReportesDominioService.class).error(e.getMessage());
        }
    }

}
