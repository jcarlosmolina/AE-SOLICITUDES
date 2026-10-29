package com.keralty.aesolicitudes.viewmodel.marcamedicac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.MarcaMedicaCConstants;
import com.keralty.aesolicitudes.persistence.MarcaMedicaC;
import com.keralty.aesolicitudes.persistence.oid.MarcaMedicaCOid;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class ModificarRequest {

    @JsonProperty("p_thismarcamedicac_oid")
    private MarcaMedicaCOid marcaMedicaCmodificarpthisMarcaMedicaC;
    
    @JsonIgnore
    private MarcaMedicaC marcaMedicaCmodificarpthisMarcaMedicaCInstance;

    @JsonProperty("p_descripcion")
    private String marcaMedicaCmodificarpDescripcion;

    @JsonProperty("p_tipomarcacion")
    private String marcaMedicaCmodificarpTipoMarcacion;

    @JsonProperty("p_eximepagoprestacion")
    private Boolean marcaMedicaCmodificarpEximePagoPrestacion;

    @JsonProperty("p_estadomarcacionmedica")
    private String marcaMedicaCmodificarpEstadoMarcacionMedica;

    @JsonProperty("p_fechainicio")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date marcaMedicaCmodificarpFechaInicio;

    @JsonProperty("p_fechafin")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date marcaMedicaCmodificarpFechaFin;

    public void checkArguments() throws NotNullArgumentException {
        checkMarcaMedicaCmodificarpthisMarcaMedicaC();
    }

    @JsonIgnore
    public MarcaMedicaCOid getMarcaMedicaCmodificarpthisMarcaMedicaC() {
        return this.marcaMedicaCmodificarpthisMarcaMedicaC;
    }
    
    public void setMarcaMedicaCmodificarpthisMarcaMedicaC(MarcaMedicaCOid marcaMedicaCmodificarpthisMarcaMedicaC) {
        this.marcaMedicaCmodificarpthisMarcaMedicaC = marcaMedicaCmodificarpthisMarcaMedicaC;
    }

    @JsonIgnore
    public MarcaMedicaC getMarcaMedicaCmodificarpthisMarcaMedicaCInstance() {
        return this.marcaMedicaCmodificarpthisMarcaMedicaCInstance;
    }
    
    public void setMarcaMedicaCmodificarpthisMarcaMedicaCInstance(MarcaMedicaC marcaMedicaCmodificarpthisMarcaMedicaC) {
        this.marcaMedicaCmodificarpthisMarcaMedicaCInstance = marcaMedicaCmodificarpthisMarcaMedicaC;
        this.marcaMedicaCmodificarpthisMarcaMedicaC = marcaMedicaCmodificarpthisMarcaMedicaC != null ? marcaMedicaCmodificarpthisMarcaMedicaC.getOid() : null;
    }

    private void checkMarcaMedicaCmodificarpthisMarcaMedicaC() throws NotNullArgumentException {
        if(this.getMarcaMedicaCmodificarpthisMarcaMedicaCInstance() == null || this.getMarcaMedicaCmodificarpthisMarcaMedicaCInstance().isNull()) {
            throw new NotNullArgumentException(MarcaMedicaCConstants.SERV_ID_MODIFICAR, MarcaMedicaCConstants.CLASS_ID, MarcaMedicaCConstants.ARG_ID_MODIFICAR_MARCAMEDICACMODIFICARPTHISMARCAMEDICAC, MarcaMedicaCConstants.SERV_ALIAS_MODIFICAR, MarcaMedicaCConstants.CLASS_ALIAS, MarcaMedicaCConstants.ARG_ALIAS_MODIFICAR_MARCAMEDICACMODIFICARPTHISMARCAMEDICAC);
        }
    }

    @JsonIgnore
    public String getMarcaMedicaCmodificarpDescripcion() {
        return this.marcaMedicaCmodificarpDescripcion;
    }
    
    public void setMarcaMedicaCmodificarpDescripcion(String marcaMedicaCmodificarpDescripcion) {
        this.marcaMedicaCmodificarpDescripcion = marcaMedicaCmodificarpDescripcion;
    }

    @JsonIgnore
    public String getMarcaMedicaCmodificarpTipoMarcacion() {
        return this.marcaMedicaCmodificarpTipoMarcacion;
    }
    
    public void setMarcaMedicaCmodificarpTipoMarcacion(String marcaMedicaCmodificarpTipoMarcacion) {
        this.marcaMedicaCmodificarpTipoMarcacion = marcaMedicaCmodificarpTipoMarcacion;
    }

    @JsonIgnore
    public Boolean getMarcaMedicaCmodificarpEximePagoPrestacion() {
        return this.marcaMedicaCmodificarpEximePagoPrestacion;
    }
    
    public void setMarcaMedicaCmodificarpEximePagoPrestacion(Boolean marcaMedicaCmodificarpEximePagoPrestacion) {
        this.marcaMedicaCmodificarpEximePagoPrestacion = marcaMedicaCmodificarpEximePagoPrestacion;
    }

    @JsonIgnore
    public String getMarcaMedicaCmodificarpEstadoMarcacionMedica() {
        return this.marcaMedicaCmodificarpEstadoMarcacionMedica;
    }
    
    public void setMarcaMedicaCmodificarpEstadoMarcacionMedica(String marcaMedicaCmodificarpEstadoMarcacionMedica) {
        this.marcaMedicaCmodificarpEstadoMarcacionMedica = marcaMedicaCmodificarpEstadoMarcacionMedica;
    }

    @JsonIgnore
    public Date getMarcaMedicaCmodificarpFechaInicio() {
        return this.marcaMedicaCmodificarpFechaInicio;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setMarcaMedicaCmodificarpFechaInicio(Date marcaMedicaCmodificarpFechaInicio) {
        this.marcaMedicaCmodificarpFechaInicio = marcaMedicaCmodificarpFechaInicio;
    }

    @JsonIgnore
    public Date getMarcaMedicaCmodificarpFechaFin() {
        return this.marcaMedicaCmodificarpFechaFin;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setMarcaMedicaCmodificarpFechaFin(Date marcaMedicaCmodificarpFechaFin) {
        this.marcaMedicaCmodificarpFechaFin = marcaMedicaCmodificarpFechaFin;
    }
}
