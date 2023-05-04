package ind.milo.demo.algorithm.LeetCode;

import ind.milo.demo.algorithm.Tag;

import java.util.HashSet;
import java.util.Set;

/**
 编写一个算法来判断一个数 n 是不是快乐数。

 「快乐数」 定义为：

 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 如果这个过程 结果为 1，那么这个数就是快乐数。
 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。


 示例 1：

 输入：n = 19
 输出：true
 解释：
 1^2 + 9^2 = 82
 8^2 + 2^2 = 68
 6^2 + 8^2 = 100
 1^2 + 0^2 + 02 = 1

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/happy-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0202_Happy_Number {

    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }

    // 定义一个set用来保存每次计算后的数，如果下一次计算后的值在set中，代表已经发生了循环
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNumber(n);
        }

        return n == 1;
    }


    public static int getNextNumber(int n) {
        int res = 0;
        while (n != 0) {
            // 取个位数
            int lastNum = n % 10;
            res = res + lastNum * lastNum;
            n = n / 10;
        }
        return res;
    }

    Tag[] tags = {Tag.MATH};

}
