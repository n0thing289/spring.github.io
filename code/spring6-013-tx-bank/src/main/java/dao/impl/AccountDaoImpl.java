package dao.impl;

import dao.AccountDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;
import pojo.Account;

import java.io.IOException;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    private SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    private SqlSessionFactory sqlSessionFactory;

    {
        try {
            sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account selectByActno(String actno) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Account account = sqlSession.selectOne("AccountMapper.selectByActno", actno);

        sqlSession.close();
        return account;
    }

    @Override
    public int update(Account act) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int affectRows = sqlSession.update("update", act);
        sqlSession.close();
        return affectRows;
    }
}
