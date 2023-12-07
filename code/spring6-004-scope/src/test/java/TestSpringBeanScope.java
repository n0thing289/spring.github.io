import bean.SpringBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringBeanScope {
    /**
     * 1. Spring默认情况下是如何管理这个Bean的:
     *      默认情况下Bean是单例的。(单例: singLeton)
     *      在Spring上下文初始化的时候实例化。
     *      每一次调用getBean()方法的时候，都返回那个单例的对象
     * 2.当将bean的scope质性设置为prototype:bean是多例的。
     *      spring上下文初始化的时候，并不会初始化这些prototype的bean。
     *      每一次调用getBean()方法的时候，实例化bean对家。
     *      prototype翻泽为: 原型。
     */
    @Test
    public void testBeanScope() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean sb = ac.getBean("sb", SpringBean.class);
        System.out.println(sb);
        SpringBean sb2 = ac.getBean("sb", SpringBean.class);
        System.out.println(sb2);
        SpringBean sb3 = ac.getBean("sb", SpringBean.class);
        System.out.println(sb3);
    }
}
