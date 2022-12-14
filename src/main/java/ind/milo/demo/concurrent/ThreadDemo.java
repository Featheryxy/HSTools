package ind.milo.demo.concurrent;

public class ThreadDemo {
    static int count = 0;
    static final Object room = new Object();
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    synchronized (room) {
                        count++;
                    }
                }
            }
        };

        Thread thread1 = new Thread(runnable, "thread1");
        thread1.start();

        Thread thread2 = new Thread(runnable, "thread2");
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);
    }
}
