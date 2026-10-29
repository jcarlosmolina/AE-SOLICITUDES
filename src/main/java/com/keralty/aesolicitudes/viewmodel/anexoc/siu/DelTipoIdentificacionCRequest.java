package com.keralty.aesolicitudes.viewmodel.anexoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.AnexoCConstants;
import com.keralty.aesolicitudes.persistence.AnexoC;
import com.keralty.aesolicitudes.persistence.oid.AnexoCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoIdentificacionOid;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;

public class DelTipoIdentificacionCRequest {

    @JsonProperty("p_thisanexoc_oid")
    private AnexoCOid anexoCDelTipoIdentificacionCpthisAnexoC;
    
    @JsonIgnore
    private AnexoC anexoCDelTipoIdentificacionCpthisAnexoCInstance;

    @JsonProperty("p_evctipoidentificacion_oid")
    private TipoIdentificacionOid anexoCDelTipoIdentificacionCpevcTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion anexoCDelTipoIdentificacionCpevcTipoIdentificacionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAnexoCDelTipoIdentificacionCpthisAnexoC();
        checkAnexoCDelTipoIdentificacionCpevcTipoIdentificacion();
    }

    @JsonIgnore
    public AnexoCOid getAnexoCDelTipoIdentificacionCpthisAnexoC() {
        return this.anexoCDelTipoIdentificacionCpthisAnexoC;
    }
    
    public void setAnexoCDelTipoIdentificacionCpthisAnexoC(AnexoCOid anexoCDelTipoIdentificacionCpthisAnexoC) {
        this.anexoCDelTipoIdentificacionCpthisAnexoC = anexoCDelTipoIdentificacionCpthisAnexoC;
    }

    @JsonIgnore
    public AnexoC getAnexoCDelTipoIdentificacionCpthisAnexoCInstance() {
        return this.anexoCDelTipoIdentificacionCpthisAnexoCInstance;
    }
    
    public void setAnexoCDelTipoIdentificacionCpthisAnexoCInstance(AnexoC anexoCDelTipoIdentificacionCpthisAnexoC) {
        this.anexoCDelTipoIdentificacionCpthisAnexoCInstance = anexoCDelTipoIdentificacionCpthisAnexoC;
        this.anexoCDelTipoIdentificacionCpthisAnexoC = anexoCDelTipoIdentificacionCpthisAnexoC != null ? anexoCDelTipoIdentificacionCpthisAnexoC.getOid() : null;
    }

    private void checkAnexoCDelTipoIdentificacionCpthisAnexoC() throws NotNullArgumentException {
        if(this.getAnexoCDelTipoIdentificacionCpthisAnexoCInstance() == null || this.getAnexoCDelTipoIdentificacionCpthisAnexoCInstance().isNull()) {
            throw new NotNullArgumentException(AnexoCConstants.SERV_ID_DELTIPOIDENTIFICACIONC, AnexoCConstants.CLASS_ID, AnexoCConstants.ARG_ID_DELTIPOIDENTIFICACIONC_ANEXOCDELTIPOIDENTIFICACIONCPTHISANEXOC, AnexoCConstants.SERV_ALIAS_DELTIPOIDENTIFICACIONC, AnexoCConstants.CLASS_ALIAS, AnexoCConstants.ARG_ALIAS_DELTIPOIDENTIFICACIONC_ANEXOCDELTIPOIDENTIFICACIONCPTHISANEXOC);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getAnexoCDelTipoIdentificacionCpevcTipoIdentificacion() {
        return this.anexoCDelTipoIdentificacionCpevcTipoIdentificacion;
    }
    
    public void setAnexoCDelTipoIdentificacionCpevcTipoIdentificacion(TipoIdentificacionOid anexoCDelTipoIdentificacionCpevcTipoIdentificacion) {
        this.anexoCDelTipoIdentificacionCpevcTipoIdentificacion = anexoCDelTipoIdentificacionCpevcTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getAnexoCDelTipoIdentificacionCpevcTipoIdentificacionInstance() {
        return this.anexoCDelTipoIdentificacionCpevcTipoIdentificacionInstance;
    }
    
    public void setAnexoCDelTipoIdentificacionCpevcTipoIdentificacionInstance(TipoIdentificacion anexoCDelTipoIdentificacionCpevcTipoIdentificacion) {
        this.anexoCDelTipoIdentificacionCpevcTipoIdentificacionInstance = anexoCDelTipoIdentificacionCpevcTipoIdentificacion;
        this.anexoCDelTipoIdentificacionCpevcTipoIdentificacion = anexoCDelTipoIdentificacionCpevcTipoIdentificacion != null ? anexoCDelTipoIdentificacionCpevcTipoIdentificacion.getOid() : null;
    }

    private void checkAnexoCDelTipoIdentificacionCpevcTipoIdentificacion() throws NotNullArgumentException {
        if(this.getAnexoCDelTipoIdentificacionCpevcTipoIdentificacionInstance() == null || this.getAnexoCDelTipoIdentificacionCpevcTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(AnexoCConstants.SERV_ID_DELTIPOIDENTIFICACIONC, AnexoCConstants.CLASS_ID, AnexoCConstants.ARG_ID_DELTIPOIDENTIFICACIONC_ANEXOCDELTIPOIDENTIFICACIONCPEVCTIPOIDENTIFICACION, AnexoCConstants.SERV_ALIAS_DELTIPOIDENTIFICACIONC, AnexoCConstants.CLASS_ALIAS, AnexoCConstants.ARG_ALIAS_DELTIPOIDENTIFICACIONC_ANEXOCDELTIPOIDENTIFICACIONCPEVCTIPOIDENTIFICACION);
        }
    }
}
