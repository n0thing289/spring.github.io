import com.powernode.myspring.bean.UserService;
import org.junit.Test;
import org.springframework.core.ApplicationContext;
import org.springframework.core.ClassPathXmlApplicationContext;

public class TestMySpring {
    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("myspring.xml");

        Object user = ac.getBean("user");
        System.out.println(user);

        UserService userService = (UserService) ac.getBean("userService");
        userService.save();
    }
}
