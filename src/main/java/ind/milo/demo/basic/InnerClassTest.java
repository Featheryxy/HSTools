package ind.milo.demo.basic;

abstract class C{
    public abstract  void method1();
    public abstract  void method2();
}

//class D extends C{
//    @Override
//    public void method1() {
//        System.out.println("抽象类的子类");
//    }
//
//    @Override
//    public void method2() {
//        System.out.println("抽象类的子类");
//    }
//}

public class InnerClassTest {
    public static void main(String[] args) {
//        D d = new D();
//        d.method1();
//        d.method2();
//        System.out.println("+++++++++");
        // 匿名内部类的形式创建抽象类对象
        C c = new C() {
            @Override
            public void method1() {
                System.out.println("匿名抽象类");
            }

            @Override
            public void method2() {
                System.out.println("匿名抽象类");
            }
        };
        c.method1();
        c.method2();
       	/*
        抽象类的子类
        抽象类的子类
        +++++++++
        匿名抽象类
        匿名抽象类
        */
    }
}
