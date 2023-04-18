package ind.milo.demo.algorithm.LeetCode;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *提示：
 *  1 <= nums.length <= 105
 *  -104 <= nums[i] <= 104
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
// todo 动态规划，待求解
public class LC0053MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    // 滑动窗口：维护一个连续子数组l， r
    //
    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        if (nums.length == 1) {
            return nums[0];
        }
        int l = 0, r = 1;
        int maxSum = nums[0];
        while (r < length) {
            int tmpNum = nums[r];
            int tmpSum = maxSum + tmpNum;
            if (tmpSum >= maxSum) {
                r++;
                maxSum = tmpSum;
            } else {
                tmpSum = tmpSum - nums[l];
                l++;
            }
        }

        return maxSum;
    }
}


