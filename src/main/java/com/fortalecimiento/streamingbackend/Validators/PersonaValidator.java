package com.fortalecimiento.streamingbackend.Validators;

import com.fortalecimiento.streamingbackend.DTO.Request.PersonaRequest;
import com.fortalecimiento.streamingbackend.DTO.Response.PersonaResponse;
import com.fortalecimiento.streamingbackend.Entity.Persona;
import com.fortalecimiento.streamingbackend.Entity.Plan;

import java.util.Optional;

public class PersonaValidator {
    public String correoPersona(Optional<Persona> persona){
        if (persona.isPresent()){
            return "El correo ingresado ya se encuentra registrado.";
        }
        return null;
    }

    public boolean validarPlan(Optional<Persona> persona, Plan plan){
        if (persona.get().getPerfils().size()+1>plan.getNumpefil()){
            return true;

        }
        return false;
    }
}
