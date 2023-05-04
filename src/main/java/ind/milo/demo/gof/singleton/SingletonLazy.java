package ind.milo.demo.gof.singleton;

public class SingletonLazy {
    // 饱汉式（懒汉式），延迟加载, 在第一次调用getInstance()时创建对象
    private static SingletonLazy singleton = null;

    private SingletonLazy(){

    }

    public static synchronized SingletonLazy getSingleton() {
        if (singleton == null) {
            singleton = new SingletonLazy();
        }
        return singleton;
    }
    // 有时候，面试官会问这种实现方式有什么问题。他们指的就是指令重排序。
    //instance = new Singleton(); 并不是一个原子操作， 这句代码实际执行了三件事。
    //1、 给 Singleton 的实例分配内存；
    //2、调用 Singleton 的构造函数，初始化成员变量；
    //3、将 instance 的对象指向分配的内存空间。
    //因为 Java 编译器允许处理器乱序执行，2、3的顺序是无法保证的。如果是 1-3-2 执行的顺序，当执行完 3 、2未执行之前，被切换到 B 线程，此时 instance 已经非空，B 会直接取走 instance，在使用时就会出错。
    //这就是指令重排。
    //解决办法也很简单：只需要给 instance 成员变量加上 volatile 关键字，就可以禁止指令重排序。
    //其实这个问题在高版本的 java 中已经被解决了，解决方式也很简单，就是把对象 new 操作和初始化操作设计为原子操作，就自然能禁止重排序。

}
