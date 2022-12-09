package ind.milo.demo.concurrent;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Date 2022/12/8 15:23
 * @Created by Milo
 */
public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        final ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set(Thread.currentThread().getName()+"'s threadlocal");

        Thread thread = new Thread(() -> {
            Thread currentThread = Thread.currentThread();
            // 获取不到主线程设置的值，所以为null
            System.out.println(threadLocal.get()); // null
            threadLocal.set(currentThread.getName()+"'s threadlocal");
            System.out.println(threadLocal.get()); // sub-thread : World
//            try {
//                Thread.sleep(10000000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }, "sub-thread ");
        // 启动子线程
        thread.start();
        // 让子线程先执行完成，再继续执行主线
        thread.join();
        // 获取到的是主线程设置的值，而不是子线程设置的
        System.out.println(threadLocal.get()); // main-thread : Hello
        threadLocal.remove(); // 防止内存泄露
        System.out.println(threadLocal.get()); // null
        Thread.sleep(1000);


        System.out.println("_______________________");
        // Reference https://zhuanlan.zhihu.com/p/192997550

//        Class clzz = Thread.class;
//        Field field2 = clzz.getDeclaredField("threadLocals");
////        Field field2 = clzz.getDeclaredField("inheritableThreadLocals");
////        System.out.println("字段：" + field1);
//        field2.setAccessible(true);
//        Object o = field2.get(thread);
//
//        System.out.println(o);

//        Object invoke = getMap.invoke(thread);
//        System.out.println("反射获取结果：" + invoke);
    }
}
