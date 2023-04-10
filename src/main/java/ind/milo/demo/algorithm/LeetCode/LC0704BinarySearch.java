package ind.milo.demo.algorithm.LeetCode;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0704BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int len = nums.length;
        int l=0, r=len-1;
        // 维护数组[l, r]，其包含了target
        while (l<=r) {
            int middle = (l+r)/2;
            if (target < nums[middle]) {
                r = middle - 1;
            } else if (target > nums[middle]){
                l = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    public static int search1(int[] nums, int target) {
        int len = nums.length;
        int l=0, r=len;
        // 维护数组[l, r)，其包含了target
        while (l<r) {
            int middle = (l+r)/2;
            if (target < nums[middle]) {
                r = middle ;
            } else if (target > nums[middle]){
                l = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
