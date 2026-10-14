package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.exception.SystemException;
import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.Dominio;
import com.keralty.aesolicitudes.persistence.Planes;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;
import java.sql.Date;
import java.util.Collection;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalServicesJpaRepository {

    Collection<Productos> assocOperator074(String tGSOLICITUDFISICACARGARpCLProducto) throws SystemException;

    Collection<Aesolicitudes> assocOperator075(String tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD) throws SystemException;

    Boolean assocOperator076(String tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD) throws SystemException;

    Collection<Dominio> assocOperator135() throws SystemException;

    Collection<Solicitud> assocOperator136(Planes oGANULARSOLAUXptPlan, Date oGANULARSOLAUXptFechaCad) throws SystemException;

    Collection<Solicitud> assocOperator141() throws SystemException;

    Collection<SolicitudNovedad> assocOperator142() throws SystemException;

    void refreshEntity(Object object);
}
