package com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.AesolicitudesConstants;
import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.EstadoContrato;
import com.keralty.aesolicitudes.persistence.oid.AesolicitudesOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoContratoOid;

public class InsESTADOSOLICITUDRequest {

    @JsonProperty("p_thisae_solicitudes_oid")
    private AesolicitudesOid aesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDES;
    
    @JsonIgnore
    private Aesolicitudes aesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDESInstance;

    @JsonProperty("p_evcestadocontrato_oid")
    private EstadoContratoOid aesolicitudesInsESTADOSOLICITUDpevcEstadoContrato;
    
    @JsonIgnore
    private EstadoContrato aesolicitudesInsESTADOSOLICITUDpevcEstadoContratoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDES();
        checkAesolicitudesInsESTADOSOLICITUDpevcEstadoContrato();
    }

    @JsonIgnore
    public AesolicitudesOid getAesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDES() {
        return this.aesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDES;
    }
    
    public void setAesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDES(AesolicitudesOid aesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDES) {
        this.aesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDES = aesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDES;
    }

    @JsonIgnore
    public Aesolicitudes getAesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDESInstance() {
        return this.aesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDESInstance;
    }
    
    public void setAesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDESInstance(Aesolicitudes aesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDES) {
        this.aesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDESInstance = aesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDES;
        this.aesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDES = aesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDES != null ? aesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDES.getOid() : null;
    }

    private void checkAesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDES() throws NotNullArgumentException {
        if(this.getAesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDESInstance() == null || this.getAesolicitudesInsESTADOSOLICITUDpthisAESOLICITUDESInstance().isNull()) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_INSESTADOSOLICITUD, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_INSESTADOSOLICITUD_AESOLICITUDESINSESTADOSOLICITUDPTHISAESOLICITUDES, AesolicitudesConstants.SERV_ALIAS_INSESTADOSOLICITUD, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_INSESTADOSOLICITUD_AESOLICITUDESINSESTADOSOLICITUDPTHISAESOLICITUDES);
        }
    }

    @JsonIgnore
    public EstadoContratoOid getAesolicitudesInsESTADOSOLICITUDpevcEstadoContrato() {
        return this.aesolicitudesInsESTADOSOLICITUDpevcEstadoContrato;
    }
    
    public void setAesolicitudesInsESTADOSOLICITUDpevcEstadoContrato(EstadoContratoOid aesolicitudesInsESTADOSOLICITUDpevcEstadoContrato) {
        this.aesolicitudesInsESTADOSOLICITUDpevcEstadoContrato = aesolicitudesInsESTADOSOLICITUDpevcEstadoContrato;
    }

    @JsonIgnore
    public EstadoContrato getAesolicitudesInsESTADOSOLICITUDpevcEstadoContratoInstance() {
        return this.aesolicitudesInsESTADOSOLICITUDpevcEstadoContratoInstance;
    }
    
    public void setAesolicitudesInsESTADOSOLICITUDpevcEstadoContratoInstance(EstadoContrato aesolicitudesInsESTADOSOLICITUDpevcEstadoContrato) {
        this.aesolicitudesInsESTADOSOLICITUDpevcEstadoContratoInstance = aesolicitudesInsESTADOSOLICITUDpevcEstadoContrato;
        this.aesolicitudesInsESTADOSOLICITUDpevcEstadoContrato = aesolicitudesInsESTADOSOLICITUDpevcEstadoContrato != null ? aesolicitudesInsESTADOSOLICITUDpevcEstadoContrato.getOid() : null;
    }

    private void checkAesolicitudesInsESTADOSOLICITUDpevcEstadoContrato() throws NotNullArgumentException {
        if(this.getAesolicitudesInsESTADOSOLICITUDpevcEstadoContratoInstance() == null || this.getAesolicitudesInsESTADOSOLICITUDpevcEstadoContratoInstance().isNull()) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_INSESTADOSOLICITUD, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_INSESTADOSOLICITUD_AESOLICITUDESINSESTADOSOLICITUDPEVCESTADOCONTRATO, AesolicitudesConstants.SERV_ALIAS_INSESTADOSOLICITUD, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_INSESTADOSOLICITUD_AESOLICITUDESINSESTADOSOLICITUDPEVCESTADOCONTRATO);
        }
    }
}
