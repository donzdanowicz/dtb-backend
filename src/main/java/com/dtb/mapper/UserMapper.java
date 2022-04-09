package com.dtb.mapper;

import com.dtb.domain.User;
import com.dtb.domain.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserMapper {
    public User mapToUser(final UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .created(userDto.getCreated())
                .currency(userDto.getCurrency())
                .build();
    }

    public UserDto mapToUserDto(final User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .created(user.getCreated())
                .currency(user.getCurrency())
                .build();
    }

    public List<UserDto> mapToUserDtoList(final List<User> categories) {
        return categories.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
