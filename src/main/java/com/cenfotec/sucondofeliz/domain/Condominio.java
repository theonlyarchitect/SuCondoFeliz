package com.cenfotec.sucondofeliz.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "condominio")
public class Condominio {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    private String direccion;

    private String cedulaJuridica;

    private String representanteLegal;

    private Float cantidadUnidades;

    private Float cuotaMensual;

    private String estado;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "condominio")
    private Set<Cuota> historicoCoutas;

    @ManyToMany
    @JoinTable(
        name = "condominios_amenidades",
        joinColumns = @JoinColumn(name = "condominio_id"),
        inverseJoinColumns = @JoinColumn(name = "amenidad_id") )
    private Set<Amenidad> amenidades;

    public Condominio(){

    }

    public Condominio(Long id, String nombre, String direccion, String cedulaJuridica, String representanteLegal, Float cantidadUnidades, Float cuotaMensual, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cedulaJuridica = cedulaJuridica;
        this.representanteLegal = representanteLegal;
        this.cantidadUnidades = cantidadUnidades;
        this.cuotaMensual = cuotaMensual;
        this.estado = estado;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedulaJuridica() {
        return cedulaJuridica;
    }

    public void setCedulaJuridica(String cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public Float getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(Float cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    public Float getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(Float cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<Cuota> getHistoricoCoutas() {
        return historicoCoutas;
    }

    public void setHistoricoCoutas(Set<Cuota> historicoCoutas) {
        this.historicoCoutas = historicoCoutas;
    }

    public void addtoHistoricoCoutas(Cuota couta){
        this.historicoCoutas.add(couta);
    }

    public Set<Amenidad> getAmenidades() {
        return amenidades;
    }

    public void setAmenidades(Set<Amenidad> amenidades) {
        this.amenidades = amenidades;
    }

    public void addAmenidad(Amenidad amenidad){
        this.amenidades.add(amenidad);
        amenidad.addCondominio(this);
    }
}
