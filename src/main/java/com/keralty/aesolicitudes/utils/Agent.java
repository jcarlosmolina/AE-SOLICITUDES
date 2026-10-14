package com.keralty.aesolicitudes.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import org.eclipse.microprofile.jwt.JsonWebToken;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.persistence.AbstractAppEntity;
import com.keralty.aesolicitudes.persistence.Funcionario;
import com.keralty.aesolicitudes.persistence.Admin;
import com.keralty.aesolicitudes.persistence.SuperAdmin;
import com.keralty.aesolicitudes.persistence.Asesor;
import com.keralty.aesolicitudes.persistence.AreaMedica;
import com.keralty.aesolicitudes.persistence.Afiliaciones;
import com.keralty.aesolicitudes.persistence.RespRegional;
import com.keralty.aesolicitudes.persistence.Gestor;
import com.keralty.aesolicitudes.persistence.MesaDeApoyo;
import com.keralty.aesolicitudes.persistence.UsuarioSistemaExterno;
import com.keralty.aesolicitudes.persistence.IEntity;
import com.keralty.aesolicitudes.persistence.oid.IOid;
import com.keralty.aesolicitudes.persistence.oid.FuncionarioOid;
import com.keralty.aesolicitudes.persistence.oid.AdminOid;
import com.keralty.aesolicitudes.persistence.oid.SuperAdminOid;
import com.keralty.aesolicitudes.persistence.oid.AsesorOid;
import com.keralty.aesolicitudes.persistence.oid.AreaMedicaOid;
import com.keralty.aesolicitudes.persistence.oid.AfiliacionesOid;
import com.keralty.aesolicitudes.persistence.oid.RespRegionalOid;
import com.keralty.aesolicitudes.persistence.oid.GestorOid;
import com.keralty.aesolicitudes.persistence.oid.MesaDeApoyoOid;
import com.keralty.aesolicitudes.persistence.oid.UsuarioSistemaExternoOid;
import com.keralty.aesolicitudes.security.User;
import com.keralty.aesolicitudes.security.UserCrudService;
import com.keralty.aesolicitudes.service.FuncionarioService;
import com.keralty.aesolicitudes.service.AdminService;
import com.keralty.aesolicitudes.service.SuperAdminService;
import com.keralty.aesolicitudes.service.AsesorService;
import com.keralty.aesolicitudes.service.AreaMedicaService;
import com.keralty.aesolicitudes.service.AfiliacionesService;
import com.keralty.aesolicitudes.service.RespRegionalService;
import com.keralty.aesolicitudes.service.GestorService;
import com.keralty.aesolicitudes.service.MesaDeApoyoService;
import com.keralty.aesolicitudes.service.UsuarioSistemaExternoService;

/**
 * Holds the information of the connected agent.
 */
@RequestScoped
public class Agent implements UserCrudService {

    private String className;

    private IOid agentOid;

    private List<String> activeFacets = new ArrayList<>();


    FuncionarioService funcionarioService;

    AdminService adminService;

    SuperAdminService superAdminService;

    AsesorService asesorService;

    AreaMedicaService areaMedicaService;

    AfiliacionesService afiliacionesService;

    RespRegionalService respRegionalService;

    GestorService gestorService;

    MesaDeApoyoService mesaDeApoyoService;

    UsuarioSistemaExternoService usuarioSistemaExternoService;

    JsonWebToken jwt;

    @Inject
    public Agent(
            FuncionarioService funcionarioService,
            AdminService adminService,
            SuperAdminService superAdminService,
            AsesorService asesorService,
            AreaMedicaService areaMedicaService,
            AfiliacionesService afiliacionesService,
            RespRegionalService respRegionalService,
            GestorService gestorService,
            MesaDeApoyoService mesaDeApoyoService,
            UsuarioSistemaExternoService usuarioSistemaExternoService,
            JsonWebToken jwt){
        this.funcionarioService = funcionarioService;
        this.adminService = adminService;
        this.superAdminService = superAdminService;
        this.asesorService = asesorService;
        this.areaMedicaService = areaMedicaService;
        this.afiliacionesService = afiliacionesService;
        this.respRegionalService = respRegionalService;
        this.gestorService = gestorService;
        this.mesaDeApoyoService = mesaDeApoyoService;
        this.usuarioSistemaExternoService = usuarioSistemaExternoService;
        this.jwt = jwt;
    }

