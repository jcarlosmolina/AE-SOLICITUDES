package com.keralty.aesolicitudes.viewmodel.usuario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.UsuarioConstants;
import com.keralty.aesolicitudes.persistence.oid.UsuarioOid;
import com.keralty.aesolicitudes.persistence.Usuario;

public class CalcularIMCRequest {

    @JsonProperty("p_thisusuario_oid")
    private UsuarioOid usuariocalcularIMCpthisUsuario;
    
    @JsonIgnore
    private Usuario usuariocalcularIMCpthisUsuarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuariocalcularIMCpthisUsuario();
    }

    @JsonIgnore
    public UsuarioOid getUsuariocalcularIMCpthisUsuario() {
        return this.usuariocalcularIMCpthisUsuario;
    }
    
    public void setUsuariocalcularIMCpthisUsuario(UsuarioOid usuariocalcularIMCpthisUsuario) {
        this.usuariocalcularIMCpthisUsuario = usuariocalcularIMCpthisUsuario;
    }

    @JsonIgnore
    public Usuario getUsuariocalcularIMCpthisUsuarioInstance() {
        return this.usuariocalcularIMCpthisUsuarioInstance;
    }
    
    public void setUsuariocalcularIMCpthisUsuarioInstance(Usuario usuariocalcularIMCpthisUsuario) {
        this.usuariocalcularIMCpthisUsuarioInstance = usuariocalcularIMCpthisUsuario;
        this.usuariocalcularIMCpthisUsuario = usuariocalcularIMCpthisUsuario != null ? usuariocalcularIMCpthisUsuario.getOid() : null;
    }

    private void checkUsuariocalcularIMCpthisUsuario() throws NotNullArgumentException {
        if(this.getUsuariocalcularIMCpthisUsuarioInstance() == null || this.getUsuariocalcularIMCpthisUsuarioInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioConstants.SERV_ID_CALCULARIMC, UsuarioConstants.CLASS_ID, UsuarioConstants.ARG_ID_CALCULARIMC_USUARIOCALCULARIMCPTHISUSUARIO, UsuarioConstants.SERV_ALIAS_CALCULARIMC, UsuarioConstants.CLASS_ALIAS, UsuarioConstants.ARG_ALIAS_CALCULARIMC_USUARIOCALCULARIMCPTHISUSUARIO);
        }
    }
}
