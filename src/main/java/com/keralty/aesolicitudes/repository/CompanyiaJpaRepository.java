package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.Companyia;
import com.keralty.aesolicitudes.persistence.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyiaJpaRepository extends JpaRepository<Companyia, Long>, CompanyiaJpaRepositoryCustom {

    List<Companyia> findByAtributosUsuario(Usuario atributosUsuario);

    List<Companyia> findByBeneficiariosC(BeneficiarioC beneficiariosC);
}
