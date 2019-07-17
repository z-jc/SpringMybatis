package com.example.demo;

import com.example.demo.bean.UserInfo;
import com.example.demo.dao.BaseDao;
import com.example.demo.dao.UserDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        BaseDao dao = new UserDao();
        /*try {
            ((UserDao) dao).findUserByIdTest(3);
            ((UserDao) dao).findAllUser();
            ((UserDao) dao).updateUserInfoName(2, "陈老板", "645648564");
            UserInfo info = new UserInfo();
            info.setUser_name("杨老板");
            info.setPassword("956487");
            ((UserDao) dao).insertUserInfo(info);
            ((UserDao) dao).deleteUserInfo(5);
            ((UserDao) dao).findUserByNameTest("王老板");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}