package bean;

/**
 * 具体工厂角色
 */
public class StarFactory {
    /**
     * 生产星星
     * @return
     */
    public static Star get(){
        return new Star();
    }
}
