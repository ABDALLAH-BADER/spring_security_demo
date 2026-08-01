package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.example.entity.Role;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public UserDto register(UserDto dto){
        User user = new User();
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setUsername(dto.getUsername());
        user.setRole(Role.USER);
        userRepository.save(user);
        return dto;
    }

    public String login ( UserDto dto){
        // here it call jwtFilter
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(),dto.getPassword())
        );
        User user = userRepository.findByUsername(dto.getUsername()).orElseThrow();
        return jwtUtil.generateToken(user);
    }

}
