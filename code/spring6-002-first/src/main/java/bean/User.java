package bean;

public class User {
    // spring是怎么实例化对象的？
    //默认是会通过反射机制，调用类的无参构造器来实例化对象
    public User() {
        System.out.println("User构造器执行ing");
    }

}
