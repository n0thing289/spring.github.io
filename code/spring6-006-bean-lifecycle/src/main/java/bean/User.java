package bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * bean的生命周期按照粗略的五步的话：
 * 第一步：实例化bean（调用无参数构造方法）
 * 第二步：给bean属性赋值（调用set方法）
 * 第三步：初始化bean（会调用init方法，注意这个init方法需要自己写，自己配置）
 * 第四步：使用bean
 * 第五步：销毁bean（会调用bean的destroy方法，注意这个destroy方法需要自己写，自己配置）
 */
public class User implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean {
    private String name;

    public User() {
        System.out.println("第一步：实例化bean,无参构造器执行");
    }

    public void setName(String name) {
        System.out.println("第二步：给bean属性赋值,set方法执行");
        this.name = name;
    }

    //方法名随意
    public void initBean() {
        System.out.println("第三步：初始化bean, initBean方法执行");
    }

    //方法名随意
    public void destroyBean() {
        System.out.println("第五步：销毁bean, destroyBean方法执行");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("点位1: setBeanName()执行, 这个Bean的名字是:" + name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("点位1: setBeanClassLoader()执行, Bean这个类的加载器:" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("点位1: setBeanFactory()执行, 生产这个Bean的工厂对象是:" + beanFactory);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("点位2: afterPropertiesSet()执行");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("点位3: destroy()执行");
    }
}
