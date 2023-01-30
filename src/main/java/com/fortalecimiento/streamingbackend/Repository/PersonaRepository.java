package com.fortalecimiento.streamingbackend.Repository;

import com.fortalecimiento.streamingbackend.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
    Optional<Persona> findByCorreo(String correo);
}
