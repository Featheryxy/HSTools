package ind.milo.demo.algorithm.LeetCode;

import java.util.Arrays;

/**
 977. 有序数组的平方
 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。



 示例 1：

 输入：nums = [-4,-1,0,3,10]
 输出：[0,1,9,16,100]
 解释：平方后，数组变为 [16,1,0,9,100]
 排序后，数组变为 [0,1,9,16,100]
 */
public class LC0977SquaresofaSortedArray {
    public static void main(String[] args) {
        int [] nums = new int[]{-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(nums)));

    }

    // 维护一个数组ret[index], 其大于index的元素都是递增的
    // 由于原数组nums是单调递增的，所以我们可以使用使用头尾指针l,r，来遍历nums数组
    // ret[index] = max(f(l), f(r))
    public static int[] sortedSquares(int[] nums) {
        int l=0, r=nums.length-1;
        int ret[] = new int[nums.length];
        int index = r;
        while (l <= r) {
            int powerOfLeft = nums[l] * nums[l];
            int powerOfRight = nums[r] * nums[r];
            if (powerOfRight > powerOfLeft) {
                ret[index] = powerOfRight;
                index--;
                r --;
            } else {
                ret[index] = powerOfLeft;
                l++;
                index--;
            }
        }
        return ret;
    }
}
