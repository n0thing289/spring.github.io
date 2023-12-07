import bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanLifeCycle {
    @Test
    public void testBeanLifeCycleFive() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        User user = ac.getBean("userBean", User.class);
        System.out.println("第四步: 使用bean" + user);

        //注意: 必须手动关闭Spring容器,这样Spring容器才会销毁bean
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) ac;
        context.close();
    }
}
