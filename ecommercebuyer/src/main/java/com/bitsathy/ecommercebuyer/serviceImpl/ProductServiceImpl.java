package com.bitsathy.ecommercebuyer.serviceImpl;

import com.bitsathy.ecommercebuyer.model.Product;
import com.bitsathy.ecommercebuyer.pojo.ProductRequest;
import com.bitsathy.ecommercebuyer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class ProductServiceImpl {
    @Autowired
    ProductRepository productRepository;

    public Flux<Product> getAvailableProducts() {
        return productRepository.findByIsAvailable(true);
    }
}
