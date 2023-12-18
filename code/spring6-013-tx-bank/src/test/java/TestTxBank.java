import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;
import service.impl.AccountServiceImpl;

public class TestTxBank {
    @Test
    public void testTransfer(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = ac.getBean("accountService", AccountServiceImpl.class);
        accountService.transfer("act-001","act-002",10000);
    }
}
