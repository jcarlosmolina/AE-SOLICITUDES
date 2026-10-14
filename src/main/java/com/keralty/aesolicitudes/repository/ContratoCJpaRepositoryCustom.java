package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.ObservacionesC;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.sqlutils.SQLExists;
import com.keralty.aesolicitudes.sqlutils.SQLGetOne;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLPopulation;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.Collection;
import java.util.List;

public interface ContratoCJpaRepositoryCustom {

    List<ContratoC> solveQuery(SQLSelect query);
    
    List<ContratoC> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Double assocOperator000(ContratoC instance) throws SystemException;

    Collection<BeneficiarioC> assocOperator000Range1(ContratoC instance) throws SystemException;
    
    SQLPopulation assocOperator000Range1Query(ContratoC instance) throws SystemException;

    Double assocOperator001(ContratoC instance) throws SystemException;

    Collection<BeneficiarioC> assocOperator001Range1(ContratoC instance) throws SystemException;
    
    SQLPopulation assocOperator001Range1Query(ContratoC instance) throws SystemException;

    Double assocOperator002(ContratoC instance) throws SystemException;

    Collection<BeneficiarioC> assocOperator002Range1(ContratoC instance) throws SystemException;
    
    SQLPopulation assocOperator002Range1Query(ContratoC instance) throws SystemException;

    Boolean assocOperator003(ContratoC instance) throws SystemException;

    Boolean assocOperator003Range1(ContratoC instance) throws SystemException;
    
    SQLExists assocOperator003Range1Query(ContratoC instance) throws SystemException;

    Boolean assocOperator004(ContratoC instance) throws SystemException;

    Boolean assocOperator004Range1(ContratoC instance) throws SystemException;
    
    SQLExists assocOperator004Range1Query(ContratoC instance) throws SystemException;

    Boolean assocOperator005(ContratoC instance) throws SystemException;

    Boolean assocOperator005Range1(ContratoC instance) throws SystemException;
    
    SQLExists assocOperator005Range1Query(ContratoC instance) throws SystemException;

    String assocOperator006(ContratoC instance) throws SystemException;

    String assocOperator006Range1(ContratoC instance) throws SystemException;
    
    SQLGetOne assocOperator006Range1Query(ContratoC instance) throws SystemException;

    Double assocOperator007(ContratoC instance) throws SystemException;

    Collection<BeneficiarioC> assocOperator007Range1(ContratoC instance) throws SystemException;
    
    SQLPopulation assocOperator007Range1Query(ContratoC instance) throws SystemException;

    Double assocOperator008(ContratoC instance) throws SystemException;

    Collection<BeneficiarioC> assocOperator008Range1(ContratoC instance) throws SystemException;
    
    SQLPopulation assocOperator008Range1Query(ContratoC instance) throws SystemException;

    Boolean assocOperator011(ContratoC instance) throws SystemException;

    Boolean assocOperator011Range1(ContratoC instance) throws SystemException;
    
    SQLExists assocOperator011Range1Query(ContratoC instance) throws SystemException;

    Boolean assocOperator012(ContratoC instance) throws SystemException;

    Boolean assocOperator012Range1(ContratoC instance) throws SystemException;
    
    SQLExists assocOperator012Range1Query(ContratoC instance) throws SystemException;

    Boolean assocOperator013(ContratoC instance) throws SystemException;

    Boolean assocOperator013Range1(ContratoC instance) throws SystemException;
    
    SQLExists assocOperator013Range1Query(ContratoC instance) throws SystemException;

    Boolean assocOperator014(ContratoC instance) throws SystemException;

    Boolean assocOperator014Range1(ContratoC instance) throws SystemException;
    
    SQLExists assocOperator014Range1Query(ContratoC instance) throws SystemException;

    Boolean assocOperator016(ContratoC instance) throws SystemException;

    Boolean assocOperator016Range1(ContratoC instance) throws SystemException;
    
    SQLExists assocOperator016Range1Query(ContratoC instance) throws SystemException;

    Collection<DireccionC> assocOperator018(ContratoC instance, Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAE) throws SystemException;

    Collection<DireccionC> assocOperator018Range1(ContratoC instance, Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAE) throws SystemException;
    
    SQLPopulation assocOperator018Range1Query(ContratoC instance, Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAE) throws SystemException;

    Boolean assocOperator020(Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAE) throws SystemException;

    Boolean assocOperator020Range1(Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAE) throws SystemException;
    
    SQLExists assocOperator020Range1Query(Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAE, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator021(ContratoC instance, Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAE) throws SystemException;

    Boolean assocOperator021Range1(ContratoC instance, Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAE) throws SystemException;
    
    SQLExists assocOperator021Range1Query(ContratoC instance, Solicitud contratoCTCREAROMODDIRDEAEpSolicitudAE) throws SystemException;

    Collection<FamiliaC> assocOperator022(ContratoC instance) throws SystemException;

    Collection<FamiliaC> assocOperator022Range1(ContratoC instance) throws SystemException;
    
    SQLPopulation assocOperator022Range1Query(ContratoC instance) throws SystemException;

    Collection<ObservacionesC> assocOperator024(ContratoC instance) throws SystemException;

    Collection<ObservacionesC> assocOperator024Range1(ContratoC instance) throws SystemException;
    
    SQLPopulation assocOperator024Range1Query(ContratoC instance) throws SystemException;

    Collection<DireccionC> assocOperator025(ContratoC instance) throws SystemException;

    Collection<DireccionC> assocOperator025Range1(ContratoC instance) throws SystemException;
    
    SQLPopulation assocOperator025Range1Query(ContratoC instance) throws SystemException;

    Boolean assocOperator026(ContratoC instance) throws SystemException;

    Boolean assocOperator026Range1(ContratoC instance) throws SystemException;
    
    SQLExists assocOperator026Range1Query(ContratoC instance) throws SystemException;

    Collection<PersonaC> assocOperator028(ContratoC instance) throws SystemException;

    Collection<PersonaC> assocOperator028Range1(ContratoC instance) throws SystemException;
    
    SQLPopulation assocOperator028Range1Query(ContratoC instance) throws SystemException;

    Collection<FamiliaC> assocOperator032(ContratoC instance) throws SystemException;

    Collection<FamiliaC> assocOperator032Range1(ContratoC instance) throws SystemException;
    
    SQLPopulation assocOperator032Range1Query(ContratoC instance) throws SystemException;

    Boolean assocOperator033(ContratoC instance) throws SystemException;

    Boolean assocOperator033Range1(ContratoC instance) throws SystemException;
    
    SQLExists assocOperator033Range1Query(ContratoC instance) throws SystemException;

    Boolean assocOperator034(ContratoC instance) throws SystemException;

    Boolean assocOperator034Range1(ContratoC instance) throws SystemException;
    
    SQLExists assocOperator034Range1Query(ContratoC instance) throws SystemException;

    Boolean assocOperator035(ContratoC instance) throws SystemException;

    Boolean assocOperator035Range1(ContratoC instance) throws SystemException;
    
    SQLExists assocOperator035Range1Query(ContratoC instance) throws SystemException;

    Boolean assocOperator036(ContratoC instance) throws SystemException;

    Boolean assocOperator036Range1(ContratoC instance) throws SystemException;
    
    SQLExists assocOperator036Range1Query(ContratoC instance) throws SystemException;

    public List<ContratoC> executeQuery(String query);

    public List<ContratoC> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
