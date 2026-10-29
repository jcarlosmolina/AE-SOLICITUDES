package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.ConceptoC;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConceptoCJpaRepository extends JpaRepository<ConceptoC, Long>, ConceptoCJpaRepositoryCustom {

    List<ConceptoC> findByBeneficiarioC(BeneficiarioC beneficiarioC);
}
