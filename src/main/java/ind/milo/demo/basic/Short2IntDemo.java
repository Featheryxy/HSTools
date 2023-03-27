package ind.milo.demo.basic;

/**
 * @Date 2023/1/30 17:03
 * @Created by Milo
 */
public class Short2IntDemo {
    public static void main(String[] args) {
        short s = 5;
//     s = s - 2;// wrong，2 is int
        s = 5 - (short) (2);
        System.out.println(s);
        s -= 2; //Convert int to short
        System.out.println(s);

        char c = 'a'; // a = 97
        int i = 5;
        float d = .314F;
        double result = c + i + d; // 向上转型
        System.out.println(result);

    }
}
