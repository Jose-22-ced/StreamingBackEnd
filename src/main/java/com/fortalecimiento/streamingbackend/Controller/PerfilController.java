package com.fortalecimiento.streamingbackend.Controller;


import com.fortalecimiento.streamingbackend.DTO.Request.PerfilRequest;
import com.fortalecimiento.streamingbackend.DTO.Request.PersonaRequest;
import com.fortalecimiento.streamingbackend.DTO.Response.PerfilResponse;
import com.fortalecimiento.streamingbackend.DTO.Response.PersonaResonse;
import com.fortalecimiento.streamingbackend.Service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping("/getAll")
    private ResponseEntity<List<PerfilResponse>> listar (){
        return new ResponseEntity<List<PerfilResponse>>(perfilService.getPerfil(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Boolean> save (@RequestBody PerfilRequest perfilRequest){
        perfilService.savePerfil(perfilRequest);
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }

    @PutMapping ("/update")
    public ResponseEntity<Boolean> update (@RequestBody PerfilRequest perfilRequest){
        perfilService.savePerfil(perfilRequest);
        return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PerfilResponse> getById(@PathVariable Long id){
        return new ResponseEntity<PerfilResponse>(perfilService.getPerfilId(id),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        perfilService.deletePerfil(id);
        return new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
    }
}
