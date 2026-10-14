package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.persistence.Usuario;
import com.keralty.aesolicitudes.sqlutils.SQLExists;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLPopulation;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.Collection;
import java.util.List;

public interface FamiliaCJpaRepositoryCustom {

    List<FamiliaC> solveQuery(SQLSelect query);
    
    List<FamiliaC> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);
    
    Long nextFamiliaCID(Long contratoCContratoCID);

    Collection<BeneficiarioC> assocOperator000(FamiliaC instance) throws SystemException;

    Collection<BeneficiarioC> assocOperator000Range1(FamiliaC instance) throws SystemException;
    
    SQLPopulation assocOperator000Range1Query(FamiliaC instance) throws SystemException;

    Boolean assocOperator002(FamiliaC instance) throws SystemException;

    Boolean assocOperator002Range1(FamiliaC instance) throws SystemException;
    
    SQLExists assocOperator002Range1Query(FamiliaC instance) throws SystemException;

    Collection<Usuario> assocOperator003(Solicitud familiaCTNEWDESDEAEptSolicitud) throws SystemException;

    Collection<Usuario> assocOperator003Range1(Solicitud familiaCTNEWDESDEAEptSolicitud) throws SystemException;
    
    SQLPopulation assocOperator003Range1Query(Solicitud familiaCTNEWDESDEAEptSolicitud) throws SystemException;

    Collection<BeneficiarioC> assocOperator005(FamiliaC instance, TipoIdentificacion familiaCTCREARACTBENEFptptTipoId, String familiaCTCREARACTBENEFptptNumIdentificacion) throws SystemException;

    Collection<BeneficiarioC> assocOperator005Range1(FamiliaC instance, TipoIdentificacion familiaCTCREARACTBENEFptptTipoId, String familiaCTCREARACTBENEFptptNumIdentificacion) throws SystemException;
    
    SQLPopulation assocOperator005Range1Query(FamiliaC instance, TipoIdentificacion familiaCTCREARACTBENEFptptTipoId, String familiaCTCREARACTBENEFptptNumIdentificacion) throws SystemException;

    Boolean assocOperator006(FamiliaC instance, TipoIdentificacion familiaCTCREARACTBENEFptptTipoId, String familiaCTCREARACTBENEFptptNumIdentificacion) throws SystemException;

    Boolean assocOperator006Range1(FamiliaC instance, TipoIdentificacion familiaCTCREARACTBENEFptptTipoId, String familiaCTCREARACTBENEFptptNumIdentificacion) throws SystemException;
    
    SQLExists assocOperator006Range1Query(FamiliaC instance, TipoIdentificacion familiaCTCREARACTBENEFptptTipoId, String familiaCTCREARACTBENEFptptNumIdentificacion) throws SystemException;

    Boolean assocOperator009(FamiliaC instance) throws SystemException;

    Boolean assocOperator009Range1(FamiliaC instance) throws SystemException;
    
    SQLExists assocOperator009Range1Query(FamiliaC instance) throws SystemException;

    Boolean assocOperator010(FamiliaC instance) throws SystemException;

    Boolean assocOperator010Range1(FamiliaC instance) throws SystemException;
    
    SQLExists assocOperator010Range1Query(FamiliaC instance) throws SystemException;

    public List<FamiliaC> executeQuery(String query);

    public List<FamiliaC> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
