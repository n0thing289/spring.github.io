package bean.factory_method;

import bean.factory_method.Weapon;

/**
 * 抽象工厂角色
 */
public abstract class WeaponFactory {
    public abstract Weapon get();
}
