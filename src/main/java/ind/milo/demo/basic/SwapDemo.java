package ind.milo.demo.basic;

public class SwapDemo {
    public static void main(String[] args) {
        int a = 3, b = 4;
//        intSwap(a, b);
//        System.out.println(a+" "+b);
        integerSwap(a, b);
        System.out.println(a+" "+b);
    }


    // 不会交换两个数
    static void  intSwap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

    //
    static void  integerSwap(Integer a, Integer b) {
        Integer tmp = a;
        a = b;
        b = tmp;
    }
}
