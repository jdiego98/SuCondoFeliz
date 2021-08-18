package com.cenfotec.sucondofeliz.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Condominio {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombre;
    private String direccion;
    private String cedulaJuridica;
    private String representante;
    private int unidades;

    @OneToMany(fetch= FetchType.LAZY, mappedBy="cuota")
    private Set<Couta> cuota;

    @OneToMany(fetch= FetchType.LAZY, mappedBy="amenidades")
    private Set<Amenidad> amenidades;

    public Condominio() {

    }

    public Condominio(long id, String nombre, String direccion, String cedulaJuridica, String representante, int unidades, Set<Couta> cuota, Set<Amenidad> amenidades) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cedulaJuridica = cedulaJuridica;
        this.representante = representante;
        this.unidades = unidades;
        this.cuota = cuota;
        this.amenidades = amenidades;
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

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Set<Couta> getCuota() {
        return cuota;
    }

    public void setCuota(Set<Couta> cuota) {
        this.cuota = cuota;
    }

    public Set<Amenidad> getAmenidades() {
        return amenidades;
    }

    public void setAmenidades(Set<Amenidad> amenidades) {
        this.amenidades = amenidades;
    }
}
