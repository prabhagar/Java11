package com.prabh.java11.springbootlab.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductRequest {
    @NotBlank
    private String name;

    @Min(1)
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}