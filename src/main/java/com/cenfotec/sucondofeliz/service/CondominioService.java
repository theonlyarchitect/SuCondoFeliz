package com.cenfotec.sucondofeliz.service;


import com.cenfotec.sucondofeliz.domain.CondoStatus;
import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.repository.CondominioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class CondominioService {

    private final Logger log = LoggerFactory.getLogger(CondominioService.class);

    @Autowired
    CondominioRepository condominioRepository;

    public Condominio save(Condominio condominio) {
        log.debug("Guardando: {}", condominio);
        return condominioRepository.save(condominio);
    }

    public Optional<Condominio> partialUpdate(Condominio condominio) {
        log.debug("UpdateParcial de : {}", condominio);
        return condominioRepository
                .findById(condominio.getId())
                .map(
                        existingCondominio -> {
                            if (condominio.getId() != null) {
                                existingCondominio.setId(condominio.getId());
                            }
                            if (condominio.getNombre() != null) {
                                existingCondominio.setNombre(condominio.getNombre());
                            }
                            if (condominio.getDireccion() != null) {
                                existingCondominio.setDireccion(condominio.getDireccion());
                            }
                            if (condominio.getCedulaJuridica() != null) {
                                existingCondominio.setCedulaJuridica(condominio.getCedulaJuridica());
                            }
                            if (condominio.getRepresentanteLegal() != null) {
                                existingCondominio.setRepresentanteLegal(condominio.getRepresentanteLegal());
                            }
                            if (condominio.getCantidadUnidades() != null) {
                                existingCondominio.setCantidadUnidades(condominio.getCantidadUnidades());
                            }
                            if (condominio.getCuotaMensual() != null) {
                                existingCondominio.setCuotaMensual(condominio.getCuotaMensual());
                            }
                            if (condominio.getEstado() != null) {
                                existingCondominio.setEstado(condominio.getEstado());
                            }
                            return existingCondominio;
                        }
                )
                .map(condominioRepository::save);
    }

    @Transactional(readOnly = true)
    public List<Condominio> findAll() {
        log.debug("Se solicitan todos los condominios...");
        return condominioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Condominio> findOne(Long id) {
        log.debug("Se busca condominio id : {}", id);
        return condominioRepository.findById(id);
    }

    public void delete(Long id) {
        log.debug("Se elimina el condominio : {}", id);
        condominioRepository.deleteById(id);
    }

    public Optional<Condominio> desactivate(Long id) {
        log.debug("Se desactiva el condominio id: {}", id);
        Condominio condominio = new Condominio();
        condominio.setId(id);
        condominio.setEstado("INACTIVO");
        return partialUpdate(condominio);
    }

    public List<Condominio> getAllInactives() {
        return condominioRepository.findByEstadoIgnoreCaseContaining("INACTIVO");
    }

    public List<Condominio> getAllActives() {
        return condominioRepository.findByEstadoIgnoreCaseContaining("ACTIVO");
    }

}
