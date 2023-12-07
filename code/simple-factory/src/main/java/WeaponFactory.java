/**
 * 具体工厂类角色
 */
public class WeaponFactory {
    /**
     * 根据不同武器类型生产武器
     * @param name
     * @return
     */
    public static Weapon get(String name){
        if("DAGGER".equals(name.toUpperCase())){
            return new Dagger();
        }else if("GUN".equals(name.toUpperCase())){
            return new Gun();
        }
        return null;
    }
}
