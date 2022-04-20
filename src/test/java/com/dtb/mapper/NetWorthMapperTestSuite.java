package com.dtb.mapper;

import com.dtb.domain.*;
import com.dtb.exception.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class NetWorthMapperTestSuite {

    @Autowired
    private NetWorthMapper netWorthMapper;

    @Test
    public void shouldMapToNetWorth() throws UserNotFoundException {
        //Given
        NetWorthDto netWorthDto = new NetWorthDto.NetWorthDtoBuilder()
                .id(1L)
                .realEstate(400000)
                .cash(25000)
                .vehicles(150000)
                .savingsAndInvestments(50000)
                .foreignCurrencies(50000)
                .stocks(20000)
                .collections(5000)
                .homeContent(10000)
                .otherAssets(30000)
                .mortgage(220000)
                .loans(0)
                .creditCards(3000)
                .otherLiabilities(500)
                .date(LocalDate.of(2022,4,3))
                .userId(1L)
                .build();

        netWorthDto.setTotalAssets(netWorthDto.calculateTotalAssets());
        netWorthDto.setTotalLiabilities(netWorthDto.calculateTotalLiabilities());
        netWorthDto.setTotalNetWorth(netWorthDto.calculateTotalNetWorth());

        //When
        NetWorth netWorth = netWorthMapper.mapToNetWorth(netWorthDto);

        //Then
        assertEquals(1L, netWorth.getId());
        assertEquals(400000, netWorth.getRealEstate());
        assertEquals(25000, netWorth.getCash());
        assertEquals(150000, netWorth.getVehicles());
        assertEquals(50000, netWorth.getSavingsAndInvestments());
        assertEquals(50000, netWorth.getForeignCurrencies());
        assertEquals(20000, netWorth.getStocks());
        assertEquals(5000, netWorth.getCollections());
        assertEquals(10000, netWorth.getHomeContent());
        assertEquals(30000, netWorth.getOtherAssets());
        assertEquals(220000, netWorth.getMortgage());
        assertEquals(0, netWorth.getLoans());
        assertEquals(3000, netWorth.getCreditCards());
        assertEquals(500, netWorth.getOtherLiabilities());
        assertEquals(LocalDate.of(2022, 4, 3), netWorth.getDate());
        assertEquals(740000, netWorth.getTotalAssets());
        assertEquals(223500, netWorth.getTotalLiabilities());
        assertEquals(516500, netWorth.getTotalNetWorth());
        assertEquals(1L, netWorth.getUser().getId());
    }

    @Test
    public void shouldMapToNetWorthDto() throws UserNotFoundException {
        //Given
        User user = new User(1L, "John", "Shoggoth",
                LocalDateTime.of(2022,3,22,12,33,0), "PLN", false);

        NetWorth netWorth = new NetWorth.NetWorthBuilder()
                .id(1L)
                .realEstate(400000)
                .cash(25000)
                .vehicles(150000)
                .savingsAndInvestments(50000)
                .foreignCurrencies(50000)
                .stocks(20000)
                .collections(5000)
                .homeContent(10000)
                .otherAssets(30000)
                .mortgage(220000)
                .loans(0)
                .creditCards(3000)
                .otherLiabilities(500)
                .date(LocalDate.of(2022,4,3))
                .user(user)
                .build();

        netWorth.setTotalAssets(netWorth.calculateTotalAssets());
        netWorth.setTotalLiabilities(netWorth.calculateTotalLiabilities());
        netWorth.setTotalNetWorth(netWorth.calculateTotalNetWorth());

        //When
        NetWorthDto netWorthDto = netWorthMapper.mapToNetWorthDto(netWorth);

        //Then
        assertEquals(1L, netWorthDto.getId());
        assertEquals(400000, netWorthDto.getRealEstate());
        assertEquals(25000, netWorthDto.getCash());
        assertEquals(150000, netWorthDto.getVehicles());
        assertEquals(50000, netWorthDto.getSavingsAndInvestments());
        assertEquals(50000, netWorthDto.getForeignCurrencies());
        assertEquals(20000, netWorthDto.getStocks());
        assertEquals(5000, netWorthDto.getCollections());
        assertEquals(10000, netWorthDto.getHomeContent());
        assertEquals(30000, netWorthDto.getOtherAssets());
        assertEquals(220000, netWorthDto.getMortgage());
        assertEquals(0, netWorthDto.getLoans());
        assertEquals(3000, netWorthDto.getCreditCards());
        assertEquals(500, netWorthDto.getOtherLiabilities());
        assertEquals(LocalDate.of(2022, 4, 3), netWorthDto.getDate());
        assertEquals(740000, netWorthDto.getTotalAssets());
        assertEquals(223500, netWorthDto.getTotalLiabilities());
        assertEquals(516500, netWorthDto.getTotalNetWorth());
        assertEquals(1L, netWorthDto.getUserId());
    }

    @Test
    public void shouldMapToEntryDtoList() {
        //Given
        List<NetWorth> netWorthList = new ArrayList<>();

        User user = new User(1L, "John", "Shoggoth",
                LocalDateTime.of(2022,3,22,12,33,0), "PLN", false);

        NetWorth netWorth1 = new NetWorth.NetWorthBuilder()
                .id(1L)
                .realEstate(400000)
                .cash(25000)
                .vehicles(150000)
                .savingsAndInvestments(50000)
                .foreignCurrencies(50000)
                .stocks(20000)
                .collections(5000)
                .homeContent(10000)
                .otherAssets(30000)
                .mortgage(220000)
                .loans(0)
                .creditCards(3000)
                .otherLiabilities(500)
                .date(LocalDate.of(2022,3,3))
                .user(user)
                .build();

        netWorth1.setTotalAssets(netWorth1.calculateTotalAssets());
        netWorth1.setTotalLiabilities(netWorth1.calculateTotalLiabilities());
        netWorth1.setTotalNetWorth(netWorth1.calculateTotalNetWorth());

        NetWorth netWorth2 = new NetWorth.NetWorthBuilder()
                .id(2L)
                .realEstate(410000)
                .cash(27000)
                .vehicles(160000)
                .savingsAndInvestments(54000)
                .foreignCurrencies(52000)
                .stocks(24000)
                .collections(6000)
                .homeContent(10000)
                .otherAssets(30000)
                .mortgage(205000)
                .loans(0)
                .creditCards(2000)
                .otherLiabilities(0)
                .date(LocalDate.of(2022,4,3))
                .user(user)
                .build();

        netWorth2.setTotalAssets(netWorth2.calculateTotalAssets());
        netWorth2.setTotalLiabilities(netWorth2.calculateTotalLiabilities());
        netWorth2.setTotalNetWorth(netWorth2.calculateTotalNetWorth());


        netWorthList.add(netWorth1);
        netWorthList.add(netWorth2);

        //When
        List<NetWorthDto> netWorthDtoList = netWorthMapper.mapToNetWorthDtoList(netWorthList);

        //Then
        assertEquals(2, netWorthDtoList.size());
        assertEquals(1L, netWorthDtoList.get(0).getId());
        assertEquals(400000, netWorthDtoList.get(0).getRealEstate());
        assertEquals(25000, netWorthDtoList.get(0).getCash());
        assertEquals(150000, netWorthDtoList.get(0).getVehicles());
        assertEquals(50000, netWorthDtoList.get(0).getSavingsAndInvestments());
        assertEquals(50000, netWorthDtoList.get(0).getForeignCurrencies());
        assertEquals(20000, netWorthDtoList.get(0).getStocks());
        assertEquals(5000, netWorthDtoList.get(0).getCollections());
        assertEquals(10000, netWorthDtoList.get(1).getHomeContent());
        assertEquals(30000, netWorthDtoList.get(1).getOtherAssets());
        assertEquals(205000, netWorthDtoList.get(1).getMortgage());
        assertEquals(0, netWorthDtoList.get(1).getLoans());
        assertEquals(2000, netWorthDtoList.get(1).getCreditCards());
        assertEquals(0, netWorthDtoList.get(1).getOtherLiabilities());
        assertEquals(LocalDate.of(2022, 4, 3), netWorthDtoList.get(1).getDate());
        assertEquals(773000, netWorthDtoList.get(1).getTotalAssets());
        assertEquals(207000, netWorthDtoList.get(1).getTotalLiabilities());
        assertEquals(566000, netWorthDtoList.get(1).getTotalNetWorth());
        assertEquals(1L, netWorthDtoList.get(1).getUserId());

    }



}

