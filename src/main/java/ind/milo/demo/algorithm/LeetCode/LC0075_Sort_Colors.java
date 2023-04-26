package ind.milo.demo.algorithm.LeetCode;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0075_Sort_Colors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors2Error(nums);
        System.out.println(Arrays.toString(nums));
    }

    // method2:
    // 头尾指针，头指针排0，[0,l) 维护了元素为0的数组； 尾指针排2, (r, len-1]维护了元素为1的数组，头尾排好后中间剩下的自然就是1  遍历整个数组
    public static void sortColors2Error(int[] nums) {
        int l = 0, r = nums.length - 1;
        for (int i = 0; i < r; i++) {
            if (l > r) {
                break;
            }
            if (nums[i] == 0) {
                swap(nums, i, l);
                l++;
            } else if (nums[i] == 2) {
                swap(nums, i, r);
                r--;
            }
        }

    }

    // method1
    // 两阶段快慢指针：慢指针index维护一个有序的数组，快指针fast用来搜索0，1，2
    // 第一次先排0， 第二次先排1， 排好0，1后，2自然有序
    public static void sortColors(int[] nums) {
        int length = nums.length;
        int index = 0, fast = 0;
        // 第一阶段：先排0
        for (fast = 0; fast < length; fast++) {
            if (nums[fast] == 0) {
                swap(nums, index, fast);
                index++;
            }
        }
        // 第二阶段：在数组【index, length】中排1，
        for (fast = index; fast < length; fast++) {
            int currNum = nums[fast];
            if (currNum == 1) {
                swap(nums, index, fast);
                index++;
            }
        }
        // 0， 1拍好后，2就排号了，可以不用遍历
//        for (fast = index; fast < length; fast++) {
//            int currNum = nums[fast];
//            if (currNum == 2) {
//                extracted(nums, index, fast);
//                index++;
//            }
//        }
    }

    private static void swap(int[] nums, int index, int fast) {
        int tmp = nums[index];
        nums[index] = nums[fast];
        nums[fast] = tmp;
    }
}
