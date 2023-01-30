package com.fortalecimiento.streamingbackend.DTO.Response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Getter
@Setter
public class PlanRespose implements Serializable {

    private Long idplan;

    private String tipo;

    private int numpefil;

    private String usua_creo;

    private String usua_mod;

    private Date fech_cre;

    private Date fech_mod;

    private List<PersonaResponse> personas;

    public PlanRespose() {
    }

    public PlanRespose(Long idplan, String tipo, int numpefil, String usua_creo, String usua_mod, Date fech_cre, Date fech_mod, List<PersonaResponse> personas) {
        this.idplan = idplan;
        this.tipo = tipo;
        this.numpefil = numpefil;
        this.usua_creo = usua_creo;
        this.usua_mod = usua_mod;
        this.fech_cre = fech_cre;
        this.fech_mod = fech_mod;
        this.personas = personas;
    }
}
