package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Firma;
import com.keralty.aesolicitudes.persistence.Regional;
import com.keralty.aesolicitudes.persistence.RespRegional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespRegionalJpaRepository extends JpaRepository<RespRegional, Long>, RespRegionalJpaRepositoryCustom {

    List<RespRegional> findByFirma(Firma firma);

    List<RespRegional> findByRegional(Regional regional);
}
