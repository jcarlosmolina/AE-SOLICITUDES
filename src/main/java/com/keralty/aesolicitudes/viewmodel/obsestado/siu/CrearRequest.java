package com.keralty.aesolicitudes.viewmodel.obsestado.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ObsEstadoConstants;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.Funcionario;
import com.keralty.aesolicitudes.persistence.oid.DocumentoGOid;
import com.keralty.aesolicitudes.persistence.oid.FuncionarioOid;

public class CrearRequest {

    @JsonProperty("p_agragente_oid")
    private FuncionarioOid obsEstadocrearpagrAgente;
    
    @JsonIgnore
    private Funcionario obsEstadocrearpagrAgenteInstance;

    @JsonProperty("p_agrdocumentog_oid")
    private DocumentoGOid obsEstadocrearpagrDocumentoG;
    
    @JsonIgnore
    private DocumentoG obsEstadocrearpagrDocumentoGInstance;

    @JsonProperty("p_atrobservacions")
    private String obsEstadocrearpatrObservacions;

    @JsonProperty("p_atrestadoanterior")
    private Long obsEstadocrearpatrEstadoAnterior;

    @JsonProperty("p_atrestadonuevo")
    private Long obsEstadocrearpatrEstadoNuevo;

    public void checkArguments() throws NotNullArgumentException {
        checkObsEstadocrearpagrAgente();
        checkObsEstadocrearpagrDocumentoG();
        checkObsEstadocrearpatrEstadoAnterior();
        checkObsEstadocrearpatrEstadoNuevo();
    }

    @JsonIgnore
    public FuncionarioOid getObsEstadocrearpagrAgente() {
        return this.obsEstadocrearpagrAgente;
    }
    
    public void setObsEstadocrearpagrAgente(FuncionarioOid obsEstadocrearpagrAgente) {
        this.obsEstadocrearpagrAgente = obsEstadocrearpagrAgente;
    }

    @JsonIgnore
    public Funcionario getObsEstadocrearpagrAgenteInstance() {
        return this.obsEstadocrearpagrAgenteInstance;
    }
    
    public void setObsEstadocrearpagrAgenteInstance(Funcionario obsEstadocrearpagrAgente) {
        this.obsEstadocrearpagrAgenteInstance = obsEstadocrearpagrAgente;
        this.obsEstadocrearpagrAgente = obsEstadocrearpagrAgente != null ? obsEstadocrearpagrAgente.getOid() : null;
    }

    private void checkObsEstadocrearpagrAgente() throws NotNullArgumentException {
        if(this.getObsEstadocrearpagrAgenteInstance() == null || this.getObsEstadocrearpagrAgenteInstance().isNull()) {
            throw new NotNullArgumentException(ObsEstadoConstants.SERV_ID_CREAR, ObsEstadoConstants.CLASS_ID, ObsEstadoConstants.ARG_ID_CREAR_OBSESTADOCREARPAGRAGENTE, ObsEstadoConstants.SERV_ALIAS_CREAR, ObsEstadoConstants.CLASS_ALIAS, ObsEstadoConstants.ARG_ALIAS_CREAR_OBSESTADOCREARPAGRAGENTE);
        }
    }

    @JsonIgnore
    public DocumentoGOid getObsEstadocrearpagrDocumentoG() {
        return this.obsEstadocrearpagrDocumentoG;
    }
    
    public void setObsEstadocrearpagrDocumentoG(DocumentoGOid obsEstadocrearpagrDocumentoG) {
        this.obsEstadocrearpagrDocumentoG = obsEstadocrearpagrDocumentoG;
    }

    @JsonIgnore
    public DocumentoG getObsEstadocrearpagrDocumentoGInstance() {
        return this.obsEstadocrearpagrDocumentoGInstance;
    }
    
    public void setObsEstadocrearpagrDocumentoGInstance(DocumentoG obsEstadocrearpagrDocumentoG) {
        this.obsEstadocrearpagrDocumentoGInstance = obsEstadocrearpagrDocumentoG;
        this.obsEstadocrearpagrDocumentoG = obsEstadocrearpagrDocumentoG != null ? obsEstadocrearpagrDocumentoG.getOid() : null;
    }

    private void checkObsEstadocrearpagrDocumentoG() throws NotNullArgumentException {
        if(this.getObsEstadocrearpagrDocumentoGInstance() == null || this.getObsEstadocrearpagrDocumentoGInstance().isNull()) {
            throw new NotNullArgumentException(ObsEstadoConstants.SERV_ID_CREAR, ObsEstadoConstants.CLASS_ID, ObsEstadoConstants.ARG_ID_CREAR_OBSESTADOCREARPAGRDOCUMENTOG, ObsEstadoConstants.SERV_ALIAS_CREAR, ObsEstadoConstants.CLASS_ALIAS, ObsEstadoConstants.ARG_ALIAS_CREAR_OBSESTADOCREARPAGRDOCUMENTOG);
        }
    }

    @JsonIgnore
    public String getObsEstadocrearpatrObservacions() {
        return this.obsEstadocrearpatrObservacions;
    }
    
    public void setObsEstadocrearpatrObservacions(String obsEstadocrearpatrObservacions) {
        this.obsEstadocrearpatrObservacions = obsEstadocrearpatrObservacions;
    }

    @JsonIgnore
    public Long getObsEstadocrearpatrEstadoAnterior() {
        return this.obsEstadocrearpatrEstadoAnterior;
    }
    
    public void setObsEstadocrearpatrEstadoAnterior(Long obsEstadocrearpatrEstadoAnterior) {
        this.obsEstadocrearpatrEstadoAnterior = obsEstadocrearpatrEstadoAnterior;
    }

    private void checkObsEstadocrearpatrEstadoAnterior() throws NotNullArgumentException {
        if(this.getObsEstadocrearpatrEstadoAnterior() == null) {
            throw new NotNullArgumentException(ObsEstadoConstants.SERV_ID_CREAR, ObsEstadoConstants.CLASS_ID, ObsEstadoConstants.ARG_ID_CREAR_OBSESTADOCREARPATRESTADOANTERIOR, ObsEstadoConstants.SERV_ALIAS_CREAR, ObsEstadoConstants.CLASS_ALIAS, ObsEstadoConstants.ARG_ALIAS_CREAR_OBSESTADOCREARPATRESTADOANTERIOR);
        }
    }

    @JsonIgnore
    public Long getObsEstadocrearpatrEstadoNuevo() {
        return this.obsEstadocrearpatrEstadoNuevo;
    }
    
    public void setObsEstadocrearpatrEstadoNuevo(Long obsEstadocrearpatrEstadoNuevo) {
        this.obsEstadocrearpatrEstadoNuevo = obsEstadocrearpatrEstadoNuevo;
    }

    private void checkObsEstadocrearpatrEstadoNuevo() throws NotNullArgumentException {
        if(this.getObsEstadocrearpatrEstadoNuevo() == null) {
            throw new NotNullArgumentException(ObsEstadoConstants.SERV_ID_CREAR, ObsEstadoConstants.CLASS_ID, ObsEstadoConstants.ARG_ID_CREAR_OBSESTADOCREARPATRESTADONUEVO, ObsEstadoConstants.SERV_ALIAS_CREAR, ObsEstadoConstants.CLASS_ALIAS, ObsEstadoConstants.ARG_ALIAS_CREAR_OBSESTADOCREARPATRESTADONUEVO);
        }
    }
}
