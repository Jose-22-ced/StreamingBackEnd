package com.fortalecimiento.streamingbackend.Validators;

import com.fortalecimiento.streamingbackend.DTO.Request.SignUpRequest;
import com.fortalecimiento.streamingbackend.Entity.Persona;

import java.util.Optional;

public class SignUpValidator {

    public String signUpValidate(Optional<Persona> persona, SignUpRequest loginRequest){
        if (!persona.isPresent()){
            return "El correo ingresado no existe, porfavor intente con otro.";
        }else if (!persona.get().getClave().equals(loginRequest.getClave())) {
            return "Contrasaña incorrecta.";
        }
        return null;
    }
}
