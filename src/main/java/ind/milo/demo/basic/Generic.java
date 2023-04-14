package ind.milo.demo.basic;

import sun.rmi.runtime.Log;

/**
 * @Date 2023/4/13 16:25
 * @Created by Milo
 */
public class Generic<T> {
    //key这个成员变量的类型为T, T的类型由外部指定
    private T key;

    public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }

    public static void showKeyValue1(Generic<Number> obj){
        System.out.println("泛型测试: key value is " + obj.getKey());
    }

    // 范型通配符 ? Generic<?> obj
    // Generic<? extends Number> 通配符?一定是 Number自己或其子类
    // Generic<? super Integer>  通配符?一定是 Integer自己或其父类
    public static void showKeyValue(Generic<? super Integer> obj){
        System.out.println("泛型测试: key value is " + obj.getKey());
    }

    public static void main(String[] args) {
        Generic<Number> gNumber = new Generic<Number>(456);
        Generic<Integer> gInteger = new Generic<Integer>(123);

        // 编译报错
//        showKeyValue1(gInteger);

        showKeyValue(gInteger);
    }
}

interface Generator<T> {
    public T next();
}