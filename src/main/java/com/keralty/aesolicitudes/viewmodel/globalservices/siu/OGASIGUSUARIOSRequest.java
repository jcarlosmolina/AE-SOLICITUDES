package com.keralty.aesolicitudes.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.GlobalServiceConstants;

public class OGASIGUSUARIOSRequest {

    @JsonProperty("ptfichero")
    private byte[] oGASIGUSUARIOSptFichero;

    public void checkArguments() throws NotNullArgumentException {
        checkOGASIGUSUARIOSptFichero();
    }

    @JsonIgnore
    public byte[] getOGASIGUSUARIOSptFichero() {
        return this.oGASIGUSUARIOSptFichero;
    }
    
    public void setOGASIGUSUARIOSptFichero(byte[] oGASIGUSUARIOSptFichero) {
        this.oGASIGUSUARIOSptFichero = oGASIGUSUARIOSptFichero;
    }

    private void checkOGASIGUSUARIOSptFichero() throws NotNullArgumentException {
        if(this.getOGASIGUSUARIOSptFichero() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_OGASIGUSUARIOS, GlobalServiceConstants.GS_ARG_ID_OGASIGUSUARIOS_OGASIGUSUARIOSPTFICHERO, GlobalServiceConstants.G_SERV_ALIAS_OGASIGUSUARIOS, GlobalServiceConstants.GS_ARG_ALIAS_OGASIGUSUARIOS_OGASIGUSUARIOSPTFICHERO);
        }
    }
}
