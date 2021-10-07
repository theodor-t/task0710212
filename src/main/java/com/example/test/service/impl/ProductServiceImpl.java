package com.example.test.service.impl;

import com.example.test.exception.ResourceNotFoundException;
import com.example.test.model.Product;
import org.springframework.stereotype.Service;
import com.example.test.repository.ProductRepository;
import com.example.test.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    public  ProductServiceImpl(ProductRepository productRepository){
        super();
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product country) {
        return productRepository.save(country);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product get(long id) {
        return productRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Product", "id", id));
    }
    @Override
    public Product update(Product product, long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Product", "id", id));
        existingProduct.setName(product.getName());
        productRepository.save(existingProduct);
        return existingProduct;

    }
    @Override
    public void delete(long id) {
        productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product","id",id));
        productRepository.deleteById(id);
    }
}
