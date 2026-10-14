package com.keralty.aesolicitudes.viewmodel.usuario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.UsuarioConstants;
import com.keralty.aesolicitudes.persistence.oid.UsuarioOid;
import com.keralty.aesolicitudes.persistence.Usuario;

public class TCARGARPREEXISTRequest {

    @JsonProperty("p_thisusuario_oid")
    private UsuarioOid usuarioTCARGARPREEXISTpthisUsuario;
    
    @JsonIgnore
    private Usuario usuarioTCARGARPREEXISTpthisUsuarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioTCARGARPREEXISTpthisUsuario();
    }

    @JsonIgnore
    public UsuarioOid getUsuarioTCARGARPREEXISTpthisUsuario() {
        return this.usuarioTCARGARPREEXISTpthisUsuario;
    }
    
    public void setUsuarioTCARGARPREEXISTpthisUsuario(UsuarioOid usuarioTCARGARPREEXISTpthisUsuario) {
        this.usuarioTCARGARPREEXISTpthisUsuario = usuarioTCARGARPREEXISTpthisUsuario;
    }

    @JsonIgnore
    public Usuario getUsuarioTCARGARPREEXISTpthisUsuarioInstance() {
        return this.usuarioTCARGARPREEXISTpthisUsuarioInstance;
    }
    
    public void setUsuarioTCARGARPREEXISTpthisUsuarioInstance(Usuario usuarioTCARGARPREEXISTpthisUsuario) {
        this.usuarioTCARGARPREEXISTpthisUsuarioInstance = usuarioTCARGARPREEXISTpthisUsuario;
        this.usuarioTCARGARPREEXISTpthisUsuario = usuarioTCARGARPREEXISTpthisUsuario != null ? usuarioTCARGARPREEXISTpthisUsuario.getOid() : null;
    }

    private void checkUsuarioTCARGARPREEXISTpthisUsuario() throws NotNullArgumentException {
        if(this.getUsuarioTCARGARPREEXISTpthisUsuarioInstance() == null || this.getUsuarioTCARGARPREEXISTpthisUsuarioInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioConstants.SERV_ID_TCARGARPREEXIST, UsuarioConstants.CLASS_ID, UsuarioConstants.ARG_ID_TCARGARPREEXIST_USUARIOTCARGARPREEXISTPTHISUSUARIO, UsuarioConstants.SERV_ALIAS_TCARGARPREEXIST, UsuarioConstants.CLASS_ALIAS, UsuarioConstants.ARG_ALIAS_TCARGARPREEXIST_USUARIOTCARGARPREEXISTPTHISUSUARIO);
        }
    }
}
