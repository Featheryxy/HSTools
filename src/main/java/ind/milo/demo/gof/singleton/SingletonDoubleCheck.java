package ind.milo.demo.gof.singleton;

import javax.jws.Oneway;
import java.util.HashMap;

public class SingletonDoubleCheck {
    // https://zhuanlan.zhihu.com/p/160835278
    // https://blog.csdn.net/shallynever/article/details/52503139
    // 饿汉式不能延时加载，懒汉式有性能问题，而双重检测方式既支持延迟加载、又支持高并发的单例实现方式。
//    private static volatile SingletonDoubleCheck instance;
    private static  SingletonDoubleCheck instance;
    public static SingletonDoubleCheck getInstance(){
        // 后续的线程进来后，并不会直接调用synchronized方法，提高了性能
        if (instance == null) {
            // 线程A, B第一次进来时,此时instance == null，
            synchronized (Singleton.class) {
                if (instance == null) { //线程A创建了了对象， 如果没有这个判断，B线程也会创建一个对象
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }

    private SingletonDoubleCheck(){}

    public static void main(String[] args) {
        while (true) {
            new Thread(()->{
                SingletonDoubleCheck instance = SingletonDoubleCheck.getInstance();
            }).start();
        }
    }

}
