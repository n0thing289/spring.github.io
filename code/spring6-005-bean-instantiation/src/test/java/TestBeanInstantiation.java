import bean.SpringBean;
import bean.factory_bean.Person;
import bean.factory_method.Gun;
import bean.simple_factory.Star;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanInstantiation {

    @Test
    public void testCreateBean4(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Person p = ac.getBean("personBean", Person.class);
        System.out.println(p);
    }

    @Test
    public void testCreateBean3(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Gun gun = ac.getBean("gunBean", Gun.class);
        System.out.println(gun);
        gun.attack();
    }

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
