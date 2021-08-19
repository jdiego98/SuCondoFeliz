package com.cenfotec.sucondofeliz.graphql.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class CondominioGraph implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nombre;
    private String direccion;
    private String cedulaJuridica;
    private String representante;
    private int unidades;
    private boolean estado;
    private double cuota;
    private String eliminado;

    @OneToMany
    @JoinColumn(name="condominioPadre", referencedColumnName = "id")
    private Set<CondominioGraph> condominios;

    public CondominioGraph() {

    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Set<CondominioGraph> getCondominios() {
        return condominios;
    }

    public void setCondominios(Set<CondominioGraph> condominios) {
        this.condominios = condominios;
    }

    public String getEliminado() {
        return eliminado;
    }

    public void setEliminado(String eliminado) {
        this.eliminado = eliminado;
    }


}
