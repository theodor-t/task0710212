package com.example.test.controller;

import com.example.test.model.Product;
import org.springframework.web.bind.annotation.*;
import com.example.test.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;


    public ProductController(ProductService productService){
        super();
        this.productService = productService;
    }

    @PostMapping("/createproduct")
    public ResponseEntity<Product> create(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.save(product), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public List<Product> get(){
        return productService.getAll();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> get(@PathVariable("id") long id){
        return new ResponseEntity<Product>(productService.get(id), HttpStatus.OK);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") long id,
                                          @RequestBody Product product ){
        return new ResponseEntity<Product>(productService.update(product, id), HttpStatus.OK);
    }
}
