package web;

import service.UserService;
import service.impl.UserServiceImpl;

public class UserAction {

    private UserService userService;

    public void deleteRequest() {
        //调用service的删除业务

        userService.deleteUser();
    }
}
