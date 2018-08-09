package com.liuyanzhao.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 言曌
 * @date 2018/8/8 16:32
 */
@Controller
public class MainController {

    @GetMapping("/login")
    public String hello(Model model) {
        model.addAttribute("hello","hello, saysky!");
        return "login";
    }
}
