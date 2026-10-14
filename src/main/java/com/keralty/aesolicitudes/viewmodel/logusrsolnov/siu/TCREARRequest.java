package com.keralty.aesolicitudes.viewmodel.logusrsolnov.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.LogUsrSolNovConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudNovedadOid;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;

public class TCREARRequest {

    @JsonProperty("pt_p_agrsolicitudnovedad_oid")
    private SolicitudNovedadOid logUsrSolNovTCREARptpagrSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad logUsrSolNovTCREARptpagrSolicitudNovedadInstance;

    @JsonProperty("pt_p_atrusuario")
    private String logUsrSolNovTCREARptpatrUsuario;

    public void checkArguments() throws NotNullArgumentException {
        checkLogUsrSolNovTCREARptpagrSolicitudNovedad();
        checkLogUsrSolNovTCREARptpatrUsuario();
    }

    @JsonIgnore
    public SolicitudNovedadOid getLogUsrSolNovTCREARptpagrSolicitudNovedad() {
        return this.logUsrSolNovTCREARptpagrSolicitudNovedad;
    }
    
    public void setLogUsrSolNovTCREARptpagrSolicitudNovedad(SolicitudNovedadOid logUsrSolNovTCREARptpagrSolicitudNovedad) {
        this.logUsrSolNovTCREARptpagrSolicitudNovedad = logUsrSolNovTCREARptpagrSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getLogUsrSolNovTCREARptpagrSolicitudNovedadInstance() {
        return this.logUsrSolNovTCREARptpagrSolicitudNovedadInstance;
    }
    
    public void setLogUsrSolNovTCREARptpagrSolicitudNovedadInstance(SolicitudNovedad logUsrSolNovTCREARptpagrSolicitudNovedad) {
        this.logUsrSolNovTCREARptpagrSolicitudNovedadInstance = logUsrSolNovTCREARptpagrSolicitudNovedad;
        this.logUsrSolNovTCREARptpagrSolicitudNovedad = logUsrSolNovTCREARptpagrSolicitudNovedad != null ? logUsrSolNovTCREARptpagrSolicitudNovedad.getOid() : null;
    }

    private void checkLogUsrSolNovTCREARptpagrSolicitudNovedad() throws NotNullArgumentException {
        if(this.getLogUsrSolNovTCREARptpagrSolicitudNovedadInstance() == null || this.getLogUsrSolNovTCREARptpagrSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(LogUsrSolNovConstants.SERV_ID_TCREAR, LogUsrSolNovConstants.CLASS_ID, LogUsrSolNovConstants.ARG_ID_TCREAR_LOGUSRSOLNOVTCREARPTPAGRSOLICITUDNOVEDAD, LogUsrSolNovConstants.SERV_ALIAS_TCREAR, LogUsrSolNovConstants.CLASS_ALIAS, LogUsrSolNovConstants.ARG_ALIAS_TCREAR_LOGUSRSOLNOVTCREARPTPAGRSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public String getLogUsrSolNovTCREARptpatrUsuario() {
        return this.logUsrSolNovTCREARptpatrUsuario;
    }
    
    public void setLogUsrSolNovTCREARptpatrUsuario(String logUsrSolNovTCREARptpatrUsuario) {
        this.logUsrSolNovTCREARptpatrUsuario = logUsrSolNovTCREARptpatrUsuario;
    }

    private void checkLogUsrSolNovTCREARptpatrUsuario() throws NotNullArgumentException {
        if(this.getLogUsrSolNovTCREARptpatrUsuario() == null) {
            throw new NotNullArgumentException(LogUsrSolNovConstants.SERV_ID_TCREAR, LogUsrSolNovConstants.CLASS_ID, LogUsrSolNovConstants.ARG_ID_TCREAR_LOGUSRSOLNOVTCREARPTPATRUSUARIO, LogUsrSolNovConstants.SERV_ALIAS_TCREAR, LogUsrSolNovConstants.CLASS_ALIAS, LogUsrSolNovConstants.ARG_ALIAS_TCREAR_LOGUSRSOLNOVTCREARPTPATRUSUARIO);
        }
    }
}
