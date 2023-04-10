package ind.milo.demo.algorithm.LeetCode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0005LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
//        System.out.println(new StringBuilder("abc").reverse());
        System.out.println(longestPalindrome(s));
    }

    public static boolean isPalindromicStr1(String s) {
        final StringBuilder stringBuilder = new StringBuilder(s);
        StringBuilder reverse = stringBuilder.reverse();
        return s.equals(reverse.toString());
    }

    public static boolean isPalindromicStr(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 暴力解法，遍历所有的子串
    public static String longestPalindrome(String s) {

        int len = s.length();
        if (len == 1) {
            return s;
        }

        String ret = "";
        for (int i=0;i<len; i++){
            for(int j=i+1; j<len+1; j++) {
//                System.out.println(i+" "+j);
                String currStr = s.substring(i, j);
//                System.out.println(currStr);
                if (isPalindromicStr(currStr) && currStr.length()>=ret.length()) {
                    ret = currStr;
                }
            }
        }
        return ret;
    }
}