    public List<String> getAgentRoles() {
        return (jwt != null && jwt.getGroups() != null) ? new ArrayList<>(jwt.getGroups()) : new ArrayList<>();
    }

    /**
     * Returns the identifier of the connected agent.
     * 
     * @return the agent identifier.
     */
    public IOid getAgentOid() {
        if (agentOid == null)
        {
            IEntity agentInstance = getAgentInstance();
            agentOid = agentInstance != null ? agentInstance.getOid() : null;
        }
        return agentOid;
    }

    /**
     * Returns the instance of the connected agent.
     * 
     * @return Agent Entity
     */
    public IEntity getAgentInstance() {
    	setClassName(getAgentRoles().get(0));
        IEntity lAgent = null;
        if (Constants.FUNCIONARIO.equalsIgnoreCase(className)) {
            lAgent = funcionarioService.getByOID(new FuncionarioOid(Long.valueOf(getAgentName())));
        }
        if (Constants.ADMIN.equalsIgnoreCase(className)) {
            lAgent = adminService.getByOID(new AdminOid(Long.valueOf(getAgentName())));
        }
        if (Constants.SUPERADMIN.equalsIgnoreCase(className)) {
            lAgent = superAdminService.getByOID(new SuperAdminOid(Long.valueOf(getAgentName())));
        }
        if (Constants.ASESOR.equalsIgnoreCase(className)) {
            lAgent = asesorService.getByOID(new AsesorOid(Long.valueOf(getAgentName())));
        }
        if (Constants.AREAMEDICA.equalsIgnoreCase(className)) {
            lAgent = areaMedicaService.getByOID(new AreaMedicaOid(Long.valueOf(getAgentName())));
        }
        if (Constants.AFILIACIONES.equalsIgnoreCase(className)) {
            lAgent = afiliacionesService.getByOID(new AfiliacionesOid(Long.valueOf(getAgentName())));
        }
        if (Constants.RESPREGIONAL.equalsIgnoreCase(className)) {
            lAgent = respRegionalService.getByOID(new RespRegionalOid(Long.valueOf(getAgentName())));
        }
        if (Constants.GESTOR.equalsIgnoreCase(className)) {
            lAgent = gestorService.getByOID(new GestorOid(Long.valueOf(getAgentName())));
        }
        if (Constants.MESADEAPOYO.equalsIgnoreCase(className)) {
            lAgent = mesaDeApoyoService.getByOID(new MesaDeApoyoOid(Long.valueOf(getAgentName())));
        }
        if (Constants.USUARIOSISTEMAEXTERNO.equalsIgnoreCase(className)) {
            lAgent = usuarioSistemaExternoService.getByOID(new UsuarioSistemaExternoOid(getAgentName()));
        }
        return lAgent;
    }

    public String getAgentName() {
        return jwt != null ? jwt.getName() : "";
    }
    
    /**
     * Returns the a given active facet of the instance of the connected agent.
     * 
     * @param facetName name of the active facet to return.
     * @return given active facet of the instance of the connected agent.
     */
    public IEntity getAgentInstance(String facetName) {
        IEntity currentAgentInstance = null;
        try {
            currentAgentInstance = getAgentInstance();
            if (currentAgentInstance == null) {
                Class<?> classFacet = Class
                        .forName("com.keralty.aesolicitudes.persistence." + facetName);
                Constructor<?> agentConstructor = classFacet.getConstructor();
                currentAgentInstance = (IEntity) agentConstructor.newInstance();
            } else {
                if (!className.equalsIgnoreCase(facetName)) {
                    currentAgentInstance = executeGetFacetMethod(currentAgentInstance,
                            currentAgentInstance.getMethod(facetName + "facet"));
                }
            }
        } catch (Exception e) {
            currentAgentInstance = null;
        }
        return currentAgentInstance;
    }

