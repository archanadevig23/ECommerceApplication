package com.bitsathy.ecommercebuyer.serviceImpl;

import com.bitsathy.ecommercebuyer.model.User;
import com.bitsathy.ecommercebuyer.pojo.UserLoginRequest;
import com.bitsathy.ecommercebuyer.pojo.UserRequest;
import com.bitsathy.ecommercebuyer.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
@Service
public class UserServiceImpl {
    @Autowired
    UserRepository userRepository;

    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public Mono<User> addUser(UserRequest userRequest) {
        if(userRepository.findById(userRequest.getPhone()).blockOptional().isEmpty()) {
            User user = new User(userRequest);
            return userRepository.save(user);
        }
        return Mono.empty();
    }
    public Flux<User> getUser(Optional<String> id) {
        if(id.isPresent()) {
//            log.info("Message");
            return Flux.just(userRepository.findById(id.get()).block());
        }
        else
        {
            log.info("Inside else");
            userRepository.findAll().subscribe(val -> System.out.println("val = " + val));
            log.info("Here");
            return userRepository.findAll();
        }
    }

    public Mono<User> authUser(UserLoginRequest userLoginRequest) {
        return userRepository.findByEmailAndPassword(userLoginRequest.getEmail(), userLoginRequest.getPassword());
    }

    public Flux<User> searchUser(String name) {
        Flux<User> userFlux = null;
        userRepository.findAll().filter(user -> {
            if(user.getName().contains(name))
                userFlux.concatWith(Flux.just(user));
            return true;
        }).subscribe(val -> System.out.println("val = " + val));
        return userRepository.findByName(name);
    }
}
