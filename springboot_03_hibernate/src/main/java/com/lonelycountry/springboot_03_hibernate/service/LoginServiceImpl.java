package com.lonelycountry.springboot_03_hibernate.service;

import com.lonelycountry.springboot_03_hibernate.dao.UserDao;
import com.lonelycountry.springboot_03_hibernate.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * @author zhuqiwei
 * 2018/6/29.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserMsg(String loginName) {
        return userDao.findByLoginName(loginName);
    }

    @Override
    public Optional<User> getUserMsg(Long id) {
        return userDao.findById(id);
    }

    @Override
    public void saveUserMsg(String loginName, String password) {
        User user = new User();
        user.setId(UUID.randomUUID().getMostSignificantBits());
        user.setLoginName(loginName);
        user.setPassword(password);
        userDao.save(user);
    }

    @Override
    public void updateUserMsg(Long id, String loginName, String password) {
        User user = new User();
        user.setId(id);
        user.setLoginName(loginName);
        user.setPassword(password);
        userDao.save(user);
    }

    @Override
    public void deleteUserMsg(Long id) {
        userDao.deleteById(id);
    }
}
