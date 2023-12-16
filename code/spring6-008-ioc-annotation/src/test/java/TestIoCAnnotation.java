import bean.Student;
import dao.StudentDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoCAnnotation {

    /**
     * 测试用注解注入
     */
    @Test
    public void testInject(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Student student = ac.getBean("student", Student.class);
        System.out.println(student);
    }

    /**
     * 测试用注解声明bean
     */
    @Test
    public void testBean(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Student student = ac.getBean("student", Student.class);
        System.out.println(student);

        StudentDao studentDao = ac.getBean("studentDaoBean", StudentDao.class);
        System.out.println(studentDao);
    }
}
