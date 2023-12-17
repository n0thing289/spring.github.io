import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.OrderService;
import service.Spring6Configuration;
import service.UserService;

public class TestSpringAOP {

    @Test
    public void testNoXml(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(Spring6Configuration.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);
        orderService.generate();
    }

    @Test
    public void testBefore() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

//        UserService userService = (UserService) ac.getBean("userService", UserService.class);
//        userService.login();
//        userService.logout();

        OrderService orderService = ac.getBean("orderService", OrderService.class);
        orderService.generate();
    }
}
