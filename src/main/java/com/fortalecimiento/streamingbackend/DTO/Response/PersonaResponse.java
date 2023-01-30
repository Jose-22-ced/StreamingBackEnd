package com.fortalecimiento.streamingbackend.DTO.Response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Getter
@Setter
public class PersonaResponse implements Serializable {

    private Long idpersona;

    private String correo;

    private String clave;

    private String usua_creo;

    private String usua_mod;

    private Date fech_cre;

    private Date fech_mod;

    private List<PerfilResponse> perfils;

    private PlanRespose plan;


    public PersonaResponse() {
    }

    public PersonaResponse(Long idpersona, String correo, String clave, String usua_creo, String usua_mod, Date fech_cre, Date fech_mod, List<PerfilResponse> perfils, PlanRespose plan) {
        this.idpersona = idpersona;
        this.correo = correo;
        this.clave = clave;
        this.usua_creo = usua_creo;
        this.usua_mod = usua_mod;
        this.fech_cre = fech_cre;
        this.fech_mod = fech_mod;
        this.perfils = perfils;
        this.plan = plan;
    }
}
