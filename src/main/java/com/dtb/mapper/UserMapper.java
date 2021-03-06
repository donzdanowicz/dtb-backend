package com.dtb.mapper;

import com.dtb.domain.User;
import com.dtb.domain.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserMapper {
    public User mapToUser(final UserDto userDto) {
        return new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(),
                userDto.getCreated(), userDto.getCurrency(), userDto.isActive());
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(),
                user.getCreated(), user.getCurrency(), user.isActive());
    }

    public List<UserDto> mapToUserDtoList(final List<User> users) {
        return users.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
