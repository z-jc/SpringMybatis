package com.example.demo.bean;

/**
 * @ClassName UserInfo
 * @Description TODO
 * @Author ZJC
 * @Date 2019\3\16 0016 9:02
 * @Version 1.0
 **/
public class UserInfo {

    private int id;
    private String user_name;
    private String password;

    public UserInfo(){}

    public UserInfo(int id, String user_name, String password) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
    }

    public UserInfo(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public UserInfo(int id) {
        this.id = id;
    }

    public UserInfo(String user_name) {
        this.user_name = user_name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}