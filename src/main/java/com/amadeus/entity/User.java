package com.amadeus.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -5187799831961347090L;

    /**
     * id
     */
    private Long id;

    /**
     * mongoId
     */
    private String mongoId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;
}