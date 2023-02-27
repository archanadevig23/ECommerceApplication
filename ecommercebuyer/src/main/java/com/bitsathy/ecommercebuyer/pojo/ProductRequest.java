package com.bitsathy.ecommercebuyer.pojo;

import lombok.Data;

@Data
public class ProductRequest {
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
}
