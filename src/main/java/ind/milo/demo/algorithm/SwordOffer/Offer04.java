package ind.milo.demo.algorithm.SwordOffer;

/**
 在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，每一列都按照从上到下 非递减 的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

  

 示例:

 现有矩阵 matrix 如下：

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 给定 target = 5，返回 true。

 给定 target = 20，返回 false。

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer04 {
    public static void main(String[] args) {
        // m=2, n=3
//        int [][] arr = new int[][] {
//                {1,   4,  7, 11, 15},
//                {2,   5,  8, 12, 19},
//                {3,   6,  9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        };
        int target = 5;
        int [][] arr = new int[0][0];
        System.out.println(findNumberIn2DArray(arr, target));

    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        int rowLen = matrix.length;
        if (rowLen == 0) {
            return false;
        }
        int colLen = matrix[0].length;

        // 遍历所有行，找到一行第一个元素小等于target，且target<=最后一个元素。
        // 利用二分查找查找该行中是否有target
        for (int row=0; row<rowLen; row++){
            if(matrix[row][0] <= target &&  target <= matrix[row][colLen-1]){
                // 维护【l, r】包含target
                int l = 0;
                int r = colLen-1;
                while (l <= r) {
                    int middle = (l+r)/2;
                    if (target < matrix[row][middle]) {
                        r = middle - 1;
                    } else if (matrix[row][middle] < target) {
                        l = middle + 1;
                    } else {
                        return true;
                    }

                }
            }
        }

        return false;
    }


}
