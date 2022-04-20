package com.dtb.service;

import com.dtb.domain.CurrencyAud;
import com.dtb.domain.UserAud;
import com.dtb.repository.CurrencyAudRepository;
import com.dtb.repository.UserAudRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserAudDbServiceTestSuite {

    @InjectMocks
    UserAudDbService userAudDbService;

    @Mock
    UserAudRepository userAudRepository;

    @Test
    void saveUserAud() {
        //Given
        UserAud userAud = UserAud.builder()
                .eventDate(LocalDate.now())
                .eventType("INSERT")
                .userId(1L)
                .newFirstName("John")
                .newLastName("Shoggoth")
                .newCreated(LocalDateTime.of(2022,1,1,12,30,0))
                .newCurrency("PLN")
                .newActive(false)
                .build();

        when(userAudRepository.findById(1L)).thenReturn(Optional.of(userAud));

        //When
        userAudDbService.saveUserAud(userAud);

        //Then
        assertEquals("INSERT", userAudRepository.findById(1L).get().getEventType());
        assertEquals(1L, userAudRepository.findById(1L).get().getUserId());
        assertEquals("John", userAudRepository.findById(1L).get().getNewFirstName());
        assertEquals("Shoggoth", userAudRepository.findById(1L).get().getNewLastName());
        assertEquals(LocalDateTime.of(2022,1,1,12,30,0),
                userAudRepository.findById(1L).get().getNewCreated());
        assertEquals("PLN", userAudRepository.findById(1L).get().getNewCurrency());
    }
}
