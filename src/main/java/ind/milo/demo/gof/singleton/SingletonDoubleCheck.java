package ind.milo.demo.gof.singleton;

import javax.jws.Oneway;
import java.util.HashMap;

public class SingletonDoubleCheck {
    // https://zhuanlan.zhihu.com/p/160835278
    // 饿汉式不能延时加载，懒汉式有性能问题，而双重检测方式既支持延迟加载、又支持高并发的单例实现方式。
    private static SingletonDoubleCheck instance;
    public static SingletonDoubleCheck getInstance(){
        // 后续的线程进来后，并不会直接调用synchronized方法，提高了性能
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) { //如果没有这个判断，会创建多个实例
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }

    private SingletonDoubleCheck(){}

}
