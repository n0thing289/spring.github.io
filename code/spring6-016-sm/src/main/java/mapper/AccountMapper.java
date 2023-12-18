package mapper;

import pojo.Account;

import java.util.List;

public interface AccountMapper {
    int insert(Account act);
    int deleteByActno(String actno);
    int update(Account act);
    Account selectByActno(String actno);
    List<Account> selectAll();
}
