package com.dtb.service;

import com.dtb.domain.EntryAud;
import com.dtb.domain.ReportAud;
import com.dtb.repository.EntryAudRepository;
import com.dtb.repository.ReportAudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReportAudDbService {
    private final ReportAudRepository reportAudRepository;

    public ReportAud saveReportAud(final ReportAud reportAud) {
        return reportAudRepository.save(reportAud);
    }
}
