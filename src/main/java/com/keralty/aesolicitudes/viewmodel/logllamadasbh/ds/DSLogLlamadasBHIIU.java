package com.keralty.aesolicitudes.viewmodel.logllamadasbh.ds;

import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.LogLlamadasBH;
public class DSLogLlamadasBHIIU {

    @JsonProperty("id")
    private Long dSLogLlamadasBHIIUID;

    @JsonProperty("tiposervicio")
    private String dSLogLlamadasBHIIUTipoServicio;

    @JsonProperty("solicitud")
    private String dSLogLlamadasBHIIUSolicitud;

    @JsonProperty("servicio")
    private String dSLogLlamadasBHIIUServicio;

    @JsonProperty("capacidad")
    private String dSLogLlamadasBHIIUCapacidad;

    @JsonProperty("fechahora")
    private Timestamp dSLogLlamadasBHIIUFechaHora;

    @JsonProperty("textoerror")
    private String dSLogLlamadasBHIIUTextoError;

    @JsonProperty("tiempoejecucion")
    private Double dSLogLlamadasBHIIUTiempoEjecucion;

    @JsonProperty("peticion")
    private String dSLogLlamadasBHIIUPeticion;

    @JsonProperty("respuesta")
    private String dSLogLlamadasBHIIURespuesta;

    @JsonProperty("usuario")
    private String dSLogLlamadasBHIIUUsuario;

    public DSLogLlamadasBHIIU() {
    
    }

    public DSLogLlamadasBHIIU(LogLlamadasBH instance) {
        if (instance != null) {
            this.dSLogLlamadasBHIIUID = instance.getLogLlamadasBHID();
            this.dSLogLlamadasBHIIUTipoServicio = instance.getLogLlamadasBHTipoServicio();
            this.dSLogLlamadasBHIIUSolicitud = instance.getLogLlamadasBHSolicitud();
            this.dSLogLlamadasBHIIUServicio = instance.getLogLlamadasBHServicio();
            this.dSLogLlamadasBHIIUCapacidad = instance.getLogLlamadasBHCapacidad();
            this.dSLogLlamadasBHIIUFechaHora = instance.getLogLlamadasBHFechaHora();
            this.dSLogLlamadasBHIIUTextoError = instance.getLogLlamadasBHTextoError();
            this.dSLogLlamadasBHIIUTiempoEjecucion = instance.getLogLlamadasBHTiempoEjecucion();
            this.dSLogLlamadasBHIIUPeticion = instance.getLogLlamadasBHPeticion();
            this.dSLogLlamadasBHIIURespuesta = instance.getLogLlamadasBHRespuesta();
            this.dSLogLlamadasBHIIUUsuario = instance.getLogLlamadasBHUsuario();
        }
    }

    @JsonIgnore
    public Long getDSLogLlamadasBHIIUID() {
        return this.dSLogLlamadasBHIIUID;
    }
    
    public void setDSLogLlamadasBHIIUID(Long dSLogLlamadasBHIIUID) {
        this.dSLogLlamadasBHIIUID = dSLogLlamadasBHIIUID;
    }

    @JsonIgnore
    public String getDSLogLlamadasBHIIUTipoServicio() {
        return this.dSLogLlamadasBHIIUTipoServicio;
    }
    
    public void setDSLogLlamadasBHIIUTipoServicio(String dSLogLlamadasBHIIUTipoServicio) {
        this.dSLogLlamadasBHIIUTipoServicio = dSLogLlamadasBHIIUTipoServicio;
    }

    @JsonIgnore
    public String getDSLogLlamadasBHIIUSolicitud() {
        return this.dSLogLlamadasBHIIUSolicitud;
    }
    
    public void setDSLogLlamadasBHIIUSolicitud(String dSLogLlamadasBHIIUSolicitud) {
        this.dSLogLlamadasBHIIUSolicitud = dSLogLlamadasBHIIUSolicitud;
    }

    @JsonIgnore
    public String getDSLogLlamadasBHIIUServicio() {
        return this.dSLogLlamadasBHIIUServicio;
    }
    
    public void setDSLogLlamadasBHIIUServicio(String dSLogLlamadasBHIIUServicio) {
        this.dSLogLlamadasBHIIUServicio = dSLogLlamadasBHIIUServicio;
    }

    @JsonIgnore
    public String getDSLogLlamadasBHIIUCapacidad() {
        return this.dSLogLlamadasBHIIUCapacidad;
    }
    
    public void setDSLogLlamadasBHIIUCapacidad(String dSLogLlamadasBHIIUCapacidad) {
        this.dSLogLlamadasBHIIUCapacidad = dSLogLlamadasBHIIUCapacidad;
    }

    @JsonIgnore
    public Timestamp getDSLogLlamadasBHIIUFechaHora() {
        return this.dSLogLlamadasBHIIUFechaHora;
    }
    
    public void setDSLogLlamadasBHIIUFechaHora(Timestamp dSLogLlamadasBHIIUFechaHora) {
        this.dSLogLlamadasBHIIUFechaHora = dSLogLlamadasBHIIUFechaHora;
    }

    @JsonIgnore
    public String getDSLogLlamadasBHIIUTextoError() {
        return this.dSLogLlamadasBHIIUTextoError;
    }
    
    public void setDSLogLlamadasBHIIUTextoError(String dSLogLlamadasBHIIUTextoError) {
        this.dSLogLlamadasBHIIUTextoError = dSLogLlamadasBHIIUTextoError;
    }

    @JsonIgnore
    public Double getDSLogLlamadasBHIIUTiempoEjecucion() {
        return this.dSLogLlamadasBHIIUTiempoEjecucion;
    }
    
    public void setDSLogLlamadasBHIIUTiempoEjecucion(Double dSLogLlamadasBHIIUTiempoEjecucion) {
        this.dSLogLlamadasBHIIUTiempoEjecucion = dSLogLlamadasBHIIUTiempoEjecucion;
    }

    @JsonIgnore
    public String getDSLogLlamadasBHIIUPeticion() {
        return this.dSLogLlamadasBHIIUPeticion;
    }
    
    public void setDSLogLlamadasBHIIUPeticion(String dSLogLlamadasBHIIUPeticion) {
        this.dSLogLlamadasBHIIUPeticion = dSLogLlamadasBHIIUPeticion;
    }

    @JsonIgnore
    public String getDSLogLlamadasBHIIURespuesta() {
        return this.dSLogLlamadasBHIIURespuesta;
    }
    
    public void setDSLogLlamadasBHIIURespuesta(String dSLogLlamadasBHIIURespuesta) {
        this.dSLogLlamadasBHIIURespuesta = dSLogLlamadasBHIIURespuesta;
    }

    @JsonIgnore
    public String getDSLogLlamadasBHIIUUsuario() {
        return this.dSLogLlamadasBHIIUUsuario;
    }
    
    public void setDSLogLlamadasBHIIUUsuario(String dSLogLlamadasBHIIUUsuario) {
        this.dSLogLlamadasBHIIUUsuario = dSLogLlamadasBHIIUUsuario;
    }
}
