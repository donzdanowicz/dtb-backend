package com.dtb.service;

import com.dtb.domain.Plan;
import com.dtb.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PlanDbService {
    private final PlanRepository planRepository;

    public List<Plan> getPlans() {
        return planRepository.findAll();
    }

    public Optional<Plan> getPlan(final Long id) {
        return planRepository.findById(id);
    }

    public Plan savePlan(final Plan plan) {
        return planRepository.save(plan);
    }

    public void deletePlan(final Long id) {
        planRepository.deleteById(id);
    }
}
