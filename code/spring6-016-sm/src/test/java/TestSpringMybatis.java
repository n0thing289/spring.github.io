import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;

public class TestSpringMybatis {
    @Test
    public void testSM() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = ac.getBean("accountService", AccountService.class);
        accountService.transfer("act-001", "act-002", 10000);
    }
}
