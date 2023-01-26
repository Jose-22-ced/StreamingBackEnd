package com.fortalecimiento.streamingbackend.DTO.Response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PerfilResponse implements Serializable {


    private Long idperfil;

    private String nombre;

    private String tipo;

    private String usua_creo;

    private String usua_mod;

    private Date fech_cre;

    private Date fech_mod;

    private PersonaResonse persona;

    public PerfilResponse() {
    }

    public PerfilResponse(Long idperfil, String nombre, String tipo, String usua_creo, String usua_mod, Date fech_cre, Date fech_mod, PersonaResonse persona) {
        this.idperfil = idperfil;
        this.nombre = nombre;
        this.tipo = tipo;
        this.usua_creo = usua_creo;
        this.usua_mod = usua_mod;
        this.fech_cre = fech_cre;
        this.fech_mod = fech_mod;
        this.persona = persona;
    }
}
