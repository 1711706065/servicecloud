package com.lmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lmc
 * @Description
 * @Date: Create in 11:26 2020/8/16
 */
@RestController
public class TestController {

    @RequestMapping("/")
    public String root() {
        return "root path...";
    }

    @RequestMapping("/test01")
    public String test() {
        return "test01...";
    }

}
