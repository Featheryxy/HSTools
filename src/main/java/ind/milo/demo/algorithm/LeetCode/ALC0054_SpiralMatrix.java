package ind.milo.demo.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 输出：[1,2,3,6,9,8,7,4,5]
 */
public class ALC0054_SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));

        System.out.println(3 & 1);
        System.out.println(2 & 1);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int rowLen = matrix.length;
        int colLen = matrix.length;
        for (int row = 0; row < rowLen; row++) {
//            ans.add()
        }

        return ans;
    }
}
