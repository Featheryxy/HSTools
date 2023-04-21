package ind.milo.demo.algorithm.LeetCode;

/**
 给你一个正整数 n ，返回 2 和 n 的最小公倍数（正整数）。

 示例 1：

 输入：n = 5
 输出：10
 解释：5 和 2 的最小公倍数是 10 。
 示例 2：

 输入：n = 6
 输出：6
 解释：6 和 2 的最小公倍数是 6 。注意数字会是它自身的倍数。

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/smallest-even-multiple
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC2413_SmallestEvenMultiple {
    public static void main(String[] args) {
//        int n = 10;
        System.out.println(String.format(Integer.toBinaryString(127)));
        System.out.println(Integer.toBinaryString(-1).substring(24));
        System.out.println(Integer.toBinaryString(-2).substring(24));
        System.out.println(Integer.toBinaryString(-3).substring(24));
        System.out.println(Integer.toBinaryString(-127).substring(24));
        System.out.println(Integer.toBinaryString(-128).substring(24));
//        System.out.println(n);
//        System.out.println(smallestEvenMultiple(n));
    }

    // 一个数与2的最小公倍数，如果该数是偶数，则最小公倍数是其本身，否则是其两倍
    public static int smallestEvenMultiple(int n) {
        // 偶数二进制最低位一定为0，奇数为1
        return (n & 1) == 0 ? n : n << 1;
    }
}
