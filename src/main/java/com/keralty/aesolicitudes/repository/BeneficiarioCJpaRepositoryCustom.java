package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.persistence.AnexoC;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.ConceptoC;
import com.keralty.aesolicitudes.persistence.PreexistenciaC;
import com.keralty.aesolicitudes.persistence.Usuario;
import com.keralty.aesolicitudes.sqlutils.SQLExists;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLPopulation;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import com.keralty.aesolicitudes.sqlutils.SQLSum;
import java.util.Collection;
import java.util.List;

public interface BeneficiarioCJpaRepositoryCustom {

    List<BeneficiarioC> solveQuery(SQLSelect query);
    
    List<BeneficiarioC> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);
    
    Long nextBeneficiarioCID(Long contratoCContratoCID);

    Double assocOperator000(BeneficiarioC instance) throws SystemException;

    Double assocOperator000Range1(BeneficiarioC instance) throws SystemException;
    
    SQLSum assocOperator000Range1Query(BeneficiarioC instance) throws SystemException;

    Double assocOperator001(BeneficiarioC instance) throws SystemException;

    Double assocOperator001Range1(BeneficiarioC instance) throws SystemException;
    
    SQLSum assocOperator001Range1Query(BeneficiarioC instance) throws SystemException;

    Double assocOperator002(BeneficiarioC instance) throws SystemException;

    Double assocOperator002Range1(BeneficiarioC instance) throws SystemException;
    
    SQLSum assocOperator002Range1Query(BeneficiarioC instance) throws SystemException;

    Double assocOperator003(BeneficiarioC instance) throws SystemException;

    Double assocOperator003Range1(BeneficiarioC instance) throws SystemException;
    
    SQLSum assocOperator003Range1Query(BeneficiarioC instance) throws SystemException;

    Double assocOperator004(BeneficiarioC instance) throws SystemException;

    Double assocOperator004Range1(BeneficiarioC instance) throws SystemException;
    
    SQLSum assocOperator004Range1Query(BeneficiarioC instance) throws SystemException;

    Double assocOperator005(BeneficiarioC instance) throws SystemException;

    Double assocOperator005Range1(BeneficiarioC instance) throws SystemException;
    
    SQLSum assocOperator005Range1Query(BeneficiarioC instance) throws SystemException;

    Double assocOperator006(BeneficiarioC instance) throws SystemException;

    Double assocOperator006Range1(BeneficiarioC instance) throws SystemException;
    
    SQLSum assocOperator006Range1Query(BeneficiarioC instance) throws SystemException;

    Double assocOperator007(BeneficiarioC instance) throws SystemException;

    Double assocOperator007Range1(BeneficiarioC instance) throws SystemException;
    
    SQLSum assocOperator007Range1Query(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator008(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator008Range1(BeneficiarioC instance) throws SystemException;
    
    SQLExists assocOperator008Range1Query(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator009(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator009Range1(BeneficiarioC instance) throws SystemException;
    
    SQLExists assocOperator009Range1Query(BeneficiarioC instance) throws SystemException;

    Collection<AnexoC> assocOperator010(BeneficiarioC instance) throws SystemException;

    Collection<AnexoC> assocOperator010Range1(BeneficiarioC instance) throws SystemException;
    
    SQLPopulation assocOperator010Range1Query(BeneficiarioC instance) throws SystemException;

    Collection<ConceptoC> assocOperator011(BeneficiarioC instance) throws SystemException;

    Collection<ConceptoC> assocOperator011Range1(BeneficiarioC instance) throws SystemException;
    
    SQLPopulation assocOperator011Range1Query(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator013(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator013Range1(BeneficiarioC instance) throws SystemException;
    
    SQLExists assocOperator013Range1Query(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator014(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator014Range1(BeneficiarioC instance) throws SystemException;
    
    SQLExists assocOperator014Range1Query(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator015(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator015Range1(BeneficiarioC instance) throws SystemException;
    
    SQLExists assocOperator015Range1Query(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator017(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator017Range1(BeneficiarioC instance) throws SystemException;
    
    SQLExists assocOperator017Range1Query(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator019(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator019Range1(BeneficiarioC instance) throws SystemException;
    
    SQLExists assocOperator019Range1Query(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator022(Usuario beneficiarioCTNEWDESDEAEptUsuario) throws SystemException;

    Boolean assocOperator022Range1(Usuario beneficiarioCTNEWDESDEAEptUsuario) throws SystemException;
    
    SQLExists assocOperator022Range1Query(Usuario beneficiarioCTNEWDESDEAEptUsuario, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator023(Usuario beneficiarioCTNEWDESDEAEptUsuario) throws SystemException;

    Boolean assocOperator023Range1(Usuario beneficiarioCTNEWDESDEAEptUsuario) throws SystemException;
    
    SQLExists assocOperator023Range1Query(Usuario beneficiarioCTNEWDESDEAEptUsuario, SQLSelect superQuery) throws SystemException;

    Collection<PreexistenciaC> assocOperator024(BeneficiarioC instance) throws SystemException;

    Collection<PreexistenciaC> assocOperator024Range1(BeneficiarioC instance) throws SystemException;
    
    SQLPopulation assocOperator024Range1Query(BeneficiarioC instance) throws SystemException;

    Collection<ConceptoC> assocOperator025(BeneficiarioC instance) throws SystemException;

    Collection<ConceptoC> assocOperator025Range1(BeneficiarioC instance) throws SystemException;
    
    SQLPopulation assocOperator025Range1Query(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator029(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator029Range1(BeneficiarioC instance) throws SystemException;
    
    SQLExists assocOperator029Range1Query(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator030(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator030Range1(BeneficiarioC instance) throws SystemException;
    
    SQLExists assocOperator030Range1Query(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator031(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator031Range1(BeneficiarioC instance) throws SystemException;
    
    SQLExists assocOperator031Range1Query(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator033(BeneficiarioC instance) throws SystemException;

    Boolean assocOperator033Range1(BeneficiarioC instance) throws SystemException;
    
    SQLExists assocOperator033Range1Query(BeneficiarioC instance) throws SystemException;

    public List<BeneficiarioC> executeQuery(String query);

    public List<BeneficiarioC> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
