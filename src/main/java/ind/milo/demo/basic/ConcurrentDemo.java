package ind.milo.demo.basic;

/**
 * @Date 2023/4/15 17:53
 * @Created by Milo
 */
public class ConcurrentDemo {
    public static void main(String[] args) throws InterruptedException {
        final Thread t1 = new Thread(() -> System.out.println("t1"));
        final Thread t2 = new Thread(() -> {
            try {
                // 引用t1线程，等待t1线程执行完
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2");
        });
        Thread t3 = new Thread(() -> {
            try {
                // 引用t2线程，等待t2线程执行完
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3");
        });
//        t3.start();//这里三个线程的启动顺序可以任意，大家可以试下！
//        Thread.sleep(1000);
        t1.start();
        Thread.sleep(1000);
        t2.start();

    }
}
