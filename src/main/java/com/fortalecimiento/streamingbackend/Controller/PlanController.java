package com.fortalecimiento.streamingbackend.Controller;


import com.fortalecimiento.streamingbackend.DTO.Request.PlanRequest;
import com.fortalecimiento.streamingbackend.DTO.Response.PlanRespose;
import com.fortalecimiento.streamingbackend.Entity.Plan;
import com.fortalecimiento.streamingbackend.Service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("api/plan")
public class PlanController {

    @Autowired
    private PlanService planService;


    @GetMapping("/getAll")
    private ResponseEntity<List<PlanRespose>> listar (){
        return new ResponseEntity<List<PlanRespose>>(planService.getPlan(),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Boolean> save (@RequestBody PlanRequest planRequest){
        planService.savePlan(planRequest);
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }

    @PutMapping ("/update")
    public ResponseEntity<Boolean> update (@RequestBody PlanRequest planRequest){
        planService.savePlan(planRequest);
        return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PlanRespose> getById(@PathVariable Long id){
        return new ResponseEntity<PlanRespose>(planService.getPlanId(id),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        planService.deletePlan(id);
        return new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
    }


}
