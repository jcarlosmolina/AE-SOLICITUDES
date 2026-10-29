package com.keralty.aesolicitudes.viewmodel.usuario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.UsuarioConstants;
import com.keralty.aesolicitudes.persistence.oid.UsuarioOid;
import com.keralty.aesolicitudes.persistence.Usuario;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TCREARCUESMEDICOAUXRequest {

    @JsonProperty("p_thisusuario_oid")
    private UsuarioOid usuarioTCREARCUESMEDICOAUXpthisUsuario;
    
    @JsonIgnore
    private Usuario usuarioTCREARCUESMEDICOAUXpthisUsuarioInstance;

    @JsonProperty("ptfechafinvigenciausuario")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date usuarioTCREARCUESMEDICOAUXptFechafinVigenciaUsuario;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioTCREARCUESMEDICOAUXpthisUsuario();
    }

    @JsonIgnore
    public UsuarioOid getUsuarioTCREARCUESMEDICOAUXpthisUsuario() {
        return this.usuarioTCREARCUESMEDICOAUXpthisUsuario;
    }
    
    public void setUsuarioTCREARCUESMEDICOAUXpthisUsuario(UsuarioOid usuarioTCREARCUESMEDICOAUXpthisUsuario) {
        this.usuarioTCREARCUESMEDICOAUXpthisUsuario = usuarioTCREARCUESMEDICOAUXpthisUsuario;
    }

    @JsonIgnore
    public Usuario getUsuarioTCREARCUESMEDICOAUXpthisUsuarioInstance() {
        return this.usuarioTCREARCUESMEDICOAUXpthisUsuarioInstance;
    }
    
    public void setUsuarioTCREARCUESMEDICOAUXpthisUsuarioInstance(Usuario usuarioTCREARCUESMEDICOAUXpthisUsuario) {
        this.usuarioTCREARCUESMEDICOAUXpthisUsuarioInstance = usuarioTCREARCUESMEDICOAUXpthisUsuario;
        this.usuarioTCREARCUESMEDICOAUXpthisUsuario = usuarioTCREARCUESMEDICOAUXpthisUsuario != null ? usuarioTCREARCUESMEDICOAUXpthisUsuario.getOid() : null;
    }

    private void checkUsuarioTCREARCUESMEDICOAUXpthisUsuario() throws NotNullArgumentException {
        if(this.getUsuarioTCREARCUESMEDICOAUXpthisUsuarioInstance() == null || this.getUsuarioTCREARCUESMEDICOAUXpthisUsuarioInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioConstants.SERV_ID_TCREARCUESMEDICOAUX, UsuarioConstants.CLASS_ID, UsuarioConstants.ARG_ID_TCREARCUESMEDICOAUX_USUARIOTCREARCUESMEDICOAUXPTHISUSUARIO, UsuarioConstants.SERV_ALIAS_TCREARCUESMEDICOAUX, UsuarioConstants.CLASS_ALIAS, UsuarioConstants.ARG_ALIAS_TCREARCUESMEDICOAUX_USUARIOTCREARCUESMEDICOAUXPTHISUSUARIO);
        }
    }

    @JsonIgnore
    public Date getUsuarioTCREARCUESMEDICOAUXptFechafinVigenciaUsuario() {
        return this.usuarioTCREARCUESMEDICOAUXptFechafinVigenciaUsuario;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setUsuarioTCREARCUESMEDICOAUXptFechafinVigenciaUsuario(Date usuarioTCREARCUESMEDICOAUXptFechafinVigenciaUsuario) {
        this.usuarioTCREARCUESMEDICOAUXptFechafinVigenciaUsuario = usuarioTCREARCUESMEDICOAUXptFechafinVigenciaUsuario;
    }
}
