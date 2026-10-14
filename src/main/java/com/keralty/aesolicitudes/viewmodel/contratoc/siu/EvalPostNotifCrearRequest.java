package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class EvalPostNotifCrearRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCevalPostNotifCrearpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCevalPostNotifCrearpthisContratoCInstance;

    @JsonProperty("p_numcontrato")
    private String contratoCevalPostNotifCrearpNumContrato;

    @JsonProperty("p_tipocontrato")
    private Long contratoCevalPostNotifCrearpTipoContrato;

    @JsonProperty("p_fechainivigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date contratoCevalPostNotifCrearpFechaIniVigencia;

    @JsonProperty("p_direccion")
    private String contratoCevalPostNotifCrearpDireccion;

    @JsonProperty("p_numtelcontratante")
    private String contratoCevalPostNotifCrearpnumTelContratante;

    @JsonProperty("p_numcelcontratante")
    private String contratoCevalPostNotifCrearpnumCelContratante;

    @JsonProperty("p_fechafinvigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date contratoCevalPostNotifCrearpFechaFinVigencia;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCevalPostNotifCrearpthisContratoC();
    }

    @JsonIgnore
    public ContratoCOid getContratoCevalPostNotifCrearpthisContratoC() {
        return this.contratoCevalPostNotifCrearpthisContratoC;
    }
    
    public void setContratoCevalPostNotifCrearpthisContratoC(ContratoCOid contratoCevalPostNotifCrearpthisContratoC) {
        this.contratoCevalPostNotifCrearpthisContratoC = contratoCevalPostNotifCrearpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCevalPostNotifCrearpthisContratoCInstance() {
        return this.contratoCevalPostNotifCrearpthisContratoCInstance;
    }
    
    public void setContratoCevalPostNotifCrearpthisContratoCInstance(ContratoC contratoCevalPostNotifCrearpthisContratoC) {
        this.contratoCevalPostNotifCrearpthisContratoCInstance = contratoCevalPostNotifCrearpthisContratoC;
        this.contratoCevalPostNotifCrearpthisContratoC = contratoCevalPostNotifCrearpthisContratoC != null ? contratoCevalPostNotifCrearpthisContratoC.getOid() : null;
    }

    private void checkContratoCevalPostNotifCrearpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCevalPostNotifCrearpthisContratoCInstance() == null || this.getContratoCevalPostNotifCrearpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_EVALPOSTNOTIFCREAR, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_EVALPOSTNOTIFCREAR_CONTRATOCEVALPOSTNOTIFCREARPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_EVALPOSTNOTIFCREAR, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_EVALPOSTNOTIFCREAR_CONTRATOCEVALPOSTNOTIFCREARPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public String getContratoCevalPostNotifCrearpNumContrato() {
        return this.contratoCevalPostNotifCrearpNumContrato;
    }
    
    public void setContratoCevalPostNotifCrearpNumContrato(String contratoCevalPostNotifCrearpNumContrato) {
        this.contratoCevalPostNotifCrearpNumContrato = contratoCevalPostNotifCrearpNumContrato;
    }

    @JsonIgnore
    public Long getContratoCevalPostNotifCrearpTipoContrato() {
        return this.contratoCevalPostNotifCrearpTipoContrato;
    }
    
    public void setContratoCevalPostNotifCrearpTipoContrato(Long contratoCevalPostNotifCrearpTipoContrato) {
        this.contratoCevalPostNotifCrearpTipoContrato = contratoCevalPostNotifCrearpTipoContrato;
    }

    @JsonIgnore
    public Date getContratoCevalPostNotifCrearpFechaIniVigencia() {
        return this.contratoCevalPostNotifCrearpFechaIniVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setContratoCevalPostNotifCrearpFechaIniVigencia(Date contratoCevalPostNotifCrearpFechaIniVigencia) {
        this.contratoCevalPostNotifCrearpFechaIniVigencia = contratoCevalPostNotifCrearpFechaIniVigencia;
    }

    @JsonIgnore
    public String getContratoCevalPostNotifCrearpDireccion() {
        return this.contratoCevalPostNotifCrearpDireccion;
    }
    
    public void setContratoCevalPostNotifCrearpDireccion(String contratoCevalPostNotifCrearpDireccion) {
        this.contratoCevalPostNotifCrearpDireccion = contratoCevalPostNotifCrearpDireccion;
    }

    @JsonIgnore
    public String getContratoCevalPostNotifCrearpnumTelContratante() {
        return this.contratoCevalPostNotifCrearpnumTelContratante;
    }
    
    public void setContratoCevalPostNotifCrearpnumTelContratante(String contratoCevalPostNotifCrearpnumTelContratante) {
        this.contratoCevalPostNotifCrearpnumTelContratante = contratoCevalPostNotifCrearpnumTelContratante;
    }

    @JsonIgnore
    public String getContratoCevalPostNotifCrearpnumCelContratante() {
        return this.contratoCevalPostNotifCrearpnumCelContratante;
    }
    
    public void setContratoCevalPostNotifCrearpnumCelContratante(String contratoCevalPostNotifCrearpnumCelContratante) {
        this.contratoCevalPostNotifCrearpnumCelContratante = contratoCevalPostNotifCrearpnumCelContratante;
    }

    @JsonIgnore
    public Date getContratoCevalPostNotifCrearpFechaFinVigencia() {
        return this.contratoCevalPostNotifCrearpFechaFinVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setContratoCevalPostNotifCrearpFechaFinVigencia(Date contratoCevalPostNotifCrearpFechaFinVigencia) {
        this.contratoCevalPostNotifCrearpFechaFinVigencia = contratoCevalPostNotifCrearpFechaFinVigencia;
    }
}
