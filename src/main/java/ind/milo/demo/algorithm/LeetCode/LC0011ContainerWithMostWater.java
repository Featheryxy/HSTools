package ind.milo.demo.algorithm.LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 *输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0011ContainerWithMostWater {
    public static void main(String[] args) {
        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    // 减少搜索空间, 指针碰撞
    // 如果左边短于右边，左边向中间移动
    public static  int maxArea(int[] height) {
        int length = height.length;
        int l = 0, r = length - 1;
        int s = 0;
        // l == r 是，底为0，面积也为0，无意义
        while (l < r) {
            int d = r - l;
            int minHeight = Math.min(height[l], height[r]);
            s = Math.max(s, d * minHeight);
            //  将指向短板的指针向内移动
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return s;
    }

    // 暴力求解, 错误求解
    public static  int maxAreaWrong(int[] height) {
        int length = height.length;
        int s = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                // s = d*h
                int d = j - i;
                // 高为height数组中[i, j]中的最小值
                int minHeight = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    if (height[k] < minHeight) {
                        minHeight = height[k];
                    }
                }
                s = Math.max(d * minHeight, s) ;
            }
        }
        return s;
    }

}
