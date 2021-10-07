package controller;

import model.Product;
import org.springframework.web.bind.annotation.*;
import service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){
        super();
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.save(product), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Product> get(){
        return productService.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> get(@PathVariable("id") long id){
        return new ResponseEntity<Product>(productService.get(id), HttpStatus.OK);
    }
}
