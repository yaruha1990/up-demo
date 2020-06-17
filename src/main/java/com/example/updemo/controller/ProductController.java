package com.example.updemo.controller;

import com.example.updemo.dto.ProductDto;
import com.example.updemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.badRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findByID(@PathVariable("id") long id) {
        Optional<ProductDto> productDto = productService.findById(id);
        return productDto.map(ResponseEntity::ok).orElseGet(() -> badRequest().build());
    }

    @GetMapping("/category/{id}")
    public List<ProductDto> findAllByCategoryId(@PathVariable(value = "id") long categoryId) {
        return productService.findAllByCategoryId(categoryId);
    }

    @GetMapping("/category")
    public List<ProductDto> findAllByCategoryName(@RequestParam(value = "categoryName") String categoryName) {
        return productService.findAllByCategoryName(categoryName);
    }
}
