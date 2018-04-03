package com.asiainfo.controller;

import com.asiainfo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2018-04-03 14:06
 **/
@RestController
@Api(value = "DemoController", description = "Demo------Controller")
@RequestMapping(value = "/demo")
public class DemoController {


    @ApiOperation(value = "根据用户Id查询用户", notes = "根据用户ID查询用户", response = User.class, httpMethod = "GET")
    @RequestMapping(value = "/findUserById/{userId}", method = RequestMethod.GET)
    public User findUserById(
            @ApiParam(name = "userId", value = "用户ID", required = true)
            @PathVariable(value = "userId", required = true) String userId) {

        return new User("zhangsan" + userId, "123456");
    }

    @ApiOperation(value = "新增用户", notes = "新增用户", response = User.class)
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User addUser(
            @ApiParam(name = "user", value = "新增的用户信息", required = true)
            @RequestBody User user) {

        return user;

    }
}
