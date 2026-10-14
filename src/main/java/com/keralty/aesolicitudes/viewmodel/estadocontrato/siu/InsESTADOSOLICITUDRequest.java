package com.keralty.aesolicitudes.viewmodel.estadocontrato.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.EstadoContratoConstants;
import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.EstadoContrato;
import com.keralty.aesolicitudes.persistence.oid.AesolicitudesOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoContratoOid;

public class InsESTADOSOLICITUDRequest {

    @JsonProperty("p_thisestadocontrato_oid")
    private EstadoContratoOid estadoContratoInsESTADOSOLICITUDpthisEstadoContrato;
    
    @JsonIgnore
    private EstadoContrato estadoContratoInsESTADOSOLICITUDpthisEstadoContratoInstance;

    @JsonProperty("p_evcae_solicitudes_oid")
    private AesolicitudesOid estadoContratoInsESTADOSOLICITUDpevcAesolicitudes;
    
    @JsonIgnore
    private Aesolicitudes estadoContratoInsESTADOSOLICITUDpevcAesolicitudesInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkEstadoContratoInsESTADOSOLICITUDpthisEstadoContrato();
        checkEstadoContratoInsESTADOSOLICITUDpevcAesolicitudes();
    }

    @JsonIgnore
    public EstadoContratoOid getEstadoContratoInsESTADOSOLICITUDpthisEstadoContrato() {
        return this.estadoContratoInsESTADOSOLICITUDpthisEstadoContrato;
    }
    
    public void setEstadoContratoInsESTADOSOLICITUDpthisEstadoContrato(EstadoContratoOid estadoContratoInsESTADOSOLICITUDpthisEstadoContrato) {
        this.estadoContratoInsESTADOSOLICITUDpthisEstadoContrato = estadoContratoInsESTADOSOLICITUDpthisEstadoContrato;
    }

    @JsonIgnore
    public EstadoContrato getEstadoContratoInsESTADOSOLICITUDpthisEstadoContratoInstance() {
        return this.estadoContratoInsESTADOSOLICITUDpthisEstadoContratoInstance;
    }
    
    public void setEstadoContratoInsESTADOSOLICITUDpthisEstadoContratoInstance(EstadoContrato estadoContratoInsESTADOSOLICITUDpthisEstadoContrato) {
        this.estadoContratoInsESTADOSOLICITUDpthisEstadoContratoInstance = estadoContratoInsESTADOSOLICITUDpthisEstadoContrato;
        this.estadoContratoInsESTADOSOLICITUDpthisEstadoContrato = estadoContratoInsESTADOSOLICITUDpthisEstadoContrato != null ? estadoContratoInsESTADOSOLICITUDpthisEstadoContrato.getOid() : null;
    }

    private void checkEstadoContratoInsESTADOSOLICITUDpthisEstadoContrato() throws NotNullArgumentException {
        if(this.getEstadoContratoInsESTADOSOLICITUDpthisEstadoContratoInstance() == null || this.getEstadoContratoInsESTADOSOLICITUDpthisEstadoContratoInstance().isNull()) {
            throw new NotNullArgumentException(EstadoContratoConstants.SERV_ID_INSESTADOSOLICITUD, EstadoContratoConstants.CLASS_ID, EstadoContratoConstants.ARG_ID_INSESTADOSOLICITUD_ESTADOCONTRATOINSESTADOSOLICITUDPTHISESTADOCONTRATO, EstadoContratoConstants.SERV_ALIAS_INSESTADOSOLICITUD, EstadoContratoConstants.CLASS_ALIAS, EstadoContratoConstants.ARG_ALIAS_INSESTADOSOLICITUD_ESTADOCONTRATOINSESTADOSOLICITUDPTHISESTADOCONTRATO);
        }
    }

    @JsonIgnore
    public AesolicitudesOid getEstadoContratoInsESTADOSOLICITUDpevcAesolicitudes() {
        return this.estadoContratoInsESTADOSOLICITUDpevcAesolicitudes;
    }
    
    public void setEstadoContratoInsESTADOSOLICITUDpevcAesolicitudes(AesolicitudesOid estadoContratoInsESTADOSOLICITUDpevcAesolicitudes) {
        this.estadoContratoInsESTADOSOLICITUDpevcAesolicitudes = estadoContratoInsESTADOSOLICITUDpevcAesolicitudes;
    }

    @JsonIgnore
    public Aesolicitudes getEstadoContratoInsESTADOSOLICITUDpevcAesolicitudesInstance() {
        return this.estadoContratoInsESTADOSOLICITUDpevcAesolicitudesInstance;
    }
    
    public void setEstadoContratoInsESTADOSOLICITUDpevcAesolicitudesInstance(Aesolicitudes estadoContratoInsESTADOSOLICITUDpevcAesolicitudes) {
        this.estadoContratoInsESTADOSOLICITUDpevcAesolicitudesInstance = estadoContratoInsESTADOSOLICITUDpevcAesolicitudes;
        this.estadoContratoInsESTADOSOLICITUDpevcAesolicitudes = estadoContratoInsESTADOSOLICITUDpevcAesolicitudes != null ? estadoContratoInsESTADOSOLICITUDpevcAesolicitudes.getOid() : null;
    }

    private void checkEstadoContratoInsESTADOSOLICITUDpevcAesolicitudes() throws NotNullArgumentException {
        if(this.getEstadoContratoInsESTADOSOLICITUDpevcAesolicitudesInstance() == null || this.getEstadoContratoInsESTADOSOLICITUDpevcAesolicitudesInstance().isNull()) {
            throw new NotNullArgumentException(EstadoContratoConstants.SERV_ID_INSESTADOSOLICITUD, EstadoContratoConstants.CLASS_ID, EstadoContratoConstants.ARG_ID_INSESTADOSOLICITUD_ESTADOCONTRATOINSESTADOSOLICITUDPEVCAESOLICITUDES, EstadoContratoConstants.SERV_ALIAS_INSESTADOSOLICITUD, EstadoContratoConstants.CLASS_ALIAS, EstadoContratoConstants.ARG_ALIAS_INSESTADOSOLICITUD_ESTADOCONTRATOINSESTADOSOLICITUDPEVCAESOLICITUDES);
        }
    }
}
