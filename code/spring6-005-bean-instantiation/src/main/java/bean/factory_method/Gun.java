package bean.factory_method;

/**
 * 具体产品角色
 */
public class Gun extends Weapon{
    @Override
    public void attack() {
        System.out.println("ak47开火~");
    }
}
