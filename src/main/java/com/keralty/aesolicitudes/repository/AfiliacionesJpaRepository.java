package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Afiliaciones;
import com.keralty.aesolicitudes.persistence.Planes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AfiliacionesJpaRepository extends JpaRepository<Afiliaciones, Long>, AfiliacionesJpaRepositoryCustom {

    List<Afiliaciones> findByPlanes(Planes planes);
}
