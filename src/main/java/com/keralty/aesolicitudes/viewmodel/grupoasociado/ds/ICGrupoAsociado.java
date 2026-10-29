package com.keralty.aesolicitudes.viewmodel.grupoasociado.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.GrupoAsociado;
public class ICGrupoAsociado {

    @JsonProperty("codigolegal")
    private String iCGrupoAsociadoCodigoLegal;

    @JsonProperty("descripcion")
    private String iCGrupoAsociadoDescripcion;

    public ICGrupoAsociado() {
    
    }

    public ICGrupoAsociado(GrupoAsociado instance) {
        if (instance != null) {
            this.iCGrupoAsociadoCodigoLegal = instance.getGrupoAsociadoCodigoLegal();
            this.iCGrupoAsociadoDescripcion = instance.getGrupoAsociadoDescripcion();
        }
    }

    @JsonIgnore
    public String getICGrupoAsociadoCodigoLegal() {
        return this.iCGrupoAsociadoCodigoLegal;
    }
    
    public void setICGrupoAsociadoCodigoLegal(String iCGrupoAsociadoCodigoLegal) {
        this.iCGrupoAsociadoCodigoLegal = iCGrupoAsociadoCodigoLegal;
    }

    @JsonIgnore
    public String getICGrupoAsociadoDescripcion() {
        return this.iCGrupoAsociadoDescripcion;
    }
    
    public void setICGrupoAsociadoDescripcion(String iCGrupoAsociadoDescripcion) {
        this.iCGrupoAsociadoDescripcion = iCGrupoAsociadoDescripcion;
    }
}
