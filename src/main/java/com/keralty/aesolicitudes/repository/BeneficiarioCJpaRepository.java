package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.AnexoC;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.Companyia;
import com.keralty.aesolicitudes.persistence.ConceptoC;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Eps;
import com.keralty.aesolicitudes.persistence.EstadoBeneficiario;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.Parentesco;
import com.keralty.aesolicitudes.persistence.PersonaC;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiarioCJpaRepository extends JpaRepository<BeneficiarioC, BeneficiarioCOid>, BeneficiarioCJpaRepositoryCustom {

    List<BeneficiarioC> findByPersonaC(PersonaC personaC);

    List<BeneficiarioC> findByAnexosC(AnexoC anexosC);

    List<BeneficiarioC> findByConceptosC(ConceptoC conceptosC);

    List<BeneficiarioC> findByContratoC(ContratoC contratoC);

    List<BeneficiarioC> findByFamiliasC(FamiliaC familiasC);

    List<BeneficiarioC> findByEPSC(Eps ePSC);

    List<BeneficiarioC> findByCompanyiaMPC(Companyia companyiaMPC);

    List<BeneficiarioC> findByParentescoC(Parentesco parentescoC);

    List<BeneficiarioC> findByEstadoBeneficiarioC(EstadoBeneficiario estadoBeneficiarioC);
}
