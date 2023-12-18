package dao;

import pojo.Account;

public interface AccountDao {
    /**
     * 根据账户查询账户信息
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 更新账户信息
     * @param act
     * @return
     */
    int update(Account act);
}
