package com.keralty.aesolicitudes.global;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.LoggerFactory;

import com.keralty.aesolicitudes.persistence.ErrorWS;
import com.keralty.aesolicitudes.persistence.AreaMedica;
import com.keralty.aesolicitudes.persistence.Asesor;
import com.keralty.aesolicitudes.persistence.CuestionarioMed;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.DetalleTarifa;
import com.keralty.aesolicitudes.persistence.Direccion;
import com.keralty.aesolicitudes.persistence.Dominio;
import com.keralty.aesolicitudes.persistence.Eps;
import com.keralty.aesolicitudes.persistence.EstadoBeneficiario;
import com.keralty.aesolicitudes.persistence.EstadoCivil;
import com.keralty.aesolicitudes.persistence.EstadoContrato;
import com.keralty.aesolicitudes.persistence.EstadoPersona;
import com.keralty.aesolicitudes.persistence.Funcionario;
import com.keralty.aesolicitudes.persistence.GrupoAsociado;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.Pais;
import com.keralty.aesolicitudes.persistence.Parentesco;
import com.keralty.aesolicitudes.persistence.Periodicidad;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Planes;
import com.keralty.aesolicitudes.persistence.PlantillaEmail;
import com.keralty.aesolicitudes.persistence.PregCuesMedC;
import com.keralty.aesolicitudes.persistence.Pregunta;
import com.keralty.aesolicitudes.persistence.PreguntaP;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.persistence.Rol;
import com.keralty.aesolicitudes.persistence.SeccionP;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;
import com.keralty.aesolicitudes.persistence.Tarifa;
import com.keralty.aesolicitudes.persistence.TipoDireccion;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.persistence.Usuario;
import com.keralty.aesolicitudes.repository.AsesorJpaRepository;
import com.keralty.aesolicitudes.repository.CuestionarioMedJpaRepository;
import com.keralty.aesolicitudes.repository.DepartamentoJpaRepository;
import com.keralty.aesolicitudes.repository.EpsJpaRepository;
import com.keralty.aesolicitudes.repository.EstadoBeneficiarioJpaRepository;
import com.keralty.aesolicitudes.repository.EstadoCivilJpaRepository;
import com.keralty.aesolicitudes.repository.FuncionarioJpaRepository;
import com.keralty.aesolicitudes.repository.GrupoAsociadoJpaRepository;
import com.keralty.aesolicitudes.repository.MunicipioJpaRepository;
import com.keralty.aesolicitudes.repository.PaisJpaRepository;
import com.keralty.aesolicitudes.repository.ParentescoJpaRepository;
import com.keralty.aesolicitudes.repository.ProductosJpaRepository;
import com.keralty.aesolicitudes.repository.RolJpaRepository;
import com.keralty.aesolicitudes.repository.TipoDireccionJpaRepository;
import com.keralty.aesolicitudes.repository.TipoIdentificacionJpaRepository;
import com.keralty.aesolicitudes.service.AbstractService;
import com.keralty.aesolicitudes.service.SolicitudNovedadService;
import com.keralty.aesolicitudes.service.SolicitudService;
import com.keralty.aesolicitudes.sqlutils.SQLPopulation;
import com.keralty.aesolicitudes.sqlutils.SQLWhereComparison;
import com.keralty.aesolicitudes.sqlutils.SQLWhereConjunction;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aesolicitudes.viewmodel.FilterRequest;
import com.keralty.aesolicitudes.viewmodel.FilterVariableRequest;
import com.keralty.aesolicitudes.viewmodel.QueryRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuAnadirTextoRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuBuscarDocGestorNumIdRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuBuscarDocGestorSolicitudRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuCalcularIMCRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuCalcularIMCUsuarioRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuCallSPgetsemaforoareamedRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuCallSPgetsemaforograbadorRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuCallSPgetsemaforograbadornovRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuCallSPgetusuareamedRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuCallSPgetusugrabadorRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuCallSPgetusugrabadornovRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuCheckRegimenSubsidiadoRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuContieneCharEspecialRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuContratoExentoDocSolRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuEnviarEmailDevDocRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuEnviarEmailRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuEnviarSMSRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuEstadoSolicitudRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuExisteContratoExentoFIngresoRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuFormarTextoObservacionesRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuGenerarReporteOracleRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuGetCodTarifaProdPlanAnyoRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuGetCodigoPersonaCORERequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuGetDirResidenciaPersonaRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuGetFInicioPlanVolRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuGetFechaFinVigenciaUsuarioRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuGetIdDocIdentidadEnGestorRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuGetNombreAsesorRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuGetNombreFuncionarioRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuGetReporteSolicitudRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuGetTextoAvisoFirmaRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuObtenerDocumentoRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuSoloLetrasRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuSoloNumerosRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuStrONullRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuSustituirParamsEnURLRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuValidarDominioIncompatiblesRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuValidarEmailRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuValidarNombreRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuValidarTelefonoCelularRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuValidarTelefonoFijoRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuconcatenarConNulosRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuformarListaValoresPreguntaRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FuformarMsgErrorUsrSinDocsRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetAgenteRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetAreaMedicaPorIdRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetAsesorRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetDepartamentoCLRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetEstadoBeneficiarioCOREPorNombreRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetEstadoBeneficiarioCORERequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetEstadoCivilRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetEstadoContratoPorNombreRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetEstadoContratoRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetEstadoPersonaRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetFuncionarioPorIdRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetFuncionarioPorLDAPRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetGrupoAsocRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetListaErroresRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetMunicipioCLRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetPaisRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetPlanPorCLRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetPlantillaEmailRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetPrioridadRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetProductoPorCLRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetRolRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetSolicitudByNumeroRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetSolicitudNovedadByNumRadicadoRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetTipoIdentificacionRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetValorParametroConfRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FugetValorTarifaSegunEdadRequest;
import com.keralty.aesolicitudes.viewmodel.userfunctions.FusubstringTextRequest;
import com.keralty.integraciones.emailnotification.EmailNotificationsUtils;

import io.quarkus.arc.Arc;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

/**
 * User functions
 */
@ApplicationScoped
public class UserFunctions extends AbstractService {
    
    @PersistenceContext
    protected EntityManager em;

    @RestClient
    UserFunctionsProxy userFunctionsProxy;

    @Inject
    SolicitudService solicitudService;

    @Inject
    SolicitudNovedadService solicitudNovedadService;
    
    @Inject
    CuestionarioMedJpaRepository cuestionarioMedJpaRepository;

    @Inject 
    EmailNotificationsUtils emailNotificationsUtils;


	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final String NUMEROS_PATTERN = "^[0-9]+$";

	private static final String LETRAS_PATTERN = "^[a-zA-Z]+$";

	private static final String TELEFONOFIJO_PATTERN = "\\d{7}";

	private static final String TELEFONOCELULAR_PATTERN = "\\d{10}";

