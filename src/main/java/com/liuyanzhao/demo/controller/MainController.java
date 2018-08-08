package com.liuyanzhao.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 言曌
 * @date 2018/8/8 16:32
 */
@RestController
public class MainController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
