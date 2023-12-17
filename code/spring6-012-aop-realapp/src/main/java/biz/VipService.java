package biz;

import org.springframework.stereotype.Service;

@Service
public class VipService {
    public void saveUser(){
        System.out.println("新增用户信息");
    }
    public void deleteUser(){
        System.out.println("删除用户信息");
    }
    public void updateUser(){
        System.out.println("修改用户信息");
    }
    public void getUser(){
        System.out.println("查询用户信息");
    }
}
