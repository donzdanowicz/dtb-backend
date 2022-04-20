package com.dtb.service;

import com.dtb.domain.EntryAud;
import com.dtb.domain.EntryType;
import com.dtb.domain.NetWorthAud;
import com.dtb.repository.EntryAudRepository;
import com.dtb.repository.NetWorthAudRepository;
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
class NetWorthAudDbServiceTestSuite {

    @InjectMocks
    NetWorthAudDbService netWorthAudDbService;

    @Mock
    NetWorthAudRepository netWorthAudRepository;

    @Test
    void saveNetWorthAud() {
        //Given
        NetWorthAud netWorthAud = NetWorthAud.builder()
                .eventDate(LocalDate.now())
                .eventType("INSERT")
                .netWorthId(1L)
                .newRealEstate(500000)
                .newCash(40000)
                .newVehicles(200000)
                .newSavingsAndInvestments(200000)
                .newForeignCurrencies(50000)
                .newStocks(30000)
                .newCollections(19000)
                .newHomeContent(10000)
                .newOtherAssets(20000)
                .newMortgage(200000)
                .newLoans(0)
                .newCreditCards(4000)
                .newOtherLiabilities(1000)
                .newDate(LocalDate.of(2022,4,2))
                .newTotalAssets(1069000)
                .newTotalLiabilities(205000)
                .newTotalNetWorth(864000)
                .newUserId(1L)
                .build();

        when(netWorthAudRepository.findById(1L)).thenReturn(Optional.of(netWorthAud));

        //When
        netWorthAudDbService.saveNetWorthAud(netWorthAud);

        //Then
        assertEquals("INSERT", netWorthAudRepository.findById(1L).get().getEventType());
        assertEquals(1L, netWorthAudRepository.findById(1L).get().getNetWorthId());
        assertEquals(500000, netWorthAudRepository.findById(1L).get().getNewRealEstate());
        assertEquals(40000, netWorthAudRepository.findById(1L).get().getNewCash());
        assertEquals(200000, netWorthAudRepository.findById(1L).get().getNewVehicles());
        assertEquals(200000, netWorthAudRepository.findById(1L).get().getNewSavingsAndInvestments());
        assertEquals(50000, netWorthAudRepository.findById(1L).get().getNewForeignCurrencies());
        assertEquals(30000, netWorthAudRepository.findById(1L).get().getNewStocks());
        assertEquals(19000, netWorthAudRepository.findById(1L).get().getNewCollections());
        assertEquals(10000, netWorthAudRepository.findById(1L).get().getNewHomeContent());
        assertEquals(20000, netWorthAudRepository.findById(1L).get().getNewOtherAssets());
        assertEquals(200000, netWorthAudRepository.findById(1L).get().getNewMortgage());
        assertEquals(0, netWorthAudRepository.findById(1L).get().getNewLoans());
        assertEquals(4000, netWorthAudRepository.findById(1L).get().getNewCreditCards());
        assertEquals(1000, netWorthAudRepository.findById(1L).get().getNewOtherLiabilities());
        assertEquals(LocalDate.of(2022, 4, 2), netWorthAudRepository.findById(1L).get().getNewDate());
        assertEquals(1069000, netWorthAudRepository.findById(1L).get().getNewTotalAssets());
        assertEquals(205000, netWorthAudRepository.findById(1L).get().getNewTotalLiabilities());
        assertEquals(864000, netWorthAudRepository.findById(1L).get().getNewTotalNetWorth());
        assertEquals(1L, netWorthAudRepository.findById(1L).get().getNewUserId());
    }
}
