package com.keralty.aesolicitudes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aesolicitudes.exception.ModelException;
import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.AesolicitudesConstants;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.GrupoAsociadoConstants;
import com.keralty.aesolicitudes.global.PlanesConstants;
import com.keralty.aesolicitudes.global.ProductosConstants;
import com.keralty.aesolicitudes.global.STDFunctions;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.GrupoAsociado;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.GrupoAsociadoOid;
import com.keralty.aesolicitudes.persistence.oid.PlanesOid;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudNovedadOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Planes;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;
import com.keralty.aesolicitudes.repository.GrupoAsociadoJpaRepository;
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
public class GrupoAsociadoService extends AbstractService {

    GrupoAsociadoJpaRepository repository;

    GrupoAsociadoService grupoAsociadoSrv;

    SolicitudService solicitudSrv;

    ProductosService productosSrv;

    PlanesService planesSrv;

    ContratoCService contratoCSrv;

    SolicitudNovedadService solicitudNovedadSrv;

    @Inject
    public GrupoAsociadoService(
            GrupoAsociadoService grupoAsociadoSrv,
            SolicitudService solicitudSrv,
            ProductosService productosSrv,
            PlanesService planesSrv,
            ContratoCService contratoCSrv,
            SolicitudNovedadService solicitudNovedadSrv,
            GrupoAsociadoJpaRepository repository) {
        this.grupoAsociadoSrv = grupoAsociadoSrv;
        this.solicitudSrv = solicitudSrv;
        this.productosSrv = productosSrv;
        this.planesSrv = planesSrv;
        this.contratoCSrv = contratoCSrv;
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, GrupoAsociadoConstants.CLASS_NAME);
    }

    private List<GrupoAsociado> solveGrupoAsociadoTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, GrupoAsociadoConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveGrupoAsociadoTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, GrupoAsociadoConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class GrupoAsociado
     *
     * @return Population of class GrupoAsociado
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<GrupoAsociado> get() {
        List<GrupoAsociado> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class GrupoAsociado
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class GrupoAsociado
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<GrupoAsociado> instances = get(queryRequest);
        if(GrupoAsociadoConstants.DSICGRUPOASOCIADO.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICGrupoAsociado())).collect(Collectors.toList());
        }
        if(GrupoAsociadoConstants.DSDSGRUPOASOCIADOPIU.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSGrupoAsociadoPIU())).collect(Collectors.toList());
        }
        if(GrupoAsociadoConstants.DSDSGRUPOASOCIADOPIUBUSQUEDA.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSGrupoAsociadoPIUBusqueda())).collect(Collectors.toList());
        }
        return results;
    }

    /*
     * Gets the properties of DisplaySet ICGrupoAsociado for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet ICGrupoAsociado for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aesolicitudes.viewmodel.grupoasociado.ds.ICGrupoAsociado getICGrupoAsociado(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        GrupoAsociado instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.keralty.aesolicitudes.viewmodel.grupoasociado.ds.ICGrupoAsociado(instance);
    }

    /*
     * Gets the properties of DisplaySet DSGrupoAsociadoPIU for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSGrupoAsociadoPIU for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aesolicitudes.viewmodel.grupoasociado.ds.DSGrupoAsociadoPIU getDSGrupoAsociadoPIU(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        GrupoAsociado instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.keralty.aesolicitudes.viewmodel.grupoasociado.ds.DSGrupoAsociadoPIU(instance);
    }

    /*
     * Gets the properties of DisplaySet DSGrupoAsociadoPIUBusqueda for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSGrupoAsociadoPIUBusqueda for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aesolicitudes.viewmodel.grupoasociado.ds.DSGrupoAsociadoPIUBusqueda getDSGrupoAsociadoPIUBusqueda(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        GrupoAsociado instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.keralty.aesolicitudes.viewmodel.grupoasociado.ds.DSGrupoAsociadoPIUBusqueda(instance);
    }

    /*
     * Returns the population of class GrupoAsociado that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class GrupoAsociado matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<GrupoAsociado> get(QueryRequest queryRequest) {
        return solveGrupoAsociadoTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveGrupoAsociadoTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveGrupoAsociadoTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveGrupoAsociadoTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveGrupoAsociadoTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of GrupoAsociado by ID
     *
     * @param grupoAsociadoCodigo Identification field grupoAsociadoCodigo
     *
     * @return Instance of GrupoAsociado
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public GrupoAsociado getById(Long grupoAsociadoCodigo) {
        return getByOID(new GrupoAsociadoOid(grupoAsociadoCodigo));
    }
    
    /*
     * Returns an instance of GrupoAsociado by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of GrupoAsociado
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public GrupoAsociado getByOID(GrupoAsociadoOid oid) {
        Optional<GrupoAsociado> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of GrupoAsociado by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of GrupoAsociado
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public GrupoAsociado getByOIDWithHV(GrupoAsociadoOid oid) {
        Optional<GrupoAsociado> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<GrupoAsociado> getInstanceByOid(GrupoAsociadoOid oid) {
        return oid != null && oid.getGrupoAsociadoCodigo() != null
               ? repository.findById(oid.getGrupoAsociadoCodigo())
               : Optional.empty();
    }

    /*
     * Returns an instance of GrupoAsociado by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of GrupoAsociado
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public GrupoAsociado getByJsonOid(String jsonOid) {
        GrupoAsociadoOid oid = new GrupoAsociadoOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of GrupoAsociado related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of GrupoAsociado
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<GrupoAsociado> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveGrupoAsociadoTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of GrupoAsociado related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of GrupoAsociado
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<GrupoAsociado> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of GrupoAsociado
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of GrupoAsociado
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getGrupoAsociadoDynamic(GrupoAsociadoOid oid, String displaySetItems) {
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
    public String getSuppInfo(GrupoAsociadoOid oid, String dsName) {
        GrupoAsociado instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(GrupoAsociado instance, String dsName) {
        if (GrupoAsociadoConstants.DSICGRUPOASOCIADO.equals(dsName))
            return instance.buildICGrupoAsociado();
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(GrupoAsociado instance, String dsName) {
        if (GrupoAsociadoConstants.DSICGRUPOASOCIADO.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICGrupoAsociado());
        if (GrupoAsociadoConstants.DSDSGRUPOASOCIADOPIU.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSGrupoAsociadoPIU());
        if (GrupoAsociadoConstants.DSDSGRUPOASOCIADOPIUBUSQUEDA.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSGrupoAsociadoPIUBusqueda());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (GrupoAsociadoConstants.FILTER_NAME_FGRUPOASOCIADOVARIOS.equalsIgnoreCase(filterRequest.getName()))
            fGrupoAsociadoVarios(filterRequest, sql);
        if (GrupoAsociadoConstants.FILTER_NAME_IFGRUPOASOCIADOCODIGOLEGAL.equalsIgnoreCase(filterRequest.getName()))
            iFGrupoAsociadoCodigoLegal(filterRequest, sql);
        if (GrupoAsociadoConstants.FILTER_NAME_FGRUPOASOCIADOBUSQUEDA.equalsIgnoreCase(filterRequest.getName()))
            fGrupoAsociadoBusqueda(filterRequest, sql);
    }

    @Override
    protected void applyNavigationalFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if ("Ae_solicitudes_TNUEVAAFILIACION_pt_p_agrGrupoAsociado_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431956094976663FiltNav4(filterRequest, sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_GrupoAsociado".equals(filterRequest.getName()))
            suppInfo4ICGrupoAsociado(filterRequest.getFilterVariable("searchText").toString(), sql);
    }


    private void fGrupoAsociadoVarios(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Productos voProducto = filterRequest.hasFilterVariable(GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOVARIOS_VOPRODUCTO) ? productosSrv.getByOID(new ProductosOid().fromJsonString(toJson(filterRequest.getFilterVariable(GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOVARIOS_VOPRODUCTO)))) : null;
        Planes voPlan = filterRequest.hasFilterVariable(GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOVARIOS_VOPLAN) ? planesSrv.getByOID(new PlanesOid().fromJsonString(toJson(filterRequest.getFilterVariable(GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOVARIOS_VOPLAN)))) : null;
        Date vFIni = filterRequest.hasFilterVariable(GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOVARIOS_VFINI) ? (Date) filterRequest.getFilterVariable(GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOVARIOS_VFINI, FilterVariableRequest.DATE) : null;
        Date vFFin = filterRequest.hasFilterVariable(GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOVARIOS_VFFIN) ? (Date) filterRequest.getFilterVariable(GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOVARIOS_VFFIN, FilterVariableRequest.DATE) : null;

        // ProductoT = voProducto
        if (voProducto != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(GrupoAsociadoConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOVARIOS_VOPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, voProducto.getOid(), GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOVARIOS_VOPRODUCTO);
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        // PlanT = voPlan
        if (voPlan != null) {
            // '=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(GrupoAsociadoConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOVARIOS_VOPLAN, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, voPlan.getOid(), GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOVARIOS_VOPLAN);
            comparison2.setSecondOperand(operand224);
            conjunction.addOperand(comparison2);

        }        

        // FIniVigencia >= vFIni
        if (vFIni != null) {
            // '>=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator(">=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(GrupoAsociadoConstants.ATTR_NAME_GRUPOASOCIADOFINIVIGENCIA, Constants.Type.DATE.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(vFIni, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // FIniVigencia = vFFin
        if (vFFin != null) {
            // '=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(GrupoAsociadoConstants.ATTR_NAME_GRUPOASOCIADOFINIVIGENCIA, Constants.Type.DATE.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(vFFin, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        sql.addConjunction(conjunction);
    }

    private void iFGrupoAsociadoCodigoLegal(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vCodigoLegal = filterRequest.hasFilterVariable(GrupoAsociadoConstants.VAR_NAME_IFGRUPOASOCIADOCODIGOLEGAL_VCODIGOLEGAL) ? (String) filterRequest.getFilterVariable(GrupoAsociadoConstants.VAR_NAME_IFGRUPOASOCIADOCODIGOLEGAL_VCODIGOLEGAL, FilterVariableRequest.STRING) : null;

        // CodigoLegal = vCodigoLegal
        if (vCodigoLegal != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(GrupoAsociadoConstants.ATTR_NAME_GRUPOASOCIADOCODIGOLEGAL, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vCodigoLegal, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    private void fGrupoAsociadoBusqueda(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vCodigoLegal = filterRequest.hasFilterVariable(GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOBUSQUEDA_VCODIGOLEGAL) ? (String) filterRequest.getFilterVariable(GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOBUSQUEDA_VCODIGOLEGAL, FilterVariableRequest.STRING) : null;
        String vDescripcion = filterRequest.hasFilterVariable(GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOBUSQUEDA_VDESCRIPCION) ? (String) filterRequest.getFilterVariable(GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOBUSQUEDA_VDESCRIPCION, FilterVariableRequest.STRING) : null;

        // CodigoLegal LIKE "%" + vCodigoLegal
        if (vCodigoLegal != null) {
            // 'like' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(GrupoAsociadoConstants.ATTR_NAME_GRUPOASOCIADOCODIGOLEGAL, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral("%" + vCodigoLegal, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        // Descripcion LIKE "%" + vDescripcion
        if (vDescripcion != null) {
            // 'like' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(GrupoAsociadoConstants.ATTR_NAME_GRUPOASOCIADODESCRIPCION, Constants.Type.STRING.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            comparison2.setSecondOperand(new SQLWhereOperandLiteral("%" + vDescripcion, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison2);

        }        

        sql.addConjunction(conjunction);
    }

    private void clas1431956094976663FiltNav4(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Productos aesolicitudesTNUEVAAFILIACIONptpagrProducto = filterRequest.hasFilterVariable(AesolicitudesConstants.ARG_NAME_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPRODUCTO) ? productosSrv.getByOID(new ProductosOid().fromJsonString(toJson(filterRequest.getFilterVariable(AesolicitudesConstants.ARG_NAME_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPRODUCTO)))) : null;
        Planes aesolicitudesTNUEVAAFILIACIONptpagrPlan = filterRequest.hasFilterVariable(AesolicitudesConstants.ARG_NAME_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPLAN) ? planesSrv.getByOID(new PlanesOid().fromJsonString(toJson(filterRequest.getFilterVariable(AesolicitudesConstants.ARG_NAME_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPLAN)))) : null;

        // ProductoT = ptpagrProducto
        if (aesolicitudesTNUEVAAFILIACIONptpagrProducto != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(GrupoAsociadoConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(AesolicitudesConstants.ARG_NAME_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, aesolicitudesTNUEVAAFILIACIONptpagrProducto.getOid(), AesolicitudesConstants.ARG_NAME_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPRODUCTO);
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        // PlanT = ptpagrPlan
        if (aesolicitudesTNUEVAAFILIACIONptpagrPlan != null) {
            // '=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(GrupoAsociadoConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(AesolicitudesConstants.ARG_NAME_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPLAN, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, aesolicitudesTNUEVAAFILIACIONptpagrPlan.getOid(), AesolicitudesConstants.ARG_NAME_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPLAN);
            comparison2.setSecondOperand(operand224);
            conjunction.addOperand(comparison2);

        }        

        // systemDate() >= FIniVigencia
        // '>=' Comparison
        SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
        comparison3.setOperator(">=");
        
        // Operand 1
                if (STDFunctions.systemDateFun() != null) {
                    comparison3.setFirstOperand(new SQLWhereOperandLiteral(STDFunctions.systemDateFun(), Constants.Type.DATE.getTypeName()));
                } else {
                    comparison3.setFirstOperand(new SQLWhereOperandNull());
                    }
        
        // Operand 2
        SQLWhereOperandPathAttribute operand225 = new SQLWhereOperandPathAttribute(GrupoAsociadoConstants.ATTR_NAME_GRUPOASOCIADOFINIVIGENCIA, Constants.Type.DATE.getTypeName());
        comparison3.setSecondOperand(operand225);
        conjunction.addOperand(comparison3);


        // systemDate() <= FFinVigencia
        // '<=' Comparison
        SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
        comparison4.setOperator("<=");
        
        // Operand 1
                if (STDFunctions.systemDateFun() != null) {
                    comparison4.setFirstOperand(new SQLWhereOperandLiteral(STDFunctions.systemDateFun(), Constants.Type.DATE.getTypeName()));
                } else {
                    comparison4.setFirstOperand(new SQLWhereOperandNull());
                    }
        
        // Operand 2
        SQLWhereOperandPathAttribute operand226 = new SQLWhereOperandPathAttribute(GrupoAsociadoConstants.ATTR_NAME_GRUPOASOCIADOFFINVIGENCIA, Constants.Type.DATE.getTypeName());
        comparison4.setSecondOperand(operand226);
        conjunction.addOperand(comparison4);

        sql.addConjunction(conjunction);
    }

    // IIU Methods


    /*
     * Solves the query needed for PIUGrupoAsociado
     *
     * @param queryRequest Query request
     * @return List of viewmodels for GrupoAsociado using displayset DSGrupoAsociadoPIU that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aesolicitudes.viewmodel.grupoasociado.ds.DSGrupoAsociadoPIU> piuPIUGrupoAsociado(QueryRequest queryRequest) {
        return solveGrupoAsociadoTypedQuery(queryRequest).stream()
                .map(com.keralty.aesolicitudes.viewmodel.grupoasociado.ds.DSGrupoAsociadoPIU::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUGrupoAsociado
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUGrupoAsociado
     */
    public int getCount4PIUGrupoAsociado(QueryRequest queryRequest) {
        return solveGrupoAsociadoTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUGrupoAsociadoBusqueda
     *
     * @param queryRequest Query request
     * @return List of viewmodels for GrupoAsociado using displayset DSGrupoAsociadoPIUBusqueda that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aesolicitudes.viewmodel.grupoasociado.ds.DSGrupoAsociadoPIUBusqueda> piuPIUGrupoAsociadoBusqueda(QueryRequest queryRequest) {
        return solveGrupoAsociadoTypedQuery(queryRequest).stream()
                .map(com.keralty.aesolicitudes.viewmodel.grupoasociado.ds.DSGrupoAsociadoPIUBusqueda::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUGrupoAsociadoBusqueda
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUGrupoAsociadoBusqueda
     */
    public int getCount4PIUGrupoAsociadoBusqueda(QueryRequest queryRequest) {
        return solveGrupoAsociadoTypedQuery(queryRequest).size();
    }

    // Service: InsGrupoAsociadoSolicitud

    /*
     * Entry point for service InsGrupoAsociadoSolicitud
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insGrupoAsociadoSolicitud(
            com.keralty.aesolicitudes.viewmodel.grupoasociado.siu.InsGrupoAsociadoSolicitudRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = grupoAsociadoSrv.insGrupoAsociadoSolicitudTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsGrupoAsociadoSolicitud
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insGrupoAsociadoSolicitudTxn(
            com.keralty.aesolicitudes.viewmodel.grupoasociado.siu.InsGrupoAsociadoSolicitudRequest request) throws ModelException {
        request.setGrupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociadoInstance(grupoAsociadoSrv.getByOIDWithHV(request.getGrupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociado()));
        request.setGrupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getGrupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitud()));
        return grupoAsociadoSrv.insGrupoAsociadoSolicitudImplementation(request, true);
    }

    /*
     * Implements service InsGrupoAsociadoSolicitud
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insGrupoAsociadoSolicitudImplementation(
            com.keralty.aesolicitudes.viewmodel.grupoasociado.siu.InsGrupoAsociadoSolicitudRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        GrupoAsociado grupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociado = request.getGrupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociadoInstance();
        Solicitud grupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitud = request.getGrupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitudInstance();

        request.checkArguments();
        GrupoAsociado instance = grupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociado;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.solicitud.siu.InsGrupoAsociadoSolicitudRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.solicitud.siu.InsGrupoAsociadoSolicitudRequest();
            relatedRequest.setSolicitudInsGrupoAsociadoSolicitudpthisSolicitudInstance(grupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitud);
            relatedRequest.setSolicitudInsGrupoAsociadoSolicitudpevcGrupoAsociadoInstance(grupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociado);
            solicitudSrv.insGrupoAsociadoSolicitudImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICGrupoAsociado());

        return response;
    }

    // Service: DelGrupoAsociadoSolicitud

    /*
     * Entry point for service DelGrupoAsociadoSolicitud
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delGrupoAsociadoSolicitud(
            com.keralty.aesolicitudes.viewmodel.grupoasociado.siu.DelGrupoAsociadoSolicitudRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = grupoAsociadoSrv.delGrupoAsociadoSolicitudTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelGrupoAsociadoSolicitud
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delGrupoAsociadoSolicitudTxn(
            com.keralty.aesolicitudes.viewmodel.grupoasociado.siu.DelGrupoAsociadoSolicitudRequest request) throws ModelException {
        request.setGrupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociadoInstance(grupoAsociadoSrv.getByOIDWithHV(request.getGrupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociado()));
        request.setGrupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getGrupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitud()));
        return grupoAsociadoSrv.delGrupoAsociadoSolicitudImplementation(request, true);
    }

    /*
     * Implements service DelGrupoAsociadoSolicitud
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delGrupoAsociadoSolicitudImplementation(
            com.keralty.aesolicitudes.viewmodel.grupoasociado.siu.DelGrupoAsociadoSolicitudRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        GrupoAsociado grupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociado = request.getGrupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociadoInstance();
        Solicitud grupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitud = request.getGrupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitudInstance();

        request.checkArguments();
        GrupoAsociado instance = grupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociado;

        if (isEntryPoint) {
            com.keralty.aesolicitudes.viewmodel.solicitud.siu.DelGrupoAsociadoSolicitudRequest relatedRequest = new com.keralty.aesolicitudes.viewmodel.solicitud.siu.DelGrupoAsociadoSolicitudRequest();
            relatedRequest.setSolicitudDelGrupoAsociadoSolicitudpthisSolicitudInstance(grupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitud);
            relatedRequest.setSolicitudDelGrupoAsociadoSolicitudpevcGrupoAsociadoInstance(grupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociado);
            solicitudSrv.delGrupoAsociadoSolicitudImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICGrupoAsociado());

        return response;
    }


    private void suppInfo4ICGrupoAsociado(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(GrupoAsociadoConstants.ATTR_NAME_GRUPOASOCIADOCODIGOLEGAL, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison1);

            SQLWhereComparison comparison2 = new SQLWhereComparison(select);
            comparison2.setOperator("LIKE");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(GrupoAsociadoConstants.ATTR_NAME_GRUPOASOCIADODESCRIPCION, Constants.Type.STRING.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison2);

            SQLWhereConjunction conjunction = new SQLWhereConjunction();
            conjunction.addDisjunction(disjunction);
            select.addConjunction(conjunction);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyOCOCGrupoAsociado(queryRequest, select);
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(GrupoAsociadoConstants.CLASS_NAME, GrupoAsociadoConstants.ATTR_FIELD_GRUPOASOCIADOCODIGO, false), true);
    }


    private void applyOCOCGrupoAsociado(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_GrupoAsociado".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(GrupoAsociadoConstants.CLASS_NAME, GrupoAsociadoConstants.ATTR_NAME_GRUPOASOCIADOCODIGOLEGAL, false), true);
            select.getOrderByPart().addItem(Constants.normalizePath(GrupoAsociadoConstants.CLASS_NAME, GrupoAsociadoConstants.ATTR_NAME_GRUPOASOCIADODESCRIPCION, false), true);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildGrupoAsociadoRelatedInstance(relatedInstanceJsonOid);
        }
        if (GrupoAsociadoConstants.ROLE_NAME_SOLICITUDES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGrupoAsociadoRelatedInstance4Solicitud(relatedInstanceJsonOid, remainingPath);
        }
        if (GrupoAsociadoConstants.ROLE_NAME_CONTRATOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGrupoAsociadoRelatedInstance4ContratoC(relatedInstanceJsonOid, remainingPath);
        }
        if (GrupoAsociadoConstants.ROLE_NAME_SOLICITUDESNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGrupoAsociadoRelatedInstance4SolicitudNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (GrupoAsociadoConstants.ROLE_NAME_PRODUCTOT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGrupoAsociadoRelatedInstance4Productos(relatedInstanceJsonOid, remainingPath);
        }
        if (GrupoAsociadoConstants.ROLE_NAME_PLANT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGrupoAsociadoRelatedInstance4Planes(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildGrupoAsociadoRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new GrupoAsociado(mapper.readValue(relatedInstanceJsonOid, GrupoAsociadoOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildGrupoAsociadoRelatedInstance4Solicitud(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Solicitud(mapper.readValue(relatedInstanceJsonOid, SolicitudOid.class)): Solicitud.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildGrupoAsociadoRelatedInstance4ContratoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ContratoC(mapper.readValue(relatedInstanceJsonOid, ContratoCOid.class)): ContratoC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildGrupoAsociadoRelatedInstance4SolicitudNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class)): SolicitudNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildGrupoAsociadoRelatedInstance4Productos(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Productos(mapper.readValue(relatedInstanceJsonOid, ProductosOid.class)): Productos.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildGrupoAsociadoRelatedInstance4Planes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Planes(mapper.readValue(relatedInstanceJsonOid, PlanesOid.class)): Planes.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            GrupoAsociadoOid oid = new GrupoAsociadoOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(GrupoAsociadoConstants.ATTR_FIELD_GRUPOASOCIADOCODIGO, Constants.Type.INT.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getGrupoAsociadoCodigo(), Constants.Type.INT.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(GrupoAsociadoService.class).error(e.getMessage());
        }
    }

}
