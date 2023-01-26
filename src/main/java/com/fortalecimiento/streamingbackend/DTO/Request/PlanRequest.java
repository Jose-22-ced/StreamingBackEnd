package com.fortalecimiento.streamingbackend.DTO.Request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Getter
@Setter
public class PlanRequest implements Serializable {

    private Long idplan;

    private String tipo;

    private int numpefil;

    private String usua_creo;

    private String usua_mod;

    private Date fech_cre;

    private Date fech_mod;

}
