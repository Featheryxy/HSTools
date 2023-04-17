package ind.milo.demo.algorithm;

import ind.milo.demo.concurrent.ReentrantLockDemo;

import java.util.ArrayDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 实现一个拥有如下方法的线程安全有界阻塞队列：
 BoundedBlockingQueue(int capacity) 构造方法初始化队列，其中capacity代表队列长度上限。
  void enqueue(int element) 在队首增加一个element.
 如果队列满，调用线程被阻塞直到队列非满。 int dequeue() 返回队尾元素并从队列中将其删除.
 如果队列为空，调用线程被阻塞直到队列非空。 int size() 返回当前队列元素个数。 
 你的实现将会被多线程同时访问进行测试。
 每一个线程要么是一个只调用enqueue方法的生产者线程，要么是一个只调用dequeue方法的消费者线程。
 请不要使用内置的阻塞队列实现
 */

public class BoundedBlockingQueue {
    private ArrayDeque queue;
    int size = 0;
    int capacity;

    // 消费者，生产者
    private static  Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public BoundedBlockingQueue(int capacity){
        queue = new ArrayDeque(capacity);
    }

    // 如果队列满，调用线程被阻塞直到队列非满.,void enqueue(int element) 在队首增加一个element.
    public  void enqueue(int element){
        // 队列满了，阻塞
        if (size == capacity) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            lock.lock();
            queue.addFirst(element);
            size ++;
            lock.unlock();
            condition.signal();
        }
    }

//    如果队列满，调用线程被阻塞直到队列非满。 int dequeue() 返回队尾元素并从队列中将其删除.
    public  int dequeue()  {
        Integer integer = 0;
        if (queue.isEmpty()) {
            condition.signal();
        } else{
            lock.lock();
            integer = (Integer) queue.removeLast();
            lock.unlock();
        }
        return integer;
    }

    //  如果队列为空，调用线程被阻塞直到队列非空。 int size() 返回当前队列元素个数。 
    public int size(){
        return size;
    }
}
