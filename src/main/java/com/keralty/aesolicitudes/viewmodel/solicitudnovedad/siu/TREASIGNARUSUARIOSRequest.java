package com.keralty.aesolicitudes.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudNovedadConstants;
import com.keralty.aesolicitudes.persistence.Funcionario;
import com.keralty.aesolicitudes.persistence.oid.FuncionarioOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudNovedadOid;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;

public class TREASIGNARUSUARIOSRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedadInstance;

    @JsonProperty("ptusrafiliacion_oid")
    private FuncionarioOid solicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacion;
    
    @JsonIgnore
    private Funcionario solicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedad();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedad() {
        return this.solicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedad) {
        this.solicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedad = solicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedad) {
        this.solicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedadInstance = solicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedad;
        this.solicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedad = solicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedad != null ? solicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadTREASIGNARUSUARIOSpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TREASIGNARUSUARIOS, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TREASIGNARUSUARIOS_SOLICITUDNOVEDADTREASIGNARUSUARIOSPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_TREASIGNARUSUARIOS, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TREASIGNARUSUARIOS_SOLICITUDNOVEDADTREASIGNARUSUARIOSPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public FuncionarioOid getSolicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacion() {
        return this.solicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacion;
    }
    
    public void setSolicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacion(FuncionarioOid solicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacion) {
        this.solicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacion = solicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacion;
    }

    @JsonIgnore
    public Funcionario getSolicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacionInstance() {
        return this.solicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacionInstance;
    }
    
    public void setSolicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacionInstance(Funcionario solicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacion) {
        this.solicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacionInstance = solicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacion;
        this.solicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacion = solicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacion != null ? solicitudNovedadTREASIGNARUSUARIOSptUsrAfiliacion.getOid() : null;
    }
}
