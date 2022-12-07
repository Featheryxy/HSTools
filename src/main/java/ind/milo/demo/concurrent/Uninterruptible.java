package ind.milo.demo.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * @Date 2022/12/6 18:21
 * @Created by Milo
 */
@Slf4j
public class Uninterruptible {
    private static Object obj = new Object();
    public static void main(String[] args) {
        // 1.定义一个Runnable
        Runnable run = () -> {
            // 2.在Runnable定义同步代码块
            synchronized (obj) {
                String name = Thread.currentThread().getName();
                log.debug(name+"进入同步代码块");
                // 保证不退出同步代码块
                try {
                    Thread.sleep(888888);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 3.先开启一个线程来执行同步代码块
        Thread t1 = new Thread(run);
        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 4.开启一个线程来执行同步代码块(阻塞状态)
        Thread t2 = new Thread(run);
        t2.start();

        log.debug("t1: "+t1.getState()); // TIMED_WAITING
        log.debug("t2: "+t2.getState()); // BLOCKED
        
        // 5.停止第二个线程
//        t2.interrupt();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.debug("停止线程t2后");
//        log.debug("t1: "+t1.getState()); // TIMED_WAITING
//        log.debug("t2: "+t2.getState()); // BLOCKED



        t1.interrupt();
        log.debug("停止线程t1后");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.debug("t1: "+t1.getState()); // TERMINATED
        log.debug("t2: "+t2.getState()); // TIMED_WAITING
    }
}
