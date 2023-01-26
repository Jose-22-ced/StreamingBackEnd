package com.fortalecimiento.streamingbackend.Repository;

import com.fortalecimiento.streamingbackend.Entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
