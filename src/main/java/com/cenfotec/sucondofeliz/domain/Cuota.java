package com.cenfotec.sucondofeliz.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cuota {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double precio;
    private Date fecha;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Condominio condominio;

    public Cuota() {
    }

    public Cuota(long id, double precio, Date fecha, Condominio condominio) {
        this.id = id;
        this.precio = precio;
        this.fecha = fecha;
        this.condominio = condominio;
    }

    public Cuota(double precio, Date fecha, Condominio condominio) {
        this.precio = precio;
        this.fecha = fecha;
        this.condominio = condominio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }
}
