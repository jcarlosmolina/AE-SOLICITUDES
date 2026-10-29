package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.AnexoMat;
import com.keralty.aesolicitudes.persistence.AnexoNeo;
import com.keralty.aesolicitudes.persistence.Companyia;
import com.keralty.aesolicitudes.persistence.CuestionarioP;
import com.keralty.aesolicitudes.persistence.Eps;
import com.keralty.aesolicitudes.persistence.EstadoBeneficiario;
import com.keralty.aesolicitudes.persistence.oid.UsuarioOid;
import com.keralty.aesolicitudes.persistence.Parentesco;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.persistence.Preexistencia;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.persistence.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioJpaRepository extends JpaRepository<Usuario, UsuarioOid>, UsuarioJpaRepositoryCustom {

    List<Usuario> findByCuestionarioP(CuestionarioP cuestionarioP);

    List<Usuario> findByAnexoMat(AnexoMat anexoMat);

    List<Usuario> findByAnexoNeo(AnexoNeo anexoNeo);

    List<Usuario> findByPreexistencias(Preexistencia preexistencias);

    List<Usuario> findBySolicitud(Solicitud solicitud);

    List<Usuario> findByUsuarioPersona(Persona usuarioPersona);

    List<Usuario> findByEps(Eps eps);

    List<Usuario> findByParentesco(Parentesco parentesco);

    List<Usuario> findByCompanyia(Companyia companyia);

    List<Usuario> findByTipoIdentificacion(TipoIdentificacion tipoIdentificacion);

    List<Usuario> findByEstadoBeneficiario(EstadoBeneficiario estadoBeneficiario);
}