    private static final String CARACTERESNORMALES_PATTERN = "^[a-zA-Z0-9áäéíóöúüÄÁÉÍÓÖÜÚñÑ\\s\\.\\-]*$";
    
    
    private static Boolean regexpMatches(String regexp, String text) {
        Boolean result = true;
        if (text != null) {
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regexp);
            java.util.regex.Matcher matcher = pattern.matcher(text);
            result = matcher.matches();
        }
        return result;
    }
    
    private static int countOccurrences(String findStr, String text) {
        int lastIndex = 0;
        int count =0;

        while(lastIndex != -1){

               lastIndex = text.indexOf(findStr,lastIndex);

               if( lastIndex != -1){
                     count ++;
                     lastIndex += findStr.length();
              }
        }
        return count;
    }
    
    private static Boolean hasDifferentDigits(String text) {
        Boolean result = true;
        if (text != null) {
            result = (countOccurrences("0", text) < text.length() &&
                    countOccurrences("1", text) < text.length() &&
                    countOccurrences("2", text) < text.length() &&
                    countOccurrences("3", text) < text.length() &&
                    countOccurrences("4", text) < text.length() &&
                    countOccurrences("5", text) < text.length() &&
                    countOccurrences("6", text) < text.length() &&
                    countOccurrences("7", text) < text.length() &&
                    countOccurrences("8", text) < text.length() &&
                    countOccurrences("9", text) < text.length());
        }
        return result;
    }

 
    private Double llamarFuncionPktAsignaciones(String nombreFuncion, Long numSol){
    	// Llamada a una funciÃ³n de Oracle
    	try {
			String storedProcedure = "select pktmodasig." + nombreFuncion + "(?1) from dual";
			Query query = em.createNativeQuery(storedProcedure);
			query.setParameter(1, numSol);
			
			Object resultado = query.getSingleResult();
	
			if (resultado != null){
				return Double.parseDouble(resultado.toString());
			} 
    	} catch(Exception e) {
    		LoggerFactory.getLogger(this.getClass()).error("Error en llamarFuncionPktAsignaciones: " + e.getMessage());
    	}

    	return 0.0;
    }

    /** 
     * Method that solves the fuformarListaValoresPregunta user function.
     *
     * @param pfuPregunta This parameter represents the pfuPregunta inbound argument.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuformarListaValoresPreguntaFun(Pregunta pfuPregunta) {

        // COMMENTS:
		// Dada una pregunta de un cuestrionario, devuelve una coma lista de los valores
		// posibles para de dicha pregunta

		if (pfuPregunta == null || pfuPregunta.isNull())
			return "";

		StringBuilder result = new StringBuilder();
		String separator = "";
		for (com.keralty.aesolicitudes.persistence.Valor valor : pfuPregunta.getValores()) {
			result.append(separator);
			result.append(valor.getValorValorPosible());
			separator = ";";
		}
		return result.toString();
    }

    public String fuformarListaValoresPreguntaFun(FuformarListaValoresPreguntaRequest request) {
        return fuformarListaValoresPreguntaFun(request.getPfuPreguntaInstance());
    }

    /** 
     * Method that solves the fuconcatenarConNulos user function.
     *
     * @param pfuPrefijo This parameter represents the pfuPrefijo inbound argument.
     *
     * @param pfuString This parameter represents the pfuString inbound argument.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuconcatenarConNulosFun(String pfuPrefijo, String pfuString) {

        // COMMENTS:
        // Funcion que recibe dos parametros, un prefijo y un string que admite nulos. Si el segundo parametro es nulo, devuelve cadena vacia, si no lo es, concatena prefijo y string.
    	String textoADevolver = ""; 
    	try{
	    	String prefijo = "";
	    	if (pfuPrefijo != null && !pfuPrefijo.isEmpty())
	    		prefijo = pfuPrefijo;
	    	
	    	String texto = ""; 
	    	if (pfuString != null && !pfuString.isEmpty())
	    		texto = pfuString; 
	    	
	    	textoADevolver = prefijo + texto; 
	    	
    	} catch (Exception e)  {
    		textoADevolver = "Error ->" + e.getMessage();
		}
    	return textoADevolver; 
    }

    public String fuconcatenarConNulosFun(FuconcatenarConNulosRequest request) {
        return fuconcatenarConNulosFun(request.getPfuPrefijo(), request.getPfuString());
    }

    /** 
     * Method that solves the fugetTipoDirResidencial user function.
     *
     * @return Return TipoDireccion value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public TipoDireccion fugetTipoDirResidencialFun() {

        // COMMENTS:
        // Devuelve el tipo de dirección que corresponde a residencial
        //return userFunctionsProxy.fugetTipoDirResidencialFun();
    	try {
	    	SQLPopulation query = new SQLPopulation(TipoDireccionConstants.CLASS_NAME);
	
	        SQLWhereConjunction conjunction = new SQLWhereConjunction();
	
	        // EsResidencia = true
	        // '=' Comparison
	        SQLWhereComparison comparison = new SQLWhereComparison(query);
	        comparison.setOperator("=");
	        
	        
	        SQLWhereOperandPathAttribute operand1= new SQLWhereOperandPathAttribute(TipoDireccionConstants.ATTR_NAME_TIPODIRECCIONESRESIDENCIA, Constants.Type.BOOL.getTypeName());
	        comparison.setFirstOperand(operand1);
	        
	        // True
	        comparison.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
	        conjunction.addOperand(comparison);
	
	
	        query.addConjunction(conjunction);
	    	
			List<TipoDireccion> lista = Arc.container().select(TipoDireccionJpaRepository.class).get().solveQuery(query );
			if (lista != null && !lista.isEmpty()) {
				return lista.get(0);						
			}
    	} catch(Exception e) {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fugetTipoDirResidencialFun: " + e.getMessage());
    	}
    	return null;
    }

    /** 
     * Method that solves the fugetTipoDirCorrespondencia user function.
     *
     * @return Return TipoDireccion value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public TipoDireccion fugetTipoDirCorrespondenciaFun() {

        // COMMENTS:
        // Devuelve el tipo de dirección que corresponde a correspondencia
    	try {
	    	SQLPopulation query = new SQLPopulation(TipoDireccionConstants.CLASS_NAME);
	
	        SQLWhereConjunction conjunction = new SQLWhereConjunction();
	
	        // EsResidencia = true
	        // '=' Comparison
	        SQLWhereComparison comparison = new SQLWhereComparison(query);
	        comparison.setOperator("=");
	        
	        // EsCorrespondencia
	        SQLWhereOperandPathAttribute operand1= new SQLWhereOperandPathAttribute(TipoDireccionConstants.ATTR_NAME_TIPODIRECCIONESCORRESPONDENCIA, Constants.Type.BOOL.getTypeName());
	        comparison.setFirstOperand(operand1);
	        
	        // True
	        comparison.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
	        conjunction.addOperand(comparison);
	
	
	        query.addConjunction(conjunction);
	    	
			List<TipoDireccion> lista = Arc.container().select(TipoDireccionJpaRepository.class).get().solveQuery(query );
			if (lista != null && !lista.isEmpty()) {
				return lista.get(0);						
			}
    	} catch(Exception e) {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fugetTipoDirCorrespondenciaFun: " + e.getMessage());
    	}
    	return null;
    }

    /** 
     * Method that solves the fuValidarEmail user function.
     *
     * @param pfuEmail This parameter represents the pfuEmail inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Boolean fuValidarEmailFun(String pfuEmail) {

        // COMMENTS:
        // Validar que la información en e-mail contenga un solo arroba y que después del carácter arroba exista por lo menos un punto, que no contenga, tildes, ni comas, ni el carácter ñ.
        //         Si el email recibido es nulo (no lo ha proporcionado) devuelve TRUE, ya que esta función se usará en precondiciones. 
		return regexpMatches(EMAIL_PATTERN, pfuEmail);
    }

    public java.lang.Boolean fuValidarEmailFun(FuValidarEmailRequest request) {
        return fuValidarEmailFun(request.getPfuEmail());
    }

    /** 
     * Method that solves the fuValidarNombre user function.
     *
     * @param pfuNombre This parameter represents the pfuNombre inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Boolean fuValidarNombreFun(String pfuNombre) {

		// COMMENTS:
		// El nombre debe contener al menos un cara¡cter alfabético.
		// Si el nombre recibido es nulo (no lo ha proporcionado) devuelve TRUE, ya que
		// esta función se usará en precondiciones.
		if (pfuNombre != null && !pfuNombre.isEmpty()) {
			return regexpMatches(CARACTERESNORMALES_PATTERN, pfuNombre);
		}
		return false;
    }

    public java.lang.Boolean fuValidarNombreFun(FuValidarNombreRequest request) {
        return fuValidarNombreFun(request.getPfuNombre());
    }

    /** 
     * Method that solves the fuSoloNumeros user function.
     *
     * @param pfuNumero This parameter represents the pfuNumero inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Boolean fuSoloNumerosFun(String pfuNumero) {

        // COMMENTS:
        // El argumento debe contener sólo números.
        //         Si el argumento recibido es nulo (no lo ha proporcionado) devuelve TRUE, ya que esta función se usará en precondiciones. 
		// El argumento debe contener sólo números.
		// Si el argumento recibido es nulo (no lo ha proporcionado) devuelve TRUE
		return pfuNumero == null || regexpMatches(NUMEROS_PATTERN, pfuNumero);
    }

    public java.lang.Boolean fuSoloNumerosFun(FuSoloNumerosRequest request) {
        return fuSoloNumerosFun(request.getPfuNumero());
    }

    /** 
     * Method that solves the fuContieneCharEspecial user function.
     *
     * @param pfustring This parameter represents the pfustring inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Boolean fuContieneCharEspecialFun(String pfustring) {

        // COMMENTS:
        // El argumento no debe contener carácteres especiales.
        //         Si el argumento recibido es nulo (no lo ha proporcionado) devuelve FALSE ya que esta función se usará en precondiciones.
    	if (pfustring == null || pfustring.isEmpty()) {
    		return false;
    	}
    	return !regexpMatches(CARACTERESNORMALES_PATTERN, pfustring);
    }

    public java.lang.Boolean fuContieneCharEspecialFun(FuContieneCharEspecialRequest request) {
        return fuContieneCharEspecialFun(request.getPfustring());
    }

    /** 
     * Method that solves the fugetTipoIdentificacion user function.
     *
     * @param pfuNombreCorto This parameter represents the pfuNombreCorto inbound argument.
     *
     * @return Return TipoIdentificacion value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public TipoIdentificacion fugetTipoIdentificacionFun(String pfuNombreCorto) {

        // COMMENTS:
        // Devuelve el tipo de identificaciÃ³n a partir de su nombre corto.
    	try {
	    	SQLPopulation query = new SQLPopulation(TipoIdentificacionConstants.CLASS_NAME);
	
	        SQLWhereConjunction conjunction = new SQLWhereConjunction();
	
	        // EsResidencia = true
	        // '=' Comparison
	        SQLWhereComparison comparison = new SQLWhereComparison(query);
	        comparison.setOperator("=");
	        
	        // EsCorrespondencia
	        SQLWhereOperandPathAttribute operand1= new SQLWhereOperandPathAttribute(TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONNOMBRECORTO, Constants.Type.STRING.getTypeName());
	        comparison.setFirstOperand(operand1);
	        
	        // True
	        comparison.setSecondOperand(new SQLWhereOperandLiteral(pfuNombreCorto, Constants.Type.STRING.getTypeName()));
	        conjunction.addOperand(comparison);
	
	
	        query.addConjunction(conjunction);
	    	
			List<TipoIdentificacion> lista = Arc.container().select(TipoIdentificacionJpaRepository.class).get().solveQuery(query );
			if (lista != null && !lista.isEmpty()) {
				return lista.get(0);						
			}
    	} catch(Exception e) {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fugetTipoIdentificacionFun: " + e.getMessage());
    	}    	
    	return null;
    }

    public TipoIdentificacion fugetTipoIdentificacionFun(FugetTipoIdentificacionRequest request) {
        return fugetTipoIdentificacionFun(request.getPfuNombreCorto());
    }

    /** 
     * Method that solves the fugetEstadoCivil user function.
     *
     * @param pfuCodigo This parameter represents the pfuCodigo inbound argument.
     *
     * @return Return EstadoCivil value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public EstadoCivil fugetEstadoCivilFun(java.lang.Long pfuCodigo) {

        // COMMENTS:
        // Devuelve el estado civil a partir de su código
    	if (pfuCodigo != null) {
	    	try {
				EstadoCivil lista = Arc.container().select(EstadoCivilJpaRepository.class).get().getOne(pfuCodigo);
				if (lista != null ) {
					return lista;						
				}
	    	} catch(Exception e) {
	    		LoggerFactory.getLogger(this.getClass()).error("Error en fugetEstadoCivilFun: " + e.getMessage());
	    	}
    	}
    	return null;   
    }

    public EstadoCivil fugetEstadoCivilFun(FugetEstadoCivilRequest request) {
        return fugetEstadoCivilFun(request.getPfuCodigo());
    }

    /** 
     * Method that solves the fugetEstadoPersona user function.
     *
     * @param pfuCodigo This parameter represents the pfuCodigo inbound argument.
     *
     * @return Return EstadoPersona value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public EstadoPersona fugetEstadoPersonaFun(java.lang.Long pfuCodigo) {

        // COMMENTS:
        // Devuelve el estado de la persona a partir de su código
        FugetEstadoPersonaRequest request = new FugetEstadoPersonaRequest();
        request.setPfuCodigo(pfuCodigo);
        return userFunctionsProxy.fugetEstadoPersonaFun(request);
    }

    public EstadoPersona fugetEstadoPersonaFun(FugetEstadoPersonaRequest request) {
        return fugetEstadoPersonaFun(request.getPfuCodigo());
    }

    /** 
     * Method that solves the fugetPais user function.
     *
     * @param pfuCodigo This parameter represents the pfuCodigo inbound argument.
     *
     * @return Return Pais value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Pais fugetPaisFun(String pfuCodigo) {

        // COMMENTS:
        // Devuelve el  país a partir de su código
    	try {
			Pais lista = Arc.container().select(PaisJpaRepository.class).get().getOne(pfuCodigo);
			if (lista != null ) {
				return lista;						
			}
    	} catch(Exception e) {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fugetPaisFun: " + e.getMessage());
    	}
    	return null; 
    }

    public Pais fugetPaisFun(FugetPaisRequest request) {
        return fugetPaisFun(request.getPfuCodigo());
    }

    /** 
     * Method that solves the fuValidarTelefonoFijo user function.
     *
     * @param pfuTelefonoFijo This parameter represents the pfuTelefonoFijo inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Boolean fuValidarTelefonoFijoFun(String pfuTelefonoFijo) {

		// COMMENTS:
		// Validar que la información en teléfono fijo contenga al menos 7 dígitos y que
		// alguno de los 7 sea diferente.
		// Si el teléfono recibido es nulo (no lo ha proporcionado) devuelve TRUE
		return regexpMatches(TELEFONOFIJO_PATTERN, pfuTelefonoFijo) && hasDifferentDigits(pfuTelefonoFijo);
    }

    public java.lang.Boolean fuValidarTelefonoFijoFun(FuValidarTelefonoFijoRequest request) {
        return fuValidarTelefonoFijoFun(request.getPfuTelefonoFijo());
    }

    /** 
     * Method that solves the fuValidarTelefonoCelular user function.
     *
     * @param pfuTelefonoCelular This parameter represents the pfuTelefonoCelular inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Boolean fuValidarTelefonoCelularFun(String pfuTelefonoCelular) {

		// COMMENTS:
		// Validar que la información contenga al menos 10 dígitos y que alguno de los
		// 10 sea diferente.
		// Si el dato recibido es nulo (no lo ha proporcionado) devuelve TRUE
		return regexpMatches(TELEFONOCELULAR_PATTERN, pfuTelefonoCelular) && hasDifferentDigits(pfuTelefonoCelular);
    }

    public java.lang.Boolean fuValidarTelefonoCelularFun(FuValidarTelefonoCelularRequest request) {
        return fuValidarTelefonoCelularFun(request.getPfuTelefonoCelular());
    }

    /** 
     * Method that solves the fuStrONull user function.
     *
     * @param pfuNumero This parameter represents the pfuNumero inbound argument.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuStrONullFun(java.lang.Long pfuNumero) {

        // COMMENTS:
        // Recibe un número. Si el número recibido es null, devuelve null. Si es un número lo convierte a string. 
        //         No se puede usar IntToStr, porque si recibe un null falla. 
        FuStrONullRequest request = new FuStrONullRequest();
        request.setPfuNumero(pfuNumero);
        return userFunctionsProxy.fuStrONullFun(request);
    }

    public String fuStrONullFun(FuStrONullRequest request) {
        return fuStrONullFun(request.getPfuNumero());
    }

    /** 
     * Method that solves the fugetEPSSanitas user function.
     *
     * @return Return Eps value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Eps fugetEPSSanitasFun() {

        // COMMENTS:
        // Devuelve la EPS Sanitas, esto es, la primera que tenga la marca de EPS Sanitas a true. Se utiliza en reglas de dependencia. 
    	try {
	    	SQLPopulation query = new SQLPopulation(EpsConstants.CLASS_NAME);
	
	        SQLWhereConjunction conjunction = new SQLWhereConjunction();
	
	        // EsResidencia = true
	        // '=' Comparison
	        SQLWhereComparison comparison = new SQLWhereComparison(query);
	        comparison.setOperator("=");
	        
	        SQLWhereOperandPathAttribute operand1= new SQLWhereOperandPathAttribute(EpsConstants.ATTR_NAME_EPSEPSSANITAS, Constants.Type.BOOL.getTypeName());
	        comparison.setFirstOperand(operand1);
	        
	        comparison.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
	        conjunction.addOperand(comparison);
	
	
	        query.addConjunction(conjunction);
	    	
			List<Eps> lista = Arc.container().select(EpsJpaRepository.class).get().solveQuery(query );
			if (lista != null && !lista.isEmpty()) {
				return lista.get(0);						
			}
    	} catch(Exception e) {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fugetEPSSanitasFun: " + e.getMessage());
    	}
    	return null;
    }

    /** 
     * Method that solves the fugetParentescoTitular user function.
     *
     * @return Return Parentesco value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Parentesco fugetParentescoTitularFun() {

        // COMMENTS:
        // Devuelve el parentesco titular. Se utiliza en reglas de dependencia. 
    	try {
	    	SQLPopulation query = new SQLPopulation(ParentescoConstants.CLASS_NAME);
	
	        SQLWhereConjunction conjunction = new SQLWhereConjunction();
	
	        // EsResidencia = true
	        // '=' Comparison
	        SQLWhereComparison comparison = new SQLWhereComparison(query);
	        comparison.setOperator("=");
	        
	        // EsCorrespondencia
	        SQLWhereOperandPathAttribute operand1= new SQLWhereOperandPathAttribute(ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
	        comparison.setFirstOperand(operand1);
	        
	        // True
	        comparison.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
	        conjunction.addOperand(comparison);
	
	
	        query.addConjunction(conjunction);
	    	
			List<Parentesco> lista = Arc.container().select(ParentescoJpaRepository.class).get().solveQuery(query );
			if (lista != null && !lista.isEmpty()) {
				return lista.get(0);						
			}
    	} catch(Exception e) {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fugetParentescoTitularFun: " + e.getMessage());
    	}
    	return null;
    }

    /** 
     * Method that solves the fugetCuestionarioMedico user function.
     *
     * @return Return CuestionarioMed value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public CuestionarioMed fugetCuestionarioMedicoFun() {

        // COMMENTS:
        // Devuelve la única instancia que debe existir de cuestionario médico.
        //         No hace falta modelar filtro en la clase, recuperaremos toda la población.
    	
    	try {
			// List<CuestionarioMed> lista = Arc.container().select(CuestionarioMedJpaRepository.class).get().findAll();
			List<CuestionarioMed> lista = cuestionarioMedJpaRepository.findAll();
			if (lista != null && !lista.isEmpty()) {
				return lista.get(0);						
			}
    	} catch(Exception e) {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fugetCuestionarioMedicoFun: " + e.getMessage());
    	}
    	return null;

    }

    /** 
     * Method that solves the fugetValorParametroConf user function.
     *
     * @param pfuCodigo This parameter represents the pfuCodigo inbound argument.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fugetValorParametroConfFun(String pfuCodigo) {

    	// COMMENTS:
    	// Devuelve el valor del parámetro de configuración cuyo código recibe como argumento. 
    	String valor  = null;
    	try {
    		String select = "select " + ParamConfigConstants.FLD_PARAMCONFIGVALOR+
    				" FROM " + ParamConfigConstants.CLASS_NAME +
    				" WHERE " +
    				ParamConfigConstants.FLD_PARAMCONFIGCODIGO  + " = ?1 ";
    		Query query = em.createNativeQuery(select);
    		query.setParameter(1, pfuCodigo);

    		Object resultado = query.getSingleResult();

    		if (resultado != null) {
    			valor = resultado.toString() ;
    		}    				
    	} catch (NoResultException e)  {
    		valor = null;
    	} catch (Exception e)  {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fugetValorParametroConfFun: " + e.getMessage());
    		valor = null;
    	}
    	return valor;    	        
    }

    public String fugetValorParametroConfFun(FugetValorParametroConfRequest request) {
        return fugetValorParametroConfFun(request.getPfuCodigo());
    }

    /** 
     * Method that solves the fugetRol user function.
     *
     * @param pfuNombre This parameter represents the pfuNombre inbound argument.
     *
     * @return Return Rol value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Rol fugetRolFun(String pfuNombre) {

        // COMMENTS:
        // Devuelve el rol con el nombre recibido.
    	try {
	    	SQLPopulation query = new SQLPopulation(RolConstants.CLASS_NAME);
	
	        SQLWhereConjunction conjunction = new SQLWhereConjunction();
	
	        // EsResidencia = true
	        // '=' Comparison
	        SQLWhereComparison comparison = new SQLWhereComparison(query);
	        comparison.setOperator("=");
	        
	        // EsCorrespondencia
	        SQLWhereOperandPathAttribute operand1= new SQLWhereOperandPathAttribute(RolConstants.ATTR_NAME_ROLNOMBRE, Constants.Type.STRING.getTypeName());
	        comparison.setFirstOperand(operand1);
	        
	        // True
	        comparison.setSecondOperand(new SQLWhereOperandLiteral(pfuNombre, Constants.Type.STRING.getTypeName()));
	        conjunction.addOperand(comparison);
	
	
	        query.addConjunction(conjunction);
	    	
			List<Rol> lista = Arc.container().select(RolJpaRepository.class).get().solveQuery(query );
			if (lista != null && !lista.isEmpty()) {
				return lista.get(0);						
			}
    	} catch(Exception e) {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fugetRolFun: " + e.getMessage());
    	}
    	return null;
    }

    public Rol fugetRolFun(FugetRolRequest request) {
        return fugetRolFun(request.getPfuNombre());
    }

    /** 
     * Method that solves the fusubstringText user function.
     *
     * @param pfuText This parameter represents the pfuText inbound argument.
     *
     * @param pfuDesde This parameter represents the pfuDesde inbound argument.
     *
     * @param pfuHasta This parameter represents the pfuHasta inbound argument.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fusubstringTextFun(String pfuText, java.lang.Long pfuDesde, java.lang.Long pfuHasta) {

        // COMMENTS:
        // Devuelve el substring del texto recibido. Es como la función estándar pero con text. 
        FusubstringTextRequest request = new FusubstringTextRequest();
        request.setPfuText(pfuText);
        request.setPfuDesde(pfuDesde);
        request.setPfuHasta(pfuHasta);
        return userFunctionsProxy.fusubstringTextFun(request);
    }

    public String fusubstringTextFun(FusubstringTextRequest request) {
        return fusubstringTextFun(request.getPfuText(), request.getPfuDesde(), request.getPfuHasta());
    }

    /** 
     * Method that solves the fugetValorTarifaSegunEdad user function.
     *
     * @param pfuProducto This parameter represents the pfuProducto inbound argument.
     *
     * @param pfuPlan This parameter represents the pfuPlan inbound argument.
     *
     * @param pfuEdad This parameter represents the pfuEdad inbound argument.
     *
     * @param pfuTipoContrato This parameter represents the pfuTipoContrato inbound argument.
     *
     * @param pfuVieneTraslado This parameter represents the pfuVieneTraslado inbound argument.
     *
     * @param pfuFechaContratacion This parameter represents the pfuFechaContratacion inbound argument.
     *
     * @return Return java.lang.Double value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Double fugetValorTarifaSegunEdadFun(Productos pfuProducto, Planes pfuPlan, java.lang.Long pfuEdad, java.lang.Long pfuTipoContrato, java.lang.Boolean pfuVieneTraslado, java.sql.Date pfuFechaContratacion) {

        // COMMENTS:
        // Recibe producto, plan, edad, tipo contrato y si viene de traslado. Devuelve el valor 
        FugetValorTarifaSegunEdadRequest request = new FugetValorTarifaSegunEdadRequest();
        request.setPfuProductoInstance(pfuProducto);
        request.setPfuPlanInstance(pfuPlan);
        request.setPfuEdad(pfuEdad);
        request.setPfuTipoContrato(pfuTipoContrato);
        request.setPfuVieneTraslado(pfuVieneTraslado);
        request.setPfuFechaContratacion(pfuFechaContratacion);
        return userFunctionsProxy.fugetValorTarifaSegunEdadFun(request);
    }

    public java.lang.Double fugetValorTarifaSegunEdadFun(FugetValorTarifaSegunEdadRequest request) {
        return fugetValorTarifaSegunEdadFun(request.getPfuProductoInstance(), request.getPfuPlanInstance(), request.getPfuEdad(), request.getPfuTipoContrato(), request.getPfuVieneTraslado(), request.getPfuFechaContratacion());
    }

    /** 
     * Method that solves the fugetGrupoAsoc user function.
     *
     * @param pfuCodioLegal This parameter represents the pfuCodioLegal inbound argument.
     *
     * @return Return GrupoAsociado value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public GrupoAsociado fugetGrupoAsocFun(String pfuCodioLegal) {
    	try {
	    	SQLPopulation query = new SQLPopulation(GrupoAsociadoConstants.CLASS_NAME);
	
	        SQLWhereConjunction conjunction = new SQLWhereConjunction();
	
	        // EsResidencia = true
	        // '=' Comparison
	        SQLWhereComparison comparison = new SQLWhereComparison(query);
	        comparison.setOperator("=");
	        
	        SQLWhereOperandPathAttribute operand1= new SQLWhereOperandPathAttribute(GrupoAsociadoConstants.ATTR_NAME_GRUPOASOCIADOCODIGOLEGAL, Constants.Type.STRING.getTypeName());
	        comparison.setFirstOperand(operand1);
	        
	        comparison.setSecondOperand(new SQLWhereOperandLiteral(pfuCodioLegal, Constants.Type.STRING.getTypeName()));
	        conjunction.addOperand(comparison);
	
	
	        query.addConjunction(conjunction);
	    	
			List<GrupoAsociado> lista = Arc.container().select(GrupoAsociadoJpaRepository.class).get().solveQuery(query);
			if (lista != null && !lista.isEmpty()) {
				return lista.get(0);						
			}
    	} catch(Exception e) {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fugetGrupoAsocFun: " + e.getMessage());
    	}
    	return null;
    }

    public GrupoAsociado fugetGrupoAsocFun(FugetGrupoAsocRequest request) {
        return fugetGrupoAsocFun(request.getPfuCodioLegal());
    }

    /** 
     * Method that solves the fugetEstadoBeneficiarioCORE user function.
     *
     * @param pfuCodigo This parameter represents the pfuCodigo inbound argument.
     *
     * @return Return EstadoBeneficiario value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public EstadoBeneficiario fugetEstadoBeneficiarioCOREFun(java.lang.Long pfuCodigo) {
        FugetEstadoBeneficiarioCORERequest request = new FugetEstadoBeneficiarioCORERequest();
        request.setPfuCodigo(pfuCodigo);
        return userFunctionsProxy.fugetEstadoBeneficiarioCOREFun(request);
    }

    public EstadoBeneficiario fugetEstadoBeneficiarioCOREFun(FugetEstadoBeneficiarioCORERequest request) {
        return fugetEstadoBeneficiarioCOREFun(request.getPfuCodigo());
    }

    /** 
     * Method that solves the fuObtenerDocumento user function.
     *
     * @param pPathCompleto This parameter represents the pPathCompleto inbound argument.
     *
     * @return Return byte[] value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public byte[] fuObtenerDocumentoFun(String pPathCompleto) {
        FuObtenerDocumentoRequest request = new FuObtenerDocumentoRequest();
        request.setPPathCompleto(pPathCompleto);
        return userFunctionsProxy.fuObtenerDocumentoFun(request);
    }

    public byte[] fuObtenerDocumentoFun(FuObtenerDocumentoRequest request) {
        return fuObtenerDocumentoFun(request.getPPathCompleto());
    }

    /** 
     * Method that solves the fugetPeriodicidadMensual user function.
     *
     * @return Return Periodicidad value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Periodicidad fugetPeriodicidadMensualFun() {

        // COMMENTS:
        // Devuelve la periodicidad mensual
        return userFunctionsProxy.fugetPeriodicidadMensualFun();
    }

    /** 
     * Method that solves the fugetPlantillaEmail user function.
     *
     * @param pfuCodigo This parameter represents the pfuCodigo inbound argument.
     *
     * @param pfSolicitud This parameter represents the pfSolicitud inbound argument.
     *
     * @return Return PlantillaEmail value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public PlantillaEmail fugetPlantillaEmailFun(java.lang.Long pfuCodigo, Solicitud pfSolicitud) {

        // COMMENTS:
        // Recupera una plantilla de email a partir de su código y para la solicitud indicada
    	for (Dominio dominio : pfSolicitud.getAesolicitudes().getPlanT().getDominios()) {
    		for(PlantillaEmail plantilla : dominio.getPlantillas()) {
    			if (plantilla.getPlantillaEmailCodigo().equals(pfuCodigo)) {
    				return plantilla;
    			}
    		}
    	}
    	return null;
    }

    public PlantillaEmail fugetPlantillaEmailFun(FugetPlantillaEmailRequest request) {
        return fugetPlantillaEmailFun(request.getPfuCodigo(), request.getPfSolicitudInstance());
    }

    /** 
     * Method that solves the fuSustituirParamsEnURL user function.
     *
     * @param pfuURL Valor sacado del fichero de propiedades
     *
     * @param pfuSolicitud This parameter represents the pfuSolicitud inbound argument.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuSustituirParamsEnURLFun(String pfuURL, Solicitud pfuSolicitud) {

        // COMMENTS:
        // Devuelve la URL de pago recibida sustituyendo los parámetros por los valores proporcionados.
        //         Según la solicitud sea de nueva afiliación o inclusión la URL tiene más parámetros o menos.  Pero todos ellos se pueden sacar de la solicitud.
        FuSustituirParamsEnURLRequest request = new FuSustituirParamsEnURLRequest();
        request.setPfuURL(pfuURL);
        request.setPfuSolicitudInstance(pfuSolicitud);
        return userFunctionsProxy.fuSustituirParamsEnURLFun(request);
    }

    public String fuSustituirParamsEnURLFun(FuSustituirParamsEnURLRequest request) {
        return fuSustituirParamsEnURLFun(request.getPfuURL(), request.getPfuSolicitudInstance());
    }

    /** 
     * Method that solves the fuEnviarEmail user function.
     *
     * @param pfuAsunto This parameter represents the pfuAsunto inbound argument.
     *
     * @param pfuDestinatario This parameter represents the pfuDestinatario inbound argument.
     *
     * @param pfuEmailConfirmacion This parameter represents the pfuEmailConfirmacion inbound argument.
     *
     * @param pfuCuerpo This parameter represents the pfuCuerpo inbound argument.
     *
     * @param pfuNombreAdjunto Si se manda un adjunto, el nombre del adjunto
     *
     * @param pfuAdjunto Si hay adjunto, el adjunto
     *
     * @param pfuNumSolicitud El número de la solicitud en el marco de la cual se envía el email (si es en el marco de una solicitud).
     * GdC37, para el log
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuEnviarEmailFun(String pfuAsunto, String pfuDestinatario, String pfuEmailConfirmacion, String pfuCuerpo, String pfuNombreAdjunto, byte[] pfuAdjunto, String pfuNumSolicitud) {

    	String resultado = "";
    	try{
    		if (pfuAsunto == null)
    			return "No se puedo enviar el email por no disponer de asunto";
    		
    		if (pfuDestinatario == null)
    			return "No se puedo enviar el email por no disponer del email del destinatario";   	
    		
    		if (pfuCuerpo == null)
    			return "No se puedo enviar el email por no disponer de cuerpo del mensaje";   
    		
    		resultado = emailNotificationsUtils.enviarCorreo(pfuAsunto, pfuDestinatario, pfuCuerpo, pfuNombreAdjunto, pfuAdjunto, pfuNumSolicitud, pfuEmailConfirmacion);
    	} catch (Exception e)  {
    		String msgError = e.getMessage();
    		if (msgError != null && msgError.length() > 251){
    			msgError = msgError.substring(0, 250);
    		}
    		return msgError;
		}
    	
    	return resultado != null && !resultado.isEmpty() ? resultado : "Email enviado";
    }

    public String fuEnviarEmailFun(FuEnviarEmailRequest request) {
        return fuEnviarEmailFun(request.getPfuAsunto(), request.getPfuDestinatario(), request.getPfuEmailConfirmacion(), request.getPfuCuerpo(), request.getPfuNombreAdjunto(), request.getPfuAdjunto(), request.getPfuNumSolicitud());
    }

    /** 
     * Method that solves the fuAnadirTexto user function.
     *
     * @param pfuTexto This parameter represents the pfuTexto inbound argument.
     *
     * @param pfuAnadir This parameter represents the pfuAnadir inbound argument.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuAnadirTextoFun(String pfuTexto, String pfuAnadir) {

        // COMMENTS:
        // Recibe como parámetro un text, que es el texto de una plantilla de email. Le añade un salto de línea y el argumento recibido, que es la URL de pago.
        //         Se utilizará desde el envío de las URLs de pago a los contratantes

    	String pfuTextoCompleto = pfuTexto; 
    	
    	try{
    		if (pfuTexto == null)
    			return null;
    		
    		if (pfuAnadir != null && !pfuAnadir.isEmpty()) {
    			pfuTextoCompleto = pfuTextoCompleto + "\n" + pfuAnadir;
    		}
    		
    	} catch (Exception e)  {
    		return null;
		}
    	
    	return pfuTextoCompleto;        
    }

    public String fuAnadirTextoFun(FuAnadirTextoRequest request) {
        return fuAnadirTextoFun(request.getPfuTexto(), request.getPfuAnadir());
    }

    /** 
     * Method that solves the fugetEstadoContrato user function.
     *
     * @param pfuCodigo This parameter represents the pfuCodigo inbound argument.
     *
     * @return Return EstadoContrato value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public EstadoContrato fugetEstadoContratoFun(java.lang.Long pfuCodigo) {
        FugetEstadoContratoRequest request = new FugetEstadoContratoRequest();
        request.setPfuCodigo(pfuCodigo);
        return userFunctionsProxy.fugetEstadoContratoFun(request);
    }

    public EstadoContrato fugetEstadoContratoFun(FugetEstadoContratoRequest request) {
        return fugetEstadoContratoFun(request.getPfuCodigo());
    }

    /** 
     * Method that solves the fugetDepartamentoCL user function.
     *
     * @param pfuCodigoLegal Código legal del departamento
     *
     * @return Return Departamento value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Departamento fugetDepartamentoCLFun(String pfuCodigoLegal) {

        // COMMENTS:
        // Devuelve el departamento a partir de su código legal
    	try {
	    	SQLPopulation query = new SQLPopulation(DepartamentoConstants.CLASS_NAME);
	
	        SQLWhereConjunction conjunction = new SQLWhereConjunction();
	
	        // EsResidencia = true
	        // '=' Comparison
	        SQLWhereComparison comparison = new SQLWhereComparison(query);
	        comparison.setOperator("=");
	        
	        SQLWhereOperandPathAttribute operand1= new SQLWhereOperandPathAttribute(DepartamentoConstants.ATTR_NAME_DEPARTAMENTOCODIGOLEGAL, Constants.Type.STRING.getTypeName());
	        comparison.setFirstOperand(operand1);
	        
	        comparison.setSecondOperand(new SQLWhereOperandLiteral(pfuCodigoLegal, Constants.Type.STRING.getTypeName()));
	        conjunction.addOperand(comparison);
	
	
	        query.addConjunction(conjunction);
	    	
			List<Departamento> lista = Arc.container().select(DepartamentoJpaRepository.class).get().solveQuery(query );
			if (lista != null && !lista.isEmpty()) {
				return lista.get(0);						
			}
    	} catch(Exception e) {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fugetDepartamentoCLFun: " + e.getMessage());
    	}
    	return null;
    }

    public Departamento fugetDepartamentoCLFun(FugetDepartamentoCLRequest request) {
        return fugetDepartamentoCLFun(request.getPfuCodigoLegal());
    }

    /** 
     * Method that solves the fugetSolicitudByNumero user function.
     *
     * @param pfuNumSolicitud This parameter represents the pfuNumSolicitud inbound argument.
     *
     * @return Return Solicitud value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Solicitud fugetSolicitudByNumeroFun(String pfuNumSolicitud) {
        if (pfuNumSolicitud == null || pfuNumSolicitud.isEmpty())
            return null;
        
        List<FilterVariableRequest> filterVariables = new ArrayList<>();
        filterVariables.add(new FilterVariableRequest(SolicitudConstants.VAR_NAME_IFSOLICITUDNUMSOLICITUD_VNUMSOLICITUD, pfuNumSolicitud));
        FilterRequest filterRequest = new FilterRequest(SolicitudConstants.FILTER_NAME_IFSOLICITUDNUMSOLICITUD, filterVariables);
        QueryRequest queryRequest = new QueryRequest(filterRequest);
        List<Solicitud> results = solicitudService.get(queryRequest);
        return results != null && !results.isEmpty() ? results.get(0) : null;
    	
    }

    public Solicitud fugetSolicitudByNumeroFun(FugetSolicitudByNumeroRequest request) {
        return fugetSolicitudByNumeroFun(request.getPfuNumSolicitud());
    }

    /** 
     * Method that solves the fugetAgente user function.
     *
     * @param pfuLogin This parameter represents the pfuLogin inbound argument.
     *
     * @return Return Funcionario value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Funcionario fugetAgenteFun(String pfuLogin) {
    	try {
	    	SQLPopulation query = new SQLPopulation(FuncionarioConstants.CLASS_NAME);
	
	        SQLWhereConjunction conjunction = new SQLWhereConjunction();
	
	        // EsResidencia = true
	        // '=' Comparison
	        SQLWhereComparison comparison = new SQLWhereComparison(query);
	        comparison.setOperator("=");
	        
	        // Usuario
	        SQLWhereOperandPathAttribute operand1= new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO , Constants.Type.STRING.getTypeName());
	        comparison.setFirstOperand(operand1);
	        
	        // pfuLogin
	        comparison.setSecondOperand(new SQLWhereOperandLiteral(pfuLogin, Constants.Type.STRING.getTypeName()));
	        conjunction.addOperand(comparison);
	
	
	        query.addConjunction(conjunction);
	    	
			List<Funcionario> lista = Arc.container().select(FuncionarioJpaRepository.class).get().solveQuery(query );
			if (lista != null && !lista.isEmpty()) {
				return lista.get(0);						
			}
    	} catch(Exception e) {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fugetAgenteFun: " + e.getMessage());
    	}    
    	return null;
    }

    public Funcionario fugetAgenteFun(FugetAgenteRequest request) {
        return fugetAgenteFun(request.getPfuLogin());
    }

    /** 
     * Method that solves the fuBuscarDocGestorNumId user function.
     *
     * @param pfuNumIdentificacion This parameter represents the pfuNumIdentificacion inbound argument.
     *
     * @param pfuNumSolicitud GdC37: Nº de solicitud en el marco de la cual se realiza la búsqueda. Para log.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuBuscarDocGestorNumIdFun(String pfuNumIdentificacion, String pfuNumSolicitud) {

        // COMMENTS:
        // Busca un documento del gestor documental, que no se ha subido desde AE.
        //         La forma de hacerlo será consumiendo la capacidad SearchDocumentP8
        //         Si se quieren consultar los documentos de tipo Identificación de persona, se invocará la capacidad de la siguiente manera:
        //         En documentClass se especificará DocumentoIdentidad
        //         En lParametersSearch se añadirá un solo parámetro:
        //         o Nombre del parámetro : NumeroDocumentoIdentidad
        //         o Valor :El número de identificación del usuario
        //         
        FuBuscarDocGestorNumIdRequest request = new FuBuscarDocGestorNumIdRequest();
        request.setPfuNumIdentificacion(pfuNumIdentificacion);
        request.setPfuNumSolicitud(pfuNumSolicitud);
        return userFunctionsProxy.fuBuscarDocGestorNumIdFun(request);
    }

    public String fuBuscarDocGestorNumIdFun(FuBuscarDocGestorNumIdRequest request) {
        return fuBuscarDocGestorNumIdFun(request.getPfuNumIdentificacion(), request.getPfuNumSolicitud());
    }

    /** 
     * Method that solves the fuBuscarDocGestorSolicitud user function.
     *
     * @param pfuNumSolicitud This parameter represents the pfuNumSolicitud inbound argument.
     *
     * @param pfuNumIdentidad This parameter represents the pfuNumIdentidad inbound argument.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuBuscarDocGestorSolicitudFun(String pfuNumSolicitud, String pfuNumIdentidad) {

        // COMMENTS:
        // Buscar un documento del gestor documental, que no se ha subido desde AE.
        //         La forma de hacerlo será consumiendo la capacidad SearchDocumentP8
        //         Si se quieren consular los documentos de tipo solicitud, se invocará la capacidad de la siguiente manera:
        //         En documentClass se especificará AfiliacionesMPSolicitudAfiliacion
        //         En lParametersSearch se añadirán dos parámetros:
        //         o Nombre del parámetro 1: NumeroSolicitud
        //         o Valor : El número de la solicitud
        //         o Nombre del parámetro 2: NumeroDocumentoIdentidad
        //         o Valor: El número de identificación del usuario
        //         
        FuBuscarDocGestorSolicitudRequest request = new FuBuscarDocGestorSolicitudRequest();
        request.setPfuNumSolicitud(pfuNumSolicitud);
        request.setPfuNumIdentidad(pfuNumIdentidad);
        return userFunctionsProxy.fuBuscarDocGestorSolicitudFun(request);
    }

    public String fuBuscarDocGestorSolicitudFun(FuBuscarDocGestorSolicitudRequest request) {
        return fuBuscarDocGestorSolicitudFun(request.getPfuNumSolicitud(), request.getPfuNumIdentidad());
    }

    /** 
     * Method that solves the fuSoloLetras user function.
     *
     * @param pfuNumero This parameter represents the pfuNumero inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Boolean fuSoloLetrasFun(String pfuNumero) {

        // COMMENTS:
        // El argumento debe contener sólo letras (sin caracteres especiales ni acentos).
        //         Si el argumento recibido es nulo (no lo ha proporcionado) devuelve TRUE, ya que esta función se usará en precondiciones.
    	
    	if (pfuNumero == null || pfuNumero.isEmpty()) {
    		return true;
    	}
    	
    	return regexpMatches(LETRAS_PATTERN, pfuNumero);
    }

    public java.lang.Boolean fuSoloLetrasFun(FuSoloLetrasRequest request) {
        return fuSoloLetrasFun(request.getPfuNumero());
    }

    /** 
     * Method that solves the fuGetTextoProteccionDatos user function.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuGetTextoProteccionDatosFun() {
        return userFunctionsProxy.fuGetTextoProteccionDatosFun();
    }

    /** 
     * Method that solves the fugetAsesor user function.
     *
     * @param pfuUsuario This parameter represents the pfuUsuario inbound argument.
     *
     * @return Return Asesor value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Asesor fugetAsesorFun(String pfuUsuario) {
        FugetAsesorRequest request = new FugetAsesorRequest();
        request.setPfuUsuario(pfuUsuario);
        return userFunctionsProxy.fugetAsesorFun(request);
    }

    public Asesor fugetAsesorFun(FugetAsesorRequest request) {
        return fugetAsesorFun(request.getPfuUsuario());
    }

    /** 
     * Method that solves the fugetMunicipioCL user function.
     *
     * @param pfCodLegal This parameter represents the pfCodLegal inbound argument.
     *
     * @return Return Municipio value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Municipio fugetMunicipioCLFun(String pfCodLegal) {

        // COMMENTS:
        // Devuelve el municipio a partir de su código legal
    	try {
	    	SQLPopulation query = new SQLPopulation(MunicipioConstants.CLASS_NAME);
	
	        SQLWhereConjunction conjunction = new SQLWhereConjunction();
	
	        // EsResidencia = true
	        // '=' Comparison
	        SQLWhereComparison comparison = new SQLWhereComparison(query);
	        comparison.setOperator("=");
	        
	        SQLWhereOperandPathAttribute operand1= new SQLWhereOperandPathAttribute(MunicipioConstants.ATTR_NAME_MUNICIPIOCODIGOLEGAL, Constants.Type.STRING.getTypeName());
	        comparison.setFirstOperand(operand1);
	        
	        comparison.setSecondOperand(new SQLWhereOperandLiteral(pfCodLegal, Constants.Type.STRING.getTypeName()));
	        conjunction.addOperand(comparison);
	
	
	        query.addConjunction(conjunction);
	    	
			List<Municipio> lista = Arc.container().select(MunicipioJpaRepository.class).get().solveQuery(query );
			if (lista != null && !lista.isEmpty()) {
				return lista.get(0);						
			}
    	} catch(Exception e) {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fugetMunicipioCLFun: " + e.getMessage());
    	}
    	return null;
    }

    public Municipio fugetMunicipioCLFun(FugetMunicipioCLRequest request) {
        return fugetMunicipioCLFun(request.getPfCodLegal());
    }

    /** 
     * Method that solves the fuGetDirResidenciaPersona user function.
     *
     * @param pfPersona This parameter represents the pfPersona inbound argument.
     *
     * @return Return Direccion value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Direccion fuGetDirResidenciaPersonaFun(Persona pfPersona) {
        FuGetDirResidenciaPersonaRequest request = new FuGetDirResidenciaPersonaRequest();
        request.setPfPersonaInstance(pfPersona);
        return userFunctionsProxy.fuGetDirResidenciaPersonaFun(request);
    }

    public Direccion fuGetDirResidenciaPersonaFun(FuGetDirResidenciaPersonaRequest request) {
        return fuGetDirResidenciaPersonaFun(request.getPfPersonaInstance());
    }

    /** 
     * Method that solves the fuGetTextoAvisoFirma user function.
     *
     * @param pfFirma Indica si es el texto para la primera (1) o la segunda (2) firma
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuGetTextoAvisoFirmaFun(java.lang.Long pfFirma) {

        // COMMENTS:
        // Obtiene el texto para mostrar en la primera firma de una solicitud
        FuGetTextoAvisoFirmaRequest request = new FuGetTextoAvisoFirmaRequest();
        request.setPfFirma(pfFirma);
        return userFunctionsProxy.fuGetTextoAvisoFirmaFun(request);
    }

    public String fuGetTextoAvisoFirmaFun(FuGetTextoAvisoFirmaRequest request) {
        return fuGetTextoAvisoFirmaFun(request.getPfFirma());
    }

    /** 
     * Method that solves the fugetListaErrores user function.
     *
     * @param pfSolicitud This parameter represents the pfSolicitud inbound argument.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fugetListaErroresFun(Solicitud pfSolicitud) {

        // COMMENTS:
        // Devuelve en un string los errores WS para una solicitud
        StringBuilder listaErrores = new StringBuilder();
        
        if (pfSolicitud != null && pfSolicitud.getErroresWS() != null && !pfSolicitud.getErroresWS().isEmpty()){
        	for (ErrorWS error : pfSolicitud.getErroresWS()){
        		listaErrores.append(" ");
        		listaErrores.append(error.getErrorWSDescripcion());
        	}
        }
        
        return listaErrores.toString();
    }

    public String fugetListaErroresFun(FugetListaErroresRequest request) {
        return fugetListaErroresFun(request.getPfSolicitudInstance());
    }

    /** 
     * Method that solves the fuGetCodTarifaProdPlanAnyo user function.
     *
     * @param pfProducto This parameter represents the pfProducto inbound argument.
     *
     * @param pfPlan This parameter represents the pfPlan inbound argument.
     *
     * @param pfAnyo This parameter represents the pfAnyo inbound argument.
     *
     * @param pfTipoContrato This parameter represents the pfTipoContrato inbound argument.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuGetCodTarifaProdPlanAnyoFun(Productos pfProducto, Planes pfPlan, java.lang.Long pfAnyo, java.lang.Long pfTipoContrato) {
    	try {
    		
    		for(Tarifa tarifa : pfPlan.getTarifas()) {
    			if (tarifa.getProductoT().equals(pfProducto) && tarifa.getTarifaTipoContrato().equals(pfTipoContrato)) {
    				for (DetalleTarifa detTarifa : tarifa.getDetallesTarifa()) {
    					if (detTarifa.getDetalleTarifaAnyo().equals(pfAnyo)) {
    						return tarifa.getTarifaCodigo();
    					}
    				}
    			}
    		}
    	} catch(Exception e) {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fuGetCodTarifaProdPlanAnyoFun: " + e.getMessage());
    	}
    	return null;    	
    }

    public String fuGetCodTarifaProdPlanAnyoFun(FuGetCodTarifaProdPlanAnyoRequest request) {
        return fuGetCodTarifaProdPlanAnyoFun(request.getPfProductoInstance(), request.getPfPlanInstance(), request.getPfAnyo(), request.getPfTipoContrato());
    }

    /** 
     * Method that solves the fugetProductoPorCL user function.
     *
     * @param pfCodLegalProd This parameter represents the pfCodLegalProd inbound argument.
     *
     * @return Return Productos value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Productos fugetProductoPorCLFun(String pfCodLegalProd) {

        // COMMENTS:
        // Devuelve el  producto a partir de su número
    	try {
	    	SQLPopulation query = new SQLPopulation(ProductosConstants.CLASS_NAME);
	
	        SQLWhereConjunction conjunction = new SQLWhereConjunction();
	
	        // EsResidencia = true
	        // '=' Comparison
	        SQLWhereComparison comparison = new SQLWhereComparison(query);
	        comparison.setOperator("=");
	        
	        // EsCorrespondencia
	        SQLWhereOperandPathAttribute operand1= new SQLWhereOperandPathAttribute(ProductosConstants.ATTR_NAME_PRODUCTOSCODIGOLEGAL, Constants.Type.STRING.getTypeName());
	        comparison.setFirstOperand(operand1);
	        
	        // True
	        comparison.setSecondOperand(new SQLWhereOperandLiteral(pfCodLegalProd, Constants.Type.STRING.getTypeName()));
	        conjunction.addOperand(comparison);
	
	
	        query.addConjunction(conjunction);
	    	
			List<Productos> lista = Arc.container().select(ProductosJpaRepository.class).get().solveQuery(query );
			if (lista != null && !lista.isEmpty()) {
				return lista.get(0);						
			}
    	} catch(Exception e) {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fugetProductoPorCLFun: " + e.getMessage());
    	}
    	return null;
    }

    public Productos fugetProductoPorCLFun(FugetProductoPorCLRequest request) {
        return fugetProductoPorCLFun(request.getPfCodLegalProd());
    }

    /** 
     * Method that solves the fugetPlanPorCL user function.
     *
     * @param pfCodLegalPlan This parameter represents the pfCodLegalPlan inbound argument.
     *
     * @return Return Planes value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Planes fugetPlanPorCLFun(String pfCodLegalPlan) {

        // COMMENTS:
        // Devuelve el  producto a partir de su número
        FugetPlanPorCLRequest request = new FugetPlanPorCLRequest();
        request.setPfCodLegalPlan(pfCodLegalPlan);
        return userFunctionsProxy.fugetPlanPorCLFun(request);
    }

    public Planes fugetPlanPorCLFun(FugetPlanPorCLRequest request) {
        return fugetPlanPorCLFun(request.getPfCodLegalPlan());
    }

    /** 
     * Method that solves the fugetFuncionarioPorLDAP user function.
     *
     * @param pfUsuLDAP This parameter represents the pfUsuLDAP inbound argument.
     *
     * @return Return Funcionario value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Funcionario fugetFuncionarioPorLDAPFun(String pfUsuLDAP) {
    	try {
	    	SQLPopulation query = new SQLPopulation(FuncionarioConstants.CLASS_NAME);
	
	        SQLWhereConjunction conjunction = new SQLWhereConjunction();
	
	        // EsResidencia = true
	        // '=' Comparison
	        SQLWhereComparison comparison = new SQLWhereComparison(query);
	        comparison.setOperator("=");
	        
	        SQLWhereOperandPathAttribute operand1= new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIOLDAP, Constants.Type.STRING.getTypeName());
	        comparison.setFirstOperand(operand1);
	        
	        comparison.setSecondOperand(new SQLWhereOperandLiteral(pfUsuLDAP, Constants.Type.STRING.getTypeName()));
	        conjunction.addOperand(comparison);
	
	
	        query.addConjunction(conjunction);
	    	
			List<Funcionario> lista = Arc.container().select(FuncionarioJpaRepository.class).get().solveQuery(query);
			if (lista != null && !lista.isEmpty()) {
				return lista.get(0);						
			}
    	} catch(Exception e) {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fugetFuncionarioPorLDAPFun: " + e.getMessage());
    	}
    	return null;
    }

    public Funcionario fugetFuncionarioPorLDAPFun(FugetFuncionarioPorLDAPRequest request) {
        return fugetFuncionarioPorLDAPFun(request.getPfUsuLDAP());
    }

    /** 
     * Method that solves the fuFormarTextoObservaciones user function.
     *
     * @param pfSolicitud This parameter represents the pfSolicitud inbound argument.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuFormarTextoObservacionesFun(Solicitud pfSolicitud) {

        // COMMENTS:
        // El texto a aÃ±adir se compone en funciÃ³n del valor de los datos mencinados. De tal manera que:
        //         GdC-14: Req. 60: Observaciones AutomÃ¡ticas
        //         Las observaciones deben ser:
        //         Usuario1: Traer la EPS que se diligencio / indicar fecha de antigÃ¼edad/ Parentesco
        //         
//    	Req. 16: ModificaciÃ³n del grupo asociado en inclusiones
//    	Esta modificaciÃ³n se debe ver reflejada en observaciones de la solicitud (se debe ver el nuevo cÃ³digo de grupo asociado). Esta modificaciÃ³n no se replicarÃ­a en bh, solo servirÃ­a para que afiliaciones sepa a quÃ© grupo asociado cambia el contrato. 
//    	Si no se modifica el grupo asociado en el reporte de solicitudes no debe aparecer en la observaciÃ³n el grupo asociado del contrato.
//    	El texto que deberÃ¡ aparecer en observaciones es: â€œNuevo grupo asociado xxxâ€


    	StringBuilder resultado = new StringBuilder();
    	
    	
    	if (pfSolicitud != null && !pfSolicitud.isNull()){
    		
    		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    		String stringTemp = "";
			try {
	    		// Grupo asociado
				if (pfSolicitud.getSolicitudTramite() == 1L){
					stringTemp = pfSolicitud.getSolicituddrvGrupoAsociado();
		    		if (stringTemp != null && !stringTemp.isEmpty()){
		    			resultado.append("Grupo asociado ");
		    			resultado.append(stringTemp);
		    		}
				}
	    		// Traslado
	    		if (pfSolicitud.getSolicitudEsTraslado()){
	    			if (resultado.length() > 0){
	    				resultado.append(", ");
	    			}
	    			resultado.append("Viene de traslado");
	    		}
	    		
	    		// Usuarios
				String textoUsuario = "";
	    		for(Usuario usu : pfSolicitud.getUsuarios()){
	    			
	    			// Usuario1: Traer la EPS que se diligencio / indicar fecha de antigÃ¼edad/ Parentesco

	    			textoUsuario = "Usuario " + usu.getUsuariodrvIdentificacion() + ":";
	    			if (usu.getEps() != null && !usu.getEps().isNull()) {
	    				textoUsuario += " EPS: " + usu.getEps().getEpsDescripcion(); 
	    			}
	    			if (usu.getUsuarioFechaAntiguedadBeneficiario() != null) {
	    				textoUsuario += " / F. Ant: " + dateFormat.format(usu.getUsuarioFechaAntiguedadBeneficiario()); 
	    			}
	    			if (usu.getParentesco() != null && !usu.getParentesco().isNull()) {
	    				textoUsuario += " / " + usu.getParentesco().getParentescoDescripcion(); 
	    			}
	    			
	    			if (resultado.length() > 0){
	    				resultado.append(", ");
	    			}
	    			
	    			resultado.append(textoUsuario);
	    		}

	    		
	    		// El texto que deberÃ¡ aparecer en observaciones es: â€œNuevo grupo asociado xxxâ€
//	    		GdC-14:Req. 16: ModificaciÃ³n del grupo asociado en inclusiones
//	    		Esta modificaciÃ³n se debe ver reflejada en observaciones de la solicitud (se debe ver el nuevo cÃ³digo de grupo asociado).
//	    		En este nos guardaremos el cÃ³digo del grupo original, el recuperado del CORE
//	    		Si toma valor NULL, significa que NO ha sido modificado el Grupo
//	    		Si toma valor -1, significa que NO tenÃ­a grupo asociado
//	    		Si toma cualquier otro valor, es el cÃ³digo del grupo original
	    		stringTemp = "";
	    		if (pfSolicitud.getSolicitudGrupoDelCORE() != null){
	    			if (pfSolicitud.getGrupoAsociado() != null && !pfSolicitud.getGrupoAsociado().isNull()) {
		    			if (!pfSolicitud.getGrupoAsociado().getGrupoAsociadoCodigo().equals(pfSolicitud.getSolicitudGrupoDelCORE()) ) {
		    				stringTemp = "Nuevo grupo asociado " + pfSolicitud.getGrupoAsociado().getGrupoAsociadoCodigoLegal();
		    			}
	    				
	    			} else {
	    				stringTemp = "Nuevo grupo asociado 'ninguno'";
	    			}
	    		}
	    		
	    		if (!stringTemp.isEmpty()){
	    			if (resultado.length() > 0){
	    				resultado.append("\n");
	    			}
    				resultado.append(stringTemp);
	    		}
	    		
	    		
	    		
	            // GdC-14: Req. 13: Prorrateo. Debe aparecer en Observaciones
	            if (pfSolicitud.getSolicitudPorcentajeProrrateo() != null && pfSolicitud.getSolicitudPorcentajeProrrateo() > 0) {
	    			if (resultado.length() > 0){
	    				resultado.append("\n");
	    			}
    				resultado.append("Prorrateo: " + pfSolicitud.getSolicitudPorcentajeProrrateo().toString() + "%");
	            }
	    		
			} catch (Exception e) {
        		org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error("fuFormarTextoObservacionesFun\n" + e.getMessage());
			}
    		
    	}
    	
    	
    	return resultado.toString();
    }

    public String fuFormarTextoObservacionesFun(FuFormarTextoObservacionesRequest request) {
        return fuFormarTextoObservacionesFun(request.getPfSolicitudInstance());
    }

    /** 
     * Method that solves the fuGetCodigoPersonaCORE user function.
     *
     * @param tipoId This parameter represents the tipoId inbound argument.
     *
     * @param numId This parameter represents the numId inbound argument.
     *
     * @param numSolicitud GdC 37: El número de solicitud en el marco de la cual se llama a esta fu. Para hacer log.
     *
     * @return Return java.lang.Long value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Long fuGetCodigoPersonaCOREFun(String tipoId, String numId, String numSolicitud) {
        FuGetCodigoPersonaCORERequest request = new FuGetCodigoPersonaCORERequest();
        request.setTipoId(tipoId);
        request.setNumId(numId);
        request.setNumSolicitud(numSolicitud);
        return userFunctionsProxy.fuGetCodigoPersonaCOREFun(request);
    }

    public java.lang.Long fuGetCodigoPersonaCOREFun(FuGetCodigoPersonaCORERequest request) {
        return fuGetCodigoPersonaCOREFun(request.getTipoId(), request.getNumId(), request.getNumSolicitud());
    }

    /** 
     * Method that solves the fuGetFechaFinVigenciaUsuario user function.
     *
     * @param pfTipoIdentificacion This parameter represents the pfTipoIdentificacion inbound argument.
     *
     * @param pfNumIdentificacion This parameter represents the pfNumIdentificacion inbound argument.
     *
     * @param pfNumSolicitud GcD-37 Log llamadas a BH con el Num solicitud
     *
     * @return Return java.sql.Date value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.sql.Date fuGetFechaFinVigenciaUsuarioFun(String pfTipoIdentificacion, String pfNumIdentificacion, String pfNumSolicitud) {

        // COMMENTS:
        // GdC10-12: Para obtener los contratos anteriores, invocaremos a la capacidad consultar beneficiario servicio de contratoMP, pasando como parámetros el tipo de identificación y número de identificación.
        //         Las fechas para la comparación son el tag fechaFinVigencia de la sección InformacionBeneficiarios (de la capacidad consultar beneficiario servicio de contratoMP) y nos quedaremos con la mayor de todos aquellos domicnios donde se indica que se debe rellenar el cuestionario médico. Devolvemos null si no tiene contratos anteriores o si para ninguno de ellos su dominio indica que se debe rellenar el cuestionario medico
        FuGetFechaFinVigenciaUsuarioRequest request = new FuGetFechaFinVigenciaUsuarioRequest();
        request.setPfTipoIdentificacion(pfTipoIdentificacion);
        request.setPfNumIdentificacion(pfNumIdentificacion);
        request.setPfNumSolicitud(pfNumSolicitud);
        return userFunctionsProxy.fuGetFechaFinVigenciaUsuarioFun(request);
    }

    public java.sql.Date fuGetFechaFinVigenciaUsuarioFun(FuGetFechaFinVigenciaUsuarioRequest request) {
        return fuGetFechaFinVigenciaUsuarioFun(request.getPfTipoIdentificacion(), request.getPfNumIdentificacion(), request.getPfNumSolicitud());
    }

    /** 
     * Method that solves the fuGetNombreAsesor user function.
     *
     * @param pfUsuario This parameter represents the pfUsuario inbound argument.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuGetNombreAsesorFun(String pfUsuario) {

        // COMMENTS:
        // Devuelve el nombre completo del asesor que tenga como usuario el recibido y no sea de agencia (no sea manual)
    	try {
	    	SQLPopulation query = new SQLPopulation(AsesorConstants.CLASS_NAME);
	
	        SQLWhereConjunction conjunction = new SQLWhereConjunction();
	
	        // '=' Comparison
	        SQLWhereComparison comparison = new SQLWhereComparison(query);
	        comparison.setOperator("=");
	        
	        SQLWhereOperandPathAttribute operand1= new SQLWhereOperandPathAttribute(AsesorConstants.ATTR_NAME_FUNCIONARIOUSUARIO , Constants.Type.STRING.getTypeName());
	        comparison.setFirstOperand(operand1);
	        
	        comparison.setSecondOperand(new SQLWhereOperandLiteral(pfUsuario, Constants.Type.STRING.getTypeName()));
	        conjunction.addOperand(comparison);
	
	        query.addConjunction(conjunction);
	    	
			List<Asesor> lista = Arc.container().select(AsesorJpaRepository.class).get().solveQuery(query);
			if (lista != null && !lista.isEmpty()) {
				return lista.get(0).getFuncionariodrvNombreCompleto();						
			}
    	} catch(Exception e) {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fuGetNombreAsesorFun: " + e.getMessage());
    	}
    	return null;
    }

    public String fuGetNombreAsesorFun(FuGetNombreAsesorRequest request) {
        return fuGetNombreAsesorFun(request.getPfUsuario());
    }

    /** 
     * Method that solves the fuGetNombreFuncionario user function.
     *
     * @param pfUsuario This parameter represents the pfUsuario inbound argument.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuGetNombreFuncionarioFun(String pfUsuario) {

        // COMMENTS:
        // Devuelve el nombre completo del funcionaio que tenga como usuario el recibido y no sea de agencia (no sea manual)
    	try {
	    	SQLPopulation query = new SQLPopulation(FuncionarioConstants.CLASS_NAME);
	
	        SQLWhereConjunction conjunction = new SQLWhereConjunction();
	
	        // '=' Comparison
	        SQLWhereComparison comparison = new SQLWhereComparison(query);
	        comparison.setOperator("=");
	        
	        SQLWhereOperandPathAttribute operand1= new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO , Constants.Type.STRING.getTypeName());
	        comparison.setFirstOperand(operand1);
	        
	        comparison.setSecondOperand(new SQLWhereOperandLiteral(pfUsuario, Constants.Type.STRING.getTypeName()));
	        conjunction.addOperand(comparison);
	
	        query.addConjunction(conjunction);
	    	
			List<Funcionario> lista = Arc.container().select(FuncionarioJpaRepository.class).get().solveQuery(query);
			if (lista != null && !lista.isEmpty()) {
				return lista.get(0).getFuncionariodrvNombreCompleto();						
			}
    	} catch(Exception e) {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fuGetNombreFuncionarioFun: " + e.getMessage());
    	}
    	return null;
    }

    public String fuGetNombreFuncionarioFun(FuGetNombreFuncionarioRequest request) {
        return fuGetNombreFuncionarioFun(request.getPfUsuario());
    }

    /** 
     * Method that solves the fuformarMsgErrorUsrSinDocs user function.
     *
     * @param pfSolicitud This parameter represents the pfSolicitud inbound argument.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuformarMsgErrorUsrSinDocsFun(Solicitud pfSolicitud) {

        // COMMENTS:
        // Dada una solicitud, devuelve las lista de usuarios a los que les falta alg´nu tip ode documentación
    	String textos = "";
    	
    	try {
			for(Usuario usu: pfSolicitud.getUsuarios()){
				usu.setServiceContext(serCtx);
				if (!usu.getUsuariodrvTieneDocumentos()){
					textos += "   " + usu.getUsuariodrvIdentificacion() + " le falta documento de identificación.";
				}
			}
		} catch (Exception e) {
			textos = "";
		}
    	
    	return textos;
    }

    public String fuformarMsgErrorUsrSinDocsFun(FuformarMsgErrorUsrSinDocsRequest request) {
        return fuformarMsgErrorUsrSinDocsFun(request.getPfSolicitudInstance());
    }

    /** 
     * Method that solves the fuEnviarEmailDevDoc user function.
     *
     * @param pfAsunto This parameter represents the pfAsunto inbound argument.
     *
     * @param pfCuerpo This parameter represents the pfCuerpo inbound argument.
     *
     * @param pfDestinatario This parameter represents the pfDestinatario inbound argument.
     *
     * @param pfEmailConf This parameter represents the pfEmailConf inbound argument.
     *
     * @param ptObservaciones This parameter represents the ptObservaciones inbound argument.
     *
     * @param pfNumSolicitud GdC 37, si el email se envía en el marco de una solicitud, el número de la misma
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuEnviarEmailDevDocFun(String pfAsunto, String pfCuerpo, String pfDestinatario, String pfEmailConf, String ptObservaciones, String pfNumSolicitud) {
        FuEnviarEmailDevDocRequest request = new FuEnviarEmailDevDocRequest();
        request.setPfAsunto(pfAsunto);
        request.setPfCuerpo(pfCuerpo);
        request.setPfDestinatario(pfDestinatario);
        request.setPfEmailConf(pfEmailConf);
        request.setPtObservaciones(ptObservaciones);
        request.setPfNumSolicitud(pfNumSolicitud);
        return userFunctionsProxy.fuEnviarEmailDevDocFun(request);
    }

    public String fuEnviarEmailDevDocFun(FuEnviarEmailDevDocRequest request) {
        return fuEnviarEmailDevDocFun(request.getPfAsunto(), request.getPfCuerpo(), request.getPfDestinatario(), request.getPfEmailConf(), request.getPtObservaciones(), request.getPfNumSolicitud());
    }

    /** 
     * Method that solves the fuContratoExentoDocSol user function.
     *
     * @param pfNumContrato This parameter represents the pfNumContrato inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Boolean fuContratoExentoDocSolFun(String pfNumContrato) {
    	
    	Boolean existe = false;
    	try{
    		if (pfNumContrato != null && !pfNumContrato.isEmpty()){

				String select = "select COUNT(*) " +
						" FROM " + ContSinDocSolConstants.CLASS_NAME +
						" WHERE " +
						ContSinDocSolConstants.FLD_CONTSINDOCSOLNUMCONTRATO +
						" = ?1";
				Query query = em.createNativeQuery(select);
				query.setParameter(1, pfNumContrato);

				Object resultado = query.getSingleResult();
		
				if (resultado != null && !"0".equalsIgnoreCase(resultado.toString())){
					existe = true;
				}    				
    		}
    	} catch (NoResultException e)  {
    		existe = false;
    	} catch (Exception e)  {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fuContratoExentoDocSolFun: " + e.getMessage());
    		existe = false;
    	}
    	return existe;    	
    }

    public java.lang.Boolean fuContratoExentoDocSolFun(FuContratoExentoDocSolRequest request) {
        return fuContratoExentoDocSolFun(request.getPfNumContrato());
    }

    /** 
     * Method that solves the fuEstadoSolicitud user function.
     *
     * @param pfEstadoSol This parameter represents the pfEstadoSol inbound argument.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuEstadoSolicitudFun(java.lang.Long pfEstadoSol) {

        // COMMENTS:
        // Devuelve el estado de la solicitud en texto
		// Devuelve el estado de la solicitud en texto
		// Please implement the body of your user function
		String estado = "desconocido";
		if (pfEstadoSol == 0L) {
			estado = "Error";
		}
		if (pfEstadoSol == 1L) {
			estado = "Radicado";
		}
		if (pfEstadoSol == 2L) {
			estado = "Tramitado";
		}
		if (pfEstadoSol == 3L) {
			estado = "Tramitado con preexistencias";
		}
		if (pfEstadoSol == 4L) {
			estado = "Anulado";
		}
		if (pfEstadoSol == 5L) {
			estado = "Pendiente médico";
		}
		if (pfEstadoSol == 6L) {
			estado = "Devuelta por área médica";
		}
		if (pfEstadoSol == 7L) {
			estado = "Aprobado médico";
		}

		return estado;
    }

    public String fuEstadoSolicitudFun(FuEstadoSolicitudRequest request) {
        return fuEstadoSolicitudFun(request.getPfEstadoSol());
    }

    /** 
     * Method that solves the fuGenerarReporteOracle user function.
     *
     * @param pfNombreReporte This parameter represents the pfNombreReporte inbound argument.
     *
     * @param pfUsuario This parameter represents the pfUsuario inbound argument.
     *
     * @param pfParametros This parameter represents the pfParametros inbound argument.
     *
     * @return Return byte[] value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public byte[] fuGenerarReporteOracleFun(String pfNombreReporte, String pfUsuario, String pfParametros) {
        FuGenerarReporteOracleRequest request = new FuGenerarReporteOracleRequest();
        request.setPfNombreReporte(pfNombreReporte);
        request.setPfUsuario(pfUsuario);
        request.setPfParametros(pfParametros);
        return userFunctionsProxy.fuGenerarReporteOracleFun(request);
    }

    public byte[] fuGenerarReporteOracleFun(FuGenerarReporteOracleRequest request) {
        return fuGenerarReporteOracleFun(request.getPfNombreReporte(), request.getPfUsuario(), request.getPfParametros());
    }

    /** 
     * Method that solves the fuCalcularIMC user function.
     *
     * @param pfPersonaC This parameter represents the pfPersonaC inbound argument.
     *
     * @return Return java.lang.Double value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Double fuCalcularIMCFun(PersonaC pfPersonaC) {
    	
    	// IMC = Peso (kg.) / Altura ^ 2 (metros) .
    	// Sacamos el peso y la altura de las respuestas del cuestionario médico
    	// Si no encontramos dichas preguntas, devovlemos un cero
    	
    	Double imc = 0.0;
    	
    	String codPreguntaPeso = fugetValorParametroConfFun("PREGUNTAPESO");
    	String codPreguntaTalla = fugetValorParametroConfFun("PREGUNTATALLA");
    	
    	if (codPreguntaTalla != null && codPreguntaPeso != null) {
    		String peso = null;
    		String talla = null;
    		try {
				for(PregCuesMedC pregunta : pfPersonaC.getPregsCuesMedC()) { 
					
					if (pregunta.getPregCuesMedCCodPregunta().toString().equalsIgnoreCase(codPreguntaPeso)) {
						peso = pregunta.getPregCuesMedCObservacions();
					}
					if (pregunta.getPregCuesMedCCodPregunta().toString().equalsIgnoreCase(codPreguntaTalla)) {
						talla = pregunta.getPregCuesMedCObservacions();
					}
					if (peso != null && talla != null) {
						double tallaDbl = Double.valueOf(talla) / 100;
						imc = Double.valueOf(peso) / (tallaDbl  * tallaDbl);
						break;
					}
				}
				
			} catch (Exception e) {
				imc = 0.0;
			}
    	}
    	
        return imc;    	
    }

    public java.lang.Double fuCalcularIMCFun(FuCalcularIMCRequest request) {
        return fuCalcularIMCFun(request.getPfPersonaCInstance());
    }

    /** 
     * Method that solves the fuGetEstadoPersonaError user function.
     *
     * @return Return EstadoBeneficiario value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public EstadoBeneficiario fuGetEstadoPersonaErrorFun() {
    	try {
			List<EstadoBeneficiario> lista = Arc.container().select(EstadoBeneficiarioJpaRepository.class).get().findAll();
			if (lista != null) {
				for(EstadoBeneficiario estado: lista) {
					if (estado.getEstadoBeneficiarioEsError()) {
						return estado;
					}
				}
			}
    	} catch(Exception e) {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fuGetEstadoPersonaErrorFun: " + e.getMessage());
    	}
    	return null;
    }

    /** 
     * Method that solves the fuCalcularIMCUsuario user function.
     *
     * @param pfUsuario This parameter represents the pfUsuario inbound argument.
     *
     * @return Return java.lang.Double value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Double fuCalcularIMCUsuarioFun(Usuario pfUsuario) {
    	// IMC = Peso (kg.) / Altura ^ 2 (metros).
    	// Sacamos el peso y la altura de las respuestas del cuestionario médico
    	// Si no encontramos dichas preguntas, devovlemos un cero
    	
    	Double imc = 0.0;
    	
    	String codPreguntaPeso = fugetValorParametroConfFun("PREGUNTAPESO");
    	String codPreguntaTalla = fugetValorParametroConfFun("PREGUNTATALLA");
    	
    	try {
			if (codPreguntaTalla != null && codPreguntaPeso != null && pfUsuario.getCuestionarioP() != null && !pfUsuario.getCuestionarioP().isNull()) {
				String peso = null;
				String talla = null;
				for(SeccionP seccion : pfUsuario.getCuestionarioP().getSecciones()) { 
					for(PreguntaP pregunta : seccion.getPreguntas()) {
					
						if (pregunta.getPreguntaPNumero().toString().equalsIgnoreCase(codPreguntaPeso)) {
							peso = pregunta.getPreguntaPdrvRespuesta();
						}
						if (pregunta.getPreguntaPNumero().toString().equalsIgnoreCase(codPreguntaTalla)) {
							talla = pregunta.getPreguntaPdrvRespuesta();
						}
					}
					if (peso != null && talla != null) {
						double tallaDbl = Double.valueOf(talla) / 100;
						imc = Double.valueOf(peso) / (tallaDbl  * tallaDbl);
						break;
					}
				}
				
			}
		} catch (NumberFormatException e) {
			imc = 0.0;
		} catch (Exception e) {
			imc = 0.0;
		}
    	
        return imc;    	
    }

    public java.lang.Double fuCalcularIMCUsuarioFun(FuCalcularIMCUsuarioRequest request) {
        return fuCalcularIMCUsuarioFun(request.getPfUsuarioInstance());
    }

    /** 
     * Method that solves the fuEnviarSMS user function.
     *
     * @param pfSolicitud This parameter represents the pfSolicitud inbound argument.
     *
     * @param pfNumCelulcar This parameter represents the pfNumCelulcar inbound argument.
     *
     * @param pfPlantilla This parameter represents the pfPlantilla inbound argument.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuEnviarSMSFun(Solicitud pfSolicitud, String pfNumCelulcar, PlantillaEmail pfPlantilla) {
        FuEnviarSMSRequest request = new FuEnviarSMSRequest();
        request.setPfSolicitudInstance(pfSolicitud);
        request.setPfNumCelulcar(pfNumCelulcar);
        request.setPfPlantillaInstance(pfPlantilla);
        return userFunctionsProxy.fuEnviarSMSFun(request);
    }

    public String fuEnviarSMSFun(FuEnviarSMSRequest request) {
        return fuEnviarSMSFun(request.getPfSolicitudInstance(), request.getPfNumCelulcar(), request.getPfPlantillaInstance());
    }

    /** 
     * Method that solves the fugetFuncionarioPorId user function.
     *
     * @param pfIdFuncionario This parameter represents the pfIdFuncionario inbound argument.
     *
     * @return Return Funcionario value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Funcionario fugetFuncionarioPorIdFun(java.lang.Long pfIdFuncionario) {
    	return funcionarioSrv.getById(pfIdFuncionario);
    }

    public Funcionario fugetFuncionarioPorIdFun(FugetFuncionarioPorIdRequest request) {
        return fugetFuncionarioPorIdFun(request.getPfIdFuncionario());
    }

    /** 
     * Method that solves the fuCallSPgetusugrabador user function.
     *
     * @param pfIdSolicitud This parameter represents the pfIdSolicitud inbound argument.
     *
     * @return Return java.lang.Long value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Long fuCallSPgetusugrabadorFun(java.lang.Long pfIdSolicitud) {
    	return llamarFuncionPktAsignaciones("getusugrabador", pfIdSolicitud).longValue();
    }

    public java.lang.Long fuCallSPgetusugrabadorFun(FuCallSPgetusugrabadorRequest request) {
        return fuCallSPgetusugrabadorFun(request.getPfIdSolicitud());
    }

    /** 
     * Method that solves the fuCallSPgetusugrabadornov user function.
     *
     * @param pfIdSolcitudNov This parameter represents the pfIdSolcitudNov inbound argument.
     *
     * @return Return java.lang.Long value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Long fuCallSPgetusugrabadornovFun(java.lang.Long pfIdSolcitudNov) {
        return llamarFuncionPktAsignaciones("getusugrabadornov", pfIdSolcitudNov).longValue();
    }

    public java.lang.Long fuCallSPgetusugrabadornovFun(FuCallSPgetusugrabadornovRequest request) {
        return fuCallSPgetusugrabadornovFun(request.getPfIdSolcitudNov());
    }

    /** 
     * Method that solves the fuCallSPgetusuareamed user function.
     *
     * @param pfIdSolicitud This parameter represents the pfIdSolicitud inbound argument.
     *
     * @return Return java.lang.Long value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Long fuCallSPgetusuareamedFun(java.lang.Long pfIdSolicitud) {
    	
    	return llamarFuncionPktAsignaciones("getusuareamed", pfIdSolicitud).longValue();

    }

    public java.lang.Long fuCallSPgetusuareamedFun(FuCallSPgetusuareamedRequest request) {
        return fuCallSPgetusuareamedFun(request.getPfIdSolicitud());
    }

    /** 
     * Method that solves the fugetAreaMedicaPorId user function.
     *
     * @param pfIdAreaMedica This parameter represents the pfIdAreaMedica inbound argument.
     *
     * @return Return AreaMedica value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public AreaMedica fugetAreaMedicaPorIdFun(java.lang.Long pfIdAreaMedica) {
    	if (pfIdAreaMedica != null) {
    		return this.areaMedicaSrv.getById(pfIdAreaMedica);
    	}
        return null;
    }

    public AreaMedica fugetAreaMedicaPorIdFun(FugetAreaMedicaPorIdRequest request) {
        return fugetAreaMedicaPorIdFun(request.getPfIdAreaMedica());
    }

    /** 
     * Method that solves the fugetPrioridad user function.
     *
     * @param pfEstadoSol This parameter represents the pfEstadoSol inbound argument.
     *
     * @param pfEstadoDoc This parameter represents the pfEstadoDoc inbound argument.
     *
     * @return Return java.lang.Long value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Long fugetPrioridadFun(java.lang.Long pfEstadoSol, java.lang.Long pfEstadoDoc) {

    	// COMMENTS:
    	// Devuelve la prioridad para una solicitud en función del estado y del estado de la documentación, recibidos ambos como argumentos en la funcion.
    	//         Deb buscar en la tabla 'PriorizacionSolicitud" el par recibido. Si no se encuentra debe devolver 0 (cero) para que el que la invoca proceda en consecuencia
    	Long prioridad = 0L;
    	try{
    		String select = "select " + PriorizacionSolicitudesConstants.FLD_PRIORIZACIONSOLICITUDESPRIORIDAD +
    				" FROM " + PriorizacionSolicitudesConstants.CLASS_NAME +
    				" WHERE " +
    				PriorizacionSolicitudesConstants.FLD_PRIORIZACIONSOLICITUDESESTADODOC  + " = ?1 AND " +
    				PriorizacionSolicitudesConstants.FLD_PRIORIZACIONSOLICITUDESESTADOSOLICITUD + " = ?2";
    		Query query = em.createNativeQuery(select);
    		query.setParameter(1, pfEstadoDoc);
    		query.setParameter(2, pfEstadoSol);

    		Object resultado = query.getSingleResult();

    		if (resultado != null){
    			prioridad = Long.parseLong(resultado.toString());
    		}    				
    	} catch (NoResultException e)  {
    		prioridad = 0L;
    	} catch (Exception e)  {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fugetPrioridadFun: " + e.getMessage());
    		prioridad = 0L;
    	}
    	return prioridad;    	        
    }

    public java.lang.Long fugetPrioridadFun(FugetPrioridadRequest request) {
        return fugetPrioridadFun(request.getPfEstadoSol(), request.getPfEstadoDoc());
    }

    /** 
     * Method that solves the fuCallSPgetsemaforograbador user function.
     *
     * @param pfIdSolicitud This parameter represents the pfIdSolicitud inbound argument.
     *
     * @return Return java.lang.Double value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Double fuCallSPgetsemaforograbadorFun(java.lang.Long pfIdSolicitud) {

    	return llamarFuncionPktAsignaciones("getsemaforograbador", pfIdSolicitud);
    }

    public java.lang.Double fuCallSPgetsemaforograbadorFun(FuCallSPgetsemaforograbadorRequest request) {
        return fuCallSPgetsemaforograbadorFun(request.getPfIdSolicitud());
    }

    /** 
     * Method that solves the fuCallSPgetsemaforograbadornov user function.
     *
     * @param pfIdSolcitudNov This parameter represents the pfIdSolcitudNov inbound argument.
     *
     * @return Return java.lang.Double value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Double fuCallSPgetsemaforograbadornovFun(java.lang.Long pfIdSolcitudNov) {

    	return llamarFuncionPktAsignaciones("getsemaforograbadornov", pfIdSolcitudNov);
    }

    public java.lang.Double fuCallSPgetsemaforograbadornovFun(FuCallSPgetsemaforograbadornovRequest request) {
        return fuCallSPgetsemaforograbadornovFun(request.getPfIdSolcitudNov());
    }

    /** 
     * Method that solves the fuCallSPgetsemaforoareamed user function.
     *
     * @param pfIdSolicitud This parameter represents the pfIdSolicitud inbound argument.
     *
     * @return Return java.lang.Double value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Double fuCallSPgetsemaforoareamedFun(java.lang.Long pfIdSolicitud) {

    	return llamarFuncionPktAsignaciones("getsemaforoareamed", pfIdSolicitud);
    }

    public java.lang.Double fuCallSPgetsemaforoareamedFun(FuCallSPgetsemaforoareamedRequest request) {
        return fuCallSPgetsemaforoareamedFun(request.getPfIdSolicitud());
    }

    /** 
     * Method that solves the fugetSolicitudNovedadByNumRadicado user function.
     *
     * @param pfNumRadicado This parameter represents the pfNumRadicado inbound argument.
     *
     * @return Return SolicitudNovedad value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public SolicitudNovedad fugetSolicitudNovedadByNumRadicadoFun(String pfNumRadicado) {
        if (pfNumRadicado == null || pfNumRadicado.isEmpty())
            return null;
        
        List<FilterVariableRequest> filterVariables = new ArrayList<>();
        filterVariables.add(new FilterVariableRequest(SolicitudNovedadConstants.VAR_NAME_IFILTROPORNUMRADICADO_VFNUMRADICADO, pfNumRadicado));
        FilterRequest filterRequest = new FilterRequest(SolicitudNovedadConstants.FILTER_NAME_IFILTROPORNUMRADICADO, filterVariables);
        QueryRequest queryRequest = new QueryRequest(filterRequest);
        List<SolicitudNovedad> results = solicitudNovedadService.get(queryRequest);
        return results != null && !results.isEmpty() ? results.get(0) : null;
    }

    public SolicitudNovedad fugetSolicitudNovedadByNumRadicadoFun(FugetSolicitudNovedadByNumRadicadoRequest request) {
        return fugetSolicitudNovedadByNumRadicadoFun(request.getPfNumRadicado());
    }

    /** 
     * Method that solves the fuGetFechaDesdeVarFiltro user function.
     *
     * @return Return java.sql.Date value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.sql.Date fuGetFechaDesdeVarFiltroFun() {
        return userFunctionsProxy.fuGetFechaDesdeVarFiltroFun();
    }

    /** 
     * Method that solves the fuCheckRegimenSubsidiado user function.
     *
     * @param pfTipoId This parameter represents the pfTipoId inbound argument.
     *
     * @param pfNumId This parameter represents the pfNumId inbound argument.
     *
     * @param pfSolicitud This parameter represents the pfSolicitud inbound argument.
     *
     * @param pfEsVoluntario This parameter represents the pfEsVoluntario inbound argument.
     *
     * @return Return java.lang.Long value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Long fuCheckRegimenSubsidiadoFun(String pfTipoId, String pfNumId, String pfSolicitud, java.lang.Boolean pfEsVoluntario) {

        // COMMENTS:
        // Realiza las comprobacione del Requisito 1 de la GdC-39. Devuevle: 0 = Puede añadirse el usuario. 1 = No puede porque no corresponde a regimen subsidiado. 2 = No puede porque no se encuentra activo en un contrato de régimen contributivo
        FuCheckRegimenSubsidiadoRequest request = new FuCheckRegimenSubsidiadoRequest();
        request.setPfTipoId(pfTipoId);
        request.setPfNumId(pfNumId);
        request.setPfSolicitud(pfSolicitud);
        request.setPfEsVoluntario(pfEsVoluntario);
        return userFunctionsProxy.fuCheckRegimenSubsidiadoFun(request);
    }

    public java.lang.Long fuCheckRegimenSubsidiadoFun(FuCheckRegimenSubsidiadoRequest request) {
        return fuCheckRegimenSubsidiadoFun(request.getPfTipoId(), request.getPfNumId(), request.getPfSolicitud(), request.getPfEsVoluntario());
    }

    /** 
     * Method that solves the fuGetFInicioPlanVol user function.
     *
     * @param pfTipoTramite This parameter represents the pfTipoTramite inbound argument.
     *
     * @param pfTipoContrato This parameter represents the pfTipoContrato inbound argument.
     *
     * @param pfFecha This parameter represents the pfFecha inbound argument.
     *
     * @return Return java.sql.Date value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.sql.Date fuGetFInicioPlanVolFun(java.lang.Long pfTipoTramite, java.lang.Long pfTipoContrato, java.sql.Date pfFecha) {

        // COMMENTS:
        // GdC-39 Requisito 2: Localiza la fecha de inicio en la nueva paramétrica para el tipo de tramite, tipo de contrato y a la fecha recibida
    	java.sql.Date fecha = null;
    	try{

    		// Tramite =  vfTramite AND TipoContrato =  vfTipoContrato AND Desde <=  vfFecha AND Hasta >=  vfFecha 
				String select = "select " + FechaIniEPSConstants.FLD_FECHAINIEPSFECHAINICIOAPLICAR +
						" FROM " + FechaIniEPSConstants.CLASS_NAME +
						" WHERE " +
						FechaIniEPSConstants.FLD_FECHAINIEPSTRAMITE + " = ?1 AND " +
						FechaIniEPSConstants.FLD_FECHAINIEPSTIPOCONTRATO + " = ?2 AND " +
						FechaIniEPSConstants.FLD_FECHAINIEPSDESDE + " <= ?3 AND " +
						FechaIniEPSConstants.FLD_FECHAINIEPSHASTA + " >= ?4 ";
				Query query = em.createNativeQuery(select);
				query.setParameter(1, pfTipoTramite);
				query.setParameter(2, pfTipoContrato);
				query.setParameter(3, pfFecha);
				query.setParameter(4, pfFecha);

				Object resultado = query.getSingleResult();
		
				if (resultado != null){
					fecha = new Date(((Timestamp) resultado).getTime());
				}    				
    	} catch (NoResultException e)  {
    		fecha = null;
    	} catch (Exception e)  {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fuGetFInicioPlanVolFun: " + e.getMessage());
    	}
    	return fecha;    	    	

    }

    public java.sql.Date fuGetFInicioPlanVolFun(FuGetFInicioPlanVolRequest request) {
        return fuGetFInicioPlanVolFun(request.getPfTipoTramite(), request.getPfTipoContrato(), request.getPfFecha());
    }

    /** 
     * Method that solves the fuValidarDominioIncompatibles user function.
     *
     * @param pfTipoId This parameter represents the pfTipoId inbound argument.
     *
     * @param pfNumId This parameter represents the pfNumId inbound argument.
     *
     * @param pfFechaInicioVigencia This parameter represents the pfFechaInicioVigencia inbound argument.
     *
     * @param pfSolicitud This parameter represents the pfSolicitud inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Boolean fuValidarDominioIncompatiblesFun(String pfTipoId, String pfNumId, java.sql.Date pfFechaInicioVigencia, Solicitud pfSolicitud) {
        FuValidarDominioIncompatiblesRequest request = new FuValidarDominioIncompatiblesRequest();
        request.setPfTipoId(pfTipoId);
        request.setPfNumId(pfNumId);
        request.setPfFechaInicioVigencia(pfFechaInicioVigencia);
        request.setPfSolicitudInstance(pfSolicitud);
        return userFunctionsProxy.fuValidarDominioIncompatiblesFun(request);
    }

    public java.lang.Boolean fuValidarDominioIncompatiblesFun(FuValidarDominioIncompatiblesRequest request) {
        return fuValidarDominioIncompatiblesFun(request.getPfTipoId(), request.getPfNumId(), request.getPfFechaInicioVigencia(), request.getPfSolicitudInstance());
    }

    /** 
     * Method that solves the fuExisteContratoExentoFIngreso user function.
     *
     * @param vfNumContrato This parameter represents the vfNumContrato inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.lang.Boolean fuExisteContratoExentoFIngresoFun(String vfNumContrato) {
    	Boolean existe = false;
    	try{
    		if (vfNumContrato != null && !vfNumContrato.isEmpty()){

				String select = "select COUNT(*) " +
						" FROM " + ContratosExentosFIngresoConstants.CLASS_NAME +
						" WHERE " +
						ContratosExentosFIngresoConstants.FLD_CONTRATOSEXENTOSFINGRESONUMCONTRATO +
						" = ?1";
				Query query = em.createNativeQuery(select);
				query.setParameter(1, vfNumContrato);

				Object resultado = query.getSingleResult();
		
				if (resultado != null && !"0".equalsIgnoreCase(resultado.toString())){
					existe = true;
				}    				
    		}
    	} catch (NoResultException e)  {
    		existe = false;
    	} catch (Exception e)  {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fuExisteContratoExentoFIngresoFun: " + e.getMessage());
    		existe = false;
    	}
    	return existe;    	    	
    }

    public java.lang.Boolean fuExisteContratoExentoFIngresoFun(FuExisteContratoExentoFIngresoRequest request) {
        return fuExisteContratoExentoFIngresoFun(request.getVfNumContrato());
    }

    /** 
     * Method that solves the fuGetFechaLimiteDescargaDoc user function.
     *
     * @return Return java.sql.Date value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public java.sql.Date fuGetFechaLimiteDescargaDocFun() {

        // COMMENTS:
        // GdC-47 v.1 Req 6. "Parametrización fecha de descarga de documentos"
    	java.sql.Date fecha = null;
    	String fechaTexto = fugetValorParametroConfFun( "FECHADESCARGADOCUMENTOS");
    	
        try {
        	fecha = new java.sql.Date( new SimpleDateFormat("yyyy-MM-dd").parse(fechaTexto).getTime());
        } catch(Exception e) {
        	fecha = null;
        }
    	return fecha;
    }

    /** 
     * Method that solves the fuGetTkn user function.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuGetTknFun() {

        // COMMENTS:
        // Devuelve un Token para el gestor documental ATOMIC
        return userFunctionsProxy.fuGetTknFun();
    }

    /** 
     * Method that solves the fuGetReporteSolicitud user function.
     *
     * @param pfSolicitud This parameter represents the pfSolicitud inbound argument.
     *
     * @param pfRuta This parameter represents the pfRuta inbound argument.
     *
     * @return Return byte[] value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public byte[] fuGetReporteSolicitudFun(Solicitud pfSolicitud, String pfRuta) {

        // COMMENTS:
        // Genera el reporte de la ruta indicada para la solciitud recibida
        FuGetReporteSolicitudRequest request = new FuGetReporteSolicitudRequest();
        request.setPfSolicitudInstance(pfSolicitud);
        request.setPfRuta(pfRuta);
        return userFunctionsProxy.fuGetReporteSolicitudFun(request);
    }

    public byte[] fuGetReporteSolicitudFun(FuGetReporteSolicitudRequest request) {
        return fuGetReporteSolicitudFun(request.getPfSolicitudInstance(), request.getPfRuta());
    }

    /** 
     * Method that solves the fugetEstadoBeneficiarioCOREPorNombre user function.
     *
     * @param pfNombre This parameter represents the pfNombre inbound argument.
     *
     * @return Return EstadoBeneficiario value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public EstadoBeneficiario fugetEstadoBeneficiarioCOREPorNombreFun(String pfNombre) {
    	try {
	    	SQLPopulation query = new SQLPopulation(EstadoBeneficiarioConstants.CLASS_NAME);
	
	        SQLWhereConjunction conjunction = new SQLWhereConjunction();
	
	        // EsResidencia = true
	        // '=' Comparison
	        SQLWhereComparison comparison = new SQLWhereComparison(query);
	        comparison.setOperator("=");
	        
	        SQLWhereOperandPathAttribute operand1= new SQLWhereOperandPathAttribute(EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIODESCRIPCION, Constants.Type.STRING.getTypeName());
	        comparison.setFirstOperand(operand1);
	        
	        comparison.setSecondOperand(new SQLWhereOperandLiteral(pfNombre, Constants.Type.STRING.getTypeName()));
	        conjunction.addOperand(comparison);
	
	
	        query.addConjunction(conjunction);
	    	
			List<EstadoBeneficiario> lista = Arc.container().select(EstadoBeneficiarioJpaRepository.class).get().solveQuery(query );
			if (lista != null && !lista.isEmpty()) {
				return lista.get(0);						
			}
    	} catch(Exception e) {
    		LoggerFactory.getLogger(this.getClass()).error("Error en fugetEstadoBeneficiarioCOREPorNombreFun: " + e.getMessage());
    	}
    	return null;    	
    }

    public EstadoBeneficiario fugetEstadoBeneficiarioCOREPorNombreFun(FugetEstadoBeneficiarioCOREPorNombreRequest request) {
        return fugetEstadoBeneficiarioCOREPorNombreFun(request.getPfNombre());
    }

    /** 
     * Method that solves the fugetEstadoContratoPorNombre user function.
     *
     * @param pfNombre This parameter represents the pfNombre inbound argument.
     *
     * @return Return EstadoContrato value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public EstadoContrato fugetEstadoContratoPorNombreFun(String pfNombre) {
        FugetEstadoContratoPorNombreRequest request = new FugetEstadoContratoPorNombreRequest();
        request.setPfNombre(pfNombre);
        return userFunctionsProxy.fugetEstadoContratoPorNombreFun(request);
    }

    public EstadoContrato fugetEstadoContratoPorNombreFun(FugetEstadoContratoPorNombreRequest request) {
        return fugetEstadoContratoPorNombreFun(request.getPfNombre());
    }

    /** 
     * Method that solves the fuGetIdDocIdentidadEnGestor user function.
     *
     * @param pfNumIdentificacion This parameter represents the pfNumIdentificacion inbound argument.
     *
     * @param pfNumRadicado This parameter represents the pfNumRadicado inbound argument.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuGetIdDocIdentidadEnGestorFun(String pfNumIdentificacion, String pfNumRadicado) {

        // COMMENTS:
        // Busca en el gestor documental el documento de identidad de la persona con la identificación recibida. Devuelve el Id del documento y la extensión
        FuGetIdDocIdentidadEnGestorRequest request = new FuGetIdDocIdentidadEnGestorRequest();
        request.setPfNumIdentificacion(pfNumIdentificacion);
        request.setPfNumRadicado(pfNumRadicado);
        return userFunctionsProxy.fuGetIdDocIdentidadEnGestorFun(request);
    }

    public String fuGetIdDocIdentidadEnGestorFun(FuGetIdDocIdentidadEnGestorRequest request) {
        return fuGetIdDocIdentidadEnGestorFun(request.getPfNumIdentificacion(), request.getPfNumRadicado());
    }

    /** 
     * Method that solves the fuGetIURLDescargaATOMIC user function.
     *
     * @return Return String value of the User Function
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String fuGetIURLDescargaATOMICFun() {

        // COMMENTS:
        // Devuelve la URL de descarga del gestor documental ATOMIC
        return userFunctionsProxy.fuGetIURLDescargaATOMICFun();
    }
}
