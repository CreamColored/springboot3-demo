package com.amadeus.mongo.service.impl;

import com.amadeus.mongo.entity.UserCollection;
import com.amadeus.mongo.repository.UserMongoRepository;
import com.amadeus.mongo.service.UserMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMongoServiceImpl extends MongoBaseServiceImpl<UserCollection, String> implements UserMongoService {

    @Autowired
    private UserMongoRepository userMongoRepository;

    public UserMongoServiceImpl(UserMongoRepository userMongoRepository) {
        super(userMongoRepository);
        this.userMongoRepository = userMongoRepository;
    }
}
