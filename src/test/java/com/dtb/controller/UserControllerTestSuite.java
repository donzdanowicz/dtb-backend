package com.dtb.controller;

import com.dtb.domain.CurrencyDto;
import com.dtb.domain.User;
import com.dtb.domain.UserDto;
import com.dtb.facade.CurrencyFacade;
import com.dtb.facade.UserFacade;
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

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(UserController.class)
class UserControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserFacade userFacade;

    @Test
    public void shouldGetEmptyListOfUsers() throws Exception {
        //Given
        when(userFacade.getUsers()).thenReturn(List.of());

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void shouldGetUsers() throws Exception {
        // Given
        UserDto userDto = new UserDto(1L, "John", "Shoggoth",
                LocalDateTime.of(2022,1,1,12,30,0), "PLN", false);

        List<UserDto> usersDto = List.of(userDto);

        //When
        when(userFacade.getUsers()).thenReturn(usersDto);

        //Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName", Matchers.is("John")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].lastName", Matchers.is("Shoggoth")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].currency", Matchers.is("PLN")));
    }

    @Test
    public void shouldDeleteUser() throws Exception {
        //Given & When

        //Then
        mockMvc.
                perform(MockMvcRequestBuilders
                        .delete("/v1/users/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void shouldUpdateUser() throws Exception {
        // Given
        UserDto userDto = UserDto.builder()
                .id(1L)
                .firstName("John")
                .lastName("Shoggoth")
                .currency("PLN")
                .active(false)
                .build();

        when(userFacade.updateUser(userDto)).thenReturn(userDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(userDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is("John")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", Matchers.is("Shoggoth")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency", Matchers.is("PLN")));
    }

    @Test
    void shouldCreateUser() throws Exception {
        // Given
        UserDto userDto = UserDto.builder()
                .id(1L)
                .firstName("John")
                .lastName("Shoggoth")
                .currency("PLN")
                .active(false)
                .build();


        Gson gson = new Gson();
        String jsonContent = gson.toJson(userDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}