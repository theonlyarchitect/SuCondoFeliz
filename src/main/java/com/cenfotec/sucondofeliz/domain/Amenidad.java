package com.cenfotec.sucondofeliz.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Amenidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany
    private Set<Condominio> condominioSet;

    public Amenidad(){

    }

    public Amenidad(Long id, String nombre, Set<Condominio> condominioSet) {
        this.id = id;
        this.nombre = nombre;
        this.condominioSet = condominioSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Condominio> getCondominioSet() {
        return condominioSet;
    }

    public void setCondominioSet(Set<Condominio> condominioSet) {
        this.condominioSet = condominioSet;
    }

    public void addCondominio(Condominio condominio){
        this.condominioSet.add(condominio);
    }

    public void deleteCondominio(Condominio condominio){
        this.condominioSet.remove(condominio);
    }
}
