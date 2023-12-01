package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;

public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao;

    public int deleteUser() {
        //删除用户的业务
        UserDao userDao = new UserDaoImpl();
        userDao.deleteById();
        return 0;
    }
}
