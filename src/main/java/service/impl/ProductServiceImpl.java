package service.impl;

import exception.ResourceNotFoundException;
import model.Product;
import org.springframework.stereotype.Service;
import repository.ProductRepository;
import service.ProductService;

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
}
