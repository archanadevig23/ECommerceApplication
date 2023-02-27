package com.bitsathy.ecommercebuyer.model;

import com.bitsathy.ecommercebuyer.pojo.UserRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String name;
    String password;
    @Id
    String phone;
    String email;

    public User(UserRequest userRequest) {
        this.name = userRequest.getName();
        this.password = userRequest.getPassword();
        this.phone = userRequest.getPhone();
        this.email = userRequest.getEmail();
    }
}
