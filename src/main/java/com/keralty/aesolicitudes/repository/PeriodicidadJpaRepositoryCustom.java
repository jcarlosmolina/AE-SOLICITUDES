package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.persistence.Dominio;
import com.keralty.aesolicitudes.persistence.Periodicidad;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;
import com.keralty.aesolicitudes.sqlutils.SQLExists;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface PeriodicidadJpaRepositoryCustom {

    List<Periodicidad> solveQuery(SQLSelect query);
    
    List<Periodicidad> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Boolean assocOperator001(Dominio dominioInsPeriodicidadDominiopthisDominio) throws SystemException;

    Boolean assocOperator001Range1(Dominio dominioInsPeriodicidadDominiopthisDominio) throws SystemException;
    
    SQLExists assocOperator001Range1Query(Dominio dominioInsPeriodicidadDominiopthisDominio, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator002(Dominio dominioDelPeriodicidadDominiopthisDominio) throws SystemException;

    Boolean assocOperator002Range1(Dominio dominioDelPeriodicidadDominiopthisDominio) throws SystemException;
    
    SQLExists assocOperator002Range1Query(Dominio dominioDelPeriodicidadDominiopthisDominio, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator003(Solicitud solicitudTMODIFICARINFOPAGOpthisSolicitud) throws SystemException;

    Boolean assocOperator003Range1(Solicitud solicitudTMODIFICARINFOPAGOpthisSolicitud) throws SystemException;
    
    SQLExists assocOperator003Range1Query(Solicitud solicitudTMODIFICARINFOPAGOpthisSolicitud, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator004(SolicitudNovedad solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad) throws SystemException;

    Boolean assocOperator004Range1(SolicitudNovedad solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad) throws SystemException;
    
    SQLExists assocOperator004Range1Query(SolicitudNovedad solicitudNovedadTCHGNUEVAPERIODICIDADpthisSolicitudNovedad, SQLSelect superQuery) throws SystemException;

    public List<Periodicidad> executeQuery(String query);

    public List<Periodicidad> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
