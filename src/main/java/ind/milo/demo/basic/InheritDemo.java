package ind.milo.demo.basic;

/**
 * @Date 2022/12/7 14:13
 * @Created by Milo
 */
public class InheritDemo {
    public static void main(String[] args) {
        B b = new B();
//        b.say();
    }

}

class  A{
    private void say() {
        System.out.println("hello, I'm A");
    }
}

class B extends A{

}