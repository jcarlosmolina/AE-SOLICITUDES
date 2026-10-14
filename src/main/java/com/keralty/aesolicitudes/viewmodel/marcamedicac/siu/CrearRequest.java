package com.keralty.aesolicitudes.viewmodel.marcamedicac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.MarcaMedicaCConstants;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class CrearRequest {

    @JsonProperty("p_agrproductoc_oid")
    private ProductosOid marcaMedicaCcrearpagrProductoC;
    
    @JsonIgnore
    private Productos marcaMedicaCcrearpagrProductoCInstance;

    @JsonProperty("p_agrpersonac_oid")
    private PersonaCOid marcaMedicaCcrearpagrPersonaC;
    
    @JsonIgnore
    private PersonaC marcaMedicaCcrearpagrPersonaCInstance;

    @JsonProperty("p_atrcodigo")
    private String marcaMedicaCcrearpatrCodigo;

    @JsonProperty("p_atrdescripcion")
    private String marcaMedicaCcrearpatrDescripcion;

    @JsonProperty("p_atrtipomarcacion")
    private String marcaMedicaCcrearpatrTipoMarcacion;

    @JsonProperty("p_atreximepagoprestacion")
    private Boolean marcaMedicaCcrearpatrEximePagoPrestacion;

    @JsonProperty("p_atrestadomarcacionmedica")
    private String marcaMedicaCcrearpatrEstadoMarcacionMedica;

    @JsonProperty("p_atrfechainicio")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date marcaMedicaCcrearpatrFechaInicio;

    @JsonProperty("p_atrfechafin")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date marcaMedicaCcrearpatrFechaFin;

    public void checkArguments() throws NotNullArgumentException {
        checkMarcaMedicaCcrearpagrProductoC();
        checkMarcaMedicaCcrearpagrPersonaC();
        checkMarcaMedicaCcrearpatrCodigo();
    }

    @JsonIgnore
    public ProductosOid getMarcaMedicaCcrearpagrProductoC() {
        return this.marcaMedicaCcrearpagrProductoC;
    }
    
    public void setMarcaMedicaCcrearpagrProductoC(ProductosOid marcaMedicaCcrearpagrProductoC) {
        this.marcaMedicaCcrearpagrProductoC = marcaMedicaCcrearpagrProductoC;
    }

    @JsonIgnore
    public Productos getMarcaMedicaCcrearpagrProductoCInstance() {
        return this.marcaMedicaCcrearpagrProductoCInstance;
    }
    
    public void setMarcaMedicaCcrearpagrProductoCInstance(Productos marcaMedicaCcrearpagrProductoC) {
        this.marcaMedicaCcrearpagrProductoCInstance = marcaMedicaCcrearpagrProductoC;
        this.marcaMedicaCcrearpagrProductoC = marcaMedicaCcrearpagrProductoC != null ? marcaMedicaCcrearpagrProductoC.getOid() : null;
    }

    private void checkMarcaMedicaCcrearpagrProductoC() throws NotNullArgumentException {
        if(this.getMarcaMedicaCcrearpagrProductoCInstance() == null || this.getMarcaMedicaCcrearpagrProductoCInstance().isNull()) {
            throw new NotNullArgumentException(MarcaMedicaCConstants.SERV_ID_CREAR, MarcaMedicaCConstants.CLASS_ID, MarcaMedicaCConstants.ARG_ID_CREAR_MARCAMEDICACCREARPAGRPRODUCTOC, MarcaMedicaCConstants.SERV_ALIAS_CREAR, MarcaMedicaCConstants.CLASS_ALIAS, MarcaMedicaCConstants.ARG_ALIAS_CREAR_MARCAMEDICACCREARPAGRPRODUCTOC);
        }
    }

    @JsonIgnore
    public PersonaCOid getMarcaMedicaCcrearpagrPersonaC() {
        return this.marcaMedicaCcrearpagrPersonaC;
    }
    
    public void setMarcaMedicaCcrearpagrPersonaC(PersonaCOid marcaMedicaCcrearpagrPersonaC) {
        this.marcaMedicaCcrearpagrPersonaC = marcaMedicaCcrearpagrPersonaC;
    }

    @JsonIgnore
    public PersonaC getMarcaMedicaCcrearpagrPersonaCInstance() {
        return this.marcaMedicaCcrearpagrPersonaCInstance;
    }
    
    public void setMarcaMedicaCcrearpagrPersonaCInstance(PersonaC marcaMedicaCcrearpagrPersonaC) {
        this.marcaMedicaCcrearpagrPersonaCInstance = marcaMedicaCcrearpagrPersonaC;
        this.marcaMedicaCcrearpagrPersonaC = marcaMedicaCcrearpagrPersonaC != null ? marcaMedicaCcrearpagrPersonaC.getOid() : null;
    }

    private void checkMarcaMedicaCcrearpagrPersonaC() throws NotNullArgumentException {
        if(this.getMarcaMedicaCcrearpagrPersonaCInstance() == null || this.getMarcaMedicaCcrearpagrPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(MarcaMedicaCConstants.SERV_ID_CREAR, MarcaMedicaCConstants.CLASS_ID, MarcaMedicaCConstants.ARG_ID_CREAR_MARCAMEDICACCREARPAGRPERSONAC, MarcaMedicaCConstants.SERV_ALIAS_CREAR, MarcaMedicaCConstants.CLASS_ALIAS, MarcaMedicaCConstants.ARG_ALIAS_CREAR_MARCAMEDICACCREARPAGRPERSONAC);
        }
    }

    @JsonIgnore
    public String getMarcaMedicaCcrearpatrCodigo() {
        return this.marcaMedicaCcrearpatrCodigo;
    }
    
    public void setMarcaMedicaCcrearpatrCodigo(String marcaMedicaCcrearpatrCodigo) {
        this.marcaMedicaCcrearpatrCodigo = marcaMedicaCcrearpatrCodigo;
    }

    private void checkMarcaMedicaCcrearpatrCodigo() throws NotNullArgumentException {
        if(this.getMarcaMedicaCcrearpatrCodigo() == null) {
            throw new NotNullArgumentException(MarcaMedicaCConstants.SERV_ID_CREAR, MarcaMedicaCConstants.CLASS_ID, MarcaMedicaCConstants.ARG_ID_CREAR_MARCAMEDICACCREARPATRCODIGO, MarcaMedicaCConstants.SERV_ALIAS_CREAR, MarcaMedicaCConstants.CLASS_ALIAS, MarcaMedicaCConstants.ARG_ALIAS_CREAR_MARCAMEDICACCREARPATRCODIGO);
        }
    }

    @JsonIgnore
    public String getMarcaMedicaCcrearpatrDescripcion() {
        return this.marcaMedicaCcrearpatrDescripcion;
    }
    
    public void setMarcaMedicaCcrearpatrDescripcion(String marcaMedicaCcrearpatrDescripcion) {
        this.marcaMedicaCcrearpatrDescripcion = marcaMedicaCcrearpatrDescripcion;
    }

    @JsonIgnore
    public String getMarcaMedicaCcrearpatrTipoMarcacion() {
        return this.marcaMedicaCcrearpatrTipoMarcacion;
    }
    
    public void setMarcaMedicaCcrearpatrTipoMarcacion(String marcaMedicaCcrearpatrTipoMarcacion) {
        this.marcaMedicaCcrearpatrTipoMarcacion = marcaMedicaCcrearpatrTipoMarcacion;
    }

    @JsonIgnore
    public Boolean getMarcaMedicaCcrearpatrEximePagoPrestacion() {
        return this.marcaMedicaCcrearpatrEximePagoPrestacion;
    }
    
    public void setMarcaMedicaCcrearpatrEximePagoPrestacion(Boolean marcaMedicaCcrearpatrEximePagoPrestacion) {
        this.marcaMedicaCcrearpatrEximePagoPrestacion = marcaMedicaCcrearpatrEximePagoPrestacion;
    }

    @JsonIgnore
    public String getMarcaMedicaCcrearpatrEstadoMarcacionMedica() {
        return this.marcaMedicaCcrearpatrEstadoMarcacionMedica;
    }
    
    public void setMarcaMedicaCcrearpatrEstadoMarcacionMedica(String marcaMedicaCcrearpatrEstadoMarcacionMedica) {
        this.marcaMedicaCcrearpatrEstadoMarcacionMedica = marcaMedicaCcrearpatrEstadoMarcacionMedica;
    }

    @JsonIgnore
    public Date getMarcaMedicaCcrearpatrFechaInicio() {
        return this.marcaMedicaCcrearpatrFechaInicio;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setMarcaMedicaCcrearpatrFechaInicio(Date marcaMedicaCcrearpatrFechaInicio) {
        this.marcaMedicaCcrearpatrFechaInicio = marcaMedicaCcrearpatrFechaInicio;
    }

    @JsonIgnore
    public Date getMarcaMedicaCcrearpatrFechaFin() {
        return this.marcaMedicaCcrearpatrFechaFin;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setMarcaMedicaCcrearpatrFechaFin(Date marcaMedicaCcrearpatrFechaFin) {
        this.marcaMedicaCcrearpatrFechaFin = marcaMedicaCcrearpatrFechaFin;
    }
}
