package ind.milo.demo.basic;

/**
 * @Date 2023/1/30 16:19
 * @Created by Milo
 */
public class AutoBoxing {
    public static void main(String[] args) {
        Integer a = 3;
        Integer a1 = Integer.valueOf(3);


        int b = a;
        int b1 = a.intValue();
    }
}
