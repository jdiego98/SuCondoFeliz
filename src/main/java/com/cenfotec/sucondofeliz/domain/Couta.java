package com.cenfotec.sucondofeliz.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Couta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double precio;
    private Date fecha;

    public Couta() {
    }

    public Couta(long id, double precio, Date fecha) {
        this.id = id;
        this.precio = precio;
        this.fecha = fecha;
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
}
