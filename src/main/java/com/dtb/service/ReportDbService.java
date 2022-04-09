package com.dtb.service;

import com.dtb.domain.Report;
import com.dtb.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReportDbService {
    private final ReportRepository reportRepository;

    /*public List<Report> getPlans() {
        return reportRepository.findAll();
    }

    public Optional<Report> getPlan(final Long id) {
        return reportRepository.findById(id);
    }

    public Report savePlan(final Report report) {
        return reportRepository.save(report);
    }

    public void deletePlan(final Long id) {
        reportRepository.deleteById(id);
    }*/

    public List<Report> report() {
        return reportRepository.report();
    }
}
