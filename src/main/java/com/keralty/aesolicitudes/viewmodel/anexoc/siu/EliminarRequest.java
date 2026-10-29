package com.keralty.aesolicitudes.viewmodel.anexoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.AnexoCConstants;
import com.keralty.aesolicitudes.persistence.AnexoC;
import com.keralty.aesolicitudes.persistence.oid.AnexoCOid;

public class EliminarRequest {

    @JsonProperty("p_thisanexoc_oid")
    private AnexoCOid anexoCeliminarpthisAnexoC;
    
    @JsonIgnore
    private AnexoC anexoCeliminarpthisAnexoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAnexoCeliminarpthisAnexoC();
    }

    @JsonIgnore
    public AnexoCOid getAnexoCeliminarpthisAnexoC() {
        return this.anexoCeliminarpthisAnexoC;
    }
    
    public void setAnexoCeliminarpthisAnexoC(AnexoCOid anexoCeliminarpthisAnexoC) {
        this.anexoCeliminarpthisAnexoC = anexoCeliminarpthisAnexoC;
    }

    @JsonIgnore
    public AnexoC getAnexoCeliminarpthisAnexoCInstance() {
        return this.anexoCeliminarpthisAnexoCInstance;
    }
    
    public void setAnexoCeliminarpthisAnexoCInstance(AnexoC anexoCeliminarpthisAnexoC) {
        this.anexoCeliminarpthisAnexoCInstance = anexoCeliminarpthisAnexoC;
        this.anexoCeliminarpthisAnexoC = anexoCeliminarpthisAnexoC != null ? anexoCeliminarpthisAnexoC.getOid() : null;
    }

    private void checkAnexoCeliminarpthisAnexoC() throws NotNullArgumentException {
        if(this.getAnexoCeliminarpthisAnexoCInstance() == null || this.getAnexoCeliminarpthisAnexoCInstance().isNull()) {
            throw new NotNullArgumentException(AnexoCConstants.SERV_ID_ELIMINAR, AnexoCConstants.CLASS_ID, AnexoCConstants.ARG_ID_ELIMINAR_ANEXOCELIMINARPTHISANEXOC, AnexoCConstants.SERV_ALIAS_ELIMINAR, AnexoCConstants.CLASS_ALIAS, AnexoCConstants.ARG_ALIAS_ELIMINAR_ANEXOCELIMINARPTHISANEXOC);
        }
    }
}
