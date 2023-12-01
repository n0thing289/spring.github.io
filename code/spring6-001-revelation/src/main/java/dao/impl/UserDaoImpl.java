package dao.impl;

import dao.UserDao;

public class UserDaoImpl implements UserDao {
    public int deleteById(){
        System.out.println("UserDaoImpl正在从数据库中删除数据");
        return 0;
    }
}
