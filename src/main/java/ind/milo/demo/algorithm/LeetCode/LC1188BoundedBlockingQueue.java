package ind.milo.demo.algorithm.LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现一个拥有如下方法的线程安全有界阻塞队列：
 * BoundedBlockingQueue(int capacity) 构造方法初始化队列，其中 capacity 代表队列长度上限。
 *  void enqueue(int element) 在队首增加一个element.如果队列满，调用线程被阻塞直到队列非满。
 *  int dequeue() 返回队尾元素并从队列中将其删除. 如果队列为空，调用线程被阻塞直到队列非空。
 * int size() 返回当前队列元素个数。
 * 你的实现将会被多线程同时访问进行测试。
 * 每一个线程要么是一个只调用enqueue方法的生产者线程，要么是一个只调用dequeue方法的消费者线程。
 * 请不要使用内置的阻塞队列实现
 */
public class LC1188BoundedBlockingQueue {
    private int capacity;
    private LinkedList<Integer> list;
    private ReentrantLock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    public LC1188BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
    }

    // 在队首增加一个element.如果队列满，调用线程被阻塞直到队列非满。
    public void enqueue(int element) {
        try {
            lock.lock();
            while (list.size() == capacity) {
                full.await();
            }
            list.addFirst(element);
            empty.signal();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 返回队尾元素并从队列中将其删除. 如果队列为空，调用线程被阻塞直到队列非空。
    int dequeue() {
        Integer integer = null;
        try {
            lock.lock();
            while (list.size() == 0) {
                empty.await();
            }
            integer = list.removeLast();
            full.signal();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return integer;

    }
    /**
     * 在Java中，通过ReentrantLock来实现条件变量Condition。条件变量通常与锁一起使用
     * Condition 条件变量由两部分组成：等待队列和条件谓词
     * 等待队列是一组线程，这些线程等待特定的条件谓词成立。
     * 条件谓词是一个布尔表达式，用于描述线程所等待的条件。
     * Condition对象的await()方法来等待条件谓词成立，阻塞
     * 通过调用 signal()或 signalAll()方法来通知等待的线程条件谓词已经成立，可以重新检查条件。
     * 当线程被通知条件谓词成立时，它将从等待队列中移除，并尝试重新获取锁。如果获取到了锁，则线程可以继续执行；否则，线程将继续等待。
     */
}
