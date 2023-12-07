import org.junit.Test;

public class TestWeaponFactory {
    @Test
    public void test(){
        Weapon gun = WeaponFactory.get("gun");
        System.out.println(gun);
        gun.attack();

        Weapon dagger = WeaponFactory.get("dagger");
        System.out.println(dagger);
        dagger.attack();
    }
}
