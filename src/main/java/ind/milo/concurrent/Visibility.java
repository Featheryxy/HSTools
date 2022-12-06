package ind.milo.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Date 2022/12/6 9:44
 * @Created by Milo
 */
@Slf4j
public class Visibility {
    private static boolean flag = true;
    public static void main(String[] args) throws InterruptedException {

        new Thread(
                () -> {
                    log.debug("Thread 1 is running");
                    while (flag) {
                        // 不能有IO, 因为IO有同步代码块
                    }
                    log.debug("Thread 1 was stoped");
                }
        ).start();

        Thread.sleep(10);

        new Thread(
                () -> {
                    flag = !flag;
                    log.debug("Thread 2 modified the flag");
                }).start();
    }
}
