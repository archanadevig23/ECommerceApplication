package com.bitsathy.ecommercebuyer.repository;

import com.bitsathy.ecommercebuyer.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
    public Flux<Product> findByIsAvailable(Boolean isAvailable);
}
