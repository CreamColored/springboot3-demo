package com.amadeus.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.amadeus.entity.User;
import com.amadeus.entity.bo.UserBO;
import com.amadeus.entity.vo.UserVO;
import com.amadeus.mapper.UserMapper;
import com.amadeus.mongo.entity.UserCollection;
import com.amadeus.mongo.service.UserMongoService;
import com.amadeus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMongoService userMongoService;


    @Override
    public int saveUser(UserBO user) {
        UserCollection userCollection = userMongoService.save(BeanUtil.toBean(user, UserCollection.class));
        User entity = BeanUtil.toBean(user, User.class);
        entity.setMongoId(userCollection.getId());
        return userMapper.insert(entity);
    }

    @Override
    public UserVO getByMongoId(String mongoId) {
        UserCollection entity = new UserCollection();
        entity.setUserName("test");
        Page<UserCollection> page = userMongoService.findByPage(entity, PageRequest.of(0, 10));
        List<UserCollection> list = page.get().toList();
        Optional<UserCollection> optional = userMongoService.findById(mongoId);
        return optional.map(userCollection -> BeanUtil.toBean(userCollection, UserVO.class)).orElse(null);
    }
}
