package service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 专门负责计时的一个调用处理器对象
 * 在这个调用处理器当中编写计时相关的增强代码
 * 这个调用处理器只需要写一个就行了。
 */
public class TimerInvocationHandler implements InvocationHandler {
    private Object target;

    public TimerInvocationHandler() {
    }

    public TimerInvocationHandler(Object target) {
        this.target = target;
    }

    /*
        1.为什么强行要求你必须实现InvocationHandler接口?
            因为为一个类实现接口就必须实现接口中的方法。
            以下这个方法必须是invoke()，因为JDK在底层调用invoke()方法的程序已经提前写好了
            注意: invoke方法不是我们程序员负责调用的，是JDK负责调用的。
        2. invoke 方法什么时候被调用呢?
            当代理对象调用代理方法的时候，注册在InvocationHandler调用处理器当中的invoke()方法被调用
        3. invoke方法的三个参数:
                invoke 方法是JDK负责调用的，所以JDK 调用这个方法的时候会自动给我们传过来这三个参数
                我们可以在invoke方法的大括号中直接使用。
                第一个季数: 0bject proxy 代理对象的引用。这个参数使用较少。
                第二个参数:Method method 目标对象上的目标方法。 (要执行的目标方法就是它。)
                第三个参数: 0bject[] args 月标方法上的实参。

                invoke方法执行过程中，使用method来调用目标对象的目标方法
         */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start");
        long start = System.currentTimeMillis();

        Object result = method.invoke(target, args);

        long end = System.currentTimeMillis();
        System.out.println("end耗时: " + (end - start) + "\n");
        //注意这个invoke 方法的返回值，如界代理对象调用代理方法之后，需要返回结果的话，inyoke 方法必须将日标对象的目标方法执行结果继结饭回
        return result;
    }
}
