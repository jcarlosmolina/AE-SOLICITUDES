package com.keralty.aesolicitudes.viewmodel.direccionc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DireccionCConstants;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;
import com.keralty.aesolicitudes.persistence.oid.PaisOid;
import com.keralty.aesolicitudes.persistence.oid.TipoDireccionOid;
import com.keralty.aesolicitudes.persistence.Pais;
import com.keralty.aesolicitudes.persistence.TipoDireccion;

public class TMODIFICARRequest {

    @JsonProperty("p_thisdireccionc_oid")
    private DireccionCOid direccionCTMODIFICARpthisDireccionC;
    
    @JsonIgnore
    private DireccionC direccionCTMODIFICARpthisDireccionCInstance;

    @JsonProperty("pt_p_direccioncompleta")
    private String direccionCTMODIFICARptpDireccionCompleta;

    @JsonProperty("pt_p_evcdepartamentoc_oid")
    private DepartamentoOid direccionCTMODIFICARptpevcDepartamentoC;
    
    @JsonIgnore
    private Departamento direccionCTMODIFICARptpevcDepartamentoCInstance;

    @JsonProperty("pt_p_evcmunicipioc_oid")
    private MunicipioOid direccionCTMODIFICARptpevcMunicipioC;
    
    @JsonIgnore
    private Municipio direccionCTMODIFICARptpevcMunicipioCInstance;

    @JsonProperty("pt_p_evcpaisc_oid")
    private PaisOid direccionCTMODIFICARptpevcPaisC;
    
    @JsonIgnore
    private Pais direccionCTMODIFICARptpevcPaisCInstance;

    @JsonProperty("pt_p_evctipodireccionc_oid")
    private TipoDireccionOid direccionCTMODIFICARptpevcTipoDireccionC;
    
    @JsonIgnore
    private TipoDireccion direccionCTMODIFICARptpevcTipoDireccionCInstance;

    @JsonProperty("pt_p_localidad")
    private String direccionCTMODIFICARptpLocalidad;

    public void checkArguments() throws NotNullArgumentException {
        checkDireccionCTMODIFICARpthisDireccionC();
    }

    @JsonIgnore
    public DireccionCOid getDireccionCTMODIFICARpthisDireccionC() {
        return this.direccionCTMODIFICARpthisDireccionC;
    }
    
    public void setDireccionCTMODIFICARpthisDireccionC(DireccionCOid direccionCTMODIFICARpthisDireccionC) {
        this.direccionCTMODIFICARpthisDireccionC = direccionCTMODIFICARpthisDireccionC;
    }

    @JsonIgnore
    public DireccionC getDireccionCTMODIFICARpthisDireccionCInstance() {
        return this.direccionCTMODIFICARpthisDireccionCInstance;
    }
    
    public void setDireccionCTMODIFICARpthisDireccionCInstance(DireccionC direccionCTMODIFICARpthisDireccionC) {
        this.direccionCTMODIFICARpthisDireccionCInstance = direccionCTMODIFICARpthisDireccionC;
        this.direccionCTMODIFICARpthisDireccionC = direccionCTMODIFICARpthisDireccionC != null ? direccionCTMODIFICARpthisDireccionC.getOid() : null;
    }

    private void checkDireccionCTMODIFICARpthisDireccionC() throws NotNullArgumentException {
        if(this.getDireccionCTMODIFICARpthisDireccionCInstance() == null || this.getDireccionCTMODIFICARpthisDireccionCInstance().isNull()) {
            throw new NotNullArgumentException(DireccionCConstants.SERV_ID_TMODIFICAR, DireccionCConstants.CLASS_ID, DireccionCConstants.ARG_ID_TMODIFICAR_DIRECCIONCTMODIFICARPTHISDIRECCIONC, DireccionCConstants.SERV_ALIAS_TMODIFICAR, DireccionCConstants.CLASS_ALIAS, DireccionCConstants.ARG_ALIAS_TMODIFICAR_DIRECCIONCTMODIFICARPTHISDIRECCIONC);
        }
    }

    @JsonIgnore
    public String getDireccionCTMODIFICARptpDireccionCompleta() {
        return this.direccionCTMODIFICARptpDireccionCompleta;
    }
    
    public void setDireccionCTMODIFICARptpDireccionCompleta(String direccionCTMODIFICARptpDireccionCompleta) {
        this.direccionCTMODIFICARptpDireccionCompleta = direccionCTMODIFICARptpDireccionCompleta;
    }

    @JsonIgnore
    public DepartamentoOid getDireccionCTMODIFICARptpevcDepartamentoC() {
        return this.direccionCTMODIFICARptpevcDepartamentoC;
    }
    
