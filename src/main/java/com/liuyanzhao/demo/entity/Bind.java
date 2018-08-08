package com.liuyanzhao.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 言曌
 * @date 2018/8/8 16:34
 */
@Data
@Entity
@Table(name = "bind")
public class Bind implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String openId;

    @org.hibernate.annotations.CreationTimestamp  // 由数据库自动创建时间
    private Date createTime;
}
