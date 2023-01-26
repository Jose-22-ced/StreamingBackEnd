package com.fortalecimiento.streamingbackend.Service;


import com.fortalecimiento.streamingbackend.DTO.Request.PlanRequest;
import com.fortalecimiento.streamingbackend.DTO.Response.PersonaResonse;
import com.fortalecimiento.streamingbackend.DTO.Response.PlanRespose;
import com.fortalecimiento.streamingbackend.Entity.Plan;
import com.fortalecimiento.streamingbackend.Repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    /** Funcion que guarda un plan.
     * @param: PlanRequest
     * @return: ninguno
     * @author: José Cedeño <jose22ced@gmail.com>
     */
    @Transactional
    public void savePlan(PlanRequest planRequest){
        try {
            Plan plan = new Plan();
            plan.setTipo(planRequest.getTipo());
            plan.setIdplan(planRequest.getIdplan());
            plan.setNumpefil(planRequest.getNumpefil());
            plan.setFech_cre(planRequest.getFech_cre());
            plan.setFech_mod(planRequest.getFech_mod());
            plan.setUsua_creo(planRequest.getUsua_creo());
            plan.setUsua_mod(planRequest.getUsua_mod());
            planRepository.save(plan);
        }catch (Exception e){

        }
    }

    /** Funcion que lista todos los planes.
     * @param: ninguno
     * @return: List<PlanRespose>
     * @author: José Cedeño <jose22ced@gmail.com>
     */
    @Transactional
    public List<PlanRespose> getPlan(){
        try {
            List<Plan> plan = planRepository.findAll();
            return plan.stream().map(plan1 -> {
                PlanRespose planRespose = new PlanRespose();
                planRespose.setIdplan(plan1.getIdplan());
                planRespose.setTipo(plan1.getTipo());
                planRespose.setNumpefil(plan1.getNumpefil());
                planRespose.setUsua_creo(plan1.getUsua_creo());
                planRespose.setUsua_mod(plan1.getUsua_mod());
                planRespose.setFech_cre(plan1.getFech_cre());
                planRespose.setFech_mod(plan1.getFech_mod());
                return planRespose;
            }).collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }

    /** Funcion que busca un plan.
     * @param: Long id
     * @return: PlanRespose
     * @author: José Cedeño <jose22ced@gmail.com>
     */
    @Transactional
    public PlanRespose getPlanId(Long id){
        try {
            Plan plan = planRepository.findById(id).get();
            PlanRespose planRespose = new PlanRespose();
            planRespose.setIdplan(plan.getIdplan());
            planRespose.setTipo(plan.getTipo());
            planRespose.setNumpefil(plan.getNumpefil());
            planRespose.setUsua_creo(plan.getUsua_creo());
            planRespose.setUsua_mod(plan.getUsua_mod());
            planRespose.setFech_cre(plan.getFech_cre());
            planRespose.setFech_mod(plan.getFech_mod());
            return planRespose;
        }catch (Exception e){
         return null;
        }
    }

    /** Funcion que elimina un plan.
     * @param: Long id
     * @return: ninguno
     * @author: José Cedeño <jose22ced@gmail.com>
     */
    @Transactional
    public void deletePlan(Long id){
        try {
            planRepository.deleteById(id);
        }catch (Exception e){

        }
    }
}
