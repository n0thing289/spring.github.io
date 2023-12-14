package com.powernode.myspring.bean;

public class UserDao {
    private User user;

    public void insert(){
        System.out.println("数据库正在保存用户信息: " + user.getName());
    }
}
