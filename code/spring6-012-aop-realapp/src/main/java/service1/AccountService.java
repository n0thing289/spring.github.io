package service1;

import org.springframework.stereotype.Service;

/**
 * 目标类
 */
@Service("accountService")
public class AccountService {
    public void transfer(){
        System.out.println("银行账户正在完成转账操作,,,,");
    }
    public void withdraw(){
        System.out.println("正在取款请稍后...");
    }
}
