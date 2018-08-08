package com.liuyanzhao.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 言曌
 * @date 2018/8/8 16:34
 */
@Entity
@Table(name = "user")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String nickname;

    private String email;

    @org.hibernate.annotations.CreationTimestamp  // 由数据库自动创建时间
    private Date createTime;
}
