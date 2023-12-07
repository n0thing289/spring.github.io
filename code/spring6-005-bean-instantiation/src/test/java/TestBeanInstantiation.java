import bean.SpringBean;
import bean.Star;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanInstantiation {
    @Test
    public void testCreateBean2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        ac.getBean("starBean", Star.class);
    }

    /**
     * 实例化bean的第一种方式,也是之前创建对象的方式
     */
    @Test
    public void testCreateBean1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        SpringBean sb = ac.getBean("sb", SpringBean.class);
        System.out.println(sb);
    }
}
