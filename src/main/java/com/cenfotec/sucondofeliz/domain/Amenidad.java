package com.cenfotec.sucondofeliz.domain;

import javax.persistence.*;

@Entity
public class Amenidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;


    @ManyToOne
    @JoinColumn(nullable=false)
    private Condominio condominio;

    public Amenidad() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }
}
