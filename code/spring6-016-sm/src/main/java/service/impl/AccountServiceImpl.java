package service.impl;

import mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pojo.Account;
import service.AccountService;

import java.util.List;
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int save(Account act) {
        return accountMapper.insert(act);
    }

    @Override
    public int deleteByActno(String actno) {
        return accountMapper.deleteByActno(actno);
    }

    @Override
    public int modify(Account account) {
        return accountMapper.update(account);
    }

    @Override
    public Account getByActno(String actno) {
        return accountMapper.selectByActno(actno);
    }

    @Override
    public List<Account> getAll() {
        return accountMapper.selectAll();
    }

    @Override
    public void transfer(String fromActno, String toActno, double money) {
        //查询转出账户余额
        Account fromAct = accountMapper.selectByActno(fromActno);
        Account toAct = accountMapper.selectByActno(toActno);

        if (fromAct.getBalance() < money) {
            System.out.println("余额不足无法转账");
            throw new RuntimeException("余额不足!");
        }
        //将内存中的余额先修改
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        //持久化
        int count = accountMapper.update(fromAct);
//        String s = null;
//        s.toString();
        count += accountMapper.update(toAct);

        if (count != 2) {
            throw new RuntimeException("出现异常!");
        }
    }
}
