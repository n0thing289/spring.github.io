import org.junit.Test;
import reflect.SomeService;

import java.lang.reflect.Method;

public class TestReflect {
    /**
     * 使用反射机制
     */
    @Test
    public void test2() throws Exception {
        //获取类(的结构)
        Class<?> clazz = Class.forName("reflect.SomeService");
        //获取方法(的对象)
        Method doSomeMethod = clazz.getDeclaredMethod("doSome", String.class, int.class);
        //调用方法, 需要对象和参数
        Object obj = clazz.getDeclaredConstructor().newInstance();
        Object result = doSomeMethod.invoke(obj, "张三",250);
        System.out.println(result);
    }

    /**
     * 分析: 调用一个方法，当中含有几个要素?
     *      四要素
     *      第一要素:调用哪个对象
     *      第二要素:调用哪个方法
     *      第三要素:调用方法的时候传什么参数
     *      第四要素:方法执行结束之后的返回结果
     *
 *      调用哪个对象的哪个方法，传什么参数，返回什么值
     *  即使是使用反射机制调用方法，也同样需要具备这四个要素。
     *
     */
    @Test
    public void test(){
        //不使用反射机制
        SomeService someService = new SomeService();
        someService.doSome();
        someService.doSome("李四");
        someService.doSome("张三", 250);

    }
}
