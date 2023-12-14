package org.springframework.core;

import java.util.HashMap;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext{

    private Map<String,Object> singletonObjects = new HashMap<>();

    /**
     * 解析xml配置文件，实例化所有对象。
     * 使用ClassPathXmlApplicationContext，配置文件必须放置在类的根路径下
     */
    public ClassPathXmlApplicationContext(String configurationPath) {
        //解析xml文件，创建对象，放入集合中管理
    }

    @Override
    public Object getBean(String beanName) {
        return singletonObjects.get(beanName);
    }
}
