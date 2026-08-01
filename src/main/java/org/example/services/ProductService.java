package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.example.entity.Product;
import org.example.entity.Role;
import org.example.entity.User;
import org.example.repository.ProductRepository;
import org.example.repository.UserRepository;
import org.example.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
