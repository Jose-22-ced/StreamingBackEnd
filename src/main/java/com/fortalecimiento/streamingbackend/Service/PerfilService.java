package com.fortalecimiento.streamingbackend.Service;


import com.fortalecimiento.streamingbackend.DTO.Request.PerfilRequest;
import com.fortalecimiento.streamingbackend.DTO.Request.PlanRequest;
import com.fortalecimiento.streamingbackend.DTO.Response.PerfilResponse;
import com.fortalecimiento.streamingbackend.DTO.Response.PersonaResonse;
import com.fortalecimiento.streamingbackend.DTO.Response.PlanRespose;
import com.fortalecimiento.streamingbackend.Entity.Perfil;
import com.fortalecimiento.streamingbackend.Entity.Plan;
import com.fortalecimiento.streamingbackend.Exceptions.BadRequestException;
import com.fortalecimiento.streamingbackend.Repository.PerfilRepository;
import com.fortalecimiento.streamingbackend.Repository.PersonaRepository;
import com.fortalecimiento.streamingbackend.Validators.PerfilValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerfilService {

    @Autowired
    PerfilRepository perfilRepository;
    @Autowired
    PersonaRepository personaRepository;
    PerfilValidator perfilValidator = new PerfilValidator();

    /** Funcion que guarda un perfil.
     * @param: PerfilRequest
     * @return: ninguna
     * @author: José Cedeño <jose22ced@gmail.com>
     */
    @Transactional
    public void savePerfil(PerfilRequest perfilRequest){
        String mensaje  = perfilValidator.maxPerfiles(personaRepository.findById(perfilRequest.getIdpersona()));
        if(mensaje==null){
            Perfil perfil = new Perfil();
            perfil.setIdperfil(perfilRequest.getIdperfil());
            perfil.setNombre(perfilRequest.getNombre());
            perfil.setTipo(perfilRequest.getTipo());
            perfil.setUsua_creo(perfilRequest.getUsua_mod());
            perfil.setUsua_mod(perfilRequest.getUsua_mod());
            perfil.setFech_cre(perfilRequest.getFech_cre());
            perfil.setFech_mod(perfilRequest.getFech_mod());
            perfil.setPersona(personaRepository.findById(perfilRequest.getIdpersona()).get());
            perfilRepository.save(perfil);
        }else {
            throw new BadRequestException(mensaje);
        }

    }

    /** Funcion que lista todos lo perfeilies.
     * @param: ninguno
     * @return: List<PerfilResponse>
     * @author: José Cedeño <jose22ced@gmail.com>
     */
    @Transactional
    public List<PerfilResponse> getPerfil(){
        try {
            List<Perfil> perfils = perfilRepository.findAll();
            return perfils.stream().map(perfil1 -> {
                PerfilResponse perfilResponse = new PerfilResponse();
                perfilResponse.setIdperfil(perfil1.getIdperfil());
                perfilResponse.setNombre(perfil1.getNombre());
                perfilResponse.setTipo(perfil1.getTipo());
                perfilResponse.setUsua_creo(perfil1.getUsua_creo());
                perfilResponse.setUsua_mod(perfil1.getUsua_mod());
                perfilResponse.setFech_cre(perfil1.getFech_cre());
                perfilResponse.setFech_mod(perfil1.getFech_mod());
                perfilResponse.setPersona(new PersonaResonse(
                        perfil1.getPersona().getIdpersona(),
                        perfil1.getPersona().getCorreo(),
                        perfil1.getPersona().getClave(),
                        perfil1.getPersona().getUsua_creo(),
                        perfil1.getPersona().getUsua_mod(),
                        perfil1.getPersona().getFech_cre(),
                        perfil1.getPersona().getFech_mod(),
                        null,
                        null));
                return perfilResponse;
            }).collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }

    /** Funcion que busca una persona.
     * @param: Long id
     * @return: PerfilResponse
     * @author: José Cedeño <jose22ced@gmail.com>
     */
    @Transactional
    public PerfilResponse getPerfilId(Long id){
        try {
            Perfil perfils = perfilRepository.findById(id).get();
            PerfilResponse perfilResponse = new PerfilResponse();
            perfilResponse.setIdperfil(perfils.getIdperfil());
            perfilResponse.setNombre(perfils.getNombre());
            perfilResponse.setTipo(perfils.getTipo());
            perfilResponse.setUsua_creo(perfils.getUsua_creo());
            perfilResponse.setUsua_mod(perfils.getUsua_mod());
            perfilResponse.setFech_cre(perfils.getFech_cre());
            perfilResponse.setFech_mod(perfils.getFech_mod());
            perfilResponse.setPersona(new PersonaResonse(
                    perfils.getPersona().getIdpersona(),
                    perfils.getPersona().getCorreo(),
                    perfils.getPersona().getClave(),
                    perfils.getPersona().getUsua_creo(),
                    perfils.getPersona().getUsua_mod(),
                    perfils.getPersona().getFech_cre(),
                    perfils.getPersona().getFech_mod(),
                    null,
                    null));
            return perfilResponse;
        }catch (Exception e){
            return null;
        }
    }

    /** Funcion que elimina un perfil.
     * @param: Long id
     * @return: ninguna
     * @author: José Cedeño <jose22ced@gmail.com>
     */
    @Transactional
    public void deletePerfil(Long id){
        try {
            perfilRepository.deleteById(id);
        }catch (Exception e){

        }
    }
}
