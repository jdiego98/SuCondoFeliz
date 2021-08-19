package com.cenfotec.sucondofeliz.domain;

import javax.persistence.*;

@Entity
public class Amenidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAmenida;
    private String nombre;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Condominio condominio;

    public Amenidad() {
    }

    public long getIdAmenida() {
        return idAmenida;
    }

    public void setIdAmenida(long idAmenida) {
        this.idAmenida = idAmenida;
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
