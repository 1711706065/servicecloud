package com.lmc.controller;

import com.lmc.beans.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lmc
 * @Description
 * @Date: Create in 22:11 2020/8/25
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test ...";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello ...";
    }

    //只要接口中存在实体类，它就会被扫描到wagger中
    @PostMapping("/user")
    //ApiOperation接口,描述接口的
    @ApiOperation("Hello控制类")
    public User user(@ApiParam("用户名") String username){
        return new User();
    }

}
