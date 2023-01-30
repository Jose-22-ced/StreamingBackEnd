package com.fortalecimiento.streamingbackend.Validators;

import com.fortalecimiento.streamingbackend.Entity.Persona;
import com.fortalecimiento.streamingbackend.Exceptions.BadRequestException;

import java.util.Optional;

public class PerfilValidator {

    public String maxPerfiles(Optional<Persona> persona){
        if (!persona.isPresent()){
            return "La persona no existe";
        }else if (persona.get().getPlan().getNumpefil()<persona.get().getPerfils().size()+1) {
            return "El numero no perfiles no corresponde a su plan";
        }
        return null;
    }


}
