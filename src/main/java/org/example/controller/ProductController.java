package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.example.entity.Product;
import org.example.services.ProductService;
import org.example.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public List<Product> findAll(){
        return productService.findAll();
    }

}