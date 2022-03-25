package com.dtb.controller;

import com.dtb.domain.Plan;
import com.dtb.domain.PlanDto;
import com.dtb.exception.CategoryNotFoundException;
import com.dtb.exception.PlanNotFoundException;
import com.dtb.exception.UserNotFoundException;
import com.dtb.mapper.PlanMapper;
import com.dtb.service.PlanDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("v1")
public class PlanController {
    private final PlanDbService planDbService;
    private final PlanMapper planMapper;

    @GetMapping(value = "/plans")
    public List<PlanDto> getPlans() {
        List<Plan> plans = planDbService.getPlans();
        return planMapper.mapToPlanDtoList(plans);
    }

    @GetMapping(value = "/plans/{id}")
    public PlanDto getPlan(@PathVariable Long id) throws PlanNotFoundException {
        return planMapper.mapToPlanDto(
                planDbService.getPlan(id).orElseThrow(PlanNotFoundException::new)
        );
    }

    @DeleteMapping(value = "/plans/{id}")
    public void deletePlan(@PathVariable Long id) {
        planDbService.deletePlan(id);
    }

    @PostMapping(value = "/plans", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createPlan(@RequestBody PlanDto planDto) throws UserNotFoundException, CategoryNotFoundException {
        Plan plan = planMapper.mapToPlan(planDto);
        planDbService.savePlan(plan);
    }

    @PutMapping(value = "/plans")
    public PlanDto updatePlan(@RequestBody PlanDto planDto) throws UserNotFoundException, CategoryNotFoundException {
        Plan plan = planMapper.mapToPlan(planDto);
        Plan updatedPlan = planDbService.savePlan(plan);
        return planMapper.mapToPlanDto(updatedPlan);
    }

}
