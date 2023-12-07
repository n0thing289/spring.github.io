import org.junit.Test;

public class TestWeaponFactory {
    @Test
    public void test(){

        Weapon gun = new GunFactory().get();
        System.out.println(gun);
        gun.attack();

        Weapon dagger = new DaggerFactory().get();
        System.out.println(dagger);
        dagger.attack();
    }
}
