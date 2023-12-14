package org.springframework.core;

public interface ApplicationContext {
    /**
     * 根据名字返回对象
     * @param beanName
     * @return
     */
    Object getBean(String beanName);
}
