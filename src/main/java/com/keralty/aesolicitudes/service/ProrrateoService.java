package com.keralty.aesolicitudes.service;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.DominioConstants;
import com.keralty.aesolicitudes.global.ProrrateoConstants;
import com.keralty.aesolicitudes.persistence.oid.ProrrateoOid;
import com.keralty.aesolicitudes.persistence.Prorrateo;
import com.keralty.aesolicitudes.repository.ProrrateoJpaRepository;
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
public class ProrrateoService extends AbstractService {

    ProrrateoJpaRepository repository;

    ProrrateoService prorrateoSrv;

    @Inject
    public ProrrateoService(
            ProrrateoService prorrateoSrv,
            ProrrateoJpaRepository repository) {
        this.prorrateoSrv = prorrateoSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of Prorrateo by ID
     *
     * @param dominioNumero Identification field dominioNumero
     *
     * @param prorrateoidProrrateo Identification field prorrateoidProrrateo
     *
     * @return Instance of Prorrateo
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Prorrateo getById(Long dominioNumero, Long prorrateoidProrrateo) {
        return getByOID(new ProrrateoOid(dominioNumero, prorrateoidProrrateo));
    }
    
    /*
     * Returns an instance of Prorrateo by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Prorrateo
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Prorrateo getByOID(ProrrateoOid oid) {
        Optional<Prorrateo> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Prorrateo by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Prorrateo
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Prorrateo getByOIDWithHV(ProrrateoOid oid) {
        Optional<Prorrateo> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Prorrateo> getInstanceByOid(ProrrateoOid oid) {
        return oid != null && oid.getDominioNumero() != null
               ? repository.findById(oid)
               : Optional.empty();
    }

    /*
     * Returns an instance of Prorrateo by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Prorrateo
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Prorrateo getByJsonOid(String jsonOid) {
        ProrrateoOid oid = new ProrrateoOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ProrrateoOid oid = new ProrrateoOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ProrrateoConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ATTR_FIELD_DOMINIONUMERO, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getDominioNumero(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(ProrrateoConstants.ATTR_FIELD_PRORRATEOIDPRORRATEO, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(oid.getProrrateoidProrrateo(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison2);
        } catch (Exception e) {
            LoggerFactory.getLogger(ProrrateoService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
