package com.lonelycountry.springboot_03_hibernate.dao;

import com.lonelycountry.springboot_03_hibernate.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhuqiwei
 * 2018/6/29.
 */
public interface UserDao extends JpaRepository<User, Long> {
    /**
     * 获取用户信息
     * @param loginName 登录名
     * @return User
     */
    User findByLoginName(String loginName);


}
