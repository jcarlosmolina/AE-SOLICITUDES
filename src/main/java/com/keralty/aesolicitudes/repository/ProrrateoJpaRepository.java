package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.oid.ProrrateoOid;
import com.keralty.aesolicitudes.persistence.Prorrateo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProrrateoJpaRepository extends JpaRepository<Prorrateo, ProrrateoOid>, ProrrateoJpaRepositoryCustom {
}
