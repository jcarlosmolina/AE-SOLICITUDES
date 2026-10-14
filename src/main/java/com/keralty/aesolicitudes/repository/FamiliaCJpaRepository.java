package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliaCJpaRepository extends JpaRepository<FamiliaC, FamiliaCOid>, FamiliaCJpaRepositoryCustom {

    List<FamiliaC> findByPersonaCTitular(PersonaC personaCTitular);

    List<FamiliaC> findByBeneficiariosC(BeneficiarioC beneficiariosC);

    List<FamiliaC> findByContratoC(ContratoC contratoC);

    List<FamiliaC> findByMunicipioC(Municipio municipioC);
}
