package ind.milo.demo.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ALC0015_3Sum {


    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0, 0, 0, 0};
        int[] nums = {-2,0,0,2,2};
        System.out.println(threeSum(nums));

    }

    // 1. 排序
    // 2. 固定一个数，二分查找
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            int fixedNum = nums[i];
            // 数组单调递增，如果第一个数大于0，则nums[i] + nums[l] + nums[r] 必定大于0；
            if (fixedNum > 0) {
                return ans; // 提早返回
                //break;
            }
            // 答案中不可以包含重复的三元组。
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            // l不能等于r，因为不能有相同的数
            while (l < r) {
                int tmpSum = nums[l] + fixedNum + nums[r];
                if (tmpSum == 0) {
//                    List<Integer> tmpAns = new ArrayList<>();
//                    tmpAns.add(fixedNum);
//                    tmpAns.add(nums[l]);
//                    tmpAns.add(nums[r]);
//                    ans.add(tmpAns);
                    ans.add(Arrays.asList(fixedNum, nums[l], nums[r]));
                    // *** 这里一定要有，否则会有重复答案，指向下一个与当前答案不同的值
                    while (l<r && nums[l] == nums[l+1]) l++;
                    while (l<r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                    continue;
                }

                if (tmpSum  > 0 ) {
                    r--;
                    continue;
                }

                if (tmpSum < 0 ) {
                    l++;
                    continue;
                }
            }

        }

        return ans;
    }
}
