package ind.milo.demo.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * @Date 2022/12/6 9:44
 * @Created by Milo
 */
@Slf4j
public class Visibility {
//    private static  boolean flag = true;
    private static volatile boolean flag = true;
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
