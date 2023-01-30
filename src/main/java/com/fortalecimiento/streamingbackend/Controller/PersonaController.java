package com.fortalecimiento.streamingbackend.Controller;


import com.fortalecimiento.streamingbackend.DTO.Request.PersonaRequest;
import com.fortalecimiento.streamingbackend.DTO.Request.SignUpRequest;
import com.fortalecimiento.streamingbackend.DTO.Response.PersonaResponse;
import com.fortalecimiento.streamingbackend.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("api/persona")
public class PersonaController {

    @Autowired
    private PersonService personService;


    @GetMapping("/getAll")
    private ResponseEntity<List<PersonaResponse>> listar (){
        return new ResponseEntity<List<PersonaResponse>>(personService.getPersona(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Boolean> save (@RequestBody PersonaRequest personaRequest){
        personService.savePersona(personaRequest);
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }

    @PutMapping ("/update")
    public ResponseEntity<Boolean> update (@RequestBody PersonaRequest personaRequest){
        personService.updatePersona(personaRequest);
        return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PersonaResponse> getById(@PathVariable Long id){
        return new ResponseEntity<PersonaResponse>(personService.getPersonaId(id),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        personService.deletePersona(id);
        return new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
    }

    @PostMapping("/signup")
    public ResponseEntity<PersonaResponse> signUp(@RequestBody SignUpRequest signUpRequest){
        return new ResponseEntity<PersonaResponse>(personService.signUpUsuario(signUpRequest),HttpStatus.ACCEPTED);
    }

}
