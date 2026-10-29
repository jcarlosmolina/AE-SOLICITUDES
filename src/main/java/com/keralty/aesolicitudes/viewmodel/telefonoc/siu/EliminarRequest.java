package com.keralty.aesolicitudes.viewmodel.telefonoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.TelefonoCConstants;
import com.keralty.aesolicitudes.persistence.oid.TelefonoCOid;
import com.keralty.aesolicitudes.persistence.TelefonoC;

public class EliminarRequest {

    @JsonProperty("p_thistelefonoc_oid")
    private TelefonoCOid telefonoCeliminarpthisTelefonoC;
    
    @JsonIgnore
    private TelefonoC telefonoCeliminarpthisTelefonoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTelefonoCeliminarpthisTelefonoC();
    }

    @JsonIgnore
    public TelefonoCOid getTelefonoCeliminarpthisTelefonoC() {
        return this.telefonoCeliminarpthisTelefonoC;
    }
    
    public void setTelefonoCeliminarpthisTelefonoC(TelefonoCOid telefonoCeliminarpthisTelefonoC) {
        this.telefonoCeliminarpthisTelefonoC = telefonoCeliminarpthisTelefonoC;
    }

    @JsonIgnore
    public TelefonoC getTelefonoCeliminarpthisTelefonoCInstance() {
        return this.telefonoCeliminarpthisTelefonoCInstance;
    }
    
    public void setTelefonoCeliminarpthisTelefonoCInstance(TelefonoC telefonoCeliminarpthisTelefonoC) {
        this.telefonoCeliminarpthisTelefonoCInstance = telefonoCeliminarpthisTelefonoC;
        this.telefonoCeliminarpthisTelefonoC = telefonoCeliminarpthisTelefonoC != null ? telefonoCeliminarpthisTelefonoC.getOid() : null;
    }

    private void checkTelefonoCeliminarpthisTelefonoC() throws NotNullArgumentException {
        if(this.getTelefonoCeliminarpthisTelefonoCInstance() == null || this.getTelefonoCeliminarpthisTelefonoCInstance().isNull()) {
            throw new NotNullArgumentException(TelefonoCConstants.SERV_ID_ELIMINAR, TelefonoCConstants.CLASS_ID, TelefonoCConstants.ARG_ID_ELIMINAR_TELEFONOCELIMINARPTHISTELEFONOC, TelefonoCConstants.SERV_ALIAS_ELIMINAR, TelefonoCConstants.CLASS_ALIAS, TelefonoCConstants.ARG_ALIAS_ELIMINAR_TELEFONOCELIMINARPTHISTELEFONOC);
        }
    }
}
