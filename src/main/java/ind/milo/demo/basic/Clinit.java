package ind.milo.demo.basic;

/**
 * @Date 2022/12/8 19:51
 * @Created by Milo
 */
public class Clinit {

    private static  int a;

    private static final int b = 1;

    static {
        System.out.println(a);
        a = 1;
        System.out.println(a);
    }



    public static void main(String[] args) {
        System.out.println(b);
    }
}
