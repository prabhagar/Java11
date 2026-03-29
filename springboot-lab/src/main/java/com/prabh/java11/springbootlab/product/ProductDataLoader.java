package com.prabh.java11.springbootlab.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductDataLoader implements CommandLineRunner {
    private final ProductRepository productRepository;

    public ProductDataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        if (productRepository.count() == 0) {
            productRepository.save(new Product("Keyboard", 1499));
            productRepository.save(new Product("Monitor", 8999));
            productRepository.save(new Product("Mouse", 499));
        }
    }
}