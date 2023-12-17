package service;

import org.springframework.stereotype.Service;

/**
 * 目标类
 */
@Service("userService")
public class UserService {
    public void login(){//目标方法
        System.out.println("系统正在进行身份认证...");
    }
    public void logout(){//目标方法
        System.out.println("系统退出...");
    }
}
