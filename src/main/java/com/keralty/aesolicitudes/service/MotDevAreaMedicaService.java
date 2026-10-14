package com.keralty.aesolicitudes.service;

import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.MotDevAreaMedicaConstants;
import com.keralty.aesolicitudes.persistence.MotDevAreaMedica;
import com.keralty.aesolicitudes.persistence.oid.MotDevAreaMedicaOid;
import com.keralty.aesolicitudes.repository.MotDevAreaMedicaJpaRepository;
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
public class MotDevAreaMedicaService extends AbstractService {

    MotDevAreaMedicaJpaRepository repository;

    MotDevAreaMedicaService motDevAreaMedicaSrv;

    @Inject
    public MotDevAreaMedicaService(
            MotDevAreaMedicaService motDevAreaMedicaSrv,
            MotDevAreaMedicaJpaRepository repository) {
        this.motDevAreaMedicaSrv = motDevAreaMedicaSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of MotDevAreaMedica by ID
     *
     * @param motDevAreaMedicaId Identification field motDevAreaMedicaId
     *
     * @return Instance of MotDevAreaMedica
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public MotDevAreaMedica getById(Long motDevAreaMedicaId) {
        return getByOID(new MotDevAreaMedicaOid(motDevAreaMedicaId));
    }
    
    /*
     * Returns an instance of MotDevAreaMedica by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of MotDevAreaMedica
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public MotDevAreaMedica getByOID(MotDevAreaMedicaOid oid) {
        Optional<MotDevAreaMedica> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of MotDevAreaMedica by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of MotDevAreaMedica
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public MotDevAreaMedica getByOIDWithHV(MotDevAreaMedicaOid oid) {
        Optional<MotDevAreaMedica> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<MotDevAreaMedica> getInstanceByOid(MotDevAreaMedicaOid oid) {
        return oid != null && oid.getMotDevAreaMedicaId() != null
               ? repository.findById(oid.getMotDevAreaMedicaId())
               : Optional.empty();
    }

    /*
     * Returns an instance of MotDevAreaMedica by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of MotDevAreaMedica
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public MotDevAreaMedica getByJsonOid(String jsonOid) {
        MotDevAreaMedicaOid oid = new MotDevAreaMedicaOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            MotDevAreaMedicaOid oid = new MotDevAreaMedicaOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(MotDevAreaMedicaConstants.ATTR_FIELD_MOTDEVAREAMEDICAID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getMotDevAreaMedicaId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(MotDevAreaMedicaService.class).error(e.getMessage());
        }
    }

}
