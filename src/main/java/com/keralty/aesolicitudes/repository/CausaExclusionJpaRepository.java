package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.CausaExclusion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CausaExclusionJpaRepository extends JpaRepository<CausaExclusion, Long>, CausaExclusionJpaRepositoryCustom {
}
