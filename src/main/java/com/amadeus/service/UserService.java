package com.amadeus.service;

import com.amadeus.entity.bo.UserBO;
import com.amadeus.entity.vo.UserVO;

public interface UserService {

    int saveUser(UserBO user);

    UserVO getByMongoId(String mongoId);
}
