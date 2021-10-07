package service.impl;

import model.Product;
import org.springframework.stereotype.Service;
import repository.ProductRepository;
import service.ProductService;

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
}
