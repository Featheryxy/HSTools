package ind.milo.demo.algorithm.LeetCode;

import java.util.PriorityQueue;

/**
 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。

 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。


 示例 1:

 输入: [3,2,1,5,6,4], k = 2
 输出: 5

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/kth-largest-element-in-an-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0215_Kth_Largest_Element_in_an_Array {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

    // 第 k 个最大的元素，维护一个长度为k的小项堆，堆的顶点就是这k个元素中的最小值
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            // 不能有等于
            if (queue.size() < k) {
                queue.add(nums[i]);
                continue;
            }

            if ((queue.size() == k) && queue.peek() < nums[i]) {
                queue.poll();
                queue.add(nums[i]);
            }
        }

        return queue.peek();

    }
}
