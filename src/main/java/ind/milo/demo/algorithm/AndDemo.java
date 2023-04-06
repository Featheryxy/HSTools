package ind.milo.demo.algorithm;

/**
 * @Date 2023/4/6 15:30
 * @Created by Milo
 */
public class AndDemo {
    public static void main(String[] args) {
        System.out.println(1 & 1);
        System.out.println(0 & 1);
        System.out.println(01 & 1);
        System.out.println(10 & 1);
        System.out.println(11 & 1);
        System.out.println(6 & 7); // 6

        System.out.println(1<<2);
        System.out.println(Integer.toBinaryString(4));
    }
}
