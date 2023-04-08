package ind.milo.demo.algorithm.LeetCode_643;

/**
 * @Date 2023/4/8 17:40
 * @Created by Milo
 */
public class _Maximum_Average_Subarray_I {
    public static void main(String[] args) {
        int[] nums = new int[] {1,12,-5,-6,50,3};
        int k = 4;
        findMaxAverage(nums, k);
    }

    public static double findMaxAverage(int[] nums, int k) {
        double ret=0;
        for(int i=0; i<k; i++) {
            ret += nums[i];
        }

        double maxValue = ret;
        for(int i=k; i<nums.length; i++) {
            ret =  ret+nums[i]-nums[i-k];
            maxValue = Math.max(maxValue, ret);
        }
        return maxValue/k;
    }
}
