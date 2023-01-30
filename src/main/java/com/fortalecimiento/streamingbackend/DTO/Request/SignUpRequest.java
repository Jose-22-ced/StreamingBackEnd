package com.fortalecimiento.streamingbackend.DTO.Request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SignUpRequest implements Serializable {
    private String correo;
    private String clave;
}
