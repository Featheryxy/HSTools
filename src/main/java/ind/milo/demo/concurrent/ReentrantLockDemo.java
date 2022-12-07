package ind.milo.demo.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Date 2022/12/6 19:22
 * @Created by Milo
 */
public class ReentrantLockDemo {
    private static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
//        test01();
		test02();
    }

    // 演示 Lock可中断
    public static void test02() throws InterruptedException {
        Runnable run = () -> {
            String name = Thread.currentThread().getName();
            boolean b = false;
            try {
                b = lock.tryLock(3, TimeUnit.SECONDS);
                if (b) {
                    System.out.println(name + ": 获得锁,进入锁执行");
                    Thread.sleep(88888);
                } else {
                    System.out.println(name + ": 在指定时间没有得到锁做其他操作");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (b) {
                    lock.unlock();
                    System.out.println(name + "释放锁");
                }
            }
        };
        Thread t1 = new Thread(run);
        t1.start();
        Thread.sleep(1000);
        Thread t2 = new Thread(run);
        t2.start();
        // Thread-0获得锁,进入锁执行
        // Thread-1在指定时间没有得到锁做其他操作
    }

    // 演示Lock不可中断
    public static void test01() throws InterruptedException {
        Runnable run = () -> {
            String name = Thread.currentThread().getName();
            try {
                lock.lock();
                System.out.println(name + "获得锁,进入锁执行");
                Thread.sleep(88888);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(name + "释放锁");
            }
        };
        Thread t1 = new Thread(run);
        t1.start();
        Thread.sleep(1000);
        Thread t2 = new Thread(run);
        t2.start();
        Thread.sleep(1000);
        System.out.println(t1.getName()+": "+t1.getState());
        System.out.println(t2.getName()+": "+t2.getState());
        t2.interrupt();
        System.out.println("停止线程: "+t2.getName());
        Thread.sleep(1000);
        System.out.println(t1.getName()+": "+t1.getState());
        System.out.println(t2.getName()+": "+t2.getState());
		/*
            Thread-0获得锁,进入锁执行
            Thread-0: TIMED_WAITING
            Thread-1: WAITING
            停止线程: Thread-1
            Thread-0: TIMED_WAITING
            Thread-1: WAITING
		 */
    }
}
