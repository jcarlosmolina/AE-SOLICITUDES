package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.AreaMedica;
import com.keralty.aesolicitudes.persistence.Funcionario;
import com.keralty.aesolicitudes.persistence.oid.AreaMedicaOid;
import com.keralty.aesolicitudes.persistence.oid.FuncionarioOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TREASIGNARUSUARIOSRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTREASIGNARUSUARIOSpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTREASIGNARUSUARIOSpthisSolicitudInstance;

    @JsonProperty("ptusrafiliacion_oid")
    private FuncionarioOid solicitudTREASIGNARUSUARIOSptUsrAfiliacion;
    
    @JsonIgnore
    private Funcionario solicitudTREASIGNARUSUARIOSptUsrAfiliacionInstance;

    @JsonProperty("ptusrareamedica_oid")
    private AreaMedicaOid solicitudTREASIGNARUSUARIOSptUsrAreaMedica;
    
    @JsonIgnore
    private AreaMedica solicitudTREASIGNARUSUARIOSptUsrAreaMedicaInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTREASIGNARUSUARIOSpthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTREASIGNARUSUARIOSpthisSolicitud() {
        return this.solicitudTREASIGNARUSUARIOSpthisSolicitud;
    }
    
    public void setSolicitudTREASIGNARUSUARIOSpthisSolicitud(SolicitudOid solicitudTREASIGNARUSUARIOSpthisSolicitud) {
        this.solicitudTREASIGNARUSUARIOSpthisSolicitud = solicitudTREASIGNARUSUARIOSpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTREASIGNARUSUARIOSpthisSolicitudInstance() {
        return this.solicitudTREASIGNARUSUARIOSpthisSolicitudInstance;
    }
    
    public void setSolicitudTREASIGNARUSUARIOSpthisSolicitudInstance(Solicitud solicitudTREASIGNARUSUARIOSpthisSolicitud) {
        this.solicitudTREASIGNARUSUARIOSpthisSolicitudInstance = solicitudTREASIGNARUSUARIOSpthisSolicitud;
        this.solicitudTREASIGNARUSUARIOSpthisSolicitud = solicitudTREASIGNARUSUARIOSpthisSolicitud != null ? solicitudTREASIGNARUSUARIOSpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTREASIGNARUSUARIOSpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTREASIGNARUSUARIOSpthisSolicitudInstance() == null || this.getSolicitudTREASIGNARUSUARIOSpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TREASIGNARUSUARIOS, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TREASIGNARUSUARIOS_SOLICITUDTREASIGNARUSUARIOSPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TREASIGNARUSUARIOS, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TREASIGNARUSUARIOS_SOLICITUDTREASIGNARUSUARIOSPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public FuncionarioOid getSolicitudTREASIGNARUSUARIOSptUsrAfiliacion() {
        return this.solicitudTREASIGNARUSUARIOSptUsrAfiliacion;
    }
    
    public void setSolicitudTREASIGNARUSUARIOSptUsrAfiliacion(FuncionarioOid solicitudTREASIGNARUSUARIOSptUsrAfiliacion) {
        this.solicitudTREASIGNARUSUARIOSptUsrAfiliacion = solicitudTREASIGNARUSUARIOSptUsrAfiliacion;
    }

    @JsonIgnore
    public Funcionario getSolicitudTREASIGNARUSUARIOSptUsrAfiliacionInstance() {
        return this.solicitudTREASIGNARUSUARIOSptUsrAfiliacionInstance;
    }
    
    public void setSolicitudTREASIGNARUSUARIOSptUsrAfiliacionInstance(Funcionario solicitudTREASIGNARUSUARIOSptUsrAfiliacion) {
        this.solicitudTREASIGNARUSUARIOSptUsrAfiliacionInstance = solicitudTREASIGNARUSUARIOSptUsrAfiliacion;
        this.solicitudTREASIGNARUSUARIOSptUsrAfiliacion = solicitudTREASIGNARUSUARIOSptUsrAfiliacion != null ? solicitudTREASIGNARUSUARIOSptUsrAfiliacion.getOid() : null;
    }

    @JsonIgnore
    public AreaMedicaOid getSolicitudTREASIGNARUSUARIOSptUsrAreaMedica() {
        return this.solicitudTREASIGNARUSUARIOSptUsrAreaMedica;
    }
    
    public void setSolicitudTREASIGNARUSUARIOSptUsrAreaMedica(AreaMedicaOid solicitudTREASIGNARUSUARIOSptUsrAreaMedica) {
        this.solicitudTREASIGNARUSUARIOSptUsrAreaMedica = solicitudTREASIGNARUSUARIOSptUsrAreaMedica;
    }

    @JsonIgnore
    public AreaMedica getSolicitudTREASIGNARUSUARIOSptUsrAreaMedicaInstance() {
        return this.solicitudTREASIGNARUSUARIOSptUsrAreaMedicaInstance;
    }
    
    public void setSolicitudTREASIGNARUSUARIOSptUsrAreaMedicaInstance(AreaMedica solicitudTREASIGNARUSUARIOSptUsrAreaMedica) {
        this.solicitudTREASIGNARUSUARIOSptUsrAreaMedicaInstance = solicitudTREASIGNARUSUARIOSptUsrAreaMedica;
        this.solicitudTREASIGNARUSUARIOSptUsrAreaMedica = solicitudTREASIGNARUSUARIOSptUsrAreaMedica != null ? solicitudTREASIGNARUSUARIOSptUsrAreaMedica.getOid() : null;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
