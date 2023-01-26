package com.fortalecimiento.streamingbackend.DTO.Request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
public class PersonaRequest implements Serializable {

    private Long idpersona;

    private String correo;

    private String clave;

    private String usua_creo;

    private String usua_mod;

    private Date fech_cre;

    private Date fech_mod;

    private Long idplan;
}
