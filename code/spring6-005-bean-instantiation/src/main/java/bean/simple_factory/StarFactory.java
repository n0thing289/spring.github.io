package bean.simple_factory;

import bean.simple_factory.Star;

/**
 * 具体工厂角色
 */
public class StarFactory {
    /**
     * 生产星星
     * @return
     */
    public static Star get(){//简单工厂的get是需要接收产品名字的
        return new Star();
    }
}
