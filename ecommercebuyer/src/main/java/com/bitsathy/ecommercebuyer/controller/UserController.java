package com.bitsathy.ecommercebuyer.controller;

import com.bitsathy.ecommercebuyer.model.User;
import com.bitsathy.ecommercebuyer.pojo.UserLoginRequest;
import com.bitsathy.ecommercebuyer.pojo.UserRequest;
import com.bitsathy.ecommercebuyer.serviceImpl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserServiceImpl userServiceImpl;
    @PostMapping("/addUser")
    public ResponseEntity<Mono<User>> addUser(@RequestBody UserRequest userRequest) {
        Mono<User> newUser = userServiceImpl.addUser(userRequest);
        log.info(String.valueOf(newUser.blockOptional().isPresent()));
        if(newUser.hasElement().block())
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/getUser")
    public ResponseEntity<Flux<User>> getUser(@RequestParam(required = false) Optional<String> id) {
        return new ResponseEntity<>(userServiceImpl.getUser(id), HttpStatus.OK);
    }

    @PostMapping("/authUser")
    public ResponseEntity<Mono<User>> authUser(@RequestBody UserLoginRequest userLoginRequest) {
        if(!userServiceImpl.authUser(userLoginRequest).blockOptional().isEmpty()) {
            return new ResponseEntity<>(userServiceImpl.authUser(userLoginRequest), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/searchUser")
    public ResponseEntity<Flux<User>> searchUser(String name) {
        if(userServiceImpl.searchUser(name).hasElements().block()) {
            return new ResponseEntity<>(userServiceImpl.searchUser(name), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
