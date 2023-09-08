package com.amadeus.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("user")
public class UserCollection {

    @Id
    private String id;

    private String userName;

    private String password;
}
