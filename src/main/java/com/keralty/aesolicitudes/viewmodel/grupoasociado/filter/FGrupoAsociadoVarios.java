package com.keralty.aesolicitudes.viewmodel.grupoasociado.filter;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.oid.PlanesOid;
import com.keralty.aesolicitudes.global.GrupoAsociadoConstants;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;

public class FGrupoAsociadoVarios {

    @JsonProperty("vo_producto")
    private ProductosOid voProducto;

    @JsonProperty("vo_plan")
    private PlanesOid voPlan;

    @JsonProperty("v_fini")
    private Date vFIni;

    @JsonProperty("v_ffin")
    private Date vFFin;

    public FGrupoAsociadoVarios() {
        // Default constructor
    }

    @JsonIgnore
    public ProductosOid getVoProducto() {
        return this.voProducto;
    }
    
    public void setVoProducto(ProductosOid voProducto) {
        this.voProducto = voProducto;
    }

    @JsonIgnore
    public PlanesOid getVoPlan() {
        return this.voPlan;
    }
    
    public void setVoPlan(PlanesOid voPlan) {
        this.voPlan = voPlan;
    }

    @JsonIgnore
    public Date getVFIni() {
        return this.vFIni;
    }
    
    public void setVFIni(Date vFIni) {
        this.vFIni = vFIni;
    }

    @JsonIgnore
    public Date getVFFin() {
        return this.vFFin;
    }
    
    public void setVFFin(Date vFFin) {
        this.vFFin = vFFin;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(GrupoAsociadoConstants.FILTER_NAME_FGRUPOASOCIADOVARIOS);
        filterRequest.addFilterVariable(GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOVARIOS_VOPRODUCTO, voProducto);
        filterRequest.addFilterVariable(GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOVARIOS_VOPLAN, voPlan);
        filterRequest.addFilterVariable(GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOVARIOS_VFINI, vFIni);
        filterRequest.addFilterVariable(GrupoAsociadoConstants.VAR_NAME_FGRUPOASOCIADOVARIOS_VFFIN, vFFin);
        return filterRequest;
    }
}
