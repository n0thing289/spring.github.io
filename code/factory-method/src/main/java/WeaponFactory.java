/**
 * 抽象工厂角色
 */
public abstract class WeaponFactory {
    /**
     * 所有工厂生产武器
     * @param name
     * @return
     */
    public abstract Weapon get();
}
