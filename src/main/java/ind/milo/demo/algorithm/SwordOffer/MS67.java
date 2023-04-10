package ind.milo.demo.algorithm.SwordOffer;

import java.util.Arrays;

/**
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MS67 {
    public static void main(String[] args) {
//        String str = "3.14159";
//        String str = "-91283472332"; // -2147483648
        String str = "+"; // -2147483648
        System.out.println(strToInt(str));
    }

    // 0. 使用一个index, 将一个循环分成多个循环，每段循环各自处理下面几个问题
    // 1. 过滤左边所有空格
    // 2. 找到第一个字符，判端是否在（+, -）中，不是直接return 0
    // 3. 找到数字字符，将其转为数字
    // 4. 判断数字是否在int字符内
    public static int strToInt(String str) {
        // [index, len)
        int index = 0;
        int len = str.length();
        boolean isNeg = false;

//        while (index<len) {
////            if (str.charAt(index) == ' '){
////                index++;
////            } else {
////                break;
////            }
//            if (str.charAt(index) != ' '){
//                break;
//            }
//            index ++;
//        }

        while (index<len) {
            if (str.charAt(index) != ' '){
                break;
            }
            index++;
        }

        if (index<len && (str.charAt(index) == '-' || str.charAt(index) == '+')) {
            isNeg = str.charAt(index) == '-';
            index ++;
        }

        if (index<len &&(!Character.isDigit(str.charAt(index)))) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        while (index<len && Character.isDigit(str.charAt(index))) {
            sb.append(str.charAt(index));
            index++;
        }

        double ret = 0;
        int sbLen = sb.length();

        for (int i = 0; i < sbLen; i++) {
            char currChr = sb.charAt(i);
            int currNum = currChr - '0';
            double weight = Math.pow(10, sbLen - i - 1);
            ret = ret + (currNum * weight);
        }

        if ((int) ret != ret) {
            return isNeg ?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }

        return (int) (isNeg ? -ret : ret);
    }



    public static int strToIntWrong(String str) {
        char[] chars = str.toCharArray();
        boolean isNeg = false;
        StringBuilder sb = new StringBuilder();
        char firstChr = '*';
        int isfirstChr = 0;
        // 遍历字符数组
        for (char chr : chars) {
            if (Character.isWhitespace(chr)) {
                continue;
            }
            ++isfirstChr;

            if (isfirstChr==1) {
                firstChr = chr;
            }

            if (firstChr != '-' && (firstChr < '0' || firstChr > '9')) {
                return 0;
            }

            if ('-' == chr) {
                isNeg = true;
                continue;
            }

            if (chr < '0' || chr > '9') {
                continue;
            }

            sb.append(chr);
        }

        double ret = 0;
        int len = sb.length();

        for (int i = 0; i < len; i++) {
            char currChr = sb.charAt(i);
            int currNum = currChr - '0';
            double weight = Math.pow(10, len - i - 1);
            ret = ret + (currNum * weight);
        }

        if ((int) ret != ret) {
            return isNeg ?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }

        return (int) (isNeg ? -ret : ret);
    }
}
