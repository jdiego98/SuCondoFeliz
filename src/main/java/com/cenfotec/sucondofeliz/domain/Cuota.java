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

}
