package ind.milo.demo.collection;

import java.util.PriorityQueue;

/**
 * @Date 2023/4/25 15:20
 * @Created by Milo
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        // 小项堆，无界。
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int[] arr = {1, 3, 8, 10, 2, 7, 6};
        for (int tmp : arr) {
            queue.add(tmp);
        }

        System.out.println("堆："+queue);

        while (!queue.isEmpty()) {
            System.out.println("peek: "+queue.peek()); // 查看堆顶元素
            System.out.println("poll: "+queue.poll()); // 弹出堆顶元素
        }

    }


    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.offer(nums[i]);
                continue;
            }
            if (queue.size() == k) {
                if (nums[i] > queue.peek()) {
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        return queue.poll();
    }


    /**
     * PriorityQueue是一个无限制的队列，并且动态增长。默认初始容量'11'可以使用相应构造函数中的initialCapacity参数覆盖。
     * 它不允许NULL对象。
     * 添加到PriorityQueue的对象必须具有可比性。
     * 默认情况下，优先级队列的对象按自然顺序排序。
     * 比较器可用于队列中对象的自定义排序。
     * 优先级队列的头部是基于自然排序或基于比较器的排序的最小元素。当我们轮询队列时，它从队列中返回头对象。
     * 如果存在多个具有相同优先级的对象，则它可以随机轮询其中任何一个。
     * PriorityQueue 不是线程安全的。PriorityBlockingQueue在并发环境中使用。
     * 它为add和poll方法提供了O（log（n））时间。
     */
}
