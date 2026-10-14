package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.AreaMedica;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.FormaPago;
import com.keralty.aesolicitudes.persistence.Funcionario;
import com.keralty.aesolicitudes.persistence.GrupoAsociado;
import com.keralty.aesolicitudes.persistence.oid.AesolicitudesOid;
import com.keralty.aesolicitudes.persistence.oid.AreaMedicaOid;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.FormaPagoOid;
import com.keralty.aesolicitudes.persistence.oid.FuncionarioOid;
import com.keralty.aesolicitudes.persistence.oid.GrupoAsociadoOid;
import com.keralty.aesolicitudes.persistence.oid.PeriodicidadOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaOid;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.oid.TipoFacturaOid;
import com.keralty.aesolicitudes.persistence.Periodicidad;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.persistence.TipoFactura;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class CrearRequest {

    @JsonProperty("p_agrae_solicitudes_oid")
    private AesolicitudesOid solicitudcrearpagrAesolicitudes;
    
    @JsonIgnore
    private Aesolicitudes solicitudcrearpagrAesolicitudesInstance;

    @JsonProperty("p_agrcontratantepersona_oid")
    private PersonaOid solicitudcrearpagrContratantePersona;
    
    @JsonIgnore
    private Persona solicitudcrearpagrContratantePersonaInstance;

    @JsonProperty("p_agrtitularpersona_oid")
    private PersonaOid solicitudcrearpagrTitularPersona;
    
    @JsonIgnore
    private Persona solicitudcrearpagrTitularPersonaInstance;

    @JsonProperty("p_agrprotecciondatos_oid")
    private ProteccionDatosOid solicitudcrearpagrProteccionDatos;
    
    @JsonIgnore
    private ProteccionDatos solicitudcrearpagrProteccionDatosInstance;

    @JsonProperty("p_agragente_oid")
    private FuncionarioOid solicitudcrearpagrAgente;
    
    @JsonIgnore
    private Funcionario solicitudcrearpagrAgenteInstance;

    @JsonProperty("p_agrperiodicidad_oid")
    private PeriodicidadOid solicitudcrearpagrPeriodicidad;
    
    @JsonIgnore
    private Periodicidad solicitudcrearpagrPeriodicidadInstance;

    @JsonProperty("p_agrgrupoasociado_oid")
    private GrupoAsociadoOid solicitudcrearpagrGrupoAsociado;
    
    @JsonIgnore
    private GrupoAsociado solicitudcrearpagrGrupoAsociadoInstance;

    @JsonProperty("p_agrcontratoc_oid")
    private ContratoCOid solicitudcrearpagrContratoC;
    
    @JsonIgnore
    private ContratoC solicitudcrearpagrContratoCInstance;

    @JsonProperty("p_agrusrareamedica_oid")
    private AreaMedicaOid solicitudcrearpagrUsrAreaMedica;
    
    @JsonIgnore
    private AreaMedica solicitudcrearpagrUsrAreaMedicaInstance;

    @JsonProperty("p_agrformapago_oid")
    private FormaPagoOid solicitudcrearpagrFormaPago;
    
    @JsonIgnore
    private FormaPago solicitudcrearpagrFormaPagoInstance;

    @JsonProperty("p_agrtipofactura_oid")
    private TipoFacturaOid solicitudcrearpagrTipoFactura;
    
    @JsonIgnore
    private TipoFactura solicitudcrearpagrTipoFacturaInstance;

    @JsonProperty("p_agrusrafiliacion_oid")
    private FuncionarioOid solicitudcrearpagrUsrAfiliacion;
    
    @JsonIgnore
    private Funcionario solicitudcrearpagrUsrAfiliacionInstance;

    @JsonProperty("p_atrtramite")
    private Long solicitudcrearpatrTramite;

    @JsonProperty("p_atrfiniciocontrato")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudcrearpatrFInicioContrato;

    @JsonProperty("p_atrestraslado")
    private Boolean solicitudcrearpatrEsTraslado;

    @JsonProperty("p_atrnumcontratoinclusion")
    private String solicitudcrearpatrNumContratoInclusion;

    @JsonProperty("p_atrnumfamilia")
    private String solicitudcrearpatrNumFamilia;

    @JsonProperty("p_atrcoddirector")
    private String solicitudcrearpatrcodDirector;

    @JsonProperty("p_atrcodtarifa")
    private String solicitudcrearpatrCodTarifa;

    @JsonProperty("p_atrporcentajeprorrateo")
    private Double solicitudcrearpatrPorcentajeProrrateo;

    @JsonProperty("p_atrenviocarnetfisico")
    private Boolean solicitudcrearpatrEnvioCarnetFisico;

    @JsonProperty("p_atrnumradicado")
    private Long solicitudcrearpatrNumRadicado;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudcrearpagrAesolicitudes();
        checkSolicitudcrearpagrAgente();
        checkSolicitudcrearpatrTramite();
        checkSolicitudcrearpatrEsTraslado();
        checkSolicitudcrearpatrcodDirector();
        checkSolicitudcrearpatrEnvioCarnetFisico();
        checkSolicitudcrearpatrNumRadicado();
    }

    @JsonIgnore
    public AesolicitudesOid getSolicitudcrearpagrAesolicitudes() {
        return this.solicitudcrearpagrAesolicitudes;
    }
    
    public void setSolicitudcrearpagrAesolicitudes(AesolicitudesOid solicitudcrearpagrAesolicitudes) {
        this.solicitudcrearpagrAesolicitudes = solicitudcrearpagrAesolicitudes;
    }

    @JsonIgnore
    public Aesolicitudes getSolicitudcrearpagrAesolicitudesInstance() {
        return this.solicitudcrearpagrAesolicitudesInstance;
    }
    
    public void setSolicitudcrearpagrAesolicitudesInstance(Aesolicitudes solicitudcrearpagrAesolicitudes) {
        this.solicitudcrearpagrAesolicitudesInstance = solicitudcrearpagrAesolicitudes;
        this.solicitudcrearpagrAesolicitudes = solicitudcrearpagrAesolicitudes != null ? solicitudcrearpagrAesolicitudes.getOid() : null;
    }

    private void checkSolicitudcrearpagrAesolicitudes() throws NotNullArgumentException {
        if(this.getSolicitudcrearpagrAesolicitudesInstance() == null || this.getSolicitudcrearpagrAesolicitudesInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_CREAR, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_CREAR_SOLICITUDCREARPAGRAESOLICITUDES, SolicitudConstants.SERV_ALIAS_CREAR, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_CREAR_SOLICITUDCREARPAGRAESOLICITUDES);
        }
    }

    @JsonIgnore
    public PersonaOid getSolicitudcrearpagrContratantePersona() {
        return this.solicitudcrearpagrContratantePersona;
    }
    
    public void setSolicitudcrearpagrContratantePersona(PersonaOid solicitudcrearpagrContratantePersona) {
        this.solicitudcrearpagrContratantePersona = solicitudcrearpagrContratantePersona;
    }

    @JsonIgnore
    public Persona getSolicitudcrearpagrContratantePersonaInstance() {
        return this.solicitudcrearpagrContratantePersonaInstance;
    }
    
    public void setSolicitudcrearpagrContratantePersonaInstance(Persona solicitudcrearpagrContratantePersona) {
        this.solicitudcrearpagrContratantePersonaInstance = solicitudcrearpagrContratantePersona;
        this.solicitudcrearpagrContratantePersona = solicitudcrearpagrContratantePersona != null ? solicitudcrearpagrContratantePersona.getOid() : null;
    }

    @JsonIgnore
    public PersonaOid getSolicitudcrearpagrTitularPersona() {
        return this.solicitudcrearpagrTitularPersona;
    }
    
    public void setSolicitudcrearpagrTitularPersona(PersonaOid solicitudcrearpagrTitularPersona) {
        this.solicitudcrearpagrTitularPersona = solicitudcrearpagrTitularPersona;
    }

    @JsonIgnore
    public Persona getSolicitudcrearpagrTitularPersonaInstance() {
        return this.solicitudcrearpagrTitularPersonaInstance;
    }
    
    public void setSolicitudcrearpagrTitularPersonaInstance(Persona solicitudcrearpagrTitularPersona) {
        this.solicitudcrearpagrTitularPersonaInstance = solicitudcrearpagrTitularPersona;
        this.solicitudcrearpagrTitularPersona = solicitudcrearpagrTitularPersona != null ? solicitudcrearpagrTitularPersona.getOid() : null;
    }

    @JsonIgnore
    public ProteccionDatosOid getSolicitudcrearpagrProteccionDatos() {
        return this.solicitudcrearpagrProteccionDatos;
    }
    
    public void setSolicitudcrearpagrProteccionDatos(ProteccionDatosOid solicitudcrearpagrProteccionDatos) {
        this.solicitudcrearpagrProteccionDatos = solicitudcrearpagrProteccionDatos;
    }

    @JsonIgnore
    public ProteccionDatos getSolicitudcrearpagrProteccionDatosInstance() {
        return this.solicitudcrearpagrProteccionDatosInstance;
    }
    
    public void setSolicitudcrearpagrProteccionDatosInstance(ProteccionDatos solicitudcrearpagrProteccionDatos) {
        this.solicitudcrearpagrProteccionDatosInstance = solicitudcrearpagrProteccionDatos;
        this.solicitudcrearpagrProteccionDatos = solicitudcrearpagrProteccionDatos != null ? solicitudcrearpagrProteccionDatos.getOid() : null;
    }

    @JsonIgnore
    public FuncionarioOid getSolicitudcrearpagrAgente() {
        return this.solicitudcrearpagrAgente;
    }
    
    public void setSolicitudcrearpagrAgente(FuncionarioOid solicitudcrearpagrAgente) {
        this.solicitudcrearpagrAgente = solicitudcrearpagrAgente;
    }

    @JsonIgnore
    public Funcionario getSolicitudcrearpagrAgenteInstance() {
        return this.solicitudcrearpagrAgenteInstance;
    }
    
    public void setSolicitudcrearpagrAgenteInstance(Funcionario solicitudcrearpagrAgente) {
        this.solicitudcrearpagrAgenteInstance = solicitudcrearpagrAgente;
        this.solicitudcrearpagrAgente = solicitudcrearpagrAgente != null ? solicitudcrearpagrAgente.getOid() : null;
    }

    private void checkSolicitudcrearpagrAgente() throws NotNullArgumentException {
        if(this.getSolicitudcrearpagrAgenteInstance() == null || this.getSolicitudcrearpagrAgenteInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_CREAR, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_CREAR_SOLICITUDCREARPAGRAGENTE, SolicitudConstants.SERV_ALIAS_CREAR, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_CREAR_SOLICITUDCREARPAGRAGENTE);
        }
    }

    @JsonIgnore
    public PeriodicidadOid getSolicitudcrearpagrPeriodicidad() {
        return this.solicitudcrearpagrPeriodicidad;
    }
    
    public void setSolicitudcrearpagrPeriodicidad(PeriodicidadOid solicitudcrearpagrPeriodicidad) {
        this.solicitudcrearpagrPeriodicidad = solicitudcrearpagrPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getSolicitudcrearpagrPeriodicidadInstance() {
        return this.solicitudcrearpagrPeriodicidadInstance;
    }
    
    public void setSolicitudcrearpagrPeriodicidadInstance(Periodicidad solicitudcrearpagrPeriodicidad) {
        this.solicitudcrearpagrPeriodicidadInstance = solicitudcrearpagrPeriodicidad;
        this.solicitudcrearpagrPeriodicidad = solicitudcrearpagrPeriodicidad != null ? solicitudcrearpagrPeriodicidad.getOid() : null;
    }

    @JsonIgnore
    public GrupoAsociadoOid getSolicitudcrearpagrGrupoAsociado() {
        return this.solicitudcrearpagrGrupoAsociado;
    }
    
    public void setSolicitudcrearpagrGrupoAsociado(GrupoAsociadoOid solicitudcrearpagrGrupoAsociado) {
        this.solicitudcrearpagrGrupoAsociado = solicitudcrearpagrGrupoAsociado;
    }

    @JsonIgnore
    public GrupoAsociado getSolicitudcrearpagrGrupoAsociadoInstance() {
        return this.solicitudcrearpagrGrupoAsociadoInstance;
    }
    
    public void setSolicitudcrearpagrGrupoAsociadoInstance(GrupoAsociado solicitudcrearpagrGrupoAsociado) {
        this.solicitudcrearpagrGrupoAsociadoInstance = solicitudcrearpagrGrupoAsociado;
        this.solicitudcrearpagrGrupoAsociado = solicitudcrearpagrGrupoAsociado != null ? solicitudcrearpagrGrupoAsociado.getOid() : null;
    }

    @JsonIgnore
    public ContratoCOid getSolicitudcrearpagrContratoC() {
        return this.solicitudcrearpagrContratoC;
    }
    
    public void setSolicitudcrearpagrContratoC(ContratoCOid solicitudcrearpagrContratoC) {
        this.solicitudcrearpagrContratoC = solicitudcrearpagrContratoC;
    }

    @JsonIgnore
    public ContratoC getSolicitudcrearpagrContratoCInstance() {
        return this.solicitudcrearpagrContratoCInstance;
    }
    
    public void setSolicitudcrearpagrContratoCInstance(ContratoC solicitudcrearpagrContratoC) {
        this.solicitudcrearpagrContratoCInstance = solicitudcrearpagrContratoC;
        this.solicitudcrearpagrContratoC = solicitudcrearpagrContratoC != null ? solicitudcrearpagrContratoC.getOid() : null;
    }

    @JsonIgnore
    public AreaMedicaOid getSolicitudcrearpagrUsrAreaMedica() {
        return this.solicitudcrearpagrUsrAreaMedica;
    }
    
    public void setSolicitudcrearpagrUsrAreaMedica(AreaMedicaOid solicitudcrearpagrUsrAreaMedica) {
        this.solicitudcrearpagrUsrAreaMedica = solicitudcrearpagrUsrAreaMedica;
    }

    @JsonIgnore
    public AreaMedica getSolicitudcrearpagrUsrAreaMedicaInstance() {
        return this.solicitudcrearpagrUsrAreaMedicaInstance;
    }
    
    public void setSolicitudcrearpagrUsrAreaMedicaInstance(AreaMedica solicitudcrearpagrUsrAreaMedica) {
        this.solicitudcrearpagrUsrAreaMedicaInstance = solicitudcrearpagrUsrAreaMedica;
        this.solicitudcrearpagrUsrAreaMedica = solicitudcrearpagrUsrAreaMedica != null ? solicitudcrearpagrUsrAreaMedica.getOid() : null;
    }

    @JsonIgnore
    public FormaPagoOid getSolicitudcrearpagrFormaPago() {
        return this.solicitudcrearpagrFormaPago;
    }
    
    public void setSolicitudcrearpagrFormaPago(FormaPagoOid solicitudcrearpagrFormaPago) {
        this.solicitudcrearpagrFormaPago = solicitudcrearpagrFormaPago;
    }

    @JsonIgnore
    public FormaPago getSolicitudcrearpagrFormaPagoInstance() {
        return this.solicitudcrearpagrFormaPagoInstance;
    }
    
    public void setSolicitudcrearpagrFormaPagoInstance(FormaPago solicitudcrearpagrFormaPago) {
        this.solicitudcrearpagrFormaPagoInstance = solicitudcrearpagrFormaPago;
        this.solicitudcrearpagrFormaPago = solicitudcrearpagrFormaPago != null ? solicitudcrearpagrFormaPago.getOid() : null;
    }

    @JsonIgnore
    public TipoFacturaOid getSolicitudcrearpagrTipoFactura() {
        return this.solicitudcrearpagrTipoFactura;
    }
    
    public void setSolicitudcrearpagrTipoFactura(TipoFacturaOid solicitudcrearpagrTipoFactura) {
        this.solicitudcrearpagrTipoFactura = solicitudcrearpagrTipoFactura;
    }

    @JsonIgnore
    public TipoFactura getSolicitudcrearpagrTipoFacturaInstance() {
        return this.solicitudcrearpagrTipoFacturaInstance;
    }
    
    public void setSolicitudcrearpagrTipoFacturaInstance(TipoFactura solicitudcrearpagrTipoFactura) {
        this.solicitudcrearpagrTipoFacturaInstance = solicitudcrearpagrTipoFactura;
        this.solicitudcrearpagrTipoFactura = solicitudcrearpagrTipoFactura != null ? solicitudcrearpagrTipoFactura.getOid() : null;
    }

    @JsonIgnore
    public FuncionarioOid getSolicitudcrearpagrUsrAfiliacion() {
        return this.solicitudcrearpagrUsrAfiliacion;
    }
    
    public void setSolicitudcrearpagrUsrAfiliacion(FuncionarioOid solicitudcrearpagrUsrAfiliacion) {
        this.solicitudcrearpagrUsrAfiliacion = solicitudcrearpagrUsrAfiliacion;
    }

    @JsonIgnore
    public Funcionario getSolicitudcrearpagrUsrAfiliacionInstance() {
        return this.solicitudcrearpagrUsrAfiliacionInstance;
    }
    
    public void setSolicitudcrearpagrUsrAfiliacionInstance(Funcionario solicitudcrearpagrUsrAfiliacion) {
        this.solicitudcrearpagrUsrAfiliacionInstance = solicitudcrearpagrUsrAfiliacion;
        this.solicitudcrearpagrUsrAfiliacion = solicitudcrearpagrUsrAfiliacion != null ? solicitudcrearpagrUsrAfiliacion.getOid() : null;
    }

    @JsonIgnore
    public Long getSolicitudcrearpatrTramite() {
        return this.solicitudcrearpatrTramite;
    }
    
    public void setSolicitudcrearpatrTramite(Long solicitudcrearpatrTramite) {
        this.solicitudcrearpatrTramite = solicitudcrearpatrTramite;
    }

    private void checkSolicitudcrearpatrTramite() throws NotNullArgumentException {
        if(this.getSolicitudcrearpatrTramite() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_CREAR, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_CREAR_SOLICITUDCREARPATRTRAMITE, SolicitudConstants.SERV_ALIAS_CREAR, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_CREAR_SOLICITUDCREARPATRTRAMITE);
        }
    }

    @JsonIgnore
    public Date getSolicitudcrearpatrFInicioContrato() {
        return this.solicitudcrearpatrFInicioContrato;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudcrearpatrFInicioContrato(Date solicitudcrearpatrFInicioContrato) {
        this.solicitudcrearpatrFInicioContrato = solicitudcrearpatrFInicioContrato;
    }

    @JsonIgnore
    public Boolean getSolicitudcrearpatrEsTraslado() {
        return this.solicitudcrearpatrEsTraslado;
    }
    
    public void setSolicitudcrearpatrEsTraslado(Boolean solicitudcrearpatrEsTraslado) {
        this.solicitudcrearpatrEsTraslado = solicitudcrearpatrEsTraslado;
    }

    private void checkSolicitudcrearpatrEsTraslado() throws NotNullArgumentException {
        if(this.getSolicitudcrearpatrEsTraslado() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_CREAR, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_CREAR_SOLICITUDCREARPATRESTRASLADO, SolicitudConstants.SERV_ALIAS_CREAR, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_CREAR_SOLICITUDCREARPATRESTRASLADO);
        }
    }

    @JsonIgnore
    public String getSolicitudcrearpatrNumContratoInclusion() {
        return this.solicitudcrearpatrNumContratoInclusion;
    }
    
    public void setSolicitudcrearpatrNumContratoInclusion(String solicitudcrearpatrNumContratoInclusion) {
        this.solicitudcrearpatrNumContratoInclusion = solicitudcrearpatrNumContratoInclusion;
    }

    @JsonIgnore
    public String getSolicitudcrearpatrNumFamilia() {
        return this.solicitudcrearpatrNumFamilia;
    }
    
    public void setSolicitudcrearpatrNumFamilia(String solicitudcrearpatrNumFamilia) {
        this.solicitudcrearpatrNumFamilia = solicitudcrearpatrNumFamilia;
    }

    @JsonIgnore
    public String getSolicitudcrearpatrcodDirector() {
        return this.solicitudcrearpatrcodDirector;
    }
    
    public void setSolicitudcrearpatrcodDirector(String solicitudcrearpatrcodDirector) {
        this.solicitudcrearpatrcodDirector = solicitudcrearpatrcodDirector;
    }

    private void checkSolicitudcrearpatrcodDirector() throws NotNullArgumentException {
        if(this.getSolicitudcrearpatrcodDirector() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_CREAR, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_CREAR_SOLICITUDCREARPATRCODDIRECTOR, SolicitudConstants.SERV_ALIAS_CREAR, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_CREAR_SOLICITUDCREARPATRCODDIRECTOR);
        }
    }

    @JsonIgnore
    public String getSolicitudcrearpatrCodTarifa() {
        return this.solicitudcrearpatrCodTarifa;
    }
    
    public void setSolicitudcrearpatrCodTarifa(String solicitudcrearpatrCodTarifa) {
        this.solicitudcrearpatrCodTarifa = solicitudcrearpatrCodTarifa;
    }

    @JsonIgnore
    public Double getSolicitudcrearpatrPorcentajeProrrateo() {
        return this.solicitudcrearpatrPorcentajeProrrateo;
    }
    
    public void setSolicitudcrearpatrPorcentajeProrrateo(Double solicitudcrearpatrPorcentajeProrrateo) {
        this.solicitudcrearpatrPorcentajeProrrateo = solicitudcrearpatrPorcentajeProrrateo;
    }

    @JsonIgnore
    public Boolean getSolicitudcrearpatrEnvioCarnetFisico() {
        return this.solicitudcrearpatrEnvioCarnetFisico;
    }
    
    public void setSolicitudcrearpatrEnvioCarnetFisico(Boolean solicitudcrearpatrEnvioCarnetFisico) {
        this.solicitudcrearpatrEnvioCarnetFisico = solicitudcrearpatrEnvioCarnetFisico;
    }

    private void checkSolicitudcrearpatrEnvioCarnetFisico() throws NotNullArgumentException {
        if(this.getSolicitudcrearpatrEnvioCarnetFisico() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_CREAR, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_CREAR_SOLICITUDCREARPATRENVIOCARNETFISICO, SolicitudConstants.SERV_ALIAS_CREAR, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_CREAR_SOLICITUDCREARPATRENVIOCARNETFISICO);
        }
    }

    @JsonIgnore
    public Long getSolicitudcrearpatrNumRadicado() {
        return this.solicitudcrearpatrNumRadicado;
    }
    
    public void setSolicitudcrearpatrNumRadicado(Long solicitudcrearpatrNumRadicado) {
        this.solicitudcrearpatrNumRadicado = solicitudcrearpatrNumRadicado;
    }

    private void checkSolicitudcrearpatrNumRadicado() throws NotNullArgumentException {
        if(this.getSolicitudcrearpatrNumRadicado() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_CREAR, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_CREAR_SOLICITUDCREARPATRNUMRADICADO, SolicitudConstants.SERV_ALIAS_CREAR, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_CREAR_SOLICITUDCREARPATRNUMRADICADO);
        }
    }
}
