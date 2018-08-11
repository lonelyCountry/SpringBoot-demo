package com.lonelycountry.springboot_03_hibernate.service;

import com.lonelycountry.springboot_03_hibernate.po.User;

import java.util.Optional;

/**
 * @author zhuqiwei
 * 2018/6/29.
 */
public interface LoginService {
    /**
     * 获取用户登录信息
     * @param loginName 登录名
     * @return User
     */
    User getUserMsg(String loginName);

    /**
     * 获取用户登录信息
     * @param id 人员id
     * @return User
     */
    Optional<User> getUserMsg(Long id);

    /**
     * 保存用户登录信息
     * @param loginName
     * @param password
     */
    void saveUserMsg(String loginName, String password);

    /**
     * 修改用户登录信息
     * @param id
     * @param loginName
     * @param password
     */
    void updateUserMsg(Long id, String loginName, String password);

    /**
     * 删除用户登录信息
     * @param id
     */
    void deleteUserMsg(Long id);
}
