package com.dtb.mapper;

import com.dtb.domain.User;
import com.dtb.domain.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserMapperTestSuite {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void shouldMapToUser() {
        //Given
        UserDto userDto = new UserDto(1L, "John", "Shoggoth",
                LocalDateTime.of(2022,3,22,12,33,0), "PLN", false);

        //When
        User user = userMapper.mapToUser(userDto);

        //Then
        assertEquals(1L, user.getId());
        assertEquals("John", user.getFirstName());
        assertEquals("Shoggoth", user.getLastName());
        assertEquals(LocalDateTime.of(2022,3,22,12,33,0), user.getCreated());
        assertEquals("PLN", user.getCurrency());
    }

    @Test
    public void shouldMapToUserDto() {
        //Given
        User user = new User(1L, "John", "Shoggoth",
                LocalDateTime.of(2022,3,22,12,33,0), "PLN", false);

        //When
        UserDto userDto = userMapper.mapToUserDto(user);

        //Then
        assertEquals(1L, userDto.getId());
        assertEquals("John", userDto.getFirstName());
        assertEquals("Shoggoth", userDto.getLastName());
        assertEquals(LocalDateTime.of(2022,3,22,12,33,0), userDto.getCreated());
        assertEquals("PLN", userDto.getCurrency());
    }

    @Test
    public void shouldMapToUserDtoList() {
        //Given
        List<User> users = new ArrayList<>();
        User user1 = new User(1L, "John", "Shoggoth",
                LocalDateTime.of(2022,3,22,12,33,0), "PLN", false);
        User user2 = new User(2L, "Sam", "Rlyeh",
                LocalDateTime.of(2022,4,22,8,30,0), "USD", false);

        users.add(user1);
        users.add(user2);

        //When
        List<UserDto> usersDto = userMapper.mapToUserDtoList(users);

        //Then
        assertEquals(2, usersDto.size());
        assertEquals(1L, usersDto.get(0).getId());
        assertEquals("John", usersDto.get(0).getFirstName());
        assertEquals("Shoggoth", usersDto.get(0).getLastName());
        assertEquals(LocalDateTime.of(2022,4,22,8,30,0), usersDto.get(1).getCreated());
        assertEquals("USD", usersDto.get(1).getCurrency());

    }



}

