package ind.milo.demo.concurrent;

public class VolatileDemo {
    // 不能保证i++ 正确
    volatile static int index;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 2000; i++) {

                index++;
            }
        });

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 2000; i++) {

                index--;
            }
        });
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(index);
    }

    void test(){
        index++;
    }
}
