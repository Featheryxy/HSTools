package ind.milo.demo.basic;

import java.util.HashMap;

/**
 * @Date 2023/3/30 10:10
 * @Created by Milo
 */
public class StaticDemo {
    static int value = 33;

    public static void main(String[] args) {
        new StaticDemo().printValue();
        new HashMap<>()
    }

    private void printValue(){
        int value = 3;
        System.out.println(this.value);
        System.out.println(value);
    }
}
