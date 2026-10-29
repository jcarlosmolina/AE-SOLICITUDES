package com.keralty.aesolicitudes.viewmodel.grupoasociado.ds;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.GrupoAsociado;
public class DSGrupoAsociadoPIU {

    @JsonProperty("productot_descripcion")
    private String dSGrupoAsociadoPIUProductoTDotDescripcion;

    @JsonProperty("plant_nombre")
    private String dSGrupoAsociadoPIUPlanTDotNombre;

    @JsonProperty("codigolegal")
    private String dSGrupoAsociadoPIUCodigoLegal;

    @JsonProperty("descripcion")
    private String dSGrupoAsociadoPIUDescripcion;

    @JsonProperty("codtarifacore")
    private String dSGrupoAsociadoPIUCodTarifaCORE;

    @JsonProperty("finivigencia")
    private Date dSGrupoAsociadoPIUFIniVigencia;

    @JsonProperty("ffinvigencia")
    private Date dSGrupoAsociadoPIUFFinVigencia;

    @JsonProperty("estado")
    private Long dSGrupoAsociadoPIUEstado;

    @JsonProperty("disminucioncarencia")
    private Long dSGrupoAsociadoPIUDisminucionCarencia;

    public DSGrupoAsociadoPIU() {
    
    }

    public DSGrupoAsociadoPIU(GrupoAsociado instance) {
        if (instance != null) {
            try {
                this.dSGrupoAsociadoPIUProductoTDotDescripcion = instance.getProductoT().getProductosDescripcion();
                this.dSGrupoAsociadoPIUPlanTDotNombre = instance.getPlanT().getPlanesNombre();
                this.dSGrupoAsociadoPIUCodigoLegal = instance.getGrupoAsociadoCodigoLegal();
                this.dSGrupoAsociadoPIUDescripcion = instance.getGrupoAsociadoDescripcion();
                this.dSGrupoAsociadoPIUCodTarifaCORE = instance.getGrupoAsociadoCodTarifaCORE();
                this.dSGrupoAsociadoPIUFIniVigencia = instance.getGrupoAsociadoFIniVigencia();
                this.dSGrupoAsociadoPIUFFinVigencia = instance.getGrupoAsociadoFFinVigencia();
                this.dSGrupoAsociadoPIUEstado = instance.getGrupoAsociadoEstado();
                this.dSGrupoAsociadoPIUDisminucionCarencia = instance.getGrupoAsociadoDisminucionCarencia();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSGrupoAsociadoPIUProductoTDotDescripcion() {
        return this.dSGrupoAsociadoPIUProductoTDotDescripcion;
    }
    
    public void setDSGrupoAsociadoPIUProductoTDotDescripcion(String dSGrupoAsociadoPIUProductoTDotDescripcion) {
        this.dSGrupoAsociadoPIUProductoTDotDescripcion = dSGrupoAsociadoPIUProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSGrupoAsociadoPIUPlanTDotNombre() {
        return this.dSGrupoAsociadoPIUPlanTDotNombre;
    }
    
    public void setDSGrupoAsociadoPIUPlanTDotNombre(String dSGrupoAsociadoPIUPlanTDotNombre) {
        this.dSGrupoAsociadoPIUPlanTDotNombre = dSGrupoAsociadoPIUPlanTDotNombre;
    }

    @JsonIgnore
    public String getDSGrupoAsociadoPIUCodigoLegal() {
        return this.dSGrupoAsociadoPIUCodigoLegal;
    }
    
    public void setDSGrupoAsociadoPIUCodigoLegal(String dSGrupoAsociadoPIUCodigoLegal) {
        this.dSGrupoAsociadoPIUCodigoLegal = dSGrupoAsociadoPIUCodigoLegal;
    }

    @JsonIgnore
    public String getDSGrupoAsociadoPIUDescripcion() {
        return this.dSGrupoAsociadoPIUDescripcion;
    }
    
    public void setDSGrupoAsociadoPIUDescripcion(String dSGrupoAsociadoPIUDescripcion) {
        this.dSGrupoAsociadoPIUDescripcion = dSGrupoAsociadoPIUDescripcion;
    }

    @JsonIgnore
    public String getDSGrupoAsociadoPIUCodTarifaCORE() {
        return this.dSGrupoAsociadoPIUCodTarifaCORE;
    }
    
    public void setDSGrupoAsociadoPIUCodTarifaCORE(String dSGrupoAsociadoPIUCodTarifaCORE) {
        this.dSGrupoAsociadoPIUCodTarifaCORE = dSGrupoAsociadoPIUCodTarifaCORE;
    }

    @JsonIgnore
    public Date getDSGrupoAsociadoPIUFIniVigencia() {
        return this.dSGrupoAsociadoPIUFIniVigencia;
    }
    
    public void setDSGrupoAsociadoPIUFIniVigencia(Date dSGrupoAsociadoPIUFIniVigencia) {
        this.dSGrupoAsociadoPIUFIniVigencia = dSGrupoAsociadoPIUFIniVigencia;
    }

    @JsonIgnore
    public Date getDSGrupoAsociadoPIUFFinVigencia() {
        return this.dSGrupoAsociadoPIUFFinVigencia;
    }
    
    public void setDSGrupoAsociadoPIUFFinVigencia(Date dSGrupoAsociadoPIUFFinVigencia) {
        this.dSGrupoAsociadoPIUFFinVigencia = dSGrupoAsociadoPIUFFinVigencia;
    }

    @JsonIgnore
    public Long getDSGrupoAsociadoPIUEstado() {
        return this.dSGrupoAsociadoPIUEstado;
    }
    
    public void setDSGrupoAsociadoPIUEstado(Long dSGrupoAsociadoPIUEstado) {
        this.dSGrupoAsociadoPIUEstado = dSGrupoAsociadoPIUEstado;
    }

    @JsonIgnore
    public Long getDSGrupoAsociadoPIUDisminucionCarencia() {
        return this.dSGrupoAsociadoPIUDisminucionCarencia;
    }
    
    public void setDSGrupoAsociadoPIUDisminucionCarencia(Long dSGrupoAsociadoPIUDisminucionCarencia) {
        this.dSGrupoAsociadoPIUDisminucionCarencia = dSGrupoAsociadoPIUDisminucionCarencia;
    }
}
