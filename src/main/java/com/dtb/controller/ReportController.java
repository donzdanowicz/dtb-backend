package com.dtb.controller;

import com.dtb.domain.Entry;
import com.dtb.domain.EntryDto;
import com.dtb.domain.Report;
import com.dtb.domain.ReportDto;
import com.dtb.exception.ReportNotFoundException;
import com.dtb.exception.UserNotFoundException;
import com.dtb.mapper.ReportMapper;
import com.dtb.service.ReportDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/v1")
public class ReportController {
    private final ReportDbService reportDbService;
    private final ReportMapper reportMapper;

    /*@GetMapping(value = "/plans")
    public List<ReportDto> getPlans() {
        List<Report> reports = reportDbService.getPlans();
        return reportMapper.mapToPlanDtoList(reports);
    }

    @GetMapping(value = "/plans/{id}")
    public ReportDto getPlan(@PathVariable Long id) throws ReportNotFoundException {
        return reportMapper.mapToPlanDto(
                reportDbService.getPlan(id).orElseThrow(ReportNotFoundException::new)
        );
    }

    @DeleteMapping(value = "/plans/{id}")
    public void deletePlan(@PathVariable Long id) {
        reportDbService.deletePlan(id);
    }

    @PostMapping(value = "/plans", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createPlan(@RequestBody ReportDto reportDto) throws UserNotFoundException {
        Report report = reportMapper.mapToPlan(reportDto);
        reportDbService.savePlan(report);
    }

    @PutMapping(value = "/plans")
    public ReportDto updatePlan(@RequestBody ReportDto reportDto) throws UserNotFoundException {
        Report report = reportMapper.mapToPlan(reportDto);
        Report updatedReport = reportDbService.savePlan(report);
        return reportMapper.mapToPlanDto(updatedReport);
    }*/

    @GetMapping(value = "/report")
    public List<ReportDto> report() {
        List<Report> report = reportDbService.report();
        return reportMapper.mapToReportDtoList(report);
    }

}
