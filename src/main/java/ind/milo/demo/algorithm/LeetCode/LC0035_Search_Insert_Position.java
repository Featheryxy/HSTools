package ind.milo.demo.algorithm.LeetCode;

import ind.milo.demo.algorithm.Tag;

/**
 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

 请必须使用时间复杂度为 O(log n) 的算法。

  

 示例 1:

 输入: nums = [1,3,5,6], target = 5
 输出: 2
 示例 2:

 输入: nums = [1,3,5,6], target = 2
 输出: 1

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/search-insert-position
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0035_Search_Insert_Position {
    public static void main(String[] args) {
//        int[] nums = {1, 3, 5, 6};
//        int target = 2;
        int[] nums = {1, 3, 5};
        int target = 2;
        System.out.println(searchInsert2(nums, target));
    }

    // method3: 因为数组单调有序，给定target，
    // 遍历数组，当数组中的元素大于target时，返回前一个数
    public static int searchInsert3(int[] nums, int target) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            // 一定要小于，不等等于
            if (nums[i] < target) {
                res++;
            }
        }
        return res;

    }

    public static int office(int[] nums, int target) {
        int len = nums.length;
        // 特殊判断
        if (nums[len - 1] < target) {
            return len;
        }

        // 程序走到这里一定有 nums[len - 1] >= target，插入位置在区间 [0..len - 1]
        int left = 0;
        int right = len - 1;
        // 在区间 nums[left..right] 里查找第 1 个大于等于 target 的元素的下标
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                // 下一轮搜索的区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是 [left..mid]
                right = mid;
            }
        }
        return left;
    }

    // method2：二分法，每次将搜索范围缩减为原来的一半
    public static int searchInsert2(int[] nums, int target) {
        int l=0, r=nums.length-1;
//        while (l <= r) {
//            int mid = (l + r) / 2;
//            int midNum = nums[mid];
//            if (midNum == target) {
//                return mid;
//            } else if (midNum > target) {
//                r = mid-1;
//            } else {
//                l = mid+1;
//            }
//        }

        // 不能有等于，否则会出现死循环，
        while (l < r) {
            int mid = l + r >> 1;
            int midNum = nums[mid];
            if (midNum <  target) {
                // 下一轮搜索的区间是 [middle + 1, r]
                l = mid+1;
            } else {
                // 下一轮搜索的区间是 [l, middle]
                r = mid;
            }
        }

        return l;
    }


    // method1, 头尾指针法，时间复杂度为O(n)
    public static int searchInsert(int[] nums, int target) {
        int l=0, r=nums.length-1;
        // 这里一定要有等于，当数组长度为奇数时，{1, 3, 5}， target=2时，
        // 中间的数字3也要参与比较
        while(l<=r){
            if (nums[l] == target) {
                return l;
            } else if (nums[l] > target){
                return l;
            } else {
                l++;
            }

            if (nums[r] == target) {
                return r;
            } else if (nums[r] < target){
                return ++r;
            } else {
                r--;
            }
        }
        return l;
    }

    public Tag[] tags = {Tag.ARRAY, Tag.BINARY_SEARCH};
}
