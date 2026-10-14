package com.keralty.aesolicitudes.viewmodel.marcamedicac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.MarcaMedicaCConstants;
import com.keralty.aesolicitudes.persistence.MarcaMedicaC;
import com.keralty.aesolicitudes.persistence.oid.MarcaMedicaCOid;

public class EliminarRequest {

    @JsonProperty("p_thismarcamedicac_oid")
    private MarcaMedicaCOid marcaMedicaCeliminarpthisMarcaMedicaC;
    
    @JsonIgnore
    private MarcaMedicaC marcaMedicaCeliminarpthisMarcaMedicaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkMarcaMedicaCeliminarpthisMarcaMedicaC();
    }

    @JsonIgnore
    public MarcaMedicaCOid getMarcaMedicaCeliminarpthisMarcaMedicaC() {
        return this.marcaMedicaCeliminarpthisMarcaMedicaC;
    }
    
    public void setMarcaMedicaCeliminarpthisMarcaMedicaC(MarcaMedicaCOid marcaMedicaCeliminarpthisMarcaMedicaC) {
        this.marcaMedicaCeliminarpthisMarcaMedicaC = marcaMedicaCeliminarpthisMarcaMedicaC;
    }

    @JsonIgnore
    public MarcaMedicaC getMarcaMedicaCeliminarpthisMarcaMedicaCInstance() {
        return this.marcaMedicaCeliminarpthisMarcaMedicaCInstance;
    }
    
    public void setMarcaMedicaCeliminarpthisMarcaMedicaCInstance(MarcaMedicaC marcaMedicaCeliminarpthisMarcaMedicaC) {
        this.marcaMedicaCeliminarpthisMarcaMedicaCInstance = marcaMedicaCeliminarpthisMarcaMedicaC;
        this.marcaMedicaCeliminarpthisMarcaMedicaC = marcaMedicaCeliminarpthisMarcaMedicaC != null ? marcaMedicaCeliminarpthisMarcaMedicaC.getOid() : null;
    }

    private void checkMarcaMedicaCeliminarpthisMarcaMedicaC() throws NotNullArgumentException {
        if(this.getMarcaMedicaCeliminarpthisMarcaMedicaCInstance() == null || this.getMarcaMedicaCeliminarpthisMarcaMedicaCInstance().isNull()) {
            throw new NotNullArgumentException(MarcaMedicaCConstants.SERV_ID_ELIMINAR, MarcaMedicaCConstants.CLASS_ID, MarcaMedicaCConstants.ARG_ID_ELIMINAR_MARCAMEDICACELIMINARPTHISMARCAMEDICAC, MarcaMedicaCConstants.SERV_ALIAS_ELIMINAR, MarcaMedicaCConstants.CLASS_ALIAS, MarcaMedicaCConstants.ARG_ALIAS_ELIMINAR_MARCAMEDICACELIMINARPTHISMARCAMEDICAC);
        }
    }
}
