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

    // 二分法，每次将搜索范围缩减为原来的一半
    public static int search(int[] nums, int target) {
        int len = nums.length;
        int l=0, r=len-1;
        // 维护数组[l, r]，其包含了target, mid 有可能是问题的答案，所以不能排除掉
        // 等于 代表要继续搜索【l】这个区间
        while (l<=r) {
            int middle = l+(l-r)/2; // 防止l+r 溢出
            if (target < nums[middle]) {
                // 将右边界缩减为中间的左边一位，因为中间在当此循环中已经搜索过了
                // 下一轮搜索的区间是 [l, middle - 1]
                r = middle - 1;
            } else if (target > nums[middle]){
                // 下一轮搜索的区间是 [middle+1, r]
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
