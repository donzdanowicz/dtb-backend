package com.dtb.service;

import com.dtb.domain.EntryAud;
import com.dtb.domain.EntryType;
import com.dtb.domain.ReportAud;
import com.dtb.repository.EntryAudRepository;
import com.dtb.repository.ReportAudRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReportAudDbServiceTestSuite {

    @InjectMocks
    ReportAudDbService reportAudDbService;

    @Mock
    ReportAudRepository reportAudRepository;

    @Test
    void saveReportAud() {
        //Given

        ReportAud reportAud = ReportAud.builder()
                .eventDate(LocalDate.now())
                .income(10000)
                .food(700)
                .housing(1000)
                .transportation(300)
                .healthcare(400)
                .personal(400)
                .kids(800)
                .entertainment(200)
                .miscellaneous(500)
                .travel(1000)
                .debts(0)
                .savingAndInvesting(5000)
                .type(EntryType.PLAN)
                .fromDate(LocalDate.of(2022,4,1))
                .toDate(LocalDate.of(2022,4,30))
                .userId(1L)
                .build();

        when(reportAudRepository.findById(1L)).thenReturn(Optional.of(reportAud));

        //When
        reportAudDbService.saveReportAud(reportAud);

        //Then
        assertEquals(10000, reportAudRepository.findById(1L).get().getIncome());
        assertEquals(700, reportAudRepository.findById(1L).get().getFood());
        assertEquals(1000, reportAudRepository.findById(1L).get().getHousing());
        assertEquals(300, reportAudRepository.findById(1L).get().getTransportation());
        assertEquals(400, reportAudRepository.findById(1L).get().getHealthcare());
        assertEquals(400, reportAudRepository.findById(1L).get().getPersonal());
        assertEquals(800, reportAudRepository.findById(1L).get().getKids());
        assertEquals(200, reportAudRepository.findById(1L).get().getEntertainment());
        assertEquals(500, reportAudRepository.findById(1L).get().getMiscellaneous());
        assertEquals(1000, reportAudRepository.findById(1L).get().getTravel());
        assertEquals(0, reportAudRepository.findById(1L).get().getDebts());
        assertEquals(5000, reportAudRepository.findById(1L).get().getSavingAndInvesting());
        assertEquals(EntryType.PLAN, reportAudRepository.findById(1L).get().getType());
        assertEquals(LocalDate.of(2022, 4, 1), reportAudRepository.findById(1L).get().getFromDate());
        assertEquals(LocalDate.of(2022, 4, 30), reportAudRepository.findById(1L).get().getToDate());
        assertEquals(1L, reportAudRepository.findById(1L).get().getUserId());
    }
}
