package ind.milo.concurrent;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @Date 2022/12/6 14:02
 * @Created by Milo
 */
public class Atomicity {
    private static int number;
    public static void main(String[] args) throws InterruptedException {
        Runnable increment = () -> {
            for (int i = 0; i < 1000; i++) {
                number++;
            }
        };

        ArrayList<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(increment);
            t.start();
            ts.add(t);
        }

        for (Thread t : ts) {
            t.join();
        }

        System.out.println("number = " + number);
        // 结果不一定是5000，可能小于5000
    }

}
