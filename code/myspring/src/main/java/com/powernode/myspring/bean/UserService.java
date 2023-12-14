package com.powernode.myspring.bean;

public class UserService {
    private UserDao userDao;
    public void save(){
        userDao.insert();
    }
}
