package service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 全注解开发代替spring.xml
 */
@Configuration//代替xml
@ComponentScan({"service"})//开启组件扫描
@EnableAspectJAutoProxy(proxyTargetClass = true)//启用aspectj的自动代理
public class Spring6Configuration {
}
