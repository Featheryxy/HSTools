package ind.milo.demo.algorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0003LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s =
                "abba";
        lengthOfLongestSubstring(s);
    }

    public static int lengthOfLongestSubstring(String s) {
        // 维护一个动态的滑动窗口，用以记录无重复字符的最长子串
        int len = s.length();
        if (len <= 1) {
            return len;
        }

        int l = 0, r = 1;
        // substring方法左闭右开 s 等于 s.substring(0, 1)+s.substring(1);
        String longestSubstr = s.substring(0, 1);
        for (; r < len; r++) {
            char currChr = s.charAt(r);
            String currStr = s.substring(l, r);
            // 如果当前窗口内含有新增的值，需要将左指针移动到重复字符的下一个位置
            if (currStr.contains(currChr + "")) {
                l = s.substring(0, r).lastIndexOf(currChr)+1;
            }

            // 如果滑动窗口的长度大于最大长度，记录当前最大字符串
            String append = s.substring(l, r+1);
            if (append.length() > longestSubstr.length()) {
                longestSubstr = append;
            }
        }
        System.out.println(longestSubstr);
        return longestSubstr.length();
    }

    public static int lengthOfLongestSubstringOffice(String s) {
        int left = 0, n = s.length(), max_len = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char tem = s.charAt(i);
            if (map.containsKey(tem)) {
                int lastIndexOfChr = map.get(tem) + 1;
                if (lastIndexOfChr > left) {
                    left = lastIndexOfChr;
                }
            }
            map.put(tem, i);
            max_len = Math.max(max_len, i - left + 1);
        }

        return max_len;
    }
}
