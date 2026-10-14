package com.keralty.aesolicitudes.viewmodel.grupoasociado.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.GrupoAsociado;
public class DSGrupoAsociadoPIUBusqueda {

    @JsonProperty("codigolegal")
    private String dSGrupoAsociadoPIUBusquedaCodigoLegal;

    @JsonProperty("descripcion")
    private String dSGrupoAsociadoPIUBusquedaDescripcion;

    public DSGrupoAsociadoPIUBusqueda() {
    
    }

    public DSGrupoAsociadoPIUBusqueda(GrupoAsociado instance) {
        if (instance != null) {
            this.dSGrupoAsociadoPIUBusquedaCodigoLegal = instance.getGrupoAsociadoCodigoLegal();
            this.dSGrupoAsociadoPIUBusquedaDescripcion = instance.getGrupoAsociadoDescripcion();
        }
    }

    @JsonIgnore
    public String getDSGrupoAsociadoPIUBusquedaCodigoLegal() {
        return this.dSGrupoAsociadoPIUBusquedaCodigoLegal;
    }
    
    public void setDSGrupoAsociadoPIUBusquedaCodigoLegal(String dSGrupoAsociadoPIUBusquedaCodigoLegal) {
        this.dSGrupoAsociadoPIUBusquedaCodigoLegal = dSGrupoAsociadoPIUBusquedaCodigoLegal;
    }

    @JsonIgnore
    public String getDSGrupoAsociadoPIUBusquedaDescripcion() {
        return this.dSGrupoAsociadoPIUBusquedaDescripcion;
    }
    
    public void setDSGrupoAsociadoPIUBusquedaDescripcion(String dSGrupoAsociadoPIUBusquedaDescripcion) {
        this.dSGrupoAsociadoPIUBusquedaDescripcion = dSGrupoAsociadoPIUBusquedaDescripcion;
    }
}
