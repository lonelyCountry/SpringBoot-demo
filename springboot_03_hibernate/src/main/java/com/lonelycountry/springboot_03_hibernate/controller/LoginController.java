package com.lonelycountry.springboot_03_hibernate.controller;

import com.google.common.collect.Maps;
import com.lonelycountry.springboot_03_hibernate.po.User;
import com.lonelycountry.springboot_03_hibernate.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author zhuqiwei
 * 2018/6/29.
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    HttpServletRequest request;

    @GetMapping("/msg/{loginName}")
    public User getUserMsg(@PathVariable String loginName) {
        User user = loginService.getUserMsg(loginName);
        return user;
    }

    @GetMapping("/msg2/{id}")
    public User getUserMsg(@PathVariable Long id) {
        User user = loginService.getUserMsg(id).isPresent() ? loginService.getUserMsg(id).get() : null;
        return user;
    }

    @PostMapping("/msg/{loginName}/{password}")
    public Map<String, Object> saveUserMsg(@PathVariable String loginName, @PathVariable String password) {
        loginService.saveUserMsg(loginName, password);
        Map<String, Object> result = Maps.newHashMap();
        result.put("stauts", "successed");
        return result;
    }

    @PutMapping("/msg/{id}/{loginName}/{password}")
    public Map<String, Object> updateUserMsg(@PathVariable Long id, @PathVariable String loginName, @PathVariable String password) {
        loginService.updateUserMsg(id, loginName, password);
        Map<String, Object> result = Maps.newHashMap();
        result.put("stauts", "successed");
        return result;
    }

    @DeleteMapping("/msg/{id}")
    public Map<String, Object> updateUserMsg(@PathVariable Long id) {
        loginService.deleteUserMsg(id);
        Map<String, Object> result = Maps.newHashMap();
        result.put("stauts", "successed");
        return result;
    }
}
