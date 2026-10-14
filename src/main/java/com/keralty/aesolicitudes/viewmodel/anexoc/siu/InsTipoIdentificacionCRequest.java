package com.keralty.aesolicitudes.viewmodel.anexoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.AnexoCConstants;
import com.keralty.aesolicitudes.persistence.AnexoC;
import com.keralty.aesolicitudes.persistence.oid.AnexoCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoIdentificacionOid;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;

public class InsTipoIdentificacionCRequest {

    @JsonProperty("p_thisanexoc_oid")
    private AnexoCOid anexoCInsTipoIdentificacionCpthisAnexoC;
    
    @JsonIgnore
    private AnexoC anexoCInsTipoIdentificacionCpthisAnexoCInstance;

    @JsonProperty("p_evctipoidentificacion_oid")
    private TipoIdentificacionOid anexoCInsTipoIdentificacionCpevcTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion anexoCInsTipoIdentificacionCpevcTipoIdentificacionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAnexoCInsTipoIdentificacionCpthisAnexoC();
        checkAnexoCInsTipoIdentificacionCpevcTipoIdentificacion();
    }

    @JsonIgnore
    public AnexoCOid getAnexoCInsTipoIdentificacionCpthisAnexoC() {
        return this.anexoCInsTipoIdentificacionCpthisAnexoC;
    }
    
    public void setAnexoCInsTipoIdentificacionCpthisAnexoC(AnexoCOid anexoCInsTipoIdentificacionCpthisAnexoC) {
        this.anexoCInsTipoIdentificacionCpthisAnexoC = anexoCInsTipoIdentificacionCpthisAnexoC;
    }

    @JsonIgnore
    public AnexoC getAnexoCInsTipoIdentificacionCpthisAnexoCInstance() {
        return this.anexoCInsTipoIdentificacionCpthisAnexoCInstance;
    }
    
    public void setAnexoCInsTipoIdentificacionCpthisAnexoCInstance(AnexoC anexoCInsTipoIdentificacionCpthisAnexoC) {
        this.anexoCInsTipoIdentificacionCpthisAnexoCInstance = anexoCInsTipoIdentificacionCpthisAnexoC;
        this.anexoCInsTipoIdentificacionCpthisAnexoC = anexoCInsTipoIdentificacionCpthisAnexoC != null ? anexoCInsTipoIdentificacionCpthisAnexoC.getOid() : null;
    }

    private void checkAnexoCInsTipoIdentificacionCpthisAnexoC() throws NotNullArgumentException {
        if(this.getAnexoCInsTipoIdentificacionCpthisAnexoCInstance() == null || this.getAnexoCInsTipoIdentificacionCpthisAnexoCInstance().isNull()) {
            throw new NotNullArgumentException(AnexoCConstants.SERV_ID_INSTIPOIDENTIFICACIONC, AnexoCConstants.CLASS_ID, AnexoCConstants.ARG_ID_INSTIPOIDENTIFICACIONC_ANEXOCINSTIPOIDENTIFICACIONCPTHISANEXOC, AnexoCConstants.SERV_ALIAS_INSTIPOIDENTIFICACIONC, AnexoCConstants.CLASS_ALIAS, AnexoCConstants.ARG_ALIAS_INSTIPOIDENTIFICACIONC_ANEXOCINSTIPOIDENTIFICACIONCPTHISANEXOC);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getAnexoCInsTipoIdentificacionCpevcTipoIdentificacion() {
        return this.anexoCInsTipoIdentificacionCpevcTipoIdentificacion;
    }
    
    public void setAnexoCInsTipoIdentificacionCpevcTipoIdentificacion(TipoIdentificacionOid anexoCInsTipoIdentificacionCpevcTipoIdentificacion) {
        this.anexoCInsTipoIdentificacionCpevcTipoIdentificacion = anexoCInsTipoIdentificacionCpevcTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getAnexoCInsTipoIdentificacionCpevcTipoIdentificacionInstance() {
        return this.anexoCInsTipoIdentificacionCpevcTipoIdentificacionInstance;
    }
    
    public void setAnexoCInsTipoIdentificacionCpevcTipoIdentificacionInstance(TipoIdentificacion anexoCInsTipoIdentificacionCpevcTipoIdentificacion) {
        this.anexoCInsTipoIdentificacionCpevcTipoIdentificacionInstance = anexoCInsTipoIdentificacionCpevcTipoIdentificacion;
        this.anexoCInsTipoIdentificacionCpevcTipoIdentificacion = anexoCInsTipoIdentificacionCpevcTipoIdentificacion != null ? anexoCInsTipoIdentificacionCpevcTipoIdentificacion.getOid() : null;
    }

    private void checkAnexoCInsTipoIdentificacionCpevcTipoIdentificacion() throws NotNullArgumentException {
        if(this.getAnexoCInsTipoIdentificacionCpevcTipoIdentificacionInstance() == null || this.getAnexoCInsTipoIdentificacionCpevcTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(AnexoCConstants.SERV_ID_INSTIPOIDENTIFICACIONC, AnexoCConstants.CLASS_ID, AnexoCConstants.ARG_ID_INSTIPOIDENTIFICACIONC_ANEXOCINSTIPOIDENTIFICACIONCPEVCTIPOIDENTIFICACION, AnexoCConstants.SERV_ALIAS_INSTIPOIDENTIFICACIONC, AnexoCConstants.CLASS_ALIAS, AnexoCConstants.ARG_ALIAS_INSTIPOIDENTIFICACIONC_ANEXOCINSTIPOIDENTIFICACIONCPEVCTIPOIDENTIFICACION);
        }
    }
}
