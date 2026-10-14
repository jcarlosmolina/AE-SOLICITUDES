package com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.AesolicitudesConstants;
import com.keralty.aesolicitudes.persistence.Asesor;
import com.keralty.aesolicitudes.persistence.oid.AsesorOid;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.Planes;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TINCLUSIONSCRequest {

    @JsonProperty("pt_p_agrproducto_json")
    private String aesolicitudesTINCLUSIONSCptpagrProducto;
    
    @JsonIgnore
    private Productos aesolicitudesTINCLUSIONSCptpagrProductoInstance;

    @JsonProperty("pt_p_agrplan_json")
    private String aesolicitudesTINCLUSIONSCptpagrPlan;
    
    @JsonIgnore
    private Planes aesolicitudesTINCLUSIONSCptpagrPlanInstance;

    @JsonProperty("pt_protecciondatos_oid")
    private ProteccionDatosOid aesolicitudesTINCLUSIONSCptProteccionDatos;
    
    @JsonIgnore
    private ProteccionDatos aesolicitudesTINCLUSIONSCptProteccionDatosInstance;

    @JsonProperty("pt_p_atrfiniciocontrato")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date aesolicitudesTINCLUSIONSCptpatrFInicioContrato;

    @JsonProperty("pt_p_atrnumcontratoinclusion")
    private String aesolicitudesTINCLUSIONSCptpatrNumContratoInclusion;

    @JsonProperty("pt_p_atrnumfamilia")
    private String aesolicitudesTINCLUSIONSCptpatrNumFamilia;

    @JsonProperty("pdirector_oid")
    private AsesorOid aesolicitudesTINCLUSIONSCpDirector;
    
    @JsonIgnore
    private Asesor aesolicitudesTINCLUSIONSCpDirectorInstance;

    @JsonProperty("ptmarcacarnet")
    private Boolean aesolicitudesTINCLUSIONSCptMarcaCarnet;

    @JsonProperty("ptavisomarcacarnet")
    private String aesolicitudesTINCLUSIONSCptAvisoMarcaCarnet;

    @JsonProperty("ptsolodiauno")
    private Boolean aesolicitudesTINCLUSIONSCptSoloDiaUno;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkAesolicitudesTINCLUSIONSCptpagrProducto();
        checkAesolicitudesTINCLUSIONSCptpagrPlan();
        checkAesolicitudesTINCLUSIONSCptProteccionDatos();
        checkAesolicitudesTINCLUSIONSCptpatrNumContratoInclusion();
        checkAesolicitudesTINCLUSIONSCpDirector();
        checkAesolicitudesTINCLUSIONSCptMarcaCarnet();
        checkAesolicitudesTINCLUSIONSCptAvisoMarcaCarnet();
        checkAesolicitudesTINCLUSIONSCptSoloDiaUno();
    }

    @JsonIgnore
    public String getAesolicitudesTINCLUSIONSCptpagrProducto() {
        return this.aesolicitudesTINCLUSIONSCptpagrProducto;
    }
    
    public void setAesolicitudesTINCLUSIONSCptpagrProducto(String aesolicitudesTINCLUSIONSCptpagrProducto) {
        this.aesolicitudesTINCLUSIONSCptpagrProducto = aesolicitudesTINCLUSIONSCptpagrProducto;
    }

    @JsonIgnore
    public Productos getAesolicitudesTINCLUSIONSCptpagrProductoInstance() {
        return this.aesolicitudesTINCLUSIONSCptpagrProductoInstance;
    }
    
    public void setAesolicitudesTINCLUSIONSCptpagrProductoInstance(Productos aesolicitudesTINCLUSIONSCptpagrProducto) {
        this.aesolicitudesTINCLUSIONSCptpagrProductoInstance = aesolicitudesTINCLUSIONSCptpagrProducto;
        this.aesolicitudesTINCLUSIONSCptpagrProducto = aesolicitudesTINCLUSIONSCptpagrProducto != null ? aesolicitudesTINCLUSIONSCptpagrProducto.getOid().toJson() : "";
    }

    private void checkAesolicitudesTINCLUSIONSCptpagrProducto() throws NotNullArgumentException {
        if(this.getAesolicitudesTINCLUSIONSCptpagrProductoInstance() == null || this.getAesolicitudesTINCLUSIONSCptpagrProductoInstance().isNull()) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_TINCLUSIONSC, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTPAGRPRODUCTO, AesolicitudesConstants.SERV_ALIAS_TINCLUSIONSC, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTPAGRPRODUCTO);
        }
    }

    @JsonIgnore
    public String getAesolicitudesTINCLUSIONSCptpagrPlan() {
        return this.aesolicitudesTINCLUSIONSCptpagrPlan;
    }
    
    public void setAesolicitudesTINCLUSIONSCptpagrPlan(String aesolicitudesTINCLUSIONSCptpagrPlan) {
        this.aesolicitudesTINCLUSIONSCptpagrPlan = aesolicitudesTINCLUSIONSCptpagrPlan;
    }

    @JsonIgnore
    public Planes getAesolicitudesTINCLUSIONSCptpagrPlanInstance() {
        return this.aesolicitudesTINCLUSIONSCptpagrPlanInstance;
    }
    
    public void setAesolicitudesTINCLUSIONSCptpagrPlanInstance(Planes aesolicitudesTINCLUSIONSCptpagrPlan) {
        this.aesolicitudesTINCLUSIONSCptpagrPlanInstance = aesolicitudesTINCLUSIONSCptpagrPlan;
        this.aesolicitudesTINCLUSIONSCptpagrPlan = aesolicitudesTINCLUSIONSCptpagrPlan != null ? aesolicitudesTINCLUSIONSCptpagrPlan.getOid().toJson() : "";
    }

    private void checkAesolicitudesTINCLUSIONSCptpagrPlan() throws NotNullArgumentException {
        if(this.getAesolicitudesTINCLUSIONSCptpagrPlanInstance() == null || this.getAesolicitudesTINCLUSIONSCptpagrPlanInstance().isNull()) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_TINCLUSIONSC, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTPAGRPLAN, AesolicitudesConstants.SERV_ALIAS_TINCLUSIONSC, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTPAGRPLAN);
        }
    }

    @JsonIgnore
    public ProteccionDatosOid getAesolicitudesTINCLUSIONSCptProteccionDatos() {
        return this.aesolicitudesTINCLUSIONSCptProteccionDatos;
    }
    
    public void setAesolicitudesTINCLUSIONSCptProteccionDatos(ProteccionDatosOid aesolicitudesTINCLUSIONSCptProteccionDatos) {
        this.aesolicitudesTINCLUSIONSCptProteccionDatos = aesolicitudesTINCLUSIONSCptProteccionDatos;
    }

    @JsonIgnore
    public ProteccionDatos getAesolicitudesTINCLUSIONSCptProteccionDatosInstance() {
        return this.aesolicitudesTINCLUSIONSCptProteccionDatosInstance;
    }
    
    public void setAesolicitudesTINCLUSIONSCptProteccionDatosInstance(ProteccionDatos aesolicitudesTINCLUSIONSCptProteccionDatos) {
        this.aesolicitudesTINCLUSIONSCptProteccionDatosInstance = aesolicitudesTINCLUSIONSCptProteccionDatos;
        this.aesolicitudesTINCLUSIONSCptProteccionDatos = aesolicitudesTINCLUSIONSCptProteccionDatos != null ? aesolicitudesTINCLUSIONSCptProteccionDatos.getOid() : null;
    }

    private void checkAesolicitudesTINCLUSIONSCptProteccionDatos() throws NotNullArgumentException {
        if(this.getAesolicitudesTINCLUSIONSCptProteccionDatosInstance() == null || this.getAesolicitudesTINCLUSIONSCptProteccionDatosInstance().isNull()) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_TINCLUSIONSC, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTPROTECCIONDATOS, AesolicitudesConstants.SERV_ALIAS_TINCLUSIONSC, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTPROTECCIONDATOS);
        }
    }

    @JsonIgnore
    public Date getAesolicitudesTINCLUSIONSCptpatrFInicioContrato() {
        return this.aesolicitudesTINCLUSIONSCptpatrFInicioContrato;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setAesolicitudesTINCLUSIONSCptpatrFInicioContrato(Date aesolicitudesTINCLUSIONSCptpatrFInicioContrato) {
        this.aesolicitudesTINCLUSIONSCptpatrFInicioContrato = aesolicitudesTINCLUSIONSCptpatrFInicioContrato;
    }

    @JsonIgnore
    public String getAesolicitudesTINCLUSIONSCptpatrNumContratoInclusion() {
        return this.aesolicitudesTINCLUSIONSCptpatrNumContratoInclusion;
    }
    
    public void setAesolicitudesTINCLUSIONSCptpatrNumContratoInclusion(String aesolicitudesTINCLUSIONSCptpatrNumContratoInclusion) {
        this.aesolicitudesTINCLUSIONSCptpatrNumContratoInclusion = aesolicitudesTINCLUSIONSCptpatrNumContratoInclusion;
    }

    private void checkAesolicitudesTINCLUSIONSCptpatrNumContratoInclusion() throws NotNullArgumentException {
        if(this.getAesolicitudesTINCLUSIONSCptpatrNumContratoInclusion() == null) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_TINCLUSIONSC, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTPATRNUMCONTRATOINCLUSION, AesolicitudesConstants.SERV_ALIAS_TINCLUSIONSC, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTPATRNUMCONTRATOINCLUSION);
        }
    }

    @JsonIgnore
    public String getAesolicitudesTINCLUSIONSCptpatrNumFamilia() {
        return this.aesolicitudesTINCLUSIONSCptpatrNumFamilia;
    }
    
    public void setAesolicitudesTINCLUSIONSCptpatrNumFamilia(String aesolicitudesTINCLUSIONSCptpatrNumFamilia) {
        this.aesolicitudesTINCLUSIONSCptpatrNumFamilia = aesolicitudesTINCLUSIONSCptpatrNumFamilia;
    }

    @JsonIgnore
    public AsesorOid getAesolicitudesTINCLUSIONSCpDirector() {
        return this.aesolicitudesTINCLUSIONSCpDirector;
    }
    
    public void setAesolicitudesTINCLUSIONSCpDirector(AsesorOid aesolicitudesTINCLUSIONSCpDirector) {
        this.aesolicitudesTINCLUSIONSCpDirector = aesolicitudesTINCLUSIONSCpDirector;
    }

    @JsonIgnore
    public Asesor getAesolicitudesTINCLUSIONSCpDirectorInstance() {
        return this.aesolicitudesTINCLUSIONSCpDirectorInstance;
    }
    
    public void setAesolicitudesTINCLUSIONSCpDirectorInstance(Asesor aesolicitudesTINCLUSIONSCpDirector) {
        this.aesolicitudesTINCLUSIONSCpDirectorInstance = aesolicitudesTINCLUSIONSCpDirector;
        this.aesolicitudesTINCLUSIONSCpDirector = aesolicitudesTINCLUSIONSCpDirector != null ? aesolicitudesTINCLUSIONSCpDirector.getOid() : null;
    }

    private void checkAesolicitudesTINCLUSIONSCpDirector() throws NotNullArgumentException {
        if(this.getAesolicitudesTINCLUSIONSCpDirectorInstance() == null || this.getAesolicitudesTINCLUSIONSCpDirectorInstance().isNull()) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_TINCLUSIONSC, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPDIRECTOR, AesolicitudesConstants.SERV_ALIAS_TINCLUSIONSC, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPDIRECTOR);
        }
    }

    @JsonIgnore
    public Boolean getAesolicitudesTINCLUSIONSCptMarcaCarnet() {
        return this.aesolicitudesTINCLUSIONSCptMarcaCarnet;
    }
    
    public void setAesolicitudesTINCLUSIONSCptMarcaCarnet(Boolean aesolicitudesTINCLUSIONSCptMarcaCarnet) {
        this.aesolicitudesTINCLUSIONSCptMarcaCarnet = aesolicitudesTINCLUSIONSCptMarcaCarnet;
    }

    private void checkAesolicitudesTINCLUSIONSCptMarcaCarnet() throws NotNullArgumentException {
        if(this.getAesolicitudesTINCLUSIONSCptMarcaCarnet() == null) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_TINCLUSIONSC, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTMARCACARNET, AesolicitudesConstants.SERV_ALIAS_TINCLUSIONSC, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTMARCACARNET);
        }
    }

    @JsonIgnore
    public String getAesolicitudesTINCLUSIONSCptAvisoMarcaCarnet() {
        return this.aesolicitudesTINCLUSIONSCptAvisoMarcaCarnet;
    }
    
    public void setAesolicitudesTINCLUSIONSCptAvisoMarcaCarnet(String aesolicitudesTINCLUSIONSCptAvisoMarcaCarnet) {
        this.aesolicitudesTINCLUSIONSCptAvisoMarcaCarnet = aesolicitudesTINCLUSIONSCptAvisoMarcaCarnet;
    }

    private void checkAesolicitudesTINCLUSIONSCptAvisoMarcaCarnet() throws NotNullArgumentException {
        if(this.getAesolicitudesTINCLUSIONSCptAvisoMarcaCarnet() == null) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_TINCLUSIONSC, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTAVISOMARCACARNET, AesolicitudesConstants.SERV_ALIAS_TINCLUSIONSC, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTAVISOMARCACARNET);
        }
    }

    @JsonIgnore
    public Boolean getAesolicitudesTINCLUSIONSCptSoloDiaUno() {
        return this.aesolicitudesTINCLUSIONSCptSoloDiaUno;
    }
    
    public void setAesolicitudesTINCLUSIONSCptSoloDiaUno(Boolean aesolicitudesTINCLUSIONSCptSoloDiaUno) {
        this.aesolicitudesTINCLUSIONSCptSoloDiaUno = aesolicitudesTINCLUSIONSCptSoloDiaUno;
    }

    private void checkAesolicitudesTINCLUSIONSCptSoloDiaUno() throws NotNullArgumentException {
        if(this.getAesolicitudesTINCLUSIONSCptSoloDiaUno() == null) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_TINCLUSIONSC, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTSOLODIAUNO, AesolicitudesConstants.SERV_ALIAS_TINCLUSIONSC, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTSOLODIAUNO);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
