package com.liuyanzhao.demo.repository;

import com.liuyanzhao.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 言曌
 * @date 2018/8/8 16:46
 */

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
