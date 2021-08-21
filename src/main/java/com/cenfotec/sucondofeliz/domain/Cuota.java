package com.cenfotec.sucondofeliz.domain;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Cuota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float monto;

    private LocalDate fechaTransaccion;

    @ManyToOne
    private Condominio condominio;

    public Cuota() {

    }

    public Cuota(Long id, float monto, LocalDate fechaTransaccion, Condominio condominio) {
        this.id = id;
        this.monto = monto;
        this.fechaTransaccion = fechaTransaccion;
        this.condominio = condominio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public LocalDate getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDate fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }
}
