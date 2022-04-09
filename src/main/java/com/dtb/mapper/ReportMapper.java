package com.dtb.mapper;

import com.dtb.domain.Report;
import com.dtb.domain.ReportDto;
import com.dtb.exception.UserNotFoundException;
import com.dtb.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ReportMapper {
    private UserRepository userRepository;

    public Report mapToReport(final ReportDto reportDto) throws UserNotFoundException {
        return Report.builder()
                .id(reportDto.getId())
                .income(reportDto.getIncome())
                .food(reportDto.getFood())
                .housing(reportDto.getHousing())
                .transportation(reportDto.getTransportation())
                .healthcare(reportDto.getHealthcare())
                .personal(reportDto.getPersonal())
                .kids(reportDto.getKids())
                .entertainment(reportDto.getEntertainment())
                .miscellaneous(reportDto.getMiscellaneous())
                .travel(reportDto.getTravel())
                .debts(reportDto.getDebts())
                .savingAndInvesting(reportDto.getSavingAndInvesting())
                .type(reportDto.getType())
                .month(reportDto.getMonth())
                .year(reportDto.getYear())
                .user(userRepository.findById(reportDto.getUserId()).orElseThrow(UserNotFoundException::new))
                .build();
    }

    public ReportDto mapToReportDto(final Report report) {
        return ReportDto.builder()
                .id(report.getId())
                .income(report.getIncome())
                .food(report.getFood())
                .housing(report.getHousing())
                .transportation(report.getTransportation())
                .healthcare(report.getHealthcare())
                .personal(report.getPersonal())
                .kids(report.getKids())
                .entertainment(report.getEntertainment())
                .miscellaneous(report.getMiscellaneous())
                .travel(report.getTravel())
                .debts(report.getDebts())
                .savingAndInvesting(report.getSavingAndInvesting())
                .type(report.getType())
                .month(report.getMonth())
                .year(report.getYear())
                .userId(report.getUser().getId())
                .build();
    }

    public List<ReportDto> mapToReportDtoList(final List<Report> reports) {
        return reports.stream()
                .map(this::mapToReportDto)
                .collect(Collectors.toList());
    }
}
