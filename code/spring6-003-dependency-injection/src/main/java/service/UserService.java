package service;

import dao.UserDao;
import dao.VipDao;

/**
 * 用于测试set注入
 */
public class UserService {

    private UserDao userDao;

    private VipDao vipDao;
    //这里测试后,发现,
    public void setAbc(VipDao vipDao) {
        this.vipDao = vipDao;
    }

    //set注入的话,必须提供一个set方法
    //spring容器会调用这个set方法，来给userDao属性赋值
    //我自己写一个set方法，不使用Idea工具生成的，不符合javabean规范
    //至少这个方法是以set单词开始的，前三个字母不能随便写，必须是“set”
//    public void setMySQLUserDao(UserDao userDao){
//        this.userDao = userDao;
//    }
    //机器生成,符合规范->属性名
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(){
        userDao.insert();
    }
}
