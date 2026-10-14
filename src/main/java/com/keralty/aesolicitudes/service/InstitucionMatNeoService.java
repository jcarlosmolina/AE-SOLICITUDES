package com.keralty.aesolicitudes.service;

import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.InstitucionMatNeoConstants;
import com.keralty.aesolicitudes.persistence.InstitucionMatNeo;
import com.keralty.aesolicitudes.persistence.oid.InstitucionMatNeoOid;
import com.keralty.aesolicitudes.repository.InstitucionMatNeoJpaRepository;
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
public class InstitucionMatNeoService extends AbstractService {

    InstitucionMatNeoJpaRepository repository;

    InstitucionMatNeoService institucionMatNeoSrv;

    @Inject
    public InstitucionMatNeoService(
            InstitucionMatNeoService institucionMatNeoSrv,
            InstitucionMatNeoJpaRepository repository) {
        this.institucionMatNeoSrv = institucionMatNeoSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of InstitucionMatNeo by ID
     *
     * @param institucionMatNeoCodigo Identification field institucionMatNeoCodigo
     *
     * @return Instance of InstitucionMatNeo
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public InstitucionMatNeo getById(String institucionMatNeoCodigo) {
        return getByOID(new InstitucionMatNeoOid(institucionMatNeoCodigo));
    }
    
    /*
     * Returns an instance of InstitucionMatNeo by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of InstitucionMatNeo
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public InstitucionMatNeo getByOID(InstitucionMatNeoOid oid) {
        Optional<InstitucionMatNeo> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of InstitucionMatNeo by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of InstitucionMatNeo
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstitucionMatNeo getByOIDWithHV(InstitucionMatNeoOid oid) {
        Optional<InstitucionMatNeo> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<InstitucionMatNeo> getInstanceByOid(InstitucionMatNeoOid oid) {
        return oid != null && oid.getInstitucionMatNeoCodigo() != null
               ? repository.findById(oid.getInstitucionMatNeoCodigo())
               : Optional.empty();
    }

    /*
     * Returns an instance of InstitucionMatNeo by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of InstitucionMatNeo
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public InstitucionMatNeo getByJsonOid(String jsonOid) {
        InstitucionMatNeoOid oid = new InstitucionMatNeoOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            InstitucionMatNeoOid oid = new InstitucionMatNeoOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(InstitucionMatNeoConstants.ATTR_FIELD_INSTITUCIONMATNEOCODIGO, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getInstitucionMatNeoCodigo(), Constants.Type.STRING.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(InstitucionMatNeoService.class).error(e.getMessage());
        }
    }

}
