package com.keralty.aesolicitudes.service;

import com.keralty.aesolicitudes.global.AgentexProductoConstants;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.FuncionarioConstants;
import com.keralty.aesolicitudes.persistence.AgentexProducto;
import com.keralty.aesolicitudes.persistence.oid.AgentexProductoOid;
import com.keralty.aesolicitudes.repository.AgentexProductoJpaRepository;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLWhereComparison;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aesolicitudes.sqlutils.SQLWhereOperandPathAttribute;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class AgentexProductoService extends AbstractService {

    AgentexProductoJpaRepository repository;

    AgentexProductoService agentexProductoSrv;

    @Inject
    public AgentexProductoService(
            AgentexProductoService agentexProductoSrv,
            AgentexProductoJpaRepository repository) {
        this.agentexProductoSrv = agentexProductoSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of AgentexProducto by ID
     *
     * @param funcionarioAsesorId Identification field funcionarioAsesorId
     *
     * @param agentexProductoId Identification field agentexProductoId
     *
     * @return Instance of AgentexProducto
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public AgentexProducto getById(Long funcionarioAsesorId, Long agentexProductoId) {
        return getByOID(new AgentexProductoOid(funcionarioAsesorId, agentexProductoId));
    }
    
    /*
     * Returns an instance of AgentexProducto by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of AgentexProducto
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public AgentexProducto getByOID(AgentexProductoOid oid) {
        Optional<AgentexProducto> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of AgentexProducto by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of AgentexProducto
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public AgentexProducto getByOIDWithHV(AgentexProductoOid oid) {
        Optional<AgentexProducto> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<AgentexProducto> getInstanceByOid(AgentexProductoOid oid) {
        return oid != null && oid.getFuncionarioAsesorId() != null
               ? repository.findById(oid)
               : Optional.empty();
    }

    /*
     * Returns an instance of AgentexProducto by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of AgentexProducto
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public AgentexProducto getByJsonOid(String jsonOid) {
        AgentexProductoOid oid = new AgentexProductoOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            AgentexProductoOid oid = new AgentexProductoOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(AgentexProductoConstants.ROLE_NAME_ASESOR + "." + FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getFuncionarioAsesorId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(AgentexProductoConstants.ATTR_FIELD_AGENTEXPRODUCTOID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(oid.getAgentexProductoId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison2);
        } catch (Exception e) {
            LoggerFactory.getLogger(AgentexProductoService.class).error(e.getMessage());
        }
    }

}
