package com.aloha.demo.product.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Product {
    private int no;
    private String id;
    private String name;
    private int price;
    private String img;
    private Date createdAt;
    private Date updatedAt;

    // Getters and Setters
    // ...
}
