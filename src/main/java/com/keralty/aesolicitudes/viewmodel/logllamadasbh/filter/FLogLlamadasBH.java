package com.keralty.aesolicitudes.viewmodel.logllamadasbh.filter;

import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aesolicitudes.global.LogLlamadasBHConstants;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;

public class FLogLlamadasBH {

    @JsonProperty("vftiposervicio")
    private String vfTipoServicio;

    @JsonProperty("vfservicio")
    private String vfServicio;

    @JsonProperty("vfcapa")
    private String vfCapa;

    @JsonProperty("vfdesde")
    private Timestamp vfDesde;

    @JsonProperty("vfhasta")
    private Timestamp vfHasta;

    @JsonProperty("vfnumsolicitud")
    private String vfNumSolicitud;

    public FLogLlamadasBH() {
        // Default constructor
    }

    @JsonIgnore
    public String getVfTipoServicio() {
        return this.vfTipoServicio;
    }
    
    public void setVfTipoServicio(String vfTipoServicio) {
        this.vfTipoServicio = vfTipoServicio;
    }

    @JsonIgnore
    public String getVfServicio() {
        return this.vfServicio;
    }
    
    public void setVfServicio(String vfServicio) {
        this.vfServicio = vfServicio;
    }

    @JsonIgnore
    public String getVfCapa() {
        return this.vfCapa;
    }
    
    public void setVfCapa(String vfCapa) {
        this.vfCapa = vfCapa;
    }

    @JsonIgnore
    public Timestamp getVfDesde() {
        return this.vfDesde;
    }
    
    public void setVfDesde(Timestamp vfDesde) {
        this.vfDesde = vfDesde;
    }

    @JsonIgnore
    public Timestamp getVfHasta() {
        return this.vfHasta;
    }
    
    public void setVfHasta(Timestamp vfHasta) {
        this.vfHasta = vfHasta;
    }

    @JsonIgnore
    public String getVfNumSolicitud() {
        return this.vfNumSolicitud;
    }
    
    public void setVfNumSolicitud(String vfNumSolicitud) {
        this.vfNumSolicitud = vfNumSolicitud;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(LogLlamadasBHConstants.FILTER_NAME_FLOGLLAMADASBH);
        filterRequest.addFilterVariable(LogLlamadasBHConstants.VAR_NAME_FLOGLLAMADASBH_VFTIPOSERVICIO, vfTipoServicio);
        filterRequest.addFilterVariable(LogLlamadasBHConstants.VAR_NAME_FLOGLLAMADASBH_VFSERVICIO, vfServicio);
        filterRequest.addFilterVariable(LogLlamadasBHConstants.VAR_NAME_FLOGLLAMADASBH_VFCAPA, vfCapa);
        filterRequest.addFilterVariable(LogLlamadasBHConstants.VAR_NAME_FLOGLLAMADASBH_VFDESDE, vfDesde);
        filterRequest.addFilterVariable(LogLlamadasBHConstants.VAR_NAME_FLOGLLAMADASBH_VFHASTA, vfHasta);
        filterRequest.addFilterVariable(LogLlamadasBHConstants.VAR_NAME_FLOGLLAMADASBH_VFNUMSOLICITUD, vfNumSolicitud);
        return filterRequest;
    }
}
