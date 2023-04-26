package ind.milo.demo.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class ALC0054_SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix.length;
        List<Integer> ans = new ArrayList<>(m * n);
        // 这四个顺序分别为:上->右->下->左->上
        int dy[] = {1, 0, -1, 0};
        int dx[] = {0, 1, 0, -1};
//        int dx[] = {0, 1, 0, -1};
//        int dy[] = {1, 0, -1, 0};
        int i = 0, j = 0, d = 0;
        for (int cnt = 0; cnt < n * m; cnt++) {
            ans.add(matrix[i][j]);
            matrix[i][j] = -100;
            int x = i + dx[d], y = j + dy[d];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] == -100) {
                d = (d + 1) % 4; // 转向
                x = i + dx[d];
                y = j + dy[d];

            }
            i = x;
            j = y;
        }
        return ans;

    }
}
