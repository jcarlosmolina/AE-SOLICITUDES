package com.keralty.aesolicitudes.viewmodel.tipoidentificacion.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.TipoIdentificacionConstants;
import com.keralty.aesolicitudes.persistence.AnexoC;
import com.keralty.aesolicitudes.persistence.oid.AnexoCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoIdentificacionOid;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;

public class InsTipoIdentificacionCRequest {

    @JsonProperty("p_thistipoidentificacion_oid")
    private TipoIdentificacionOid tipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion tipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacionInstance;

    @JsonProperty("p_evcanexoc_oid")
    private AnexoCOid tipoIdentificacionInsTipoIdentificacionCpevcAnexoC;
    
    @JsonIgnore
    private AnexoC tipoIdentificacionInsTipoIdentificacionCpevcAnexoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacion();
        checkTipoIdentificacionInsTipoIdentificacionCpevcAnexoC();
    }

    @JsonIgnore
    public TipoIdentificacionOid getTipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacion() {
        return this.tipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacion;
    }
    
    public void setTipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacion(TipoIdentificacionOid tipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacion) {
        this.tipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacion = tipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getTipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacionInstance() {
        return this.tipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacionInstance;
    }
    
    public void setTipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacionInstance(TipoIdentificacion tipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacion) {
        this.tipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacionInstance = tipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacion;
        this.tipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacion = tipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacion != null ? tipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacion.getOid() : null;
    }

    private void checkTipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacion() throws NotNullArgumentException {
        if(this.getTipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacionInstance() == null || this.getTipoIdentificacionInsTipoIdentificacionCpthisTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_INSTIPOIDENTIFICACIONC, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_INSTIPOIDENTIFICACIONC_TIPOIDENTIFICACIONINSTIPOIDENTIFICACIONCPTHISTIPOIDENTIFICACION, TipoIdentificacionConstants.SERV_ALIAS_INSTIPOIDENTIFICACIONC, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_INSTIPOIDENTIFICACIONC_TIPOIDENTIFICACIONINSTIPOIDENTIFICACIONCPTHISTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public AnexoCOid getTipoIdentificacionInsTipoIdentificacionCpevcAnexoC() {
        return this.tipoIdentificacionInsTipoIdentificacionCpevcAnexoC;
    }
    
    public void setTipoIdentificacionInsTipoIdentificacionCpevcAnexoC(AnexoCOid tipoIdentificacionInsTipoIdentificacionCpevcAnexoC) {
        this.tipoIdentificacionInsTipoIdentificacionCpevcAnexoC = tipoIdentificacionInsTipoIdentificacionCpevcAnexoC;
    }

    @JsonIgnore
    public AnexoC getTipoIdentificacionInsTipoIdentificacionCpevcAnexoCInstance() {
        return this.tipoIdentificacionInsTipoIdentificacionCpevcAnexoCInstance;
    }
    
    public void setTipoIdentificacionInsTipoIdentificacionCpevcAnexoCInstance(AnexoC tipoIdentificacionInsTipoIdentificacionCpevcAnexoC) {
        this.tipoIdentificacionInsTipoIdentificacionCpevcAnexoCInstance = tipoIdentificacionInsTipoIdentificacionCpevcAnexoC;
        this.tipoIdentificacionInsTipoIdentificacionCpevcAnexoC = tipoIdentificacionInsTipoIdentificacionCpevcAnexoC != null ? tipoIdentificacionInsTipoIdentificacionCpevcAnexoC.getOid() : null;
    }

    private void checkTipoIdentificacionInsTipoIdentificacionCpevcAnexoC() throws NotNullArgumentException {
        if(this.getTipoIdentificacionInsTipoIdentificacionCpevcAnexoCInstance() == null || this.getTipoIdentificacionInsTipoIdentificacionCpevcAnexoCInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_INSTIPOIDENTIFICACIONC, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_INSTIPOIDENTIFICACIONC_TIPOIDENTIFICACIONINSTIPOIDENTIFICACIONCPEVCANEXOC, TipoIdentificacionConstants.SERV_ALIAS_INSTIPOIDENTIFICACIONC, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_INSTIPOIDENTIFICACIONC_TIPOIDENTIFICACIONINSTIPOIDENTIFICACIONCPEVCANEXOC);
        }
    }
}
