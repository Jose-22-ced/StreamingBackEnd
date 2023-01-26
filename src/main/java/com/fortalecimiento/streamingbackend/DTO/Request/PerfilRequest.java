package com.fortalecimiento.streamingbackend.DTO.Request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
public class PerfilRequest implements Serializable {

    private Long idperfil;

    private String nombre;

    private String tipo;

    private String usua_creo;

    private String usua_mod;

    private Date fech_cre;

    private Date fech_mod;

    private Long idpersona;
}
