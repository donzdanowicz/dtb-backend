package com.dtb.service;

import com.dtb.domain.*;
import com.dtb.repository.NetWorthAudRepository;
import com.dtb.repository.NetWorthRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NetWorthDbServiceTestSuite {

    @InjectMocks
    NetWorthDbService netWorthDbService;

    @Mock
    NetWorthRepository netWorthRepository;

    @Test
    void getNetWorthList() {
        //Given
        List<NetWorth> netWorthList = new ArrayList<>();

        NetWorth netWorth1 = new NetWorth.NetWorthBuilder()
                .id(1L)
                .realEstate(500000)
                .cash(40000)
                .vehicles(200000)
                .savingsAndInvestments(200000)
                .foreignCurrencies(50000)
                .stocks(30000)
                .collections(19000)
                .homeContent(10000)
                .otherAssets(20000)
                .mortgage(200000)
                .loans(0)
                .creditCards(4000)
                .otherLiabilities(1000)
                .date(LocalDate.of(2022,4,2))
                .totalAssets(1069000)
                .totalLiabilities(205000)
                .totalNetWorth(864000)
                .user(new User())
                .build();

        NetWorth netWorth2 = new NetWorth.NetWorthBuilder()
                .id(2L)
                .realEstate(500000)
                .cash(40000)
                .vehicles(200000)
                .savingsAndInvestments(200000)
                .foreignCurrencies(50000)
                .stocks(30000)
                .collections(19000)
                .homeContent(10000)
                .otherAssets(20000)
                .mortgage(200000)
                .loans(0)
                .creditCards(4000)
                .otherLiabilities(1000)
                .date(LocalDate.of(2022,3,2))
                .totalAssets(1069000)
                .totalLiabilities(205000)
                .totalNetWorth(864000)
                .user(new User())
                .build();

        netWorthList.add(netWorth1);
        netWorthList.add(netWorth2);

        when(netWorthRepository.findAll()).thenReturn(netWorthList);

        //When
        List<NetWorth> result = netWorthDbService.getNetWorthReport();

        //Then
        assertEquals(2, result.size());
    }

    @Test
    void getNetWorth() {
        //Given
        NetWorth netWorth = new NetWorth.NetWorthBuilder()
                .id(1L)
                .realEstate(500000)
                .cash(40000)
                .vehicles(200000)
                .savingsAndInvestments(200000)
                .foreignCurrencies(50000)
                .stocks(30000)
                .collections(19000)
                .homeContent(10000)
                .otherAssets(20000)
                .mortgage(200000)
                .loans(0)
                .creditCards(4000)
                .otherLiabilities(1000)
                .date(LocalDate.of(2022,4,2))
                .totalAssets(1069000)
                .totalLiabilities(205000)
                .totalNetWorth(864000)
                .user(new User())
                .build();

        when(netWorthRepository.findById(1L)).thenReturn(Optional.of(netWorth));

        //When
        Optional<NetWorth> result = netWorthDbService.getNetWorthEntry(1L);

        //Then
        assertEquals(Optional.of(netWorth), netWorthDbService.getNetWorthEntry(1L));
    }

    @Test
    void deleteNetWorth() {
        //Given
        NetWorth netWorth = new NetWorth.NetWorthBuilder()
                .id(1L)
                .realEstate(500000)
                .cash(40000)
                .vehicles(200000)
                .savingsAndInvestments(200000)
                .foreignCurrencies(50000)
                .stocks(30000)
                .collections(19000)
                .homeContent(10000)
                .otherAssets(20000)
                .mortgage(200000)
                .loans(0)
                .creditCards(4000)
                .otherLiabilities(1000)
                .date(LocalDate.of(2022,4,2))
                .totalAssets(1069000)
                .totalLiabilities(205000)
                .totalNetWorth(864000)
                .user(new User())
                .build();

        //When
        netWorthDbService.deleteNetWorthEntry(1L);

        //Then
        assertEquals(Optional.empty(), netWorthDbService.getNetWorthEntry(1L));
    }

    @Test
    void saveNetWorth() {
        //Given
        NetWorth netWorth = new NetWorth.NetWorthBuilder()
                .id(1L)
                .realEstate(500000)
                .cash(40000)
                .vehicles(200000)
                .savingsAndInvestments(200000)
                .foreignCurrencies(50000)
                .stocks(30000)
                .collections(19000)
                .homeContent(10000)
                .otherAssets(20000)
                .mortgage(200000)
                .loans(0)
                .creditCards(4000)
                .otherLiabilities(1000)
                .date(LocalDate.of(2022,4,2))
                .totalAssets(1069000)
                .totalLiabilities(205000)
                .totalNetWorth(864000)
                .user(new User())
                .build();

        when(netWorthRepository.findById(1L)).thenReturn(Optional.of(netWorth));

        //When
        netWorthDbService.saveNetWorthEntry(netWorth);

        //Then
        assertEquals(1L, netWorthRepository.findById(1L).get().getId());
        assertEquals(500000, netWorthRepository.findById(1L).get().getRealEstate());
        assertEquals(40000, netWorthRepository.findById(1L).get().getCash());
        assertEquals(200000, netWorthRepository.findById(1L).get().getVehicles());
        assertEquals(200000, netWorthRepository.findById(1L).get().getSavingsAndInvestments());
        assertEquals(50000, netWorthRepository.findById(1L).get().getForeignCurrencies());
        assertEquals(30000, netWorthRepository.findById(1L).get().getStocks());
        assertEquals(19000, netWorthRepository.findById(1L).get().getCollections());
        assertEquals(10000, netWorthRepository.findById(1L).get().getHomeContent());
        assertEquals(20000, netWorthRepository.findById(1L).get().getOtherAssets());
        assertEquals(200000, netWorthRepository.findById(1L).get().getMortgage());
        assertEquals(0, netWorthRepository.findById(1L).get().getLoans());
        assertEquals(4000, netWorthRepository.findById(1L).get().getCreditCards());
        assertEquals(1000, netWorthRepository.findById(1L).get().getOtherLiabilities());
        assertEquals(LocalDate.of(2022, 4, 2), netWorthRepository.findById(1L).get().getDate());
        assertEquals(1069000, netWorthRepository.findById(1L).get().getTotalAssets());
        assertEquals(205000, netWorthRepository.findById(1L).get().getTotalLiabilities());
        assertEquals(864000, netWorthRepository.findById(1L).get().getTotalNetWorth());
    }
}
