package bean;

/**
 * bean的生命周期按照粗略的五步的话：
 * 第一步：实例化bean（调用无参数构造方法）
 * 第二步：给bean属性赋值（调用set方法）
 * 第三步：初始化bean（会调用init方法，注意这个init方法需要自己写，自己配置）
 * 第四步：使用bean
 * 第五步：销毁bean（会调用bean的destroy方法，注意这个destroy方法需要自己写，自己配置）
 */
public class User {
    private String name;

    public User() {
        System.out.println("第一步：实例化bean,无参构造器执行");
    }

    public void setName(String name) {
        System.out.println("第二步：给bean属性赋值,set方法执行");
        this.name = name;
    }

    //方法名随意
    public void init() {
        System.out.println("第三步：初始化bean, init方法执行");
    }

    //方法名随意
    public void destroy() {
        System.out.println("第五步：销毁bean, destroy方法执行");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
