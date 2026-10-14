package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.EstadoBeneficiario;
import com.keralty.aesolicitudes.persistence.Usuario;
import com.keralty.aesolicitudes.persistence.UsuarioReg;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoBeneficiarioJpaRepository extends JpaRepository<EstadoBeneficiario, Long>, EstadoBeneficiarioJpaRepositoryCustom {

    List<EstadoBeneficiario> findByUsuarioS(Usuario usuarioS);

    List<EstadoBeneficiario> findByBeneficiariosC(BeneficiarioC beneficiariosC);

    List<EstadoBeneficiario> findByUsuariosReg(UsuarioReg usuariosReg);
}
