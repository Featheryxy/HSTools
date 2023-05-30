package ind.milo.demo.basic;

/**
 * @Date 2023/5/16 12:57
 * @Created by Milo
 */
public class Person {
    private static int age;

    // 该成员变量可以被子类继承，但是由于其访问控制符为private, 所以子类不能直接访问该成员变量。
    // 但是可以通过其他非private 方法来间接访问该成员变量
    private String personName;

    // 如果子类也声明了同名同类型的成员变量，子类也会继承，但是会被子类所隐藏，可以通过super调用父类的成员变量
    String name = "father";

    public Person(){
        System.out.println("Person Instance");
    }

    public void sayName(){
        System.out.println("Person's name: "+name);
    }
}
