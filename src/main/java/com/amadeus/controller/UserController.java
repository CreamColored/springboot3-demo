package com.amadeus.controller;

import cn.hutool.json.JSONUtil;
import com.amadeus.entity.bo.UserBO;
import com.amadeus.entity.vo.UserVO;
import com.amadeus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(value = "/save")
    public String save(@RequestBody UserBO user) {
        userService.saveUser(user);

        return "保存成功";
    }

    @GetMapping(value = "/{mongoId}")
    public String getBymongoId(@PathVariable String mongoId) {
        UserVO user = userService.getByMongoId(mongoId);
        return JSONUtil.toJsonStr(user);
    }
}
