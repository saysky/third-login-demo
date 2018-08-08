package com.liuyanzhao.demo.service;

import com.liuyanzhao.demo.entity.User;

import java.util.List;

/**
 * @author 言曌
 * @date 2018/8/8 16:50
 */

public interface UserService {

    Boolean insertUser(User user);

    User getUserById(Integer id);

    List<User> listUsers();

    Boolean removeUserById(Integer id);

    Boolean updateUser(User user);
}
