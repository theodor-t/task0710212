package com.example.test.service;

import com.example.test.model.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> getAll();
    Product get(long id);
    Product update(Product product, long id);
    void delete(long id);
}
