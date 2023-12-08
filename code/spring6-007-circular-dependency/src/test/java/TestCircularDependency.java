import bean.Husband;
import bean.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCircularDependency {

    @Test
    public void testCD2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring2.xml");

        Husband husband = ac.getBean("husband2", Husband.class);
        System.out.println(husband);

        Wife wife = ac.getBean("wife2", Wife.class);
        System.out.println(wife);
    }

    /**
     *
     */
    @Test
    public void testCD1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        Husband husband = ac.getBean("husband1", Husband.class);
        System.out.println(husband);

        Wife wife = ac.getBean("wife1", Wife.class);
        System.out.println(wife);
    }
}
