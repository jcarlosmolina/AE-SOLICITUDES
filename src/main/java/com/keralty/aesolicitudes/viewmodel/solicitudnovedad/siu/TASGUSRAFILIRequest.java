package com.keralty.aesolicitudes.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudNovedadConstants;
import com.keralty.aesolicitudes.persistence.Funcionario;
import com.keralty.aesolicitudes.persistence.oid.FuncionarioOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudNovedadOid;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;

public class TASGUSRAFILIRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadTASGUSRAFILIpthisSolicitudNovedadInstance;

    @JsonProperty("ptfuncionario_oid")
    private FuncionarioOid solicitudNovedadTASGUSRAFILIptFuncionario;
    
    @JsonIgnore
    private Funcionario solicitudNovedadTASGUSRAFILIptFuncionarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadTASGUSRAFILIpthisSolicitudNovedad();
        checkSolicitudNovedadTASGUSRAFILIptFuncionario();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadTASGUSRAFILIpthisSolicitudNovedad() {
        return this.solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadTASGUSRAFILIpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad) {
        this.solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad = solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadTASGUSRAFILIpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadTASGUSRAFILIpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadTASGUSRAFILIpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad) {
        this.solicitudNovedadTASGUSRAFILIpthisSolicitudNovedadInstance = solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad;
        this.solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad = solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad != null ? solicitudNovedadTASGUSRAFILIpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadTASGUSRAFILIpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTASGUSRAFILIpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadTASGUSRAFILIpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TASGUSRAFILI, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TASGUSRAFILI_SOLICITUDNOVEDADTASGUSRAFILIPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_TASGUSRAFILI, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TASGUSRAFILI_SOLICITUDNOVEDADTASGUSRAFILIPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public FuncionarioOid getSolicitudNovedadTASGUSRAFILIptFuncionario() {
        return this.solicitudNovedadTASGUSRAFILIptFuncionario;
    }
    
    public void setSolicitudNovedadTASGUSRAFILIptFuncionario(FuncionarioOid solicitudNovedadTASGUSRAFILIptFuncionario) {
        this.solicitudNovedadTASGUSRAFILIptFuncionario = solicitudNovedadTASGUSRAFILIptFuncionario;
    }

    @JsonIgnore
    public Funcionario getSolicitudNovedadTASGUSRAFILIptFuncionarioInstance() {
        return this.solicitudNovedadTASGUSRAFILIptFuncionarioInstance;
    }
    
    public void setSolicitudNovedadTASGUSRAFILIptFuncionarioInstance(Funcionario solicitudNovedadTASGUSRAFILIptFuncionario) {
        this.solicitudNovedadTASGUSRAFILIptFuncionarioInstance = solicitudNovedadTASGUSRAFILIptFuncionario;
        this.solicitudNovedadTASGUSRAFILIptFuncionario = solicitudNovedadTASGUSRAFILIptFuncionario != null ? solicitudNovedadTASGUSRAFILIptFuncionario.getOid() : null;
    }

    private void checkSolicitudNovedadTASGUSRAFILIptFuncionario() throws NotNullArgumentException {
        if(this.getSolicitudNovedadTASGUSRAFILIptFuncionarioInstance() == null || this.getSolicitudNovedadTASGUSRAFILIptFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_TASGUSRAFILI, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_TASGUSRAFILI_SOLICITUDNOVEDADTASGUSRAFILIPTFUNCIONARIO, SolicitudNovedadConstants.SERV_ALIAS_TASGUSRAFILI, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_TASGUSRAFILI_SOLICITUDNOVEDADTASGUSRAFILIPTFUNCIONARIO);
        }
    }
}
