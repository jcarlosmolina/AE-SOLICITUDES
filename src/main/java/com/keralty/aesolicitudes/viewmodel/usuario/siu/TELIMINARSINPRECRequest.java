package com.keralty.aesolicitudes.viewmodel.usuario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.UsuarioConstants;
import com.keralty.aesolicitudes.persistence.oid.UsuarioOid;
import com.keralty.aesolicitudes.persistence.Usuario;

public class TELIMINARSINPRECRequest {

    @JsonProperty("p_thisusuario_oid")
    private UsuarioOid usuarioTELIMINARSINPRECpthisUsuario;
    
    @JsonIgnore
    private Usuario usuarioTELIMINARSINPRECpthisUsuarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioTELIMINARSINPRECpthisUsuario();
    }

    @JsonIgnore
    public UsuarioOid getUsuarioTELIMINARSINPRECpthisUsuario() {
        return this.usuarioTELIMINARSINPRECpthisUsuario;
    }
    
    public void setUsuarioTELIMINARSINPRECpthisUsuario(UsuarioOid usuarioTELIMINARSINPRECpthisUsuario) {
        this.usuarioTELIMINARSINPRECpthisUsuario = usuarioTELIMINARSINPRECpthisUsuario;
    }

    @JsonIgnore
    public Usuario getUsuarioTELIMINARSINPRECpthisUsuarioInstance() {
        return this.usuarioTELIMINARSINPRECpthisUsuarioInstance;
    }
    
    public void setUsuarioTELIMINARSINPRECpthisUsuarioInstance(Usuario usuarioTELIMINARSINPRECpthisUsuario) {
        this.usuarioTELIMINARSINPRECpthisUsuarioInstance = usuarioTELIMINARSINPRECpthisUsuario;
        this.usuarioTELIMINARSINPRECpthisUsuario = usuarioTELIMINARSINPRECpthisUsuario != null ? usuarioTELIMINARSINPRECpthisUsuario.getOid() : null;
    }

    private void checkUsuarioTELIMINARSINPRECpthisUsuario() throws NotNullArgumentException {
        if(this.getUsuarioTELIMINARSINPRECpthisUsuarioInstance() == null || this.getUsuarioTELIMINARSINPRECpthisUsuarioInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioConstants.SERV_ID_TELIMINARSINPREC, UsuarioConstants.CLASS_ID, UsuarioConstants.ARG_ID_TELIMINARSINPREC_USUARIOTELIMINARSINPRECPTHISUSUARIO, UsuarioConstants.SERV_ALIAS_TELIMINARSINPREC, UsuarioConstants.CLASS_ALIAS, UsuarioConstants.ARG_ALIAS_TELIMINARSINPREC_USUARIOTELIMINARSINPRECPTHISUSUARIO);
        }
    }
}
