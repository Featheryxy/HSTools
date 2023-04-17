package ind.milo.demo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 将闭区间表示为[a,b]，a<=b，a和b都为整数。输入多个闭区间，请你合并所有重叠的区间，并返回一个不重叠的区间数组，
 该数组需恰好覆盖输入中的所有区间。。例如：

 输入： [[1,3],[2,6],[8,10],[15,18]]
 输出：[[1,6],[8,10],[15,18]]
 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

 输入：[[1,4],[4,5],[3,10],[10,10],[13,21]]
 输出：[[1,10],[13,21]]
 解释：区间 [1,4],[4,5],[3,10],[10,10] 可被视为重叠区间。

 输入：[[4,4],[3,8],[9,9]]
 输出：[[3,8],[9,9]]
 解释：区间 [4,4] 和 [3,8] 可被视为重叠区间。

 输入：[[1,1],[2,2],[3,3]]
 输出：[[1,1],[2,2],[3,3]]
 */
public class ALI {
    public static void main(String[] args) {
        int[][] ints = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        //        [[1,6],[8,10],[15,18]]
        // 分成两个数组
//        int row = ints.length;
//        // 只记录第一列
//        int[] firstArr = new int[row];
//        // 只记录第二列
//        int[] secondArr = new int[row];
//        for (int i = 0; i < row; i++) {
//            if
//        }


        // 遍历，所有行，找到第2个数小于第1个数的集合，合并,这样有问题，重复区间
        int row = ints.length;
        int col = ints[0].length;
        List<int []> ret = new ArrayList<>();

        int[] flag = new int[row];
        int tmp = 0;
        for (int i = 1; i < row; i++) {
            if (ints[i - 1][1] < ints[i][0]) {
                flag[i-1] = tmp;
                flag[i] = tmp;
                tmp ++;
            }
        }
        // 根据flag数组进行合并
        System.out.println(Arrays.toString(flag));

        for (int i = 1; i < flag.length; i++) {
            if (flag[i] == flag[i - 1]) {
                ret.add(new int[]{ints[i-1][0],ints[i][1]});
            }
        }
//
//        System.out.println(ret);

    }

}
