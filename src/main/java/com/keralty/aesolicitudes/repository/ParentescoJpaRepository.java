package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.Parentesco;
import com.keralty.aesolicitudes.persistence.Usuario;
import com.keralty.aesolicitudes.persistence.UsuarioReg;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentescoJpaRepository extends JpaRepository<Parentesco, Long>, ParentescoJpaRepositoryCustom {

    List<Parentesco> findByAtributosUsuario(Usuario atributosUsuario);

    List<Parentesco> findByBeneficiariosC(BeneficiarioC beneficiariosC);

    List<Parentesco> findByUsuariosReg(UsuarioReg usuariosReg);
}
