package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.oid.ParentescoDomOid;
import com.keralty.aesolicitudes.persistence.Parentesco;
import com.keralty.aesolicitudes.persistence.ParentescoDom;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentescoDomJpaRepository extends JpaRepository<ParentescoDom, ParentescoDomOid>, ParentescoDomJpaRepositoryCustom {

    List<ParentescoDom> findByParentesco(Parentesco parentesco);
}
