package service;

import dao.UserDao;
import dao.VipDao;

/**
 * 用于测试构造注入
 */
public class CustomerService {
    private UserDao userDao;

    private VipDao vipDao;

    public CustomerService() {
    }

    public CustomerService(UserDao userDao, VipDao vipDao) {
        this.userDao = userDao;
        this.vipDao = vipDao;
    }

    public void save(){
        userDao.insert();
        vipDao.insert();
    }
}
