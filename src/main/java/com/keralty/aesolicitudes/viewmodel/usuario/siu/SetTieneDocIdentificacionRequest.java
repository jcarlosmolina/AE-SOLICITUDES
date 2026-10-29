package com.keralty.aesolicitudes.viewmodel.usuario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.UsuarioConstants;
import com.keralty.aesolicitudes.persistence.oid.UsuarioOid;
import com.keralty.aesolicitudes.persistence.Usuario;

public class SetTieneDocIdentificacionRequest {

    @JsonProperty("p_thisusuario_oid")
    private UsuarioOid usuariosetTieneDocIdentificacionpthisUsuario;
    
    @JsonIgnore
    private Usuario usuariosetTieneDocIdentificacionpthisUsuarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuariosetTieneDocIdentificacionpthisUsuario();
    }

    @JsonIgnore
    public UsuarioOid getUsuariosetTieneDocIdentificacionpthisUsuario() {
        return this.usuariosetTieneDocIdentificacionpthisUsuario;
    }
    
    public void setUsuariosetTieneDocIdentificacionpthisUsuario(UsuarioOid usuariosetTieneDocIdentificacionpthisUsuario) {
        this.usuariosetTieneDocIdentificacionpthisUsuario = usuariosetTieneDocIdentificacionpthisUsuario;
    }

    @JsonIgnore
    public Usuario getUsuariosetTieneDocIdentificacionpthisUsuarioInstance() {
        return this.usuariosetTieneDocIdentificacionpthisUsuarioInstance;
    }
    
    public void setUsuariosetTieneDocIdentificacionpthisUsuarioInstance(Usuario usuariosetTieneDocIdentificacionpthisUsuario) {
        this.usuariosetTieneDocIdentificacionpthisUsuarioInstance = usuariosetTieneDocIdentificacionpthisUsuario;
        this.usuariosetTieneDocIdentificacionpthisUsuario = usuariosetTieneDocIdentificacionpthisUsuario != null ? usuariosetTieneDocIdentificacionpthisUsuario.getOid() : null;
    }

    private void checkUsuariosetTieneDocIdentificacionpthisUsuario() throws NotNullArgumentException {
        if(this.getUsuariosetTieneDocIdentificacionpthisUsuarioInstance() == null || this.getUsuariosetTieneDocIdentificacionpthisUsuarioInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioConstants.SERV_ID_SETTIENEDOCIDENTIFICACION, UsuarioConstants.CLASS_ID, UsuarioConstants.ARG_ID_SETTIENEDOCIDENTIFICACION_USUARIOSETTIENEDOCIDENTIFICACIONPTHISUSUARIO, UsuarioConstants.SERV_ALIAS_SETTIENEDOCIDENTIFICACION, UsuarioConstants.CLASS_ALIAS, UsuarioConstants.ARG_ALIAS_SETTIENEDOCIDENTIFICACION_USUARIOSETTIENEDOCIDENTIFICACIONPTHISUSUARIO);
        }
    }
}
