package ind.milo.demo.basic;

/**
 * @Date 2022/12/6 18:01
 * @Created by Milo
 */
public class IsIntObject {
    public static void main(String[] args) {
        int a = 1;
        label1:
        for (int i = 0; i < 100; i++) {
            if (i == 10) {

                break label1;
            }
        }

    }
}
