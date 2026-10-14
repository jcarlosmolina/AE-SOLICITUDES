package com.keralty.aesolicitudes.viewmodel.beneficiarioc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.BeneficiarioCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.oid.UsuarioOid;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.Usuario;

public class TNEWDESDEAERequest {

    @JsonProperty("ptcontrato_oid")
    private ContratoCOid beneficiarioCTNEWDESDEAEptContrato;
    
    @JsonIgnore
    private ContratoC beneficiarioCTNEWDESDEAEptContratoInstance;

    @JsonProperty("ptfamilia_oid")
    private FamiliaCOid beneficiarioCTNEWDESDEAEptFamilia;
    
    @JsonIgnore
    private FamiliaC beneficiarioCTNEWDESDEAEptFamiliaInstance;

    @JsonProperty("ptusuario_oid")
    private UsuarioOid beneficiarioCTNEWDESDEAEptUsuario;
    
    @JsonIgnore
    private Usuario beneficiarioCTNEWDESDEAEptUsuarioInstance;

    @JsonProperty("ptsolicitud_oid")
    private SolicitudOid beneficiarioCTNEWDESDEAEptSolicitud;
    
    @JsonIgnore
    private Solicitud beneficiarioCTNEWDESDEAEptSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkBeneficiarioCTNEWDESDEAEptContrato();
        checkBeneficiarioCTNEWDESDEAEptFamilia();
        checkBeneficiarioCTNEWDESDEAEptUsuario();
        checkBeneficiarioCTNEWDESDEAEptSolicitud();
    }

    @JsonIgnore
    public ContratoCOid getBeneficiarioCTNEWDESDEAEptContrato() {
        return this.beneficiarioCTNEWDESDEAEptContrato;
    }
    
    public void setBeneficiarioCTNEWDESDEAEptContrato(ContratoCOid beneficiarioCTNEWDESDEAEptContrato) {
        this.beneficiarioCTNEWDESDEAEptContrato = beneficiarioCTNEWDESDEAEptContrato;
    }

    @JsonIgnore
    public ContratoC getBeneficiarioCTNEWDESDEAEptContratoInstance() {
        return this.beneficiarioCTNEWDESDEAEptContratoInstance;
    }
    
    public void setBeneficiarioCTNEWDESDEAEptContratoInstance(ContratoC beneficiarioCTNEWDESDEAEptContrato) {
        this.beneficiarioCTNEWDESDEAEptContratoInstance = beneficiarioCTNEWDESDEAEptContrato;
        this.beneficiarioCTNEWDESDEAEptContrato = beneficiarioCTNEWDESDEAEptContrato != null ? beneficiarioCTNEWDESDEAEptContrato.getOid() : null;
    }

    private void checkBeneficiarioCTNEWDESDEAEptContrato() throws NotNullArgumentException {
        if(this.getBeneficiarioCTNEWDESDEAEptContratoInstance() == null || this.getBeneficiarioCTNEWDESDEAEptContratoInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_TNEWDESDEAE, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_TNEWDESDEAE_BENEFICIARIOCTNEWDESDEAEPTCONTRATO, BeneficiarioCConstants.SERV_ALIAS_TNEWDESDEAE, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_TNEWDESDEAE_BENEFICIARIOCTNEWDESDEAEPTCONTRATO);
        }
    }

    @JsonIgnore
    public FamiliaCOid getBeneficiarioCTNEWDESDEAEptFamilia() {
        return this.beneficiarioCTNEWDESDEAEptFamilia;
    }
    
    public void setBeneficiarioCTNEWDESDEAEptFamilia(FamiliaCOid beneficiarioCTNEWDESDEAEptFamilia) {
        this.beneficiarioCTNEWDESDEAEptFamilia = beneficiarioCTNEWDESDEAEptFamilia;
    }

    @JsonIgnore
    public FamiliaC getBeneficiarioCTNEWDESDEAEptFamiliaInstance() {
        return this.beneficiarioCTNEWDESDEAEptFamiliaInstance;
    }
    
    public void setBeneficiarioCTNEWDESDEAEptFamiliaInstance(FamiliaC beneficiarioCTNEWDESDEAEptFamilia) {
        this.beneficiarioCTNEWDESDEAEptFamiliaInstance = beneficiarioCTNEWDESDEAEptFamilia;
        this.beneficiarioCTNEWDESDEAEptFamilia = beneficiarioCTNEWDESDEAEptFamilia != null ? beneficiarioCTNEWDESDEAEptFamilia.getOid() : null;
    }

    private void checkBeneficiarioCTNEWDESDEAEptFamilia() throws NotNullArgumentException {
        if(this.getBeneficiarioCTNEWDESDEAEptFamiliaInstance() == null || this.getBeneficiarioCTNEWDESDEAEptFamiliaInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_TNEWDESDEAE, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_TNEWDESDEAE_BENEFICIARIOCTNEWDESDEAEPTFAMILIA, BeneficiarioCConstants.SERV_ALIAS_TNEWDESDEAE, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_TNEWDESDEAE_BENEFICIARIOCTNEWDESDEAEPTFAMILIA);
        }
    }

    @JsonIgnore
    public UsuarioOid getBeneficiarioCTNEWDESDEAEptUsuario() {
        return this.beneficiarioCTNEWDESDEAEptUsuario;
    }
    
    public void setBeneficiarioCTNEWDESDEAEptUsuario(UsuarioOid beneficiarioCTNEWDESDEAEptUsuario) {
        this.beneficiarioCTNEWDESDEAEptUsuario = beneficiarioCTNEWDESDEAEptUsuario;
    }

    @JsonIgnore
    public Usuario getBeneficiarioCTNEWDESDEAEptUsuarioInstance() {
        return this.beneficiarioCTNEWDESDEAEptUsuarioInstance;
    }
    
    public void setBeneficiarioCTNEWDESDEAEptUsuarioInstance(Usuario beneficiarioCTNEWDESDEAEptUsuario) {
        this.beneficiarioCTNEWDESDEAEptUsuarioInstance = beneficiarioCTNEWDESDEAEptUsuario;
        this.beneficiarioCTNEWDESDEAEptUsuario = beneficiarioCTNEWDESDEAEptUsuario != null ? beneficiarioCTNEWDESDEAEptUsuario.getOid() : null;
    }

    private void checkBeneficiarioCTNEWDESDEAEptUsuario() throws NotNullArgumentException {
        if(this.getBeneficiarioCTNEWDESDEAEptUsuarioInstance() == null || this.getBeneficiarioCTNEWDESDEAEptUsuarioInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_TNEWDESDEAE, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_TNEWDESDEAE_BENEFICIARIOCTNEWDESDEAEPTUSUARIO, BeneficiarioCConstants.SERV_ALIAS_TNEWDESDEAE, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_TNEWDESDEAE_BENEFICIARIOCTNEWDESDEAEPTUSUARIO);
        }
    }

    @JsonIgnore
    public SolicitudOid getBeneficiarioCTNEWDESDEAEptSolicitud() {
        return this.beneficiarioCTNEWDESDEAEptSolicitud;
    }
    
    public void setBeneficiarioCTNEWDESDEAEptSolicitud(SolicitudOid beneficiarioCTNEWDESDEAEptSolicitud) {
        this.beneficiarioCTNEWDESDEAEptSolicitud = beneficiarioCTNEWDESDEAEptSolicitud;
    }

    @JsonIgnore
    public Solicitud getBeneficiarioCTNEWDESDEAEptSolicitudInstance() {
        return this.beneficiarioCTNEWDESDEAEptSolicitudInstance;
    }
    
    public void setBeneficiarioCTNEWDESDEAEptSolicitudInstance(Solicitud beneficiarioCTNEWDESDEAEptSolicitud) {
        this.beneficiarioCTNEWDESDEAEptSolicitudInstance = beneficiarioCTNEWDESDEAEptSolicitud;
        this.beneficiarioCTNEWDESDEAEptSolicitud = beneficiarioCTNEWDESDEAEptSolicitud != null ? beneficiarioCTNEWDESDEAEptSolicitud.getOid() : null;
    }

    private void checkBeneficiarioCTNEWDESDEAEptSolicitud() throws NotNullArgumentException {
        if(this.getBeneficiarioCTNEWDESDEAEptSolicitudInstance() == null || this.getBeneficiarioCTNEWDESDEAEptSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(BeneficiarioCConstants.SERV_ID_TNEWDESDEAE, BeneficiarioCConstants.CLASS_ID, BeneficiarioCConstants.ARG_ID_TNEWDESDEAE_BENEFICIARIOCTNEWDESDEAEPTSOLICITUD, BeneficiarioCConstants.SERV_ALIAS_TNEWDESDEAE, BeneficiarioCConstants.CLASS_ALIAS, BeneficiarioCConstants.ARG_ALIAS_TNEWDESDEAE_BENEFICIARIOCTNEWDESDEAEPTSOLICITUD);
        }
    }
}
