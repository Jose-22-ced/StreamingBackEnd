package com.fortalecimiento.streamingbackend.Service;


import com.fortalecimiento.streamingbackend.DTO.Request.PersonaRequest;
import com.fortalecimiento.streamingbackend.DTO.Response.PerfilResponse;
import com.fortalecimiento.streamingbackend.DTO.Response.PersonaResonse;
import com.fortalecimiento.streamingbackend.DTO.Response.PlanRespose;
import com.fortalecimiento.streamingbackend.Entity.Persona;
import com.fortalecimiento.streamingbackend.Repository.PersonaRepository;
import com.fortalecimiento.streamingbackend.Repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private PlanRepository planRepository;


    /** Funcion que guarda a una persona.
     * @param: PersonaRequest
     * @return: ninguna
     * @author: José Cedeño <jose22ced@gmail.com>
    */
    @Transactional
    public void savePersona(PersonaRequest personaRequest) {
        try {
            Persona persona = new Persona();
            persona.setIdpersona(personaRequest.getIdpersona());
            persona.setCorreo(personaRequest.getCorreo());
            persona.setClave(personaRequest.getClave());
            persona.setUsua_creo(personaRequest.getUsua_creo());
            persona.setUsua_mod(personaRequest.getUsua_mod());
            persona.setFech_mod(personaRequest.getFech_mod());
            persona.setFech_cre(personaRequest.getFech_cre());
            persona.setPlan(planRepository.findById(personaRequest.getIdplan()).get());
            personaRepository.save(persona);
        } catch (Exception e) {

        }
    }

    /** Funcion que lista todas las personas.
     * @param: ninguna
     * @return: List<PersonaResonse>
     * @author: José Cedeño <jose22ced@gmail.com>
     */
    @Transactional
    public List<PersonaResonse> getPersona() {
        try {
            List<Persona> personas = personaRepository.findAll();
            return personas.stream().map(persona1 -> {
                PersonaResonse personaResonse = new PersonaResonse();
                personaResonse.setIdpersona(persona1.getIdpersona());
                personaResonse.setCorreo(persona1.getCorreo());
                personaResonse.setClave(persona1.getClave());
                personaResonse.setUsua_creo(persona1.getUsua_creo());
                personaResonse.setUsua_mod(persona1.getUsua_mod());
                personaResonse.setFech_cre(persona1.getFech_cre());
                personaResonse.setFech_mod(persona1.getFech_cre());
                personaResonse.setPerfils(persona1.getPerfils().stream().map(perfil1 -> {
                    PerfilResponse perfilResponse = new PerfilResponse();
                    perfilResponse.setIdperfil(perfil1.getIdperfil());
                    perfilResponse.setNombre(perfil1.getNombre());
                    perfilResponse.setTipo(perfil1.getTipo());
                    perfilResponse.setUsua_creo(perfil1.getUsua_creo());
                    perfilResponse.setUsua_mod(perfil1.getUsua_mod());
                    perfilResponse.setFech_cre(perfil1.getFech_cre());
                    perfilResponse.setFech_mod(perfil1.getFech_mod());
                    return perfilResponse;
                }).collect(Collectors.toList()));
                personaResonse.setPlan(
                        new PlanRespose(
                                persona1.getPlan().getIdplan(),
                                persona1.getPlan().getTipo(),
                                persona1.getPlan().getNumpefil(),
                                persona1.getPlan().getUsua_creo(),
                                persona1.getPlan().getUsua_mod(),
                                persona1.getPlan().getFech_cre(),
                                persona1.getPlan().getFech_cre(),
                                null));
                return personaResonse;
            }).collect(Collectors.toList());
        } catch (Exception e) {
            return null;
        }
    }

    /** Funcion que busca a una persona.
     * @param: Long id
     * @return: PersonaResonse
     * @author: José Cedeño <jose22ced@gmail.com>
     */
    @Transactional
    public PersonaResonse getPersonaId(Long id) {
        try {
            Persona personas = personaRepository.findById(id).get();
            PersonaResonse personaResonse = new PersonaResonse();
            personaResonse.setIdpersona(personas.getIdpersona());
            personaResonse.setCorreo(personas.getCorreo());
            personaResonse.setClave(personas.getClave());
            personaResonse.setUsua_creo(personas.getUsua_creo());
            personaResonse.setUsua_mod(personas.getUsua_mod());
            personaResonse.setFech_cre(personas.getFech_cre());
            personaResonse.setFech_mod(personas.getFech_cre());
            personaResonse.setPerfils(personas.getPerfils().stream().map(perfil1 -> {
                PerfilResponse perfilResponse = new PerfilResponse();
                perfilResponse.setIdperfil(perfil1.getIdperfil());
                perfilResponse.setNombre(perfil1.getNombre());
                perfilResponse.setTipo(perfil1.getTipo());
                perfilResponse.setUsua_creo(perfil1.getUsua_creo());
                perfilResponse.setUsua_mod(perfil1.getUsua_mod());
                perfilResponse.setFech_cre(perfil1.getFech_cre());
                perfilResponse.setFech_mod(perfil1.getFech_mod());
                return perfilResponse;
            }).collect(Collectors.toList()));
            personaResonse.setPlan(
                    new PlanRespose(
                            personas.getPlan().getIdplan(),
                            personas.getPlan().getTipo(),
                            personas.getPlan().getNumpefil(),
                            personas.getPlan().getUsua_creo(),
                            personas.getPlan().getUsua_mod(),
                            personas.getPlan().getFech_cre(),
                            personas.getPlan().getFech_cre(),
                            null));
            return personaResonse;
        } catch (Exception e) {
            return null;
        }
    }

    /** Funcion que elimina a una persona.
     * @param: Long id
     * @return: ninguno
     * @author: José Cedeño <jose22ced@gmail.com>
     */
    @Transactional
    public void deletePersona(Long id) {
        try {
            personaRepository.deleteById(id);
        } catch (Exception e) {

        }
    }
}
