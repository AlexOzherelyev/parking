package dev.vorstu.controllers;

import dev.vorstu.dto.OwnerDto;
import dev.vorstu.dto.UserDto;
import dev.vorstu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getUser(){return userService.findAll();}

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
        Optional<UserDto> userDto =userService.findById(id);
        return userDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/fio/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getFIOById(@PathVariable("id") Long id) {
        Optional<UserDto> userDtoOptional = userService.findById(id);
        return userDtoOptional.map(userDto -> ResponseEntity.ok(userDto.getFio()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
