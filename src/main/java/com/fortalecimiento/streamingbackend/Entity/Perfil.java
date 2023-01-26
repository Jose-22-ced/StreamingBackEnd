package com.fortalecimiento.streamingbackend.Entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "perfil")
@Getter
@Setter
public class Perfil implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idperfil", nullable = false)
    private Long idperfil;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;

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

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    private Persona persona;

}
