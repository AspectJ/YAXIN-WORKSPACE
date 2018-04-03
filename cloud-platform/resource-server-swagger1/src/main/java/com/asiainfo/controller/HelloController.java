package com.asiainfo.controller;

import com.asiainfo.entity.User;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2018-04-03 14:06
 **/
@RestController
@Api(value = "HelloController", description = "Hello---Controller")
@RequestMapping(value = "/hello")
public class HelloController {


    @ApiOperation(value = "根据用户Id查询用户", notes = "根据用户ID查询用户", response = User.class, httpMethod = "GET")
    @RequestMapping(value = "/findUserById/{userId}", method = RequestMethod.GET)
    public User findUserById(
            @ApiParam(name = "userId", value = "用户ID", required = true)
            @PathVariable(value = "userId", required = true) String userId) {

        return new User("zhangsan" + userId, "123456");
    }
}
