package ind.milo.demo.algorithm.LeetCode;

import java.util.Arrays;

/**
 2441. 与对应负数同时存在的最大正整数
 给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。

 返回正整数 k ，如果不存在这样的整数，返回 -1 。



 示例 1：

 输入：nums = [-1,2,-3,3]
 输出：3
 解释：3 是数组中唯一一个满足题目要求的 k 。
 示例 2：

 输入：nums = [-1,10,6,7,-7,1]
 输出：7
 解释：数组中存在 1 和 7 对应的负数，7 的值更大。
 示例 3：

 输入：nums = [-10,8,6,7,-2,-3]
 输出：-1
 解释：不存在满足题目要求的 k ，返回 -1 。
 */
public class LC2441_Largest_Positive_Integer_That_Exists_With_Its_Negative_Given {
    public static void main(String[] args) {
        int[] nums = {-10, 8, 6, 7, -2, -3};
//        int[] nums = {-1, 10, 6, 7, -7, 1};
        System.out.println(findMaxK(nums));
    }

    // method1: 排序 + 头尾双指针
    public static int findMaxK(int[] nums) {
        int l=0, r=nums.length-1;
        Arrays.sort(nums);
        // -7, -1, 1,  6, 7, 10

        while (l < r) {
            int leftNum = nums[l];
            int rightNum = nums[r];
            if (leftNum > 0 || rightNum<0) {
                return -1;
            }

            if (Math.abs(leftNum) == rightNum) {
                return rightNum;
            } else if (Math.abs(leftNum) > rightNum) {
                l++;
            } else {
                r--;
            }
        }
        return -1;
    }
}
