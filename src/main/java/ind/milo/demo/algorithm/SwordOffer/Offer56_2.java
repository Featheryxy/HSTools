package ind.milo.demo.algorithm.SwordOffer;

import java.util.HashMap;
import java.util.Map;

/**
 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。


 示例 1：

 输入：nums = [3,4,3,3]
 输出：4
 示例 2：

 输入：nums = [9,1,7,9,7,9,7]
 输出：1

 限制：

 1 <= nums.length <= 10000
 1 <= nums[i] < 2^31

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer56_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{9, 1, 7, 9, 7, 9, 7};
        System.out.println(singleNumber(nums));

    }

    // 遍历数组，维护一个map用以记录当前数字出现的次数。
    // 遍历map，返回value = 1的key
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == 3) {
                map.remove(nums[i]);
            }
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        return -1;
    }
}
