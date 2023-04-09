package ind.milo.demo.algorithm.LeetCode_643;

import java.util.regex.Pattern;

/**
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: s = "aba"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0459RepeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "abcdabcd";
        System.out.println(repeatedSubstringPattern(s));
    }


    public static boolean repeatedSubstringPattern(String s) {
        int lens = s.length(), i = 0;
        while (++i < lens) {
            if (lens % i != 0) continue;
            if (s.substring(lens - i, lens).equals(s.substring(0, i))) // 判断x是不是基串
                if (s.substring(i, lens).equals(s.substring(0, lens - i))) return true; // 判断拿去x后是否相等
        }
        return false;
    }



    // 暴力求解：超时
    public static boolean repeatedSubstringPatternViolence(String s) {
        int length = s.length();
        if (length == 1) {
            return false;
        }
        // 遍历每个子串，判断每个
        // 注意：因为s.substring()是左闭右开，所以j最大可以为 length
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j <= length; j++) {
                if (i==0 && j==length) {
                    continue;
                }
                String currStr = s.substring(i,j);
                if (canReplaceable(currStr, s)) {
                    return true;
                }
            }
        }


        if (canReplaceable(s.charAt(length-1)+"", s)){
            return true;
        }

        return false;
    }


    public static boolean canReplaceable(String subStr, String s) {
        return s.replace(subStr, "").length()  == 0;
    }
}
