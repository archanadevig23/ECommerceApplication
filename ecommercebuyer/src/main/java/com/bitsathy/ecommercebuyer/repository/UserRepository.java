package com.bitsathy.ecommercebuyer.repository;

import com.bitsathy.ecommercebuyer.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
    public Mono<User> findByEmailAndPassword(String email, String password);
    public Flux<User> findByName(String name);
}
