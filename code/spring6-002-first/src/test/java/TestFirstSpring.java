import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFirstSpring {
    /**
     * 测试第一个细节:怎么实例化对象的?
     *      通过反射机制,调用类的无参构造器来实例化对象
     */
    @Test
    public void testNewInstance(){
        // 获取spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        // 获取对象, 获取配置文件中配置bean
        Object obj = applicationContext.getBean("userBean");
        System.out.println(obj);

        Logger logger = LoggerFactory.getLogger(TestFirstSpring.class);
        logger.info("我是一条日志消息");
        logger.debug("我是一条调试信息");
        logger.error("我是一条错误信息");
    }

    /**
     * 测试第一个入门程序
     */
    @Test
    public void testFirstSpringCode(){
        // 第一步:获取Spring容器对象。
        // ApplicationContext 翻译为:应用上下文。其实就是Spring容器
        // ApplicationContext 是一个接口。
        // ApplicationContext 接口下有很多实现类。其中有一个实现类叫做: CLassPathXmlApplicationContext
        // ClassPathXmlApplicationContext 专门从类路径当中加spring配置文件的一个Spring上下文对象。
        // 这行代码只要执行:就相当于启动了Spring容器，解析spring.xml文件，并且实例化所有的bean对象，放到spring容器当中。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        // 第二步 根据bean和id从spring容器中获取这个对象
        Object obj = applicationContext.getBean("vipUserBean");
        System.out.println(obj);
    }
}
