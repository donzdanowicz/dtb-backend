package com.dtb.controller;

import com.dtb.domain.*;
import com.dtb.facade.CurrencyFacade;
import com.dtb.facade.EntryFacade;
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
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(EntryController.class)
class EntryControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EntryFacade entryFacade;

    @Test
    public void shouldGetEmptyListOfEntries() throws Exception {
        //Given
        when(entryFacade.getEntries()).thenReturn(List.of());

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/entries")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void shouldGetEntries() throws Exception {
        // Given
        EntryDto entryDto = new EntryDto.EntryDtoBuilder()
                .id(1L)
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
                .date(LocalDate.of(2022, 4, 3))
                .userId(1L)
                .build();

        List<EntryDto> entriesDto = List.of(entryDto);

        //When
        when(entryFacade.getEntries()).thenReturn(entriesDto);

        //Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/entries")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].income", Matchers.is(10000.0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].personal", Matchers.is(400.0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].travel", Matchers.is(1000.0)));
    }

    @Test
    public void shouldDeleteEntry() throws Exception {
        //Given & When

        //Then
        mockMvc.
                perform(MockMvcRequestBuilders
                        .delete("/v1/entries/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void shouldUpdateEntry() throws Exception {
        // Given
        EntryDto entryDto = new EntryDto.EntryDtoBuilder()
                .id(1L)
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
                .userId(1L)
                .build();

        when(entryFacade.updateEntry(entryDto)).thenReturn(entryDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(entryDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/entries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.jsonPath("$.income", Matchers.is(10000.0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.personal", Matchers.is(400.0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.travel", Matchers.is(1000.0)));
    }

    @Test
    void shouldCreateEntry() throws Exception {
        // Given
        EntryDto entryDto = new EntryDto.EntryDtoBuilder()
                .id(1L)
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
                .userId(1L)
                .build();

        Gson gson = new Gson();
        String jsonContent = gson.toJson(entryDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/entries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}