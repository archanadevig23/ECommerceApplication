package com.bitsathy.ecommercebuyer.controller;

import com.bitsathy.ecommercebuyer.model.Product;
import com.bitsathy.ecommercebuyer.pojo.ProductRequest;
import com.bitsathy.ecommercebuyer.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductServiceImpl productServiceImpl;
    @GetMapping("/getAvailableProducts")
    public ResponseEntity<Flux<Product>> getAvailableProducts() {
        return new ResponseEntity<>(productServiceImpl.getAvailableProducts(), HttpStatus.OK);
    }
}
