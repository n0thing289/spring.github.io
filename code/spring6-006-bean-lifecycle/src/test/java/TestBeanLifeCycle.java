import bean.Student;
import bean.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanLifeCycle {
    /**
     * 将自己new出来后的对象纳入Spring容器管理
     */
    @Test
    public void testRegisterBean(){
        //自己new对象
        Student stu = new Student();
        System.out.println(stu);

        //将以上自己new的这个对象纳入Spring答器来管理。半路上交给Spring来管理
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("studentBean", stu);
        //从spring容器种获取
        Object obj = factory.getBean("studentBean");
        System.out.println(obj);

    }

    /**
     * 小细节: spring容器值只对singleton的bean,进行完整的生命周期的管理
     *       如果是prototype作用域的bean,Spring容器只负责将该bean初始化完毕.
     *          等客户端程序一旦获取到Bean之后(使用bean),spring就不再管理该对象的生命周期了
     */
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
