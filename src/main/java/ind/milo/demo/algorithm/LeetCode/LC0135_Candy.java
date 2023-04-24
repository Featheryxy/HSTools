package ind.milo.demo.algorithm.LeetCode;

import java.util.Arrays;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 *
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0135_Candy {
    public static void main(String[] args) {
        int[] ratings = {1,3,2,2,1};
        System.out.println(candyOffice(ratings));
    }

    public static int candy(int[] ratings) {
        int length = ratings.length;
        int[] ans = new int[length];

        // 从左到右分发糖果，如果右边的分数高于左边的，则给右边的孩子多分一颗糖果
        for (int i = 0; i < length ; i++) {
            if (i == 0) {
                ans[i] = 1;
                continue;
            }
            ans[i] = 1;
            if ((ratings[i] > ratings[i - 1])) {
                ans[i] += 1;
            }
        }

        // 从右到左分发糖果，如果左边的分数高于右边的，则给左边的孩子多分一颗糖果
        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                ans[i]=Math.max(ans[i],ans[i]+1);
            }
        }

        int ansSum = 0;
        for (int i = 0; i < length; i++) {
            ansSum += ans[i];
        }

        return ansSum;
    }


    public  static int candyOffice(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i = 1; i < ratings.length; i++)
            if(ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
        int count = left[ratings.length - 1];
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;
            count += Math.max(left[i], right[i]);
        }
        return count;
    }

}
