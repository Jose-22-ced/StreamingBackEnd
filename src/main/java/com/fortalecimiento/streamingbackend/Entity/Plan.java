package com.fortalecimiento.streamingbackend.Entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "plan")
@Getter
@Setter
public class Plan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idplan", nullable = false)
    private Long idplan;

    @Column(name = "tipo", length = 50, nullable = false, unique = true)
    private String tipo;

    @Column(name = "numpefil", nullable = false)
    private int numpefil;

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

    @OneToMany(targetEntity = Persona.class,mappedBy = "plan")
    private List<Persona> personas;

}
