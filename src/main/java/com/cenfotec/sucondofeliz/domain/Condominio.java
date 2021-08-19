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
    private boolean estado;

//    @OneToMany(fetch= FetchType.LAZY, mappedBy="condominio")
//    private Set<Cuota> cuota;

    private double cuota;

    @OneToMany(fetch= FetchType.LAZY, mappedBy="condominio")
    private Set<Amenidad> amenidad;

    public Condominio() {

    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

//    public Set<Cuota> getCuota() {
//        return cuota;
//    }
//
//    public void setCuota(Set<Cuota> cuota) {
//        this.cuota = cuota;
//    }

    public Set<Amenidad> getAmenidad() {
        return amenidad;
    }

    public void setAmenidad(Set<Amenidad> amenidad) {
        this.amenidad = amenidad;
    }
}
