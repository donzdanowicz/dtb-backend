package com.dtb.controller;

import com.dtb.domain.User;
import com.dtb.domain.UserDto;
import com.dtb.exception.UserNotFoundException;
import com.dtb.facade.UserFacade;
import com.dtb.mapper.UserMapper;
import com.dtb.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/v1")
public class UserController {
    private final UserFacade userFacade;

    @GetMapping(value = "/users")
    public List<UserDto> getUsers() {
//        List<User> users = userDbService.getUsers();
//        return userMapper.mapToUserDtoList(users);
        return userFacade.getUsers();
    }

    @GetMapping(value = "/users/{id}")
    public UserDto getUser(@PathVariable Long id) throws UserNotFoundException {
//        return userMapper.mapToUserDto(
//                userDbService.getUser(id).orElseThrow(UserNotFoundException::new)
//        );
        return userFacade.getUser(id);
    }

    @DeleteMapping(value = "/users/{id}")
    public void deleteUser(@PathVariable Long id) throws UserNotFoundException {
//        userDbService.deleteUser(id);
        userFacade.deleteUser(id);
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
//        //userDto.setCreated(LocalDateTime.now());
//        User user = userMapper.mapToUser(userDto);
//        userDbService.saveUser(user);

        userFacade.createUser(userDto);
    }

    @PutMapping(value = "/users")
    public UserDto updateUser(@RequestBody UserDto userDto) throws UserNotFoundException {
//        User user = userMapper.mapToUser(userDto);
//        User updatedUser = userDbService.saveUser(user);
//        return userMapper.mapToUserDto(updatedUser);

        return userFacade.updateUser(userDto);
    }

    @PutMapping(value = "/users/setActive/")
    public void setUserActive(@RequestParam Long id, @RequestParam boolean active) throws UserNotFoundException {
        userFacade.setUserActive(id, active);
    }

}
