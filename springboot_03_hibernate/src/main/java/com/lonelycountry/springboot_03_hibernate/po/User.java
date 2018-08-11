package com.lonelycountry.springboot_03_hibernate.po;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zhuqiwei
 * 2018/6/29.
 */
@Data
@Entity
@Table(name = "user")
public class User {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 登录名
     */
    @Column(name = "LOGIN_NAME")
    private String loginName;

    /**
     * 密码
     */
    @Column(name = "PASSWORD")
    private String password;
}
