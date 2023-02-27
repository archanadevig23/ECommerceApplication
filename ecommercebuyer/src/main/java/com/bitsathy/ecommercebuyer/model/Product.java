package com.bitsathy.ecommercebuyer.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Flux;

@Data
@Document
public class Product {
    @Id
    String id;
    String title;
    String description;
    String catId;
    String subCatId;
    String sellerId;
    Double mrp;
    Boolean isOfferAvailable;
    Double offerPercentage;
    Double price;
    Boolean isAvailable;
    Integer availableStock;
    Integer purchasedStock;
    Integer viewCount;
    Flux<String> purchasedUsersId;
}
