package com.fortalecimiento.streamingbackend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "persona")
@Getter
@Setter
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idpersona", nullable = false)
    private Long idpersona;

    @Column(name = "correo", length = 50, nullable = false, unique = true)
    private String correo;

    @Column(name = "clave", length = 50, nullable = false)
    private String clave;

    @Column(name = "usua_creo", length = 50, nullable = false)
    private String usua_creo;

    @Column(name = "usua_mod", length = 50, nullable = false)
    private String usua_mod;

    @Column(name = "fech_cre", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fech_cre;

    @Column(name = "fech_mod", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fech_mod;

    @OneToMany(targetEntity = Perfil.class,mappedBy = "persona")
    private List<Perfil> perfils;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "idplan", referencedColumnName = "idplan")
    private Plan plan;
}
