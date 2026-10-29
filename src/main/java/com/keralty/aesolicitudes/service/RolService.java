package com.keralty.aesolicitudes.service;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.RolConstants;
import com.keralty.aesolicitudes.persistence.oid.RolOid;
import com.keralty.aesolicitudes.persistence.Rol;
import com.keralty.aesolicitudes.repository.RolJpaRepository;
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
public class RolService extends AbstractService {

    RolJpaRepository repository;

    RolService rolSrv;

    @Inject
    public RolService(
            RolService rolSrv,
            RolJpaRepository repository) {
        this.rolSrv = rolSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of Rol by ID
     *
     * @param rolIdentificador Identification field rolIdentificador
     *
     * @return Instance of Rol
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Rol getById(Long rolIdentificador) {
        return getByOID(new RolOid(rolIdentificador));
    }
    
    /*
     * Returns an instance of Rol by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Rol
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Rol getByOID(RolOid oid) {
        Optional<Rol> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Rol by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Rol
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Rol getByOIDWithHV(RolOid oid) {
        Optional<Rol> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Rol> getInstanceByOid(RolOid oid) {
        return oid != null && oid.getRolIdentificador() != null
               ? repository.findById(oid.getRolIdentificador())
               : Optional.empty();
    }

    /*
     * Returns an instance of Rol by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Rol
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Rol getByJsonOid(String jsonOid) {
        RolOid oid = new RolOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            RolOid oid = new RolOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(RolConstants.ATTR_FIELD_ROLIDENTIFICADOR, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getRolIdentificador(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(RolService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
