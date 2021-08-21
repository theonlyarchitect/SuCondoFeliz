package com.cenfotec.sucondofeliz.service;

import com.cenfotec.sucondofeliz.domain.Amenidad;
import com.cenfotec.sucondofeliz.domain.Condominio;
import com.cenfotec.sucondofeliz.domain.Cuota;

import java.util.List;
import java.util.Optional;

public interface ICondominioService {

    public void addCouta(Cuota c);

    public Amenidad getAmenidad(String name);

    public List<Condominio> getAllInactives();

    public List<Condominio> getAllActives();

    public boolean deleteCondomino(Long id);

    public boolean disable(Long id);

}
