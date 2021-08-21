package com.cenfotec.sucondofeliz.repository;

import com.cenfotec.sucondofeliz.domain.Amenidad;
import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.domain.Cuota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CondominioRepository extends JpaRepository<Condominio, Long> {
    public List<Condominio> findByEstadoIgnoreCaseContaining(String estado);
}