    public void setDireccionCTMODIFICARptpevcDepartamentoC(DepartamentoOid direccionCTMODIFICARptpevcDepartamentoC) {
        this.direccionCTMODIFICARptpevcDepartamentoC = direccionCTMODIFICARptpevcDepartamentoC;
    }

    @JsonIgnore
    public Departamento getDireccionCTMODIFICARptpevcDepartamentoCInstance() {
        return this.direccionCTMODIFICARptpevcDepartamentoCInstance;
    }
    
    public void setDireccionCTMODIFICARptpevcDepartamentoCInstance(Departamento direccionCTMODIFICARptpevcDepartamentoC) {
        this.direccionCTMODIFICARptpevcDepartamentoCInstance = direccionCTMODIFICARptpevcDepartamentoC;
        this.direccionCTMODIFICARptpevcDepartamentoC = direccionCTMODIFICARptpevcDepartamentoC != null ? direccionCTMODIFICARptpevcDepartamentoC.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getDireccionCTMODIFICARptpevcMunicipioC() {
        return this.direccionCTMODIFICARptpevcMunicipioC;
    }
    
    public void setDireccionCTMODIFICARptpevcMunicipioC(MunicipioOid direccionCTMODIFICARptpevcMunicipioC) {
        this.direccionCTMODIFICARptpevcMunicipioC = direccionCTMODIFICARptpevcMunicipioC;
    }

    @JsonIgnore
    public Municipio getDireccionCTMODIFICARptpevcMunicipioCInstance() {
        return this.direccionCTMODIFICARptpevcMunicipioCInstance;
    }
    
    public void setDireccionCTMODIFICARptpevcMunicipioCInstance(Municipio direccionCTMODIFICARptpevcMunicipioC) {
        this.direccionCTMODIFICARptpevcMunicipioCInstance = direccionCTMODIFICARptpevcMunicipioC;
        this.direccionCTMODIFICARptpevcMunicipioC = direccionCTMODIFICARptpevcMunicipioC != null ? direccionCTMODIFICARptpevcMunicipioC.getOid() : null;
    }

    @JsonIgnore
    public PaisOid getDireccionCTMODIFICARptpevcPaisC() {
        return this.direccionCTMODIFICARptpevcPaisC;
    }
    
    public void setDireccionCTMODIFICARptpevcPaisC(PaisOid direccionCTMODIFICARptpevcPaisC) {
        this.direccionCTMODIFICARptpevcPaisC = direccionCTMODIFICARptpevcPaisC;
    }

    @JsonIgnore
    public Pais getDireccionCTMODIFICARptpevcPaisCInstance() {
        return this.direccionCTMODIFICARptpevcPaisCInstance;
    }
    
    public void setDireccionCTMODIFICARptpevcPaisCInstance(Pais direccionCTMODIFICARptpevcPaisC) {
        this.direccionCTMODIFICARptpevcPaisCInstance = direccionCTMODIFICARptpevcPaisC;
        this.direccionCTMODIFICARptpevcPaisC = direccionCTMODIFICARptpevcPaisC != null ? direccionCTMODIFICARptpevcPaisC.getOid() : null;
    }

    @JsonIgnore
    public TipoDireccionOid getDireccionCTMODIFICARptpevcTipoDireccionC() {
        return this.direccionCTMODIFICARptpevcTipoDireccionC;
    }
    
    public void setDireccionCTMODIFICARptpevcTipoDireccionC(TipoDireccionOid direccionCTMODIFICARptpevcTipoDireccionC) {
        this.direccionCTMODIFICARptpevcTipoDireccionC = direccionCTMODIFICARptpevcTipoDireccionC;
    }

    @JsonIgnore
    public TipoDireccion getDireccionCTMODIFICARptpevcTipoDireccionCInstance() {
        return this.direccionCTMODIFICARptpevcTipoDireccionCInstance;
    }
    
    public void setDireccionCTMODIFICARptpevcTipoDireccionCInstance(TipoDireccion direccionCTMODIFICARptpevcTipoDireccionC) {
        this.direccionCTMODIFICARptpevcTipoDireccionCInstance = direccionCTMODIFICARptpevcTipoDireccionC;
        this.direccionCTMODIFICARptpevcTipoDireccionC = direccionCTMODIFICARptpevcTipoDireccionC != null ? direccionCTMODIFICARptpevcTipoDireccionC.getOid() : null;
    }

    @JsonIgnore
    public String getDireccionCTMODIFICARptpLocalidad() {
        return this.direccionCTMODIFICARptpLocalidad;
    }
    
    public void setDireccionCTMODIFICARptpLocalidad(String direccionCTMODIFICARptpLocalidad) {
        this.direccionCTMODIFICARptpLocalidad = direccionCTMODIFICARptpLocalidad;
    }
}
