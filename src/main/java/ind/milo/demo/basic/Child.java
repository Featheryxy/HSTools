package ind.milo.demo.basic;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Date 2023/5/16 12:58
 * @Created by Milo
 */
public class Child extends Person {
    String name="child";

    public Child(){
        System.out.println("Child Instance");
    }

    public void sayFatherName(){
        System.out.println("Child: "+super.name);
    }

//    @Override
//    public void sayName() {
//        System.out.println("Child's name: "+name);
//    }

    public static void main(String[] args) {
        // 创建子类的同时也会创建父类，并且将父类
        // 但是父类创建成功后会直接销毁。
        Child child = new Child();
        child.sayFatherName();
        System.out.println(child.name);
        Method[] methods = Child.class.getMethods();
        System.out.println("methods len: "+methods.length+" methods: "+Arrays.toString(methods));
        Method[] declaredMethods = Child.class.getDeclaredMethods();
        System.out.println("declare methods len: "+declaredMethods.length+" methods: "+Arrays.toString(declaredMethods));

        System.out.println();
    }
}
