import bean.*;
import jbdc.MyDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.CustomerService;
import service.OrderService;
import service.UserService;

import java.lang.Math;
import java.util.Date;

public class TestSpringDI {
    /**
     * 测试C命名空间
     *      底层调用构造器->简化构造器注入
     */
    @Test
    public void testCNameSpace(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-c.xml");
        People p = ac.getBean("peopleBean", People.class);
        System.out.println(p);
    }

    /**
     * 测试p命名空间
     *      底层还是用set方法->简化set注入
     */
    @Test
    public void testPNameSpace(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-p.xml");
        Dog dog = ac.getBean("dogBean", Dog.class);
        System.out.println(dog);

    }

    /**
     * 测试特殊字符
     */
    @Test
    public void testSpecialChar(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("set-di.xml");
        MyMath math = ac.getBean("myMathBean", MyMath.class);
        System.out.println(math);
    }

    /**
     * 测试空和空字符串
     */
    @Test
    public void testNull(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("set-di.xml");
        Cat cat = ac.getBean("catBean", Cat.class);
        System.out.println(cat.getName().toUpperCase());
    }

    /**
     * 测试注入map或者Properties类
     */
    @Test
    public void testMapOrProperties(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-collection.xml");
        Person person = ac.getBean("person", Person.class);
        System.out.println(person);
    }

    /**
     * 测试注入list或者set
     */
    @Test
    public void testInjectListOrSet(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-collection.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }

    /**
     * 测试注入数组
     */
    @Test
    public void testInjectArray(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-array.xml");
        QianDaYe qdy = ac.getBean("yuQian", QianDaYe.class);
        System.out.println(qdy);
    }

    /**
     * 测试级联属性赋值
     */
    @Test
    public void testCascade(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("cascade.xml");

        Student student = ac.getBean("studentBean", Student.class);
        Clazz clazz = ac.getBean("clazzBean", Clazz.class);

        System.out.println(student);
        System.out.println(clazz);
    }

    /**
     * 测试简单类型注入的经典应用-管理数据源
     */
    @Test
    public void testMyDataSource(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");

        MyDataSource myDataSource = applicationContext.getBean("myDataSourceBean", MyDataSource.class);
        System.out.println(myDataSource);
    }

    /**
     * 测试简单数据类型有哪些
     */
    @Test
    public void testSimpleValueType(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
//        SimpleValueType svt = applicationContext.getBean("svtBean", SimpleValueType.class);
        System.out.println(new Date());
    }

    /**
     * 测试注入简单类型
     */
    @Test
    public void testSetSimpleType(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        User user = applicationContext.getBean("userBean", User.class);
        System.out.println(user);
    }

    /**
     * 测试set注入之内部bean和外部bean
     */
    @Test
    public void testSetDI2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        //
        OrderService orderService = applicationContext.getBean("orderServiceBean", OrderService.class);
        orderService.generate();
        //
        OrderService orderService2 = applicationContext.getBean("orderServiceBean2", OrderService.class);
        orderService2.generate();
    }


    /**
     * 测试构造方法注入
     */
    @Test
    public void testConstructorDI(){
        //获取spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        //获取对象
        CustomerService cs1 = applicationContext.getBean("csBean", CustomerService.class);
        cs1.save();

        //获取对象
        CustomerService cs2 = applicationContext.getBean("csBean2", CustomerService.class);
        cs2.save();

        //获取对象
        CustomerService cs3 = applicationContext.getBean("csBean3", CustomerService.class);
        cs3.save();
    }

    /**
     * 测试set注入
     */
    @Test
    public void testSetDI(){
        //获取spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        //获取对象
        UserService userService = applicationContext.getBean("userServiceBean", UserService.class);
        userService.saveUser();
    }
}
