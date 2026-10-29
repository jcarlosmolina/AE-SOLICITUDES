package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Preexistencia;
import com.keralty.aesolicitudes.sqlutils.SQLParam;
import com.keralty.aesolicitudes.sqlutils.SQLSelect;
import java.util.List;

public interface PreexistenciaJpaRepositoryCustom {

    List<Preexistencia> solveQuery(SQLSelect query);
    
    List<Preexistencia> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);
    
    Long nextPreexistenciaIdentificador(Long aesolicitudesidsolicitud, Long usuarioUsuarioIdentificador);

    public List<Preexistencia> executeQuery(String query);

    public List<Preexistencia> executeQuery(String query, List<SQLParam> params);

    void refreshEntity(Object object);
}
