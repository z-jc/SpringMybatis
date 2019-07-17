package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.UserInfo;
import com.example.demo.dao.UserDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author ZJC
 * @Date 2019\7\17 0017 11:45
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/user")
public class UserController {

    /**
     * 用户登录
     *
     * @param name     用户账号
     * @param password 用户密码
     * @return
     */
    @RequestMapping("/login")
    public String postLogin(@RequestParam(name = "name",
            required = true,
            defaultValue = "") String name, @RequestParam(name = "password",
            required = true,
            defaultValue = "") String password) {
        System.out.println("name:" + name + ",password:" + password);
        JSONObject jsonObject = new JSONObject();
        String code = "";
        String msg = "";
        if (name == null || password == null || name.equals("") || password.equals("")) {
            code = "101";
            msg = "缺少字段";
        } else {
            UserInfo userInfo = null;
            try {
                userInfo = new UserDao().findUserByNameTest(name);
                if (userInfo == null) {
                    code = "101";
                    msg = "登录失败,该账号还未注册";
                } else {
                    if (userInfo.getPassword().equals(password)) {
                        code = "100";
                        msg = "登录成功";
                    } else {
                        code = "101";
                        msg = "登录失败,密码输入错误";
                    }
                }
            } catch (IOException e) {
                code = "101";
                msg = "登录失败,数据库查询异常:" + e.toString();
            }
        }
        jsonObject.put("code", code);
        jsonObject.put("msg", msg);
        return jsonObject.toString();
    }

    /**
     * 用户注册
     *
     * @param name     用户账号
     * @param password 用户密码
     * @return
     */
    @RequestMapping("/register")
    public String postRegister(@RequestParam(name = "name",
            required = true,
            defaultValue = "") String name, @RequestParam(name = "password",
            required = true,
            defaultValue = "") String password) {
        System.out.println("name:" + name + ",password:" + password);
        JSONObject jsonObject = new JSONObject();
        String code = "";
        String msg = "";
        if (name == null || password == null || name.equals("") || password.equals("")) {
            code = "101";
            msg = "缺少字段";
        } else if (password.length() < 6) {
            code = "101";
            msg = "注册失败,密码不能小于6位";
        } else {
            UserInfo userInfo = null;
            try {
                userInfo = new UserDao().findUserByNameTest(name);
                if (userInfo == null) {//说明账号不存在,则进行注册
                    int index = new UserDao().insertUserInfo(new UserInfo(name, password));
                    if (index != -1) {
                        code = "100";
                        msg = "注册成功";
                    } else {
                        code = "1001";
                        msg = "注册失败";
                    }
                } else {
                    code = "101";
                    msg = "注册失败,您的账号已注册,无需再次注册!";
                }
            } catch (IOException e) {
                code = "101";
                msg = "注册失败,数据库查询异常:" + e.toString();
            }
        }
        jsonObject.put("code", code);
        jsonObject.put("msg", msg);
        return jsonObject.toString();
    }

    /**
     * 修改密码
     *
     * @param name          用户账号
     * @param password      当前密码
     * @param resetpassword 更换后的密码
     * @return
     */
    @RequestMapping("/resetpsw")
    public String postResetPsw(@RequestParam(name = "name",
            required = true,
            defaultValue = "") String name, @RequestParam(name = "password",
            required = true,
            defaultValue = "") String password, @RequestParam(name = "resetpassword",
            required = true,
            defaultValue = "") String resetpassword) {

        System.out.println("name:" + name + ",password:" + password + ",resetpassword:" + resetpassword);
        JSONObject jsonObject = new JSONObject();
        String code = "";
        String msg = "";
        if (name == null || password == null || name.equals("") || password.equals("") || resetpassword == null || resetpassword.equals("")) {
            code = "101";
            msg = "缺少字段";
        } else if (resetpassword.length() < 6) {
            code = "101";
            msg = "重置失败,新密码不能小于6位";
        } else {
            UserInfo userInfo = null;
            try {
                userInfo = new UserDao().findUserByNameTest(name);
                if (userInfo != null) {//说明账号不存在,则进行注册
                    if (userInfo.getPassword().equals(password)) {
                        // TODO: 2019\7\17 0017 去修改
                        UserInfo info = new UserDao().updateUserInfoName(userInfo.getId(), userInfo.getUser_name(), resetpassword);
                        if (info.getId() != -1) {
                            code = "100";
                            msg = "重置成功";
                        } else {
                            code = "101";
                            msg = "重置失败";
                        }
                    } else {
                        // TODO: 2019\7\17 0017 旧密码输入错误
                        code = "101";
                        msg = "重置失败,您的旧密码输入错误";
                    }
                } else {
                    code = "101";
                    msg = "重置失败,您的账号未注册!";
                }
            } catch (IOException e) {
                code = "101";
                msg = "重置失败,数据库查询异常:" + e.toString();
            }
        }
        jsonObject.put("code", code);
        jsonObject.put("msg", msg);
        return jsonObject.toString();
    }
}