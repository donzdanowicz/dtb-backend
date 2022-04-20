package com.dtb.facade;

import com.dtb.domain.EntryAud;
import com.dtb.domain.User;
import com.dtb.domain.UserAud;
import com.dtb.domain.UserDto;
import com.dtb.exception.UserNotFoundException;
import com.dtb.mapper.UserMapper;
import com.dtb.service.UserAudDbService;
import com.dtb.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class UserFacade {
    @Autowired
    private UserDbService userDbService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserAudDbService userAudDbService;

    public List<UserDto> getUsers() {
        List<User> users = userDbService.getUsers();
        return userMapper.mapToUserDtoList(users);
    }

    public UserDto getUser(final Long id) throws UserNotFoundException {
        return userMapper.mapToUserDto(
                userDbService.getUser(id).orElseThrow(UserNotFoundException::new)
        );
    }

    public void deleteUser(final Long id) throws UserNotFoundException {
        UserAud userAud = UserAud.builder()
                .eventDate(LocalDate.now())
                .eventType("DELETE")
                .userId(id)
                .oldFirstName(getUser(id).getFirstName())
                .oldLastName(getUser(id).getLastName())
                .oldCreated(getUser(id).getCreated())
                .oldCurrency(getUser(id).getCurrency())
                .build();

        userAudDbService.saveUserAud(userAud);

        userDbService.deleteUser(id);
    }

    public void createUser(final UserDto userDto) {
        //userDto.setCreated(LocalDateTime.now());
        User user = userMapper.mapToUser(userDto);
        user.setCreated(LocalDateTime.now());
        user.setActive(false);
        userDbService.saveUser(user);

        UserAud userAud = UserAud.builder()
                .eventDate(LocalDate.now())
                .eventType("INSERT")
                .userId(getUsers().get(getUsers().size() - 1).getId())
                .newFirstName(userDto.getFirstName())
                .newLastName(userDto.getLastName())
                .newCreated(userDto.getCreated())
                .newCurrency(userDto.getCurrency())
                .newActive(userDto.isActive())
                .build();

        userAudDbService.saveUserAud(userAud);
    }

    public UserDto updateUser(final UserDto userDto) throws UserNotFoundException {
        Long id = userDto.getId();

        UserAud userAud = UserAud.builder()
                .eventDate(LocalDate.now())
                .eventType("UPDATE")
                .userId(userDto.getId())
                .newFirstName(userDto.getFirstName())
                .newLastName(userDto.getLastName())
                .newCreated(getUser(id).getCreated())
                .newCurrency(userDto.getCurrency())
                .newActive(userDto.isActive())
                .oldFirstName(getUser(id).getFirstName())
                .oldLastName(getUser(id).getLastName())
                .oldCreated(getUser(id).getCreated())
                .oldCurrency(getUser(id).getCurrency())
                .oldActive(getUser(id).isActive())
                .build();

        userAudDbService.saveUserAud(userAud);

        User user = userMapper.mapToUser(userDto);
        if(user.getCreated() == null) user.setCreated(getUser(id).getCreated());
        User updatedUser = userDbService.saveUser(user);
        return userMapper.mapToUserDto(updatedUser);
    }

    public void setUserActive(final Long id, final boolean active) throws UserNotFoundException {

        UserDto updatedUserDto = getUser(id);
        updatedUserDto.setActive(active);

        UserAud userAud = UserAud.builder()
                .eventDate(LocalDate.now())
                .eventType("UPDATE")
                .userId(id)
                .newFirstName(getUser(id).getFirstName())
                .newLastName(getUser(id).getLastName())
                .newCreated(getUser(id).getCreated())
                .newCurrency(getUser(id).getCurrency())
                .newActive(getUser(id).isActive())
                .oldFirstName(getUser(id).getFirstName())
                .oldLastName(getUser(id).getLastName())
                .oldCreated(getUser(id).getCreated())
                .oldCurrency(getUser(id).getCurrency())
                .oldActive(getUser(id).isActive())
                .build();

        userAudDbService.saveUserAud(userAud);

        User updatedUser = userMapper.mapToUser(updatedUserDto);
        if(updatedUser.getCreated() == null) updatedUser.setCreated(getUser(id).getCreated());
        userDbService.saveUser(updatedUser);
    }

}
