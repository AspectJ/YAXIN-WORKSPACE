package com.asiainfo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2018-04-03 14:17
 **/
@ApiModel(value = "UserEntity", description = "User实体对象")
public class User {

    @ApiModelProperty(value = "用户名", name = "用户名")
    private String username;
    @ApiModelProperty(value = "密码", name = "密码")
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
