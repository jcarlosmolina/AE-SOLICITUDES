package com.keralty.aesolicitudes.viewmodel.usuario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.UsuarioConstants;
import com.keralty.aesolicitudes.persistence.oid.UsuarioOid;
import com.keralty.aesolicitudes.persistence.Usuario;

public class TRECREARCUESMEDICORequest {

    @JsonProperty("p_thisusuario_oid")
    private UsuarioOid usuarioTRECREARCUESMEDICOpthisUsuario;
    
    @JsonIgnore
    private Usuario usuarioTRECREARCUESMEDICOpthisUsuarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioTRECREARCUESMEDICOpthisUsuario();
    }

    @JsonIgnore
    public UsuarioOid getUsuarioTRECREARCUESMEDICOpthisUsuario() {
        return this.usuarioTRECREARCUESMEDICOpthisUsuario;
    }
    
    public void setUsuarioTRECREARCUESMEDICOpthisUsuario(UsuarioOid usuarioTRECREARCUESMEDICOpthisUsuario) {
        this.usuarioTRECREARCUESMEDICOpthisUsuario = usuarioTRECREARCUESMEDICOpthisUsuario;
    }

    @JsonIgnore
    public Usuario getUsuarioTRECREARCUESMEDICOpthisUsuarioInstance() {
        return this.usuarioTRECREARCUESMEDICOpthisUsuarioInstance;
    }
    
    public void setUsuarioTRECREARCUESMEDICOpthisUsuarioInstance(Usuario usuarioTRECREARCUESMEDICOpthisUsuario) {
        this.usuarioTRECREARCUESMEDICOpthisUsuarioInstance = usuarioTRECREARCUESMEDICOpthisUsuario;
        this.usuarioTRECREARCUESMEDICOpthisUsuario = usuarioTRECREARCUESMEDICOpthisUsuario != null ? usuarioTRECREARCUESMEDICOpthisUsuario.getOid() : null;
    }

    private void checkUsuarioTRECREARCUESMEDICOpthisUsuario() throws NotNullArgumentException {
        if(this.getUsuarioTRECREARCUESMEDICOpthisUsuarioInstance() == null || this.getUsuarioTRECREARCUESMEDICOpthisUsuarioInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioConstants.SERV_ID_TRECREARCUESMEDICO, UsuarioConstants.CLASS_ID, UsuarioConstants.ARG_ID_TRECREARCUESMEDICO_USUARIOTRECREARCUESMEDICOPTHISUSUARIO, UsuarioConstants.SERV_ALIAS_TRECREARCUESMEDICO, UsuarioConstants.CLASS_ALIAS, UsuarioConstants.ARG_ALIAS_TRECREARCUESMEDICO_USUARIOTRECREARCUESMEDICOPTHISUSUARIO);
        }
    }
}
