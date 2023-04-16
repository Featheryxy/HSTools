package ind.milo.demo.gof.singleton;

import javax.jws.Oneway;

public class SingletonHungry {
    // 饿汉式，在类加载的时候的创建实例
    private static SingletonHungry singleton = new SingletonHungry();
    private SingletonHungry(){

    }

    public static SingletonHungry getInstance(){
        return singleton;
    }

}
