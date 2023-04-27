package ind.milo.demo.algorithm.LeetCode;

import ind.milo.demo.algorithm.Tag;

import java.util.*;

import static ind.milo.demo.algorithm.Tag.ARRAY;
import static ind.milo.demo.algorithm.Tag.HEAP;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0347_Top_K_Frequent_Elements {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
//        Output: [1,2]
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        // 建立小项堆，按照数组的第二个值比较
//        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] m, int[] n)->{
//            return m[1] - n[1];
//        });
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt((int[] m) -> m[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 维护大小为k的小项堆
            if (queue.size() < k) {
                queue.add(new int[]{entry.getKey(), entry.getValue()});
                continue;
            }

            // 如果堆顶元素 小于 当前元素，将当前元素加入到堆中
            if (queue.peek()[1] < entry.getValue()) {
                queue.poll();
                queue.add(new int[]{entry.getKey(), entry.getValue()});
            }
        }

        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.poll()[0];
        }
        return res;
    }

    Tag[] tags = {ARRAY, HEAP};
}
