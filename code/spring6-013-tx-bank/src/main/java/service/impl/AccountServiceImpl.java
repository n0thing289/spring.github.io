package service.impl;

import dao.AccountDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Account;
import service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    @Transactional
    public void transfer(String fromActno, String toActno, double money) {
        //查询转出账户余额
        Account fromAct = accountDao.selectByActno(fromActno);
        Account toAct = accountDao.selectByActno(toActno);

        if (fromAct.getBalance() < money) {
            System.out.println("余额不足无法转账");
            throw new RuntimeException("余额不足!");
        }
        //将内存中的余额先修改
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        //持久化
        int count = accountDao.update(fromAct);
//        String s = null;
//        s.toString();
        count += accountDao.update(toAct);

        if (count != 2) {
            throw new RuntimeException("出现异常!");
        }
    }
}
