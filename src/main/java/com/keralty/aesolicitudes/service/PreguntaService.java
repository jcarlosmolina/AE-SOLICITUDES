package com.keralty.aesolicitudes.service;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.global.Constants;
import com.keralty.aesolicitudes.global.PreguntaConstants;
import com.keralty.aesolicitudes.persistence.oid.PreguntaOid;
import com.keralty.aesolicitudes.persistence.Pregunta;
import com.keralty.aesolicitudes.repository.PreguntaJpaRepository;
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
public class PreguntaService extends AbstractService {

    PreguntaJpaRepository repository;

    PreguntaService preguntaSrv;

    @Inject
    public PreguntaService(
            PreguntaService preguntaSrv,
            PreguntaJpaRepository repository) {
        this.preguntaSrv = preguntaSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of Pregunta by ID
     *
     * @param preguntaNumero Identification field preguntaNumero
     *
     * @return Instance of Pregunta
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Pregunta getById(Long preguntaNumero) {
        return getByOID(new PreguntaOid(preguntaNumero));
    }
    
    /*
     * Returns an instance of Pregunta by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Pregunta
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Pregunta getByOID(PreguntaOid oid) {
        Optional<Pregunta> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Pregunta by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Pregunta
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Pregunta getByOIDWithHV(PreguntaOid oid) {
        Optional<Pregunta> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Pregunta> getInstanceByOid(PreguntaOid oid) {
        return oid != null && oid.getPreguntaNumero() != null
               ? repository.findById(oid.getPreguntaNumero())
               : Optional.empty();
    }

    /*
     * Returns an instance of Pregunta by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Pregunta
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Pregunta getByJsonOid(String jsonOid) {
        PreguntaOid oid = new PreguntaOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            PreguntaOid oid = new PreguntaOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(PreguntaConstants.ATTR_FIELD_PREGUNTANUMERO, Constants.Type.INT.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getPreguntaNumero(), Constants.Type.INT.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(PreguntaService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
