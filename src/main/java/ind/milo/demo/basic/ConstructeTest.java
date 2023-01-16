package ind.milo.demo.basic;

public class ConstructeTest {
    static {
        System.out.println("block B");
    }

    public static ConstructeTest t1 = new ConstructeTest();

    public ConstructeTest(){
        System.out.println("构造方法");
    }

    {
        System.out.println("block A");
    }



    public static void main(String[] args) {
        ConstructeTest t2 = new ConstructeTest();
        //        block A
        //        block B
        //        block A

        //静态块：用static申明，JVM加载类时执行，仅执行一次
        //构造块：类中直接用{}定义，每一次创建对象时执行
        //执行顺序优先级：静态块>main()>构造块>构造方法  静态块按照申明顺序执行。
    }
}
