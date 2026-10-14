package com.keralty.aesolicitudes.viewmodel.aesolicitudes.ds;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.Aesolicitudes;
public class DSAesolicitudes {

    @JsonProperty("fechaasignacion")
    private Date dSAesolicitudesFechaasignacion;

    @JsonProperty("numerosolicitud")
    private String dSAesolicitudesNumerosolicitud;

    @JsonProperty("swestado")
    private String dSAesolicitudesSwestado;

    public DSAesolicitudes() {
    
    }

    public DSAesolicitudes(Aesolicitudes instance) {
        if (instance != null) {
            this.dSAesolicitudesFechaasignacion = instance.getAesolicitudesFechaasignacion();
            this.dSAesolicitudesNumerosolicitud = instance.getAesolicitudesNumerosolicitud();
            this.dSAesolicitudesSwestado = instance.getAesolicitudesSwestado();
        }
    }

    @JsonIgnore
    public Date getDSAesolicitudesFechaasignacion() {
        return this.dSAesolicitudesFechaasignacion;
    }
    
    public void setDSAesolicitudesFechaasignacion(Date dSAesolicitudesFechaasignacion) {
        this.dSAesolicitudesFechaasignacion = dSAesolicitudesFechaasignacion;
    }

    @JsonIgnore
    public String getDSAesolicitudesNumerosolicitud() {
        return this.dSAesolicitudesNumerosolicitud;
    }
    
    public void setDSAesolicitudesNumerosolicitud(String dSAesolicitudesNumerosolicitud) {
        this.dSAesolicitudesNumerosolicitud = dSAesolicitudesNumerosolicitud;
    }

    @JsonIgnore
    public String getDSAesolicitudesSwestado() {
        return this.dSAesolicitudesSwestado;
    }
    
    public void setDSAesolicitudesSwestado(String dSAesolicitudesSwestado) {
        this.dSAesolicitudesSwestado = dSAesolicitudesSwestado;
    }
}
