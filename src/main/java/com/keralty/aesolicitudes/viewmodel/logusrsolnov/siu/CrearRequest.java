package com.keralty.aesolicitudes.viewmodel.logusrsolnov.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.LogUsrSolNovConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudNovedadOid;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;

public class CrearRequest {

    @JsonProperty("p_agrsolicitudnovedad_oid")
    private SolicitudNovedadOid logUsrSolNovcrearpagrSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad logUsrSolNovcrearpagrSolicitudNovedadInstance;

    @JsonProperty("p_atrloginfuncionario")
    private String logUsrSolNovcrearpatrLoginFuncionario;

    @JsonProperty("p_atrusuario")
    private String logUsrSolNovcrearpatrUsuario;

    public void checkArguments() throws NotNullArgumentException {
        checkLogUsrSolNovcrearpagrSolicitudNovedad();
        checkLogUsrSolNovcrearpatrLoginFuncionario();
        checkLogUsrSolNovcrearpatrUsuario();
    }

    @JsonIgnore
    public SolicitudNovedadOid getLogUsrSolNovcrearpagrSolicitudNovedad() {
        return this.logUsrSolNovcrearpagrSolicitudNovedad;
    }
    
    public void setLogUsrSolNovcrearpagrSolicitudNovedad(SolicitudNovedadOid logUsrSolNovcrearpagrSolicitudNovedad) {
        this.logUsrSolNovcrearpagrSolicitudNovedad = logUsrSolNovcrearpagrSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getLogUsrSolNovcrearpagrSolicitudNovedadInstance() {
        return this.logUsrSolNovcrearpagrSolicitudNovedadInstance;
    }
    
    public void setLogUsrSolNovcrearpagrSolicitudNovedadInstance(SolicitudNovedad logUsrSolNovcrearpagrSolicitudNovedad) {
        this.logUsrSolNovcrearpagrSolicitudNovedadInstance = logUsrSolNovcrearpagrSolicitudNovedad;
        this.logUsrSolNovcrearpagrSolicitudNovedad = logUsrSolNovcrearpagrSolicitudNovedad != null ? logUsrSolNovcrearpagrSolicitudNovedad.getOid() : null;
    }

    private void checkLogUsrSolNovcrearpagrSolicitudNovedad() throws NotNullArgumentException {
        if(this.getLogUsrSolNovcrearpagrSolicitudNovedadInstance() == null || this.getLogUsrSolNovcrearpagrSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(LogUsrSolNovConstants.SERV_ID_CREAR, LogUsrSolNovConstants.CLASS_ID, LogUsrSolNovConstants.ARG_ID_CREAR_LOGUSRSOLNOVCREARPAGRSOLICITUDNOVEDAD, LogUsrSolNovConstants.SERV_ALIAS_CREAR, LogUsrSolNovConstants.CLASS_ALIAS, LogUsrSolNovConstants.ARG_ALIAS_CREAR_LOGUSRSOLNOVCREARPAGRSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public String getLogUsrSolNovcrearpatrLoginFuncionario() {
        return this.logUsrSolNovcrearpatrLoginFuncionario;
    }
    
    public void setLogUsrSolNovcrearpatrLoginFuncionario(String logUsrSolNovcrearpatrLoginFuncionario) {
        this.logUsrSolNovcrearpatrLoginFuncionario = logUsrSolNovcrearpatrLoginFuncionario;
    }

    private void checkLogUsrSolNovcrearpatrLoginFuncionario() throws NotNullArgumentException {
        if(this.getLogUsrSolNovcrearpatrLoginFuncionario() == null) {
            throw new NotNullArgumentException(LogUsrSolNovConstants.SERV_ID_CREAR, LogUsrSolNovConstants.CLASS_ID, LogUsrSolNovConstants.ARG_ID_CREAR_LOGUSRSOLNOVCREARPATRLOGINFUNCIONARIO, LogUsrSolNovConstants.SERV_ALIAS_CREAR, LogUsrSolNovConstants.CLASS_ALIAS, LogUsrSolNovConstants.ARG_ALIAS_CREAR_LOGUSRSOLNOVCREARPATRLOGINFUNCIONARIO);
        }
    }

    @JsonIgnore
    public String getLogUsrSolNovcrearpatrUsuario() {
        return this.logUsrSolNovcrearpatrUsuario;
    }
    
    public void setLogUsrSolNovcrearpatrUsuario(String logUsrSolNovcrearpatrUsuario) {
        this.logUsrSolNovcrearpatrUsuario = logUsrSolNovcrearpatrUsuario;
    }

    private void checkLogUsrSolNovcrearpatrUsuario() throws NotNullArgumentException {
        if(this.getLogUsrSolNovcrearpatrUsuario() == null) {
            throw new NotNullArgumentException(LogUsrSolNovConstants.SERV_ID_CREAR, LogUsrSolNovConstants.CLASS_ID, LogUsrSolNovConstants.ARG_ID_CREAR_LOGUSRSOLNOVCREARPATRUSUARIO, LogUsrSolNovConstants.SERV_ALIAS_CREAR, LogUsrSolNovConstants.CLASS_ALIAS, LogUsrSolNovConstants.ARG_ALIAS_CREAR_LOGUSRSOLNOVCREARPATRUSUARIO);
        }
    }
}
