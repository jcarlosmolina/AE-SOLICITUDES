package com.keralty.aesolicitudes.viewmodel.logllamadasbh.ds;

import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.LogLlamadasBH;
public class DSLogLlamadasBH {

    @JsonProperty("tiposervicio")
    private String dSLogLlamadasBHTipoServicio;

    @JsonProperty("servicio")
    private String dSLogLlamadasBHServicio;

    @JsonProperty("capacidad")
    private String dSLogLlamadasBHCapacidad;

    @JsonProperty("fechahora")
    private Timestamp dSLogLlamadasBHFechaHora;

    @JsonProperty("solicitud")
    private String dSLogLlamadasBHSolicitud;

    @JsonProperty("textoerror")
    private String dSLogLlamadasBHTextoError;

    public DSLogLlamadasBH() {
    
    }

    public DSLogLlamadasBH(LogLlamadasBH instance) {
        if (instance != null) {
            this.dSLogLlamadasBHTipoServicio = instance.getLogLlamadasBHTipoServicio();
            this.dSLogLlamadasBHServicio = instance.getLogLlamadasBHServicio();
            this.dSLogLlamadasBHCapacidad = instance.getLogLlamadasBHCapacidad();
            this.dSLogLlamadasBHFechaHora = instance.getLogLlamadasBHFechaHora();
            this.dSLogLlamadasBHSolicitud = instance.getLogLlamadasBHSolicitud();
            this.dSLogLlamadasBHTextoError = instance.getLogLlamadasBHTextoError();
        }
    }

    @JsonIgnore
    public String getDSLogLlamadasBHTipoServicio() {
        return this.dSLogLlamadasBHTipoServicio;
    }
    
    public void setDSLogLlamadasBHTipoServicio(String dSLogLlamadasBHTipoServicio) {
        this.dSLogLlamadasBHTipoServicio = dSLogLlamadasBHTipoServicio;
    }

    @JsonIgnore
    public String getDSLogLlamadasBHServicio() {
        return this.dSLogLlamadasBHServicio;
    }
    
    public void setDSLogLlamadasBHServicio(String dSLogLlamadasBHServicio) {
        this.dSLogLlamadasBHServicio = dSLogLlamadasBHServicio;
    }

    @JsonIgnore
    public String getDSLogLlamadasBHCapacidad() {
        return this.dSLogLlamadasBHCapacidad;
    }
    
    public void setDSLogLlamadasBHCapacidad(String dSLogLlamadasBHCapacidad) {
        this.dSLogLlamadasBHCapacidad = dSLogLlamadasBHCapacidad;
    }

    @JsonIgnore
    public Timestamp getDSLogLlamadasBHFechaHora() {
        return this.dSLogLlamadasBHFechaHora;
    }
    
    public void setDSLogLlamadasBHFechaHora(Timestamp dSLogLlamadasBHFechaHora) {
        this.dSLogLlamadasBHFechaHora = dSLogLlamadasBHFechaHora;
    }

    @JsonIgnore
    public String getDSLogLlamadasBHSolicitud() {
        return this.dSLogLlamadasBHSolicitud;
    }
    
    public void setDSLogLlamadasBHSolicitud(String dSLogLlamadasBHSolicitud) {
        this.dSLogLlamadasBHSolicitud = dSLogLlamadasBHSolicitud;
    }

    @JsonIgnore
    public String getDSLogLlamadasBHTextoError() {
        return this.dSLogLlamadasBHTextoError;
    }
    
    public void setDSLogLlamadasBHTextoError(String dSLogLlamadasBHTextoError) {
        this.dSLogLlamadasBHTextoError = dSLogLlamadasBHTextoError;
    }
}
