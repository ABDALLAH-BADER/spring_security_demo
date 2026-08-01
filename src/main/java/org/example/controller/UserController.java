package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.example.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto user){
        UserDto userDto= userService.register(user);
        return ResponseEntity.ok( userDto.getUsername());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto user){
        String token = userService.login(user);
        return ResponseEntity.ok( token );
    }
}