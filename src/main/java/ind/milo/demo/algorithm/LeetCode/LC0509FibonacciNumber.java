package ind.milo.demo.algorithm.LeetCode;

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0509FibonacciNumber {
    static int count = 0;
    public static void main(String[] args) {
        int ans = fib(3);
//        ans = sum(3);
        System.out.println();
        System.out.println(ans);
        System.out.println(count);
    }

    public static int fib(int n) {
        count++;
        System.out.print(n+ " ");
        if (n==1 || n==0) {
            return n;
        }

        return fib(n-1) + fib(n-2);
    }


    public static int sum(int n){
        System.out.print(n);
        if (n == 1) {
            return n;
        }

        return n+sum(n-1);
    }
}
