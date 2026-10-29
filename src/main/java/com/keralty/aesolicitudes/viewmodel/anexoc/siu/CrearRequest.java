package com.keralty.aesolicitudes.viewmodel.anexoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.AnexoCConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.PeriodicidadOid;
import com.keralty.aesolicitudes.persistence.oid.TipoIdentificacionOid;
import com.keralty.aesolicitudes.persistence.Periodicidad;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class CrearRequest {

    @JsonProperty("p_agrperiodicidadc_oid")
    private PeriodicidadOid anexoCcrearpagrPeriodicidadC;
    
    @JsonIgnore
    private Periodicidad anexoCcrearpagrPeriodicidadCInstance;

    @JsonProperty("p_agrbeneficiarioc_oid")
    private BeneficiarioCOid anexoCcrearpagrBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC anexoCcrearpagrBeneficiarioCInstance;

    @JsonProperty("p_agrtipoidentificacionc_oid")
    private TipoIdentificacionOid anexoCcrearpagrTipoIdentificacionC;
    
    @JsonIgnore
    private TipoIdentificacion anexoCcrearpagrTipoIdentificacionCInstance;

    @JsonProperty("p_atrcodigoplananexo")
    private String anexoCcrearpatrCodigoPlanAnexo;

    @JsonProperty("p_atrcodigotarifa")
    private String anexoCcrearpatrCodigoTarifa;

    @JsonProperty("p_atrfechainiciovigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date anexoCcrearpatrFechaInicioVigencia;

    @JsonProperty("p_atrfechaultimaregla")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date anexoCcrearpatrFechaUltimaRegla;

    @JsonProperty("p_atrnumcuotaspago")
    private Long anexoCcrearpatrNumCuotasPago;

    @JsonProperty("p_atrnumidentificacion")
    private String anexoCcrearpatrNumIdentificacion;

    @JsonProperty("p_atrcodsucursal")
    private String anexoCcrearpatrCodSucursal;

    public void checkArguments() throws NotNullArgumentException {
        checkAnexoCcrearpagrBeneficiarioC();
    }

    @JsonIgnore
    public PeriodicidadOid getAnexoCcrearpagrPeriodicidadC() {
        return this.anexoCcrearpagrPeriodicidadC;
    }
    
    public void setAnexoCcrearpagrPeriodicidadC(PeriodicidadOid anexoCcrearpagrPeriodicidadC) {
        this.anexoCcrearpagrPeriodicidadC = anexoCcrearpagrPeriodicidadC;
    }

    @JsonIgnore
    public Periodicidad getAnexoCcrearpagrPeriodicidadCInstance() {
        return this.anexoCcrearpagrPeriodicidadCInstance;
    }
    
    public void setAnexoCcrearpagrPeriodicidadCInstance(Periodicidad anexoCcrearpagrPeriodicidadC) {
        this.anexoCcrearpagrPeriodicidadCInstance = anexoCcrearpagrPeriodicidadC;
        this.anexoCcrearpagrPeriodicidadC = anexoCcrearpagrPeriodicidadC != null ? anexoCcrearpagrPeriodicidadC.getOid() : null;
    }

    @JsonIgnore
    public BeneficiarioCOid getAnexoCcrearpagrBeneficiarioC() {
        return this.anexoCcrearpagrBeneficiarioC;
    }
    
    public void setAnexoCcrearpagrBeneficiarioC(BeneficiarioCOid anexoCcrearpagrBeneficiarioC) {
        this.anexoCcrearpagrBeneficiarioC = anexoCcrearpagrBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getAnexoCcrearpagrBeneficiarioCInstance() {
        return this.anexoCcrearpagrBeneficiarioCInstance;
    }
    
    public void setAnexoCcrearpagrBeneficiarioCInstance(BeneficiarioC anexoCcrearpagrBeneficiarioC) {
        this.anexoCcrearpagrBeneficiarioCInstance = anexoCcrearpagrBeneficiarioC;
        this.anexoCcrearpagrBeneficiarioC = anexoCcrearpagrBeneficiarioC != null ? anexoCcrearpagrBeneficiarioC.getOid() : null;
    }

    private void checkAnexoCcrearpagrBeneficiarioC() throws NotNullArgumentException {
        if(this.getAnexoCcrearpagrBeneficiarioCInstance() == null || this.getAnexoCcrearpagrBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(AnexoCConstants.SERV_ID_CREAR, AnexoCConstants.CLASS_ID, AnexoCConstants.ARG_ID_CREAR_ANEXOCCREARPAGRBENEFICIARIOC, AnexoCConstants.SERV_ALIAS_CREAR, AnexoCConstants.CLASS_ALIAS, AnexoCConstants.ARG_ALIAS_CREAR_ANEXOCCREARPAGRBENEFICIARIOC);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getAnexoCcrearpagrTipoIdentificacionC() {
        return this.anexoCcrearpagrTipoIdentificacionC;
    }
    
    public void setAnexoCcrearpagrTipoIdentificacionC(TipoIdentificacionOid anexoCcrearpagrTipoIdentificacionC) {
        this.anexoCcrearpagrTipoIdentificacionC = anexoCcrearpagrTipoIdentificacionC;
    }

    @JsonIgnore
    public TipoIdentificacion getAnexoCcrearpagrTipoIdentificacionCInstance() {
        return this.anexoCcrearpagrTipoIdentificacionCInstance;
    }
    
    public void setAnexoCcrearpagrTipoIdentificacionCInstance(TipoIdentificacion anexoCcrearpagrTipoIdentificacionC) {
        this.anexoCcrearpagrTipoIdentificacionCInstance = anexoCcrearpagrTipoIdentificacionC;
        this.anexoCcrearpagrTipoIdentificacionC = anexoCcrearpagrTipoIdentificacionC != null ? anexoCcrearpagrTipoIdentificacionC.getOid() : null;
    }

    @JsonIgnore
    public String getAnexoCcrearpatrCodigoPlanAnexo() {
        return this.anexoCcrearpatrCodigoPlanAnexo;
    }
    
    public void setAnexoCcrearpatrCodigoPlanAnexo(String anexoCcrearpatrCodigoPlanAnexo) {
        this.anexoCcrearpatrCodigoPlanAnexo = anexoCcrearpatrCodigoPlanAnexo;
    }

    @JsonIgnore
    public String getAnexoCcrearpatrCodigoTarifa() {
        return this.anexoCcrearpatrCodigoTarifa;
    }
    
    public void setAnexoCcrearpatrCodigoTarifa(String anexoCcrearpatrCodigoTarifa) {
        this.anexoCcrearpatrCodigoTarifa = anexoCcrearpatrCodigoTarifa;
    }

    @JsonIgnore
    public Date getAnexoCcrearpatrFechaInicioVigencia() {
        return this.anexoCcrearpatrFechaInicioVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setAnexoCcrearpatrFechaInicioVigencia(Date anexoCcrearpatrFechaInicioVigencia) {
        this.anexoCcrearpatrFechaInicioVigencia = anexoCcrearpatrFechaInicioVigencia;
    }

    @JsonIgnore
    public Date getAnexoCcrearpatrFechaUltimaRegla() {
        return this.anexoCcrearpatrFechaUltimaRegla;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setAnexoCcrearpatrFechaUltimaRegla(Date anexoCcrearpatrFechaUltimaRegla) {
        this.anexoCcrearpatrFechaUltimaRegla = anexoCcrearpatrFechaUltimaRegla;
    }

    @JsonIgnore
    public Long getAnexoCcrearpatrNumCuotasPago() {
        return this.anexoCcrearpatrNumCuotasPago;
    }
    
    public void setAnexoCcrearpatrNumCuotasPago(Long anexoCcrearpatrNumCuotasPago) {
        this.anexoCcrearpatrNumCuotasPago = anexoCcrearpatrNumCuotasPago;
    }

    @JsonIgnore
    public String getAnexoCcrearpatrNumIdentificacion() {
        return this.anexoCcrearpatrNumIdentificacion;
    }
    
    public void setAnexoCcrearpatrNumIdentificacion(String anexoCcrearpatrNumIdentificacion) {
        this.anexoCcrearpatrNumIdentificacion = anexoCcrearpatrNumIdentificacion;
    }

    @JsonIgnore
    public String getAnexoCcrearpatrCodSucursal() {
        return this.anexoCcrearpatrCodSucursal;
    }
    
    public void setAnexoCcrearpatrCodSucursal(String anexoCcrearpatrCodSucursal) {
        this.anexoCcrearpatrCodSucursal = anexoCcrearpatrCodSucursal;
    }
}
