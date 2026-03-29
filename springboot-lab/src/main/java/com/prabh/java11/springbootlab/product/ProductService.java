package com.prabh.java11.springbootlab.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product create(ProductRequest request) {
        Product product = new Product(request.getName().trim(), request.getPrice());
        return productRepository.save(product);
    }
            
    public boolean deleteById(Long id) {
        // Exercise for today:
        // 1. Check if the product exists.
        // 2. If it does not exist, return false.
        // 3. If it exists, delete it and return true.
        return false;
    }
}