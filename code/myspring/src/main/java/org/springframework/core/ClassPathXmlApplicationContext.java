package org.springframework.core;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext {

    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 解析xml配置文件，实例化所有对象。
     * 使用ClassPathXmlApplicationContext，配置文件必须放置在类的根路径下
     */
    public ClassPathXmlApplicationContext(String configurationPath) {
        try {
            //解析xml文件，创建对象，放入集合中管理
            SAXReader reader = new SAXReader();
            //获取输入流,指向配置文件
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(configurationPath);
            Document document = reader.read(is);
            //获取所有的bean标签
            List<Node> nodes = document.selectNodes("//bean");
            //遍历bean标签
            nodes.forEach(node -> {
                try {
                    //                System.out.println(node);
                    //向下转型,为了使用Element更丰富的方法
                    Element beanElt = (Element) node;
                    //获取id属性的值
                    String id = beanElt.attributeValue("id");
                    //获取class属性的值
                    String classPath = beanElt.attributeValue("class");
                    System.out.println(id);
                    System.out.println(classPath);
                    //创建对象
                    Class<?> clazz = Class.forName(classPath);
                    Object obj = clazz.getDeclaredConstructor().newInstance();
                    //放入map,提前曝光
                    singletonObjects.put(id, obj);
                } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            });

            //再次重新把所有的bean标签遍历一次,这一次主要给对象的属性赋值
            nodes.forEach(node -> {
                try {
                    Element beanElt = (Element) node;
                    //获取id属性的值
                    String id = beanElt.attributeValue("id");
                    //获取class属性的值
                    String classPath = beanElt.attributeValue("class");
                    //获取类的字节码对象
                    Class<?> aClass = Class.forName(classPath);
                    //获取property
                    List<Element> propertys = beanElt.elements("property");
                    //遍历propertys
                    propertys.forEach(property -> {
                        try {
                            //获取属性名
                            String propertyName = property.attributeValue("name");
                            //获取属性类型
                            Field field = aClass.getDeclaredField(propertyName);
                            //获取set方法名
                            String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                            //获取set方法对象
                            Method setMethod = aClass.getDeclaredMethod(setMethodName, field.getType());
                            //获取value属性的值和ref属性的值
                            String propertyValue = property.attributeValue("value");
                            String propertyRef = property.attributeValue("ref");
                            //调用set方法
                            if (propertyValue != null) {
                                Object actualValue = null;
                                //说明这个值十简单类型
                                //声明一下我们的myspring支持byte short int char float double long boolean
                                String simpleName = field.getType().getSimpleName();
                                switch(simpleName){
                                    case "byte":
                                        actualValue = Byte.parseByte(propertyValue);
                                        break;
                                    case "short":
                                        actualValue = Short.parseShort(propertyValue);
                                        break;
                                    case "int":
                                        actualValue = Integer.parseInt(propertyValue);
                                        break;
                                    case "char":
                                        actualValue = propertyValue.charAt(0);
                                        break;
                                    case "float":
                                        actualValue = Float.parseFloat(propertyValue);
                                        break;
                                    case "double":
                                        actualValue = Double.parseDouble(propertyValue);
                                        break;
                                    case "long":
                                        actualValue = Long.parseLong(propertyValue);
                                        break;
                                    case "boolean":
                                        actualValue = Boolean.parseBoolean(propertyValue);
                                        break;
                                    case "Byte":
                                        actualValue = Byte.valueOf(propertyValue);
                                        break;
                                    case "Short":
                                        actualValue = Short.valueOf(propertyValue);
                                        break;
                                    case "Integer":
                                        actualValue = Integer.valueOf(propertyValue);
                                        break;
                                    case "Character":
                                        actualValue = Character.valueOf(propertyValue.charAt(0));
                                        break;
                                    case "Float":
                                        actualValue = Float.valueOf(propertyValue);
                                        break;
                                    case "Double":
                                        actualValue = Double.valueOf(propertyValue);
                                        break;
                                    case "Long":
                                        actualValue = Long.valueOf(propertyValue);
                                        break;
                                    case "Boolean":
                                        actualValue = Boolean.valueOf(propertyValue);
                                        break;
                                    case "String":
                                        actualValue = propertyValue;
                                        break;
                                }
                                setMethod.invoke(singletonObjects.get(id), actualValue);
                            }
                            if (propertyRef != null) {
                                setMethod.invoke(singletonObjects.get(id), singletonObjects.get(propertyRef));
                            }

                        } catch (NoSuchMethodException | NoSuchFieldException | InvocationTargetException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    });
                } catch (Exception e) {

                }
            });
            System.out.println(singletonObjects);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object getBean(String beanName) {
        return singletonObjects.get(beanName);
    }
}
