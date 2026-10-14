package com.keralty.aesolicitudes.service;

import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.DominioConstants;
import com.keralty.aesolicitudes.global.ParentescoDomConstants;
import com.keralty.aesolicitudes.persistence.oid.ParentescoDomOid;
import com.keralty.aesolicitudes.persistence.ParentescoDom;
import com.keralty.aesolicitudes.repository.ParentescoDomJpaRepository;
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
public class ParentescoDomService extends AbstractService {

    ParentescoDomJpaRepository repository;

    ParentescoDomService parentescoDomSrv;

    @Inject
    public ParentescoDomService(
            ParentescoDomService parentescoDomSrv,
            ParentescoDomJpaRepository repository) {
        this.parentescoDomSrv = parentescoDomSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of ParentescoDom by ID
     *
     * @param dominioNumero Identification field dominioNumero
     *
     * @param parentescoDomIdentificador Identification field parentescoDomIdentificador
     *
     * @return Instance of ParentescoDom
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ParentescoDom getById(Long dominioNumero, Long parentescoDomIdentificador) {
        return getByOID(new ParentescoDomOid(dominioNumero, parentescoDomIdentificador));
    }
    
    /*
     * Returns an instance of ParentescoDom by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ParentescoDom
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ParentescoDom getByOID(ParentescoDomOid oid) {
        Optional<ParentescoDom> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of ParentescoDom by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ParentescoDom
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public ParentescoDom getByOIDWithHV(ParentescoDomOid oid) {
        Optional<ParentescoDom> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<ParentescoDom> getInstanceByOid(ParentescoDomOid oid) {
        return oid != null && oid.getDominioNumero() != null
               ? repository.findById(oid)
               : Optional.empty();
    }

    /*
     * Returns an instance of ParentescoDom by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of ParentescoDom
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public ParentescoDom getByJsonOid(String jsonOid) {
        ParentescoDomOid oid = new ParentescoDomOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ParentescoDomOid oid = new ParentescoDomOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ParentescoDomConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ATTR_FIELD_DOMINIONUMERO, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getDominioNumero(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(ParentescoDomConstants.ATTR_FIELD_PARENTESCODOMIDENTIFICADOR, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(oid.getParentescoDomIdentificador(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison2);
        } catch (Exception e) {
            LoggerFactory.getLogger(ParentescoDomService.class).error(e.getMessage());
        }
    }

}
