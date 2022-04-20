package com.dtb.service;

import com.dtb.domain.Currency;
import com.dtb.domain.User;
import com.dtb.domain.UserAud;
import com.dtb.repository.UserAudRepository;
import com.dtb.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDbServiceTestSuite {

    @InjectMocks
    UserDbService userDbService;

    @Mock
    UserRepository userRepository;

    @Test
    void getUsers() {
        //Given
        List<User> users = new ArrayList<>();

        User user1 = new User(1L, "John", "Shoggoth",
                LocalDateTime.of(2022,4,1,12,30,0), "PLN", false);

        User user2 = new User(2L, "Sam", "Rlyeh",
                LocalDateTime.of(2022,1,1,12,30,0), "PLN", false);


        users.add(user1);
        users.add(user2);
        when(userRepository.findAll()).thenReturn(users);

        //When
        List<User> result = userDbService.getUsers();

        //Then
        assertEquals(2, result.size());
    }

    @Test
    void getUser() {
        //Given
        User user = new User(1L, "John", "Shoggoth",
                LocalDateTime.of(2022,1,1,12,30,0), "PLN", false);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        //When
        Optional<User> result = userDbService.getUser(1L);

        //Then
        assertEquals(Optional.of(user), userDbService.getUser(1L));
    }

    @Test
    void deleteUser() {
        //Given
        User user = new User(1L, "John", "Shoggoth",
                LocalDateTime.of(2022,1,1,12,30,0), "PLN", false);

        //When
        userDbService.deleteUser(1L);

        //Then
        assertEquals(Optional.empty(), userDbService.getUser(1L));
    }

    @Test
    void saveUser() {
        //Given
        User user = new User(1L, "John", "Shoggoth",
                LocalDateTime.of(2022,1,1,12,30,0), "PLN", false);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        //When
        userDbService.saveUser(user);

        //Then
        assertEquals(1L, userRepository.findById(1L).get().getId());
        assertEquals("John", userRepository.findById(1L).get().getFirstName());
        assertEquals("Shoggoth", userRepository.findById(1L).get().getLastName());
        assertEquals(LocalDateTime.of(2022,1,1,12,30,0),
                userRepository.findById(1L).get().getCreated());
        assertEquals("PLN", userRepository.findById(1L).get().getCurrency());
    }
}
