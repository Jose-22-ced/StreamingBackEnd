package com.fortalecimiento.streamingbackend.Repository;

import com.fortalecimiento.streamingbackend.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
}
