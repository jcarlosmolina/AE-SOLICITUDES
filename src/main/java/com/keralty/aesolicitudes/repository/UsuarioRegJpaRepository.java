package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.EstadoBeneficiario;
import com.keralty.aesolicitudes.persistence.oid.UsuarioRegOid;
import com.keralty.aesolicitudes.persistence.Parentesco;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.UsuarioReg;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRegJpaRepository extends JpaRepository<UsuarioReg, UsuarioRegOid>, UsuarioRegJpaRepositoryCustom {

    List<UsuarioReg> findBySolicitud(Solicitud solicitud);

    List<UsuarioReg> findByEstadoBeneficiario(EstadoBeneficiario estadoBeneficiario);

    List<UsuarioReg> findByParentesco(Parentesco parentesco);
}
