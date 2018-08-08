package com.liuyanzhao.demo.controller;

import com.liuyanzhao.demo.entity.User;
import com.liuyanzhao.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 言曌
 * @date 2018/8/8 16:48
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> listUsers() {
        List<User> userList =userService.listUsers();
        return userList;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        return user;
    }

    @PostMapping("/user")
    public String insertUser(@RequestBody User user) {
        Boolean isSuccess = userService.insertUser(user);
        if(isSuccess) {
            return "添加成功";
        }
        return "添加失败";
    }

    
}
