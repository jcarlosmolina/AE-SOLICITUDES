package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.FormaPago;
import com.keralty.aesolicitudes.persistence.Solicitud;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaPagoJpaRepository extends JpaRepository<FormaPago, Long>, FormaPagoJpaRepositoryCustom {

    List<FormaPago> findBySolicitudes(Solicitud solicitudes);

    List<FormaPago> findByContratosC(ContratoC contratosC);
}
