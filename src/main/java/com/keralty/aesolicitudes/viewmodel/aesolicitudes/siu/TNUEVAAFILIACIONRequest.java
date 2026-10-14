package com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.AesolicitudesConstants;
import com.keralty.aesolicitudes.persistence.Asesor;
import com.keralty.aesolicitudes.persistence.GrupoAsociado;
import com.keralty.aesolicitudes.persistence.oid.AsesorOid;
import com.keralty.aesolicitudes.persistence.oid.GrupoAsociadoOid;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.Planes;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.Prorrateo;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.persistence.TipoFactura;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TNUEVAAFILIACIONRequest {

    @JsonProperty("pt_p_agrproducto_json")
    private String aesolicitudesTNUEVAAFILIACIONptpagrProducto;
    
    @JsonIgnore
    private Productos aesolicitudesTNUEVAAFILIACIONptpagrProductoInstance;

    @JsonProperty("pt_p_agrplan_json")
    private String aesolicitudesTNUEVAAFILIACIONptpagrPlan;
    
    @JsonIgnore
    private Planes aesolicitudesTNUEVAAFILIACIONptpagrPlanInstance;

    @JsonProperty("pt_protecciondatos_oid")
    private ProteccionDatosOid aesolicitudesTNUEVAAFILIACIONptProteccionDatos;
    
    @JsonIgnore
    private ProteccionDatos aesolicitudesTNUEVAAFILIACIONptProteccionDatosInstance;

    @JsonProperty("pt_p_agrgrupoasociado_oid")
    private GrupoAsociadoOid aesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociado;
    
    @JsonIgnore
    private GrupoAsociado aesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociadoInstance;

    @JsonProperty("pt_p_atrfiniciocontrato")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date aesolicitudesTNUEVAAFILIACIONptpatrFInicioContrato;

    @JsonProperty("pt_p_atrestraslado")
    private Boolean aesolicitudesTNUEVAAFILIACIONptpatrEsTraslado;

    @JsonProperty("pdirector_oid")
    private AsesorOid aesolicitudesTNUEVAAFILIACIONpDirector;
    
    @JsonIgnore
    private Asesor aesolicitudesTNUEVAAFILIACIONpDirectorInstance;

    @JsonProperty("ptprorrateo_json")
    private String aesolicitudesTNUEVAAFILIACIONptProrrateo;
    
    @JsonIgnore
    private Prorrateo aesolicitudesTNUEVAAFILIACIONptProrrateoInstance;

    @JsonProperty("pttipofactura_json")
    private String aesolicitudesTNUEVAAFILIACIONptTipoFactura;
    
    @JsonIgnore
    private TipoFactura aesolicitudesTNUEVAAFILIACIONptTipoFacturaInstance;

    @JsonProperty("ptmarcacarnet")
    private Boolean aesolicitudesTNUEVAAFILIACIONptMarcaCarnet;

    @JsonProperty("ptavisomarcacarnet")
    private String aesolicitudesTNUEVAAFILIACIONptAvisoMarcaCarnet;

    @JsonProperty("ptsolodiauno")
    private Boolean aesolicitudesTNUEVAAFILIACIONptSoloDiaUno;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkAesolicitudesTNUEVAAFILIACIONptpagrProducto();
        checkAesolicitudesTNUEVAAFILIACIONptpagrPlan();
        checkAesolicitudesTNUEVAAFILIACIONptProteccionDatos();
        checkAesolicitudesTNUEVAAFILIACIONptpatrEsTraslado();
        checkAesolicitudesTNUEVAAFILIACIONpDirector();
        checkAesolicitudesTNUEVAAFILIACIONptTipoFactura();
        checkAesolicitudesTNUEVAAFILIACIONptMarcaCarnet();
        checkAesolicitudesTNUEVAAFILIACIONptAvisoMarcaCarnet();
        checkAesolicitudesTNUEVAAFILIACIONptSoloDiaUno();
    }

    @JsonIgnore
    public String getAesolicitudesTNUEVAAFILIACIONptpagrProducto() {
        return this.aesolicitudesTNUEVAAFILIACIONptpagrProducto;
    }
    
    public void setAesolicitudesTNUEVAAFILIACIONptpagrProducto(String aesolicitudesTNUEVAAFILIACIONptpagrProducto) {
        this.aesolicitudesTNUEVAAFILIACIONptpagrProducto = aesolicitudesTNUEVAAFILIACIONptpagrProducto;
    }

    @JsonIgnore
    public Productos getAesolicitudesTNUEVAAFILIACIONptpagrProductoInstance() {
        return this.aesolicitudesTNUEVAAFILIACIONptpagrProductoInstance;
    }
    
    public void setAesolicitudesTNUEVAAFILIACIONptpagrProductoInstance(Productos aesolicitudesTNUEVAAFILIACIONptpagrProducto) {
        this.aesolicitudesTNUEVAAFILIACIONptpagrProductoInstance = aesolicitudesTNUEVAAFILIACIONptpagrProducto;
        this.aesolicitudesTNUEVAAFILIACIONptpagrProducto = aesolicitudesTNUEVAAFILIACIONptpagrProducto != null ? aesolicitudesTNUEVAAFILIACIONptpagrProducto.getOid().toJson() : "";
    }

    private void checkAesolicitudesTNUEVAAFILIACIONptpagrProducto() throws NotNullArgumentException {
        if(this.getAesolicitudesTNUEVAAFILIACIONptpagrProductoInstance() == null || this.getAesolicitudesTNUEVAAFILIACIONptpagrProductoInstance().isNull()) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_TNUEVAAFILIACION, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPRODUCTO, AesolicitudesConstants.SERV_ALIAS_TNUEVAAFILIACION, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPRODUCTO);
        }
    }

    @JsonIgnore
    public String getAesolicitudesTNUEVAAFILIACIONptpagrPlan() {
        return this.aesolicitudesTNUEVAAFILIACIONptpagrPlan;
    }
    
    public void setAesolicitudesTNUEVAAFILIACIONptpagrPlan(String aesolicitudesTNUEVAAFILIACIONptpagrPlan) {
        this.aesolicitudesTNUEVAAFILIACIONptpagrPlan = aesolicitudesTNUEVAAFILIACIONptpagrPlan;
    }

    @JsonIgnore
    public Planes getAesolicitudesTNUEVAAFILIACIONptpagrPlanInstance() {
        return this.aesolicitudesTNUEVAAFILIACIONptpagrPlanInstance;
    }
    
    public void setAesolicitudesTNUEVAAFILIACIONptpagrPlanInstance(Planes aesolicitudesTNUEVAAFILIACIONptpagrPlan) {
        this.aesolicitudesTNUEVAAFILIACIONptpagrPlanInstance = aesolicitudesTNUEVAAFILIACIONptpagrPlan;
        this.aesolicitudesTNUEVAAFILIACIONptpagrPlan = aesolicitudesTNUEVAAFILIACIONptpagrPlan != null ? aesolicitudesTNUEVAAFILIACIONptpagrPlan.getOid().toJson() : "";
    }

    private void checkAesolicitudesTNUEVAAFILIACIONptpagrPlan() throws NotNullArgumentException {
        if(this.getAesolicitudesTNUEVAAFILIACIONptpagrPlanInstance() == null || this.getAesolicitudesTNUEVAAFILIACIONptpagrPlanInstance().isNull()) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_TNUEVAAFILIACION, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPLAN, AesolicitudesConstants.SERV_ALIAS_TNUEVAAFILIACION, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPLAN);
        }
    }

    @JsonIgnore
    public ProteccionDatosOid getAesolicitudesTNUEVAAFILIACIONptProteccionDatos() {
        return this.aesolicitudesTNUEVAAFILIACIONptProteccionDatos;
    }
    
    public void setAesolicitudesTNUEVAAFILIACIONptProteccionDatos(ProteccionDatosOid aesolicitudesTNUEVAAFILIACIONptProteccionDatos) {
        this.aesolicitudesTNUEVAAFILIACIONptProteccionDatos = aesolicitudesTNUEVAAFILIACIONptProteccionDatos;
    }

    @JsonIgnore
    public ProteccionDatos getAesolicitudesTNUEVAAFILIACIONptProteccionDatosInstance() {
        return this.aesolicitudesTNUEVAAFILIACIONptProteccionDatosInstance;
    }
    
    public void setAesolicitudesTNUEVAAFILIACIONptProteccionDatosInstance(ProteccionDatos aesolicitudesTNUEVAAFILIACIONptProteccionDatos) {
        this.aesolicitudesTNUEVAAFILIACIONptProteccionDatosInstance = aesolicitudesTNUEVAAFILIACIONptProteccionDatos;
        this.aesolicitudesTNUEVAAFILIACIONptProteccionDatos = aesolicitudesTNUEVAAFILIACIONptProteccionDatos != null ? aesolicitudesTNUEVAAFILIACIONptProteccionDatos.getOid() : null;
    }

    private void checkAesolicitudesTNUEVAAFILIACIONptProteccionDatos() throws NotNullArgumentException {
        if(this.getAesolicitudesTNUEVAAFILIACIONptProteccionDatosInstance() == null || this.getAesolicitudesTNUEVAAFILIACIONptProteccionDatosInstance().isNull()) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_TNUEVAAFILIACION, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPROTECCIONDATOS, AesolicitudesConstants.SERV_ALIAS_TNUEVAAFILIACION, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPROTECCIONDATOS);
        }
    }

    @JsonIgnore
    public GrupoAsociadoOid getAesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociado() {
        return this.aesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociado;
    }
    
    public void setAesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociado(GrupoAsociadoOid aesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociado) {
        this.aesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociado = aesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociado;
    }

    @JsonIgnore
    public GrupoAsociado getAesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociadoInstance() {
        return this.aesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociadoInstance;
    }
    
    public void setAesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociadoInstance(GrupoAsociado aesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociado) {
        this.aesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociadoInstance = aesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociado;
        this.aesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociado = aesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociado != null ? aesolicitudesTNUEVAAFILIACIONptpagrGrupoAsociado.getOid() : null;
    }

    @JsonIgnore
    public Date getAesolicitudesTNUEVAAFILIACIONptpatrFInicioContrato() {
        return this.aesolicitudesTNUEVAAFILIACIONptpatrFInicioContrato;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setAesolicitudesTNUEVAAFILIACIONptpatrFInicioContrato(Date aesolicitudesTNUEVAAFILIACIONptpatrFInicioContrato) {
        this.aesolicitudesTNUEVAAFILIACIONptpatrFInicioContrato = aesolicitudesTNUEVAAFILIACIONptpatrFInicioContrato;
    }

    @JsonIgnore
    public Boolean getAesolicitudesTNUEVAAFILIACIONptpatrEsTraslado() {
        return this.aesolicitudesTNUEVAAFILIACIONptpatrEsTraslado;
    }
    
    public void setAesolicitudesTNUEVAAFILIACIONptpatrEsTraslado(Boolean aesolicitudesTNUEVAAFILIACIONptpatrEsTraslado) {
        this.aesolicitudesTNUEVAAFILIACIONptpatrEsTraslado = aesolicitudesTNUEVAAFILIACIONptpatrEsTraslado;
    }

    private void checkAesolicitudesTNUEVAAFILIACIONptpatrEsTraslado() throws NotNullArgumentException {
        if(this.getAesolicitudesTNUEVAAFILIACIONptpatrEsTraslado() == null) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_TNUEVAAFILIACION, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPATRESTRASLADO, AesolicitudesConstants.SERV_ALIAS_TNUEVAAFILIACION, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPATRESTRASLADO);
        }
    }

    @JsonIgnore
    public AsesorOid getAesolicitudesTNUEVAAFILIACIONpDirector() {
        return this.aesolicitudesTNUEVAAFILIACIONpDirector;
    }
    
    public void setAesolicitudesTNUEVAAFILIACIONpDirector(AsesorOid aesolicitudesTNUEVAAFILIACIONpDirector) {
        this.aesolicitudesTNUEVAAFILIACIONpDirector = aesolicitudesTNUEVAAFILIACIONpDirector;
    }

    @JsonIgnore
    public Asesor getAesolicitudesTNUEVAAFILIACIONpDirectorInstance() {
        return this.aesolicitudesTNUEVAAFILIACIONpDirectorInstance;
    }
    
    public void setAesolicitudesTNUEVAAFILIACIONpDirectorInstance(Asesor aesolicitudesTNUEVAAFILIACIONpDirector) {
        this.aesolicitudesTNUEVAAFILIACIONpDirectorInstance = aesolicitudesTNUEVAAFILIACIONpDirector;
        this.aesolicitudesTNUEVAAFILIACIONpDirector = aesolicitudesTNUEVAAFILIACIONpDirector != null ? aesolicitudesTNUEVAAFILIACIONpDirector.getOid() : null;
    }

    private void checkAesolicitudesTNUEVAAFILIACIONpDirector() throws NotNullArgumentException {
        if(this.getAesolicitudesTNUEVAAFILIACIONpDirectorInstance() == null || this.getAesolicitudesTNUEVAAFILIACIONpDirectorInstance().isNull()) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_TNUEVAAFILIACION, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPDIRECTOR, AesolicitudesConstants.SERV_ALIAS_TNUEVAAFILIACION, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPDIRECTOR);
        }
    }

    @JsonIgnore
    public String getAesolicitudesTNUEVAAFILIACIONptProrrateo() {
        return this.aesolicitudesTNUEVAAFILIACIONptProrrateo;
    }
    
    public void setAesolicitudesTNUEVAAFILIACIONptProrrateo(String aesolicitudesTNUEVAAFILIACIONptProrrateo) {
        this.aesolicitudesTNUEVAAFILIACIONptProrrateo = aesolicitudesTNUEVAAFILIACIONptProrrateo;
    }

    @JsonIgnore
    public Prorrateo getAesolicitudesTNUEVAAFILIACIONptProrrateoInstance() {
        return this.aesolicitudesTNUEVAAFILIACIONptProrrateoInstance;
    }
    
    public void setAesolicitudesTNUEVAAFILIACIONptProrrateoInstance(Prorrateo aesolicitudesTNUEVAAFILIACIONptProrrateo) {
        this.aesolicitudesTNUEVAAFILIACIONptProrrateoInstance = aesolicitudesTNUEVAAFILIACIONptProrrateo;
        this.aesolicitudesTNUEVAAFILIACIONptProrrateo = aesolicitudesTNUEVAAFILIACIONptProrrateo != null ? aesolicitudesTNUEVAAFILIACIONptProrrateo.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getAesolicitudesTNUEVAAFILIACIONptTipoFactura() {
        return this.aesolicitudesTNUEVAAFILIACIONptTipoFactura;
    }
    
    public void setAesolicitudesTNUEVAAFILIACIONptTipoFactura(String aesolicitudesTNUEVAAFILIACIONptTipoFactura) {
        this.aesolicitudesTNUEVAAFILIACIONptTipoFactura = aesolicitudesTNUEVAAFILIACIONptTipoFactura;
    }

    @JsonIgnore
    public TipoFactura getAesolicitudesTNUEVAAFILIACIONptTipoFacturaInstance() {
        return this.aesolicitudesTNUEVAAFILIACIONptTipoFacturaInstance;
    }
    
    public void setAesolicitudesTNUEVAAFILIACIONptTipoFacturaInstance(TipoFactura aesolicitudesTNUEVAAFILIACIONptTipoFactura) {
        this.aesolicitudesTNUEVAAFILIACIONptTipoFacturaInstance = aesolicitudesTNUEVAAFILIACIONptTipoFactura;
        this.aesolicitudesTNUEVAAFILIACIONptTipoFactura = aesolicitudesTNUEVAAFILIACIONptTipoFactura != null ? aesolicitudesTNUEVAAFILIACIONptTipoFactura.getOid().toJson() : "";
    }

    private void checkAesolicitudesTNUEVAAFILIACIONptTipoFactura() throws NotNullArgumentException {
        if(this.getAesolicitudesTNUEVAAFILIACIONptTipoFacturaInstance() == null || this.getAesolicitudesTNUEVAAFILIACIONptTipoFacturaInstance().isNull()) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_TNUEVAAFILIACION, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTTIPOFACTURA, AesolicitudesConstants.SERV_ALIAS_TNUEVAAFILIACION, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTTIPOFACTURA);
        }
    }

    @JsonIgnore
    public Boolean getAesolicitudesTNUEVAAFILIACIONptMarcaCarnet() {
        return this.aesolicitudesTNUEVAAFILIACIONptMarcaCarnet;
    }
    
    public void setAesolicitudesTNUEVAAFILIACIONptMarcaCarnet(Boolean aesolicitudesTNUEVAAFILIACIONptMarcaCarnet) {
        this.aesolicitudesTNUEVAAFILIACIONptMarcaCarnet = aesolicitudesTNUEVAAFILIACIONptMarcaCarnet;
    }

    private void checkAesolicitudesTNUEVAAFILIACIONptMarcaCarnet() throws NotNullArgumentException {
        if(this.getAesolicitudesTNUEVAAFILIACIONptMarcaCarnet() == null) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_TNUEVAAFILIACION, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTMARCACARNET, AesolicitudesConstants.SERV_ALIAS_TNUEVAAFILIACION, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTMARCACARNET);
        }
    }

    @JsonIgnore
    public String getAesolicitudesTNUEVAAFILIACIONptAvisoMarcaCarnet() {
        return this.aesolicitudesTNUEVAAFILIACIONptAvisoMarcaCarnet;
    }
    
    public void setAesolicitudesTNUEVAAFILIACIONptAvisoMarcaCarnet(String aesolicitudesTNUEVAAFILIACIONptAvisoMarcaCarnet) {
        this.aesolicitudesTNUEVAAFILIACIONptAvisoMarcaCarnet = aesolicitudesTNUEVAAFILIACIONptAvisoMarcaCarnet;
    }

    private void checkAesolicitudesTNUEVAAFILIACIONptAvisoMarcaCarnet() throws NotNullArgumentException {
        if(this.getAesolicitudesTNUEVAAFILIACIONptAvisoMarcaCarnet() == null) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_TNUEVAAFILIACION, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTAVISOMARCACARNET, AesolicitudesConstants.SERV_ALIAS_TNUEVAAFILIACION, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTAVISOMARCACARNET);
        }
    }

    @JsonIgnore
    public Boolean getAesolicitudesTNUEVAAFILIACIONptSoloDiaUno() {
        return this.aesolicitudesTNUEVAAFILIACIONptSoloDiaUno;
    }
    
    public void setAesolicitudesTNUEVAAFILIACIONptSoloDiaUno(Boolean aesolicitudesTNUEVAAFILIACIONptSoloDiaUno) {
        this.aesolicitudesTNUEVAAFILIACIONptSoloDiaUno = aesolicitudesTNUEVAAFILIACIONptSoloDiaUno;
    }

    private void checkAesolicitudesTNUEVAAFILIACIONptSoloDiaUno() throws NotNullArgumentException {
        if(this.getAesolicitudesTNUEVAAFILIACIONptSoloDiaUno() == null) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_TNUEVAAFILIACION, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTSOLODIAUNO, AesolicitudesConstants.SERV_ALIAS_TNUEVAAFILIACION, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTSOLODIAUNO);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
