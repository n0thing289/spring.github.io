import biz.UserService;
import biz.VipService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service1.AccountService;
import service1.OrderService;

public class TestRealApp {
    @Test
    public void testSecurityLog(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = ac.getBean("userService", UserService.class);
        userService.saveUser();
        userService.deleteUser();
        userService.updateUser();
        userService.getUser();

        VipService vipService = ac.getBean("vipService", VipService.class);
        vipService.saveUser();
        vipService.deleteUser();
        vipService.updateUser();
        vipService.getUser();

    }

    /**
     * 编程式事务解决方案
     */
    @Test
    public void testTransaction(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        AccountService accountService = ac.getBean("accountService", AccountService.class);
        accountService.transfer();
        accountService.withdraw();

        OrderService orderService = ac.getBean("orderService", OrderService.class);
        orderService.generate();
        orderService.cancel();
    }
}