    private IEntity executeGetFacetMethod(IEntity entity, Method getFacetMethod) {
        IEntity facet;
        try {
            facet = (getFacetMethod != null ? (IEntity) getFacetMethod.invoke(entity) : null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            facet = null;
        }
        return facet;
    }

    /**
     * Sets the identifier of the connected agent.
     * 
     * @param agentOID the agent identifier.
     */
    public void setAgentOID(IOid agentOid) {
        this.agentOid = agentOid;
    }

    /**
     * Returns the name of the connected agent model class. The model class name is
     * used to perform several visibility checks.
     * 
     * @return the agent class name.
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the model class name of the connected agent.
     * 
     * @param className the agent class name.
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Says if the connected agent is an instance of the model class
     * <code>agentClass</code>.
     *
     * @param agentClass the name of the model class to check against the connected
     *                   agent.
     * @return TRUE if the connected agent is an instance of the model class
     *         <code>agentClass</code> FALSE otherwise.
     */
    public boolean isA(String agentClass) {
        return className.equals(agentClass);
    }

    /**
     * Determines which attributes of the given display set the agent is able to see.
     * 
     * @param displaySet the attributes set to check.
     * @return the collection of attributes that this agent can see.
     * @throws SystemException In case of any error
     */
    public Collection<String> getVisibleAttributes(String displaySet) {
        Collection<String> attrList = new ArrayList<>();
        for (String attribute : displaySet.split(",")) {
            attrList.add(attribute.trim());
        }
        return attrList;
    }

    /**
     * Gets the list of active facets.
     * 
     * @return the activeFacets
     */
    public List<String> getActiveFacets() {
        return activeFacets;
    }

    /**
     * Sets the list of active facets.
     * 
     * @param activeFacets the activeFacets to set
     */
    public void setActiveFacets(List<String> activeFacets) {
        this.activeFacets = activeFacets;
    }

    /**
     * Returns if any of the facets is active
     * @param facets Comma-separated list of class names
     * @return True if any of the class names is an active facet
     */
    public boolean isAnyFacetActive(String facets) {
    	boolean result = false;
    	for(String facet : facets.split(",")) {
    		result |= isFacetActive(facet);
    	}
    	return result;
    }
    
    /**
     * Returns if a agent class is active or not.
     * 
     * @param agentClassName the name of the class agent
     * @return true if the class of the agent is active, false otherwise
     */
    public boolean isFacetActive(String agentClassName) {
    	return getAgentRoles().contains(agentClassName);
    }

    /**
     * Initializes the active facets list corresponding to the connected agent.
     */
    public void calculateActiveFacets() {
        activeFacets = new ArrayList<>();
        IEntity agentInstance = this.getAgentInstance();
        if (agentInstance != null) {
            activeFacets = agentInstance.getActiveFacets();
        } else {
            activeFacets.add(this.className);
        }
    }
    @Override
    public User save(User agent) {
        return agent;
    }

    @Override
    public Optional<User> find(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String userName) {
    	AbstractAppEntity instance = findAgentByUserName(userName);
    	List<String> roles = (instance != null ? instance.getActiveFacets() : new ArrayList<>());
        return instance != null ? Optional.of(new User(userName, getPassword(instance), roles, "")) : Optional.empty();
    }
    
    @Override
    public Optional<User> findByFacetAndUsername(String facetName, String userName) {
    	AbstractAppEntity instance = findAgentByFacetAndUsername(facetName, userName);
    	List<String> roles = (instance != null ? instance.getActiveFacets() : new ArrayList<>());
        return instance != null ? Optional.of(new User(userName, getPassword(instance), roles, facetName)) : Optional.empty();
    }
    
    private AbstractAppEntity findAgentByUserName(String userName) {
    	AbstractAppEntity instance;
        instance = findFuncionarioByUserName(userName);
        if (instance == null) instance = findUsuarioSistemaExternoByUserName(userName);
    	return instance;
    }
    
    private AbstractAppEntity findAgentByFacetAndUsername(String facetName, String userName) {
        setClassName(facetName);
    	switch (facetName) {
    	case Constants.FUNCIONARIO:
    		return findAgentAsFuncionario(userName);
    	case Constants.ADMIN:
    		return findAgentAsAdmin(userName);
    	case Constants.SUPERADMIN:
    		return findAgentAsSuperAdmin(userName);
    	case Constants.ASESOR:
    		return findAgentAsAsesor(userName);
    	case Constants.AREAMEDICA:
    		return findAgentAsAreaMedica(userName);
    	case Constants.AFILIACIONES:
    		return findAgentAsAfiliaciones(userName);
    	case Constants.RESPREGIONAL:
    		return findAgentAsRespRegional(userName);
    	case Constants.GESTOR:
    		return findAgentAsGestor(userName);
    	case Constants.MESADEAPOYO:
    		return findAgentAsMesaDeApoyo(userName);
    	case Constants.USUARIOSISTEMAEXTERNO:
    		return findAgentAsUsuarioSistemaExterno(userName);
    	default:
    		return null;
    	}
    }

    private Funcionario findFuncionarioByUserName(String userName) {
        return funcionarioService.getById(Long.valueOf(userName));
    }

    private UsuarioSistemaExterno findUsuarioSistemaExternoByUserName(String userName) {
        return usuarioSistemaExternoService.getById(userName);
    }

    private Funcionario findAgentAsFuncionario(String userName) {
    	return funcionarioService.getByOID(new FuncionarioOid().fromJsonString(userName));
    }

    private Admin findAgentAsAdmin(String userName) {
    	return adminService.getByOID(new AdminOid().fromJsonString(userName));
    }

    private SuperAdmin findAgentAsSuperAdmin(String userName) {
    	return superAdminService.getByOID(new SuperAdminOid().fromJsonString(userName));
    }

    private Asesor findAgentAsAsesor(String userName) {
    	return asesorService.getByOID(new AsesorOid().fromJsonString(userName));
    }

    private AreaMedica findAgentAsAreaMedica(String userName) {
    	return areaMedicaService.getByOID(new AreaMedicaOid().fromJsonString(userName));
    }

    private Afiliaciones findAgentAsAfiliaciones(String userName) {
    	return afiliacionesService.getByOID(new AfiliacionesOid().fromJsonString(userName));
    }

    private RespRegional findAgentAsRespRegional(String userName) {
    	return respRegionalService.getByOID(new RespRegionalOid().fromJsonString(userName));
    }

    private Gestor findAgentAsGestor(String userName) {
    	return gestorService.getByOID(new GestorOid().fromJsonString(userName));
    }

    private MesaDeApoyo findAgentAsMesaDeApoyo(String userName) {
    	return mesaDeApoyoService.getByOID(new MesaDeApoyoOid().fromJsonString(userName));
    }

    private UsuarioSistemaExterno findAgentAsUsuarioSistemaExterno(String userName) {
    	return usuarioSistemaExternoService.getByOID(new UsuarioSistemaExternoOid().fromJsonString(userName));
    }

    private String getPassword(AbstractAppEntity instance) {
    	String p4ssw0rd;
    	Method p4ssw0rdGetter = instance.getMethod("PassWord");
    	try {
    		p4ssw0rd = p4ssw0rdGetter != null
        			? (p4ssw0rdGetter.invoke(instance)).toString()
        			: "";
    	} catch (Exception e) {
    		p4ssw0rd = "";
    	}
    	return p4ssw0rd;
    }
}
