import org.junit.Test;
import reflect.SomeService;
import reflect.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflect {

    @Test
    public void test4()throws Exception{
        /*
         * 需求:
         *      假设你现在已知以下信息:
         *          1.有这样一个类，类名叫做: com.powernode.reflect.User
         *          2.这个类符合javabean规范。质性私有化，对外提供公开的setter和getter方法
         *          3. 你还知道这个类当中有一个属性，属性的名字叫做 age
         *          4.并且你还知道age 质性的类型是int美型。
         * 请使用反射机制调用相关方法，给User对象的age 属性赋值
          */
        String classPath = "reflect.User";
        String propertyName = "age";
        //获取类的字节码对象
        Class<?> clazz = Class.forName(classPath);
        //从字节码对象中拿到set方法对象
        String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
        //更具属性获取属性类型 -> 参数的类型
        Field field = clazz.getDeclaredField(propertyName);
        Method setMethod = clazz.getDeclaredMethod(setMethodName,field.getType());
        //创建对象
        Object user = clazz.getDeclaredConstructor().newInstance();
        //调用方法
        setMethod.invoke(user, 30);

        //打印以下
        System.out.println(user);
    }


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
