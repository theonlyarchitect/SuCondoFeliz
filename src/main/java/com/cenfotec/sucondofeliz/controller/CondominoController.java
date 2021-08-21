package com.cenfotec.sucondofeliz.controller;

import com.cenfotec.sucondofeliz.domain.CondoStatus;
import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.repository.CondominioRepository;
import com.cenfotec.sucondofeliz.service.CondominioService;
import javassist.tools.web.BadHttpRequest;
import org.apache.tomcat.util.http.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping({"/condominio"})
public class CondominoController {

    public CondominoController(CondominioService condominioService){
        this.condominioService = condominioService;
    }

    private final Logger log = LoggerFactory.getLogger(CondominoController.class);

    @Autowired
    private CondominioService condominioService;

    @Autowired
    private CondominioRepository condominioRepository;

    @PostMapping
    @ResponseStatus()
    public ResponseEntity<Condominio> registerCondominio(@RequestBody Condominio condominio) throws URISyntaxException {
        log.debug("Creando COndominio : {}", condominio);
        if(condominio.getId() != null){
            return ResponseEntity.badRequest().build();
        }
        condominio.setEstado("ACTIVO");
        Condominio result = condominioService.save(condominio);
        return ResponseEntity
                .created(new URI("/condominio/" +result.getId()))
                .body(result);
    }

    @GetMapping
    public ResponseEntity<List<Condominio>> getAllCondominios(){
        log.debug("Devolviendo todos los condomnios");
        List<Condominio> entityList = condominioService.findAll();
        return ResponseEntity.ok().body(entityList);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Condominio> updateCondominio(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody Condominio condominio
    ){
        if(condominio.getId() == null)
        {
            return ResponseEntity.badRequest().build();
        }
        if (!Objects.equals(id, condominio.getId()))
        {
            return ResponseEntity.badRequest().build();
        }
        if(!condominioRepository.existsById(id))
        {
            return ResponseEntity.badRequest().build();
        }
        Condominio isActive = condominioRepository.getById(id);
        if(isActive.getEstado() != "ACTIVO"){
            return ResponseEntity.badRequest().build();
        }
        Condominio result  = condominioService.save(condominio);
        return ResponseEntity.ok().body(result);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Optional<Condominio>> partialUpdateCondominio(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody Condominio condominio
    ){
        if(condominio.getId() == null)
        {
            return ResponseEntity.badRequest().build();
        }
        if (!Objects.equals(id, condominio.getId()))
        {
            return ResponseEntity.badRequest().build();
        }
        if(!condominioRepository.existsById(id))
        {
            return ResponseEntity.badRequest().build();
        }
        Condominio isActive = condominioRepository.getById(id);
        if(isActive.getEstado() != "ACTIVO"){
            return ResponseEntity.badRequest().build();
        }
        Optional<Condominio> result  = condominioService.partialUpdate(condominio);

        return ResponseEntity.ok().body(result);
    }

    //ACIONES RELACIONADAS A LAS CUOTAS


}
