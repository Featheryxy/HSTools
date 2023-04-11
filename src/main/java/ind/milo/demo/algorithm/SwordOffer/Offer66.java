package ind.milo.demo.algorithm.SwordOffer;

import java.util.Arrays;

/**
 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。

  

 示例:

 输入: [1,2,3,4,5]
 输出: [120,60,40,30,24]
  

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer66 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(constructArr(a)));


    }


    // B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]
    // B[i] = (A[0]×A[1]×…×A[i-1]) * (A[i+1]×…×A[n-1])
    // 定义两个数组，分别保存左乘积数组（第一个元素为1），右乘积数组（最后一个元素为1）
    // 最后的结果 = 左乘积数组 * 右乘积数组
    public static int[] constructArr(int[] a) {
        int len = a.length;
        int[] res = new int[len];
        int[] resReverse = new int[len];
        // 循环变量，每次循环时更新，用于记录数组中左边元素的乘积
        int tmp = 1;
        for (int i = 0; i < len; i++) {
            res[i] = tmp;
            tmp = tmp * a[i];
        }
        System.out.println(Arrays.toString(res));

        tmp = 1;
        for (int j = len - 1; j >= 0; j--) {
            resReverse[j] = tmp;
            tmp = tmp*a[j];
        }
        System.out.println(Arrays.toString(resReverse));

        for (int i = 0; i < len; i++) {
            res[i] = res[i] * resReverse[i];
        }

        return res;
    }

    // 暴力法：
    // 定义一个数组res用来返回，遍历这个数组,计算每一位上的数值
    // 该数值 = 另一个数组的每个元素（除了当前元素）的乘积
    public static int[] constructArrViolence(int[] a) {
        int index = 0;
        int[] res = new int[a.length];

        while (index<a.length) {
            int tmpCount = 1;
            for (int i = 0; i < a.length; i++) {
                if (i == index) {
                    continue;
                }
                tmpCount *= a[i];
            }
            res[index] = tmpCount;
            index++;
        }

        return res;
    }
}
