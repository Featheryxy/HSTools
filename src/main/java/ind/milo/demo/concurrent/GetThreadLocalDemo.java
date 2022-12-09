package ind.milo.demo.concurrent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2022/12/8 18:24
 * @Created by Milo
 */
public class GetThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Thread> list = new ArrayList<>();
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set(Thread.currentThread().getName()+"'s threadLocal");

        Runnable run = () -> {
            Thread thread = Thread.currentThread();
//            System.out.println("内部:" + thread);
            threadLocal.set(thread+"'s threadLocal");
            System.out.println(threadLocal.get()); // sub-thread : World
            list.add(thread);

            Class clzz = threadLocal.getClass();
            Method method = null;
            try {
                method = clzz.getDeclaredMethod("getMap", Thread.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            method.setAccessible(true);
            Object o = null;
            try {
                o = method.invoke(threadLocal, thread);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println("asdasdasdas" + o);
        };
        Thread thread = new Thread(run, "子线程");



        // Thread.sleep(1000);
        // 启动子线程
        thread.start();
        // // 让子线程先执行完成，再继续执行主线
//        thread.join();
        System.out.println(threadLocal.get());

//        System.out.println("list中：" + list.get(0));

        System.out.println("_______________________");

        Class clzz = threadLocal.getClass();
        Method method = clzz.getDeclaredMethod("getMap", Thread.class);
        method.setAccessible(true);
        Object o = method.invoke(threadLocal, thread);
        System.out.println(o);

//        Object invoke = getMap.invoke(thread);
//        System.out.println("反射获取结果：" + invoke);
    }
}
