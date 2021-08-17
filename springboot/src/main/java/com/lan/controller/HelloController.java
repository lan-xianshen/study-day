package com.lan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jianglin.lan
 * @title: HelloController
 * @projectName study-day
 * @description: TODO
 * @date 2021/8/5 15:36
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello () {
        return "hello boot";
    }
}
