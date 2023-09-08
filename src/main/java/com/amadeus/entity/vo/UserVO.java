package com.amadeus.entity.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserVO implements Serializable {


    @Serial
    private static final long serialVersionUID = -4695901955691200102L;

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;
}
