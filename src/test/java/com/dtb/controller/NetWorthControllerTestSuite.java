package com.dtb.controller;

import com.dtb.domain.*;
import com.dtb.facade.EntryFacade;
import com.dtb.facade.NetWorthFacade;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(NetWorthController.class)
class NetWorthControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NetWorthFacade netWorthFacade;

    @Test
    public void shouldGetEmptyListOfNetWorth() throws Exception {
        //Given
        when(netWorthFacade.getNetWorthReport()).thenReturn(List.of());

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/netWorth")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void shouldGetNetWorthList() throws Exception {
        // Given
        NetWorthDto netWorthDto = new NetWorthDto.NetWorthDtoBuilder()
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
                .userId(1L)
                .build();

        List<NetWorthDto> netWorthListDto = List.of(netWorthDto);

        //When
        when(netWorthFacade.getNetWorthReport()).thenReturn(netWorthListDto);

        //Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/netWorth")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].realEstate", Matchers.is(500000.0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].vehicles", Matchers.is(200000.0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].mortgage", Matchers.is(200000.0)));
    }

    @Test
    public void shouldDeleteNetWorth() throws Exception {
        //Given & When

        //Then
        mockMvc.
                perform(MockMvcRequestBuilders
                        .delete("/v1/netWorth/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void shouldUpdateNetWorth() throws Exception {
        // Given
        NetWorthDto netWorthDto = new NetWorthDto.NetWorthDtoBuilder()
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
                .totalAssets(1069000)
                .totalLiabilities(205000)
                .totalNetWorth(864000)
                .userId(1L)
                .build();

        when(netWorthFacade.updateNetWorthEntry(netWorthDto)).thenReturn(netWorthDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(netWorthDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/netWorth")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))

                .andExpect(MockMvcResultMatchers.jsonPath("$.realEstate", Matchers.is(500000.0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.vehicles", Matchers.is(200000.0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mortgage", Matchers.is(200000.0)));
    }

    @Test
    void shouldCreateEntry() throws Exception {
        // Given
        NetWorthDto netWorthDto = new NetWorthDto.NetWorthDtoBuilder()
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
                .totalAssets(1069000)
                .totalLiabilities(205000)
                .totalNetWorth(864000)
                .userId(1L)
                .build();

        Gson gson = new Gson();
        String jsonContent = gson.toJson(netWorthDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/netWorth")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}