package com.amadeus.mongo.repository;

import com.amadeus.mongo.entity.UserCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoRepository extends MongoRepository<UserCollection, String> {
}
